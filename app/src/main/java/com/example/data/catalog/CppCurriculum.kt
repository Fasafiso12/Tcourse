package com.example.data.catalog

import com.example.model.*

/**
 * C++ Kolay & Anlaşılır Müfredatı (12 Adım):
 * AAA oyun motorlarının, Unreal Engine'in ve yüksek performanslı sistemlerin dili C++'ı keyifle öğrenin!
 */
object CppCurriculum {

    fun getSections(): List<CourseSection> = listOf(
        CourseSection(
            id = "cpp_sec_1",
            courseId = "cpp",
            title = "Bölüm 1: C++ Temelleri ve Giriş/Çıkış",
            level = CourseLevel.BEGINNER,
            order = 1,
            description = "std::cout ve std::cin ile konsolla konuşma, değişkenler ve döngüler.",
            learningObjectives = listOf("std::cout ve std::cin kullanımını öğrenmek", "if-else ve for döngüleri kurmak"),
            prerequisites = listOf("Ön koşul gerekmez! Sıfırdan başlar.")
        ),
        CourseSection(
            id = "cpp_sec_2",
            courseId = "cpp",
            title = "Bölüm 2: Vektörler, Stringler ve Referanslar",
            level = CourseLevel.BEGINNER,
            order = 2,
            description = "Dinamik büyüyen std::vector, kolay metinler (std::string) ve & referans mekanizması.",
            learningObjectives = listOf("std::vector ile esnek listeler yapmak", "Referans (&) ile hızlı parametre aktarmak"),
            prerequisites = listOf("C++ Temelleri")
        ),
        CourseSection(
            id = "cpp_sec_3",
            courseId = "cpp",
            title = "Bölüm 3: Nesne Yönelimli C++ (OOP & Sınıflar)",
            level = CourseLevel.INTERMEDIATE,
            order = 3,
            description = "Kendi sınıflarınızı (class) üretme, kurucular (Constructor) ve otomatik temizlik (Destructor).",
            learningObjectives = listOf("class ve nesne tanımlamak", "Constructor ve Destructor mantığını kavramak"),
            prerequisites = listOf("Vektörler ve Fonksiyonlar")
        ),
        CourseSection(
            id = "cpp_sec_4",
            courseId = "cpp",
            title = "Bölüm 4: Kalıtım ve Akıllı İşaretçiler (Smart Pointers)",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            description = "Kalıtım (Inheritance), sanal fonksiyonlar ve hafıza sızıntısını tarihe gömen unique_ptr.",
            learningObjectives = listOf("Kalıtım ile kod tekrarını önlemek", "unique_ptr ile güvenli bellek yönetimi"),
            prerequisites = listOf("Sınıflar ve Nesneler")
        ),
        CourseSection(
            id = "cpp_sec_5",
            courseId = "cpp",
            title = "Bölüm 5: Şablonlar (Templates) ve STL Kütüphanesi",
            level = CourseLevel.ADVANCED,
            order = 5,
            description = "Her veri tipi için tek fonksiyon (Template), std::map ve std::sort algoritmaları.",
            learningObjectives = listOf("Template ile jenerik kod yazmak", "std::map ve std::sort kullanmak"),
            prerequisites = listOf("Akıllı İşaretçiler ve Kalıtım")
        ),
        CourseSection(
            id = "cpp_sec_6",
            courseId = "cpp",
            title = "Bölüm 6: Oyun Motorları ve C++ Ustalığı",
            level = CourseLevel.EXPERT,
            order = 6,
            description = "Unreal Engine, try-catch hata yakalama ve profesyonel C++ ipuçları.",
            learningObjectives = listOf("try-catch ile hataları yakalamak", "C++'ın oyun ve sistem gücünü kavramak"),
            prerequisites = listOf("Tüm Seviyeler")
        )
    )

    fun getLessons(): List<Lesson> = listOf(
        // ==========================================
        // DERS 1: MAIN, COUT VE CIN
        // ==========================================
        Lesson(
            id = "cpp_1",
            courseId = "cpp",
            sectionId = "cpp_sec_1",
            title = "C++ Dünyasına Giriş: main(), cout ve cin",
            shortDesc = "Konsola şıkça yazı yazdırma (std::cout) ve kullanıcıdan bilgi alma (std::cin).",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false,
            learningObjectives = listOf(
                "#include <iostream> ve std::cout ile ekrana yazdırmak",
                "<< (yazma) ve >> (okuma) akış operatörlerini öğrenmek",
                "int, double, bool ve char değişkenlerini tanımlamak"
            ),
            prerequisites = listOf("Ön koşul gerekmez."),
            subtopics = listOf("C++ Neden Çok Popüler?", "std::cout ve <<", "std::cin ve >>", "Temel Değişkenler"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. C++: Süper Hızlı ve Güçlü",
                    body = "Oynadığınız Fortnite, GTA veya Unreal Engine oyunları C++ ile yazılır. C++ hem donanım hızında çalışır hem de modern nesne yönelimli özellikler sunar.\n\nEkrana yazı yazmak için `std::cout`, klavyeden okumak için `std::cin` kullanılır.",
                    codeSnippet = "#include <iostream>\n\nint main() {\n    std::cout << \"Merhaba C++ Dünyası! 🚀\" << std::endl;\n    \n    int yas = 22;\n    std::cout << \"Yaşım: \" << yas << std::endl;\n    return 0;\n}"
                )
            ),
            codeExample = "#include <iostream>\n\nint main() {\n    int skor = 100;\n    std::cout << \"Skorunuz: \" << skor << \" puan!\" << std::endl;\n    return 0;\n}",
            codeExplanation = "std::cout ile değişkenler ve metinler zincirleme birleştirilerek ekrana basıldı.",
            realWorldExample = "Unreal Engine veya PlayStation oyun konsollarındaki oyun kodlarının temeli bu yapıyla yazılır.",
            practicalTask = "Adınızı ve favori oyununuzu std::cout ile ekrana yazdıran bir kod yazın.",
            starterPlaygroundCode = "#include <iostream>\nint main() {\n    std::cout << \"Oyuncu: Can\" << std::endl;\n    return 0;\n}",
            miniQuestion = MiniQuestion(
                id = "cpp_q_1",
                question = "C++'ta konsola veri yazdırmak için kullanılan standart çıktı nesnesi hangisidir?",
                options = listOf("std::cout", "std::cin", "std::print", "console.log"),
                correctIndex = 0,
                explanation = "Konsola yazdırmak için 'std::cout' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_cpp_1",
                lessonId = "cpp_1",
                title = "Toplam Fonksiyonu",
                instructions = "İki sayıyı toplayıp döndüren topla(a, b) fonksiyonunu yazın.",
                exampleInput = "topla(15, 25)",
                exampleOutput = "40",
                starterCode = "int topla(int a, int b) {\n    // Kodunu yaz:\n    return 0;\n}",
                solutionCode = "int topla(int a, int b) {\n    return a + b;\n}",
                hints = listOf("return a + b; yazın."),
                testCases = listOf(
                    TestCase("topla(15, 25)", "40", "Toplam testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "cpp_quiz_1_1",
                    lessonId = "cpp_1",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "C++ programlarında ekrana yeni bir alt satıra geçmek için ne yazılır?",
                    options = listOf("std::endl veya '\\n'", "std::break", "std::stop", "next()"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! std::endl veya '\\n' yeni satıra geçirir.",
                    explanationWrong = "std::endl kullanılır.",
                    reviewTopic = "C++ Giriş/Çıkış"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "using namespace std; yazmak ne işe yarar?",
                    answer = "Her seferinde 'std::cout' yazmak yerine sadece 'cout' yazmanıza olanak tanır."
                )
            ),
            completionCriteria = listOf(
                "std::cout ve std::cin mantığını kavramak",
                "Temel değişkenleri kullanabilmek"
            )
        ),

        // ==========================================
        // DERS 2: KOŞULLAR VE DÖNGÜLER
        // ==========================================
        Lesson(
            id = "cpp_2",
            courseId = "cpp",
            sectionId = "cpp_sec_1",
            title = "Kararlar (if-else) ve Döngüler (for, while)",
            shortDesc = "Can puanına göre hayatta kalma kararları ve modern for döngüleri.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false,
            learningObjectives = listOf(
                "if-else blokları ile koşullu mantık kurmak",
                "Klasik for ve while döngülerini kullanmak",
                "Modern 'for (auto eleman : liste)' döngüsünü öğrenmek"
            ),
            prerequisites = listOf("C++ Temelleri"),
            subtopics = listOf("if / else if", "for Döngüsü", "Range-based for Döngüsü"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Kararlar ve Modern Döngüler",
                    body = "C++'ta döngüler çok güçlü ve hızlıdır. Özellikle C++11 ile gelen `range-based for` listeleri tek satırda gezmeyi sağlar.",
                    codeSnippet = "int can = 100;\n\nif (can <= 0) {\n    std::cout << \"Game Over!\\n\";\n} else {\n    std::cout << \"Maceraya devam!\\n\";\n}\n\n// 1'den 5'e kadar sayalım:\nfor (int i = 1; i <= 5; ++i) {\n    std::cout << i << \" \";\n}"
                )
            ),
            codeExample = "#include <iostream>\n\nint main() {\n    int toplam = 0;\n    for (int i = 1; i <= 10; ++i) {\n        toplam += i;\n    }\n    std::cout << \"1-10 Toplamı: \" << toplam << std::endl;\n    return 0;\n}",
            codeExplanation = "for döngüsüyle 1-10 arası sayılar toplandı.",
            realWorldExample = "Oyunlarda haritadaki tüm düşmanları tek tek güncellerken for döngüsü kullanılır.",
            practicalTask = "5 kere 'Ateş Edildi!' yazan bir for döngüsü kurun.",
            starterPlaygroundCode = "for(int i=0; i<5; ++i) std::cout << \"Ateş!\\n\";",
            miniQuestion = MiniQuestion(
                id = "cpp_q_2",
                question = "C++ dilinde 'VEYA' (OR) mantıksal operatörü hangisidir?",
                options = listOf("||", "&&", "!", "^"),
                correctIndex = 0,
                explanation = "VEYA mantığı için '||' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_cpp_2",
                lessonId = "cpp_2",
                title = "Çarpım Tablosu Elemanı",
                instructions = "sayi ve adim parametrelerini çarpıp 'sayi x adim = sonuc' şeklinde string döndüren carpim(sayi, adim) fonksiyonunu yazın veya sonucunu döndürün.",
                exampleInput = "carpim(3, 4)",
                exampleOutput = "12",
                starterCode = "int carpim(int sayi, int adim) {\n    // Kodunu yaz:\n    return 0;\n}",
                solutionCode = "int carpim(int sayi, int adim) {\n    return sayi * adim;\n}",
                hints = listOf("return sayi * adim; yazın."),
                testCases = listOf(
                    TestCase("carpim(3, 4)", "12", "Çarpım testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "cpp_quiz_2_1",
                    lessonId = "cpp_2",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Döngüyü hemen sonlandırıp döngüden çıkmak için hangi komut kullanılır?",
                    options = listOf("break", "continue", "exit", "return"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! 'break' döngüyü anında bitirir.",
                    explanationWrong = "break komutu kullanılır.",
                    reviewTopic = "C++ Kontrol Akışı"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "continue ne işe yarar?",
                    answer = "Döngünün o anki turunu atlayıp hemen bir sonraki adıma geçer."
                )
            ),
            completionCriteria = listOf(
                "if-else ve for döngülerini kurabilmek",
                "break ve continue mantığını bilmek"
            )
        ),

        // ==========================================
        // DERS 3: REFERANSLAR (Pass by Reference &)
        // ==========================================
        Lesson(
            id = "cpp_3",
            courseId = "cpp",
            sectionId = "cpp_sec_2",
            title = "Fonksiyonlar ve Referanslar (&): Işık Hızında Parametre",
            shortDesc = "Devasa nesneleri kopyalamadan tek bir '&' işaretiyle ışık hızında aktarma sanatı.",
            level = CourseLevel.BEGINNER,
            order = 3,
            isPremium = false,
            learningObjectives = listOf(
                "Değerle aktarım (kopya) vs Referansla aktarım (&) farkını kavramak",
                "Referans kullanarak fonksiyon içinden orijinal değişkeni güncellemek",
                "const referans (const T&) ile sıfır maliyetli güvenli okuma yapmak"
            ),
            prerequisites = listOf("C++ Fonksiyonları"),
            subtopics = listOf("Değerle Aktarım (Copy)", "Referans (&) Nedir?", "const Referanslar"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Referans (&) Mucizesi",
                    body = "Fonksiyona parametre gönderirken `&` koyarsanız, C++ veriyi kopyalamaz; orijinal veriye doğrudan bir takma ad verir. Bu sayede hem bellek harcanmaz hem de işlem ışık hızında gerçekleşir!",
                    codeSnippet = "void canYenile(int &can) {\n    can = 100; // Orijinal can değişkeni 100 olur!\n}\n\nint main() {\n    int oyuncuCani = 20;\n    canYenile(oyuncuCani);\n    std::cout << oyuncuCani; // 100 yazar!\n}"
                )
            ),
            codeExample = "void ikiKatYap(int &x) {\n    x *= 2;\n}\n\nint main() {\n    int a = 10;\n    ikiKatYap(a);\n    std::cout << a << std::endl; // 20\n    return 0;\n}",
            codeExplanation = "a değişkeninin referansı alındığı için a'nın orijinal değeri 20 oldu.",
            realWorldExample = "Oyunlarda 100.000 poligonlu bir 3D modeli fonksiyona gönderirken kopyalamak oyunu dondurur; const Model& ile kopyasız ve anında gönderilir.",
            practicalTask = "İki sayının yerini değiştiren swap fonksiyonunu & referans ile yazın.",
            starterPlaygroundCode = "void takas(int &a, int &b) { int t = a; a = b; b = t; }",
            miniQuestion = MiniQuestion(
                id = "cpp_q_3",
                question = "C++'ta bir fonksiyon parametresinin kopyalanmasını önleyip orijinaline doğrudan erişmek için tipin yanına hangi işaret konur?",
                options = listOf("& (Referans)", "*", "#", "@"),
                correctIndex = 0,
                explanation = "Referans oluşturmak için '&' simgesi kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_cpp_3",
                lessonId = "cpp_3",
                title = "Referans ile Artırma",
                instructions = "Parametre olarak referans (&) alan ve sayıyı 5 artıran besEkle(int &x) fonksiyonunu yazın.",
                exampleInput = "int a = 10; besEkle(a);",
                exampleOutput = "a = 15",
                starterCode = "void besEkle(int &x) {\n    // Kodunu yaz:\n}",
                solutionCode = "void besEkle(int &x) {\n    x += 5;\n}",
                hints = listOf("x += 5; yazın."),
                testCases = listOf(
                    TestCase("int a = 10; besEkle(a); a", "15", "5 ekleme testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "cpp_quiz_3_1",
                    lessonId = "cpp_3",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "const std::string& parametresi ne anlama gelir?",
                    options = listOf("Metni hiç kopyalamadan (referansla) çok hızlı oku ama fonksiyon içinde değiştirmeye izin verme", "Metni sil", "Metni ikiye böl", "Metni kopyala"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Performanslı ve güvenli salt-okunur aktarım sağlar.",
                    explanationWrong = "Sıfır kopyalı salt-okunur referans sağlar.",
                    reviewTopic = "C++ Referanslar"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Pointer (*) ile Referans (&) farkı nedir?",
                    answer = "Referans asla boş (null) olamaz ve syntax'ı normal değişken gibi çok daha basittir (-> yerine . kullanılır)."
                )
            ),
            completionCriteria = listOf(
                "& referans mantığını kavramak",
                "const T& kullanım amacını bilmek"
            )
        ),

        // ==========================================
        // DERS 4: VEKTÖRLER VE STRİNGLER
        // ==========================================
        Lesson(
            id = "cpp_4",
            courseId = "cpp",
            sectionId = "cpp_sec_2",
            title = "Dinamik Diziler: std::vector ve std::string",
            shortDesc = "Boyutu otomatik büyüyen süper dizi std::vector ve modern metin sınıfı std::string.",
            level = CourseLevel.BEGINNER,
            order = 4,
            isPremium = true,
            learningObjectives = listOf(
                "#include <vector> ile std::vector kullanmak",
                "push_back() ile listeye yeni eleman eklemek",
                "std::string ile metinleri birleştirmek ve uzunluğunu bulmak"
            ),
            prerequisites = listOf("Fonksiyonlar ve Döngüler"),
            subtopics = listOf("std::vector", "push_back() ve size()", "std::string"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. std::vector: Otomatik Büyüyen Liste",
                    body = "Eski C dizileri gibi boyutunu baştan belirlemenize gerek yoktur. İhtiyaç oldukça `push_back()` ile içine istediğiniz kadar eleman eklersiniz.",
                    codeSnippet = "#include <iostream>\n#include <vector>\n#include <string>\n\nint main() {\n    std::vector<std::string> kahramanlar;\n    kahramanlar.push_back(\"Savaşçı\");\n    kahramanlar.push_back(\"Büyücü\");\n    \n    for (const auto &k : kahramanlar) {\n        std::cout << \"Kahraman: \" << k << std::endl;\n    }\n    return 0;\n}"
                )
            ),
            codeExample = "std::vector<int> puanlar = {10, 20, 30};\npuanlar.push_back(40);\nstd::cout << \"Toplam Eleman: \" << puanlar.size(); // 4",
            codeExplanation = "Vektöre yeni eleman eklendi ve boyutu yazdırıldı.",
            realWorldExample = "Envanter çantanızdaki eşyaların listesi std::vector<Item> ile tutulur.",
            practicalTask = "3 adet meyve ismi içeren bir std::vector oluşturup ekrana yazdırın.",
            starterPlaygroundCode = "std::vector<std::string> meyveler = {\"Elma\", \"Muz\"};\nmeyveler.push_back(\"Çilek\");",
            miniQuestion = MiniQuestion(
                id = "cpp_q_4",
                question = "std::vector'ün sonuna yeni bir eleman eklemek için hangi fonksiyon kullanılır?",
                options = listOf("push_back()", "add()", "append()", "insertLast()"),
                correctIndex = 0,
                explanation = "Vektörün sonuna eleman eklemek için 'push_back()' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_cpp_4",
                lessonId = "cpp_4",
                title = "Vektör Toplayıcı",
                instructions = "Verilen std::vector<int> listesindeki sayıların toplamını hesaplayan vektorTopla(vec) fonksiyonunu yazın.",
                exampleInput = "vektorTopla({5, 10, 15})",
                exampleOutput = "30",
                starterCode = "#include <vector>\n\nint vektorTopla(const std::vector<int> &vec) {\n    // Kodunu yaz:\n    return 0;\n}",
                solutionCode = "#include <vector>\n\nint vektorTopla(const std::vector<int> &vec) {\n    int top = 0;\n    for (int x : vec) top += x;\n    return top;\n}",
                hints = listOf("for (int x : vec) top += x; return top; yazın."),
                testCases = listOf(
                    TestCase("vektorTopla({5, 10, 15})", "30", "Vektör toplamı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "cpp_quiz_4_1",
                    lessonId = "cpp_4",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "std::vector'deki eleman sayısını öğrenmek için hangi metot çağrılır?",
                    options = listOf("size()", "length()", "count()", "capacity()"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Eleman sayısı için .size() metodu kullanılır.",
                    explanationWrong = ".size() metodu kullanılır.",
                    reviewTopic = "C++ Vektörler"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "vector içindeki ilk elemana nasıl erişilir?",
                    answer = "vec[0] veya sınır kontrolü yapan güvenli vec.at(0) ile erişebilirsiniz."
                )
            ),
            completionCriteria = listOf(
                "std::vector ve std::string kullanabilmek",
                "push_back() ve size() metotlarını kavramak"
            )
        ),

        // ==========================================
        // DERS 5: SINIFLAR (CLASS) VE NESNELER
        // ==========================================
        Lesson(
            id = "cpp_5",
            courseId = "cpp",
            sectionId = "cpp_sec_3",
            title = "Nesne Yönelimli C++: Sınıflar (Class) ve Nesneler",
            shortDesc = "Kendi oyun karakterinizi veya araba modelinizi oluşturun: public ve private sırları.",
            level = CourseLevel.INTERMEDIATE,
            order = 5,
            isPremium = true,
            learningObjectives = listOf(
                "class yapısı ile veri ve fonksiyonları birleştirmek",
                "public (herkese açık) ve private (gizli) alanları yönetmek",
                "Kapsülleme (Encapsulation) ile güvenli kod yazmak"
            ),
            prerequisites = listOf("Vektörler ve Fonksiyonlar"),
            subtopics = listOf("Class Tanımlama", "public vs private", "Metotlar"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Gerçek Dünyayı Modellemek",
                    body = "Bir 'Oyuncu' sınıfı açıp içine canını, ismini ve 'atesEt()' yeteneğini ekleyebiliriz.",
                    codeSnippet = "class Oyuncu {\nprivate:\n    int can = 100;\n\npublic:\n    std::string isim;\n    \n    void hasarAl(int miktar) {\n        can -= miktar;\n        if (can < 0) can = 0;\n    }\n    \n    int getCan() const {\n        return can;\n    }\n};"
                )
            ),
            codeExample = "Oyuncu p1;\np1.isim = \"Kartal\";\np1.hasarAl(30);\nstd::cout << p1.isim << \" Kalan Can: \" << p1.getCan() << std::endl; // 70",
            codeExplanation = "Oyuncu nesnesi üretildi ve hasar alma metodu çalıştırıldı.",
            realWorldExample = "Oyunlardaki her düşman, silah ve araç birer Class örneğidir.",
            practicalTask = "Araba sınıfı tanımlayıp marka ve hiz alanları ekleyin.",
            starterPlaygroundCode = "class Araba {\npublic:\n    std::string marka;\n    int hiz = 0;\n};",
            miniQuestion = MiniQuestion(
                id = "cpp_q_5",
                question = "C++ sınıflarında dışarıdan doğrudan erişilmesini istemediğimiz özel alanlar hangi anahtar kelime altına yazılır?",
                options = listOf("private", "public", "protected", "hidden"),
                correctIndex = 0,
                explanation = "Gizli alanlar 'private' belirteci altına yazılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_cpp_5",
                lessonId = "cpp_5",
                title = "Kare Sınıfı",
                instructions = "kenar alanına sahip ve alan() metodu kenar * kenar döndüren Kare sınıfını yazın.",
                exampleInput = "Kare k; k.kenar = 4; k.alan()",
                exampleOutput = "16",
                starterCode = "class Kare {\npublic:\n    int kenar;\n    int alan() {\n        // Kodunu yaz:\n        return 0;\n    }\n};",
                solutionCode = "class Kare {\npublic:\n    int kenar;\n    int alan() {\n        return kenar * kenar;\n    }\n};",
                hints = listOf("return kenar * kenar; yazın."),
                testCases = listOf(
                    TestCase("Kare k; k.kenar = 4; k.alan()", "16", "Kare alanı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "cpp_quiz_5_1",
                    lessonId = "cpp_5",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "C++'ta class ile struct arasındaki tek fark nedir?",
                    options = listOf("class üyeleri varsayılan olarak private, struct üyeleri varsayılan olarak public'tir", "struct fonksiyon içeremez", "class daha yavaştır", "Hiçbir fark yoktur"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Varsayılan erişim belirteci class'ta private, struct'ta public'tir.",
                    explanationWrong = "Varsayılan erişim belirteci farkıdır.",
                    reviewTopic = "C++ OOP"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Kapsülleme (Encapsulation) neden önemlidir?",
                    answer = "Dışarıdan birinin 'oyuncu.can = -9999;' gibi hatalı değerler girmesini engelleyip veriyi güvenli metotlarla kontrol altında tutar."
                )
            ),
            completionCriteria = listOf(
                "Class ve nesne tanımlayabilmek",
                "public ve private farkını bilmek"
            )
        ),

        // ==========================================
        // DERS 6: CONSTRUCTOR VE DESTRUCTOR
        // ==========================================
        Lesson(
            id = "cpp_6",
            courseId = "cpp",
            sectionId = "cpp_sec_3",
            title = "Kurucular (Constructor) ve Yıkıcılar (Destructor)",
            shortDesc = "Nesne doğduğunda otomatik çalışan Constructor ve nesne silinirken temizlik yapan Destructor (~).",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true,
            learningObjectives = listOf(
                "Constructor ile nesneyi ilk değerlerle başlatmak",
                "Destructor (~SınıfAdi) ile otomatik temizlik yapmak",
                "RAII (Kaynak Yönetimi) felsefesini anlamak"
            ),
            prerequisites = listOf("Sınıflar ve Nesneler"),
            subtopics = listOf("Constructor (Kurucu)", "Destructor (Yıkıcı ~)", "RAII Prensibi"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Doğum ve Veda Anı",
                    body = "Bir nesne oluşturulduğu an **Constructor** devreye girer. İşlevi bitip süslü parantez kapandığında ise **Destructor (~)** otomatik çağrılarak tüm kaynakları arkasında çöp bırakmadan temizler.",
                    codeSnippet = "class Silah {\npublic:\n    Silah(std::string isim) {\n        std::cout << isim << \" kuşanıldı! ⚔️\\n\";\n    }\n    \n    ~Silah() {\n        std::cout << \"Silah kılıfına kondu.\\n\";\n    }\n};"
                )
            ),
            codeExample = "{\n    Silah s(\"Kılıç\"); // Kurucu çalışır\n} // Parantez bittiğinde yıkıcı (~) otomatik çalışır!",
            codeExplanation = "RAII prensibi sayesinde bellek otomatik temizlenir.",
            realWorldExample = "Bir dosya açtığınızda constructor dosyayı açar, süslü parantezden çıkıldığında destructor dosyayı otomatik kapatır.",
            practicalTask = "Basit bir Constructor ve Destructor içeren sınıf yazın.",
            starterPlaygroundCode = "class Test { public: Test(){ std::cout << \"Açıldı\"; } ~Test(){ std::cout << \"Kapandı\"; } };",
            miniQuestion = MiniQuestion(
                id = "cpp_q_6",
                question = "C++'ta bir sınıfın Yıkıcı (Destructor) fonksiyonu hangi özel işaretle başlar?",
                options = listOf("~ (Tilde)", "!", "#", "@"),
                correctIndex = 0,
                explanation = "Yıkıcı fonksiyon '~' (tilde) işaretiyle başlar (örn: ~Sınıf())."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_cpp_6",
                lessonId = "cpp_6",
                title = "Başlangıç Değerli Oyuncu",
                instructions = "Kurucusunda isim ve can değerlerini alan ve getBilgi() metodu 'isim (can)' döndüren Oyuncu sınıfını yazın.",
                exampleInput = "Oyuncu p(\"Ali\", 100); p.getBilgi()",
                exampleOutput = "\"Ali (100)\"",
                starterCode = "#include <string>\n\nclass Oyuncu {\npublic:\n    std::string isim;\n    int can;\n    Oyuncu(std::string i, int c) : isim(i), can(c) {}\n    std::string getBilgi() {\n        // Kodunu yaz:\n        return \"\";\n    }\n};",
                solutionCode = "#include <string>\n\nclass Oyuncu {\npublic:\n    std::string isim;\n    int can;\n    Oyuncu(std::string i, int c) : isim(i), can(c) {}\n    std::string getBilgi() {\n        return isim + \" (\" + std::to_string(can) + \")\";\n    }\n};",
                hints = listOf("return isim + \" (\" + std::to_string(can) + \")\"; yazın."),
                testCases = listOf(
                    TestCase("Oyuncu p(\"Ali\", 100); p.getBilgi()", "Ali (100)", "Oyuncu bilgi testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "cpp_quiz_6_1",
                    lessonId = "cpp_6",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "C++'ın en büyük güçlerinden biri olan RAII ne anlama gelir?",
                    options = listOf("Kaynak Edinimi Başlatmadır (Kaynakların nesne ömrüyle otomatik yönetilmesi ve temizlenmesi)", "Hızlı derleme", "Grafik çizimi", "Döngü optimizasyonu"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! RAII bellek ve dosya kaynaklarını otomatik yönetir.",
                    explanationWrong = "RAII otomatik kaynak yönetimidir.",
                    reviewTopic = "C++ RAII"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Yıkıcı (Destructor) parametre alabilir mi?",
                    answer = "Hayır! Destructor asla parametre alamaz ve geriye değer döndüremez."
                )
            ),
            completionCriteria = listOf(
                "Constructor ve Destructor mantığını kavramak",
                "RAII prensibini anlamak"
            )
        ),

        // ==========================================
        // DERS 7: KALITIM VE ÇOK BİÇİMLİLİK
        // ==========================================
        Lesson(
            id = "cpp_7",
            courseId = "cpp",
            sectionId = "cpp_sec_4",
            title = "Kalıtım (Inheritance) ve Çok Biçimlilik (Polymorphism)",
            shortDesc = "Ortak özellikleri miras alma ve virtual / override ile her sınıfa özel ses çıkartma.",
            level = CourseLevel.INTERMEDIATE,
            order = 7,
            isPremium = true,
            learningObjectives = listOf(
                "class Kedi : public Hayvan kalıtım yapısını kurmak",
                "virtual ve override ile metotları ezmek (Polymorphism)",
                "Soyut sınıflar (Abstract Classes) ve Interface mantığını öğrenmek"
            ),
            prerequisites = listOf("Sınıflar ve Kurucular"),
            subtopics = listOf("Kalıtım (Inheritance)", "virtual ve override", "Polymorphism"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Kalıtım ve Sanal Metotlar (virtual)",
                    body = "Bir `Hayvan` sınıfı yazıp `sesCikar()` metoduna `virtual` dersek; `Kopek` sınıfı havlar, `Kedi` sınıfı miyavlar. Tek bir listede tüm hayvanları toplayıp sırayla ses çıkartabiliriz!",
                    codeSnippet = "class Hayvan {\npublic:\n    virtual void sesCikar() {\n        std::cout << \"Bilinmeyen ses\\n\";\n    }\n};\n\nclass Kedi : public Hayvan {\npublic:\n    void sesCikar() override {\n        std::cout << \"Miyav! 🐱\\n\";\n    }\n};"
                )
            ),
            codeExample = "Hayvan *h = new Kedi();\nh->sesCikar(); // \"Miyav!\" yazar\ndelete h;",
            codeExplanation = "Polymorphism sayesinde doğru sınıfın metodu çağrıldı.",
            realWorldExample = "Oyunlarda 'Dusman' ana sınıfından türeyen 'Zombi', 'Ejderha' ve 'Robot' düşmanları.",
            practicalTask = "Sekil sınıfından türeyen Daire sınıfı tasarlayın.",
            starterPlaygroundCode = "class Sekil { public: virtual void ciz() {} };\nclass Daire : public Sekil { public: void ciz() override {} };",
            miniQuestion = MiniQuestion(
                id = "cpp_q_7",
                question = "Alt sınıfların bir metodu kendi ihtiyacına göre ezebilmesi (override) için üst sınıfta metodun başına hangi kelime konur?",
                options = listOf("virtual", "override", "abstract", "dynamic"),
                correctIndex = 0,
                explanation = "Ezilebilir metotlar 'virtual' ile işaretlenir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_cpp_7",
                lessonId = "cpp_7",
                title = "Kalıtımlı Köpek Sınıfı",
                instructions = "Hayvan sınıfından türeyen ve sesCikar() metodunda 'Hav!' döndüren Kopek sınıfını yazın.",
                exampleInput = "Kopek k; k.sesCikar()",
                exampleOutput = "\"Hav!\"",
                starterCode = "#include <string>\n\nclass Hayvan {\npublic:\n    virtual std::string sesCikar() { return \"Ses\"; }\n};\n\nclass Kopek : public Hayvan {\npublic:\n    // Kodunu yaz:\n};",
                solutionCode = "#include <string>\n\nclass Hayvan {\npublic:\n    virtual std::string sesCikar() { return \"Ses\"; }\n};\n\nclass Kopek : public Hayvan {\npublic:\n    std::string sesCikar() override { return \"Hav!\"; }\n};",
                hints = listOf("std::string sesCikar() override { return \"Hav!\"; } yazın."),
                testCases = listOf(
                    TestCase("Kopek k; k.sesCikar()", "Hav!", "Köpek sesi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "cpp_quiz_7_1",
                    lessonId = "cpp_7",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir C++ sınıfının türetildiği üst sınıfta sanal yıkıcı (virtual ~SinifAdi()) yazmak neden hayati önem taşır?",
                    options = listOf("delete yapıldığında alt sınıfın yıkıcısının da düzgünce çalışıp bellek sızıntısını önlemesi için", "Daha hızlı derleme için", "Programı kapatmak için", "Gerekli değildir"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Sanal yıkıcı alt sınıfların güvenle silinmesini sağlar.",
                    explanationWrong = "Bellek sızıntılarını önlemek için sanal yıkıcı zorunludur.",
                    reviewTopic = "C++ Sanal Yıkıcılar"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Saf Sanal Fonksiyon (Pure Virtual) nedir?",
                    answer = "virtual void ciz() = 0; şeklinde gövdesi olmayan ve alt sınıfların doldurmasını zorunlu kılan arayüz (interface) metodudur."
                )
            ),
            completionCriteria = listOf(
                "Kalıtım ve override kavramını bilmek",
                "virtual fonksiyonların amacını anlamak"
            )
        ),

        // ==========================================
        // DERS 8: AKILLI İŞARETÇİLER (SMART POINTERS)
        // ==========================================
        Lesson(
            id = "cpp_8",
            courseId = "cpp",
            sectionId = "cpp_sec_4",
            title = "Modern C++: Akıllı İşaretçiler (unique_ptr ve shared_ptr)",
            shortDesc = "delete yazmayı sonsuza dek unutturan ve bellek sızıntısını sıfıra indiren akıllı işaretçiler.",
            level = CourseLevel.INTERMEDIATE,
            order = 8,
            isPremium = true,
            learningObjectives = listOf(
                "std::make_unique ve std::unique_ptr ile tek sahipli bellek yönetmek",
                "std::make_shared ve std::shared_ptr ile ortak sahipli bellek yönetmek",
                "delete anahtar kelimesine ihtiyaç duymadan %100 güvenli C++ yazmak"
            ),
            prerequisites = listOf("Sınıflar ve RAII"),
            subtopics = listOf("std::unique_ptr", "std::shared_ptr", "make_unique Kullanımı"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Manuel delete Dönemi Bitti!",
                    body = "Eski C++'ta `new` ile açtığınız belleği `delete` etmeyi unutursanız oyun çökerdi. Modern C++'ta `std::make_unique` kullanırız; nesneyle işimiz bittiğinde C++ kendisi anında siler!",
                    codeSnippet = "#include <iostream>\n#include <memory>\n\nclass Canavar {\npublic:\n    void saldir() { std::cout << \"Kükredi! 🐉\\n\"; }\n};\n\nint main() {\n    // Akıllı işaretçi oluşturalım:\n    auto ejderha = std::make_unique<Canavar>();\n    ejderha->saldir();\n    \n    // delete YAZMAYA GEREK YOK! Otomatik silinir.\n    return 0;\n}"
                )
            ),
            codeExample = "auto ptr = std::make_unique<int>(42);\nstd::cout << *ptr << std::endl; // 42",
            codeExplanation = "unique_ptr ile güvenli dinamik değişken oluşturuldu.",
            realWorldExample = "Modern oyun motorlarında sahnede açılan efektler ve ses dosyaları unique_ptr ile yönetilir.",
            practicalTask = "make_unique ile bir nesne oluşturup metodunu çağırın.",
            starterPlaygroundCode = "auto p = std::make_unique<int>(10);",
            miniQuestion = MiniQuestion(
                id = "cpp_q_8",
                question = "Bellekteki bir nesnenin tek bir sahibi olmasını sağlayan ve kopyalanamayan modern C++ akıllı işaretçisi hangisidir?",
                options = listOf("std::unique_ptr", "std::shared_ptr", "std::weak_ptr", "std::raw_ptr"),
                correctIndex = 0,
                explanation = "Tek sahiplik için 'std::unique_ptr' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_cpp_8",
                lessonId = "cpp_8",
                title = "Akıllı İşaretçi Değeri",
                instructions = "make_unique<int>(deger) ile oluşturulan işaretçideki değeri okuyup döndüren akilliDeger(deger) fonksiyonunu yazın.",
                exampleInput = "akilliDeger(99)",
                exampleOutput = "99",
                starterCode = "#include <memory>\n\nint akilliDeger(int deger) {\n    // Kodunu yaz:\n    return 0;\n}",
                solutionCode = "#include <memory>\n\nint akilliDeger(int deger) {\n    auto ptr = std::make_unique<int>(deger);\n    return *ptr;\n}",
                hints = listOf("auto ptr = std::make_unique<int>(deger); return *ptr; yazın."),
                testCases = listOf(
                    TestCase("akilliDeger(99)", "99", "Akıllı işaretçi testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "cpp_quiz_8_1",
                    lessonId = "cpp_8",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "std::shared_ptr bir nesneyi bellekten tam olarak ne zaman siler?",
                    options = listOf("O nesneyi gösteren son shared_ptr referansı da yok olduğunda (Referans Sayacı = 0)", "Program ilk açıldığında", "Rastgele bir zamanda", "Hiçbir zaman"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Referans sayacı 0'a düştüğü an bellek serbest bırakılır.",
                    explanationWrong = "Referans sayacı sıfır olduğunda silinir.",
                    reviewTopic = "C++ Shared Pointers"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Neden raw pointer (int *p = new int) yerine unique_ptr kullanmalıyız?",
                    answer = "Çünkü kodun ortasında bir hata fırlatılsa bile unique_ptr hafızayı kesinlikle temizler, bellek sızıntısını imkansız kılar."
                )
            ),
            completionCriteria = listOf(
                "std::unique_ptr ve std::shared_ptr farkını bilmek",
                "std::make_unique kullanabilmek"
            )
        ),

        // ==========================================
        // DERS 9: ŞABLONLAR (TEMPLATES)
        // ==========================================
        Lesson(
            id = "cpp_9",
            courseId = "cpp",
            sectionId = "cpp_sec_5",
            title = "Şablonlar (Templates): Her Tip İçin Tek Kod",
            shortDesc = "Hem int, hem double, hem string için çalışan evrensel jenerik fonksiyonlar ve sınıflar.",
            level = CourseLevel.ADVANCED,
            order = 9,
            isPremium = true,
            learningObjectives = listOf(
                "template <typename T> ile jenerik fonksiyonlar yazmak",
                "Farklı tipler için tekrar tekrar fonksiyon yazmaktan kurtulmak",
                "Tip güvenli şablon mantığını kavramak"
            ),
            prerequisites = listOf("Fonksiyonlar ve Sınıflar"),
            subtopics = listOf("template <typename T>", "Jenerik Fonksiyonlar", "Şablon Sınıflar"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Bir Kere Yaz, Her Tipte Kullan",
                    body = "İki sayıyı toplayan bir fonksiyon yazmak istiyorsunuz. int için ayrı, float için ayrı yazmak yerine bir `Template` açarsınız, C++ derleyicisi ihtiyaca göre otomatik üretir!",
                    codeSnippet = "template <typename T>\nT topla(T a, T b) {\n    return a + b;\n}\n\nint main() {\n    std::cout << topla(5, 10) << std::endl;         // 15 (int)\n    std::cout << topla(3.5, 2.5) << std::endl;     // 6.0 (double)\n    std::cout << topla(std::string(\"A\"), std::string(\"B\")); // AB\n}"
                )
            ),
            codeExample = "template <typename T>\nT maksimum(T a, T b) {\n    return (a > b) ? a : b;\n}",
            codeExplanation = "maksimum fonksiyonu tüm veri tipleriyle kusursuz çalışır.",
            realWorldExample = "std::vector<int> veya std::vector<std::string> arkasında çalışan mekanizma bir C++ Template'idir.",
            practicalTask = "İki değeri ekrana yazdıran jenerik yazdir<T>(T deger) fonksiyonunu inceleyin.",
            starterPlaygroundCode = "template <typename T>\nvoid yazdir(T x) { std::cout << x << std::endl; }",
            miniQuestion = MiniQuestion(
                id = "cpp_q_9",
                question = "C++'ta jenerik (şablon) bir fonksiyon veya sınıf tanımlamak için hangi anahtar kelime kullanılır?",
                options = listOf("template <typename T>", "generic <T>", "dynamic <T>", "macro <T>"),
                correctIndex = 0,
                explanation = "Şablon tanımlamak için 'template <typename T>' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_cpp_9",
                lessonId = "cpp_9",
                title = "Jenerik Minimum",
                instructions = "İki parametreden küçük olanını döndüren template <typename T> T minimum(T a, T b) fonksiyonunu yazın.",
                exampleInput = "minimum(10, 20)",
                exampleOutput = "10",
                starterCode = "template <typename T>\nT minimum(T a, T b) {\n    // Kodunu yaz:\n    return a;\n}",
                solutionCode = "template <typename T>\nT minimum(T a, T b) {\n    return (a < b) ? a : b;\n}",
                hints = listOf("return (a < b) ? a : b; yazın."),
                testCases = listOf(
                    TestCase("minimum(10, 20)", "10", "Minimum int"),
                    TestCase("minimum(5.5, 2.2)", "2.2", "Minimum double")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "cpp_quiz_9_1",
                    lessonId = "cpp_9",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "C++ Şablonları (Templates) çalışma anında mı yoksa derleme anında mı çözümlenir?",
                    options = listOf("Derleme anında (Compile-time) sıfır performans kaybıyla çözümlenir", "Çalışma anında", "Yalnızca hata durumunda", "Tarayıcıda"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! C++ şablonları derleme anında işlendiği için sıfır hız kaybı yaşatır.",
                    explanationWrong = "Derleme anında çözümlenir.",
                    reviewTopic = "C++ Templates"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "typename yerine class yazılabilir mi?",
                    answer = "Evet, template <class T> ile template <typename T> tamamen aynı anlama gelir."
                )
            ),
            completionCriteria = listOf(
                "template tanımlayabilmek",
                "Jenerik fonksiyon mantığını anlamak"
            )
        ),

        // ==========================================
        // DERS 10: STL HARİKALARI (MAP, SORT, LAMBDALAR)
        // ==========================================
        Lesson(
            id = "cpp_10",
            courseId = "cpp",
            sectionId = "cpp_sec_5",
            title = "STL Harikaları: std::map, std::sort ve Lambdalar",
            shortDesc = "Anahtar-değer sözlükleri (std::map), şimşek hızında sıralama ve tek satırlık lambda fonksiyonları.",
            level = CourseLevel.ADVANCED,
            order = 10,
            isPremium = true,
            learningObjectives = listOf(
                "std::map ile anahtar-değer (Key-Value) veri saklamak",
                "std::sort ile listeleri küçükten büyüğe sıralamak",
                "[](int x) { ... } lambda ifadeleri ile anlık fonksiyonlar üretmek"
            ),
            prerequisites = listOf("Vektörler ve Şablonlar"),
            subtopics = listOf("std::map", "std::sort", "C++ Lambda İfadeleri"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. std::map ve std::sort",
                    body = "STL (Standart Şablon Kütüphanesi) C++'ın en büyük zenginliğidir. Arama motoru hızında çalışan `map` ve en hızlı sıralama algoritmaları hazır gelir.",
                    codeSnippet = "#include <iostream>\n#include <vector>\n#include <algorithm>\n#include <map>\n\nint main() {\n    // 1. Sözlük (map):\n    std::map<std::string, int> skorlar;\n    skorlar[\"Ahmet\"] = 95;\n    skorlar[\"Elif\"] = 100;\n    \n    // 2. Sıralama ve Lambda:\n    std::vector<int> sayilar = {5, 2, 8, 1};\n    std::sort(sayilar.begin(), sayilar.end()); // 1, 2, 5, 8\n    return 0;\n}"
                )
            ),
            codeExample = "std::vector<int> v = {1, 2, 3};\nstd::for_each(v.begin(), v.end(), [](int n) { std::cout << n * 2 << \" \"; }); // 2 4 6",
            codeExplanation = "Lambda fonksiyonu ile tüm elemanlar ikiye katlanıp yazdırıldı.",
            realWorldExample = "Oyun içi liderlik tablosu sıralaması std::sort ve lambda ile yapılır.",
            practicalTask = "std::map ile öğrenci adı ve notunu eşleştiren bir örnek yapın.",
            starterPlaygroundCode = "std::map<std::string, int> notlar; notlar[\"Ali\"] = 90;",
            miniQuestion = MiniQuestion(
                id = "cpp_q_10",
                question = "C++'ta bir vektörü küçükten büyüğe sıralamak için <algorithm> kütüphanesindeki hangi fonksiyon kullanılır?",
                options = listOf("std::sort", "std::order", "std::arrange", "std::quick"),
                correctIndex = 0,
                explanation = "Sıralama için 'std::sort(baslangic, bitis)' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_cpp_10",
                lessonId = "cpp_10",
                title = "Vektör Sıralayıcı",
                instructions = "Verilen std::vector<int> listesini küçükten büyüğe sıralayıp ilk (en küçük) elemanını döndüren enKucukBul(vec) fonksiyonunu yazın.",
                exampleInput = "enKucukBul({9, 3, 7})",
                exampleOutput = "3",
                starterCode = "#include <vector>\n#include <algorithm>\n\nint enKucukBul(std::vector<int> vec) {\n    // Kodunu yaz:\n    return 0;\n}",
                solutionCode = "#include <vector>\n#include <algorithm>\n\nint enKucukBul(std::vector<int> vec) {\n    std::sort(vec.begin(), vec.end());\n    return vec[0];\n}",
                hints = listOf("std::sort(vec.begin(), vec.end()); return vec[0]; yazın."),
                testCases = listOf(
                    TestCase("enKucukBul({9, 3, 7})", "3", "En küçük eleman")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "cpp_quiz_10_1",
                    lessonId = "cpp_10",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "C++'ta isimsiz anlık fonksiyon (Lambda) tanımlarken kullanılan giriş köşeli parantezi '[]' neyi temsil eder?",
                    options = listOf("Yakalama Listesi (Capture Clause - Dışarıdaki değişkenleri içine alma)", "Dizi boyutu", "İndeks numarası", "Tip belirteci"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! '[]' dışarıdaki değişkenleri yakalamak (Capture) içindir.",
                    explanationWrong = "Yakalama listesidir.",
                    reviewTopic = "C++ Lambdalar"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "std::map ile std::unordered_map farkı nedir?",
                    answer = "std::map anahtarları sıralı tutar (Kırmızı-Siyah Ağaç), unordered_map ise sırasız ama O(1) hızında çalışır (Hash Tablosu)."
                )
            ),
            completionCriteria = listOf(
                "std::map ve std::sort kullanımını bilmek",
                "Lambda fonksiyonlarını kavramak"
            )
        ),

        // ==========================================
        // DERS 11: HATA YÖNETİMİ (TRY-CATCH)
        // ==========================================
        Lesson(
            id = "cpp_11",
            courseId = "cpp",
            sectionId = "cpp_sec_6",
            title = "Hata Yakalama: try-catch ve Güvenli Kod",
            shortDesc = "Programın aniden çökmesini engelleyen try-catch blokları ve throw ile özel hata fırlatma.",
            level = CourseLevel.EXPERT,
            order = 11,
            isPremium = true,
            learningObjectives = listOf(
                "try ve catch blokları kurmak",
                "throw ile mantıksal hata fırlatmak",
                "std::exception ve .what() mesajını okumak"
            ),
            prerequisites = listOf("Sınıflar ve STL"),
            subtopics = listOf("try / catch", "throw İfadesi", "std::runtime_error"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Programın Çökmesini Önlemek",
                    body = "Kullanıcı sıfıra bölme yaptığında veya olmayan bir dosyayı açtığında programın patlamaması için kodları `try` içine alır, hatayı `catch` ile yumuşakça yakalarız.",
                    codeSnippet = "#include <iostream>\n#include <stdexcept>\n\ndouble bol(double a, double b) {\n    if (b == 0) throw std::runtime_error(\"Sıfıra bölünemez!\");\n    return a / b;\n}\n\nint main() {\n    try {\n        std::cout << bol(10, 0);\n    } catch (const std::exception &e) {\n        std::cout << \"Hata Yakalandı: \" << e.what() << std::endl;\n    }\n    return 0;\n}"
                )
            ),
            codeExample = "try {\n    throw std::string(\"Bağlantı koptu\");\n} catch (const std::string &hata) {\n    std::cout << \"Sorun: \" << hata << std::endl;\n}",
            codeExplanation = "Fırlatılan hata güvenle yakalandı.",
            realWorldExample = "Online oyunlarda sunucuyla bağlantı koptuğunda oyunun direkt kapanmak yerine 'Bağlantı Kesildi' uyarısı vermesi try-catch ile sağlanır.",
            practicalTask = "try-catch bloğunu inceleyin.",
            starterPlaygroundCode = "try { /* ... */ } catch (...) { std::cout << \"Hata!\"; }",
            miniQuestion = MiniQuestion(
                id = "cpp_q_11",
                question = "C++'ta yakalanan standart bir hatanın açıklama mesajını okumak için hangi metot çağrılır?",
                options = listOf("e.what()", "e.getMessage()", "e.text()", "e.error()"),
                correctIndex = 0,
                explanation = "Hata mesajı 'e.what()' ile okunur."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_cpp_11",
                lessonId = "cpp_11",
                title = "Güvenli Bölme",
                instructions = "b sıfır ise -1 döndüren, değilse a / b tam sayı sonucunu döndüren guvenliBol(a, b) fonksiyonunu yazın.",
                exampleInput = "guvenliBol(10, 0)",
                exampleOutput = "-1",
                starterCode = "int guvenliBol(int a, int b) {\n    // Kodunu yaz:\n    return 0;\n}",
                solutionCode = "int guvenliBol(int a, int b) {\n    if (b == 0) return -1;\n    return a / b;\n}",
                hints = listOf("if (b == 0) return -1; return a / b; yazın."),
                testCases = listOf(
                    TestCase("guvenliBol(10, 0)", "-1", "Sıfıra bölme"),
                    TestCase("guvenliBol(10, 2)", "5", "Normal bölme")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "cpp_quiz_11_1",
                    lessonId = "cpp_11",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir C++ fonksiyonunda kasıtlı olarak bir hata durumu fırlatmak için hangi anahtar kelime kullanılır?",
                    options = listOf("throw", "raise", "error", "catch"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Hata fırlatmak için 'throw' kullanılır.",
                    explanationWrong = "throw kelimesi kullanılır.",
                    reviewTopic = "C++ Hata Yönetimi"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "catch(...) ne anlama gelir?",
                    answer = "Tipi ne olursa olsun fırlatılan tüm hataları genel olarak yakalayan joker catch bloğudur."
                )
            ),
            completionCriteria = listOf(
                "try-catch yapısını kurabilmek",
                "throw ile hata fırlatabilmek"
            )
        ),

        // ==========================================
        // DERS 12: OYUN MOTORLARI VE C++ GELECEĞİ
        // ==========================================
        Lesson(
            id = "cpp_12",
            courseId = "cpp",
            sectionId = "cpp_sec_6",
            title = "C++ Ustalığı: Unreal Engine, Oyun Motorları ve Gelecek",
            shortDesc = "C++ ile oyun geliştirme, yüksek frekanslı ticaret (HFT) ve geleceğin teknolojileri.",
            level = CourseLevel.EXPERT,
            order = 12,
            isPremium = true,
            learningObjectives = listOf(
                "C++'ın oyun motorlarındaki (Unreal Engine) yerini kavramak",
                "Modern C++20 / C++23 yeniliklerini tanımak",
                "Tebrikler: Artık dünyanın en güçlü diline hakim bir yazılımcısınız!"
            ),
            prerequisites = listOf("Tüm C++ Konuları"),
            subtopics = listOf("Unreal Engine & C++", "C++20 / C++23", "Tebrikler ve Tavsiyeler"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Tebrikler! C++ Müfredatını Başarıyla Tamamladınız! 🎮🏆",
                    body = "Artık bellek yönetiminden nesne yönelimli mimariye, STL kütüphanesinden akıllı işaretçilere kadar C++'ın tüm temel ve ileri düzey dinamiklerine hakimsiniz.\n\nUnreal Engine ile hayalinizdeki 3D oyunu geliştirebilir, robotik sistemler kodlayabilir veya yüksek hızlı finans yazılımları üretebilirsiniz!"
                )
            ),
            codeExample = "// C++ Geliştiricisi Başarı Sertifikası\n#include <iostream>\nint main() {\n    std::cout << \"C++ Seviyeniz: USTA! 🚀\" << std::endl;\n    return 0;\n}",
            codeExplanation = "C++ yolculuğunuz başarıyla tamamlandı.",
            realWorldExample = "Dünyanın en popüler oyun motorlarından Unreal Engine tamamen C++ ile programlanır.",
            practicalTask = "C++ başarılarınızı kutlayın!",
            starterPlaygroundCode = "// Tebrikler C++ Geliştiricisi!",
            miniQuestion = MiniQuestion(
                id = "cpp_q_12",
                question = "Dünyaca ünlü AAA kalitesindeki oyunların geliştirildiği Unreal Engine motorunun ana programlama dili hangisidir?",
                options = listOf("C++", "Java", "Python", "PHP"),
                correctIndex = 0,
                explanation = "Unreal Engine'in ana dili C++'tır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_cpp_12",
                lessonId = "cpp_12",
                title = "Şampiyon Mesajı",
                instructions = "Üstünde 'C++ Şampiyonu' yazan bir string döndüren sampiyon() fonksiyonunu yazın.",
                exampleInput = "sampiyon()",
                exampleOutput = "\"C++ Şampiyonu\"",
                starterCode = "#include <string>\n\nstd::string sampiyon() {\n    // Kodunu yaz:\n    return \"\";\n}",
                solutionCode = "#include <string>\n\nstd::string sampiyon() {\n    return \"C++ Şampiyonu\";\n}",
                hints = listOf("return \"C++ Şampiyonu\"; yazın."),
                testCases = listOf(
                    TestCase("sampiyon()", "C++ Şampiyonu", "Şampiyon testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "cpp_quiz_12_1",
                    lessonId = "cpp_12",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "C++ dilinin 'Sıfır Ek Yük Prensibi' (Zero-overhead principle) ne anlama gelir?",
                    options = listOf("Kullanmadığınız hiçbir özelliğin bedelini (hız/hafıza kaybı olarak) ödemezsiniz", "Bedava bir dildir", "Hiç bellek harcamaz", "Sıfır hata ile çalışır"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Bjarne Stroustrup'un ünlü ilkesidir: Kullanmadığın özelliğin maliyeti sıfırdır.",
                    explanationWrong = "Sıfır ek yük prensibidir.",
                    reviewTopic = "C++ Felsefesi"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "C++'ı iyi öğrenmek bana ne kazandırdı?",
                    answer = "Tüm programlama dillerinin arka planını, donanım optimizasyonunu ve en zorlu mimarileri rahatça anlama yeteneği kazandırdı."
                )
            ),
            completionCriteria = listOf(
                "C++ vizyonunu kazanmak",
                "Oyun ve sistem mimarilerine hazır olmak"
            )
        )
    )
}
