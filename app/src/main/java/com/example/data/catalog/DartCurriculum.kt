package com.example.data.catalog

import com.example.model.*

/**
 * Dart Complete Official Curriculum (12 Sequential Lessons):
 * BEGINNER -> FUNDAMENTAL -> INTERMEDIATE -> ADVANCED -> EXPERT
 * Seamless progression from basic syntax to Dart VM & FFI internals.
 */
object DartCurriculum {

    fun getSections(): List<CourseSection> = listOf(
        CourseSection(
            id = "dart_sec_1",
            courseId = "dart",
            title = "Seviye 1 – Dart Temelleri, Sözdizimi & Kontrol Akışı",
            level = CourseLevel.BEGINNER,
            order = 1,
            description = "Dart felsefesi, main(), değişkenler, temel veri tipleri (int, double, String, bool), operatörler, if-else, switch-case ve döngüler.",
            learningObjectives = listOf("Dart programlama ortamı & main()", "var, final, const kavramları", "Koşullu ifadeler (if-else, switch)", "for, while, do-while döngüleri"),
            prerequisites = listOf("Temel bilgisayar kullanım bilgisi")
        ),
        CourseSection(
            id = "dart_sec_2",
            courseId = "dart",
            title = "Seviye 2 – Fonksiyonlar, Koleksiyonlar & Sound Null Safety",
            level = CourseLevel.BEGINNER,
            order = 2,
            description = "Fonksiyon parametreleri (Named/Positional), List, Set, Map veri yapıları, Spread operatörü (...), Collection-if/for ve Sound Null Safety kuralları.",
            learningObjectives = listOf("Fonksiyonlar & Arrow syntax", "List, Set, Map koleksiyonları", "Collection if & for yetenekleri", "Sound Null Safety (?, !., ??, ??=, late)"),
            prerequisites = listOf("Dart Temelleri ve Kontrol Akışı")
        ),
        CourseSection(
            id = "dart_sec_3",
            courseId = "dart",
            title = "Seviye 3 – Nesne Yönelimli Programlama (OOP) & Hata Yönetimi",
            level = CourseLevel.INTERMEDIATE,
            order = 3,
            description = "Sınıflar, Kurucular (Named, Factory, Const), Kapsülleme (Getters/Setters), Kalıtım (extends, super), Soyut Sınıflar, Arayüzler (implements) ve try-catch-finally.",
            learningObjectives = listOf("Class yapısı ve constructor türleri", "Kapsülleme & Özel (private _) alanlar", "Kalıtım, polymorphism ve abstract class", "Hata ve istisna yönetimi (try-catch-finally)"),
            prerequisites = listOf("Dart Fonksiyonlar ve Koleksiyonlar")
        ),
        CourseSection(
            id = "dart_sec_4",
            courseId = "dart",
            title = "Seviye 4 – Modern Dart 3: Mixins, Extensions, Records & Sealed Classes",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            description = "Mixins ('with'), Extension Methods, Dart 3 Records (demetler), Pattern Matching ve Exhaustive Sealed Types.",
            learningObjectives = listOf("Mixins ile çoklu davranış paylaşımı", "Extension Methods ile yardımcı yapılar", "Dart 3 Records ve Destructuring", "Sealed Classes ile derleme zamanı durum kontrolü"),
            prerequisites = listOf("Dart OOP ve Temel Sınıf Mimarisi")
        ),
        CourseSection(
            id = "dart_sec_5",
            courseId = "dart",
            title = "Seviye 5 – Asenkron Programlama, Event Loop & Streams",
            level = CourseLevel.ADVANCED,
            order = 5,
            description = "Tek iş parçacıklı Dart Event Loop, Microtask vs Event Queue, Future API, async/await, Streams, StreamController ve async* jeneratörleri.",
            learningObjectives = listOf("Dart Event Loop kuyruk öncelikleri", "Future API & async/await derinlikleri", "Streams, BroadcastStream ve StreamTransformers", "async* ve yield ile reaktif veri jeneratörleri"),
            prerequisites = listOf("Dart OOP ve Koleksiyonlar")
        ),
        CourseSection(
            id = "dart_sec_6",
            courseId = "dart",
            title = "Seviye 6 – Çok Çekirdekli Paralellik, Dart VM & Native FFI",
            level = CourseLevel.EXPERT,
            order = 6,
            description = "Isolates (Isolate.run, SendPort/ReceivePort), Dart VM Generational GC (Nursery/Old space), Memory Profiling ve dart:ffi ile yerel C/C++ entegrasyonu.",
            learningObjectives = listOf("Isolates ile gerçek CPU paralelliği", "Dart VM Generational Garbage Collector", "Memory Leak tespiti & Retaining Tree", "dart:ffi ile C kütüphanelerini doğrudan çalıştırma"),
            prerequisites = listOf("Asenkron Dart ve İleri Düzey Sistem Mimarisi")
        )
    )

    fun getLessons(): List<Lesson> = listOf(
        // ==========================================
        // DERS 1: TEMEL SÖZDİZİMİ, DEĞİŞKENLER & TİPLER (ÜCRETSİZ)
        // ==========================================
        Lesson(
            id = "dart_1",
            courseId = "dart",
            sectionId = "dart_sec_1",
            title = "Dart Mimarisi, Bellek Modeli & Değişkenler",
            shortDesc = "Dart VM, JIT/AOT derleme hattı, main() giriş noktası, tip çıkarımı, 'Everything is an Object' modeli ve const canonicalization.",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false,
            learningObjectives = listOf(
                "Dart'ın JIT (Just-In-Time) ve AOT (Ahead-Of-Time) çift derleme mimarisini kavramak",
                "Her değerin 'Object' olduğu tekil nesne hiyerarşisi ve bellek temsilini öğrenmek",
                "var, final ve const arasındaki derleme ve çalışma zamanı bellek farklarını (Canonicalization) ayırt etmek",
                "String interpolation ve UTF-16 Runes/CodeUnits ayrımını anlamak"
            ),
            prerequisites = listOf("Ön koşul gerekmez. Temel programlama mantığı yeterlidir."),
            subtopics = listOf("Dart VM, JIT (Hot Reload) & AOT Derleme", "Isolate Tabanlı Tek İş Parçacıklı Çalışma", "Everything is an Object Modeli", "var, final, const & Canonicalization", "Sayısal Tipler (int, double, num) ve Metin Belleği"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Dart Çalışma Zamanı ve Çift Derleme (JIT & AOT) Mimarisi",
                    body = "Dart, istemci taraflı geliştirmede benzersiz bir esneklik sağlamak amacıyla iki farklı derleme modunu destekleyen modern bir dildir:\n\n1. **JIT (Just-In-Time) Modu:** Geliştirme (Debug) aşamasında Dart Sanal Makinesi (Dart VM) üzerinde çalışır. Kaynak kod çalışma anında anlık derlenir; bu sayede Flutter'ın alt-saniyelik 'Stateful Hot Reload' özelliği mümkün kılınır.\n2. **AOT (Ahead-Of-Time) Modu:** Dağıtım (Release) aşamasında Dart kodu doğrudan hedef platformun (ARM64, x86_64) makine koduna (Native Machine Code) dönüştürülür. Bu sayede hiçbir yorumlayıcı (interpreter) veya sanal makine ek yükü olmadan 60/120 FPS akıcı performans ve anında açılış (Fast Startup) elde edilir.\n\nHer bağımsız Dart yürütmesi bir `Isolate` içinde koşar. Isolate'ler kendilerine ait özel bellek alanına (Heap) sahiptir ve paylaşılan bellek (shared state) yerine mesajlaşma ile haberleşir. Bu sayede 'Thread Lock' veya 'Race Condition' tehlikesi sıfıra indirgenir.",
                    codeSnippet = "// Programın giriş noktası (Entry point):\nvoid main(List<String> args) {\n  print('Dart AOT/JIT Çalışma Zamanı Başlatıldı.');\n  print('Argüman Sayısı: \${args.length}');\n}",
                    tip = "Dart'ta ilkel (primitive) tip kavramı yoktur; int, double, bool ve fonksiyonlar dahil her şey 'Object' sınıfının bir alt örneğidir (Heap tahsisli nesne referansı)."
                ),
                LessonContentBlock(
                    subtitle = "2. Tip Sistemi ve Bellek Temsili: int, double, num, String",
                    body = "Dart güçlü ve statik bir tip sistemine (Sound Type System) sahiptir:\n\n• `int`: 64-bit işaretli tamsayılar (-2^63 ile 2^63-1 arası değerler). Web platformunda (dart2js) JavaScript'in 53-bit IEEE float kısıtlamasına uyarlanır.\n• `double`: 64-bit IEEE 754 çift duyarlıklı kayan noktalı sayılar.\n• `num`: Hem int hem double türlerini kapsayan üst polimorfik soyut sınıftır.\n• `String`: UTF-16 kod ünitelerinden (Code Units) oluşan değiştirilemez (immutable) dizilerdir. Unicode emojiler 32-bit olduğunda iki ayrı UTF-16 code unit (surrogate pair) oluşturur; tam karakter iterasyonu için `Runes` kullanılır.\n• `bool`: Yalnızca `true` ve `false` literallerini kabul eder. Sayısal 0 veya boş dize bool yerine geçemez.",
                    codeSnippet = "int sayac = 100;\ndouble oran = 0.85;\nnum genelSayi = 10; // int\ngenelSayi = 12.4;  // double olarak güncellenebilir\n\nString mesaj = 'Flutter & Dart';\n// Runes ile Unicode karakter çözümleme:\nString emoji = '🎯';\nprint(emoji.length); // 2 (UTF-16 code unit)\nprint(emoji.runes.length); // 1 (Gerçek Unicode Glif)"
                ),
                LessonContentBlock(
                    subtitle = "3. var, final ve const: Canonicalization ve Bellek Optimizasyonu",
                    body = "Dart'ta değişken bağlama ve değişmezlik (Immutability) üç anahtar kelime ile yönetilir:\n\n• `var`: Değişkenin tipini ilk atanan değerden çıkarsar (Type Inference) ve kilitler. Değer sonradan değiştirilebilir ancak tipi değiştirilemez.\n• `final`: Çalışma zamanında (runtime) yalnızca bir kez atanabilen tek kullanımlık sabittir (Read-only reference). Nesnenin içeriği değiştirilebilir (mutable) olabilir.\n• `const`: Derleme zamanında (compile-time) mutlak sabitlik gerektirir. Derleyici aynı değere sahip tüm const nesneleri tek bir bellek adresinde birleştirir (**Canonicalization**). Bu optimizasyon Flutter'ın widget ağaçlarını yeniden çizerken bellek tahsisini sıfıra indirir.",
                    codeSnippet = "var sehir = 'Ankara'; // Derleyici String olarak kilitler\nfinal anlikZaman = DateTime.now(); // Çalışma anı sabiti\nconst double yercekimi = 9.80665; // Derleme anı sabiti\n\n// Canonicalization Örneği:\nconst list1 = [1, 2, 3];\nconst list2 = [1, 2, 3];\nprint(identical(list1, list2)); // true! Bellekte aynı bellek işaretçisi (Pointer)",
                    tip = "Flutter'da widget'ların başına 'const' koymak, Flutter motorunun o widget'ı her frame renderında tekrar tekrar oluşturmasını engelleyerek 60/120 FPS akıcılık sağlar."
                )
            ),
            codeExample = "void main() {\n  final String dilAdi = 'Dart';\n  const int surum = 3;\n  double performansPuani = 98.5;\n  bool modernMi = true;\n  \n  print('\$dilAdi \$surum mimarisi - Performans: %\$performansPuani (Modern: \$modernMi)');\n}",
            codeExplanation = "String, int, double ve bool Dart'ın temel ilkel tipleridir. Metin içinde \$islem veya \${islem} ile String Interpolation yapılır.",
            realWorldExample = "Flutter uygulamalarında uygulamanın başlangıç noktası `void main() => runApp(MyApp());` şeklinde Dart main() fonksiyonudur.",
            practicalTask = "Adınızı, yaşınızı ve boyunuzu uygun tiplerde tanımlayıp f-string benzeri String interpolation ile ekrana yazdıran bir Dart kodu yazın.",
            starterPlaygroundCode = "void main() {\n  String ad = 'Ahmet';\n  int yas = 22;\n  print('Adım \$ad, yaşım \$yas.');\n}",
            miniQuestion = MiniQuestion(
                id = "dart_q_1",
                question = "Dart'ta derleme zamanı (compile-time) sabiti tanımlamak ve nesneleri canonicalization (tekil bellek) ile optimize etmek için hangi anahtar kelime kullanılır?",
                options = listOf("final", "const", "static", "let"),
                correctIndex = 1,
                explanation = "const derleme anında sabit değerler için kullanılır ve aynı değere sahip const nesneler tek bir bellek adresinde canonicalize edilir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_dart_1",
                lessonId = "dart_1",
                title = "Öğrenci Bilgi Kartı",
                instructions = "Öğrencinin adını ve notunu alıp 'Ali: 85 Puan' formatında metin döndüren bilgiKarti() fonksiyonunu yazın.",
                exampleInput = "ad = 'Ali', not = 85",
                exampleOutput = "'Ali: 85 Puan'",
                starterCode = "String bilgiKarti(String ad, int notu) {\n  // Kodunu buraya yaz:\n  return '';\n}",
                solutionCode = "String bilgiKarti(String ad, int notu) {\n  return '\$ad: \$notu Puan';\n}",
                hints = listOf("String interpolation (\$ad: \$notu Puan) kullanın."),
                testCases = listOf(
                    TestCase("bilgiKarti('Ali', 85)", "Ali: 85 Puan", "Normal öğrenci kartı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "dart_quiz_1_1",
                    lessonId = "dart_1",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Dart dilinde tüm tiplerin (int, double, bool dahil) türediği en üst temel sınıf hangisidir?",
                    options = listOf("Any", "Object", "Primitive", "dynamic"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Dart'ta her değer Object sınıfının bir alt tipidir.",
                    explanationWrong = "Dart'ta her değer Object sınıfından türer.",
                    reviewTopic = "Dart Tip Sistemi"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "dynamic ile Object? arasındaki fark nedir?",
                    answer = "'dynamic' statik tip kontrolünü tamamen devre dışı bırakır ve hatalar runtime'da NoSuchMethodError olarak patlar. 'Object?' ise her değeri tutabilir ancak metodlarına erişmek için tip kontrolü (is) veya tür dönüşümü (as) zorunludur."
                )
            ),
            completionCriteria = listOf(
                "Dart temel veri tiplerini hatasız tanımlayabilmek",
                "final ve const arasındaki farkı ve canonicalization mantığını bilmek",
                "String interpolation ile dinamik metin oluşturabilmek"
            )
        ),

        // ==========================================
        // DERS 2: OPERATÖRLER, KOŞULLAR & DÖNGÜLER (ÜCRETSİZ)
        // ==========================================
        Lesson(
            id = "dart_2",
            courseId = "dart",
            sectionId = "dart_sec_1",
            title = "Kontrol Akışı, Modern Switch & Pattern Matching",
            shortDesc = "if-else, Ternary (? :), Dart 3 Pattern Matching ve Exhaustive Switch Expressions, for-in, while ve etiketli döngüler.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false,
            learningObjectives = listOf(
                "Dart 3 Pattern Matching ve Exhaustive Switch ifadelerini etkin kullanmak",
                "Ternary ve Null-aware mantıksal kontroller ile temiz koşul blokları yazmak",
                "for, for-in ve while döngüleri ile etiketli (labeled) akış kontrollerini yönetmek"
            ),
            prerequisites = listOf("Dart'a Giriş, Değişkenler & Veri Tipleri"),
            subtopics = listOf("Aritmetik & Mantıksal Operatörler", "Ternary Operator & Guard Clauses", "Dart 3 Switch Expressions & Pattern Matching", "Exhaustiveness Checking (Tüketici Denetim)", "for, for-in & Döngü Etiketleri (Labels)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Karar Yapıları, Ternary ve Guard Clauses",
                    body = "Yazılım algoritmalarında koşullu dallanma (branching) kodun okunabilirliğini doğrudan etkiler. Dart, derin iç içe `if-else` piramitlerini önlemek için Guard Clause desenini ve tek satırlık temiz Ternary operatörlerini destekler.\n\nTernary Sözdizimi: `koşul ? doğruysa_ifade : yanlışsa_ifade`",
                    codeSnippet = "int sinavNotu = 75;\nString durum = (sinavNotu >= 50) ? 'Geçti' : 'Kaldı';\n\n// Guard Clause Kalıbı:\nvoid siparisIsle(int stok, bool odemeAlindi) {\n  if (stok <= 0) return;\n  if (!odemeAlindi) return;\n  print('Sipariş başarıyla paketlendi.');\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Modern Switch Expressions ve Pattern Matching (Dart 3)",
                    body = "Dart 3 ile birlikte switch yapısı sadece bir deyim (statement) olmaktan çıkıp doğrudan değer üreten bir ifadeye (expression) dönüştü. 'break' yazma zorunluluğu kaldırıldı ve derleyici 'Exhaustiveness Checking' yaparak tüm olası durumların (özellikle enum ve sealed class'larda) eksiksiz kapsandığını derleme zamanında garanti altına alır.",
                    codeSnippet = "enum HTTPStatus { ok, notFound, serverError }\n\nString durumMesaji(HTTPStatus status) => switch (status) {\n  HTTPStatus.ok => 'İşlem Başarılı (200)',\n  HTTPStatus.notFound => 'Kaynak Bulunamadı (404)',\n  HTTPStatus.serverError => 'Sunucu Hatası (500)',\n  // Tüm enum durumları yazıldığı için default/wildcard gerekmez!\n};\n\n// Pattern Matching ile Tip ve Aralık Kontrolü:\nString notDegerlendir(int notu) => switch (notu) {\n  >= 90 => 'Harika (AA)',\n  >= 70 && < 90 => 'İyi (BB)',\n  _ => 'Geliştirilmeli'\n};"
                ),
                LessonContentBlock(
                    subtitle = "3. İterasyon ve Döngü Mimarileri (for-in, Labeled Loops)",
                    body = "Dart'ta koleksiyonları gezmek için en güvenli yöntem `for-in` döngüsüdür. `for-in`, arka planda Iterator protokolünü (`moveNext()` ve `current`) çalıştırarak indeks aşımı (IndexOutOfBoundsException) riskini tamamen ortadan kaldırır.\n\nİç içe döngülerde belirli bir dış döngüyü anında kırmak için Dart etiketli döngüleri (Labeled loops) destekler.",
                    codeSnippet = "disDongu: for (int i = 0; i < 5; i++) {\n  for (int j = 0; j < 5; j++) {\n    if (i == 2 && j == 2) {\n      break disDongu; // Doğrudan dıştaki döngüyü kırar!\n    }\n  }\n}"
                )
            ),
            codeExample = "void main() {\n  for (int i = 1; i <= 5; i++) {\n    if (i % 2 == 0) {\n      print('\$i çifttir.');\n    } else {\n      print('\$i tektir.');\n    }\n  }\n}",
            codeExplanation = "for döngüsü 1'den 5'e kadar döner. Mod (%) operatörü ile 2'ye tam bölünenler tespit edilir.",
            realWorldExample = "Kullanıcı arayüzünde liste elemanlarını sıralarken veya sayfalama (pagination) yaparken döngüler ve koşullar kullanılır.",
            practicalTask = "1'den 100'e kadar olan sayılardan 3 ve 5'e tam bölünenleri 'FizzBuzz' olarak yazdıran bir döngü kurun.",
            starterPlaygroundCode = "void main() {\n  for (int i = 1; i <= 10; i++) {\n    print('Sayı: \$i');\n  }\n}",
            miniQuestion = MiniQuestion(
                id = "dart_q_2",
                question = "Dart 3 switch expressions mimarisinde derleyicinin tüm durumların kapsandığını garanti etmesine ne ad verilir?",
                options = listOf("Exhaustiveness Checking", "Type Erasure", "Canonicalization", "Dynamic Dispatch"),
                correctIndex = 0,
                explanation = "Dart 3 derleyicisi switch ifadelerinde enum veya sealed class tiplerinin tüm durumlarını 'Exhaustiveness Checking' ile doğrular."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_dart_2",
                lessonId = "dart_2",
                title = "Çift Sayıların Toplamı",
                instructions = "1'den n'e kadar olan çift sayıların toplamını hesaplayan ciftToplami() fonksiyonunu yazın.",
                exampleInput = "n = 6",
                exampleOutput = "12 (2 + 4 + 6)",
                starterCode = "int ciftToplami(int n) {\n  // Kodunu buraya yaz:\n  return 0;\n}",
                solutionCode = "int ciftToplami(int n) {\n  int top = 0;\n  for (int i = 2; i <= n; i += 2) {\n    top += i;\n  }\n  return top;\n}",
                hints = listOf("Döngüyü i = 2'den başlatıp i += 2 ile artırabilirsiniz."),
                testCases = listOf(
                    TestCase("ciftToplami(6)", "12", "6 için toplam"),
                    TestCase("ciftToplami(10)", "30", "10 için toplam")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "dart_quiz_2_1",
                    lessonId = "dart_2",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "do-while döngüsünün while döngüsünden en temel farkı nedir?",
                    options = listOf("Daha hızlı çalışır", "Koşul yanlış olsa bile gövdesi en az bir kez mutlaka çalışır", "Sadece sayılarla çalışır", "Sonsuz döngüye giremez"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! do-while koşulu sonda kontrol ettiği için kod bloğu en az 1 defa çalışır.",
                    explanationWrong = "do-while bloğu koşul sağlanmasa bile en az 1 kez çalışır.",
                    reviewTopic = "Dart Döngüler"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Dart'ta switch-case ifadelerinde break kullanmak zorunlu mudur?",
                    answer = "Dart 3'ten itibaren boş olmayan case bloklarında otomatik akış (fall-through) yasaklanmıştır; break yazmasanız bile alt case'e geçilmez. Ayrıca Dart 3 ile fonksiyonel switch ifadeleri gelmiştir."
                )
            ),
            completionCriteria = listOf(
                "Ternary operatörü temiz şekilde uygulayabilmek",
                "Dart 3 Switch Expression ve Pattern Matching yapılarını kullanabilmek",
                "for ve while döngüleri ile algoritmik hesaplamalar yapabilmek"
            )
        ),

        // ==========================================
        // DERS 3: FONKSİYONLAR, PARAMETRELER & ARROW SYNTAX
        // ==========================================
        Lesson(
            id = "dart_3",
            courseId = "dart",
            sectionId = "dart_sec_2",
            title = "Fonksiyonlar, Parametre Mimarisi & Closures",
            shortDesc = "First-Class Functions, Named/Positional/Optional parametreler, Default değerler, Arrow (=>) ifadeleri, Anonim Fonksiyonlar ve Lexical Closures.",
            level = CourseLevel.BEGINNER,
            order = 3,
            isPremium = false,
            learningObjectives = listOf(
                "Flutter'ın temelini oluşturan İsimlendirilmiş ({required}) parametre mimarisini kavramak",
                "First-Class Citizen olarak fonksiyon işaretçilerini ve Higher-Order fonksiyonları kullanmak",
                "Lexical Closure (Kapanış) yapısı ile değişken durumunu fonksiyon içinde hapsetmek",
                "Tek satırlık Arrow (=>) ifadelerini doğru sözdizimiyle yazmak"
            ),
            prerequisites = listOf("Dart Operatörler ve Döngüler"),
            subtopics = listOf("First-Class Functions & Function Types", "Named Parameters ({required}) & Positional ([])", "Default Values & Compile-Time Sabitleri", "Arrow Functions (=>) Sınırları", "Anonymous Functions & Closures"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Fonksiyon İmzası ve Parametre Mimarisi",
                    body = "Dart'ta fonksiyonlar 'First-Class Functions' özelliğine sahiptir; yani bir fonksiyona parametre geçilebilir, bir değişkene atanabilir veya başka bir fonksiyondan döndürülebilir.\n\nDart parametreleri iki ana kategoriye ayrılır:\n1. **Konumsal (Positional):** Parametreler sırasıyla gönderilir. Köşeli parantez `[int yas = 18]` ile opsiyonel yapılabilir.\n2. **İsimlendirilmiş (Named):** `{}` süslü parantez ile tanımlanır. Çağrılırken sıra bağımsızdır (`isim: 'Ali'`). `required` anahtar kelimesi ile zorunlu kılınabilir veya varsayılan değer alabilir. Flutter widget kurucularının tamamı bu mimariyi kullanır.",
                    codeSnippet = "typedef FiltreFonksiyonu = bool Function(int sayi);\n\nvoid ogrenciKaydet({\n  required String ad,\n  int yas = 18,\n  String? bolum,\n}) {\n  print('\$ad - Yaş: \$yas - Bölüm: \${bolum ?? \"Genel\"}');\n}\n\n// Çağrılış (Sıra bağımsız):\nogrenciKaydet(bolum: 'Yazılım', ad: 'Zeynep');"
                ),
                LessonContentBlock(
                    subtitle = "2. Arrow Syntax (=>) ve Lexical Closures (Kapanışlar)",
                    body = "• **Arrow Syntax (`=>`):** Tek bir ifadeden (expression) oluşan fonksiyonların gövdesini süslü parantez ve 'return' yazmadan döndürmeyi sağlar. Birden çok ifade veya döngü içeremez.\n• **Lexical Closure:** Bir fonksiyon tanımlandığı kapsamdaki (lexical scope) yerel değişkenleri, dış fonksiyon sonlansa dahi bellek Heap alanında canlı tutar.",
                    codeSnippet = "int topla(int a, int b) => a + b;\n\n// Closure Fabrikası Örneği:\nint Function(int) carpanUret(int carpan) {\n  return (int deger) => deger * carpan; // 'carpan' değişkenini yakalar (Close-over)\n}\n\nfinal ucleCarp = carpanUret(3);\nprint(ucleCarp(10)); // 30",
                    tip = "Arrow fonksiyonlar (=>) yalnızca tek bir satır/ifade içerebilir. İçerisinde if-else blokları veya for döngüleri gibi deyimler (statements) kullanılamaz."
                )
            ),
            codeExample = "int carp(int a, int b) => a * b;\n\nvoid selamVer({required String ad, String unvan = 'Geliştirici'}) {\n  print('Merhaba \$unvan \$ad!');\n}\n\nvoid main() {\n  selamVer(ad: 'Zeynep');\n  print('Çarpım: \${carp(4, 5)}');\n}",
            codeExplanation = "selamVer fonksiyonunda ad zorunlu isimlendirilmiş, unvan ise varsayılan değere sahip isimlendirilmiş parametredir.",
            realWorldExample = "Flutter'daki tüm Widget kurucuları (örn: `Text('Başlık', style: TextStyle(...))`) isimlendirilmiş parametre mimarisine dayanır.",
            practicalTask = "İki sayıyı toplayan, çıkaran ve çarpan 3 ayrı Arrow fonksiyonu tek satırda yazın.",
            starterPlaygroundCode = "int kareAl(int x) => x * x;\nvoid main() {\n  print(kareAl(6));\n}",
            miniQuestion = MiniQuestion(
                id = "dart_q_3",
                question = "Flutter ve Dart'ta parametrelerin çağrılırken isimleriyle belirtilmesini sağlayan sözdizimi hangisidir?",
                options = listOf("[] parantezleri", "{} süslü parantezleri", "() normal parantezler", "<> açılı parantezler"),
                correctIndex = 1,
                explanation = "Fonksiyon parametre listesinde {} kullanıldığında parametreler 'Named Parameters' olur."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_dart_3",
                lessonId = "dart_3",
                title = "İsimlendirilmiş Selamlayıcı",
                instructions = "Zorunlu 'isim' ve opsiyonel 'selam' parametresi (varsayılan 'Merhaba') alan ve '\$selam, \$isim!' döndüren selamla() fonksiyonunu yazın.",
                exampleInput = "isim: 'Murat'",
                exampleOutput = "'Merhaba, Murat!'",
                starterCode = "String selamla({required String isim, String selam = 'Merhaba'}) {\n  // Kodunu buraya yaz:\n  return '';\n}",
                solutionCode = "String selamla({required String isim, String selam = 'Merhaba'}) {\n  return '\$selam, \$isim!';\n}",
                hints = listOf("String interpolation ile birleştirin."),
                testCases = listOf(
                    TestCase("selamla(isim: 'Murat')", "Merhaba, Murat!", "Varsayılan selam"),
                    TestCase("selamla(isim: 'Ece', selam: 'Günaydın')", "Günaydın, Ece!", "Özel selam")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "dart_quiz_3_1",
                    lessonId = "dart_3",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Arrow syntax (=>) aşağıdaki durumlardan hangisinde KULLANILAMAZ?",
                    options = listOf("Tek satırlı bir aritmetik dönüşünde", "İçinde birden fazla deyim (statement/döngü/if bloğu) bulunan fonksiyonlarda", "Getter tanımlarında", "Basit bir print çağrısında"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Arrow (=>) yalnızca tek bir ifade (expression) alabilir, birden fazla statement içeremez.",
                    explanationWrong = "=> yalnızca tek bir ifade içerebilir.",
                    reviewTopic = "Dart Fonksiyonlar"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Dart'ta isimsiz (Anonymous / Lambda) fonksiyon nasıl tanımlanır?",
                    answer = "`var topla = (int a, int b) => a + b;` veya `(item) { print(item); }` şeklinde isimsiz fonksiyonlar bir değişkene atanabilir veya başka fonksiyona parametre geçilebilir."
                )
            ),
            completionCriteria = listOf(
                "Named ve Positional parametreleri doğru kurabilmek",
                "Arrow syntax ile temiz ve kısa fonksiyonlar yazabilmek",
                "Parametrelere varsayılan değerler atayabilmek"
            )
        ),

        // ==========================================
        // DERS 4: KOLEKSİYONLAR, SPREAD & COLLECTION OPERATORS
        // ==========================================
        Lesson(
            id = "dart_4",
            courseId = "dart",
            sectionId = "dart_sec_2",
            title = "Koleksiyonlar (List, Set, Map) & Deklaratif Operatörler",
            shortDesc = "List, Set, Map veri modelleri, Spread (... / ...?), Collection-if/for, Iterable Lazy Evaluation ve Higher-Order fonksiyonlar (where, map, fold).",
            level = CourseLevel.BEGINNER,
            order = 4,
            isPremium = true,
            learningObjectives = listOf(
                "List, Set ve Map koleksiyonlarının bellek organizasyonu ve zaman karmaşıklıklarını (O(1) vs O(N)) öğrenmek",
                "Collection-if, Collection-for ve Null-aware Spread (...?) ile deklaratif UI listeleri oluşturmak",
                "Iterable Lazy Evaluation mantığını kavrayarak performanslı where/map zincirleri kurmak"
            ),
            prerequisites = listOf("Dart Fonksiyonlar"),
            subtopics = listOf("List Mimarisi & Büyüyebilir Diziler", "Set Hash Mimarisi (O(1) Lookup)", "Map (LinkedHashMap) Ekleme Sırası", "Spread (... ve ...?) Operatörleri", "Collection-if ve Collection-for", "Iterable Lazy Evaluation (where, map, fold)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Temel Koleksiyon Türleri: List, Set ve Map",
                    body = "Dart, optimize edilmiş üç ana koleksiyon veri yapısı sunar:\n\n• **List<E>**: Bellekte ardışık (contiguous) dinamik dizidir. İndeks bazlı erişim O(1), başa eleman ekleme O(N), sona amorti edilmiş O(1) maliyetlidir.\n• **Set<E>**: Varsayılan olarak `_CompactLinkedHashSet` (Hash Table) mimarisini kullanır. Elemanların benzersizliğini (Uniqueness) `hashCode` ve `==` üzerinden denetler. Eleman arama (`contains`) O(1) hızındadır.\n• **Map<K, V>**: `_CompactLinkedHashMap` mimarisi ile anahtar-değer çiftlerini saklar. Python 3.7+ sözlükleri gibi varsayılan olarak ekleme sırasını (insertion order) muhafaza eder.",
                    codeSnippet = "List<String> diller = ['Dart', 'Kotlin', 'Dart'];\nSet<int> tekilSayilar = {1, 2, 2, 3}; // Bellekte {1, 2, 3}\nMap<String, double> kurlar = {'USD': 34.5, 'EUR': 37.8};"
                ),
                LessonContentBlock(
                    subtitle = "2. Collection-if, Collection-for ve Null-Aware Spread (...?)",
                    body = "Dart, koleksiyon tanımlarının içine programlama mantığı gömülmesine olanak tanır. Bu özellik Flutter'ın deklaratif widget ağaçlarının omurgasını oluşturur:\n\n• `Collection-if`: Şarta bağlı olarak listeye eleman ekler.\n• `Collection-for`: Başka bir koleksiyonu döngüyle gezip sonuçları mevcut listeye dahil eder.\n• `Spread (...)`: Başka bir koleksiyonun elemanlarını tek tek mevcut koleksiyona yayar (unpacking).\n• `Null-Aware Spread (...?)`: Kaynak liste null olsa dahi çökme üretmez, işlemi sessizce atlar.",
                    codeSnippet = "bool adminMi = true;\nList<String>? ekstraMenuler = ['Sistem Logları', 'Yedekleme'];\n\nvar navigasyonMenusu = [\n  'Ana Sayfa',\n  'Profil',\n  if (adminMi) 'Yönetici Paneli',\n  ...?ekstraMenuler, // Null-safe yayma\n];"
                ),
                LessonContentBlock(
                    subtitle = "3. Iterable Lazy Evaluation ve Metot Zincirleme",
                    body = "Dart'ta `where()`, `map()`, `take()` gibi fonksiyonlar **Tembel Değerlendirme (Lazy Evaluation)** prensibiyle çalışır. Yani siz listeyi tüketene kadar (örneğin `.toList()` çağırana veya `for-in` döngüsüne sokana kadar) hiçbir hesaplama yapılmaz. Bu sayede milyonlarca elemanlık listeler bile minimum CPU ile işlenir.",
                    codeSnippet = "final sayilar = [1, 2, 3, 4, 5, 6, 7, 8];\n\n// Lazy Iterable dönüşümü:\nfinal ciftKareler = sayilar\n    .where((n) => n.isEven)\n    .map((n) => n * n)\n    .toList(); // Somut List Heap tahsisi burada gerçekleşir: [4, 16, 36, 64]"
                )
            ),
            codeExample = "void main() {\n  final sayilar = [1, 2, 3, 4, 5, 6];\n  \n  final ciftKareler = sayilar\n      .where((s) => s.isEven)\n      .map((s) => s * s)\n      .toList();\n      \n  print('Çift sayıların kareleri: \$ciftKareler'); // [4, 16, 36]\n}",
            codeExplanation = "where() çift sayıları filtreler, map() karesini alır, toList() nihai listeyi üretir.",
            realWorldExample = "Flutter BottomNavigationBar sekmelerinde veya dinamik arama listelerinde filtreleme işlemleri doğrudan List.where() ile yapılır.",
            practicalTask = "Bir Map içindeki tüm ürün fiyatlarını toplayıp ortalamasını bulan bir fonksiyon yazın.",
            starterPlaygroundCode = "void main() {\n  final liste = [10, 20, 30];\n  final toplam = liste.fold(0, (acc, val) => acc + val);\n  print('Toplam: \$toplam');\n}",
            miniQuestion = MiniQuestion(
                id = "dart_q_4",
                question = "Dart'ta bir koleksiyondaki tüm elemanları başka bir koleksiyonun içine yaymak (unpack) için hangi operatör kullanılır?",
                options = listOf("...", "->", "::", "&&"),
                correctIndex = 0,
                explanation = "Spread operatörü (...) bir listenin elemanlarını diğerine yayar. Nullable listeler için '...?' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_dart_4",
                lessonId = "dart_4",
                title = "Pozitif Sayıları Filtrele ve İki Katına Çıkar",
                instructions = "Verilen tam sayı listesindeki sadece pozitif (> 0) sayıları seçip iki katını liste olarak döndüren filtreleVeKatla() fonksiyonunu yazın.",
                exampleInput = "[-2, 5, -1, 3, 0]",
                exampleOutput = "[10, 6]",
                starterCode = "List<int> filtreleVeKatla(List<int> sayilar) {\n  // Kodunu buraya yaz:\n  return [];\n}",
                solutionCode = "List<int> filtreleVeKatla(List<int> sayilar) {\n  return sayilar.where((n) => n > 0).map((n) => n * 2).toList();\n}",
                hints = listOf("where() ve map() fonksiyonlarını zincirleyin."),
                testCases = listOf(
                    TestCase("filtreleVeKatla([-2, 5, -1, 3, 0])", "[10, 6]", "Pozitif ve negatifler")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "dart_quiz_4_1",
                    lessonId = "dart_4",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Dart'ta Set koleksiyonunun List koleksiyonundan en temel farkı nedir?",
                    options = listOf("Set sadece String tutabilir", "Set benzersiz (unique) elemanlar tutar ve tekrara izin vermez", "Set sıralı indeks erişimi sağlar", "Set daha yavaştır"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Set matematiksel küme gibidir; aynı elemandan birden fazla barındırmaz.",
                    explanationWrong = "Set elemanların benzersizliğini garanti eder.",
                    reviewTopic = "Dart Koleksiyonlar"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Iterable ile List arasındaki fark nedir?",
                    answer = "Iterable tembeldir (lazy evaluated); elemanlar ancak döngüye girildiğinde üretilir. List ise bellekte tutulan somut dizidir."
                )
            ),
            completionCriteria = listOf(
                "List, Set ve Map koleksiyonlarını doğru yerde kullanabilmek",
                "Collection-if ve Spread operatörlerini uygulayabilmek",
                "Higher-order metodlarla (where, map, fold) veri dönüştürebilmek"
            )
        ),

        // ==========================================
        // DERS 5: SOUND NULL SAFETY & HATA YÖNETİMİ
        // ==========================================
        Lesson(
            id = "dart_5",
            courseId = "dart",
            sectionId = "dart_sec_2",
            title = "Sound Null Safety & Hata Mimarisi",
            shortDesc = "Sound Null Safety tip sistemi, Null-aware operatörleri (?, !., ??, ??=), Flow Analysis/Type Promotion, late ve try-on-catch-finally.",
            level = CourseLevel.BEGINNER,
            order = 5,
            isPremium = true,
            learningObjectives = listOf(
                "Sound Null Safety mantığını ve derleme zamanı tip kanıtlama (Type Proof) mimarisini anlamak",
                "Flow Analysis ve Type Promotion mekanizmalarını doğru yönlendirmek",
                "late anahtar kelimesinin tembel başlatma (Lazy Init) ve tehlikelerini kavramak",
                "try-on-catch-finally ve özel Exception/Error hiyerarşisi oluşturmak"
            ),
            prerequisites = listOf("Dart Değişkenler ve Fonksiyonlar"),
            subtopics = listOf("Sound Null Safety Felsefesi & Milyar Dolarlık Hata", "Nullable (?) vs Non-nullable Tipler", "Flow Analysis & Type Promotion", "Null Coalescing (??) & Null-Assignment (??=)", "late Anahtar Kelimesi & LateInitializationError", "try, on, catch (e, s), finally & Stack Trace"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Sound Null Safety: Derleme Zamanı Tip Güvencesi",
                    body = "Dart, 'Sound Null Safety' mimarisi ile donatılmıştır. 'Soundness' (Sağlamlık), tip sisteminin derleme anında bir değerin null olamayacağını kanıtlaması durumunda, o değerin çalışma zamanında da ASLA null olamayacağını garanti etmesidir.\n\nBu sayede derleyici gereksiz null kontrollerini ikili makine kodundan (AOT) silerek performansı ve kod boyutunu optimize eder.\n\n• `T` (Non-nullable): Asla null değer alamaz (`String ad = 'Ali'`).\n• `T?` (Nullable): Ya ilgili tipte bir nesne ya da `null` referansı tutabilir (`String? soyad = null`).",
                    codeSnippet = "String kesinMetin = 'Dart';\n// kesinMetin = null; // ❌ DERLEME HATASI\n\nString? serbestMetin = null;\n// Null-Coalescing Operatörleri:\nString sonuc = serbestMetin ?? 'Varsayılan';\nserbestMetin ??= 'İlk Değer'; // Sadece null ise ata"
                ),
                LessonContentBlock(
                    subtitle = "2. Flow Analysis, Type Promotion ve 'late' Mekanizması",
                    body = "Dart derleyicisi akıllı bir **Flow Analysis (Akış Analizi)** motoruna sahiptir:\n\n• **Type Promotion:** Bir `if (serbestMetin != null)` kontrolü yapıldığında, derleyici o blok içerisinde değişkenin tipini `String?` tipinden `String` tipine otomatik terfi ettirir.\n• **Bang Operatörü (`!`):** Derleyiciye 'Bu değerin şu an kesinlikle null olmadığını garanti ediyorum' demektir. Eğer nesne çalışma anında null çıkarsa `Null check operator used on a null value` hatası ile uygulama çöker.\n• **late:** Değişkenin ilk erişim anında başlatılacağını ve non-null kalacağını taahhüt eder. Başlatılmadan okunursa `LateInitializationError` fırlatılır.",
                    codeSnippet = "void yazdir(String? girdi) {\n  if (girdi != null) {\n    // Type Promotion sayesinde ?. yazmaya gerek kalmaz:\n    print('Karakter Sayısı: \${girdi.length}');\n  }\n}\n\n// late ile Tembel Başlatma (Lazy Initialization):\nlate final String agirVeri = _veritabanindanYukle();"
                ),
                LessonContentBlock(
                    subtitle = "3. İstisna Yönetimi: Exception vs Error & try-on-catch",
                    body = "Dart'ta çalışma zamanı anomalileri ikiye ayrılır:\n1. **Exception:** Öngörülebilen ve yakalanıp tolere edilmesi gereken durumlardır (örn: `SocketException`, `FormatException`).\n2. **Error:** Programcı hatası veya sistem çöküşüdür, yakalanması değil düzeltilmesi gerekir (örn: `RangeError`, `OutOfMemoryError`).",
                    codeSnippet = "try {\n  int sonuc = 10 ~/ 0; // IntegerDivisionByZeroException\n} on UnsupportedError catch (e) {\n  print('İşlem desteklenmiyor: \$e');\n} catch (e, stackTrace) {\n  print('Bilinmeyen Hata: \$e');\n  print('Hata Yığını:\\n\$stackTrace');\n} finally {\n  print('Veritabanı bağlantısı ve soketler kapatıldı.');\n}"
                )
            ),
            codeExample = "double bolme(int a, int b) {\n  if (b == 0) {\n    throw ArgumentError('Bölen sıfır olamaz!');\n  }\n  return a / b;\n}\n\nvoid main() {\n  try {\n    print(bolme(10, 2));\n    print(bolme(10, 0));\n  } catch (e) {\n    print('Yakalanan Hata: \$e');\n  }\n}",
            codeExplanation = "bolme fonksiyonu b sıfır olduğunda throw ile ArgumentError fırlatır. main() içindeki try-catch bunu güvenle yakalar.",
            realWorldExample = "Mobil uygulamalarda internet kopması veya geçersiz JSON yanıtlarında uygulamanın çökmesini engellemek için try-catch kullanılır.",
            practicalTask = "Parametre olarak gelen String? değerini int'e çeviren (int.tryParse), başarısızsa 0 döndüren güvenli bir fonksiyon yazın.",
            starterPlaygroundCode = "void main() {\n  String? metin = '123';\n  int sayi = int.tryParse(metin ?? '') ?? 0;\n  print('Sayı: \$sayi');\n}",
            miniQuestion = MiniQuestion(
                id = "dart_q_5",
                question = "Dart'ta bir değişkene 'asla null olamaz ve ilk erişildiğinde başlatılacak' garantisi veren anahtar kelime hangisidir?",
                options = listOf("final", "const", "late", "required"),
                correctIndex = 2,
                explanation = "'late' değişkenin ilk kullanım anında başlatılacağını ve non-null olduğunu garanti eder."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_dart_5",
                lessonId = "dart_5",
                title = "Güvenli Sayı Çevirici",
                instructions = "String? tipindeki metni tam sayıya çeviren, metin null veya geçersiz sayı ise varsayılan (defaultVal) değerini döndüren guvenliCevir() fonksiyonunu yazın.",
                exampleInput = "metin = '42', defaultVal = 0",
                exampleOutput = "42",
                starterCode = "int guvenliCevir(String? metin, int defaultVal) {\n  // Kodunu buraya yaz:\n  return 0;\n}",
                solutionCode = "int guvenliCevir(String? metin, int defaultVal) {\n  if (metin == null) return defaultVal;\n  return int.tryParse(metin) ?? defaultVal;\n}",
                hints = listOf("int.tryParse() metodunu ve ?? operatörünü kullanın."),
                testCases = listOf(
                    TestCase("guvenliCevir('42', 0)", "42", "Geçerli sayı"),
                    TestCase("guvenliCevir('abc', 10)", "10", "Geçersiz metin")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "dart_quiz_5_1",
                    lessonId = "dart_5",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Dart Sound Null Safety'de Type Promotion (Tip Terfisi) ne anlama gelir?",
                    options = listOf("Değişkenin double'dan int'e geçmesi", "Derleyicinin if (x != null) kontrolünden sonra x'i otomatik olarak nullable'dan non-nullable tipe terfi ettirmesi", "Tüm nesnelerin dynamic olması", "Değişkenin static yapılması"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Dart derleyicisi null kontrolünü gördüğü kod akışında tipi güvenli tipe otomatik terfi ettirir.",
                    explanationWrong = "Type promotion null kontrolünden sonra tipin otomatik non-nullable olmasını sağlar.",
                    reviewTopic = "Dart Null Safety"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Bang (!) operatörü ne zaman kullanılır?",
                    answer = "Bang (!) operatörü derleyiciye 'bu değişkenin null olmadığını garanti ediyorum' der. Eğer çalışma anında null gelirse program çöker (Null check operator used on a null value), bu yüzden sadece kesin emin olunan durumlarda kullanılmalıdır."
                )
            ),
            completionCriteria = listOf(
                "Null-safety kurallarını eksiksiz uygulayabilmek",
                "try-catch-finally ile istisnaları yakalayabilmek",
                "int.tryParse ve null-coalescing ile güvenli veri dönüşümü yapabilmek"
            )
        ),

        // ==========================================
        // DERS 6: NESNE YÖNELİMLİ PROGRAMLAMA (OOP) TEMELLERİ
        // ==========================================
        Lesson(
            id = "dart_6",
            courseId = "dart",
            sectionId = "dart_sec_3",
            title = "OOP Temelleri: Sınıflar, Kurucular & Kapsülleme",
            shortDesc = "Sınıflar (class), Nesneler, Kurucu Metotlar (Generative, Named, Initializer Lists), Kapsülleme (Private _) ve Getters/Setters.",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true,
            learningObjectives = listOf(
                "Sınıf tanımlamak ve 'this.alan' ile kısa kurucular yazmak",
                "İsimlendirilmiş kurucuları (Named Constructors) kullanmak",
                "Kütüphane düzeyinde gizlilik (private _) ve getter/setter yapılarını uygulamak"
            ),
            prerequisites = listOf("Dart Fonksiyonlar ve Null Safety"),
            subtopics = listOf("Class Tanımı & Alanlar", "this.field Kurucu Sözdizimi", "Named Constructors (İsimlendirilmiş Kurucular)", "Initializer List (:) & Const Constructors", "Kapsülleme (Private _) & Getters/Setters"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Nesne Yönelimli Programlama ve Kurucu Mimarisi",
                    body = "Dart tam anlamıyla saf bir nesne yönelimli (OOP) dildir. Sınıflar (Class), gerçek dünyadaki varlıkların durumlarını (fields/özellikler) ve eylemlerini (methods/davranışlar) modeller.\n\nDart kurucu sözdiziminde `this.alan` kuralı kullanılır. Bu sayede constructor parametresi doğrudan sınıf alanına atanır ve satırlarca `this.ad = ad;` yazma zorunluluğu ortadan kalkar.",
                    codeSnippet = "class Kullanici {\n  final String ad;\n  final int yas;\n\n  // Kısa ve zarif Kurucu (Generative Constructor):\n  Kullanici(this.ad, this.yas);\n\n  // İsimlendirilmiş Kurucu (Named Constructor):\n  Kullanici.anonim() : ad = 'Misafir', yas = 18;\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Kapsülleme (Encapsulation) ve Kütüphane Düzeyinde Gizlilik",
                    body = "Diğer pek çok dilden farklı olarak Dart'ta 'public', 'private', 'protected' gibi anahtar kelimeler yoktur. Bir alanın veya metodun başına alt çizgi `_` konulduğunda, o eleman tanımlandığı dosya/kütüphane (library) dışından tamamen gizlenir.\n\nGetters ve Setters (`get` / `set`) anahtar kelimeleri ile gizli alanlar üzerinde doğrulanmış okuma/yazma erişimi sağlanır.",
                    codeSnippet = "class Cüzdan {\n  double _bakiye = 0.0; // Private alan\n\n  // Getter: Dışarıya kontrollü okuma sunar\n  double get bakiye => _bakiye;\n\n  // Setter: Dışarıdan gelen değeri denetler\n  set bakiye(double yeniDeger) {\n    if (yeniDeger >= 0) _bakiye = yeniDeger;\n  }\n}",
                    tip = "Dart felsefesinde (Effective Dart) salt alan erişimi için gereksiz getter/setter yazılmaz; direkt public alan kullanılır. Yalnızca hesaplama veya doğrulama gerektiğinde get/set'e dönüştürülür."
                )
            ),
            codeExample = "class BankaHesabi {\n  final String hesapNo;\n  double _bakiye = 0.0; // Private alan\n\n  BankaHesabi(this.hesapNo, [double ilkBakiye = 0.0]) {\n    if (ilkBakiye > 0) _bakiye = ilkBakiye;\n  }\n\n  double get bakiye => _bakiye;\n\n  void paraYatir(double miktar) {\n    if (miktar > 0) _bakiye += miktar;\n  }\n}\n\nvoid main() {\n  final hesap = BankaHesabi('TR1001', 500.0);\n  hesap.paraYatir(250.0);\n  print('Hesap Bakiyesi: \${hesap.bakiye} TL');\n}",
            codeExplanation = "_bakiye alanı dışarıdan doğrudan değiştirilemez, yalnızca paraYatir metodu üzerinden güvenle güncellenir ve bakiye getter'ı ile okunur.",
            realWorldExample = "Flutter'daki tüm State ve Model sınıfları kapsülleme ve kurucu sözdizimi ilkelerine göre tasarlanır.",
            practicalTask = "Genişlik ve yükseklik alanları olan, 'alan' getter'ı ile dikdörtgenin alanını hesaplayan bir Dikdortgen sınıfı yazın.",
            starterPlaygroundCode = "class Araba {\n  String marka;\n  int modelYili;\n  Araba(this.marka, this.modelYili);\n}\nvoid main() {\n  var a = Araba('Toyota', 2022);\n  print(a.marka);\n}",
            miniQuestion = MiniQuestion(
                id = "dart_q_6",
                question = "Dart dilinde bir değişkeni veya metodu dosya dışına gizlemek (private yapmak) için ne yapılır?",
                options = listOf("Başına 'private' yazılır", "Başına alt çizgi (_) eklenir", "Başına '#' eklenir", "'hidden' anahtar kelimesi kullanılır"),
                correctIndex = 1,
                explanation = "Dart'ta alt çizgi (_) ile başlayan tüm tanımlayıcılar tanımlandıkları kütüphaneye özel (library-private) olur."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_dart_6",
                lessonId = "dart_6",
                title = "Öğrenci Sınıfı ve Ortalama Getter'ı",
                instructions = "String ad ve List<int> notlar alan bir Ogrenci sınıfı oluşturun. 'ortalama' isimli bir double getter ile notların aritmetik ortalamasını döndürün (not yoksa 0.0).",
                exampleInput = "Ogrenci('Ali', [80, 90, 100])",
                exampleOutput = "90.0",
                starterCode = "class Ogrenci {\n  final String ad;\n  final List<int> notlar;\n  Ogrenci(this.ad, this.notlar);\n  \n  // ortalama getter'ını buraya yaz:\n}",
                solutionCode = "class Ogrenci {\n  final String ad;\n  final List<int> notlar;\n  Ogrenci(this.ad, this.notlar);\n  \n  double get ortalama {\n    if (notlar.isEmpty) return 0.0;\n    return notlar.reduce((a, b) => a + b) / notlar.length;\n  }\n}",
                hints = listOf("notlar.reduce() veya fold() ile toplayıp notlar.length'e bölün."),
                testCases = listOf(
                    TestCase("Ogrenci('Ali', [80, 90, 100]).ortalama", "90.0", "3 not ortalaması")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "dart_quiz_6_1",
                    lessonId = "dart_6",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Dart kurucularında iki nokta (:) ile başlayan Initializer List bloğu ne zaman çalışır?",
                    options = listOf("Kurucu gövdesinden ({}) hemen önce", "Program sona ererken", "Sadece hata oluştuğunda", "Garbage Collector çalışırken"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Initializer List, sınıf alanlarını kurucu gövdesi çalışmadan hemen önce başlatır.",
                    explanationWrong = "Initializer list kurucu gövdesinden önce alanları başlatır.",
                    reviewTopic = "Dart Constructors"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Const constructor ne zaman yazılabilir?",
                    answer = "Bir sınıfın tüm alanları 'final' ise ve derleme zamanında değişmez sabit nesneler üretilmesi isteniyorsa kurucunun başına 'const' eklenebilir."
                )
            ),
            completionCriteria = listOf(
                "Sınıflar ve isimlendirilmiş kurucular tanımlayabilmek",
                "Private (_) değişkenler ve getter/setter ile kapsülleme yapabilmek",
                "Const constructor kavramını uygulayabilmek"
            )
        ),

        // ==========================================
        // DERS 7: İLERİ OOP, KALITIM & MIXINS
        // ==========================================
        Lesson(
            id = "dart_7",
            courseId = "dart",
            sectionId = "dart_sec_3",
            title = "Kalıtım, Soyut Sınıflar & Mixins ('with')",
            shortDesc = "Kalıtım (extends, super), Metot Ezme (@override), Soyut Sınıflar (abstract), Arayüzler (implements) ve Mixins ile çoklu yetenek enjeksiyonu.",
            level = CourseLevel.INTERMEDIATE,
            order = 7,
            isPremium = true,
            learningObjectives = listOf(
                "Kalıtım zinciri kurup 'super' ile üst sınıf kurucularını çağırmak",
                "Soyut sınıflar (abstract class) ile kontrat tanımlamak",
                "Mixins ('with') kullanarak çoklu davranış paylaşımı sağlamak"
            ),
            prerequisites = listOf("OOP Temelleri: Sınıflar ve Kurucular"),
            subtopics = listOf("extends & super ile Kalıtım", "@override Anotasyonu & Polimorfizm", "abstract class & Kontrat Tasarımı", "implements & Implicit Interfaces", "Mixins ('with') ile Davranış Enjeksiyonu", "on Kısıtlaması (mixin on Base)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Kalıtım (Inheritance) ve Soyut Sınıflar (Abstract Classes)",
                    body = "Dart tekli kalıtım modelini (single class inheritance) benimser. Bir sınıf yalnızca bir üst sınıftan `extends` edebilir. Üst sınıfın kurucusuna parametre iletmek için `super(parametreler)` kullanılır.\n\nSoyut sınıflar (`abstract class`), doğrudan nesnesi üretilemeyen ancak alt sınıflara rehberlik eden kontratlardır. İçerisinde gövdesiz (abstract) metotlar tanımlanabilir.",
                    codeSnippet = "abstract class Sekil {\n  // Gövdesiz soyut metot:\n  double alanHesapla();\n}\n\nclass Kare extends Sekil {\n  final double kenar;\n  Kare(this.kenar);\n\n  @override\n  double alanHesapla() => kenar * kenar;\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Mixin Mimarisi: Çoklu Kalıtımın Zarif Çözümü",
                    body = "Geleneksel dillerdeki çoklu kalıtım (multiple inheritance) 'Diamond Problem' gibi mimari krizlere yol açar. Dart bu sorunu 'Mixin' ile çözer.\n\nMixin'ler bağımsız yetenek paketleridir (`mixin Logger`). Bir sınıfa `with` anahtar kelimesi ile tek veya virgülle ayrılarak birden fazla mixin eklenebilir (`class Servis with Logger, Cacheable`).",
                    codeSnippet = "mixin Logger {\n  void log(String mesaj) => print('[LOG \${DateTime.now()}]: \$mesaj');\n}\n\nclass AgServisi with Logger {\n  void istekAt(String url) {\n    log('\$url adresine istek gönderiliyor...');\n  }\n}",
                    tip = "Eğer bir mixin'in yalnızca belirli bir sınıfın alt sınıflarında kullanılmasını istiyorsanız 'mixin MyMixin on BaseClass' sözdizimi ile sınırlandırabilirsiniz."
                )
            ),
            codeExample = "abstract class Hayvan {\n  final String isim;\n  Hayvan(this.isim);\n  void sesCikar();\n}\n\nmixin Ucabilen {\n  void uc() => print('Gökyüzünde süzülüyor... 🦅');\n}\n\nclass Kartal extends Hayvan with Ucabilen {\n  Kartal(String isim) : super(isim);\n  @override\n  void sesCikar() => print('\$isim: Çığlık atıyor!');\n}\n\nvoid main() {\n  final k = Kartal('Şahin');\n  k.sesCikar();\n  k.uc();\n}",
            codeExplanation = "Kartal sınıfı Hayvan'dan kalıtım alır ve Ucabilen mixin'i ile uçma yeteneğini bünyesine katar.",
            realWorldExample = "Flutter'da `SingleTickerProviderStateMixin` animasyon controller'larına tick yeteneği kazandırmak için kullanılan bir mixin'dir.",
            practicalTask = "JsonSerializable adında bir mixin yazarak toMap() metodunu sınıflara kazandırın.",
            starterPlaygroundCode = "mixin Hizli {\n  void kos() => print('Hızlı koşuyor!');\n}\nclass Atlet with Hizli {}\nvoid main() {\n  Atlet().kos();\n}",
            miniQuestion = MiniQuestion(
                id = "dart_q_7",
                question = "Dart'ta bir sınıfa birden fazla mixin yeteneği eklemek için hangi anahtar kelime kullanılır?",
                options = listOf("extends", "implements", "with", "using"),
                correctIndex = 2,
                explanation = "Dart'ta mixin'ler 'with' anahtar kelimesi ile sınıfa eklenir (örn: class A with B, C)."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_dart_7",
                lessonId = "dart_7",
                title = "Geometrik Çok Biçimlilik",
                instructions = "Soyut Sekil sınıfını kalıtım alan ve alanHesapla() metodunu ezen Daire(double r) sınıfını yazın (Pi = 3.14).",
                exampleInput = "Daire(10)",
                exampleOutput = "314.0",
                starterCode = "abstract class Sekil {\n  double alanHesapla();\n}\n\nclass Daire extends Sekil {\n  final double r;\n  Daire(this.r);\n  // Metodu buraya yaz:\n}",
                solutionCode = "abstract class Sekil {\n  double alanHesapla();\n}\n\nclass Daire extends Sekil {\n  final double r;\n  Daire(this.r);\n  @override\n  double alanHesapla() => 3.14 * r * r;\n}",
                hints = listOf("3.14 * r * r formülünü kullanın."),
                testCases = listOf(
                    TestCase("Daire(10).alanHesapla()", "314.0", "Yarıçap 10 için alan")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "dart_quiz_7_1",
                    lessonId = "dart_7",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Dart'ta bir mixin'in sadece belirli bir sınıfın alt sınıflarında kullanılabilmesini sınırlandırmak için hangi anahtar kelime kullanılır?",
                    options = listOf("on", "extends", "implements", "where"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! 'mixin MyMixin on BaseClass' sözdizimi mixin'in uygulanabileceği sınıf tipini sınırlandırır.",
                    explanationWrong = "'on' anahtar kelimesi kullanılır.",
                    reviewTopic = "Dart Mixins"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "implements ile extends arasındaki fark nedir?",
                    answer = "'extends' sınıfın kodunu ve davranışını doğrudan miras alır. 'implements' ise o sınıfı sadece bir arayüz (interface) olarak görür; tüm metot ve alanlarını sıfırdan yeniden yazmanızı zorunlu kılar."
                )
            ),
            completionCriteria = listOf(
                "Kalıtım ve soyut sınıflarla hiyerarşi tasarlayabilmek",
                "Mixins ('with') ile yetenek paylaşımı yapabilmek",
                "@override anotasyonunu doğru kullanabilmek"
            )
        ),

        // ==========================================
        // DERS 8: DART 3 RECORDS, PATTERNS & SEALED CLASSES
        // ==========================================
        Lesson(
            id = "dart_8",
            courseId = "dart",
            sectionId = "dart_sec_4",
            title = "Dart 3 Records, Patterns & Sealed Classes",
            shortDesc = "Dart 3 devrimi: Records (Tuple), Pattern Matching, Switch İfadeleri, Destructuring ve Exhaustive Sealed Types.",
            level = CourseLevel.INTERMEDIATE,
            order = 8,
            isPremium = true,
            learningObjectives = listOf(
                "Records kullanarak hafif veri demetleri (tuple) oluşturmak",
                "Pattern matching ve destructuring sözdizimini kavramak",
                "Sealed class hiyerarşileri ile derleme zamanı durum kontrolü (Exhaustive Switch) sağlamak"
            ),
            prerequisites = listOf("Kalıtım, Soyut Sınıflar & Mixins"),
            subtopics = listOf("Dart 3 Records & Tuples", "Object Destructuring", "Pattern Matching in Switch", "Sealed Classes & Exhaustive Matching", "Class Modifiers (final, base, interface, sealed)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Dart 3 Records: Hafif ve Tip Güvenli Veri Demetleri",
                    body = "Dart 3 öncesinde bir fonksiyondan 2 veya 3 değer döndürmek için özel bir sınıf yazmak veya tip güvenliği zayıf List/Map yapılarına başvurmak gerekiyordu. Records ile parantez içinde virgülle ayrılmış hafif ve değişmez (immutable) veri grupları tanımlanabilir.",
                    codeSnippet = "(String, int, {bool aktif}) kullaniciBilgisi() {\n  return ('Deniz', 28, aktif: true);\n}\n\n// Çağrılış ve Destructuring (Parçalama):\nfinal (isim, yas, :aktif) = kullaniciBilgisi();\nprint('\$isim - \$yas - Aktif: \$aktif');"
                ),
                LessonContentBlock(
                    subtitle = "2. Sealed Classes ve Kapsamlı (Exhaustive) Pattern Matching",
                    body = "Dart 3'ün en devrimci özelliği `sealed` sınıf hiyerarşisidir. Bir sınıf `sealed` olarak tanımlandığında, tüm alt sınıflarının aynı dosyada yer alması zorunludur.\n\nBu sayede derleyici tüm olası durumları bilir. Bir `switch` ifadesinde alt sınıfların tümü kontrol edildiğinde 'default' satırına gerek kalmaz; gelecekte yeni bir alt sınıf eklendiğinde derleyici tüm switch'lerde derleme hatası vererek unuttuğunuz noktaları anında bildirir.",
                    codeSnippet = "sealed class AgDurumu {}\nclass Yukleniyor extends AgDurumu {}\nclass Basarili extends AgDurumu { final String veri; Basarili(this.veri); }\nclass Hata extends AgDurumu { final String mesaj; Hata(this.mesaj); }\n\n// Switch İfadesi (Expression):\nString durumuGoster(AgDurumu durum) => switch (durum) {\n  Yukleniyor() => 'Yükleniyor... ⏳',\n  Basarili(:final veri) => 'Gelen Veri: \$veri ✅',\n  Hata(:final mesaj) => 'Hata: \$mesaj ❌',\n};",
                    tip = "Flutter Bloc, Riverpod ve modern UI mimarilerinde State modellemesi için Sealed Sınıflar mutlak endüstri standardıdır."
                )
            ),
            codeExample = "sealed class UiDurum {}\nclass Yukleniyor extends UiDurum {}\nclass Basarili extends UiDurum { final String veri; Basarili(this.veri); }\nclass Hata extends UiDurum { final String mesaj; Hata(this.mesaj); }\n\nString durumuYazdir(UiDurum durum) => switch (durum) {\n  Yukleniyor() => 'Yükleniyor... ⏳',\n  Basarili(:final veri) => 'Veri Geldi: \$veri ✅',\n  Hata(:final mesaj) => 'Hata Oluştu: \$mesaj ❌',\n};\n\nvoid main() {\n  print(durumuYazdir(Basarili('Kullanıcı Listesi')));\n}",
            codeExplanation = "switch ifadesi tüm alt sınıfları kapsadığı için derleyici eksik durum kalmadığını derleme zamanında garanti eder.",
            realWorldExample = "Modern Flutter mimarilerinde Ağ isteklerinin (Loading, Success, Failure) durum yönetimi Dart 3 Sealed Sınıfları ve Pattern Matching ile kurulur.",
            practicalTask = "Geometrik şekilleri (Daire, Dikdörtgen) sealed class olarak modelleyin ve switch ifadesiyle alanlarını hesaplayın.",
            starterPlaygroundCode = "void main() {\n  final (x, y) = (10, 20);\n  print('x: \$x, y: \$y');\n}",
            miniQuestion = MiniQuestion(
                id = "dart_q_8",
                question = "Sealed sınıflarla yazılan bir switch ifadesinde tüm alt durumlar ele alınmazsa ne gerçekleşir?",
                options = listOf("Çalışma anında null döner", "Derleme zamanı hatası (non-exhaustive switch) verir", "Otomatik log basılır", "Son case varsayılan kabul edilir"),
                correctIndex = 1,
                explanation = "Sealed sınıflar 'exhaustiveness checking' uygular; eksik alt durum derleme anında yakalanır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_dart_8",
                lessonId = "dart_8",
                title = "Record ile Min ve Max Bulma",
                instructions = "Verilen tam sayı listesinin minimum ve maksimum değerini (min, max) Record olarak döndüren minMaxBul() fonksiyonunu yazın.",
                exampleInput = "[5, 12, 1, 9, 30]",
                exampleOutput = "(1, 30)",
                starterCode = "(int, int) minMaxBul(List<int> liste) {\n  // Kodunu buraya yaz:\n  return (0, 0);\n}",
                solutionCode = "(int, int) minMaxBul(List<int> liste) {\n  int minVal = liste.reduce((a, b) => a < b ? a : b);\n  int maxVal = liste.reduce((a, b) => a > b ? a : b);\n  return (minVal, maxVal);\n}",
                hints = listOf("Record döndürmek için (minVal, maxVal) sözdizimini kullanın."),
                testCases = listOf(
                    TestCase("minMaxBul([5, 12, 1, 9, 30])", "(1, 30)", "Karışık liste")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "dart_quiz_8_1",
                    lessonId = "dart_8",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Dart 3'te bir sınıfın dış kütüphaneler tarafından 'extend' edilmesini engelleyip sadece 'implement' edilmesine izin veren modifiye edici hangisidir?",
                    options = listOf("sealed", "interface class", "base class", "final class"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! 'interface class' sınıfın miras alınmasını (extends) engeller, sadece arayüz olarak uygulanmasına (implements) izin verir.",
                    explanationWrong = "interface class kullanılmalıdır.",
                    reviewTopic = "Dart 3 Class Modifiers"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Dart 3 class modifiers (final, base, interface, sealed) ne avantaj sağlar?",
                    answer = "API geliştiricilerinin sınıflarının nasıl tüketileceğini (kalıtım vs implementasyon) katı derleme kurallarıyla sınırlandırmasını ve API güvenliğini garanti etmesini sağlar."
                )
            ),
            completionCriteria = listOf(
                "Records ile çoklu değer döndürüp destructure edebilmek",
                "Pattern matching ile switch ifadeleri yazabilmek",
                "Sealed class ile hatasız durum modellemesi yapabilmek"
            )
        ),

        // ==========================================
        // DERS 9: ASENKRON DART: EVENT LOOP, FUTURES & ASYNC/AWAIT
        // ==========================================
        Lesson(
            id = "dart_9",
            courseId = "dart",
            sectionId = "dart_sec_5",
            title = "Dart Event Loop, Microtasks & Futures",
            shortDesc = "Dart tek iş parçacıklı yürütme motoru: Microtask Queue, Event Queue, Future API, async/await ve Future.wait.",
            level = CourseLevel.ADVANCED,
            order = 9,
            isPremium = true,
            learningObjectives = listOf(
                "Dart Event Loop mimarisini ve iki ana kuyruğu (Microtask vs Event Queue) kavramak",
                "Future, async ve await anahtar kelimelerinin altında yatan mekanizmayı öğrenmek",
                "Future.wait ile paralel asenkron I/O istekleri yönetmek"
            ),
            prerequisites = listOf("Dart OOP ve Records"),
            subtopics = listOf("Single-Threaded Model & Concurrency", "Microtask Queue (Öncelikli Kuyruk)", "Event Queue (Olay Kuyruğu)", "Future API & async/await Mekanizması", "Future.wait & Future.any Orkestrasyonu"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Dart'ın Tek İş Parçacıklı (Single-Threaded) Event Loop Mimarisi",
                    body = "Dart, JavaScript ve Node.js gibi 'Single-Threaded Event Loop' mimarisiyle çalışır. Yani ana kod akışı tek bir thread üzerinde kesintisiz çalışır; eşzamanlılık (concurrency) işleri iki ayrı kuyruk vasıtasıyla organize edilir:\n\n1. Microtask Queue: En yüksek önceliğe sahiptir. Bu kuyrukta bekleyen tüm mikro işler tamamlanmadan Event Queue'ya asla geçilmez.\n2. Event Queue: Ağ istekleri, dosya okuma/yazma (I/O), ekran tıklamaları, animasyon tetikleyicileri ve standart `Future` nesneleri bu kuyruğa yerleşir.",
                    codeSnippet = "import 'dart:async';\n\nscheduleMicrotask(() => print('1. Microtask (Mutlak Öncelik)'));\nFuture(() => print('2. Event Queue (Normal Öncelik)'));"
                ),
                LessonContentBlock(
                    subtitle = "2. async/await Aslında Ne Yapar?",
                    body = "Bir fonksiyona `async` yazmak yeni bir thread başlatmaz! Sadece fonksiyonun bir `Future` döndüreceğini ve içinde `await` kullanılabileceğini belirtir.\n\n`await` ifadesine gelindiğinde, fonksiyonun çalışması dondurulur ve Event Loop'un diğer işleri yürütmesine izin verilir. İlgili Future tamamlandığında fonksiyonun geri kalan kısmı bir callback gibi Event Loop kuyruğuna geri eklenerek devam eder.",
                    tip = "UI donmalarının asıl sebebi ağ çağrıları değil, ana thread üzerinde koşturulan ağır senkron hesaplama döngüleridir (örn: 100 bin satırlık for döngüsü)."
                )
            ),
            codeExample = "import 'dart:async';\n\nvoid main() {\n  print('A: Senkron Başlangıç');\n  \n  Future(() => print('B: Event Queue'));\n  \n  scheduleMicrotask(() => print('C: Microtask'));\n  \n  print('D: Senkron Bitiş');\n  // Çıktı Sırası: A -> D -> C -> B\n}",
            codeExplanation = "A ve D ana yürütme hattında derhal çalışır. Ardından Microtask (C) öncelikli olarak tamamlanır. En son Event Queue'daki Future (B) işlenir.",
            realWorldExample = "Flutter render motoru animasyon frame'lerini Event Loop üzerinde işler; Microtask kuyruğunu gereksiz doldurmak 60/120 FPS akıcılığını bozar.",
            practicalTask = "Birden fazla API isteğini paralel başlatan ve hepsi tamamlandığında sonuçları birleştiren Future.wait yapısı kurun.",
            starterPlaygroundCode = "void main() async {\n  print('Başladı');\n  await Future.delayed(Duration(milliseconds: 100));\n  print('Bitti');\n}",
            miniQuestion = MiniQuestion(
                id = "dart_q_9",
                question = "Dart Event Loop döngüsünde Microtask Queue ile Event Queue arasındaki öncelik ilişkisi nasıldır?",
                options = listOf("Event Queue daha önceliklidir", "Her zaman Microtask Queue boşalana kadar Event Queue'dan yeni olay işlenmez", "İkisi rastgele sırayla işlenir", "Timer'lar her zaman önce çalışır"),
                correctIndex = 1,
                explanation = "Dart Event Loop'ta Microtask kuyruğu mutlak önceliğe sahiptir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_dart_9",
                lessonId = "dart_9",
                title = "Paralel Asenkron İstekleri Birleştir",
                instructions = "Future.wait kullanarak iki asenkron metnin sonucunu aralarında boşlukla birleştiren birlestir() fonksiyonunu yazın.",
                exampleInput = "f1 = 'Merhaba', f2 = 'Dünya'",
                exampleOutput = "'Merhaba Dünya'",
                starterCode = "Future<String> birlestir(Future<String> f1, Future<String> f2) async {\n  // Kodunu buraya yaz:\n  return '';\n}",
                solutionCode = "Future<String> birlestir(Future<String> f1, Future<String> f2) async {\n  final sonuclar = await Future.wait([f1, f2]);\n  return sonuclar.join(' ');\n}",
                hints = listOf("Future.wait([f1, f2]) kullanın."),
                testCases = listOf(
                    TestCase("birlestir", "Merhaba Dünya", "Paralel Future")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "dart_quiz_9_1",
                    lessonId = "dart_9",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir Future'ın sonucunu beklemeden arka planda tetikleyip linter uyarısını engellemek için kullanılan fonksiyon hangisidir?",
                    options = listOf("unawaited()", "ignore()", "background()", "detach()"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! 'unawaited(future)' bilerek beklenmeyen Future'ları açıkça belirtmek için kullanılır.",
                    explanationWrong = "unawaited() fonksiyonu kullanılır.",
                    reviewTopic = "Dart Futures"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Ağır bir JSON parse işlemi async bir fonksiyon içinde yapılırsa neden ekran donabilir?",
                    answer = "Çünkü async fonksiyonlar ayrı bir thread açmaz, aynı Event Loop thread'inde senkron çalışır. Ağır CPU hesaplamaları Isolate'e devredilmelidir."
                )
            ),
            completionCriteria = listOf(
                "Event Loop ve Microtask kuyruk mantığını açıklayabilmek",
                "Future.wait ile paralel I/O orkestrasyonu yapabilmek",
                "UI bloklayan senkron kodları tespit edebilmek"
            )
        ),

        // ==========================================
        // DERS 10: STREAMS, STREAMCONTROLLER & ASYNC*
        // ==========================================
        Lesson(
            id = "dart_10",
            courseId = "dart",
            sectionId = "dart_sec_5",
            title = "Reaktif Veri Akışları (Streams & async*)",
            shortDesc = "Zamana yayılmış veri akışları (Stream), Single-subscription vs Broadcast, StreamController, StreamTransformer ve async* jeneratörleri.",
            level = CourseLevel.ADVANCED,
            order = 10,
            isPremium = true,
            learningObjectives = listOf(
                "Single-subscription ve Broadcast Stream farklarını öğrenmek",
                "async* ve yield ile reaktif veri jeneratörleri yazmak",
                "StreamController ile özel olay yayıncıları inşa etmek"
            ),
            prerequisites = listOf("Dart Event Loop & Futures"),
            subtopics = listOf("Streams & async* Jeneratörleri", "StreamController & Sink Mimarisi", "Single-subscription vs Broadcast Streams", "StreamTransformer ile Veri İşleme", "await for ile Akış Tüketimi"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Streams: Zamana Yayılmış Olay Boru Hattı",
                    body = "Bir `Future` gelecekte tek bir değer üretip kapanırken, `Stream` zaman içinde ardışık olarak birden çok veri, hata veya tamamlanma sinyali aktaran reaktif boru hattıdır.\n\n`async*` anahtar kelimesi ile işaretlenen fonksiyonlar Stream üreticileridir. `yield` ifadesi, hesaplanan her yeni değeri derhal akışa fırlatır.",
                    codeSnippet = "Stream<int> geriSayim(int baslangic) async* {\n  for (int i = baslangic; i >= 0; i--) {\n    await Future.delayed(Duration(seconds: 1));\n    yield i; // Her saniye yeni sayıyı yayar\n  }\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. StreamController ve Broadcast Farkı",
                    body = "• Single-Subscription Stream: Varsayılan tiptir; sadece tek bir dinleyici (listener) abone olabilir. İkinci bir dinleyici bağlanırsa çalışma zamanı hatası fırlatır (Örn: Dosya okuma akışı).\n• Broadcast Stream: `StreamController.broadcast()` ile oluşturulur; aynı anda sınırsız sayıda bağımsız dinleyici akışı dinleyebilir (Örn: Canlı borsa fiyatları, bildirimler).",
                    codeSnippet = "final controller = StreamController<String>.broadcast();\n\n// Dinleyiciler:\ncontroller.stream.listen((v) => print('UI Dinleyicisi: \$v'));\ncontroller.stream.listen((v) => print('Log Dinleyicisi: \$v'));\n\n// Veri basma (Sink):\ncontroller.sink.add('Yeni Mesaj Geldi!');",
                    tip = "Controller nesnesiyle işiniz bittiğinde mutlaka `controller.close()` çağrılmalıdır; aksi takdirde açık kalan abonelikler bellek sızıntısına (Memory Leak) sebep olur."
                )
            ),
            codeExample = "import 'dart:async';\n\nvoid main() async {\n  final controller = StreamController<String>.broadcast();\n  \n  controller.stream.listen((veri) => print('Dinleyici 1: \$veri'));\n  controller.stream.listen((veri) => print('Dinleyici 2: \$veri'));\n  \n  controller.add('Canlı Borsa Fiyatı: 100 TL');\n  controller.add('Canlı Borsa Fiyatı: 105 TL');\n  \n  await controller.close();\n}",
            codeExplanation = "Broadcast Stream Controller oluşturularak birden çok dinleyicinin aynı anda akıştan haberdar olması sağlandı.",
            realWorldExample = "Flutter'da Firebase Firestore gerçek zamanlı veritabanı dinleyicileri (snapshots()) Stream mimarisi üzerinde çalışır.",
            practicalTask = "1'den 10'a kadar olan sayıları her 500ms'de bir yield eden bir async* jeneratör fonksiyonu yazın.",
            starterPlaygroundCode = "void main() async {\n  final stream = Stream.fromIterable([10, 20, 30]);\n  await for (var val in stream) {\n    print('Gelen: \$val');\n  }\n}",
            miniQuestion = MiniQuestion(
                id = "dart_q_10",
                question = "Birden çok dinleyicinin (listener) aynı anda dinleyebilmesi için hangi tür Stream kullanılmalıdır?",
                options = listOf("Single-subscription Stream", "Broadcast Stream", "Buffered Stream", "Synchronous Stream"),
                correctIndex = 1,
                explanation = "Broadcast Stream birden çok aboneyi aynı anda destekler."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_dart_10",
                lessonId = "dart_10",
                title = "async* ile Çift Sayı Akışı",
                instructions = "1'den n'e kadar olan çift sayıları yield eden ciftSayiAkisi(int n) fonksiyonunu yazın.",
                exampleInput = "n = 6",
                exampleOutput = "[2, 4, 6]",
                starterCode = "Stream<int> ciftSayiAkisi(int n) async* {\n  // Kodunu buraya yaz:\n}",
                solutionCode = "Stream<int> ciftSayiAkisi(int n) async* {\n  for (int i = 1; i <= n; i++) {\n    if (i % 2 == 0) yield i;\n  }\n}",
                hints = listOf("async* fonksiyonu içinde 'yield' kullanın."),
                testCases = listOf(
                    TestCase("ciftSayiAkisi(6)", "2, 4, 6", "Çift sayılar")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "dart_quiz_10_1",
                    lessonId = "dart_10",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "StreamController kapatılmazsa (close()) ne tür bir problem ortaya çıkar?",
                    options = listOf("Derleme hatası verir", "Bellek sızıntısı (Memory Leak) ve açık kalan aboneliklerin gereksiz CPU harcaması oluşur", "Hiçbir şey olmaz", "Uygulama hemen kapanır"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Açık kalan controller'lar GC tarafından toplanamaz ve bellek sızıntısına yol açar.",
                    explanationWrong = "Kapatılmayan controller bellek sızıntısına sebep olur.",
                    reviewTopic = "Dart Streams"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "StreamTransformer nedir?",
                    answer = "Stream'den gelen verileri dönüştüren, filtreleyen veya birleştiren (örn: debounce, buffer, map) reaktif işlemcilerdir."
                )
            ),
            completionCriteria = listOf(
                "Broadcast ve Single-subscription stream farkını bilmek",
                "StreamController ile olay yayınlayabilmek",
                "async* jeneratörleri yazabilmek"
            )
        ),

        // ==========================================
        // DERS 11: ÇOK ÇEKİRDEKLİ PARALELLİK & DART ISOLATES
        // ==========================================
        Lesson(
            id = "dart_11",
            courseId = "dart",
            sectionId = "dart_sec_6",
            title = "Çok Çekirdekli Paralellik: Dart Isolates & compute()",
            shortDesc = "Gerçek çok çekirdekli paralellik: Dart Isolates bellek modeli, Isolate.run(), Isolate.spawn() ve SendPort/ReceivePort iletişimi.",
            level = CourseLevel.EXPERT,
            order = 11,
            isPremium = true,
            learningObjectives = listOf(
                "Dart Isolates mimarisini ve bellek paylaşmama (share-nothing) felsefesini anlamak",
                "Isolate.run() ile ağır CPU işlerini ana thread'den (UI thread) ayırmak",
                "SendPort ve ReceivePort ile iki yönlü mesajlaşma protokolü kurmak"
            ),
            prerequisites = listOf("Dart Streams ve Asenkron Mimari"),
            subtopics = listOf("Dart Isolates & Sıfır Bellek Paylaşımı", "Isolate.run() ile Tek Seferlik Paralellik", "Isolate.spawn() & İki Yönlü Portlar", "SendPort & ReceivePort İletişimi", "compute() ve Flutter Entegrasyonu"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Dart Isolates: Bellek Paylaşmayan (Share-Nothing) Paralellik",
                    body = "Geleneksel dillerde (C++, Java) birden çok thread aynı bellek alanını paylaşır; bu durum yarış durumlarına (race condition), kilitlenmelere (deadlock) ve karmaşık kilit mekanizmalarına (mutex) yol açar.\n\nDart bu sorunu 'Isolates' ile çözer. Her Isolate kendi bağımsız bellek alanına (heap) ve kendi Event Loop'una sahiptir. Isolates birbirlerinin belleğine asla doğrudan erişemez; sadece mesajlaşarak (SendPort/ReceivePort veya Isolate.run) konuşurlar.",
                    codeSnippet = "import 'dart:isolate';\n\n// Dart 2.19+ ile gelen modern Isolate çalıştırma:\nfinal sonuc = await Isolate.run(() {\n  // Bu blok cihazın boş bir CPU çekirdeğinde çalışır\n  return agirHesaplamaYap(5000000);\n});"
                ),
                LessonContentBlock(
                    subtitle = "2. UI Thread'ini (60/120 FPS) Korumak",
                    body = "Flutter'da arayüz çizimi ve kullanıcı dokunuşları ana thread (UI Thread) üzerinde gerçekleşir. Eğer ana thread üzerinde 10 MB'lık bir JSON çözümlenir veya yüksek çözünürlüklü bir resim sıkıştırılırsa, frame atlaması (jank) yaşanır ve ekran donar.\n\nAğır CPU gerektiren her türlü işlem `Isolate.run()` ile arka plan çekirdeğe devredilmelidir.",
                    tip = "Isolates arasında sadece serileştirilebilir veriler (int, String, List, Map, byte buffer vb.) aktarılabilir; UI Widget'ları veya canlı nesne referansları aktarılamaz."
                )
            ),
            codeExample = "import 'dart:isolate';\n\nint asalSayilariSay(int limit) {\n  int sayac = 0;\n  for (int i = 2; i < limit; i++) {\n    bool asal = true;\n    for (int j = 2; j * j <= i; j++) {\n      if (i % j == 0) { asal = false; break; }\n    }\n    if (asal) sayac++;\n  }\n  return sayac;\n}\n\nvoid main() async {\n  print('Hesaplama Isolate\\'e gönderiliyor...');\n  final toplam = await Isolate.run(() => asalSayilariSay(500000));\n  print('Bulunan Asal Sayı: \$toplam');\n}",
            codeExplanation = "Isolate.run() arka planda yeni bir Isolate tahsis eder, asal sayıları hesaplar, sonucu ana thread'e transfer eder ve Isolate'i güvenle kapatır.",
            realWorldExample = "Kamera görüntüsünden yüz tanıma / ML çıkarımı veya 50 MB'lık şifrelenmiş dosyanın AES ile çözülmesi Isolate'lerde yapılır.",
            practicalTask = "SendPort ve ReceivePort kullanarak ana thread ile Isolate arasında ping-pong mesajlaşması kurun.",
            starterPlaygroundCode = "void main() async {\n  print('Isolate Paralel Çalışma Sistemi!');\n}",
            miniQuestion = MiniQuestion(
                id = "dart_q_11",
                question = "Dart Isolates diğer dillerdeki geleneksel thread'lerden hangi temel özelliğiyle ayrılır?",
                options = listOf("Daha yavaş olmalarıyla", "Kendi bağımsız heap bellek alanlarına sahip olmaları ve bellek paylaşmayıp sadece mesajlaşmalarıyla", "Yalnızca web'de çalışmalarıyla", "Asenkron olamamalarıyla"),
                correctIndex = 1,
                explanation = "Isolate'ler bellek paylaşmaz. Bu sayede kilit (mutex/deadlock) karmaşası olmadan güvenli paralellik sağlanır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_dart_11",
                lessonId = "dart_11",
                title = "Paralel Faktöriyel Hesaplayıcı",
                instructions = "Isolate.run kullanarak büyük bir sayının faktöriyelini arka planda hesaplayan paralelFaktoriyel(int n) fonksiyonunu yazın.",
                exampleInput = "n = 5",
                exampleOutput = "120",
                starterCode = "Future<int> paralelFaktoriyel(int n) async {\n  // Kodunu buraya yaz:\n  return 1;\n}",
                solutionCode = "import 'dart:isolate';\nFuture<int> paralelFaktoriyel(int n) async {\n  return await Isolate.run(() {\n    int sonuc = 1;\n    for (int i = 2; i <= n; i++) sonuc *= i;\n    return sonuc;\n  });\n}",
                hints = listOf("Isolate.run(() { ... }) kullanın."),
                testCases = listOf(
                    TestCase("paralelFaktoriyel(5)", "120", "5! hesaplama")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "dart_quiz_11_1",
                    lessonId = "dart_11",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Flutter'daki compute() fonksiyonu ile Dart'ın yerleşik Isolate.run() fonksiyonu arasındaki ilişki nedir?",
                    options = listOf("Tamamen farklı motorlardır", "compute() Flutter'ın Isolate sarmalayıcısıdır, Isolate.run() ise saf Dart'ın yerleşik ve önerilen API'sidir", "compute() daha hızlıdır", "Isolate.run() web'de çalışmaz"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Isolate.run() modern saf Dart standart API'sidir.",
                    explanationWrong = "Isolate.run() saf Dart'ın modern standart Isolate API'sidir.",
                    reviewTopic = "Dart Isolates"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Isolates arasında hangi veri tipleri aktarılabilir?",
                    answer = "İlkel tipler (int, double, String, bool), List, Map, SendPort/ReceivePort gibi serileştirilebilir veriler doğrudan transfer edilebilir. Closure veya UI Widget'ları Isolate sınırından geçirilemez."
                )
            ),
            completionCriteria = listOf(
                "Isolate bellek izolasyonu prensibini açıklayabilmek",
                "Isolate.run ile UI thread'ini dondurmayan CPU optimizasyonu yapabilmek",
                "SendPort/ReceivePort mesajlaşma protokolünü kavramak"
            )
        ),

        // ==========================================
        // DERS 12: DART VM, GC, PROFILING & NATIVE FFI
        // ==========================================
        Lesson(
            id = "dart_12",
            courseId = "dart",
            sectionId = "dart_sec_6",
            title = "Dart VM Internals, Generational GC & dart:ffi Köprüsü",
            shortDesc = "Dart Sanal Makinesi (VM) bellek modeli: Nursery vs Old Space GC, AOT vs JIT, Memory Leak analizi ve dart:ffi ile C/C++ entegrasyonu.",
            level = CourseLevel.EXPERT,
            order = 12,
            isPremium = true,
            learningObjectives = listOf(
                "Dart VM Generational Garbage Collection mimarisini anlamak",
                "Scavenger (Young generation) ve Mark-Sweep-Compact (Old generation) döngülerini kavramak",
                "dart:ffi ile yerel C/C++ kütüphanelerini mikrosaniye hızında doğrudan çağırmak"
            ),
            prerequisites = listOf("Dart Isolates ve Çok Çekirdekli Mimari"),
            subtopics = listOf("Dart VM Architecture", "Nursery & Old Space GC", "AOT Compilation Pipeline", "Memory Retaining Paths", "dart:ffi & Native C Pointers"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Generational Garbage Collection: Nursery ve Old Space",
                    body = "Dart VM, nesnelerin büyük çoğunluğunun çok kısa ömürlü olduğu gerçeğine (Weak Generational Hypothesis) dayanarak iki katmanlı bir bellek yönetimi uygular:\n\n1. Nursery (Young Space): Yeni üretilen tüm nesneler buraya yerleşir. Scavenger algoritması ile çalışan bu alan, milisaniyenin altında (genellikle < 1ms) çok hızlı temizlenir ve UI thread'ini asla duraklatmaz.\n2. Old Space: Birkaç GC turunu atlatan kalıcı nesneler buraya aktarılır. Mark-Sweep-Compact algoritmasıyla periyodik ve seyrek olarak taranır.",
                    codeSnippet = "// Flutter widget ağacındaki kısa ömürlü nesneler Nursery'de mikrosaniyede temizlenir."
                ),
                LessonContentBlock(
                    subtitle = "2. dart:ffi ile Sıfır Gecikmeli C/C++ ve Rust Köprüsü",
                    body = "Geleneksel Platform Channel mekanizmaları veriyi JSON veya binary buffer olarak serileştirip platform thread'ine iletir; bu durum yüksek veri akışlarında gecikme yaratır.\n\n`dart:ffi` (Foreign Function Interface), Dart kodunun doğrudan C/C++/Rust bellek adreslerine (pointer) ve derlenmiş paylaşımlı kütüphanelere (`.so`, `.dylib`, `.dll`) sıfır serileştirme ek yüküyle, yerel CPU hızında erişmesini sağlar.",
                    codeSnippet = "import 'dart:ffi';\nimport 'package:ffi/ffi.dart';\n\n// C dinamik kütüphanesini açma:\nfinal dylib = DynamicLibrary.open('libcrypto.so');\n\n// Yerel C fonksiyonunun Dart tarafında eşleştirilmesi:\ntypedef CTopla = Int32 Function(Int32 a, Int32 b);\ntypedef DartTopla = int Function(int a, int b);\n\nfinal topla = dylib.lookupFunction<CTopla, DartTopla>('topla');\nfinal sonuc = topla(10, 20); // Doğrudan C hızında çalışır"
                )
            ),
            codeExample = "import 'dart:ffi';\nimport 'package:ffi/ffi.dart';\n\nvoid main() {\n  // Arena ile otomatik serbest bırakılan yerel bellek tahsisi\n  using((Arena arena) {\n    final Pointer<Int32> pInt = arena<Int32>();\n    pInt.value = 42;\n    print('C Pointer Adresi: \${pInt.address}, Değer: \${pInt.value}');\n    // Scope bitince yerel bellek işletim sistemine iade edilir\n  });\n}",
            codeExplanation = "arena<Int32>() C tarafında malloc yapar. using() bloğu tamamlandığında free() otomatik çalışır.",
            realWorldExample = "Flutter'ın resmi SQLite sürücüsü (sqlite3) ve Realm veritabanı motoru dart:ffi köprüsü ile native hızında çalışır.",
            practicalTask = "Zayıf referans (WeakReference) kullanarak bellek sızıntısı yapmayan bir Önbellek (Cache) mekanizması tasarlayın.",
            starterPlaygroundCode = "void main() {\n  final weakRef = WeakReference(Object());\n  print('Hedef var mı: \${weakRef.target != null}');\n}",
            miniQuestion = MiniQuestion(
                id = "dart_q_12",
                question = "dart:ffi ile tahsis edilen native C belleğinin serbest bırakılmasından kim sorumludur?",
                options = listOf("Dart Garbage Collector", "Geliştirici (Manuel veya Arena/free kullanarak)", "İşletim sistemi otomatik temizler", "Flutter Engine"),
                correctIndex = 1,
                explanation = "Native bellek Dart heap'i dışındadır; geliştirici serbest bırakmazsa sistem seviyesinde bellek sızıntısı oluşur."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_dart_12",
                lessonId = "dart_12",
                title = "Clean Architecture Hata Sarmalayıcı (Result Pattern)",
                instructions = "Başarılı sonucu ve hatayı tip güvenli tutan Result<T> generic sealed class mimarisini yazın.",
                exampleInput = "Success(100)",
                exampleOutput = "100",
                starterCode = "sealed class Result<T> {}\nclass Success<T> extends Result<T> { final T data; Success(this.data); }\nclass Failure<T> extends Result<T> { final String error; Failure(this.error); }\n\nT? unwrap<T>(Result<T> r) {\n  // Kodunu buraya yaz:\n  return null;\n}",
                solutionCode = "sealed class Result<T> {}\nclass Success<T> extends Result<T> { final T data; Success(this.data); }\nclass Failure<T> extends Result<T> { final String error; Failure(this.error); }\n\nT? unwrap<T>(Result<T> r) {\n  return switch(r) {\n    Success(:final data) => data,\n    Failure() => null,\n  };\n}",
                hints = listOf("Pattern matching ve switch ifadesi kullanın."),
                testCases = listOf(
                    TestCase("unwrap", "42", "Başarılı durum")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "dart_quiz_12_1",
                    lessonId = "dart_12",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Platform Channels (MethodChannel) yerine dart:ffi tercih edilmesinin en temel sebebi nedir?",
                    options = listOf("Daha kolay yazılması", "İkili serileştirme ve thread geçişi ek yükü olmadan doğrudan C hızında senkron bellek erişimi sağlaması", "Sadece iOS'ta çalışması", "Daha az kod üretmesi"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! FFI serileştirme yapmadan doğrudan yerel pointer'lara erişir ve mikrosaniye gecikmesiz çalışır.",
                    explanationWrong = "dart:ffi doğrudan native bellek erişimiyle sıfır serileştirme gecikmesi sunar.",
                    reviewTopic = "dart:ffi"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Tree Shaking nedir?",
                    answer = "AOT derleyicinin projede ve kütüphanelerde hiç çağrılmayan ölü kodları (dead code) tespit edip nihai ikili binary dosyasından tamamen ayıklayarak dosya boyutunu küçültmesidir."
                )
            ),
            completionCriteria = listOf(
                "Dart VM Generational GC mekanizmasını açıklayabilmek",
                "Memory Retaining Path analizi ile leak tespit edebilmek",
                "dart:ffi ile yerel C kütüphanelerini entegre edebilmek"
            )
        )
    )
}
