package com.example.data.catalog

import com.example.model.*

/**
 * Python Kolay & Anlaşılır Müfredatı (12 Adım):
 * Sıfırdan başlayanlar için sade, samimi ve örneklerle dolu Python rehberi.
 */
object PythonCurriculum {

    fun getSections(): List<CourseSection> = listOf(
        CourseSection(
            id = "py_sec_1",
            courseId = "python",
            title = "Bölüm 1: Python Temelleri ve Kontrol Akışı",
            level = CourseLevel.BEGINNER,
            order = 1,
            description = "Python dünyasına giriş: Ekrana yazı yazdırma, değişkenler, f-string ile metin süsleme, if-else şartları ve döngüler.",
            learningObjectives = listOf("Python sözdizimini ve print() komutunu öğrenmek", "Sayılar ve metinler ile değişken tanımlamak", "if-elif-else ile karar mekanizmaları kurmak", "for ve while döngüleri ile işlemleri tekrarlamak"),
            prerequisites = listOf("Ön bilgi gerekmez! Sıfırdan başlar.")
        ),
        CourseSection(
            id = "py_sec_2",
            courseId = "python",
            title = "Bölüm 2: Fonksiyonlar ve Veri Yapıları",
            level = CourseLevel.BEGINNER,
            order = 2,
            description = "İşleri fonksiyonlara bölme, Listeler, Sözlükler (Dict), Kümeler (Set) ve tek satırda liste üretme (Comprehensions).",
            learningObjectives = listOf("def ile fonksiyon yazmak ve parametre göndermek", "List, Tuple, Set ve Dict yapılarını kullanmak", "List Comprehension ile pratik veri işlemek"),
            prerequisites = listOf("Python Temelleri ve Döngüler")
        ),
        CourseSection(
            id = "py_sec_3",
            courseId = "python",
            title = "Bölüm 3: Hata Yönetimi ve Nesneler (OOP)",
            level = CourseLevel.INTERMEDIATE,
            order = 3,
            description = "try-except ile çökmeyen programlar yazma, Sınıflar (Class), self mantığı ve kalıtım.",
            learningObjectives = listOf("try-except ile hataları yakalamak", "Sınıf (Class) ve __init__ ile nesne üretmek", "Kalıtım (Inheritance) ile kod paylaşmak"),
            prerequisites = listOf("Fonksiyonlar ve Veri Yapıları")
        ),
        CourseSection(
            id = "py_sec_4",
            courseId = "python",
            title = "Bölüm 4: Dekoratörler ve Jeneratörler",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            description = "@decorator ile fonksiyonlara süper güçler katma ve yield ile hafızayı yormayan veri akışları.",
            learningObjectives = listOf("Dekoratör mantığını kavramak", "yield ile bellek dostu jeneratörler yazmak"),
            prerequisites = listOf("Sınıflar ve Fonksiyonlar")
        ),
        CourseSection(
            id = "py_sec_5",
            courseId = "python",
            title = "Bölüm 5: Asenkron Python (AsyncIO)",
            level = CourseLevel.ADVANCED,
            order = 5,
            description = "İnternet veya dosya beklerken vakit kaybetmeyen async ve await yapıları.",
            learningObjectives = listOf("async ve await ile beklemesiz programlama", "Eşzamanlı görevleri yönetmek"),
            prerequisites = listOf("Fonksiyonlar ve Hata Yönetimi")
        ),
        CourseSection(
            id = "py_sec_6",
            courseId = "python",
            title = "Bölüm 6: İleri Seviye ve Temiz Kod",
            level = CourseLevel.EXPERT,
            order = 6,
            description = "Büyük projeleri modüllere ayırma, profesyonel ipuçları ve Python'un sırları.",
            learningObjectives = listOf("Modüller ve paketler oluşturmak", "Python'da temiz ve standartlara uygun kod yazmak"),
            prerequisites = listOf("Tüm Temel ve İleri Seviyeler")
        )
    )

    fun getLessons(): List<Lesson> = listOf(
        // ==========================================
        // DERS 1: TEMEL SÖZDİZİMİ VE DEĞİŞKENLER
        // ==========================================
        Lesson(
            id = "py_1",
            courseId = "python",
            sectionId = "py_sec_1",
            title = "Python'a Giriş: Değişkenler ve f-String",
            shortDesc = "Dünyanın en popüler dili Python'a ilk adım! Ekrana yazı yazdırma ve değişkenlerle bilgi saklama.",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false,
            learningObjectives = listOf(
                "print() fonksiyonu ile ekrana çıktı almayı öğrenmek",
                "Metin (str), Tam Sayı (int), Ondalık (float) ve Mantıksal (bool) değişkenleri tanımlamak",
                "f-string (f'Merhaba {isim}') ile metinleri kolayca birleştirmek",
                "Python'ın sade ve noktalı virgülsüz sözdizimini keşfetmek"
            ),
            prerequisites = listOf("Ön koşul gerekmez."),
            subtopics = listOf("Python Neden Çok Popüler?", "print() ve Açıklama Satırları (#)", "Değişkenler ve Türler", "Süper Pratik f-Strings"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Python Dünyasına Hoş Geldiniz!",
                    body = "Python; yapay zeka, veri bilimi, web geliştirme ve otomasyon alanlarında dünyanın 1 numaralı dilidir. En güzel yanı, neredeyse günlük İngilizce konuşur gibi sade ve temiz yazılmasıdır. Noktalı virgül (;) veya süslü parantez karmaşası yoktur!\n\nBilgisayara ilk mesajımızı iletmek için `print()` komutunu kullanırız.",
                    codeSnippet = "# Bu bir yorum satırıdır, bilgisayar burayı okumaz\nprint('Merhaba Python ve Kod Akademi!')",
                    tip = "Python'da metinleri tek tırnak ('...') veya çift tırnak (\"...\") içine alabilirsiniz."
                ),
                LessonContentBlock(
                    subtitle = "2. Değişkenler: Bilgi Saklayan Kutular",
                    body = "Değişkenler hafızadaki etiketli kutulardır. Tip belirtmenize gerek yoktur, Python ne koyduğunuzu hemen anlar:\n\n• `isim = 'Can'` (Metin - str)\n• `yas = 25` (Tam Sayı - int)\n• `boy = 1.78` (Ondalıklı Sayı - float)\n• `ogrenci_mi = True` (Doğru/Yanlış - bool)",
                    codeSnippet = "ad = 'Zeynep'\nyas = 22\nnot_ortalamasi = 3.90\nmezun = False\n\nprint(ad)\nprint(yas)"
                ),
                LessonContentBlock(
                    subtitle = "3. f-String: Metin İçine Değişken Koymanın En Kolay Yolu!",
                    body = "Metnin başına küçük bir `f` harfi koyup, değişkenlerimizi süslü parantez `{değişken}` içine yazarak harika cümleler kurabiliriz.",
                    codeSnippet = "ad = 'Mert'\npuan = 100\n\n# f-string ile şık bir birleştirme:\nmesaj = f'Tebrikler {ad}, sınavdan {puan} aldın!'\nprint(mesaj)"
                )
            ),
            codeExample = "dil = 'Python'\nyil = 2026\nkolay_mi = True\n\nprint(f'{dil} öğreniyorum! Yıl: {yil} (Kolay mı: {kolay_mi})')",
            codeExplanation = "Değişkenler tanımlandı ve f-string kalıbı f'{...}' ile tek satırda ekrana yazdırıldı.",
            realWorldExample = "Yapay zeka robotları ve ChatGPT benzeri modellerin arkasındaki algoritmaların neredeyse tamamı Python ile yazılır.",
            practicalTask = "Adınızı ve yaşınızı iki değişkende saklayıp f-string ile 'Benim adım ..., yaşım ...' yazdırın.",
            starterPlaygroundCode = "ad = 'Ahmet'\nyas = 20\n# f-string kullanarak print yazın:\n",
            miniQuestion = MiniQuestion(
                id = "py_q_1",
                question = "Python'da metin içine değişken yerleştirmek için metnin başına hangi harf konur?",
                options = listOf("f", "s", "m", "p"),
                correctIndex = 0,
                explanation = "f harfi konularak f-string formatı etkinleştirilir (örn: f'Merhaba {ad}')."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_1",
                lessonId = "py_1",
                title = "Öğrenci Not Kartı",
                instructions = "ad ve notu parametrelerini alıp f-string kullanarak 'Ali: 90 Puan' formatında döndüren not_karti() fonksiyonunu yazın.",
                exampleInput = "ad = 'Ali', notu = 90",
                exampleOutput = "'Ali: 90 Puan'",
                starterCode = "def not_karti(ad, notu):\n    # Kodunu buraya yaz:\n    return ''",
                solutionCode = "def not_karti(ad, notu):\n    return f'{ad}: {notu} Puan'",
                hints = listOf("f'{ad}: {notu} Puan' döndürün."),
                testCases = listOf(
                    TestCase("not_karti('Ali', 90)", "Ali: 90 Puan", "Not kartı testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_1_1",
                    lessonId = "py_1",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Python dilinde yorum (açıklama) satırı hangi işaretle başlar?",
                    options = listOf("#", "//", "/*", "--"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Python'da tek satırlık yorumlar # (diyez) ile yazılır.",
                    explanationWrong = "Python'da yorumlar # işaretiyle başlar.",
                    reviewTopic = "Python Temelleri"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Python'da neden noktalı virgül (;) yok?",
                    answer = "Python'ın tasarım felsefesi sadelik üzerine kuruludur. Her satır bir komuttur ve girintiler (boşluklar) blokları belirler."
                )
            ),
            completionCriteria = listOf(
                "print() komutunu kullanabilmek",
                "Değişken tanımlayabilmek",
                "f-string ile metin birleştirebilmek"
            )
        ),

        // ==========================================
        // DERS 2: KOŞULLAR VE DÖNGÜLER
        // ==========================================
        Lesson(
            id = "py_2",
            courseId = "py",
            sectionId = "py_sec_1",
            title = "Karar Yapıları (if-else) ve Döngüler (for, while)",
            shortDesc = "Bilgisayara şartlara göre karar aldırma ve range() ile tekrarlayan döngüler kurma.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false,
            learningObjectives = listOf(
                "if, elif ve else ile şartlı dallanmalar kurmak",
                "Python'daki girinti (indentation) kuralını kavramak",
                "for döngüsü ve range() fonksiyonunu kullanmak",
                "while döngüsü ile şartlı tekrarlar yapmak"
            ),
            prerequisites = listOf("Python Değişkenler"),
            subtopics = listOf("Girinti (İçeriden Yazma) Kuralı", "if, elif, else", "for ve range()", "while Döngüsü"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Kararlar: if, elif ve else",
                    body = "Python'da şart bloklarının sınırını süslü parantez değil, **satır başındaki 4 boşluk (girinti)** belirler:\n\n• `if sart:`: Şart doğruysa girintili bloğu çalıştır.\n• `elif diger_sart:`: İlk şart tutmadıysa buna bak (else-if'in kısaltması).\n• `else:`: Hiçbiri tutmadıysa bunu yap.",
                    codeSnippet = "puan = 80\n\nif puan >= 90:\n    print('Harika! Notun: A')\nelif puan >= 70:\n    print('İyi! Notun: B')\nelse:\n    print('Geliştirilmeli')"
                ),
                LessonContentBlock(
                    subtitle = "2. Döngüler: for ve range()",
                    body = "Belirli bir sayıda tekrar yapmak için `for i in range(başlangıç, bitiş):` yapısını kullanırız. `range(1, 6)` ifadesi 1'den başlar ve 5'e kadar (6 dahil değil) sayar.",
                    codeSnippet = "# 1'den 5'e kadar sayalım:\nfor i in range(1, 6):\n    print(f'Adım: {i}')\n\n# Bir listenin elemanlarını gezmek:\nmeyveler = ['Elma', 'Muz', 'Çilek']\nfor meyve in meyveler:\n    print(f'Meyve: {meyve}')"
                )
            ),
            codeExample = "toplam = 0\nfor sayi in range(1, 6):\n    toplam += sayi\nprint(f'1-5 Arası Toplam: {toplam}') # 15",
            codeExplanation = "for döngüsü 1'den 5'e kadar her sayıyı toplam değişkenine ekler.",
            realWorldExample = "Kullanıcı hatalı şifre girdiğinde 'Kalan hakkınız: 2' uyarısı vermek için if ve sayaçlar kullanılır.",
            practicalTask = "1'den 10'a kadar olan sayılardan sadece çift olanları ekrana yazdıran bir for döngüsü yazın.",
            starterPlaygroundCode = "for sayi in range(1, 11):\n    # if sayi % 2 == 0 kontrolü yapın:\n    pass",
            miniQuestion = MiniQuestion(
                id = "py_q_2",
                question = "range(1, 4) ifadesi sırasıyla hangi sayıları üretir?",
                options = listOf("1, 2, 3", "1, 2, 3, 4", "0, 1, 2, 3, 4", "2, 3, 4"),
                correctIndex = 0,
                explanation = "range(başlangıç, bitiş) fonksiyonunda bitiş sayısı dahil edilmez, yani 1, 2, 3 üretilir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_2",
                lessonId = "py_2",
                title = "Çift Sayıların Toplamı",
                instructions = "1'den n'e kadar (n dahil) olan çift sayıların toplamını hesaplayan cift_toplami(n) fonksiyonunu yazın.",
                exampleInput = "n = 6",
                exampleOutput = "12 (2 + 4 + 6)",
                starterCode = "def cift_toplami(n):\n    # Kodunu buraya yaz:\n    return 0",
                solutionCode = "def cift_toplami(n):\n    top = 0\n    for i in range(2, n + 1, 2):\n        top += i\n    return top",
                hints = listOf("range(2, n + 1, 2) kullanarak ikişer ikişer sayabilirsiniz."),
                testCases = listOf(
                    TestCase("cift_toplami(6)", "12", "6 için toplam"),
                    TestCase("cift_toplami(10)", "30", "10 için toplam")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_2_1",
                    lessonId = "py_2",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Python'da bir kod bloğunun hangi if veya for'a ait olduğunu belirleyen şey nedir?",
                    options = listOf("Satır başındaki boşluklar (Girinti)", "Süslü parantezler {}", "Noktalı virgül ;", "Satır sonundaki ünlem !"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Python girinti (indentation) temelli bir dildir.",
                    explanationWrong = "Python'da bloklar girintiler (boşluklar) ile ayrılır.",
                    reviewTopic = "Python Sözdizimi"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Girinti kaç boşluk olmalıdır?",
                    answer = "Python standartlarında (PEP 8) her bir girinti seviyesi için 4 adet boşluk kullanılması tavsiye edilir."
                )
            ),
            completionCriteria = listOf(
                "if, elif ve else bloklarını kurabilmek",
                "for ve range() ile döngü yapabilmek",
                "Girinti (boşluk) mantığına alışmak"
            )
        ),

        // ==========================================
        // DERS 3: FONKSİYONLAR (def)
        // ==========================================
        Lesson(
            id = "py_3",
            courseId = "py",
            sectionId = "py_sec_2",
            title = "Fonksiyonlar: def ile Kodları Paketleme",
            shortDesc = "Tekrar tekrar aynı işi yapmak yerine def ile fonksiyon yazın, parametre verin ve sonuç alın.",
            level = CourseLevel.BEGINNER,
            order = 3,
            isPremium = false,
            learningObjectives = listOf(
                "def anahtar kelimesi ile fonksiyon tanımlamak",
                "Parametre (girdi) göndermek ve return ile sonuç almak",
                "Varsayılan (default) değerli parametreler oluşturmak",
                "Tek satırlık pratik lambda fonksiyonlarını öğrenmek"
            ),
            prerequisites = listOf("Değişkenler ve Koşullar"),
            subtopics = listOf("Fonksiyon Nedir? (def)", "return ile Değer Döndürme", "Varsayılan Parametreler", "Lambda Fonksiyonları"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Fonksiyon Tanımlama (def)",
                    body = "Fonksiyonlar, belirli bir görevi yapan küçük akıllı yardımcılardır. `def fonksiyon_adi(parametreler):` şeklinde tanımlanır ve `return` ile sonucu geri verir.",
                    codeSnippet = "def topla(a, b):\n    sonuc = a + b\n    return sonuc\n\n# Fonksiyonu çağıralım:\ntoplam = topla(10, 20)\nprint(f'Toplam: {toplam}') # 30"
                ),
                LessonContentBlock(
                    subtitle = "2. Varsayılan Değerler ve İsimle Çağırma",
                    body = "Bir parametreye varsayılan değer verirseniz, o bilgi verilmediğinde otomatik devreye girer.",
                    codeSnippet = "def selamla(isim, unvan='Üye'):\n    return f'Merhaba {unvan} {isim}!'\n\nprint(selamla('Ahmet'))          # Merhaba Üye Ahmet!\nprint(selamla('Elif', 'Yönetici')) # Merhaba Yönetici Elif!"
                )
            ),
            codeExample = "def daire_alani(r, pi=3.14):\n    return pi * (r ** 2)\n\nprint(f'Yarıçapı 5 olan dairenin alanı: {daire_alani(5)}')",
            codeExplanation = "daire_alani fonksiyonu pi sayısını varsayılan 3.14 alarak alanı hesaplar.",
            realWorldExample = "Web sitesinde bir sipariş oluşturulduğunda fatura tutarını KDV ekleyerek hesaplayan fonksiyon.",
            practicalTask = "Bir sayının karesini alan kare_al(sayi) fonksiyonunu yazın.",
            starterPlaygroundCode = "def kare_al(sayi):\n    # return ile karesini döndürün:\n    pass\n\nprint(kare_al(4))",
            miniQuestion = MiniQuestion(
                id = "py_q_3",
                question = "Python'da bir fonksiyonun dışarıya sonuç üretip geri göndermesi için hangi kelime kullanılır?",
                options = listOf("return", "send", "give", "output"),
                correctIndex = 0,
                explanation = "Fonksiyondan sonuç almak için 'return' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_3",
                lessonId = "py_3",
                title = "Metin Tekrarlayıcı",
                instructions = "Verilen metni adet kadar yan yana tekrarlayan tekrar_et(metin, adet) fonksiyonunu yazın.",
                exampleInput = "tekrar_et('Kod', 3)",
                exampleOutput = "'KodKodKod'",
                starterCode = "def tekrar_et(metin, adet):\n    # Kodunu yaz:\n    return ''",
                solutionCode = "def tekrar_et(metin, adet):\n    return metin * adet",
                hints = listOf("Python'da metin * adet işlemi metni çoğaltır."),
                testCases = listOf(
                    TestCase("tekrar_et('A', 3)", "AAA", "3 kez A"),
                    TestCase("tekrar_et('Hi', 2)", "HiHi", "2 kez Hi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_3_1",
                    lessonId = "py_3",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Python'da yeni bir fonksiyon tanımlamak için hangi kelime kullanılır?",
                    options = listOf("def", "func", "function", "fn"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Python'da fonksiyonlar 'def' (define) ile başlar.",
                    explanationWrong = "Fonksiyon tanımı 'def' ile yapılır.",
                    reviewTopic = "Python Fonksiyonlar"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "def neyin kısaltmasıdır?",
                    answer = "'Define' (Tanımla) kelimesinin kısaltmasıdır."
                )
            ),
            completionCriteria = listOf(
                "def ile fonksiyon yazabilmek",
                "return ile sonuç döndürebilmek",
                "Varsayılan parametreleri kullanabilmek"
            )
        ),

        // ==========================================
        // DERS 4: LİSTELER, SÖZLÜKLER VE KÜMELER
        // ==========================================
        Lesson(
            id = "py_4",
            courseId = "py",
            sectionId = "py_sec_2",
            title = "Veri Yapıları: Listeler, Sözlükler (Dict) ve Kümeler",
            shortDesc = "Bilgileri listelerde sıralama ve sözlüklerde anahtarlarla saklama teknikleri.",
            level = CourseLevel.BEGINNER,
            order = 4,
            isPremium = true,
            learningObjectives = listOf(
                "List (Liste) ile sıralı veriler tutmak ve eleman ekleyip/silmek",
                "Dict (Sözlük) ile anahtar-değer (Key-Value) ikilileri kurmak",
                "Set (Küme) ile benzersiz elemanlar yönetmek",
                "Tuple (Demet) ile değiştirilemez listeler oluşturmak"
            ),
            prerequisites = listOf("Fonksiyonlar"),
            subtopics = listOf("Listeler (List)", "Sözlükler (Dict)", "Kümeler (Set)", "Demetler (Tuple)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Listeler ([...])",
                    body = "Listeler köşeli parantez `[]` ile tanımlanır. İlk elemanın indeksi `0`'dır.",
                    codeSnippet = "sehirler = ['İstanbul', 'Ankara', 'İzmir']\n\nprint(sehirler[0]) # İstanbul\nsehirler.append('Bursa') # Sona yeni şehir ekler\nprint(f'Toplam şehir: {len(sehirler)}') # 4"
                ),
                LessonContentBlock(
                    subtitle = "2. Sözlükler ({key: value})",
                    body = "Tıpkı bir sözlük veya telefon rehberi gibi her bilgiye bir etiket veririz.",
                    codeSnippet = "ogrenci = {\n    'ad': 'Zeynep',\n    'yas': 21,\n    'bolum': 'Bilgisayar'\n}\n\nprint(ogrenci['ad']) # Zeynep\nogrenci['not'] = 95 # Yeni bilgi ekleme"
                ),
                LessonContentBlock(
                    subtitle = "3. Set (Küme) ve Tuple (Demet)",
                    body = "• **Set (`{1, 2, 3}`):** Tekrar eden elemanları otomatik siler.\n• **Tuple (`(1, 2, 3)`):** Tanımlandıktan sonra elemanları değiştirilemeyen güvenli listedir.",
                    codeSnippet = "sayilar = {1, 2, 2, 3, 3} # Set\nprint(sayilar) # {1, 2, 3}\n\nkoordinat = (41.0082, 28.9784) # Tuple (Enlem, Boylam)"
                )
            ),
            codeExample = "kullanici = {'isim': 'Mert', 'roller': ['admin', 'yazar']}\nprint(f'{kullanici[\"isim\"]} Rolleri: {kullanici[\"roller\"]}')",
            codeExplanation = "Sözlük içinde liste saklanarak esnek veri yapıları oluşturuldu.",
            realWorldExample = "İnternetten çekilen hava durumu veya kullanıcı profili JSON verileri Python sözlüklerine (dict) dönüştürülür.",
            practicalTask = "Bir öğrenci sözlüğü oluşturup içine ad, yas ve dersler listesi ekleyin.",
            starterPlaygroundCode = "ogrenci = {\n    'ad': 'Ali',\n    'notlar': [80, 90, 100]\n}\nprint(ogrenci)",
            miniQuestion = MiniQuestion(
                id = "py_q_4",
                question = "Python'da bir listeye yeni bir eleman eklemek için hangi fonksiyon kullanılır?",
                options = listOf("append()", "add()", "push()", "insert_end()"),
                correctIndex = 0,
                explanation = "Listelerin sonuna eleman eklemek için append() metodu kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_4",
                lessonId = "py_4",
                title = "Liste Eleman Sayısı ve İlk Eleman",
                instructions = "Verilen listenin ilk elemanını ve toplam eleman sayısını f-string ile 'İlk: X, Toplam: Y' şeklinde döndüren liste_bilgisi(liste) fonksiyonunu yazın.",
                exampleInput = "liste_bilgisi(['Elma', 'Armut'])",
                exampleOutput = "'İlk: Elma, Toplam: 2'",
                starterCode = "def liste_bilgisi(liste):\n    # Kodunu yaz:\n    return ''",
                solutionCode = "def liste_bilgisi(liste):\n    return f'İlk: {liste[0]}, Toplam: {len(liste)}'",
                hints = listOf("liste[0] ve len(liste) ifadelerini kullanın."),
                testCases = listOf(
                    TestCase("liste_bilgisi(['A', 'B', 'C'])", "İlk: A, Toplam: 3", "3 elemanlı liste")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_4_1",
                    lessonId = "py_4",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "İçine eklenen mükerrer (çift) elemanları otomatik olarak tekilleştiren veri yapısı hangisidir?",
                    options = listOf("set (Küme)", "list (Liste)", "dict (Sözlük)", "tuple (Demet)"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Set (Küme) benzersiz elemanlar tutar.",
                    explanationWrong = "Kümeler (set) mükerrer kayıt tutmaz.",
                    reviewTopic = "Python Kümeler"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "List ile Tuple arasındaki fark nedir?",
                    answer = "List'e sonradan eleman eklenebilir veya silinebilir (mutable). Tuple ise sabittir, bir kez tanımlandıktan sonra değiştirilemez (immutable)."
                )
            ),
            completionCriteria = listOf(
                "List ve Dict oluşturup veriye erişebilmek",
                "append() ile eleman ekleyebilmek",
                "len() ile uzunluk ölçebilmek"
            )
        ),

        // ==========================================
        // DERS 5: LIST COMPREHENSIONS
        // ==========================================
        Lesson(
            id = "py_5",
            courseId = "py",
            sectionId = "py_sec_2",
            title = "Pratik Listeler: List Comprehensions",
            shortDesc = "3-4 satırlık döngü ve filtrelemeleri tek bir satırda yazma sanatı.",
            level = CourseLevel.BEGINNER,
            order = 5,
            isPremium = true,
            learningObjectives = listOf(
                "List Comprehension sözdizimini kavramak",
                "Filtreleme ve matematiksel işlemleri tek satırda birleştirmek",
                "Daha temiz, kısa ve okunabilir Python kodu yazmak"
            ),
            prerequisites = listOf("Listeler ve Döngüler"),
            subtopics = listOf("Comprehension Nedir?", "Filtreleme Eklemek (if)", "Sözlük Comprehension"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Tek Satırda Liste Üretme",
                    body = "Normalde bir listenin elemanlarının karesini almak için boş bir liste açıp for döngüsüyle `append` yapardık. List Comprehension ile bunu tek satırda hallederiz!",
                    codeSnippet = "# Eski yöntem (4 satır):\nkareler = []\nfor x in range(1, 6):\n    kareler.append(x * x)\n\n# Yeni süper yöntem (Tek satır!):\nkareler_pratik = [x * x for x in range(1, 6)]\nprint(kareler_pratik) # [1, 4, 9, 16, 25]"
                ),
                LessonContentBlock(
                    subtitle = "2. Şartlı Filtreleme (if Eklemek)",
                    body = "Sadece çift sayıların karesini almak istersek sonuna basitçe `if` ekleriz.",
                    codeSnippet = "sayilar = [1, 2, 3, 4, 5, 6]\n# Sadece çift olanları seç:\ncift_kareler = [x * x for x in sayilar if x % 2 == 0]\nprint(cift_kareler) # [4, 16, 36]"
                )
            ),
            codeExample = "isimler = ['ali', 'ayşe', 'mehmet']\nbuyuk_isimler = [isim.upper() for isim in isimler]\nprint(buyuk_isimler) # ['ALI', 'AYŞE', 'MEHMET']",
            codeExplanation = "Tüm isimler tek satırlık döngüyle büyük harfe çevrildi.",
            realWorldExample = "Veri bilimi ve yapay zekada milyonlarca veriyi hızlıca temizlemek için kullanılır.",
            practicalTask = "1'den 10'a kadar olan sayılardan sadece tek olanları listeleyen bir comprehension yazın.",
            starterPlaygroundCode = "tekler = [x for x in range(1, 11) if x % 2 != 0]\nprint(tekler)",
            miniQuestion = MiniQuestion(
                id = "py_q_5",
                question = "[x * 2 for x in [1, 2, 3]] ifadesinin sonucu ne olur?",
                options = listOf("[2, 4, 6]", "[1, 2, 3, 1, 2, 3]", "[2, 2, 2]", "[1, 4, 9]"),
                correctIndex = 0,
                explanation = "Her eleman 2 ile çarpılarak yeni liste üretilir: [2, 4, 6]."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_5",
                lessonId = "py_5",
                title = "Pozitif Sayıların İki Katı",
                instructions = "Verilen sayı listesindeki sadece pozitif (> 0) sayıları seçip iki katını liste olarak döndüren pozitif_katla(sayilar) fonksiyonunu tek satır comprehension ile yazın.",
                exampleInput = "[-2, 5, -1, 3]",
                exampleOutput = "[10, 6]",
                starterCode = "def pozitif_katla(sayilar):\n    # Tek satırda yazın:\n    return []",
                solutionCode = "def pozitif_katla(sayilar):\n    return [x * 2 for x in sayilar if x > 0]",
                hints = listOf("[x * 2 for x in sayilar if x > 0] kalıbını kullanın."),
                testCases = listOf(
                    TestCase("pozitif_katla([-2, 5, -1, 3])", "[10, 6]", "Pozitifleri katla")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_5_1",
                    lessonId = "py_5",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "List comprehension kullanımının en büyük avantajı nedir?",
                    options = listOf("Daha kısa, temiz ve hızlı okunabilen liste oluşturması", "Sadece sayılarla çalışması", "Bilgisayarı kapatması", "Hata vermemesi"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Kod satırlarını kısaltır ve Pythonik temizlik sağlar.",
                    explanationWrong = "Kodun okunabilirliğini ve yazım hızını artırır.",
                    reviewTopic = "Python Comprehensions"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Comprehension ile Sözlük de üretilebilir mi?",
                    answer = "Evet! `{k: v for ...}` şeklinde Sözlük Comprehension da yapılabilir."
                )
            ),
            completionCriteria = listOf(
                "List Comprehension kalıbını [x for x in ...] kavramak",
                "if şartı ekleyerek filtreleme yapabilmek"
            )
        ),

        // ==========================================
        // DERS 6: HATA YAKALAMA (try-except)
        // ==========================================
        Lesson(
            id = "py_6",
            courseId = "py",
            sectionId = "py_sec_3",
            title = "Hata Yakalama (try-except): Çökmeyen Programlar",
            shortDesc = "Beklenmedik durumlarda programın kapanmasını önleyin ve kullanıcıya yol gösterin.",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true,
            learningObjectives = listOf(
                "try ve except blokları ile hataları yakalamak",
                "finally ile her halükarda çalışan temizlik kodları yazmak",
                "raise ile bilerek özel hata fırlatmak"
            ),
            prerequisites = listOf("Fonksiyonlar ve Veri Yapıları"),
            subtopics = listOf("Hata Nedir?", "try-except Blokları", "finally Bloğu", "raise ile Hata Fırlatma"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Hataları Güvenle Karşılama (try-except)",
                    body = "Kullanıcı sayı yerine harf girebilir veya olmayan bir dosyayı açmaya çalışabilir. Programın aniden çökmemesi için tehlikeli satırları `try` içine alır, hata olursa `except` ile yakalarız.",
                    codeSnippet = "try:\n    sayi = int('abc') # 'abc' sayıya çevrilemez!\n    print(sayi)\nexcept ValueError as e:\n    print(f'Hata yakalandı ama program çökmedi: {e}')"
                ),
                LessonContentBlock(
                    subtitle = "2. finally: Her Zaman Çalışan Blok",
                    body = "`finally` bloğu, hata çıksa da çıkmasa da en sonda mutlaka çalıştırılır. Dosya veya veritabanı bağlantılarını kapatmak için çok uygundur.",
                    codeSnippet = "try:\n    sonuc = 10 / 2\nexcept ZeroDivisionError:\n    print('Sıfıra bölünemez!')\nfinally:\n    print('İşlem sonlandırıldı.')"
                )
            ),
            codeExample = "def guvenli_bolme(a, b):\n    try:\n        return a / b\n    except ZeroDivisionError:\n        return 'Hata: Sıfıra bölme yapılamaz!'\n\nprint(guvenli_bolme(10, 0))",
            codeExplanation = "Sıfıra bölme hatası yakalanarak dostça bir hata mesajı döndürüldü.",
            realWorldExample = "Web sunucusu veritabanına bağlanamadığında sunucunun kapanmasını engelleyip 'Lütfen biraz sonra tekrar deneyin' mesajı göstermek.",
            practicalTask = "Kullanıcıdan gelen bir metni int'e çeviren ve hata olursa -1 döndüren fonksiyon yazın.",
            starterPlaygroundCode = "def sayiya_cevir(metin):\n    try:\n        return int(metin)\n    except:\n        return -1",
            miniQuestion = MiniQuestion(
                id = "py_q_6",
                question = "Python'da hata olsa da olmasa da kesinlikle çalışan blok hangisidir?",
                options = listOf("finally", "except", "else", "catch"),
                correctIndex = 0,
                explanation = "finally bloğu her şartta çalıştırılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_6",
                lessonId = "py_6",
                title = "Güvenli Sayı Çevirici",
                instructions = "Verilen metni sayıya çevirmeye çalışan, başarısız olursa -1 döndüren guvenli_int(deger) fonksiyonunu yazın.",
                exampleInput = "guvenli_int('50')",
                exampleOutput = "50",
                starterCode = "def guvenli_int(deger):\n    # try-except ile yazın:\n    return 0",
                solutionCode = "def guvenli_int(deger):\n    try:\n        return int(deger)\n    except:\n        return -1",
                hints = listOf("try { return int(deger) } except { return -1 } kullanın."),
                testCases = listOf(
                    TestCase("guvenli_int('42')", "42", "Geçerli"),
                    TestCase("guvenli_int('xyz')", "-1", "Geçersiz")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_6_1",
                    lessonId = "py_6",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Python'da programcının bilerek bir hata fırlatması için hangi kelime kullanılır?",
                    options = listOf("raise", "throw", "error", "catch"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Python'da hata fırlatmak için 'raise Exception(...)' kullanılır.",
                    explanationWrong = "Hata fırlatma 'raise' kelimesiyle yapılır.",
                    reviewTopic = "Python Hata Yönetimi"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Her şeyi çıplak except: ile yakalamak doğru mudur?",
                    answer = "Hayır! Mümkünse yakalamak istediğiniz hatanın türünü belirtmek (örn: except ValueError:) en iyi uygulamadır."
                )
            ),
            completionCriteria = listOf(
                "try-except yapısını öğrenmek",
                "finally bloğunun amacını kavramak"
            )
        ),

        // ==========================================
        // DERS 7: SINIFLAR VE NESNELER (OOP)
        // ==========================================
        Lesson(
            id = "py_7",
            courseId = "py",
            sectionId = "py_sec_3",
            title = "Sınıflar (Class) ve self Mantığı: Nesne Dünyası",
            shortDesc = "Kendi özel veri tiplerinizi üretin: Sınıflar, __init__ kurucusu ve self referansı.",
            level = CourseLevel.INTERMEDIATE,
            order = 7,
            isPremium = true,
            learningObjectives = listOf(
                "Class (Sınıf) ve Object (Nesne) mantığını kavramak",
                "__init__ metodu ile nesne özelliklerini başlatmak",
                "self kelimesinin 'bu nesnenin kendisi' anlamına geldiğini öğrenmek",
                "Sınıf içine yetenekler (Metotlar) eklemek"
            ),
            prerequisites = listOf("Fonksiyonlar ve Sözlükler"),
            subtopics = listOf("Sınıf Nedir? (Kalıp)", "__init__ ve Kurucu Metot", "self Nedir?", "Metotlar"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Sınıf ve Nesne (Araba Fabrikası)",
                    body = "Sınıf bir araba krokisidir, nesne ise fabrikadan çıkan gerçek arabadır.\n\n• `__init__`: Nesne ilk üretildiğinde çalışan başlangıç fonksiyonudur.\n• `self`: O anda oluşturulan nesnenin kendisini temsil eder.",
                    codeSnippet = "class Araba:\n    def __init__(self, marka, model_yili):\n        self.marka = marka\n        self.model_yili = model_yili\n        \n    def korna_cal(self):\n        print(f'{self.marka}: Düt düüt! 🚗')\n\n# Nesne üretelim:\narabam = Araba('Toyota', 2022)\narabam.korna_cal() # Toyota: Düt düüt!"
                )
            ),
            codeExample = "class Oyuncu:\n    def __init__(self, isim, skor=0):\n        self.isim = isim\n        self.skor = skor\n        \n    def puan_kazan(self, puan):\n        self.skor += puan\n\noyuncu1 = Oyuncu('Ahmet')\noyuncu1.puan_kazan(50)\nprint(f'{oyuncu1.isim} Skoru: {oyuncu1.skor}')",
            codeExplanation = "Oyuncu sınıfı tanımlandı ve puan_kazan metodu ile skoru güncellendi.",
            realWorldExample = "Oyun programlamada ekrandaki her canavar, oyuncu veya eşya birer sınıf nesnesidir.",
            practicalTask = "Kitap adında bir sınıf açıp baslik ve yazar özelliklerini __init__ ile doldurun.",
            starterPlaygroundCode = "class Kitap:\n    def __init__(self, baslik, yazar):\n        self.baslik = baslik\n        self.yazar = yazar",
            miniQuestion = MiniQuestion(
                id = "py_q_7",
                question = "Python'da bir sınıfın kurucu (başlangıç) metodunun adı nedir?",
                options = listOf("__init__", "constructor", "create", "start"),
                correctIndex = 0,
                explanation = "Python'da nesne oluşturulurken çalışan ilk kurucu metot __init__'tir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_7",
                lessonId = "py_7",
                title = "Kişi Kartı Sınıfı",
                instructions = "ad ve yas alanlarına sahip Kisi sınıfını yazın ve 'Ad: X, Yaş: Y' metnini döndüren bilgi() metodunu ekleyin.",
                exampleInput = "Kisi('Mert', 25).bilgi()",
                exampleOutput = "'Ad: Mert, Yaş: 25'",
                starterCode = "class Kisi:\n    def __init__(self, ad, yas):\n        self.ad = ad\n        self.yas = yas\n        \n    def bilgi(self):\n        # Kodunu yaz:\n        return ''",
                solutionCode = "class Kisi:\n    def __init__(self, ad, yas):\n        self.ad = ad\n        self.yas = yas\n        \n    def bilgi(self):\n        return f'Ad: {self.ad}, Yaş: {self.yas}'",
                hints = listOf("f'Ad: {self.ad}, Yaş: {self.yas}' döndürün."),
                testCases = listOf(
                    TestCase("Kisi('Mert', 25).bilgi()", "Ad: Mert, Yaş: 25", "Kisi bilgisi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_7_1",
                    lessonId = "py_7",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Sınıf içindeki metotların ilk parametresi olarak yazılan 'self' neyi ifade eder?",
                    options = listOf("O metodun ait olduğu nesnenin kendisini", "Python'ın kendisini", "Kütüphane adını", "İlk değişkeni"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! 'self', o an işlem yapılan nesnenin kendisine işaret eder.",
                    explanationWrong = "self o anki nesne örneğidir.",
                    reviewTopic = "Python OOP"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "self yazmak zorunlu mudur?",
                    answer = "Evet, Python nesne metotlarında ilk parametre olarak her zaman nesnenin kendisini (self) bekler."
                )
            ),
            completionCriteria = listOf(
                "class ve __init__ ile nesne kurabilmek",
                "self ile nesne özelliklerine erişebilmek"
            )
        ),

        // ==========================================
        // DERS 8: KALITIM VE SÜPER METOTLAR
        // ==========================================
        Lesson(
            id = "py_8",
            courseId = "py",
            sectionId = "py_sec_3",
            title = "Kalıtım (Inheritance) ve Sihirli Metotlar (__str__)",
            shortDesc = "Üst sınıftan özellikleri miras alma ve print(nesne) yazıldığında güzel çıktı alma sırları.",
            level = CourseLevel.INTERMEDIATE,
            order = 8,
            isPremium = true,
            learningObjectives = listOf(
                "Kalıtım ile ortak kodları tek üst sınıfta toplamak",
                "super() ile üst sınıfın kurucusunu çağırmak",
                "__str__ sihirli metodu ile nesneyi metne dönüştürmek"
            ),
            prerequisites = listOf("Sınıflar ve Nesneler"),
            subtopics = listOf("Kalıtım (Inheritance)", "super() Kullanımı", "Sihirli Metotlar (__str__, __len__)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Kalıtım: Özellikleri Miras Alma",
                    body = "Bir `Hayvan` sınıfımız varsa, `Kopek` sınıfı bu sınıfı miras alarak onun tüm özelliklerine otomatik sahip olur.",
                    codeSnippet = "class Hayvan:\n    def __init__(self, isim):\n        self.isim = isim\n        \n    def ses_cikar(self):\n        print('Genel bir ses...')\n\nclass Kopek(Hayvan): # Hayvan'dan miras aldı\n    def ses_cikar(self):\n        print(f'{self.isim}: Hav hav! 🐶')"
                ),
                LessonContentBlock(
                    subtitle = "2. Sihirli Metot: __str__",
                    body = "Bir nesneyi `print(nesne)` ile ekrana bastığınızda anlamsız bir adres yerine şık bir metin görmek için `__str__` metodunu yazarız.",
                    codeSnippet = "class Kitap:\n    def __init__(self, baslik, yazar):\n        self.baslik = baslik\n        self.yazar = yazar\n        \n    def __str__(self):\n        return f'{self.baslik} - {self.yazar}'\n\nkitap = Kitap('1984', 'George Orwell')\nprint(kitap) # 1984 - George Orwell"
                )
            ),
            codeExample = "class Kare:\n    def __init__(self, kenar):\n        self.kenar = kenar\n    def __str__(self):\n        return f'Kenarı {self.kenar} olan Kare'\n\nprint(Kare(5))",
            codeExplanation = "__str__ metodu sayesinde nesne ekrana doğrudan anlaşılır bir metin olarak yazdırıldı.",
            realWorldExample = "Django web çerçevesinde veritabanı modellerinin panelde güzel gözükmesi için __str__ tanımlanır.",
            practicalTask = "Kendi oluşturduğunuz bir sınıfa __str__ metodu ekleyerek ekrana yazdırın.",
            starterPlaygroundCode = "class Urun:\n    def __init__(self, ad, fiyat):\n        self.ad = ad\n        self.fiyat = fiyat\n    def __str__(self):\n        return f'{self.ad}: {self.fiyat} TL'",
            miniQuestion = MiniQuestion(
                id = "py_q_8",
                question = "Python'da bir nesne print() ile yazdırıldığında hangi sihirli metot devreye girer?",
                options = listOf("__str__", "__print__", "__show__", "__text__"),
                correctIndex = 0,
                explanation = "print(nesne) çağrıldığında nesnenin __str__ metodu çalışır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_8",
                lessonId = "py_8",
                title = "Şık Ürün Yazdırıcı",
                instructions = "ad ve fiyat alanlarına sahip Urun sınıfını yazın ve print(urun) yapıldığında 'X - Y TL' döndüren __str__ metodunu ekleyin.",
                exampleInput = "str(Urun('Kahve', 45))",
                exampleOutput = "'Kahve - 45 TL'",
                starterCode = "class Urun:\n    def __init__(self, ad, fiyat):\n        self.ad = ad\n        self.fiyat = fiyat\n        \n    def __str__(self):\n        # Kodunu yaz:\n        return ''",
                solutionCode = "class Urun:\n    def __init__(self, ad, fiyat):\n        self.ad = ad\n        self.fiyat = fiyat\n        \n    def __str__(self):\n        return f'{self.ad} - {self.fiyat} TL'",
                hints = listOf("f'{self.ad} - {self.fiyat} TL' döndürün."),
                testCases = listOf(
                    TestCase("str(Urun('Kahve', 45))", "Kahve - 45 TL", "Ürün str testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_8_1",
                    lessonId = "py_8",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Alt sınıfın üst sınıfa ait kurucu metodu çağırması için hangi fonksiyon kullanılır?",
                    options = listOf("super()", "parent()", "base()", "upper()"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! super().__init__(...) ile üst sınıf kurucusu tetiklenir.",
                    explanationWrong = "Üst sınıf için super() kullanılır.",
                    reviewTopic = "Python Kalıtım"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Neden dunder (çift alt çizgili __) metotlar denir?",
                    answer = "'Double Underscore' (Çift Alt Çizgi) ifadesinin kısaltmasıdır (__init__, __str__ gibi)."
                )
            ),
            completionCriteria = listOf(
                "Kalıtım (Inheritance) mantığını kavramak",
                "__str__ ile nesneyi metne dökebilmek"
            )
        ),

        // ==========================================
        // DERS 9: DEKORATÖRLER (@decorator)
        // ==========================================
        Lesson(
            id = "py_9",
            courseId = "py",
            sectionId = "py_sec_4",
            title = "Dekoratörler (@): Fonksiyonlara Süper Güçler Katma",
            shortDesc = "Mevcut fonksiyonun koduna dokunmadan ona loglama, yetki kontrolü veya süre ölçme gücü katın.",
            level = CourseLevel.INTERMEDIATE,
            order = 9,
            isPremium = true,
            learningObjectives = listOf(
                "Dekoratör (@) işaretinin ne anlama geldiğini anlamak",
                "Fonksiyonların içine fonksiyon yerleştirme mantığını kavramak",
                "Basit bir dekoratör yazıp kullanmak"
            ),
            prerequisites = listOf("Fonksiyonlar ve Sınıflar"),
            subtopics = listOf("Dekoratör Nedir? (Hediye Paketi)", "@ İşareti ile Kullanım", "Süre ve Log Dekoratörleri"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Dekoratör Nedir? (Hediye Paketi)",
                    body = "Bir fonksiyonu bir hediye kutusu gibi düşünün. Dekoratör, kutunun içine dokunmadan dışına süslü bir ambalaj kağıdı ve kurdele sarar. Yani fonksiyon çalışmadan hemen önce ve hemen sonra ek işler yapmamızı sağlar.",
                    codeSnippet = "def suslu_yaz(fonk):\n    def sarici():\n        print('✨ --- İŞLEM BAŞLADI --- ✨')\n        fonk()\n        print('✨ --- İŞLEM BİTTİ --- ✨')\n    return sarici\n\n@suslu_yaz\ndef selam():\n    print('Selam Kod Akademi!')\n\nselam()"
                )
            ),
            codeExample = "def buyuk_harf_yap(fonk):\n    def sarici(isim):\n        return fonk(isim).upper()\n    return sarici\n\n@buyuk_harf_yap\ndef karsila(ad):\n    return f'hoş geldin {ad}'\n\nprint(karsila('ahmet')) # HOŞ GELDIN AHMET",
            codeExplanation = "Dekoratör karsila fonksiyonunun sonucunu otomatik olarak büyük harfe dönüştürdü.",
            realWorldExample = "Web sitelerinde '@giris_gerekli' dekoratörüyle kullanıcının giriş yapıp yapmadığı kontrol edilir.",
            practicalTask = "Bir fonksiyon çalışmadan önce 'Hazırlanıyor...' yazdıran basit bir dekoratör tanımlayın.",
            starterPlaygroundCode = "def bildirim(fonk):\n    def sarici():\n        print('Hazırlanıyor...')\n        fonk()\n    return sarici",
            miniQuestion = MiniQuestion(
                id = "py_q_9",
                question = "Python'da bir fonksiyona dekoratör uygulamak için fonksiyonun üst satırına hangi işaret konur?",
                options = listOf("@", "#", "$", "&"),
                correctIndex = 0,
                explanation = "Dekoratörler '@dekorator_adi' şeklinde uygulanır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_9",
                lessonId = "py_9",
                title = "Dekoratör ile Çıktıyı Selamla",
                instructions = "Gelen metin sonucunun başına 'Selam: ' ekleyen selam_ekle dekoratörünü yazın.",
                exampleInput = "@selam_ekle def test(): return 'Dünya'",
                exampleOutput = "'Selam: Dünya'",
                starterCode = "def selam_ekle(fonk):\n    def sarici():\n        # Kodunu yaz:\n        return ''\n    return sarici",
                solutionCode = "def selam_ekle(fonk):\n    def sarici():\n        return f'Selam: {fonk()}'\n    return sarici",
                hints = listOf("f'Selam: {fonk()}' döndürün."),
                testCases = listOf(
                    TestCase("selam_ekle(lambda: 'Dünya')()", "Selam: Dünya", "Dekoratör testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_9_1",
                    lessonId = "py_9",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Dekoratörlerin temel amacı nedir?",
                    options = listOf("Mevcut fonksiyonun kodunu değiştirmeden ona ek davranışlar kazandırmak", "Sadece sayıları toplamak", "Değişkenleri silmek", "Python'ı hızlandırmak"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Dekoratörler fonksiyonları sararak yeni yetenekler katar.",
                    explanationWrong = "Dekoratör fonksiyonları sarıp zenginleştirir.",
                    reviewTopic = "Python Dekoratörler"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Dekoratörler nerelerde çok kullanılır?",
                    answer = "Flask/FastAPI web rotalarında, oturum kontrollerinde ve loglama işlemlerinde standarttır."
                )
            ),
            completionCriteria = listOf(
                "Dekoratör (@) mantığını kavramak",
                "Basit bir sarıcı (wrapper) fonksiyon yazabilmek"
            )
        ),

        // ==========================================
        // DERS 10: JENERATÖRLER (yield)
        // ==========================================
        Lesson(
            id = "py_10",
            courseId = "py",
            sectionId = "py_sec_4",
            title = "Jeneratörler (yield): Hafızayı Doldurmayan Akıllı Sayaçlar",
            shortDesc = "10 milyon sayıyı hafızaya yükleyip bilgisayarı dondurmak yerine ihtiyaç anında tek tek üreten yield gücü.",
            level = CourseLevel.ADVANCED,
            order = 10,
            isPremium = true,
            learningObjectives = listOf(
                "return ile yield arasındaki farkı anlamak",
                "Hafıza dostu veri üretimi (Lazy Evaluation) mantığını kavramak",
                "Kendi jeneratör fonksiyonunuzu yazmak"
            ),
            prerequisites = listOf("Fonksiyonlar ve Döngüler"),
            subtopics = listOf("Neden Jeneratör?", "yield Nedir?", "next() ile Sıradaki Elemanı Çekme"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. yield: Sırayla ve Lazım Oldukça Üret!",
                    body = "Eğer 1 milyon elemanlı bir liste oluşturursanız bilgisayarın tüm RAM hafızası dolar. Ama `yield` kullanan bir jeneratör yazarsanız, sadece siz `sıradakini ver` dediğinizde 1 tane üretir, hafızada yer kaplamaz!",
                    codeSnippet = "def sayi_sayici(limit):\n    sayi = 1\n    while sayi <= limit:\n        yield sayi # Sıradaki sayıyı verip duraklar\n        sayi += 1\n\n# Jeneratörü kullanalım:\nfor s in sayi_sayici(3):\n    print(f'Sayı: {s}') # 1, 2, 3"
                )
            ),
            codeExample = "def cift_sayilar(n):\n    for i in range(0, n, 2):\n        yield i\n\nprint(list(cift_sayilar(8))) # [0, 2, 4, 6]",
            codeExplanation = "yield ile adım adım üretilen sayılar list() ile listeye dönüştürüldü.",
            realWorldExample = "Gigabaytlarca büyüklükteki büyük veri dosyalarını satır satır okurken bilgisayarın çökmesini engeller.",
            practicalTask = "1'den n'e kadar sayıların karesini yield ile fırlatan bir jeneratör yazın.",
            starterPlaygroundCode = "def kareler(n):\n    for i in range(1, n + 1):\n        yield i * i",
            miniQuestion = MiniQuestion(
                id = "py_q_10",
                question = "Bir fonksiyonun jeneratör (üretici) olması için değer döndürürken hangi kelime kullanılır?",
                options = listOf("yield", "return", "generate", "emit"),
                correctIndex = 0,
                explanation = "Jeneratör fonksiyonlarında veri üretmek için 'yield' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_10",
                lessonId = "py_10",
                title = "Geri Sayım Jeneratörü",
                instructions = "n'den 1'e kadar geriye doğru sayan ve yield ile sayıları veren geri_say(n) fonksiyonunu yazın.",
                exampleInput = "list(geri_say(3))",
                exampleOutput = "[3, 2, 1]",
                starterCode = "def geri_say(n):\n    # yield ile yazın:\n    pass",
                solutionCode = "def geri_say(n):\n    for i in range(n, 0, -1):\n        yield i",
                hints = listOf("range(n, 0, -1) ve yield i kullanın."),
                testCases = listOf(
                    TestCase("list(geri_say(3))", "[3, 2, 1]", "Geri sayım")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_10_1",
                    lessonId = "py_10",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "yield ile return arasındaki en belirgin fark nedir?",
                    options = listOf("return fonksiyonu tamamen sonlandırır, yield ise kaldığı yeri hatırlayarak duraklar", "yield daha yavaştır", "return sadece sayılarda çalışır", "Fark yoktur"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! yield fonksiyonun durumunu korur ve bir sonraki çağrıda kaldığı yerden devam eder.",
                    explanationWrong = "yield kaldığı yeri hatırlar.",
                    reviewTopic = "Python Jeneratörler"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Jeneratörler belleği nasıl korur?",
                    answer = "Tüm listeyi bellekte saklamaz; her çağrıldığında sadece 1 eleman üretip unutur."
                )
            ),
            completionCriteria = listOf(
                "yield mantığını kavramak",
                "Jeneratör döngüsü kurabilmek"
            )
        ),

        // ==========================================
        // DERS 11: ASENKRON PYTHON (async / await)
        // ==========================================
        Lesson(
            id = "py_11",
            courseId = "py",
            sectionId = "py_sec_5",
            title = "Asenkron Python: async ve await ile Hızlı Programlar",
            shortDesc = "İnternetten 10 farklı siteden veri çekerken tek tek beklemek yerine hepsini aynı anda başlatın.",
            level = CourseLevel.ADVANCED,
            order = 11,
            isPremium = true,
            learningObjectives = listOf(
                "Asenkron çalışmanın ne olduğunu ve faydalarını anlamak",
                "async def ve await sözdizimini öğrenmek",
                "asyncio kütüphanesi ile eşzamanlı işler yönetmek"
            ),
            prerequisites = listOf("Fonksiyonlar ve Hata Yönetimi"),
            subtopics = listOf("Senkron vs Asenkron", "async def ve await", "asyncio.gather ile Birlikte Çalıştırma"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Asenkron Nedir? (Aynı Anda Çay Demleme)",
                    body = "Sabah kahvaltısı hazırlarken çayın kaynamasını beklerken heykel gibi durup yumurtaları kırmamazlık etmezsiniz; çay demlenirken bir yandan yumurtayı pişirirsiniz.\n\nİşte internetten fotoğraf indirirken veya veritabanına bağlanırken uygulamanın beklemede donmaması için `async` ve `await` kullanırız.",
                    codeSnippet = "import asyncio\n\nasync def veri_cek():\n    print('İstek gönderildi...')\n    await asyncio.sleep(1) # 1 saniye sahte bekleme\n    return 'Kullanıcı Profili 👤'\n\n# Çalıştırmak için:\n# asyncio.run(veri_cek())"
                )
            ),
            codeExample = "import asyncio\n\nasync def selam():\n    await asyncio.sleep(0.1)\n    return 'Asenkron Selam!'\n\n# print(asyncio.run(selam()))",
            codeExplanation = "async def ile tanımlanan fonksiyon await ile beklenir.",
            realWorldExample = "FastAPI web framework'ü, saniyede yüz binlerce isteği asenkron (async/await) mimarisi sayesinde karşılar.",
            practicalTask = "async def kullanarak 1 saniye bekleyip 'Tamamlandı' döndüren bir fonksiyon yazın.",
            starterPlaygroundCode = "import asyncio\n\nasync def gorev():\n    await asyncio.sleep(0.5)\n    return 'Tamamlandı'",
            miniQuestion = MiniQuestion(
                id = "py_q_11",
                question = "Python'da asenkron bir fonksiyon tanımlamak için def kelimesinin önüne ne yazılır?",
                options = listOf("async", "await", "thread", "future"),
                correctIndex = 0,
                explanation = "Asenkron fonksiyonlar 'async def' ile tanımlanır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_11",
                lessonId = "py_11",
                title = "Asenkron Selamlama",
                instructions = "async def ile yazılan ve 'Merhaba, {ad}!' metnini döndüren asenkron_selam(ad) fonksiyonunu yazın.",
                exampleInput = "asenkron_selam('Zeynep')",
                exampleOutput = "'Merhaba, Zeynep!'",
                starterCode = "async def asenkron_selam(ad):\n    # Kodunu yaz:\n    return ''",
                solutionCode = "async def asenkron_selam(ad):\n    return f'Merhaba, {ad}!'",
                hints = listOf("f'Merhaba, {ad}!' döndürün."),
                testCases = listOf(
                    TestCase("asenkron_selam('Zeynep')", "Merhaba, Zeynep!", "Asenkron test")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_11_1",
                    lessonId = "py_11",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "await anahtar kelimesi ne işe yarar?",
                    options = listOf("Zaman alan bir asenkron işlemin sonucunu programı kilitlemeden bekler", "Programı sonsuza kadar durdurur", "Değişkenleri siler", "Fonksiyonu siler"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! await, bekleme anında kontrolü başka işlere devreder.",
                    explanationWrong = "await asenkron işlemi bekler.",
                    reviewTopic = "Python AsyncIO"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "time.sleep() yerine neden asyncio.sleep() kullanıyoruz?",
                    answer = "time.sleep() tüm programı dondurur. asyncio.sleep() ise sadece o görevi bekletirken diğer görevlerin çalışmasına izin verir."
                )
            ),
            completionCriteria = listOf(
                "async def ve await mantığını kavramak",
                "Asenkron programlamanın hız avantajını bilmek"
            )
        ),

        // ==========================================
        // DERS 12: MODÜLLER VE TEMİZ KOD
        // ==========================================
        Lesson(
            id = "py_12",
            courseId = "py",
            sectionId = "py_sec_6",
            title = "Modüller ve Temiz Kod: Profesyonel Pythoncu Olmak",
            shortDesc = "Büyük projeleri modüllere bölme (import), paketler ve Python'ın altın kuralları.",
            level = CourseLevel.EXPERT,
            order = 12,
            isPremium = true,
            learningObjectives = listOf(
                "import ile hazır ve harici modülleri kullanmak",
                "Kendi Python dosyanızı modül olarak içe aktarmak",
                "PEP 8 temiz kod standartlarını kavramak"
            ),
            prerequisites = listOf("Tüm Python Konuları"),
            subtopics = listOf("Modül Nedir? (import)", "math ve random Modülleri", "PEP 8 Temiz Kod Standartları"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Hazır Süper Güçler: import",
                    body = "Her şeyi sıfırdan yazmanıza gerek yoktur. Python zengin bir kütüphane havuzuna sahiptir. `import math` veya `import random` diyerek binlerce hazır fonksiyona anında erişebilirsiniz.",
                    codeSnippet = "import math\nimport random\n\nprint(f'Karekök 16: {math.isqrt(16)}') # 4\nprint(f'Rastgele Sayı: {random.randint(1, 100)}') # 1-100 arası zar atar"
                ),
                LessonContentBlock(
                    subtitle = "2. Tebrikler! Python Yolculuğunu Tamamladınız!",
                    body = "Artık değişkenlerden veri yapılarına, nesnelerden asenkron yapılara kadar Python'ın temelini eksiksiz öğrendiniz. Şimdi yapay zeka, veri analizi veya web projeleri geliştirme zamanı! 🐍🚀"
                )
            ),
            codeExample = "import math\n\ndef hipotenus(a, b):\n    return math.sqrt(a**2 + b**2)\n\nprint(f'3-4-5 Üçgeni: {hipotenus(3, 4)}') # 5.0",
            codeExplanation = "math modülünden sqrt (karekök) kullanılarak geometri hesabı yapıldı.",
            realWorldExample = "Veri biliminde 'import pandas as pd' ve 'import numpy as np' en çok kullanılan modül çağrılarıdır.",
            practicalTask = "random modülünü import edip 1 ile 10 arasında rastgele bir sayı yazdırın.",
            starterPlaygroundCode = "import random\n# random.randint(1, 10) kullanın:\n",
            miniQuestion = MiniQuestion(
                id = "py_q_12",
                question = "Python'da harici bir kütüphaneyi veya dosyayı programa dahil etmek için hangi komut kullanılır?",
                options = listOf("import", "include", "require", "using"),
                correctIndex = 0,
                explanation = "Python'da modüller 'import' ile dahil edilir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_12",
                lessonId = "py_12",
                title = "Karekök Hesaplayıcı",
                instructions = "math modülünü kullanarak verilen sayının karekökünü tam sayı olarak döndüren karekok_bul(sayi) fonksiyonunu yazın.",
                exampleInput = "karekok_bul(25)",
                exampleOutput = "5",
                starterCode = "import math\n\ndef karekok_bul(sayi):\n    # Kodunu yaz:\n    return 0",
                solutionCode = "import math\n\ndef karekok_bul(sayi):\n    return int(math.sqrt(sayi))",
                hints = listOf("int(math.sqrt(sayi)) kullanın."),
                testCases = listOf(
                    TestCase("karekok_bul(25)", "5", "25'in karekökü"),
                    TestCase("karekok_bul(100)", "10", "100'ün karekökü")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_12_1",
                    lessonId = "py_12",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Python'ın resmi stil ve temiz kod kuralları kılavuzuna ne ad verilir?",
                    options = listOf("PEP 8", "ISO 9001", "Python Clean", "Zen Doc"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! PEP 8, Python kodlama standartları kılavuzudur.",
                    explanationWrong = "Python standartları PEP 8 olarak bilinir.",
                    reviewTopic = "Python Standartları"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Kendi yazdığım dosyayı import edebilir miyim?",
                    answer = "Evet! Örneğin 'hesap.py' adında bir dosyanız varsa, diğer dosyadan 'import hesap' diyerek içindeki tüm fonksiyonları çağırabilirsiniz."
                )
            ),
            completionCriteria = listOf(
                "import ile modül ekleyebilmek",
                "Temiz kod standartlarını öğrenmek"
            )
        )
    )
}
