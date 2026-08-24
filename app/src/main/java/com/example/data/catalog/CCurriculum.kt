package com.example.data.catalog

import com.example.model.*

/**
 * C Dili Kapsamlı Resmi Müfredatı (12 Sıralı Ders):
 * BEGINNER -> FUNDAMENTAL -> INTERMEDIATE -> ADVANCED -> EXPERT
 * Temel I/O ve döngülerden pointerlar, dinamik bellek, POSIX thread'ler ve kernel seviyesi özel bellek tahsisçilerine kadar.
 */
object CCurriculum {

    fun getSections(): List<CourseSection> = listOf(
        CourseSection(
            id = "c_sec_1",
            courseId = "c",
            title = "Seviye 1 – C Temelleri, Sözdizimi & Kontrol Akışı",
            level = CourseLevel.BEGINNER,
            order = 1,
            description = "C yapısı, main(), printf, scanf, temel veri tipleri (int, float, char, double), if-else ve for/while döngüleri.",
            learningObjectives = listOf("C derleme süreci (GCC/Clang)", "printf ve scanf ile I/O işlemleri", "if-else ve switch-case karar blokları", "for ve while döngüleri"),
            prerequisites = listOf("Temel bilgisayar bilgisi")
        ),
        CourseSection(
            id = "c_sec_2",
            courseId = "c",
            title = "Seviye 2 – Fonksiyonlar, Diziler & Stringler",
            level = CourseLevel.BEGINNER,
            order = 2,
            description = "Modüler fonksiyonlar, header (.h) dosyaları, tek/çok boyutlu diziler ve null-terminated ('\\0') C karakter dizileri.",
            learningObjectives = listOf("Fonksiyon prototipi ve tanımı", "Diziler ve bellek düzeni", "C Stringleri ve string.h kütüphanesi", "Stack bellekte değişken yaşam süresi"),
            prerequisites = listOf("C Temelleri ve Kontrol Akışı")
        ),
        CourseSection(
            id = "c_sec_3",
            courseId = "c",
            title = "Seviye 3 – Pointerlar (İşaretçiler) & Dinamik Bellek",
            level = CourseLevel.INTERMEDIATE,
            order = 3,
            description = "Bellek adresleri (&), Pointer dereferencing (*), Pointer aritmetiği, Heap bellek yönetimi (malloc, calloc, realloc, free).",
            learningObjectives = listOf("Pointer ve bellek adresi kavramı", "Pointer aritmetiği ve dizi ilişkisi", "malloc/free ile Heap bellek yönetimi", "Bellek sızıntılarını (Memory Leaks) önleme"),
            prerequisites = listOf("C Fonksiyonlar ve Diziler")
        ),
        CourseSection(
            id = "c_sec_4",
            courseId = "c",
            title = "Seviye 4 – Struct, Union, Enum & Fonksiyon Göstericileri",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            description = "struct, union, enum, typedef ile veri soyutlama, bellek hizalama (Memory Alignment/Padding) ve Callback fonksiyon göstericileri.",
            learningObjectives = listOf("struct ve typedef ile veri modelleri", "union ve enum ile bellek tasarrufu", "struct bellek hizalama (padding/packing)", "Function Pointers ve Callback mimarisi"),
            prerequisites = listOf("Pointerlar ve Dinamik Bellek")
        ),
        CourseSection(
            id = "c_sec_5",
            courseId = "c",
            title = "Seviye 5 – Önişlemci (Preprocessor), Bit İşlemleri & Dosya I/O",
            level = CourseLevel.ADVANCED,
            order = 5,
            description = "Makrolar (#define, #ifdef), Include Guards, Bit Manipülasyonu (&, |, ^, ~, <<, >>) ve Dosya Giriş/Çıkış (fopen, fread, fwrite).",
            learningObjectives = listOf("C Preprocessor ve parametreli makrolar", "Bitwise operatörler ve Bitmask filtreleme", "Binary ve Text dosya I/O işlemleri", "Hata yönetimi (errno, perror)"),
            prerequisites = listOf("Struct ve Fonksiyon Göstericileri")
        ),
        CourseSection(
            id = "c_sec_6",
            courseId = "c",
            title = "Seviye 6 – POSIX Threads, Eşzamanlılık & Sistem Mimarisi",
            level = CourseLevel.EXPERT,
            order = 6,
            description = "pthread kütüphanesi, mutex, semaforlar, Race Condition önleme ve sıfırdan Custom Arena/Pool Memory Allocator mimarisi.",
            learningObjectives = listOf("pthread_create ve pthread_join ile multithreading", "pthread_mutex_t ile yarış durumlarını engelleme", "Raw bellek manipülasyonu", "Özel Arena Memory Allocator tasarımı"),
            prerequisites = listOf("İleri C Bellek ve Dosya Yönetimi")
        )
    )

    fun getLessons(): List<Lesson> = listOf(
        // ==========================================
        // DERS 1: TEMEL SÖZDİZİMİ & I/O (ÜCRETSİZ)
        // ==========================================
        Lesson(
            id = "c_1",
            courseId = "c",
            sectionId = "c_sec_1",
            title = "C'ye Giriş, main(), printf & scanf",
            shortDesc = "C derleme süreci, main() fonksiyonu, stdio.h kütüphanesi, printf biçimlendiricileri (%d, %f, %c, %s) ve scanf ile girdi alma.",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false,
            learningObjectives = listOf(
                "C derleme sürecini (Önişleme -> Derleme -> Montaj -> Bağlama) kavramak",
                "printf ve format belirteçleri ile konsola biçimli çıktı vermek",
                "scanf ile kullanıcıdan girdi alırken & (adres) operatörünü doğru kullanmak"
            ),
            prerequisites = listOf("Ön koşul gerekmez. Sıfırdan başlar."),
            subtopics = listOf("main() Fonksiyonu", "#include <stdio.h>", "Format Belirteçleri", "Değişkenler ve Tipler", "scanf ile Girdi"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. C Program Yapısı ve stdio.h",
                    body = "C dilinde programın giriş noktası `int main()` fonksiyonudur. Ekrana metin yazdırmak için `<stdio.h>` başlık dosyasında tanımlı `printf()` fonksiyonu kullanılır.",
                    codeSnippet = "#include <stdio.h>\n\nint main(void) {\n    printf(\"Merhaba C Dili!\\n\");\n    return 0;\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Format Belirteçleri ve scanf",
                    body = "• %d: İşaretli tamsayı (int)\n• %f: Ondalıklı sayı (float)\n• %lf: Çift duyarlıklı ondalıklı sayı (double)\n• %c: Tek karakter (char)\n• %s: Karakter dizisi (string)\n\nscanf ile değer okurken değişkenin bellek adresini bildirmek için başına '&' işareti konur.",
                    tip = "scanf(\"%d\", &yas); şeklinde '&' adres işaretini unutmak tanımsız davranışa (Segmentation fault) yol açar."
                )
            ),
            codeExample = "#include <stdio.h>\n\nint main(void) {\n    int yas = 24;\n    float puan = 95.5f;\n    char notHarfi = 'A';\n    \n    printf(\"Yas: %d, Puan: %.1f, Not: %c\\n\", yas, puan, notHarfi);\n    return 0;\n}",
            codeExplanation = "printf fonksiyonundaki format belirteçleri sırasıyla verilen değişken değerleriyle eşleşerek ekrana yazdırılır.",
            realWorldExample = "Linux çekirdeği, Git versiyon kontrol sistemi ve mikrodenetleyici cihazlar en yüksek hız ve donanım kontrolü için C ile yazılmıştır.",
            practicalTask = "Kullanıcıdan iki tamsayı alıp bu sayıların toplamını printf ile yazdıran bir C programı yazın.",
            starterPlaygroundCode = "#include <stdio.h>\n\nint main(void) {\n    int a = 12, b = 28;\n    printf(\"Toplam: %d\\n\", a + b);\n    return 0;\n}",
            miniQuestion = MiniQuestion(
                id = "c_q_1",
                question = "C dilinde printf ile bir tamsayıyı (int) ekrana yazdırmak için hangi format belirteci kullanılır?",
                options = listOf("%d", "%f", "%c", "%s"),
                correctIndex = 0,
                explanation = "%d (decimal) tamsayıları yazdırmak için kullanılan standart format belirtecidir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_c_1",
                lessonId = "c_1",
                title = "İki Tamsayıyı Toplama",
                instructions = "Verilen iki int parametresini toplayıp döndüren topla(int a, int b) fonksiyonunu yazın.",
                exampleInput = "a = 15, b = 35",
                exampleOutput = "50",
                starterCode = "int topla(int a, int b) {\n    // Kodunu buraya yaz:\n    return 0;\n}",
                solutionCode = "int topla(int a, int b) {\n    return a + b;\n}",
                hints = listOf("return a + b; yazarak sonucu döndürün."),
                testCases = listOf(
                    TestCase("topla(15, 35)", "50", "Temel toplama")
                )
            )
        ),

        // ==========================================
        // DERS 2: KONTROL AKIŞI (ÜCRETSİZ)
        // ==========================================
        Lesson(
            id = "c_2",
            courseId = "c",
            sectionId = "c_sec_1",
            title = "Kontrol Akışı: if-else, switch & Döngüler",
            shortDesc = "Koşullu ifadeler (if, else if, else), switch-case seçicileri, for döngüsü, while/do-while ve döngü denetleyicileri (break, continue).",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false,
            learningObjectives = listOf(
                "if, else if ve switch-case yapılarıyla karar mekanizmaları kurmak",
                "for, while ve do-while döngüleriyle tekrarlayan mantıkları kodlamak",
                "break ve continue ifadeleriyle döngü akışını yönetmek"
            ),
            prerequisites = listOf("C'ye Giriş & Temel Tipler"),
            subtopics = listOf("if-else Karar Yapıları", "switch-case ve break", "for Döngüsü", "while ve do-while", "Mantıksal Operatörler (&&, ||, !)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. C'de Boolean Mantığı",
                    body = "Geleneksel C'de (C99 öncesi) ayrı bir bool tipi yoktur; 0 değeri YANLIŞ (false), sıfır dışındaki tüm değerler DOĞRU (true) kabul edilir. Modern C'de `<stdbool.h>` ile `bool`, `true`, `false` kullanılabilir.",
                    codeSnippet = "#include <stdio.h>\n#include <stdbool.h>\n\nint main(void) {\n    int not = 85;\n    if (not >= 90) {\n        printf(\"AA\\n\");\n    } else if (not >= 80) {\n        printf(\"BA\\n\");\n    } else {\n        printf(\"Gecer\\n\");\n    }\n    return 0;\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. for ve while Döngüleri",
                    body = "for döngüsü: `for (başlangıç; koşul; artış)` yapısına sahiptir.\nwhile döngüsü koşul doğru olduğu sürece çalışır.",
                    tip = "switch-case bloklarında her case sonuna `break;` koymayı unutmayın, aksi halde 'fall-through' (aşağıya akma) gerçekleşir."
                )
            ),
            codeExample = "#include <stdio.h>\n\nint main(void) {\n    for (int i = 1; i <= 5; i++) {\n        printf(\"Adim: %d\\n\", i);\n    }\n    return 0;\n}",
            codeExplanation = "i değişkeni 1'den başlar, 5'e kadar her adımda 1 artarak döngü gövdesini çalıştırır.",
            realWorldExample = "Otomotiv ECU yazılımlarında ve mikrokontrolörlerde sensör okumaları sonsuz `while(1)` döngüleri içinde kontrol edilir.",
            practicalTask = "1'den 100'e kadar olan sayılardan sadece çift olanları toplayıp ekrana yazdıran bir C kodu yazın.",
            starterPlaygroundCode = "#include <stdio.h>\n\nint main(void) {\n    int toplam = 0;\n    for (int i = 2; i <= 10; i += 2) {\n        toplam += i;\n    }\n    printf(\"Cift Toplam (1-10): %d\\n\", toplam);\n    return 0;\n}",
            miniQuestion = MiniQuestion(
                id = "c_q_2",
                question = "C dilinde switch bloğunda bir case'in çalışması bittikten sonra diğer case'lere geçişi durdurmak için ne kullanılır?",
                options = listOf("break", "stop", "exit", "return"),
                correctIndex = 0,
                explanation = "break komutu switch bloğundan anında çıkılmasını sağlar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_c_2",
                lessonId = "c_2",
                title = "Faktöriyel Hesaplayıcı",
                instructions = "Pozitif bir n tamsayısının faktöriyelini (n!) hesaplayan faktoriyel(n) fonksiyonunu yazın. (0! = 1)",
                exampleInput = "n = 5",
                exampleOutput = "120",
                starterCode = "long long faktoriyel(int n) {\n    // Kodunu buraya yaz:\n    return 1;\n}",
                solutionCode = "long long faktoriyel(int n) {\n    long long sonuc = 1;\n    for (int i = 1; i <= n; i++) {\n        sonuc *= i;\n    }\n    return sonuc;\n}",
                hints = listOf("1'den n'e kadar döngü kurup çarparak biriktirin."),
                testCases = listOf(
                    TestCase("faktoriyel(5)", "120", "5 faktöriyel")
                )
            )
        ),

        // ==========================================
        // DERS 3: FONKSİYONLAR & MODÜLERLİK (ÜCRETSİZ)
        // ==========================================
        Lesson(
            id = "c_3",
            courseId = "c",
            sectionId = "c_sec_2",
            title = "Fonksiyonlar, Header Dosyaları & Kapsam (Scope)",
            shortDesc = "Fonksiyon tanımlama, prototipler, değerle aktarım (Pass by Value), static ve extern değişkenler, .h ve .c dosya modülerliği.",
            level = CourseLevel.BEGINNER,
            order = 3,
            isPremium = false,
            learningObjectives = listOf(
                "Fonksiyon prototipleri yazarak derleyiciye fonksiyon imzasını önceden bildirmek",
                "C'de varsayılan Pass by Value (Değerle Aktarım) mekanizmasını anlamak",
                "static ve extern anahtar kelimeleriyle değişken kapsamını yönetmek"
            ),
            prerequisites = listOf("Kontrol Akışı ve Döngüler"),
            subtopics = listOf("Fonksiyon Prototipleri", "Değerle Parametre Aktarımı", "Header Dosyaları (.h)", "static & extern Belirteçleri", "Stack Çerçevesi (Stack Frame)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Fonksiyon Prototipi ve Tanımı",
                    body = "C derleyicisi kaynak kodları yukarıdan aşağıya tek geçişte okur. Eğer `main()` içinde çağrılan bir fonksiyon `main()` sonrasında tanımlanmışsa, en üste fonksiyon prototipi eklenmelidir.",
                    codeSnippet = "#include <stdio.h>\n\n// Fonksiyon Prototipi\nint kareAl(int sayi);\n\nint main(void) {\n    printf(\"Sonuc: %d\\n\", kareAl(6));\n    return 0;\n}\n\n// Fonksiyon Tanımı\nint kareAl(int sayi) {\n    return sayi * sayi;\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. static Değişkenler",
                    body = "Bir fonksiyon içindeki `static` değişken fonksiyon sonlansa bile bellekteki değerini korur. Dosya seviyesindeki `static` fonksiyon ise yalnızca o .c dosyası içinde görünür (private) kalır.",
                    tip = "Header (.h) dosyalarında fonksiyon bildirimleri, .c dosyalarında ise gerçek gövde tanımları yer alır."
                )
            ),
            codeExample = "#include <stdio.h>\n\nvoid sayacArttir(void) {\n    static int sayac = 0;\n    sayac++;\n    printf(\"Sayac Degeri: %d\\n\", sayac);\n}\n\nint main(void) {\n    sayacArttir();\n    sayacArttir();\n    sayacArttir();\n    return 0;\n}",
            codeExplanation = "static int sayac çağrılar arasında sıfırlanmaz ve 1, 2, 3 olarak artmaya devam eder.",
            realWorldExample = "Büyük C projelerinde (örn. SQLite) kod tabanı yüzlerce modüle bölünür ve header dosyaları ile birleştirilir.",
            practicalTask = "İki sayının en büyük ortak bölenini (EBOB) hesaplayan bir fonksiyon yazın.",
            starterPlaygroundCode = "#include <stdio.h>\n\nint ebob(int a, int b) {\n    while (b != 0) {\n        int gecici = b;\n        b = a % b;\n        a = gecici;\n    }\n    return a;\n}\n\nint main(void) {\n    printf(\"EBOB(48, 18) = %d\\n\", ebob(48, 18));\n    return 0;\n}",
            miniQuestion = MiniQuestion(
                id = "c_q_3",
                question = "C dilinde bir fonksiyon içindeki lokal değişkenin fonksiyon bittikten sonra da değerini koruması için başına hangi anahtar kelime getirilir?",
                options = listOf("static", "const", "extern", "register"),
                correctIndex = 0,
                explanation = "static lokal değişkenler programın tüm yaşam döngüsü boyunca bellekte saklanır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_c_3",
                lessonId = "c_3",
                title = "Asallık Kontrolü",
                instructions = "Verilen bir tamsayının asal sayı olup olmadığını kontrol eden asalMi(int n) fonksiyonunu yazın. Asal ise 1, değilse 0 dönmelidir.",
                exampleInput = "n = 13",
                exampleOutput = "1",
                starterCode = "int asalMi(int n) {\n    // Kodunu buraya yaz:\n    return 0;\n}",
                solutionCode = "int asalMi(int n) {\n    if (n <= 1) return 0;\n    for (int i = 2; i * i <= n; i++) {\n        if (n % i == 0) return 0;\n    }\n    return 1;\n}",
                hints = listOf("2'den başlayarak kareköküne kadar bölünüp bölünmediğini test edin."),
                testCases = listOf(
                    TestCase("asalMi(13)", "1", "Asal sayı testi")
                )
            )
        ),

        // ==========================================
        // DERS 4: DİZİLER & C STRİNGLERİ (PRO)
        // ==========================================
        Lesson(
            id = "c_4",
            courseId = "c",
            sectionId = "c_sec_2",
            title = "Diziler (Arrays) & C Stringleri (char[])",
            shortDesc = "Sabit boyutlu diziler, çok boyutlu matrisler, C string karakter dizileri, Null sonlandırıcı ('\\0') ve string.h kütüphanesi (strlen, strcpy, strcmp, strcat).",
            level = CourseLevel.BEGINNER,
            order = 4,
            isPremium = true,
            learningObjectives = listOf(
                "C dizilerinin bellekteki bitişik (contiguous) yapısını kavramak",
                "C stringlerinin sonundaki '\\0' (null terminator) mantığını öğrenmek",
                "string.h fonksiyonlarını (strlen, strcpy, strcmp, strcat) güvenli kullanmak"
            ),
            prerequisites = listOf("Fonksiyonlar ve Kapsam"),
            subtopics = listOf("Tek Boyutlu Diziler", "Matrisler (2D Arrays)", "char[] ve '\\0' Null Terminator", "string.h Fonksiyonları", "Dizi Sınır Güvenliği"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. C Stringleri ve Null Karakteri",
                    body = "C dilinde yerleşik bir string tipi yoktur. Stringler, sonu `\\0` (ASCII 0) karakteri ile biten `char` dizileridir. 5 harfli bir kelime için en az 6 byte'lık dizi gereklidir.",
                    codeSnippet = "#include <stdio.h>\n#include <string.h>\n\nint main(void) {\n    char isim[] = \"KodAkademi\";\n    printf(\"Metin: %s, Uzunluk: %zu\\n\", isim, strlen(isim));\n    return 0;\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Güvenlik Uyarısı: Buffer Overflow",
                    body = "C dizilerinde sınır kontrolü yapılmaz. Tanımlanan boyuttan fazla veri yazmak bellek taşmasına (Buffer Overflow) yol açar.",
                    tip = "strcpy yerine her zaman güvenli olan strncpy veya snprintf tercih edilmelidir."
                )
            ),
            codeExample = "#include <stdio.h>\n#include <string.h>\n\nint main(void) {\n    char kaynak[] = \"Sistem Programlama\";\n    char hedef[50];\n    strcpy(hedef, kaynak);\n    printf(\"Kopyalanan: %s\\n\", hedef);\n    return 0;\n}",
            codeExplanation = "strcpy fonksiyonu kaynak stringi hedef diziye sonlandırıcı '\\0' dahil kopyalar.",
            realWorldExample = "Ağ paket başlıkları ve dosya sistemi blokları C dizileriyle byte byte işlenir.",
            practicalTask = "Bir dizideki en büyük ve en küçük elemanı bulan bir C programı yazın.",
            starterPlaygroundCode = "#include <stdio.h>\n\nint main(void) {\n    int sayilar[] = {14, 55, 3, 99, 42};\n    int n = 5;\n    int max = sayilar[0];\n    for (int i = 1; i < n; i++) {\n        if (sayilar[i] > max) max = sayilar[i];\n    }\n    printf(\"En Buyuk: %d\\n\", max);\n    return 0;\n}",
            miniQuestion = MiniQuestion(
                id = "c_q_4",
                question = "C dilinde 7 karakterlik \"Merhaba\" metnini saklayabilmek için char dizisi boyutu en az kaç olmalıdır?",
                options = listOf("8", "7", "6", "9"),
                correctIndex = 0,
                explanation = "7 karakter + 1 sonlandırıcı '\\0' karakteri için toplam 8 byte alan gerekir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_c_4",
                lessonId = "c_4",
                title = "Dizi Elemanları Toplamı",
                instructions = "Verilen n elemanlı bir int dizisinin elemanları toplamını hesaplayan diziToplami(int dizi[], int n) fonksiyonunu yazın.",
                exampleInput = "dizi = {1, 2, 3, 4, 5}, n = 5",
                exampleOutput = "15",
                starterCode = "int diziToplami(int dizi[], int n) {\n    // Kodunu buraya yaz:\n    return 0;\n}",
                solutionCode = "int diziToplami(int dizi[], int n) {\n    int toplam = 0;\n    for (int i = 0; i < n; i++) {\n        toplam += dizi[i];\n    }\n    return toplam;\n}",
                hints = listOf("0'dan n-1'e kadar dönen bir döngüde toplam değişkenine ekleyin."),
                testCases = listOf(
                    TestCase("diziToplami(test, 5)", "15", "Dizi toplamı testi")
                )
            )
        ),

        // ==========================================
        // DERS 5: POINTERLAR (İŞARETÇİLER) (PRO)
        // ==========================================
        Lesson(
            id = "c_5",
            courseId = "c",
            sectionId = "c_sec_3",
            title = "Pointerlar (İşaretçiler) & Bellek Adresleri",
            shortDesc = "Pointer temelleri, Adres operatörü (&), Dereference operatörü (*), Pointer aritmetiği, void* ve Pass by Reference simülasyonu.",
            level = CourseLevel.INTERMEDIATE,
            order = 5,
            isPremium = true,
            learningObjectives = listOf(
                "Bellek adreslerini (&) ve işaretçi (pointer) değişkenleri kavramak",
                "Pointer dereferencing (*) ile adresteki değeri okumak ve değiştirmek",
                "Pointer aritmetiği (ptr + 1) ile bellek adımlaması yapmak"
            ),
            prerequisites = listOf("Diziler ve C Stringleri"),
            subtopics = listOf("Bellek Adresleri (&)", "Pointer Tanımlama (*)", "Dereferencing", "Pass by Pointer (Swap)", "Pointer Aritmetiği"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Pointer Nedir?",
                    body = "Pointer, başka bir değişkenin bellekteki adresini tutan özel bir değişkendir. `int* ptr = &sayi;` ifadesinde `ptr` değişkeni `sayi`'nın bellek adresini tutar.",
                    codeSnippet = "#include <stdio.h>\n\nint main(void) {\n    int x = 42;\n    int* ptr = &x;\n    \n    printf(\"x'in Degeri: %d\\n\", x);\n    printf(\"x'in Adresi: %p\\n\", (void*)ptr);\n    printf(\"ptr ile x'e erisim: %d\\n\", *ptr);\n    \n    *ptr = 100;\n    printf(\"Yeni x: %d\\n\", x);\n    return 0;\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Pass by Pointer ile Swap",
                    body = "C dilinde referansla aktarım yoktur; fonksiyonların çağıran tarafın değişkenini değiştirebilmesi için pointer parametreleri kullanılır.",
                    tip = "Asla başlatılmamış (wild pointer) veya NULL olan bir pointer'ı dereference (*ptr) etmeyin."
                )
            ),
            codeExample = "#include <stdio.h>\n\nvoid swap(int* a, int* b) {\n    int gecici = *a;\n    *a = *b;\n    *b = gecici;\n}\n\nint main(void) {\n    int x = 10, y = 20;\n    swap(&x, &y);\n    printf(\"x: %d, y: %d\\n\", x, y);\n    return 0;\n}",
            codeExplanation = "swap fonksiyonu &x ve &y adreslerini alarak orijinal x ve y değerlerinin yerini değiştirir.",
            realWorldExample = "İşletim sistemi çekirdeklerinde sürücüler donanım register adreslerine pointerlar ile doğrudan yazar.",
            practicalTask = "İki pointer alıp değerlerini değiştiren bir swap fonksiyonu yazın.",
            starterPlaygroundCode = "#include <stdio.h>\n\nvoid ikiyeKatla(int* ptr) {\n    *ptr = (*ptr) * 2;\n}\n\nint main(void) {\n    int deger = 25;\n    ikiyeKatla(&deger);\n    printf(\"Sonuc: %d\\n\", deger);\n    return 0;\n}",
            miniQuestion = MiniQuestion(
                id = "c_q_5",
                question = "C dilinde bir değişkenin bellekteki adresini elde etmek için hangi operatör kullanılır?",
                options = listOf("&", "*", "->", "%"),
                correctIndex = 0,
                explanation = "& operatörü (Address-of operator) değişkenin RAM adresini döndürür."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_c_5",
                lessonId = "c_5",
                title = "Pointer ile Değer Arttırma",
                instructions = "Verilen bir int pointer'ın gösterdiği adresteki değeri 1 arttıran arttir(int* ptr) fonksiyonunu yazın.",
                exampleInput = "x = 10, arttir(&x)",
                exampleOutput = "x = 11",
                starterCode = "void arttir(int* ptr) {\n    // Kodunu buraya yaz:\n}",
                solutionCode = "void arttir(int* ptr) {\n    if (ptr != NULL) {\n        (*ptr)++;\n    }\n}",
                hints = listOf("(*ptr)++ yazarak adresteki değeri arttırın."),
                testCases = listOf(
                    TestCase("arttir(&val)", "11", "Pointer arttırma testi")
                )
            )
        ),

        // ==========================================
        // DERS 6: DİNAMİK BELLEK YÖNETİMİ (PRO)
        // ==========================================
        Lesson(
            id = "c_6",
            courseId = "c",
            sectionId = "c_sec_3",
            title = "Dinamik Bellek Yönetimi: malloc, calloc, realloc & free",
            shortDesc = "Heap bellek alanı, malloc ile bellek ayırma, calloc ile sıfırlanmış bellek, realloc ile yeniden boyutlandırma ve free() ile bellek iadesi.",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true,
            learningObjectives = listOf(
                "Heap ve Stack bellek alanlarının farkını ve kullanım amaçlarını öğrenmek",
                "malloc, calloc, realloc fonksiyonlarıyla dinamik bellek tahsis etmek",
                "free() kullanarak bellek sızıntılarını (Memory Leaks) ve Dangling Pointer hatalarını engellemek"
            ),
            prerequisites = listOf("Pointerlar ve Bellek Adresleri"),
            subtopics = listOf("Stack vs Heap", "malloc() ve sizeof", "calloc() ile Sıfırlama", "realloc() ile Boyutlandırma", "free() ve Bellek Sızıntıları"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Heap Bellek Tahsisi",
                    body = "Çalışma anında boyutu belirlenen veriler için `<stdlib.h>` kütüphanesindeki `malloc` fonksiyonu kullanılır. `malloc(n * sizeof(int))` Heap'ten n adet int için yer ayırır.",
                    codeSnippet = "#include <stdio.h>\n#include <stdlib.h>\n\nint main(void) {\n    int n = 5;\n    int* dizi = (int*)malloc(n * sizeof(int));\n    if (dizi == NULL) {\n        printf(\"Bellek yetersiz!\\n\");\n        return 1;\n    }\n    \n    for (int i = 0; i < n; i++) dizi[i] = (i + 1) * 10;\n    for (int i = 0; i < n; i++) printf(\"%d \", dizi[i]);\n    printf(\"\\n\");\n    \n    free(dizi); // Bellek serbest bırakılır\n    dizi = NULL;\n    return 0;\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Altın Kural: Her malloc için bir free",
                    body = "Heap'ten ayrılan her bellek bloğu işi bittiğinde `free()` ile sisteme iade edilmelidir. free edildikten sonra pointer'a `NULL` atanması en iyi uygulamadır.",
                    tip = "free(ptr) çağrıldıktan sonra ptr kullanılmaya devam edilirse 'Use-After-Free' güvenlik açığı oluşur."
                )
            ),
            codeExample = "#include <stdio.h>\n#include <stdlib.h>\n\nint main(void) {\n    int* sayilar = calloc(3, sizeof(int)); // Tüm elemanlar 0 ile başlar\n    sayilar[0] = 100;\n    printf(\"sayilar[0]: %d, sayilar[1]: %d\\n\", sayilar[0], sayilar[1]);\n    free(sayilar);\n    return 0;\n}",
            codeExplanation = "calloc tahsis ettiği tüm byte'ları 0 değeriyle ilklendirir.",
            realWorldExample = "Veritabanı motorları (PostgreSQL/MySQL) dinamik sorgu sonuçlarını Heap bellek üzerinde tamponlar.",
            practicalTask = "Kullanıcıdan eleman sayısı alıp dinamik dizi oluşturan, dolduran ve free eden bir C programı yazın.",
            starterPlaygroundCode = "#include <stdio.h>\n#include <stdlib.h>\n\nint main(void) {\n    int* p = malloc(sizeof(int));\n    *p = 77;\n    printf(\"Heap Degeri: %d\\n\", *p);\n    free(p);\n    return 0;\n}",
            miniQuestion = MiniQuestion(
                id = "c_q_6",
                question = "C dilinde Heap'ten ayrılan belleği işletim sistemine geri vermek için hangi fonksiyon çağrılır?",
                options = listOf("free()", "delete()", "release()", "clean()"),
                correctIndex = 0,
                explanation = "free() fonksiyonu malloc/calloc/realloc ile tahsis edilen bellek bloğunu serbest bırakır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_c_6",
                lessonId = "c_6",
                title = "Dinamik Dizi Tahsisi",
                instructions = "Verilen n boyutunda bir int dizisi tahsis eden, içini 1'den n'e kadar sayılarla doldurup pointer'ını döndüren diziUret(int n) fonksiyonunu yazın.",
                exampleInput = "n = 3",
                exampleOutput = "[1, 2, 3]",
                starterCode = "int* diziUret(int n) {\n    // Kodunu buraya yaz:\n    return NULL;\n}",
                solutionCode = "int* diziUret(int n) {\n    int* dizi = (int*)malloc(n * sizeof(int));\n    if (!dizi) return NULL;\n    for (int i = 0; i < n; i++) {\n        dizi[i] = i + 1;\n    }\n    return dizi;\n}",
                hints = listOf("malloc(n * sizeof(int)) ile yer ayırıp döngüyle doldurun."),
                testCases = listOf(
                    TestCase("diziUret(3)", "dizi pointer", "Dinamik dizi testi")
                )
            )
        ),

        // ==========================================
        // DERS 7: STRUCT, UNION & ENUM (PRO)
        // ==========================================
        Lesson(
            id = "c_7",
            courseId = "c",
            sectionId = "c_sec_4",
            title = "struct, union, enum & typedef Veri Yapıları",
            shortDesc = "Özel veri tipleri oluşturma, struct tanımlama, Ok (->) ve Nokta (.) operatörleri, union ile paylaşımlı bellek, enum sabitleri ve typedef alias'ları.",
            level = CourseLevel.INTERMEDIATE,
            order = 7,
            isPremium = true,
            learningObjectives = listOf(
                "struct kullanarak karmaşık veri modelleri tasarlamak",
                "Pointer üzerinden struct üyelerine ok (->) operatörüyle erişmek",
                "union ve enum yapılarının bellek farkını ve avantajlarını kavramak"
            ),
            prerequisites = listOf("Dinamik Bellek Yönetimi"),
            subtopics = listOf("struct Tanımlama", "typedef Kullanımı", "Nokta (.) vs Ok (->) Operatörü", "union ve Bellek Paylaşımı", "enum Numaralandırıcıları"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. struct ve typedef",
                    body = "Farklı türlerdeki verileri tek bir çatı altında toplamak için `struct` kullanılır. `typedef` ile yapıya kısa bir isim verilebilir.",
                    codeSnippet = "#include <stdio.h>\n\ntypedef struct {\n    int id;\n    char isim[30];\n    float maas;\n} Calisan;\n\nint main(void) {\n    Calisan c1 = {101, \"Ali Yilmaz\", 45000.0f};\n    printf(\"Calisan: %s (ID: %d), Maas: %.2f\\n\", c1.isim, c1.id, c1.maas);\n    return 0;\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Struct Pointer ve Ok (->) Operatörü",
                    body = "Eğer elinizde bir struct pointer'ı varsa, `(*ptr).id` yerine pratik olan `ptr->id` sözdizimi kullanılır.",
                    tip = "union içindeki tüm alanlar aynı bellek alanını paylaşır ve boyutu en büyük alanın boyutu kadardır."
                )
            ),
            codeExample = "#include <stdio.h>\n\ntypedef struct {\n    int x;\n    int y;\n} Nokta;\n\nvoid sifirla(Nokta* p) {\n    p->x = 0;\n    p->y = 0;\n}\n\nint main(void) {\n    Nokta n = {10, 20};\n    sifirla(&n);\n    printf(\"Nokta: (%d, %d)\\n\", n.x, n.y);\n    return 0;\n}",
            codeExplanation = "sifirla fonksiyonu Nokta yapısının adresini alarak -> operatörü ile koordinatları günceller.",
            realWorldExample = "Ağ protokol başlıkları (TCP/IP paketleri) C struct yapıları olarak tanımlanır.",
            practicalTask = "Öğrenci adı, numarası ve notunu saklayan bir struct ve öğrencileri listeleyen bir fonksiyon yazın.",
            starterPlaygroundCode = "#include <stdio.h>\n\ntypedef struct {\n    char ad[20];\n    int puan;\n} Oyuncu;\n\nint main(void) {\n    Oyuncu p1 = {\"Ahmet\", 1500};\n    printf(\"Oyuncu: %s, Skor: %d\\n\", p1.ad, p1.puan);\n    return 0;\n}",
            miniQuestion = MiniQuestion(
                id = "c_q_7",
                question = "Bir struct pointer'ı üzerinden struct'ın elemanına erişmek için hangi operatör kullanılır?",
                options = listOf("->", ".", "::", "*."),
                correctIndex = 0,
                explanation = "-> operatörü (Arrow operator) pointer üzerinden üye erişimi için kullanılır (*ptr.alan kısaltmasıdır)."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_c_7",
                lessonId = "c_7",
                title = "Dikdörtgen Alanı",
                instructions = "genislik ve yukseklik alanlarına sahip Dikdortgen struct'ının alanını hesaplayan alanHesapla(Dikdortgen d) fonksiyonunu yazın.",
                exampleInput = "d.genislik = 5, d.yukseklik = 8",
                exampleOutput = "40",
                starterCode = "typedef struct {\n    int genislik;\n    int yukseklik;\n} Dikdortgen;\n\nint alanHesapla(Dikdortgen d) {\n    // Kodunu buraya yaz:\n    return 0;\n}",
                solutionCode = "typedef struct {\n    int genislik;\n    int yukseklik;\n} Dikdortgen;\n\nint alanHesapla(Dikdortgen d) {\n    return d.genislik * d.yukseklik;\n}",
                hints = listOf("d.genislik * d.yukseklik değerini döndürün."),
                testCases = listOf(
                    TestCase("alanHesapla(d)", "40", "Alan hesabı testi")
                )
            )
        ),

        // ==========================================
        // DERS 8: FONKSİYON GÖSTERİCİLERİ (PRO)
        // ==========================================
        Lesson(
            id = "c_8",
            courseId = "c",
            sectionId = "c_sec_4",
            title = "Fonksiyon Göstericileri (Function Pointers) & Callbacks",
            shortDesc = "Fonksiyon bellek adresleri, Function Pointer sözdizimi, Callback mekanizması ve qsort() kütüphane fonksiyonu ile özel sıralama.",
            level = CourseLevel.INTERMEDIATE,
            order = 8,
            isPremium = true,
            learningObjectives = listOf(
                "Fonksiyonların da bellekte bir adrese sahip olduğunu ve işaretlenebileceğini kavramak",
                "Fonksiyon pointer tiplerini (dönüş tipi ve parametre listesi) doğru tanımlamak",
                "qsort() ile özel karşılaştırıcı (comparator) fonksiyonları yazmak"
            ),
            prerequisites = listOf("Struct ve typedef Yapıları"),
            subtopics = listOf("Fonksiyon Adresleri", "Function Pointer Tanımı", "Callback Mekanizması", "qsort() ve Comparator Fonksiyonları", "Event Tabanlı Mimari"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Fonksiyon Göstericisi Sözdizimi",
                    body = "`int (*islem)(int, int);` ifadesi iki int alıp int döndüren herhangi bir fonksiyonun adresini tutabilen bir pointer tanımlar.",
                    codeSnippet = "#include <stdio.h>\n\nint topla(int a, int b) { return a + b; }\nint carp(int a, int b) { return a * b; }\n\nvoid hesapla(int a, int b, int (*islemPtr)(int, int)) {\n    printf(\"Sonuc: %d\\n\", islemPtr(a, b));\n}\n\nint main(void) {\n    hesapla(5, 4, topla); // 9\n    hesapla(5, 4, carp);  // 20\n    return 0;\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. qsort() ile Dizi Sıralama",
                    body = "Standart C kütüphanesindeki `qsort`, karşılaştırma mantığını kullanıcıdan bir fonksiyon göstericisi olarak alır.",
                    tip = "Comparator fonksiyonu `int karsilastir(const void* a, const void* b)` imzasında olmalıdır."
                )
            ),
            codeExample = "#include <stdio.h>\n#include <stdlib.h>\n\nint siralaArtan(const void* a, const void* b) {\n    return (*(int*)a - *(int*)b);\n}\n\nint main(void) {\n    int dizi[] = {45, 12, 89, 3, 21};\n    qsort(dizi, 5, sizeof(int), siralaArtan);\n    for (int i = 0; i < 5; i++) printf(\"%d \", dizi[i]);\n    printf(\"\\n\");\n    return 0;\n}",
            codeExplanation = "qsort fonksiyonu siralaArtan callback'ini kullanarak diziyi küçükten büyüğe sıralar.",
            realWorldExample = "Linux işletim sisteminde sanal dosya sistemi (VFS) tüm dosya işlemlerini (read, write, open) struct içindeki fonksiyon göstericileriyle yönetir.",
            practicalTask = "Diziyi büyükten küçüğe sıralayan bir comparator fonksiyonu yazın.",
            starterPlaygroundCode = "#include <stdio.h>\n\nvoid selamVer(void) { printf(\"Merhaba!\\n\"); }\n\nint main(void) {\n    void (*fn)(void) = selamVer;\n    fn();\n    return 0;\n}",
            miniQuestion = MiniQuestion(
                id = "c_q_8",
                question = "C dilinde standart qsort() fonksiyonuna dizinin nasıl sıralanacağını bildirmek için ne aktarılır?",
                options = listOf("Fonksiyon Göstericisi (Function Pointer / Callback)", "Bir String kuralı", "Bir enum değeri", "Dizi boyutu kopyası"),
                correctIndex = 0,
                explanation = "qsort karşılaştırma fonksiyonunun adresini (function pointer) parametre olarak alır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_c_8",
                lessonId = "c_8",
                title = "İşlem Yürütücü Callback",
                instructions = "int tipinde x değeri ve int (*f)(int) fonksiyon göstericisi alan, f(x)'i çalıştırıp sonucunu dönen calistir(int x, int (*f)(int)) fonksiyonunu yazın.",
                exampleInput = "x = 4, f = kareAl",
                exampleOutput = "16",
                starterCode = "int calistir(int x, int (*f)(int)) {\n    // Kodunu buraya yaz:\n    return 0;\n}",
                solutionCode = "int calistir(int x, int (*f)(int)) {\n    if (f != NULL) return f(x);\n    return x;\n}",
                hints = listOf("f(x) çağrısının sonucunu döndürün."),
                testCases = listOf(
                    TestCase("calistir(4, kare)", "16", "Callback çalıştırma testi")
                )
            )
        ),

        // ==========================================
        // DERS 9: PREPROCESSOR & BIT MANİPÜLASYONU (PRO)
        // ==========================================
        Lesson(
            id = "c_9",
            courseId = "c",
            sectionId = "c_sec_5",
            title = "C Preprocessor (#define, Makrolar) & Bit Manipülasyonu",
            shortDesc = "C Önişlemci direktifleri (#define, #ifdef, #ifndef, Include Guards), Parametreli Makrolar ve Bitwise Operatörler (&, |, ^, ~, <<, >>).",
            level = CourseLevel.ADVANCED,
            order = 9,
            isPremium = true,
            learningObjectives = listOf(
                "Önişlemci (Preprocessor) direktifleri ile derleme zamanı kod üretimi yapmak",
                "Header dosyalarında çift dahil etmeyi önlemek için Include Guard mekanizmasını kurmak",
                "Bit seviyesinde maskeleme, bayrak (flags) yönetimi ve kaydırma işlemlerini öğrenmek"
            ),
            prerequisites = listOf("Fonksiyon Göstericileri"),
            subtopics = listOf("#define ve Sabitler", "Parametreli Makrolar", "#ifdef ve Header Guards", "Bitwise Operatörler (&, |, ^, ~, <<, >>)", "Bit Maskeleme ve Bayraklar (Flags)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Include Guards",
                    body = "Bir header dosyasının birden fazla kez derlemeye girmesini engellemek için standard Include Guard kalıbı kullanılır.",
                    codeSnippet = "#ifndef MATEMATIK_H\n#define MATEMATIK_H\n\nint topla(int a, int b);\n\n#endif // MATEMATIK_H"
                ),
                LessonContentBlock(
                    subtitle = "2. Bitwise Operatörler ve Bayraklar",
                    body = "• & (AND): İki bit de 1 ise 1\n• | (OR): Herhangi bir bit 1 ise 1\n• ^ (XOR): Bitler farklıysa 1\n• ~ (NOT): Bitleri tersine çevirir\n• << / >>: Bitleri sola veya sağa kaydırır.",
                    tip = "Bir bayrağı set etmek için `flags |= (1 << n);`, temizlemek için `flags &= ~(1 << n);` kullanılır."
                )
            ),
            codeExample = "#include <stdio.h>\n\n#define MAX(a, b) ((a) > (b) ? (a) : (b))\n#define FLAG_OKUMA  (1 << 0) // 0001\n#define FLAG_YAZMA  (1 << 1) // 0010\n\nint main(void) {\n    int buyuk = MAX(15, 30);\n    printf(\"Buyuk Sayi: %d\\n\", buyuk);\n    \n    int izinler = FLAG_OKUMA | FLAG_YAZMA; // 0011\n    if (izinler & FLAG_OKUMA) printf(\"Okuma izni var!\\n\");\n    return 0;\n}",
            codeExplanation = "Bitmask tekniği ile tek bir tamsayı içinde onlarca boolean ayar son derece hızlı ve az bellek ile saklanır.",
            realWorldExample = "Dosya izinleri (Linux chmod 755) ve donanım yazmaçları bit bayrakları ile kontrol edilir.",
            practicalTask = "Verilen bir tamsayının n. bitinin 1 mi 0 mı olduğunu kontrol eden bir fonksiyon yazın.",
            starterPlaygroundCode = "#include <stdio.h>\n\nint main(void) {\n    int sayi = 8; // 1000 binary\n    printf(\"sayi << 1 = %d\\n\", sayi << 1); // 16\n    printf(\"sayi >> 1 = %d\\n\", sayi >> 1); // 4\n    return 0;\n}",
            miniQuestion = MiniQuestion(
                id = "c_q_9",
                question = "C dilinde bir tamsayıyı 2 ile çarpmak için hangi bit kaydırma operatörü en hızlı alternatiftir?",
                options = listOf("<< 1", ">> 1", "& 2", "^ 2"),
                correctIndex = 0,
                explanation = "Bitleri 1 basamak sola kaydırmak (sayi << 1) sayıyı 2 ile çarpmaya eşdeğerdir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_c_9",
                lessonId = "c_9",
                title = "2'nin Kuvveti Kontrolü (Bitwise)",
                instructions = "Verilen pozitif bir sayının 2'nin tam kuvveti olup olmadığını bitwise operatörlerle kontrol eden ikiKuvvetiMi(int n) fonksiyonunu yazın. 2'nin kuvveti ise 1, değilse 0 dönmelidir.",
                exampleInput = "n = 16",
                exampleOutput = "1",
                starterCode = "int ikiKuvvetiMi(int n) {\n    // Kodunu buraya yaz:\n    return 0;\n}",
                solutionCode = "int ikiKuvvetiMi(int n) {\n    if (n <= 0) return 0;\n    return (n & (n - 1)) == 0;\n}",
                hints = listOf("n & (n - 1) ifadesi 2'nin kuvveti sayılarda 0 sonucunu verir."),
                testCases = listOf(
                    TestCase("ikiKuvvetiMi(16)", "1", "2'nin kuvveti testi")
                )
            )
        ),

        // ==========================================
        // DERS 10: DOSYA İŞLEMLERİ & FILE I/O (PRO)
        // ==========================================
        Lesson(
            id = "c_10",
            courseId = "c",
            sectionId = "c_sec_5",
            title = "Dosya İşlemleri (File I/O): fopen, fread, fwrite & fclose",
            shortDesc = "Metin ve İkili (Binary) dosyalar, FILE* işaretçisi, fopen modları (\"r\", \"w\", \"a\", \"rb\", \"wb\"), fseek/ftell ile dosya konumu ve güvenli okuma/yazma.",
            level = CourseLevel.ADVANCED,
            order = 10,
            isPremium = true,
            learningObjectives = listOf(
                "FILE* işaretçisi ile dosya açma, okuma, yazma ve kapatma işlemlerini yönetmek",
                "Metin dosyaları ile Binary (ikili) dosyaların farkını kavramak",
                "fseek() ve ftell() ile dosya boyutunu ve imlecini konumlandırmak"
            ),
            prerequisites = listOf("Bit Manipülasyonu ve Preprocessor"),
            subtopics = listOf("FILE* İşaretçisi", "fopen Modları", "Metin Dosyaları (fgets, fprintf)", "İkili Dosyalar (fread, fwrite)", "fseek, ftell ve fclose"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Dosya Açma ve Kapatma",
                    body = "Dosyalar `fopen()` ile açılır ve `FILE*` işaretçisi döndürür. İşlem bittiğinde `fclose()` ile işletim sistemi dosya tanıtıcısı (file descriptor) serbest bırakılır.",
                    codeSnippet = "#include <stdio.h>\n\nint main(void) {\n    FILE* fp = fopen(\"gunluk.txt\", \"w\");\n    if (fp == NULL) {\n        perror(\"Dosya acilamadi\");\n        return 1;\n    }\n    fprintf(fp, \"C Dili ile Dosya Yazma\\nTarih: 2026\\n\");\n    fclose(fp);\n    return 0;\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Binary Dosya Okuma/Yazma (fread / fwrite)",
                    body = "Struct gibi ham bellek bloklarını doğrudan diske kaydetmek için `fwrite` ve geri yüklemek için `fread` kullanılır.",
                    tip = "Binary mod için fopen mod parametresine 'b' eklenmelidir (örn: \"wb\", \"rb\")."
                )
            ),
            codeExample = "#include <stdio.h>\n\ntypedef struct { int id; float deger; } Veri;\n\nint main(void) {\n    Veri v = {42, 3.14f};\n    FILE* fp = fopen(\"veri.bin\", \"wb\");\n    if (fp) {\n        fwrite(&v, sizeof(Veri), 1, fp);\n        fclose(fp);\n    }\n    return 0;\n}",
            codeExplanation = "fwrite fonksiyonu bellek adresini doğrudan diske binary byte dizisi olarak yazar.",
            realWorldExample = "Görüntü işleme kütüphaneleri (JPEG/PNG dekoderları) dosya başlıklarını fread ile binary olarak ayrıştırır.",
            practicalTask = "Bir metin dosyasındaki karakter sayısını ftell ile bulan bir C programı yazın.",
            starterPlaygroundCode = "#include <stdio.h>\n\nint main(void) {\n    printf(\"Dosya I/O Modu Hazir\\n\");\n    return 0;\n}",
            miniQuestion = MiniQuestion(
                id = "c_q_10",
                question = "C dilinde açılmış bir dosyanın boyutunu öğrenmek için fseek(fp, 0, SEEK_END) çağrısından sonra hangi fonksiyon kullanılır?",
                options = listOf("ftell(fp)", "fsize(fp)", "flen(fp)", "feof(fp)"),
                correctIndex = 0,
                explanation = "ftell(fp) dosya imlecinin baştan itibaren kaçıncı byte'ta olduğunu döndürür."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_c_10",
                lessonId = "c_10",
                title = "Dosya Yazma Kontrolü",
                instructions = "Verilen dosya yoluna metin yazıp başarılı olursa 1, dosya açılamazsa 0 dönen dosyaYaz(const char* yol, const char* metin) fonksiyonunu yazın.",
                exampleInput = "yol = \"test.txt\", metin = \"Merhaba\"",
                exampleOutput = "1",
                starterCode = "int dosyaYaz(const char* yol, const char* metin) {\n    // Kodunu buraya yaz:\n    return 0;\n}",
                solutionCode = "int dosyaYaz(const char* yol, const char* metin) {\n    if (!yol || !metin) return 0;\n    FILE* fp = fopen(yol, \"w\");\n    if (!fp) return 0;\n    fputs(metin, fp);\n    fclose(fp);\n    return 1;\n}",
                hints = listOf("fopen ile dosyayı 'w' modunda açıp fputs ile yazın ve fclose ile kapatın."),
                testCases = listOf(
                    TestCase("dosyaYaz(\"a.txt\", \"b\")", "1", "Dosya yazma testi")
                )
            )
        ),

        // ==========================================
        // DERS 11: POSIX THREADS & MULTITHREADING (PRO)
        // ==========================================
        Lesson(
            id = "c_11",
            courseId = "c",
            sectionId = "c_sec_6",
            title = "Eşzamanlılık: POSIX Threads (pthread) & Mutex",
            shortDesc = "Çoklu iş parçacığı (Multithreading), pthread_create, pthread_join, Yarış Durumu (Race Condition), pthread_mutex_t kilitleri ve Thread Güvenliği.",
            level = CourseLevel.EXPERT,
            order = 11,
            isPremium = true,
            learningObjectives = listOf(
                "pthread_create ve pthread_join ile eşzamanlı iş parçacıkları başlatmak",
                "Paylaşılan bellek kaynaklarında Race Condition tehlikesini anlamak",
                "pthread_mutex_t ile kritik bölgeyi (Critical Section) kilitleyip senkronize etmek"
            ),
            prerequisites = listOf("Dosya I/O ve Fonksiyon Göstericileri"),
            subtopics = listOf("Multithreading Temelleri", "pthread_create ve pthread_join", "Race Condition Nedir?", "pthread_mutex_lock & unlock", "Thread Pool Mimarisi"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. pthread ile Thread Başlatma",
                    body = "POSIX standardındaki `pthread.h` kütüphanesi işletim sistemi seviyesinde hafif iş parçacıkları üretir.",
                    codeSnippet = "#include <stdio.h>\n#include <pthread.h>\n\nvoid* threadGorevi(void* arg) {\n    printf(\"Thread calisiyor! ID: %ld\\n\", (long)arg);\n    return NULL;\n}\n\nint main(void) {\n    pthread_t t1;\n    pthread_create(&t1, NULL, threadGorevi, (void*)1);\n    pthread_join(t1, NULL); // Thread bitene kadar bekle\n    printf(\"Ana program tamamlandi.\\n\");\n    return 0;\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Mutex ile Senkronizasyon",
                    body = "Birden fazla thread aynı anda paylaşılan değişkene yazmaya çalıştığında veri bozulur. Bunu önlemek için `pthread_mutex_lock` ve `pthread_mutex_unlock` kullanılır.",
                    tip = "Kilit açmayı (mutex unlock) unutmak programın donmasına (Deadlock) sebep olur."
                )
            ),
            codeExample = "#include <stdio.h>\n#include <pthread.h>\n\nint sayac = 0;\npthread_mutex_t kilit = PTHREAD_MUTEX_INITIALIZER;\n\nvoid* arttir(void* arg) {\n    for (int i = 0; i < 10000; i++) {\n        pthread_mutex_lock(&kilit);\n        sayac++;\n        pthread_mutex_unlock(&kilit);\n    }\n    return NULL;\n}\n\nint main(void) {\n    pthread_t t1, t2;\n    pthread_create(&t1, NULL, arttir, NULL);\n    pthread_create(&t2, NULL, arttir, NULL);\n    pthread_join(t1, NULL);\n    pthread_join(t2, NULL);\n    printf(\"Guvenli Sayac: %d\\n\", sayac);\n    return 0;\n}",
            codeExplanation = "Mutex kilidi sayesinde iki thread aynı anda sayacı artıramaz ve sayac tam 20000 değerine ulaşır.",
            realWorldExample = "Web sunucuları (Nginx/Apache) gelen binlerce HTTP isteğini thread havuzları ile paralel işler.",
            practicalTask = "İki thread oluşturup her birinde ekrana farklı mesaj yazdıran bir C programı yazın.",
            starterPlaygroundCode = "#include <stdio.h>\n\nint main(void) {\n    printf(\"pthread eszamanlilik testi\\n\");\n    return 0;\n}",
            miniQuestion = MiniQuestion(
                id = "c_q_11",
                question = "Birden fazla thread'in aynı paylaşılan belleğe aynı anda yazmasını engelleyip sıralı erişim sağlayan mekanizma hangisidir?",
                options = listOf("Mutex (Mutual Exclusion)", "Fork", "Signal", "Malloc"),
                correctIndex = 0,
                explanation = "Mutex paylaşılan kritik bölgeye aynı anda yalnızca tek bir thread'in girmesini garanti eder."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_c_11",
                lessonId = "c_11",
                title = "Thread Güvenli Toplayıcı",
                instructions = "Bir sayaç değişkenini mutex kullanarak güvenli şekilde n defa arttıran guvenliArttir(int* sayac, pthread_mutex_t* kilit, int n) mantığını yazın.",
                exampleInput = "n = 100",
                exampleOutput = "sayac = 100",
                starterCode = "void guvenliArttir(int* sayac, pthread_mutex_t* kilit, int n) {\n    // Kodunu buraya yaz:\n}",
                solutionCode = "void guvenliArttir(int* sayac, pthread_mutex_t* kilit, int n) {\n    for (int i = 0; i < n; i++) {\n        pthread_mutex_lock(kilit);\n        (*sayac)++;\n        pthread_mutex_unlock(kilit);\n    }\n}",
                hints = listOf("Döngü içinde lock ve unlock arasına arttırma işlemini yerleştirin."),
                testCases = listOf(
                    TestCase("guvenliArttir(&s, &k, 10)", "10", "Mutex güvenli arttırma")
                )
            )
        ),

        // ==========================================
        // DERS 12: DÜŞÜK SEVİYE SİSTEM MİMARİSİ (PRO)
        // ==========================================
        Lesson(
            id = "c_12",
            courseId = "c",
            sectionId = "c_sec_6",
            title = "Düşük Seviye Sistem Programlama & Özel Bellek Havuzları",
            shortDesc = "Ham bellek manipülasyonu, Memory Alignment, Arena Allocator mimarisi, Cache Locality ve Sıfır Bölünme (Zero Fragmentation) tasarımı.",
            level = CourseLevel.EXPERT,
            order = 12,
            isPremium = true,
            learningObjectives = listOf(
                "Standart malloc maliyetini ve bellek parçalanmasını (fragmentation) anlamak",
                "Sıfırdan Arena (Linear) Memory Allocator tasarlamak",
                "Cache Locality ve donanım dostu veri yapıları kurmak"
            ),
            prerequisites = listOf("POSIX Threads ve Dinamik Bellek"),
            subtopics = listOf("Bellek Parçalanması (Fragmentation)", "Arena Memory Allocator", "Memory Alignment (Hizalama)", "Cache Locality Optimizasyonu", "Kernel Mimarisi"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Arena Memory Allocator Nedir?",
                    body = "Oyun motorlarında ve yüksek performanslı sunucularda her nesne için `malloc` çağırmak çok yavaştır. Bunun yerine devasa tek bir bellek bloğu ayrılır (Arena) ve nesneler için imleç ilerletilir. İş bitince tüm arena tek seferde sıfırlanır.",
                    codeSnippet = "#include <stdio.h>\n#include <stdlib.h>\n#include <stdint.h>\n\ntypedef struct {\n    uint8_t* buffer;\n    size_t kapasite;\n    size_t offset;\n} Arena;\n\nArena arenaOlustur(size_t kapasite) {\n    Arena a;\n    a.buffer = (uint8_t*)malloc(kapasite);\n    a.kapasite = kapasite;\n    a.offset = 0;\n    return a;\n}\n\nvoid* arenaTahsis(Arena* a, size_t boyut) {\n    if (a->offset + boyut > a->kapasite) return NULL;\n    void* ptr = &a->buffer[a->offset];\n    a->offset += boyut;\n    return ptr;\n}\n\nvoid arenaSifirla(Arena* a) {\n    a->offset = 0;\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Sıfır Serbest Bırakma Maliyeti",
                    body = "Arena tahsisçisinde binlerce nesne için ayrı ayrı `free` çağırmaya gerek yoktur; `offset = 0` yapılarak tüm bellek anında tekrar kullanılabilir hale gelir.",
                    tip = "Arena tahsisçileri bellek parçalanmasını tamamen ortadan kaldırır ve CPU L1/L2 önbellek verimini en üst düzeye çıkarır."
                )
            ),
            codeExample = "#include <stdio.h>\n#include <stdlib.h>\n\nint main(void) {\n    printf(\"Arena Allocator: Sifir Parcalanma, Ultra Hizli Tahsis\\n\");\n    return 0;\n}",
            codeExplanation = "Özel bellek tahsisçileri modern oyun motorlarının (id Software Doom motoru vb.) bellek omurgasını oluşturur.",
            realWorldExample = "Oyun motorları her kare (frame) başında bir Frame Arena tahsis eder ve kare sonunda tek bir işlemle tüm geçici belleği temizler.",
            practicalTask = "Sabit boyutlu bir byte dizisi üzerinden sırayla int tahsis eden basit bir arena mekanizması kodlayın.",
            starterPlaygroundCode = "#include <stdio.h>\n\nint main(void) {\n    printf(\"Sistem Programlama Bitirme Projesi\\n\");\n    return 0;\n}",
            miniQuestion = MiniQuestion(
                id = "c_q_12",
                question = "Arena (Linear) bellek tahsisçisinin standart malloc/free'ye göre en büyük performans avantajı nedir?",
                options = listOf("Tahsis O(1) hızındadır ve tek hamlede tüm blok sıfırlanarak sıfır parçalanma sağlar", "Daha fazla RAM kullanır", "Her tipe otomatik cast yapar", "Thread oluşturmayı hızlandırır"),
                correctIndex = 0,
                explanation = "Arena tahsisçisi sadece bir işaretçi kaydırarak O(1) tahsis yapar ve toplu sıfırlanabilir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_c_12",
                lessonId = "c_12",
                title = "Arena Offset İlerleme",
                instructions = "Mevcut offset değeri ve talep edilen boyut (byte) verildiğinde, kapasiteyi aşmıyorsa yeni offset'i, aşıyorsa -1 döndüren sonrakiOffset(size_t kapasite, size_t offset, size_t boyut) fonksiyonunu yazın.",
                exampleInput = "kapasite = 1024, offset = 100, boyut = 64",
                exampleOutput = "164",
                starterCode = "long long sonrakiOffset(long long kapasite, long long offset, long long boyut) {\n    // Kodunu buraya yaz:\n    return -1;\n}",
                solutionCode = "long long sonrakiOffset(long long kapasite, long long offset, long long boyut) {\n    if (offset + boyut <= kapasite) {\n        return offset + boyut;\n    }\n    return -1;\n}",
                hints = listOf("offset + boyut <= kapasite kontrolü yapın."),
                testCases = listOf(
                    TestCase("sonrakiOffset(1024, 100, 64)", "164", "Arena offset testi")
                )
            )
        )
    )
}
