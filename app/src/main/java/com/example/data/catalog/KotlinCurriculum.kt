package com.example.data.catalog

import com.example.model.*

/**
 * Kotlin Kolay & Anlaşılır Müfredatı (12 Adım):
 * Android'in resmi dili Kotlin'i sıfırdan, sade ve keyifli bir dille öğrenin.
 */
object KotlinCurriculum {

    fun getSections(): List<CourseSection> = listOf(
        CourseSection(
            id = "kt_sec_1",
            courseId = "kotlin",
            title = "Bölüm 1: Kotlin Temelleri ve Güvenlik",
            level = CourseLevel.BEGINNER,
            order = 1,
            description = "Kotlin dünyasına merhaba: val ve var farkı, sayı ve metinler, çökmeleri önleyen Null Safety.",
            learningObjectives = listOf("val (sabit) ve var (değişken) kullanımını öğrenmek", "Null Safety (?, ?:) ile çökme riskini sıfırlamak", "Metin şablonları (\$isim) kullanmak"),
            prerequisites = listOf("Ön bilgi gerekmez! Merak ve heves yeterlidir.")
        ),
        CourseSection(
            id = "kt_sec_2",
            courseId = "kotlin",
            title = "Bölüm 2: Kararlar, Döngüler ve Fonksiyonlar",
            level = CourseLevel.BEGINNER,
            order = 2,
            description = "when ve if ile karar verme, döngüler, tek satırlık pratik fonksiyonlar ve lambdalar.",
            learningObjectives = listOf("Süper pratik when yapısını kullanmak", "for döngüsü ve aralıklar (1..10)", "fun ile fonksiyon tanımlamak"),
            prerequisites = listOf("Kotlin Değişkenleri")
        ),
        CourseSection(
            id = "kt_sec_3",
            courseId = "kotlin",
            title = "Bölüm 3: Nesneler ve Veri Sınıfları (Data Class)",
            level = CourseLevel.INTERMEDIATE,
            order = 3,
            description = "Sınıflar (Class), tek satırda model oluşturan data class'lar ve güvenli Sealed class yapıları.",
            learningObjectives = listOf("class ve kurucuları (constructor) öğrenmek", "data class ile temiz veri modelleri kurmak", "object ve companion object kavramlarını kavramak"),
            prerequisites = listOf("Fonksiyonlar ve Döngüler")
        ),
        CourseSection(
            id = "kt_sec_4",
            courseId = "kotlin",
            title = "Bölüm 4: Pratik Uzantılar ve Kapsam Fonksiyonları",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            description = "Sınıflara yeni güçler katan Extension fonksiyonları ve let/apply gibi pratik kapsam araçları.",
            learningObjectives = listOf("Extension Functions yazmak", "let, apply, also gibi kapsam fonksiyonlarını kullanmak"),
            prerequisites = listOf("Sınıflar ve Nesneler")
        ),
        CourseSection(
            id = "kt_sec_5",
            courseId = "kotlin",
            title = "Bölüm 5: Asenkron Kotlin (Coroutines) ve Flow",
            level = CourseLevel.ADVANCED,
            order = 5,
            description = "Uygulama arayüzünün donmasını engelleyen Coroutines (suspend) ve canlı veri akışları (Flow).",
            learningObjectives = listOf("suspend fonksiyonlar ile donmayan işlemler", "Kotlin Flow ve StateFlow ile reaktif arayüzler"),
            prerequisites = listOf("Fonksiyonlar ve Sınıflar")
        ),
        CourseSection(
            id = "kt_sec_6",
            courseId = "kotlin",
            title = "Bölüm 6: İleri Düzey İpuçları ve Temiz Kod",
            level = CourseLevel.EXPERT,
            order = 6,
            description = "Hata yönetimi, profesyonel Android geliştirme ipuçları ve temiz kod mimarisi.",
            learningObjectives = listOf("try-catch ve Result ile güvenli hata yakalama", "Temiz ve modern Kotlin yazma alışkanlığı"),
            prerequisites = listOf("Tüm Seviyeler")
        )
    )

    fun getLessons(): List<Lesson> = listOf(
        // ==========================================
        // DERS 1: TEMEL SÖZDİZİMİ, VAL/VAR & NULL SAFETY
        // ==========================================
        Lesson(
            id = "kt_1",
            courseId = "kotlin",
            sectionId = "kt_sec_1",
            title = "Kotlin'e Giriş: val, var ve Null Safety",
            shortDesc = "Modern Android'in dili Kotlin'e ilk adım! Değişkenler, sabitler ve çökmeyi önleyen Elvis operatörü (?:).",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false,
            learningObjectives = listOf(
                "main() fonksiyonu ve println() ile ekrana yazı yazdırmak",
                "val (değişmez/sabit) ve var (değişebilir) farkını anlamak",
                "Null Safety (?, ?:) ile uygulamanın çökmesini engellemek",
                "Metin içine \$isim yazarak String şablonlarını kullanmak"
            ),
            prerequisites = listOf("Ön koşul gerekmez."),
            subtopics = listOf("Kotlin Neden Seviliyor?", "val vs var", "Temel Veri Tipleri", "Null Safety (?, ?:)", "String Şablonları"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Kotlin Dünyasına Hoş Geldiniz!",
                    body = "Kotlin, Google tarafından Android geliştirmenin **resmi dili** ilan edilmiş modern ve güvenli bir programlama dilidir. Kodları çok kısa, anlaşılır ve hatasız yazmanızı sağlar.\n\nKotlin'de programın başlangıç noktası `fun main()` fonksiyonudur.",
                    codeSnippet = "fun main() {\n    // Ekrana ilk mesajımızı yazalım:\n    println(\"Merhaba Kotlin ve Kod Akademi!\")\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. val (Sabit) ve var (Değişken) Farkı",
                    body = "• **val (Değer / Value):** Bir kere atandıktan sonra asla değiştirilemeyen güvenli kutudur. (Mümkün oldukça her yerde val tercih ederiz!)\n• **var (Değişken / Variable):** Değeri sonradan güncellenebilen kutudur.",
                    codeSnippet = "val dogumYili = 2000 // Asla değişmez (Sabit)\n// dogumYili = 2001 -> HATA! val değiştirilemez.\n\nvar puan = 10\npuan = 20 // Geçerli! var güncellenebilir."
                ),
                LessonContentBlock(
                    subtitle = "3. Null Safety: Çökmeyen Uygulamalar",
                    body = "Normalde hiçbir değişken boş (`null`) kalamaz. Eğer boş kalabilmesini istiyorsanız tipin sonuna `?` koyarsınız. Eğer boş ise yedek bir değer kullanmak için sevimli **Elvis Operatörü (`?:`)** devreye girer!",
                    codeSnippet = "var isim: String = \"Mert\" // Asla null olamaz\nvar soyisim: String? = null // Null olabilir\n\n// Elvis (?:) ile yedek değer:\nval gorunenSoyad = soyisim ?: \"Soyad Belirtilmedi\"\nprintln(\"Kullanıcı: \$isim \$gorunenSoyad\")"
                )
            ),
            codeExample = "fun main() {\n    val dil = \"Kotlin\"\n    val surum = 2.0\n    val harikaMi = true\n    \n    println(\"\$dil \$surum ile Android kodluyoruz! (Harika: \$harikaMi)\")\n}",
            codeExplanation = "val ile değişkenler tanımlandı ve \$ işaretiyle metin içine yerleştirildi.",
            realWorldExample = "Android telefonunuzdaki neredeyse tüm modern uygulamalar (Instagram, Twitter, bankacılık) Kotlin ile yazılmıştır.",
            practicalTask = "Adınızı val, yaşınızı var olarak tanımlayıp ekrana \$ad ve \$yas ile yazdırın.",
            starterPlaygroundCode = "fun main() {\n    val ad = \"Zeynep\"\n    var yas = 22\n    // println ile ekrana yazdırın:\n}",
            miniQuestion = MiniQuestion(
                id = "kt_q_1",
                question = "Kotlin'de bir değişkenin değerinin sonradan değiştirilememesini (sabit kalmasını) sağlamak için hangi kelime kullanılır?",
                options = listOf("val", "var", "const_only", "let"),
                correctIndex = 0,
                explanation = "val ile tanımlanan değişkenler sabittir ve sonradan değiştirilemez."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_1",
                lessonId = "kt_1",
                title = "Öğrenci Bilgi Kartı",
                instructions = "ad ve notu parametrelerini alıp 'Ali: 85 Puan' formatında String döndüren bilgiKarti(ad, notu) fonksiyonunu yazın.",
                exampleInput = "ad = 'Ali', notu = 85",
                exampleOutput = "'Ali: 85 Puan'",
                starterCode = "fun bilgiKarti(ad: String, notu: Int): String {\n    // Kodunu yaz:\n    return \"\"\n}",
                solutionCode = "fun bilgiKarti(ad: String, notu: Int): String {\n    return \"\$ad: \$notu Puan\"\n}",
                hints = listOf("\"\$ad: \$notu Puan\" döndürün."),
                testCases = listOf(
                    TestCase("bilgiKarti(\"Ali\", 85)", "Ali: 85 Puan", "Öğrenci kartı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_1_1",
                    lessonId = "kt_1",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Kotlin'de sol taraf null ise sağdaki varsayılan değeri seçen operatörün (?:) adı nedir?",
                    options = listOf("Elvis Operatörü", "Safe Call", "Smart Cast", "Spread"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Yan çevrilmiş Elvis Presley saçına benzediği için (?:) Elvis Operatörü denir.",
                    explanationWrong = "?: operatörüne Elvis Operatörü denir.",
                    reviewTopic = "Kotlin Null Safety"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Neden var yerine val önerilir?",
                    answer = "Değişmeyen (immutable) verilerle çalışmak kodun beklenmedik şekilde bozulmasını önler ve hataları çok azaltır."
                )
            ),
            completionCriteria = listOf(
                "val ve var farkını bilmek",
                "Elvis operatörünü (?:) kullanabilmek",
                "String şablonları (\$isim) ile metin basabilmek"
            )
        ),

        // ==========================================
        // DERS 2: KOŞULLAR (when) VE DÖNGÜLER
        // ==========================================
        Lesson(
            id = "kt_2",
            courseId = "kotlin",
            sectionId = "kt_sec_2",
            title = "Kararlar (when) ve Döngüler (for, while)",
            shortDesc = "Kotlin'in süper yetenekli when yapısı ve 1..10 aralıklarıyla kolay döngüler.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false,
            learningObjectives = listOf(
                "when yapısı ile çok seçenekli kararları temizce yazmak",
                "if yapısının bir değere eşitlenebildiğini (Expression) görmek",
                "1..10, downTo ve step ile pratik for döngüleri kurmak"
            ),
            prerequisites = listOf("Kotlin Değişkenleri"),
            subtopics = listOf("when Karar Yapısı", "if İfadesi", "for Döngüsü ve Aralıklar (..)", "while Döngüsü"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Süper Pratik Karar Yapısı: when",
                    body = "Diğer dillerdeki karmaşık switch-case yapısı yerine Kotlin'de tertemiz bir `when` vardır. Hatta bir değişkene doğrudan sonuç atayabilir!",
                    codeSnippet = "val notu = 85\n\nval sonuc = when (notu) {\n    in 90..100 -> \"Pekiyi (A)\"\n    in 70..89 -> \"İyi (B)\"\n    in 50..69 -> \"Geçer (C)\"\n    else -> \"Kaldı\"\n}\nprintln(\"Sonuç: \$sonuc\") // İyi (B)"
                ),
                LessonContentBlock(
                    subtitle = "2. Döngüler ve Aralıklar (1..5, step, downTo)",
                    body = "Kotlin'de döngü yazmak çok doğaldır:\n\n• `1..5`: 1'den 5'e kadar (5 dahil)\n• `1 until 5`: 1'den 4'e kadar (5 dahil değil)\n• `10 downTo 1 step 2`: 10'dan geriye ikişer ikişer say",
                    codeSnippet = "// 1'den 3'e kadar say:\nfor (i in 1..3) {\n    println(\"Adım: \$i\")\n}\n\n// Geriye ikişer say:\nfor (i in 6 downTo 2 step 2) {\n    println(\"Çift: \$i\") // 6, 4, 2\n}"
                )
            ),
            codeExample = "fun main() {\n    var toplam = 0\n    for (i in 1..5) {\n        toplam += i\n    }\n    println(\"1-5 Toplamı: \$toplam\") // 15\n}",
            codeExplanation = "1..5 aralığı for döngüsüyle dönülerek sayılar toplandı.",
            realWorldExample = "Kullanıcının üyelik tipine göre (Gold, Silver, Normal) indirim oranı belirlerken when kullanılır.",
            practicalTask = "1'den 10'a kadar olan sayılardan sadece çift olanları ekrana yazdıran bir döngü yazın.",
            starterPlaygroundCode = "fun main() {\n    for (i in 2..10 step 2) {\n        println(i)\n    }\n}",
            miniQuestion = MiniQuestion(
                id = "kt_q_2",
                question = "Kotlin'de 1'den 5'e kadar (5 dahil) sayı aralığı nasıl yazılır?",
                options = listOf("1..5", "1 to 5", "1->5", "1...5"),
                correctIndex = 0,
                explanation = "Kotlin'de iki nokta yan yana (1..5) aralık belirtir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_2",
                lessonId = "kt_2",
                title = "Çift Sayıların Toplamı",
                instructions = "1'den n'e kadar olan çift sayıların toplamını hesaplayan ciftToplami(n) fonksiyonunu yazın.",
                exampleInput = "n = 6",
                exampleOutput = "12 (2 + 4 + 6)",
                starterCode = "fun ciftToplami(n: Int): Int {\n    // Kodunu yaz:\n    return 0\n}",
                solutionCode = "fun ciftToplami(n: Int): Int {\n    var top = 0\n    for (i in 2..n step 2) top += i\n    return top\n}",
                hints = listOf("for (i in 2..n step 2) ile ikişer ikişer toplayın."),
                testCases = listOf(
                    TestCase("ciftToplami(6)", "12", "6 için"),
                    TestCase("ciftToplami(10)", "30", "10 için")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_2_1",
                    lessonId = "kt_2",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Kotlin'de çoklu koşul dallanmalarında switch yerine hangi anahtar kelime kullanılır?",
                    options = listOf("when", "match", "case", "select"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Kotlin'de switch yerine çok daha yetenekli 'when' kullanılır.",
                    explanationWrong = "Kotlin'de when kullanılır.",
                    reviewTopic = "Kotlin Kontrol Akışı"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "when ifadesinde else yazmak zorunlu mudur?",
                    answer = "Eğer bir değişkene değer atıyorsanız ve tüm durumlar kapsanmadıysa derleyici else yazmanızı zorunlu tutar."
                )
            ),
            completionCriteria = listOf(
                "when yapısını kullanabilmek",
                "1..n aralığıyla for döngüsü kurabilmek"
            )
        ),

        // ==========================================
        // DERS 3: FONKSİYONLAR (fun)
        // ==========================================
        Lesson(
            id = "kt_3",
            courseId = "kt",
            sectionId = "kt_sec_2",
            title = "Fonksiyonlar: fun ile Kolay Kodlama",
            shortDesc = "Tek satırlık pratik fonksiyonlar, varsayılan parametreler ve lambdalar.",
            level = CourseLevel.BEGINNER,
            order = 3,
            isPremium = false,
            learningObjectives = listOf(
                "fun kelimesi ile fonksiyon tanımlamak",
                "Tek satırlık (Single-expression) fonksiyonlar yazmak",
                "Varsayılan ve isimlendirilmiş parametreleri kullanmak"
            ),
            prerequisites = listOf("Kotlin Değişkenleri ve Koşulları"),
            subtopics = listOf("fun Tanımlama", "Tek Satırlık Fonksiyonlar (=)", "Varsayılan Parametreler", "Lambdalar"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Fonksiyon Tanımlama (fun)",
                    body = "Fonksiyonlar işlerimizi paketleyen yardımcılarımızdır. Tek satırlık fonksiyonlarda süslü parantez bile açmadan eşittir (`=`) koyarak sonucu döndürebiliriz!",
                    codeSnippet = "// Klasik yöntem:\nfun topla(a: Int, b: Int): Int {\n    return a + b\n}\n\n// Tek satırlık pratik yöntem (Aynı işi yapar):\nfun toplaPratik(a: Int, b: Int) = a + b"
                ),
                LessonContentBlock(
                    subtitle = "2. Varsayılan ve İsimlendirilmiş Parametreler",
                    body = "Parametrelere varsayılan değer verebilir ve çağırırken parametrenin adını belirtebilirsiniz.",
                    codeSnippet = "fun kullaniciOlustur(ad: String, rol: String = \"Üye\") {\n    println(\"Kullanıcı: \$ad (Rol: \$rol)\")\n}\n\n// Çağırma:\nkullaniciOlustur(\"Ali\") // Rol otomatik 'Üye' olur\nkullaniciOlustur(rol = \"Yönetici\", ad = \"Ayşe\") // İsimle çağrı"
                )
            ),
            codeExample = "fun kareAl(x: Int) = x * x\n\nfun main() {\n    println(\"6'nın karesi: \${kareAl(6)}\") // 36\n}",
            codeExplanation = "kareAl tek satırlık pratik eşittir (=) fonksiyonuyla yazıldı.",
            realWorldExample = "Jetpack Compose ile Android arayüzü çizerken her UI bileşeni (@Composable) bir Kotlin fonksiyonudur.",
            practicalTask = "İki sayıyı çarpan tek satırlık carp(a, b) fonksiyonu yazın.",
            starterPlaygroundCode = "fun carp(a: Int, b: Int) = a * b\n\nfun main() {\n    println(carp(4, 5))\n}",
            miniQuestion = MiniQuestion(
                id = "kt_q_3",
                question = "Kotlin'de yeni bir fonksiyon tanımlamak için hangi kelime kullanılır?",
                options = listOf("fun", "func", "function", "def"),
                correctIndex = 0,
                explanation = "Kotlin'de fonksiyonlar 'fun' (function) ile başlar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_3",
                lessonId = "kt_3",
                title = "İsimlendirilmiş Selamlayıcı",
                instructions = "isim ve varsayılan degeri 'Merhaba' olan selam parametresi alıp '\$selam, \$isim!' döndüren selamla() fonksiyonunu yazın.",
                exampleInput = "selamla(\"Murat\")",
                exampleOutput = "'Merhaba, Murat!'",
                starterCode = "fun selamla(isim: String, selam: String = \"Merhaba\"): String {\n    // Kodunu yaz:\n    return \"\"\n}",
                solutionCode = "fun selamla(isim: String, selam: String = \"Merhaba\"): String {\n    return \"\$selam, \$isim!\"\n}",
                hints = listOf("\"\$selam, \$isim!\" döndürün."),
                testCases = listOf(
                    TestCase("selamla(\"Murat\")", "Merhaba, Murat!", "Varsayılan"),
                    TestCase("selamla(\"Ece\", \"Günaydın\")", "Günaydın, Ece!", "Özel")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_3_1",
                    lessonId = "kt_3",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Tek satırlık bir fonksiyonda süslü parantez ve return yerine ne kullanılır?",
                    options = listOf("= (eşittir)", "-> (ok)", "=>", ":="),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! 'fun topla(a: Int, b: Int) = a + b' şeklinde eşittir kullanılır.",
                    explanationWrong = "Tek satırlık fonksiyonlarda = kullanılır.",
                    reviewTopic = "Kotlin Fonksiyonlar"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Değer döndürmeyen fonksiyonların tipi nedir?",
                    answer = "Kotlin'de hiçbir şey döndürmeyen fonksiyonların dönüş tipi 'Unit'tir (Java'daki void gibi)."
                )
            ),
            completionCriteria = listOf(
                "fun ile fonksiyon yazabilmek",
                "Tek satırlık = fonksiyonlarını kullanabilmek"
            )
        ),

        // ==========================================
        // DERS 4: LİSTELER VE KOLEKSİYONLAR
        // ==========================================
        Lesson(
            id = "kt_4",
            courseId = "kt",
            sectionId = "kt_sec_2",
            title = "Koleksiyonlar: Listeler, filter ve map",
            shortDesc = "Değişmeyen listOf ile güvenli listeler, filter ve map ile hızlı veri işleme.",
            level = CourseLevel.BEGINNER,
            order = 4,
            isPremium = true,
            learningObjectives = listOf(
                "listOf (sabit) ve mutableListOf (değişebilir) listeleri öğrenmek",
                "filter ile liste elemanlarını filtrelemek",
                "map ile elemanları dönüştürmek"
            ),
            prerequisites = listOf("Fonksiyonlar"),
            subtopics = listOf("listOf vs mutableListOf", "filter ile Seçme", "map ile Dönüştürme"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Sabit ve Değişebilir Listeler",
                    body = "Kotlin güvenliğe çok önem verir:\n\n• `listOf(\"A\", \"B\")`: Eleman eklenemeyen, silinemeyen sabit listedir.\n• `mutableListOf(\"A\", \"B\")`: Sonradan `.add()` ile eleman eklenebilen listedir.",
                    codeSnippet = "val diller = listOf(\"Kotlin\", \"Java\", \"Dart\")\n// diller.add(\"C++\") -> HATA! listOf sabittir.\n\nval sehirler = mutableListOf(\"İzmir\")\nsehirler.add(\"Ankara\") // Geçerli!"
                ),
                LessonContentBlock(
                    subtitle = "2. filter ve map Yetenekleri",
                    body = "Listeleri işlemek için döngü yazmak yerine `filter` (seç) ve `map` (dönüştür) kullanırız. Listenin her elemanını temsil etmek için sihirli `it` kelimesi kullanılır!",
                    codeSnippet = "val sayilar = listOf(1, 2, 3, 4, 5, 6)\n\n// Çiftleri seç ve karelerini al:\nval ciftKareler = sayilar\n    .filter { it % 2 == 0 } // [2, 4, 6]\n    .map { it * it }        // [4, 16, 36]\n\nprintln(ciftKareler) // [4, 16, 36]"
                )
            ),
            codeExample = "fun main() {\n    val isimler = listOf(\"ali\", \"ayşe\", \"mehmet\")\n    val buyukler = isimler.map { it.uppercase() }\n    println(buyukler) // [ALI, AYŞE, MEHMET]\n}",
            codeExplanation = "map { it.uppercase() } ile tüm isimler büyük harfe dönüştürüldü.",
            realWorldExample = "Android uygulamasında arama çubuğuna harf yazıldığında ürün listesini filtrelemek için .filter { it.contains(arama) } kullanılır.",
            practicalTask = "Sayı listesindeki pozitif sayıları filtreleyip iki katını alan bir kod yazın.",
            starterPlaygroundCode = "fun main() {\n    val liste = listOf(-2, 5, -1, 3)\n    val sonuc = liste.filter { it > 0 }.map { it * 2 }\n    println(sonuc)\n}",
            miniQuestion = MiniQuestion(
                id = "kt_q_4",
                question = "Kotlin'de tek parametreli lambdalarda o anki elemanı temsil eden varsayılan kelime nedir?",
                options = listOf("it", "this", "item", "el"),
                correctIndex = 0,
                explanation = "Kotlin lambdalarında tek parametre otomatik olarak 'it' adını alır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_4",
                lessonId = "kt_4",
                title = "Pozitif Sayıları Filtrele ve Katla",
                instructions = "Verilen tam sayı listesindeki sadece pozitif (> 0) sayıları seçip 2 katını liste olarak döndüren filtreleVeKatla(sayilar) fonksiyonunu yazın.",
                exampleInput = "listOf(-2, 5, -1, 3)",
                exampleOutput = "[10, 6]",
                starterCode = "fun filtreleVeKatla(sayilar: List<Int>): List<Int> {\n    // Kodunu yaz:\n    return emptyList()\n}",
                solutionCode = "fun filtreleVeKatla(sayilar: List<Int>): List<Int> {\n    return sayilar.filter { it > 0 }.map { it * 2 }\n}",
                hints = listOf("sayilar.filter { it > 0 }.map { it * 2 } ifadesini döndürün."),
                testCases = listOf(
                    TestCase("filtreleVeKatla(listOf(-2, 5, -1, 3))", "[10, 6]", "Filtreleme")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_4_1",
                    lessonId = "kt_4",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Sonradan eleman eklenebilen ve silinebilen liste oluşturmak için hangisi kullanılır?",
                    options = listOf("mutableListOf()", "listOf()", "fixedListOf()", "arrayListOf_readOnly()"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Değiştirilebilir listeler için mutableListOf kullanılır.",
                    explanationWrong = "Değişebilir liste mutableListOf ile üretilir.",
                    reviewTopic = "Kotlin Koleksiyonlar"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Neden varsayılan liste listOf değişmezdir?",
                    answer = "Yanlışlıkla listenin bozulmasını engellemek ve kod güvenliğini en üst düzeye çıkarmak için Kotlin değişmezliği varsayılan yapmıştır."
                )
            ),
            completionCriteria = listOf(
                "listOf ve mutableListOf farkını bilmek",
                "filter ve map ile liste işleyebilmek"
            )
        ),

        // ==========================================
        // DERS 5: DATA CLASS VE NESNELER
        // ==========================================
        Lesson(
            id = "kt_5",
            courseId = "kt",
            sectionId = "kt_sec_3",
            title = "Veri Sınıfları (Data Class) ve Nesneler",
            shortDesc = "Tek satırda model sınıfları kurma ve otomatik equals, hashCode, copy ve toString süper güçleri.",
            level = CourseLevel.INTERMEDIATE,
            order = 5,
            isPremium = true,
            learningObjectives = listOf(
                "class tanımlayıp nesne üretmek",
                "data class'ın sağladığı inanılmaz kolaylıkları keşfetmek",
                "copy() metodu ile verileri kolayca kopyalayıp güncellemek"
            ),
            prerequisites = listOf("Fonksiyonlar ve Koleksiyonlar"),
            subtopics = listOf("Normal Sınıflar (class)", "Süper Kahraman: data class", "copy() Yeteneği"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. data class: Tek Satırda Veri Modeli!",
                    body = "Diğer dillerde bir Kullanıcı veya Ürün sınıfı yazmak için onlarca satır getter, setter, toString ve equals yazmak gerekirdi. Kotlin'de başına `data` yazmanız yeterlidir; her şey tek satırda otomatik oluşur!",
                    codeSnippet = "// Tek satırda eksiksiz veri modeli:\ndata class Kullanici(val id: Int, val ad: String, val sehir: String = \"İstanbul\")\n\nfun main() {\n    val k1 = Kullanici(1, \"Zeynep\")\n    println(k1) // Otomatik şık çıktı: Kullanici(id=1, ad=Zeynep, sehir=İstanbul)\n    \n    // copy() ile kopyalayıp sadece şehri değiştirelim:\n    val k2 = k1.copy(sehir = \"Ankara\")\n    println(k2) // Kullanici(id=1, ad=Zeynep, sehir=Ankara)\n}"
                )
            ),
            codeExample = "data class Urun(val isim: String, val fiyat: Double)\n\nfun main() {\n    val u1 = Urun(\"Kahve\", 45.0)\n    val u2 = Urun(\"Kahve\", 45.0)\n    println(\"Aynı mı: \${u1 == u2}\") // true! data class otomatik içerik karşılaştırır.\n}",
            codeExplanation = "data class otomatik olarak equals oluşturduğu için u1 == u2 doğru (true) sonucunu verdi.",
            realWorldExample = "Android uygulamalarında API'den gelen kullanıcılar, haberler, mesajlar her zaman data class olarak modellenir.",
            practicalTask = "Kitap adında bir data class oluşturup baslik ve yazar alanları ekleyin.",
            starterPlaygroundCode = "data class Kitap(val baslik: String, val yazar: String)\n\nfun main() {\n    val k = Kitap(\"1984\", \"George Orwell\")\n    println(k)\n}",
            miniQuestion = MiniQuestion(
                id = "kt_q_5",
                question = "Kotlin'de bir sınıfın otomatik olarak toString(), equals() ve copy() metotlarına sahip olması için başına ne yazılır?",
                options = listOf("data", "model", "struct", "record"),
                correctIndex = 0,
                explanation = "Kotlin'de 'data class' yazıldığında bu metotlar otomatik üretilir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_5",
                lessonId = "kt_5",
                title = "Kitap Özeti",
                instructions = "baslik ve yazar alanlarına sahip Kitap data class'ını yazın ve 'Başlık - Yazar' formatında metin veren ozet() metodunu ekleyin.",
                exampleInput = "Kitap(\"Simyacı\", \"Paulo Coelho\").ozet()",
                exampleOutput = "'Simyacı - Paulo Coelho'",
                starterCode = "data class Kitap(val baslik: String, val yazar: String) {\n    fun ozet(): String {\n        // Kodunu yaz:\n        return \"\"\n    }\n}",
                solutionCode = "data class Kitap(val baslik: String, val yazar: String) {\n    fun ozet(): String = \"\$baslik - \$yazar\"\n}",
                hints = listOf("\"\$baslik - \$yazar\" döndürün."),
                testCases = listOf(
                    TestCase("Kitap(\"1984\", \"George Orwell\").ozet()", "1984 - George Orwell", "Kitap özeti")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_5_1",
                    lessonId = "kt_5",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "data class'larda var olan bir nesnenin birkaç alanını değiştirerek yenisini üretmeyi sağlayan metot hangisidir?",
                    options = listOf("copy()", "clone()", "duplicate()", "recreate()"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! copy(...) fonksiyonuyla değişmez nesnelerin güncel kopyaları üretilir.",
                    explanationWrong = "copy() metodu kullanılır.",
                    reviewTopic = "Kotlin Data Classes"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "data class'ın birincil kurucusunda en az kaç parametre olmalıdır?",
                    answer = "En az 1 adet val veya var parametresi bulunmalıdır."
                )
            ),
            completionCriteria = listOf(
                "data class tanımlayabilmek",
                "copy() ile nesne güncelleyebilmek"
            )
        ),

        // ==========================================
        // DERS 6: KALITIM VE SEALED CLASSES
        // ==========================================
        Lesson(
            id = "kt_6",
            courseId = "kt",
            sectionId = "kt_sec_3",
            title = "Kalıtım (open) ve Mühürlü Sınıflar (Sealed Class)",
            shortDesc = "Kotlin'de sınıfları miras alma (open) ve durum yönetiminin kralı Sealed Class.",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true,
            learningObjectives = listOf(
                "Kotlin'de sınıfların varsayılan olarak kapalı (final) olduğunu ve miras için 'open' gerektiğini öğrenmek",
                "Sealed Class (Mühürlü Sınıf) ile UI durumlarını (Yükleniyor, Başarılı, Hata) modellemek",
                "when ile tüm durumları eksiksiz yakalamak"
            ),
            prerequisites = listOf("Sınıflar ve Data Class"),
            subtopics = listOf("open Kelimesi ve Kalıtım", "override ile Özelleştirme", "Sealed Class Nedir?"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Kalıtım ve 'open' Anahtarı",
                    body = "Kotlin'de sınıflar güvenlik gereği varsayılan olarak kilitlidir (miras alınamaz). Bir sınıfın miras alınabilmesi için başına açıkça `open` yazılır.",
                    codeSnippet = "open class Hayvan(val isim: String) {\n    open fun sesCikar() = println(\"Ses...\")\n}\n\nclass Kopek(isim: String) : Hayvan(isim) {\n    override fun sesCikar() = println(\"\$isim: Hav hav! 🐶\")\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Sealed Class: Android UI Durumlarının Kalbi",
                    body = "Mobil uygulamada sayfa 3 durumda olabilir: **Yükleniyor**, **Veri Geldi** veya **Hata Oluştu**. `sealed class` ile bu durumları mühürleriz; böylece `when` ifadesi tüm durumların kontrol edildiğini bilir ve asla hata kaçırmaz!",
                    codeSnippet = "sealed class SayfaDurumu {\n    object Yukleniyor : SayfaDurumu()\n    data class Basarili(val veri: String) : SayfaDurumu()\n    data class Hata(val mesaj: String) : SayfaDurumu()\n}\n\nfun durumuGoster(durum: SayfaDurumu) = when (durum) {\n    is SayfaDurumu.Yukleniyor -> \"Dönüyor... ⏳\"\n    is SayfaDurumu.Basarili -> \"Gelen Veri: \${durum.veri} ✅\"\n    is SayfaDurumu.Hata -> \"Hata: \${durum.mesaj} ❌\"\n    // else yazmaya gerek yoktur, tüm durumlar garantidir!\n}"
                )
            ),
            codeExample = "fun main() {\n    val durum = SayfaDurumu.Basarili(\"Kullanıcı Profili\")\n    println(durumuGoster(durum))\n}",
            codeExplanation = "Sealed class ve when ile durum kusursuz bir şekilde yönetildi.",
            realWorldExample = "Jetpack Compose ve Android ViewModel mimarisinde ekran durumları (UiState) daima Sealed Class / Interface ile yönetilir.",
            practicalTask = "Sekil üst sınıfından türeyen ve alan hesaplayan Kare sınıfı yazın.",
            starterPlaygroundCode = "open class Sekil {\n    open fun alan(): Double = 0.0\n}\nclass Kare(val kenar: Double) : Sekil() {\n    override fun alan() = kenar * kenar\n}",
            miniQuestion = MiniQuestion(
                id = "kt_q_6",
                question = "Kotlin'de bir sınıfın başka bir sınıf tarafından miras alınabilmesi için başına hangi kelime yazılmalıdır?",
                options = listOf("open", "public", "extendable", "base"),
                correctIndex = 0,
                explanation = "Kotlin'de sınıflar varsayılan final'dır, miras için 'open' yazılmalıdır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_6",
                lessonId = "kt_6",
                title = "Kare Alanı",
                instructions = "Sekil sınıfından türeyen ve alan() fonksiyonu kenar * kenar döndüren Kare sınıfını yazın.",
                exampleInput = "Kare(5.0).alan()",
                exampleOutput = "25.0",
                starterCode = "open class Sekil {\n    open fun alan(): Double = 0.0\n}\n\nclass Kare(val kenar: Double) : Sekil() {\n    // override fun alan() yazın:\n}",
                solutionCode = "open class Sekil {\n    open fun alan(): Double = 0.0\n}\n\nclass Kare(val kenar: Double) : Sekil() {\n    override fun alan(): Double = kenar * kenar\n}",
                hints = listOf("override fun alan(): Double = kenar * kenar"),
                testCases = listOf(
                    TestCase("Kare(5.0).alan().toInt()", "25", "5 kenarlı kare")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_6_1",
                    lessonId = "kt_6",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Sealed Class kullanmanın when ifadelerindeki en büyük kolaylığı nedir?",
                    options = listOf("Derleyici tüm durumların yazıldığını bildiği için 'else' dalı yazma zorunluluğunu kaldırır", "Sadece sayılarla çalışır", "Daha yavaş çalışır", "Miras alınamaz"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Sealed class sonlu sayıda durumu garanti eder.",
                    explanationWrong = "Sealed class when ile else gerektirmeden tam kapsam sağlar.",
                    reviewTopic = "Kotlin Sealed Classes"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Sealed Interface ile Sealed Class farkı nedir?",
                    answer = "Sealed Interface çoklu kalıtıma izin verir ve bellekte daha hafiftir; modern Kotlin projelerinde çok tercih edilir."
                )
            ),
            completionCriteria = listOf(
                "open ile kalıtım yapabilmek",
                "Sealed Class mantığını ve durum yönetimini kavramak"
            )
        ),

        // ==========================================
        // DERS 7: OBJECT VE SINGLETON
        // ==========================================
        Lesson(
            id = "kt_7",
            courseId = "kt",
            sectionId = "kt_sec_3",
            title = "object ve Companion Object: Tekil Nesneler",
            shortDesc = "Tüm uygulamada tek bir örneği olan Singleton nesneler ve static benzeri Companion Object.",
            level = CourseLevel.INTERMEDIATE,
            order = 7,
            isPremium = true,
            learningObjectives = listOf(
                "object kelimesi ile tek satırda Singleton oluşturmak",
                "companion object ile sınıfa bağlı yardımcı fonksiyonlar yazmak"
            ),
            prerequisites = listOf("Sınıflar"),
            subtopics = listOf("object ile Singleton", "companion object"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. object: Tek Satırda Singleton!",
                    body = "Bir veritabanı yardımcısı veya ayar yöneticisi gibi tüm uygulamada sadece **tek bir kopyası** olması gereken yapılar için `object` kelimesini kullanırız.",
                    codeSnippet = "object VeriTabani {\n    val dbAdi = \"UygulamaDB\"\n    fun baglan() = println(\"\$dbAdi bağlantısı kuruldu.\")\n}\n\nfun main() {\n    // new yapmadan doğrudan ismiyle çağrılır:\n    VeriTabani.baglan()\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. companion object (Sınıfın Sadık Dostu)",
                    body = "Bir sınıfa ait genel sabitleri veya fabrika metotlarını (Java'daki `static` gibi) sınıfın içine `companion object` açarak yazarız.",
                    codeSnippet = "class Kullanici(val ad: String) {\n    companion object {\n        const val MIN_YAS = 18\n        fun misafirOlustur() = Kullanici(\"Misafir\")\n    }\n}\n\nfun main() {\n    val k = Kullanici.misafirOlustur()\n    println(\"Adı: \${k.ad}, Min Yaş: \${Kullanici.MIN_YAS}\")\n}"
                )
            ),
            codeExample = "object Ayarlar {\n    var karanlikMod = true\n}\n\nfun main() {\n    println(\"Karanlık Mod: \${Ayarlar.karanlikMod}\")\n}",
            codeExplanation = "object ile tekil bir Ayarlar nesnesi oluşturuldu ve doğrudan erişildi.",
            realWorldExample = "Android Retrofit ağ isteklerinde ApiClient nesnesi companion object veya object ile tekil tutulur.",
            practicalTask = "Matematik adında bir object açıp içine pi sabiti ve kareAl fonksiyonu ekleyin.",
            starterPlaygroundCode = "object Matematik {\n    const val PI = 3.14\n    fun kare(x: Int) = x * x\n}",
            miniQuestion = MiniQuestion(
                id = "kt_q_7",
                question = "Kotlin'de tüm programda yalnızca tek bir örneği (Singleton) olan nesne tanımlamak için hangi kelime kullanılır?",
                options = listOf("object", "singleton", "static", "single"),
                correctIndex = 0,
                explanation = "Kotlin'de 'object' kelimesi doğrudan Singleton nesnesi oluşturur."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_7",
                lessonId = "kt_7",
                title = "Tekil Sayaç Nesnesi",
                instructions = "icinde sayac değişkeni ve artir() metodu bulunan Sayac object nesnesini yazın.",
                exampleInput = "Sayac.artir()",
                exampleOutput = "1",
                starterCode = "object Sayac {\n    var deger = 0\n    fun artir(): Int {\n        // Kodunu yaz:\n        return 0\n    }\n}",
                solutionCode = "object Sayac {\n    var deger = 0\n    fun artir(): Int {\n        deger++\n        return deger\n    }\n}",
                hints = listOf("deger++ yapıp deger döndürün."),
                testCases = listOf(
                    TestCase("Sayac.artir()", "1", "Sayaç artırma")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_7_1",
                    lessonId = "kt_7",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Kotlin'de bir sınıfa static benzeri metotlar eklemek için sınıf içine ne yazılır?",
                    options = listOf("companion object", "static object", "inner class", "data object"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Kotlin'de static yerine companion object kullanılır.",
                    explanationWrong = "companion object kullanılır.",
                    reviewTopic = "Kotlin Companion Object"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "object ile class farkı nedir?",
                    answer = "class'tan istediğiniz kadar yeni nesne üretebilirsiniz (new). object ise zaten kendisi tek bir hazır nesnedir."
                )
            ),
            completionCriteria = listOf(
                "object ile Singleton tanımlayabilmek",
                "companion object kullanımını kavramak"
            )
        ),

        // ==========================================
        // DERS 8: EXTENSION FUNCTIONS VE SCOPE FUNCTIONS
        // ==========================================
        Lesson(
            id = "kt_8",
            courseId = "kt",
            sectionId = "kt_sec_4",
            title = "Uzantılar (Extensions) ve Kapsam Fonksiyonları (let, apply)",
            shortDesc = "Hazır sınıflara yeni metotlar kazandırma ve let, apply ile temiz kod yazma.",
            level = CourseLevel.INTERMEDIATE,
            order = 8,
            isPremium = true,
            learningObjectives = listOf(
                "Extension Function ile String veya Int gibi sınıflara yeni fonksiyon eklemek",
                "let ile null kontrolü yapıp işlem yürütmek",
                "apply ile nesne özelliklerini tek blokta ayarlamak"
            ),
            prerequisites = listOf("Fonksiyonlar ve Sınıflar"),
            subtopics = listOf("Extension Functions", "let Kapsam Fonksiyonu", "apply ve also"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Extension Functions: Sınıflara Yeni Yetenekler",
                    body = "String sınıfına dokunmadan ona kendi fonksiyonunuzu ekleyebilirsiniz!",
                    codeSnippet = "// String sınıfına unlemEkle metodu ekleyelim:\nfun String.unlemEkle(): String = \"\$this!\"\n\nfun main() {\n    val mesaj = \"Merhaba\"\n    println(mesaj.unlemEkle()) // Merhaba!\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Süper Pratik 'let' ve 'apply'",
                    body = "• **let:** Değişken null değilse bloğu çalıştırır (`?.let { ... }`).\n• **apply:** Bir nesneyi oluştururken tüm ayarlarını tek bir blokta şıkça yapmanızı sağlar.",
                    codeSnippet = "val email: String? = \"ahmet@kod.com\"\nemail?.let {\n    println(\"Email gönderiliyor: \$it\")\n}"
                )
            ),
            codeExample = "fun Int.kare(): Int = this * this\n\nfun main() {\n    println(5.kare()) // 25\n}",
            codeExplanation = "Int sınıfına .kare() uzantı fonksiyonu eklendi.",
            realWorldExample = "Android'de `view.visible()` veya `context.showToast(\"...\")` gibi uzantılar Extension ile yazılır.",
            practicalTask = "String sınıfına ilk harfi büyük yapan bir extension fonksiyonu yazın.",
            starterPlaygroundCode = "fun String.ilkHarfBuyuk() = this.replaceFirstChar { it.uppercase() }",
            miniQuestion = MiniQuestion(
                id = "kt_q_8",
                question = "Kotlin'de mevcut bir sınıfa kaynak kodunu değiştirmeden yeni fonksiyon eklemeye ne ad verilir?",
                options = listOf("Extension Function", "Inheritance", "Lambda", "Override"),
                correctIndex = 0,
                explanation = "Mevcut tiplere yeni fonksiyon eklemeye Extension Function (Genişletme Fonksiyonu) denir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_8",
                lessonId = "kt_8",
                title = "String Ünlem Uzantısı",
                instructions = "String sınıfına bu metnin sonuna '!' ekleyen unlemEkle() extension fonksiyonunu yazın.",
                exampleInput = "\"Selam\".unlemEkle()",
                exampleOutput = "'Selam!'",
                starterCode = "fun String.unlemEkle(): String {\n    // Kodunu yaz:\n    return \"\"\n}",
                solutionCode = "fun String.unlemEkle(): String = \"\$this!\"",
                hints = listOf("\"\$this!\" döndürün."),
                testCases = listOf(
                    TestCase("\"Kod\".unlemEkle()", "Kod!", "Ünlem")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_8_1",
                    lessonId = "kt_8",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir değişken null DEĞİLSE bir kod bloğunu güvenle çalıştırmak için en çok hangi kalıp kullanılır?",
                    options = listOf("degisken?.let { ... }", "degisken.run { ... }", "degisken.apply { ... }", "if (null)"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! 'degisken?.let' kalıbı Kotlin'in en sevilen null-safe yapısıdır.",
                    explanationWrong = "degisken?.let { ... } kullanılır.",
                    reviewTopic = "Kotlin Kapsam Fonksiyonları"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Extension fonksiyon orijinal sınıfı bozar mı?",
                    answer = "Hayır, Extension'lar sadece derleme zamanında pratiklik sağlayan sentetik yardımcı fonksiyonlardır."
                )
            ),
            completionCriteria = listOf(
                "Extension fonksiyon yazabilmek",
                "?.let { } kalıbını kullanabilmek"
            )
        ),

        // ==========================================
        // DERS 9: ASENKRON KOTLIN (Coroutines)
        // ==========================================
        Lesson(
            id = "kt_9",
            courseId = "kt",
            sectionId = "kt_sec_5",
            title = "Coroutines ve suspend: Donmayan Android Uygulamaları",
            shortDesc = "İnternetten veri çekerken ekranın kilitlenmesini engelleyen ultra hafif Coroutines mimarisi.",
            level = CourseLevel.ADVANCED,
            order = 9,
            isPremium = true,
            learningObjectives = listOf(
                "Coroutines kavramını ve geleneksel Thread'lerden neden bin kat hafif olduğunu anlamak",
                "suspend fonksiyonlar ile duraklatılabilir işlemler yazmak",
                "delay() ile donmayan beklemeler yapmak"
            ),
            prerequisites = listOf("Fonksiyonlar ve Sınıflar"),
            subtopics = listOf("Coroutines Nedir?", "suspend Fonksiyonlar", "delay vs Thread.sleep"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Coroutines Nedir? (Tüy Kadar Hafif İşçiler)",
                    body = "Eski usul iş parçacıkları (Threads) bellekte çok yer kaplar ve telefonun pilini hızlı tüketir. Kotlin'in **Coroutines** teknolojisi ise tüy kadar hafiftir; aynı anda 100.000 tane Coroutine başlatsanız bile telefon zerre kasmaz!",
                    codeSnippet = "// Duraklatılabilir asenkron fonksiyon:\nsuspend fun veriIndir(): String {\n    kotlinx.coroutines.delay(1000) // 1 saniye bekle ama ekranı dondurma!\n    return \"İnternetten gelen veri 📲\"\n}"
                )
            ),
            codeExample = "suspend fun selamVer(): String {\n    return \"Coroutines ile Merhaba!\"\n}\n\nfun main() {\n    // runBlocking veya viewModelScope ile çağrılır\n}",
            codeExplanation = "suspend kelimesi fonksiyonun duraklatılabilir asenkron bir görev olduğunu belirtir.",
            realWorldExample = "Android'de Retrofit ile sunucudan veri çekerken API fonksiyonları `suspend fun getKullanicilar(): List<User>` şeklinde yazılır.",
            practicalTask = "suspend anahtar kelimesi ile 1 saniye bekleyip sonuç veren bir fonksiyon tanımlayın.",
            starterPlaygroundCode = "suspend fun gorevYap(): String {\n    return \"Görev Bitti\"\n}",
            miniQuestion = MiniQuestion(
                id = "kt_q_9",
                question = "Kotlin'de bir fonksiyonun Coroutines içinde duraklatılabilir (asenkron) olduğunu belirtmek için başına hangi kelime yazılır?",
                options = listOf("suspend", "async", "await", "coroutine"),
                correctIndex = 0,
                explanation = "Kotlin'de duraklatılabilir fonksiyonlar 'suspend fun' ile tanımlanır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_9",
                lessonId = "kt_9",
                title = "Asenkron Selamlama",
                instructions = "suspend fun olarak tanımlanan ve 'Merhaba, \$isim!' döndüren asenkronSelam(isim) fonksiyonunu yazın.",
                exampleInput = "asenkronSelam(\"Merve\")",
                exampleOutput = "'Merhaba, Merve!'",
                starterCode = "suspend fun asenkronSelam(isim: String): String {\n    // Kodunu yaz:\n    return \"\"\n}",
                solutionCode = "suspend fun asenkronSelam(isim: String): String {\n    return \"Merhaba, \$isim!\"\n}",
                hints = listOf("\"Merhaba, \$isim!\" döndürün."),
                testCases = listOf(
                    TestCase("asenkronSelam(\"Merve\")", "Merhaba, Merve!", "Asenkron test")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_9_1",
                    lessonId = "kt_9",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "suspend fonksiyonlar nereden çağrılabilir?",
                    options = listOf("Yalnızca başka bir suspend fonksiyonun içinden veya bir Coroutine kapsamından", "Herhangi bir normal fonksiyondan doğrudan", "Sadece main()'den", "Sadece sınıflardan"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! suspend fonksiyonlar sadece coroutine kapsamı içinden çalıştırılabilir.",
                    explanationWrong = "suspend fonksiyonlar coroutine kapsamı gerektirir.",
                    reviewTopic = "Kotlin Coroutines"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "delay() ile Thread.sleep() farkı nedir?",
                    answer = "Thread.sleep tüm işlemi dondurur. delay() ise iş parçacığını serbest bırakır, başka işlerin çalışmasına izin verir."
                )
            ),
            completionCriteria = listOf(
                "suspend anahtar kelimesini bilmek",
                "Coroutines'in hafifliğini kavramak"
            )
        ),

        // ==========================================
        // DERS 10: VERİ AKIŞLARI (Kotlin Flow)
        // ==========================================
        Lesson(
            id = "kt_10",
            courseId = "kt",
            sectionId = "kt_sec_5",
            title = "Kotlin Flow: Canlı ve Sürekli Veri Akışları",
            shortDesc = "Canlı sohbet mesajları, borsa kurları veya sayaç gibi sürekli akan verileri Flow ile dinleyin.",
            level = CourseLevel.ADVANCED,
            order = 10,
            isPremium = true,
            learningObjectives = listOf(
                "Flow (Veri Akışı) mantığını kavramak",
                "flow { emit(...) } ile canlı veri yaymak",
                "collect ile verileri ekranda yakalamak"
            ),
            prerequisites = listOf("Coroutines ve suspend"),
            subtopics = listOf("Flow Nedir?", "emit ile Veri Fırlatma", "collect ile Dinleme"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Flow Nedir? (Canlı Yayın Akışı)",
                    body = "Tek bir değer için `suspend fun` yeterlidir. Ancak zaman içinde birden çok veri akacaksa (örneğin kronometre saniyeleri veya canlı bildirimler) **Kotlin Flow** kullanırız.",
                    codeSnippet = "import kotlinx.coroutines.flow.*\n\n// 1'den 3'e kadar her saniye sayı akıtan Flow:\nfun sayacFlow(): Flow<Int> = flow {\n    for (i in 1..3) {\n        kotlinx.coroutines.delay(1000)\n        emit(i) // 'Yeni veriyi akışa bırak' demektir\n    }\n}"
                )
            ),
            codeExample = "import kotlinx.coroutines.flow.*\n\nfun bildirimler(): Flow<String> = flow {\n    emit(\"Yeni mesajınız var! 💬\")\n    emit(\"Arkadaşınız beğendi ❤️\")\n}",
            codeExplanation = "emit ile veriler akışa bırakıldı.",
            realWorldExample = "Android Jetpack Compose ve Room veritabanı, tablodaki her değişiklikte ekranı otomatik güncellemek için Flow döndürür.",
            practicalTask = "1'den 5'e kadar sayıları emit eden bir flow fonksiyonu yazın.",
            starterPlaygroundCode = "import kotlinx.coroutines.flow.*\nfun sayiAkisi() = flow { for (i in 1..5) emit(i) }",
            miniQuestion = MiniQuestion(
                id = "kt_q_10",
                question = "Kotlin Flow içinde yeni bir veriyi akışa fırlatmak için hangi fonksiyon kullanılır?",
                options = listOf("emit()", "send()", "yield()", "push()"),
                correctIndex = 0,
                explanation = "Flow içinde veri yaymak için 'emit()' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_10",
                lessonId = "kt_10",
                title = "Geri Sayım Flow'u",
                instructions = "n'den 1'e kadar geriye doğru sayan ve emit ile fırlatan geriSayim(n) flow fonksiyonunu yazın.",
                exampleInput = "geriSayim(3)",
                exampleOutput = "3, 2, 1",
                starterCode = "import kotlinx.coroutines.flow.*\n\nfun geriSayim(n: Int): Flow<Int> = flow {\n    // Kodunu yaz:\n}",
                solutionCode = "import kotlinx.coroutines.flow.*\n\nfun geriSayim(n: Int): Flow<Int> = flow {\n    for (i in n downTo 1) emit(i)\n}",
                hints = listOf("for (i in n downTo 1) emit(i) kullanın."),
                testCases = listOf(
                    TestCase("geriSayim(3)", "3, 2, 1", "Geri sayım")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_10_1",
                    lessonId = "kt_10",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir Flow'dan gelen verileri tüketip ekranda göstermek için hangi metot çağrılır?",
                    options = listOf("collect()", "get()", "fetch()", "listen()"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Flow verileri 'collect { ... }' ile toplanır/dinlenir.",
                    explanationWrong = "collect { } çağrısı kullanılır.",
                    reviewTopic = "Kotlin Flow"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "StateFlow nedir?",
                    answer = "StateFlow, her zaman en son güncel değeri hafızasında tutan ve UI ekranlarına yayınlayan özel bir Flow türüdür."
                )
            ),
            completionCriteria = listOf(
                "Flow ve emit mantığını kavramak",
                "collect ile veriyi yakalayabilmek"
            )
        ),

        // ==========================================
        // DERS 11: KANALLAR (Channels)
        // ==========================================
        Lesson(
            id = "kt_11",
            courseId = "kt",
            sectionId = "kt_sec_6",
            title = "Kanallar (Channels): Coroutines Arası Mesajlaşma",
            shortDesc = "Farklı işçiler arasında veri boruları (borular) kurarak güvenli mesajlaşma.",
            level = CourseLevel.EXPERT,
            order = 11,
            isPremium = true,
            learningObjectives = listOf(
                "Channel (Kanal) kavramını anlamak",
                "send ve receive ile veri aktarmak"
            ),
            prerequisites = listOf("Coroutines ve Flow"),
            subtopics = listOf("Channel Nedir?", "send ve receive"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Channel: İki İşçi Arasındaki Boru Hattı",
                    body = "Bir Coroutine veri üretirken diğer Coroutine bu veriyi işlemek istiyorsa aralarına bir `Channel` (Kanal borusu) kurarız. Biri `send` ile içine atar, diğeri `receive` ile alır.",
                    codeSnippet = "import kotlinx.coroutines.channels.Channel\n\nval kanal = Channel<String>()\n\n// İşçi 1: kanal.send(\"Sipariş 1\")\n// İşçi 2: val siparis = kanal.receive()"
                )
            ),
            codeExample = "fun main() {\n    // Channel örnek kullanımı\n    println(\"Kanal Mimarisi Hazır!\")\n}",
            codeExplanation = "Channel iki asenkron görev arasında güvenli köprü kurar.",
            realWorldExample = "Oyunlarda arka planda indirilen grafik modellerini ana sahneye sırayla aktarırken Channel kullanılır.",
            practicalTask = "Basit bir Channel tanımlayıp veri aktarım mantığını inceleyin.",
            starterPlaygroundCode = "import kotlinx.coroutines.channels.Channel\nval kanal = Channel<Int>()",
            miniQuestion = MiniQuestion(
                id = "kt_q_11",
                question = "Kotlin Channel yapısında kanala veri göndermek için hangi fonksiyon kullanılır?",
                options = listOf("send()", "emit()", "push()", "put()"),
                correctIndex = 0,
                explanation = "Channel'a veri göndermek için 'send()' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_11",
                lessonId = "kt_11",
                title = "Faktöriyel Hesaplayıcı",
                instructions = "Verilen n sayısının faktöriyelini hesaplayan faktoriyel(n) fonksiyonunu yazın.",
                exampleInput = "faktoriyel(5)",
                exampleOutput = "120",
                starterCode = "fun faktoriyel(n: Int): Int {\n    // Kodunu yaz:\n    return 1\n}",
                solutionCode = "fun faktoriyel(n: Int): Int {\n    var f = 1\n    for (i in 2..n) f *= i\n    return f\n}",
                hints = listOf("for (i in 2..n) f *= i döngüsü kurun."),
                testCases = listOf(
                    TestCase("faktoriyel(5)", "120", "5!"),
                    TestCase("faktoriyel(4)", "24", "4!")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_11_1",
                    lessonId = "kt_11",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Channel ile Flow arasındaki temel fark nedir?",
                    options = listOf("Channel tek seferlik tüketilen sıcak bir kuyruktur, Flow ise soğuk bir veri akışıdır", "Channel daha yavaştır", "Flow sadece Android içindir", "Fark yoktur"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Channel kuyruk mantığıyla mesajlaşma sağlar.",
                    explanationWrong = "Channel kuyruk mantığıyla çalışır.",
                    reviewTopic = "Kotlin Channels"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Channel kapatılabilir mi?",
                    answer = "Evet, kanal.close() çağrılarak artık yeni veri gelmeyeceği belirtilebilir."
                )
            ),
            completionCriteria = listOf(
                "Channel mantığını bilmek",
                "send ve receive kullanımını kavramak"
            )
        ),

        // ==========================================
        // DERS 12: HATA YÖNETİMİ VE TEMİZ KOD
        // ==========================================
        Lesson(
            id = "kt_12",
            courseId = "kt",
            sectionId = "kt_sec_6",
            title = "Hata Yakalama ve Profesyonel Android İpuçları",
            shortDesc = "try-catch, runCatching ile çökmeyen yapılar ve Android geliştirici standartları.",
            level = CourseLevel.EXPERT,
            order = 12,
            isPremium = true,
            learningObjectives = listOf(
                "try-catch-finally ile hataları güvenle yakalamak",
                "Kotlin'in süper pratik runCatching fonksiyonunu öğrenmek",
                "Tebrikler: Artık tam donanımlı bir Kotlin geliştiricisisiniz!"
            ),
            prerequisites = listOf("Tüm Kotlin Konuları"),
            subtopics = listOf("try-catch ve finally", "runCatching Pratiği", "Profesyonel Kodlama İpuçları"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Güvenli Hata Yakalama (try-catch ve runCatching)",
                    body = "Beklenmedik bir hata olduğunda uygulamanın kapanmaması için kodları `try-catch` içine alabilir veya Kotlin'in modern `runCatching` fonksiyonunu kullanabiliriz.",
                    codeSnippet = "fun sayiCevir(metin: String): Int {\n    return try {\n        metin.toInt()\n    } catch (e: Exception) {\n        -1 // Hata olursa -1 döner\n    }\n}\n\n// runCatching ile modern yöntem:\nval sonuc = runCatching { \"123\".toInt() }.getOrDefault(0)"
                ),
                LessonContentBlock(
                    subtitle = "2. Tebrikler! Kotlin Ustası Oldunuz! 🏆",
                    body = "Artık değişkenlerden veri sınıflarına, Coroutines'ten Flow mimarisine kadar modern Android geliştirmenin tüm gereksinimlerine hakimsiniz. Şimdi Jetpack Compose ile hayalinizdeki Android uygulamalarını inşa etme zamanı! 📱🚀"
                )
            ),
            codeExample = "fun main() {\n    val sonuc = runCatching { 10 / 0 }.getOrElse { 0 }\n    println(\"Güvenli Sonuç: \$sonuc\") // 0\n}",
            codeExplanation = "runCatching ile sıfıra bölme hatası yakalandı ve varsayılan 0 döndürüldü.",
            realWorldExample = "Android'de internetten JSON verisi ayrıştırılırken (JSON parse) veri bozuksa uygulamanın çökmemesi için runCatching kullanılır.",
            practicalTask = "Geçersiz bir metni sayıya çevirmeyi deneyip hatayı yakalayan bir try-catch bloğu yazın.",
            starterPlaygroundCode = "fun main() {\n    try {\n        val sayi = \"abc\".toInt()\n    } catch (e: Exception) {\n        println(\"Hata yakalandı!\")\n    }\n}",
            miniQuestion = MiniQuestion(
                id = "kt_q_12",
                question = "Kotlin'de bir kod bloğunu deneyip hata durumunda yedek değer döndürmeyi sağlayan modern fonksiyon hangisidir?",
                options = listOf("runCatching", "catchAll", "safeRun", "guard"),
                correctIndex = 0,
                explanation = "runCatching { ... }.getOrDefault(...) yapısı Kotlin'de çok popülerdir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_12",
                lessonId = "kt_12",
                title = "Güvenli Sayı Çevirici",
                instructions = "Verilen metni sayıya çevirmeye çalışan, başarısız olursa -1 döndüren guvenliCevir(metin) fonksiyonunu yazın.",
                exampleInput = "guvenliCevir(\"42\")",
                exampleOutput = "42",
                starterCode = "fun guvenliCevir(metin: String): Int {\n    // try-catch ile yazın:\n    return 0\n}",
                solutionCode = "fun guvenliCevir(metin: String): Int {\n    return try {\n        metin.toInt()\n    } catch (e: Exception) {\n        -1\n    }\n}",
                hints = listOf("try { metin.toInt() } catch(e: Exception) { -1 } kullanın."),
                testCases = listOf(
                    TestCase("guvenliCevir(\"42\")", "42", "Geçerli sayı"),
                    TestCase("guvenliCevir(\"abc\")", "-1", "Hatalı metin")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_12_1",
                    lessonId = "kt_12",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir try-catch yapısında hata meydana gelse de gelmese de kesinlikle çalışan blok hangisidir?",
                    options = listOf("finally", "catch", "else", "always"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! finally bloğu her halükarda en sonda çalışır.",
                    explanationWrong = "finally bloğu her durumda çalışır.",
                    reviewTopic = "Kotlin Hata Yönetimi"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Kotlin'de Checked Exception zorunluluğu var mıdır?",
                    answer = "Hayır! Java'dan farklı olarak Kotlin'de tüm istisnalar Unchecked'tir; bu sayede kodunuz gereksiz throws kalabalığıyla boğulmaz."
                )
            ),
            completionCriteria = listOf(
                "try-catch ve runCatching mantığını bilmek",
                "Temiz ve çökmeyen Kotlin uygulamaları yazabilmek"
            )
        )
    )
}
