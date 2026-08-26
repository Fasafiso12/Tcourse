package com.example.data.catalog

import com.example.model.*

/**
 * Rust Kolay & Anlaşılır Müfredatı (12 Adım):
 * Dünyanın en sevilen, çökmeyen ve bellek güvenliği sağlayan sistem dili Rust'ı keyifle öğrenin!
 */
object RustCurriculum {

    fun getSections(): List<CourseSection> = listOf(
        CourseSection(
            id = "rs_sec_1",
            courseId = "rust",
            title = "Bölüm 1: Rust Temelleri ve Değişmezlik",
            level = CourseLevel.BEGINNER,
            order = 1,
            description = "println! makrosu, let ve let mut (değişmezlik ilkesi), if-else ve döngüler.",
            learningObjectives = listOf("println! makrosunu kullanmak", "let ve let mut farkını kavramak", "for ve while döngüleri kurmak"),
            prerequisites = listOf("Ön koşul gerekmez! Sıfırdan başlar.")
        ),
        CourseSection(
            id = "rs_sec_2",
            courseId = "rust",
            title = "Bölüm 2: Rust'ın Kalbi: Sahiplik (Ownership)",
            level = CourseLevel.BEGINNER,
            order = 2,
            description = "Rust'ı eşsiz kılan Sahiplik (Ownership) ve Ödünç Alma (& Borrowing) kuralları.",
            learningObjectives = listOf("Sahiplik (Ownership) mantığını anlamak", "& ve &mut ile veriyi ödünç vermek"),
            prerequisites = listOf("Rust Temelleri")
        ),
        CourseSection(
            id = "rs_sec_3",
            courseId = "rust",
            title = "Bölüm 3: Yapılar (struct) ve Listeler (Vec)",
            level = CourseLevel.INTERMEDIATE,
            order = 3,
            description = "struct ile kendi veri modellerini kurma, impl ile metot yazma ve Vec<T> dinamik dizisi.",
            learningObjectives = listOf("struct ve impl blokları yazmak", "Vec<T> ile dinamik listeler yönetmek"),
            prerequisites = listOf("Sahiplik ve Referanslar")
        ),
        CourseSection(
            id = "rs_sec_4",
            courseId = "rust",
            title = "Bölüm 4: match, Option ve Result (Null'a Son!)",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            description = "match ile kusursuz desen eşleme, Option<T> ile null hatasız kod ve Result ile hata yakalama.",
            learningObjectives = listOf("match kalıbını ustaca kullanmak", "Option (Some/None) ile null riskini yok etmek", "Result ve '?' operatörü ile hata yönetmek"),
            prerequisites = listOf("struct ve Koleksiyonlar")
        ),
        CourseSection(
            id = "rs_sec_5",
            courseId = "rust",
            title = "Bölüm 5: Nitelikler (Traits) ve HashMap",
            level = CourseLevel.ADVANCED,
            order = 5,
            description = "Ortak yetenekler kazandıran Trait arayüzleri ve anahtar-değer sözlükleri (HashMap).",
            learningObjectives = listOf("Trait tanımlayıp sınıflara uygulamak", "HashMap ile hızlı arama yapmak"),
            prerequisites = listOf("Option ve Result")
        ),
        CourseSection(
            id = "rs_sec_6",
            courseId = "rust",
            title = "Bölüm 6: Rust Ustalığı ve Sistem Dünyası",
            level = CourseLevel.EXPERT,
            order = 6,
            description = "Linux çekirdeğinde Rust, sıfır maliyetli soyutlama ve profesyonel Rust geliştiricisi olma.",
            learningObjectives = listOf("Rust'ın endüstrideki gücünü kavramak", "Hatasız ve güvenli sistem yazılımları üretmek"),
            prerequisites = listOf("Tüm Seviyeler")
        )
    )

    fun getLessons(): List<Lesson> = listOf(
        // ==========================================
        // DERS 1: PRINTLN VE MAIN
        // ==========================================
        Lesson(
            id = "rs_1",
            courseId = "rust",
            sectionId = "rs_sec_1",
            title = "Rust'a Giriş: Güvenlik, Hız ve println!",
            shortDesc = "Çökmeyen, hafıza sızıntısı yapmayan ve C++ hızında çalışan modern sistem dili!",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false,
            learningObjectives = listOf(
                "Rust'ın neden dünyanın en sevilen dili seçildiğini anlamak",
                "main() fonksiyonu ve println!() makrosu ile ekrana yazdırmak",
                "{} yer tutucuları ile değişkenleri metne gömmek"
            ),
            prerequisites = listOf("Ön koşul gerekmez."),
            subtopics = listOf("Rust Nedir?", "Cargo Paket Yöneticisi", "main() ve println!", "{} Formatlama"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Rust Neden Bu Kadar Özel?",
                    body = "Yazılımların en büyük kabusu olan 'bellek sızıntıları' ve 'çökmeler' (Crash) Rust'ta derleme aşamasında engellenir. Rust size C++ hızında ama Python konforunda güvenli bir kodlama deneyimi sunar.\n\nEkrana yazı basmak için sonuna ünlem `!` koyduğumuz `println!` makrosunu kullanırız."
                ),
                LessonContentBlock(
                    subtitle = "2. İlk Rust Kodunuz",
                    body = "Süslü parantez `{}` işaretleri metnin içine değişken yerleştirmeyi sağlar.",
                    codeSnippet = "fn main() {\n    println!(\"Merhaba Rust Dünyası! 🦀\");\n    \n    let puan = 100;\n    println!(\"Kazanılan Puan: {}\", puan);\n}"
                )
            ),
            codeExample = "fn main() {\n    let ad = \"Demir\";\n    println!(\"Oyuncu: {}\", ad);\n}",
            codeExplanation = "println! makrosu {} yer tutucusuna ad değişkenini koydu.",
            realWorldExample = "Linux çekirdeği (Kernel), Android işletim sistemi ve Cloudflare ağ altyapısı artık Rust ile yazılmaktadır.",
            practicalTask = "Adınızı ve yaşınızı {} kullanarak tek bir println! ile yazdırın.",
            starterPlaygroundCode = "fn main() {\n    println!(\"Merhaba {}\", \"Ahmet\");\n}",
            miniQuestion = MiniQuestion(
                id = "rs_q_1",
                question = "Rust'ta ekrana formatlı yazı basmak için hangi makro kullanılır?",
                options = listOf("println!", "print_line()", "console.log()", "fmt.Println()"),
                correctIndex = 0,
                explanation = "Rust'ta standart ekrana yazdırma 'println!' makrosuyla yapılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_rs_1",
                lessonId = "rs_1",
                title = "İki Sayıyı Topla",
                instructions = "İki tam sayıyı toplayıp sonucunu döndüren topla(a, b) fonksiyonunu yazın.",
                exampleInput = "topla(10, 20)",
                exampleOutput = "30",
                starterCode = "fn topla(a: i32, b: i32) -> i32 {\n    // Kodunu yaz:\n    0\n}",
                solutionCode = "fn topla(a: i32, b: i32) -> i32 {\n    a + b\n}",
                hints = listOf("a + b (noktalı virgülsüz son ifade) veya return a + b; yazın."),
                testCases = listOf(
                    TestCase("topla(10, 20)", "30", "Toplam testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "rs_quiz_1_1",
                    lessonId = "rs_1",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Rust fonksiyonlarında son satıra noktalı virgül (;) koymazsanız Rust bunu ne olarak kabul eder?",
                    options = listOf("Geriye döndürülecek değer (return ifadesi)", "Sözdizimi hatası", "Yorum satırı", "Döngü sonu"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Rust'ta noktalı virgülsüz son satır otomatik olarak return edilir.",
                    explanationWrong = "Otomatik return değeri olarak kabul edilir.",
                    reviewTopic = "Rust Temelleri"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "println! sonundaki '!' ne anlama gelir?",
                    answer = "Bunun normal bir fonksiyon değil, derleme anında çalışan güçlü bir makro olduğunu gösterir."
                )
            ),
            completionCriteria = listOf(
                "println! ve {} kullanımını bilmek",
                "Rust'ın güvenlik amacını anlamak"
            )
        ),

        // ==========================================
        // DERS 2: DEĞİŞKENLER (let vs let mut)
        // ==========================================
        Lesson(
            id = "rs_2",
            courseId = "rust",
            sectionId = "rs_sec_1",
            title = "Değişkenler: let vs let mut (Değişmezlik)",
            shortDesc = "Rust'ta her değişken varsayılan olarak sabittir! Değiştirmek için 'mut' anahtarı.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false,
            learningObjectives = listOf(
                "Rust'ın varsayılan 'Immutable' (Değişmez) kuralını kavramak",
                "Değeri değişecek değişkenler için 'let mut' kullanmak",
                "i32, f64, bool ve char tiplerini öğrenmek"
            ),
            prerequisites = listOf("Rust Giriş ve println!"),
            subtopics = listOf("let (Sabit)", "let mut (Değişken)", "Temel Tipler (i32, f64)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Rust Neden Değişkenleri Kilitler?",
                    body = "Yanlışlıkla bir değişkenin değerini değiştirmek büyük bug'lara yol açar. Bu yüzden Rust'ta `let sayi = 5;` yazarsanız bu sayı artık taşa kazınmıştır, değiştirilemez!\n\nDeğiştirmek istiyorsanız açıkça izin vermelisiniz: `let mut sayi = 5;` (mutable)."
                ),
                LessonContentBlock(
                    subtitle = "2. Örnek Kullanım",
                    body = "mut eklenmediğinde derleyici sizi korur ve hata verir.",
                    codeSnippet = "let x = 10; // x sabittir\n// x = 20; -> HATA VERİR!\n\nlet mut can = 100; // can değişebilir\ncan = 80; // Sorunsuz çalışır!"
                )
            ),
            codeExample = "let mut skor = 0;\nskor += 10;\nprintln!(\"Skor: {}\", skor); // 10",
            codeExplanation = "let mut ile skor değişkeni artırılabilir hale getirildi.",
            realWorldExample = "Kullanıcı ID'si gibi asla değişmemesi gereken veriler let ile, sayaçlar let mut ile tanımlanır.",
            practicalTask = "let mut ile bir sayaç tanımlayıp değerini 1 artırın.",
            starterPlaygroundCode = "let mut sayac = 0;\nsayac += 1;",
            miniQuestion = MiniQuestion(
                id = "rs_q_2",
                question = "Rust'ta bir değişkenin değerinin sonradan değiştirilebilmesi için başına hangi kelime eklenir?",
                options = listOf("mut", "var", "change", "dynamic"),
                correctIndex = 0,
                explanation = "Değiştirilebilir değişkenler için 'mut' (mutable) kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_rs_2",
                lessonId = "rs_2",
                title = "İki Katını Al",
                instructions = "Parametre olarak gelen x sayısını 2 ile çarpıp döndüren iki_kat(x) fonksiyonunu yazın.",
                exampleInput = "iki_kat(7)",
                exampleOutput = "14",
                starterCode = "fn iki_kat(x: i32) -> i32 {\n    // Kodunu yaz:\n    0\n}",
                solutionCode = "fn iki_kat(x: i32) -> i32 {\n    x * 2\n}",
                hints = listOf("x * 2 yazın."),
                testCases = listOf(
                    TestCase("iki_kat(7)", "14", "İki katı testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "rs_quiz_2_1",
                    lessonId = "rs_2",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Rust'ta varsayılan değişken tipi olan 32-bit işaretli tam sayı nasıl yazılır?",
                    options = listOf("i32", "int", "number", "i64"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Standart tam sayı tipi i32'dir.",
                    explanationWrong = "i32 kullanılır.",
                    reviewTopic = "Rust Tipleri"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Shadowing (Gölgeleme) nedir?",
                    answer = "Aynı isimle tekrar 'let x = x + 1;' diyerek değişkenin tipini veya değerini yeniden tanımlama özelliğidir."
                )
            ),
            completionCriteria = listOf(
                "let ve let mut farkını bilmek",
                "Temel veri tiplerini tanımak"
            )
        ),

        // ==========================================
        // DERS 3: KOŞULLAR VE DÖNGÜLER
        // ==========================================
        Lesson(
            id = "rs_3",
            courseId = "rust",
            sectionId = "rs_sec_1",
            title = "Kararlar (if-else) ve Döngüler (for, while, loop)",
            shortDesc = "if bir ifadedir (değer döndürür!) ve sonsuz döngüler için süper hızlı loop yapısı.",
            level = CourseLevel.BEGINNER,
            order = 3,
            isPremium = false,
            learningObjectives = listOf(
                "if-else ile koşul kontrolü yapmak",
                "if'i tek satırda değişken atamasında kullanmak",
                "loop, while ve for 1..5 döngülerini kurmak"
            ),
            prerequisites = listOf("let ve Değişkenler"),
            subtopics = listOf("if / else", "if ile Değer Döndürme", "for ve Aralıklar (1..5)", "loop ve while"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. if Bir İfadedir!",
                    body = "Rust'ta if sadece bir karar bloğu değil, aynı zamanda geriye değer döndüren bir ifadedir.",
                    codeSnippet = "let yetiskin_mi = true;\nlet durum = if yetiskin_mi { \"Girebilir\" } else { \"Giremez\" };\nprintln!(\"Sonuç: {}\", durum);"
                ),
                LessonContentBlock(
                    subtitle = "2. for Döngüsü ve Aralıklar (Range)",
                    body = "`1..=5` yazarak 1'den 5'e kadar (5 dahil) kolayca döngü kurabiliriz.",
                    codeSnippet = "for sayi in 1..=5 {\n    println!(\"Adım: {}\", sayi);\n}"
                )
            ),
            codeExample = "let mut sayac = 0;\nwhile sayac < 3 {\n    println!(\"Sayı: {}\", sayac);\n    sayac += 1;\n}",
            codeExplanation = "while döngüsü şart doğru olduğu sürece 3 tur çalıştı.",
            realWorldExample = "Oyun döngüleri (Game loop) Rust'ta doğrudan 'loop { ... }' ile kurulur.",
            practicalTask = "1'den 10'a kadar olan sayıları for döngüsüyle yazdırın.",
            starterPlaygroundCode = "for i in 1..=10 {\n    println!(\"{}\", i);\n}",
            miniQuestion = MiniQuestion(
                id = "rs_q_3",
                question = "Rust'ta 1'den 5'e kadar (5 dahil) bir sayı aralığı nasıl yazılır?",
                options = listOf("1..=5", "1..5", "1-5", "[1, 5]"),
                correctIndex = 0,
                explanation = "Bitiş sayısı dahil aralık için '1..=5' yazılır ('1..5' 5'i dahil etmez)."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_rs_3",
                lessonId = "rs_3",
                title = "Pozitif mi?",
                instructions = "sayi 0'dan büyükse true, değilse false döndüren pozitif_mi(sayi) fonksiyonunu yazın.",
                exampleInput = "pozitif_mi(5)",
                exampleOutput = "true",
                starterCode = "fn pozitif_mi(sayi: i32) -> bool {\n    // Kodunu yaz:\n    false\n}",
                solutionCode = "fn pozitif_mi(sayi: i32) -> bool {\n    sayi > 0\n}",
                hints = listOf("sayi > 0 yazın."),
                testCases = listOf(
                    TestCase("pozitif_mi(5)", "true", "Pozitif sayı"),
                    TestCase("pozitif_mi(-2)", "false", "Negatif sayı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "rs_quiz_3_1",
                    lessonId = "rs_3",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Rust'ta sonsuz bir döngü başlatmak için en yalın anahtar kelime hangisidir?",
                    options = listOf("loop", "while true", "forever", "repeat"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Rust'ta sonsuz döngüler için 'loop' kullanılır.",
                    explanationWrong = "loop anahtar kelimesi kullanılır.",
                    reviewTopic = "Rust Döngüler"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "loop döngüsünden break ile değer döndürülebilir mi?",
                    answer = "Evet! 'break sonuc;' diyerek döngünün sonucunu doğrudan bir değişkene atayabilirsiniz."
                )
            ),
            completionCriteria = listOf(
                "if ifadesini değer döndürmede kullanabilmek",
                "for ve 1..=5 aralıklarını kurabilmek"
            )
        ),

        // ==========================================
        // DERS 4: SAHİPLİK (OWNERSHIP)
        // ==========================================
        Lesson(
            id = "rs_4",
            courseId = "rust",
            sectionId = "rs_sec_2",
            title = "Rust'ın Kalbi: Sahiplik (Ownership) ve Taşıma (Move)",
            shortDesc = "Çöp toplayıcı (Garbage Collector) olmadan bellek sızıntısını sıfıra indiren dahi sistem!",
            level = CourseLevel.BEGINNER,
            order = 4,
            isPremium = true,
            learningObjectives = listOf(
                "Rust'ın 3 Altın Sahiplik Kuralını öğrenmek",
                "Değerlerin taşınması (Move semantiği) mantığını kavramak",
                "Copy ve Clone arasındaki farkı anlamak"
            ),
            prerequisites = listOf("Değişkenler ve Döngüler"),
            subtopics = listOf("Sahiplik Kuralları", "Move (Taşıma)", "Clone ile Kopyalama"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Sahiplik (Ownership) Nedir?",
                    body = "Elinizde bir kitap olduğunu düşünün. Kitabı arkadaşınıza verdiğinizde (Move) artık kitap sizde değil, ondadır! Siz okuyamazsınız.\n\n**Rust'ın 3 Kuralı:**\n1. Her değerin tek bir 'sahibi' olan değişkeni vardır.\n2. Aynı anda sadece BİR sahip olabilir.\n3. Sahip kapsamdan ({ }) çıktığında bellek otomatik silinir."
                ),
                LessonContentBlock(
                    subtitle = "2. Taşıma (Move) Örneği",
                    body = "String tipi Heap'te yer tuttuğu için başka bir değişkene atandığında taşınır.",
                    codeSnippet = "let s1 = String::from(\"Merhaba\");\nlet s2 = s1; // Sahiplik s2'ye GEÇTİ (Move)!\n\n// println!(\"{}\", s1); -> HATA VERİR! s1 artık boş.\nprintln!(\"{}\", s2); // Sorunsuz çalışır."
                )
            ),
            codeExample = "let s1 = String::from(\"Rust\");\nlet s2 = s1.clone(); // Klonlayarak ikisinde de tutabiliriz\nprintln!(\"s1: {}, s2: {}\", s1, s2);",
            codeExplanation = "clone() ile verinin tam bir kopyası oluşturuldu.",
            realWorldExample = "Bir banka hesabından para transferi yaptığınızda paranın eski hesapta yok olup yeni hesaba geçmesi (Move) gibi.",
            practicalTask = "String::from() ile bir metin oluşturup sahipliğini inceleyin.",
            starterPlaygroundCode = "let s = String::from(\"Kitap\");",
            miniQuestion = MiniQuestion(
                id = "rs_q_4",
                question = "Rust'ta bir String değişkeni başka bir değişkene atandığında (let s2 = s1;) orijinal s1 değişkenine ne olur?",
                options = listOf("Sahipliği devreder (Move) ve s1 artık geçersiz hale gelir", "İki değişken de belleği ortak kullanır", "s1 klonlanır", "Program çöker"),
                correctIndex = 0,
                explanation = "Rust'ta Heap verileri atanırken taşınır (Move); s1 geçersiz olur."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_rs_4",
                lessonId = "rs_4",
                title = "Metin Klonlayıcı",
                instructions = "Gelen String'i klonlayıp aynısını döndüren metin_kopyala(s) fonksiyonunu yazın.",
                exampleInput = "metin_kopyala(String::from(\"A\"))",
                exampleOutput = "\"A\"",
                starterCode = "fn metin_kopyala(s: &String) -> String {\n    // Kodunu yaz:\n    String::new()\n}",
                solutionCode = "fn metin_kopyala(s: &String) -> String {\n    s.clone()\n}",
                hints = listOf("s.clone() yazın."),
                testCases = listOf(
                    TestCase("metin_kopyala(&String::from(\"Rust\"))", "Rust", "Klon testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "rs_quiz_4_1",
                    lessonId = "rs_4",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Rust'ta bir değişkenin etki alanı (Scope) bittiğinde belleğinin otomatik serbest bırakılmasını sağlayan mekanizmanın adı nedir?",
                    options = listOf("drop", "garbage collector", "free", "delete"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Kapsam bitince Rust otomatik 'drop' fonksiyonunu çağırır.",
                    explanationWrong = "drop fonksiyonu çağrılır.",
                    reviewTopic = "Rust Sahiplik"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "i32 sayıları neden Move olmuyor da kopyalanıyor?",
                    answer = "Küçük ilkel tipler (i32, bool) Stack'te tutulduğu için 'Copy' niteliğine sahiptir ve otomatik kopyalanır."
                )
            ),
            completionCriteria = listOf(
                "Sahiplik (Ownership) 3 kuralını bilmek",
                "Move ve Clone farkını kavramak"
            )
        ),

        // ==========================================
        // DERS 5: ÖDÜNÇ ALMA (BORROWING & REFERANSLAR)
        // ==========================================
        Lesson(
            id = "rs_5",
            courseId = "rust",
            sectionId = "rs_sec_2",
            title = "Ödünç Alma (Borrowing): & ve &mut Referansları",
            shortDesc = "Sahipliği tamamen devretmek yerine sadece ödünç verip (&) geri alma sanatı.",
            level = CourseLevel.BEGINNER,
            order = 5,
            isPremium = true,
            learningObjectives = listOf(
                "& işareti ile salt okunur ödünç almak (Immutable Reference)",
                "&mut ile değiştirilebilir ödünç almak (Mutable Reference)",
                "Aynı anda birden fazla &mut yapılamayacağını (Veri Yarışı Güvenliği) öğrenmek"
            ),
            prerequisites = listOf("Sahiplik (Ownership)"),
            subtopics = listOf("& Referans", "&mut Değiştirilebilir Referans", "Borrow Checker"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Kitabı Ödünç Vermek (&)",
                    body = "Kitabın mülkiyetini arkadaşınıza vermek istemiyorsunuz, sadece 'Bak, oku ama geri ver' diyorsunuz. İşte buna `&` (Referans / Borrowing) denir!",
                    codeSnippet = "fn uzunluk(metin: &String) -> usize {\n    metin.len() // Sadece okur, sahiplik almaz\n}\n\nfn main() {\n    let s = String::from(\"Kod Akademi\");\n    let boy = uzunluk(&s); // & ile ödünç verdik\n    println!(\"'{}' metni {} harflidir.\", s, boy); // s HALA BİZİM!\n}"
                )
            ),
            codeExample = "fn ekleme_yap(s: &mut String) {\n    s.push_str(\" Dünyası\");\n}\n\nfn main() {\n    let mut s = String::from(\"Rust\");\n    ekleme_yap(&mut s);\n    println!(\"{}\", s); // \"Rust Dünyası\"\n}",
            codeExplanation = "&mut ile metin ödünç alınıp değiştirildi.",
            realWorldExample = "Bir dokümanı başkasına 'Sadece Görüntüle' linkiyle (&) veya 'Düzenle' yetkisiyle (&mut) paylaşmak gibi.",
            practicalTask = "&String parametresi alan bir fonksiyon yazın.",
            starterPlaygroundCode = "fn yaz(s: &String) { println!(\"{}\", s); }",
            miniQuestion = MiniQuestion(
                id = "rs_q_5",
                question = "Rust'ta bir veriyi değiştirmek üzere ödünç vermek için tipin önüne ne yazılır?",
                options = listOf("&mut", "&", "*mut", "ref"),
                correctIndex = 0,
                explanation = "Değiştirilebilir ödünç alma için '&mut' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_rs_5",
                lessonId = "rs_5",
                title = "Karakter Sayıcı",
                instructions = "Ödünç olarak &String alan ve karakter sayısını (s.len() as i32) döndüren harf_sayisi(s) fonksiyonunu yazın.",
                exampleInput = "harf_sayisi(&String::from(\"Elma\"))",
                exampleOutput = "4",
                starterCode = "fn harf_sayisi(s: &String) -> i32 {\n    // Kodunu yaz:\n    0\n}",
                solutionCode = "fn harf_sayisi(s: &String) -> i32 {\n    s.len() as i32\n}",
                hints = listOf("s.len() as i32 yazın."),
                testCases = listOf(
                    TestCase("harf_sayisi(&String::from(\"Elma\"))", "4", "Karakter sayısı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "rs_quiz_5_1",
                    lessonId = "rs_5",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Rust'ın 'Borrow Checker' kurallarına göre aynı anda aynı veriye kaç tane &mut (değiştirilebilir referans) oluşturulabilir?",
                    options = listOf("Sadece 1 tane", "Sonsuz sayıda", "En fazla 5", "Hiç oluşturulamaz"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Veri yarışlarını (Data Race) engellemek için aynı anda sadece 1 &mut olabilir.",
                    explanationWrong = "Aynı anda sadece 1 &mut referans olabilir.",
                    reviewTopic = "Rust Borrow Checker"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Aynı anda hem & hem &mut olabilir mi?",
                    answer = "Hayır! Biri okurken diğeri veriyi değiştiremez. Bu kural tüm concurrency bug'larını çözer."
                )
            ),
            completionCriteria = listOf(
                "& ve &mut kullanımını bilmek",
                "Ödünç alma kurallarını kavramak"
            )
        ),

        // ==========================================
        // DERS 6: YAPILAR (STRUCT) VE METOTLAR (IMPL)
        // ==========================================
        Lesson(
            id = "rs_6",
            courseId = "rust",
            sectionId = "rs_sec_3",
            title = "Yapılar (struct) ve Metotlar (impl)",
            shortDesc = "Kendi veri tiplerinizi üretin ve 'impl' blokları ile nesnelere özel metotlar (&self) tanımlayın.",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true,
            learningObjectives = listOf(
                "struct tanımlayarak ilişkili alanları birleştirmek",
                "impl bloğu içinde &self ile metotlar yazmak",
                "Sınıf kurucusu (Constructor / new) desenini öğrenmek"
            ),
            prerequisites = listOf("Sahiplik ve Referanslar"),
            subtopics = listOf("struct Tanımlama", "impl Blokları", "&self Metotları"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. struct ve impl Ayrımı",
                    body = "Rust'ta veriler `struct` ile tanımlanır, bu verilere ait davranışlar/fonksiyonlar ise `impl` (implementation) bloğuna yazılır.",
                    codeSnippet = "struct Oyuncu {\n    isim: String,\n    can: i32,\n}\n\nimpl Oyuncu {\n    fn yeni(isim: &str) -> Oyuncu {\n        Oyuncu { isim: isim.to_string(), can: 100 }\n    }\n    \n    fn vuruldu_mu(&self) {\n        println!(\"{} hayatta, kalan can: {}\", self.isim, self.can);\n    }\n}"
                )
            ),
            codeExample = "let p = Oyuncu::yeni(\"Ejder\");\np.vuruldu_mu();",
            codeExplanation = "Oyuncu nesnesi oluşturuldu ve metodu çağrıldı.",
            realWorldExample = "Oyun içi karakterler, e-ticaret sipariş fişleri struct ile modellenir.",
            practicalTask = "Dikdortgen adında bir struct açıp alan() metodunu yazın.",
            starterPlaygroundCode = "struct Dikdortgen { en: u32, boy: u32 }",
            miniQuestion = MiniQuestion(
                id = "rs_q_6",
                question = "Rust'ta bir struct'a ait metotların içine yazıldığı blok hangisidir?",
                options = listOf("impl", "class", "methods", "trait"),
                correctIndex = 0,
                explanation = "Metotlar 'impl' (implementation) bloğu içine yazılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_rs_6",
                lessonId = "rs_6",
                title = "Kare Alanı",
                instructions = "kenar alanına sahip Kare struct'ını ve impl Kare içinde alan(&self) -> i32 metodunu yazın.",
                exampleInput = "let k = Kare { kenar: 5 }; k.alan()",
                exampleOutput = "25",
                starterCode = "struct Kare {\n    kenar: i32,\n}\n\nimpl Kare {\n    // alan(&self) metodunu yaz:\n}",
                solutionCode = "struct Kare {\n    kenar: i32,\n}\n\nimpl Kare {\n    fn alan(&self) -> i32 {\n        self.kenar * self.kenar\n    }\n}",
                hints = listOf("fn alan(&self) -> i32 { self.kenar * self.kenar } yazın."),
                testCases = listOf(
                    TestCase("Kare { kenar: 5 }.alan()", "25", "Kare alanı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "rs_quiz_6_1",
                    lessonId = "rs_6",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir metodun struct içindeki alanları sadece okuması için parametresine ne yazılır?",
                    options = listOf("&self", "self", "&mut self", "this"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Salt-okunur erişim için '&self' kullanılır.",
                    explanationWrong = "&self kullanılır.",
                    reviewTopic = "Rust Struct & Impl"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "&mut self ne zaman kullanılır?",
                    answer = "Metot struct'ın içindeki bir alanı değiştirecekse (örn: canını azaltacaksa) &mut self yazılır."
                )
            ),
            completionCriteria = listOf(
                "struct ve impl tanımlayabilmek",
                "&self ile metot çağırabilmek"
            )
        ),

        // ==========================================
        // DERS 7: ENUM VE MATCH KALIBI
        // ==========================================
        Lesson(
            id = "rs_7",
            courseId = "rust",
            sectionId = "rs_sec_4",
            title = "Enumlar ve Süper Güç: match Kalıbı",
            shortDesc = "İçinde veri taşıyabilen süper enumlar ve her ihtimali eksiksiz denetleyen match yapısı.",
            level = CourseLevel.INTERMEDIATE,
            order = 7,
            isPremium = true,
            learningObjectives = listOf(
                "Rust'ta Enum'ların içine veri koyabilmek",
                "match ifadesi ile tüm durumları eksiksiz kontrol etmek",
                "_ (joker) deseni ile varsayılan durum belirlemek"
            ),
            prerequisites = listOf("struct ve impl"),
            subtopics = listOf("Verili Enumlar", "match İfadesi", "_ Joker Kalıbı"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. match: Süper Switch",
                    body = "Rust'ın `match` ifadesi o kadar akıllıdır ki, bir tek ihtimali bile atlarsanız kod derlenmez! Bu sayede sürpriz hatalar asla yaşanmaz.",
                    codeSnippet = "enum Yon {\n    Kuzey,\n    Guney,\n    Dogu,\n    Bati,\n}\n\nlet secim = Yon::Kuzey;\n\nmatch secim {\n    Yon::Kuzey => println!(\"Yukarı gidiliyor ⬆️\"),\n    Yon::Guney => println!(\"Aşağı gidiliyor ⬇️\"),\n    _ => println!(\"Yana gidiliyor ➡️\"),\n}"
                )
            ),
            codeExample = "enum Mesaj {\n    Yazi(String),\n    Konum(i32, i32),\n}",
            codeExplanation = "Enum farklı tiplerde veri taşıyabilen süper bir yapıya dönüştürüldü.",
            realWorldExample = "Ağ paketleri veya kullanıcı tıklama olayları enum ve match ile ayrıştırılır.",
            practicalTask = "Basit bir TrafikIsigi enum'ı ve match bloğu tasarlayın.",
            starterPlaygroundCode = "enum Isik { Kirmizi, Sari, Yesil }",
            miniQuestion = MiniQuestion(
                id = "rs_q_7",
                question = "Rust'ta match bloğunda kalan tüm diğer durumları yakalamak için hangi joker karakter kullanılır?",
                options = listOf("_ (Alt Çizgi)", "*", "default", "else"),
                correctIndex = 0,
                explanation = "Kalan diğer durumlar için '_' (underscore) kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_rs_7",
                lessonId = "rs_7",
                title = "Yön Mesajı",
                instructions = "yon (1: Kuzey, 2: Güney, diğer: Bilinmiyor) tam sayısını alıp match ile yön metnini döndüren yon_metni(yon) fonksiyonunu yazın.",
                exampleInput = "yon_metni(1)",
                exampleOutput = "\"Kuzey\"",
                starterCode = "fn yon_metni(yon: i32) -> &'static str {\n    // Kodunu yaz:\n    \"\"\n}",
                solutionCode = "fn yon_metni(yon: i32) -> &'static str {\n    match yon {\n        1 => \"Kuzey\",\n        2 => \"Güney\",\n        _ => \"Bilinmiyor\",\n    }\n}",
                hints = listOf("match yon { 1 => \"Kuzey\", 2 => \"Güney\", _ => \"Bilinmiyor\" } yazın."),
                testCases = listOf(
                    TestCase("yon_metni(1)", "Kuzey", "Kuzey yönü"),
                    TestCase("yon_metni(9)", "Bilinmiyor", "Bilinmeyen yön")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "rs_quiz_7_1",
                    lessonId = "rs_7",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Rust'ta match ifadesinin tüm olası durumları (Exhaustive) kapsaması zorunlu mudur?",
                    options = listOf("Evet, zorunludur! Bir durum bile atlanırsa derleyici hata verir", "Hayır, isteğe bağlıdır", "Sadece sayılarda zorunludur", "Yalnızca testlerde zorunludur"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Match her durumu kapsamak zorundadır; bu Rust'ın güvenlik garantisidir.",
                    explanationWrong = "Evet, tüm durumları kapsamak zorunludur.",
                    reviewTopic = "Rust Match"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "if let nedir?",
                    answer = "Sadece tek bir durumu kontrol edip diğerlerini umursamadığınızda match yerine yazılan kısa sözdizimidir."
                )
            ),
            completionCriteria = listOf(
                "Enum tanımlayabilmek",
                "match ile durumları eşleyebilmek"
            )
        ),

        // ==========================================
        // DERS 8: NULL DEĞER YOK (OPTION<T>)
        // ==========================================
        Lesson(
            id = "rs_8",
            courseId = "rust",
            sectionId = "rs_sec_4",
            title = "Null Değer Yok!: Option<T> (Some ve None)",
            shortDesc = "Milyar dolarlık NullPointer hatasını tarihe gömen hediye paketi felsefesi.",
            level = CourseLevel.INTERMEDIATE,
            order = 8,
            isPremium = true,
            learningObjectives = listOf(
                "Rust'ta neden 'null' olmadığını anlamak",
                "Option<T> ile Some(değer) ve None (boş) durumlarını yönetmek",
                "unwrap() ve unwrap_or() ile kutuyu güvenle açmak"
            ),
            prerequisites = listOf("Enumlar ve match"),
            subtopics = listOf("Null Neden Yok?", "Some ve None", "unwrap_or()"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Hediye Paketi Mantığı: Option",
                    body = "Bir fonksiyondan sonuç çıkmayabilir (Örn: Arama sonucunda kullanıcı bulunamayabilir). Diğer dillerde `null` dönüp programı çökertmek yerine Rust size kapalı bir hediye kutusu (`Option`) verir:\n\n• `Some(deger)`: Kutunun içinde hediye var!\n• `None`: Kutu boş çıktı."
                ),
                LessonContentBlock(
                    subtitle = "2. Kutuyu Açmak",
                    body = "Kutuyu match ile kontrol edebilir veya varsayılan değerle açabilirsiniz.",
                    codeSnippet = "let isim: Option<&str> = Some(\"Zeynep\");\nlet bos: Option<&str> = None;\n\nprintln!(\"İsim: {}\", isim.unwrap_or(\"Misafir\")); // Zeynep\nprintln!(\"İsim: {}\", bos.unwrap_or(\"Misafir\"));  // Misafir"
                )
            ),
            codeExample = "fn ikiye_bol(sayi: i32) -> Option<i32> {\n    if sayi % 2 == 0 { Some(sayi / 2) } else { None }\n}",
            codeExplanation = "Tek sayılarda None, çift sayılarda Some döner.",
            realWorldExample = "Veritabanından kullanıcı çekerken kullanıcı bulunamazsa None döner ve program asla çökmez.",
            practicalTask = "Option dönen bir fonksiyonu unwrap_or ile kullanın.",
            starterPlaygroundCode = "let x: Option<i32> = Some(10); println!(\"{}\", x.unwrap_or(0));",
            miniQuestion = MiniQuestion(
                id = "rs_q_8",
                question = "Rust'ta bir değerin 'var' veya 'yok' olduğunu ifade eden standart Option enum'ının iki kolu hangileridir?",
                options = listOf("Some ve None", "Ok ve Err", "True ve False", "Valid ve Null"),
                correctIndex = 0,
                explanation = "Option enum'ı 'Some' ve 'None' kollarına sahiptir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_rs_8",
                lessonId = "rs_8",
                title = "Güvenli Değer Okuyucu",
                instructions = "Gelen Option<i32> kutusu doluysa içindeki sayıyı, boşsa 0 döndüren guvenli_oku(kutu) fonksiyonunu yazın.",
                exampleInput = "guvenli_oku(Some(42))",
                exampleOutput = "42",
                starterCode = "fn guvenli_oku(kutu: Option<i32>) -> i32 {\n    // Kodunu yaz:\n    0\n}",
                solutionCode = "fn guvenli_oku(kutu: Option<i32>) -> i32 {\n    kutu.unwrap_or(0)\n}",
                hints = listOf("kutu.unwrap_or(0) yazın."),
                testCases = listOf(
                    TestCase("guvenli_oku(Some(42))", "42", "Dolu kutu"),
                    TestCase("guvenli_oku(None)", "0", "Boş kutu")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "rs_quiz_8_1",
                    lessonId = "rs_8",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir Option değişkeni None iken doğrudan .unwrap() çağrılırsa ne olur?",
                    options = listOf("Program panic! vererek anında durur (Crash)", "0 döner", "None döner", "Sessizce geçer"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! None iken unwrap() panic oluşturur; bu yüzden unwrap_or veya match tercih edilir.",
                    explanationWrong = "Program panic verir.",
                    reviewTopic = "Rust Option"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Neden null yerine Option?",
                    answer = "Çünkü derleyici sizi 'bu değer boş olabilir, kontrol et!' diye zorlar; böylece çalışma anında NullPointerException almak imkansızdır."
                )
            ),
            completionCriteria = listOf(
                "Option, Some ve None mantığını bilmek",
                "unwrap_or() kullanabilmek"
            )
        ),

        // ==========================================
        // DERS 9: HATA YÖNETİMİ (RESULT<T, E> VE '?')
        // ==========================================
        Lesson(
            id = "rs_9",
            courseId = "rust",
            sectionId = "rs_sec_4",
            title = "Hata Yönetimi: Result<T, E> ve Sihirli '?' İşareti",
            shortDesc = "İşlemlerin başarılı (Ok) veya hatalı (Err) sonuçlanması ve tek satırlık '?' operatörü.",
            level = CourseLevel.ADVANCED,
            order = 9,
            isPremium = true,
            learningObjectives = listOf(
                "Result<T, E> ile Ok(sonuc) ve Err(hata) döndürmek",
                "Hataları yukarı fırlatan sihirli '?' operatörünü öğrenmek",
                "panic! makrosu ne zaman kullanılır bilmek"
            ),
            prerequisites = listOf("Option ve match"),
            subtopics = listOf("Result Enum'ı (Ok / Err)", "'?' Operatörü", "panic!"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Result: Başarılı mı Hatalı mı?",
                    body = "Dosya okuma, internete bağlanma gibi işlemler hata verebilir. Rust'ta bu fonksiyonlar `Result<T, E>` döndürür:\n\n• `Ok(veri)`: İşlem başarılı oldu, veri burada!\n• `Err(hata)`: İşlem başarısız, hata sebebi bu."
                ),
                LessonContentBlock(
                    subtitle = "2. Sihirli '?' İşareti",
                    body = "Fonksiyonun sonuna `?` koyarsanız; işlem başarılıysa veriyi çıkarır, hataysa fonksiyonu hemen sonlandırıp hatayı yukarı iletir.",
                    codeSnippet = "fn bol(a: f64, b: f64) -> Result<f64, String> {\n    if b == 0.0 {\n        Err(String::from(\"Sıfıra bölünemez!\"))\n    } else {\n        Ok(a / b)\n    }\n}"
                )
            ),
            codeExample = "match bol(10.0, 2.0) {\n    Ok(sonuc) => println!(\"Sonuç: {}\", sonuc),\n    Err(hata) => println!(\"Hata: {}\", hata),\n}",
            codeExplanation = "Result match ile kontrol edildi.",
            realWorldExample = "İnternetten veri indirirken bağlantı koptuğunda Err döndürülür.",
            practicalTask = "Result döndüren bir bölme fonksiyonunu inceleyin.",
            starterPlaygroundCode = "let r: Result<i32, &str> = Ok(100);",
            miniQuestion = MiniQuestion(
                id = "rs_q_9",
                question = "Rust'ta Result döndüren bir fonksiyon çağrısının sonuna '?' konduğunda ne olur?",
                options = listOf("Ok ise içindeki veriyi açar, Err ise fonksiyonu durdurup hatayı yukarı fırlatır", "Kodu yorum satırı yapar", "Rastgele sayı üretir", "Ekrana basar"),
                correctIndex = 0,
                explanation = "'?' operatörü hataları yukarı iletmenin en temiz yoludur."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_rs_9",
                lessonId = "rs_9",
                title = "Pozitif Sayı Kontrolü",
                instructions = "sayi >= 0 ise Ok(sayi), negatifse Err(\"Negatif\") döndüren kontrol_et(sayi) fonksiyonunu yazın.",
                exampleInput = "kontrol_et(5)",
                exampleOutput = "Ok(5)",
                starterCode = "fn kontrol_et(sayi: i32) -> Result<i32, &'static str> {\n    // Kodunu yaz:\n    Ok(0)\n}",
                solutionCode = "fn kontrol_et(sayi: i32) -> Result<i32, &'static str> {\n    if sayi >= 0 { Ok(sayi) } else { Err(\"Negatif\") }\n}",
                hints = listOf("if sayi >= 0 { Ok(sayi) } else { Err(\"Negatif\") } yazın."),
                testCases = listOf(
                    TestCase("kontrol_et(5)", "Ok(5)", "Pozitif"),
                    TestCase("kontrol_et(-3)", "Err(\"Negatif\")", "Negatif")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "rs_quiz_9_1",
                    lessonId = "rs_9",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Rust'ta telafi edilemeyecek ölümcül bir durumda programı anında durdurmak için hangi makro çağrılır?",
                    options = listOf("panic!(\"Mesaj\")", "stop!()", "exit()", "abort()"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Ölümcül hatalar için panic! kullanılır.",
                    explanationWrong = "panic! makrosu çağrılır.",
                    reviewTopic = "Rust Hata Yönetimi"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Option ile Result farkı nedir?",
                    answer = "Option 'var ya da yok' (Some/None) durumları içindir. Result ise 'başarılı mı yoksa hangi hatayla başarısız oldu' (Ok/Err) durumları içindir."
                )
            ),
            completionCriteria = listOf(
                "Result, Ok ve Err kullanımını bilmek",
                "'?' hata operatörünü anlamak"
            )
        ),

        // ==========================================
        // DERS 10: NİTELİKLER (TRAITS)
        // ==========================================
        Lesson(
            id = "rs_10",
            courseId = "rust",
            sectionId = "rs_sec_5",
            title = "Nitelikler (Traits): Rust'ın Arayüzleri",
            shortDesc = "Farklı türdeki yapılara ortak süper güçler ve yetenekler kazandıran Trait mimarisi.",
            level = CourseLevel.ADVANCED,
            order = 10,
            isPremium = true,
            learningObjectives = listOf(
                "trait ile ortak metot imzaları tanımlamak",
                "impl Trait for Struct ile arayüzü uygulamak",
                "Hazır türetilen nitelikleri (#[derive(Debug, Clone)]) öğrenmek"
            ),
            prerequisites = listOf("struct ve impl"),
            subtopics = listOf("Trait Tanımlama", "Trait Uygulama", "#[derive(Debug)]"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Trait: Ortak Yetenek",
                    body = "Bir `Kopek` ve bir `Robot` çok farklıdır ama ikisi de `ses_cikar()` yeteneğine sahip olabilir. İşte bu ortak yeteneği `trait` ile tanımlarız.",
                    codeSnippet = "trait Sesli {\n    fn ses_cikar(&self) -> String;\n}\n\nstruct Kopek;\nimpl Sesli for Kopek {\n    fn ses_cikar(&self) -> String {\n        \"Hav hav! 🐶\".to_string()\n    }\n}"
                )
            ),
            codeExample = "#[derive(Debug)]\nstruct Oyuncu { isim: String }\n\n// {:?} ile ekrana kolayca basılabilir:\nlet p = Oyuncu { isim: \"Alp\".to_string() };\nprintln!(\"{:?}\", p);",
            codeExplanation = "#[derive(Debug)] ile tek satırda yazdırma yeteneği eklendi.",
            realWorldExample = "Ödeme sistemlerinde KrediKarti ve Kripto cüzdanının her ikisine de 'Ode' Trait'i uygulanır.",
            practicalTask = "#[derive(Debug)] içeren bir struct tanımlayın.",
            starterPlaygroundCode = "#[derive(Debug)]\nstruct Nokta { x: i32, y: i32 }",
            miniQuestion = MiniQuestion(
                id = "rs_q_10",
                question = "Rust'ta bir struct'ı println!(\"{:?}\", nesne) şeklinde hata ayıklama modunda yazdırabilmek için üstüne hangi nitelik eklenir?",
                options = listOf("#[derive(Debug)]", "#[derive(Print)]", "#[derive(Display)]", "#[derive(Show)]"),
                correctIndex = 0,
                explanation = "Hata ayıklama çıktısı için '#[derive(Debug)]' eklenir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_rs_10",
                lessonId = "rs_10",
                title = "Konuşan Nesne",
                instructions = "fn konus(&self) -> &'static str imzasına sahip Konusabilir trait'ini ve bunu uygulayan Kedi struct'ını yazın (konus 'Miyav' döndürsün).",
                exampleInput = "Kedi.konus()",
                exampleOutput = "\"Miyav\"",
                starterCode = "trait Konusabilir {\n    fn konus(&self) -> &'static str;\n}\n\nstruct Kedi;\n// impl Konusabilir for Kedi yaz:\n",
                solutionCode = "trait Konusabilir {\n    fn konus(&self) -> &'static str;\n}\n\nstruct Kedi;\n\nimpl Konusabilir for Kedi {\n    fn konus(&self) -> &'static str {\n        \"Miyav\"\n    }\n}",
                hints = listOf("impl Konusabilir for Kedi { fn konus(&self) -> &'static str { \"Miyav\" } } yazın."),
                testCases = listOf(
                    TestCase("Kedi.konus()", "Miyav", "Kedi konuşması")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "rs_quiz_10_1",
                    lessonId = "rs_10",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Rust'ta nesne yönelimli dillerdeki 'Interface' kavramının karşılığı hangisidir?",
                    options = listOf("Trait", "Struct", "Enum", "Module"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Interface karşılığı Trait'tir.",
                    explanationWrong = "Trait kullanılır.",
                    reviewTopic = "Rust Traits"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Varsayılan (Default) Trait metodu yazılabilir mi?",
                    answer = "Evet! Trait içinde metoda gövde yazarsanız, uygulayan sınıflar isterse onu ezer, istemezse varsayılanı kullanır."
                )
            ),
            completionCriteria = listOf(
                "Trait tanımlayıp uygulayabilmek",
                "#[derive(Debug)] kullanımını bilmek"
            )
        ),

        // ==========================================
        // DERS 11: KOLEKSİYONLAR (VEC VE HASHMAP)
        // ==========================================
        Lesson(
            id = "rs_11",
            courseId = "rust",
            sectionId = "rs_sec_5",
            title = "Koleksiyonlar: Vec<T> ve HashMap ile Veri Deposu",
            shortDesc = "Dinamik büyüyen listeler (vec![]) ve anahtar-değer sözlükleri (HashMap).",
            level = CourseLevel.ADVANCED,
            order = 11,
            isPremium = true,
            learningObjectives = listOf(
                "vec![1, 2, 3] makrosu ile dinamik liste oluşturmak",
                "push() ve pop() ile liste yönetmek",
                "HashMap ile sözlük (Key-Value) veri saklamak"
            ),
            prerequisites = listOf("Traits ve Option"),
            subtopics = listOf("Vec<T> ve vec![]", "HashMap", "İteratörler"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Vec<T> ve HashMap",
                    body = "Listeler için `Vec<T>`, sözlükler için `HashMap` kullanırız.",
                    codeSnippet = "use std::collections::HashMap;\n\n// 1. Liste:\nlet mut sayilar = vec![10, 20, 30];\nsayilar.push(40);\n\n// 2. Sözlük:\nlet mut puanlar = HashMap::new();\npuanlar.insert(\"Ahmet\", 95);\npuanlar.insert(\"Ayşe\", 100);"
                )
            ),
            codeExample = "let v = vec![1, 2, 3];\nlet toplam: i32 = v.iter().sum();\nprintln!(\"Toplam: {}\", toplam); // 6",
            codeExplanation = "İteratör ile listedeki elemanlar toplandı.",
            realWorldExample = "E-ticaret sepetindeki ürünler Vec içinde, kullanıcı profil ayarları HashMap içinde tutulur.",
            practicalTask = "vec![] ile 3 meyve içeren liste yapın.",
            starterPlaygroundCode = "let mut liste = vec![\"Elma\", \"Armut\"]; liste.push(\"Muz\");",
            miniQuestion = MiniQuestion(
                id = "rs_q_11",
                question = "Rust'ta hızlıca bir vektör (dinamik liste) tanımlamak için hangi hazır makro kullanılır?",
                options = listOf("vec![]", "list![]", "array![]", "make_vec()"),
                correctIndex = 0,
                explanation = "Vektör oluşturmak için 'vec![]' makrosu kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_rs_11",
                lessonId = "rs_11",
                title = "Vektör Toplamı",
                instructions = "Verilen &[i32] dilimindeki sayıların toplamını hesaplayan liste_toplami(liste) fonksiyonunu yazın.",
                exampleInput = "liste_toplami(&[2, 4, 6])",
                exampleOutput = "12",
                starterCode = "fn liste_toplami(liste: &[i32]) -> i32 {\n    // Kodunu yaz:\n    0\n}",
                solutionCode = "fn liste_toplami(liste: &[i32]) -> i32 {\n    liste.iter().sum()\n}",
                hints = listOf("liste.iter().sum() yazın."),
                testCases = listOf(
                    TestCase("liste_toplami(&[2, 4, 6])", "12", "Toplam testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "rs_quiz_11_1",
                    lessonId = "rs_11",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "HashMap'ten bir eleman okumaya çalıştığınızda (.get(\"anahtar\")) dönen sonuç ne tipindedir?",
                    options = listOf("Option<&V> (Çünkü aranan anahtar bulunamayabilir)", "Doğrudan değer", "String", "Hata"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Anahtar olmayabileceği için Option döner.",
                    explanationWrong = "Option döner.",
                    reviewTopic = "Rust Koleksiyonlar"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Vec ile Dizi ([T; N]) farkı nedir?",
                    answer = "Dizilerin boyutu sabittir, Vec ise çalışma anında büyüyüp küçülebilir."
                )
            ),
            completionCriteria = listOf(
                "vec![] ve HashMap kullanabilmek",
                "İteratörlerle işlem yapabilmek"
            )
        ),

        // ==========================================
        // DERS 12: RUST USTALIĞI VE GELECEK
        // ==========================================
        Lesson(
            id = "rs_12",
            courseId = "rust",
            sectionId = "rs_sec_6",
            title = "Rust Ustalığı: Güvenli Gelecek ve Sistem Dünyası",
            shortDesc = "Linux çekirdeğinden WebAssembly'e (Wasm) uzanan Rust devrimi ve geleceğin mimarisi.",
            level = CourseLevel.EXPERT,
            order = 12,
            isPremium = true,
            learningObjectives = listOf(
                "Rust'ın işletim sistemleri ve WebAssembly'deki yerini kavramak",
                "Korkusuz Eşzamanlılık (Fearless Concurrency) gücünü anlamak",
                "Tebrikler: Artık güvenli ve ultra hızlı Rust kodları yazabilen bir uzmansınız!"
            ),
            prerequisites = listOf("Tüm Rust Konuları"),
            subtopics = listOf("WebAssembly (WASM)", "Fearless Concurrency", "Tebrikler ve Tavsiyeler"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Tebrikler! Rust Yolculuğunu Başarıyla Tamamladınız! 🦀🏆",
                    body = "Artık Sahiplik (Ownership), Ödünç Alma (Borrowing), Option/Result hata yönetimi ve Trait mimarisine tam anlamıyla hakimsiniz.\n\nRust öğrenmek sizi sadece daha iyi bir Rust geliştiricisi yapmaz; bellek yönetimi ve sistem güvenliği konusundaki derin anlayışınızla tüm dillerde çok daha kaliteli kodlar yazmanızı sağlar!"
                )
            ),
            codeExample = "fn main() {\n    println!(\"Rust Uzmanı Oldunuz! Tebrikler! 🦀✨\");\n}",
            codeExplanation = "Rust yolculuğunuz başarıyla tamamlandı.",
            realWorldExample = "Microsoft, Google ve Amazon tüm yeni kritik sistem bileşenlerini Rust ile geliştirmektedir.",
            practicalTask = "Rust başarılarınızı kutlayın!",
            starterPlaygroundCode = "// Harika bir Rust geliştiricisisiniz!",
            miniQuestion = MiniQuestion(
                id = "rs_q_12",
                question = "Rust dilinin eşzamanlı (multi-thread) programlama sloganı hangisidir?",
                options = listOf("Korkusuz Eşzamanlılık (Fearless Concurrency)", "Hızlı Thread", "Otomatik Kilit", "Kolay Paralellik"),
                correctIndex = 0,
                explanation = "Rust'ın derleme anı güvenlik garantisi 'Fearless Concurrency' olarak adlandırılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_rs_12",
                lessonId = "rs_12",
                title = "Şampiyon Rust Mesajı",
                instructions = "Üstünde 'Rust Şampiyonu' yazan String döndüren sampiyon_mesaji() fonksiyonunu yazın.",
                exampleInput = "sampiyon_mesaji()",
                exampleOutput = "\"Rust Şampiyonu\"",
                starterCode = "fn sampiyon_mesaji() -> String {\n    // Kodunu yaz:\n    String::new()\n}",
                solutionCode = "fn sampiyon_mesaji() -> String {\n    String::from(\"Rust Şampiyonu\")\n}",
                hints = listOf("String::from(\"Rust Şampiyonu\") yazın."),
                testCases = listOf(
                    TestCase("sampiyon_mesaji()", "Rust Şampiyonu", "Şampiyon testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "rs_quiz_12_1",
                    lessonId = "rs_12",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Rust kodlarını tarayıcı içinde neredeyse yerel hızda çalıştırmayı sağlayan teknoloji hangisidir?",
                    options = listOf("WebAssembly (Wasm)", "JavaScript", "HTML5", "CSS3"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Rust WebAssembly (Wasm) için bir numaralı dildir.",
                    explanationWrong = "WebAssembly (Wasm) teknolojisidir.",
                    reviewTopic = "Rust & WebAssembly"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Rust ile web sunucusu yazılabilir mi?",
                    answer = "Evet! Axum ve Actix-Web gibi dünyanın en hızlı ve en hafif web çatıları Rust ile yazılmıştır."
                )
            ),
            completionCriteria = listOf(
                "Rust felsefesini tam kavramak",
                "Güvenli ve yüksek performanslı uygulamalar geliştirebilmek"
            )
        )
    )
}
