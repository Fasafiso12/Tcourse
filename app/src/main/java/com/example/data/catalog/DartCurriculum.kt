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
            title = "Dart'a Giriş, Değişkenler & Veri Tipleri",
            shortDesc = "Dart dili mimarisi, main() giriş noktası, temel tipler (int, double, String, bool) ve var, final, const kavramları.",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false,
            learningObjectives = listOf(
                "Dart programlama dilinin statik ve güçlü tip sistemini kavramak",
                "main() fonksiyonunun çalışma mantığını öğrenmek",
                "var, final ve const anahtar kelimeleri arasındaki farkı ayırt etmek"
            ),
            prerequisites = listOf("Ön koşul gerekmez. Sıfırdan başlar."),
            subtopics = listOf("main() Giriş Fonksiyonu", "int, double, num, String, bool", "Tip Çıkarımı (Type Inference)", "final vs const"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. main() Fonksiyonu ve Kodun Başlangıcı",
                    body = "Her Dart programı 'main()' fonksiyonu ile başlar. Dart güçlü ve statik tipli (strongly typed) bir dildir ancak tip çıkarımı (type inference) sayesinde türleri otomatik olarak da algılayabilir.",
                    codeSnippet = "void main() {\n  print('Dart Dünyasına Hoş Geldiniz!');\n}",
                    tip = "Dart'ta her şey bir nesnedir (int, double, fonksiyonlar dahil her şey Object sınıfından türer)."
                ),
                LessonContentBlock(
                    subtitle = "2. final ve const Farkı",
                    body = "• var: Değişkenin türünü atanan ilk değerden otomatik belirler ve sonradan değeri değiştirilebilir.\n• final: Çalışma anında (runtime) bir kez atanır ve bir daha değiştirilemez.\n• const: Derleme zamanında (compile-time) bilinen sabitlerdir. Bellekte tek bir kopya (canonical instance) paylaşılır.",
                    codeSnippet = "var isim = 'Dart';\nisim = 'Flutter'; // Geçerli\n\nfinal bugun = DateTime.now(); // Çalışma anında hesaplanır\nconst pi = 3.14159; // Derleme anında sabittir"
                )
            ),
            codeExample = "void main() {\n  String baslik = 'Mobil Programlama';\n  int dersSaati = 40;\n  double ucret = 0.0; // Ücretsiz\n  bool yayinda = true;\n  \n  print('\$baslik dersi \$dersSaati saat sürecektir. Yayında mı: \$yayinda');\n}",
            codeExplanation = "String, int, double ve bool Dart'ın temel ilkel tipleridir. Metin içinde \$islem veya \${islem} ile String Interpolation yapılır.",
            realWorldExample = "Flutter uygulamalarında uygulamanın başlangıç noktası `void main() => runApp(MyApp());` şeklinde Dart main() fonksiyonudur.",
            practicalTask = "Adınızı, yaşınızı ve boyunuzu uygun tiplerde tanımlayıp f-string benzeri String interpolation ile ekrana yazdıran bir Dart kodu yazın.",
            starterPlaygroundCode = "void main() {\n  String ad = 'Ahmet';\n  int yas = 22;\n  print('Adım \$ad, yaşım \$yas.');\n}",
            miniQuestion = MiniQuestion(
                id = "dart_q_1",
                question = "Dart'ta derleme zamanı (compile-time) sabiti tanımlamak için hangi anahtar kelime kullanılır?",
                options = listOf("final", "const", "static", "let"),
                correctIndex = 1,
                explanation = "const derleme anında sabit değerler için kullanılır; final ise çalışma zamanında tek seferlik atama içindir."
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
                    answer = "'dynamic' statik tip kontrolünü tamamen devre dışı bırakır. 'Object?' ise tüm tipleri kabul eder ancak metodlarına erişmek için tip kontrolü (is) veya tür dönüşümü (as) gerektirir."
                )
            ),
            completionCriteria = listOf(
                "Dart temel veri tiplerini hatasız tanımlayabilmek",
                "final ve const arasındaki farkı bilmek",
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
            title = "Operatörler, Koşullu İfadeler & Döngüler",
            shortDesc = "Aritmetik ve mantıksal operatörler, if-else, switch-case, for, for-in, while ve do-while döngüleri.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false,
            learningObjectives = listOf(
                "if-else ve üçlü koşul (ternary ? :) yapılarını kullanmak",
                "switch-case ile çoklu durum kontrolü yapmak",
                "for, for-in ve while döngüleri ile iterasyon gerçekleştirmek"
            ),
            prerequisites = listOf("Dart'a Giriş, Değişkenler & Veri Tipleri"),
            subtopics = listOf("Aritmetik & Mantıksal Operatörler", "if, else if, else", "Ternary Operator (? :)", "for & for-in Döngüleri", "while & do-while"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Karar Yapıları: if-else ve Üçlü Operatör",
                    body = "Dart'ta koşul ifadeleri standart C sözdizimine benzer. Kısa koşullar için ternary 'kosul ? dogruysa : yanlissa' kullanılır.",
                    codeSnippet = "int not = 75;\nString sonuc = not >= 50 ? 'Geçti' : 'Kaldı';"
                ),
                LessonContentBlock(
                    subtitle = "2. Döngü Çeşitleri",
                    body = "• Standart for: `for (int i = 0; i < 5; i++)`\n• for-in: Koleksiyon elemanlarını doğrudan gezmek için: `for (var item in list)`\n• while: Koşul sağlandığı sürece çalışır.",
                    tip = "Döngüyü erken sonlandırmak için 'break', mevcut adımı atlamak için 'continue' kullanılır."
                )
            ),
            codeExample = "void main() {\n  for (int i = 1; i <= 5; i++) {\n    if (i % 2 == 0) {\n      print('\$i çifttir.');\n    } else {\n      print('\$i tektir.');\n    }\n  }\n}",
            codeExplanation = "for döngüsü 1'den 5'e kadar döner. Mod (%) operatörü ile 2'ye tam bölünenler tespit edilir.",
            realWorldExample = "Kullanıcı arayüzünde liste elemanlarını sıralarken veya sayfalama (pagination) yaparken döngüler ve koşullar kullanılır.",
            practicalTask = "1'den 100'e kadar olan sayılardan 3 ve 5'e tam bölünenleri 'FizzBuzz' olarak yazdıran bir döngü kurun.",
            starterPlaygroundCode = "void main() {\n  for (int i = 1; i <= 10; i++) {\n    print('Sayı: \$i');\n  }\n}",
            miniQuestion = MiniQuestion(
                id = "dart_q_2",
                question = "Dart'ta bir koleksiyonun tüm elemanlarını indeks kullanmadan sırayla gezmek için en temiz döngü hangisidir?",
                options = listOf("for-in döngüsü", "do-while döngüsü", "goto komutu", "switch-case"),
                correctIndex = 0,
                explanation = "'for (var eleman in liste)' sözdizimi koleksiyonları en temiz şekilde gezer."
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
                "for ve while döngüleri ile algoritmik hesaplamalar yapabilmek",
                "break ve continue akış kontrolünü doğru kullanabilmek"
            )
        ),

        // ==========================================
        // DERS 3: FONKSİYONLAR, PARAMETRELER & ARROW SYNTAX
        // ==========================================
        Lesson(
            id = "dart_3",
            courseId = "dart",
            sectionId = "dart_sec_2",
            title = "Fonksiyonlar, Parametre Türleri & Arrow Syntax",
            shortDesc = "Fonksiyon tanımlama, Konumsal (Positional), İsimlendirilmiş ({Named}), Opsiyonel ([Optional]) parametreler ve tek satırlık Arrow (=>) fonksiyonlar.",
            level = CourseLevel.BEGINNER,
            order = 3,
            isPremium = false,
            learningObjectives = listOf(
                "İsimlendirilmiş ({required Param}) ve opsiyonel parametreleri öğrenmek",
                "Tek satırlı Arrow (=>) sözdizimini etkin kullanmak",
                "First-Class fonksiyonlar ve anonim fonksiyon yapılarını kavramak"
            ),
            prerequisites = listOf("Dart Operatörler ve Döngüler"),
            subtopics = listOf("Fonksiyon İmzası & Dönüş Tipleri", "Named Parameters ({})", "Positional Optional Parameters ([])", "Default Değerler", "Arrow (=>) Syntax"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. İsimlendirilmiş Parametreler (Flutter Standardı)",
                    body = "Süslü parantez `{}` içine alınan parametreler isimlendirilmiş parametrelerdir. Çağrılırken isimleriyle verilir ve sırası önemsizdir. 'required' ile zorunlu kılınabilir.",
                    codeSnippet = "void kullaniciOlustur({required String isim, int yas = 18}) {\n  print('\$isim - \$yas');\n}\n\nkullaniciOlustur(isim: 'Can'); // yas varsayılan 18 olur"
                ),
                LessonContentBlock(
                    subtitle = "2. Arrow Syntax (=>)",
                    body = "Yalnızca tek bir ifadeden (expression) oluşan fonksiyonlar süslü parantez yerine `=>` ile yazılır.",
                    codeSnippet = "int topla(int a, int b) => a + b;"
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
            title = "Koleksiyonlar (List, Set, Map) & Spread Operatörleri",
            shortDesc = "Listeler, Kümeler (Set), Sözlükler (Map), Spread operatörü (...), Collection-if/for ve Higher-Order fonksiyonlar (map, where, reduce).",
            level = CourseLevel.BEGINNER,
            order = 4,
            isPremium = true,
            learningObjectives = listOf(
                "List, Set ve Map veri yapılarının kullanım amaçlarını öğrenmek",
                "Collection-if ve Collection-for ile dinamik listeler üretmek",
                "Spread operatörü (...) ve higher-order metodları (where, map, fold) kavramak"
            ),
            prerequisites = listOf("Dart Fonksiyonlar"),
            subtopics = listOf("List & Indeksleme", "Set & Benzersiz Elemanlar", "Map (Anahtar-Değer)", "Spread Operatörü (...)", "Collection-if / Collection-for"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Koleksiyon Türleri",
                    body = "• List: Sıralı ve tekrarlı eleman tutar: `[1, 2, 3]`\n• Set: Benzersiz (unique) eleman tutar, tekrar kabul etmez: `{1, 2, 3}`\n• Map: Anahtar-değer çiftleri tutar: `{'ad': 'Ali', 'yas': 25}`",
                    codeSnippet = "List<String> diller = ['Dart', 'Kotlin', 'Rust'];\nSet<int> tekiller = {1, 2, 2, 3}; // {1, 2, 3}\nMap<String, int> notlar = {'Matematik': 90, 'Fizik': 85};"
                ),
                LessonContentBlock(
                    subtitle = "2. Collection-if, Collection-for ve Spread (...)",
                    body = "Dart koleksiyonları içinde doğrudan 'if' ve 'for' yazılabilir. Bu sayede Flutter widget ağaçlarında koşullu UI elemanları son derece zarif inşa edilir.",
                    codeSnippet = "bool admin = true;\nvar menuler = ['Ana Sayfa', if (admin) 'Yönetici Paneli', 'Ayarlar'];"
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
            title = "Sound Null Safety & Hata Yönetimi",
            shortDesc = "Sound Null Safety kuralları (?, !., ??, ??=, late), Type Promotion, try-catch-on-finally blokları ve özel Exception sınıfları.",
            level = CourseLevel.BEGINNER,
            order = 5,
            isPremium = true,
            learningObjectives = listOf(
                "Sound Null Safety mantığını ve derleme zamanı garantilerini anlamak",
                "Null-aware operatörleri (??, ?., ??=, !) doğru kullanmak",
                "try-catch-on-finally ile istisnaları yakalayıp özel hata fırlatmak (throw)"
            ),
            prerequisites = listOf("Dart Değişkenler ve Fonksiyonlar"),
            subtopics = listOf("Sound Null Safety", "Nullable vs Non-nullable Tipler", "Null Coalescing (??, ??=)", "late Anahtar Kelimesi", "try, on, catch, finally"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Sound Null Safety Felsefesi",
                    body = "Dart'ta bir değişken varsayılan olarak asla null olamaz. Null olabilmesi için açıkça '?' ile işaretlenmesi zorunludur (örn: `String?`).",
                    codeSnippet = "String? isim = null;\nString gorunen = isim ?? 'Misafir'; // isim null ise 'Misafir' atanır"
                ),
                LessonContentBlock(
                    subtitle = "2. Hata Yakalama: try-catch-on-finally",
                    body = "Beklenmeyen hatalar 'try' bloğuna alınır. Belirli hata tipini yakalamak için 'on ExceptionType' kullanılır. 'finally' ise hata olsa da olmasa da en son mutlaka çalışır.",
                    codeSnippet = "try {\n  int sonuc = 10 ~/ 0;\n} on UnsupportedError {\n  print('Sıfıra bölme hatası!');\n} catch (e) {\n  print('Bilinmeyen hata: \$e');\n} finally {\n  print('İşlem bitti.');\n}"
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
            subtopics = listOf("Class Tanımı & Alanlar", "this.field Kurucu Sözdizimi", "Named Constructors", "Initializer List (:)", "Getters & Setters"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Dart Sınıf ve Kurucu Sözdizimi",
                    body = "Dart kurucularında 'this.alan' sözdizimi ile kurucu parametresi doğrudan sınıf alanına atanır; fazladan atama kodu yazmaya gerek kalmaz.",
                    codeSnippet = "class Kisi {\n  final String ad;\n  final int yas;\n  // Kısa kurucu:\n  Kisi(this.ad, this.yas);\n  // İsimlendirilmiş kurucu:\n  Kisi.yeniDogan(this.ad) : yas = 0;\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Kapsülleme ve Dart'ta Gizlilik",
                    body = "Dart'ta 'private' anahtar kelimesi yoktur. Bir alanın veya metodun başına alt çizgi `_` konulduğunda, o dosya/kütüphane (library) dışına gizlenir.",
                    tip = "Dart'ta gizlilik sınıf düzeyinde değil, dosya (kütüphane) düzeyindedir."
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
            subtopics = listOf("extends & super", "@override Anotasyonu", "abstract class", "implements & Implicit Interfaces", "Mixins ('with')"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Kalıtım ve Soyut Sınıflar",
                    body = "Dart tekli kalıtımı (single inheritance) destekler. Soyut sınıflar (abstract class) doğrudan instance'ı üretilemeyen ancak alt sınıflara şablon oluşturan sınıflardır.",
                    codeSnippet = "abstract class Sekil {\n  double alanHesapla();\n}\n\nclass Kare extends Sekil {\n  final double kenar;\n  Kare(this.kenar);\n  @override\n  double alanHesapla() => kenar * kenar;\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Mixins ile Çoklu Davranış Paylaşımı",
                    body = "Mixin'ler ('with') kalıtım hiyerarşisini şişirmeden bir sınıfa bağımsız yetenekler aşılamanın en temiz yoludur.",
                    codeSnippet = "mixin Logger {\n  void log(String msg) => print('[LOG]: \$msg');\n}\n\nclass Servis with Logger {\n  void calistir() => log('Servis devrede.');\n}"
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
            subtopics = listOf("Dart 3 Records", "Object Destructuring", "Pattern Matching in Switch", "Sealed Classes", "Class Modifiers (final, base, interface, sealed)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Dart 3 Records (Kayıtlar)",
                    body = "Birden çok değeri bir sınıfa gerek duymadan tip güvenli şekilde tek fonksiyondan döndürmenizi sağlar. İsimlendirilmiş ve konumsal alanları destekler.",
                    codeSnippet = "(String, int) kullaniciAl() => ('Deniz', 28);\nfinal (isim, yas) = kullaniciAl(); // Otomatik destructuring!"
                ),
                LessonContentBlock(
                    subtitle = "2. Sealed Classes ile Tam Güvence",
                    body = "Sealed sınıflar, alt sınıfların sadece aynı dosyada tanımlanmasını zorunlu kılar. Bu sayede switch ifadesinde 'default' yazmanıza gerek kalmaz; eksik bir durum varsa derleyici derleme hatası verir.",
                    tip = "Flutter Bloc ve UI state yönetiminde Sealed Sınıflar en modern endüstri standardıdır."
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
            subtopics = listOf("Single-Threaded Model", "Microtask Queue", "Event Queue", "Future API & async/await", "Future.wait & Future.any"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Event Loop İki Kuyruk Prensibi",
                    body = "Dart motoru iki kuyrukla çalışır:\n1. Microtask Queue: Yüksek önceliklidir. İşi bitene kadar Event Queue'ya geçilmez.\n2. Event Queue: I/O olayları, tıklamalar, Timer'lar ve standart Future'lar buraya düşer.",
                    codeSnippet = "scheduleMicrotask(() => print('1. Microtask (Öncelikli)'));\nFuture(() => print('2. Event Queue (Normal)'));"
                ),
                LessonContentBlock(
                    subtitle = "2. async/await Aslında Nedir?",
                    body = "async/await yeni bir thread açmaz! Yalnızca Future tamamlandığında fonksiyonun geri kalanını Event Loop'a geri planlayan sözdizimsel bir şekerdir (syntactic sugar).",
                    tip = "UI donmalarının sebebi asenkron kod değil, Event Loop üzerinde koşan ağır senkron CPU döngüleridir."
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
            subtopics = listOf("Streams & async*", "StreamController & Sink", "Broadcast Streams", "StreamTransformer", "await for Döngüsü"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Streams: Reaktif Veri Boru Hattı",
                    body = "Future tek bir asenkron değer üretirken, Stream zaman içinde birden fazla olay (data, error, done) akıtır. WebSocket'ler, konum güncellemeleri ve kullanıcı tıklamaları Stream'dir.",
                    codeSnippet = "Stream<int> sayacUret() async* {\n  for (int i = 1; i <= 5; i++) {\n    await Future.delayed(Duration(seconds: 1));\n    yield i;\n  }\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. StreamController Mimarisi",
                    body = "StreamController bir Sink (giriş) ve bir Stream (çıkış) barındırır. `controller.sink.add(veri)` ile veri eklenir ve `controller.stream.listen()` ile dinlenir.",
                    tip = "Controller işi bittiğinde bellek sızıntısını önlemek için `controller.close()` mutlaka çağrılmalıdır."
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
            subtopics = listOf("Dart Isolates Felsefesi", "Isolate.run()", "Isolate.spawn()", "SendPort & ReceivePort", "compute() Fonksiyonu"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Isolates ile Sıfır Kilit (Zero-Lock) Paralelliği",
                    body = "Dart Isolates kendi bağımsız heap bellek alanına ve Event Loop'una sahip çalışma birimleridir. Bellek paylaşmazlar; mesajlaşarak (SendPort/ReceivePort veya Isolate.run) iletişim kurarlar. Bu sayede mutex/deadlock kilitlenmeleri yaşanmaz.",
                    codeSnippet = "final sonuc = await Isolate.run(() => agirHesaplama(1000000));"
                ),
                LessonContentBlock(
                    subtitle = "2. UI Thread'ini Kurtarmak",
                    body = "Ağır bir JSON parse, 50MB resim sıkıştırma veya kriptografi işlemi ana thread'de yapılırsa Flutter 60 FPS hedefini kaybeder ve ekran takılır (jank). Ağır CPU işleri Isolate'e devredilmelidir.",
                    tip = "Dart 2.19+ ile gelen `Isolate.run()` port yönetimine gerek kalmadan işi arka plana atıp sonucu döndürür."
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
                    subtitle = "1. Generational GC Mimarisi",
                    body = "Dart nesneleri iki alanda yaşar:\n1. Nursery (Young Space): Yeni nesneler burada çok hızlı tahsis edilir. Yaşamı kısa olanlar Scavenge algoritması ile milisaniyeden kısa sürede temizlenir.\n2. Old Space: Birkaç GC döngüsünden sağ çıkan nesneler buraya terfi eder. Daha seyrek çalışan Mark-Sweep algoritmasıyla taranır.",
                    codeSnippet = "// Kısa ömürlü nesneler UI thread'ini hiç yavaşlatmaz"
                ),
                LessonContentBlock(
                    subtitle = "2. dart:ffi: Sıfır Maliyetli Yerel Çağrı",
                    body = "Platform Channel'ların serileştirme (JSON/BinaryMessenger) ek yükü olmadan, doğrudan bellek adresleri üzerinden C fonksiyonlarını mikrosaniye altında çağırır.",
                    codeSnippet = "final dylib = DynamicLibrary.open('libnative.so');\nfinal topla = dylib.lookupFunction<Int32 Function(Int32, Int32), int Function(int, int)>('topla');"
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
