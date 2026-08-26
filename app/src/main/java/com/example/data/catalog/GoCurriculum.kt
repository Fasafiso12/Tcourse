package com.example.data.catalog

import com.example.model.*

/**
 * Go (Golang) Kolay & Anlaşılır Müfredatı (12 Adım):
 * Google tarafından geliştirilen, bulut dünyasının (Docker, Kubernetes) ve yüksek hızlı mikroservislerin dili Go'yu öğrenin!
 */
object GoCurriculum {

    fun getSections(): List<CourseSection> = listOf(
        CourseSection(
            id = "go_sec_1",
            courseId = "go",
            title = "Bölüm 1: Go Temelleri ve := Operatörü",
            level = CourseLevel.BEGINNER,
            order = 1,
            description = "fmt.Println, pratik değişken tanımlama (:=), if-else ve Go'nun tek döngüsü: for.",
            learningObjectives = listOf("fmt paketiyle ekrana yazdırmak", ":= ile hızlı değişken tanımlamak", "for döngüsü kurmak"),
            prerequisites = listOf("Ön koşul gerekmez! Sıfırdan başlar.")
        ),
        CourseSection(
            id = "go_sec_2",
            courseId = "go",
            title = "Bölüm 2: Fonksiyonlar, Slice'lar ve Map'ler",
            level = CourseLevel.BEGINNER,
            order = 2,
            description = "Çoklu değer döndüren fonksiyonlar, otomatik büyüyen Slice listeleri (append) ve Map sözlükleri.",
            learningObjectives = listOf("Birden fazla sonuç döndüren fonksiyon yazmak", "Slice ve append() ile liste yönetmek", "Map ile anahtar-değer saklamak"),
            prerequisites = listOf("Go Temelleri")
        ),
        CourseSection(
            id = "go_sec_3",
            courseId = "go",
            title = "Bölüm 3: Struct'lar, Pointer'lar ve Metodlar",
            level = CourseLevel.INTERMEDIATE,
            order = 3,
            description = "Kendi veri tiplerini kurma (struct), bellek işaretçileri (& ve *) ve Receiver metodları.",
            learningObjectives = listOf("struct tanımlamak", "Pointer (& ve *) mantığını kavramak", "Struct'a özel metot yazmak"),
            prerequisites = listOf("Slice'lar ve Fonksiyonlar")
        ),
        CourseSection(
            id = "go_sec_4",
            courseId = "go",
            title = "Bölüm 4: Arayüzler (Interfaces) ve Hata Yönetimi",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            description = "Go'nun ünlü 'if err != nil' hata kontrolü, otomatik temizlik yapan defer ve Interfaces.",
            learningObjectives = listOf("if err != nil ile güvenli hata kontrolü yapmak", "defer ile dosya/bağlantı kapatmak", "Interface mantığını anlamak"),
            prerequisites = listOf("Struct'lar ve Metodlar")
        ),
        CourseSection(
            id = "go_sec_5",
            courseId = "go",
            title = "Bölüm 5: Eşzamanlılık: Goroutines ve Kanallar",
            level = CourseLevel.ADVANCED,
            order = 5,
            description = "Aynı anda 100.000 görevi çalıştırmayı sağlayan 'go' anahtarı ve haberleşme kanalları (chan).",
            learningObjectives = listOf("go func() ile arka plan görevi başlatmak", "Kanallar (Channels) ile veri alıp göndermek"),
            prerequisites = listOf("Hata Yönetimi ve Struct'lar")
        ),
        CourseSection(
            id = "go_sec_6",
            courseId = "go",
            title = "Bölüm 6: Bulut Dünyası ve Go Ustalığı",
            level = CourseLevel.EXPERT,
            order = 6,
            description = "Docker, Kubernetes, REST API sunucuları ve profesyonel Go ipuçları.",
            learningObjectives = listOf("Go'nun bulut altyapılarındaki gücünü kavramak", "Hızlı HTTP web servisleri yazmak"),
            prerequisites = listOf("Tüm Seviyeler")
        )
    )

    fun getLessons(): List<Lesson> = listOf(
        // ==========================================
        // DERS 1: FMT VE := OPERATÖRÜ
        // ==========================================
        Lesson(
            id = "go_1",
            courseId = "go",
            sectionId = "go_sec_1",
            title = "Go Diline Giriş: package main, fmt ve := Operatörü",
            shortDesc = "Google tarafından tasarlanan süper hızlı bulut dili! fmt.Println ve := ile pratik değişkenler.",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false,
            learningObjectives = listOf(
                "package main ve main() fonksiyonunun görevini anlamak",
                "fmt.Println ile ekrana yazdırmak",
                ":= operatörü ile tip belirtmeden şimşek hızında değişken tanımlamak"
            ),
            prerequisites = listOf("Ön koşul gerekmez."),
            subtopics = listOf("Go Neden Çok Seviliyor?", "package main ve import fmt", ":= Kısa Tanımlama", "Temel Tipler"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Google'ın Sade ve Güçlü Dili: Go",
                    body = "Go dili karmaşadan uzaktır; gereksiz hiçbir kural barındırmaz. Docker, Kubernetes, Netflix ve Uber gibi dev sistemler Go ile çalışır.\n\nHer Go programı `package main` ve `func main()` ile başlar."
                ),
                LessonContentBlock(
                    subtitle = "2. := ile Hızlı Değişken Tanımlama",
                    body = "`var isim string = \"Ahmet\"` yazmak yerine Go'nun sihirli `:=` operatörünü kullanırız. Go tipini otomatik anlar!",
                    codeSnippet = "package main\n\nimport \"fmt\"\n\nfunc main() {\n    isim := \"Zeynep\" // := otomatik string anlar\n    yas := 22       // otomatik int anlar\n    \n    fmt.Println(\"Merhaba\", isim, \"Yaş:\", yas)\n}"
                )
            ),
            codeExample = "puan := 100\nfmt.Println(\"Skor:\", puan)",
            codeExplanation = ":= ile değişken tanımlandı ve fmt.Println ile ekrana basıldı.",
            realWorldExample = "Docker ve Kubernetes gibi bulut teknolojilerinin tamamı Go ile yazılmıştır.",
            practicalTask = "Adınızı ve yaşınızı fmt.Println ile ekrana yazdıran bir Go programı yazın.",
            starterPlaygroundCode = "package main\nimport \"fmt\"\nfunc main() {\n    ad := \"Can\"\n    fmt.Println(\"Selam\", ad)\n}",
            miniQuestion = MiniQuestion(
                id = "go_q_1",
                question = "Go dilinde bir fonksiyonda değişkenin tipini yazmadan otomatik tanımlamak için hangi operatör kullanılır?",
                options = listOf(":=", "=", "==", "var"),
                correctIndex = 0,
                explanation = "Kısa değişken tanımlama için ':=' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_go_1",
                lessonId = "go_1",
                title = "İki Sayıyı Topla",
                instructions = "İki tam sayıyı toplayıp sonucunu döndüren topla(a, b int) int fonksiyonunu yazın.",
                exampleInput = "topla(10, 20)",
                exampleOutput = "30",
                starterCode = "func topla(a int, b int) int {\n    // Kodunu yaz:\n    return 0\n}",
                solutionCode = "func topla(a int, b int) int {\n    return a + b\n}",
                hints = listOf("return a + b yazın."),
                testCases = listOf(
                    TestCase("topla(10, 20)", "30", "Toplam testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "go_quiz_1_1",
                    lessonId = "go_1",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Go'da yazılan bir değişkene değer atanıp programda hiç kullanılmazsa Go derleyicisi ne yapar?",
                    options = listOf("Derleme anında hata verir (Unused variable hatası)", "Uyarı verip geçer", "Değişkeni siler", "Çalıştırır"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Go temiz kod için kullanılmayan değişkenleri ve import'ları hata sayar.",
                    explanationWrong = "Derleme hatası verir.",
                    reviewTopic = "Go Derleme Kuralları"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Go'da satır sonuna noktalı virgül (;) konur mu?",
                    answer = "Hayır! Go derleyicisi satır sonlarına görünmez noktalı virgülleri kendisi otomatik ekler."
                )
            ),
            completionCriteria = listOf(
                "package main ve main() mantığını bilmek",
                ":= ve fmt.Println kullanımını kavramak"
            )
        ),

        // ==========================================
        // DERS 2: KOŞULLAR VE FOR DÖNGÜSÜ
        // ==========================================
        Lesson(
            id = "go_2",
            courseId = "go",
            sectionId = "go_sec_1",
            title = "Kararlar ve Tek Döngü: if, switch ve for",
            shortDesc = "Go'da while yoktur; her işi gören tek bir süper 'for' döngüsü ve parantezsiz if blokları vardır.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false,
            learningObjectives = listOf(
                "Parantezsiz if-else blokları kurmak",
                "Go'daki tek döngü olan for'un (klasik, while ve sonsuz) tüm hallerini öğrenmek",
                "Otomatik 'break' içeren modern switch ifadesini kullanmak"
            ),
            prerequisites = listOf("Go Değişkenleri ve := "),
            subtopics = listOf("if / else", "Tek Döngü: for", "Modern switch"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Sadeliğin Zirvesi: while Yok, Sadece for Var!",
                    body = "Go dili öğrenmeyi kolaylaştırmak için gereksiz döngü çeşitlerini kaldırmıştır. Sadece `for` vardır:\n\n• Klasik for: `for i := 0; i < 5; i++`\n• While gibi: `for can > 0`\n• Sonsuz döngü: `for { ... }`"
                ),
                LessonContentBlock(
                    subtitle = "2. Parantezsiz if",
                    body = "Koşulun etrafına parantez `( )` konmaz ama süslü parantez `{ }` zorunludur.",
                    codeSnippet = "puan := 85\n\nif puan >= 90 {\n    fmt.Println(\"Pekiyi\")\n} else if puan >= 70 {\n    fmt.Println(\"İyi\")\n} else {\n    fmt.Println(\"Kaldı\")\n}"
                )
            ),
            codeExample = "toplam := 0\nfor i := 1; i <= 5; i++ {\n    toplam += i\n}\nfmt.Println(\"Toplam:\", toplam) // 15",
            codeExplanation = "for döngüsüyle 1-5 arası sayılar toplandı.",
            realWorldExample = "Sunucuya gelen istekleri dinleyen döngüler 'for { ... }' şeklinde yazılır.",
            practicalTask = "1'den 10'a kadar olan çift sayıları yazdıran bir for döngüsü kurun.",
            starterPlaygroundCode = "for i := 2; i <= 10; i += 2 { fmt.Println(i) }",
            miniQuestion = MiniQuestion(
                id = "go_q_2",
                question = "Go programlama dilinde kaç farklı döngü anahtar kelimesi (keyword) vardır?",
                options = listOf("Sadece 1 tane (for)", "3 tane (for, while, do)", "2 tane (for, while)", "4 tane"),
                correctIndex = 0,
                explanation = "Go'da döngü olarak sadece 'for' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_go_2",
                lessonId = "go_2",
                title = "Pozitif Sayı Kontrolü",
                instructions = "sayi > 0 ise 'Pozitif', sayi < 0 ise 'Negatif', değilse 'Sıfır' döndüren durum(sayi int) string fonksiyonunu yazın.",
                exampleInput = "durum(5)",
                exampleOutput = "\"Pozitif\"",
                starterCode = "func durum(sayi int) string {\n    // Kodunu yaz:\n    return \"\"\n}",
                solutionCode = "func durum(sayi int) string {\n    if sayi > 0 {\n        return \"Pozitif\"\n    } else if sayi < 0 {\n        return \"Negatif\"\n    }\n    return \"Sıfır\"\n}",
                hints = listOf("if sayi > 0 { return \"Pozitif\" } else if sayi < 0 { return \"Negatif\" } return \"Sıfır\" yazın."),
                testCases = listOf(
                    TestCase("durum(5)", "Pozitif", "Pozitif sayı"),
                    TestCase("durum(-3)", "Negatif", "Negatif sayı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "go_quiz_2_1",
                    lessonId = "go_2",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Go'da switch-case bloklarında diğer dillerdeki gibi her case'in sonuna 'break' yazmak gerekir mi?",
                    options = listOf("Hayır, Go'da case eşleştiğinde otomatik olarak durur (break yazmaya gerek yoktur)", "Evet, zorunludur", "Sadece sayılarda gerekir", "Hata verir"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Go'da switch otomatik break yapar; alta geçmek için açıkça 'fallthrough' yazılır.",
                    explanationWrong = "Go'da otomatik break vardır.",
                    reviewTopic = "Go Switch"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "if içinde kısa değişken tanımlanabilir mi?",
                    answer = "Evet! 'if x := hesapla(); x > 10 { ... }' şeklinde if bloğuna özel yerel değişken açılabilir."
                )
            ),
            completionCriteria = listOf(
                "Parantezsiz if yazabilmek",
                "for döngüsünün 3 farklı halini kavramak"
            )
        ),

        // ==========================================
        // DERS 3: FONKSİYONLAR VE ÇOKLU DÖNÜŞ
        // ==========================================
        Lesson(
            id = "go_3",
            courseId = "go",
            sectionId = "go_sec_2",
            title = "Fonksiyonlar ve Çoklu Dönüş Değerleri",
            shortDesc = "Go fonksiyonlarının en büyük gücü: (sonuc, err) şeklinde iki değeri aynı anda döndürmek.",
            level = CourseLevel.BEGINNER,
            order = 3,
            isPremium = false,
            learningObjectives = listOf(
                "func adi(parametre tipi) donusTipi yapısını kurmak",
                "Geriye birden fazla değer (örn: sonuc, hata) döndürmek",
                "_ (Blank Identifier) ile istenmeyen dönüşleri göz ardı etmek"
            ),
            prerequisites = listOf("Go Temelleri ve Kontrol Akışı"),
            subtopics = listOf("Fonksiyon Tanımlama", "Çoklu Dönüş Değeri", "_ (Joker / Blank)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Hem Sonucu Hem Hatayı Döndürmek",
                    body = "Go'da fonksiyonlar parantez içinde birden fazla dönüş tipi belirtebilir: `(int, error)`.",
                    codeSnippet = "func bol(a, b int) (int, string) {\n    if b == 0 {\n        return 0, \"Sıfıra bölünemez!\"\n    }\n    return a / b, \"Başarılı\"\n}\n\nfunc main() {\n    sonuc, mesaj := bol(10, 2)\n    fmt.Println(\"Sonuç:\", sonuc, \"Mesaj:\", mesaj)\n}"
                )
            ),
            codeExample = "func minMax(a, b int) (int, int) {\n    if a < b { return a, b }\n    return b, a\n}",
            codeExplanation = "minMax tek çağrıda hem küçüğü hem büyüğü döndürdü.",
            realWorldExample = "Go'da dosya açma veya internetten veri okuma fonksiyonları daima (veri, err) ikilisi döndürür.",
            practicalTask = "İki sayının hem toplamını hem farkını döndüren bir fonksiyon yazın.",
            starterPlaygroundCode = "func toplaFark(a, b int) (int, int) { return a+b, a-b }",
            miniQuestion = MiniQuestion(
                id = "go_q_3",
                question = "Go'da bir fonksiyonun döndürdüğü 2 değerden birini kullanmak istemiyorsanız yerine hangi karakteri koyarsınız?",
                options = listOf("_ (Alt Çizgi / Blank Identifier)", "nil", "ignore", "pass"),
                correctIndex = 0,
                explanation = "İstenmeyen değerler '_' (blank identifier) ile yoksayılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_go_3",
                lessonId = "go_3",
                title = "Kare ve Küp",
                instructions = "Verilen x sayısının karesini ve küpünü aynı anda döndüren kareKup(x int) (int, int) fonksiyonunu yazın.",
                exampleInput = "kareKup(3)",
                exampleOutput = "9, 27",
                starterCode = "func kareKup(x int) (int, int) {\n    // Kodunu yaz:\n    return 0, 0\n}",
                solutionCode = "func kareKup(x int) (int, int) {\n    return x * x, x * x * x\n}",
                hints = listOf("return x * x, x * x * x yazın."),
                testCases = listOf(
                    TestCase("kareKup(3)", "9, 27", "3 için kare ve küp")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "go_quiz_3_1",
                    lessonId = "go_3",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Go'da bir fonksiyon aynı tipte birden çok parametre alıyorsa (örn: a int, b int) nasıl kısaltılabilir?",
                    options = listOf("func topla(a, b int)", "func topla(a & b int)", "func topla(int a, b)", "func topla(a..b int)"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! 'a, b int' şeklinde tip ortak paranteze alınabilir.",
                    explanationWrong = "a, b int şeklinde yazılabilir.",
                    reviewTopic = "Go Fonksiyonlar"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "İsimlendirilmiş dönüş değeri (Named Return) nedir?",
                    answer = "func hesapla() (sonuc int) şeklinde dönüş değişkenine isim verip fonksiyon sonunda sadece 'return' yazmaktır."
                )
            ),
            completionCriteria = listOf(
                "Çoklu dönüş değerli fonksiyon yazabilmek",
                "_ joker karakterini kullanabilmek"
            )
        ),

        // ==========================================
        // DERS 4: DİNAMİK DİZİLER (SLICES VE APPEND)
        // ==========================================
        Lesson(
            id = "go_4",
            courseId = "go",
            sectionId = "go_sec_2",
            title = "Dinamik Diziler (Slices) ve append()",
            shortDesc = "Boyutu otomatik büyüyen listeler (Slice) ve yeni eleman eklemenin yolu: append().",
            level = CourseLevel.BEGINNER,
            order = 4,
            isPremium = true,
            learningObjectives = listOf(
                "Sabit boyutlu Dizi ([5]int) ile dinamik Slice ([]int) farkını kavramak",
                "append() fonksiyonu ile listeye yeni elemanlar eklemek",
                "range ile liste elemanlarını döngüye sokmak"
            ),
            prerequisites = listOf("Fonksiyonlar ve Döngüler"),
            subtopics = listOf("Slice Nedir? ([]int)", "append() Kullanımı", "for range Döngüsü"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Slice: Esnek ve Akıllı Liste",
                    body = "Go'da köşeli parantezin içine sayı yazmazsanız `[]string` bu bir **Slice** (Dinamik Liste) olur. Boyutu sınırsızdır ve `append()` ile içine dilediğiniz kadar eleman eklersiniz.",
                    codeSnippet = "meyveler := []string{\"Elma\", \"Muz\"}\nmeyveler = append(meyveler, \"Çilek\") // Listeye Çilek ekledik\n\nfor i, m := range meyveler {\n    fmt.Println(i, m)\n}"
                )
            ),
            codeExample = "sayilar := []int{10, 20}\nsayilar = append(sayilar, 30, 40)\nfmt.Println(\"Eleman Sayısı:\", len(sayilar)) // 4",
            codeExplanation = "append ile birden çok eleman eklendi ve len() ile uzunluk ölçüldü.",
            realWorldExample = "Veritabanından çekilen binlerce kullanıcı kaydı Go'da bir Slice içinde toplanır.",
            practicalTask = "3 elemanlı bir string slice oluşturup append ile 4. elemanı ekleyin.",
            starterPlaygroundCode = "liste := []string{\"A\", \"B\"}\nliste = append(liste, \"C\")",
            miniQuestion = MiniQuestion(
                id = "go_q_4",
                question = "Go'da bir Slice'ın sonuna yeni bir eleman eklemek için hangi standart fonksiyon kullanılır?",
                options = listOf("append()", "push()", "add()", "insert()"),
                correctIndex = 0,
                explanation = "Eleman eklemek için 'append(slice, eleman)' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_go_4",
                lessonId = "go_4",
                title = "Slice Toplayıcı",
                instructions = "Verilen []int dilimindeki sayıların toplamını hesaplayan sliceTopla(liste []int) int fonksiyonunu yazın.",
                exampleInput = "sliceTopla([]int{5, 10, 15})",
                exampleOutput = "30",
                starterCode = "func sliceTopla(liste []int) int {\n    // Kodunu yaz:\n    return 0\n}",
                solutionCode = "func sliceTopla(liste []int) int {\n    top := 0\n    for _, v := range liste {\n        top += v\n    }\n    return top\n}",
                hints = listOf("for _, v := range liste { top += v } return top yazın."),
                testCases = listOf(
                    TestCase("sliceTopla([]int{5, 10, 15})", "30", "Slice toplamı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "go_quiz_4_1",
                    lessonId = "go_4",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir Slice'ın eleman sayısını (uzunluğunu) öğrenmek için hangi fonksiyon çağrılır?",
                    options = listOf("len(slice)", "count(slice)", "slice.size()", "slice.length"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Uzunluk için 'len()' kullanılır.",
                    explanationWrong = "len() fonksiyonu kullanılır.",
                    reviewTopic = "Go Slice'lar"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "make([]int, 5, 10) ne anlama gelir?",
                    answer = "Uzunluğu 5, arka plandaki bellek kapasitesi 10 olan optimize bir Slice oluşturur."
                )
            ),
            completionCriteria = listOf(
                "Slice tanımlayıp append() yapabilmek",
                "for range ile slice'ı gezebilmek"
            )
        ),

        // ==========================================
        // DERS 5: SÖZLÜKLER (MAPS)
        // ==========================================
        Lesson(
            id = "go_5",
            courseId = "go",
            sectionId = "go_sec_2",
            title = "Sözlükler (Maps) ve Anahtar-Değer Deposu",
            shortDesc = "Işık hızında arama yapmayı sağlayan map[string]int sözlükleri ve varlık kontrolü (ok).",
            level = CourseLevel.BEGINNER,
            order = 5,
            isPremium = true,
            learningObjectives = listOf(
                "make(map[string]int) ile sözlük oluşturmak",
                "Anahtar-değer eklemek, okumak ve delete() ile silmek",
                "val, ok := sozluk[anahtar] ile elemanın var olup olmadığını anlamak"
            ),
            prerequisites = listOf("Slice'lar ve Fonksiyonlar"),
            subtopics = listOf("map Tanımlama", "Eleman Ekleme/Silme", "İki Değerli Varlık Kontrolü (, ok)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Map: Anahtar ile Değere Ulaşmak",
                    body = "Kullanıcı adı yazıp yaşını veya telefonunu anında bulmak için `map[anahtarTipi]degerTipi` yapısı kullanılır.",
                    codeSnippet = "notlar := make(map[string]int)\nnotlar[\"Ahmet\"] = 95\nnotlar[\"Zeynep\"] = 100\n\n// Varlık kontrolü (ok):\nif not, varMi := notlar[\"Ahmet\"]; varMi {\n    fmt.Println(\"Ahmet'in Notu:\", not)\n}"
                )
            ),
            codeExample = "baskentler := map[string]string{\n    \"Türkiye\": \"Ankara\",\n    \"Fransa\": \"Paris\",\n}\nfmt.Println(baskentler[\"Türkiye\"]) // Ankara",
            codeExplanation = "Map doğrudan süslü parantez ile ilk değerleriyle tanımlandı.",
            realWorldExample = "Web sunucusuna gelen HTTP Header başlıkları map[string]string içinde saklanır.",
            practicalTask = "Telefon rehberi tutan bir map[string]string tanımlayın.",
            starterPlaygroundCode = "rehber := map[string]string{\"Ali\": \"555-1234\"}",
            miniQuestion = MiniQuestion(
                id = "go_q_5",
                question = "Go'da bir map'ten eleman okurken (deger, ok := m[key]) 'ok' değişkeni neyi ifade eder?",
                options = listOf("Aranan anahtarın map'te gerçekten bulunup bulunmadığını (bool)", "İşlemin hızını", "Hata mesajını", "Karakter sayısını"),
                correctIndex = 0,
                explanation = "'ok' değişkeni anahtar varsa true, yoksa false döner."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_go_5",
                lessonId = "go_5",
                title = "Not Sorgulayıcı",
                instructions = "notlar haritasında ogrenci varsa notunu, yoksa -1 döndüren notuBul(notlar map[string]int, ogrenci string) int fonksiyonunu yazın.",
                exampleInput = "notuBul(m, \"Ahmet\")",
                exampleOutput = "95",
                starterCode = "func notuBul(notlar map[string]int, ogrenci string) int {\n    // Kodunu yaz:\n    return 0\n}",
                solutionCode = "func notuBul(notlar map[string]int, ogrenci string) int {\n    if not, ok := notlar[ogrenci]; ok {\n        return not\n    }\n    return -1\n}",
                hints = listOf("if not, ok := notlar[ogrenci]; ok { return not } return -1 yazın."),
                testCases = listOf(
                    TestCase("notuBul(map[string]int{\"Ali\": 90}, \"Ali\")", "90", "Öğrenci var"),
                    TestCase("notuBul(map[string]int{\"Ali\": 90}, \"Can\")", "-1", "Öğrenci yok")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "go_quiz_5_1",
                    lessonId = "go_5",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Go'da bir map'ten bir anahtarı silmek için hangi fonksiyon kullanılır?",
                    options = listOf("delete(map, key)", "map.remove(key)", "map.pop(key)", "erase(map, key)"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Map elemanı silmek için 'delete()' kullanılır.",
                    explanationWrong = "delete() fonksiyonu kullanılır.",
                    reviewTopic = "Go Map'ler"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Map'te olmayan bir anahtarı okursak ne döner?",
                    answer = "Hata vermez, o tipin sıfır değerini (int için 0, string için \"\") döndürür."
                )
            ),
            completionCriteria = listOf(
                "Map tanımlayıp okuma/yazma yapabilmek",
                ", ok varlık kontrolünü bilmek"
            )
        ),

        // ==========================================
        // DERS 6: STRUCTS VE POINTERLAR
        // ==========================================
        Lesson(
            id = "go_6",
            courseId = "go",
            sectionId = "go_sec_3",
            title = "Yapılar (Structs) ve Pointer'lar (& ve *)",
            shortDesc = "Kendi veri modelinizi oluşturun (struct) ve bellek kopyalamasını önleyen pointerlar.",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true,
            learningObjectives = listOf(
                "type Kisi struct yapısı ile veri modellemek",
                "& (Adres) ve * (İçerik) pointer operatörlerini kavramak",
                "Büyük struct'ları fonksiyona pointerla hızlıca aktarmak"
            ),
            prerequisites = listOf("Map'ler ve Slice'lar"),
            subtopics = listOf("struct Tanımlama", "Pointerlar (&, *)", "Bellek Verimliliği"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. struct: Bilgi Paketi",
                    body = "Bir 'Kullanici' açıp içine adını, yaşını ve e-postasını tek bir pakete koyarız.",
                    codeSnippet = "type Kullanici struct {\n    Isim  string\n    Yas   int\n    Aktif bool\n}\n\nfunc main() {\n    k := Kullanici{Isim: \"Murat\", Yas: 28, Aktif: true}\n    fmt.Println(k.Isim, \"Yaş:\", k.Yas)\n}"
                )
            ),
            codeExample = "func yasArtir(k *Kullanici) {\n    k.Yas++ // Pointer üzerinden orijinal veriyi günceller\n}",
            codeExplanation = "*Kullanici pointer parametresi ile orijinal nesne güncellendi.",
            realWorldExample = "Veritabanı tablolarının Go kodundaki karşılıkları struct modelleridir.",
            practicalTask = "Araba adında bir struct açıp Marka ve Hiz alanları ekleyin.",
            starterPlaygroundCode = "type Araba struct { Marka string; Hiz int }",
            miniQuestion = MiniQuestion(
                id = "go_q_6",
                question = "Go'da bir değişkenin bellekteki adresini almak için değişkenin önüne hangi işaret konur?",
                options = listOf("& (Ampersand)", "*", "#", "@"),
                correctIndex = 0,
                explanation = "Bellek adresini almak için '&' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_go_6",
                lessonId = "go_6",
                title = "Dikdörtgen Alanı",
                instructions = "En ve Boy alanlarına sahip Dikdortgen struct'ını alan ve alanını (En * Boy) hesaplayan alan(d Dikdortgen) int fonksiyonunu yazın.",
                exampleInput = "alan(Dikdortgen{En: 5, Boy: 4})",
                exampleOutput = "20",
                starterCode = "type Dikdortgen struct {\n    En  int\n    Boy int\n}\n\nfunc alan(d Dikdortgen) int {\n    // Kodunu yaz:\n    return 0\n}",
                solutionCode = "type Dikdortgen struct {\n    En  int\n    Boy int\n}\n\nfunc alan(d Dikdortgen) int {\n    return d.En * d.Boy\n}",
                hints = listOf("return d.En * d.Boy yazın."),
                testCases = listOf(
                    TestCase("alan(Dikdortgen{En: 5, Boy: 4})", "20", "Alan testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "go_quiz_6_1",
                    lessonId = "go_6",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Go'da struct alanlarının ilk harfi BÜYÜK yazılırsa (örn: Isim) bu ne anlama gelir?",
                    options = listOf("Public (Exported) olur, diğer paketlerden erişilebilir", "Sabit (Const) olur", "Özel (Private) olur", "Hata verir"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Go'da büyük harfle başlayan her şey dışarıya açıktır (Exported).",
                    explanationWrong = "Public (Dışa açık) olur.",
                    reviewTopic = "Go Paket Görünürlüğü"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Go'da C gibi pointer aritmetiği (ptr++) var mıdır?",
                    answer = "Hayır! Go güvenlik için doğrudan bellek adresi matematiğine izin vermez."
                )
            ),
            completionCriteria = listOf(
                "struct ve pointer tanımlayabilmek",
                "Büyük/küçük harf görünürlük kuralını bilmek"
            )
        ),

        // ==========================================
        // DERS 7: METODLAR (RECEIVERS)
        // ==========================================
        Lesson(
            id = "go_7",
            courseId = "go",
            sectionId = "go_sec_3",
            title = "Metodlar (Receivers) ve Kompozisyon",
            shortDesc = "Struct'lara özel fonksiyonlar yazma (func (o Oyuncu) Vur()) ve kalıtım yerine gömme (Embedding).",
            level = CourseLevel.INTERMEDIATE,
            order = 7,
            isPremium = true,
            learningObjectives = listOf(
                "func (r Receiver) MetodAdi() sözdizimini öğrenmek",
                "Value Receiver vs Pointer Receiver (*Struct) farkını kavramak",
                "Struct içine başka struct gömerek (Composition) kod tekrarını önlemek"
            ),
            prerequisites = listOf("Structs ve Pointerlar"),
            subtopics = listOf("Receiver Metodları", "Pointer Receiver (*T)", "Struct Gömme (Embedding)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Fonksiyonu Struct'a Bağlamak (Receiver)",
                    body = "Fonksiyon adının önüne `(o Oyuncu)` yazarsanız bu fonksiyon artık o struct'ın bir metodu haline gelir.",
                    codeSnippet = "type Oyuncu struct {\n    Isim string\n    Can  int\n}\n\n// Değer değiştirmek için Pointer (*Oyuncu) kullanırız:\nfunc (o *Oyuncu) HasarAl(miktar int) {\n    o.Can -= miktar\n}\n\nfunc main() {\n    p := Oyuncu{Isim: \"Efe\", Can: 100}\n    p.HasarAl(20)\n    fmt.Println(p.Can) // 80\n}"
                )
            ),
            codeExample = "func (o Oyuncu) BilgiVer() string {\n    return o.Isim\n}",
            codeExplanation = "Value receiver ile sadece okuma yapan metot tanımlandı.",
            realWorldExample = "HTTP sunucusundaki Handler nesneleri ServeHTTP metoduna sahip Receiver'lardır.",
            practicalTask = "Oyuncu struct'ına CanYenile metodu ekleyin.",
            starterPlaygroundCode = "func (o *Oyuncu) CanYenile() { o.Can = 100 }",
            miniQuestion = MiniQuestion(
                id = "go_q_7",
                question = "Bir metodun struct içindeki alanları kalıcı olarak değiştirebilmesi için receiver nasıl tanımlanmalıdır?",
                options = listOf("Pointer Receiver (*Struct)", "Value Receiver (Struct)", "Static", "Void"),
                correctIndex = 0,
                explanation = "Değerleri değiştirebilmek için '*Struct' pointer receiver gerekir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_go_7",
                lessonId = "go_7",
                title = "Sayaç Metodu",
                instructions = "Deger alanına sahip Sayac struct'ını ve Deger'i 1 artıran (s *Sayac) Artir() metodunu yazın.",
                exampleInput = "s := Sayac{Deger: 0}; s.Artir()",
                exampleOutput = "s.Deger = 1",
                starterCode = "type Sayac struct {\n    Deger int\n}\n\n// Artir() metodunu yaz:\n",
                solutionCode = "type Sayac struct {\n    Deger int\n}\n\nfunc (s *Sayac) Artir() {\n    s.Deger++\n}",
                hints = listOf("func (s *Sayac) Artir() { s.Deger++ } yazın."),
                testCases = listOf(
                    TestCase("s := &Sayac{Deger: 0}; s.Artir(); s.Deger", "1", "Sayaç artırma")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "go_quiz_7_1",
                    lessonId = "go_7",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Go'da diğer nesne yönelimli dillerdeki 'class ... extends' kalıtımı yerine hangi yaklaşım kullanılır?",
                    options = listOf("Kompozisyon (Composition / Struct Embedding - struct içine struct gömme)", "Çoklu Kalıtım", "Virtual Sınıflar", "Kalıtım tamamen yasaktır"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Go 'Kalıtım yerine Kompozisyon' felsefesini savunur.",
                    explanationWrong = "Kompozisyon (Embedding) kullanılır.",
                    reviewTopic = "Go Kompozisyon"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Value Receiver ne zaman kullanılır?",
                    answer = "Struct küçükse ve metot veriyi sadece okuyacaksa Value Receiver (kopyalama) tercih edilir."
                )
            ),
            completionCriteria = listOf(
                "Receiver metodları tanımlayabilmek",
                "Pointer receiver gerekliliğini kavramak"
            )
        ),

        // ==========================================
        // DERS 8: ARAYÜZLER (INTERFACES)
        // ==========================================
        Lesson(
            id = "go_8",
            courseId = "go",
            sectionId = "go_sec_4",
            title = "Arayüzler (Interfaces): Ördek Testi Felsefesi",
            shortDesc = "'Ördek gibi yürüyorsa ve vaklıyorsa, o bir ördektir!' Açıkça 'implements' yazmadan arayüz olma sanatı.",
            level = CourseLevel.INTERMEDIATE,
            order = 8,
            isPremium = true,
            learningObjectives = listOf(
                "type Arayuz interface { ... } yapısını kavramak",
                "Go'da örtük (Implicit) arayüz uygulamasını anlamak",
                "any (interface{}) tipi ile jenerik veri tutmak"
            ),
            prerequisites = listOf("Structs ve Metodlar"),
            subtopics = listOf("Interface Tanımlama", "Örtük Uygulama (Duck Typing)", "any (interface{})"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. implements Yazmak Yok!",
                    body = "Bir interface `Konus() string` metodu istiyorsa; sizin struct'ınız bu metodu içerdiği an otomatik olarak o interface'e dönüşür. Hiçbir yere 'implements' yazmanız gerekmez!"
                ),
                LessonContentBlock(
                    subtitle = "2. Örnek Kullanım",
                    body = "Hem Köpek hem Kedi 'Sesli' arayüzünü otomatik karşılar.",
                    codeSnippet = "type Sesli interface {\n    SesCikar() string\n}\n\ntype Kopek struct{}\nfunc (k Kopek) SesCikar() string { return \"Hav hav! 🐶\" }\n\nfunc Konustur(s Sesli) {\n    fmt.Println(s.SesCikar())\n}"
                )
            ),
            codeExample = "var s Sesli = Kopek{}\nfmt.Println(s.SesCikar())",
            codeExplanation = "Kopek nesnesi Sesli interface değişkenine başarıyla atandı.",
            realWorldExample = "Go'daki 'io.Reader' interface'i dosya, internet bağlantısı ve metin akışlarını tek bir çatı altında birleştirir.",
            practicalTask = "Sekil interface'i açıp Alan() int metodu tanımlayın.",
            starterPlaygroundCode = "type Sekil interface { Alan() int }",
            miniQuestion = MiniQuestion(
                id = "go_q_8",
                question = "Go'da bir struct'ın bir interface'i uygulaması için ne yapması gerekir?",
                options = listOf("Interface'in istediği metodları aynı imzada tanımlaması yeterlidir (Otomatik/Örtük eşleşir)", "implements anahtar kelimesi yazmalıdır", "Ayrı dosya açmalıdır", "Derleyiciye bildirmelidir"),
                correctIndex = 0,
                explanation = "Go'da interface'ler örtüktür (Implicit); metodu yazmanız yeterlidir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_go_8",
                lessonId = "go_8",
                title = "Mesaj Verici Interface",
                instructions = "Mesaj() string metoduna sahip Mesajci interface'ini ve bunu uygulayan Selam struct'ını yazın (Mesaj 'Merhaba' döndürsün).",
                exampleInput = "var m Mesajci = Selam{}; m.Mesaj()",
                exampleOutput = "\"Merhaba\"",
                starterCode = "type Mesajci interface {\n    Mesaj() string\n}\n\ntype Selam struct{}\n// Mesaj() metodunu yaz:\n",
                solutionCode = "type Mesajci interface {\n    Mesaj() string\n}\n\ntype Selam struct{}\n\nfunc (s Selam) Mesaj() string {\n    return \"Merhaba\"\n}",
                hints = listOf("func (s Selam) Mesaj() string { return \"Merhaba\" } yazın."),
                testCases = listOf(
                    TestCase("Selam{}.Mesaj()", "Merhaba", "Mesaj testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "go_quiz_8_1",
                    lessonId = "go_8",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Modern Go sürümlerinde her türden veriyi kabul edebilen boş arayüzün (interface{}) modern takma adı nedir?",
                    options = listOf("any", "all", "object", "dynamic"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Go 1.18 ile birlikte 'any' anahtar kelimesi eklendi.",
                    explanationWrong = "any kullanılır.",
                    reviewTopic = "Go any Tipi"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Type Assertion (v.(string)) nedir?",
                    answer = "any tipindeki bir değişkenin içindeki verinin gerçekten string mi int mi olduğunu doğrulamak için kullanılır."
                )
            ),
            completionCriteria = listOf(
                "Interface mantığını kavramak",
                "Örtük interface uygulamasını anlamak"
            )
        ),

        // ==========================================
        // DERS 9: HATA YÖNETİMİ VE DEFER
        // ==========================================
        Lesson(
            id = "go_9",
            courseId = "go",
            sectionId = "go_sec_4",
            title = "Hata Yönetimi: if err != nil ve defer",
            shortDesc = "Go'nun ünlü 'if err != nil' kalıbı ve fonksiyon biterken otomatik temizlik yapan defer.",
            level = CourseLevel.INTERMEDIATE,
            order = 9,
            isPremium = true,
            learningObjectives = listOf(
                "Go'da try-catch olmadığını ve hataların değer olarak döndüğünü anlamak",
                "if err != nil kalıbıyla hataları güvenle yakalamak",
                "defer ile dosya ve veritabanı kilitlerini otomatik kapatmak"
            ),
            prerequisites = listOf("Interface'ler ve Fonksiyonlar"),
            subtopics = listOf("if err != nil", "errors.New()", "defer Anahtar Sözcüğü"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. if err != nil: Go'nun İmzası",
                    body = "Go'da hatalar arka planda gizlice fırlatılmaz; fonksiyonun eline bir `error` teslim edilir. Hata yoksa `nil` (boş) döner.",
                    codeSnippet = "import \"errors\"\n\nfunc bol(a, b int) (int, error) {\n    if b == 0 {\n        return 0, errors.New(\"Sıfıra bölünemez!\")\n    }\n    return a / b, nil\n}\n\nfunc main() {\n    sonuc, err := bol(10, 0)\n    if err != nil {\n        fmt.Println(\"Hata Var:\", err)\n        return\n    }\n    fmt.Println(\"Sonuç:\", sonuc)\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. defer: Çıkarken Işıkları Kapat",
                    body = "`defer` önüne yazılan kod, fonksiyon ne zaman ve nasıl biterse bitsin (hata olsa bile) en son çalışır. Dosya kapatmak için mükemmeldir!",
                    codeSnippet = "file, _ := os.Open(\"veri.txt\")\ndefer file.Close() // Fonksiyon bittiğinde otomatik kapanır!"
                )
            ),
            codeExample = "defer fmt.Println(\"3. Son\")\nfmt.Println(\"1. İlk\")\nfmt.Println(\"2. İkinci\")",
            codeExplanation = "defer ile ertelenen satır fonksiyonun en sonunda çalıştı.",
            realWorldExample = "Web sunucusunda veritabanı bağlantısı açıldığında hemen altına 'defer db.Close()' yazılır.",
            practicalTask = "defer ile çalışan basit bir fonksiyon inceleyin.",
            starterPlaygroundCode = "defer fmt.Println(\"Kapanış\")",
            miniQuestion = MiniQuestion(
                id = "go_q_9",
                question = "Go dilinde bir fonksiyon çağrısının başına 'defer' konduğunda o kod tam olarak ne zaman çalıştırılır?",
                options = listOf("İçinde bulunduğu fonksiyon tamamen bitip geri dönmeden hemen önce", "Hemen o an", "1 saniye sonra", "Arka planda bağımsız"),
                correctIndex = 0,
                explanation = "defer komutları fonksiyon çıkışında en son çalışır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_go_9",
                lessonId = "go_9",
                title = "Güvenli Hata Kontrolü",
                instructions = "err != nil ise err.Error() mesajını, err nil ise 'Başarılı' döndüren hataMesaji(err error) string fonksiyonunu yazın.",
                exampleInput = "hataMesaji(nil)",
                exampleOutput = "\"Başarılı\"",
                starterCode = "func hataMesaji(err error) string {\n    // Kodunu yaz:\n    return \"\"\n}",
                solutionCode = "func hataMesaji(err error) string {\n    if err != nil {\n        return err.Error()\n    }\n    return \"Başarılı\"\n}",
                hints = listOf("if err != nil { return err.Error() } return \"Başarılı\" yazın."),
                testCases = listOf(
                    TestCase("hataMesaji(nil)", "Başarılı", "Hata yok")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "go_quiz_9_1",
                    lessonId = "go_9",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Go standart kütüphanesinde yeni ve basit bir hata nesnesi üretmek için hangi paket ve fonksiyon kullanılır?",
                    options = listOf("errors.New(\"Hata metni\")", "new Error()", "throw(\"Hata\")", "make(error)"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! errors.New() ile hata nesnesi oluşturulur.",
                    explanationWrong = "errors.New() kullanılır.",
                    reviewTopic = "Go Hata Yönetimi"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Birden fazla defer yazılırsa hangi sırayla çalışır?",
                    answer = "Son giren ilk çıkar (LIFO - Last In First Out) sırasıyla, yani tersten çalışır."
                )
            ),
            completionCriteria = listOf(
                "if err != nil yapısını kavramak",
                "defer ile kaynak temizliği yapabilmek"
            )
        ),

        // ==========================================
        // DERS 10: GOROUTINES (EŞZAMANLILIK)
        // ==========================================
        Lesson(
            id = "go_10",
            courseId = "go",
            sectionId = "go_sec_5",
            title = "Goroutines: Hafif İplikler (go func())",
            shortDesc = "Tek bir 'go' kelimesiyle aynı anda yüz binlerce görevi çalıştıran devasa eşzamanlılık gücü.",
            level = CourseLevel.ADVANCED,
            order = 10,
            isPremium = true,
            learningObjectives = listOf(
                "İşletim sistemi thread'i (2MB) vs Goroutine (2KB) farkını anlamak",
                "'go' anahtarı ile asenkron arka plan görevi başlatmak",
                "time.Sleep ve sync.WaitGroup ile goroutine'leri beklemek"
            ),
            prerequisites = listOf("Hata Yönetimi ve Fonksiyonlar"),
            subtopics = listOf("Goroutine Nedir?", "go Anahtar Sözcüğü", "sync.WaitGroup"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Tek Kelimeyle Çoklu Görev: go",
                    body = "Normalde 100.000 thread açarsanız bilgisayar donar. Ama Go'nun **Goroutine**'leri o kadar hafiftir ki (sadece 2 KB!) aynı anda milyonlarcasını milisaniyede açabilirsiniz.",
                    codeSnippet = "func selamVer(isim string) {\n    fmt.Println(\"Selam\", isim)\n}\n\nfunc main() {\n    go selamVer(\"Ahmet\") // Arka planda anında başlar!\n    go selamVer(\"Ayşe\")\n    \n    time.Sleep(time.Millisecond * 100) // Bitmelerini bekle\n}"
                )
            ),
            codeExample = "go func() {\n    fmt.Println(\"Arka planda anonim görev çalışıyor!\")\n}()",
            codeExplanation = "go anahtarı anonim fonksiyonu anında ayrı bir goroutine olarak başlattı.",
            realWorldExample = "Aynı anda 50.000 kullanıcıya canlı bildirim gönderen mesajlaşma sunucuları Goroutine ile yazılır.",
            practicalTask = "go anahtar sözcüğü ile basit bir görevi asenkron başlatın.",
            starterPlaygroundCode = "go func() { fmt.Println(\"Goroutine\") }()",
            miniQuestion = MiniQuestion(
                id = "go_q_10",
                question = "Go'da bir fonksiyonu arka planda bağımsız bir eşzamanlı görev (Goroutine) olarak çalıştırmak için fonksiyon çağrısının başına ne yazılır?",
                options = listOf("go", "async", "thread", "spawn"),
                correctIndex = 0,
                explanation = "Goroutine başlatmak için 'go' anahtarı yazılır (örn: go gorevYap())."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_go_10",
                lessonId = "go_10",
                title = "Goroutine Başlatıcı",
                instructions = "Gelen f fonksiyonunu bir goroutine olarak 'go f()' şeklinde başlatan gorevBaslat(f func()) fonksiyonunu yazın.",
                exampleInput = "gorevBaslat(func() {})",
                exampleOutput = "Goroutine başlatıldı",
                starterCode = "func gorevBaslat(f func()) {\n    // Kodunu yaz:\n}",
                solutionCode = "func gorevBaslat(f func()) {\n    go f()\n}",
                hints = listOf("go f() yazın."),
                testCases = listOf(
                    TestCase("gorevBaslat(func(){})", "", "Goroutine testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "go_quiz_10_1",
                    lessonId = "go_10",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Goroutine'lerin işletim sistemi thread'lerine göre en büyük avantajı nedir?",
                    options = listOf("Yalnızca ~2 KB bellek kaplamaları ve Go çalışma zamanı (Runtime) tarafından ultra hızlı yönetilmeleri", "Sadece internete bağlanmaları", "Daha yavaş olmaları", "Sadece tek çekirdekte çalışmaları"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Goroutine'ler tüy kadar hafiftir.",
                    explanationWrong = "Ultra hafif ve hızlı olmalarıdır.",
                    reviewTopic = "Go Eşzamanlılık"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "main() fonksiyonu biterse arka plandaki goroutine'lere ne olur?",
                    answer = "main() bittiği an program kapanır ve çalışan tüm goroutine'ler anında sonlandırılır."
                )
            ),
            completionCriteria = listOf(
                "Goroutine kavramını bilmek",
                "go anahtar sözcüğünü kullanabilmek"
            )
        ),

        // ==========================================
        // DERS 11: KANALLAR (CHANNELS)
        // ==========================================
        Lesson(
            id = "go_11",
            courseId = "go",
            sectionId = "go_sec_5",
            title = "Kanallar (Channels): Goroutine'ler Arası İletişim",
            shortDesc = "Goroutine'lerin birbirine veri fırlattığı boru hatları (<- chan) ve 'select' yapısı.",
            level = CourseLevel.ADVANCED,
            order = 11,
            isPremium = true,
            learningObjectives = listOf(
                "make(chan int) ile kanal oluşturmak",
                "<- (Kanal okuma/yazma) operatörünü öğrenmek",
                "select ile birden fazla kanalı aynı anda dinlemek"
            ),
            prerequisites = listOf("Goroutines"),
            subtopics = listOf("Kanal Nedir? (chan)", "<- Veri Gönderme ve Alma", "select İfadesi"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. 'Hafızayı paylaşarak iletişim kurma, iletişim kurarak hafızayı paylaş!'",
                    body = "Go'nun ünlü felsefesi: İki ayrı görev birbirinin değişkenine doğrudan dokunmaz; aralarına bir **Kanal (Channel)** borusu çeker ve veriyi fırlatır (`ch <- deger`).",
                    codeSnippet = "func hesapla(ch chan int) {\n    ch <- 42 // Kanala 42 değerini yolla\n}\n\nfunc main() {\n    ch := make(chan int)\n    go hesapla(ch)\n    \n    gelen := <-ch // Kanaldan veri gelene kadar bekler ve okur\n    fmt.Println(\"Kanaldan Gelen:\", gelen) // 42\n}"
                )
            ),
            codeExample = "ch := make(chan string, 1)\nch <- \"Mesaj\"\nfmt.Println(<-ch)",
            codeExplanation = "Kanala veri yazıldı ve kanaldan veri okundu.",
            realWorldExample = "Finans borsalarında fiyat değişimleri kanallar üzerinden anlık olarak emir motorlarına iletilir.",
            practicalTask = "Kanal oluşturup içine sayı gönderip okuyan kodu inceleyin.",
            starterPlaygroundCode = "ch := make(chan int, 1); ch <- 10; fmt.Println(<-ch)",
            miniQuestion = MiniQuestion(
                id = "go_q_11",
                question = "Go'da bir kanala (ch) veri göndermek için hangi sözdizimi kullanılır?",
                options = listOf("ch <- deger", "ch.send(deger)", "deger -> ch", "ch.push(deger)"),
                correctIndex = 0,
                explanation = "Kanala veri yazmak için 'ch <- deger' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_go_11",
                lessonId = "go_11",
                title = "Kanala Veri Gönderici",
                instructions = "ch kanalına deger sayısını 'ch <- deger' şeklinde gönderen kanalaGonder(ch chan int, deger int) fonksiyonunu yazın.",
                exampleInput = "kanalaGonder(ch, 50)",
                exampleOutput = "<-ch = 50",
                starterCode = "func kanalaGonder(ch chan int, deger int) {\n    // Kodunu yaz:\n}",
                solutionCode = "func kanalaGonder(ch chan int, deger int) {\n    ch <- deger\n}",
                hints = listOf("ch <- deger yazın."),
                testCases = listOf(
                    TestCase("ch := make(chan int, 1); kanalaGonder(ch, 50); <-ch", "50", "Kanal testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "go_quiz_11_1",
                    lessonId = "go_11",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Go'da birden fazla kanaldan hangisinden ilk veri gelirse onu anında yakalayan yapı hangisidir?",
                    options = listOf("select", "switch", "listen", "poll"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Kanalları eşzamanlı dinlemek için 'select' kullanılır.",
                    explanationWrong = "select kullanılır.",
                    reviewTopic = "Go Select"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Kanal kapatılmazsa ne olur?",
                    answer = "Kanalda bekleyen kimse kalmazsa çöp toplayıcı temizler; ancak range ile okunuyorsa sonsuz beklemeyi önlemek için 'close(ch)' çağrılır."
                )
            ),
            completionCriteria = listOf(
                "Kanal oluşturup <- ile okuma/yazma yapabilmek",
                "select yapısının amacını bilmek"
            )
        ),

        // ==========================================
        // DERS 12: BULUT VE GO USTALIĞI
        // ==========================================
        Lesson(
            id = "go_12",
            courseId = "go",
            sectionId = "go_sec_6",
            title = "Go Ustalığı: Mikroservisler, Bulut ve Gelecek",
            shortDesc = "Docker, Kubernetes, REST API sunucuları ve dünyanın en verimli arka uç (Backend) mühendisi olma.",
            level = CourseLevel.EXPERT,
            order = 12,
            isPremium = true,
            learningObjectives = listOf(
                "Go'nun bulut ve mikroservis dünyasındaki lider konumunu anlamak",
                "net/http ile tek dosyada REST API web sunucusu kurmak",
                "Tebrikler: Artık bulut devlerinin aradığı donanımlı bir Go geliştiricisisiniz!"
            ),
            prerequisites = listOf("Tüm Go Konuları"),
            subtopics = listOf("net/http Web Sunucusu", "Docker & Kubernetes Ekosistemi", "Tebrikler ve Tavsiyeler"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Tebrikler! Go Yolculuğunu Başarıyla Tamamladınız! 🐹🏆",
                    body = "Artık Go temellerinden Goroutine ve Kanallarla eşzamanlı mimarilere, Duck Typing arayüzlerden güvenli hata yönetimine kadar tüm Go ekosistemine hakimsiniz.\n\nSaniyede yüz binlerce istek karşılayan API sunucuları yazabilir, bulut altyapıları geliştirebilir ve küresel ölçekte yazılımlar üretebilirsiniz!"
                )
            ),
            codeExample = "// Go Ustası Oldunuz!\npackage main\nimport \"fmt\"\nfunc main() {\n    fmt.Println(\"Go Seviyeniz: USTA! 🚀✨\")\n}",
            codeExplanation = "Go yolculuğunuz başarıyla tamamlandı.",
            realWorldExample = "Google Cloud, AWS ve Azure altyapı araçlarının neredeyse tamamı Go ile geliştirilir.",
            practicalTask = "Go başarılarınızı kutlayın!",
            starterPlaygroundCode = "// Harika bir Go geliştiricisisiniz!",
            miniQuestion = MiniQuestion(
                id = "go_q_12",
                question = "Go standart kütüphanesinde hiçbir harici paket kurmadan saniyeler içinde web sunucusu açmayı sağlayan paket hangisidir?",
                options = listOf("net/http", "web/server", "io/http", "cloud/api"),
                correctIndex = 0,
                explanation = "Web sunucuları için standart 'net/http' paketi kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_go_12",
                lessonId = "go_12",
                title = "Şampiyon Go Mesajı",
                instructions = "Üstünde 'Go Şampiyonu' yazan string döndüren sampiyon() string fonksiyonunu yazın.",
                exampleInput = "sampiyon()",
                exampleOutput = "\"Go Şampiyonu\"",
                starterCode = "func sampiyon() string {\n    // Kodunu yaz:\n    return \"\"\n}",
                solutionCode = "func sampiyon() string {\n    return \"Go Şampiyonu\"\n}",
                hints = listOf("return \"Go Şampiyonu\" yazın."),
                testCases = listOf(
                    TestCase("sampiyon()", "Go Şampiyonu", "Şampiyon testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "go_quiz_12_1",
                    lessonId = "go_12",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Go dilinin sevimli resmi maskotu nedir?",
                    options = listOf("Gopher (Sincap benzeri dağ sıçanı)", "Kedi", "Yılan", "Fil"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Go'nun maskotu sevimli Gopher'dır.",
                    explanationWrong = "Gopher'dır.",
                    reviewTopic = "Go Kültürü"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Go kodu tek bir binary dosyaya mı derlenir?",
                    answer = "Evet! Hiçbir bağımlılık veya framework kurmadan tek bir çalıştırılabilir dosya (.exe veya ELF) olarak her yerde çalışır."
                )
            ),
            completionCriteria = listOf(
                "Go felsefesine tam hakim olmak",
                "Mikroservis ve bulut mimarilerine hazır olmak"
            )
        )
    )
}
