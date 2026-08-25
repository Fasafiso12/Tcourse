package com.example.data.catalog

import com.example.model.*

/**
 * Rust Complete Official Curriculum (12 Sequential Lessons):
 * BEGINNER -> FUNDAMENTAL -> INTERMEDIATE -> ADVANCED -> EXPERT
 * Seamless progression from basic syntax & Ownership to Lifetimes, Concurrency (Arc/Mutex) & Unsafe Rust/FFI.
 */
object RustCurriculum {

    fun getSections(): List<CourseSection> = listOf(
        CourseSection(
            id = "rs_sec_1",
            courseId = "rust",
            title = "Seviye 1 – Rust Temelleri, Sözdizimi & Kontrol Akışı",
            level = CourseLevel.BEGINNER,
            order = 1,
            description = "Rust felsefesi, Cargo, let vs let mut değişmezlik ilkesi, ilkel tipler, if/else ifadeleri ve loop, while, for döngüleri.",
            learningObjectives = listOf("Rust derleme ve güvenlik modeli", "let vs let mut değişmezlik kuralı", "Temel ilkel tipler ve gölgelenme (shadowing)", "loop, while, for ve range aralıkları"),
            prerequisites = listOf("Temel bilgisayar kullanım bilgisi")
        ),
        CourseSection(
            id = "rs_sec_2",
            courseId = "rust",
            title = "Seviye 2 – Rust'ın Kalbi: Sahiplik (Ownership) & Ödünç Alma (Borrowing)",
            level = CourseLevel.BEGINNER,
            order = 2,
            description = "Ownership (Sahiplik) sistemi, Move semantiği, Copy vs Clone, Referanslar (&, &mut) ve Borç Denetleyicisi (Borrow Checker) kuralları.",
            learningObjectives = listOf("Ownership (Sahiplik) mekanizması", "Move vs Copy semantiği", "&T (değişmez) ve &mut T (değiştirilebilir) referanslar", "Data race ve çakışma kuralları"),
            prerequisites = listOf("Rust Temelleri ve Kontrol Akışı")
        ),
        CourseSection(
            id = "rs_sec_3",
            courseId = "rust",
            title = "Seviye 3 – Dilimler (Slices), Yapılar (Structs) & Koleksiyonlar",
            level = CourseLevel.INTERMEDIATE,
            order = 3,
            description = "Dilimler (&str, &[T]), String vs &str farkı, Vec<T>, HashMap, Structs ve impl blokları ile metot (&self, &mut self) yazımı.",
            learningObjectives = listOf("String vs &str bellek farkı", "Vec<T> ve HashMap veri yapıları", "Struct tanımlama ve impl blokları", "&self ve &mut self metot tasarımları"),
            prerequisites = listOf("Rust Sahiplik ve Ödünç Alma")
        ),
        CourseSection(
            id = "rs_sec_4",
            courseId = "rust",
            title = "Seviye 4 – Enums, Pattern Matching & Hata Yönetimi (Result/Option)",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            description = "Gelişmiş Enum yapıları, match ile kapsamlı örüntü eşleme, if let, Option<T>, Result<T, E> ve hata fırlatma (? operatörü).",
            learningObjectives = listOf("Veri taşıyan Enum yapıları", "match ile örüntü eşleme (pattern matching)", "Option<T> ile null'sız programlama", "Result<T, E> ve '?' hata yayma operatörü"),
            prerequisites = listOf("Rust Structs ve Koleksiyonlar")
        ),
        CourseSection(
            id = "rs_sec_5",
            courseId = "rust",
            title = "Seviye 5 – Nitelikler (Traits), Yaşam Süreleri (Lifetimes) & Kapanışlar (Closures)",
            level = CourseLevel.ADVANCED,
            order = 5,
            description = "Traits (Arayüzler), Trait Bounds, dyn vs impl Trait, Yaşam Süreleri ('a Lifetimes), Borrow Checker derinlikleri ve Closures (Fn, FnMut, FnOnce).",
            learningObjectives = listOf("Trait tanımlama ve Trait Bounds", "Monomorphism (impl Trait) vs Dinamik Dağıtım (dyn Trait)", "Lifetimes ('a) sözdizimi ve borç ömrü", "Closures ve Iterator adaptörleri"),
            prerequisites = listOf("Rust Enums ve Hata Yönetimi")
        ),
        CourseSection(
            id = "rs_sec_6",
            courseId = "rust",
            title = "Seviye 6 – Eşzamanlılık (Arc/Mutex), Unsafe Rust & Makrolar",
            level = CourseLevel.EXPERT,
            order = 6,
            description = "Korkusuz Eşzamanlılık (Fearless Concurrency): thread::spawn, Kanallar (mpsc), Arc<Mutex<T>>, Send/Sync traitleri, Unsafe Rust (*const/*mut) ve Makrolar.",
            learningObjectives = listOf("thread::spawn ve mpsc mesaj kuyrukları", "Arc<Mutex<T>> ile paylaşımlı durum yönetimi", "Send ve Sync trait kuralları", "Unsafe Rust ve ham işaretçiler (*const T, *mut T)"),
            prerequisites = listOf("Rust Traits, Lifetimes ve Closures")
        )
    )

    fun getLessons(): List<Lesson> = listOf(
        // ==========================================
        // DERS 1: TEMEL SÖZDİZİMİ, LET/MUT & DEĞİŞMEZLİK (ÜCRETSİZ)
        // ==========================================
        Lesson(
            id = "rs_1",
            courseId = "rust",
            sectionId = "rs_sec_1",
            title = "Rust'a Giriş, Değişkenler & Değişmezlik (let / mut)",
            shortDesc = "Rust felsefesi, Cargo paket yöneticisi, 'let' ile varsayılan değişmezlik (immutability), 'mut', gölgelenme (shadowing) ve ilkel tipler.",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false,
            learningObjectives = listOf(
                "Rust'ın bellek güvenliği ve sıfır maliyetli soyutlama vizyonunu anlamak",
                "let (değişmez) ve let mut (değiştirilebilir) farkını kavramak",
                "Temel skaler tipleri (i32, f64, bool, char) ve Shadowing mekanizmasını öğrenmek"
            ),
            prerequisites = listOf("Ön koşul gerekmez. Sıfırdan başlar."),
            subtopics = listOf("Rustc Derleyicisi & LLVM Arka Ucu", "Varsayılan İmmutability Felsefesi", "let vs let mut (Bellek Mutasyonu)", "Değişken Gölgelenme (Variable Shadowing)", "Skaler & Bileşik Veri Tipleri (i32, f64, bool, char, tuple, array)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Rust'ın Değişmezlik (Immutability) Felsefesi",
                    body = "Rust'ta `let` ile tanımlanan tüm değişkenler varsayılan olarak `immutable` (değiştirilemez)dir. Bu, çok iş parçacıklı (multi-threaded) ortamlarda eşzamanlılık hatalarını derleme zamanında önler.\n\nBir değişkenin değerini değiştirmek için açıkça `let mut` bildirimi yapılmalıdır; böylece derleyici bellek yazma iznini denetler.",
                    codeSnippet = "let x = 5; // x değiştirilemez (read-only)\n// x = 6; // DERLEME HATASI (cannot assign twice to immutable variable)\nlet mut y = 5;\ny = 6; // Geçerli bellek mutasyonu"
                ),
                LessonContentBlock(
                    subtitle = "2. Shadowing ve İfade Tabanlı (Expression-based) Yapı",
                    body = "Aynı isimle yeniden `let` tanımlamak (Shadowing), önceki değişkeni kapsam içinde gizler ve tür dönüşümü yaparken yeni bir değişken adı uydurma zorunluluğunu ortadan kaldırır. `println!` bir fonksiyon değil, derleme zamanında AST üzerinde çalışan bir makrodur.",
                    tip = "`const` her zaman açık tip bildirimi gerektirir ve derleme anında sabitlenirken, `let` çalışma zamanı ifadelerini bağlayabilir."
                )
            ),
            codeExample = "fn main() {\n    let isim = \"Deniz\";\n    let mut puan = 85;\n    puan += 10;\n    \n    // Shadowing ile tipi dönüştürelim:\n    let puan = format!(\"{} Puan\", puan);\n    \n    println!(\"Öğrenci: {}, Başarı: {}\", isim, puan);\n}",
            codeExplanation = "puan önce i32 bir tamsayı iken let ile gölgelenerek String bir metne dönüştürüldü. println! ile formatlandı.",
            realWorldExample = "Linux çekirdeği (Kernel), Amazon Web Services (Firecracker microVM) ve Discord altyapısı kritik hız ve güvenlik için Rust kullanır.",
            practicalTask = "İki tamsayı değişkeni toplayıp ekrana println! ile yazdıran bir Rust kodu yazın.",
            starterPlaygroundCode = "fn main() {\n    let a = 10;\n    let b = 20;\n    println!(\"Toplam: {}\", a + b);\n}",
            miniQuestion = MiniQuestion(
                id = "rs_q_1",
                question = "Rust'ta bir değişkenin değerinin sonradan değiştirilebilmesi (mutable) için hangi anahtar kelime eklenmelidir?",
                options = listOf("var", "mut", "dynamic", "changeable"),
                correctIndex = 1,
                explanation = "Rust'ta değişkenler varsayılan olarak immutable'dır; `let mut` ile mutable yapılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_rs_1",
                lessonId = "rs_1",
                title = "İki Sayının Çarpımı",
                instructions = "İki i32 tamsayı alıp çarpımını i32 olarak döndüren carp(a, b) fonksiyonunu yazın.",
                exampleInput = "a = 4, b = 5",
                exampleOutput = "20",
                starterCode = "pub fn carp(a: i32, b: i32) -> i32 {\n    // Kodunu buraya yaz:\n    0\n}",
                solutionCode = "pub fn carp(a: i32, b: i32) -> i32 {\n    a * b\n}",
                hints = listOf("Rust'ta son ifade noktalı virgülsüz bırakılırsa otomatik return edilir (a * b)."),
                testCases = listOf(
                    TestCase("carp(4, 5)", "20", "Çarpım testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "rs_quiz_1_1",
                    lessonId = "rs_1",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Rust fonksiyonlarında bir ifadenin (expression) sonuna noktalı virgül (;) konulmazsa ne gerçekleşir?",
                    options = listOf("Sözdizimi hatası verir", "O ifadenin sonucu fonksiyonun dönüş değeri (implicit return) kabul edilir", "Fonksiyon sonsuz döngüye girer", "Değer sıfırlanır"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Rust expression tabanlıdır; noktalı virgülsüz son ifade fonksiyonun dönüş değeridir.",
                    explanationWrong = "Noktalı virgülsüz son ifade fonksiyonun dönüş değeri olur.",
                    reviewTopic = "Rust Expressions"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "const ile let arasındaki fark nedir?",
                    answer = "`const` her zaman bir tip bildirimi gerektirir, mut yapılamaz ve kesinlikle derleme zamanında sabit bir ifadeye bağlanmalıdır. `let` ise çalışma anında hesaplanan değerleri tutabilir."
                )
            ),
            completionCriteria = listOf(
                "let ve let mut arasındaki farkı bilmek",
                "Shadowing mekanizmasını uygulayabilmek",
                "Temel skaler tipleri ve implicit return mantığını kavramak"
            )
        ),

        // ==========================================
        // DERS 2: KONTROL AKIŞI: IF, LOOP & MATCH (ÜCRETSİZ)
        // ==========================================
        Lesson(
            id = "rs_2",
            courseId = "rust",
            sectionId = "rs_sec_1",
            title = "Kontrol Akışı: if/else, loop, while, for & match",
            shortDesc = "Rust'ta if bir ifadedir. Sonsuz döngü (loop) ve değer döndürme (break deger), while, for in ranges ve güçlü match kontrolü.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false,
            learningObjectives = listOf(
                "if/else yapısını değer döndüren bir ifade olarak kullanmak",
                "loop döngüsünden 'break deger;' ile sonuç döndürmek",
                "for döngüleri ve range (0..10, 0..=10) yapılarını öğrenmek"
            ),
            prerequisites = listOf("Rust'a Giriş & Değişkenler"),
            subtopics = listOf("İfade Tabanlı if/else (Ternary Alternatifi)", "loop İfadesi & break ile Değer Döndürme", "Döngü Etiketleri ('label: loop)", "for in Ranges (0..n, 0..=n, .rev())", "match Örüntü Eşleme & Kapsayıcılık (Exhaustiveness)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. if ve loop İfadelerinden Değer Döndürme",
                    body = "Rust'ta ternary operatörü (`? :`) bulunmaz; çünkü `if-else` bizzat bir ifadedir (expression) ve sonuç döndürür. Benzer şekilde `loop` bloğu içinde `break deger;` yazılarak döngü kırılarak doğrudan bir değişkene sonuç atanabilir.",
                    codeSnippet = "let mut sayac = 0;\nlet sonuc = loop {\n    sayac += 1;\n    if sayac == 10 {\n        break sayac * 2; // 20 sonuc değişkenine atanır\n    }\n};"
                ),
                LessonContentBlock(
                    subtitle = "2. match Örüntü Eşleme ve Derleme Güvencesi",
                    body = "`match` yapısı yalnızca eşitlik değil, aralıklar (`1..=10`), tuple'lar ve enum'lar üzerinde kalıp eşleştirmesi yapar. Tüm olası durumlar kapsanmak (exhaustive) zorundadır; aksi halde kod derlenmez.",
                    tip = "Tüm durumları tek tek yazmak istemiyorsanız diğer tüm ihtimalleri yakalamak için joker `_ =>` desenini kullanın."
                )
            ),
            codeExample = "fn main() {\n    let durum = 200;\n    let mesaj = match durum {\n        200 => \"Başarılı (OK)\",\n        404 => \"Bulunamadı\",\n        500..=599 => \"Sunucu Hatası\",\n        _ => \"Diğer Durum\",\n    };\n    println!(\"HTTP: {}\", mesaj);\n    \n    for n in (1..=3).rev() {\n        print!(\"{}.. \", n); // 3.. 2.. 1..\n    }\n}",
            codeExplanation = "match tüm olası durumları kapsar (_ jokerdir). .rev() range aralığını tersine çevirir.",
            realWorldExample = "Ağ protokolü ayrıştırmada (parser) bayt başlıkları `match` örüntüleri ile tek nanosaniyede dallandırılır.",
            practicalTask = "1'den 20'ye kadar olan tek sayıları for döngüsü ile ekrana yazdırın.",
            starterPlaygroundCode = "fn main() {\n    for i in 1..=5 { println!(\"Adım {}\", i); }\n}",
            miniQuestion = MiniQuestion(
                id = "rs_q_2",
                question = "Rust'ta '1..=5' range aralığı hangi sayıları kapsar?",
                options = listOf("1, 2, 3, 4", "1, 2, 3, 4, 5", "2, 3, 4", "1 ve 5"),
                correctIndex = 1,
                explanation = "'..=' kapsayıcı (inclusive) aralıktır; bitiş değerini (5) dahil eder."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_rs_2",
                lessonId = "rs_2",
                title = "Faktöriyel Hesaplayıcı",
                instructions = "Verilen n (u64) sayısının faktöriyelini döngü kullanarak hesaplayan faktoriyel(n) fonksiyonunu yazın (0! = 1).",
                exampleInput = "n = 5",
                exampleOutput = "120",
                starterCode = "pub fn faktoriyel(n: u64) -> u64 {\n    // Kodunu buraya yaz:\n    1\n}",
                solutionCode = "pub fn faktoriyel(n: u64) -> u64 {\n    let mut sonuc = 1;\n    for i in 2..=n {\n        sonuc *= i;\n    }\n    sonuc\n}",
                hints = listOf("let mut sonuc = 1; for i in 2..=n { sonuc *= i; } sonuc"),
                testCases = listOf(
                    TestCase("faktoriyel(5)", "120", "5! hesabı"),
                    TestCase("faktoriyel(0)", "1", "0! hesabı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "rs_quiz_2_1",
                    lessonId = "rs_2",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Rust 'match' ifadesinde tüm olası durumların kapsanması (exhaustiveness) zorunlu mudur?",
                    options = listOf("Hayır, istenen durumlar yazılabilir", "Evet, tüm ihtimaller kapsanmazsa veya '_' (wildcard) eklenmezse derleyici hata verir ve kodu derlemez", "Sadece sayılarda zorunludur", "İsteğe bağlıdır"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Rust match ifadeleri %100 exhaustive olmak zorundadır.",
                    explanationWrong = "Tüm durumların kapsanması zorunludur.",
                    reviewTopic = "match Exhaustiveness"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Döngü etiketleri (loop labels) ne işe yarar?",
                    answer = "İç içe döngülerde `'dis_dongu: loop { ... break 'dis_dongu; }` şeklinde en dıştaki döngüyü doğrudan kırmak için kullanılır."
                )
            ),
            completionCriteria = listOf(
                "if ve match ifadelerini değer döndürecek şekilde kullanabilmek",
                "loop ve break ile değer döndürmek",
                "Range aralıklarıyla for döngüleri kurabilmek"
            )
        ),

        // ==========================================
        // DERS 3: OWNERSHIP (SAHİPLİK) & MOVE SEMANTİĞİ
        // ==========================================
        Lesson(
            id = "rs_3",
            courseId = "rust",
            sectionId = "rs_sec_2",
            title = "Rust'ın Kalbi: Sahiplik (Ownership) & Move Semantiği",
            shortDesc = "Çöp Toplayıcısız (GC) bellek güvenliği: Ownership 3 altın kuralı, Move (Taşınma) semantiği, Copy Trait vs Clone ve Drop mekanizması.",
            level = CourseLevel.BEGINNER,
            order = 3,
            isPremium = false,
            learningObjectives = listOf(
                "Ownership'in 3 temel kuralını kavramak",
                "Move semantiğini ve s1'in s2'ye atandığında neden geçersiz olduğunu anlamak",
                "Copy (Stack kopyalama) ile Clone (Heap derin kopyalama) arasındaki farkı öğrenmek"
            ),
            prerequisites = listOf("Rust Kontrol Akışı ve Döngüler"),
            subtopics = listOf("Ownership'in 3 Altın Kuralı (Affine Type System)", "Move Semantiği & Derleme Seviyesi Geçersiz Kılma", "Drop Trait & Otomatik Deterministik Yıkım", "Copy Trait (Bitwise Kopyalama) vs Clone (Derin Kopyalama)", "Fonksiyon Çağrılarında Sahiplik Transferi"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Ownership'in 3 Altın Kuralı ve Bellek Güvenliği",
                    body = "1. Rust'ta her değerin tek bir 'sahibi' (owner) olan değişkeni vardır.\n2. Aynı anda yalnızca BİR sahip olabilir.\n3. Sahip kapsamdan (scope `{ }`) çıktığı an, değerin belleği otomatik olarak Drop edilir.\n\nBu sayede Garbage Collector (GC) duraksaması olmadan C/C++ hızında bellek güvenliği sağlanır.",
                    codeSnippet = "let s1 = String::from(\"merhaba\");\nlet s2 = s1; // Sahiplik s2'ye TAŞINDI (MOVE)\n// println!(\"{}\", s1); // DERLEME HATASI! s1 artık Stack'te geçersizdir."
                ),
                LessonContentBlock(
                    subtitle = "2. Copy Trait vs Clone (Derin Kopyalama)",
                    body = "• `Copy`: İlkel tipler (i32, bool, f64, sabit diziler) tamamen Stack üzerinde yaşar ve atandığında bit düzeyinde kopyalanır (Move olmaz).\n• `Clone`: Heap tahsisine sahip nesnelerde (String, Vec) gerçek RAM kopyalaması yapmak için açıkça `.clone()` çağrılmalıdır.",
                    tip = "Move işlemi C++'taki gibi nesneyi kopyalamaz; yalnızca 24 baytlık (ptr, len, cap) Stack başlığını kopyalar ve eski değişkeni derleme seviyesinde siler (Sıfır Maliyetli Taşıma)."
                )
            ),
            codeExample = "fn sahipligi_al(metin: String) {\n    println!(\"Fonksiyon sahiplendi: {}\", metin);\n} // 'metin' burada drop edilir ve Heap belleği iade edilir!\n\nfn main() {\n    let s = String::from(\"Rust\");\n    sahipligi_al(s); // Sahiplik fonksiyona devredildi\n    // println!(\"{}\", s); // HATA: s artık kullanılamaz!\n}",
            codeExplanation = "s değişkeni sahipligi_al fonksiyonuna geçirildiğinde sahiplik devredildi. Fonksiyon bittiğinde bellek anında temizlendi.",
            realWorldExample = "C ve C++'ta en sık karşılaşılan 'Double Free' ve 'Use-After-Free' güvenlik açıkları Rust'ın Ownership kuralları sayesinde derleme anında %100 engellenir.",
            practicalTask = "Bir String oluşturup .clone() ile kopyalayarak hem orijinali hem kopyayı ayrı ayrı yazdıran bir kod yazın.",
            starterPlaygroundCode = "fn main() {\n    let s1 = String::from(\"hello\");\n    let s2 = s1.clone();\n    println!(\"s1: {}, s2: {}\", s1, s2);\n}",
            miniQuestion = MiniQuestion(
                id = "rs_q_3",
                question = "Rust'ta 'let s1 = String::from(\"kod\"); let s2 = s1;' yapıldığında bellekte ne gerçekleşir?",
                options = listOf("Heap belleği derin kopyalanır", "s1'in Heap işaretçisi ve sahipliği s2'ye taşınır (Move) ve s1 geçersiz kalır", "İki değişken ortak kilitlenir", "Derleme hatası verir"),
                correctIndex = 1,
                explanation = "String tipi Heap'tedir; atama işlemi Move yapar ve s1 derleyici tarafından geçersiz kılınır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_rs_3",
                lessonId = "rs_3",
                title = "String Sahiplik ve Uzunluk",
                instructions = "Bir String alıp sahipliğini devralan ve uzunluğunu usize olarak döndüren uzunluk_al(s: String) -> usize fonksiyonunu yazın.",
                exampleInput = "s = String::from(\"Rust\")",
                exampleOutput = "4",
                starterCode = "pub fn uzunluk_al(s: String) -> usize {\n    // Kodunu buraya yaz:\n    0\n}",
                solutionCode = "pub fn uzunluk_al(s: String) -> usize {\n    s.len()\n}",
                hints = listOf("s.len() ifadesini döndürün."),
                testCases = listOf(
                    TestCase("uzunluk_al(String::from(\"Rust\"))", "4", "String uzunluğu")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "rs_quiz_3_1",
                    lessonId = "rs_3",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir veri tipinin otomatik olarak 'Copy' (kopyalanabilir) olabilmesi için temel şart nedir?",
                    options = listOf("String içermesi", "Verinin tamamının Stack üzerinde sabit boyutta yer alması ve Heap tahsisi yapmaması", "En az 100 bayt olması", "Mutable olması"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Yalnızca boyutu derleme anında bilinen ve Heap kullanmayan tipler (i32, bool, char, [i32; 4]) Copy olabilir.",
                    explanationWrong = "Sadece Stack üzerinde yaşayan tipler Copy trait'ini uygulayabilir.",
                    reviewTopic = "Copy Trait"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Drop Trait nedir?",
                    answer = "Bir değişkenin ömrü bittiğinde (scope dışına çıktığında) derleyicinin otomatik olarak çağırdığı temizlik metodudur (`drop(&mut self)`). C++'taki Destructor karşılığıdır."
                )
            ),
            completionCriteria = listOf(
                "Ownership'in 3 temel kuralını ezbere bilmek",
                "Move semantiğini ve Use-after-move derleme hatalarını çözebilmek",
                "Copy ve Clone arasındaki farkı açıklayabilmek"
            )
        ),

        // ==========================================
        // DERS 4: BORROWING (ÖDÜNÇ ALMA) & REFERANSLAR
        // ==========================================
        Lesson(
            id = "rs_4",
            courseId = "rust",
            sectionId = "rs_sec_2",
            title = "Ödünç Alma (Borrowing) & Referanslar (& / &mut)",
            shortDesc = "Sahipliği devretmeden veriye erişmek: Değişmez Referans (&T), Değiştirilebilir Referans (&mut T), Aliasing kuralları ve Data Race koruması.",
            level = CourseLevel.BEGINNER,
            order = 4,
            isPremium = true,
            learningObjectives = listOf(
                "Sahiplik devretmeden (&) referans ile veri ödünç almayı öğrenmek",
                "Değiştirilebilir referansların (&mut) kurallarını kavramak",
                "Borrow Checker'ın 2 Altın Kuralını (Çoklu Okuyucu VEYA Tek Yazıcı) uygulamak"
            ),
            prerequisites = listOf("Ownership (Sahiplik) ve Move Semantiği"),
            subtopics = listOf("Borrowing Mekanizması (&T)", "Değiştirilebilir Referans (&mut T)", "Borrow Checker 2 Temel Kuralı", "Data Race Önleme & Thread Güvenliği", "Non-Lexical Lifetimes (NLL) Çözümleyicisi"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Borrow Checker'ın 2 Altın Kuralı",
                    body = "Belirli bir kapsamda bir veri kaynağı için:\n1. İSTEDİĞİNİZ KADAR değişmez referansa (`&T`) sahip olabilirsiniz (Eşzamanlı Okuyucular).\n2. VEYA YALNIZCA BİR TANE değiştirilebilir referansa (`&mut T`) sahip olabilirsiniz (Tekil Yazıcı).\nİkisi aynı anda ASLA var olamaz; bu sayede Pointer Aliasing ve Data Race derleme aşamasında tamamen engellenir.",
                    codeSnippet = "let mut s = String::from(\"merhaba\");\nlet r1 = &s; // Okuyucu 1\nlet r2 = &s; // Okuyucu 2 (Geçerli)\n// let r3 = &mut s; // DERLEME HATASI! Okuyucular varken &mut alınamaz."
                ),
                LessonContentBlock(
                    subtitle = "2. Sarkan İşaretçi (Dangling Reference) İmkansızlığı",
                    body = "Rust derleyicisi bir referansın ömrünün, işaret ettiği verinin ömrünü aşmasına izin vermez. Veri Drop edildiğinde ona bağlı hiçbir referans yaşayamaz.",
                    tip = "Non-Lexical Lifetimes (NLL) sayesinde bir referansın ömrü süslü parantezde değil, kodda en son kullanıldığı satırda otomatik sonlanır."
                )
            ),
            codeExample = "fn uzunluk_hesapla(metin: &String) -> usize {\n    metin.len() // Sahiplik alınmadı, sadece ödünç alındı (&)\n}\n\nfn ekle(metin: &mut String) {\n    metin.push_str(\" Dünyası!\");\n}\n\nfn main() {\n    let mut s = String::from(\"Rust\");\n    let len = uzunluk_hesapla(&s); // s hala geçerli!\n    ekle(&mut s);\n    println!(\"{}, Uzunluk: {}\", s, len); // Rust Dünyası!\n}",
            codeExplanation = "&s ile değişmez referans, &mut s ile değiştirilebilir referans verildi; sahiplik main'de kaldı.",
            realWorldExample = "Tarayıcı motorlarında (Servo) binlerce thread DOM ağacını okurken Borrow Checker sayesinde hiçbir kilit mekanizması olmadan sıfır Data Race ile çalışır.",
            practicalTask = "Bir tamsayı referansı (&mut i32) alıp değerini 10 artıran bir fonksiyon yazın.",
            starterPlaygroundCode = "fn main() {\n    let mut x = 5;\n    let r = &mut x;\n    *r += 1;\n    println!(\"{}\", x);\n}",
            miniQuestion = MiniQuestion(
                id = "rs_q_4",
                question = "Rust Borrow Checker kurallarına göre aynı anda aynı veri için kaç tane '&mut T' (değiştirilebilir referans) bulunabilir?",
                options = listOf("Sınırsız", "Yalnızca 1", "En fazla 2", "CPU çekirdeği kadar"),
                correctIndex = 1,
                explanation = "Veri yarışlarını (Data Race) engellemek için aynı anda yalnızca tek bir mutable referans bulunabilir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_rs_4",
                lessonId = "rs_4",
                title = "Metin Sonuna Ünlem Ekleme (&mut)",
                instructions = "&mut String referansı alıp sonuna '!' karakteri ekleyen unlem_ekle(s: &mut String) fonksiyonunu yazın.",
                exampleInput = "s = \"Merhaba\"",
                exampleOutput = "\"Merhaba!\"",
                starterCode = "pub fn unlem_ekle(s: &mut String) {\n    // Kodunu buraya yaz:\n}",
                solutionCode = "pub fn unlem_ekle(s: &mut String) {\n    s.push('!');\n}",
                hints = listOf("s.push('!') veya s.push_str(\"!\") kullanın."),
                testCases = listOf(
                    TestCase("unlem_ekle", "Başarılı", "&mut testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "rs_quiz_4_1",
                    lessonId = "rs_4",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Aynı kapsamda hem '&T' (okuma) hem de '&mut T' (yazma) referanslarının aynı anda bulunması neden yasaktır?",
                    options = listOf("Derleyici yavaşladığı için", "Okuyucuların okuduğu sırada yazıcının veriyi değiştirip okuma tutarsızlığı veya işaretçi bozulması (Aliasing bug) yaratmasını engellemek için", "Bellek taşmasını engellemek için", "Rust sözdizimi kuralı olduğu için"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Bu kural Pointer Aliasing ve Data Race sorunlarını derleme anında tamamen yok eder.",
                    explanationWrong = "Eşzamanlı okuma/yazma çakışmalarını önlemek için yasaktır.",
                    reviewTopic = "Borrowing Rules"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Non-Lexical Lifetimes (NLL) nedir?",
                    answer = "Rust 2018 ile gelen özelliktir. Bir referansın ömrü artık süslü parantezin `}` bittiği yerde değil, o referansın kodda SON KULLANILDIĞI satırda biter."
                )
            ),
            completionCriteria = listOf(
                "& ve &mut referans farklarını bilmek",
                "Borrow Checker kurallarını hatasız uygulamak",
                "Dangling reference hatalarını önlemek"
            )
        ),

        // ==========================================
        // DERS 5: SLICES, VECTORS & HASHMAPS
        // ==========================================
        Lesson(
            id = "rs_5",
            courseId = "rust",
            sectionId = "rs_sec_3",
            title = "Dilimler (Slices: &str, &[T]), Vektörler (Vec) & HashMaps",
            shortDesc = "Koleksiyonun bir parçasına güvenli erişim (Slices), String vs &str bellek farkı, dinamik diziler (Vec<T>) ve Anahtar-Değer haritaları (HashMap).",
            level = CourseLevel.INTERMEDIATE,
            order = 5,
            isPremium = true,
            learningObjectives = listOf(
                "String (Heap, büyüyebilir) ile &str (String Slice, salt okunur görünüm) farkını kavramak",
                "Vec<T> dinamik dizisi oluşturup yönetmek",
                "std::collections::HashMap ile anahtar-değer eşlemeleri ve entry() API'sini kullanmak"
            ),
            prerequisites = listOf("Ödünç Alma ve Referanslar"),
            subtopics = listOf("Fat Pointers: &str Mimarisi (ptr + len)", "Dizi Dilimleri (&[T]) & Bounds Checking", "Vec<T> Bellek Mimarisi (Kapasite İkiye Katlama)", "HashMap & entry().or_insert() API", "Deref Coercion (&String -> &str)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. String vs &str (Fat Pointer)",
                    body = "• `String`: Heap'te tahsis edilen, büyütülebilen ve bellek sahipliğine sahip olan tiptir (ptr, len, capacity = 24 bayt).\n• `&str`: Bir metnin (String veya ikili dosyadaki statik veri) bellekteki belirli bir alt aralığını gösteren `[işaretçi, uzunluk]` (16 baytlık Fat Pointer) dilimidir.",
                    codeSnippet = "let s = String::from(\"Merhaba Rust\");\nlet dilim: &str = &s[0..7]; // \"Merhaba\" (kopyalama yok, sadece işaretçi)"
                ),
                LessonContentBlock(
                    subtitle = "2. Vec<T> Tahsisi ve HashMap entry API'si",
                    body = "`Vec<T>` kapasitesi dolduğunda Heap'te belleği ikiye katlayarak (2x reallocation) elemanları taşır.\n\n`HashMap::entry(key).or_insert(deger)` metodu, anahtar yoksa varsayılan değeri ekleyip referansını tek bir arama maliyetiyle döner.",
                    tip = "Fonksiyon parametrelerinde `&String` yerine daima `&str` kullanın; Deref Coercion sayesinde hem `&String` hem de `\"literal\"` metinleri kabul eder."
                )
            ),
            codeExample = "use std::collections::HashMap;\n\nfn main() {\n    let mut sayilar: Vec<i32> = vec![10, 20, 30];\n    sayilar.push(40);\n    \n    let mut frekans = HashMap::new();\n    let metin = \"elma muz elma elma armut\";\n    \n    for kelime in metin.split_whitespace() {\n        let count = frekans.entry(kelime).or_insert(0);\n        *count += 1;\n    }\n    \n    println!(\"Frekans: {:?}\", frekans); // {\"elma\": 3, \"muz\": 1, \"armut\": 1}\n}",
            codeExplanation = "entry(kelime).or_insert(0) anahtar yoksa 0 ekler ve değere bir &mut i32 referansı döner; *count += 1 ile frekans artırılır.",
            realWorldExample = "Metin işleme, derleyici sembol tabloları ve HTTP header yönetiminde Vec ve HashMap çekirdek veri yapılarıdır.",
            practicalTask = "Bir tamsayı vektöründeki çift sayıları yeni bir vektöre toplayan bir Rust kodu yazın.",
            starterPlaygroundCode = "fn main() {\n    let v = vec![1, 2, 3];\n    println!(\"İlk eleman: {}\", v[0]);\n}",
            miniQuestion = MiniQuestion(
                id = "rs_q_5",
                question = "Rust'ta bir fonksiyon parametresinin hem 'String' hem de '\"statik metin\"' literallerini kabul edebilmesi için parametre tipi ne olmalıdır?",
                options = listOf("&String", "&str", "String", "char*"),
                correctIndex = 1,
                explanation = "&str (String Slice) Deref Coercion sayesinde hem &String hem de string literallerini kabul eder."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_rs_5",
                lessonId = "rs_5",
                title = "Vektör Toplayıcı",
                instructions = "&Vec<i32> referansı alıp elemanların toplamını i32 olarak döndüren vektor_topla(v: &Vec<i32>) -> i32 fonksiyonunu yazın.",
                exampleInput = "v = vec![10, 20, 30]",
                exampleOutput = "60",
                starterCode = "pub fn vektor_topla(v: &Vec<i32>) -> i32 {\n    // Kodunu buraya yaz:\n    0\n}",
                solutionCode = "pub fn vektor_topla(v: &Vec<i32>) -> i32 {\n    v.iter().sum()\n}",
                hints = listOf("v.iter().sum() kullanın."),
                testCases = listOf(
                    TestCase("vektor_topla(&vec![10, 20, 30])", "60", "Vektör toplamı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "rs_quiz_5_1",
                    lessonId = "rs_5",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Rust'ta bir String dilimi (&str) bellekte hangi iki bilgiyi tutar?",
                    options = listOf("Sadece verinin kopyasını", "Başlangıç bellek işaretçisi (pointer) ve dilimin uzunluğu (length)", "Kapasite ve sayaç", "Heap ID'si"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Slice'lar 'fat pointer'dır; bellek adresi ve uzunluk taşır.",
                    explanationWrong = "Slice'lar pointer ve length taşır.",
                    reviewTopic = "Slices Internals"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Vec ile Dizi ([T; N]) farkı nedir?",
                    answer = "Dizi sabit boyutludur ve Stack'te yaşar. `Vec<T>` ise Heap'te dinamik olarak büyüyüp küçülebilen bir vektördür."
                )
            ),
            completionCriteria = listOf(
                "String ve &str arasındaki bellek farkını bilmek",
                "Vec ve HashMap veri yapılarını kullanabilmek",
                "entry().or_insert() kalıbını uygulayabilmek"
            )
        ),

        // ==========================================
        // DERS 6: STRUCTS, IMPL & METOTLAR
        // ==========================================
        Lesson(
            id = "rs_6",
            courseId = "rust",
            sectionId = "rs_sec_3",
            title = "Yapılar (Structs), impl Blokları & Metotlar",
            shortDesc = "Özel veri tipleri: Klasik Structs, Tuple Structs, impl blokları, Metotlar (&self, &mut self, self) ve İlişkili Fonksiyonlar (Associated Functions).",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true,
            learningObjectives = listOf(
                "Struct ile özel veri modelleri tanımlamak",
                "impl bloğu içinde &self ve &mut self metotları yazmak",
                "İlişkili Fonksiyonlar (örn. `Dikdortgen::yeni(...)` kurucuları) inşa etmek"
            ),
            prerequisites = listOf("Dilimler, Vektörler ve Koleksiyonlar"),
            subtopics = listOf("Named Structs", "Tuple Structs & Unit Structs", "impl Blokları", "&self vs &mut self vs self", "Associated Functions (String::from gibi)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Struct ve impl Mimarisi",
                    body = "Rust'ta veri tanımı (`struct`) ile fonksiyon/metot mantığı (`impl`) tamamen ayrılmıştır.",
                    codeSnippet = "struct Kullanici {\n    kullanici_adi: String,\n    aktif: bool,\n}\n\nimpl Kullanici {\n    fn yeni(ad: &str) -> Self {\n        Self { kullanici_adi: String::from(ad), aktif: true }\n    }\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. &self, &mut self ve self Farkı",
                    body = "• `&self`: Nesneyi salt okunur ödünç alır (en yaygın metot tipi).\n• `&mut self`: Nesnenin durumunu değiştiren metotlar için.\n• `self`: Nesnenin sahipliğini tüketir (Move eder - dönüştürücü metotlar için).",
                    tip = "Debug çıktısı alabilmek için struct'ların başına `#[derive(Debug)]` niteliği eklenmelidir."
                )
            ),
            codeExample = "#[derive(Debug)]\nstruct Dikdortgen {\n    genislik: u32,\n    yukseklik: u32,\n}\n\nimpl Dikdortgen {\n    // İlişkili fonksiyon (Kurucu):\n    fn yeni(g: u32, y: u32) -> Self {\n        Self { genislik: g, yukseklik: y }\n    }\n    \n    // Metot (&self):\n    fn alan(&self) -> u32 {\n        self.genislik * self.yukseklik\n    }\n}\n\nfn main() {\n    let d = Dikdortgen::yeni(10, 20);\n    println!(\"{:?} Alanı: {}\", d, d.alan());\n}",
            codeExplanation = "Dikdortgen::yeni kurucu olarak nesne üretti, d.alan() ise &self referansı ile alanı hesapladı.",
            realWorldExample = "Oyun motorlarında fizik gövdeleri (RigidBody) ve ağ paketleri struct ve impl bloklarıyla modellenir.",
            practicalTask = "Bakiye tutan bir BankaHesabi struct'ı ve para_yatir(&mut self) metodunu yazın.",
            starterPlaygroundCode = "struct Nokta { x: i32, y: i32 }\nimpl Nokta { fn orijin() -> Self { Self { x: 0, y: 0 } } }\nfn main() { let n = Nokta::orijin(); println!(\"{}\", n.x); }",
            miniQuestion = MiniQuestion(
                id = "rs_q_6",
                question = "Rust'ta bir struct metodunun nesnenin içindeki alanları DEĞİŞTİREBİLMESİ için ilk parametresi ne olmalıdır?",
                options = listOf("&self", "&mut self", "self", "mut this"),
                correctIndex = 1,
                explanation = "&mut self parametresi metodun çağıran nesne üzerinde değiştirilebilir referans edinmesini sağlar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_rs_6",
                lessonId = "rs_6",
                title = "Daire Struct ve Alan Hesabı",
                instructions = "yaricap (f64) alanı olan Daire struct'ı oluşturun. impl Daire içinde alan(&self) -> f64 metodunu yazın (Pi = 3.14).",
                exampleInput = "let d = Daire { yaricap: 10.0 }; d.alan()",
                exampleOutput = "314.0",
                starterCode = "pub struct Daire {\n    pub yaricap: f64,\n}\nimpl Daire {\n    // Metodu buraya yaz:\n}",
                solutionCode = "pub struct Daire {\n    pub yaricap: f64,\n}\nimpl Daire {\n    pub fn alan(&self) -> f64 {\n        3.14 * self.yaricap * self.yaricap\n    }\n}",
                hints = listOf("pub fn alan(&self) -> f64 { 3.14 * self.yaricap * self.yaricap }"),
                testCases = listOf(
                    TestCase("Daire", "314.0", "Daire alan hesabı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "rs_quiz_6_1",
                    lessonId = "rs_6",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Rust'ta ilk parametresi 'self' olmayan bir impl fonksiyonu (örn: `fn yeni() -> Self`) nasıl çağrılır?",
                    options = listOf("nesne.yeni()", "StructAdi::yeni() (İki nokta operatörü ile)", "new StructAdi()", "yeni(StructAdi)"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Associated Functions `Struct::fonksiyon()` sözdizimi ile çağrılır.",
                    explanationWrong = "StructAdi::fonksiyon() sözdizimi kullanılır.",
                    reviewTopic = "Associated Functions"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Tuple Struct nedir?",
                    answer = "Alanlarının ismi olmayan, sadece tipleri ve sıraları olan struct'lardır: `struct Renk(u8, u8, u8);`"
                )
            ),
            completionCriteria = listOf(
                "Struct ve impl bloklarını kurabilmek",
                "&self ve &mut self ayrımını bilmek",
                "Associated Functions ile kurucu metotlar yazabilmek"
            )
        ),

        // ==========================================
        // DERS 7: ENUMS, OPTION & RESULT (? OPERATÖRÜ)
        // ==========================================
        Lesson(
            id = "rs_7",
            courseId = "rust",
            sectionId = "rs_sec_4",
            title = "Enums, Pattern Matching, Option & Result (? Operatörü)",
            shortDesc = "Veri taşıyan Enum yapıları, match ile destructuring, if let, Option<T> (Some/None), Result<T, E> (Ok/Err) ve '?' hata yayma operatörü.",
            level = CourseLevel.INTERMEDIATE,
            order = 7,
            isPremium = true,
            learningObjectives = listOf(
                "Rust'ta Enum'ların veri (struct, tuple vb.) taşıyabilme gücünü kavramak",
                "Option<T> ile null kullanmadan güvenli değer yokluğu modellemek",
                "Result<T, E> ve '?' operatörü ile temiz ve profesyonel hata yönetimi yapmak"
            ),
            prerequisites = listOf("Structs ve impl Blokları"),
            subtopics = listOf("Zengin Enum Tipleri", "match & if let Sözdizimi", "Option<T> (Some vs None)", "Result<T, E> (Ok vs Err)", "? Operatörü (Error Propagation)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Option<T>: Null'a Son",
                    body = "Rust'ta 'NULL' değeri yoktur. Bir değerin var veya yok olabileceği `enum Option<T> { Some(T), None }` ile ifade edilir.",
                    codeSnippet = "fn bol(a: f64, b: f64) -> Option<f64> {\n    if b == 0.0 { None } else { Some(a / b) }\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Result<T, E> ve '?' Operatörü",
                    body = "İşlemin başarılı (`Ok(deger)`) veya hatalı (`Err(hata)`) olabileceğini belirtir. `?` operatörü hata varsa fonksiyondan anında return eder, hata yoksa Ok içindeki değeri çözer.",
                    tip = "? operatörü sadece dönüş tipi Result veya Option olan fonksiyonlar içinde kullanılabilir."
                )
            ),
            codeExample = "enum Mesaj {\n    Cikis,\n    MetinYaz(String),\n    Konum { x: i32, y: i32 },\n}\n\nfn isle(m: Mesaj) {\n    match m {\n        Mesaj::Cikis => println!(\"Çıkış yapıldı.\"),\n        Mesaj::MetinYaz(yazi) => println!(\"Mesaj: {}\", yazi),\n        Mesaj::Konum { x, y } => println!(\"Konum: ({}, {})\", x, y),\n    }\n}\n\nfn main() {\n    isle(Mesaj::MetinYaz(String::from(\"Rust Enums Harika!\")));\n}",
            codeExplanation = "Mesaj enum'ının her varyantı farklı veri tipleri taşır. match ifadesi varyanta göre veriyi çözer (destructure eder).",
            realWorldExample = "Dosya okuma (`File::open`), ağ istekleri ve JSON ayrıştırma kütüphaneleri tüm hata kontrollerini `Result` ve `?` ile yönetir.",
            practicalTask = "String bir sayıyı parse edip 2 katını alan, parse hatası olursa hata dönen bir Result fonksiyonu yazın.",
            starterPlaygroundCode = "fn main() {\n    let sayi: Option<i32> = Some(42);\n    if let Some(s) = sayi { println!(\"Sayı: {}\", s); }\n}",
            miniQuestion = MiniQuestion(
                id = "rs_q_7",
                question = "Rust'ta Result<T, E> döndüren bir işlemde hata durumunda hatayı fonksiyondan anında yukarıya fırlatan (propagate eden) operatör hangisidir?",
                options = listOf("!", "?", "->", "throw"),
                correctIndex = 1,
                explanation = "'?' operatörü Err durumunda fonksiyonu erken sonlandırıp hatayı döner; Ok durumunda ise değeri açar (unwrap eder)."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_rs_7",
                lessonId = "rs_7",
                title = "Güvenli Bölme Fonksiyonu (Option)",
                instructions = "İki f64 sayıyı bölen; b == 0.0 ise None, aksi halde Some(a / b) döndüren guvenli_bol(a, b) -> Option<f64> fonksiyonunu yazın.",
                exampleInput = "a = 10.0, b = 2.0",
                exampleOutput = "Some(5.0)",
                starterCode = "pub fn guvenli_bol(a: f64, b: f64) -> Option<f64> {\n    // Kodunu buraya yaz:\n    None\n}",
                solutionCode = "pub fn guvenli_bol(a: f64, b: f64) -> Option<f64> {\n    if b == 0.0 { None } else { Some(a / b) }\n}",
                hints = listOf("if b == 0.0 { None } else { Some(a / b) }"),
                testCases = listOf(
                    TestCase("guvenli_bol(10.0, 2.0)", "Some(5.0)", "Bölme"),
                    TestCase("guvenli_bol(10.0, 0.0)", "None", "Sıfıra bölme")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "rs_quiz_7_1",
                    lessonId = "rs_7",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Rust'ta bir Option veya Result içindeki değeri doğrudan almak için '.unwrap()' kullanmanın en büyük riski nedir?",
                    options = listOf("Yavaş çalışması", "Eğer değer None veya Err ise programın derhal 'panic!' ile çökmesi", "Bellek sızdırması", "Yanlış değer dönmesi"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! unwrap() hata durumunda panic üretir; üretim kodunda match, if let veya '?' tercih edilmelidir.",
                    explanationWrong = "unwrap() None/Err durumunda panic ile programı çökertir.",
                    reviewTopic = "unwrap vs ?"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "if let sözdizimi ne zaman tercih edilir?",
                    answer = "Yalnızca tek bir enum varyantı (örneğin sadece `Some(x)`) ile ilgilenip diğer tüm durumları yok saymak istediğinizde `match` yazmak yerine kullanılır."
                )
            ),
            completionCriteria = listOf(
                "Veri taşıyan zengin Enum tipleri tasarlayabilmek",
                "Option ve Result mimarisini kavramak",
                "? operatörü ile hata zincirleri kurabilmek"
            )
        ),

        // ==========================================
        // DERS 8: TRAITS, DYN VS IMPL & MONOMORPHISM
        // ==========================================
        Lesson(
            id = "rs_8",
            courseId = "rust",
            sectionId = "rs_sec_5",
            title = "Nitelikler (Traits), Trait Bounds & dyn vs impl Trait",
            shortDesc = "Ortak davranış arayüzleri (Traits), #[derive(...)], Trait Bounds, impl Trait (Monomorphism - Sıfır Maliyet) vs dyn Trait (Dinamik Dağıtım).",
            level = CourseLevel.ADVANCED,
            order = 8,
            isPremium = true,
            learningObjectives = listOf(
                "Trait tanımlamak ve sınıflara 'impl Trait for Struct' ile yetenek kazandırmak",
                "Statik Dağıtım (impl Trait / Monomorphism) ile Dinamik Dağıtım (dyn Trait) farkını öğrenmek",
                "derive makroları (Debug, Clone, PartialEq, Default) ile otomatik trait implementasyonu yapmak"
            ),
            prerequisites = listOf("Enums, Option ve Result Mimarisi"),
            subtopics = listOf("Trait Bildirimi & Tanımı", "Varsayılan Metot Gövdeleri", "Trait Bounds (T: Trait)", "impl Trait (Static Dispatch)", "dyn Trait (Dynamic Dispatch / Trait Objects)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Statik Dağıtım (impl Trait) vs Dinamik Dağıtım (dyn Trait)",
                    body = "• `impl Trait` (Static Dispatch): Derleme zamanında her somut tip için ayrı makine kodu üretir (Monomorphization). Sıfır çalışma zamanı ek yükü sunar ve inline edilebilir.\n• `dyn Trait` (Dynamic Dispatch): Farklı tipleri aynı koleksiyonda (`Vec<Box<dyn Cizilebilir>>`) tutmak için vtable üzerinden çalışma zamanı çözümlemesi yapar.",
                    codeSnippet = "trait Ozetlenebilir {\n    fn ozet(&self) -> String;\n}\n\nfn haber_bas(item: &impl Ozetlenebilir) {\n    println!(\"{}\", item.ozet());\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Trait Bounds ile Kısıtlama",
                    body = "`fn karsilastir<T: PartialOrd + std::fmt::Display>(a: T, b: T)` sözdizimi ile jenerik tiplerin hangi yeteneklere sahip olması gerektiği zorunlu kılınır.",
                    tip = "Standart trait'leri (Clone, Copy, Debug, PartialEq) elle yazmak yerine `#[derive(Clone, Debug)]` ile türetin."
                )
            ),
            codeExample = "trait SesCikarabilen {\n    fn ses(&self) -> String;\n}\n\nstruct Kopek;\nimpl SesCikarabilen for Kopek {\n    fn ses(&self) -> String { String::from(\"Hav hav! 🐕\") }\n}\n\nstruct Kedi;\nimpl SesCikarabilen for Kedi {\n    fn ses(&self) -> String { String::from(\"Miyav! 🐈\") }\n}\n\nfn main() {\n    // dyn Trait ile farklı türleri aynı vektörde toplayalım:\n    let hayvanlar: Vec<Box<dyn SesCikarabilen>> = vec![\n        Box::new(Kopek),\n        Box::new(Kedi),\n    ];\n    \n    for h in &hayvanlar {\n        println!(\"{}\", h.ses());\n    }\n}",
            codeExplanation = "Box<dyn SesCikarabilen> Trait Object'i vtable tablosu kullanarak heterojen hayvan nesnelerini aynı vektörde çok biçimli yönetti.",
            realWorldExample = "Rust standart kütüphanesindeki `std::io::Read`, `std::io::Write` ve `Iterator` tüm I/O ve akış işlemlerini Trait'ler ile yönetir.",
            practicalTask = "Alan trait'i oluşturup Dikdortgen ve Daire yapılarına uygulayın.",
            starterPlaygroundCode = "trait Selam { fn de(&self); }\nstruct A; impl Selam for A { fn de(&self) { println!(\"A\"); } }\nfn main() { A.de(); }",
            miniQuestion = MiniQuestion(
                id = "rs_q_8",
                question = "Rust'ta 'fn yazdir(item: impl Display)' kullanıldığında derleyicinin derleme anında somut tiplere özel kod üretme işlemine ne ad verilir?",
                options = listOf("Monomorphization (Statik Dağıtım)", "Dynamic Dispatch", "Reflection", "Interpretation"),
                correctIndex = 0,
                explanation = "Monomorphization jenerik kodu derleme anında somut tiplere dönüştürerek sıfır maliyetli soyutlama sağlar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_rs_8",
                lessonId = "rs_8",
                title = "Ozetlenebilir Trait'i",
                instructions = "ozet(&self) -> String metoduna sahip Ozetlenebilir trait'ini tanımlayın. Bunu metin (String) alanı olan Haber struct'ına uygulayın.",
                exampleInput = "Haber { metin: \"Flaş!\" }.ozet()",
                exampleOutput = "\"Flaş!\"",
                starterCode = "pub trait Ozetlenebilir {\n    fn ozet(&self) -> String;\n}\npub struct Haber {\n    pub metin: String,\n}\n// impl Ozetlenebilir for Haber buraya yazın:",
                solutionCode = "pub trait Ozetlenebilir {\n    fn ozet(&self) -> String;\n}\npub struct Haber {\n    pub metin: String,\n}\nimpl Ozetlenebilir for Haber {\n    fn ozet(&self) -> String {\n        self.metin.clone()\n    }\n}",
                hints = listOf("impl Ozetlenebilir for Haber { fn ozet(&self) -> String { self.metin.clone() } }"),
                testCases = listOf(
                    TestCase("Haber", "Flaş!", "Trait testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "rs_quiz_8_1",
                    lessonId = "rs_8",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Farklı türdeki somut struct'ları aynı Vec içinde polimorfik olarak tutabilmek için hangisi kullanılmalıdır?",
                    options = listOf("Vec<impl Trait>", "Vec<Box<dyn Trait>> (Trait Object)", "Vec<Trait>", "Vec<Any>"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Farklı boyutlardaki heterojen tipler Trait Object (`Box<dyn Trait>`) olarak dinamik dağıtım ile tutulur.",
                    explanationWrong = "Box<dyn Trait> yapısı kullanılır.",
                    reviewTopic = "Trait Objects"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Coherence (Orphan Rule) nedir?",
                    answer = "Bir Trait'i bir Tip için uygularken (impl Trait for Type), ya o Trait'in ya da o Tipin KENDİ kütüphanenizde (crate) tanımlanmış olması kuralıdır. Dış kütüphanenin trait'ini dış kütüphanenin tipine uygulayamazsınız."
                )
            ),
            completionCriteria = listOf(
                "Trait tanımlayıp struct'lara uygulayabilmek",
                "impl Trait (Statik) ile dyn Trait (Dinamik) farkını bilmek",
                "Trait Bounds kısıtları kurabilmek"
            )
        ),

        // ==========================================
        // DERS 9: LIFETIMES ('A) & BORROW CHECKER DERİNLİKLERİ
        // ==========================================
        Lesson(
            id = "rs_9",
            courseId = "rust",
            sectionId = "rs_sec_5",
            title = "Yaşam Süreleri (Lifetimes: 'a, 'static) & Borrow Checker",
            shortDesc = "Referansların geçerlilik ömrü: Yaşam süresi parametreleri ('a), Lifetime Elision kuralları, Yapılarda referans tutma ve 'static ömrü.",
            level = CourseLevel.ADVANCED,
            order = 9,
            isPremium = true,
            learningObjectives = listOf(
                "Yaşam Süresi ('a) sözdiziminin amacını ve referans geçerliliğini kavramak",
                "Derleyicinin Lifetime Elision (otomatik ömür tahmini) kurallarını öğrenmek",
                "Struct içinde referans saklarken 'a ömrünü tanımlamak"
            ),
            prerequisites = listOf("Traits ve Trait Bounds"),
            subtopics = listOf("Lifetimes Neden Vardır?", "Yaşam Süresi Bildirimi (&'a str)", "Fonksiyonlarda 'a İlişkisi", "Struct İçinde Referans ('a)", "'static Yaşam Süresi"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Lifetimes ('a) Aslında Ne Yapar?",
                    body = "Lifetimes çalışma zamanında hiçbir şeyi uzatmaz veya kısaltmaz; sadece derleyiciye (Borrow Checker) iki referansın yaşam süreleri arasındaki ilişkiyi açıklar. Böylece sarkan işaretçi (dangling pointer) riski matematiksel olarak sıfırlanır.",
                    codeSnippet = "fn en_uzun<'a>(x: &'a str, y: &'a str) -> &'a str {\n    if x.len() > y.len() { x } else { y }\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. 'static Yaşam Süresi",
                    body = "`'static` verinin tüm program çalışması boyunca bellekte (genellikle derlenmiş binary veri segmentinde) yaşayacağını belirtir. String literalleri (`&'static str`) bu kategoridedir.",
                    tip = "Struct içinde referans tutuyorsanız `struct Kitap<'a> { baslik: &'a str }` şeklinde lifetime belirtmek zorunludur."
                )
            ),
            codeExample = "struct Alinti<'a> {\n    metin: &'a str,\n}\n\nfn en_uzun<'a>(x: &'a str, y: &'a str) -> &'a str {\n    if x.len() > y.len() { x } else { y }\n}\n\nfn main() {\n    let s1 = String::from(\"uzun metin\");\n    let s2 = \"kısa\";\n    let sonuc = en_uzun(&s1, s2);\n    \n    let alinti = Alinti { metin: sonuc };\n    println!(\"Alıntı: {}\", alinti.metin);\n}",
            codeExplanation = "en_uzun fonksiyonu dönen referansın en az x ve y kadar yaşayacağını 'a ile bildirdi.",
            realWorldExample = "Sıfır kopyalı (Zero-Copy) yüksek hızlı JSON/Binary parser'ları veriyi belleğe kopyalamak yerine lifetime'lar ile doğrudan bellek tamponu dilimlerini işaret eder.",
            practicalTask = "İki string dilimi alıp ilkini dönen bir fonksiyonun lifetime imzasını yazın.",
            starterPlaygroundCode = "fn birinci<'a>(x: &'a str, _y: &str) -> &'a str { x }\nfn main() { println!(\"{}\", birinci(\"a\", \"b\")); }",
            miniQuestion = MiniQuestion(
                id = "rs_q_9",
                question = "Rust'ta programın çalıştığı tüm süre boyunca bellekte kalacağını belirten özel yaşam süresi hangisidir?",
                options = listOf("'a", "'static", "'global", "'forever"),
                correctIndex = 1,
                explanation = "'static yaşam süresi verinin tüm program süresince geçerli olduğunu belirtir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_rs_9",
                lessonId = "rs_9",
                title = "Lifetime ile Karşılaştırıcı",
                instructions = "İki &str referansı alıp uzun olanı &'a str olarak döndüren en_uzun_bul<'a>(x: &'a str, y: &'a str) -> &'a str fonksiyonunu yazın.",
                exampleInput = "x = \"elma\", y = \"karpuz\"",
                exampleOutput = "\"karpuz\"",
                starterCode = "pub fn en_uzun_bul<'a>(x: &'a str, y: &'a str) -> &'a str {\n    // Kodunu buraya yaz:\n    x\n}",
                solutionCode = "pub fn en_uzun_bul<'a>(x: &'a str, y: &'a str) -> &'a str {\n    if x.len() >= y.len() { x } else { y }\n}",
                hints = listOf("if x.len() >= y.len() { x } else { y }"),
                testCases = listOf(
                    TestCase("en_uzun_bul(\"elma\", \"karpuz\")", "karpuz", "Lifetime karşılaştırma")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "rs_quiz_9_1",
                    lessonId = "rs_9",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Rust derleyicisinin tek parametreli fonksiyonlarda yaşam süresi belirtilmese bile lifetime'ı otomatik anlamasını sağlayan kurallara ne ad verilir?",
                    options = listOf("Lifetime Inference", "Lifetime Elision Kuralları", "Auto-Lifetime", "Implicit Borrow"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! 3 adet Lifetime Elision kuralı sayesinde standart fonksiyonlarda açıkça 'a yazmaya gerek kalmaz.",
                    explanationWrong = "Lifetime Elision kuralları denir.",
                    reviewTopic = "Lifetime Elision"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Lifetime Elision 1. kuralı nedir?",
                    answer = "Derleyici, parametre olarak gelen her bir referansa otomatik olarak ayrı bir lifetime parametresi atar (örn: `fn f(x: &i32, y: &i32)` -> `fn f<'a, 'b>(x: &'a i32, y: &'b i32)`)."
                )
            ),
            completionCriteria = listOf(
                "Lifetimes mantığını ve 'a sözdizimini açıklayabilmek",
                "Yapılarda referans ve lifetime tanımlayabilmek",
                "'static yaşam süresinin kullanım yerlerini bilmek"
            )
        ),

        // ==========================================
        // DERS 10: ITERATORS & CLOSURES (FN, FNMUT, FNONCE)
        // ==========================================
        Lesson(
            id = "rs_10",
            courseId = "rust",
            sectionId = "rs_sec_5",
            title = "İteratörler, Kapanışlar (Closures) & Fonksiyonel Rust",
            shortDesc = "Kapanışlar (Closures: |x| x + 1), Ortam yakalama kuralları (Fn, FnMut, FnOnce, move), İteratör Adaptörleri (map, filter, collect) ve Sıfır Maliyetli İterasyon.",
            level = CourseLevel.ADVANCED,
            order = 10,
            isPremium = true,
            learningObjectives = listOf(
                "Closures (|param| { }) sözdizimini ve tip çıkarımını öğrenmek",
                "Fn (Salt Okunur), FnMut (Değiştiren) ve FnOnce (Tüketen) trait ayrımını kavramak",
                "İteratör adaptörleri (map, filter, fold, collect) ile C hızında fonksiyonel akışlar kurmak"
            ),
            prerequisites = listOf("Yaşam Süreleri ve Borrow Checker"),
            subtopics = listOf("Closures (|x| ...)", "move Anahtar Kelimesi ile Sahiplik Yakalama", "Fn, FnMut, FnOnce Traitleri", "Iterator & IntoIterator", "Tembel Hesaplama (Lazy Iterators)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Closure Traitleri: Fn, FnMut, FnOnce",
                    body = "• `Fn`: Ortamdaki değişkenleri değişmez referansla (`&T`) yakalar; sınırsız çağrılabilir.\n• `FnMut`: Ortamdaki değişkenleri değiştirilebilir referansla (`&mut T`) yakalar.\n• `FnOnce`: Ortamdaki değişkenin sahipliğini (`T`) alır; bu nedenle yalnızca BİR KEZ çağrılabilir.",
                    codeSnippet = "let mut toplam = 0;\nlet mut artir = |x| toplam += x; // FnMut\nartir(5);\nartir(10);"
                ),
                LessonContentBlock(
                    subtitle = "2. Sıfır Maliyetli İteratörler (Zero-Cost Abstractions)",
                    body = "Rust'ta `iter().map().filter()` zincirleri C tarzı elle optimize edilmiş ham döngülerle tamamen aynı (bazen daha hızlı) makine koduna derlenir.",
                    tip = "İteratörler tembeldir (lazy); sonuna `.collect()` veya `.sum()` gibi bir tüketici metot eklenene kadar hiçbir işlem çalışmaz."
                )
            ),
            codeExample = "fn main() {\n    let sayilar = vec![1, 2, 3, 4, 5, 6];\n    \n    // Çift sayıların karelerini hesaplayıp yeni vektöre toplayalım:\n    let cift_kareler: Vec<i32> = sayilar\n        .iter()\n        .filter(|&&x| x % 2 == 0)\n        .map(|&x| x * x)\n        .collect();\n        \n    println!(\"Çift Kareler: {:?}\", cift_kareler); // [4, 16, 36]\n}",
            codeExplanation = "filter ve map tembelce bağlandı, collect() ile sonuç tek bir bellek tahsisiyle yeni Vec'e toplandı.",
            realWorldExample = "Büyük veri işleme hatlarında (Polars DataFrame) milyonlarca veri satırı Rust Iterator pipeline'ları ile SIMD seviyesinde işlenir.",
            practicalTask = "Bir string vektöründeki kelimelerin uzunlukları toplamını iter().map().sum() ile hesaplayın.",
            starterPlaygroundCode = "fn main() {\n    let v = vec![1, 2, 3];\n    let toplam: i32 = v.into_iter().sum();\n    println!(\"{}\", toplam);\n}",
            miniQuestion = MiniQuestion(
                id = "rs_q_10",
                question = "Yakalanan ortam değişkeninin sahipliğini (ownership) tamamen içine alıp kopyalamak/taşımak için Closure başına hangi anahtar kelime eklenir?",
                options = listOf("take", "move", "own", "capture"),
                correctIndex = 1,
                explanation = "`move |...|` closure'ı yakaladığı değişkenlerin sahipliğini closure gövdesine taşır (özellikle thread'lere closure aktarırken zorunludur)."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_rs_10",
                lessonId = "rs_10",
                title = "Fonksiyonel Kareler Toplamı",
                instructions = "&[i32] dilimi alıp içindeki pozitif sayıların karelerinin toplamını iteratör zinciri ile hesaplayan kareler_toplami(dilim: &[i32]) -> i32 fonksiyonunu yazın.",
                exampleInput = "dilim = &[1, 2, 3]",
                exampleOutput = "14 (1+4+9)",
                starterCode = "pub fn kareler_toplami(dilim: &[i32]) -> i32 {\n    // Kodunu buraya yaz:\n    0\n}",
                solutionCode = "pub fn kareler_toplami(dilim: &[i32]) -> i32 {\n    dilim.iter().filter(|&&x| x > 0).map(|&x| x * x).sum()\n}",
                hints = listOf("dilim.iter().filter(|&&x| x > 0).map(|&x| x * x).sum() kullanın."),
                testCases = listOf(
                    TestCase("kareler_toplami(&[1, 2, 3])", "14", "Kareler toplamı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "rs_quiz_10_1",
                    lessonId = "rs_10",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Neden bir Closure 'FnOnce' olarak işaretlenir?",
                    options = listOf("Sadece bir kez derlendiği için", "Yakaladığı bir değişkenin sahipliğini (ownership) taşıdığı (consume ettiği) için ikinci kez çağrılması bellek güvenliğini bozacağından yalnızca tek bir kez çalıştırılabilir", "Daha hızlı olduğu için", "Statik olduğu için"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Değeri tüketen closure'lar yalnızca bir kez (FnOnce) çağrılabilir.",
                    explanationWrong = "Sahipliği tüketilen değişken ikinci kez çağrılamaz.",
                    reviewTopic = "FnOnce Trait"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "iter() ile into_iter() farkı nedir?",
                    answer = "`iter()` elemanları değişmez referans (`&T`) olarak ödünç alırken, `into_iter()` koleksiyonun sahipliğini tüketerek elemanların kendilerini (`T`) döner."
                )
            ),
            completionCriteria = listOf(
                "Fn, FnMut ve FnOnce farklarını bilmek",
                "move closure'larını doğru yerde kullanabilmek",
                "İteratör adaptörlerini (map, filter, fold) etkin kullanmak"
            )
        ),

        // ==========================================
        // DERS 11: KORKUSUZ EŞZAMANLILIK (FEARLESS CONCURRENCY)
        // ==========================================
        Lesson(
            id = "rs_11",
            courseId = "rust",
            sectionId = "rs_sec_6",
            title = "Korkusuz Eşzamanlılık: thread::spawn, Kanallar & Arc<Mutex<T>>",
            shortDesc = "Data Race'siz çoklu iş parçacığı: std::thread, Mesajlaşma Kanalları (mpsc), Çoklu Sahiplik (Arc), Karşılıklı Dışlama (Mutex) ve Send / Sync Traitleri.",
            level = CourseLevel.EXPERT,
            order = 11,
            isPremium = true,
            learningObjectives = listOf(
                "thread::spawn ile işletim sistemi thread'leri açıp join() ile beklemek",
                "mpsc (Multiple Producer, Single Consumer) kanalları ile aktör tarzı mesajlaşmak",
                "Arc<Mutex<T>> ile thread'ler arası güvenli paylaşımlı bellek yönetmek"
            ),
            prerequisites = listOf("İteratörler ve Kapanışlar (Closures)"),
            subtopics = listOf("thread::spawn & join()", "Mesajlaşma (mpsc::channel)", "Arc (Atomic Reference Counted)", "Mutex<T> & MutexGuard RAII", "Send ve Sync Trait Kuralları"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Korkusuz Eşzamanlılık (Fearless Concurrency)",
                    body = "Diğer dillerde Data Race çalışma anında sessizce veriyi bozar. Rust'ta eğer bir veri tipi thread-safe değilse derleyici KODU DERLEMEZ! Bu garanti `Send` (Thread'ler arası taşınabilir) ve `Sync` (Thread'ler arası referans paylaşılabilir) trait'leri ile sağlanır.",
                    codeSnippet = "use std::sync::{Arc, Mutex};\nuse std::thread;\n\nlet sayac = Arc::new(Mutex::new(0));\nlet s_kopya = Arc::clone(&sayac);\n\nthread::spawn(move || {\n    let mut kilit = s_kopya.lock().unwrap();\n    *kilit += 1;\n});"
                ),
                LessonContentBlock(
                    subtitle = "2. Arc<Mutex<T>> İkilisi",
                    body = "• `Arc<T>`: Çoklu thread'ler için atomik referans sayacı (Atomic Reference Counting).\n• `Mutex<T>`: Veriyi sarmalayan kilit. Kilidi alan `MutexGuard` scope bitince kilidi otomatik serbest bırakır (RAII).",
                    tip = "Tek thread'li `Rc<RefCell<T>>` asla thread'ler arasında taşınamaz (`!Send`); thread'ler için daima `Arc<Mutex<T>>` kullanılır."
                )
            ),
            codeExample = "use std::sync::{Arc, Mutex};\nuse std::thread;\n\nfn main() {\n    let sayac = Arc::new(Mutex::new(0));\n    let mut handles = vec![];\n    \n    for _ in 0..5 {\n        let sayac_klon = Arc::clone(&sayac);\n        let h = thread::spawn(move || {\n            let mut num = sayac_klon.lock().unwrap();\n            *num += 1;\n        });\n        handles.push(h);\n    }\n    \n    for h in handles { h.join().unwrap(); }\n    println!(\"Son Sayaç Değeri: {}\", *sayac.lock().unwrap()); // Kesinlikle 5!\n}",
            codeExplanation = "Arc::clone ile 5 thread'e referans dağıtıldı; her thread lock().unwrap() ile sayacı atomik olarak artırdı.",
            realWorldExample = "Yüksek performanslı web sunucusu Actix-Web ve Toki async runtime'ı milyonlarca isteği Arc/Mutex ve kanal mimarisiyle işler.",
            practicalTask = "mpsc kanalı kullanarak arka plan thread'inden ana thread'e 'Tamamlandı' mesajı gönderen bir kod yazın.",
            starterPlaygroundCode = "use std::thread;\nfn main() {\n    let h = thread::spawn(|| 42);\n    println!(\"{}\", h.join().unwrap());\n}",
            miniQuestion = MiniQuestion(
                id = "rs_q_11",
                question = "Rust'ta birden fazla iş parçacığının (thread) aynı Heap verisine eşzamanlı ve güvenli şekilde sahip olabilmesi için hangi atomik akıllı işaretçi kullanılır?",
                options = listOf("Rc<T>", "Arc<T>", "Box<T>", "RefCell<T>"),
                correctIndex = 1,
                explanation = "Arc (Atomic Reference Counted) atomik referans sayacı ile verinin thread'ler arası çoklu sahipliğini yönetir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_rs_11",
                lessonId = "rs_11",
                title = "Paralel Thread Toplayıcı",
                instructions = "thread::spawn kullanarak 1'den 100'e kadar olan sayıları arka plan thread'inde toplayıp join() ile ana akışa döndüren paralel_topla() -> i32 fonksiyonunu yazın.",
                exampleInput = "paralel_topla()",
                exampleOutput = "5050",
                starterCode = "use std::thread;\npub fn paralel_topla() -> i32 {\n    // Kodunu buraya yaz:\n    0\n}",
                solutionCode = "use std::thread;\npub fn paralel_topla() -> i32 {\n    let handle = thread::spawn(|| {\n        (1..=100).sum::<i32>()\n    });\n    handle.join().unwrap()\n}",
                hints = listOf("thread::spawn(|| (1..=100).sum::<i32>()).join().unwrap()"),
                testCases = listOf(
                    TestCase("paralel_topla()", "5050", "Paralel toplam")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "rs_quiz_11_1",
                    lessonId = "rs_11",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Rust'ta standart 'Rc<T>' nesnesi neden thread::spawn içine 'move' edilemez?",
                    options = listOf("Çok büyük olduğu için", "Rc<T> atomik olmayan basit sayaç kullandığı için 'Send' trait'ini uygulamaz; derleyici veri yarışını önlemek için derlemeyi reddeder", "Sadece string'lerle çalıştığı için", "Syntax hatası olduğu için"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Derleyici Send/Sync trait denetimi ile thread-safe olmayan yapıların thread'lere geçişini kesinlikle engeller.",
                    explanationWrong = "Rc Send trait'ini uygulamaz; yerine Arc kullanılmalıdır.",
                    reviewTopic = "Send and Sync Traits"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Mutex Poisioning nedir?",
                    answer = "Bir thread Mutex kilidini elinde tutarken `panic!` ile çökerse mutex zehirlenir (poisoned). Bir sonraki thread `.lock()` çağırdığında Result içinde zehirlenme hatası alır."
                )
            ),
            completionCriteria = listOf(
                "thread::spawn ve join döngüsünü yönetebilmek",
                "mpsc kanalları ile mesajlaşabilmek",
                "Arc<Mutex<T>> ile thread-safe paylaşımlı bellek kurabilmek"
            )
        ),

        // ==========================================
        // DERS 12: UNSAFE RUST, FFI & MAKROLAR
        // ==========================================
        Lesson(
            id = "rs_12",
            courseId = "rust",
            sectionId = "rs_sec_6",
            title = "Unsafe Rust (*const/*mut), FFI & Makro Sistemi",
            shortDesc = "Derleyicinin prangalarını kırmak: unsafe blokları, Ham İşaretçiler (*const T, *mut T), C/C++ FFI entegrasyonu ve macro_rules! deklaratif makrolar.",
            level = CourseLevel.EXPERT,
            order = 12,
            isPremium = true,
            learningObjectives = listOf(
                "Unsafe Rust'ın 5 süper gücünü ve kullanım sınırlarını anlamak",
                "Ham İşaretçileri (*const T, *mut T) oluşturup güvenle dereference etmek",
                "C FFI (Foreign Function Interface) ile harici C kütüphanelerini çağırmak ve macro_rules! yazmak"
            ),
            prerequisites = listOf("Korkusuz Eşzamanlılık ve İleri Rust"),
            subtopics = listOf("Unsafe Rust'ın 5 Yeteneği", "Ham İşaretçiler (*const T, *mut T)", "extern 'C' & FFI", "macro_rules! Deklaratif Makrolar", "Prosedürel Makrolar (Derive / Attribute)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Unsafe Rust'ın 5 Süper Gücü",
                    body = "`unsafe { }` bloğu içinde şunlar yapılabilir:\n1. Ham işaretçileri (raw pointers) dereference etmek.\n2. Unsafe fonksiyonları/metotları çağırmak.\n3. Değiştirilebilir statik değişkenlere (static mut) erişmek/yazmak.\n4. Unsafe trait uygulamak.\n5. `union` alanlarına erişmek.",
                    codeSnippet = "let mut sayi = 42;\nlet r1 = &sayi as *const i32; // Ham işaretçi (Safe)\nlet r2 = &mut sayi as *mut i32;\n\nunsafe {\n    *r2 = 100; // Sadece unsafe içinde dereference edilebilir!\n    println!(\"r1: {}\", *r1);\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. C FFI (Foreign Function Interface)",
                    body = "`extern \"C\"` bloğu ile C standart kütüphanesindeki veya işletim sistemindeki yerel C fonksiyonları sıfır ek yükle doğrudan çağrılır.",
                    tip = "Unsafe Rust, Rust'ın kurallarını yok saymaz; sadece derleyicinin doğrulayamadığı noktalarda sorumluluğu geliştiriciye bırakır."
                )
            ),
            codeExample = "// Basit bir vektör oluşturma makrosu (macro_rules!):\nmacro_rules! benim_vec {\n    ( \$( \$x:expr ),* ) => {\n        {\n            let mut temp_vec = Vec::new();\n            \$(\n                temp_vec.push(\$x);\n            )*\n            temp_vec\n        }\n    };\n}\n\nfn main() {\n    let v = benim_vec![10, 20, 30];\n    println!(\"Makro ile üretilen vektör: {:?}\", v);\n}",
            codeExplanation = "macro_rules! derleme zamanında kodu genişletti (macro expansion) ve vec![...] benzeri özel bir sözdizimi oluşturdu.",
            realWorldExample = "Linux çekirdeğindeki Rust sürücüleri donanım I/O portlarına ve kesme vektörlerine (Interrupts) doğrudan Unsafe Rust ve ham işaretçilerle erişir.",
            practicalTask = "Bir tamsayı değişkeninin adresini ham işaretçiye (*mut i32) çevirip unsafe blokta değerini değiştiren bir kod yazın.",
            starterPlaygroundCode = "fn main() {\n    let x = 5;\n    let raw = &x as *const i32;\n    unsafe { println!(\"{}\", *raw); }\n}",
            miniQuestion = MiniQuestion(
                id = "rs_q_12",
                question = "Rust'ta ham işaretçiler (*const T veya *mut T) oluşturulurken mi yoksa değerlerine erişilip dereference (*ptr) edilirken mi 'unsafe' bloğu zorunludur?",
                options = listOf("Oluşturulurken", "Yalnızca dereference edilirken (*ptr)", "Her iki durumda da", "Hiçbir zaman"),
                correctIndex = 1,
                explanation = "Ham işaretçi oluşturmak güvenlidir (safe); ancak o bellek adresindeki veriyi okumak veya yazmak (dereferencing) `unsafe` blok gerektirir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_rs_12",
                lessonId = "rs_12",
                title = "Ham İşaretçi ile Değer Değiştirme (Unsafe)",
                instructions = "*mut i32 tipinde ham işaretçi ve yeni bir i32 değer alıp unsafe blok içinde adresteki değeri güncelleyen ham_yaz(ptr: *mut i32, deger: i32) fonksiyonunu yazın.",
                exampleInput = "let mut x = 5; ham_yaz(&mut x as *mut i32, 50);",
                exampleOutput = "x == 50",
                starterCode = "pub fn ham_yaz(ptr: *mut i32, deger: i32) {\n    // Kodunu buraya yaz:\n}",
                solutionCode = "pub fn ham_yaz(ptr: *mut i32, deger: i32) {\n    if !ptr.is_null() {\n        unsafe {\n            *ptr = deger;\n        }\n    }\n}",
                hints = listOf("unsafe { *ptr = deger; } kullanın."),
                testCases = listOf(
                    TestCase("ham_yaz", "50", "Unsafe raw pointer")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "rs_quiz_12_1",
                    lessonId = "rs_12",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Rust'ta Prosedürel Makrolar (Procedural Macros) ne zaman çalışır?",
                    options = listOf("Program çalışırken (Runtime)", "Derleme zamanında (Compile-time) derleyiciye AST eklentisi olarak", "İşletim sistemi başlatılırken", "Testler koşarken"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Prosedürel makrolar derleme anında kaynak kod token akışını (TokenStream) alıp yeni kod üretir.",
                    explanationWrong = "Derleme zamanında AST seviyesinde çalışır.",
                    reviewTopic = "Procedural Macros"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Neden Unsafe Rust vardır?",
                    answer = "Çünkü donanım erişimi, işletim sistemi çekirdekleri, düşük seviyeli bellek yöneticileri ve C kütüphaneleri (FFI) doğası gereği derleyicinin matematiksel olarak doğrulayamayacağı işlemler gerektirir."
                )
            ),
            completionCriteria = listOf(
                "Unsafe Rust'ın 5 yeteneğini ve kurallarını bilmek",
                "Ham işaretçileri (*const, *mut) güvenle yönetebilmek",
                "macro_rules! ile deklaratif makrolar yazabilmek"
            )
        )
    )
}
