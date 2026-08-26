package com.example.data.catalog

import com.example.model.*

/**
 * C Kolay & Anlaşılır Müfredatı (12 Adım):
 * Tüm modern dillerin atası C dilini sıfırdan, korkusuzca ve eğlenceli örneklerle öğrenin.
 */
object CCurriculum {

    fun getSections(): List<CourseSection> = listOf(
        CourseSection(
            id = "c_sec_1",
            courseId = "c",
            title = "Bölüm 1: C Temelleri ve Kontrol Akışı",
            level = CourseLevel.BEGINNER,
            order = 1,
            description = "Yazılımın temel taşı C'ye giriş: main(), printf ile ekrana yazdırma, değişkenler, if-else ve döngüler.",
            learningObjectives = listOf("main() fonksiyonunu kavramak", "printf ile ekrana biçimli yazı yazdırmak", "if-else ve for/while döngülerini öğrenmek"),
            prerequisites = listOf("Ön bilgi gerekmez! Sıfırdan başlar.")
        ),
        CourseSection(
            id = "c_sec_2",
            courseId = "c",
            title = "Bölüm 2: Fonksiyonlar ve Diziler",
            level = CourseLevel.BEGINNER,
            order = 2,
            description = "İşleri fonksiyonlara bölme, sayı dizileri ve C'de metinlerin (string) mantığı.",
            learningObjectives = listOf("Kendi fonksiyonlarını yazmak", "Dizilerde (Array) veri saklamak", "C metinlerini ('\\0') anlamak"),
            prerequisites = listOf("C Temelleri ve Döngüler")
        ),
        CourseSection(
            id = "c_sec_3",
            courseId = "c",
            title = "Bölüm 3: Pointerlar (İşaretçiler) ve Bellek",
            level = CourseLevel.INTERMEDIATE,
            order = 3,
            description = "Korkulacak hiçbir şey yok! Ev adresleri gibi bellek adreslerini (& ve *) ve malloc/free mantığını öğrenin.",
            learningObjectives = listOf("Bellek adresi (&) ve Pointer (*) kavramını çözmek", "malloc ve free ile hafıza yönetmek"),
            prerequisites = listOf("Fonksiyonlar ve Diziler")
        ),
        CourseSection(
            id = "c_sec_4",
            courseId = "c",
            title = "Bölüm 4: Yapılar (struct) ve Özel Tipler",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            description = "Farklı bilgileri tek pakette toplayan struct, typedef ve enum yapıları.",
            learningObjectives = listOf("struct ile kendi veri modelini kurmak", "typedef ile kodları sadeleştirmek"),
            prerequisites = listOf("Pointerlar ve Fonksiyonlar")
        ),
        CourseSection(
            id = "c_sec_5",
            courseId = "c",
            title = "Bölüm 5: Dosyalar ve Bit Düzeyinde İşlemler",
            level = CourseLevel.ADVANCED,
            order = 5,
            description = "Dosyalara yazı yazma/okuma (fopen) ve bilgisayarın en hızlı dili olan bit işlemleri.",
            learningObjectives = listOf("fopen ve fclose ile dosya yönetmek", "Bit düzeyinde işlemler yapmak"),
            prerequisites = listOf("struct ve Bellek Yönetimi")
        ),
        CourseSection(
            id = "c_sec_6",
            courseId = "c",
            title = "Bölüm 6: İleri C ve Sistem Dünyası",
            level = CourseLevel.EXPERT,
            order = 6,
            description = "İşletim sistemleri, mikroçip programlama ve C ustası olmanın yolları.",
            learningObjectives = listOf("C ile sistem programlama mantığını kavramak", "Hatasız ve güvenli C kodu yazmak"),
            prerequisites = listOf("Tüm Seviyeler")
        )
    )

    fun getLessons(): List<Lesson> = listOf(
        // ==========================================
        // DERS 1: MAIN(), PRINTF VE DEĞİŞKENLER
        // ==========================================
        Lesson(
            id = "c_1",
            courseId = "c",
            sectionId = "c_sec_1",
            title = "C Diline Giriş: main(), printf ve Değişkenler",
            shortDesc = "Tüm programlama dillerinin atası C'ye ilk adım! main() fonksiyonu ve ekrana yazdırma.",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false,
            learningObjectives = listOf(
                "#include <stdio.h> ve main() fonksiyonunun görevini anlamak",
                "printf() fonksiyonu ile ekrana biçimli metin basmak",
                "int, float, double ve char değişkenlerini tanımlamak",
                "%d, %f, %c yer tutucularını kullanmak"
            ),
            prerequisites = listOf("Ön koşul gerekmez."),
            subtopics = listOf("C Neden Çok Hızlı?", "main() ve stdio.h", "printf() ve %d", "Temel Veri Tipleri"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Programlamanın Kalbine Hoş Geldiniz!",
                    body = "Windows, macOS, Linux, oyun motorları ve uzay araçları C dili ile çalışır. C dili doğrudan donanımla konuştuğu için dünyanın en hızlı ve en hafif dillerinden biridir.\n\nHer C programı `main()` fonksiyonundan başlar.",
                    codeSnippet = "#include <stdio.h>\n\nint main() {\n    // Ekrana ilk mesajımızı yazalım:\n    printf(\"Merhaba C ve Kod Akademi!\\n\");\n    return 0;\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Değişkenler ve Yer Tutucular (%d, %f, %s)",
                    body = "C dilinde ekrana değişken basarken metnin içine özel yer tutucular koyarız:\n\n• `%d`: Tam Sayı (int)\n• `%f`: Ondalıklı Sayı (float)\n• `%c`: Tek Karakter (char)\n• `%s`: Metin (String)",
                    codeSnippet = "int yas = 25;\nfloat boy = 1.78;\n\nprintf(\"Yaşım: %d, Boyum: %.2f\\n\", yas, boy);"
                )
            ),
            codeExample = "#include <stdio.h>\n\nint main() {\n    int puan = 100;\n    printf(\"Sınav Puanı: %d\\n\", puan);\n    return 0;\n}",
            codeExplanation = "puan değişkeni tanımlandı ve %d yer tutucusu ile ekrana basıldı.",
            realWorldExample = "Otomobillerdeki ABS fren beyni veya mikrodalga fırınların içindeki çipler C kodu ile çalışır.",
            practicalTask = "Adınızın baş harfini (char) ve yaşınızı (int) printf ile ekrana yazdırın.",
            starterPlaygroundCode = "#include <stdio.h>\nint main() {\n    int yas = 20;\n    printf(\"Yaş: %d\\n\", yas);\n    return 0;\n}",
            miniQuestion = MiniQuestion(
                id = "c_q_1",
                question = "C dilinde printf fonksiyonuyla ekrana tam sayı (int) yazdırmak için hangi yer tutucu kullanılır?",
                options = listOf("%d", "%s", "%c", "%f"),
                correctIndex = 0,
                explanation = "Tam sayılar (int) için '%d' (decimal) kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_c_1",
                lessonId = "c_1",
                title = "İki Sayının Toplamı",
                instructions = "İki tam sayıyı toplayıp sonucunu döndüren topla(a, b) fonksiyonunu yazın.",
                exampleInput = "topla(10, 20)",
                exampleOutput = "30",
                starterCode = "int topla(int a, int b) {\n    // Kodunu yaz:\n    return 0;\n}",
                solutionCode = "int topla(int a, int b) {\n    return a + b;\n}",
                hints = listOf("return a + b; yazın."),
                testCases = listOf(
                    TestCase("topla(10, 20)", "30", "Toplam testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "c_quiz_1_1",
                    lessonId = "c_1",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "C programlarında standart girdi/çıktı (printf gibi) kütüphanesini dahil etmek için hangi başlık dosyası eklenir?",
                    options = listOf("#include <stdio.h>", "#include <stdlib.h>", "#include <string.h>", "#include <math.h>"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! 'stdio.h' (Standard Input Output) kullanılır.",
                    explanationWrong = "stdio.h başlık dosyası eklenir.",
                    reviewTopic = "C Temelleri"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "main() fonksiyonunun sonundaki 'return 0;' ne demektir?",
                    answer = "İşletim sistemine 'Bu program hiçbir hata olmadan başarıyla tamamlandı' mesajı verir."
                )
            ),
            completionCriteria = listOf(
                "main() ve printf kullanımını bilmek",
                "%d ve %f yer tutucularını kullanabilmek"
            )
        ),

        // ==========================================
        // DERS 2: KOŞULLAR VE DÖNGÜLER
        // ==========================================
        Lesson(
            id = "c_2",
            courseId = "c",
            sectionId = "c_sec_1",
            title = "Kararlar (if-else) ve Döngüler (for, while)",
            shortDesc = "Şartlara göre dallanma, for döngüsüyle sayma ve while ile tekrarlama.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false,
            learningObjectives = listOf(
                "if, else if ve else blokları kurmak",
                "for döngüsü ile sayaçlı işlemler yapmak",
                "while döngüsünü kullanmak"
            ),
            prerequisites = listOf("C Değişkenleri ve printf"),
            subtopics = listOf("if / else", "for Döngüsü", "while Döngüsü"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Kararlar: if ve else",
                    body = "Şartlar parantez `( )` içine yazılır, süslü parantez `{ }` içine yapılacak işler konur.",
                    codeSnippet = "int notu = 85;\n\nif (notu >= 90) {\n    printf(\"Pekiyi (A)\\n\");\n} else if (notu >= 70) {\n    printf(\"İyi (B)\\n\");\n} else {\n    printf(\"Kaldı\\n\");\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. for Döngüsü",
                    body = "1'den 5'e kadar saymak için standart `for (başlangıç; şart; artış)` kalıbı kullanılır.",
                    codeSnippet = "// 1'den 5'e kadar sayalım:\nfor (int i = 1; i <= 5; i++) {\n    printf(\"Adım: %d\\n\", i);\n}"
                )
            ),
            codeExample = "#include <stdio.h>\n\nint main() {\n    int toplam = 0;\n    for (int i = 1; i <= 5; i++) {\n        toplam += i;\n    }\n    printf(\"Toplam: %d\\n\", toplam); // 15\n    return 0;\n}",
            codeExplanation = "for döngüsüyle 1-5 arası sayılar toplandı.",
            realWorldExample = "Robotik kollarda motorun açısını 0 dereceden 180 dereceye kadar adım adım artırırken for döngüsü kullanılır.",
            practicalTask = "1'den 10'a kadar olan sayılardan çift olanları ekrana yazdırın.",
            starterPlaygroundCode = "for (int i = 2; i <= 10; i += 2) {\n    printf(\"%d\\n\", i);\n}",
            miniQuestion = MiniQuestion(
                id = "c_q_2",
                question = "for (int i = 0; i < 3; i++) döngüsü toplam kaç kez çalışır?",
                options = listOf("3", "2", "4", "Sonsuz"),
                correctIndex = 0,
                explanation = "i = 0, 1, 2 değerleri için toplam 3 kez çalışır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_c_2",
                lessonId = "c_2",
                title = "Çift Sayıların Toplamı",
                instructions = "1'den n'e kadar olan çift sayıların toplamını hesaplayan cift_toplami(n) fonksiyonunu yazın.",
                exampleInput = "cift_toplami(6)",
                exampleOutput = "12 (2 + 4 + 6)",
                starterCode = "int cift_toplami(int n) {\n    // Kodunu yaz:\n    return 0;\n}",
                solutionCode = "int cift_toplami(int n) {\n    int top = 0;\n    for (int i = 2; i <= n; i += 2) top += i;\n    return top;\n}",
                hints = listOf("for (int i = 2; i <= n; i += 2) top += i; yazın."),
                testCases = listOf(
                    TestCase("cift_toplami(6)", "12", "6 için toplam"),
                    TestCase("cift_toplami(10)", "30", "10 için toplam")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "c_quiz_2_1",
                    lessonId = "c_2",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "C dilinde eşitlik kontrolü için hangi operatör kullanılır?",
                    options = listOf("==", "=", "!=", "==="),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Karşılaştırma için '==' kullanılır.",
                    explanationWrong = "Eşitlik için '==' kullanılır.",
                    reviewTopic = "C Operatörler"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "while ile do-while farkı nedir?",
                    answer = "while şartı başta kontrol eder; do-while ise şart yanlış olsa bile bloğu en az 1 kez mutlaka çalıştırır."
                )
            ),
            completionCriteria = listOf(
                "if-else blokları yazabilmek",
                "for ve while döngüleri kurabilmek"
            )
        ),

        // ==========================================
        // DERS 3: FONKSİYONLAR
        // ==========================================
        Lesson(
            id = "c_3",
            courseId = "c",
            sectionId = "c_sec_2",
            title = "Fonksiyonlar: Kodları Modüler Hale Getirme",
            shortDesc = "Büyük işleri küçük fonksiyonlara bölme, parametre verme ve return ile sonuç alma.",
            level = CourseLevel.BEGINNER,
            order = 3,
            isPremium = false,
            learningObjectives = listOf(
                "Dönüş tipi, fonksiyon adı ve parametreleri belirlemek",
                "void (sonuç döndürmeyen) fonksiyonları öğrenmek",
                "Fonksiyon prototiplerini anlamak"
            ),
            prerequisites = listOf("C Değişkenleri ve Koşulları"),
            subtopics = listOf("Fonksiyon Tanımlama", "return ve void", "Fonksiyon Çağrısı"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Fonksiyon Yazmak",
                    body = "Fonksiyonun başına ne tür bir sonuç döndüreceğini (`int`, `float` veya hiçbir şey döndürmüyorsa `void`) yazarız.",
                    codeSnippet = "int kareAl(int sayi) {\n    return sayi * sayi;\n}\n\nvoid selamVer() {\n    printf(\"Selam C Geliştiricisi!\\n\");\n}"
                )
            ),
            codeExample = "#include <stdio.h>\n\nint carp(int a, int b) {\n    return a * b;\n}\n\nint main() {\n    printf(\"Sonuç: %d\\n\", carp(4, 5)); // 20\n    return 0;\n}",
            codeExplanation = "carp fonksiyonu iki sayıyı çarparak sonucu main içine döndürdü.",
            realWorldExample = "Oyun motorlarında oyuncunun zıplama fiziğini hesaplayan Jump() fonksiyonu gibi.",
            practicalTask = "İki sayının büyüğünü bulan en_buyuk(a, b) fonksiyonunu yazın.",
            starterPlaygroundCode = "int en_buyuk(int a, int b) {\n    return (a > b) ? a : b;\n}",
            miniQuestion = MiniQuestion(
                id = "c_q_3",
                question = "C dilinde hiçbir değer geri döndürmeyen fonksiyonların dönüş tipi ne olarak belirtilir?",
                options = listOf("void", "null", "empty", "none"),
                correctIndex = 0,
                explanation = "Geriye değer döndürmeyen fonksiyonlar 'void' ile tanımlanır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_c_3",
                lessonId = "c_3",
                title = "Küp Hesaplayıcı",
                instructions = "Verilen sayının küpünü (x * x * x) hesaplayan kup(x) fonksiyonunu yazın.",
                exampleInput = "kup(3)",
                exampleOutput = "27",
                starterCode = "int kup(int x) {\n    // Kodunu yaz:\n    return 0;\n}",
                solutionCode = "int kup(int x) {\n    return x * x * x;\n}",
                hints = listOf("return x * x * x; yazın."),
                testCases = listOf(
                    TestCase("kup(3)", "27", "3'ün küpü"),
                    TestCase("kup(2)", "8", "2'nin küpü")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "c_quiz_3_1",
                    lessonId = "c_3",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir C programı çalıştırıldığında işletim sistemi ilk olarak hangi fonksiyonu arar ve başlatır?",
                    options = listOf("main()", "start()", "init()", "run()"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Giriş noktası daima main() fonksiyonudur.",
                    explanationWrong = "main() fonksiyonudur.",
                    reviewTopic = "C Fonksiyonlar"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Fonksiyon prototipi (Header) nedir?",
                    answer = "Fonksiyonun gövdesini main'in altına yazdıysanız, derleyiciye 'böyle bir fonksiyon var' demek için en üste sadece imzasını (örn: int topla(int, int);) yazarsınız."
                )
            ),
            completionCriteria = listOf(
                "Fonksiyon tanımlayabilmek",
                "void ve return farkını bilmek"
            )
        ),

        // ==========================================
        // DERS 4: DİZİLER VE STRİNGLER
        // ==========================================
        Lesson(
            id = "c_4",
            courseId = "c",
            sectionId = "c_sec_2",
            title = "Diziler (Array) ve Metinler (C Strings)",
            shortDesc = "Sayı dizileri ve C dilinde metinlerin sırrı: Karakter dizisi ve null sonlandırıcı ('\\0').",
            level = CourseLevel.BEGINNER,
            order = 4,
            isPremium = true,
            learningObjectives = listOf(
                "Sayı dizileri tanımlayıp elemanlarına erişmek",
                "C'de metinlerin (char[]) birer karakter dizisi olduğunu kavramak",
                "Metinlerin sonundaki görünmez '\\0' işaretinin önemini anlamak"
            ),
            prerequisites = listOf("Fonksiyonlar ve Döngüler"),
            subtopics = listOf("Diziler", "C Stringleri (char[])", "'\\0' Null Sonlandırıcı"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Diziler ve C Stringleri",
                    body = "C dilinde diğer dillerdeki gibi hazır bir `String` türü yoktur. Metinler aslında `char isim[] = \"Ali\";` şeklinde yan yana dizilmiş karakterlerdir ve en sonunda metnin bittiğini gösteren görünmez bir `\\0` (null karakter) bulunur.",
                    codeSnippet = "int sayilar[3] = {10, 20, 30};\nprintf(\"İlk Sayı: %d\\n\", sayilar[0]); // 10\n\nchar ad[] = \"Zeynep\"; // Otomatik sonuna '\\0' eklenir\nprintf(\"İsim: %s\\n\", ad);"
                )
            ),
            codeExample = "#include <stdio.h>\n#include <string.h>\n\nint main() {\n    char metin[] = \"Kod Akademi\";\n    printf(\"Uzunluk: %lu\\n\", strlen(metin)); // 11\n    return 0;\n}",
            codeExplanation = "string.h kütüphanesindeki strlen() ile metnin karakter sayısı ölçüldü.",
            realWorldExample = "Oyunlarda oyuncu isimleri veya ağ paketlerindeki mesaj başlıkları C dizileriyle işlenir.",
            practicalTask = "5 elemanlı bir int dizisi oluşturup elemanlarını for döngüsüyle yazdırın.",
            starterPlaygroundCode = "int dizi[5] = {1, 2, 3, 4, 5};\nfor(int i=0; i<5; i++) printf(\"%d \", dizi[i]);",
            miniQuestion = MiniQuestion(
                id = "c_q_4",
                question = "C dilinde bir metnin (string) sona erdiğini derleyiciye bildiren özel karakter hangisidir?",
                options = listOf("'\\0' (Null)", "'\\n'", "'\\t'", "'EOF'"),
                correctIndex = 0,
                explanation = "C metinleri '\\0' (null-terminator) ile biter."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_c_4",
                lessonId = "c_4",
                title = "Dizi Elemanları Toplamı",
                instructions = "Verilen n elemanlı dizi dizisinin elemanları toplamını bulan dizi_toplami(dizi, n) fonksiyonunu yazın.",
                exampleInput = "dizi = {2, 3, 5}, n = 3",
                exampleOutput = "10",
                starterCode = "int dizi_toplami(int dizi[], int n) {\n    // Kodunu yaz:\n    return 0;\n}",
                solutionCode = "int dizi_toplami(int dizi[], int n) {\n    int top = 0;\n    for (int i = 0; i < n; i++) top += dizi[i];\n    return top;\n}",
                hints = listOf("for döngüsüyle dizi[i] değerlerini toplayın."),
                testCases = listOf(
                    TestCase("dizi_toplami((int[]){1,2,3}, 3)", "6", "Dizi toplamı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "c_quiz_4_1",
                    lessonId = "c_4",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "C dilinde bir metnin karakter uzunluğunu hesaplayan standart fonksiyon hangisidir?",
                    options = listOf("strlen()", "sizeof()", "length()", "count()"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! string.h içindeki strlen() fonksiyonu kullanılır.",
                    explanationWrong = "strlen() fonksiyonu kullanılır.",
                    reviewTopic = "C Stringleri"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "char metin[5] içine 5 harfli kelime sığar mı?",
                    answer = "Hayır! Sonundaki '\\0' için de 1 bayt yer gerekir; 5 harfli kelime için dizi boyutu en az 6 olmalıdır."
                )
            ),
            completionCriteria = listOf(
                "Dizi tanımlayıp gezebilmek",
                "C String mantığını ve '\\0' karakterini bilmek"
            )
        ),

        // ==========================================
        // DERS 5: POINTERLAR (İŞARETÇİLER)
        // ==========================================
        Lesson(
            id = "c_5",
            courseId = "c",
            sectionId = "c_sec_3",
            title = "Pointerlar (İşaretçiler): Bellek Adreslerinin Sırrı",
            shortDesc = "Korkulacak hiçbir şey yok! Ev adresleri (&) ve adrese gidip kapıyı çalma (*) mantığı.",
            level = CourseLevel.INTERMEDIATE,
            order = 5,
            isPremium = true,
            learningObjectives = listOf(
                "& (Adres) operatörü ile değişkenin RAM'deki adresini öğrenmek",
                "* (Pointer) operatörü ile adrese gidip içeriğe erişmek (Dereference)",
                "Fonksiyonlara değişkenin adresini vererek değerini değiştirmek (Pass-by-reference)"
            ),
            prerequisites = listOf("Fonksiyonlar ve Diziler"),
            subtopics = listOf("& Operatörü (Adres)", "* Operatörü (İşaretçi)", "Değer Değiştirme (Swap)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Pointer Nedir? (Ev Adresi Mantığı)",
                    body = "Arkadaşınıza 'Bana evini ver' diyemezsiniz; ona 'Evinin adresini ver' dersiniz ve adrese giderek eve ulaşırsınız.\n\n• `&yas`: 'yas' değişkeninin hafızadaki **adresini** verir.\n• `*ptr`: O adrese git ve **içindeki değeri** oku/değiştir demektir.",
                    codeSnippet = "int sayi = 10;\nint *ptr = &sayi; // ptr artık sayi'nin hafıza adresini tutar\n\nprintf(\"Sayının Değeri: %d\\n\", sayi);  // 10\nprintf(\"Hafıza Adresi: %p\\n\", ptr);   // Örn: 0x7ffd98...\n\n*ptr = 20; // Adrese gidip değeri 20 yaptık!\nprintf(\"Yeni Değer: %d\\n\", sayi);    // 20!"
                )
            ),
            codeExample = "void degerDegistir(int *x) {\n    *x = 100;\n}\n\nint main() {\n    int a = 5;\n    degerDegistir(&a);\n    printf(\"a = %d\\n\", a); // 100\n    return 0;\n}",
            codeExplanation = "Fonksiyona a'nın adresi (&a) gönderilerek a'nın orijinal değeri değiştirildi.",
            realWorldExample = "İşletim sistemleri klavye tuşuna basıldığında donanım belleğindeki adresleri okumak için pointer kullanır.",
            practicalTask = "İki sayının yerini değiştiren (swap) pointer fonksiyonunu inceleyin.",
            starterPlaygroundCode = "void swap(int *a, int *b) {\n    int temp = *a;\n    *a = *b;\n    *b = temp;\n}",
            miniQuestion = MiniQuestion(
                id = "c_q_5",
                question = "C dilinde bir değişkenin bellekteki adresini almak için değişkenin önüne hangi işaret konur?",
                options = listOf("& (Ampersand)", "* (Yıldız)", "# (Diyez)", "$ (Dolar)"),
                correctIndex = 0,
                explanation = "Bellek adresini almak için '&' işareti kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_c_5",
                lessonId = "c_5",
                title = "Pointer ile Değer İki Katına Çıkarma",
                instructions = "Kendisine gönderilen pointer adresindeki sayıyı iki katına çıkaran ikiye_katla(int *ptr) fonksiyonunu yazın.",
                exampleInput = "int x = 5; ikiye_katla(&x);",
                exampleOutput = "x = 10",
                starterCode = "void ikiye_katla(int *ptr) {\n    // Kodunu yaz:\n}",
                solutionCode = "void ikiye_katla(int *ptr) {\n    *ptr = (*ptr) * 2;\n}",
                hints = listOf("*ptr = *ptr * 2; yazın."),
                testCases = listOf(
                    TestCase("int x = 5; ikiye_katla(&x); x", "10", "İkiye katlama")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "c_quiz_5_1",
                    lessonId = "c_5",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Pointer tanımlarken kullanılan '*' işareti bir pointer değişkeninin önüne konduğunda (örn: *p = 5) ne anlama gelir?",
                    options = listOf("O adrese git ve tuttuğu veriyi değiştir/oku (Dereferencing)", "İki sayıyı çarp", "Yeni bir dosya aç", "Adresi sil"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! *p adrese doğrudan erişmeyi (Dereferencing) sağlar.",
                    explanationWrong = "Adresteki değere erişmeyi sağlar.",
                    reviewTopic = "C Pointerlar"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Pointer neden bu kadar önemlidir?",
                    answer = "Büyük verileri kopyalamadan tek bir adres üzerinden çok hızlı aktarmanızı ve doğrudan donanım belleğini yönetmenizi sağlar."
                )
            ),
            completionCriteria = listOf(
                "& ve * operatörlerinin mantığını kavramak",
                "Pointer ile fonksiyon üzerinden değer güncelleyebilmek"
            )
        ),

        // ==========================================
        // DERS 6: DİNAMİK BELLEK (malloc ve free)
        // ==========================================
        Lesson(
            id = "c_6",
            courseId = "c",
            sectionId = "c_sec_3",
            title = "Dinamik Bellek Yönetimi: malloc ve free",
            shortDesc = "Çalışma anında işletim sisteminden hafıza kiralama (malloc) ve işi bitince geri verme (free).",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true,
            learningObjectives = listOf(
                "malloc() ile Heap bölgesinden dinamik hafıza istemek",
                "sizeof() operatörünü öğrenmek",
                "free() ile kiraladığımız hafızayı geri vererek bellek sızıntısını (Memory Leak) önlemek"
            ),
            prerequisites = listOf("Pointerlar"),
            subtopics = listOf("malloc()", "sizeof()", "free() ve Bellek Sızıntısı"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. malloc ve free: Hafıza Kiralama",
                    body = "Kullanıcının kaç sayı gireceğini önceden bilmiyorsanız, program çalışırken `malloc()` ile işletim sisteminden bellek istersiniz. İşiniz bitince mutlaka `free()` ile geri vermelisiniz; yoksa bilgisayarın hafızası dolar!",
                    codeSnippet = "#include <stdlib.h>\n\n// 5 adet int büyüklüğünde yer kiralayalım:\nint *dizi = (int*) malloc(5 * sizeof(int));\n\nif (dizi != NULL) {\n    dizi[0] = 100;\n    printf(\"Dinamik Değer: %d\\n\", dizi[0]);\n    \n    // İşi bitince MUTLAKA serbest bırak:\n    free(dizi);\n}"
                )
            ),
            codeExample = "int *sayi = (int*) malloc(sizeof(int));\n*sayi = 42;\nprintf(\"Sayı: %d\\n\", *sayi);\nfree(sayi);",
            codeExplanation = "malloc ile hafıza ayrıldı, kullanıldı ve free ile temizlendi.",
            realWorldExample = "Photoshop gibi dev programlar büyük bir resmi açarken malloc ile dinamik hafıza tahsis eder.",
            practicalTask = "malloc ve free kalıbını inceleyin.",
            starterPlaygroundCode = "int *ptr = (int*) malloc(sizeof(int));\nfree(ptr);",
            miniQuestion = MiniQuestion(
                id = "c_q_6",
                question = "C dilinde malloc ile kiralanan bellek alanını işletim sistemine geri iade etmek için hangi fonksiyon çağrılır?",
                options = listOf("free()", "delete()", "clear()", "release()"),
                correctIndex = 0,
                explanation = "Belleği iade etmek için 'free()' fonksiyonu kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_c_6",
                lessonId = "c_6",
                title = "Dinamik Bellek Ayırıcı",
                instructions = "1 adet int alanı dinamik olarak malloc ile ayıran, içine deger yazan ve bu pointerı döndüren dinamik_int(deger) fonksiyonunu yazın.",
                exampleInput = "dinamik_int(50)",
                exampleOutput = "50",
                starterCode = "#include <stdlib.h>\n\nint* dinamik_int(int deger) {\n    // Kodunu yaz:\n    return NULL;\n}",
                solutionCode = "#include <stdlib.h>\n\nint* dinamik_int(int deger) {\n    int *p = (int*) malloc(sizeof(int));\n    if (p) *p = deger;\n    return p;\n}",
                hints = listOf("int *p = malloc(sizeof(int)); *p = deger; return p; yazın."),
                testCases = listOf(
                    TestCase("*dinamik_int(50)", "50", "Dinamik int testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "c_quiz_6_1",
                    lessonId = "c_6",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "malloc ile ayrılan belleğin iş bittiğinde free() ile serbest bırakılmaması durumunda ortaya çıkan tehlikeli duruma ne ad verilir?",
                    options = listOf("Bellek Sızıntısı (Memory Leak)", "Stack Overflow", "Segmentation Fault", "Null Pointer"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Serbest bırakılmayan bellekler Memory Leak oluşturur.",
                    explanationWrong = "Memory Leak (Bellek Sızıntısı) oluşur.",
                    reviewTopic = "C Bellek Yönetimi"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "malloc başarısız olursa ne döndürür?",
                    answer = "Eğer bilgisayarda yeterli RAM kalmadıysa NULL döndürür; bu yüzden her malloc sonrası 'if (ptr != NULL)' kontrolü yapılır."
                )
            ),
            completionCriteria = listOf(
                "malloc ve free kullanımını bilmek",
                "Bellek sızıntısı kavramını anlamak"
            )
        ),

        // ==========================================
        // DERS 7: YAPILAR (struct)
        // ==========================================
        Lesson(
            id = "c_7",
            courseId = "c",
            sectionId = "c_sec_4",
            title = "Yapılar (struct) ve typedef: Kendi Tiplerini Üret",
            shortDesc = "Farklı türdeki verileri tek bir pakette toplama (struct) ve typedef ile şık isimlendirme.",
            level = CourseLevel.INTERMEDIATE,
            order = 7,
            isPremium = true,
            learningObjectives = listOf(
                "struct tanımlayarak birden fazla alanı tek pakette birleştirmek",
                "typedef ile 'struct Kisi' yerine doğrudan 'Kisi' yazabilmek",
                ". (nokta) ve -> (ok) operatörleri ile alanlara erişmek"
            ),
            prerequisites = listOf("Diziler ve Pointerlar"),
            subtopics = listOf("struct Tanımlama", "typedef Kolaylığı", "-> Ok Operatörü"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. struct: Bilgi Paketi",
                    body = "Bir öğrencinin adı (string), yaşı (int) ve not ortalaması (float) vardır. Bunları tek tek ayrı değişkenlerde tutmak yerine `struct` ile tek bir pakete koyarız.",
                    codeSnippet = "typedef struct {\n    char ad[30];\n    int yas;\n    float not;\n} Ogrenci;\n\nint main() {\n    Ogrenci ogr = {\"Mert\", 20, 3.85};\n    printf(\"%s (Yaş: %d, Not: %.2f)\\n\", ogr.ad, ogr.yas, ogr.not);\n    return 0;\n}"
                )
            ),
            codeExample = "typedef struct { int x; int y; } Nokta;\n\nNokta n = {10, 20};\nprintf(\"Nokta: (%d, %d)\\n\", n.x, n.y);",
            codeExplanation = "Nokta struct'ı oluşturuldu ve koordinatlar yazdırıldı.",
            realWorldExample = "Oyun motorlarında 3D karakterin pozisyonunu tutan Vector3(x, y, z) yapıları struct ile yazılır.",
            practicalTask = "Kitap adında bir struct açıp baslik ve fiyat alanları ekleyin.",
            starterPlaygroundCode = "typedef struct {\n    char baslik[50];\n    float fiyat;\n} Kitap;",
            miniQuestion = MiniQuestion(
                id = "c_q_7",
                question = "Bir struct işaretçisi (pointer) üzerinden struct elemanına erişmek için hangi operatör kullanılır?",
                options = listOf("-> (Ok)", ". (Nokta)", "::", "=>"),
                correctIndex = 0,
                explanation = "Pointer üzerinden struct alanına erişirken '->' operatörü kullanılır (örn: ptr->yas)."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_c_7",
                lessonId = "c_7",
                title = "Dikdörtgen Alanı",
                instructions = "genislik ve yukseklik alanlarına sahip Dikdortgen struct'ını alan ve alanını (g * y) hesaplayan alan_hesapla(d) fonksiyonunu yazın.",
                exampleInput = "Dikdortgen d = {5, 4}",
                exampleOutput = "20",
                starterCode = "typedef struct {\n    int genislik;\n    int yukseklik;\n} Dikdortgen;\n\nint alan_hesapla(Dikdortgen d) {\n    // Kodunu yaz:\n    return 0;\n}",
                solutionCode = "typedef struct {\n    int genislik;\n    int yukseklik;\n} Dikdortgen;\n\nint alan_hesapla(Dikdortgen d) {\n    return d.genislik * d.yukseklik;\n}",
                hints = listOf("return d.genislik * d.yukseklik; yazın."),
                testCases = listOf(
                    TestCase("alan_hesapla((Dikdortgen){5, 4})", "20", "Alan testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "c_quiz_7_1",
                    lessonId = "c_7",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "typedef anahtar kelimesinin C'deki görevi nedir?",
                    options = listOf("Mevcut bir tipe veya struct'a daha kısa ve anlaşılır bir takma ad vermek", "Yeni bir dosya açmak", "Döngü başlatmak", "Değişkeni silmek"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! typedef kodları sadeleştirmek için takma ad oluşturur.",
                    explanationWrong = "Takma ad (alias) oluşturur.",
                    reviewTopic = "C Typedef"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "struct içinde başka bir struct olabilir mi?",
                    answer = "Evet! Örneğin Adres struct'ını Kisi struct'ının içine alan olarak koyabilirsiniz."
                )
            ),
            completionCriteria = listOf(
                "struct ve typedef tanımlayabilmek",
                ". ve -> operatörlerini kullanabilmek"
            )
        ),

        // ==========================================
        // DERS 8: ENUM VE UNİON
        // ==========================================
        Lesson(
            id = "c_8",
            courseId = "c",
            sectionId = "c_sec_4",
            title = "Numaralandırma (enum) ve Birlikler (union)",
            shortDesc = "Sayılar yerine anlamlı isimler kullanma (enum) ve aynı hafıza alanını paylaşan union.",
            level = CourseLevel.INTERMEDIATE,
            order = 8,
            isPremium = true,
            learningObjectives = listOf(
                "enum ile kodun okunabilirliğini artırmak",
                "union ile aynı bellek alanında farklı veri tipleri saklamak"
            ),
            prerequisites = listOf("struct ve Veri Tipleri"),
            subtopics = listOf("enum Kullanımı", "union Nedir?"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. enum: Sayılara İsim Vermek",
                    body = "Kodun içinde `durum = 2` yazmak yerine `durum = BASARILI` yazmak çok daha anlaşılırdır.",
                    codeSnippet = "typedef enum {\n    DUR,    // 0\n    HAZIRLAN, // 1\n    GEC     // 2\n} TrafikIsigi;\n\nTrafikIsigi isik = GEC;\nif (isik == GEC) {\n    printf(\"Yol açık, geçebilirsiniz!\\n\");\n}"
                )
            ),
            codeExample = "typedef enum { KOLAY, ORTA, ZOR } Zorluk;\nZorluk z = ORTA;\nprintf(\"Zorluk Seviyesi: %d\\n\", z); // 1",
            codeExplanation = "enum otomatik olarak 0, 1, 2 değerlerini isimlerle eşleştirdi.",
            realWorldExample = "Oyunlarda karakter durumları (DURUYOR, KOSUYOR, ZIPLIYOR) enum ile yönetilir.",
            practicalTask = "Haftanın günlerini tutan bir enum tanımlayın.",
            starterPlaygroundCode = "typedef enum { PAZARTESI, SALI, CARSAMBA } Gun;",
            miniQuestion = MiniQuestion(
                id = "c_q_8",
                question = "C dilinde özel bir başlangıç değeri verilmezse enum'ın ilk elemanı hangi sayısal değere sahiptir?",
                options = listOf("0", "1", "-1", "Tanımsız"),
                correctIndex = 0,
                explanation = "enum elemanları varsayılan olarak 0'dan başlar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_c_8",
                lessonId = "c_8",
                title = "Hafta Sonu Kontrolü",
                instructions = "enum { HAFTAINI = 0, HAFTASONU = 1 } tanımlayıp gun >= 5 ise HAFTASONU döndüren hafta_sonu_mu(gun) fonksiyonunu yazın.",
                exampleInput = "hafta_sonu_mu(6)",
                exampleOutput = "1 (HAFTASONU)",
                starterCode = "int hafta_sonu_mu(int gun) {\n    // 0: Pzt, 6: Paz\n    // Kodunu yaz:\n    return 0;\n}",
                solutionCode = "int hafta_sonu_mu(int gun) {\n    return (gun >= 5) ? 1 : 0;\n}",
                hints = listOf("gun >= 5 ise 1, değilse 0 döndürün."),
                testCases = listOf(
                    TestCase("hafta_sonu_mu(6)", "1", "Pazar"),
                    TestCase("hafta_sonu_mu(2)", "0", "Çarşamba")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "c_quiz_8_1",
                    lessonId = "c_8",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "union ile struct arasındaki en temel fark nedir?",
                    options = listOf("union içindeki tüm elemanlar AYNI bellek alanını ortaklaşa paylaşır", "union daha yavaştır", "union sadece sayılarla çalışır", "Fark yoktur"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! union en büyük elemanın boyutu kadar yer kaplar ve tüm alanlar o alanı paylaşır.",
                    explanationWrong = "union elemanları aynı bellek alanını paylaşır.",
                    reviewTopic = "C Union"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "union nerelerde kullanılır?",
                    answer = "Mikrodenetleyici ve gömülü sistemlerde RAM tasarrufu yapmak için kullanılır."
                )
            ),
            completionCriteria = listOf(
                "enum tanımlayıp kullanabilmek",
                "union mantığını bilmek"
            )
        ),

        // ==========================================
        // DERS 9: ÖNİŞLEMCİ VE MAKROLAR (#define)
        // ==========================================
        Lesson(
            id = "c_9",
            courseId = "c",
            sectionId = "c_sec_5",
            title = "Önişlemci (Preprocessor): #define ve Makrolar",
            shortDesc = "Kodlar daha derlenmeden önce çalışan #define sabitleri ve akıllı makrolar.",
            level = CourseLevel.ADVANCED,
            order = 9,
            isPremium = true,
            learningObjectives = listOf(
                "#define ile global sabitler tanımlamak",
                "Parametreli pratik makrolar yazmak",
                "#include koruyucuları (Include Guards) öğrenmek"
            ),
            prerequisites = listOf("Fonksiyonlar ve Temel C"),
            subtopics = listOf("#define Sabitleri", "Parametreli Makrolar", "#ifdef ve #ifndef"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. #define: Derleme Öncesi Değiştirme",
                    body = "Önişlemci (# ile başlayan komutlar), kod derlenmeden önce metin bul-değiştir işlemi yapar.",
                    codeSnippet = "#define PI 3.14159\n#define KARE(x) ((x) * (x))\n\nint main() {\n    printf(\"PI: %f\\n\", PI);\n    printf(\"5'in karesi: %d\\n\", KARE(5)); // 25\n    return 0;\n}"
                )
            ),
            codeExample = "#define MAX(a, b) ((a) > (b) ? (a) : (b))\n\nint main() {\n    printf(\"Büyük Olan: %d\\n\", MAX(10, 20)); // 20\n    return 0;\n}",
            codeExplanation = "MAX makrosu iki sayıdan büyüğünü hızlıca seçti.",
            realWorldExample = "Linux çekirdeğinde binlerce donanım sabiti ve hızlı matematik fonksiyonu #define makroları ile yazılmıştır.",
            practicalTask = "Bir sayının iki katını alan IKI_KAT(x) makrosu tanımlayın.",
            starterPlaygroundCode = "#define IKI_KAT(x) ((x) * 2)",
            miniQuestion = MiniQuestion(
                id = "c_q_9",
                question = "C dilinde sabit değerler ve makrolar tanımlamak için kullanılan önişlemci komutu hangisidir?",
                options = listOf("#define", "#const", "#let", "#macro"),
                correctIndex = 0,
                explanation = "Makro tanımlamak için '#define' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_c_9",
                lessonId = "c_9",
                title = "Kare Makrosu",
                instructions = "Parametre olarak gelen x sayısının karesini alan kare_al(x) fonksiyonunu veya makro mantığını yazın.",
                exampleInput = "kare_al(6)",
                exampleOutput = "36",
                starterCode = "int kare_al(int x) {\n    // Kodunu yaz:\n    return 0;\n}",
                solutionCode = "int kare_al(int x) {\n    return x * x;\n}",
                hints = listOf("return x * x; yazın."),
                testCases = listOf(
                    TestCase("kare_al(6)", "36", "6'nın karesi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "c_quiz_9_1",
                    lessonId = "c_9",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir başlık dosyasının (.h) projeye birden fazla kez dahil edilip hata vermesini önlemek için ne kullanılır?",
                    options = listOf("#ifndef / #define Include Guards", "#stop", "#exit", "#prevent"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Include Guards (#ifndef / #define / #endif) kullanılır.",
                    explanationWrong = "Include Guards kullanılır.",
                    reviewTopic = "C Preprocessor"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Makrolarda neden her parametre parantez içine alınır?",
                    answer = "Örn: #define KARE(x) (x*x) yazılırsa KARE(2+3) işlemi 2+3*2+3=11 çıkar. Parantez konulursa ((2+3)*(2+3))=25 doğru sonucunu verir."
                )
            ),
            completionCriteria = listOf(
                "#define kullanımını bilmek",
                "Makroların mantığını anlamak"
            )
        ),

        // ==========================================
        // DERS 10: BİT İŞLEMLERİ
        // ==========================================
        Lesson(
            id = "c_10",
            courseId = "c",
            sectionId = "c_sec_5",
            title = "Bit İşlemleri: Bilgisayarın Ana Dili (0 ve 1'ler)",
            shortDesc = "Donanım lambalarını açıp kapatma, bit kaydırma (<<, >>) ve ultra hızlı mantık kapıları (&, |).",
            level = CourseLevel.ADVANCED,
            order = 10,
            isPremium = true,
            learningObjectives = listOf(
                "VE (&), VEYA (|), XOR (^) ve DEĞİL (~) kapılarını öğrenmek",
                "Bit kaydırma (<< ve >>) ile 2 ile çarpma ve bölme yapabilmek"
            ),
            prerequisites = listOf("Pointerlar ve Sayı Sistemleri"),
            subtopics = listOf("Bit Operatörleri (&, |)", "Bit Kaydırma (<<, >>)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Bit Düzeyinde Güç",
                    body = "C dilinde doğrudan 0 ve 1 bitleriyle oynayabilirsiniz. `1 << 3` işlemi 1 sayısını 3 basamak sola kaydırarak 8 yapar (2^3).",
                    codeSnippet = "unsigned char a = 5; // 00000101\nunsigned char b = 3; // 00000011\n\nprintf(\"a & b: %d\\n\", a & b); // 1 (00000001)\nprintf(\"a | b: %d\\n\", a | b); // 7 (00000111)\nprintf(\"a << 1: %d\\n\", a << 1); // 10 (2 ile çarptı)"
                )
            ),
            codeExample = "int sayi = 4;\nprintf(\"İki katı: %d\\n\", sayi << 1); // 8",
            codeExplanation = "Sola 1 bit kaydırma işlemi sayıyı 2 ile çarpar.",
            realWorldExample = "Oyun grafik kartlarında (GPU) ve ağ kartlarında paket baytları bit işlemleriyle ayrıştırılır.",
            practicalTask = "Bir sayının tek mi çift mi olduğunu (sayi & 1) ile kontrol eden kodu inceleyin.",
            starterPlaygroundCode = "int tek_mi(int s) { return s & 1; }",
            miniQuestion = MiniQuestion(
                id = "c_q_10",
                question = "C dilinde bir tam sayıyı 1 bit sola kaydırmak (sayi << 1) sayıyı neyle çarpmaya eşdeğerdir?",
                options = listOf("2", "4", "10", "1"),
                correctIndex = 0,
                explanation = "1 bit sola kaydırma sayıyı 2 ile çarpar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_c_10",
                lessonId = "c_10",
                title = "Bit İle Çift Sayı Kontrolü",
                instructions = "Bit operatörü (& 1) kullanarak sayı çift ise 1, tek ise 0 döndüren cift_mi(sayi) fonksiyonunu yazın.",
                exampleInput = "cift_mi(4)",
                exampleOutput = "1",
                starterCode = "int cift_mi(int sayi) {\n    // Kodunu yaz:\n    return 0;\n}",
                solutionCode = "int cift_mi(int sayi) {\n    return (sayi & 1) == 0 ? 1 : 0;\n}",
                hints = listOf("return (sayi & 1) == 0 ? 1 : 0; yazın."),
                testCases = listOf(
                    TestCase("cift_mi(4)", "1", "Çift sayı"),
                    TestCase("cift_mi(5)", "0", "Tek sayı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "c_quiz_10_1",
                    lessonId = "c_10",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "C dilinde Bitwise VEYA (OR) işlemi için hangi simge kullanılır?",
                    options = listOf("| (Tek Düz Çizgi)", "||", "&", "&&"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Bitwise OR için tek dikey çizgi '|' kullanılır.",
                    explanationWrong = "| kullanılır.",
                    reviewTopic = "C Bit İşlemleri"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Neden çarpma yerine << kaydırma kullanılır?",
                    answer = "Eski veya küçük mikrodenetleyicilerde bit kaydırma donanımsal çarpma devresinden kat kat daha hızlı çalışır."
                )
            ),
            completionCriteria = listOf(
                "&, | ve << operatörlerini bilmek",
                "Bit düzeyinde mantığı anlamak"
            )
        ),

        // ==========================================
        // DERS 11: DOSYA İŞLEMLERİ (fopen)
        // ==========================================
        Lesson(
            id = "c_11",
            courseId = "c",
            sectionId = "c_sec_5",
            title = "Dosya İşlemleri: fopen ve fclose",
            shortDesc = "Bilgisayardaki metin veya ikili (binary) dosyaları açma, okuma ve kaydetme.",
            level = CourseLevel.ADVANCED,
            order = 11,
            isPremium = true,
            learningObjectives = listOf(
                "fopen() ile dosya açmak ('w' yazma, 'r' okuma)",
                "fprintf() ve fscanf() ile dosyaya veri yazıp okumak",
                "fclose() ile dosyayı güvenle kapatmak"
            ),
            prerequisites = listOf("Pointerlar ve struct"),
            subtopics = listOf("fopen() ve Modlar", "fprintf ve fscanf", "fclose()"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Dosyaya Yazmak ve Okumak",
                    body = "Program kapandığında verilerin kaybolmaması için diske dosya olarak yazarız.",
                    codeSnippet = "FILE *dosya = fopen(\"notlar.txt\", \"w\");\nif (dosya != NULL) {\n    fprintf(dosya, \"C Programlama Başarı Notu: 100\\n\");\n    fclose(dosya); // Dosyayı kapat\n}"
                )
            ),
            codeExample = "FILE *f = fopen(\"test.txt\", \"r\");\nif (f) {\n    printf(\"Dosya başarıyla açıldı.\\n\");\n    fclose(f);\n}",
            codeExplanation = "fopen ile dosya okuma modunda ('r') açıldı ve kontrol edildi.",
            realWorldExample = "Oyun kayıt dosyaları (Save files) ve veritabanı motorları disk işlemlerini bu yöntemle yapar.",
            practicalTask = "fopen ve fclose kullanımını inceleyin.",
            starterPlaygroundCode = "FILE *f = fopen(\"a.txt\", \"w\");\nfclose(f);",
            miniQuestion = MiniQuestion(
                id = "c_q_11",
                question = "C dilinde bir dosyayı 'yazma' (write) modunda açmak için fopen içine hangi mod harfi verilir?",
                options = listOf("\"w\"", "\"r\"", "\"a\"", "\"x\""),
                correctIndex = 0,
                explanation = "Yazma modu için \"w\" (write) kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_c_11",
                lessonId = "c_11",
                title = "Dosya Kontrolü",
                instructions = "Dosya pointer'ı NULL ise 0, geçerli ise 1 döndüren dosya_gecerli_mi(FILE *f) fonksiyonunu yazın.",
                exampleInput = "dosya_gecerli_mi(NULL)",
                exampleOutput = "0",
                starterCode = "#include <stdio.h>\n\nint dosya_gecerli_mi(FILE *f) {\n    // Kodunu yaz:\n    return 0;\n}",
                solutionCode = "#include <stdio.h>\n\nint dosya_gecerli_mi(FILE *f) {\n    return f != NULL ? 1 : 0;\n}",
                hints = listOf("return f != NULL ? 1 : 0; yazın."),
                testCases = listOf(
                    TestCase("dosya_gecerli_mi(NULL)", "0", "Geçersiz dosya")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "c_quiz_11_1",
                    lessonId = "c_11",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Açılan bir dosyanın mutlaka fclose() ile kapatılması neden zorunludur?",
                    options = listOf("Yazılan verilerin disk tamponundan (buffer) fiziksel diske kaydedilmesini ve dosya kilidinin serbest bırakılmasını sağlamak için", "Bilgisayarı kapatmak için", "Hata vermek için", "Gerekli değildir"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Veri kaybını ve kilitlenmeyi önlemek için dosya daima kapatılmalıdır.",
                    explanationWrong = "Veri kaybını önlemek için fclose zorunludur.",
                    reviewTopic = "C Dosya İşlemleri"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "\"a\" modu ne işe yarar?",
                    answer = "\"a\" (Append/Ekleme) modu dosyanın içindekileri silmez, yeni yazıları dosyanın sonuna ekler."
                )
            ),
            completionCriteria = listOf(
                "fopen, fprintf ve fclose kullanımını bilmek",
                "Dosya modlarını kavramak"
            )
        ),

        // ==========================================
        // DERS 12: C USTALIĞI VE GELECEK
        // ==========================================
        Lesson(
            id = "c_12",
            courseId = "c",
            sectionId = "c_sec_6",
            title = "C Ustalığı: Temiz Kod ve Sistem Dünyası",
            shortDesc = "C öğrenen bir yazılımcının kazandığı süper güçler ve diğer dillere geçiş kolaylığı.",
            level = CourseLevel.EXPERT,
            order = 12,
            isPremium = true,
            learningObjectives = listOf(
                "Bellek ve işlemci mimarisine tam hakim olmak",
                "C'nin diğer dilleri (C++, Python, Rust, Go) nasıl beslediğini kavramak",
                "Tebrikler: Artık donanımı ve yazılımı en derinden anlayan bir C geliştiricisisiniz!"
            ),
            prerequisites = listOf("Tüm C Konuları"),
            subtopics = listOf("C'nin Gücü", "Hata Ayıklama (GDB / Valgrind)", "Tebrikler ve Tavsiyeler"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Tebrikler! C Dilini Tamamladınız! 🏆⚡",
                    body = "C dilini öğrenen biri için dünyada öğrenilemeyecek hiçbir programlama dili yoktur. Çünkü siz bilgisayarın nasıl düşündüğünü, RAM'in nasıl çalıştığını ve kodun makine diline nasıl dönüştüğünü en saf haliyle kavradınız.\n\nArtık C++, Rust, Go veya Python'da yazarken arkada dönen tüm bellek hareketlerini bir röntgen gibi görebilirsiniz!"
                )
            ),
            codeExample = "// C Ustası oldunuz!\n#include <stdio.h>\nint main() {\n    printf(\"Tebrikler C Geliştiricisi!\\n\");\n    return 0;\n}",
            codeExplanation = "C yolculuğunuz başarıyla tamamlandı.",
            realWorldExample = "Linux çekirdeğinin %95'i C ile yazılmıştır.",
            practicalTask = "C bilgilerinizle gurur duyun!",
            starterPlaygroundCode = "// C Yolculuğu Tamamlandı!",
            miniQuestion = MiniQuestion(
                id = "c_q_12",
                question = "C dilini öğrenmek bir yazılımcıya en çok hangi alanda derin bir vizyon katar?",
                options = listOf("Bilgisayar donanımı, bellek mimarisi ve işletim sistemi mantığını en derinden anlamak", "Sadece web sitesi tasarlamak", "CSS renkleri seçmek", "Yazı yazmak"),
                correctIndex = 0,
                explanation = "C dili bilgisayar mimarisi ve bellek yönetimini en iyi öğreten dildir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_c_12",
                lessonId = "c_12",
                title = "Faktöriyel",
                instructions = "n sayısının faktöriyelini hesaplayan faktoriyel(n) fonksiyonunu yazın.",
                exampleInput = "faktoriyel(5)",
                exampleOutput = "120",
                starterCode = "int faktoriyel(int n) {\n    // Kodunu yaz:\n    return 1;\n}",
                solutionCode = "int faktoriyel(int n) {\n    int f = 1;\n    for (int i = 2; i <= n; i++) f *= i;\n    return f;\n}",
                hints = listOf("for döngüsüyle f *= i yapın."),
                testCases = listOf(
                    TestCase("faktoriyel(5)", "120", "5!"),
                    TestCase("faktoriyel(4)", "24", "4!")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "c_quiz_12_1",
                    lessonId = "c_12",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "C programlarında bellek sızıntılarını (Memory Leaks) tespit etmek için en popüler Linux aracı hangisidir?",
                    options = listOf("Valgrind", "Photoshop", "Chrome", "Excel"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Valgrind bellek hatalarını ve sızıntıları tespit eder.",
                    explanationWrong = "Valgrind kullanılır.",
                    reviewTopic = "C Hata Ayıklama"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Bundan sonra hangi dili öğrenmeliyim?",
                    answer = "Nesne yönelimli ve modern sistem programlama için C++ veya Rust harika bir sonraki adımdır."
                )
            ),
            completionCriteria = listOf(
                "C dili felsefesini kavramak",
                "Temiz ve hatasız C kodları üretebilmek"
            )
        )
    )
}
