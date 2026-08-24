package com.example.data.catalog

import com.example.model.*

/**
 * Kotlin Complete Official Curriculum (12 Sequential Lessons):
 * BEGINNER -> FUNDAMENTAL -> INTERMEDIATE -> ADVANCED -> EXPERT
 * Seamless progression from basic syntax & null safety to Flow, Coroutines, Delegation, Inline Bytecode & KSP/Compiler Plugins.
 */
object KotlinCurriculum {

    fun getSections(): List<CourseSection> = listOf(
        CourseSection(
            id = "kt_sec_1",
            courseId = "kotlin",
            title = "Seviye 1 – Kotlin Temelleri, Değişkenler & Null Güvenliği",
            level = CourseLevel.BEGINNER,
            order = 1,
            description = "Kotlin felsefesi, val vs var değişmezlik ilkesi, temel tipler, String şablonları ve Milyar Dolarlık Hata'yı önleyen Null Safety (?, ?:).",
            learningObjectives = listOf("val vs var mimari farkı", "Null Safety (?, ?:, !!) mekanizması", "Smart Casts (is operatörü)", "Temel veri tipleri ve tip çıkarımı"),
            prerequisites = listOf("Temel bilgisayar kullanım bilgisi")
        ),
        CourseSection(
            id = "kt_sec_2",
            courseId = "kotlin",
            title = "Seviye 2 – Kontrol Akışı & Fonksiyonel Programlama Temelleri",
            level = CourseLevel.BEGINNER,
            order = 2,
            description = "İfade tabanlı when ve if yapıları, for/while döngüleri, tek satırlık fonksiyonlar, varsayılan/isimlendirilmiş argümanlar ve lambdalar.",
            learningObjectives = listOf("when ifadesi ile örüntü eşleme", "for in ranges (step, downTo, until)", "Single-expression fonksiyonlar", "Higher-Order Functions ve Lambda sözdizimi"),
            prerequisites = listOf("Kotlin Temelleri ve Null Güvenliği")
        ),
        CourseSection(
            id = "kt_sec_3",
            courseId = "kotlin",
            title = "Seviye 3 – Nesne Yönelimli Kotlin: Sınıflar, Data Classes & Sealed Classes",
            level = CourseLevel.INTERMEDIATE,
            order = 3,
            description = "Birincil/İkincil kurucular, init blokları, Data Classes (copy, destructuring), Sealed Classes & Interfaces, Enum Classes ve Singleton (object).",
            learningObjectives = listOf("Primary/Secondary Constructor ve init", "Data Classes (equals, hashCode, copy)", "Sealed Classes ile Tip Güvenli UI Durumu", "Companion Object ve Singleton deseni"),
            prerequisites = listOf("Kotlin Kontrol Akışı ve Fonksiyonlar")
        ),
        CourseSection(
            id = "kt_sec_4",
            courseId = "kotlin",
            title = "Seviye 4 – İleri Kotlin: Genişletmeler (Extensions), Jenerikler & Delegasyon",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            description = "Extension Functions & Properties, Kapsam Fonksiyonları (let, run, apply, also, with), Jenerikler (in, out, reified) ve Delegasyon (by lazy, Delegates.observable).",
            learningObjectives = listOf("Extension Functions ile sınıfları genişletme", "Scope Functions (let, run, apply, also)", "Generics varyansı (in vs out / Kovaryans)", "Property Delegation (by lazy)"),
            prerequisites = listOf("Nesne Yönelimli Kotlin ve Sınıflar")
        ),
        CourseSection(
            id = "kt_sec_5",
            courseId = "kotlin",
            title = "Seviye 5 – Asenkron Kotlin: Coroutines & Reaktif Flow Mimarisi",
            level = CourseLevel.ADVANCED,
            order = 5,
            description = "Kotlin Coroutines temelleri (suspend, CoroutineScope, Dispatchers, Structured Concurrency), Asenkron Flow akışları, StateFlow ve SharedFlow.",
            learningObjectives = listOf("suspend fonksiyonlar ve duraklatma mekanizması", "CoroutineScope, Job ve Dispatchers", "Reaktif Cold Flow (map, filter, collect)", "Hot Streams: StateFlow ve SharedFlow"),
            prerequisites = listOf("İleri Kotlin ve Kapsam Fonksiyonları")
        ),
        CourseSection(
            id = "kt_sec_6",
            courseId = "kotlin",
            title = "Seviye 6 – Uzman Seviye: Channels, SupervisorJob & KSP / Bytecode",
            level = CourseLevel.EXPERT,
            order = 6,
            description = "Channels (Kuyruklar), Hata yayılımı (SupervisorJob vs Job), Inline Fonksiyonlar (noinline, crossinline, reified), Kotlin Symbol Processing (KSP) ve Bytecode analizi.",
            learningObjectives = listOf("Channels ve Actor mimarisi", "Hata yayılımı: Job vs SupervisorJob", "KSP ile derleme zamanı kod üretimi", "Inline fonksiyonların Bytecode analizi"),
            prerequisites = listOf("İleri Coroutines ve Reaktif Flow Mimarisi")
        )
    )

    fun getLessons(): List<Lesson> = listOf(
        // ==========================================
        // DERS 1: TEMEL SÖZDİZİMİ, VAL/VAR & NULL SAFETY (ÜCRETSİZ)
        // ==========================================
        Lesson(
            id = "kt_1",
            courseId = "kotlin",
            sectionId = "kt_sec_1",
            title = "Kotlin'e Giriş, Değişkenler & Devrimsel Null Safety",
            shortDesc = "val vs var değişmezlik ilkesi, tip çıkarımı (type inference), String şablonları ve Milyar Dolarlık Hata'yı bitiren Null Safety (?, ?:).",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false,
            learningObjectives = listOf(
                "val (değişmez) ve var (değişken) arasındaki mimari farkı öğrenmek",
                "Kotlin'in Null Safety (?, !!, ?:) mekanizmasını kavramak",
                "String şablonları ve akıllı tip dönüşümlerini (Smart Cast) kullanmak"
            ),
            prerequisites = listOf("Ön koşul gerekmez. Sıfırdan başlar."),
            subtopics = listOf("val vs var", "Temel Veri Tipleri", "Null Güvenliği (?)", "Elvis Operatörü (?:)", "Smart Casts (is)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Null Safety: NullPointerException Tarihe Karışıyor",
                    body = "Kotlin'de tipler varsayılan olarak `null` değer ALAMAZ. Null alabilecek değişkenler sonuna `?` konularak açıkça belirtilir. Bu sayede derleyici çalışma zamanında çökebilecek tüm null risklerini derleme anında yakalar.",
                    codeSnippet = "var isim: String = \"Ahmet\" // Asla null olamaz\nvar soyisim: String? = null // Null alabilir\n\nval uzunluk = soyisim?.length ?: 0 // Elvis: null ise 0 ata"
                ),
                LessonContentBlock(
                    subtitle = "2. val vs var Tercihi",
                    body = "Kotlin felsefesi gereği değişkenler varsayılan olarak `val` (immutable / salt okunur) tanımlanmalıdır. Sadece değeri değişmek zorunda olan durumlar için `var` kullanılmalıdır.",
                    tip = "Asla zorunlu kalmadıkça `!!` (not-null assertion) kullanmayın; bu operatör null durumunda uygulamanızı anında çökertir."
                )
            ),
            codeExample = "fun main() {\n    val kullaniciAdi: String? = \"Zeynep\"\n    val mesaj = \"Hoş geldin, \" + (kullaniciAdi ?: \"Misafir\")\n    val harfSayisi = kullaniciAdi?.length ?: 0\n    \n    println(\"\$mesaj (Karakter: \$harfSayisi)\")\n}",
            codeExplanation = "kullaniciAdi null olsaydı Elvis (?:) sayesinde 'Misafir' yazılacak ve uzunluk 0 olacaktı. NullPointerException imkansız hale getirildi.",
            realWorldExample = "Android ekosisteminde Google, Kotlin-First yaklaşımını benimsemiştir ve modern Android uygulamalarının %95+'ı Kotlin ile yazılmaktadır.",
            practicalTask = "Null olabilecek bir e-posta adresini kontrol edip, null ise 'E-posta belirtilmedi' yazdıran bir Kotlin kodu yazın.",
            starterPlaygroundCode = "fun main() {\n    val ad: String? = null\n    println(\"Kullanıcı: \" + (ad ?: \"Anonim\"))\n}",
            miniQuestion = MiniQuestion(
                id = "kt_q_1",
                question = "Kotlin'de 'null' olabilecek bir ifadenin null gelmesi durumunda varsayılan bir yedek değer atamak için hangi operatör kullanılır?",
                options = listOf("Safe Call (?.)", "Elvis Operatörü (?:)", "Not-null Assertion (!!)", "Smart Cast (as?)"),
                correctIndex = 1,
                explanation = "Elvis Operatörü (?:) solundaki ifade null ise sağındaki varsayılan değeri döndürür."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_1",
                lessonId = "kt_1",
                title = "Güvenli İsim Uzunluğu",
                instructions = "String? tipinde bir isim alıp; isim varsa uzunluğunu, null ise 0 döndüren guvenliUzunluk(isim) fonksiyonunu yazın.",
                exampleInput = "isim = \"Kotlin\"",
                exampleOutput = "6",
                starterCode = "fun guvenliUzunluk(isim: String?): Int {\n    // Kodunu buraya yaz:\n    return 0\n}",
                solutionCode = "fun guvenliUzunluk(isim: String?): Int {\n    return isim?.length ?: 0\n}",
                hints = listOf("isim?.length ?: 0 ifadesini döndürün."),
                testCases = listOf(
                    TestCase("guvenliUzunluk(\"Kotlin\")", "6", "Dolu string"),
                    TestCase("guvenliUzunluk(null)", "0", "Null string")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_1_1",
                    lessonId = "kt_1",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Kotlin'de bir değişken 'val' olarak tanımlandığında ne anlama gelir?",
                    options = listOf("Değeri daha sonra tekrar değiştirilebilir", "Salt okunurdur (immutable); bir kez değer atandıktan sonra yeniden atanamaz", "Statik değişkendir", "Bellekte yer tutmaz"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! val (value) bir kez atanır ve değiştirilemez; referans değişmezliği sağlar.",
                    explanationWrong = "val değiştirilemez (read-only) referans tanımlar.",
                    reviewTopic = "val vs var"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Smart Cast (Akıllı Tip Dönüşümü) nedir?",
                    answer = "Kotlin derleyicisi bir nesnenin `if (x is String)` veya `if (x != null)` ile kontrol edildiğini gördüğü an o blok içinde x'i otomatik olarak ilgili tipe dönüştürür; manuel cast yapmanıza gerek kalmaz."
                )
            ),
            completionCriteria = listOf(
                "val ve var kullanım kurallarını bilmek",
                "Null Safety operatörlerini (?, ?:) hatasız kullanabilmek",
                "String şablonları ile metin üretebilmek"
            )
        ),

        // ==========================================
        // DERS 2: KONTROL AKIŞI: WHEN & EXPRESSIONS (ÜCRETSİZ)
        // ==========================================
        Lesson(
            id = "kt_2",
            courseId = "kotlin",
            sectionId = "kt_sec_1",
            title = "Kontrol Akışı: when, if İfadeleri & Aralıklar (Ranges)",
            shortDesc = "Kotlin'de if ve when birer deyim değil DEĞER DÖNDÜREN İFADEDİR (Expression). Pattern matching benzeri when, for döngüleri ve range aralıkları.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false,
            learningObjectives = listOf(
                "if ve when yapılarını değer döndüren bir ifade (expression) olarak kullanmak",
                "when içinde tip, aralık ve çoklu koşul denetimlerini öğrenmek",
                "downTo, step ve until ile for döngülerini kurmak"
            ),
            prerequisites = listOf("Kotlin'e Giriş, Değişkenler ve Null Safety"),
            subtopics = listOf("if as Expression", "when İfadesi & Exhaustiveness", "Ranges (1..10, until, downTo, step)", "for in Koleksiyonlar", "while ve do-while"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. if ve when Değer Döndürür",
                    body = "Kotlin'de ternary (`?:`) operatörü yoktur; çünkü `val max = if (a > b) a else b` doğrudan sonuç üretir. Benzer şekilde `when` her daldan bir değer döndürebilir.",
                    codeSnippet = "val sonuc = when (not) {\n    in 90..100 -> \"AA\"\n    in 80..89 -> \"BA\"\n    is Int -> \"Geçerli Sayı\"\n    else -> \"Kaldı\"\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Ranges ve İterasyonlar",
                    body = "• `1..5`: 1, 2, 3, 4, 5\n• `1 until 5`: 1, 2, 3, 4 (5 hariç)\n• `10 downTo 1 step 2`: 10, 8, 6, 4, 2",
                    tip = "when bir ifade olarak kullanıldığında derleyici tüm dalların kapsanmasını (`else` veya enum/sealed tiplerde tüm durumları) zorunlu kılar."
                )
            ),
            codeExample = "fun sinavDegerlendir(puan: Int): String {\n    return when (puan) {\n        in 90..100 -> \"Mükemmel\"\n        in 70..89 -> \"Başarılı\"\n        in 50..69 -> \"Orta\"\n        in 0..49 -> \"Tekrar Deneyin\"\n        else -> \"Geçersiz Puan\"\n    }\n}\n\nfun main() {\n    for (i in 1..3) {\n        print(\"\$i. Derece: \" + sinavDegerlendir(i * 30) + \" | \")\n    }\n}",
            codeExplanation = "when puan aralığına göre metin döndürdü; for döngüsü range içinde iterasyon yaptı.",
            realWorldExample = "Android ViewModel katmanında ağ durumunu (Loading, Success, Error) kontrol ederken `when` yapısı standarttır.",
            practicalTask = "1'den 50'ye kadar olan tek sayıları step kullanarak ekrana yazdırın.",
            starterPlaygroundCode = "fun main() {\n    for (i in 10 downTo 1 step 2) { print(\"\$i \") }\n}",
            miniQuestion = MiniQuestion(
                id = "kt_q_2",
                question = "Kotlin'de '1 until 10' aralığı hangi sayıları kapsar?",
                options = listOf("1'den 10'a kadar (10 dahil)", "1'den 9'a kadar (10 hariç)", "2'den 9'a kadar", "Sadece 1 ve 10"),
                correctIndex = 1,
                explanation = "'until' üst sınırı hariç tutar (exclusive); 1..9 arasını kapsar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_2",
                lessonId = "kt_2",
                title = "HTTP Durum Mesajı (when)",
                instructions = "Int kod alıp; 200 -> 'OK', 404 -> 'Not Found', 500 -> 'Server Error', diğerleri -> 'Unknown' döndüren httpMesaji(kod) fonksiyonunu when ifadesiyle yazın.",
                exampleInput = "kod = 200",
                exampleOutput = "\"OK\"",
                starterCode = "fun httpMesaji(kod: Int): String {\n    // Kodunu buraya yaz:\n    return \"\"\n}",
                solutionCode = "fun httpMesaji(kod: Int): String = when (kod) {\n    200 -> \"OK\"\n    404 -> \"Not Found\"\n    500 -> \"Server Error\"\n    else -> \"Unknown\"\n}",
                hints = listOf("when (kod) { 200 -> \"OK\" ... else -> \"Unknown\" } kullanın."),
                testCases = listOf(
                    TestCase("httpMesaji(200)", "OK", "200 testi"),
                    TestCase("httpMesaji(404)", "Not Found", "404 testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_2_1",
                    lessonId = "kt_2",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Kotlin'de 'if' yapısı Java'dan farklı olarak hangi özelliğe sahiptir?",
                    options = listOf("Sadece boolean değerlerle çalışır", "Bir ifade (expression) olarak değer döndürebilir ve değişkene atanabilir", "Döngü olarak çalışabilir", "Sınıf içinde tanımlanamaz"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Kotlin'de if bir ifadedir ve son satırındaki değer otomatik olarak döner.",
                    explanationWrong = "if Kotlin'de değer döndüren bir ifadedir.",
                    reviewTopic = "if as Expression"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "when içinde 'is' anahtar kelimesi ne yapar?",
                    answer = "Değişkenin tipini kontrol eder (`is String`) ve doğruysa o dal içinde değişkeni otomatik olarak o tipe cast eder (Smart Cast)."
                )
            ),
            completionCriteria = listOf(
                "when ve if ifadelerini değer döndürecek şekilde kullanmak",
                "Ranges operatörlerini (until, downTo, step) kavramak",
                "when içinde kapsamlı örüntü eşleme yapabilmek"
            )
        ),

        // ==========================================
        // DERS 3: FONKSİYONLAR & HIGHER-ORDER LAMBDALAR
        // ==========================================
        Lesson(
            id = "kt_3",
            courseId = "kotlin",
            sectionId = "kt_sec_2",
            title = "Fonksiyonlar, Tek Satırlı İfadeler & Higher-Order Lambdalar",
            shortDesc = "Varsayılan/isimlendirilmiş argümanlar, tek satırlı fonksiyonlar (=), Vararg, Fonksiyonel Programlama: Lambda ifadeleri, trailing lambda ve 'it' anahtar kelimesi.",
            level = CourseLevel.BEGINNER,
            order = 3,
            isPremium = false,
            learningObjectives = listOf(
                "Default & Named Arguments ile kod okunabilirliğini artırmak",
                "Tek satırlı (Single-expression) fonksiyonlar yazmak",
                "Higher-Order Functions ve Trailing Lambda sözdizimini kavramak"
            ),
            prerequisites = listOf("Kotlin Kontrol Akışı ve Döngüler"),
            subtopics = listOf("Named & Default Arguments", "Single-Expression Functions", "Vararg Parametreleri", "Lambda İfadeleri & 'it'", "Higher-Order Functions (Fonksiyon Alan Fonksiyonlar)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Default & Named Arguments",
                    body = "Parametrelere varsayılan değer vererek Java'daki aşırı yükleme (overloading) karmaşasını bitirebilirsiniz. Çağırırken parametre adını belirterek sırayı serbestçe değiştirebilirsiniz.",
                    codeSnippet = "fun baglan(url: String, timeout: Int = 5000, retry: Boolean = true) { ... }\n// Çağrı:\nbaglan(\"https://api.com\", retry = false)"
                ),
                LessonContentBlock(
                    subtitle = "2. Trailing Lambda Sözdizimi",
                    body = "Bir fonksiyonun SON parametresi bir lambda ise, o lambda parantezlerin DIŞINA süslü parantez `{ }` olarak yazılabilir. Tek parametreli lambdalarda parametre adı `it` olur.",
                    codeSnippet = "val sayilar = listOf(1, 2, 3, 4)\nval ciftler = sayilar.filter { it % 2 == 0 }"
                )
            ),
            codeExample = "fun calismaZamaniHesapla(islemAdi: String, blok: () -> Unit) {\n    val baslangic = System.currentTimeMillis()\n    blok() // Lambdayı çalıştır\n    val sure = System.currentTimeMillis() - baslangic\n    println(\"\$islemAdi tamamlandı: \${sure}ms\")\n}\n\nfun main() {\n    // Trailing lambda kullanımı:\n    calismaZamaniHesapla(\"Veri İndirme\") {\n        Thread.sleep(50)\n    }\n}",
            codeExplanation = "calismaZamaniHesapla Higher-Order fonksiyonu blok parametresi olarak bir lambda aldı ve süresini ölçtü.",
            realWorldExample = "Jetpack Compose'da her UI bileşeni (Button, Column, Row) trailing lambda parametresi alarak çalışır.",
            practicalTask = "İki sayıyı ve bir işlem lambdasını (Int, Int) -> Int alan bir hesaplayıcı fonksiyonu yazın.",
            starterPlaygroundCode = "fun topla(a: Int, b: Int = 10) = a + b\nfun main() { println(topla(5)) }",
            miniQuestion = MiniQuestion(
                id = "kt_q_3",
                question = "Kotlin'de tek bir parametre alan lambda ifadelerinde o parametrenin varsayılan adı nedir?",
                options = listOf("this", "it", "item", "val"),
                correctIndex = 1,
                explanation = "Tek parametreli lambdalarda örtük (implicit) parametre adı 'it'tir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_3",
                lessonId = "kt_3",
                title = "Özel Metin Filtreleyici (Higher-Order)",
                instructions = "String metin ve (Char) -> Boolean koşul lambdası alan, koşulu sağlayan karakterlerden oluşan yeni metni döndüren metinFiltrele(metin, kosul) fonksiyonunu yazın.",
                exampleInput = "metin = \"k-o-t-l-i-n\", kosul = { it != '-' }",
                exampleOutput = "\"kotlin\"",
                starterCode = "fun metinFiltrele(metin: String, kosul: (Char) -> Boolean): String {\n    // Kodunu buraya yaz:\n    return \"\"\n}",
                solutionCode = "fun metinFiltrele(metin: String, kosul: (Char) -> Boolean): String {\n    return metin.filter(kosul)\n}",
                hints = listOf("metin.filter(kosul) kullanabilirsiniz."),
                testCases = listOf(
                    TestCase("metinFiltrele(\"k-o-t-l-i-n\", { it != '-' })", "kotlin", "Filtreleme")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_3_1",
                    lessonId = "kt_3",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Kotlin'de bir fonksiyonun son parametresi bir fonksiyon (lambda) tipinde olduğunda parantez dışına çıkarılması kuralına ne ad verilir?",
                    options = listOf("Inline function", "Trailing Lambda", "Extension Lambda", "Currying"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Bu özelliğe Trailing Lambda denir ve Jetpack Compose DSL'lerinin temelini oluşturur.",
                    explanationWrong = "Trailing Lambda kuralı denir.",
                    reviewTopic = "Trailing Lambda"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Single-expression fonksiyonlar ne zaman tercih edilir?",
                    answer = "Fonksiyonun gövdesi tek bir ifadeden oluştuğunda süslü parantez ve return yazmak yerine doğrudan `fun topla(a: Int, b: Int) = a + b` şeklinde yazılır."
                )
            ),
            completionCriteria = listOf(
                "Default ve Named Arguments kullanabilmek",
                "Lambda ve 'it' sözdizimini kavramak",
                "Higher-Order fonksiyonlar tanımlayabilmek"
            )
        ),

        // ==========================================
        // DERS 4: KOLEKSİYONLAR & FONKSİYONEL API
        // ==========================================
        Lesson(
            id = "kt_4",
            courseId = "kotlin",
            sectionId = "kt_sec_2",
            title = "Koleksiyonlar & Fonksiyonel Dönüşümler (map, filter, reduce)",
            shortDesc = "Değişmez (List) vs Değiştirilebilir (MutableList) koleksiyonlar, Set, Map, Fonksiyonel dönüşüm zincirleri: map, filter, flatMap, groupBy ve fold/reduce.",
            level = CourseLevel.BEGINNER,
            order = 4,
            isPremium = true,
            learningObjectives = listOf(
                "List (salt okunur) ile MutableList (değiştirilebilir) farkını kavramak",
                "map, filter, groupBy ve flatMap ile karmaşık veri dönüşümleri yapmak",
                "reduce ve fold ile liste elemanlarını akümülatörle toplamak"
            ),
            prerequisites = listOf("Fonksiyonlar ve Higher-Order Lambdalar"),
            subtopics = listOf("List vs MutableList", "Set & Map Yapıları", "map, filter & find", "groupBy & associateBy", "fold vs reduce"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Read-Only vs Mutable Koleksiyonlar",
                    body = "Kotlin standart kütüphanesinde `listOf(...)` salt okunurdur (`add`/`remove` metotları yoktur). Değiştirilebilir liste için açıkça `mutableListOf(...)` oluşturulmalıdır.",
                    codeSnippet = "val okunur = listOf(\"A\", \"B\")\n// okunur.add(\"C\") // DERLEME HATASI\nval degisir = mutableListOf(\"A\", \"B\")\ndegisir.add(\"C\") // Geçerli"
                ),
                LessonContentBlock(
                    subtitle = "2. Güçlü Koleksiyon Operatörleri",
                    body = "• `groupBy { it.kategori }`: Elemanları kategoriye göre `Map<Kategori, List<T>>` yapar.\n• `flatMap { it.dersler }`: İç içe listeleri tek bir düz listeye açar.",
                    tip = "Büyük veri setlerinde ara liste kopyalarını engellemek için koleksiyonun başına `.asSequence()` ekleyin (Tembel/Lazy değerlendirme)."
                )
            ),
            codeExample = "data class Urun(val ad: String, val fiyat: Double, val kategori: String)\n\nfun main() {\n    val urunler = listOf(\n        Urun(\"Telefon\", 25000.0, \"Elektronik\"),\n        Urun(\"Kulaklık\", 1500.0, \"Elektronik\"),\n        Urun(\"Kitap\", 120.0, \"Kültür\")\n    )\n    \n    // Elektronik ürünlerin toplam fiyatını hesaplayalım:\n    val elektronikToplam = urunler\n        .filter { it.kategori == \"Elektronik\" }\n        .map { it.fiyat }\n        .sum()\n        \n    println(\"Elektronik Toplam: \$elektronikToplam TL\")\n}",
            codeExplanation = "filter ile elektronik ürünler seçildi, map ile fiyatları çıkarıldı ve sum() ile toplandı.",
            realWorldExample = "Android uygulamalarında arama yaparken veya e-ticaret filtre panellerinde bu fonksiyonel koleksiyon zincirleri kullanılır.",
            practicalTask = "Bir sayı listesindeki çift sayıların karelerini hesaplayıp yeni bir listeye toplayan Kotlin kodu yazın.",
            starterPlaygroundCode = "fun main() {\n    val l = listOf(1, 2, 3, 4)\n    println(l.map { it * it })\n}",
            miniQuestion = MiniQuestion(
                id = "kt_q_4",
                question = "Kotlin'de 'listOf(1, 2, 3)' ile oluşturulan bir listeye sonradan yeni eleman eklenebilir mi?",
                options = listOf("Evet, .add() çağrılarak", "Hayır, listOf salt okunur (read-only) liste üretir; eleman eklemek için mutableListOf kullanılmalıdır", "Sadece sayılar eklenebilir", "Belli şartlarda eklenebilir"),
                correctIndex = 1,
                explanation = "listOf() read-only List interface'i döner ve add/remove metotları bulunmaz."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_4",
                lessonId = "kt_4",
                title = "Pozitif Sayıların Toplamı",
                instructions = "List<Int> alıp içindeki 0'dan büyük pozitif sayıların toplamını Int olarak döndüren pozitifleriTopla(liste) fonksiyonunu yazın.",
                exampleInput = "liste = listOf(10, -5, 20, -1, 5)",
                exampleOutput = "35",
                starterCode = "fun pozitifleriTopla(liste: List<Int>): Int {\n    // Kodunu buraya yaz:\n    return 0\n}",
                solutionCode = "fun pozitifleriTopla(liste: List<Int>): Int {\n    return liste.filter { it > 0 }.sum()\n}",
                hints = listOf("liste.filter { it > 0 }.sum()"),
                testCases = listOf(
                    TestCase("pozitifleriTopla(listOf(10, -5, 20, -1, 5))", "35", "Pozitif toplam")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_4_1",
                    lessonId = "kt_4",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Büyük boyutlu koleksiyonlarda zincirleme map/filter işlemlerinin ara listeler üretmeden tembel (lazy) çalışmasını sağlayan yapı hangisidir?",
                    options = listOf("Sequence (asSequence())", "Array", "Set", "Stream"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Sequence'lar Java Stream gibi tembel çalışır ve ara bellek tahsislerini engeller.",
                    explanationWrong = "Sequence (asSequence()) kullanılır.",
                    reviewTopic = "Kotlin Sequences"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "fold() ile reduce() arasındaki temel fark nedir?",
                    answer = "`reduce()` başlangıç değeri olarak listenin ilk elemanını alır (liste boşsa hata verir). `fold(initial)` ise açıkça bir başlangıç değeri alır ve liste boşsa bu başlangıç değerini döner."
                )
            ),
            completionCriteria = listOf(
                "Read-only ve Mutable koleksiyon farkını bilmek",
                "map, filter, sum, groupBy zincirlerini kurabilmek",
                "Sequence yapısının performans mantığını kavramak"
            )
        ),

        // ==========================================
        // DERS 5: DATA CLASSES, SEALED CLASSES & OBJECT
        // ==========================================
        Lesson(
            id = "kt_5",
            courseId = "kotlin",
            sectionId = "kt_sec_3",
            title = "Sınıflar, Data Classes, Sealed Classes & Object",
            shortDesc = "Modern OOP: Primary Constructor, init bloğu, Data Classes (otomatik equals/copy), Sealed Classes/Interfaces (Tip Güvenli UI Durumu) ve Singleton 'object'.",
            level = CourseLevel.INTERMEDIATE,
            order = 5,
            isPremium = true,
            learningObjectives = listOf(
                "Primary Constructor ve init bloğu ile sınıf yapılandırmasını öğrenmek",
                "Data Class ile otomatik copy(), equals() ve destructuring kullanmak",
                "Sealed Class/Interface ile MVI/MVVM State makinelerini tip güvenli tasarlamak"
            ),
            prerequisites = listOf("Koleksiyonlar ve Fonksiyonel Dönüşümler"),
            subtopics = listOf("Primary vs Secondary Constructor", "Data Classes & .copy()", "Sealed Classes / Interfaces", "when ile Sealed Class Exhaustiveness", "object & Companion Object"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Data Class: Otomatik Kod Üretimi",
                    body = "`data class` başına eklenen tek kelimeyle derleyici; `equals()`, `hashCode()`, `toString()`, `copy()` ve `componentN()` metotlarını arka planda otomatik üretir.",
                    codeSnippet = "data class Kullanici(val id: Long, val ad: String)\nval k1 = Kullanici(1, \"Ali\")\nval k2 = k1.copy(ad = \"Veli\") // İmmutable güncelleme"
                ),
                LessonContentBlock(
                    subtitle = "2. Sealed Classes: Modern UI State Deseni",
                    body = "Kalıtım hiyerarşisini kısıtlayan cebirsel veri tipidir. `when` içinde kullanıldığında `else` dalına gerek kalmadan tüm durumları (Loading, Success, Error) derleme seviyesinde eksiksiz yönetir.",
                    tip = "Android ve Compose projelerinde UI State modellemesi için `sealed interface UiState` endüstri standardıdır."
                )
            ),
            codeExample = "sealed interface UiState {\n    object Loading : UiState\n    data class Success(val veri: String) : UiState\n    data class Error(val mesaj: String) : UiState\n}\n\nfun renderUi(state: UiState): String = when (state) {\n    is UiState.Loading -> \"Yükleniyor... ⏳\"\n    is UiState.Success -> \"Başarılı: \" + state.veri\n    is UiState.Error -> \"Hata Oluştu: \" + state.mesaj\n}\n\nfun main() {\n    val state: UiState = UiState.Success(\"Profil Yüklendi\")\n    println(renderUi(state))\n}",
            codeExplanation = "renderUi fonksiyonunda when tüm durumları eksiksiz kapsadı, 'else' yazmaya gerek kalmadı.",
            realWorldExample = "Jetpack Compose ve Android ViewModel state yönetiminde her ekran durumu bir `sealed interface` ile modellenir.",
            practicalTask = "BankaHesabi data class'ı yazıp .copy() ile bakiyesini güncelleyin.",
            starterPlaygroundCode = "data class User(val name: String, val age: Int)\nfun main() { val u = User(\"Ali\", 25); println(u.copy(age = 26)) }",
            miniQuestion = MiniQuestion(
                id = "kt_q_5",
                question = "Kotlin'de 'data class' tanımlandığında derleyici aşağıdakilerden hangisini OTOMATİK olarak üretmez?",
                options = listOf("toString()", "copy()", "compareTo()", "equals() ve hashCode()"),
                correctIndex = 2,
                explanation = "Data class'lar toString, copy, equals, hashCode ve componentN üretir; compareTo otomatik üretilmez."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_5",
                lessonId = "kt_5",
                title = "UI Durum Formatlayıcı (Sealed Class)",
                instructions = "Success(val puan: Int) ve Failure(val sebep: String) alt sınıfları olan sealed class SonucDurumu tanımlayın. durumYazdir(durum: SonucDurumu) fonksiyonunda 'Puan: X' veya 'Hata: Y' döndürün.",
                exampleInput = "SonucDurumu.Success(95)",
                exampleOutput = "\"Puan: 95\"",
                starterCode = "sealed class SonucDurumu {\n    // Alt sınıfları yazın:\n}\nfun durumYazdir(durum: SonucDurumu): String {\n    return \"\"\n}",
                solutionCode = "sealed class SonucDurumu {\n    data class Success(val puan: Int) : SonucDurumu()\n    data class Failure(val sebep: String) : SonucDurumu()\n}\nfun durumYazdir(durum: SonucDurumu): String = when (durum) {\n    is SonucDurumu.Success -> \"Puan: \" + durum.puan\n    is SonucDurumu.Failure -> \"Hata: \" + durum.sebep\n}",
                hints = listOf("when (durum) { is SonucDurumu.Success -> ... }"),
                testCases = listOf(
                    TestCase("durumYazdir", "Puan: 95", "Sealed class testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_5_1",
                    lessonId = "kt_5",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Kotlin'de bir sınıfa ait statik (static) benzeri fabrika metotları ve sabitler tanımlamak için sınıf içine hangi blok açılır?",
                    options = listOf("static { }", "companion object { }", "singleton { }", "factory { }"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Kotlin'de Java static yerine `companion object` kullanılır.",
                    explanationWrong = "companion object kullanılır.",
                    reviewTopic = "Companion Object"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "object anahtar kelimesi ile class arasındaki fark nedir?",
                    answer = "`object` Singleton nesnesi üretir; bellekte tek bir örneği vardır ve doğrudan sınıf adıyla çağrılır. `class` ise her `new`/çağrıda yeni bir örnek üretir."
                )
            ),
            completionCriteria = listOf(
                "Data class yeteneklerini ve .copy() metodunu bilmek",
                "Sealed class ile durum yönetimini kurgulamak",
                "Companion object kullanımını öğrenmek"
            )
        ),

        // ==========================================
        // DERS 6: EXTENSIONS, SCOPE FUNCTIONS & DELEGATION
        // ==========================================
        Lesson(
            id = "kt_6",
            courseId = "kotlin",
            sectionId = "kt_sec_4",
            title = "Extension Functions, Scope Functions & Property Delegation",
            shortDesc = "Kotlin gücü: Extension Functions, Scope Functions (let, apply, run, also, with) ve Delegasyon (by lazy, Delegates.observable).",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true,
            learningObjectives = listOf(
                "Var olan sınıflara (String, Int, View) kaynak kodu değiştirmeden yeni fonksiyonlar (Extensions) eklemek",
                "5 Kapsam Fonksiyonunu (let, apply, run, also, with) doğru senaryolarda kullanmak",
                "by lazy ile ağır nesneleri sadece ilk erişimde (Thread-safe) başlatmak"
            ),
            prerequisites = listOf("Data Classes ve Sınıf Mimarisi"),
            subtopics = listOf("Extension Functions & Properties", "let (Null Check & Dönüşüm)", "apply (Nesne Yapılandırma)", "also (Yan Etki & Loglama)", "by lazy & Delegasyon"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Extension Functions: Sınıfları Genişletme",
                    body = "Miras almadan veya kaynak kodu değiştirmeden herhangi bir tipe yeni metotlar eklenebilir. Derleme zamanında statik yardımcı metoda (Utility method) dönüştürülür.",
                    codeSnippet = "fun String.ilkHarfBuyuk(): String = this.replaceFirstChar { it.uppercase() }\n\nval ad = \"deniz\".ilkHarfBuyuk() // \"Deniz\""
                ),
                LessonContentBlock(
                    subtitle = "2. Scope Functions Hızlı Seçim Rehberi",
                    body = "• `apply`: Nesneyi yapılandırıp KENDİSİNİ döndürür (`this`).\n• `let`: Null kontrolü sonrası yeni bir tip DÖNDÜRÜR (`it`).\n• `also`: Nesneyi değiştirmeden ara adımda loglamak için (`it`).\n• `run`: Bir nesne üzerinde blok çalıştırıp SONUCU döndürür (`this`).",
                    tip = "`val veritabani by lazy { AğırVeritabani() }` nesneyi ilk çağrıldığı ana kadar belleğe yüklemez."
                )
            ),
            codeExample = "data class Profil(var ad: String, var yas: Int, var aktif: Boolean = false)\n\nfun main() {\n    // apply ile nesneyi başlatalım:\n    val p = Profil(\"Murat\", 28).apply {\n        aktif = true\n    }\n    \n    // let ile null güvenli kullanalım:\n    val isimUzunluk = p.ad.let {\n        println(\"İsim işleniyor: \$it\")\n        it.length\n    }\n    \n    println(\"Uzunluk: \$isimUzunluk\")\n}",
            codeExplanation = "apply nesneyi başlatıp döndürdü, let bloğu ismin uzunluğunu hesaplayıp döndürdü.",
            realWorldExample = "Android'de View yapılandırmalarında `apply`, ViewModel bağımlılıklarında `by lazy` ve `by viewModels()` sürekli kullanılır.",
            practicalTask = "Int tipine .ciftMi(): Boolean uzantı fonksiyonu (extension) yazın.",
            starterPlaygroundCode = "fun Int.kare(): Int = this * this\nfun main() { println(5.kare()) }",
            miniQuestion = MiniQuestion(
                id = "kt_q_6",
                question = "Kotlin'de ağır bir nesnenin sadece ilk erişildiğinde başlatılmasını ve sonrasında aynı sonucun önbellekten dönmesini sağlayan delegasyon hangisidir?",
                options = listOf("by observable", "by lazy", "by eager", "by delegate"),
                correctIndex = 1,
                explanation = "'by lazy' başlatma işlemini ilk okuma anına kadar erteler (Thread-safe Lazy Initialization)."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_6",
                lessonId = "kt_6",
                title = "String Ünlem Ekleme (Extension)",
                instructions = "String tipine sonuna '!' ekleyen unlemEkle(): String extension fonksiyonunu yazın.",
                exampleInput = "\"Merhaba\".unlemEkle()",
                exampleOutput = "\"Merhaba!\"",
                starterCode = "// Extension fonksiyonunu buraya yazın:",
                solutionCode = "fun String.unlemEkle(): String = this + \"!\"",
                hints = listOf("fun String.unlemEkle(): String = this + \"!\""),
                testCases = listOf(
                    TestCase("\"Merhaba\".unlemEkle()", "Merhaba!", "Extension testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_6_1",
                    lessonId = "kt_6",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir nesnenin alanlarını (property) başlatıp yapılandırdıktan sonra YİNE O NESNENİN KENDİSİNİ döndürmek için hangi kapsam fonksiyonu (scope function) en uygundur?",
                    options = listOf("let", "apply", "run", "with"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! apply nesne üzerinde çalışır ve bağlam nesnesinin (this) kendisini döndürür.",
                    explanationWrong = "apply fonksiyonu nesnenin kendisini döndürür.",
                    reviewTopic = "Scope Functions: apply"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Extension fonksiyonlar Java'da nasıl görünür?",
                    answer = "Java'da ilk parametresi genişletilen nesne olan statik bir metot (`UtilsKt.ilkHarfBuyuk(str)`) olarak derlenir; nesnenin belleğine veya sınıf yapısına müdahale etmez."
                )
            ),
            completionCriteria = listOf(
                "Extension fonksiyonlar tanımlayabilmek",
                "let, apply ve also farklarını bilmek",
                "by lazy delegasyonunu uygulayabilmek"
            )
        ),

        // ==========================================
        // DERS 7: JENERİKLER & VARYANS (IN, OUT, REIFIED)
        // ==========================================
        Lesson(
            id = "kt_7",
            courseId = "kotlin",
            sectionId = "kt_sec_4",
            title = "Jenerikler & Varyans: in, out (Kovaryans) & reified",
            shortDesc = "Tip güvenli generic yapılar: Declaration-site variance (out / Kovaryans, in / Kontravaryans), Type Projections ve reified inline parametreleri.",
            level = CourseLevel.INTERMEDIATE,
            order = 7,
            isPremium = true,
            learningObjectives = listOf(
                "Declaration-site variance ile out (üretici) ve in (tüketici) mantığını kavramak",
                "Java'daki '? extends T' ve '? super T' karmaşasının Kotlin'deki zarif karşılığını öğrenmek",
                "Inline fonksiyonlarda 'reified' ile çalışma anında generic tip bilgisini (T::class.java) korumak"
            ),
            prerequisites = listOf("Extensions ve Kapsam Fonksiyonları"),
            subtopics = listOf("Generic Sınıflar ve Fonksiyonlar", "out (Kovaryans / Sadece Okuma)", "in (Kontravaryans / Sadece Yazma)", "Type Projections (*)", "reified Type Parameters"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Kovaryans (out) ve Kontravaryans (in)",
                    body = "• `out T`: Sınıf sadece T üretir (return eder), parametre olarak almaz. `List<out T>` sayesinde `List<String>`, `List<Any>` yerine güvenle atanabilir.\n• `in T`: Sınıf sadece T tüketir (parametre alır), return etmez.",
                    codeSnippet = "interface Uretici<out T> {\n    fun uret(): T // out: Sadece dönüş tipinde geçerli\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. reified Anahtar Kelimesi",
                    body = "Normalde JVM'de generic tipler derleme sonrası silinir (Type Erasure). Ancak `inline fun <reified T>` yazıldığında fonksiyon çağrıldığı yere gömülür ve `T::class.java` doğrudan okunabilir.",
                    tip = "JSON ayrıştırma veya Android `startActivity<DetayActivity>()` extension'larında `reified` vazgeçilmezdir."
                )
            ),
            codeExample = "inline fun <reified T> tipKontrol(deger: Any) {\n    if (deger is T) {\n        println(\"Verilen değer \" + T::class.java.simpleName + \" tipindedir.\")\n    } else {\n        println(\"Tip eşleşmedi!\")\n    }\n}\n\nfun main() {\n    tipKontrol<String>(\"Merhaba\")\n    tipKontrol<Int>(\"Merhaba\") // Tip eşleşmedi\n}",
            codeExplanation = "reified sayesinde T silinmedi ve çalışma zamanında T::class.java üzerinden kontrol edilebildi.",
            realWorldExample = "Retrofit ve Gson/Moshi kütüphaneleri `inline fun <reified T> parseJson(...)` kalıbı ile sınıf tipini çözer.",
            practicalTask = "Jenerik bir Kutu<T>(val icerik: T) sınıfı yazıp içeriğini okuyan bir metot ekleyin.",
            starterPlaygroundCode = "class Kutu<T>(val v: T)\nfun main() { println(Kutu(\"Veri\").v) }",
            miniQuestion = MiniQuestion(
                id = "kt_q_7",
                question = "Kotlin'de JVM'in Tip Silme (Type Erasure) mekanizmasını aşarak 'T::class.java' ifadesine çalışma zamanında erişebilmek için jenerik tipin başına ne yazılmalıdır?",
                options = listOf("dynamic T", "reified T (inline fonksiyon ile)", "static T", "open T"),
                correctIndex = 1,
                explanation = "'inline fun <reified T>' tipi çağrı yerine gömerek runtime tip erişimi sağlar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_7",
                lessonId = "kt_7",
                title = "Jenerik Çift Tutucu (Pair)",
                instructions = "İki farklı tipte değer tutan generic CiftTutucu<A, B>(val birinci: A, val ikinci: B) sınıfını yazın.",
                exampleInput = "CiftTutucu(1, \"Bir\").birinci",
                exampleOutput = "1",
                starterCode = "// Generic sınıfı buraya yazın:",
                solutionCode = "class CiftTutucu<A, B>(val birinci: A, val ikinci: B)",
                hints = listOf("class CiftTutucu<A, B>(val birinci: A, val ikinci: B)"),
                testCases = listOf(
                    TestCase("CiftTutucu", "1", "Generic testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_7_1",
                    lessonId = "kt_7",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir generic tip 'out T' olarak işaretlendiğinde (Kovaryans), bu tip parametresi sınıf içinde nerede KULLANILAMAZ?",
                    options = listOf("Fonksiyonların dönüş tipi olarak (return T)", "Fonksiyonların parametre tipi olarak (fun ekle(item: T))", "Salt okunur val property olarak", "Hiçbir yerde"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! 'out' sadece üretici (producer) demektir; fonksiyon parametresi (tüketici) olarak kullanılamaz.",
                    explanationWrong = "out parametre olarak (tüketici) kullanılamaz.",
                    reviewTopic = "out Variance"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Star-projection (*) nedir?",
                    answer = "Tip argümanı hakkında hiçbir bilgiye sahip olmadığınızda (`List<*>`) kullanılır; Java'daki `List<?>` wildcard karşılığıdır."
                )
            ),
            completionCriteria = listOf(
                "in ve out varyans farkını açıklayabilmek",
                "reified inline fonksiyonlar tasarlayabilmek",
                "Type Erasure kavramını ve çözümünü bilmek"
            )
        ),

        // ==========================================
        // DERS 8: ASENKRON KOTLIN: COROUTINES TEMELLERİ
        // ==========================================
        Lesson(
            id = "kt_8",
            courseId = "kotlin",
            sectionId = "kt_sec_5",
            title = "Asenkron Kotlin: Coroutines Temelleri & Structured Concurrency",
            shortDesc = "Hafif iş parçacıkları (Lightweight Threads): suspend fonksiyonlar, duraklatma (continuation), CoroutineScope, Dispatchers (IO, Main, Default) ve launch vs async.",
            level = CourseLevel.ADVANCED,
            order = 8,
            isPremium = true,
            learningObjectives = listOf(
                "suspend fonksiyonların thread bloke etmeden nasıl duraklatıldığını kavramak",
                "Dispatchers.Main, Dispatchers.IO ve Dispatchers.Default görev dağılımlarını öğrenmek",
                "launch (Ateşle ve Unut) ile async / await (Sonuç Bekle) farkını uygulamak"
            ),
            prerequisites = listOf("Jenerikler ve İleri Kotlin"),
            subtopics = listOf("Coroutine Nedir? (Thread vs Coroutine)", "suspend Fonksiyon Mimarisi", "Dispatchers (Main, IO, Default, Unconfined)", "launch vs async/await", "Structured Concurrency & Cancellation"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Coroutines Neden Devrimseldir?",
                    body = "Bir işletim sistemi Thread'i ~1MB bellek tutarken ve oluşturulması maliyetliyken, tek bir thread üzerinde yüz binlerce Coroutine aynı anda çalışabilir. Coroutine bloke etmez; duraklar (suspend) ve thread'i diğer işlere bırakır.",
                    codeSnippet = "suspend fun veriGetir(): String {\n    delay(1000) // Thread'i bloke etmez, coroutine'i duraklatır\n    return \"Veri\"\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. launch vs async",
                    body = "• `launch`: Geriye değer döndürmeyen işler için kullanılır (`Job` döner).\n• `async`: Sonuç döndüren işler için kullanılır; `Deferred<T>` döner ve `.await()` ile beklenir.",
                    tip = "Veritabanı ve Ağ işlemleri için `Dispatchers.IO`, UI güncellemeleri için `Dispatchers.Main`, ağır CPU hesaplamaları için `Dispatchers.Default` kullanın."
                )
            ),
            codeExample = "import kotlinx.coroutines.*\n\nsuspend fun agdanIndir(id: Int): String {\n    delay(100) // Ağ gecikmesi simülasyonu\n    return \"Kullanıcı #\$id\"\n}\n\nfun main() = runBlocking {\n    println(\"Başladı...\")\n    \n    // İki isteği PARALEL olarak başlatalım:\n    val gorev1 = async(Dispatchers.IO) { agdanIndir(1) }\n    val gorev2 = async(Dispatchers.IO) { agdanIndir(2) }\n    \n    val sonuc1 = gorev1.await()\n    val sonuc2 = gorev2.await()\n    \n    println(\"Sonuçlar: \$sonuc1 ve \$sonuc2\")\n}",
            codeExplanation = "async ile iki ağ isteği paralel başlatıldı ve await() ile paralel süre zarfında toplandı.",
            realWorldExample = "Android uygulamalarında internetten veri çekip UI'a basma işlemi ViewModelScope içinde Coroutines ile saniyeler içinde kodlanır.",
            practicalTask = "withContext(Dispatchers.IO) kullanarak arka planda çalışan ve sonucu döndüren bir suspend fonksiyon yazın.",
            starterPlaygroundCode = "import kotlinx.coroutines.*\nfun main() = runBlocking { launch { delay(50); println(\"Bitti\"); } }",
            miniQuestion = MiniQuestion(
                id = "kt_q_8",
                question = "Kotlin Coroutines'te arka planda bir hesaplama yapıp sonucunu '.await()' ile geri almak için hangi coroutine builder kullanılır?",
                options = listOf("launch", "async", "runBlocking", "produce"),
                correctIndex = 1,
                explanation = "async bir Deferred<T> döner ve await() çağrılarak üretilen sonuca erişilir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_8",
                lessonId = "kt_8",
                title = "Paralel İstek Birleştirici (Coroutines)",
                instructions = "İki ayrı suspend fonksiyon sonucunu async ile paralel çağırıp toplamlarını döndüren paralelTopla(f1: suspend () -> Int, f2: suspend () -> Int): Int fonksiyonunu coroutineScope ile yazın.",
                exampleInput = "f1 -> 10, f2 -> 20",
                exampleOutput = "30",
                starterCode = "import kotlinx.coroutines.*\nsuspend fun paralelTopla(f1: suspend () -> Int, f2: suspend () -> Int): Int = coroutineScope {\n    // Kodunu buraya yaz:\n    0\n}",
                solutionCode = "import kotlinx.coroutines.*\nsuspend fun paralelTopla(f1: suspend () -> Int, f2: suspend () -> Int): Int = coroutineScope {\n    val d1 = async { f1() }\n    val d2 = async { f2() }\n    d1.await() + d2.await()\n}",
                hints = listOf("val d1 = async { f1() }; val d2 = async { f2() }; d1.await() + d2.await()"),
                testCases = listOf(
                    TestCase("paralelTopla", "30", "Paralel coroutine testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_8_1",
                    lessonId = "kt_8",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Kotlin'de 'Thread.sleep(1000)' ile Coroutines 'delay(1000)' arasındaki en temel fark nedir?",
                    options = listOf("Farkları yoktur", "Thread.sleep çalıştığı işletim sistemi thread'ini tamamen dondurur ve kilitler; delay ise sadece o coroutine'i duraklatıp thread'i diğer işler için serbest bırakır", "delay daha çok bellek harcar", "Thread.sleep sadece mobilde çalışır"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! delay non-blocking (bloke etmeyen) bir suspend fonksiyondur.",
                    explanationWrong = "delay thread'i kilitlemez, sadece coroutine'i duraklatır.",
                    reviewTopic = "delay vs Thread.sleep"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Structured Concurrency nedir?",
                    answer = "Bir üst (parent) Coroutine Scope iptal edildiğinde veya hata verdiğinde altındaki tüm çalışan çocuk coroutine'lerin de otomatik ve güvenle iptal edilmesini garanti eden mimaridir (Bellek sızıntısı ve öksüz thread'leri engeller)."
                )
            ),
            completionCriteria = listOf(
                "suspend fonksiyon mantığını kavramak",
                "Dispatchers türlerini doğru seçebilmek",
                "launch ve async arasındaki farkı bilmek"
            )
        ),

        // ==========================================
        // DERS 9: REAKTİF KOTLIN: KOTLIN FLOW & OPERATÖRLER
        // ==========================================
        Lesson(
            id = "kt_9",
            courseId = "kotlin",
            sectionId = "kt_sec_5",
            title = "Reaktif Kotlin: Kotlin Flow & Asenkron Akışlar",
            shortDesc = "Soğuk akışlar (Cold Streams): flow { emit() }, collect, Ara operatörler (map, filter, transform, debounce, distinctUntilChanged) ve flowOn.",
            level = CourseLevel.ADVANCED,
            order = 9,
            isPremium = true,
            learningObjectives = listOf(
                "Flow'un Cold Stream (sadece dinlendiğinde çalışan) yapısını kavramak",
                "map, filter, debounce ve flatMapLatest operatörleri ile asenkron veri boru hatları kurmak",
                "flowOn(Dispatchers.IO) ile thread geçişlerini hatasız yönetmek"
            ),
            prerequisites = listOf("Coroutines Temelleri ve Structured Concurrency"),
            subtopics = listOf("Flow vs List vs Sequence", "flow { emit() } & collect", "Dönüşüm Operatörleri", "Zamanlama Operatörleri (debounce, sample)", "flowOn & Exception Handling (catch)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Cold Stream Mantığı",
                    body = "Flow soğuktur; yani `.collect()` çağrılana kadar içindeki kod asla çalışmaz. Her yeni dinleyici (collector) için akış baştan sıfırdan başlar.",
                    codeSnippet = "fun sayiAkisi(): Flow<Int> = flow {\n    for (i in 1..3) {\n        delay(100)\n        emit(i) // Veriyi akışa yay\n    }\n}\n// Tüketim: sayiAkisi().collect { println(it) }"
                ),
                LessonContentBlock(
                    subtitle = "2. flowOn: Emniyetli Thread Değişimi",
                    body = "Flow'un yayım yaptığı thread'i değiştirmek için `withContext` değil, doğrudan `.flowOn(Dispatchers.IO)` kullanılır.",
                    tip = "Akıştaki hataları yakalamak için try-catch yerine Flow operatörü olan `.catch { e -> emit(YedekVeri) }` tercih edilmelidir."
                )
            ),
            codeExample = "import kotlinx.coroutines.*\nimport kotlinx.coroutines.flow.*\n\nfun canliFiyatAkisi(): Flow<Double> = flow {\n    var fiyat = 100.0\n    while (true) {\n        delay(200)\n        fiyat += ((-2..2).random())\n        emit(fiyat)\n    }\n}\n\nfun main() = runBlocking {\n    canliFiyatAkisi()\n        .take(3) // Sadece ilk 3 veriyi al\n        .map { \"Fiyat: \$it TL\" }\n        .collect { println(it) }\n}",
            codeExplanation = "flow {} emit ile fiyat üretti, take(3) akışı sınırladı, map formatladı ve collect ekrana bastı.",
            realWorldExample = "Kullanıcı arama kutusuna yazı yazarken her harfte istek atmamak için `debounce(300)` ve `distinctUntilChanged` Flow operatörleri kullanılır.",
            practicalTask = "1'den 5'e kadar her 100ms'de bir sayı yayan bir Flow oluşturup toList() ile toplayın.",
            starterPlaygroundCode = "import kotlinx.coroutines.flow.*\nimport kotlinx.coroutines.*\nfun main() = runBlocking { flowOf(1, 2, 3).collect { println(it) } }",
            miniQuestion = MiniQuestion(
                id = "kt_q_9",
                question = "Kotlin Flow'da arama kutusu girdilerinde kullanıcının yazmayı bitirmesini bekleyip gereksiz ağ isteklerini önleyen zamanlama operatörü hangisidir?",
                options = listOf("delay", "debounce", "buffer", "conflate"),
                correctIndex = 1,
                explanation = "debounce(sure) belirtilen süre boyunca yeni bir eleman gelmezse son elemanı yayar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_9",
                lessonId = "kt_9",
                title = "Çift Sayı Flow Boru Hattı",
                instructions = "Flow<Int> akışı alıp içindeki çift sayıları filtreleyip 10 ile çarpan Flow<Int> döndüren ciftleriOnlaCarp(akisi: Flow<Int>): Flow<Int> fonksiyonunu yazın.",
                exampleInput = "flowOf(1, 2, 3, 4)",
                exampleOutput = "flowOf(20, 40)",
                starterCode = "import kotlinx.coroutines.flow.*\nfun ciftleriOnlaCarp(akis: Flow<Int>): Flow<Int> {\n    // Kodunu buraya yaz:\n    return akis\n}",
                solutionCode = "import kotlinx.coroutines.flow.*\nfun ciftleriOnlaCarp(akis: Flow<Int>): Flow<Int> {\n    return akis.filter { it % 2 == 0 }.map { it * 10 }\n}",
                hints = listOf("akis.filter { it % 2 == 0 }.map { it * 10 }"),
                testCases = listOf(
                    TestCase("ciftleriOnlaCarp", "Flow", "Flow operatör testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_9_1",
                    lessonId = "kt_9",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Kotlin Flow akışlarında 'flowOn(Dispatchers.IO)' operatörü nereyi etkiler?",
                    options = listOf("collect metodunun çalıştığı yeri", "flowOn çağrısından ÖNCEKİ üst akış (upstream) kodlarının çalıştığı Dispatcher'ı", "Tüm programı", "Hiçbir yeri"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! flowOn sadece kendisinden önceki emit/dönüşüm aşamalarının çalıştığı thread havuzunu değiştirir.",
                    explanationWrong = "flowOn kendisinden önceki üst akışı etkiler.",
                    reviewTopic = "flowOn Upstream"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Flow neden RxJava'ya göre daha avantajlıdır?",
                    answer = "Kotlin Coroutines ile doğrudan yerel entegredir; ek bağımlılık ve karmaşık operatör yığını gerektirmez, 'suspend' fonksiyonları doğrudan destekler."
                )
            ),
            completionCriteria = listOf(
                "Cold Flow mantığını kavramak",
                "Flow dönüştürme ve zamanlama operatörlerini kullanabilmek",
                "flowOn ve catch ile hata/thread yönetimini kurabilmek"
            )
        ),

        // ==========================================
        // DERS 10: STATEFLOW & SHAREDFLOW (HOT STREAMS)
        // ==========================================
        Lesson(
            id = "kt_10",
            courseId = "kotlin",
            sectionId = "kt_sec_5",
            title = "Hot Streams: StateFlow & SharedFlow (MVI/MVVM)",
            shortDesc = "Canlı durum akışları (Hot Streams): StateFlow (Son durum tutan, UI State), SharedFlow (Olaylar, Snackbar, Navigasyon) ve collectAsStateWithLifecycle.",
            level = CourseLevel.ADVANCED,
            order = 10,
            isPremium = true,
            learningObjectives = listOf(
                "Cold Flow ile Hot Stream (StateFlow/SharedFlow) farkını kavramak",
                "MutableStateFlow ve asStateFlow() ile kapsüllenmiş (encapsulated) UI State tasarlamak",
                "SharedFlow ile tek seferlik olayları (One-off Events: Dialog, Navigate) yönetmek"
            ),
            prerequisites = listOf("Kotlin Flow ve Operatörler"),
            subtopics = listOf("Cold Stream vs Hot Stream", "StateFlow Mimarisi (value & replay=1)", "SharedFlow (Event Bus)", "asStateFlow() Kapsülleme Deseni", "Compose: collectAsStateWithLifecycle"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. StateFlow vs SharedFlow",
                    body = "• `StateFlow`: DAİMA bir başlangıç değeri vardır ve son durumu hafızada tutar (`.value`). UI'ın mevcut durumunu göstermek için idealdir.\n• `SharedFlow`: Başlangıç değeri yoktur; olayları dinleyicilere fırlatır (Toast, Sayfa Geçişi vb.).",
                    codeSnippet = "private val _uiState = MutableStateFlow<UiState>(UiState.Loading)\nval uiState: StateFlow<UiState> = _uiState.asStateFlow()\n\nfun guncelle(yeniVeri: String) {\n    _uiState.value = UiState.Success(yeniVeri)\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Lifecycle Güvenli Dinleme",
                    body = "Android Jetpack Compose'da `collectAsStateWithLifecycle()` uygulaması arka plana gittiğinde akışı durdurarak gereksiz CPU ve pil tüketimini önler.",
                    tip = "StateFlow değerini güncellerken race condition'ları önlemek için `_state.update { it.copy(...) }` atomik metodunu kullanın."
                )
            ),
            codeExample = "import kotlinx.coroutines.*\nimport kotlinx.coroutines.flow.*\n\nclass SayacViewModel {\n    private val _sayac = MutableStateFlow(0)\n    val sayac: StateFlow<Int> = _sayac.asStateFlow()\n    \n    fun artir() {\n        _sayac.update { it + 1 }\n    }\n}\n\nfun main() = runBlocking {\n    val vm = SayacViewModel()\n    \n    val job = launch {\n        vm.sayac.collect { println(\"UI Güncellendi: \$it\") }\n    }\n    \n    vm.artir()\n    vm.artir()\n    delay(50)\n    job.cancel()\n}",
            codeExplanation = "MutableStateFlow güncellendikçe collect anında tetiklendi; _sayac private tutularak dışarıdan bozulması engellendi.",
            realWorldExample = "Modern Android mimarisinde ViewModel ile Jetpack Compose arayüzü arasındaki tüm veri bağı StateFlow üzerinden kurulur.",
            practicalTask = "Bir SharedFlow oluşturup arka arkaya 2 event fırlatan bir kod yazın.",
            starterPlaygroundCode = "import kotlinx.coroutines.flow.*\nval s = MutableStateFlow(0); s.value = 1; println(s.value);",
            miniQuestion = MiniQuestion(
                id = "kt_q_10",
                question = "StateFlow'un Flow'dan en temel farkı nedir?",
                options = listOf("StateFlow senkron çalışır", "StateFlow bir Hot Stream'dir; daima son bir değere (.value) sahiptir ve dinleyici olmasa da hafızada yaşar", "StateFlow sadece String tutar", "StateFlow derlenmez"),
                correctIndex = 1,
                explanation = "StateFlow hot stream'dir ve her zaman geçerli son durumunu saklar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_10",
                lessonId = "kt_10",
                title = "StateFlow Sayaç Yöneticisi",
                instructions = "MutableStateFlow(0) tutan ve degeriArtir() metodu ile değeri 1 artıran SayacTutucu sınıfını yazın.",
                exampleInput = "SayacTutucu().degeriArtir()",
                exampleOutput = "state.value == 1",
                starterCode = "import kotlinx.coroutines.flow.*\nclass SayacTutucu {\n    // Kodunu buraya yaz:\n}",
                solutionCode = "import kotlinx.coroutines.flow.*\nclass SayacTutucu {\n    val state = MutableStateFlow(0)\n    fun degeriArtir() {\n        state.update { it + 1 }\n    }\n}",
                hints = listOf("state.update { it + 1 } kullanın."),
                testCases = listOf(
                    TestCase("SayacTutucu", "StateFlow", "StateFlow testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_10_1",
                    lessonId = "kt_10",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "StateFlow değişkenlerini dış sınıflara açarken neden 'val state = _state.asStateFlow()' kalıbı kullanılır?",
                    options = listOf("Daha hızlı çalışması için", "Dış sınıfların '_state.value = ...' şeklinde veriyi dışarıdan doğrudan değiştirmesini engelleyip (Encapsulation) salt okunur StateFlow sunmak için", "Zorunlu bir Kotlin kuralı olduğu için", "Belleği temizlemek için"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Kapsülleme (Encapsulation) prensibi gereği durum sadece ViewModel içinden güncellenebilmelidir.",
                    explanationWrong = "Kapsülleme sağlayıp dışarıdan müdahaleyi engellemek için kullanılır.",
                    reviewTopic = "StateFlow Encapsulation"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "SharedFlow replay parametresi ne işe yarar?",
                    answer = "Yeni bir dinleyici abone olduğunda, geçmişte fırlatılmış son kaç olayı önbellekten ona yeniden göndereceğini (replay) belirler."
                )
            ),
            completionCriteria = listOf(
                "Cold Flow ve Hot Stream ayrımını bilmek",
                "StateFlow ile UI State modellemesi yapabilmek",
                "asStateFlow kapsülleme kalıbını uygulamak"
            )
        ),

        // ==========================================
        // DERS 11: CHANNELS & SUPERVISORJOB (HATA İZOLASYONU)
        // ==========================================
        Lesson(
            id = "kt_11",
            courseId = "kotlin",
            sectionId = "kt_sec_6",
            title = "Channels & SupervisorJob: İleri Coroutines & Hata İzolasyonu",
            shortDesc = "Coroutines arası boru hatları (Channels: Channel.BUFFERED, actor), Hata yayılımı: Standart Job vs SupervisorJob (ve supervisorScope) farkı.",
            level = CourseLevel.EXPERT,
            order = 11,
            isPremium = true,
            learningObjectives = listOf(
                "Channels (SendChannel / ReceiveChannel) ile coroutines arası FIFO mesajlaşması kurmak",
                "Standart Job ile SupervisorJob arasındaki hata yayılım (Failure Propagation) farkını anlamak",
                "Bir alt coroutine çöktüğünde tüm ekranın çökmesini SupervisorJob ile engellemek"
            ),
            prerequisites = listOf("StateFlow ve Hot Streams"),
            subtopics = listOf("Channels vs Flow", "Channel Kapasiteleri (RENDEZVOUS, BUFFERED, CONFLATED)", "CoroutineExceptionHandler", "Job vs SupervisorJob Hata Yayılımı", "supervisorScope ile Hata İzolasyonu"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Job vs SupervisorJob: Kritik Fark",
                    body = "• Standart `Job`: Bir çocuk coroutine hata ile çökerse, ebeveynini ve AYNI SEVİYEDEKİ TÜM KARDEŞLERİNİ de anında iptal eder.\n• `SupervisorJob`: Bir çocuk çökse bile hata yukarı yayılmaz; kardeş coroutine'ler güvenle çalışmaya devam eder.",
                    codeSnippet = "val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)\n// scope içindeki 1. görev çökse bile 2. görev çalışmaya devam eder!"
                ),
                LessonContentBlock(
                    subtitle = "2. Channels: Sıra Tabanlı İletişim",
                    body = "Flow veri akışını yayıp dinletirken, `Channel` veriyi tek bir alıcıya aktaran (Queue) boru hattıdır.",
                    tip = "Bağımsız paralel indirme işlemlerinde tek bir indirme hatası aldığında diğerlerinin iptal olmaması için daima `supervisorScope` kullanın."
                )
            ),
            codeExample = "import kotlinx.coroutines.*\n\nfun main() = runBlocking {\n    // supervisorScope ile hata izolasyonu sağlayalım:\n    supervisorScope {\n        val basariliGorev = launch {\n            delay(100)\n            println(\"1. Görev Başarıyla Tamamlandı! ✅\")\n        }\n        \n        val hataliGorev = launch {\n            delay(50)\n            throw RuntimeException(\"2. Görevde Beklenmeyen Hata! ❌\")\n        }\n    }\n    \n    println(\"Ana Akış Çökmeden Devam Etti! 🛡️\")\n}",
            codeExplanation = "supervisorScope kullanıldığı için 2. görevdeki çökme 1. görevi iptal etmedi ve ana akış devam etti.",
            realWorldExample = "Android ViewModel'de `viewModelScope` arkada bir `SupervisorJob()` kullanır; böylece bir API hatası tüm ekranı çökertmez.",
            practicalTask = "Channel kullanarak 3 mesaj gönderip alıcı tarafında bunları okuyan bir kod yazın.",
            starterPlaygroundCode = "import kotlinx.coroutines.channels.*\nimport kotlinx.coroutines.*\nfun main() = runBlocking { val c = Channel<Int>(); launch { c.send(1); }; println(c.receive()); }",
            miniQuestion = MiniQuestion(
                id = "kt_q_11",
                question = "Birden fazla çocuk coroutine çalışırken bir tanesinde oluşan hatanın diğer kardeş coroutine'leri iptal ETMEMESİ için hangi Job türü kullanılmalıdır?",
                options = listOf("Job()", "SupervisorJob()", "CompletableJob()", "DeferredJob()"),
                correctIndex = 1,
                explanation = "SupervisorJob çocukların hatalarını yukarıya yaymaz; arıza izolasyonu sağlar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_11",
                lessonId = "kt_11",
                title = "Channel ile Mesaj İletimi",
                instructions = "Kapasitesi 5 olan bir Channel<String> oluşturup 'Selam' gönderen ve receive() ile alıp döndüren kanalMesaji(): String fonksiyonunu yazın.",
                exampleInput = "kanalMesaji()",
                exampleOutput = "\"Selam\"",
                starterCode = "import kotlinx.coroutines.channels.*\nimport kotlinx.coroutines.*\nsuspend fun kanalMesaji(): String {\n    // Kodunu buraya yaz:\n    return \"\"\n}",
                solutionCode = "import kotlinx.coroutines.channels.*\nimport kotlinx.coroutines.*\nsuspend fun kanalMesaji(): String {\n    val kanal = Channel<String>(5)\n    kanal.send(\"Selam\")\n    return kanal.receive()\n}",
                hints = listOf("val kanal = Channel<String>(5); kanal.send(\"Selam\"); return kanal.receive()"),
                testCases = listOf(
                    TestCase("kanalMesaji", "Selam", "Channel testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_11_1",
                    lessonId = "kt_11",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Standart bir CoroutineScope içinde 'launch' ile başlatılan bir coroutine işlenmeyen bir Exception fırlattığında ne gerçekleşir?",
                    options = listOf("Sadece o coroutine sessizce durur", "Hata yukarıya yayılır, parent Job iptal olur ve o Scope altındaki tüm kardeş coroutine'ler de anında iptal edilir", "Program askıda kalır", "Hata görmezden gelinir"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Standart Job yapısında Structured Concurrency gereği bir hata tüm ağacı iptal eder.",
                    explanationWrong = "Standart Job'da hata tüm kardeş coroutine'leri iptal eder.",
                    reviewTopic = "Job Exception Propagation"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Channel ile SharedFlow arasındaki en temel fark nedir?",
                    answer = "`Channel` bir kuyruktur; gönderilen her mesajı yalnızca TEK BİR alıcı tüketir (Point-to-Point). `SharedFlow` ise yayıncıdır; gönderilen mesajı TÜM aboneler aynı anda alır (Broadcast)."
                )
            ),
            completionCriteria = listOf(
                "Job ile SupervisorJob farkını bilmek",
                "supervisorScope ile arıza izolasyonu yapmak",
                "Channel ile coroutine'ler arası veri aktarmak"
            )
        ),

        // ==========================================
        // DERS 12: INLINE BYTECODE & KSP DERLEYİCİ EKLENTİLERİ
        // ==========================================
        Lesson(
            id = "kt_12",
            courseId = "kotlin",
            sectionId = "kt_sec_6",
            title = "İleri Düzey: Inline Fonksiyonlar (noinline, crossinline) & KSP",
            shortDesc = "JVM & Derleyici derinlikleri: inline fonksiyonların Bytecode analizi, noinline, crossinline, Non-local returns ve Kotlin Symbol Processing (KSP) meta-programlama.",
            level = CourseLevel.EXPERT,
            order = 12,
            isPremium = true,
            learningObjectives = listOf(
                "inline anahtar kelimesinin lambda nesnesi tahsisini (Allocation) nasıl sıfırladığını Bytecode seviyesinde görmek",
                "noinline ve crossinline anahtar kelimelerinin kullanım sınırlarını kavramak",
                "KSP (Kotlin Symbol Processing) ile Room/Dagger benzeri derleme zamanı kod üretimi mimarisini öğrenmek"
            ),
            prerequisites = listOf("Channels, SupervisorJob ve İleri Kotlin"),
            subtopics = listOf("inline & Bytecode Inlining", "Non-local returns", "noinline & crossinline Farkı", "KAPT vs KSP (Kotlin Symbol Processing)", "Derleme Zamanı Kod Üretimi (Code Generation)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. inline ve Bytecode Optimizasyonu",
                    body = "Normal lambdalar JVM'de `Function0` nesnesi olarak bellekte tahsis edilir (Allocation overhead). Bir fonksiyon `inline` yapıldığında derleyici fonksiyonun ve lambdanın gövdesini çağrıldığı yere doğrudan kopyalar; sıfır nesne üretilir.",
                    codeSnippet = "inline fun olc(blok: () -> Unit) {\n    val t = System.currentTimeMillis()\n    blok()\n    println(\"Süre: \" + (System.currentTimeMillis() - t))\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. crossinline ve noinline",
                    body = "• `noinline`: inline fonksiyon içindeki belirli bir lambdanın inline edilmeyip nesne olarak kalmasını sağlar.\n• `crossinline`: Lambdanın başka bir thread/kapsam içinden çağrıldığını ve 'non-local return' yapamayacağını garanti eder.",
                    tip = "KSP, Java annotation processor'larına (kapt) göre Kotlin kodlarını 2 kat daha hızlı analiz eder."
                )
            ),
            codeExample = "inline fun calistir(crossinline islem: () -> Unit, noinline loglayici: (String) -> Unit) {\n    val th = Thread {\n        islem() // crossinline sayesinde güvenle başka thread'e geçirildi\n    }\n    th.start()\n    loglayici(\"Thread başlatıldı\")\n}\n\nfun main() {\n    calistir(\n        islem = { println(\"Arka planda çalışıyor\") },\n        loglayici = { println(\"LOG: \$it\") }\n    )\n}",
            codeExplanation = "islem crossinline ile thread içine aktarıldı, loglayici noinline ile nesne olarak tutuldu.",
            realWorldExample = "Jetpack Compose derleyicisi ve Room veritabanı kütüphanesi tüm sorgu ve arayüz kodlarını KSP eklentileri ile derleme anında üretir.",
            practicalTask = "Bir inline fonksiyon yazıp içine basit bir işlem bloğu geçirin.",
            starterPlaygroundCode = "inline fun tekrarEt(n: Int, action: (Int) -> Unit) { for (i in 0 until n) action(i) }\nfun main() { tekrarEt(3) { println(it) } }",
            miniQuestion = MiniQuestion(
                id = "kt_q_12",
                question = "Kotlin'de Room ve Hilt gibi kütüphanelerin derleme zamanında hızlı kod üretmesini sağlayan modern Kotlin derleyici API'sinin adı nedir?",
                options = listOf("KAPT", "KSP (Kotlin Symbol Processing)", "JVM Bytecode", "Reflection"),
                correctIndex = 1,
                explanation = "KSP (Kotlin Symbol Processing) doğrudan Kotlin AST ağacını işleyerek yüksek hızda kod üretir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_kt_12",
                lessonId = "kt_12",
                title = "Inline Çalıştırma Sayacı",
                instructions = "Bir 'islem: () -> Unit' lambdası alan ve bunu 2 kez çalıştıran inline fun ikiKezCalistir(islem: () -> Unit) fonksiyonunu yazın.",
                exampleInput = "ikiKezCalistir { println(\"A\") }",
                exampleOutput = "A A",
                starterCode = "// inline fonksiyonu buraya yazın:",
                solutionCode = "inline fun ikiKezCalistir(islem: () -> Unit) {\n    islem()\n    islem()\n}",
                hints = listOf("inline fun ikiKezCalistir(islem: () -> Unit) { islem(); islem(); }"),
                testCases = listOf(
                    TestCase("ikiKezCalistir", "A A", "inline testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_quiz_12_1",
                    lessonId = "kt_12",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir inline fonksiyonun parametresi olan lambdanın içinden 'return' yazıldığında dıştaki çağıran fonksiyonun da sonlanması özelliğine ne ad verilir?",
                    options = listOf("Non-local return", "Cross-return", "Local return", "Early return"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! inline fonksiyonlar kodun içine gömüldüğü için lambda içindeki return doğrudan çevreleyen fonksiyonu sonlandırır (Non-local return).",
                    explanationWrong = "Non-local return denir.",
                    reviewTopic = "Non-local returns"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Her fonksiyonu inline yapmak doğru mudur?",
                    answer = "Hayır! Çok büyük gövdeye sahip fonksiyonları inline yapmak derlenen Bytecode boyutunu şişirir (Code bloat). Yalnızca lambda parametresi alan küçük yardımcı fonksiyonlar inline yapılmalıdır."
                )
            ),
            completionCriteria = listOf(
                "inline, noinline ve crossinline farkını bilmek",
                "Non-local return mantığını kavramak",
                "KSP mimarisinin rolünü açıklayabilmek"
            )
        )
    )
}
