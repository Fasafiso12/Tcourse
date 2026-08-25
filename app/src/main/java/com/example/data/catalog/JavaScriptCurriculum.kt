package com.example.data.catalog

import com.example.model.*

/**
 * JavaScript Complete Official Curriculum (12 Sequential Lessons):
 * BEGINNER -> FUNDAMENTAL -> INTERMEDIATE -> ADVANCED -> EXPERT
 * Complete progression from ES6+ syntax to Async/Event Loop, Prototypes, Proxies, Web Workers & V8 Engine Internals.
 */
object JavaScriptCurriculum {

    fun getSections(): List<CourseSection> = listOf(
        CourseSection(
            id = "js_sec_1",
            courseId = "javascript",
            title = "Seviye 1 – JavaScript Temelleri, Değişkenler & Veri Tipleri",
            level = CourseLevel.BEGINNER,
            order = 1,
            description = "Modern JavaScript temelleri: let vs const vs var, Primitif Tipler, Type Coercion (Tip Zorlama), Şablon Dizgileri (Template Literals) ve Strict Mode.",
            learningObjectives = listOf("let, const ve var arasındaki kapsam (Scope) farkları", "Primitif (Number, String, Boolean, Symbol, BigInt) vs Referans tipler", "Type Coercion kuralları (== vs ===)", "Template Literals kullanımı"),
            prerequisites = listOf("Temel bilgisayar kullanım bilgisi")
        ),
        CourseSection(
            id = "js_sec_2",
            courseId = "javascript",
            title = "Seviye 2 – Kontrol Akışı, Fonksiyonlar & Arrow Functions",
            level = CourseLevel.BEGINNER,
            order = 2,
            description = "Koşullu yapılar (if/else, switch, Ternary), Döngüler (for, for...of, for...in), Fonksiyon Bildirimleri vs İfadeleri ve ES6 Arrow Functions.",
            learningObjectives = listOf("Ternary operatörü ve Short-circuiting (&&, ||, ??)", "for...of vs for...in farkı", "Arrow Functions ve lexical 'this' bağlamı", "Default parametreler ve Rest/Spread operatörü (...args)"),
            prerequisites = listOf("JavaScript Temelleri ve Değişkenler")
        ),
        CourseSection(
            id = "js_sec_3",
            courseId = "javascript",
            title = "Seviye 3 – Nesneler, Diziler & Fonksiyonel Dizi Metotları",
            level = CourseLevel.INTERMEDIATE,
            order = 3,
            description = "Object Literals, Destructuring (Dizi ve Nesne Parçalama), Spread/Rest, Yüksek Mertebeli Dizi Metotları (map, filter, reduce, some, every) ve JSON işlemleri.",
            learningObjectives = listOf("Object ve Array Destructuring desenleri", "map, filter, reduce ile saf (pure) veri dönüşümleri", "Shallow Copy (Sığ) vs Deep Copy (Derin Kopyalama: structuredClone)", "Optional Chaining (?.) ve Nullish Coalescing (??)"),
            prerequisites = listOf("Kontrol Akışı ve Fonksiyonlar")
        ),
        CourseSection(
            id = "js_sec_4",
            courseId = "javascript",
            title = "Seviye 4 – Kapsam (Scope), Closures & Nesne Yönelimli JS (Classes / Prototypes)",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            description = "Lexical Scope, Hoisting, Closures (Kapsülleme), Prototip Zinciri (__proto__, prototype) ve ES6 Class Mimarisi (extends, super, #private fields).",
            learningObjectives = listOf("Lexical Scope ve Hoisting mekanizması", "Closures ile özel veri saklama (Data Encapsulation)", "Prototype Chain ve Kalıtım mimarisi", "ES6 Sınıfları ve Özel (#) alanlar"),
            prerequisites = listOf("Nesneler ve Dizi Metotları")
        ),
        CourseSection(
            id = "js_sec_5",
            courseId = "javascript",
            title = "Seviye 5 – Asenkron JS: Promises, Async/Await & Event Loop",
            level = CourseLevel.ADVANCED,
            order = 5,
            description = "Asenkron JavaScript derinlikleri: Callback Hell çözümü, Promises (all, allSettled, race), Async/Await, Tarayıcı Event Loop, Microtasks (Promise) vs Macrotasks (setTimeout).",
            learningObjectives = listOf("Promise durumları (Pending, Fulfilled, Rejected)", "async/await ile senkron görünümlü asenkron kod", "Event Loop: Call Stack, Web APIs, Microtask vs Macrotask kuyrukları", "Fetch API ve AbortController ile istek iptali"),
            prerequisites = listOf("Scope, Closures ve Sınıflar")
        ),
        CourseSection(
            id = "js_sec_6",
            courseId = "javascript",
            title = "Seviye 6 – Uzman Seviye: Metaprogramming, Web Workers & V8 Motoru",
            level = CourseLevel.EXPERT,
            order = 6,
            description = "Proxy & Reflect ile meta-programlama ve reaktif veri bağlama, Web Workers & SharedArrayBuffer ile çoklu iş parçacığı, Bellek Yönetimi (Garbage Collection) ve V8 JIT Optimizasyonları.",
            learningObjectives = listOf("Proxy & Reflect ile reaktif durum yönetimi motoru kurma", "Web Workers ve SharedArrayBuffer ile paralel hesaplama", "V8 Engine Internals: Ignition Interpreter, TurboFan JIT Compiler ve Hidden Classes", "Memory Leaks tespiti ve WeakMap / WeakRef"),
            prerequisites = listOf("Asenkron JS ve Event Loop Mimarisi")
        )
    )

    fun getLessons(): List<Lesson> = listOf(
        // ==========================================
        // DERS 1: DEĞİŞKENLER, SCOPE & TEMPLATE LITERALS (ÜCRETSİZ)
        // ==========================================
        Lesson(
            id = "js_1",
            courseId = "javascript",
            sectionId = "js_sec_1",
            title = "V8 Motoru Mimarisi, Execution Context & Değişkenler",
            shortDesc = "V8 Ignition & TurboFan derleme hattı, Execution Context, Call Stack & Heap, Primitifler vs Referanslar, IEEE 754 ve TDZ.",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false,
            learningObjectives = listOf(
                "V8 JavaScript motorunun Ignition (Interpreter) ve TurboFan (JIT Compiler) çalışma hattını öğrenmek",
                "Execution Context, Call Stack ve Heap bellek organizasyonunu kavramak",
                "Primitif tipler (IEEE 754 Float64, String, Symbol, BigInt) ile Referans nesneleri ayırt etmek",
                "Temporal Dead Zone (TDZ) ve Strict Equality (===) mantığını derinlemesine anlamak"
            ),
            prerequisites = listOf("Ön koşul gerekmez. Sıfırdan başlar."),
            subtopics = listOf("V8 Engine: Ignition Interpreter & TurboFan JIT", "Execution Context & Call Stack", "Primitif Tipler (IEEE 754) vs Heap Referansları", "var, let, const & Temporal Dead Zone (TDZ)", "Strict Equality (===) & Type Coercion"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. V8 Yürütme Motoru ve Execution Context Mimarisi",
                    body = "JavaScript kodu doğrudan donanım tarafından değil; Google V8 gibi yüksek performanslı motorlar tarafından yürütülür. V8 şu aşamaları izler:\n1. **Parser & AST:** Kaynak kod ayrıştırılarak Soyut Sözdizimi Ağacı'na (AST) dönüştürülür.\n2. **Ignition (Bytecode Interpreter):** AST'yi optimize bayt koduna çevirir ve Call Stack üzerinde çalıştırmaya başlar.\n3. **TurboFan (JIT Compiler):** Sık çalışan ('hot') fonksiyonları profiller ve doğrudan makine koduna (Machine Code) derler.\n\nKod çalışırken her fonksiyon çağrısında bir **Execution Context** (Yürütme Bağlamı) üretilir. Bu bağlam; Variable Environment, Lexical Environment ve `this` bağlamını kapsüller.",
                    codeSnippet = "// Primitifler Stack / Registry üzerinde tutulurken nesneler Heap üzerindedir:\nlet a = 42; // IEEE 754 64-bit float (Number)\nlet b = a;  // Değer kopyalanır\nb = 100;    // a etkilenmez (42 kalır)\n\nconst obj1 = { id: 1 }; // Heap üzerinde nesne tahsisi\nconst obj2 = obj1;     // Heap bellek adresi (Pointer) kopyalanır\nobj2.id = 99;\nconsole.log(obj1.id);  // 99 (Aynı heap nesnesi güncellendi)"
                ),
                LessonContentBlock(
                    subtitle = "2. Hoisting, Temporal Dead Zone (TDZ) ve let / const",
                    body = "JavaScript'te derleme (Creation Phase) aşamasında tüm değişken bildirimleri taranır:\n• `var`: Global veya fonksiyon kapsamının en tepesine taşınır (hoist) ve derhal `undefined` değeri ile ilklendirilir.\n• `let` ve `const`: Bellekte ayrılır ancak ilklendirilmez (Uninitialized). Kapsamın başlangıcından değişkenin tanımlandığı satıra kadar olan bu bölgeye **Temporal Dead Zone (TDZ)** denir. TDZ içinde değişkene erişilmeye çalışılırsa `ReferenceError` fırlatılır.",
                    codeSnippet = "console.log(eskiVar); // undefined (Hoisting çalıştı)\nvar eskiVar = 'Eski';\n\n// console.log(yeniLet); // ReferenceError: Cannot access 'yeniLet' before initialization (TDZ)\nlet yeniLet = 'Modern';"
                ),
                LessonContentBlock(
                    subtitle = "3. Strict Equality (===) ve IEEE 754 Sayı Mimarisi",
                    body = "JavaScript'te tüm sayılar 64-bit IEEE 754 çift duyarlıklı kayan nokta formatındadır (Double Precision Float). Bu nedenle `0.1 + 0.2 === 0.3` ifadesi `false` döner (`0.30000000000000004`).\n\n`==` operatörü tipleri zorlayarak (Type Coercion) `\"0\" == false` durumunda `true` döndürürken; `===` hem tip hem değer denetimi yaparak öngörülebilir ve güvenli kodlama sağlar.",
                    tip = "Daima `const` ile başlayın; yalnızca değeri değişmek zorunda olan değişkenler için `let` kullanın. `var` modern JavaScript'te asla kullanılmamalıdır."
                )
            ),
            codeExample = "const kullanici = {\n    ad: \"Deniz\",\n    yas: 25,\n    diller: [\"JS\", \"Python\"]\n};\n\n// Template literal ile dinamik metin oluşturma:\nconst mesaj = `Kullanıcı: \${kullanici.ad}, Yaş: \${kullanici.yas}, Diller: \${kullanici.diller.join(\", \")}`;\n\nconsole.log(mesaj);\nconsole.log(typeof kullanici.yas); // 'number'",
            codeExplanation = "const ile immutable referans tanımlandı, template literal değişkenleri okudu ve typeof veri tipini doğruladı.",
            realWorldExample = "Tüm modern frontend kütüphaneleri (React, Vue, Node.js) veri tanımlamalarında %100 oranında const ve let blok kapsamını kullanır.",
            practicalTask = "Adınızı ve yaşınızı iki değişkende tutup konsola bir karşılama metni yazdırın.",
            starterPlaygroundCode = "const ad = \"Ali\";\nconst yas = 20;\nconsole.log(\"Merhaba \" + ad + \", yaşın: \" + yas);",
            miniQuestion = MiniQuestion(
                id = "js_q_1",
                question = "V8 motorunda 'let' ve 'const' değişkenlerinin tanımlandığı satıra kadar erişilmesini engelleyen ve ReferenceError fırlatan güvenlik bölgesine ne ad verilir?",
                options = listOf("Temporal Dead Zone (TDZ)", "Memory Sandbox", "Garbage Collection Zone", "Stack Frame Lock"),
                correctIndex = 0,
                explanation = "Temporal Dead Zone (TDZ), let/const değişkenlerinin bildirilmeden önce kullanılmasını engelleyerek hataları önler."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_1",
                lessonId = "js_1",
                title = "Kullanıcı Karşılama Kartı",
                instructions = "ad ve rol parametrelerini alıp 'Kullanıcı: [ad] (Rol: [rol])' formatında template literal çıktısı üreten karsila(ad, rol) fonksiyonunu yazın.",
                exampleInput = "karsila(\"Selin\", \"Admin\")",
                exampleOutput = "\"Kullanıcı: Selin (Rol: Admin)\"",
                starterCode = "function karsila(ad, rol) {\n    // Kodunu buraya yaz:\n    return \"\";\n}",
                solutionCode = "function karsila(ad, rol) {\n    return `Kullanıcı: \${ad} (Rol: \${rol})`;\n}",
                hints = listOf("Template literal `\${ad}` ve `\${rol}` kullanın."),
                testCases = listOf(
                    TestCase("karsila(\"Selin\", \"Admin\")", "Kullanıcı: Selin (Rol: Admin)", "Format testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_1_1",
                    lessonId = "js_1",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "JavaScript'te 'const' ile tanımlanmış bir nesnenin (Object) bir özelliğinin (property) değeri değiştirilebilir mi?",
                    options = listOf("Hayır, nesne tamamen kilitlenir", "Evet, const referansı korur; ancak nesnenin içindeki alanlar mutasyona uğrayabilir", "Sadece sayılar değiştirilebilir", "Derleme hatası verir"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! const referansın başka bir adrese atanmasını engeller; nesnenin içeriğini tamamen dondurmak için Object.freeze() gerekir.",
                    explanationWrong = "const referansı kilitler, iç alanlar değiştirilebilir.",
                    reviewTopic = "const & Object Mutability"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "null ile undefined arasındaki fark nedir?",
                    answer = "`undefined` bir değişkenin tanımlandığını ama henüz hiçbir değer atanmadığını belirtir (JS varsayılanı). `null` ise geliştirici tarafından bilinçli olarak 'değer yok / boş' anlamında atanan bir değerdir."
                )
            ),
            completionCriteria = listOf(
                "V8 derleme hattını ve Execution Context yapısını kavramak",
                "let, const ve TDZ mekanizmasını bilmek",
                "=== ile kesin tip ve değer eşitliğini denetlemek"
            )
        ),

        // ==========================================
        // DERS 2: KONTROL AKIŞI & ARROW FUNCTIONS (ÜCRETSİZ)
        // ==========================================
        Lesson(
            id = "js_2",
            courseId = "javascript",
            sectionId = "js_sec_1",
            title = "Kontrol Akışı, İterasyon & Arrow Functions (Lexical this)",
            shortDesc = "Kısa devre operatörleri (&&, ||, ??), Symbol.iterator protokolü, for...of vs for...in ve Arrow Function Lexical this mekanizması.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false,
            learningObjectives = listOf(
                "Nullish Coalescing (??) ile mantıksal OR (||) arasındaki Falsy farklarını kavramak",
                "JavaScript İteratör Protokolünü (Symbol.iterator, next()) ve for...of döngüsünü öğrenmek",
                "Arrow Functions sözdizimini ve 'Lexical this' miras alma mekanizmasını derinlemesine anlamak",
                "call, apply ve bind metotları ile dinamik this bağlamı arasındaki farkı bilmek"
            ),
            prerequisites = listOf("JavaScript Temelleri ve Değişkenler"),
            subtopics = listOf("Nullish Coalescing (??) vs OR (||)", "Short-Circuiting Bytecode Değerlendirmesi", "JavaScript İteratör Protokolü (Symbol.iterator)", "for...of vs for...in Döngüleri", "Arrow Functions vs Standart Fonksiyonlar & Lexical 'this'"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Nullish Coalescing (??) ve Kısa Devre Mantığı",
                    body = "`||` operatörü solundaki değer Falsy (`0`, `\"\"`, `false`, `null`, `undefined`, `NaN`) olduğunda sağdaki varsayılan değere geçer. Bu durum `0` sayısının geçerli bir değer olduğu senaryolarda (örn: limit = 0, koordinat = 0) kritik hatalara yol açar.\n\n`??` (Nullish Coalescing) operatörü ise SADECE solundaki değer `null` veya `undefined` (Nullish) olduğunda sağa geçer; `0`, `false` ve `\"\"` değerlerini korur.",
                    codeSnippet = "const limit = 0;\nconst a = limit || 100; // 100 (HATA! 0 ezildi)\nconst b = limit ?? 100; // 0 (DOĞRU! Nullish korundu)"
                ),
                LessonContentBlock(
                    subtitle = "2. İteratör Protokolü (Symbol.iterator) ve for...of",
                    body = "JavaScript'te bir nesnenin `for...of` döngüsü ile gezilebilmesi için `[Symbol.iterator]` metodunu içermesi gerekir. Bu metot her adımda `{ value: any, done: boolean }` nesnesi döndüren bir iteratör üretir.\n\n• `for...of`: Yinelenebilir nesnelerin (Array, Map, Set, String) doğrudan değerlerini (values) gezer.\n• `for...in`: Nesnelerin sayılabilir özellik anahtarlarını (keys) ve prototip zincirini gezer (Dizilerde asla kullanılmamalıdır).",
                    codeSnippet = "const dizi = ['A', 'B'];\nconst it = dizi[Symbol.iterator]();\nconsole.log(it.next()); // { value: 'A', done: false }\nconsole.log(it.next()); // { value: 'B', done: false }\nconsole.log(it.next()); // { value: undefined, done: true }"
                ),
                LessonContentBlock(
                    subtitle = "3. Arrow Functions ve 'Lexical this' Mekanizması",
                    body = "Geleneksel `function` bildirimlerinde `this` dinamiktir; fonksiyonun nerede tanımlandığına değil, NASIL çağrıldığına (Call-Site) göre belirlenir (`obj.metot()`, `call()`, `apply()`, `bind()`).\n\nArrow Functions (`() => {}`) kendi `this`, `arguments`, `super` veya `new.target` bağlamlarına sahip değildir. Tanımlandıkları çevreleyen kapsamın (Lexical Scope) `this` değerini doğrudan miras alırlar.",
                    codeSnippet = "const sayac = {\n    deger: 0,\n    baslat() {\n        // Arrow function lexical this miras alır, sayac nesnesini gösterir:\n        setTimeout(() => {\n            this.deger++;\n            console.log('Sayaç:', this.deger);\n        }, 100);\n    }\n};\nsayac.baslat();"
                )
            ),
            codeExample = "const sayilar = [10, 20, 30];\n\n// for...of ile elemanları gezme:\nfor (const sayi of sayilar) {\n    console.log(\"Eleman: \" + sayi);\n}\n\n// Arrow function ile tek satırlık çarpım:\nconst kareAl = x => x * x;\nconsole.log(\"Kare: \" + kareAl(5)); // 25",
            codeExplanation = "for...of elemanları doğrudan okudu; arrow function tek parametreli ve örtük dönüşlü (implicit return) olarak çalıştı.",
            realWorldExample = "React bileşenlerinde click handler veya callback tanımlarken 'this' bağlama hatalarını önlemek için arrow fonksiyonlar standarttır.",
            practicalTask = "Verilen bir dizi içindeki sayıların ortalamasını for...of döngüsü kullanarak hesaplayan bir kod yazın.",
            starterPlaygroundCode = "const topla = (a, b = 0) => a + b;\nconsole.log(topla(5, 7));",
            miniQuestion = MiniQuestion(
                id = "js_q_2",
                question = "Aşağıdaki operatörlerden hangisi solundaki değer SADECE 'null' veya 'undefined' olduğunda sağdaki varsayılan değeri döndürür?",
                options = listOf("|| (Mantıksal OR)", "?? (Nullish Coalescing)", "&& (Mantıksal AND)", "?: (Ternary)"),
                correctIndex = 1,
                explanation = "?? (Nullish Coalescing) yalnızca null ve undefined durumlarında tetiklenir; 0 veya \"\" gibi falsy değerleri korur."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_2",
                lessonId = "js_2",
                title = "Güvenli Değer Seçici (??)",
                instructions = "Gelen ayar objesinde 'ayar.limit' varsa onu, null veya undefined ise varsayılan 50 sayısını döndüren limitGetir(ayar) fonksiyonunu yazın.",
                exampleInput = "limitGetir({ limit: 0 })",
                exampleOutput = "0",
                starterCode = "function limitGetir(ayar) {\n    // Kodunu buraya yaz:\n    return 0;\n}",
                solutionCode = "function limitGetir(ayar) {\n    return ayar?.limit ?? 50;\n}",
                hints = listOf("ayar?.limit ?? 50 kullanın."),
                testCases = listOf(
                    TestCase("limitGetir({ limit: 0 })", "0", "0 korunmalı"),
                    TestCase("limitGetir({})", "50", "Varsayılan 50")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_2_1",
                    lessonId = "js_2",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Arrow fonksiyonlar (=>) ile klasik 'function' bildirimleri arasındaki en kritik mimari fark nedir?",
                    options = listOf("Arrow fonksiyonlar daha yavaştır", "Arrow fonksiyonlar kendi 'this', 'arguments' ve 'super' bağlamlarına sahip değildir; çevreleyen kapsamdan miras alırlar", "Arrow fonksiyonlar parametre alamaz", "Arrow fonksiyonlar asenkron çalışamaz"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Arrow fonksiyonlar lexical scoping ile 'this' bağlamını dışarıdan alır.",
                    explanationWrong = "Lexical this mekanizması en temel farktır.",
                    reviewTopic = "Lexical this in Arrow Functions"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "for...in ile for...of arasındaki fark nedir?",
                    answer = "`for...in` nesnelerin anahtarları/indeksleri (keys) ve prototip zinciri üzerinde döner. `for...of` ise yinelenebilir nesnelerin (Iterable: Array, Map, Set) doğrudan değerleri (values) üzerinde döner."
                )
            ),
            completionCriteria = listOf(
                "?? ile || arasındaki falsy farkını bilmek",
                "İteratör protokolünü ve for...of döngüsünü kavramak",
                "Arrow functions ve lexical this mantığını derinlemesine açıklayabilmek"
            )
        ),

        // ==========================================
        // DERS 3: DESTRUCTURING, REST/SPREAD & NESNELER
        // ==========================================
        Lesson(
            id = "js_3",
            courseId = "javascript",
            sectionId = "js_sec_2",
            title = "Nesne Mimarisi, Destructuring, Rest & Spread",
            shortDesc = "Property Descriptors, Array/Object Destructuring, Yeniden isimlendirme, Rest/Spread mekanizması ve Shallow vs structuredClone derin kopyalama.",
            level = CourseLevel.BEGINNER,
            order = 3,
            isPremium = false,
            learningObjectives = listOf(
                "Nesne Özellik Tanımlayıcılarını (Property Descriptors: enumerable, writable, configurable) anlamak",
                "İç içe Destructuring, Takma Ad (Aliasing) ve Varsayılan Değer desenlerini ustaca uygulamak",
                "Spread (...) operatörünün sığ kopyalama (Shallow Copy) sınırlarını ve structuredClone() derin kopyalama motorunu kavramak",
                "Rest parametreleri (...args) ile değişken parametreli fonksiyonlar tasarlamak"
            ),
            prerequisites = listOf("Kontrol Akışı ve Arrow Functions"),
            subtopics = listOf("Nesne Mimarisi & Property Descriptors", "Object & Nested Array Destructuring", "Destructuring Takma Adları (Aliasing) & Defaults", "Spread (...) Operatörü & Shallow Copy Sınırları", "structuredClone() ile Deep Copy & Rest Parametreleri"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Object ve Array Destructuring İleri Desenleri",
                    body = "Destructuring, veri yapılarını parçalayarak yerel değişkenlere bağlama mekanizmasıdır:\n• Yeniden isimlendirme (Aliasing): `{ ad: kullaniciAdi }`\n• Varsayılan değerler: `{ rol = 'Misafir' }`\n• İç içe ayıklama: `const { adres: { sehir } } = kullanici;`\n• Kalan elemanları toplama (Rest): `const [ilk, ...kalanlar] = dizi;`",
                    codeSnippet = "const yanit = { data: { user: { id: 101, username: 'dev' } }, status: 200 };\nconst { data: { user: { username: kullaniciAdi } }, status } = yanit;\nconsole.log(kullaniciAdi, status); // 'dev', 200"
                ),
                LessonContentBlock(
                    subtitle = "2. Spread (...) vs structuredClone() (Shallow vs Deep Copy)",
                    body = "Spread (`{ ...obj }` veya `[...dizi]`) işlemi **Shallow Copy** (Sığ Kopyalama) yapar. İlk seviyedeki primitif değerleri kopyalar; ancak iç içe nesnelerin yalnızca bellek işaretçilerini (referanslarını) kopyalar. İçteki bir nesne değiştirilirse orijinal nesne de mutasyona uğrar!\n\nTam bağımsız derin bir kopya üretmek için modern JavaScript'in yerleşik **`structuredClone(obj)`** API'si kullanılmalıdır.",
                    codeSnippet = "const orijinal = { ad: 'Emre', ayarlar: { tema: 'Koyu' } };\n\n// Sığ Kopyalama (Spread):\nconst sigKopya = { ...orijinal };\nsigKopya.ayarlar.tema = 'Açık';\nconsole.log(orijinal.ayarlar.tema); // 'Açık' (Orijinal bozuldu!)\n\n// Derin Kopyalama (structuredClone):\nconst derinKopya = structuredClone(orijinal);\nderinKopya.ayarlar.tema = 'Mavi';\nconsole.log(orijinal.ayarlar.tema); // 'Açık' (Orijinal korundu!)"
                )
            ),
            codeExample = "const kullanici = {\n    id: 101,\n    ad: \"Ece\",\n    iletisim: { email: \"ece@test.com\", tel: \"555-1234\" },\n    roller: [\"Kullanıcı\", \"Yazar\"]\n};\n\n// İç içe destructuring ve spread:\nconst { ad, iletisim: { email }, roller: [anaRol] } = kullanici;\nconst guncelKullanici = { ...kullanici, sonGiris: \"Bugün\" };\n\nconsole.log(\"Ad: \" + ad + \", Email: \" + email + \", Rol: \" + anaRol);\nconsole.log(guncelKullanici);",
            codeExplanation = "İç içe nesneden email ve diziden ilk rol tek satırda ayıklandı, spread ile orijinal nesne bozulmadan kopyalandı.",
            realWorldExample = "Redux ve React `useState` güncellemelerinde state nesnesini klonlamak için spread operatörü zorunludur.",
            practicalTask = "İki diziyi spread operatörü kullanarak tek bir sıralı dizide birleştiren bir kod yazın.",
            starterPlaygroundCode = "const [a, ...kalanlar] = [1, 2, 3, 4];\nconsole.log(a, kalanlar);",
            miniQuestion = MiniQuestion(
                id = "js_q_3",
                question = "Aşağıdaki 'const { ad: isim = \"Bilinmiyor\" } = {}' ifadesinde üretilen değişkenin adı ve değeri ne olur?",
                options = listOf("ad = 'Bilinmiyor'", "isim = 'Bilinmiyor'", "ad = undefined", "isim = undefined"),
                correctIndex = 1,
                explanation = "'ad: isim' alanı yeniden 'isim' olarak adlandırır; nesnede ad alanı olmadığı için varsayılan 'Bilinmiyor' değerini alır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_3",
                lessonId = "js_3",
                title = "Nesne Birleştirici (Spread)",
                instructions = "İki obje alan ve birinci objenin üzerine ikinci objeyi spread ile birleştirip döndüren objeleriBirlestir(o1, o2) fonksiyonunu yazın.",
                exampleInput = "objeleriBirlestir({ a: 1 }, { b: 2 })",
                exampleOutput = "{ a: 1, b: 2 }",
                starterCode = "function objeleriBirlestir(o1, o2) {\n    // Kodunu buraya yaz:\n    return {};\n}",
                solutionCode = "function objeleriBirlestir(o1, o2) {\n    return { ...o1, ...o2 };\n}",
                hints = listOf("return { ...o1, ...o2 };"),
                testCases = listOf(
                    TestCase("objeleriBirlestir({ a: 1 }, { b: 2 })", "Object", "Spread testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_3_1",
                    lessonId = "js_3",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "JavaScript'te iç içe geçmiş karmaşık bir nesneyi tüm alt dallarıyla birlikte tam bağımsız kopyalamak (Deep Clone) için modern yerleşik standart hangisidir?",
                    options = listOf("Object.assign()", "Spread operatörü ({...obj})", "structuredClone(obj)", "Array.prototype.slice()"),
                    correctOptionIndex = 2,
                    explanationRight = "Doğru! structuredClone() tarayıcılarda ve Node.js'te döngüsel referansları da destekleyen yerleşik derin kopyalama API'sidir.",
                    explanationWrong = "structuredClone(obj) kullanılır.",
                    reviewTopic = "Deep Clone API"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Spread (...) ile kopyalama Shallow Copy midir Deep Copy midir?",
                    answer = "Shallow Copy'dir (Sığ kopyalama). İlk seviyedeki primitif alanları kopyalar; ancak nesne içindeki iç içe alt nesnelerin referans adreslerini kopyalar. Tam derin kopyalama için modern `structuredClone(obj)` kullanılmalıdır."
                )
            ),
            completionCriteria = listOf(
                "Array ve Object Destructuring yapabilmek",
                "Shallow copy ve structuredClone deep copy farkını bilmek",
                "Spread ve Rest operatörlerini doğru ayırt etmek"
            )
        ),

        // ==========================================
        // DERS 4: FONKSİYONEL DİZİ METOTLARI (MAP, FILTER, REDUCE)
        // ==========================================
        Lesson(
            id = "js_4",
            courseId = "javascript",
            sectionId = "js_sec_3",
            title = "Fonksiyonel Dizi Mimarisi, V8 Elements & Transducers",
            shortDesc = "V8 Fast Elements (PACKED_SMI vs HOLEY), map, filter, reduce akümülatör mimarisi, Saf Fonksiyonlar ve toSorted/toReversed.",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            isPremium = true,
            learningObjectives = listOf(
                "V8 motorunun dizi bellek modellerini (PACKED_SMI, PACKED_DOUBLE, HOLEY Elements) öğrenmek",
                "map, filter ve reduce ile saf (Pure), yan etkisiz veri dönüştürme boru hatları kurmak",
                "reduce akümülatörü ile tek geçişte (single-pass) karmaşık gruplama ve frekans hesaplama yapmak",
                "ECMAScript 2023 değişmez (Immutable) dizi metotlarını (toSorted, toReversed, toSpliced) kullanmak"
            ),
            prerequisites = listOf("Destructuring ve Spread Operatörü"),
            subtopics = listOf("V8 Dizi Optimizasyonları (Packed vs Holey)", "map (Projeksiyon & Yeni Dizi)", "filter (Koşullu Eleme)", "reduce (Akümülatör & İndirgeme Deseni)", "İmmutable Dizi Metotları (toSorted, toReversed, with)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. V8 Fast Elements Mimarisi (PACKED vs HOLEY)",
                    body = "V8 dizileri performansına göre dahili olarak sınıflandırır:\n• `PACKED_SMI_ELEMENTS`: Yalnızca küçük tamsayılar içeren, boşluğu olmayan en hızlı dizi.\n• `PACKED_DOUBLE_ELEMENTS`: Kayan noktalı sayılar içeren dizi.\n• `HOLEY_ELEMENTS`: İçinde `delete arr[i]` yapılmış veya `arr[100] = 5` ile arada boşluklar bırakılmış seyrek dizi.\n\nBoşluklu (Holey) diziler V8'i prototip zincirini taramaya zorlar ve performansı ciddi şekilde düşürür. Bu nedenle diziler daima ardışık doldurulmalıdır.",
                    codeSnippet = "const hizliDizi = [1, 2, 3, 4]; // PACKED_SMI\nhizliDizi.push(5);              // Optimize kalır\n\ndelete hizliDizi[1];             // HOLEY_ELEMENTS'e düşer (Yavaşlar!)"
                ),
                LessonContentBlock(
                    subtitle = "2. reduce Akümülatörü ile Tek Geçişli (Single-Pass) Veri İşleme",
                    body = "`reduce` en güçlü fonksiyonel metottur. `map` ve `filter` art arda zincirlendiğinde dizi üzerinde iki ayrı döngü oluşurken, `reduce` her iki işlemi tek bir geçişte (single pass) tamamlayabilir.",
                    codeSnippet = "const islemler = [\n    { tip: 'GELIR', tutar: 1000 },\n    { tip: 'GIDER', tutar: 300 },\n    { tip: 'GELIR', tutar: 500 }\n];\n\n// Tek geçişte hem bakiye hem de işlem adedi hesaplama:\nconst ozet = islemler.reduce((acc, islem) => {\n    if (islem.tip === 'GELIR') acc.toplamGelir += islem.tutar;\n    else acc.toplamGider += islem.tutar;\n    acc.islemSayisi++;\n    return acc;\n}, { toplamGelir: 0, toplamGider: 0, islemSayisi: 0 });"
                ),
                LessonContentBlock(
                    subtitle = "3. ECMAScript 2023 Değişmez (Immutable) Dizi Metotları",
                    body = "Geleneksel `sort()`, `reverse()` ve `splice()` orijinal diziyi mutasyona uğratır (impure). ES2023 ile gelen `toSorted()`, `toReversed()`, `toSpliced()` ve `with(index, value)` orijinal diziyi koruyarak yeni bir kopya döner.",
                    codeSnippet = "const sayilar = [3, 1, 4, 1, 5];\nconst sirali = sayilar.toSorted((a, b) => a - b);\nconsole.log(sayilar); // [3, 1, 4, 1, 5] (Orijinal bozulmadı!)\nconsole.log(sirali);  // [1, 1, 3, 4, 5]"
                )
            ),
            codeExample = "const urunler = [\n    { ad: \"Klavye\", fiyat: 500, kategori: \"Elektronik\" },\n    { ad: \"Mouse\", fiyat: 250, kategori: \"Elektronik\" },\n    { ad: \"Defter\", fiyat: 40, kategori: \"Kırtasiye\" }\n];\n\n// Elektronik ürünlerin toplam fiyatını hesaplayalım:\nconst elektronikToplam = urunler\n    .filter(u => u.kategori === \"Elektronik\")\n    .map(u => u.fiyat)\n    .reduce((toplam, f) => toplam + f, 0);\n\nconsole.log(\"Elektronik Toplam: \" + elektronikToplam + \" TL\");",
            codeExplanation = "filter kategoriyi eledi, map fiyatları çıkardı ve reduce toplam tutarı hesapladı.",
            realWorldExample = "E-ticaret sepet hesaplamalarında, analitik panellerde ve veri tablolarında reduce ve map zincirleri temel taştır.",
            practicalTask = "Bir kelime dizisindeki her kelimenin harf sayısını hesaplayan yeni bir dizi üretin.",
            starterPlaygroundCode = "const sayilar = [1, 2, 3, 4];\nconsole.log(sayilar.filter(x => x % 2 === 0));",
            miniQuestion = MiniQuestion(
                id = "js_q_4",
                question = "JavaScript ES2023 ile gelen ve orijinal diziyi bozmadan sıralanmış yeni bir kopya döndüren saf metot hangisidir?",
                options = listOf("toSorted()", "sort()", "quickSort()", "immutableSort()"),
                correctIndex = 0,
                explanation = "toSorted() metodu orijinal diziyi mutasyona uğratmadan sıralanmış yeni bir dizi döndürür."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_4",
                lessonId = "js_4",
                title = "Çift Sayıların Kareleri Toplamı",
                instructions = "Sayı dizisi alıp içindeki çift sayıların karelerini hesaplayıp toplamını döndüren ciftKarelerToplami(dizi) fonksiyonunu map, filter, reduce ile yazın.",
                exampleInput = "ciftKarelerToplami([1, 2, 3, 4])",
                exampleOutput = "20",
                starterCode = "function ciftKarelerToplami(dizi) {\n    // Kodunu buraya yaz:\n    return 0;\n}",
                solutionCode = "function ciftKarelerToplami(dizi) {\n    return dizi.filter(x => x % 2 === 0).map(x => x * x).reduce((a, b) => a + b, 0);\n}",
                hints = listOf("dizi.filter(x => x % 2 === 0).map(x => x * x).reduce((a, b) => a + b, 0)"),
                testCases = listOf(
                    TestCase("ciftKarelerToplami([1, 2, 3, 4])", "20", "2^2 + 4^2 = 20")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_4_1",
                    lessonId = "js_4",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Orijinal diziyi değiştirmeden (Pure Function kuralı) yeni bir dizi döndüren metot hangisidir?",
                    options = listOf("splice()", "sort()", "map()", "reverse()"),
                    correctOptionIndex = 2,
                    explanationRight = "Doğru! map(), filter() ve slice() orijinal diziyi koruyup yeni dizi üretir; splice ve sort orijinal diziyi bozar.",
                    explanationWrong = "map() saf fonksiyondur ve yeni dizi üretir.",
                    reviewTopic = "Pure Array Methods"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "flatMap() ne işe yarar?",
                    answer = "Önce her elemana `map()` uygular, ardından oluşan iç içe dizileri 1 derinlik seviyesinde `flat()` ile açarak tek bir düz diziye dönüştürür."
                )
            ),
            completionCriteria = listOf(
                "V8 dizi yapılarını ve optimizasyonlarını kavramak",
                "map, filter ve reduce ile veri dönüştürebilmek",
                "ES2023 toSorted() ve immutable metotları kullanabilmek"
            )
        ),

        // ==========================================
        // DERS 5: SCOPE, CLOSURES & KAPSÜLLEME
        // ==========================================
        Lesson(
            id = "js_5",
            courseId = "javascript",
            sectionId = "js_sec_4",
            title = "Scope Chain, Closures & Bellek Yönetimi",
            shortDesc = "Lexical Environment, Scope Chain çözümlemesi, Closures dahili bellek modeli, Data Encapsulation ve Memory Leak önleme.",
            level = CourseLevel.INTERMEDIATE,
            order = 5,
            isPremium = true,
            learningObjectives = listOf(
                "Lexical Environment Records ve Scope Chain arama hiyerarşisini derinlemesine anlamak",
                "Closure'ların Heap bellek tahsisi ve Garbage Collector (Mark-and-Sweep) etkileşimini kavramak",
                "Özel durumları (Private State) kapsüllemek için Closure fabrika fonksiyonları yazmak",
                "Gereksiz Closure referanslarından kaynaklanan bellek sızıntılarını (Memory Leaks) önlemek"
            ),
            prerequisites = listOf("Fonksiyonel Dizi Metotları"),
            subtopics = listOf("Lexical Environment & Environment Records", "Scope Chain Çözümlemesi", "Closures Bellek Mimarisi & Heap Tahsisi", "Data Encapsulation (Gizli State & Modül Deseni)", "Garbage Collection & Memory Leak Önleme"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Lexical Environment ve Scope Chain Çözümlemesi",
                    body = "Her fonksiyon oluşturulduğunda gizli bir `[[Environment]]` özelliğiyle tanımlandığı Lexical Environment'a bağlanır.\n\nBir değişkene erişilmek istendiğinde JavaScript motoru **Scope Chain** boyunca arama yapar: Önce mevcut fonksiyonun Environment Record'una bakar; bulamazsa dış çevreleyen (outer) fonksiyona, en son Global Environment'a kadar tırmanır.",
                    codeSnippet = "const globalVar = 'Global';\nfunction dis() {\n    const disVar = 'Dış';\n    function ic() {\n        const icVar = 'İç';\n        console.log(icVar, disVar, globalVar); // Scope chain ile yukarı tırmanır\n    }\n    return ic;\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Closure (Kapanış) Bellek Modeli ve Heap Tahsisi",
                    body = "Normal şartlarda bir fonksiyon çalışıp bittiğinde yerel değişkenleri Call Stack'ten silinir.\n\nAncak iç fonksiyon dış fonksiyonun bir değişkenini referans alıyorsa (Closure), V8 motoru bu değişkeni Stack yerine **Heap** belleğe taşır (Context Allocation). Dış fonksiyon sonlansa bile iç fonksiyon referansı yaşadığı sürece bu Heap alanı Garbage Collector tarafından temizlenmez.",
                    codeSnippet = "function sayacUretici() {\n    let sayi = 0; // Heap üzerinde korunur (Private State)\n    return {\n        artir: () => ++sayi,\n        deger: () => sayi\n    };\n}\nconst sayac = sayacUretici();\nconsole.log(sayac.artir()); // 1\nconsole.log(sayac.artir()); // 2\n// console.log(sayac.sayi); // undefined (Doğrudan erişilemez!)"
                ),
                LessonContentBlock(
                    subtitle = "3. Bellek Sızıntılarını (Memory Leak) Engelleme",
                    body = "Closure'lar kapatılan değişkenlerin GC tarafından toplanmasını engeller. Eğer büyük veri yapıları veya DOM referansları gereksiz yere closure içinde tutulursa bellek sızıntısı oluşur. İşi biten olay dinleyicileri (Event Listeners) temizlenmeli veya `WeakMap` / `WeakRef` kullanılmalıdır.",
                    tip = "Closure'lar React'in `useState` ve `useEffect` hook'larının bellek yönetiminin temelini oluşturur."
                )
            ),
            codeExample = "function bankaHesabi(baslangicBakiye) {\n    let bakiye = baslangicBakiye; // Dışarıdan doğrudan erişilemez!\n    \n    return {\n        paraYatir: (miktar) => { bakiye += miktar; },\n        paraCek: (miktar) => {\n            if (miktar <= bakiye) bakiye -= miktar;\n            else console.log(\"Yetersiz Bakiye!\");\n        },\n        bakiyeGoster: () => bakiye\n    };\n}\n\nconst hesap = bankaHesabi(1000);\nhesap.paraYatir(500);\nconsole.log(\"Mevcut Bakiye: \" + hesap.bakiyeGoster() + \" TL\"); // 1500",
            codeExplanation = "bakiye değişkeni closure içinde gizlendi; dışarıdan hesap.bakiye şeklinde bozulamaz, sadece metodlar erişebilir.",
            realWorldExample = "React Hooks mimarisindeki `useState` dahili durumunu render'lar arasında korumak için doğrudan Closures mekanizmasını kullanır.",
            practicalTask = "Bir ön ek (prefix) alan ve içine gelen metinlerin başına bu ön eki ekleyen bir closure fabrika fonksiyonu yazın.",
            starterPlaygroundCode = "function selamlayici(onEk) { return (isim) => onEk + \" \" + isim; }\nconst merhabaDe = selamlayici(\"Merhaba\");\nconsole.log(merhabaDe(\"Burak\"));",
            miniQuestion = MiniQuestion(
                id = "js_q_5",
                question = "JavaScript'te bir iç fonksiyonun, ebeveyn fonksiyonu çalışmasını tamamlayıp sonlandıktan sonra bile ebeveyninin değişkenlerine erişebilmesine ne ad verilir?",
                options = listOf("Hoisting", "Closure (Kapanış)", "Currying", "Event Bubbling"),
                correctIndex = 1,
                explanation = "Bu duruma Closure denir; fonksiyon oluşturulduğu andaki Lexical Scope referansını canlı tutar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_5",
                lessonId = "js_5",
                title = "Özel Sayaç (Closure)",
                instructions = "0'dan başlayan, artir() çağrıldığında sayacı 1 artıran, oku() çağrıldığında geçerli değeri döndüren sayacFabrikasi() fonksiyonunu closure ile yazın.",
                exampleInput = "const s = sayacFabrikasi(); s.artir(); s.oku();",
                exampleOutput = "1",
                starterCode = "function sayacFabrikasi() {\n    // Kodunu buraya yaz:\n    return {};\n}",
                solutionCode = "function sayacFabrikasi() {\n    let deger = 0;\n    return {\n        artir: () => { deger++; },\n        oku: () => deger\n    };\n}",
                hints = listOf("let deger = 0 tanımlayın ve metotları obje olarak dönün."),
                testCases = listOf(
                    TestCase("sayacFabrikasi", "1", "Closure test")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_5_1",
                    lessonId = "js_5",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "JavaScript'te 'Temporal Dead Zone (TDZ)' ne anlama gelir?",
                    options = listOf("Programın çöktüğü an", "let ve const değişkenlerinin kapsam başlangıcından tanımlandıkları satıra kadar erişilemez olduğu bölge", "Garbage collector çalışma süresi", "setTimeout bekleme süresi"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! TDZ içinde let/const değişkenine erişim ReferenceError üretir.",
                    explanationWrong = "let/const tanımlanana kadar olan erişilemez bölgedir.",
                    reviewTopic = "Temporal Dead Zone"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Currying nedir?",
                    answer = "Çok parametreli bir fonksiyonu (`f(a, b, c)`), her seferinde tek bir parametre alan iç içe fonksiyon zincirine (`f(a)(b)(c)`) dönüştürme tekniğidir."
                )
            ),
            completionCriteria = listOf(
                "Lexical Scope ve Hoisting farkını açıklayabilmek",
                "Closures ile veri kapsülleme yapabilmek",
                "TDZ mekanizmasının neden var olduğunu bilmek"
            )
        ),

        // ==========================================
        // DERS 6: PROTOTİPLER & ES6 SINIF MİMARİSİ
        // ==========================================
        Lesson(
            id = "js_6",
            courseId = "javascript",
            sectionId = "js_sec_4",
            title = "Prototip Zinciri (__proto__) & Modern ES6 Sınıfları",
            shortDesc = "Prototip tabanlı kalıtım: prototype vs __proto__, Object.create, ES6 Class, constructor, extends, super ve modern Private Fields (#alan).",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true,
            learningObjectives = listOf(
                "JavaScript'in Prototip Tabanlı (Prototypal Inheritance) kalıtım doğasını kavramak",
                "ES6 Class sözdiziminin prototip üzerindeki 'Syntactic Sugar' yapısını anlamak",
                "extends, super() ve private class fields (#alan) ile nesne yönelimli mimariler tasarlamak"
            ),
            prerequisites = listOf("Scope, Hoisting ve Closures"),
            subtopics = listOf("Prototip Tabanlı Kalıtım (Prototypal Inheritance)", "prototype vs __proto__", "ES6 Sınıfları & constructor", "Kalıtım: extends & super()", "Private Class Fields (#) & Encapsulation"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Prototip Zinciri (Prototype Chain) ve ES6 Sınıfları",
                    body = "JavaScript nesne yönelimli diller gibi 'Class-based' değil, 'Prototype-based' bir dildir. ES6 `class` sözdizimi, arka plandaki prototip zincirini saran şık bir sözdizimsel şekerdir (Syntactic Sugar).\n\nBir nesnenin `obj.metot()` çağrıldığında, motor önce nesnenin kendi alanlarına bakar; bulamazsa `obj.__proto__` üzerinden prototip zincirini tırmanarak `Object.prototype`'a kadar arar.",
                    codeSnippet = "class Hayvan {\n    constructor(isim) { this.isim = isim; }\n    sesCikar() { return \"Genel ses\"; }\n}\n\nclass Kedi extends Hayvan {\n    sesCikar() {\n        return `\${super.sesCikar()} -> Miyav!`;\n    }\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Gerçek Özel Alanlar (#private) ve Kapsülleme",
                    body = "Eski JS'deki `_gizliAlan` konvansiyonu dışarıdan erişimi engellemezdi. Modern JavaScript'te `#` önekiyle tanımlanan alanlar (`#sifre`) hem derleme hem çalışma anında sınıf dışından tamamen gizlenir (Hard Private).",
                    tip = "Sınıf metotları prototipe tek bir kez yazılır; constructor içindeki metotlar ise her nesne örneğinde yeniden oluşturulup bellek harcar."
                )
            ),
            codeExample = "class Kullanici {\n    #sifre; // Private Field\n    \n    constructor(isim, sifre) {\n        this.isim = isim;\n        this.#sifre = sifre;\n    }\n    \n    sifreDogrula(girilenSifre) {\n        return this.#sifre === girilenSifre;\n    }\n}\n\nconst k = new Kullanici(\"Kemal\", \"gizli123\");\nconsole.log(\"Kullanıcı: \" + k.isim);\nconsole.log(\"Şifre Doğru mu: \" + k.sifreDogrula(\"gizli123\")); // true\n// console.log(k.#sifre); // SyntaxError: Private field must be declared in an enclosing class",
            codeExplanation = "#sifre private alanı dış dünyadan tamamen gizlendi ve sınıf kapsülleme sağladı.",
            realWorldExample = "Node.js backend ORM'lerinde (Prisma, TypeORM) veritabanı modelleri ES6 sınıfları ve prototip kalıtımı ile oluşturulur.",
            practicalTask = "Araba sınıfı tanımlayıp ondan türeyen ElektrikliAraba sınıfı yazın.",
            starterPlaygroundCode = "class Kisi { constructor(ad) { this.ad = ad; } selam() { return \"Selam \" + this.ad; } }\nconsole.log(new Kisi(\"Efe\").selam());",
            miniQuestion = MiniQuestion(
                id = "js_q_6",
                question = "Modern JavaScript sınıflarında bir alanın (field) sınıf dışından erişilemeyen GERÇEK özel alan (private) olmasını sağlayan sözdizimi hangisidir?",
                options = listOf("_alan (Alt çizgi)", "#alan (Kare işareti)", "private alan", "local alan"),
                correctIndex = 1,
                explanation = "#alan sözdizimi derleme ve çalışma anında sınıf dışından erişimi imkansız kılan resmi JS standardıdır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_6",
                lessonId = "js_6",
                title = "Dikdörtgen Alanı (ES6 Class)",
                instructions = "genislik ve yukseklik alan Dikdortgen sınıfı tanımlayın. alanHesapla() metodu genişlik * yükseklik döndürsün.",
                exampleInput = "new Dikdortgen(5, 10).alanHesapla()",
                exampleOutput = "50",
                starterCode = "class Dikdortgen {\n    // Sınıfı buraya yazın:\n}",
                solutionCode = "class Dikdortgen {\n    constructor(genislik, yukseklik) {\n        this.genislik = genislik;\n        this.yukseklik = yukseklik;\n    }\n    alanHesapla() {\n        return this.genislik * this.yukseklik;\n    }\n}",
                hints = listOf("constructor(genislik, yukseklik) ve alanHesapla() metodunu tanımlayın."),
                testCases = listOf(
                    TestCase("Dikdortgen", "50", "Class testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_6_1",
                    lessonId = "js_6",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "JavaScript'te tüm nesnelerin en tepesindeki kök prototip hangisidir?",
                    options = listOf("Function.prototype", "Object.prototype", "null", "Array.prototype"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Prototip zincirinin en tepesinde Object.prototype yer alır (Onun da prototipi null'dur).",
                    explanationWrong = "Object.prototype zincirin en tepesindedir.",
                    reviewTopic = "Object.prototype"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "static metotlar nedir?",
                    answer = "`static` metotlar nesne örnekleri (`new Sınıf()`) üzerinden değil, doğrudan sınıfın kendisi (`Sınıf.metot()`) üzerinden çağrılan yardımcı fonksiyonlardır."
                )
            ),
            completionCriteria = listOf(
                "Prototip zincirinin çalışma mantığını bilmek",
                "ES6 class, constructor ve extends kullanabilmek",
                "#private fields ile gerçek kapsülleme yapabilmek"
            )
        ),

        // ==========================================
        // DERS 7: PROMISES & ASYNC/AWAIT
        // ==========================================
        Lesson(
            id = "js_7",
            courseId = "javascript",
            sectionId = "js_sec_5",
            title = "Asenkron JS: Promises & Async/Await Derinlikleri",
            shortDesc = "Callback Hell'den kurtuluş: Promise durumları (Pending, Fulfilled, Rejected), Chaining (.then/.catch), async/await, try/catch ve Promise combinators.",
            level = CourseLevel.ADVANCED,
            order = 7,
            isPremium = true,
            learningObjectives = listOf(
                "Promise durum makinesini (Pending, Fulfilled, Rejected) kavramak",
                "async/await ile asenkron kodları senkron gibi okunabilir yazmak",
                "Promise.all, Promise.allSettled ve Promise.race ile çoklu asenkron işlemleri yönetmek"
            ),
            prerequisites = listOf("Prototip Zinciri ve ES6 Sınıfları"),
            subtopics = listOf("Promise Durum Makinesi (State Machine)", ".then(), .catch() & .finally()", "async / await Sözdizimsel Şekeri", "Hata Yönetimi (try/catch blokları)", "Promise Combinators (all, allSettled, race, any)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Promise Durum Makinesi ve async/await Mimarisi",
                    body = "Promise, gelecekte tamamlanacak bir asenkron işlemin nihai sonucunu temsil eder. 3 durumdan birinde bulunur:\n\n• `Pending`: İşlem sürüyor.\n• `Fulfilled`: Başarıyla bitti (`resolve(veri)`).\n• `Rejected`: Hata ile sonuçlandı (`reject(hata)`).\n\n`async/await` ise Promise zincirlerini (`.then().then()`) düz senkron kod gibi okunabilir ve `try/catch` ile yakalanabilir hale getirir.",
                    codeSnippet = "async function kullaniciYukle(id) {\n    try {\n        const yanit = await fetch(`/api/users/\${id}`);\n        if (!yanit.ok) throw new Error(`HTTP Hata: \${yanit.status}`);\n        const veri = await yanit.json();\n        return veri;\n    } catch (err) {\n        console.error('Kullanıcı çekilemedi:', err.message);\n    }\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Promise Kombinatörleri (all vs allSettled vs race)",
                    body = "• `Promise.all([p1, p2])`: Tüm istekleri paralel koşturur. BİRİ BİLE hata verirse anında çöker (Fail-Fast).\n• `Promise.allSettled([p1, p2])`: Hiçbir zaman erken çökmez; tüm işlemlerin bitmesini bekler ve sonuçları `{ status: 'fulfilled'|'rejected', value, reason }` dizisi olarak verir.\n• `Promise.race([p1, p2])`: İlk sonuçlanan (hata veya başarı) Promise'in değerini alır.",
                    tip = "Bağımsız paralel API isteklerinde `await api1(); await api2();` yerine `await Promise.all([api1(), api2()]);` kullanarak süreyi yarıya indirin."
                )
            ),
            codeExample = "const veriGetir = (id) => new Promise((resolve) => {\n    setTimeout(() => resolve(\"Veri #\" + id), 100);\n});\n\nasync function veriAkisi() {\n    try {\n        console.log(\"İstekler paralel başlatıldı...\");\n        const [v1, v2] = await Promise.all([veriGetir(1), veriGetir(2)]);\n        console.log(\"Sonuçlar: \" + v1 + \" & \" + v2);\n    } catch (err) {\n        console.error(\"Hata oluştu:\", err);\n    }\n}\n\nveriAkisi();",
            codeExplanation = "Promise.all ile iki asenkron istek paralel çalıştırıldı ve await ile sonuçlar destructuring ile alındı.",
            realWorldExample = "Frontend uygulamalarında sayfa açılışında kullanıcı profili ve bildirimlerin aynı anda paralel çekilmesi `Promise.all` ile yapılır.",
            practicalTask = "Belirtilen milisaniye kadar bekleyen generic bir delay(ms) Promise fonksiyonu yazın.",
            starterPlaygroundCode = "const delay = ms => new Promise(r => setTimeout(r, ms));\nasync function main() { await delay(50); console.log(\"Hazır\"); }\nmain();",
            miniQuestion = MiniQuestion(
                id = "js_q_7",
                question = "Birden fazla Promise paralel çalıştırıldığında içlerinden biri hata verse bile diğerlerinin sonucunu kaybetmeden tüm sonuçları almak için hangi metot kullanılır?",
                options = listOf("Promise.all()", "Promise.allSettled()", "Promise.race()", "Promise.any()"),
                correctIndex = 1,
                explanation = "Promise.allSettled() her bir Promise'in başarı veya başarısızlık durumunu ayrı ayrı toplar ve asla erken çökmez."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_7",
                lessonId = "js_7",
                title = "Asenkron Sayı İki Katlayıcı",
                instructions = "Bir sayı alıp 10ms sonra bu sayının 2 katını resolve eden asenkronIkiKati(sayi) Promise fonksiyonunu yazın.",
                exampleInput = "await asenkronIkiKati(15)",
                exampleOutput = "30",
                starterCode = "function asenkronIkiKati(sayi) {\n    // Kodunu buraya yaz:\n    return Promise.resolve(0);\n}",
                solutionCode = "function asenkronIkiKati(sayi) {\n    return new Promise(resolve => {\n        setTimeout(() => resolve(sayi * 2), 10);\n    });\n}",
                hints = listOf("return new Promise(res => setTimeout(() => res(sayi * 2), 10));"),
                testCases = listOf(
                    TestCase("asenkronIkiKati(15)", "30", "Promise testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_7_1",
                    lessonId = "js_7",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir 'async' fonksiyonun dönüş değeri (return) daima nedir?",
                    options = listOf("Void", "Döndürülen değere göre değişir", "Daima bir Promise nesnesidir", "Generator nesnesidir"),
                    correctOptionIndex = 2,
                    explanationRight = "Doğru! async fonksiyonlar düz bir değer döndürseler bile JS onu otomatik olarak Promise.resolve() ile sarmalar.",
                    explanationWrong = "async fonksiyonlar daima Promise döner.",
                    reviewTopic = "async return Promise"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Promise.race() ile Promise.any() arasındaki fark nedir?",
                    answer = "`Promise.race()` ilk biten Promise'i (ister başarı olsun ister hata) hemen kabul eder. `Promise.any()` ise ilk BAŞARILI (fulfilled) olanı arar; hataları görmezden gelir."
                )
            ),
            completionCriteria = listOf(
                "Promise durumlarını ve zincirleme yapısını bilmek",
                "async/await ve try-catch ile asenkron hata yönetimi yapmak",
                "Promise.all ve allSettled arasındaki farkı uygulamak"
            )
        ),

        // ==========================================
        // DERS 8: EVENT LOOP & MICROTASKS / MACROTASKS
        // ==========================================
        Lesson(
            id = "js_8",
            courseId = "javascript",
            sectionId = "js_sec_5",
            title = "Event Loop, Call Stack & Microtask / Macrotask Kuyrukları",
            shortDesc = "Tek iş parçacığı (Single Threaded) nasıl çalışır? Call Stack, Web APIs, Microtask Queue (Promises, queueMicrotask) vs Macrotask Queue (setTimeout, I/O) öncelik sırası.",
            level = CourseLevel.ADVANCED,
            order = 8,
            isPremium = true,
            learningObjectives = listOf(
                "JavaScript'in Call Stack çalışma mantığını ve 'Stack Overflow' durumunu kavramak",
                "Event Loop'un tarayıcı ve Node.js'teki döngü mekanizmasını öğrenmek",
                "Microtask (Promise) kuyruğunun Macrotask (setTimeout) kuyruğuna olan MUTLAK ÖNCELİĞİNİ kodla kanıtlamak"
            ),
            prerequisites = listOf("Promises ve Async/Await"),
            subtopics = listOf("Single-Threaded Call Stack Mimarisi", "Web APIs & Arka Plan İşlemleri", "Microtask Queue (Promise.then, queueMicrotask)", "Macrotask Queue (setTimeout, setInterval, I/O)", "Event Loop Öncelik Döngüsü"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Event Loop ve Görev Kuyruklarının Kesin Öncelik Sıralaması",
                    body = "JavaScript tek iş parçacıklıdır (Single-Threaded). Asenkronluğu yöneten Event Loop şu kesin sırayla döner:\n\n1. **Call Stack:** Senkron kodlar yukarıdan aşağıya işlenir ve stack sıfırlanır.\n2. **Microtask Queue:** Call Stack boşaldığı anda, kuyruktaki TÜM microtask'lar (`Promise.then/catch/finally`, `queueMicrotask`, `MutationObserver`) tamamen bitene kadar işlenir.\n3. **Render (Yenileme):** Tarayıcı ekranı günceller (varsa).\n4. **Macrotask Queue:** Kuyruktaki SADECE BİR Macrotask (`setTimeout`, `setInterval`, `setImmediate`, I/O) çağrılır ve döngü 1. adıma başa döner.",
                    codeSnippet = "console.log('1: Senkron');\nsetTimeout(() => console.log('2: Macrotask (setTimeout)'), 0);\nPromise.resolve().then(() => console.log('3: Microtask (Promise)'));\nconsole.log('4: Senkron');\n// Çıktı Sırası: 1 -> 4 -> 3 -> 2"
                ),
                LessonContentBlock(
                    subtitle = "2. UI Donmasını Önleme ve Macrotask Stratejisi",
                    body = "Ağır matematiksel döngüler Call Stack'i kilitlerse tarayıcı UI render işlemlerini (60 FPS) ve kullanıcı tıklamalarını işleyemez (Freezing). Uzun süren senkron işler `setTimeout(fn, 0)` parçalarına bölünmeli veya `Web Workers`'a taşınmalıdır.",
                    tip = "`setTimeout(fn, 0)` işlemi 0 milisaniye sonra değil, mevcut Call Stack ve Microtask kuyruğu tamamen bittikten sonra çalıştırılır."
                )
            ),
            codeExample = "console.log(\"A: Senkron Başlangıç\");\n\nsetTimeout(() => {\n    console.log(\"B: Macrotask (setTimeout)\");\n}, 0);\n\nPromise.resolve().then(() => {\n    console.log(\"C: Microtask (Promise 1)\");\n}).then(() => {\n    console.log(\"D: Microtask (Promise 2)\");\n});\n\nconsole.log(\"E: Senkron Bitiş\");\n// Çıktı Sırası: A -> E -> C -> D -> B",
            codeExplanation = "Önce senkron A ve E çalıştı. Stack boşalınca Microtask C ve D çalıştı. En son Macrotask B çalıştı.",
            realWorldExample = "Mülakatlarda en sık sorulan JavaScript sorusudur ve karmaşık asenkron yarış durumlarını (Race Conditions) çözmek için şarttır.",
            practicalTask = "queueMicrotask kullanarak setTimeout'tan önce çalışan bir microtask görevi planlayın.",
            starterPlaygroundCode = "console.log(\"1\");\nsetTimeout(() => console.log(\"3\"), 0);\nqueueMicrotask(() => console.log(\"2\"));",
            miniQuestion = MiniQuestion(
                id = "js_q_8",
                question = "Call Stack boşaldığında Event Loop ilk olarak hangi kuyruktaki görevleri çalıştırır?",
                options = listOf("Macrotask Queue (setTimeout)", "Microtask Queue (Promise .then / queueMicrotask)", "DOM Event Kuyruğu", "Render Kuyruğu"),
                correctIndex = 1,
                explanation = "Microtask kuyruğu her zaman en yüksek önceliğe sahiptir ve Macrotask'lerden önce tamamen boşaltılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_8",
                lessonId = "js_8",
                title = "Microtask Planlayıcı",
                instructions = "queueMicrotask kullanarak verilen mesajı microtask kuyruğuna ekleyen microGorevEkle(mesaj, callback) fonksiyonunu yazın.",
                exampleInput = "microGorevEkle(\"Test\", fn)",
                exampleOutput = "Microtask planlandı",
                starterCode = "function microGorevEkle(mesaj, callback) {\n    // Kodunu buraya yaz:\n}",
                solutionCode = "function microGorevEkle(mesaj, callback) {\n    queueMicrotask(() => callback(mesaj));\n}",
                hints = listOf("queueMicrotask(() => callback(mesaj));"),
                testCases = listOf(
                    TestCase("microGorevEkle", "Microtask", "Event loop test")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_8_1",
                    lessonId = "js_8",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir web sayfasında sonsuz bir while(true) döngüsü çalıştırılırsa ne olur?",
                    options = listOf("Tarayıcı çöker veya sayfa tamamen donarak tıklamalara yanıt veremez hale gelir; çünkü Call Stack asla boşalamaz", "Event loop araya girip döngüyü duraklatır", "setTimeout görevleri çalışmaya devam eder", "Arka planda sessizce biter"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! JS tek thread'dir; senkron döngü Stack'i kilitlerse Event Loop diğer görevleri çalıştıramaz.",
                    explanationWrong = "Call Stack boşalmadığı için sayfa tamamen kilitlenir.",
                    reviewTopic = "Call Stack Blocking"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Node.js ile Tarayıcı Event Loop'u arasında fark var mıdır?",
                    answer = "Evet. Tarayıcıda HTML5 standardı geçerlidir (Microtask/Macrotask). Node.js'te ise Libuv kütüphanesi kullanılır ve Timer, Pending I/O, Poll, Check (setImmediate), Close olmak üzere 6 ayrı faz bulunur."
                )
            ),
            completionCriteria = listOf(
                "Call Stack ve Single-Threaded doğasını kavramak",
                "Microtask ve Macrotask sıralama kurallarını bilmek",
                "Senkron kod bloklamasının zararlarını açıklayabilmek"
            )
        ),

        // ==========================================
        // DERS 9: METAPROGRAMMING: PROXY & REFLECT
        // ==========================================
        Lesson(
            id = "js_9",
            courseId = "javascript",
            sectionId = "js_sec_6",
            title = "Metaprogramming: Proxy & Reflect API",
            shortDesc = "Reaktif sistemlerin kalbi: Proxy ile nesne işlemlerini araya girip yakalama (Traps: get, set, deleteProperty), Reflect API ve Vue 3 tarzı reaktif durum motoru.",
            level = CourseLevel.EXPERT,
            order = 9,
            isPremium = true,
            learningObjectives = listOf(
                "Proxy ile bir nesneye yapılan okuma/yazma işlemlerini yakalamayı (Interception) öğrenmek",
                "Reflect API metotlarını Proxy trap'leri içinde varsayılan davranışı korumak için kullanmak",
                "Özellik doğrulama (Validation) ve Reaktif UI Data-Binding motoru geliştirmek"
            ),
            prerequisites = listOf("Event Loop ve Nesne Yönelimli JS"),
            subtopics = listOf("Proxy & Traps (Tuzaklar) Kavramı", "get & set ile Veri Yakalama", "Reflect API ile Güvenli İşlemler", "Dinamik Doğrulama (Data Validation)", "Reaktif Durum (Vue 3 / MobX Mimarisi)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Proxy Tuzakları (Traps) ve İşlem Yakalama (Interception)",
                    body = "Proxy nesnesi, hedef bir nesnenin (Target) önüne yerleşen bir meta-programlama kalkanıdır. Nesnenin özelliklerine erişildiğinde (`get`), değer atandığında (`set`), silindiğinde (`deleteProperty`) veya fonksiyon olarak çağrıldığında (`apply`) araya girerek özel mantık çalıştırmanızı sağlar.",
                    codeSnippet = "const hedef = { bakiye: 100 };\nconst korumaliBanka = new Proxy(hedef, {\n    get(target, prop, receiver) {\n        console.log(`[LOG]: \${String(prop)} alanı okundu.`);\n        return Reflect.get(target, prop, receiver);\n    },\n    set(target, prop, value, receiver) {\n        if (prop === 'bakiye' && value < 0) {\n            throw new RangeError('Bakiye eksiye düşemez!');\n        }\n        return Reflect.set(target, prop, value, receiver);\n    }\n});"
                ),
                LessonContentBlock(
                    subtitle = "2. Neden Reflect API Kullanılır?",
                    body = "`Reflect`, JavaScript'in dahili nesne operasyonlarını fonksiyonel bir standartta sunar. Başarısız atamalarda kodun patlamasını engelleyip `false` döner ve `this` bağlamının (Receiver) doğru prototipe iletilmesini garanti eder.",
                    tip = "Vue 3 reaktivite motoru (Reactivity API) tamamen JavaScript `Proxy` nesneleri üzerine kurulmuştur."
                )
            ),
            codeExample = "function reaktifNesne(veri, onChange) {\n    return new Proxy(veri, {\n        set(target, prop, value) {\n            const eski = target[prop];\n            const sonuc = Reflect.set(target, prop, value);\n            if (eski !== value) {\n                onChange(prop, value);\n            }\n            return sonuc;\n        }\n    });\n}\n\nconst state = reaktifNesne({ sayac: 0 }, (alan, yeniDeger) => {\n    console.log(\"State değişti! [\" + alan + \"] -> \" + yeniDeger);\n});\n\nstate.sayac = 1; // Konsola: State değişti! [sayac] -> 1\nstate.sayac = 2; // Konsola: State değişti! [sayac] -> 2",
            codeExplanation = "Proxy set tuzağı ile nesne alanı her değiştiğinde onChange tetiklendi; reaktif state motoru kuruldu.",
            realWorldExample = "Vue 3, MobX ve Immer.js kütüphaneleri durum değişikliklerini otomatik algılayıp UI'ı güncellemek için Proxy kullanır.",
            practicalTask = "Olmayan bir özelliğe erişildiğinde hata fırlatan bir Proxy nesnesi yazın.",
            starterPlaygroundCode = "const p = new Proxy({}, { get: (t, k) => k in t ? t[k] : \"Bulunamadı\" });\nconsole.log(p.test);",
            miniQuestion = MiniQuestion(
                id = "js_q_9",
                question = "Vue 3 reaktivite sisteminin Vue 2'deki Object.defineProperty yerine 'Proxy' kullanmasının en büyük avantajı nedir?",
                options = listOf("Proxy daha az bellek kullanır", "Proxy sonradan eklenen yeni dinamik özellikleri ve dizi indeks değişimlerini otomatik yakalayabilir", "Proxy sadece sayılarla çalışır", "Proxy tarayıcıyı dondurmaz"),
                correctIndex = 1,
                explanation = "Proxy tüm nesneyi sarmalar; böylece sonradan eklenen özellikler ve array mutasyonları (push, splice) anında yakalanır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_9",
                lessonId = "js_9",
                title = "Pozitif Sayı Doğrulayıcı (Proxy)",
                instructions = "Sadece pozitif sayıların atanmasına izin veren, negatif sayı veya metin atanırsa hata fırlatan dogrulanmisNesne() Proxy'sini yazın.",
                exampleInput = "state.puan = -5 // Hata!",
                exampleOutput = "Error: Sadece pozitif sayı",
                starterCode = "function dogrulanmisNesne() {\n    return new Proxy({}, {\n        set(target, prop, value) {\n            // Kodunu buraya yaz:\n            return true;\n        }\n    });\n}",
                solutionCode = "function dogrulanmisNesne() {\n    return new Proxy({}, {\n        set(target, prop, value) {\n            if (typeof value !== 'number' || value < 0) {\n                throw new Error('Sadece pozitif sayı atanabilir');\n            }\n            return Reflect.set(target, prop, value);\n        }\n    });\n}",
                hints = listOf("typeof value !== 'number' || value < 0 kontrolü yapın."),
                testCases = listOf(
                    TestCase("dogrulanmisNesne", "Proxy", "Proxy validation")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_9_1",
                    lessonId = "js_9",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Proxy 'set' tuzağında (trap) atama başarılı olduğunda fonksiyon ne döndürmelidir?",
                    options = listOf("Atanan değeri", "true (başarılı) veya false (başarısız)", "target nesnesini", "undefined"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Proxy set trap'i strict mode'da false döndürürse TypeError fırlatılır; başarılı atamada true dönmelidir.",
                    explanationWrong = "Boolean (true/false) döndürmelidir.",
                    reviewTopic = "Proxy Set Trap Boolean Return"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "deleteProperty tuzağı ne işe yarar?",
                    answer = "Bir nesneden `delete nesne.ozellik` komutu ile alan silinmeye çalışıldığında araya girerek silme işlemini engellemeye veya loglamaya yarar."
                )
            ),
            completionCriteria = listOf(
                "Proxy ve Reflect API farkını bilmek",
                "get ve set tuzakları ile nesne davranışını değiştirebilmek",
                "Reaktif veri bağlama (Data binding) mantığını kavramak"
            )
        ),

        // ==========================================
        // DERS 10: MODÜLLER, WEBPACK/VITE & BUNDLERS
        // ==========================================
        Lesson(
            id = "js_10",
            courseId = "javascript",
            sectionId = "js_sec_6",
            title = "Modül Sistemleri: ESM (import/export) vs CJS & Tree-Shaking",
            shortDesc = "Modern JS mimarisi: ES Modules (import/export), CommonJS (require), Dinamik İçe Aktarma (import()), Bundler optimizasyonları ve Tree-Shaking.",
            level = CourseLevel.ADVANCED,
            order = 10,
            isPremium = true,
            learningObjectives = listOf(
                "ES Modules (ESM) ile CommonJS (CJS) arasındaki statik analiz farkını anlamak",
                "Dinamik import() ile kod bölme (Code Splitting) ve Lazy Loading yapmak",
                "Tree-Shaking mekanizmasının kullanılmayan ölü kodları nasıl temizlediğini kavramak"
            ),
            prerequisites = listOf("Proxy ve Metaprogramming"),
            subtopics = listOf("ES Modules (import / export)", "Named vs Default Export", "CommonJS (require / module.exports) Mimarisi", "Dinamik import() & Code Splitting", "Tree-Shaking & Dead Code Elimination"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. ESM (Statik) vs CommonJS (Dinamik) Mimarisi",
                    body = "CommonJS (`require`), Node.js'in klasik sistemidir ve çalışma zamanında (Runtime) dinamik yürütülür. ES Modules (`import/export`) ise resmi web standardıdır ve derleme zamanında (Build-time) statik analiz edilebilir.\n\nStatik yapı sayesinde derleyiciler (Vite, Rollup, Webpack) projedeki import edilen ancak çağrılmayan ölü kod dallarını (Dead Code) nihai üretim paketinden tamamen atar (Tree-Shaking).",
                    codeSnippet = "// utils.js\nexport const topla = (a, b) => a + b;\nexport const carp = (a, b) => a * b;\n\n// main.js\nimport { topla } from './utils.js';\n// 'carp' fonksiyonu kullanılmadığı için bundle'a asla eklenmez (Tree-Shaking)!"
                ),
                LessonContentBlock(
                    subtitle = "2. Dinamik import() ve Kod Bölme (Code Splitting)",
                    body = "Sayfa açılışında ihtiyaç duyulmayan ağır grafik veya rapor modülleri ilk yüklemeye dahil edilmez. Yalnızca kullanıcı ilgili butona tıkladığında `const mod = await import('./heavyChart.js')` şeklinde asenkron Lazy Load edilir.",
                    tip = "Daima 'Named Export' (`export { foo }`) tercih edin; 'Default Export' (`export default`) Tree-Shaking verimini ve otomatik IDE refactoring'lerini zorlaştırır."
                )
            ),
            codeExample = "// math.js modülü:\nexport const pi = 3.14;\nexport function kare(x) { return x * x; }\n\n// main.js:\n// import { kare } from './math.js';\n// console.log(kare(4)); // 'pi' kullanılmadığı için bundle'a dahil edilmez (Tree-Shaking)!\nconsole.log(\"ESM Statik Modül Sistemi Aktif\");",
            codeExplanation = "Statik import yapısı bundler araçlarının ölü kodu tespit edip atmasını sağladı.",
            realWorldExample = "Vite, Next.js ve Webpack modern web uygulamalarını mikro parçalara bölmek ve hızlı açılış sağlamak için ESM tabanlı kod bölme kullanır.",
            practicalTask = "Dinamik import() kullanarak bir fonksiyonu asenkron yükleyen bir kod taslağı yazın.",
            starterPlaygroundCode = "const mod = { topla: (a,b) => a+b };\nconsole.log(mod.topla(2, 3));",
            miniQuestion = MiniQuestion(
                id = "js_q_10",
                question = "Paketleyicilerin (Vite, Webpack) projedeki kullanılmayan ölü kodları tespit edip nihai çıktıdan atması işlemine ne ad verilir?",
                options = listOf("Minification", "Tree-Shaking", "Transpilation", "Polyfill"),
                correctIndex = 1,
                explanation = "Tree-Shaking statik ESM import yapısını inceleyerek çağrılmayan ölü kod dallarını ağaçtan silker gibi temizler."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_10",
                lessonId = "js_10",
                title = "Named Export Simülasyonu",
                instructions = "Bir nesne içinde topla ve cikar fonksiyonlarını barındıran HesapModulu nesnesini döndüren fonksiyon yazın.",
                exampleInput = "HesapModulu.topla(5, 3)",
                exampleOutput = "8",
                starterCode = "function moduluOlustur() {\n    // Kodunu buraya yaz:\n    return {};\n}",
                solutionCode = "function moduluOlustur() {\n    return {\n        topla: (a, b) => a + b,\n        cikar: (a, b) => a - b\n    };\n}",
                hints = listOf("topla ve cikar fonksiyonlarını nesne olarak dönün."),
                testCases = listOf(
                    TestCase("moduluOlustur", "Module", "Export testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_10_1",
                    lessonId = "js_10",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "CommonJS (require) modül sistemi tarayıcılarda neden doğrudan ve verimli şekilde çalışmaz?",
                    options = listOf("JS dili izin vermez", "require() senkron çalışır ve dosya sisteminden okuma yapar; tarayıcıda ise dosyalar ağ üzerinden asenkron yüklenmek zorundadır", "Sadece Linux'ta çalışır", "Güvenlik nedeniyle yasaklanmıştır"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! require senkron olduğu için tarayıcıda ana thread'i ağ isteği boyunca kilitlerdi; ESM ise asenkron modül yüklemeyi destekler.",
                    explanationWrong = "Senkron dosya okuma mantığı tarayıcı ağına uyum sağlamaz.",
                    reviewTopic = "CommonJS vs ESM in Browser"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "import.meta nedir?",
                    answer = "Mevcut modül hakkında üst veri (metadata) tutan nesnedir; örneğin `import.meta.url` geçerli dosyanın URL adresini verir."
                )
            ),
            completionCriteria = listOf(
                "ESM ve CommonJS farkını açıklayabilmek",
                "Tree-Shaking optimizasyon kurallarını bilmek",
                "Dinamik import() ile kod bölme yapabilmek"
            )
        ),

        // ==========================================
        // DERS 11: WEB WORKERS & SHAREDARRAYBUFFER
        // ==========================================
        Lesson(
            id = "js_11",
            courseId = "javascript",
            sectionId = "js_sec_6",
            title = "Web Workers & SharedArrayBuffer: Gerçek Çoklu İş Parçacığı",
            shortDesc = "Ana UI thread'ini dondurmadan arka planda çoklu thread çalıştırma: Web Workers (postMessage, onmessage), SharedArrayBuffer, Atomics ve TypedArrays (Float32Array).",
            level = CourseLevel.EXPERT,
            order = 11,
            isPremium = true,
            learningObjectives = listOf(
                "Web Workers ile ana thread'den bağımsız arka plan iş parçacıkları oluşturmak",
                "postMessage ile yapılandırılmış klonlama (Structured Clone) mesajlaşmasını kavramak",
                "SharedArrayBuffer ve Atomics ile kilitlenmesiz sıfır kopyalı paylaşımlı bellek yönetimi yapmak"
            ),
            prerequisites = listOf("Modüller ve Asenkron JS"),
            subtopics = listOf("Web Workers & Multithreading", "postMessage & onmessage (Structured Clone)", "SharedArrayBuffer ile Bellek Paylaşımı", "Atomics API & Thread Eşzamanlama", "TypedArrays (ArrayBuffer, Uint8Array)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Web Workers ile Gerçek Paralel İşleme",
                    body = "JavaScript ana iş parçacığı UI render ve kullanıcı etkileşimlerini yönetir. Görüntü filtreleme, 3D fizik hesaplamaları veya şifreleme gibi CPU-yoğun işlemler Web Worker ile ayrı bir işletim sistemi thread'ine devredilir.\n\nİletişim `postMessage()` ve `onmessage` eventleri üzerinden mesaj tabanlı (Message Passing) yürütülür.",
                    codeSnippet = "// main.js\nconst worker = new Worker('hesaplayici.js');\nworker.postMessage({ sayilar: [100, 200, 300] });\nworker.onmessage = (e) => console.log('Sonuç:', e.data);\n\n// hesaplayici.js\nonmessage = (e) => {\n    const sonuc = e.data.sayilar.reduce((a, b) => a + b, 0);\n    postMessage(sonuc);\n};"
                ),
                LessonContentBlock(
                    subtitle = "2. SharedArrayBuffer, Atomics ve TypedArrays",
                    body = "Normal mesajlaşma veriyi klonlar (büyük dizilerde kopyalama maliyeti oluşur). `SharedArrayBuffer` ile iki thread aynı ham bellek adresini sıfır kopyalama ile paylaşır.\n\nFarklı thread'lerin aynı byte'a aynı anda yazıp veri bozmasını engellemek için `Atomics.add`, `Atomics.load`, `Atomics.wait` ve `Atomics.notify` komutları kullanılır.",
                    tip = "Web Workers içinde `window`, `document` ve DOM API'leri KULLANILAMAZ; sadece saf hesaplama, fetch ve IndexedDB erişilebilir."
                )
            ),
            codeExample = "// TypedArray ile yüksek performanslı bellek yönetimi:\nconst buffer = new ArrayBuffer(16); // 16 byte ham bellek\nconst int32View = new Int32Array(buffer); // 4 elemanlık int32 dizisi\n\nint32View[0] = 42;\nint32View[1] = 100;\n\nconsole.log(\"Byte Uzunluğu: \" + buffer.byteLength);\nconsole.log(\"Değerler: \" + int32View[0] + \", \" + int32View[1]);",
            codeExplanation = "Ham bellek ArrayBuffer üzerinde TypedArray ile sıfır ek yükle C-seviyesinde sayı manipülasyonu yapıldı.",
            realWorldExample = "Figma web uygulamasında C++ motoru WebAssembly ve Web Workers üzerinde çalışır; UI 120 FPS akıcılıkta kalır.",
            practicalTask = "Float32Array oluşturup 5 kayan noktalı sayı yerleştirin.",
            starterPlaygroundCode = "const u8 = new Uint8Array(4);\nu8[0] = 255; console.log(u8[0]);",
            miniQuestion = MiniQuestion(
                id = "js_q_11",
                question = "Bir Web Worker dosyasının içinden doğrudan 'document.getElementById()' çağrılarak DOM elemanlarına erişilebilir mi?",
                options = listOf("Evet, serbestçe erişilebilir", "Hayır, Web Workers DOM ve window nesnelerine erişemez; iş parçacığı güvenliği için UI erişimi kısıtlıdır", "Sadece gizli elemanlara erişebilir", "Belli kütüphanelerle erişebilir"),
                correctIndex = 1,
                explanation = "Thread-safety gereği DOM manipülasyonu yalnızca ana thread'e aittir; Worker yalnızca veri hesaplayıp mesaj atar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_11",
                lessonId = "js_11",
                title = "TypedArray ile Bellek Doldurma",
                instructions = "N elemanlı bir Uint16Array oluşturan ve her elemanına indeks numarasını yazıp döndüren uintDizisiUret(n) fonksiyonunu yazın.",
                exampleInput = "uintDizisiUret(3)",
                exampleOutput = "Uint16Array [0, 1, 2]",
                starterCode = "function uintDizisiUret(n) {\n    // Kodunu buraya yaz:\n    return null;\n}",
                solutionCode = "function uintDizisiUret(n) {\n    const arr = new Uint16Array(n);\n    for (let i = 0; i < n; i++) arr[i] = i;\n    return arr;\n}",
                hints = listOf("const arr = new Uint16Array(n); for döngüsü ile doldurun."),
                testCases = listOf(
                    TestCase("uintDizisiUret(3)", "Uint16Array", "TypedArray testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_11_1",
                    lessonId = "js_11",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "İki farklı Worker thread'inin 'SharedArrayBuffer' üzerindeki aynı bellek alanına aynı anda yazması durumunda veri bozulmasını (Race Condition) önlemek için hangi yerleşik API kullanılır?",
                    options = listOf("Mutex API", "Atomics API", "Locker API", "Sync API"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Atomics API atomik okuma, yazma, bekleme ve uyandırma operasyonları sağlayarak bellek yarışlarını önler.",
                    explanationWrong = "Atomics API kullanılır.",
                    reviewTopic = "Atomics API"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Transferable Objects nedir?",
                    answer = "postMessage ile büyük verileri kopyalamak yerine, belleğin sahipliğini anında Worker'a devreden (Zero-Copy) nesnelerdir (`ArrayBuffer`, `ImageBitmap`). Devredildikten sonra ana thread'deki kopya nötrlenir (detached)."
                )
            ),
            completionCriteria = listOf(
                "Web Workers mimarisini ve kısıtlarını bilmek",
                "postMessage ile thread'ler arası iletişim kurabilmek",
                "TypedArray ve SharedArrayBuffer mantığını kavramak"
            )
        ),

        // ==========================================
        // DERS 12: V8 MOTORU, JIT OPTİMİZASYONLARI & BELLEK YÖNETİMİ
        // ==========================================
        Lesson(
            id = "js_12",
            courseId = "javascript",
            sectionId = "js_sec_6",
            title = "V8 Motoru Derinlikleri: JIT, Hidden Classes & Bellek Yönetimi",
            shortDesc = "Tarayıcı motorunun içi: Ignition Bytecode Interpreter, TurboFan JIT Compiler, Deoptimization, Hidden Classes (Monomorphic vs Megamorphic) ve Garbage Collection.",
            level = CourseLevel.EXPERT,
            order = 12,
            isPremium = true,
            learningObjectives = listOf(
                "V8 motorunun JS kodunu nasıl derleyip optimize ettiğini (Ignition & TurboFan) öğrenmek",
                "Hidden Classes ve Inline Caching (IC) kurallarına uyarak kodları 10 kat daha hızlı çalıştırmak",
                "Monomorphic kod yazarak Deoptimization'ları engellemek",
                "Garbage Collector (Scavenger & Mark-Sweep) çalışma mantığıyla bellek sızıntılarını önlemek"
            ),
            prerequisites = listOf("Web Workers, TypedArrays ve İleri JS"),
            subtopics = listOf("Ignition (Interpreter) vs TurboFan (JIT Compiler)", "Hidden Classes (Shape/Maps) Mimarisi", "Inline Caching (IC) & Monomorphism", "Deoptimization (Bailout) Tuzakları", "Garbage Collection & WeakMap / WeakRef"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. V8 Derleme Boru Hattı: Ignition & TurboFan",
                    body = "V8 motoru JavaScript kodunu iki aşamada çalıştırır:\n\n1. **Ignition (Bytecode Interpreter):** Kodu hemen yorumlar ve hızlı başlatır. Kodun çalışma profilini (Type feedback) toplar.\n2. **TurboFan (Optimizing JIT Compiler):** Sık çağrılan 'sıcak' (Hot) fonksiyonları doğrudan makine koduna (Assembly) derler.\n\nEğer bir fonksiyona sürekli beklenmedik tipte veriler gönderilirse JIT optimizasyonu çöker (Deoptimization / Bailout) ve kod yavaş yoruma geri döner.",
                    codeSnippet = "function topla(a, b) {\n    return a + b; // Sürekli tamsayı (int) gelirse TurboFan tamsayı toplama makine koduna derler.\n}\ntopla(10, 20); // Optimize (Hot)\ntopla(\"hata\", {}); // Deoptimization! TurboFan optimizasyonu iptal eder."
                ),
                LessonContentBlock(
                    subtitle = "2. Hidden Classes (Gizli Sınıflar) ve Monomorphic Erişim",
                    body = "V8, nesne özelliklerine C/C++ hızında bellek ofsetiyle erişebilmek için 'Hidden Classes' (Shapes) üretir. Nesnelere rastgele sırada alan eklemek veya `delete obj.alan` yapmak gizli sınıfları parçalar ve erişim hızını 10 kat düşürür.",
                    tip = "Nesnelerden alan silmek (`delete obj.prop`) yerine `obj.prop = undefined` atayın; böylece V8 gizli sınıf yapısını korur."
                )
            ),
            codeExample = "// Monomorphic optimizasyon örneği:\nclass Kullanici {\n    constructor(id, ad) {\n        this.id = id;\n        this.ad = ad; // Alanlar daima AYNI SIRAYLA eklenir!\n    }\n}\n\nfunction kullaniciOku(k) {\n    return k.id + \": \" + k.ad; // Inline Cache (IC) hızlandırılmış erişim\n}\n\nconst k1 = new Kullanici(1, \"Arda\");\nconst k2 = new Kullanici(2, \"Banu\");\n\nconsole.log(kullaniciOku(k1));\nconsole.log(kullaniciOku(k2));",
            codeExplanation = "Constructor ile alanlar aynı sırayla başlatıldığı için V8 tek bir Hidden Class üretti ve Inline Cache tam verimle çalıştı.",
            realWorldExample = "Node.js yüksek trafikli mikroservislerinde (Fastify vs Express) Fastify'ın 2 kat hızlı olmasının sebebi nesneleri Hidden Class uyumlu şablonlarla üretmesidir.",
            practicalTask = "WeakMap kullanarak DOM referansı temizlendiğinde otomatik bellekten silinen bir önbellek tasarlayın.",
            starterPlaygroundCode = "const wm = new WeakMap();\nlet obj = { a: 1 };\nwm.set(obj, \"Veri\");\nconsole.log(wm.get(obj));",
            miniQuestion = MiniQuestion(
                id = "js_q_12",
                question = "V8 motorunda bir fonksiyonun TurboFan JIT tarafından optimize edilmiş makine kodundan çıkarılıp yavaş yorumlayıcıya (Ignition) geri düşürülmesine ne ad verilir?",
                options = listOf("Garbage Collection", "Deoptimization (Bailout)", "Transpilation", "Memory Leak"),
                correctIndex = 1,
                explanation = "Fonksiyona beklenen tipin dışında farklı bir tip veya bozulmuş Hidden Class gelirse V8 optimizasyonu iptal eder (Deoptimization)."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_12",
                lessonId = "js_12",
                title = "Monomorphic Fabrika Fonksiyonu",
                instructions = "x, y, z koordinatlarını DAİMA aynı sırayla oluşturan ve donduran nokta3DUret(x, y, z) fabrika fonksiyonunu yazın.",
                exampleInput = "nokta3DUret(1, 2, 3)",
                exampleOutput = "{ x: 1, y: 2, z: 3 }",
                starterCode = "function nokta3DUret(x, y, z) {\n    // Kodunu buraya yaz:\n    return null;\n}",
                solutionCode = "function nokta3DUret(x, y, z) {\n    return { x, y, z };\n}",
                hints = listOf("return { x, y, z };"),
                testCases = listOf(
                    TestCase("nokta3DUret(1, 2, 3)", "Object", "Hidden class testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_12_1",
                    lessonId = "js_12",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "JavaScript'te 'WeakMap' veya 'WeakSet' koleksiyonlarının standart Map'ten en kritik farkı nedir?",
                    options = listOf("Daha hızlıdırlar", "Anahtarları zayıf referansla (Weak Reference) tutarlar; anahtar nesne başka hiçbir yerde kullanılmıyorsa Garbage Collector tarafından otomatik temizlenir ve bellek sızıntısı önlenir", "Sadece String tutabilirler", "Döngüyle gezilebilirler"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! WeakMap anahtarları GC'yi engellemez; böylece DOM düğümleri veya geçici nesneler silindiğinde bellekten kendiliğinden uçar.",
                    explanationWrong = "Zayıf referans sayesinde Garbage Collector nesneleri temizleyebilir.",
                    reviewTopic = "WeakMap & Garbage Collection"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "V8'de Generational Garbage Collection nasıl çalışır?",
                    answer = "Bellek Genç Nesil (Young Generation - yeni oluşturulan kısa ömürlü nesneler, Scavenger algoritmasıyla çok hızlı temizlenir) ve Yaşlı Nesil (Old Generation - hayatta kalan uzun ömürlü nesneler, Mark-Sweep-Compact ile temizlenir) olarak ikiye ayrılır."
                )
            ),
            completionCriteria = listOf(
                "Ignition ve TurboFan JIT döngüsünü bilmek",
                "Hidden Classes ve Inline Caching kurallarını kavramak",
                "Deoptimization sebeplerini ve WeakMap ile bellek yönetimini öğrenmek"
            )
        )
    )
}
