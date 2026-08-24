package com.example.data.catalog

import com.example.model.*

/**
 * C++ Complete Official Curriculum (12 Sequential Lessons):
 * BEGINNER -> FUNDAMENTAL -> INTERMEDIATE -> ADVANCED -> EXPERT
 * Seamless progression from basic syntax & pointers to STL, Concurrency & Lock-Free architecture.
 */
object CppCurriculum {

    fun getSections(): List<CourseSection> = listOf(
        CourseSection(
            id = "cpp_sec_1",
            courseId = "cpp",
            title = "Seviye 1 – C++ Temelleri, Sözdizimi & Kontrol Akışı",
            level = CourseLevel.BEGINNER,
            order = 1,
            description = "C++ yapısı, main(), std::cout/cin, temel veri tipleri, if-else, switch ve for/while döngüleri.",
            learningObjectives = listOf("C++ derleme modeli & main()", "Temel veri tipleri & std::cin/cout", "if-else ve switch karar blokları", "for ve while döngüleri"),
            prerequisites = listOf("Temel bilgisayar kullanım bilgisi")
        ),
        CourseSection(
            id = "cpp_sec_2",
            courseId = "cpp",
            title = "Seviye 2 – Fonksiyonlar, Diziler, Pointerlar & Referanslar",
            level = CourseLevel.BEGINNER,
            order = 2,
            description = "Fonksiyon parametre aktarımı (Pass by Value, Reference, Pointer), std::vector, std::string, Pointer aritmetiği ve bellek adresleri (&, *).",
            learningObjectives = listOf("Pass by Value vs Reference (&)", "std::vector ve std::string kullanımı", "Pointer (& ve *) bellek erişimi", "Stack vs Heap ayrımı"),
            prerequisites = listOf("C++ Temelleri & Kontrol Akışı")
        ),
        CourseSection(
            id = "cpp_sec_3",
            courseId = "cpp",
            title = "Seviye 3 – OOP, RAII & Akıllı İşaretçiler (Smart Pointers)",
            level = CourseLevel.INTERMEDIATE,
            order = 3,
            description = "Sınıflar, Kurucu ve Yıkıcılar (Constructors & Destructors), RAII felsefesi, new/delete ve Modern Akıllı Pointerlar (unique_ptr, shared_ptr).",
            learningObjectives = listOf("Sınıflar ve Erişim Belirteçleri", "RAII prensibi ile sıfır bellek sızıntısı", "std::unique_ptr ve std::shared_ptr", "Rule of 5 ve Taşıma Semantiği (Move)"),
            prerequisites = listOf("C++ Pointerlar ve Fonksiyonlar")
        ),
        CourseSection(
            id = "cpp_sec_4",
            courseId = "cpp",
            title = "Seviye 4 – Kalıtım, Sanal Fonksiyonlar & vtable Mimarisi",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            description = "Kalıtım (public/protected/private), Sanal Fonksiyonlar (virtual, override), Çok Biçimlilik (Polymorphism), Soyut Sınıflar ve vtable bellek düzeni.",
            learningObjectives = listOf("Kalıtım & çok biçimlilik (Polymorphism)", "virtual fonksiyonlar ve sanal yıkıcılar", "vtable & vptr mekanizması", "Saf sanal fonksiyonlar ve Interface tasarımı"),
            prerequisites = listOf("C++ OOP Temelleri ve RAII")
        ),
        CourseSection(
            id = "cpp_sec_5",
            courseId = "cpp",
            title = "Seviye 5 – Standart Şablon Kütüphanesi (STL) & Modern Şablonlar (Templates)",
            level = CourseLevel.ADVANCED,
            order = 5,
            description = "STL Kapları (vector, map, unordered_map), İteratörler, Algoritmalar, Lambdalar, Şablonlar (Templates) ve C++20 Concepts.",
            learningObjectives = listOf("STL kapları ve algoritmaları (std::sort, transform)", "Lambda ifadeleri ve yakalama listeleri ([&, =])", "Fonksiyon ve Sınıf Şablonları (Templates)", "C++20 Concepts ile tip kısıtlama"),
            prerequisites = listOf("C++ Kalıtım ve Akıllı İşaretçiler")
        ),
        CourseSection(
            id = "cpp_sec_6",
            courseId = "cpp",
            title = "Seviye 6 – Eşzamanlılık, Lock-Free & Düşük Seviye Sistem Mimarisi",
            level = CourseLevel.EXPERT,
            order = 6,
            description = "std::thread, std::mutex, std::atomic, Lock-Free Veri Yapıları, Memory Ordering (std::memory_order) ve Özel Bellek Tahsisçileri (Custom Allocators).",
            learningObjectives = listOf("std::thread ve std::mutex ile iş parçacığı güvenliği", "std::atomic ve CAS (Compare-And-Swap) mantığı", "Lock-Free Ring Buffer & Stack mimarisi", "Custom Memory Allocator tasarımı"),
            prerequisites = listOf("İleri C++ Şablonlar ve STL Mimarisi")
        )
    )

    fun getLessons(): List<Lesson> = listOf(
        // ==========================================
        // DERS 1: TEMEL SÖZDİZİMİ & I/O (ÜCRETSİZ)
        // ==========================================
        Lesson(
            id = "cpp_1",
            courseId = "cpp",
            sectionId = "cpp_sec_1",
            title = "C++'a Giriş, main() & Temel Veri Tipleri",
            shortDesc = "C++ derleme modeli, main() fonksiyonu, iostream (std::cout, std::cin), temel tipler (int, double, char, bool) ve sabitler (const, constexpr).",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false,
            learningObjectives = listOf(
                "C++ derleyici (g++/clang++) ve bağlayıcı (linker) mantığını kavramak",
                "std::cout ve std::cin ile standart girdi/çıktı akışlarını yönetmek",
                "Temel veri tiplerini ve constexpr sabitlerini öğrenmek"
            ),
            prerequisites = listOf("Ön koşul gerekmez. Sıfırdan başlar."),
            subtopics = listOf("main() Giriş Fonksiyonu", "#include <iostream>", "std::cout << & std::cin >>", "Temel Veri Tipleri", "const & constexpr"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. C++ main() ve Akışlar (Streams)",
                    body = "Her C++ programı `int main()` ile başlar ve 0 döndürerek işletim sistemine başarılı çıkış bildirir. Ekrana yazdırmak için `std::cout <<`, kullanıcıdan girdi almak için `std::cin >>` kullanılır.",
                    codeSnippet = "#include <iostream>\n\nint main() {\n    std::cout << \"C++ Dünyasına Hoş Geldiniz!\" << std::endl;\n    return 0;\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. constexpr: Derleme Zamanı Hesaplaması",
                    body = "• const: Değiştirilemeyen çalışma veya derleme zamanı sabiti.\n• constexpr: Kesinlikle derleme zamanında hesaplanan sıfır ek yük getiren sabitlerdir.",
                    tip = "C++'ta her satır noktalı virgül (;) ile bitmek zorundadır."
                )
            ),
            codeExample = "#include <iostream>\n\nint main() {\n    int yas = 25;\n    double maas = 75000.50;\n    char seviye = 'A';\n    bool aktif = true;\n    \n    std::cout << \"Yaş: \" << yas << \", Seviye: \" << seviye << \"\\n\";\n    return 0;\n}",
            codeExplanation = "int, double, char ve bool temel ilkel tiplerdir. << operatörü ile değerler std::cout akışına zincirlenir.",
            realWorldExample = "Oyun motorları (Unreal Engine), işletim sistemi çekirdekleri (Windows/Linux) ve uzay sistemleri en yüksek hız için C++ ile yazılır.",
            practicalTask = "İki sayıyı kullanıcıdan std::cin ile alıp toplamını ve çarpımını ekrana yazdıran bir C++ kodu yazın.",
            starterPlaygroundCode = "#include <iostream>\nint main() {\n    int a = 10, b = 20;\n    std::cout << \"Toplam: \" << (a + b) << \"\\n\";\n    return 0;\n}",
            miniQuestion = MiniQuestion(
                id = "cpp_q_1",
                question = "C++'ta bir değerin kesinlikle derleme zamanında hesaplanacağını garanti eden modern anahtar kelime hangisidir?",
                options = listOf("const", "constexpr", "static", "inline"),
                correctIndex = 1,
                explanation = "constexpr (constant expression) derleyiciye ifadenin derleme zamanında çözümleneceğini bildirir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_cpp_1",
                lessonId = "cpp_1",
                title = "İki Sayının Toplamı",
                instructions = "İki tamsayı (int a, int b) alıp toplamını döndüren topla(a, b) fonksiyonunu yazın.",
                exampleInput = "a = 15, b = 25",
                exampleOutput = "40",
                starterCode = "int topla(int a, int b) {\n    // Kodunu buraya yaz:\n    return 0;\n}",
                solutionCode = "int topla(int a, int b) {\n    return a + b;\n}",
                hints = listOf("return a + b; yazın."),
                testCases = listOf(
                    TestCase("topla(15, 25)", "40", "Toplam kontrolü")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "cpp_quiz_1_1",
                    lessonId = "cpp_1",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "C++'ta 'std::endl' ile '\\n' arasındaki en temel fark nedir?",
                    options = listOf("std::endl metni büyütür", "std::endl hem yeni satıra geçer hem de çıktı tamponunu (buffer flush) anında diske/ekrana boşaltır", "Farkları yoktur", "\\n daha yavaştır"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! std::endl her seferinde flush yaptığı için performans gerektiren döngülerde '\\n' tercih edilir.",
                    explanationWrong = "std::endl ek olarak buffer flush gerçekleştirir.",
                    reviewTopic = "C++ Akışları"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "using namespace std; neden büyük projelerde önerilmez?",
                    answer = "Çünkü std kütüphanesindeki binlerce isim (örneğin std::distance, std::count) projedeki kendi fonksiyonlarınızla isim çakışmasına (name pollution/collision) neden olabilir."
                )
            ),
            completionCriteria = listOf(
                "main() fonksiyonunu ve standart akışları kurabilmek",
                "Temel veri tiplerini tanımlayabilmek",
                "constexpr ile derleme zamanı sabitleri oluşturabilmek"
            )
        ),

        // ==========================================
        // DERS 2: KOŞULLAR, OPERATÖRLER & DÖNGÜLER (ÜCRETSİZ)
        // ==========================================
        Lesson(
            id = "cpp_2",
            courseId = "cpp",
            sectionId = "cpp_sec_1",
            title = "Kontrol Akışı: if-else, switch & Döngüler",
            shortDesc = "Karşılaştırma ve mantıksal operatörler, if, else if, else, switch-case, for, while ve range-based for döngüleri.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false,
            learningObjectives = listOf(
                "if-else ve switch-case kontrol bloklarını etkin kullanmak",
                "for, while ve do-while döngüleri kurmak",
                "Modern Range-based for döngüsü ile dizileri temizce gezmek"
            ),
            prerequisites = listOf("C++'a Giriş, main() & Temel Veri Tipleri"),
            subtopics = listOf("Mantıksal Operatörler (&&, ||, !)", "if - else if - else", "switch-case & break", "for & while Döngüleri", "Range-based for (auto)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. if-else ve switch Karar Yapıları",
                    body = "C++ koşul ifadeleri parantez içinde yazılır. switch-case sadece tamsayı ve enum tipleriyle çalışır.",
                    codeSnippet = "int notu = 85;\nif (notu >= 90) std::cout << \"AA\";\nelse if (notu >= 80) std::cout << \"BA\";\nelse std::cout << \"CC\";"
                ),
                LessonContentBlock(
                    subtitle = "2. Range-Based for Döngüsü",
                    body = "C++11 ile gelen `for (const auto& item : koleksiyon)` sözdizimi dizileri indeks hatası riski olmadan en hızlı şekilde gezer.",
                    tip = "Diziyi değiştirmiyorsanız kopyalamayı önlemek için `const auto&` kullanın."
                )
            ),
            codeExample = "#include <iostream>\n\nint main() {\n    int sayilar[] = {10, 20, 30, 40, 50};\n    int toplam = 0;\n    \n    for (const auto& s : sayilar) {\n        toplam += s;\n    }\n    \n    std::cout << \"Dizi Toplamı: \" << toplam << \"\\n\";\n    return 0;\n}",
            codeExplanation = "const auto& s dizideki elemanları kopyalamadan doğrudan referansla okur ve toplam değişkenine ekler.",
            realWorldExample = "Oyun döngüleri (Game Loops) `while (oyunDevamEdiyor)` yapısıyla 60 FPS hızında sürekli render ve fizik hesaplamaları yapar.",
            practicalTask = "1'den 100'e kadar olan sayılardan hem 3'e hem 5'e bölünenleri ekrana yazdıran bir C++ for döngüsü yazın.",
            starterPlaygroundCode = "#include <iostream>\nint main() {\n    for (int i = 1; i <= 5; ++i) std::cout << i << ' ';\n    return 0;\n}",
            miniQuestion = MiniQuestion(
                id = "cpp_q_2",
                question = "C++11 Range-based for döngüsünde elemanların kopyalanmasını önlemek için hangi sözdizimi tercih edilmelidir?",
                options = listOf("for (auto item : arr)", "for (const auto& item : arr)", "for (int item : arr)", "for (auto* item : arr)"),
                correctIndex = 1,
                explanation = "const auto& elemanın bellekte kopyasını oluşturmaz, doğrudan adresinden güvenle (read-only) okur."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_cpp_2",
                lessonId = "cpp_2",
                title = "Pozitif Sayıların Çarpımı",
                instructions = "1'den n'e kadar olan sayıların çarpımını (faktöriyelini) döngü kullanarak hesaplayan faktoriyel(n) fonksiyonunu yazın.",
                exampleInput = "n = 5",
                exampleOutput = "120",
                starterCode = "long long faktoriyel(int n) {\n    // Kodunu buraya yaz:\n    return 1;\n}",
                solutionCode = "long long faktoriyel(int n) {\n    long long sonuc = 1;\n    for (int i = 2; i <= n; ++i) {\n        sonuc *= i;\n    }\n    return sonuc;\n}",
                hints = listOf("for döngüsüyle 2'den n'e kadar çarpın."),
                testCases = listOf(
                    TestCase("faktoriyel(5)", "120", "5! hesaplama")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "cpp_quiz_2_1",
                    lessonId = "cpp_2",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "switch-case ifadesinde 'break' yazılması unutulursa ne gerçekleşir?",
                    options = listOf("Derleme hatası verir", "Fall-through gerçekleşir; yani eşleşen case'den sonraki tüm case blokları koşula bakılmaksızın sırayla çalışır", "Program anında kapanır", "Sonsuz döngüye girer"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! break yazılmazsa alt case'lere doğru akış (fall-through) devam eder.",
                    explanationWrong = "Fall-through oluşur ve alt case'ler çalışır.",
                    reviewTopic = "switch-case"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "++i ile i++ arasındaki performans farkı nedir?",
                    answer = "İlkel tiplerde derleyici optimize eder ancak karmaşık iteratör nesnelerinde `i++` önceki değerin kopyasını oluşturmak zorunda olduğu için `++i` (pre-increment) daha hızlı ve tercih edilendir."
                )
            ),
            completionCriteria = listOf(
                "if-else ve switch-case kontrol akışlarını kurabilmek",
                "Range-based for döngüsünü const referans ile kullanabilmek",
                "Döngü optimizasyon kurallarını bilmek"
            )
        ),

        // ==========================================
        // DERS 3: FONKSİYONLAR, PASS BY VALUE & REFERENCE
        // ==========================================
        Lesson(
            id = "cpp_3",
            courseId = "cpp",
            sectionId = "cpp_sec_2",
            title = "Fonksiyonlar, Referanslar (&) & Parametre Aktarımı",
            shortDesc = "Fonksiyon prototipleri, Değerle Aktarım (Pass by Value), Referansla Aktarım (Pass by Reference &), const referanslar ve Function Overloading.",
            level = CourseLevel.BEGINNER,
            order = 3,
            isPremium = false,
            learningObjectives = listOf(
                "Pass by Value ile Pass by Reference (&) arasındaki bellek farkını kavramak",
                "Büyük veri yapılarını kopyalamamak için 'const T&' parametre tasarımını öğrenmek",
                "Function Overloading (Fonksiyon Aşırı Yükleme) kurallarını uygulamak"
            ),
            prerequisites = listOf("C++ Kontrol Akışı ve Döngüler"),
            subtopics = listOf("Fonksiyon Bildirimi & Tanımı", "Pass by Value (Kopyalama)", "Pass by Reference (&)", "const Reference (const T&)", "Function Overloading"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Pass by Value vs Pass by Reference",
                    body = "• Pass by Value: Değişkenin tam bir kopyası fonksiyona gönderilir. Orijinal değişken değişmez.\n• Pass by Reference (`&`): Değişkenin bellek adresi paylaşılır. Fonksiyondaki değişiklik orijinal değişkeni doğrudan etkiler.",
                    codeSnippet = "void takas(int& a, int& b) {\n    int temp = a;\n    a = b;\n    b = temp;\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. const T& Tasarım Standardı",
                    body = "Büyük nesneler (string, vector vb.) fonksiyona kopyalanmadan ama kazara değiştirilmesini de önleyecek şekilde `const std::string&` olarak geçirilir.",
                    tip = "Modern C++'ta ilkel tipler (int, double) değerle, nesneler (class, struct) const referansla geçirilir."
                )
            ),
            codeExample = "#include <iostream>\n#include <string>\n\nvoid selamla(const std::string& isim) {\n    std::cout << \"Merhaba, \" << isim << \"!\\n\";\n}\n\nvoid ikiKatinaCikar(int& sayi) {\n    sayi *= 2;\n}\n\nint main() {\n    int x = 10;\n    ikiKatinaCikar(x);\n    std::cout << \"x: \" << x << \"\\n\"; // 20\n    return 0;\n}",
            codeExplanation = "ikiKatinaCikar fonksiyonu x'i referans (&) olarak aldığı için x değişkeni doğrudan 20 değerini alır.",
            realWorldExample = "Oyun motorlarında her karede binlerce nesnenin konum vektörleri referans ile güncellenir; kopyalama yapılmaz.",
            practicalTask = "İki sayıyı referans alarak takas eden (swap) bir fonksiyon yazın.",
            starterPlaygroundCode = "#include <iostream>\nvoid artir(int& n) { ++n; }\nint main() { int a = 5; artir(a); std::cout << a; return 0; }",
            miniQuestion = MiniQuestion(
                id = "cpp_q_3",
                question = "C++'ta büyük bir nesneyi fonksiyona kopyalamadan ve fonksiyon içinde değiştirilmesini engelleyerek göndermek için hangi parametre tipi kullanılır?",
                options = listOf("T nesne", "const T& nesne", "T* const nesne", "auto nesne"),
                correctIndex = 1,
                explanation = "const T& hem kopyalama ek yükünü sıfırlar hem de salt-okunur güvenlik sağlar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_cpp_3",
                lessonId = "cpp_3",
                title = "İki Değeri Takas Etme (Swap)",
                instructions = "İki tamsayı referansı (int& a, int& b) alıp değerlerini birbiriyle değiştiren degerleriTakasEt(a, b) fonksiyonunu yazın.",
                exampleInput = "a = 3, b = 7",
                exampleOutput = "a = 7, b = 3",
                starterCode = "void degerleriTakasEt(int& a, int& b) {\n    // Kodunu buraya yaz:\n}",
                solutionCode = "void degerleriTakasEt(int& a, int& b) {\n    int gecici = a;\n    a = b;\n    b = gecici;\n}",
                hints = listOf("Geçici bir değişken kullanarak a ve b'yi yer değiştirin."),
                testCases = listOf(
                    TestCase("degerleriTakasEt", "Başarılı", "Referans takası")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "cpp_quiz_3_1",
                    lessonId = "cpp_3",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "C++ Function Overloading (Fonksiyon Aşırı Yükleme) neye göre belirlenir?",
                    options = listOf("Yalnızca fonksiyonun dönüş tipine göre", "Fonksiyon adı aynı iken parametre sayısı veya parametre tiplerinin farklı olmasına göre", "Fonksiyonun hangi dosyada olduğuna göre", "Değişken isimlerine göre"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Parametre imzaları (sayı veya tip) farklı olmalıdır. Yalnızca dönüş tipi farklı olan fonksiyonlar overload edilemez.",
                    explanationWrong = "Parametre sayısı veya tiplerinin farklı olması gerekir.",
                    reviewTopic = "Function Overloading"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Inline fonksiyon nedir?",
                    answer = "'inline' anahtar kelimesi derleyiciye fonksiyon çağrısı ek yükünü (stack frame) kaldırıp fonksiyon kodunu doğrudan çağrıldığı yere yapıştırmasını önerir."
                )
            ),
            completionCriteria = listOf(
                "Pass by Value ve Pass by Reference farkını bilmek",
                "const T& kalıbını nesnelerde standart olarak uygulayabilmek",
                "Function Overloading yapabilmek"
            )
        ),

        // ==========================================
        // DERS 4: POINTERLAR, REFERANSLAR & BELLEK ADRESLERİ
        // ==========================================
        Lesson(
            id = "cpp_4",
            courseId = "cpp",
            sectionId = "cpp_sec_2",
            title = "Pointerlar, Referanslar & Bellek Adresleri (&, *)",
            shortDesc = "Adres operatörü (&), Dereference operatörü (*), Pointer aritmetiği, nullptr, Pointer vs Referans farkları ve Bellek Güvenliği.",
            level = CourseLevel.BEGINNER,
            order = 4,
            isPremium = true,
            learningObjectives = listOf(
                "Bellek adreslerini (&) ve işaretçileri (pointer *) okumak ve yönetmek",
                "Dereference (*) ile bellek adresindeki veriye doğrudan erişmek",
                "nullptr kullanımını ve tehlikeli vahşi işaretçileri (dangling pointers) öğrenmek"
            ),
            prerequisites = listOf("C++ Fonksiyonlar ve Referanslar"),
            subtopics = listOf("Bellek Mimarisi & Adres Operatörü (&)", "Pointer Tanımlama (*)", "Dereferencing (*ptr)", "nullptr vs NULL", "Pointer Aritmetiği"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Pointer Anatomisi",
                    body = "Pointer bir değişkenin RAM'deki bellek adresini tutan özel bir değişkendir.\n• `&x`: x değişkeninin bellek adresini verir.\n• `*ptr`: ptr adresindeki asıl veriyi okur veya yazar.",
                    codeSnippet = "int sayi = 42;\nint* ptr = &sayi; // ptr sayi'nin adresini tutar\n*ptr = 100; // sayi artık 100 olur!"
                ),
                LessonContentBlock(
                    subtitle = "2. nullptr Güvenliği",
                    body = "Boş bir pointer tanımlarken C'deki 'NULL' yerine tip güvenli modern C++ 'nullptr' kullanılmalıdır.",
                    tip = "Başlatılmamış pointer'lar (Wild/Dangling Pointer) rastgele bellek alanlarını göstererek programın çökmesine (Segmentation Fault) sebep olur."
                )
            ),
            codeExample = "#include <iostream>\n\nint main() {\n    int a = 10;\n    int* p = &a;\n    \n    std::cout << \"a'nin degeri: \" << a << \"\\n\";\n    std::cout << \"a'nin adresi (&a): \" << p << \"\\n\";\n    std::cout << \"p uzerinden deger (*p): \" << *p << \"\\n\";\n    \n    *p = 50; // Doğrudan RAM adresine yazıldı\n    std::cout << \"a'nin yeni degeri: \" << a << \"\\n\";\n    return 0;\n}",
            codeExplanation = "*p = 50 işlemi p'nin tuttuğu adrese giderek a değişkeninin değerini doğrudan 50 olarak günceller.",
            realWorldExample = "Ağ sürücüleri ve grafik kartı API'leri (Vulkan/DirectX) video belleğine doğrudan pointer adresleri ile komut gönderir.",
            practicalTask = "Bir dizinin elemanlarını pointer aritmetiği `*(ptr + i)` kullanarak ekrana yazdıran bir kod yazın.",
            starterPlaygroundCode = "#include <iostream>\nint main() {\n    int x = 7;\n    int* p = &x;\n    *p = 99;\n    std::cout << x;\n    return 0;\n}",
            miniQuestion = MiniQuestion(
                id = "cpp_q_4",
                question = "C++'ta bir pointer'ın tuttuğu bellek adresindeki asıl değere erişmek için hangi operatör kullanılır?",
                options = listOf("& (Address-of)", "* (Dereference)", "-> (Arrow)", ":: (Scope)"),
                correctIndex = 1,
                explanation = "* operatörü pointer'ın gösterdiği adresteki değere erişmeyi (dereferencing) sağlar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_cpp_4",
                lessonId = "cpp_4",
                title = "Pointer ile Değer İki Katına Çıkarma",
                instructions = "int* tipinde bir pointer alıp işaret ettiği yerdeki sayıyı 2 ile çarpan ikiKatiYap(int* ptr) fonksiyonunu yazın (nullptr kontrolü yapın).",
                exampleInput = "int x = 8; ikiKatiYap(&x);",
                exampleOutput = "x == 16",
                starterCode = "void ikiKatiYap(int* ptr) {\n    // Kodunu buraya yaz:\n}",
                solutionCode = "void ikiKatiYap(int* ptr) {\n    if (ptr != nullptr) {\n        *ptr *= 2;\n    }\n}",
                hints = listOf("if (ptr != nullptr) { *ptr *= 2; } kullanın."),
                testCases = listOf(
                    TestCase("ikiKatiYap", "16", "Pointer çarpımı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "cpp_quiz_4_1",
                    lessonId = "cpp_4",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Pointer ile Referans arasındaki en temel fark nedir?",
                    options = listOf("Referanslar nullptr olamaz ve oluşturulduktan sonra başka bir değişkene yeniden bağlanamaz; Pointerlar ise yeniden yönlendirilebilir ve nullptr olabilir", "Pointer daha güvenlidir", "Referans bellek harcamaz", "Farkları yoktur"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Referanslar takma addır (alias), null olamaz ve re-bind edilemez.",
                    explanationWrong = "Referanslar null olamaz ve yeniden bağlanamaz.",
                    reviewTopic = "Pointer vs Reference"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Pointer Aritmetiği nasıl çalışır?",
                    answer = "`ptr + 1` dendiğinde adres 1 bayt değil, işaret ettiği veri tipinin boyutu kadar (örn. int için 4 bayt) ilerler."
                )
            ),
            completionCriteria = listOf(
                "& ve * operatörlerinin farkını kavramak",
                "nullptr kontrolü ile güvenli pointer kullanımı yapmak",
                "Pointer vs referans kullanım yerlerini ayırt edebilmek"
            )
        ),

        // ==========================================
        // DERS 5: DİNAMİK BELLEK, STACK VS HEAP & RAII
        // ==========================================
        Lesson(
            id = "cpp_5",
            courseId = "cpp",
            sectionId = "cpp_sec_3",
            title = "Dinamik Bellek (Stack vs Heap) & RAII Felsefesi",
            shortDesc = "Stack bellek mimarisi, Heap bellek tahsisi (new, delete, new[], delete[]), Bellek Sızıntıları (Memory Leaks) ve RAII prensibi.",
            level = CourseLevel.INTERMEDIATE,
            order = 5,
            isPremium = true,
            learningObjectives = listOf(
                "Stack ile Heap bellek bölgelerinin çalışma ve hız farklarını anlamak",
                "new ve delete ile dinamik bellek tahsis edip serbest bırakmak",
                "RAII (Resource Acquisition Is Initialization) prensibini kavramak"
            ),
            prerequisites = listOf("Pointerlar, Referanslar ve Bellek Adresleri"),
            subtopics = listOf("Stack Mimarisi & Hızlı Tahsis", "Heap Mimarisi & new / delete", "Dizilerde new[] / delete[]", "Bellek Sızıntısı (Memory Leak)", "RAII Prensibi"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Stack vs Heap",
                    body = "• Stack: Fonksiyon çağrıldığında otomatik açılır, fonksiyon bitince anında temizlenir. Çok hızlıdır ancak boyutu sınırlıdır (~1-8 MB).\n• Heap: Çalışma anında dinamik olarak `new` ile açılır. Boyutu RAM kadardır ancak `delete` ile manuel temizlenmek zorundadır.",
                    codeSnippet = "int* dinamikSayi = new int(100); // Heap'te tahsis edildi\n// Kullanıldıktan sonra:\ndelete dinamikSayi; // Bellek iade edildi\ndinamikSayi = nullptr;"
                ),
                LessonContentBlock(
                    subtitle = "2. RAII (Resource Acquisition Is Initialization)",
                    body = "C++'ın en önemli ilkesidir: Kaynak (bellek, dosya, kilit) bir nesnenin kurucusunda (constructor) tahsis edilir, yıkıcısında (destructor) otomatik serbest bırakılır. Bu sayede istisna (exception) fırlatılsa bile sızıntı olmaz.",
                    tip = "Dinamik diziler tahsis edildiğinde `delete[] dizi;` ile silinmelidir. Düz delete tanımsız davranışa (undefined behavior) yol açar."
                )
            ),
            codeExample = "#include <iostream>\n\nclass GuvenliDizi {\n    int* veri;\n    int boyut;\npublic:\n    GuvenliDizi(int b) : boyut(b), veri(new int[b]) {\n        std::cout << \"Heap bellek acildi.\\n\";\n    }\n    ~GuvenliDizi() {\n        delete[] veri; // RAII: Scope bitince otomatik temizlenir\n        std::cout << \"Heap bellek serbest birakildi.\\n\";\n    }\n};\n\nint main() {\n    {\n        GuvenliDizi d(1000); // Blok bitince yıkıcı otomatik çalışır\n    }\n    std::cout << \"Bloktan cikildi.\\n\";\n    return 0;\n}",
            codeExplanation = "GuvenliDizi nesnesi RAII uygular. Blok bittiği an yıkıcı (~GuvenliDizi) çalışır ve delete[] ile bellek sızıntısını sıfırlar.",
            realWorldExample = "Chromium ve Firefox tarayıcıları tab sekmeleri kapandığında gigabaytlarca DOM nesnesini RAII yıkıcıları ile temizler.",
            practicalTask = "RAII prensibiyle bir dosya açan ve yıkıcısında dosyayı otomatik kapatan bir DosyaYoneticisi sınıfı yazın.",
            starterPlaygroundCode = "#include <iostream>\nint main() {\n    int* p = new int(42);\n    std::cout << *p;\n    delete p;\n    return 0;\n}",
            miniQuestion = MiniQuestion(
                id = "cpp_q_5",
                question = "C++'ta 'new int[50]' ile tahsis edilen dinamik bir dizi bellekten nasıl serbest bırakılmalıdır?",
                options = listOf("delete ptr;", "delete[] ptr;", "free(ptr);", "ptr.clear();"),
                correctIndex = 1,
                explanation = "new[] ile açılan diziler mutlaka delete[] ile silinmelidir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_cpp_5",
                lessonId = "cpp_5",
                title = "Dinamik Bellek Toplayıcı",
                instructions = "n elemanlı dinamik bir int dizisi tahsis eden, 1'den n'e kadar dolduran, toplamını hesaplayıp belleği delete[] ile temizleyerek toplamı döndüren dinamikToplam(n) fonksiyonunu yazın.",
                exampleInput = "n = 4",
                exampleOutput = "10 (1+2+3+4)",
                starterCode = "int dinamikToplam(int n) {\n    // Kodunu buraya yaz:\n    return 0;\n}",
                solutionCode = "int dinamikToplam(int n) {\n    int* dizi = new int[n];\n    int toplam = 0;\n    for (int i = 0; i < n; ++i) {\n        dizi[i] = i + 1;\n        toplam += dizi[i];\n    }\n    delete[] dizi;\n    return toplam;\n}",
                hints = listOf("new int[n] ile tahsis edip delete[] dizi ile temizleyin."),
                testCases = listOf(
                    TestCase("dinamikToplam(4)", "10", "Dinamik toplam")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "cpp_quiz_5_1",
                    lessonId = "cpp_5",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "RAII prensibinin en büyük mimari avantajı nedir?",
                    options = listOf("Programı daha küçük boyutlu yapması", "Fonksiyon ortasında hata fırlatılsa (exception) bile yerel nesnelerin yıkıcıları çalışarak bellek ve kaynak sızıntısını tamamen önlemesi", "Derlemeyi hızlandırması", "Grafik performansını artırması"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Stack unwinding sırasında tüm yıkıcılar çağrılır ve kaynaklar %100 güvenle serbest bırakılır.",
                    explanationWrong = "RAII istisna durumlarında dahi kaynakların otomatik temizlenmesini garanti eder.",
                    reviewTopic = "RAII"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Bellek Sızıntısı (Memory Leak) nasıl tespit edilir?",
                    answer = "Linux ve macOS'ta Valgrind (`valgrind --leak-check=full`), modern derleyicilerde ise AddressSanitizer (`-fsanitize=address`) bayrağı kullanılarak tespit edilir."
                )
            ),
            completionCriteria = listOf(
                "Stack ve Heap bellek davranışını açıklayabilmek",
                "new ve delete eşleşmesini hatasız yapabilmek",
                "RAII prensibiyle kaynak yöneten sınıflar tasarlayabilmek"
            )
        ),

        // ==========================================
        // DERS 6: OOP TEMELLERİ: SINIFLAR, ERİŞİM & KURUCULAR
        // ==========================================
        Lesson(
            id = "cpp_6",
            courseId = "cpp",
            sectionId = "cpp_sec_3",
            title = "OOP Temelleri: Sınıflar, Kurucular & Kapsülleme",
            shortDesc = "Sınıf yapısı, public/private/protected belirteçleri, Kurucu ve Yıkıcılar, Member Initializer Lists ve const metotlar.",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true,
            learningObjectives = listOf(
                "C++ sınıfı tanımlamak ve kapsülleme (encapsulation) kurallarını uygulamak",
                "Member Initializer List ile alanları verimli başlatmak",
                "const metotlar ile nesne güvenliği sağlamak"
            ),
            prerequisites = listOf("Dinamik Bellek & RAII"),
            subtopics = listOf("class vs struct Farkı", "public vs private", "Kurucu (Constructor) & Yıkıcı (Destructor)", "Member Initializer List (:)", "const Member Functions"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. class vs struct ve Erişim Belirteçleri",
                    body = "C++'ta `class` alanları varsayılan olarak `private` iken, `struct` alanları varsayılan olarak `public`tir. Kapsülleme için kritik veriler private yapılır ve getter/setter ile kontrol edilir.",
                    codeSnippet = "class BankaHesabi {\nprivate:\n    double bakiye;\npublic:\n    BankaHesabi(double ilkBakiye) : bakiye(ilkBakiye) {}\n    double getBakiye() const { return bakiye; }\n};"
                ),
                LessonContentBlock(
                    subtitle = "2. Member Initializer List Neden Zorunludur?",
                    body = "Kurucu gövdesinde atama yapmak nesneyi önce varsayılanla başlatıp sonra tekrar yazar. Initializer List (`: alan(deger)`) nesneyi doğrudan o değerle üretir; const ve referans alanlar için zorunludur.",
                    tip = "Nesnenin durumunu değiştirmeyen tüm okuma metotlarının sonuna `const` eklenmelidir."
                )
            ),
            codeExample = "#include <iostream>\n#include <string>\n\nclass Oyuncu {\nprivate:\n    std::string isim;\n    int can;\npublic:\n    Oyuncu(const std::string& i, int c = 100) : isim(i), can(c) {}\n    \n    void hasarAl(int miktar) {\n        can -= miktar;\n        if (can < 0) can = 0;\n    }\n    \n    int getCan() const { return can; }\n    std::string getIsim() const { return isim; }\n};\n\nint main() {\n    Oyuncu o(\"Savasci\");\n    o.hasarAl(35);\n    std::cout << o.getIsim() << \" Kalan Can: \" << o.getCan() << \"\\n\";\n    return 0;\n}",
            codeExplanation = "can alanı private yapılarak dışarıdan rastgele bozulması engellendi. hasarAl() metodu kontrollü güncelleme sağladı.",
            realWorldExample = "Oyun motorlarında Entity-Component sistemleri ve arayüz widget'ları kapsüllenmiş C++ sınıfları olarak modellenir.",
            practicalTask = "genislik ve yukseklik alanları olan, alan() const metoduna sahip bir Dikdortgen sınıfı yazın.",
            starterPlaygroundCode = "#include <iostream>\nclass Kedi { public: void ses() { std::cout << \"Miyav\"; } };\nint main() { Kedi k; k.ses(); return 0; }",
            miniQuestion = MiniQuestion(
                id = "cpp_q_6",
                question = "C++'ta bir üye metodun sonuna 'const' anahtar kelimesi eklendiğinde (örn. int getX() const) bu ne anlama gelir?",
                options = listOf("Metodun dönüş değeri sabittir", "Bu metot sınıfın hiçbir üye değişkenini değiştiremez ve const nesneler üzerinden çağrılabilir", "Metot derleme anında silinir", "Metot static olur"),
                correctIndex = 1,
                explanation = "const metotlar sınıfın iç durumunu değiştirmeyeceğini garanti eder."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_cpp_6",
                lessonId = "cpp_6",
                title = "Sayaç Sınıfı",
                instructions = "deger isimli bir int tutan, artir(), azalt() ve getDeger() const metotlarına sahip Sayac sınıfını yazın (başlangıç değeri 0).",
                exampleInput = "Sayac s; s.artir(); s.artir();",
                exampleOutput = "s.getDeger() == 2",
                starterCode = "class Sayac {\n    // Sınıfı buraya yazın:\n};",
                solutionCode = "class Sayac {\nprivate:\n    int deger;\npublic:\n    Sayac() : deger(0) {}\n    void artir() { ++deger; }\n    void azalt() { --deger; }\n    int getDeger() const { return deger; }\n};",
                hints = listOf("private: int deger; ve public metotları tanımlayın."),
                testCases = listOf(
                    TestCase("Sayac", "2", "Sayaç testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "cpp_quiz_6_1",
                    lessonId = "cpp_6",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "C++'ta bir sınıfın kurucusunun başına 'explicit' anahtar kelimesi konulmasının amacı nedir?",
                    options = listOf("Kurucuyu hızlandırmak", "Tek argümanlı kurucularda derleyicinin örtük (implicit) tip dönüşümü yapmasını engellemek", "Sınıfı soyut yapmak", "Çoklu kalıtımı engellemek"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! 'explicit' istenmeyen otomatik tip dönüşümlerinin önüne geçer.",
                    explanationWrong = "explicit örtük tip dönüşümlerini engeller.",
                    reviewTopic = "Explicit Constructors"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "friend fonksiyon nedir?",
                    answer = "Sınıf üyesi olmayan ancak sınıf içinde `friend` olarak bildirilen fonksiyonlar, sınıfın `private` ve `protected` üyelerine doğrudan erişim hakkı kazanır (örn. operator<< aşırı yüklemelerinde kullanılır)."
                )
            ),
            completionCriteria = listOf(
                "Sınıf ve struct farkını bilmek",
                "Member Initializer List ile temiz kurucular yazabilmek",
                "const metot güvenliğini uygulayabilmek"
            )
        ),

        // ==========================================
        // DERS 7: KALITIM, SANAL FONKSİYONLAR & VTABLE
        // ==========================================
        Lesson(
            id = "cpp_7",
            courseId = "cpp",
            sectionId = "cpp_sec_4",
            title = "Kalıtım, Sanal Fonksiyonlar & vtable Mimarisi",
            shortDesc = "Kalıtım (public inheritance), virtual metotlar, override, dynamic_cast, Saf Sanal Fonksiyonlar (= 0), Arayüzler ve vtable/vptr bellek modeli.",
            level = CourseLevel.INTERMEDIATE,
            order = 7,
            isPremium = true,
            learningObjectives = listOf(
                "Çok biçimlilik (Polymorphism) ve 'virtual' anahtar kelimesinin rolünü kavramak",
                "vtable (Virtual Method Table) ve vptr bellek düzenini anlamak",
                "Sanal Yıkıcıların (virtual destructor) bellek sızıntısını önlemedeki kritik önemini öğrenmek"
            ),
            prerequisites = listOf("C++ OOP Temelleri ve Kurucular"),
            subtopics = listOf("public Kalıtım", "virtual Fonksiyonlar & override", "vtable & vptr Bellek Düzeni", "Virtual Destructor Önemi", "Saf Sanal Metotlar (= 0) & Abstract Class"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. virtual ve Çalışma Zamanı Çok Biçimliliği",
                    body = "Bir üst sınıf işaretçisi (`Sekil* s = new Daire()`) üzerinden metot çağrıldığında alt sınıfın metodunun çalışması için üst sınıfta metodun `virtual` olarak işaretlenmesi gerekir.",
                    codeSnippet = "class Sekil {\npublic:\n    virtual void ciz() const = 0; // Saf sanal (Interface)\n    virtual ~Sekil() = default; // KRİTİK: Sanal yıkıcı!\n};"
                ),
                LessonContentBlock(
                    subtitle = "2. vtable (Sanal Metot Tablosu) Nasıl Çalışır?",
                    body = "Derleyici virtual fonksiyon içeren her sınıf için bellek adreslerini tutan bir vtable dizisi üretir. Nesnenin içine gizli bir `vptr` pointer'ı yerleştirilir. Çağrı bu tablo üzerinden dinamik olarak çözümlenir (~1 pointer indirection maliyeti).",
                    tip = "Eğer bir sınıf virtual metot içeriyorsa, yıkıcısı (destructor) da KESİNLİKLE `virtual` olmalıdır. Aksi takdirde alt sınıfın yıkıcısı çağrılmaz ve bellek sızar."
                )
            ),
            codeExample = "#include <iostream>\n#include <vector>\n#include <memory>\n\nclass Hayvan {\npublic:\n    virtual void sesCikar() const {\n        std::cout << \"Bilinmeyen ses...\\n\";\n    }\n    virtual ~Hayvan() = default;\n};\n\nclass Kopek : public Hayvan {\npublic:\n    void sesCikar() const override {\n        std::cout << \"Hav hav! 🐕\\n\";\n    }\n};\n\nint main() {\n    Hayvan* h = new Kopek();\n    h->sesCikar(); // Hav hav!\n    delete h; // Sanal yıkıcı sayesinde Kopek yıkıcısı da çalışır\n    return 0;\n}",
            codeExplanation = "h bir Hayvan* işaretçisidir ancak virtual mekanizması sayesinde çalışma anında Kopek::sesCikar() fonksiyonuna dallanır.",
            realWorldExample = "GUI kütüphanelerinde (Qt) tüm butonlar, text kutuları `QWidget` taban sınıfından türer ve `paintEvent()` virtual fonksiyonunu ezer.",
            practicalTask = "AlanHesapla() saf sanal metoduna sahip bir Sekil soyut sınıfı ve bunu miras alan Dikdortgen ile Daire sınıflarını yazın.",
            starterPlaygroundCode = "#include <iostream>\nstruct Base { virtual void f() { std::cout << \"Base\"; } };\nstruct Der : Base { void f() override { std::cout << \"Der\"; } };\nint main() { Base* b = new Der(); b->f(); delete b; return 0; }",
            miniQuestion = MiniQuestion(
                id = "cpp_q_7",
                question = "Polimorfik bir taban sınıfın yıkıcısının (destructor) 'virtual' yapılmaması durumunda ne tür bir hata ortaya çıkar?",
                options = listOf("Derleme hatası verir", "Alt sınıf delete edildiğinde alt sınıfın yıkıcısı çalışmaz ve alt sınıfa ait heap belleği sızar (Memory Leak)", "vtable silinir", "Program daha hızlı çalışır"),
                correctIndex = 1,
                explanation = "Sanal yıkıcı olmazsa üst sınıf işaretçisi ile silme yapıldığında yalnızca üst sınıfın yıkıcısı çağrılır; alt sınıfın kaynakları temizlenemez."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_cpp_7",
                lessonId = "cpp_7",
                title = "Geometrik Çok Biçimlilik",
                instructions = "virtual double alan() const = 0 saf sanal metoduna sahip Sekil taban sınıfını ve bunu miras alan Daire(double r) sınıfını yazın (Pi = 3.14).",
                exampleInput = "Daire d(10); d.alan()",
                exampleOutput = "314.0",
                starterCode = "class Sekil {\npublic:\n    virtual double alan() const = 0;\n    virtual ~Sekil() = default;\n};\n\nclass Daire : public Sekil {\n    // Sınıfı buraya yazın:\n};",
                solutionCode = "class Sekil {\npublic:\n    virtual double alan() const = 0;\n    virtual ~Sekil() = default;\n};\n\nclass Daire : public Sekil {\nprivate:\n    double r;\npublic:\n    Daire(double yaricap) : r(yaricap) {}\n    double alan() const override {\n        return 3.14 * r * r;\n    }\n};",
                hints = listOf("override anahtar kelimesiyle double alan() const metodunu ezin."),
                testCases = listOf(
                    TestCase("Daire", "314.0", "Daire alan hesabı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "cpp_quiz_7_1",
                    lessonId = "cpp_7",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "C++'ta en az bir adet 'saf sanal fonksiyon' (pure virtual function: virtual void f() = 0;) içeren sınıflara ne ad verilir?",
                    options = listOf("Final Sınıf", "Soyut Taban Sınıf (Abstract Base Class)", "Statik Sınıf", "Singleton"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Saf sanal metot içeren sınıflar soyut sınıftır ve doğrudan somutlaştırılamaz (instantiate edilemez).",
                    explanationWrong = "Soyut Taban Sınıf (Abstract Base Class) denir.",
                    reviewTopic = "Abstract Classes"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "vptr nesne boyutunu nasıl etkiler?",
                    answer = "Sınıfa virtual bir metot eklendiğinde derleyici nesneye 64-bit sistemlerde 8 baytlık bir vtable işaretçisi (vptr) ekler. Bu nedenle boş bir virtual sınıf en az 8 bayt yer kaplar."
                )
            ),
            completionCriteria = listOf(
                "virtual ve override mekanizmasını hatasız kurabilmek",
                "vtable ve vptr çalışma mantığını açıklayabilmek",
                "Sanal yıkıcı (virtual destructor) kuralına uymak"
            )
        ),

        // ==========================================
        // DERS 8: MODERN SMART POINTERLAR & RULE OF 5
        // ==========================================
        Lesson(
            id = "cpp_8",
            courseId = "cpp",
            sectionId = "cpp_sec_3",
            title = "Akıllı İşaretçiler (Smart Pointers) & Rule of 5",
            shortDesc = "Modern C++ bellek yönetimi: std::unique_ptr, std::shared_ptr, std::weak_ptr, make_unique/shared, Taşıma Semantiği (std::move) ve Rule of 5.",
            level = CourseLevel.INTERMEDIATE,
            order = 8,
            isPremium = true,
            learningObjectives = listOf(
                "std::unique_ptr ile tekil sahiplik ve sıfır maliyetli soyutlama sağlamak",
                "std::shared_ptr ve std::weak_ptr ile döngüsel bellek kilitlerini çözmek",
                "Rule of 5 (Yıkıcı, Kopyalama Kurucusu, Kopyalama Ataması, Taşıma Kurucusu, Taşıma Ataması) kuralını öğrenmek"
            ),
            prerequisites = listOf("Kalıtım, Sanal Fonksiyonlar & RAII"),
            subtopics = listOf("std::unique_ptr & std::make_unique", "std::shared_ptr (Referans Sayacı)", "std::weak_ptr (Döngü Önleme)", "Move Semantics (std::move)", "Rule of 5 / Rule of 0"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. std::unique_ptr: Tekil Sahiplik",
                    body = "unique_ptr nesnenin tek sahibi olduğunu garanti eder. Kopyalanamaz, sadece `std::move()` ile transfer edilebilir. Scope bittiğinde otomatik `delete` çağrılır. Ham pointer ile aynı boyuttadır (sıfır ek yük).",
                    codeSnippet = "auto ptr = std::make_unique<int>(42);\n// auto kopya = ptr; // DERLEME HATASI! Kopyalanamaz\nauto tasinan = std::move(ptr); // Sahiplik devredildi"
                ),
                LessonContentBlock(
                    subtitle = "2. std::shared_ptr ve std::weak_ptr",
                    body = "shared_ptr nesneye kaç referans olduğunu kontrol bloğunda sayar (reference counting). Son referans silinince bellek serbest kalır. Döngüsel referansların (cyclic reference) bellek sızdırmasını önlemek için `std::weak_ptr` kullanılır.",
                    tip = "Daima `std::make_unique` ve `std::make_shared` kullanın; `new` anahtar kelimesini kodunuzdan tamamen çıkarın."
                )
            ),
            codeExample = "#include <iostream>\n#include <memory>\n\nclass Kaynak {\npublic:\n    Kaynak() { std::cout << \"Kaynak acildi.\\n\"; }\n    ~Kaynak() { std::cout << \"Kaynak otomatik yok edildi!\\n\"; }\n    void calis() { std::cout << \"Islem yapiliyor...\\n\"; }\n};\n\nint main() {\n    {\n        std::unique_ptr<Kaynak> k = std::make_unique<Kaynak>();\n        k->calis();\n    } // Scope bitti, Kaynak anında silindi!\n    std::cout << \"Program devam ediyor.\\n\";\n    return 0;\n}",
            codeExplanation = "std::make_unique ile oluşturulan Kaynak nesnesi scope bittiğinde tek bir satır delete yazılmadan güvenle silinir.",
            realWorldExample = "Büyük ölçekli C++ sistemlerinde (örn: LLVM derleyicisi, Unreal Engine) çıplak pointer (raw pointer) yerine %99 oranında unique_ptr kullanılır.",
            practicalTask = "Döngüsel referans içeren iki shared_ptr yapısını weak_ptr kullanarak sızıntısız hale getirin.",
            starterPlaygroundCode = "#include <iostream>\n#include <memory>\nint main() {\n    auto p = std::make_unique<int>(100);\n    std::cout << *p;\n    return 0;\n}",
            miniQuestion = MiniQuestion(
                id = "cpp_q_8",
                question = "İki std::shared_ptr nesnesinin birbirini işaret etmesi sonucu oluşan bellek sızıntısını çözmek için hangi akıllı işaretçi tipi kullanılır?",
                options = listOf("std::unique_ptr", "std::weak_ptr", "std::auto_ptr", "std::raw_ptr"),
                correctIndex = 1,
                explanation = "std::weak_ptr referans sayacını artırmadan zayıf referans tutarak döngüsel bağımlılık sızıntılarını çözer."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_cpp_8",
                lessonId = "cpp_8",
                title = "unique_ptr Fabrikası",
                instructions = "Verilen tamsayı değerini tutan bir std::unique_ptr<int> nesnesi üretip döndüren akilliIsaretciUret(deger) fonksiyonunu yazın.",
                exampleInput = "akilliIsaretciUret(50)",
                exampleOutput = "*ptr == 50",
                starterCode = "#include <memory>\nstd::unique_ptr<int> akilliIsaretciUret(int deger) {\n    // Kodunu buraya yaz:\n    return nullptr;\n}",
                solutionCode = "#include <memory>\nstd::unique_ptr<int> akilliIsaretciUret(int deger) {\n    return std::make_unique<int>(deger);\n}",
                hints = listOf("std::make_unique<int>(deger) kullanın."),
                testCases = listOf(
                    TestCase("akilliIsaretciUret", "50", "unique_ptr testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "cpp_quiz_8_1",
                    lessonId = "cpp_8",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "C++ Rule of 5 kuralında bir sınıf dinamik kaynak yönetiyorsa hangi 5 özel metodu açıkça tanımlamalıdır?",
                    options = listOf("5 farklı kurucu", "Destructor, Copy Constructor, Copy Assignment, Move Constructor, Move Assignment", "5 adet public metot", "Getter, Setter, Print, Clear, Delete"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Yıkıcı, Kopyalama Kurucusu, Kopyalama Ataması, Taşıma Kurucusu ve Taşıma Ataması tanımlanmalıdır.",
                    explanationWrong = "Destructor, Copy Constr/Assign, Move Constr/Assign metotlarıdır.",
                    reviewTopic = "Rule of 5"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "std::move tam olarak ne yapar?",
                    answer = "std::move hiçbir şeyi taşımaz; yalnızca bir lvalue (sol taraf değeri) ifadesini rvalue referansa (T&&) dönüştürerek derleyicinin taşıma kurucusunu (move constructor) çalıştırmasını sağlar."
                )
            ),
            completionCriteria = listOf(
                "std::unique_ptr ve std::shared_ptr arasındaki farkı bilmek",
                "std::weak_ptr ile döngüsel bağımlılıkları çözebilmek",
                "Move semantiği ve Rule of 5 prensiplerini uygulamak"
            )
        ),

        // ==========================================
        // DERS 9: STANDART ŞABLON KÜTÜPHANESİ (STL) & ALGORİTMALAR
        // ==========================================
        Lesson(
            id = "cpp_9",
            courseId = "cpp",
            sectionId = "cpp_sec_5",
            title = "Standart Şablon Kütüphanesi (STL) & Lambdalar",
            shortDesc = "STL Kapları (vector, list, deque, map, unordered_map), İteratörler, STL Algoritmaları (sort, find, transform) ve Modern C++ Lambdaları.",
            level = CourseLevel.ADVANCED,
            order = 9,
            isPremium = true,
            learningObjectives = listOf(
                "std::vector, std::map (Kırmızı-Siyah Ağaç) ve std::unordered_map (Hash Table) karmaşıklıklarını bilmek",
                "STL algoritmalarını (std::sort, std::transform, std::accumulate) etkin kullanmak",
                "Lambda ifadeleri ve yakalama listeleri ([&, =]) ile fonksiyonel C++ yazmak"
            ),
            prerequisites = listOf("Smart Pointers & Rule of 5"),
            subtopics = listOf("Sıralı Kaplar (vector, deque)", "İlişkisel Kaplar (map, unordered_map)", "İteratör Protokolü (begin, end)", "STL Algoritmaları", "Lambda İfadeleri & Yakalama ([=, &])"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. STL Kapları Karşılaştırması",
                    body = "• std::vector: Bellekte bitişik (contiguous), O(1) rastgele erişim, en hızlı kap.\n• std::map: Sıralı Kırmızı-Siyah ağaç, O(log N) arama hızı.\n• std::unordered_map: Hash tablosu, ortalama O(1) arama hızı.",
                    codeSnippet = "#include <vector>\n#include <algorithm>\n\nstd::vector<int> v = {5, 2, 8, 1, 9};\nstd::sort(v.begin(), v.end(), [](int a, int b) { return a > b; }); // Büyükten küçüğe sırala"
                ),
                LessonContentBlock(
                    subtitle = "2. Lambda İfadeleri Anatomisi",
                    body = "`[yakalama](parametreler) -> donus_tipi { govde }`\n• `[=]`: Çevreleyen değişkenleri kopyalayarak yakalar.\n• `[&]`: Referans ile yakalar.",
                    tip = "STL algoritmaları elle yazılmış for döngülerinden genellikle daha hızlıdır ve derleyici tarafından SIMD vektörizasyonuna optimize edilebilir."
                )
            ),
            codeExample = "#include <iostream>\n#include <vector>\n#include <algorithm>\n#include <numeric>\n\nint main() {\n    std::vector<int> sayilar = {1, 2, 3, 4, 5, 6};\n    \n    // Lambda ile çift sayıları filtreleyip iki katına çıkaralım:\n    std::vector<int> sonuclar;\n    std::copy_if(sayilar.begin(), sayilar.end(), std::back_inserter(sonuclar), [](int n) {\n        return n % 2 == 0;\n    });\n    \n    for (int n : sonuclar) std::cout << n << ' '; // 2 4 6\n    return 0;\n}",
            codeExplanation = "std::copy_if algoritması lambda filtresi ile eşleşen çift sayıları sonuclar vektörüne kopyalar.",
            realWorldExample = "Finansal emir eşleştirme motorlarında (Order Book) emirler std::map veya özel STL türevi yapılarda mikrosaniyede sıralanır.",
            practicalTask = "std::transform algoritması kullanarak bir string'in tüm harflerini büyük harfe dönüştüren bir kod yazın.",
            starterPlaygroundCode = "#include <iostream>\n#include <vector>\n#include <numeric>\nint main() {\n    std::vector<int> v = {10, 20, 30};\n    std::cout << std::accumulate(v.begin(), v.end(), 0);\n    return 0;\n}",
            miniQuestion = MiniQuestion(
                id = "cpp_q_9",
                question = "C++ STL'de std::unordered_map veri yapısının ortalama eleman arama/ekleme zaman karmaşıklığı nedir?",
                options = listOf("O(1)", "O(log N)", "O(N)", "O(N^2)"),
                correctIndex = 0,
                explanation = "std::unordered_map hash tablosu tabanlı olduğu için ortalama O(1) sürede erişim sunar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_cpp_9",
                lessonId = "cpp_9",
                title = "Vektör Filtreleme ve Toplama",
                instructions = "std::vector<int> içindeki sadece pozitif (> 0) sayıların toplamını std::accumulate veya döngü ile hesaplayan pozitifToplami(v) fonksiyonunu yazın.",
                exampleInput = "v = {-5, 10, -2, 20}",
                exampleOutput = "30",
                starterCode = "#include <vector>\nint pozitifToplami(const std::vector<int>& v) {\n    // Kodunu buraya yaz:\n    return 0;\n}",
                solutionCode = "#include <vector>\nint pozitifToplami(const std::vector<int>& v) {\n    int top = 0;\n    for (int n : v) if (n > 0) top += n;\n    return top;\n}",
                hints = listOf("Pozitif elemanları toplayın."),
                testCases = listOf(
                    TestCase("pozitifToplami({-5, 10, -2, 20})", "30", "Pozitif toplam")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "cpp_quiz_9_1",
                    lessonId = "cpp_9",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir lambda ifadesinin yakalama listesinde '[&]' kullanıldığında ne olur?",
                    options = listOf("Tüm değişkenler kopyalanır", "Çevreleyen kapsamdaki tüm yerel değişkenler referans olarak yakalanır", "Lambda static olur", "Hata verir"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! '[&]' tüm dış değişkenleri referansla yakalar; '[=]' ise değerle kopyalar.",
                    explanationWrong = "[&] tüm değişkenleri referansla yakalar.",
                    reviewTopic = "C++ Lambdas"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "std::vector capacity ile size farkı nedir?",
                    answer = "'size' vektörde o anda bulunan gerçek eleman sayısını, 'capacity' ise bellekte yeniden tahsis (realloc) yapmadan alabileceği toplam ayrılmış yuva sayısını belirtir."
                )
            ),
            completionCriteria = listOf(
                "STL kaplarını performans kriterlerine göre seçebilmek",
                "STL algoritmalarını (sort, transform) kullanabilmek",
                "Lambda ifadeleri yazabilmek"
            )
        ),

        // ==========================================
        // DERS 10: ŞABLONLAR (TEMPLATES) & C++20 CONCEPTS
        // ==========================================
        Lesson(
            id = "cpp_10",
            courseId = "cpp",
            sectionId = "cpp_sec_5",
            title = "Şablonlar (Templates), Metaprogramming & Concepts (C++20)",
            shortDesc = "Jenerik programlama: Fonksiyon ve Sınıf Şablonları, Template Specialization, SFINAE / if constexpr ve C++20 Concepts ile tip kısıtlama.",
            level = CourseLevel.ADVANCED,
            order = 10,
            isPremium = true,
            learningObjectives = listOf(
                "Tip bağımsız fonksiyon ve sınıf şablonları (Templates) yazmak",
                "if constexpr ile derleme zamanı koşullu derleme yapmak",
                "C++20 Concepts ile şablon parametrelerine katı tip kuralları getirmek"
            ),
            prerequisites = listOf("STL ve Modern C++ Lambdaları"),
            subtopics = listOf("Function Templates", "Class Templates", "Template Specialization", "if constexpr (C++17)", "C++20 Concepts & requires"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Şablonlar ve Derleyici Kod Üretimi",
                    body = "C++ şablonları çalışma zamanında değil, derleme zamanında tip parametresi başına özel somut kod üretir (Monomorphization). Bu sayede sanal fonksiyon ek yükü olmadan sıfır maliyetli jenerik kod elde edilir.",
                    codeSnippet = "template <typename T>\nT maks(T a, T b) {\n    return (a > b) ? a : b;\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. C++20 Concepts: Derleme Hatalarına Son",
                    body = "Eski C++'ta yanlış şablon tipinde sayfalarca anlaşılmaz hata çıkardı. Concepts ile şablonun hangi yeteneklere sahip olması gerektiği açıkça belirtilir.",
                    codeSnippet = "template <typename T>\nconcept Sayisal = std::is_arithmetic_v<T>;\n\ntemplate <Sayisal T>\nT topla(T a, T b) { return a + b; }"
                )
            ),
            codeExample = "#include <iostream>\n#include <type_traits>\n\ntemplate <typename T>\nvoid tipYazdir(T deger) {\n    if constexpr (std::is_integral_v<T>) {\n        std::cout << deger << \" bir tamsayidir.\\n\";\n    } else {\n        std::cout << deger << \" tamsayi degildir.\\n\";\n    }\n}\n\nint main() {\n    tipYazdir(42);     // Tamsayı\n    tipYazdir(3.14);   // Tamsayı değil\n    return 0;\n}",
            codeExplanation = "if constexpr C++17 ile gelmiştir; koşul derleme zamanında değerlendirilir ve yanlış olan dal derlenmiş binary'den tamamen çıkartılır.",
            realWorldExample = "Eigen (Lineer Cebir) ve Boost kütüphaneleri tüm matris optimizasyonlarını ve SIMD hızlandırmalarını Template Metaprogramming ile çözer.",
            practicalTask = "İki eleman tutan jenerik bir `Cift<T, U>` sınıf şablonu tasarlayın.",
            starterPlaygroundCode = "#include <iostream>\ntemplate <typename T> T kare(T x) { return x * x; }\nint main() { std::cout << kare(5.5); return 0; }",
            miniQuestion = MiniQuestion(
                id = "cpp_q_10",
                question = "C++17 ile gelen ve şablon fonksiyonlar içinde derleme zamanında kod dallanması sağlayan ifade hangisidir?",
                options = listOf("if constexpr", "static if", "constexpr if", "compile_if"),
                correctIndex = 0,
                explanation = "C++17 'if constexpr' ifadesi derleme zamanı koşullu derleme sağlar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_cpp_10",
                lessonId = "cpp_10",
                title = "Jenerik Maksimum Bulucu",
                instructions = "İki parametre alıp büyük olanı döndüren jenerik template <typename T> T jenerikMaks(T a, T b) şablon fonksiyonunu yazın.",
                exampleInput = "jenerikMaks(10, 20)",
                exampleOutput = "20",
                starterCode = "template <typename T>\nT jenerikMaks(T a, T b) {\n    // Kodunu buraya yaz:\n    return a;\n}",
                solutionCode = "template <typename T>\nT jenerikMaks(T a, T b) {\n    return (a > b) ? a : b;\n}",
                hints = listOf("return (a > b) ? a : b; kullanın."),
                testCases = listOf(
                    TestCase("jenerikMaks(10, 20)", "20", "int karşılaştırma"),
                    TestCase("jenerikMaks(5.5, 2.1)", "5.5", "double karşılaştırma")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "cpp_quiz_10_1",
                    lessonId = "cpp_10",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "C++20 Concepts'in şablon metaprogramlama dünyasına kazandırdığı en büyük yenilik nedir?",
                    options = listOf("Şablonları çalıştırma anına taşır", "Şablon parametrelerine okunabilir kısıtlamalar getirerek derleme anı tip hatalarını net ve anlaşılır hale getirmesi", "Şablonları silmesi", "C++ hızını yarıya düşürmesi"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Concepts derleyicinin şablon gereksinimlerini doğrulamasına ve kristal netliğinde derleme hata mesajları üretmesine olanak tanır.",
                    explanationWrong = "Concepts derleme zamanı tip kısıtları ve net hata mesajları sağlar.",
                    reviewTopic = "C++20 Concepts"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Template Specialization nedir?",
                    answer = "Belirli bir veri tipi için (örneğin `bool` veya `char*`) şablonun genel implementasyonunu ezip o tipe özel optimize edilmiş farklı bir kod gövdesi tanımlamaktır."
                )
            ),
            completionCriteria = listOf(
                "Fonksiyon ve sınıf şablonları yazabilmek",
                "if constexpr ile derleme zamanı optimizasyonu yapabilmek",
                "C++20 Concepts ile tip güvenliğini artırabilmek"
            )
        ),

        // ==========================================
        // DERS 11: ÇOKLU İŞ PARÇACIĞI & ATOMIC İŞLEMLER
        // ==========================================
        Lesson(
            id = "cpp_11",
            courseId = "cpp",
            sectionId = "cpp_sec_6",
            title = "Eşzamanlılık: std::thread, std::mutex & std::atomic",
            shortDesc = "Çoklu iş parçacığı (Multithreading): std::thread, std::mutex, std::lock_guard, Deadlock önleme, std::atomic ve CAS (Compare-And-Swap).",
            level = CourseLevel.EXPERT,
            order = 11,
            isPremium = true,
            learningObjectives = listOf(
                "std::thread ile iş parçacıkları açıp join() ile senkronize etmek",
                "std::mutex ve RAII tabanlı std::lock_guard ile Race Condition'ları engellemek",
                "std::atomic ile kilit kullanmadan (lockless) atomik sayaçlar ve CAS işlemleri yapmak"
            ),
            prerequisites = listOf("Şablonlar ve Modern C++ Mimarisi"),
            subtopics = listOf("std::thread & join() / detach()", "Data Races & Race Conditions", "std::mutex & std::lock_guard", "std::unique_lock & condition_variable", "std::atomic & fetch_add"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. std::mutex ve RAII Kilitleme",
                    body = "Paylaşımlı belleğe birden fazla thread yazdığında veri bozulur (Data Race). `std::mutex` kritik bölgeyi korur. Kilidi unutmamak için RAII sarmalayıcısı `std::lock_guard` kullanılır.",
                    codeSnippet = "#include <mutex>\nstd::mutex mtx;\n\nvoid guvenliYaz(int veri) {\n    std::lock_guard<std::mutex> kilit(mtx); // Scope bitince kilit otomatik açılır\n    // Kritik bölge\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. std::atomic ile Kilit Olmadan Hız",
                    body = "Mutex işletim sistemini araya soktuğu için pahalıdır. `std::atomic<int>` doğrudan CPU seviyesinde donanımsal atomik komutlar (LOCK CMPXCHG) kullanarak mikrosaniye gecikmesiz çalışır.",
                    tip = "Thread nesneleri yıkılmadan önce ya `join()` ya da `detach()` çağrılmak zorundadır; aksi takdirde `std::terminate` programı çökertir."
                )
            ),
            codeExample = "#include <iostream>\n#include <thread>\n#include <atomic>\n#include <vector>\n\nstd::atomic<int> sayac(0);\n\nvoid artir() {\n    for (int i = 0; i < 10000; ++i) {\n        sayac.fetch_add(1, std::memory_order_relaxed);\n    }\n}\n\nint main() {\n    std::thread t1(artir);\n    std::thread t2(artir);\n    t1.join();\n    t2.join();\n    \n    std::cout << \"Toplam (20000 olmali): \" << sayac.load() << \"\\n\";\n    return 0;\n}",
            codeExplanation = "sayac atomik olduğu için iki thread aynı anda sayacı hiçbir kilit (mutex) kullanmadan donanım seviyesinde güvenle 20.000 yapar.",
            realWorldExample = "Finansal HFT (High-Frequency Trading) sistemlerinde her mikrosaniye milyonlarca dolar değerindedir; mutex kilitleri yerine std::atomic mimarisi kullanılır.",
            practicalTask = "10 thread açıp ortak bir std::vector'e std::mutex ile güvenli veri ekleyen bir kod yazın.",
            starterPlaygroundCode = "#include <iostream>\n#include <thread>\nint main() {\n    std::thread t([]{ std::cout << \"Thread aktif\\n\"; });\n    t.join();\n    return 0;\n}",
            miniQuestion = MiniQuestion(
                id = "cpp_q_11",
                question = "C++'ta bir std::thread nesnesi yok edilirken (destructor çalıştığında) join() veya detach() çağrılmamışsa ne olur?",
                options = listOf("Thread arka planda devam eder", "std::terminate() tetiklenir ve program anında çöker", "İşletim sistemi thread'i dondurur", "Normal devam eder"),
                correctIndex = 1,
                explanation = "Joinable durumdaki bir std::thread yıkılırsa C++ standardı gereği std::terminate çağrılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_cpp_11",
                lessonId = "cpp_11",
                title = "Paralel Dizi Toplayıcı",
                instructions = "İki thread kullanarak dizinin ilk yarısını ve ikinci yarısını paralel toplayan ve toplamı std::atomic<long long> olarak döndüren paralelDiziTopla(v) fonksiyonunu yazın.",
                exampleInput = "v = {1, 2, 3, 4}",
                exampleOutput = "10",
                starterCode = "#include <vector>\n#include <atomic>\n#include <thread>\nlong long paralelDiziTopla(const std::vector<int>& v) {\n    // Kodunu buraya yaz:\n    return 0;\n}",
                solutionCode = "#include <vector>\n#include <atomic>\n#include <thread>\nlong long paralelDiziTopla(const std::vector<int>& v) {\n    std::atomic<long long> top(0);\n    int n = v.size();\n    int yarisi = n / 2;\n    std::thread t1([&]() {\n        for (int i = 0; i < yarisi; ++i) top += v[i];\n    });\n    std::thread t2([&]() {\n        for (int i = yarisi; i < n; ++i) top += v[i];\n    });\n    t1.join();\n    t2.join();\n    return top.load();\n}",
                hints = listOf("İki thread açıp v.size()/2 üzerinden toplayın ve join() yapın."),
                testCases = listOf(
                    TestCase("paralelDiziTopla", "10", "Paralel toplam")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "cpp_quiz_11_1",
                    lessonId = "cpp_11",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "İki thread'in iki farklı mutex'i çaprazlama bekleyerek birbirini sonsuza kadar kilitlemesi durumuna ne ad verilir?",
                    options = listOf("Race Condition", "Deadlock (Ölümcül Kilitlenme)", "Livelock", "Data Abort"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Deadlock, kilitlerin farklı sıralarla edinilmesi sonucu oluşur; çözümü `std::lock` veya `std::scoped_lock` kullanmaktır.",
                    explanationWrong = "Bu durum Deadlock (Ölümcül Kilitlenme) olarak adlandırılır.",
                    reviewTopic = "Deadlocks"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "std::condition_variable ne için kullanılır?",
                    answer = "Bir thread'in belirli bir koşul (örneğin kuyrukta yeni iş oluşması) gerçekleşene kadar CPU harcamadan uyumasını (wait) ve koşul sağlandığında başka bir thread tarafından uyandırılmasını (notify_one/all) sağlar."
                )
            ),
            completionCriteria = listOf(
                "std::thread ve join/detach döngüsünü hatasız yönetebilmek",
                "std::lock_guard ile Race Condition engellemek",
                "std::atomic ile donanımsal atomik işlemler yapabilmek"
            )
        ),

        // ==========================================
        // DERS 12: LOCK-FREE MİMARİSİ, BELLEK MODELLERİ & CUSTOM ALLOCATORS
        // ==========================================
        Lesson(
            id = "cpp_12",
            courseId = "cpp",
            sectionId = "cpp_sec_6",
            title = "Lock-Free Mimarisi, Bellek Modelleri & Custom Allocators",
            shortDesc = "İleri C++ sistem mimarisi: std::memory_order (relaxed, acquire, release, seq_cst), Lock-Free Ring Buffer, ABA Problemi ve Özel Bellek Havuzları (Arena/Pool Allocator).",
            level = CourseLevel.EXPERT,
            order = 12,
            isPremium = true,
            learningObjectives = listOf(
                "C++ bellek sıralama modellerini (Memory Ordering: acquire-release vs sequentially consistent) anlamak",
                "Sıfır kilitli (Lock-Free) Ring Buffer ve Single-Producer Single-Consumer (SPSC) kuyrukları inşa etmek",
                "Özel Bellek Havuzları (Arena Allocator) tasarlayarak malloc/free ek yükünü ortadan kaldırmak"
            ),
            prerequisites = listOf("Çoklu İş Parçacığı & Atomic İşlemler"),
            subtopics = listOf("std::memory_order Semantiği", "Acquire-Release Synchronization", "Lock-Free SPSC Queue", "ABA Problemi & Tagged Pointers", "Arena & Pool Allocator Mimarisi"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Bellek Sıralaması (Memory Ordering)",
                    body = "Modern işlemciler ve derleyiciler performansı artırmak için bağımsız makine komutlarının sırasını değiştirir (instruction reordering). Acquire-Release senkronizasyonu bu yeniden sıralamayı kilit kullanmadan mikroişlemci seviyesinde kontrol altında tutar.",
                    codeSnippet = "bayrak.store(true, std::memory_order_release); // Önceki tüm yazımlar görünür olur\nwhile (!bayrak.load(std::memory_order_acquire)); // Senkronize oku"
                ),
                LessonContentBlock(
                    subtitle = "2. Arena Allocator ile Sıfır Parçalanma (Zero Fragmentation)",
                    body = "Standart `new` ve `malloc` işletim sistemi çekirdeğine context-switch yapar. Oyun ve ticaret motorlarında önceden 100 MB'lık tek bir blok ayrılır (Arena) ve her tahsis sadece bir pointer artırma işlemi (pointer bump) ile nanosaniyede tamamlanır.",
                    tip = "Lock-Free algoritmalarında `atomic.compare_exchange_weak` veya `strong` kullanılır."
                )
            ),
            codeExample = "#include <iostream>\n#include <atomic>\n\nclass ArenaTahsisci {\n    char* tampon;\n    size_t kapasite;\n    size_t ofset;\npublic:\n    ArenaTahsisci(size_t cap) : kapasite(cap), ofset(0), tampon(new char[cap]) {}\n    ~ArenaTahsisci() { delete[] tampon; }\n    \n    void* tahsisEt(size_t boyut) {\n        if (ofset + boyut > kapasite) return nullptr;\n        void* ptr = tampon + ofset;\n        ofset += boyut;\n        return ptr; // Nanosaniye hızında bellek tahsisi!\n    }\n    void sifirla() { ofset = 0; } // Tek komutla tüm belleği boşalt\n};\n\nint main() {\n    ArenaTahsisci arena(1024 * 1024); // 1 MB Arena\n    int* sayi = static_cast<int*>(arena.tahsisEt(sizeof(int)));\n    *sayi = 999;\n    std::cout << \"Arena Değeri: \" << *sayi << \"\\n\";\n    return 0;\n}",
            codeExplanation = "ArenaTahsisci tek tek delete yapmak yerine ofset=0 yaparak tek seferde tüm nesneleri sıfır maliyetle serbest bırakır.",
            realWorldExample = "Oyun motorlarında her render karesinde üretilen binlerce geçici nesne Frame Arena Allocator içinde tahsis edilir ve kare bitiminde sıfırlanır.",
            practicalTask = "std::atomic ve memory_order_relaxed kullanarak bir Lock-Free Atomik Yığın (Treiber Stack) taslağı kurun.",
            starterPlaygroundCode = "#include <iostream>\n#include <atomic>\nint main() {\n    std::atomic<bool> hazir(false);\n    hazir.store(true, std::memory_order_release);\n    std::cout << hazir.load(std::memory_order_acquire);\n    return 0;\n}",
            miniQuestion = MiniQuestion(
                id = "cpp_q_12",
                question = "Lock-Free algoritmalarında bir pointer'ın A durumundan B'ye geçip tekrar A'ya dönmesiyle oluşan ve hatalı CAS başarısına yol açan klasik problemin adı nedir?",
                options = listOf("Deadlock", "ABA Problemi", "Memory Leak", "Starvation"),
                correctIndex = 1,
                explanation = "ABA Problemi, bellek yeniden tahsis edildiğinde aynı adresin denk gelmesiyle CAS kontrolünün yanıltılmasıdır; çözümü Tagged Pointers / Versioning kullanmaktır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_cpp_12",
                lessonId = "cpp_12",
                title = "Lock-Free Spinlock Kilidi",
                instructions = "std::atomic_flag kullanarak lock() ve unlock() metotlarına sahip kilitli olmayan bir Spinlock sınıfı yazın.",
                exampleInput = "Spinlock spin; spin.lock();",
                exampleOutput = "Kilitlendi",
                starterCode = "#include <atomic>\nclass Spinlock {\n    // Spinlock sınıfını yazın:\n};",
                solutionCode = "#include <atomic>\nclass Spinlock {\n    std::atomic_flag kilit = ATOMIC_FLAG_INIT;\npublic:\n    void lock() {\n        while (kilit.test_and_set(std::memory_order_acquire));\n    }\n    void unlock() {\n        kilit.clear(std::memory_order_release);\n    }\n};",
                hints = listOf("kilit.test_and_set(std::memory_order_acquire) ve kilit.clear(std::memory_order_release) kullanın."),
                testCases = listOf(
                    TestCase("Spinlock", "Başarılı", "Spinlock kilit mekanizması")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "cpp_quiz_12_1",
                    lessonId = "cpp_12",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "C++ std::memory_order_seq_cst (Sequentially Consistent) modelinin diğer modellere göre en temel özelliği nedir?",
                    options = listOf("En hızlı olması", "Tüm iş parçacıklarının tüm atomic işlemleri kesinlikle aynı global sırada görmesini garanti eden en katı ve varsayılan bellek modeli olması", "Sadece tek thread'de çalışması", "Kilit kullanması"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! seq_cst en katı ve tam sıralı bellek modelidir; CPU bellek bariyerleri en yüksek düzeyde uygulanır.",
                    explanationWrong = "seq_cst küresel işlem sırasını tüm thread'ler için kesinlikle garanti eden en katı modeldir.",
                    reviewTopic = "Memory Order"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Arena Allocator neden standart malloc'tan 10-100 kat hızlıdır?",
                    answer = "Çünkü kilit (lock) edinmez, serbest blok arama (free list traversal) yapmaz ve işletim sistemine inmez; yalnızca bir tamsayı ofsetini (pointer bump) artırır."
                )
            ),
            completionCriteria = listOf(
                "Memory Ordering (Acquire-Release vs Relaxed) mantığını kavramak",
                "Lock-Free veri yapıları tasarlayabilmek",
                "Custom Arena / Pool Allocator mimarisi kurabilmek"
            )
        )
    )
}
