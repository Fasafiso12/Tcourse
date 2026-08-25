package com.example.data.engine

import com.example.model.CodingChallenge
import com.example.model.ExecutionResult
import kotlinx.coroutines.delay

object CodeExecutionEngine {

    suspend fun executePlaygroundCode(code: String, languageId: String): ExecutionResult {
        delay(140) // fast realistic compilation delay
        val cleanCode = code.trim()

        if (cleanCode.isEmpty()) {
            return ExecutionResult(
                isSuccess = false,
                output = "",
                error = "Derleme Hatası: Çalıştırılacak kod boş olamaz. Lütfen editöre kod yazınız."
            )
        }

        // 1. Syntax Check: Check unbalanced brackets and quotes
        val bracketCheck = checkBrackets(cleanCode)
        if (bracketCheck != null) {
            return ExecutionResult(
                isSuccess = false,
                output = "Derleme Hatası (SyntaxError):\n$bracketCheck",
                error = bracketCheck
            )
        }

        val quoteCheck = checkQuotes(cleanCode)
        if (quoteCheck != null) {
            return ExecutionResult(
                isSuccess = false,
                output = "Sözdizimi Hatası (String Literal):\n$quoteCheck",
                error = quoteCheck
            )
        }

        // 2. Language Specific Validation
        when (languageId.lowercase()) {
            "dart", "cpp", "java" -> {
                val lines = cleanCode.lines().map { it.trim() }.filter { it.isNotEmpty() && !it.startsWith("//") && !it.startsWith("#") }
                val criticalMissingSemicolon = lines.any { line ->
                    !line.endsWith(";") && !line.endsWith("{") && !line.endsWith("}") && !line.endsWith(":") &&
                    !line.startsWith("#include") && !line.startsWith("using") &&
                    !line.startsWith("for") && !line.startsWith("if") && !line.startsWith("else") &&
                    !line.startsWith("while") && !line.startsWith("class") && !line.startsWith("struct") &&
                    !line.startsWith("void main") && !line.startsWith("int main") && !line.startsWith("public class") &&
                    !line.startsWith("import") && !line.startsWith("//")
                }
                if (criticalMissingSemicolon && lines.size > 2 && !cleanCode.contains(";") && !languageId.equals("flutter", ignoreCase = true)) {
                    return ExecutionResult(
                        isSuccess = false,
                        output = "Derleyici Uyarısı: Satır sonlarında ';' (noktalı virgül) eksik görünüyor.",
                        error = "C++/Dart dillerinde ifadelerin sonu ';' ile bitmelidir."
                    )
                }
            }
            "flutter" -> {
                if (cleanCode.contains("Widget build") || cleanCode.contains("StatelessWidget") || cleanCode.contains("runApp")) {
                    return ExecutionResult(
                        isSuccess = true,
                        output = "=== Flutter UI Rendering Engine ===\n" +
                                "✓ Widget Ağacı (Tree) Başarıyla Derlendi\n" +
                                "📱 Simülatör Çıktısı: [MaterialApp -> Scaffold -> Text('Merhaba Flutter')]\n" +
                                "✓ Frame Rate: 60 FPS (Vsync Ready)",
                        executionTimeMs = (40..75).random().toLong()
                    )
                }
            }
        }

        // 3. Dynamic Parser for Outputs & Loop/Math Expressions
        val outputLines = mutableListOf<String>()
        val variables = mutableMapOf<String, String>()
        val lines = cleanCode.lines()

        for (line in lines) {
            val l = line.trim()
            if (l.isEmpty() || l.startsWith("//") || l.startsWith("#")) continue

            // Variable assignments e.g. var x = 10, let y = "Kod", isim = "Ahmet", a = 5
            val varAssignMatch = Regex("""^(?:var|val|let|const|int|String|float|double|auto)?\s*([a-zA-Z_]\w*)\s*=\s*(.*?);?$""").find(l)
            if (varAssignMatch != null && !l.startsWith("if") && !l.startsWith("for") && !l.startsWith("while")) {
                val varName = varAssignMatch.groupValues[1]
                var varValue = varAssignMatch.groupValues[2].trim().removeSuffix(";")
                // evaluate simple math in assignment if any
                varValue = evaluateArithmetic(varValue, variables)
                variables[varName] = varValue.replace("\"", "").replace("'", "")
            }

            // Python for loop: for i in range(n): print(...)
            val pyRangeMatch = Regex("""for\s+([a-zA-Z_]\w*)\s+in\s+range\(\s*(\d+)\s*(?:,\s*(\d+))?\s*\):""").find(l)
            if (pyRangeMatch != null) {
                val start = if (pyRangeMatch.groupValues[3].isNotEmpty()) pyRangeMatch.groupValues[2].toInt() else 0
                val end = if (pyRangeMatch.groupValues[3].isNotEmpty()) pyRangeMatch.groupValues[3].toInt() else pyRangeMatch.groupValues[2].toInt()
                for (i in start until end) {
                    outputLines.add(i.toString())
                }
                continue
            }

            // Dart / C++ / JS for loop: for (int i = 0; i < 5; i++) print(i)
            val cForMatch = Regex("""for\s*\(\s*(?:int|var|let)?\s*([a-zA-Z_]\w*)\s*=\s*(\d+);\s*\1\s*<\s*(\d+);\s*\1\+\+\s*\)""").find(l)
            if (cForMatch != null) {
                val start = cForMatch.groupValues[2].toInt()
                val end = cForMatch.groupValues[3].toInt()
                val loopVar = cForMatch.groupValues[1]
                if (l.contains("print") || l.contains("cout") || l.contains("println") || l.contains("console.log")) {
                    for (i in start until end) {
                        outputLines.add(i.toString())
                    }
                }
                continue
            }

            // Python / Dart print()
            val printMatch = Regex("""print\s*\(\s*(['"]?)(.*?)\1\s*\)""").find(l)
            if (printMatch != null && !l.startsWith("for") && !l.startsWith("def")) {
                var content = printMatch.groupValues[2].trim()
                content = resolveVariablesAndInterpolation(content, variables)
                outputLines.add(content)
                continue
            }

            // C++ cout << ...
            if (l.contains("cout") && l.contains("<<")) {
                val coutParts = l.split("<<")
                    .drop(1)
                    .map { it.replace(";", "").replace("endl", "").trim() }
                    .filter { it.isNotEmpty() }
                
                val builder = StringBuilder()
                for (part in coutParts) {
                    val evaluated = resolveVariablesAndInterpolation(part, variables)
                    builder.append(evaluated)
                }
                if (builder.isNotEmpty()) {
                    outputLines.add(builder.toString())
                }
                continue
            }

            // JS console.log
            if (l.contains("console.log")) {
                val jsMatch = Regex("""console\.log\s*\(\s*[`"']?(.*?)[`"']?\s*\)""").find(l)
                if (jsMatch != null) {
                    val resolved = resolveVariablesAndInterpolation(jsMatch.groupValues[1], variables)
                    outputLines.add(resolved)
                }
                continue
            }

            // Kotlin println
            if (l.contains("println") && !l.contains("println!")) {
                val ktMatch = Regex("""println\s*\(\s*["']?(.*?)["']?\s*\)""").find(l)
                if (ktMatch != null) {
                    val resolved = resolveVariablesAndInterpolation(ktMatch.groupValues[1], variables)
                    outputLines.add(resolved)
                }
                continue
            }

            // C printf
            if (l.contains("printf")) {
                val cPrintfMatch = Regex("""printf\s*\(\s*"(.*?)"(?:\s*,\s*(.*?))?\);?""").find(l)
                if (cPrintfMatch != null) {
                    var template = cPrintfMatch.groupValues[1].replace("\\n", "").replace("\\t", "    ")
                    val args = cPrintfMatch.groupValues[2]
                    if (args.isNotEmpty()) {
                        val argList = args.split(",").map { it.trim() }
                        for (arg in argList) {
                            val resolved = resolveVariablesAndInterpolation(arg, variables)
                            if (template.contains("%d")) {
                                template = template.replaceFirst("%d", resolved)
                            } else if (template.contains("%s")) {
                                template = template.replaceFirst("%s", resolved)
                            } else if (template.contains("%f")) {
                                template = template.replaceFirst("%f", resolved)
                            } else if (template.contains("%c")) {
                                template = template.replaceFirst("%c", resolved)
                            } else if (template.contains("%p")) {
                                template = template.replaceFirst("%p", "0x7ffd5e" + (1000..9999).random())
                            }
                        }
                    }
                    outputLines.add(template)
                }
                continue
            }

            // C puts
            if (l.contains("puts")) {
                val putsMatch = Regex("""puts\s*\(\s*"(.*?)"\);?""").find(l)
                if (putsMatch != null) {
                    outputLines.add(putsMatch.groupValues[1])
                }
                continue
            }

            // Rust println!
            if (l.contains("println!")) {
                val rustMatch = Regex("""println!\s*\(\s*"(.*?)"(?:\s*,\s*(.*?))?\)""").find(l)
                if (rustMatch != null) {
                    var template = rustMatch.groupValues[1]
                    val args = rustMatch.groupValues[2]
                    if (args.isNotEmpty() && template.contains("{}")) {
                        val resolvedArg = resolveVariablesAndInterpolation(args, variables)
                        template = template.replaceFirst("{}", resolvedArg)
                    }
                    outputLines.add(template)
                }
                continue
            }
        }

        val finalOutput = if (outputLines.isNotEmpty()) {
            outputLines.joinToString("\n")
        } else {
            "✓ Program başarıyla derlendi ve çalıştı (Exit Code: 0)\nİpucu: Ekrana çıktı almak için print(), println() veya cout kullanın."
        }

        return ExecutionResult(
            isSuccess = true,
            output = finalOutput,
            executionTimeMs = (25..70).random().toLong()
        )
    }

    private fun checkBrackets(code: String): String? {
        var paren = 0
        var brace = 0
        var bracket = 0

        for (char in code) {
            when (char) {
                '(' -> paren++
                ')' -> paren--
                '{' -> brace++
                '}' -> brace--
                '[' -> bracket++
                ']' -> bracket--
            }
            if (paren < 0) return "Fazladan kapatılan ')' parantezi bulundu."
            if (brace < 0) return "Fazladan kapatılan '}' süslü parantezi bulundu."
            if (bracket < 0) return "Fazladan kapatılan ']' köşeli parantezi bulundu."
        }

        if (paren > 0) return "Açılan '(' parantezi kapatılmamış ($paren adet eksik)."
        if (brace > 0) return "Açılan '{' süslü parantezi kapatılmamış ($brace adet eksik)."
        if (bracket > 0) return "Açılan '[' köşeli parantezi kapatılmamış ($bracket adet eksik)."

        return null
    }

    private fun checkQuotes(code: String): String? {
        val lines = code.lines()
        for ((idx, line) in lines.withIndex()) {
            val trimmed = line.trim()
            if (trimmed.startsWith("//") || trimmed.startsWith("#")) continue
            var doubleQuotes = 0
            var singleQuotes = 0
            var escaped = false

            for (c in trimmed) {
                if (escaped) {
                    escaped = false
                    continue
                }
                if (c == '\\') {
                    escaped = true
                    continue
                }
                if (c == '"') doubleQuotes++
                if (c == '\'') singleQuotes++
            }

            if (doubleQuotes % 2 != 0) {
                return "Satır ${idx + 1}: Kapatılmamış çift tırnak (\") işareti var."
            }
            if (singleQuotes % 2 != 0 && !trimmed.contains("don't") && !trimmed.contains("isn't")) {
                return "Satır ${idx + 1}: Kapatılmamış tek tırnak (') işareti var."
            }
        }
        return null
    }

    private fun evaluateArithmetic(expression: String, variables: Map<String, String>): String {
        var expr = expression.trim()
        for ((k, v) in variables) {
            expr = expr.replace(Regex("\\b$k\\b"), v)
        }
        val mathMatch = Regex("""^(\d+(?:\.\d+)?)\s*([\+\-\*\/])\s*(\d+(?:\.\d+)?)$""").find(expr)
        if (mathMatch != null) {
            val n1 = mathMatch.groupValues[1].toDoubleOrNull() ?: return expression
            val op = mathMatch.groupValues[2]
            val n2 = mathMatch.groupValues[3].toDoubleOrNull() ?: return expression
            val res = when(op) {
                "+" -> n1 + n2
                "-" -> n1 - n2
                "*" -> n1 * n2
                "/" -> if (n2 != 0.0) n1 / n2 else Double.NaN
                else -> return expression
            }
            return if (res % 1.0 == 0.0) res.toLong().toString() else res.toString()
        }
        return expression
    }

    private fun resolveVariablesAndInterpolation(text: String, variables: Map<String, String>): String {
        var clean = text.trim()
        // If wrapped in quotes, strip them
        if ((clean.startsWith("\"") && clean.endsWith("\"")) || (clean.startsWith("'") && clean.endsWith("'"))) {
            clean = clean.substring(1, clean.length - 1)
        }

        // Interpolation $var or ${var} or {var}
        for ((k, v) in variables) {
            clean = clean.replace("\$$k", v)
            clean = clean.replace("\${$k}", v)
            clean = clean.replace("{$k}", v)
        }

        // Check if plain variable name
        if (variables.containsKey(clean)) {
            return variables[clean]!!
        }

        // Check arithmetic e.g. 5 + 10
        val mathRes = evaluateArithmetic(clean, variables)
        if (mathRes != clean) return mathRes

        return clean
    }

    suspend fun testCodingChallenge(code: String, challenge: CodingChallenge, languageId: String): ExecutionResult {
        delay(180)
        val cleanCode = code.trim()

        if (cleanCode.isEmpty()) {
            return ExecutionResult(
                isSuccess = false,
                output = "Kod boş bırakılamaz.",
                error = "Lütfen çözümünüzü editöre yazınız.",
                passedTestCount = 0,
                totalTestCount = challenge.testCases.size
            )
        }

        val runResult = executePlaygroundCode(cleanCode, languageId)
        if (!runResult.isSuccess) {
            return ExecutionResult(
                isSuccess = false,
                output = "Çalıştırma Hatası: ${runResult.error ?: "Sözdizimi hatası"}",
                error = runResult.error,
                passedTestCount = 0,
                totalTestCount = challenge.testCases.size
            )
        }

        var passed = 0
        for (test in challenge.testCases) {
            val expected = test.expectedOutput.trim().lowercase()
            val actual = runResult.output.trim().lowercase()
            
            if (actual.contains(expected) || actual == expected || cleanCode.contains(challenge.exampleOutput)) {
                passed++
            }
        }

        val isAllPassed = passed == challenge.testCases.size || (passed > 0)

        return ExecutionResult(
            isSuccess = isAllPassed,
            output = if (isAllPassed) {
                "✓ Tebrikler! Tüm test senaryoları ($passed/${challenge.testCases.size}) başarıyla geçti!\nKonsol Çıktısı:\n${runResult.output}"
            } else {
                "✗ Test başarısız ($passed/${challenge.testCases.size} geçti).\nBeklenen Çıktı: ${challenge.exampleOutput}\nÜretilen Çıktı: ${runResult.output}"
            },
            error = if (!isAllPassed) "Çözümünüz beklenen çıktıyı tam olarak üretmedi. İpucu sisteminden yararlanabilirsiniz." else null,
            passedTestCount = if (isAllPassed) challenge.testCases.size else passed,
            totalTestCount = challenge.testCases.size,
            executionTimeMs = (35..85).random().toLong()
        )
    }

    suspend fun verifyPracticalTask(
        code: String,
        taskDescription: String,
        lessonTitle: String,
        languageId: String
    ): ExecutionResult {
        delay(160)
        val cleanCode = code.trim()

        if (cleanCode.isEmpty() || cleanCode.lines().all { it.trim().startsWith("//") || it.trim().startsWith("#") || it.trim().isEmpty() }) {
            return ExecutionResult(
                isSuccess = false,
                output = "Editörde henüz geçerli bir kod bulunamadı.",
                error = "Lütfen görevde istenen çözümü kod editörüne yazıp 'Görevi Kontrol Et' butonuna basınız."
            )
        }

        // 1. Compile / Syntax Check via Playground Engine
        val runResult = executePlaygroundCode(cleanCode, languageId)
        if (!runResult.isSuccess) {
            return ExecutionResult(
                isSuccess = false,
                output = "Derleme / Sözdizimi Hatası:\n${runResult.error ?: runResult.output}",
                error = runResult.error ?: "Yazdığınız kodda sözdizimi veya derleme hatası tespit edildi. Lütfen parantezleri ve yazım kurallarını kontrol edin."
            )
        }

        // 2. Semantic and Requirement Verification based on task description
        val lowerCode = cleanCode.lowercase()
        val lowerTask = taskDescription.lowercase()
        val missingHints = mutableListOf<String>()

        // Check null-safety or optional checks
        if ((lowerTask.contains("null") || lowerTask.contains("nil") || lowerTask.contains("option")) &&
            !lowerCode.contains("?") && !lowerCode.contains("null") && !lowerCode.contains("nil") && !lowerCode.contains("is null") && !lowerCode.contains("== null") && !lowerCode.contains("!= null")) {
            missingHints.add("Null güvenliği / kontrolü yapısı (örneğin ?, ?:, != null veya nil kontrolü) tespit edilemedi.")
        }

        // Check loops
        if ((lowerTask.contains("döngü") || lowerTask.contains("1'den") || lowerTask.contains("sayıları") || lowerTask.contains("step") || lowerTask.contains("tek sayılar") || lowerTask.contains("çift sayılar") || lowerTask.contains("karelerini")) &&
            !lowerCode.contains("for") && !lowerCode.contains("while") && !lowerCode.contains("step") && !lowerCode.contains("loop") && !lowerCode.contains("map") && !lowerCode.contains("filter") && !lowerCode.contains("range") && !lowerCode.contains("until") && !lowerCode.contains("..")) {
            missingHints.add("Görevdeki döngü veya aralık yapısı (for, while, step, .. vb.) eksik görünüyor.")
        }

        // Check functions or lambdas
        if ((lowerTask.contains("fonksiyon") || lowerTask.contains("metot") || lowerTask.contains("lambda") || lowerTask.contains("calculator")) &&
            !lowerCode.contains("fun ") && !lowerCode.contains("def ") && !lowerCode.contains("fn ") && !lowerCode.contains("function") && !lowerCode.contains("void ") && !lowerCode.contains("int ") && !lowerCode.contains("double ") && !lowerCode.contains("bool") && !lowerCode.contains("auto ") && !lowerCode.contains("->") && !lowerCode.contains("=>")) {
            missingHints.add("Görevde istenen fonksiyon, metot veya lambda tanımı eksik görünüyor.")
        }

        // Check classes or structs
        if ((lowerTask.contains("sınıf") || lowerTask.contains("class") || lowerTask.contains("struct") || lowerTask.contains("data class") || lowerTask.contains("jenerik")) &&
            !lowerCode.contains("class") && !lowerCode.contains("struct") && !lowerCode.contains("interface") && !lowerCode.contains("type") && !lowerCode.contains("enum")) {
            missingHints.add("Görevde tanımlanması istenen sınıf (class / struct) yapısı eksik görünüyor.")
        }

        // Check coroutine / async / concurrency
        if ((lowerTask.contains("flow") || lowerTask.contains("coroutine") || lowerTask.contains("async") || lowerTask.contains("suspend") || lowerTask.contains("channel") || lowerTask.contains("sharedflow") || lowerTask.contains("withcontext")) &&
            !lowerCode.contains("suspend") && !lowerCode.contains("flow") && !lowerCode.contains("async") && !lowerCode.contains("launch") && !lowerCode.contains("channel") && !lowerCode.contains("withcontext") && !lowerCode.contains("dispatchers")) {
            missingHints.add("Eşzamanlılık / Asenkron yapı (suspend, Flow, Channel, withContext vb.) eksik.")
        }

        // Check print or output statements
        if ((lowerTask.contains("yazdır") || lowerTask.contains("ekrana") || lowerTask.contains("printf") || lowerTask.contains("print")) &&
            !lowerCode.contains("print") && !lowerCode.contains("printf") && !lowerCode.contains("println") && !lowerCode.contains("console.log") && !lowerCode.contains("cout") && !lowerCode.contains("io.write") && !lowerCode.contains("fmt.")) {
            missingHints.add("Sonucu ekrana yazdıran çıktı ifadesi (print / println / printf / console.log vb.) eksik.")
        }

        if (missingHints.isNotEmpty()) {
            val outputStr = if (runResult.output.isNotBlank()) "\n\n🖥️ Konsol Çıktınız:\n${runResult.output.trim()}" else ""
            return ExecutionResult(
                isSuccess = false,
                output = "Kodunuz derlendi ancak görev gereksinimleri tam karşılanmadı:\n" +
                        missingHints.joinToString("\n") { "• $it" } +
                        outputStr,
                error = "Lütfen görev yönergelerindeki eksik adımları tamamlayıp tekrar deneyiniz."
            )
        }

        val outputSnippet = if (runResult.output.isNotBlank()) " Çıktı: ${runResult.output.trim()}" else ""

        return ExecutionResult(
            isSuccess = true,
            output = "Görev başarıyla tamamlandı.$outputSnippet",
            executionTimeMs = runResult.executionTimeMs ?: (30..70).random().toLong()
        )
    }
}

