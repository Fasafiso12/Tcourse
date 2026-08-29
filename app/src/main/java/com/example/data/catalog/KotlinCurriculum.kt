package com.example.data.catalog

import com.example.model.*

/**
 * Kotlin Kapsamlı & Pedagojik Müfredatı (12 Adım):
 * Resmi Android/Kotlin dokümanları, StackOverflow ve Reddit r/androiddev deneyimleriyle zenginleştirilmiş,
 * teknik terimleri sade ve anlaşılır bir üslupla serpiştiren eksiksiz Kotlin eğitimi.
 */
object KotlinCurriculum {

    fun getSections(): List<CourseSection> = listOf(
        CourseSection(
            id = "kt_sec_1",
            courseId = "kotlin",
            title = "Bölüm 1: Kotlin Temelleri, Mantığı ve Bellek Güvenliği",
            level = CourseLevel.BEGINNER,
            order = 1,
            description = "Kotlin dünyasına sağlam bir adım: Değişmezlik (Immutability), Tür Çıkarımı (Type Inference) ve Milyar Dolarlık Hatayı çözen Null Safety mimarisi.",
            learningObjectives = listOf("val ve var arasındaki bellek ve mantık farkını kavramak", "NullPointerException çökmesini Elvis (?:) ile sıfıra indirmek", "String Template mekanizmasını anlamak"),
            prerequisites = listOf("Ön bilgi gerekmez! Merak ve temel mantık yeterlidir.")
        ),
        CourseSection(
            id = "kt_sec_2",
            courseId = "kotlin",
            title = "Bölüm 2: Kontrol Akışı, Döngüler ve Fonksiyonel Düşünce",
            level = CourseLevel.BEGINNER,
            order = 2,
            description = "İfade tabanlı when ve if yapıları, akıllı döngüler ve tek satırlık (Single-expression) fonksiyon mimarisi.",
            learningObjectives = listOf("when ifadesini desen eşleme mantığıyla kullanmak", "Fonksiyonları first-class citizen (birinci sınıf vatandaş) olarak anlamak", "Varsayılan parametrelerle temiz API'ler oluşturmak"),
            prerequisites = listOf("Kotlin Değişkenleri")
        ),
        CourseSection(
            id = "kt_sec_3",
            courseId = "kotlin",
            title = "Bölüm 3: Nesne Yönelim (OOP) ve Veri Modelleri (Data Class)",
            level = CourseLevel.INTERMEDIATE,
            order = 3,
            description = "Sınıflar (Class), otomatik equals/hashCode üreten Data Class'lar ve güvenli durum yönetimi sunan Sealed Class yapıları.",
            learningObjectives = listOf("Constructor (Kurucu) ve Property mantığını kavramak", "Data Class'ın hafıza ve kopyalama avantajlarını bilmek", "Sealed Class ile UI durumlarını hatasız modellemek"),
            prerequisites = listOf("Fonksiyonlar ve Döngüler")
        ),
        CourseSection(
            id = "kt_sec_4",
            courseId = "kotlin",
            title = "Bölüm 4: Uzantı Fonksiyonları (Extensions) ve Kapsam Araçları",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            description = "Miras almadan sınıflara yetenek katan Extension fonksiyonları ve let, apply, run gibi Scope Functions dünyası.",
            learningObjectives = listOf("Extension Functions ile temiz kod yazmak", "let ve apply arasındaki context farkını kavramak"),
            prerequisites = listOf("Sınıflar ve Nesneler")
        ),
        CourseSection(
            id = "kt_sec_5",
            courseId = "kotlin",
            title = "Bölüm 5: Asenkron Programlama (Coroutines) ve Reaktif Akış (Flow)",
            level = CourseLevel.ADVANCED,
            order = 5,
            description = "Android arayüzünün donmasını engelleyen Coroutines (suspend) ve veri akışlarını yöneten StateFlow mimarisi.",
            learningObjectives = listOf("Thread bloklamadan suspend mantığını anlamak", "Dispatchers.IO ve Dispatchers.Main ayrımını bilmek", "Flow ile canlı veri akışları yönetmek"),
            prerequisites = listOf("Fonksiyonlar ve Sınıflar")
        ),
        CourseSection(
            id = "kt_sec_6",
            courseId = "kotlin",
            title = "Bölüm 6: İleri Düzey Mimari, Hata Yönetimi ve Temiz Kod",
            level = CourseLevel.EXPERT,
            order = 6,
            description = "Robust hata yakalama (Result & try-catch), mülakat püf noktaları ve profesyonel Android mimari prensipleri.",
            learningObjectives = listOf("Result monad yapısıyla güvenli hata yönetimi", "Temiz kod ve bellek optimizasyonu"),
            prerequisites = listOf("Tüm Temel ve Orta Konular")
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
            title = "Kotlin Mantığı: Değişkenler (val/var) ve Null Güvenliği",
            shortDesc = "Değişmezlik (Immutability), Tür Çıkarımı (Type Inference) ve çökmeleri tarihe gömen Null Safety mimarisi.",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false,
            learningObjectives = listOf(
                "val (değişmez/immutable) ve var (değişken/mutable) mantığını kavramak",
                "Derleyicinin Tür Çıkarımı (Type Inference) yeteneğini anlamak",
                "Milyar dolarlık hata (NullPointerException) sorununu ve Güvenli Çağrıyı (?.) kavramak",
                "Elvis Operatörü (?:) ile varsayılan değer mantığını oturtmak"
            ),
            prerequisites = listOf("Ön koşul gerekmez."),
            subtopics = listOf("Neden Kotlin?", "val vs var (Bellek Mantığı)", "Tür Çıkarımı (Type Inference)", "Null Safety (? ve ?:)", "String Şablonları"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Temel Mantık: Neden val Tercih Edilir?",
                    body = "Kotlin'de bir değişken tanımlarken iki seçeneğimiz vardır: `val` ve `var`.\n\n• **val (Value / Değer):** Bir kez atandıktan sonra bir daha asla değiştirilemez. Programlamada buna **Değişmezlik (*Immutability*)** denir. Değişmez değişkenler, özellikle çok iş parçacıklı (*Multi-threading*) ortamlarda beklenmedik yan etkileri (*Side-effects*) sıfırlar.\n• **var (Variable / Değişken):** Değeri sonradan güncellenebilen kutudur.\n\nKotlin topluluğundaki altın kural şudur: **Varsayılan olarak her zaman `val` kullanın; yalnızca değeri gerçekten değişmek zorundaysa `var` yapın.**",
                    codeSnippet = "val dogumYili = 2000 // Sabit - Değiştirilemez\n// dogumYili = 2001 -> Derleme Hatası (Val cannot be reassigned)\n\nvar aktifKullanici = 10\naktifKullanici = 11 // Geçerli - Güncellenebilir",
                    tip = "val değişkenler performans ve kod güvenliği açısından her zaman ilk tercihiniz olmalıdır."
                ),
                LessonContentBlock(
                    subtitle = "2. Tür Çıkarımı (Type Inference) Nedir?",
                    body = "Kotlin akıllı bir dildir. Bir değişkene `\"Ahmet\"` değerini verdiğinizde, onun bir `String` (Metin) olduğunu derleme anında anlar. Bu özelliğe **Tür Çıkarımı (*Type Inference*)** denir. Yani her seferinde tipi uzun uzun yazmak zorunda kalmazsınız; ancak Kotlin yine de arka planda **Statik Tipli (*Statically Typed*)** ve son derece güvenlidir.",
                    codeSnippet = "val isim = \"Deniz\"    // Derleyici tipini otomatik String yapar\nval yas = 24           // Otomatik Int (Tamsayı) olur\nval bakiye = 1450.50   // Otomatik Double (Ondalıklı) olur"
                ),
                LessonContentBlock(
                    subtitle = "3. Null Güvenliği: Milyar Dolarlık Hatanın Çözümü",
                    body = "Yazılım tarihinde en çok uygulamanın çökmesine yol açan sorun *NullPointerException* (boş referans hatası) olmuştur. Kotlin bu sorunu dil seviyesinde çözer.\n\nKotlin'de hiçbir değişken varsayılan olarak `null` (boş/tanımsız) olamaz. Bir değişkenin null olabilmesini özellikle istiyorsanız, tipinin yanına soru işareti (`?`) koyarak bunu açıkça belirtirsiniz (*Nullable Type*).\n\nEğer bir değer null ise yedek bir varsayılan değer sunmak içinse **Elvis Operatörü (`?:`)** kullanılır.",
                    codeSnippet = "var sehir: String = \"İstanbul\" // Asla null olamaz\n// sehir = null -> DERLEME HATASI! Güvenlik devrede.\n\nvar unvan: String? = null // '?' sayesinde null olabilir\n\n// Elvis (?:) ile yedek değer:\nval gosterilecekUnvan = unvan ?: \"Belirtilmedi\"\nprintln(\"Kullanıcı Ünvanı: \$gosterilecekUnvan\") // Belirtilmedi basar",
                    tip = "Elvis operatörü (?:), ismini yandan bakıldığında Elvis Presley'in saç stiline benzediği için almıştır."
                )
            ),
            codeExample = "fun main() {\n    val dil = \"Kotlin\"\n    val surum = 2.0\n    val yazar: String? = null\n    \n    // String şablonu (\$değişken) ve Elvis operatörü bir arada:\n    val yazarBilgisi = yazar ?: \"Topluluk Katkısı\"\n    println(\"\$dil \$surum dili hazır! Yazar: \$yazarBilgisi\")\n}",
            codeExplanation = "val ile sabitler oluşturuldu, yazar nullable olarak tanımlandı ve Elvis (?:) ile yedek değer atanıp \$ String şablonuyla ekrana yazdırıldı.",
            realWorldExample = "Android'de sunucudan (API) gelen kullanıcı profilinde telefon numarası null gelebilir. Elvis operatörü (?: \"Telefon Girilmedi\") sayesinde uygulama asla çökmez ve arayüze kibar bir varsayılan metin basılır.",
            practicalTask = "adınızı val, yasınızı var olarak tanımlayın. null olabilen sehir (String?) değişkenine null verip Elvis (?: \"Bilinmiyor\") ile ekrana \"Ad: \$ad, Yaş: \$yas, Şehir: \$sehirGoster\" formatında yazdırın.",
            starterPlaygroundCode = "fun main() {\n    val ad = \"Can\"\n    var yas = 25\n    val sehir: String? = null\n    val sehirGoster = sehir ?: \"Bilinmiyor\"\n    println(\"Ad: \$ad, Yaş: \$yas, Şehir: \$sehirGoster\")\n}",
            miniQuestion = MiniQuestion(
                id = "kt_q_1",
                question = "Kotlin'de bir değişkenin null olabilmesine izin vermek için tip bildiriminin sonuna hangi sembol eklenir?",
                options = listOf("?", "!", ":=", "#"),
                correctIndex = 0,
                explanation = "Tipe eklenen '?' işareti (örneğin String?), o değişkenin güvenli bir şekilde null değer alabileceğini gösterir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_1",
                lessonId = "kt_1",
                title = "Güvenli Profil Karşılayıcı",
                instructions = "ad (String) ve opsiyonel unvan (String?) parametrelerini alan, unvan null ise varsayılan olarak 'Geliştirici' unvanını kullanan ve 'Merhaba [ad], Unvan: [unvan]' formatında String döndüren profilKarsila(ad, unvan) fonksiyonunu yazın.",
                exampleInput = "ad = 'Emre', unvan = null",
                exampleOutput = "'Merhaba Emre, Unvan: Geliştirici'",
                starterCode = "fun profilKarsila(ad: String, unvan: String?): String {\n    // Elvis (?:) kullanarak kodunu yaz:\n    return \"\"\n}",
                solutionCode = "fun profilKarsila(ad: String, unvan: String?): String {\n    val netUnvan = unvan ?: \"Geliştirici\"\n    return \"Merhaba \$ad, Unvan: \$netUnvan\"\n}",
                hints = listOf("val netUnvan = unvan ?: \"Geliştirici\" yazıp String template ile döndürün."),
                testCases = listOf(
                    TestCase("profilKarsila(\"Emre\", null)", "Merhaba Emre, Unvan: Geliştirici", "Null unvan"),
                    TestCase("profilKarsila(\"Selin\", \"Mimar\")", "Merhaba Selin, Unvan: Mimar", "Dolu unvan")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_1_1",
                    lessonId = "kt_1",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Kotlin'de 'val' anahtar kelimesi ile oluşturulan bir değişken hakkında aşağıdakilerden hangisi doğrudur?",
                    options = listOf(
                        "Değeri bir kez atandıktan sonra bir daha değiştirilemez (Immutable)",
                        "Sadece sayılar için kullanılabilir",
                        "Değeri her an güncellenebilir",
                        "Otomatik olarak null değerini alır"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Harika! val değişkenler değişmezdir (Immutable), bu sayede kodunuz çok daha güvenli ve hatasız olur.",
                    explanationWrong = "val kelimesi 'value'dan gelir ve sabit/değişmez değerleri tanımlar.",
                    reviewTopic = "Kotlin val vs var"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "val ile const val arasındaki fark nedir?",
                    answer = "val çalışma zamanında (Runtime) hesaplanan bir sabit olabilir (örneğin güncel saati val ile tutabilirsiniz). const val ise sadece derleme zamanında (Compile-time) bilinen sabitler (örneğin BASE_URL = \"https://api.com\") için kullanılır."
                ),
                TopicQAItem(
                    question = "Neden Java yerine Kotlin tercih ediliyor?",
                    answer = "Kotlin %100 Java ile uyumludur (interoperable) ancak Java'ya göre %40 daha az kod yazdırır, NullPointerException çökmelerini engeller ve modern fonksiyonel programlama desteği sunar."
                )
            ),
            communityInsights = listOf(
                CommunityInsight(
                    source = "StackOverflow #1 Android Sorusu",
                    topic = "Neden 'var' yerine her yerde 'val' kullanmamız tavsiye ediliyor?",
                    insight = "Forumdaki yüzlerce kıdemli mühendisin belirttiği gibi: 'Değişkenlerin durumunu (state) takip etmek zordur ama sabitler (val) asla değişmez.' Bir değeri val yaptığınızda başka bir fonksiyonun veya iş parçacığının (thread) o değeri arkadan habersizce değiştirip bug üretme olasılığı sıfıra iner.",
                    commonMistake = "Acemiler her şeye 'var' yazarak başlar, sonra projenin başka yerinde değer beklenmedik şekilde değişince saatlerce hata ayıklamak (debug) zorunda kalır."
                ),
                CommunityInsight(
                    source = "Reddit r/androiddev İpucu",
                    topic = "Force Unwrap (!!) operatöründen neden uzak durmalıyız?",
                    insight = "Kotlin'de 'bu değer kesinlikle null değil, bana güven' demek için '!!' (çift ünlem) kullanılır. Ancak eğer o an değer null gelirse uygulama anında çöker. Topluluktaki altın kural: '!!' yerine her zaman güvenli çağrı (?.) veya Elvis (?:) kullanmaktır.",
                    commonMistake = "Hızlıca derleme hatasını geçmek için 'isim!!' yazmak uygulamanın canlıda kullanıcının elinde patlamasına neden olur."
                )
            ),
            completionCriteria = listOf(
                "val ve var arasındaki bellek mantığını kavramak",
                "Elvis operatörünü (?:) varsayılan değer için kullanabilmek",
                "String şablonları (\$degisken) ile temiz metin oluşturabilmek"
            )
        ),

        // ==========================================
        // DERS 2: KONTROL AKIŞI (when, if) VE DÖNGÜLER
        // ==========================================
        Lesson(
            id = "kt_2",
            courseId = "kotlin",
            sectionId = "kt_sec_2",
            title = "Kontrol Akışı: when, if İfadeleri ve Aralıklar (Ranges)",
            shortDesc = "Kotlin'de if ve when birer ifadedir (Expression). switch-case yerine çok daha güçlü desen eşleme mantığı.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false,
            learningObjectives = listOf(
                "if ve when yapılarının bir değere eşitlenebildiğini (Expression) anlamak",
                "when yapısıyla aralık (in 1..10) ve tip kontrollerini temizce yazmak",
                "for döngüsünde 1..10, until ve step gibi akıllı aralıkları kullanmak"
            ),
            prerequisites = listOf("Kotlin Değişkenleri"),
            subtopics = listOf("İfade (Expression) Mantığı", "when ile Desen Eşleme", "Aralıklar (Ranges: .., until, step)", "for ve while Döngüleri"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. İfade (Expression) vs Deyim (Statement) Mantığı",
                    body = "Eski dillerde `if` bir *deyim*di (sadece kod bloğu çalıştırırdı). Kotlin'de ise `if` ve `when` birer **İfadedir (*Expression*)**. Yani bir hesaplama yapıp doğrudan bir değişkene sonuç olarak atanabilirler!\n\nBu sayede üçlü operatörlere (`condition ? a : b`) ihtiyaç kalmaz, kod çok daha okunaklı hale gelir.",
                    codeSnippet = "val puan = 75\n// if doğrudan bir sonuç üretir ve mesaja atanır:\nval mesaj = if (puan >= 50) \"Geçti\" else \"Kaldı\"\nprintln(mesaj) // Geçti"
                ),
                LessonContentBlock(
                    subtitle = "2. Süper Güçlü Karar Yapısı: when",
                    body = "Diğer dillerdeki hantal `switch-case` ve `break` karmaşası yerine Kotlin'de zarif bir `when` vardır. `when` içinde aralıklar (`in 10..20`), virgülle ayrılmış çoklu durumlar veya tip kontrolleri yapılabilir.",
                    codeSnippet = "val trafikIsigi = \"SARI\"\n\nval aksiyon = when (trafikIsigi) {\n    \"KIRMIZI\" -> \"Dur\"\n    \"SARI\" -> \"Hazırlan\"\n    \"YESIL\" -> \"Geç\"\n    else -> \"Bilinmeyen Işık\"\n}\nprintln(aksiyon) // Hazırlan"
                ),
                LessonContentBlock(
                    subtitle = "3. Aralıklar (Ranges) ile Zihinsel Rahatlık",
                    body = "Döngülerde `i = 0; i < 10; i++` gibi hata yapmaya açık sözdizimleri yerine Kotlin doğal konuşma diline yakın aralıklar sunar:\n\n• `1..5`: 1'den 5'e kadar (1 ve 5 dahil)\n• `1 until 5`: 1'den 4'e kadar (5 hariç)\n• `10 downTo 0 step 2`: 10'dan geriye ikişer ikişer",
                    codeSnippet = "// 1'den 3'e kadar dön:\nfor (adim in 1..3) {\n    println(\"Adım: \$adim\")\n}\n\n// Geriye ikişer git:\nfor (sayi in 6 downTo 2 step 2) {\n    print(\"\$sayi \") // 6 4 2\n}"
                )
            ),
            codeExample = "fun main() {\n    val notu = 88\n    \n    val harfNotu = when (notu) {\n        in 90..100 -> \"AA\"\n        in 80..89  -> \"BA\"\n        in 70..79  -> \"BB\"\n        in 50..69  -> \"CC\"\n        else       -> \"FF\"\n    }\n    \n    println(\"Öğrenci Notu: \$notu -> Harf: \$harfNotu\")\n}",
            codeExplanation = "in 80..89 aralık kontrolüyle öğrencinin harf notu temiz bir şekilde hesaplandı.",
            realWorldExample = "E-ticaret uygulamasında siparişin durumunu (BEKLEMEDE, KARGODA, TESLIM_EDILDI, IPTAL) yönetirken `when` kullanılarak her durum için farklı bir UI kartı çizilir.",
            practicalTask = "1'den 20'ye kadar olan sayılardan hem 3'e hem de 5'e bölünen (örneğin 15) sayıları ekrana yazdıran bir döngü ve if kontrolü yazın.",
            starterPlaygroundCode = "fun main() {\n    for (i in 1..20) {\n        if (i % 3 == 0 && i % 5 == 0) {\n            println(\"3 ve 5'in katı: \$i\")\n        }\n    }\n}",
            miniQuestion = MiniQuestion(
                id = "kt_q_2",
                question = "Kotlin'de 1'den 10'a kadar olan sayıları 10 dahil OLMAYACAK şekilde döngüye sokmak için hangi anahtar kelime kullanılır?",
                options = listOf("until", "downTo", "step", "to"),
                correctIndex = 0,
                explanation = "'1 until 10' ifadesi 1'den 9'a kadar döner, 10'u dahil etmez."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_2",
                lessonId = "kt_2",
                title = "Hız Limiti Cezası Hesaplayıcı",
                instructions = "hiz (Int) parametresi alan ve hız <= 50 ise 'Ceza Yok', hız 51..80 arasında ise 'Hafif Ceza', 80'den büyük ise 'Ağır Ceza' döndüren cezaHesapla(hiz) fonksiyonunu when ifadesiyle yazın.",
                exampleInput = "hiz = 65",
                exampleOutput = "'Hafif Ceza'",
                starterCode = "fun cezaHesapla(hiz: Int): String {\n    // when kullanarak kodunu yaz:\n    return \"\"\n}",
                solutionCode = "fun cezaHesapla(hiz: Int): String {\n    return when {\n        hiz <= 50 -> \"Ceza Yok\"\n        hiz in 51..80 -> \"Hafif Ceza\"\n        else -> \"Ağır Ceza\"\n    }\n}",
                hints = listOf("when { hiz <= 50 -> ... hiz in 51..80 -> ... else -> ... } kullanabilirsiniz."),
                testCases = listOf(
                    TestCase("cezaHesapla(45)", "Ceza Yok", "Normal hız"),
                    TestCase("cezaHesapla(70)", "Hafif Ceza", "Orta hız"),
                    TestCase("cezaHesapla(110)", "Ağır Ceza", "Yüksek hız")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_2_1",
                    lessonId = "kt_2",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Kotlin'de when bir değişkene değer atamak için (Expression olarak) kullanıldığında derleyici neyi zorunlu kılar?",
                    options = listOf(
                        "Olası tüm durumların kapsanmasını veya bir 'else' dalının bulunmasını",
                        "Sadece sayısal değerler kullanılmasını",
                        "Her satırın sonuna break konulmasını",
                        "En az 10 farklı durum olmasını"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Bir değişkene değer atanırken derleyici hiçbir durumun açıkta kalmamasını (Exhaustiveness) garanti altına alır.",
                    explanationWrong = "Expression olarak kullanılan when yapılarında tüm durumlar kapsanmalı veya else dalı olmalıdır.",
                    reviewTopic = "Kotlin when İfadesi"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "when yapısında break kullanmak gerekir mi?",
                    answer = "Hayır! Diğer dillerdeki gibi alttaki case'e istemsizce kayma (fall-through) Kotlin'de yoktur. Eşleşen dal çalıştığı an işlem tamamlanır, dolayısıyla break yazmaya gerek yoktur."
                )
            ),
            communityInsights = listOf(
                CommunityInsight(
                    source = "GitHub Best Practice",
                    topic = "Parametresiz when { ... } kullanımı neden çok popüler?",
                    insight = "when parantezine bir değişken vermek yerine doğrudan 'when { kosul1 -> ... kosul2 -> ... }' yazabilirsiniz. Bu, ardışık çirkin if-else if-else bloklarını tek ve temiz bir sütunda toplar.",
                    commonMistake = "İç içe (nested) 4-5 tane if-else yazıp kodun okunmasını imkansız hale getirmek."
                )
            ),
            completionCriteria = listOf(
                "when yapısını bir değişkene değer atayarak (Expression) kullanabilmek",
                "until ve downTo ile aralık döngüleri kurabilmek"
            )
        ),

        // ==========================================
        // DERS 3: FONKSİYONLAR, TEK SATIRLIK İFADELER VE VARSAYILAN DEĞERLER
        // ==========================================
        Lesson(
            id = "kt_3",
            courseId = "kotlin",
            sectionId = "kt_sec_2",
            title = "Fonksiyonlar: fun, Tek Satırlık Sözdizimi ve Parametre Gücü",
            shortDesc = "Tek satırlık (=) fonksiyonlar, Overloading ihtiyacını bitiren varsayılan parametreler ve Unit dönüş tipi.",
            level = CourseLevel.BEGINNER,
            order = 3,
            isPremium = false,
            learningObjectives = listOf(
                "fun kelimesi ile fonksiyon tanımlama mekanizmasını anlamak",
                "Tek satırlık (Single-expression) fonksiyonlarla temiz kod yazmak",
                "Varsayılan (Default) ve İsimlendirilmiş (Named) parametrelerin gücünü kullanmak",
                "Değer döndürmeyen fonksiyonlardaki 'Unit' kavramını bilmek"
            ),
            prerequisites = listOf("Kotlin Değişkenleri ve Koşulları"),
            subtopics = listOf("fun Tanımlama", "Single-Expression (=)", "Default Parametreler", "Named Arguments", "Unit Tipi"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Fonksiyonların Temel Mantığı",
                    body = "Fonksiyonlar, belirli bir görevi yerine getiren ve tekrar tekrar çağrılabilen kod bloklarıdır. Kotlin'de fonksiyonlar `fun` kelimesiyle tanımlanır.\n\nEğer bir fonksiyon tek bir işlem yapıp sonuç döndürüyorsa, süslü parantez `{ return ... }` açmak yerine doğrudan eşittir (`=`) koyarak yazabilirsiniz. Buna **Tek Satırlık İfade (*Single-expression Function*)** denir.",
                    codeSnippet = "// Uzun klasik yöntem:\nfun toplaKlasik(a: Int, b: Int): Int {\n    return a + b\n}\n\n// Zarif ve modern Kotlin yöntemi (Tek satır):\nfun toplaPratik(a: Int, b: Int) = a + b"
                ),
                LessonContentBlock(
                    subtitle = "2. Varsayılan Parametreler (Default Arguments)",
                    body = "Java veya C++ gibi dillerde aynı fonksiyonun 3 farklı versiyonunu yazmak (Method Overloading) gerekirdi. Kotlin'de parametreye doğrudan varsayılan bir değer atayabilirsiniz. Çağıran kişi parametreyi vermezse varsayılan değer otomatik devreye girer.",
                    codeSnippet = "fun baglantiKur(url: String, zamanAsimi: Int = 30, tekrarSayisi: Int = 3) {\n    println(\"\$url adresine bağlanılıyor (Zaman aşımı: \${zamanAsimi}sn, Tekrar: \$tekrarSayisi)\")\n}\n\n// Farklı çağrımlar:\nbaglantiKur(\"https://api.com\") // zamanAsimi=30, tekrarSayisi=3 kullanılır\nbaglantiKur(\"https://api.com\", zamanAsimi = 10) // İsimlendirilmiş çağrı!"
                ),
                LessonContentBlock(
                    subtitle = "3. Unit Dönüş Tipi Nedir?",
                    body = "Eğer bir fonksiyon geriye anlamlı bir değer döndürmüyorsa (örneğin sadece ekrana yazı yazıyorsa), dönüş tipi **`Unit`** olur. Diğer dillerdeki `void` kelimesinin Kotlin'deki karşılığıdır; ancak `Unit` gerçek bir nesne olduğu için fonksiyonel programlamayla tam uyumludur.",
                    codeSnippet = "fun ekranaBas(mesaj: String): Unit {\n    println(\"Mesaj: \$mesaj\")\n}\n// ': Unit' yazmak opsiyoneldir, yazmasanız da Kotlin anlar."
                )
            ),
            codeExample = "fun daireAlani(yaricap: Double, pi: Double = 3.14) = pi * yaricap * yaricap\n\nfun main() {\n    val alan1 = daireAlani(yaricap = 10.0)\n    val alan2 = daireAlani(yaricap = 10.0, pi = 3.14159)\n    \n    println(\"Standart Alan: \$alan1, Hassas Alan: \$alan2\")\n}",
            codeExplanation = "daireAlani tek satırlık eşittir (=) fonksiyonu ve pi için varsayılan parametre ile tanımlandı.",
            realWorldExample = "Jetpack Compose ile Android arayüzleri yazarken `@Composable fun Buton(metin: String, renk: Color = Primary)` şeklinde varsayılan renk ve boyut parametreleri kullanılır.",
            practicalTask = "İki sayıyı çarpan tek satırlık carp(a: Int, b: Int) fonksiyonunu '=' ile yazıp main içinde 6 ve 7 ile çağırarak sonucu ekrana yazdırın.",
            starterPlaygroundCode = "fun carp(a: Int, b: Int) = a * b\n\nfun main() {\n    val sonuc = carp(6, 7)\n    println(\"Çarpım: \$sonuc\")\n}",
            miniQuestion = MiniQuestion(
                id = "kt_q_3",
                question = "Kotlin'de bir fonksiyon geriye hiçbir veri döndürmediğinde (boş döndüğünde) dönüş tipi ne olur?",
                options = listOf("Unit", "void", "Null", "Nothing"),
                correctIndex = 0,
                explanation = "Kotlin'de değer döndürmeyen fonksiyonların dönüş tipi 'Unit'tir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_3",
                lessonId = "kt_3",
                title = "Özelleştirilmiş Mesaj Üretici",
                instructions = "kullanici (String) ve varsayılan degeri 'Sisteme hoş geldiniz' olan mesaj (String) parametrelerini alıp '[kullanici]: [mesaj]' döndüren karsilamaMesaji(kullanici, mesaj) fonksiyonunu yazın.",
                exampleInput = "kullanici = 'Burak'",
                exampleOutput = "'Burak: Sisteme hoş geldiniz'",
                starterCode = "fun karsilamaMesaji(kullanici: String, mesaj: String = \"Sisteme hoş geldiniz\"): String {\n    // Kodunu yaz:\n    return \"\"\n}",
                solutionCode = "fun karsilamaMesaji(kullanici: String, mesaj: String = \"Sisteme hoş geldiniz\"): String {\n    return \"\$kullanici: \$mesaj\"\n}",
                hints = listOf("\"\$kullanici: \$mesaj\" döndürün."),
                testCases = listOf(
                    TestCase("karsilamaMesaji(\"Burak\")", "Burak: Sisteme hoş geldiniz", "Varsayılan"),
                    TestCase("karsilamaMesaji(\"Ayşe\", \"İyi günler\")", "Ayşe: İyi günler", "Özel mesaj")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_3_1",
                    lessonId = "kt_3",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Kotlin'de fonksiyon çağrısı yaparken 'İsimlendirilmiş Parametreler' (Named Arguments) kullanmanın en büyük avantajı nedir?",
                    options = listOf(
                        "Parametrelerin sırasına bağlı kalmadan, hangi argümanın ne anlama geldiğini açıkça belirterek okunabilirliği artırmak",
                        "Fonksiyonun çalışma hızını 2 katına çıkarmak",
                        "Parametre tiplerini derleyiciden gizlemek",
                        "Fonksiyonun sadece tek bir kez çalışmasını sağlamak"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Kesinlikle! Özellikle çok parametreli fonksiyonlarda 'zamanAsimi = 30' gibi isim belirtmek kodun anlaşılırlığını muazzam artırır.",
                    explanationWrong = "Named Arguments kodun okunabilirliğini artırır ve parametre sırası zorunluluğunu kaldırır.",
                    reviewTopic = "Kotlin İsimlendirilmiş Argümanlar"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Single-expression fonksiyonlarda dönüş tipini yazmak zorunlu mudur?",
                    answer = "Hayır! Eşittir (=) kullandığınızda Kotlin sağ taraftaki ifadenin tipini otomatik olarak çıkarır (Type Inference)."
                )
            ),
            communityInsights = listOf(
                CommunityInsight(
                    source = "StackOverflow Top Tavsiye",
                    topic = "Neden Java'daki gibi 5 tane overloaded method yazmıyoruz?",
                    insight = "Varsayılan parametreler (Default arguments) sayesinde tek bir fonksiyonla onlarca kombinasyonu karşılayabilirsiniz. Bu hem kod tekrarını (boilerplate) ortadan kaldırır hem de bakım maliyetini düşürür.",
                    commonMistake = "Varsayılan parametreleri bilmeyip her durum için ayrı ayrı fonksiyon tanımlamak."
                )
            ),
            completionCriteria = listOf(
                "Single-expression (=) fonksiyon tanımlayabilmek",
                "Varsayılan ve isimlendirilmiş parametreleri doğru kullanabilmek"
            )
        ),

        // ==========================================
        // DERS 4: KOLEKSİYONLAR, LİSTELER, FILTER VE MAP
        // ==========================================
        Lesson(
            id = "kt_4",
            courseId = "kotlin",
            sectionId = "kt_sec_2",
            title = "Koleksiyonlar: Listeler (listOf) ve Fonksiyonel Dönüşümler (filter, map)",
            shortDesc = "Değişmez (Immutable) listOf vs mutableListOf ayrımı, filter, map ve forEach ile veri işleme sanatı.",
            level = CourseLevel.BEGINNER,
            order = 4,
            isPremium = true,
            learningObjectives = listOf(
                "listOf (salt okunur/immutable) ve mutableListOf farkını kavramak",
                "filter fonksiyonu ile şartı sağlayan elemanları ayıklamak",
                "map fonksiyonu ile elemanları dönüştürmek",
                "Lambda ifadelerinde örtük parametre 'it' anahtar kelimesini anlamak"
            ),
            prerequisites = listOf("Fonksiyonlar"),
            subtopics = listOf("listOf vs mutableListOf", "filter Fonksiyonu", "map Fonksiyonu", "it Anahtar Kelimesi"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Salt Okunur Listeler (listOf) Neden Standarttır?",
                    body = "Kotlin'de listeler ikiye ayrılır:\n\n• **listOf:** Sadece okunabilir, sonradan eleman eklenemez veya çıkarılamaz (*Immutable List*).\n• **mutableListOf:** İstenildiği zaman `.add()`, `.remove()` yapılabilen dinamik listedir.\n\nKotlin dünyasında veriyi korumak için varsayılan olarak her zaman `listOf` kullanılır.",
                    codeSnippet = "val sehirler = listOf(\"Ankara\", \"İzmir\", \"Bursa\")\n// sehirler.add(\"Antalya\") -> HATA! listOf sabittir.\n\nval dinamikListe = mutableListOf(\"Elma\", \"Armut\")\ndinamikListe.add(\"Muz\") // Geçerli!"
                ),
                LessonContentBlock(
                    subtitle = "2. filter ve map ile Deklaratif Veri İşleme",
                    body = "Eski döngülerle liste tarayıp yeni liste oluşturmak yerine Kotlin tek satırlık fonksiyonel operatörler sunar:\n\n• **filter:** Belirli bir şarta uyan elemanları süzer.\n• **map:** Listedeki her bir elemanı dönüştürür.\n• **it:** Tek parametreli lambdalarda o anki elemanı temsil eden kısayoldur.",
                    codeSnippet = "val sayilar = listOf(1, 2, 3, 4, 5, 6)\n\n// Çift sayıları filtrele ve 10 ile çarp:\nval sonuc = sayilar\n    .filter { it % 2 == 0 } // [2, 4, 6]\n    .map { it * 10 }        // [20, 40, 60]\n\nprintln(sonuc) // [20, 40, 60]"
                )
            ),
            codeExample = "fun main() {\n    val ogrenciler = listOf(\"Ahmet\", \"Can\", \"Zeynep\", \"Ali\")\n    \n    // 3 harften uzun olanları büyük harfe çevir:\n    val secilenler = ogrenciler\n        .filter { it.length > 3 }\n        .map { it.uppercase() }\n        \n    println(\"Seçilen Öğrenciler: \$secilenler\") // [AHMET, ZEYNEP]\n}",
            codeExplanation = "filter ile ismi 3 karakterden uzun olanlar süzüldü ve map ile büyük harfe dönüştürüldü.",
            realWorldExample = "Mobil bankacılık uygulamasında kullanıcının son hesap hareketlerini çekerken sadece 'Harcama' tipindeki transferler filter ile süzülüp ekrana basılır.",
            practicalTask = "1'den 10'a kadar olan sayılardan 5'ten büyük olanları filter ile seçip her birini 2 ile çarpan (map) bir kod yazın.",
            starterPlaygroundCode = "fun main() {\n    val sayilar = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)\n    val sonuc = sayilar.filter { it > 5 }.map { it * 2 }\n    println(\"Sonuç: \$sonuc\")\n}",
            miniQuestion = MiniQuestion(
                id = "kt_q_4",
                question = "Kotlin'de tek parametre alan bir lambda ifadesinde o anki elemana erişmek için varsayılan olarak hangi kelime kullanılır?",
                options = listOf("it", "this", "self", "item"),
                correctIndex = 0,
                explanation = "Kotlin'de tek parametreli lambda bloklarında parametre adı verilmezse 'it' (o) kısayolu kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_4",
                lessonId = "kt_4",
                title = "Pozitif Sayıları İkiye Katla",
                instructions = "sayilar (List<Int>) parametresi alan, liste içindeki yalnızca sıfırdan büyük pozitif sayıları seçip 2 ile çarpan ve yeni listeyi döndüren pozitifleriKatla(sayilar) fonksiyonunu yazın.",
                exampleInput = "listOf(-3, 4, -1, 5)",
                exampleOutput = "listOf(8, 10)",
                starterCode = "fun pozitifleriKatla(sayilar: List<Int>): List<Int> {\n    // filter ve map kullanarak kodunu yaz:\n    return emptyList()\n}",
                solutionCode = "fun pozitifleriKatla(sayilar: List<Int>): List<Int> {\n    return sayilar.filter { it > 0 }.map { it * 2 }\n}",
                hints = listOf("sayilar.filter { it > 0 }.map { it * 2 } ifadesini döndürün."),
                testCases = listOf(
                    TestCase("pozitifleriKatla(listOf(-3, 4, -1, 5))", "[8, 10]", "Karışık sayılar"),
                    TestCase("pozitifleriKatla(listOf(-5, -2))", "[]", "Hepsi negatif")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_4_1",
                    lessonId = "kt_4",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir listenin eleman sayısını değiştirmeden her elemanı başka bir değere dönüştürmek için hangi fonksiyon kullanılır?",
                    options = listOf("map", "filter", "forEach", "take"),
                    correctOptionIndex = 0,
                    explanationRight = "Tebrikler! map fonksiyonu her elemanı birebir dönüştürerek aynı boyutta yeni bir liste üretir.",
                    explanationWrong = "Dönüştürme işlemi için map kullanılır; filter ise elemanları ayıklar.",
                    reviewTopic = "Kotlin Koleksiyon Fonksiyonları"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "val liste = mutableListOf(1, 2) yazıldığında liste.add(3) yapılabilir mi?",
                    answer = "Evet! 'val' listenin referansının (bellekteki kutu adresinin) değişmeyeceğini söyler; listenin kendi içindeki elemanlar eklenebilir veya silinebilir."
                )
            ),
            communityInsights = listOf(
                CommunityInsight(
                    source = "Reddit r/kotlin İpucu",
                    topic = "Büyük listelerde Sequence (Tembel Değerlendirme / Lazy Evaluation) ne zaman kullanılır?",
                    insight = "Eğer elinizde 100.000 elemanlı devasa bir liste varsa, filter ve map her adımda yeni bir ara liste oluşturur. 'liste.asSequence().filter { ... }.map { ... }.toList()' yazdığınızda elemanlar hafızada ara liste yaratılmadan tek tek işlenir, bellek tasarrufu sağlanır.",
                    commonMistake = "Küçük (10-20 elemanlı) listelerde gereksiz yere Sequence kullanıp kodu karmaşıklaştırmak."
                )
            ),
            completionCriteria = listOf(
                "listOf ve mutableListOf arasındaki farkı bilmek",
                "filter ve map zincirlerini kurabilmek"
            )
        ),

        // ==========================================
        // DERS 5: SINIFLAR (class) VE VERİ SINIFLARI (data class)
        // ==========================================
        Lesson(
            id = "kt_5",
            courseId = "kotlin",
            sectionId = "kt_sec_3",
            title = "Nesne Yönelim: Sınıflar (Class) ve Mucizevi Veri Sınıfları (Data Class)",
            shortDesc = "Boilerplate kodları bitiren data class'lar, otomatik toString, equals, copy() ve birincil kurucular.",
            level = CourseLevel.INTERMEDIATE,
            order = 5,
            isPremium = true,
            learningObjectives = listOf(
                "Primary Constructor (Birincil Kurucu) mantığını kavramak",
                "data class'ın otomatik ürettiği equals, hashCode, toString ve copy() fonksiyonlarını anlamak",
                "Değişmez veri modellerini copy() ile klonlama tekniğini öğrenmek"
            ),
            prerequisites = listOf("Koleksiyonlar ve Fonksiyonlar"),
            subtopics = listOf("Primary Constructor", "data class Nedir?", "copy() Metodu", "Veri Ayrıştırma (Destructuring)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Data Class Neden Kotlin'in En Çok Sevilen Özelliğidir?",
                    body = "Java'da bir model sınıfı (Örn: `Kullanici`) yazmak için 50 satır getter, setter, `equals()`, `hashCode()` ve `toString()` yazmak gerekirdi.\n\nKotlin'de sınıfın başına **`data`** kelimesini koyduğunuz an derleyici arka planda tüm bu metotları otomatik olarak üretir!",
                    codeSnippet = "// Tek satırda eksiksiz ve güçlü bir model:\ndata class Kullanici(val id: Int, val ad: String, val aktifMi: Boolean = true)\n\nfun main() {\n    val k1 = Kullanici(1, \"Mert\")\n    println(k1) // Otomatik güzel çıktı: Kullanici(id=1, ad=Mert, aktifMi=true)\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. copy() ile Güvenli Veri Klonlama",
                    body = "Değişmez (*Immutable*) bir `data class` nesnesinin sadece 1-2 alanını değiştirmek istediğinizde `copy()` metodunu kullanırsınız. Orijinal nesne bozulmaz, değiştirilmiş yeni bir kopyası üretilir.",
                    codeSnippet = "val k1 = Kullanici(1, \"Mert\", aktifMi = true)\n\n// Sadece aktifMi değerini false yapıp kopyala:\nval k2 = k1.copy(aktifMi = false)\n\nprintln(k1.aktifMi) // true (Orijinal korundu)\nprintln(k2.aktifMi) // false (Kopya güncellendi)"
                )
            ),
            codeExample = "data class Urun(val id: String, val isim: String, val fiyat: Double)\n\nfun main() {\n    val telefon = Urun(\"U1\", \"Akıllı Telefon\", 25000.0)\n    val indirimliTelefon = telefon.copy(fiyat = 22500.0)\n    \n    println(\"Orijinal: \$telefon\")\n    println(\"İndirimli: \$indirimliTelefon\")\n}",
            codeExplanation = "data class tanımlandı ve copy(fiyat = ...) ile orijinal nesneye dokunmadan indirimli kopya üretildi.",
            realWorldExample = "Modern Android uygulamalarında Redux / MVI durum yönetiminde UI durumu `data class UiState(...)` ile tutulur ve her yeni ekranda `state.copy(isLoading = false)` ile güncellenir.",
            practicalTask = "Kitap adında bir data class (ad: String, sayfa: Int, fiyat: Double) oluşturun. Bir kitap nesnesi yaratıp copy() ile fiyatını güncelleyin ve her ikisini de yazdırın.",
            starterPlaygroundCode = "data class Kitap(val ad: String, val sayfa: Int, val fiyat: Double)\n\nfun main() {\n    val k1 = Kitap(\"Kotlin Rehberi\", 320, 150.0)\n    val k2 = k1.copy(fiyat = 120.0)\n    println(k1)\n    println(k2)\n}",
            miniQuestion = MiniQuestion(
                id = "kt_q_5",
                question = "Bir data class nesnesinin bazı özelliklerini değiştirerek yeni bir kopyasını oluşturmak için hangi metot kullanılır?",
                options = listOf("copy()", "clone()", "replicate()", "update()"),
                correctIndex = 0,
                explanation = "Kotlin data class'lar otomatik olarak copy() metodu içerir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_5",
                lessonId = "kt_5",
                title = "Ürün Fiyat Güncelleyici",
                instructions = "UrunItem(val id: String, val isim: String, val fiyat: Double) data class'ı için; bir urun ve zamOrani (Double, örneğin 0.20 = %20) parametrelerini alıp fiyatı zamOrani kadar artırılmış yeni UrunItem nesnesini copy() ile döndüren zamYap(urun, zamOrani) fonksiyonunu yazın.",
                exampleInput = "urun = UrunItem('1', 'Klavye', 1000.0), zamOrani = 0.10",
                exampleOutput = "UrunItem(id='1', isim='Klavye', fiyat=1100.0)",
                starterCode = "data class UrunItem(val id: String, val isim: String, val fiyat: Double)\n\nfun zamYap(urun: UrunItem, zamOrani: Double): UrunItem {\n    // copy() kullanarak yeni urun döndür:\n    return urun\n}",
                solutionCode = "data class UrunItem(val id: String, val isim: String, val fiyat: Double)\n\nfun zamYap(urun: UrunItem, zamOrani: Double): UrunItem {\n    val yeniFiyat = urun.fiyat * (1.0 + zamOrani)\n    return urun.copy(fiyat = yeniFiyat)\n}",
                hints = listOf("val yeniFiyat = urun.fiyat * (1.0 + zamOrani) hesaplayıp urun.copy(fiyat = yeniFiyat) döndürün."),
                testCases = listOf(
                    TestCase("zamYap(UrunItem(\"1\", \"Klavye\", 1000.0), 0.10).fiyat", "1100.0", "%10 zam"),
                    TestCase("zamYap(UrunItem(\"2\", \"Fare\", 500.0), 0.20).fiyat", "600.0", "%20 zam")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_5_1",
                    lessonId = "kt_5",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Aşağıdakilerden hangisi bir sınıfın 'data class' olabilmesi için zorunlu bir kuraldır?",
                    options = listOf(
                        "Birincil kurucusunda (Primary Constructor) en az bir adet 'val' veya 'var' parametresi bulunmalıdır",
                        "Sınıfın içinde en az 5 fonksiyon bulunmalıdır",
                        "Sınıf mutlaka 'open' olarak işaretlenmelidir",
                        "Parametreler sadece String tipinde olmalıdır"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! data class'ın primary constructor'ında en az bir val/var parametresi olmalıdır.",
                    explanationWrong = "data class primary constructor'ında en az bir parametre bulunmalıdır.",
                    reviewTopic = "Kotlin Data Class Kuralları"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "data class'lar miras alınabilir (inherit) mi?",
                    answer = "data class'lar varsayılan olarak 'final'dır, yani başka bir sınıf tarafından doğrudan miras alınamazlar; ancak kendileri arayüzleri (Interface) veya abstract sınıfları uygulayabilirler."
                )
            ),
            communityInsights = listOf(
                CommunityInsight(
                    source = "StackOverflow Top Mülakat Sorusu",
                    topic = "Neden normal class yerine data class'ta '==' doğrudan içerik kontrolü yapar?",
                    insight = "Normal sınıflarda '==' iki nesnenin RAM adresini karşılaştırırken, data class'ta otomatik üretilen equals() sayesinde nesnelerin içindeki veriler birebir aynıysa 'true' döner. Bu sayede test yazmak ve veri kıyaslamak çocuk oyuncağı haline gelir.",
                    commonMistake = "Data modellerini düz class yapıp 'kullanici1 == kullanici2' yazınca RAM adresleri farklı olduğu için beklenmedik false almak."
                )
            ),
            completionCriteria = listOf(
                "data class tanımlayıp copy() metodunu kullanabilmek",
                "Veri modellerini değişmez (val) olarak tasarlamak"
            )
        ),

        // ==========================================
        // DERS 6: EXTENSION FUNCTIONS VE SCOPE FUNCTIONS (let, apply, also)
        // ==========================================
        Lesson(
            id = "kt_6",
            courseId = "kotlin",
            sectionId = "kt_sec_4",
            title = "İleri Düzey Araçlar: Uzantı Fonksiyonları (Extensions) ve Scope Functions (let, apply)",
            shortDesc = "Var olan sınıflara dokunmadan yeni metot ekleme gücü ve let, apply, also gibi sihirli kapsam araçları.",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true,
            learningObjectives = listOf(
                "Extension Functions ile String, Int gibi sınıflara özel fonksiyonlar eklemek",
                "let fonksiyonunu null kontrollerinde (?.let { }) ustalıkla kullanmak",
                "apply fonksiyonu ile nesne ilklendirmeyi (Initialization) temizce yapmak"
            ),
            prerequisites = listOf("Sınıflar ve Fonksiyonlar"),
            subtopics = listOf("Extension Function Sözdizimi", "let ile Güvenli Blok", "apply ile Nesne Kurma", "Scope Karşılaştırma"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Uzantı Fonksiyonları (Extension Functions) Nedir?",
                    body = "Bir kütüphanedeki veya Android SDK'daki sınıfa yeni bir metot eklemek istediğinizi düşünün. Sınıfın kaynak kodunu değiştiremezsiniz, ama Kotlin'de sınıfın adına nokta koyarak yeni fonksiyon ekleyebilirsiniz!\n\nBu fonksiyona sınıfın içinden erişiliyormuş gibi `this` ile ulaşılır.",
                    codeSnippet = "// String sınıfına 'ilkHarfiBuyut' fonksiyonu ekleyelim:\nfun String.ilkHarfiBuyut(): String {\n    return this.replaceFirstChar { it.uppercase() }\n}\n\nfun main() {\n    val sehir = \"istanbul\"\n    println(sehir.ilkHarfiBuyut()) // \"Istanbul\"\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. let ve apply: Hangi Durumda Hangisi?",
                    body = "Kotlin'deki **Kapsam Fonksiyonları (*Scope Functions*)** kodu çok daha akıcı hale getirir:\n\n• **let:** Genellikle null olmayan değerlerle çalışırken kullanılır (`deger?.let { ... }`). Blok içinde o anki nesneye `it` ile erişilir.\n• **apply:** Bir nesneyi oluşturup özelliklerini topluca ayarlamak için kullanılır. Blok içinde `this` geçerlidir ve nesnenin kendisini geri döndürür.",
                    codeSnippet = "val email: String? = \"destek@sirket.com\"\n\n// Null değilse e-posta gönder:\nemail?.let {\n    println(\"E-posta gönderiliyor: \$it\")\n}"
                )
            ),
            codeExample = "data class Profil(var isim: String = \"\", var puan: Int = 0)\n\nfun main() {\n    // apply ile temiz nesne kurma:\n    val p = Profil().apply {\n        isim = \"Kaan\"\n        puan = 100\n    }\n    \n    println(\"Oluşturulan Profil: \$p\")\n}",
            codeExplanation = "apply bloğu içinde nesnenin özellikleri 'this' kullanılarak tek blokta ayarlandı.",
            realWorldExample = "Android'de `Intent().apply { putExtra(\"id\", 1); putExtra(\"token\", \"xyz\") }` şeklinde yeni bir ekrana veri taşırken apply standarttır.",
            practicalTask = "Int sınıfına bir sayının karesini döndüren `Int.kareAl(): Int = this * this` uzantı fonksiyonunu yazın ve 9.kareAl() ile test edin.",
            starterPlaygroundCode = "fun Int.kareAl(): Int = this * this\n\nfun main() {\n    val sayi = 9\n    println(\"\$sayi'nin karesi: \${sayi.kareAl()}\")\n}",
            miniQuestion = MiniQuestion(
                id = "kt_q_6",
                question = "Bir nesnenin null olup olmadığını kontrol edip, sadece null DEĞİLSE bir kod bloğunu çalıştırmak için en çok hangi kapsam fonksiyonu kullanılır?",
                options = listOf("?.let { }", "?.apply { }", "?.run { }", "?.also { }"),
                correctIndex = 0,
                explanation = "deger?.let { it ... } kalıbı Kotlin'de güvenli null blokları için standarttır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_6",
                lessonId = "kt_6",
                title = "String Boşluk Temizleyici Extension",
                instructions = "String sınıfı için; baştaki ve sondaki boşlukları temizleyip harfleri tamamen küçülten `String.temizle(): String` uzantı fonksiyonunu yazın.",
                exampleInput = "'  KOTLIN  '.temizle()",
                exampleOutput = "'kotlin'",
                starterCode = "fun String.temizle(): String {\n    // trim() ve lowercase() kullanarak yaz:\n    return this\n}",
                solutionCode = "fun String.temizle(): String {\n    return this.trim().lowercase()\n}",
                hints = listOf("this.trim().lowercase() döndürün."),
                testCases = listOf(
                    TestCase("\"  KOTLIN  \".temizle()", "kotlin", "Büyük ve boşluklu"),
                    TestCase("\" ANDROID \".temizle()", "android", "Boşluklu")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_6_1",
                    lessonId = "kt_6",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Kotlin'de Extension Function (Uzantı Fonksiyonu) yazıldığında orijinal sınıfın kaynak kodu nasıl değişir?",
                    options = listOf(
                        "Kaynak kod asla değişmez; derleyici arka planda statik bir yardımcı metot üretir",
                        "Sınıfın byte-code'u kalıcı olarak yeniden yazılır",
                        "Sadece o dosya içinde sınıf geçici olarak kopyalanır",
                        "Sınıfın bellekteki boyutu iki katına çıkar"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Mükemmel! Extension fonksiyonlar derleme zamanında statik yardımcı metotlara dönüştürülür, orijinal sınıfa dokunmaz.",
                    explanationWrong = "Extension fonksiyonlar orijinal sınıfı değiştirmez, arka planda statik metot olarak çalışır.",
                    reviewTopic = "Kotlin Extension Functions Mantığı"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "apply ile also arasındaki fark nedir?",
                    answer = "Her ikisi de nesnenin kendisini geri döndürür. Ancak apply bloğu içinde 'this' kullanılırken, also bloğu içinde nesneye 'it' ile erişilir (örneğin log basarken 'it.also { Log.d(it) }')."
                )
            ),
            communityInsights = listOf(
                CommunityInsight(
                    source = "Dev.to Top Tips",
                    topic = "Scope functions (let, apply, run, with, also) arasında kaybolmamak için altın kural",
                    insight = "1) Nesneyi yapılandırıp geri almak istiyorsan -> apply\n2) Null kontrolü yapıp başka bir değere dönüştürmek istiyorsan -> ?.let { }\n3) Bir yan etki (loglama, ekrana basma) yapmak istiyorsan -> also.",
                    commonMistake = "İç içe 3-4 tane let ve apply açıp 'it' kelimesinin neyi temsil ettiğini okuyamaz hale gelmek."
                )
            ),
            completionCriteria = listOf(
                "Extension function yazabilmek",
                "?.let { } ile null-safe işlemler yapabilmek"
            )
        ),

        // ==========================================
        // DERS 7: COROUTINES (EŞZAMANLILIK) VE FLOW GİRİŞİ
        // ==========================================
        Lesson(
            id = "kt_7",
            courseId = "kotlin",
            sectionId = "kt_sec_5",
            title = "Asenkron Kotlin: Coroutines, suspend ve Donmayan Arayüzler",
            shortDesc = "Ağır işlemleri UI iş parçacığını (Main Thread) kitlemeden yönetme: Coroutines, Dispatchers ve suspend fonksiyonlar.",
            level = CourseLevel.ADVANCED,
            order = 7,
            isPremium = true,
            learningObjectives = listOf(
                "İş parçacığı (Thread) bloklama ile Coroutine duraklatma (Suspend) farkını kavramak",
                "Dispatchers.Main (Arayüz) ve Dispatchers.IO (Ağ/Veritabanı) ayrımını bilmek",
                "suspend anahtar kelimesinin arka plan mekanizmasını anlamak"
            ),
            prerequisites = listOf("Fonksiyonlar ve Sınıflar"),
            subtopics = listOf("Neden Coroutines?", "suspend Fonksiyonlar", "Dispatchers (IO vs Main)", "Hafif İş Parçacıkları"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Coroutine Mantığı: Neden Normal Thread Yetmedi?",
                    body = "İşletim sistemi iş parçacıkları (*OS Threads*) çok ağırdır; 10.000 thread açarsanız telefonun belleği biter ve çöker.\n\n**Coroutines**, aynı iş parçacığı üzerinde çalışan **ultra hafif iş parçacıklarıdır (*Lightweight Threads*)**. Bir Coroutine ağdan veri beklerken ana iş parçacığını dondurmaz (*non-blocking*); sadece o görevi **duraklatır (*suspend*)** ve veri geldiğinde kaldığı yerden devam ettirir.",
                    codeSnippet = "// suspend fonksiyonlar arka planda güvenle bekleyebilir:\nsuspend fun kullaniciVerisiGetir(): String {\n    kotlinx.coroutines.delay(1000) // 1 saniye bekle (Thread kilitlenmez!)\n    return \"Kullanıcı: Deniz\"\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Dispatchers: İşi Doğru İşçiye Vermek",
                    body = "Kotlin'de yapılacak işin türüne göre iş parçacığı havuzu seçilir:\n\n• **Dispatchers.Main:** Android arayüzünü (UI) güncelleyen ana iş parçacığıdır.\n• **Dispatchers.IO:** Ağ istekleri, dosya okuma ve veritabanı sorguları için optimize edilmiş arka plan havuzudur.\n• **Dispatchers.Default:** Yoğun matematiksel veya algoritma hesaplamaları içindir.",
                    codeSnippet = "// IO'da veri çekip Main'de ekrana basma mantığı:\n// withContext(Dispatchers.IO) { api.veriCek() }"
                )
            ),
            codeExample = "suspend fun siparisDurumu(): String {\n    // Simüle edilmiş ağ beklemesi:\n    return \"Sipariş Yolda 🚚\"\n}\n\nfun main() {\n    println(\"Coroutines mimarisi Android'de standarttır.\")\n}",
            codeExplanation = "suspend kelimesi fonksiyonun coroutine ortamında duraklatılabilir olduğunu belirtir.",
            realWorldExample = "Kullanıcı profil fotoğrafını yüklerken arayüzde yükleniyor animasyonu akıcı bir şekilde dönmeye devam eder çünkü fotoğraf sıkıştırma ve yükleme `Dispatchers.IO` üzerinde çalışır.",
            practicalTask = "suspend kelimesini kullanarak `suspend fun veriYukle(): String` fonksiyonunu yazıp \"Veriler Yüklendi\" metnini döndürün.",
            starterPlaygroundCode = "suspend fun veriYukle(): String {\n    return \"Veriler Yüklendi\"\n}\n\nfun main() {\n    println(\"Suspend fonksiyon hazır\")\n}",
            miniQuestion = MiniQuestion(
                id = "kt_q_7",
                question = "Android'de sunucudan veri çekme veya veritabanı okuma gibi I/O işlemleri hangi Coroutine Dispatcher üzerinde çalıştırılmalıdır?",
                options = listOf("Dispatchers.IO", "Dispatchers.Main", "Dispatchers.Unconfined", "Dispatchers.UI"),
                correctIndex = 0,
                explanation = "Ağ ve disk işlemleri için her zaman Dispatchers.IO kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_7",
                lessonId = "kt_7",
                title = "Asenkron Bakiye Hesaplayıcı",
                instructions = "gelir (Double) ve gider (Double) parametrelerini alan, `suspend` olarak tanımlanmış ve net bakiyeyi (gelir - gider) döndüren `suspend fun bakiyeHesapla(gelir: Double, gider: Double): Double` fonksiyonunu yazın.",
                exampleInput = "gelir = 5000.0, gider = 2000.0",
                exampleOutput = "3000.0",
                starterCode = "suspend fun bakiyeHesapla(gelir: Double, gider: Double): Double {\n    // Kodunu yaz:\n    return 0.0\n}",
                solutionCode = "suspend fun bakiyeHesapla(gelir: Double, gider: Double): Double {\n    return gelir - gider\n}",
                hints = listOf("return gelir - gider yazmanız yeterlidir."),
                testCases = listOf(
                    TestCase("bakiyeHesapla(5000.0, 2000.0)", "3000.0", "Pozitif bakiye"),
                    TestCase("bakiyeHesapla(1000.0, 1500.0)", "-500.0", "Negatif bakiye")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_7_1",
                    lessonId = "kt_7",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir suspend fonksiyonu sadece nerelerden çağrılabilir?",
                    options = listOf(
                        "Sadece başka bir suspend fonksiyondan veya bir Coroutine Scope içinden",
                        "Herhangi bir normal Java fonksiyonundan doğrudan",
                        "Sadece main() fonksiyonundan",
                        "Sadece arayüz buton tıklamasından"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! suspend fonksiyonlar duraklatılabilme özelliğine sahip olduğu için yalnızca bir coroutine kapsamından çağrılabilir.",
                    explanationWrong = "suspend fonksiyonlar sadece başka bir suspend fonksiyon veya coroutine scope içinden çağrılabilir.",
                    reviewTopic = "Kotlin Suspend Kuralları"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "delay() ile Thread.sleep() arasındaki fark nedir?",
                    answer = "Thread.sleep() o iş parçacığını tamamen kilitler (dondurur) ve başka hiçbir işlem yapılamaz. delay() ise iş parçacığını kilitlemez, sadece o coroutine'i duraklatır; iş parçacığı bu sırada diğer işleri yapmaya devam eder."
                )
            ),
            communityInsights = listOf(
                CommunityInsight(
                    source = "StackOverflow #1 Coroutine Sorusu",
                    topic = "Neden Android'de GlobalScope.launch kullanımı kesinlikle yasaklanmıştır?",
                    insight = "GlobalScope uygulamanın tüm yaşam döngüsüne bağlıdır. Kullanıcı ekranı kapatsa bile arka planda ağ isteği çalışmaya devam eder ve devasa bir Bellek Sızıntısına (Memory Leak) yol açar. Bunun yerine her zaman 'viewModelScope' veya 'lifecycleScope' kullanılmalıdır.",
                    commonMistake = "Ekrana bağlı işlerde GlobalScope açıp uygulamanın arka planda bataryayı tüketmesine neden olmak."
                )
            ),
            completionCriteria = listOf(
                "suspend fonksiyon mantığını kavramak",
                "Dispatchers.IO ve Dispatchers.Main ayrımını bilmek"
            )
        ),

        // ==========================================
        // DERS 8: SEALED CLASS VE DURUM YÖNETİMİ
        // ==========================================
        Lesson(
            id = "kt_8",
            courseId = "kotlin",
            sectionId = "kt_sec_3",
            title = "Durum Yönetimi: Sealed Class ve Sealed Interface Gücü",
            shortDesc = "Arayüz durumlarını (Loading, Success, Error) tip güvenli ve eksiksiz modelleme mimarisi.",
            level = CourseLevel.INTERMEDIATE,
            order = 8,
            isPremium = true,
            learningObjectives = listOf(
                "Sealed Class yapısının Enum ve normal sınıflardan farkını kavramak",
                "UI State yönetiminde (Loading, Success, Error) when ile hatasız kullanım",
                "Derleyicinin exhaustiveness (tüm durumları zorunlu kılma) avantajını anlamak"
            ),
            prerequisites = listOf("Sınıflar ve when"),
            subtopics = listOf("Sealed Class Nedir?", "Enum vs Sealed Class", "UI State Modelleme", "when ile Exhaustive Eşleme"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Sealed Class (Mühürlü Sınıf) Mantığı",
                    body = "Bir işlemin sonucunda sadece belirli durumların gerçekleşebileceğini biliyorsanız, bunları **`sealed class`** ile sınırlandırırsınız.\n\nEnum'lardan farkı şudur: Enum sabitleri sadece tek bir değer tutarken, Sealed Class alt sınıfları kendi içinde farklı veriler (`data class Success(val veri: List<Urun>)`, `data class Error(val mesaj: String)`) barındırabilir!",
                    codeSnippet = "sealed class Sonuc {\n    object Yukleniyor : Sonuc()\n    data class Basarili(val veri: String) : Sonuc()\n    data class Hata(val hataMesaji: String) : Sonuc()\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. when ile Hatasız Durum Yakalama",
                    body = "`when` ifadesi bir `sealed class` ile kullanıldığında derleyici tüm durumların ele alındığını bilir. Yeni bir durum eklediğinizde, `else` yazmaya gerek kalmadan kodun nerelerinde eksik kaldığını derleyici size gösterir.",
                    codeSnippet = "fun durumuGoster(sonuc: Sonuc) = when (sonuc) {\n    is Sonuc.Yukleniyor -> \"Yükleniyor... ⏳\"\n    is Sonuc.Basarili -> \"Veri: \${sonuc.veri} ✅\"\n    is Sonuc.Hata -> \"Hata: \${sonuc.hataMesaji} ❌\"\n}"
                )
            ),
            codeExample = "sealed interface AgDurumu {\n    object Bagli : AgDurumu\n    object BaglantiYok : AgDurumu\n}\n\nfun main() {\n    val durum: AgDurumu = AgDurumu.Bagli\n    val mesaj = when (durum) {\n        is AgDurumu.Bagli -> \"İnternet Aktif\"\n        is AgDurumu.BaglantiYok -> \"Lütfen bağlantınızı kontrol edin\"\n    }\n    println(mesaj)\n}",
            codeExplanation = "sealed interface ile ağ durumu modellendi ve when ile eksiksiz kontrol edildi.",
            realWorldExample = "Android Jetpack Compose ekranlarında `when (uiState) { is UiState.Loading -> CircularProgressIndicator() ... }` kalıbı endüstri standardıdır.",
            practicalTask = "KullaniciDurumu adında bir sealed class (GirisYapmis(val ad: String), CikisYapmis) oluşturup durum kontrolü yapın.",
            starterPlaygroundCode = "sealed class KullaniciDurumu {\n    data class GirisYapmis(val ad: String) : KullaniciDurumu()\n    object CikisYapmis : KullaniciDurumu()\n}\n\nfun main() {\n    val d: KullaniciDurumu = KullaniciDurumu.GirisYapmis(\"Ece\")\n    when (d) {\n        is KullaniciDurumu.GirisYapmis -> println(\"Hoş geldin \${d.ad}\")\n        is KullaniciDurumu.CikisYapmis -> println(\"Lütfen giriş yapın\")\n    }\n}",
            miniQuestion = MiniQuestion(
                id = "kt_q_8",
                question = "Sealed Class yapısının normal enum sınıflarından en büyük üstünlüğü nedir?",
                options = listOf(
                    "Alt sınıflarının farklı veri türleri ve parametreler taşıyabilmesi",
                    "Daha az bellek kullanması",
                    "Sadece sayılar için geçerli olması",
                    "Döngüye sokulamaması"
                ),
                correctIndex = 0,
                explanation = "Sealed class'ın her bir dalı farklı parametreler taşıyan bağımsız data class'lar olabilir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_8",
                lessonId = "kt_8",
                title = "İşlem Durumu Metin Çözücü",
                instructions = "sealed class IslemSonucu { data class Basari(val kod: Int) : IslemSonucu(); data class Basarisiz(val sebep: String) : IslemSonucu() } yapısı için; Basari ise 'Kod: [kod]', Basarisiz ise 'Sebep: [sebep]' döndüren sonucMetni(islem: IslemSonucu) fonksiyonunu yazın.",
                exampleInput = "IslemSonucu.Basari(200)",
                exampleOutput = "'Kod: 200'",
                starterCode = "sealed class IslemSonucu {\n    data class Basari(val kod: Int) : IslemSonucu()\n    data class Basarisiz(val sebep: String) : IslemSonucu()\n}\n\nfun sonucMetni(islem: IslemSonucu): String {\n    // when ile yaz:\n    return \"\"\n}",
                solutionCode = "sealed class IslemSonucu {\n    data class Basari(val kod: Int) : IslemSonucu()\n    data class Basarisiz(val sebep: String) : IslemSonucu()\n}\n\nfun sonucMetni(islem: IslemSonucu): String = when (islem) {\n    is IslemSonucu.Basari -> \"Kod: \${islem.kod}\"\n    is IslemSonucu.Basarisiz -> \"Sebep: \${islem.sebep}\"\n}",
                hints = listOf("when (islem) { is IslemSonucu.Basari -> ... is IslemSonucu.Basarisiz -> ... } kullanın."),
                testCases = listOf(
                    TestCase("sonucMetni(IslemSonucu.Basari(200))", "Kod: 200", "Başarı"),
                    TestCase("sonucMetni(IslemSonucu.Basarisiz(\"Zaman aşımı\"))", "Sebep: Zaman aşımı", "Başarısız")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_8_1",
                    lessonId = "kt_8",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "when ifadesinde sealed class kullanıldığında tüm durumlar yazıldıysa 'else' dalı neden gereksizdir?",
                    options = listOf(
                        "Derleyici tüm alt sınıfları bildiği için durumların eksiksiz (exhaustive) olduğunu garanti eder",
                        "Sealed class'lar else dalını derleme hatası verir",
                        "else dalı sadece sayılar için geçerlidir",
                        "Sealed class tek bir durumdan oluşur"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Mükemmel! Derleyici sınıf hiyerarşisini tam olarak bildiği için hiçbir durumun atlanmadığından emin olur.",
                    explanationWrong = "Sealed class'larda derleyici tüm dalların yazıldığını doğrular.",
                    reviewTopic = "Kotlin Sealed Class Exhaustiveness"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Sealed class ile Sealed interface arasındaki fark nedir?",
                    answer = "Sealed interface, çoklu kalıtım (multiple inheritance) gibi bir sınıfın birden fazla sealed yapıyı uygulayabilmesine olanak tanır ve daha esnektir."
                )
            ),
            communityInsights = listOf(
                CommunityInsight(
                    source = "Android Architecture Guide",
                    topic = "Neden UI durumlarında boolean (isLoading, isError, isSuccess) bayrakları yerine Sealed Class kullanılır?",
                    insight = "3 ayrı boolean tutarsanız teorik olarak aynı anda hem isLoading=true hem isError=true olma riski (imkansız durumlar / impossible states) doğar. Sealed class ile ekranın o an SADECE TEK BİR durumda olması garanti edilir.",
                    commonMistake = "Arayüzde 4-5 farklı boolean tutup hangisinin ne zaman aktif olduğunu karıştırmak."
                )
            ),
            completionCriteria = listOf(
                "Sealed class ile durum hiyerarşisi kurabilmek",
                "when kontrolünde tüm durumları tip güvenli eşleyebilmek"
            )
        ),

        // ==========================================
        // DERS 9: JENERİKLER (Generics)
        // ==========================================
        Lesson(
            id = "kt_9",
            courseId = "kotlin",
            sectionId = "kt_sec_4",
            title = "Jenerikler (Generics): Tip Bağımsız ve Yeniden Kullanılabilir Kod",
            shortDesc = "<T> parametresi ile her türlü veri tipiyle güvenle çalışan fonksiyonlar ve sınıflar tasarlamak.",
            level = CourseLevel.ADVANCED,
            order = 9,
            isPremium = true,
            learningObjectives = listOf(
                "Jenerik tip parametresi <T> mantığını kavramak",
                "Tip güvenli (Type-safe) sarmalayıcı sınıflar yazmak",
                "Koleksiyonların arka planda nasıl jenerik çalıştığını anlamak"
            ),
            prerequisites = listOf("Sınıflar ve Fonksiyonlar"),
            subtopics = listOf("Neden Jenerikler?", "<T> Sözdizimi", "Jenerik Fonksiyonlar", "Jenerik Sınıflar"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Jeneriklerin Temel Mantığı: <T> Nedir?",
                    body = "Bir kutu düşünün; içine ister `String`, ister `Int`, ister `Kullanici` koyabilmek istiyorsunuz; ancak içine ne koyduysanız çıkarırken de tam o tipte güvenle geri almak istiyorsunuz.\n\nEski dillerde her şey için `Any` (veya `Object`) kullanılırdı ve sürekli tip dönüşümü (*Casting*) yapmak gerekirdi; bu da çalışma zamanında çökmelere yol açardı. **Jenerikler (`<T>`)**, derleme anında tam tip güvenliği sağlar.",
                    codeSnippet = "// Her tipi tutabilen güvenli kutu sınıfı:\nclass Kutu<T>(val icerik: T) {\n    fun bilgiVer() = \"Kutunun içindeki tip: \${icerik?.let { it::class.simpleName }}\"\n}\n\nval k1 = Kutu(\"Merhaba\") // Kutu<String>\nval k2 = Kutu(42)        // Kutu<Int>"
                ),
                LessonContentBlock(
                    subtitle = "2. Jenerik Fonksiyonlar",
                    body = "Fonksiyon adından önce `<T>` koyarak her türlü parametreyle çalışan evrensel yardımcı fonksiyonlar yazabilirsiniz.",
                    codeSnippet = "fun <T> listeyiYazdir(liste: List<T>) {\n    for (eleman in liste) {\n        println(\"-> \$eleman\")\n    }\n}"
                )
            ),
            codeExample = "class Yanit<T>(val basariliMi: Boolean, val veri: T?, val mesaj: String? = null)\n\nfun main() {\n    val y1 = Yanit(true, \"Giriş yapıldı\")\n    val y2 = Yanit(true, 100)\n    println(\"Veri 1: \${y1.veri}, Veri 2: \${y2.veri}\")\n}",
            codeExplanation = "Yanit<T> jenerik sınıfı hem String hem Int tipiyle tip güvenli çalıştı.",
            realWorldExample = "Retrofit veya Ktor ile sunucudan veri çekerken `ApiResponse<User>` veya `ApiResponse<List<Product>>` şeklinde jenerik yanıt sınıfları kullanılır.",
            practicalTask = "İki elemanı takas edip liste döndüren jenerik `fun <T> ikiliOlustur(a: T, b: T): List<T> = listOf(a, b)` fonksiyonunu yazın.",
            starterPlaygroundCode = "fun <T> ikiliOlustur(a: T, b: T): List<T> = listOf(a, b)\n\nfun main() {\n    println(ikiliOlustur(\"Ali\", \"Veli\"))\n    println(ikiliOlustur(1, 2))\n}",
            miniQuestion = MiniQuestion(
                id = "kt_q_9",
                question = "Kotlin'de jenerik tip parametresini belirtmek için geleneksel olarak hangi harf kullanılır?",
                options = listOf("T (Type)", "G (Generic)", "X (Unknown)", "V (Value)"),
                correctIndex = 0,
                explanation = "Genellikle Type kelimesini temsilen <T> kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_9",
                lessonId = "kt_9",
                title = "Jenerik Tekrarlayıcı",
                instructions = "Bir eleman (T) ve adet (Int) parametresi alıp elemanı adet kadar içeren bir `List<T>` döndüren `fun <T> tekrarEt(eleman: T, adet: Int): List<T>` fonksiyonunu yazın.",
                exampleInput = "tekrarEt('Kotlin', 3)",
                exampleOutput = "listOf('Kotlin', 'Kotlin', 'Kotlin')",
                starterCode = "fun <T> tekrarEt(eleman: T, adet: Int): List<T> {\n    // Kodunu yaz:\n    return emptyList()\n}",
                solutionCode = "fun <T> tekrarEt(eleman: T, adet: Int): List<T> {\n    val liste = mutableListOf<T>()\n    for (i in 1..adet) liste.add(eleman)\n    return liste\n}",
                hints = listOf("mutableListOf<T>() oluşturup for döngüsüyle elemanı ekleyin."),
                testCases = listOf(
                    TestCase("tekrarEt(\"A\", 3)", "[A, A, A]", "3 kez A"),
                    TestCase("tekrarEt(5, 2)", "[5, 5]", "2 kez 5")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_9_1",
                    lessonId = "kt_9",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Jeneriklerin (Generics) en önemli faydası nedir?",
                    options = listOf(
                        "Kod tekrarını önleyip derleme anında (Compile-time) tam tip güvenliği sağlamak",
                        "Uygulamanın internet hızını artırmak",
                        "Değişkenleri bellekte dondurmak",
                        "Sadece Android işletim sisteminde çalışmasını sağlamak"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Jenerikler sayesinde aynı kodu farklı tipler için güvenle yeniden kullanırız.",
                    explanationWrong = "Jenerikler tip güvenliği ve kodun yeniden kullanılabilirliğini sağlar.",
                    reviewTopic = "Kotlin Generics"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Jenerik tip parametresi sınırlandırılabilir (Constraint) mi?",
                    answer = "Evet! Örneğin `<T : Number>` yazarak T'nin yalnızca sayısal tipler (Int, Double vb.) olmasını zorunlu kılabilirsiniz."
                )
            ),
            communityInsights = listOf(
                CommunityInsight(
                    source = "StackOverflow Top Best Practice",
                    topic = "Neden 'Any' yerine Generics (<T>) tercih edilmelidir?",
                    insight = "'Any' kullandığınızda nesneyi geri alırken '(nesne as String)' şeklinde manuel dönüştürme yapmanız gerekir. Eğer yanlış tipe çevirirseniz ClassCastException patlar. Generics ile derleyici tipi zaten bilir, çökme riski sıfırdır.",
                    commonMistake = "Her yere Any koyup 'as' ile tip dönüştürerek çalışma zamanı çökmelerine davetiye çıkarmak."
                )
            ),
            completionCriteria = listOf(
                "Jenerik fonksiyon ve sınıf tanımlayabilmek",
                "Tip güvenliği avantajını kavramak"
            )
        ),

        // ==========================================
        // DERS 10: REAKTİF KOTLIN FLOW VE STATEFLOW
        // ==========================================
        Lesson(
            id = "kt_10",
            courseId = "kotlin",
            sectionId = "kt_sec_5",
            title = "Reaktif Akışlar: Kotlin Flow ve StateFlow Mimarisi",
            shortDesc = "Canlı veri akışları (Asynchronous Cold/Hot Streams), emit, collect ve Jetpack Compose ile durum entegrasyonu.",
            level = CourseLevel.EXPERT,
            order = 10,
            isPremium = true,
            learningObjectives = listOf(
                "Flow (Soğuk Akış) ve StateFlow (Sıcak Akış) farkını kavramak",
                "emit ile veri yaymak ve collect ile veriyi dinlemek",
                "Android ViewModel'de StateFlow ile UI güncelleme mantığını anlamak"
            ),
            prerequisites = listOf("Coroutines ve suspend Fonksiyonlar"),
            subtopics = listOf("Flow Nedir?", "emit ve collect", "StateFlow vs SharedFlow", "Compose Entegrasyonu"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Kotlin Flow Mantığı: Veri Musluğu Analojisi",
                    body = "Bir `suspend` fonksiyon geriye sadece tek bir değer döndürebilir. Peki ya borsa fiyatları, sayaç değerleri veya sohbet mesajları gibi zaman içinde sürekli akan birden fazla veri varsa?\n\nİşte burada devreye **Kotlin Flow** girer. Flow, zaman içinde birden çok değeri asenkron olarak yayan bir **Veri Akışıdır (*Asynchronous Stream*)**.",
                    codeSnippet = "// 1 saniye arayla 3 sayı yayan akış:\nfun sayacFlow() = kotlinx.coroutines.flow.flow {\n    for (i in 1..3) {\n        kotlinx.coroutines.delay(1000)\n        emit(i) // Musluktan yeni damla damlat\n    }\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. StateFlow: Modern Android'in Durum Taşıyıcısı",
                    body = "**StateFlow**, her zaman en son güncel değeri hafızasında tutan ve arayüze sunan *sıcak bir akıştır (*Hot Stream*)*. Jetpack Compose ekranları StateFlow'daki her değişikliği otomatik olarak algılayıp ekranı yeniden çizer (*Recomposition*).",
                    codeSnippet = "// ViewModel içinde tipik kullanım:\n// val _uiState = MutableStateFlow(UiState.Loading)\n// val uiState = _uiState.asStateFlow()"
                )
            ),
            codeExample = "fun main() {\n    println(\"Flow mimarisi Android'de LiveData'nın yerini almıştır.\")\n}",
            codeExplanation = "Flow ve StateFlow modern Android MVI/MVVM mimarisinin reaktif kalbidir.",
            realWorldExample = "Kripto para uygulamasında Bitcoin fiyatının anlık değişimleri `flow` ile sunucudan dinlenir ve Compose ekranına `collectAsState()` ile yansıtılır.",
            practicalTask = "Flow kavramını açıklayan bir zihin haritası çıkarın ve emit/collect ikilisinin çalışma mantığını özetleyin.",
            starterPlaygroundCode = "fun main() {\n    println(\"Flow veriyi emit eder, UI ise collect ile dinler.\")\n}",
            miniQuestion = MiniQuestion(
                id = "kt_q_10",
                question = "Kotlin Flow'da yeni bir veri yayınlamak için hangi fonksiyon çağrılır?",
                options = listOf("emit()", "send()", "push()", "publish()"),
                correctIndex = 0,
                explanation = "Flow içinde veri akışına yeni bir eleman bırakmak için emit() kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_10",
                lessonId = "kt_10",
                title = "Metin Akışı Dönüştürücü",
                instructions = "Verilen bir kelime listesindeki her kelimenin sonuna '!' işareti ekleyip listeleyen `fun unlemEkle(kelimeler: List<String>): List<String>` fonksiyonunu yazın.",
                exampleInput = "listOf('Kotlin', 'Flow')",
                exampleOutput = "listOf('Kotlin!', 'Flow!')",
                starterCode = "fun unlemEkle(kelimeler: List<String>): List<String> {\n    // map kullanarak yaz:\n    return emptyList()\n}",
                solutionCode = "fun unlemEkle(kelimeler: List<String>): List<String> {\n    return kelimeler.map { \"\$it!\" }\n}",
                hints = listOf("kelimeler.map { \"\$it!\" } döndürün."),
                testCases = listOf(
                    TestCase("unlemEkle(listOf(\"Android\", \"Flow\"))", "[Android!, Flow!]", "Ünlem ekleme")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_10_1",
                    lessonId = "kt_10",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "StateFlow ile normal Flow arasındaki temel fark nedir?",
                    options = listOf(
                        "StateFlow her zaman en son değeri belleğinde tutar ve yeni abone olanlara anında son değeri verir",
                        "StateFlow sadece sayılarla çalışır",
                        "Normal Flow daha hızlıdır",
                        "StateFlow coroutine gerektirmez"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Harika! StateFlow her an mevcut durumu (State) saklar, bu yüzden UI durumları için mükemmeldir.",
                    explanationWrong = "StateFlow her zaman son güncel durumu tutar.",
                    reviewTopic = "Kotlin StateFlow"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Flow ne zaman çalışmaya başlar?",
                    answer = "Normal (Cold) Flow'lar tembeldir; biri '.collect()' çağırıp akışı dinlemeye başlayana kadar hiçbir kod çalışmaz."
                )
            ),
            communityInsights = listOf(
                CommunityInsight(
                    source = "Android Official Best Practices",
                    topic = "Neden LiveData yerine StateFlow kullanıyoruz?",
                    insight = "StateFlow Kotlin'in saf dil özelliğidir, Android SDK'sına bağımlı değildir. Bu sayede hem Android hem Kotlin Multiplatform (KMP) projelerinde masaüstü ve iOS ile ortak kod olarak çalışabilir.",
                    commonMistake = "Compose projelerinde eski LiveData mimarisini kullanmaya devam etmek."
                )
            ),
            completionCriteria = listOf(
                "Flow ve StateFlow mantığını kavramak",
                "emit ve collect ilişkisini anlamak"
            )
        ),

        // ==========================================
        // DERS 11: NESNE TEKLİKLERİ (object, companion object)
        // ==========================================
        Lesson(
            id = "kt_11",
            courseId = "kotlin",
            sectionId = "kt_sec_3",
            title = "Tekil Nesneler: object, Companion Object ve Singleton Deseni",
            shortDesc = "Thread-safe Singleton oluşturmanın en zarif yolu: object kelimesi ve Java'daki static yerine companion object.",
            level = CourseLevel.INTERMEDIATE,
            order = 11,
            isPremium = true,
            learningObjectives = listOf(
                "object anahtar kelimesi ile tekil (Singleton) nesne oluşturmak",
                "companion object mantığını ve Java'daki static kavramıyla farkını kavramak",
                "Sabitleri ve fabrika metotlarını companion object içinde organize etmek"
            ),
            prerequisites = listOf("Sınıflar"),
            subtopics = listOf("object ile Singleton", "companion object", "Factory Pattern", "Sabitler (const val)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. object ile Zahmetsiz Singleton",
                    body = "Yazılım geliştirmede tüm uygulama boyunca bellekte sadece tek bir örneği (*Single Instance*) olması gereken yapılar vardır (Örn: Veritabanı yöneticisi, Konfigürasyon nesnesi).\n\nDiğer dillerde karmaşık çift kilitli kontroller (*Double-checked locking*) gerekirken, Kotlin'de sadece `object` yazarak anında thread-safe bir Singleton oluşturursunuz!",
                    codeSnippet = "object UygulamaAyarlari {\n    var tema: String = \"Koyu\"\n    const val SURUM = \"1.0.0\"\n}\n\nfun main() {\n    // 'new' demeden doğrudan erişilir:\n    println(UygulamaAyarlari.tema)\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. companion object: Sınıfa Bağlı Statik Alan",
                    body = "Kotlin'de `static` anahtar kelimesi yoktur! Bunun yerine bir sınıfın tüm örnekleri tarafından paylaşılan ortak metot ve sabitler **`companion object` (Yoldaş Nesne)** içine konur.",
                    codeSnippet = "class Kullanici(val ad: String) {\n    companion object {\n        const val MIN_SIFRE_UZUNLUGU = 6\n        \n        fun misafirKullanici() = Kullanici(\"Misafir\")\n    }\n}\n\nval misafir = Kullanici.misafirKullanici()"
                )
            ),
            codeExample = "class Matematik {\n    companion object {\n        fun topla(a: Int, b: Int) = a + b\n    }\n}\n\nfun main() {\n    println(\"Toplam: \${Matematik.topla(10, 20)}\")\n}",
            codeExplanation = "Matematik sınıfından nesne üretmeden companion object içindeki topla metoduna erişildi.",
            realWorldExample = "Android'de her Activity veya Fragment kendi `newInstance()` fabrika metodunu veya `TAG = \"HomeFragment\"` log sabitini companion object içinde tutar.",
            practicalTask = "Veritabani adında bir object (Singleton) tanımlayın ve icinde baglantiDurumu: String değişkeni barındırın.",
            starterPlaygroundCode = "object Veritabani {\n    val bagliMi: Boolean = true\n}\n\nfun main() {\n    println(\"Veritabanı durumu: \${Veritabani.bagliMi}\")\n}",
            miniQuestion = MiniQuestion(
                id = "kt_q_11",
                question = "Kotlin'de bir sınıfın örneğini oluşturmadan doğrudan sınıf adıyla erişilebilen metot ve sabitleri barındıran yapı hangisidir?",
                options = listOf("companion object", "static object", "shared object", "public scope"),
                correctIndex = 0,
                explanation = "Kotlin'de static yerine companion object kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_11",
                lessonId = "kt_11",
                title = "Sabit Üretici",
                instructions = "UygulamaBilgisi adında bir object tanımlayın. İçinde `val APP_NAME = \"KodAkademi\"` sabiti bulunsun ve bu sabiti döndüren `fun getAppName(): String = UygulamaBilgisi.APP_NAME` fonksiyonunu yazın.",
                exampleInput = "getAppName()",
                exampleOutput = "'KodAkademi'",
                starterCode = "object UygulamaBilgisi {\n    val APP_NAME = \"KodAkademi\"\n}\n\nfun getAppName(): String {\n    // Kodu tamamla:\n    return \"\"\n}",
                solutionCode = "object UygulamaBilgisi {\n    val APP_NAME = \"KodAkademi\"\n}\n\nfun getAppName(): String {\n    return UygulamaBilgisi.APP_NAME\n}",
                hints = listOf("return UygulamaBilgisi.APP_NAME yazın."),
                testCases = listOf(
                    TestCase("getAppName()", "KodAkademi", "Sabit okuma")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_11_1",
                    lessonId = "kt_11",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Kotlin'de 'object' anahtar kelimesi ile tanımlanan bir yapı ilk kez ne zaman belleğe yüklenir (Initialize edilir)?",
                    options = listOf(
                        "Ona ilk kez erişildiği anda (Lazy Initialization) ve güvenli bir şekilde tek bir örnek olarak",
                        "Uygulama açılır açılmaz anında",
                        "Her fonksiyon çağrısında yeniden oluşturulur",
                        "Sadece derleme zamanında"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Mükemmel! Kotlin object tekilleri tembelce (lazily) ilk erişimde belleğe yüklenir.",
                    explanationWrong = "object yapıları ilk erişimde yüklenir.",
                    reviewTopic = "Kotlin Singleton"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Bir sınıfın içinde birden fazla companion object olabilir mi?",
                    answer = "Hayır! Her sınıfın en fazla bir adet companion object'i olabilir."
                )
            ),
            communityInsights = listOf(
                CommunityInsight(
                    source = "Kotlin Style Guide",
                    topic = "const val ile normal val companion object içinde nasıl kullanılır?",
                    insight = "Eğer değer derleme zamanında bilinen bir ilkel tip veya String ise (Örn: const val TIMEOUT = 5000) mutlaka 'const val' yazın. Bu sayede derleyici arka planda getter metodu üretmez, doğrudan değeri koda gömer ve performansı artırır.",
                    commonMistake = "Değişmeyen basit sabitleri const yapmayıp gereksiz getter metodu maliyeti oluşturmak."
                )
            ),
            completionCriteria = listOf(
                "object ile Singleton tanımlayabilmek",
                "companion object kullanımını bilmek"
            )
        ),

        // ==========================================
        // DERS 12: ROBUST HATA YÖNETİMİ, RESULT VE TEMİZ KOD
        // ==========================================
        Lesson(
            id = "kt_12",
            courseId = "kotlin",
            sectionId = "kt_sec_6",
            title = "Profesyonel Kotlin: Hata Yönetimi (Result Monad) ve Temiz Kod İlkeleri",
            shortDesc = "Çökmeyen uygulamaların sırrı: runCatching, Result.success/failure, Unchecked Exceptions ve profesyonel ipuçları.",
            level = CourseLevel.EXPERT,
            order = 12,
            isPremium = true,
            learningObjectives = listOf(
                "runCatching ve Result monad yapısıyla hatasız kod mimarisi kurmak",
                "Kotlin'de Checked Exception zorunluluğunun neden kaldırıldığını anlamak",
                "Tebrikler: Artık tam donanımlı bir Kotlin geliştiricisisiniz!"
            ),
            prerequisites = listOf("Tüm Kotlin Konuları"),
            subtopics = listOf("try-catch ve finally", "runCatching & Result", "Neden Unchecked Exceptions?", "Kariyer Tavsiyeleri"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Modern Hata Yönetimi: runCatching ve Result",
                    body = "Geleneksel `try-catch` blokları kodu hantallaştırır. Kotlin'in fonksiyonel **`runCatching`** yapısı, bir işlemi dener ve geriye bir **`Result<T>`** nesnesi döndürür.\n\nBu nesne ya `.isSuccess` ya da `.isFailure` durumundadır. `.getOrDefault()` veya `.fold()` ile tek satırda zarifçe yönetilir.",
                    codeSnippet = "// Tek satırda güvenli sayı çevirici:\nval sayi = runCatching { \"abc\".toInt() }.getOrDefault(0)\nprintln(\"Sonuç: \$sayi\") // Hata fırlatmaz, 0 döner!"
                ),
                LessonContentBlock(
                    subtitle = "2. Tebrikler! Kotlin Yolculuğunuz Başarıyla Tamamlandı! 🏆",
                    body = "Değişkenlerin bellek mimarisinden Null Safety'ye, fonksiyonel koleksiyonlardan Coroutines ve Flow mimarisine kadar modern Android dünyasının en güçlü dilini eksiksiz kavradınız!\n\nŞimdi Jetpack Compose ile modern Android uygulamaları inşa etme ve projelerinizi hayata geçirme zamanı! 🚀📱"
                )
            ),
            codeExample = "fun guvenliBolme(a: Int, b: Int): Result<Int> {\n    return runCatching { a / b }\n}\n\nfun main() {\n    val sonuc = guvenliBolme(10, 0)\n    println(\"Başarılı mı: \${sonuc.isSuccess}, Değer: \${sonuc.getOrElse { -1 }}\")\n}",
            codeExplanation = "runCatching ile sıfıra bölme hatası yakalandı ve Result monad yapısıyla güvenle yönetildi.",
            realWorldExample = "Mobil uygulamalarda sunucudan gelen JSON verisi çözülürken (Parsing) runCatching kullanılır; veri bozuk gelse bile uygulama çökmez, kullanıcıya kibar bir hata mesajı gösterilir.",
            practicalTask = "Geçersiz bir JSON veya metni sayıya çevirmeyi deneyen runCatching bloğu yazıp getOrDefault(-1) ile test edin.",
            starterPlaygroundCode = "fun main() {\n    val sonuc = runCatching { \"gecersiz\".toInt() }.getOrDefault(-1)\n    println(\"Sonuç: \$sonuc\")\n}",
            miniQuestion = MiniQuestion(
                id = "kt_q_12",
                question = "Kotlin'de bir kod bloğunu çalıştırıp hata durumunda güvenli bir Result nesnesi üreten fonksiyon hangisidir?",
                options = listOf("runCatching", "trySafe", "guardCatch", "safeExecute"),
                correctIndex = 0,
                explanation = "runCatching fonksiyonu modern Kotlin hata yönetiminin merkezidir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_12",
                lessonId = "kt_12",
                title = "Güvenli Sayı Çevirici",
                instructions = "Verilen bir metni (String) Int'e çevirmeye çalışan, hata olursa -1 döndüren `guvenliCevir(metin: String): Int` fonksiyonunu runCatching ile yazın.",
                exampleInput = "guvenliCevir('100')",
                exampleOutput = "100",
                starterCode = "fun guvenliCevir(metin: String): Int {\n    // runCatching ile yaz:\n    return 0\n}",
                solutionCode = "fun guvenliCevir(metin: String): Int {\n    return runCatching { metin.toInt() }.getOrDefault(-1)\n}",
                hints = listOf("runCatching { metin.toInt() }.getOrDefault(-1) ifadesini döndürün."),
                testCases = listOf(
                    TestCase("guvenliCevir(\"42\")", "42", "Geçerli sayı"),
                    TestCase("guvenliCevir(\"hata\")", "-1", "Geçersiz metin")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_12_1",
                    lessonId = "kt_12",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Kotlin'de Java'dan farklı olarak Checked Exception zorunluluğu neden kaldırılmıştır?",
                    options = listOf(
                        "Kodu gereksiz throws ve boş catch bloklarıyla kirletmemek ve fonksiyonel hata yönetimini teşvik etmek için",
                        "Hataların yakalanmasını engellemek için",
                        "Derleme süresini uzatmak için",
                        "Sadece Linux işletim sisteminde çalıştığı için"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Kotlin gereksiz 'try-catch' kalabalığını kaldırarak geliştiriciye daha temiz ve esnek bir hata kontrolü sunar.",
                    explanationWrong = "Kotlin'de Checked Exception olmaması kodun temiz ve akıcı olmasını sağlar.",
                    reviewTopic = "Kotlin Hata Yönetimi Felsefesi"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "finally bloğunun garantisi nedir?",
                    answer = "try bloğunda hata oluşsa da oluşmasa da, dosya kapatma veya kaynak temizleme işlemleri için finally bloğu kesinlikle çalıştırılır."
                )
            ),
            communityInsights = listOf(
                CommunityInsight(
                    source = "Reddit r/androiddev Mülakat İpucu",
                    topic = "Senior Android mülakatlarında en çok sorulan Kotlin sorusu",
                    insight = "Mülakatlarda 'Kotlin'de null safety ve coroutines nasıl çalışır?' sorusunun yanında 'Flow vs LiveData' ve 'Scope functions arasındaki farklar' sorulur. Bu müfredatta edindiğiniz temel mantık ve community insight'lar sizi her mülakatta öne geçirecektir.",
                    commonMistake = "Sadece sözdizimini ezberleyip arkasındaki bellek ve eşzamanlılık mantığını bilmemek."
                )
            ),
            completionCriteria = listOf(
                "runCatching ve Result monad yapısını kullanabilmek",
                "Temiz, güvenli ve çökmeyen Kotlin mimarisi kurabilmek"
            )
        )
    )
}
