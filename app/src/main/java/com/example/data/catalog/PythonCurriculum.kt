package com.example.data.catalog

import com.example.model.*

/**
 * Python Kapsamlı & Pedagojik Müfredatı (12 Adım):
 * Resmi Python dokümanları (PEP 8), StackOverflow ve Reddit r/learnpython deneyimleriyle zenginleştirilmiş,
 * teknik terimleri sade ve net bir üslupla serpiştiren eksiksiz Python eğitimi.
 */
object PythonCurriculum {

    fun getSections(): List<CourseSection> = listOf(
        CourseSection(
            id = "py_sec_1",
            courseId = "python",
            title = "Bölüm 1: Python Temelleri, Sözdizimi ve Kontrol Akışı",
            level = CourseLevel.BEGINNER,
            order = 1,
            description = "Python dünyasına giriş: Dinamik Tipler (Dynamic Typing), f-strings, Indentation (Girinti) kuralı ve akıllı döngüler.",
            learningObjectives = listOf("Dinamik tipleme ve bellek mantığını anlamak", "f-string ile performanslı metin biçimlendirmek", "if-elif-else ve range() döngülerini kavramak"),
            prerequisites = listOf("Ön bilgi gerekmez! Merak ve temel mantık yeterlidir.")
        ),
        CourseSection(
            id = "py_sec_2",
            courseId = "python",
            title = "Bölüm 2: Fonksiyonlar, Kapsam (LEGB) ve Veri Yapıları",
            level = CourseLevel.BEGINNER,
            order = 2,
            description = "Fonksiyonlar, *args/**kwargs, List, Tuple (Değişmez), Set (O(1) Arama) ve Dict mimarisi.",
            learningObjectives = listOf("LEGB Kapsam Kuralını kavramak", "Mutable vs Immutable veri yapılarını ayırt etmek", "List Comprehension ile tek satırda filtreleme yapmak"),
            prerequisites = listOf("Python Değişkenleri ve Döngüler")
        ),
        CourseSection(
            id = "py_sec_3",
            courseId = "python",
            title = "Bölüm 3: Nesne Yönelim (OOP) ve Dunder Metotlar",
            level = CourseLevel.INTERMEDIATE,
            order = 3,
            description = "Sınıflar (Class), self mantığı, __init__, __str__ ve Kalıtım (Inheritance) mekanizması.",
            learningObjectives = listOf("self referansının arka planını anlamak", "Dunder (__init__, __repr__) metotlarını kullanmak", "Kalıtım ile kod tekrarını önlemek"),
            prerequisites = listOf("Fonksiyonlar ve Sözlükler")
        ),
        CourseSection(
            id = "py_sec_4",
            courseId = "python",
            title = "Bölüm 4: İleri Düzey Python: Dekoratörler ve Jeneratörler",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            description = "@decorator deseni, Closures (Kapanışlar), yield anahtarı ve Lazy Evaluation (Tembel Değerlendirme).",
            learningObjectives = listOf("Dekoratörler ile fonksiyonları sarmalamak", "yield ile bellek dostu jeneratörler kurmak"),
            prerequisites = listOf("Fonksiyonlar ve Sınıflar")
        ),
        CourseSection(
            id = "py_sec_5",
            courseId = "python",
            title = "Bölüm 5: Asenkron Programlama (AsyncIO) ve GIL Mantığı",
            level = CourseLevel.ADVANCED,
            order = 5,
            description = "Event Loop, async/await, I/O Bound işlemler ve Python'ın Global Interpreter Lock (GIL) çalışma prensibi.",
            learningObjectives = listOf("Event loop ve coroutine ilişkisini kavramak", "GIL'in CPU vs I/O işlemlerine etkisini bilmek"),
            prerequisites = listOf("Fonksiyonlar ve Hata Yönetimi")
        ),
        CourseSection(
            id = "py_sec_6",
            courseId = "python",
            title = "Bölüm 6: Profesyonel Mimari, Context Managers ve Temiz Kod",
            level = CourseLevel.EXPERT,
            order = 6,
            description = "with deyimi (Context Managers), if __name__ == '__main__', PEP 8 standartları ve paket yönetimi.",
            learningObjectives = listOf("Context manager ile kaynak sızıntılarını önlemek", "Modüler ve profesyonel Python mimarisi kurmak"),
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
            title = "Python Mantığı: Dinamik Tipler ve f-Strings",
            shortDesc = "Dinamik Tiplendirme (Dynamic Typing), Çöp Toplayıcı (Garbage Collection) ve ultra hızlı f-string metin formatlama.",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false,
            learningObjectives = listOf(
                "print() fonksiyonunun arka planını ve separator/end parametrelerini anlamak",
                "Dinamik Tipleme (Dynamic Typing) kavramını ve temel türleri (int, float, str, bool) bilmek",
                "f-string (f'Merhaba {isim}') ile metin birleştirmede performans avantajını kavramak"
            ),
            prerequisites = listOf("Ön koşul gerekmez."),
            subtopics = listOf("Python Neden Çok Seviliyor?", "Dinamik Tipleme Mantığı", "Temel Türler (str, int, float, bool)", "f-string Formatlama"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Python'ın Felsefesi: Okunabilirlik Ön Plandadır",
                    body = "Python; 'The Zen of Python' felsefesiyle tasarlanmıştır: *'Basit, karmaşıktan iyidir; okunabilirlik önemlidir.'* Noktalı virgüller (;) veya süslü parantezler ({}) yoktur.\n\nPython **Dinamik Tipli (*Dynamically Typed*)** bir dildir. Bir değişken tanımlarken tipini belirtmezsiniz; çalışma zamanında atanan değere göre Python tipi otomatik olarak belirler.",
                    codeSnippet = "# Açıklama satırları '#' ile başlar\nprint('Merhaba Python ve Kod Akademi!')"
                ),
                LessonContentBlock(
                    subtitle = "2. Değişkenler ve Bellek İşaretçileri",
                    body = "Python'da değişkenler aslında bellekteki nesnelere işaret eden birer **etikettir (*Pointer / Reference*)**:\n\n• `str` (Metin): `'Ahmet'`, `\"Python\"`\n• `int` (Tam Sayı): `25`, `-10`\n• `float` (Ondalıklı Sayı): `3.14`, `100.5`\n• `bool` (Mantıksal): `True` veya `False`",
                    codeSnippet = "kullanici = 'Zeynep'  # str\nyas = 22             # int\nbakiye = 1500.75     # float\naktif_mi = True      # bool"
                ),
                LessonContentBlock(
                    subtitle = "3. f-String: Hızlı ve Zarif Metin Biçimlendirme",
                    body = "Eski `%` operatörü veya `.format()` yerine Python 3.6+ ile gelen **f-strings** doğrudan makine seviyesinde optimize edilir. Metnin başına `f` koyup süslü parantezler `{değişken}` içine hesaplamaları bile yazabilirsiniz.",
                    codeSnippet = "ad = 'Emre'\nnotu = 85\n\n# f-string içinde ifade bile çalıştırılabilir:\nmesaj = f'{ad} sınavdan {notu} aldı. (Geçti mi: {notu >= 50})'\nprint(mesaj)"
                )
            ),
            codeExample = "dil = 'Python'\nsurum = 3.12\n\nprint(f'{dil} {surum} ile kodlamaya başladık!')",
            codeExplanation = "f-string kalıbı kullanılarak değişkenler tek satırda güvenle birleştirildi.",
            realWorldExample = "Yapay zeka modellerinde (PyTorch, TensorFlow) ve veri analizinde (Pandas) tüm veri akışları Python'ın dinamik değişken yapısı üzerine kuruludur.",
            practicalTask = "adınızı ve yaşınızı iki değişkene atayın. f-string kullanarak 'Adım [ad], [2026 - yas] yılında doğmuşum' çıktısını üreten print komutunu yazın.",
            starterPlaygroundCode = "ad = 'Buse'\nyas = 24\n# f-string ile ekrana yazdırın:\n",
            miniQuestion = MiniQuestion(
                id = "py_q_1",
                question = "Python'da metin içine değişken veya ifade gömmek için metin tırnağının hemen başına hangi harf eklenir?",
                options = listOf("f", "s", "format", "v"),
                correctIndex = 0,
                explanation = "f-string oluşturmak için string ifadesinin başına 'f' harfi konur (Örn: f'Merhaba {ad}')."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_1",
                lessonId = "py_1",
                title = "Kullanıcı Karşılama Kartı",
                instructions = "kullanici (str) ve bakiye (float) parametrelerini alan, 'Hesap: [kullanici] | Bakiye: [bakiye] TL' formatında f-string ile metin döndüren hesap_bilgisi(kullanici, bakiye) fonksiyonunu yazın.",
                exampleInput = "kullanici = 'Ali', bakiye = 250.0",
                exampleOutput = "'Hesap: Ali | Bakiye: 250.0 TL'",
                starterCode = "def hesap_bilgisi(kullanici, bakiye):\n    # Kodunu yaz:\n    return ''",
                solutionCode = "def hesap_bilgisi(kullanici, bakiye):\n    return f'Hesap: {kullanici} | Bakiye: {bakiye} TL'",
                hints = listOf("return f'Hesap: {kullanici} | Bakiye: {bakiye} TL' yazın."),
                testCases = listOf(
                    TestCase("hesap_bilgisi('Ali', 250.0)", "Hesap: Ali | Bakiye: 250.0 TL", "Standart bakiye")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_1_1",
                    lessonId = "py_1",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Python'ın 'Dinamik Tipli' (Dynamically Typed) bir dil olması ne anlama gelir?",
                    options = listOf(
                        "Değişken tiplerinin değişken tanımlanırken değil, kod çalışırken atanan değere göre otomatik belirlenmesi",
                        "Değişkenlerin tiplerinin hiçbir zaman değişememesi",
                        "Sadece sayısal tiplerin desteklenmesi",
                        "Kodun çalıştırılamadan önce derlenmek zorunda olması"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Python'da değişken tipini elle yazmazsınız; çalışma zamanında otomatik anlaşılır.",
                    explanationWrong = "Dinamik tiplendirme tiplerin çalışma anında atanması anlamına gelir.",
                    reviewTopic = "Python Dinamik Tipler"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Python'da değişken isimleri nasıl yazılmalıdır?",
                    answer = "PEP 8 standartlarına göre değişkenler ve fonksiyonlar küçük harf ve alt çizgi (snake_case) ile yazılmalıdır (Örn: kullanici_adi, toplam_puan)."
                )
            ),
            communityInsights = listOf(
                CommunityInsight(
                    source = "StackOverflow #1 Python Tuzağı",
                    topic = "Neden fonksiyon varsayılan parametresinde asla boş liste 'def f(a=[])' kullanılmaz?",
                    insight = "Python'da varsayılan parametreler fonksiyon TANIMLANDIĞI AN tek bir kez belleğe yüklenir. 'def ekle(x, liste=[])' yazarsanız, her çağrıda aynı liste nesnesi kullanılır ve önceki çağrıların verileri üst üste biner. Doğru yöntem: 'def ekle(x, liste=None): if liste is None: liste = []' şeklindedir.",
                    commonMistake = "Varsayılan parametreye mutable (değişebilir) liste veya sözlük verip tüm kullanıcıların verisini birbirine karıştırmak."
                )
            ),
            completionCriteria = listOf(
                "Dinamik tipleme mantığını kavramak",
                "f-string ile temiz metinler üretebilmek"
            )
        ),

        // ==========================================
        // DERS 2: KONTROL AKIŞI, İNDENTATİON VE ARALIKLAR
        // ==========================================
        Lesson(
            id = "py_2",
            courseId = "python",
            sectionId = "py_sec_1",
            title = "Kontrol Akışı: if-elif-else, Girinti (Indentation) ve range()",
            shortDesc = "Süslü parantezler yerine 4 boşluk girinti kuralı, kısa devre değerlendirme (Short-circuit) ve for/while döngüleri.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false,
            learningObjectives = listOf(
                "Python'daki 4 boşluk Girinti (*Indentation*) kuralını ve TabError'dan kaçınmayı kavramak",
                "if, elif ve else ile çoklu karar mekanizmaları kurmak",
                "range(baslangic, bitis, adim) ile akıllı for döngüleri yazmak"
            ),
            prerequisites = listOf("Python Değişkenleri"),
            subtopics = listOf("Girinti (Indentation) Kuralı", "if, elif, else", "Kısa Devre (and/or)", "for ve range()", "while Döngüsü"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Girinti (Indentation): Kodun İskeleti",
                    body = "Diğer diller süslü parantez `{ }` kullanırken, Python bloğun kime ait olduğunu **satır başındaki 4 boşluk (girinti)** ile anlar. Bu sayede tüm Python kodları doğal olarak temiz ve hizalı olmak zorundadır.",
                    codeSnippet = "puan = 82\n\nif puan >= 90:\n    print('Harika! (A)')\nelif puan >= 70:\n    print('Başarılı! (B)') # Burası çalışır\nelse:\n    print('Geliştirilmeli')"
                ),
                LessonContentBlock(
                    subtitle = "2. for Döngüsü ve range() Fonksiyonu",
                    body = "`range(başlangıç, bitiş, adım)` fonksiyonu bir jeneratör gibi çalışır; hafızada milyonlarca sayıyı birden tutmaz, sırası geldikçe üretir:\n\n• `range(5)`: 0'dan 4'e kadar (5 hariç)\n• `range(1, 10, 2)`: 1, 3, 5, 7, 9",
                    codeSnippet = "toplam = 0\nfor i in range(1, 6): # 1, 2, 3, 4, 5\n    toplam += i\nprint(f'Toplam: {toplam}') # 15"
                )
            ),
            codeExample = "for i in range(2, 11, 2):\n    print(f'Çift Sayı: {i}')",
            codeExplanation = "range(2, 11, 2) ile 2'den 10'a kadar ikişer ikişer çift sayılar ekrana yazdırıldı.",
            realWorldExample = "Kullanıcı girişinde 3 defa hatalı şifre denemesi yapıldığında hesabı kilitlemek için while döngüsü ve if kontrolü kullanılır.",
            practicalTask = "1'den 20'ye kadar olan sayılardan 3'e tam bölünenleri ekrana yazdıran bir for döngüsü yazın.",
            starterPlaygroundCode = "for i in range(1, 21):\n    if i % 3 == 0:\n        print(f'3\\'ün katı: {i}')",
            miniQuestion = MiniQuestion(
                id = "py_q_2",
                question = "range(1, 10, 3) fonksiyonu sırasıyla hangi sayıları üretir?",
                options = listOf("1, 4, 7", "1, 3, 6, 9", "1, 4, 7, 10", "3, 6, 9"),
                correctIndex = 0,
                explanation = "1'den başlar, 3'er 3'er artar (1, 4, 7); 10 dahil edilmez."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_2",
                lessonId = "py_2",
                title = "3 ve 5'in Katları Toplayıcı",
                instructions = "1'den n'e kadar (n dahil) olan sayılardan hem 3'e hem 5'e bölünen (örneğin 15) sayıların toplamını hesaplayan kat_toplami(n) fonksiyonunu yazın.",
                exampleInput = "n = 30",
                exampleOutput = "45 (15 + 30)",
                starterCode = "def kat_toplami(n):\n    # Kodunu yaz:\n    return 0",
                solutionCode = "def kat_toplami(n):\n    top = 0\n    for i in range(1, n + 1):\n        if i % 15 == 0:\n            top += i\n    return top",
                hints = listOf("i % 15 == 0 kontrolü yapıp toplam değişkenine ekleyin."),
                testCases = listOf(
                    TestCase("kat_toplami(30)", "45", "30'a kadar katlar"),
                    TestCase("kat_toplami(10)", "0", "Kat yok")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_2_1",
                    lessonId = "py_2",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Python'da resmi stil rehberi (PEP 8) girintiler için neyi şart koşar?",
                    options = listOf(
                        "Her girinti seviyesi için 4 adet Boşluk (Space)",
                        "Sekme (Tab) tuşu",
                        "2 adet boşluk",
                        "Noktalı virgül"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! PEP 8 standardı Tab yerine 4 boşluk kullanılmasını tavsiye eder.",
                    explanationWrong = "Python standardında her girinti için 4 boşluk kullanılır.",
                    reviewTopic = "PEP 8 Girinti Standardı"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Python'da 'switch-case' var mıdır?",
                    answer = "Python 3.10 sürümüyle birlikte 'match-case' yapısı (Structural Pattern Matching) eklenmiştir."
                )
            ),
            communityInsights = listOf(
                CommunityInsight(
                    source = "Reddit r/learnpython İpucu",
                    topic = "Tab ve Boşlukları (Spaces) karıştırmanın tehlikesi: TabError",
                    insight = "Kod editörünüzde Tab ve Boşlukları karışık kullanırsanız ekranda aynı hizada görünse bile Python 'TabError: inconsistent use of tabs and spaces in indentation' hatası verir. Editörünüzde 'Indent using Spaces (4)' ayarını mutlaka açık tutun.",
                    commonMistake = "Farklı editörlerden kopyala-yapıştır yapıp görünmeyen Tab karakterleri yüzünden saatlerce hata aramak."
                )
            ),
            completionCriteria = listOf(
                "Girinti mantığını hatasız uygulayabilmek",
                "range() fonksiyonu ile döngüler kurabilmek"
            )
        ),

        // ==========================================
        // DERS 3: FONKSİYONLAR, ARGS/KWARGS VE KAPSAM (LEGB)
        // ==========================================
        Lesson(
            id = "py_3",
            courseId = "python",
            sectionId = "py_sec_2",
            title = "Fonksiyonlar: def, *args, **kwargs ve Kapsam Kuralı (LEGB)",
            shortDesc = "Dinamik parametre paketleme (*args, **kwargs), First-Class Functions ve değişken arama hiyerarşisi (LEGB).",
            level = CourseLevel.BEGINNER,
            order = 3,
            isPremium = false,
            learningObjectives = listOf(
                "def ile fonksiyon tanımlama ve return mekanizmasını anlamak",
                "*args (Demet) ve **kwargs (Sözlük) ile dinamik sayıda parametre kabul etmek",
                "LEGB Kapsam Kuralını (Local, Enclosing, Global, Built-in) kavramak"
            ),
            prerequisites = listOf("Python Temelleri"),
            subtopics = listOf("def Sözdizimi", "*args (Positional Args)", "**kwargs (Keyword Args)", "LEGB Kapsam Kuralı"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Fonksiyonlar ve First-Class Citizen Felsefesi",
                    body = "Python'da fonksiyonlar `def` anahtar kelimesiyle tanımlanır. Python'da fonksiyonlar **Birinci Sınıf Vatandaştır (*First-Class Citizens*)**; yani bir değişkene atanabilir, başka bir fonksiyona parametre olarak gönderilebilir veya fonksiyondan fonksiyon döndürülebilir.",
                    codeSnippet = "def topla(a, b=0):\n    return a + b\n\nprint(topla(10, 5)) # 15\nprint(topla(10))    # 10 (varsayılan b=0 devreye girdi)"
                ),
                LessonContentBlock(
                    subtitle = "2. Sihirli *args ve **kwargs",
                    body = "Fonksiyonun kaç parametre alacağını önceden bilmiyorsanız:\n\n• `*args`: Gelen tüm isimsiz parametreleri bir **Tuple (Demet)** olarak toplar.\n• `**kwargs`: Gelen tüm isimli parametreleri (`anahtar=deger`) bir **Dict (Sözlük)** olarak toplar.",
                    codeSnippet = "def siparis_ozeti(musteri, *urunler, **detaylar):\n    print(f'Müşteri: {musteri}')\n    print(f'Ürünler: {urunler}') # ('Kahve', 'Kek')\n    print(f'Detaylar: {detaylar}') # {'masa': 4, 'odeme': 'Kart'}\n\nsiparis_ozeti('Mert', 'Kahve', 'Kek', masa=4, odeme='Kart')"
                )
            ),
            codeExample = "def carpim(*sayilar):\n    sonuc = 1\n    for s in sayilar:\n        sonuc *= s\n    return sonuc\n\nprint(carpim(2, 3, 4)) # 24",
            codeExplanation = "*sayilar sayesinde fonksiyon 2, 3 veya 100 parametre ile aynı anda çalışabilir.",
            realWorldExample = "Django ve FastAPI web çatılarında arayüzden gelen dinamik URL parametreleri ve filtreler `**kwargs` ile karşılanır.",
            practicalTask = "İstediğiniz kadar sayı alıp bunların ortalamasını hesaplayan ortalama(*sayilar) fonksiyonunu yazın.",
            starterPlaygroundCode = "def ortalama(*sayilar):\n    if not sayilar:\n        return 0\n    return sum(sayilar) / len(sayilar)\n\nprint(ortalama(10, 20, 30))",
            miniQuestion = MiniQuestion(
                id = "py_q_3",
                question = "Python'da bir fonksiyonun sınırsız sayıda isimli parametreyi (keyword argument) sözlük olarak yakalaması için ne kullanılır?",
                options = listOf("**kwargs", "*args", "*params", "&dict"),
                correctIndex = 0,
                explanation = "**kwargs isimli parametreleri sözlük (dict) olarak yakalar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_3",
                lessonId = "py_3",
                title = "Dinamik Sayı Toplayıcı",
                instructions = "Sınırsız sayıda sayı parametresi (*sayilar) alabilen ve bunların toplamını döndüren topla_hepsini(*sayilar) fonksiyonunu yazın.",
                exampleInput = "topla_hepsini(1, 2, 3, 4)",
                exampleOutput = "10",
                starterCode = "def topla_hepsini(*sayilar):\n    # sum() kullanarak yaz:\n    return 0",
                solutionCode = "def topla_hepsini(*sayilar):\n    return sum(sayilar)",
                hints = listOf("return sum(sayilar) yazmanız yeterlidir."),
                testCases = listOf(
                    TestCase("topla_hepsini(1, 2, 3, 4)", "10", "4 sayı"),
                    TestCase("topla_hepsini(10, 20)", "30", "2 sayı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_3_1",
                    lessonId = "py_3",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Python'da bir değişken arandığında sırasıyla hangi kapsamlara bakılır (LEGB Kuralı)?",
                    options = listOf(
                        "Local -> Enclosing -> Global -> Built-in",
                        "Global -> Local -> Built-in -> Enclosing",
                        "Built-in -> Global -> Local",
                        "Sadece Local ve Global"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Mükemmel! LEGB: Local (Fonksiyon içi), Enclosing (Kapsayan fonksiyon), Global (Modül düzeyi), Built-in (Python yerleşik fonksiyonları).",
                    explanationWrong = "Kapsam arama sırası Local, Enclosing, Global ve Built-in (LEGB) şeklindedir.",
                    reviewTopic = "Python LEGB Kapsam Kuralı"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Fonksiyon içinde global bir değişkeni değiştirmek için ne yapılır?",
                    answer = "Fonksiyonun en başında 'global degisken_adi' yazılır; ancak yan etkileri önlemek için global değişken değiştirmekten kaçınmak en iyisidir."
                )
            ),
            communityInsights = listOf(
                CommunityInsight(
                    source = "Python Architecture Guide",
                    topic = "Unpacking Operatörü (* ve **) ile Sözlük Birleştirme",
                    insight = "Python 3.5+ ile iki sözlüğü birleştirmek için '{**sozluk1, **sozluk2}' yazabilirsiniz. Bu yöntem sözlük kopyalamanın en hızlı ve okunaklı yoludur.",
                    commonMistake = "Eski usul .update() ile orijinal sözlüğü bozup yan etki oluşturmak."
                )
            ),
            completionCriteria = listOf(
                "*args ve **kwargs mekanizmasını kavramak",
                "LEGB kapsam hiyerarşisini bilmek"
            )
        ),

        // ==========================================
        // DERS 4: VERİ YAPILARI: LİST, TUPLE, SET, DICT
        // ==========================================
        Lesson(
            id = "py_4",
            courseId = "python",
            sectionId = "py_sec_2",
            title = "Temel Veri Yapıları: List, Tuple, Set ve Dict (Hash Table)",
            shortDesc = "Değişebilen List vs Değişmez Tuple, O(1) anında arama yapan Set ve Anahtar-Değer deposu Dict mimarisi.",
            level = CourseLevel.BEGINNER,
            order = 4,
            isPremium = true,
            learningObjectives = listOf(
                "List (Dinamik Dizi) ve Tuple (Değişmez/Immutable) arasındaki farkı kavramak",
                "Set (Küme) yapısının tekrarsız eleman ve O(1) arama gücünü anlamak",
                "Dict (Sözlük / Hash Table) ile anahtar-değer eşleştirmelerini ustalıkla yönetmek"
            ),
            prerequisites = listOf("Fonksiyonlar"),
            subtopics = listOf("List (Dinamik Dizi)", "Tuple (Değişmez)", "Set ve Hash Table", "Dict Metotları (.get)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Veri Yapılarının Mimari Karşılaştırması",
                    body = "• **List `[1, 2]`:** Sıralı, elemanları güncellenebilir (*Mutable*).\n• **Tuple `(1, 2)`:** Sıralı, ancak elemanları asla değiştirilemez (*Immutable*). Bellekte daha az yer kaplar ve güvenlidir.\n• **Set `{1, 2}`:** Sırasız, tekrarsız eleman tutar. İçinde bir elemanın olup olmadığını aramak **O(1) Sabit Zaman** alır!\n• **Dict `{'ad': 'Ali'}`:** Anahtar-Değer (*Key-Value*) çiftleriyle çalışan Hash Table mimarisidir.",
                    codeSnippet = "# Liste vs Tuple vs Set:\nliste = ['Elma', 'Muz', 'Elma'] # 3 eleman\nkume = set(liste)               # {'Elma', 'Muz'} (Tekrarlar silindi)"
                ),
                LessonContentBlock(
                    subtitle = "2. Sözlüklerde Güvenli Erişim: .get() Metodu",
                    body = "Sözlükten `sozluk['yas']` diye veri çekerken eğer o anahtar yoksa program `KeyError` verip çöker. Bunun yerine `.get('yas', varsayilan)` kullanmak en güvenli topluluk standardıdır.",
                    codeSnippet = "profil = {'isim': 'Can', 'sehir': 'Ankara'}\n\n# KeyError fırlatmaz, 'Bilinmiyor' döner:\nyas = profil.get('yas', 'Bilinmiyor')\nprint(yas) # Bilinmiyor"
                )
            ),
            codeExample = "ogrenci = {'id': 101, 'ad': 'Selin', 'dersler': ['Matematik', 'Fizik']}\n\nprint(f\"Öğrenci: {ogrenci['ad']}, İlk Ders: {ogrenci['dersler'][0]}\")",
            codeExplanation = "İç içe geçmiş Dict ve List veri yapıları ile gerçekçi bir veri modeli oluşturuldu.",
            realWorldExample = "Web API'lerinden (RESTful API) dönen JSON verilerinin Python'daki karşılığı birebir `dict` ve `list` kombinasyonudur.",
            practicalTask = "Tekrarlı elemanlar içeren bir listenin tekrarlarını set() kullanarak temizleyen ve sıralı liste olarak geri döndüren bir kod yazın.",
            starterPlaygroundCode = "sayilar = [1, 2, 2, 3, 4, 4, 5]\ntekrarsiz = list(set(sayilar))\nprint(tekrarsiz)",
            miniQuestion = MiniQuestion(
                id = "py_q_4",
                question = "Python'da bir sözlükte var olmayan bir anahtarı ararken KeyError çökmesini önlemek için hangi metot kullanılır?",
                options = listOf(".get()", ".find()", ".lookup()", ".fetch()"),
                correctIndex = 0,
                explanation = ".get(anahtar, varsayilan) metodu anahtar yoksa varsayılan değeri güvenle döndürür."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_4",
                lessonId = "py_4",
                title = "Tekrarsız Eleman Sayıcı",
                instructions = "Verilen bir listedeki (liste) benzersiz (tekrarsız) eleman sayısını set kullanarak hesaplayan benzersiz_sayisi(liste) fonksiyonunu yazın.",
                exampleInput = "liste = [1, 2, 2, 3, 3, 3, 4]",
                exampleOutput = "4",
                starterCode = "def benzersiz_sayisi(liste):\n    # set ve len kullanarak yaz:\n    return 0",
                solutionCode = "def benzersiz_sayisi(liste):\n    return len(set(liste))",
                hints = listOf("return len(set(liste)) ifadesini döndürün."),
                testCases = listOf(
                    TestCase("benzersiz_sayisi([1, 2, 2, 3, 3, 3, 4])", "4", "Benzersiz sayım"),
                    TestCase("benzersiz_sayisi(['a', 'a', 'a'])", "1", "Tek eleman")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_4_1",
                    lessonId = "py_4",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Milyonlarca veri içeren bir koleksiyonda 'x elemanı bu grupta var mı?' sorgusu (x in koleksiyon) en hızlı hangi veri yapısında çalışır?",
                    options = listOf(
                        "Set (Küme) veya Dict Keys - O(1) Zaman Karmaşıklığı",
                        "List (Liste) - O(N) Zaman Karmaşıklığı",
                        "Tuple (Demet)",
                        "String"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Tebrikler! Set ve Dict arka planda Hash Table kullandığı için arama süresi eleman sayısından bağımsız olarak anındadır O(1).",
                    explanationWrong = "Set ve Dict yapıları Hash Table sayesinde O(1) sabit zamanda arama yapar.",
                    reviewTopic = "Python Veri Yapıları Performansı"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Tuple neden Listeden daha hızlıdır?",
                    answer = "Tuple immutable (değişmez) olduğu için Python bellekte tek parça sabit bir blok ayırır; liste gibi dinamik yeniden boyutlandırma ek yükü taşımaz."
                )
            ),
            communityInsights = listOf(
                CommunityInsight(
                    source = "StackOverflow Top Algoritma Sorusu",
                    topic = "Neden büyük listelerde 'if eleman in liste:' kontrolü performansı felç eder?",
                    insight = "Listede arama yapmak tüm elemanları baştan sona tek tek tarar (O(N)). Eğer 1 milyonluk bir listeniz varsa ve döngü içinde 'in liste' yazarsanız uygulamanız dakikalarca donar. Listeyi bir kez 'kume = set(liste)' yapıp 'if eleman in kume:' yazarsanız işlem mikrosaniyede biter.",
                    commonMistake = "Arama ve filtreleme işlemlerinde Set yerine List kullanıp performansı 1000 kat yavaşlatmak."
                )
            ),
            completionCriteria = listOf(
                "List, Tuple, Set ve Dict farklarını bilmek",
                ".get() metodu ile güvenli sözlük okuması yapabilmek"
            )
        ),

        // ==========================================
        // DERS 5: LIST COMPREHENSIONS VE GENERATOR İFADELERİ
        // ==========================================
        Lesson(
            id = "py_5",
            courseId = "python",
            sectionId = "py_sec_2",
            title = "Pythonic Kod: List Comprehensions ve Generator İfadeleri",
            shortDesc = "4 satırlık for döngülerini tek satıra indiren [x for x in ...] sözdizimi ve bellek dostu (x for x in ...) jeneratörleri.",
            level = CourseLevel.INTERMEDIATE,
            order = 5,
            isPremium = true,
            learningObjectives = listOf(
                "List Comprehension ile filtreleme ve dönüştürmeyi tek satırda yazmak",
                "Dict ve Set Comprehension kalıplarını kavramak",
                "List Comprehension ile Generator Expression arasındaki bellek farkını anlamak"
            ),
            prerequisites = listOf("Listeler ve Döngüler"),
            subtopics = listOf("List Comprehension Sözdizimi", "Koşullu Filtreleme (if)", "Dict Comprehension", "Bellek Tasarrufu"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. List Comprehension Mantığı",
                    body = "Geleneksel dillerde bir listeyi filtreleyip dönüştürmek için boş bir liste oluşturup for döngüsüyle `.append()` yapılır. Python'da matematiksel küme gösterimine benzeyen **List Comprehension** kullanılır; C seviyesinde çalıştığı için döngülerden çok daha hızlıdır.",
                    codeSnippet = "sayilar = [1, 2, 3, 4, 5, 6]\n\n# Çift sayıların karesini al:\n# [Dönüşüm for Eleman in Liste if Koşul]\nsonuc = [x**2 for x in sayilar if x % 2 == 0]\nprint(sonuc) # [4, 16, 36]"
                ),
                LessonContentBlock(
                    subtitle = "2. Dict Comprehension ile Sözlük Üretimi",
                    body = "Aynı mantıkla süslü parantez `{anahtar: deger for ... in ...}` kullanarak tek satırda sözlükler oluşturabilirsiniz.",
                    codeSnippet = "isimler = ['ali', 'veli', 'can']\nuzunluklar = {isim: len(isim) for isim in isimler}\nprint(uzunluklar) # {'ali': 3, 'veli': 4, 'can': 3}"
                )
            ),
            codeExample = "kelimeler = ['python', 'kod', 'akademi', 'yapayzekâ']\nbuyukler = [k.upper() for k in kelimeler if len(k) > 5]\nprint(buyukler) # ['PYTHON', 'AKADEMI', 'YAPAYZEKÂ']",
            codeExplanation = "5 karakterden uzun kelimeler filtrelendi ve tek satırda büyük harfe dönüştürüldü.",
            realWorldExample = "Veri biliminde CSV dosyalarından çekilen yüz binlerce satırlık metin sütunlarını temizlerken ve boşlukları kırparken comprehension kalıpları kullanılır.",
            practicalTask = "1'den 10'a kadar olan sayılardan tek olanların küpünü alan tek satırlık bir list comprehension yazın.",
            starterPlaygroundCode = "teplerin_kupu = [x**3 for x in range(1, 11) if x % 2 != 0]\nprint(teplerin_kupu)",
            miniQuestion = MiniQuestion(
                id = "py_q_5",
                question = "[x * 2 for x in range(4)] ifadesinin çıktısı nedir?",
                options = listOf("[0, 2, 4, 6]", "[2, 4, 6, 8]", "[0, 1, 2, 3]", "[2, 4, 6]"),
                correctIndex = 0,
                explanation = "range(4) -> 0, 1, 2, 3 üretir; 2 ile çarpılınca [0, 2, 4, 6] olur."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_5",
                lessonId = "py_5",
                title = "Pozitif Sayıların Kareleri",
                instructions = "sayilar listesindeki sadece pozitif (0'dan büyük) sayıların karesini alan ve list comprehension kullanarak yeni listeyi döndüren pozitif_kareler(sayilar) fonksiyonunu yazın.",
                exampleInput = "[-2, 3, -1, 4]",
                exampleOutput = "[9, 16]",
                starterCode = "def pozitif_kareler(sayilar):\n    # List comprehension ile yaz:\n    return []",
                solutionCode = "def pozitif_kareler(sayilar):\n    return [x**2 for x in sayilar if x > 0]",
                hints = listOf("return [x**2 for x in sayilar if x > 0] yazın."),
                testCases = listOf(
                    TestCase("pozitif_kareler([-2, 3, -1, 4])", "[9, 16]", "Karışık liste")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_5_1",
                    lessonId = "py_5",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "[x for x in range(1000000)] ile (x for x in range(1000000)) arasındaki en büyük fark nedir?",
                    options = listOf(
                        "Köşeli parantez tüm listeyi anında RAM'e yükler; normal parantez (Generator) ise sayıları istendikçe sırayla üretip devasa bellek tasarrufu sağlar",
                        "Normal parantez hata verir",
                        "Köşeli parantez daha yavaştır",
                        "Hiçbir fark yoktur"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Harika! Generator expressions hafızayı tüketmeden tembel (lazy) üretim yapar.",
                    explanationWrong = "Generator expressions bellek tasarrufu sağlar.",
                    reviewTopic = "Generator vs List Comprehension"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Comprehension'lar ne zaman kullanılmamalıdır?",
                    answer = "İç içe 3-4 tane döngü veya karmaşık if koşulları varsa kodun okunabilirliği bozulur. Okunabilirlik azaldığında normal for döngüsüne dönmek en doğrusudur."
                )
            ),
            communityInsights = listOf(
                CommunityInsight(
                    source = "Dev.to Python Best Practices",
                    topic = "Pythonic Kod Nedir?",
                    insight = "'Pythonic', Python'ın sunduğu zarif sözdizimini (Comprehensions, zip, enumerate, unpacking) kullanarak temiz ve akıcı kod yazma sanatıdır. Java veya C alışkanlıklarıyla for döngüsü içinde sayaç artırmak yerine 'for idx, eleman in enumerate(liste):' yazmak gerçek bir Pythonic yaklaşımdır.",
                    commonMistake = "range(len(liste)) yazıp liste[i] ile elemana erişmeye çalışmak."
                )
            ),
            completionCriteria = listOf(
                "List ve Dict Comprehension kalıplarını yazabilmek",
                "Generator ifadelerinin bellek avantajını kavramak"
            )
        ),

        // ==========================================
        // DERS 6: NESNE YÖNELİM: SINIFLAR, SELF VE DUNDER METOTLAR
        // ==========================================
        Lesson(
            id = "py_6",
            courseId = "python",
            sectionId = "py_sec_3",
            title = "Nesne Yönelim (OOP): Sınıflar, self Sırrı ve Dunder Metotlar",
            shortDesc = "class mimarisi, __init__ yapıcısı, self parametresinin çalışma mantığı ve __str__/__repr__ sihri.",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true,
            learningObjectives = listOf(
                "Sınıf (Class) ve Nesne (Instance) ilişkisini kavramak",
                "self parametresinin arka planda nasıl çalıştığını anlamak",
                "__init__, __str__ ve __len__ gibi Dunder (Double Underscore) metotlarını öğrenmek"
            ),
            prerequisites = listOf("Fonksiyonlar ve Sözlükler"),
            subtopics = listOf("class Tanımlama", "__init__ Constructor", "self Parametresi", "Dunder Metotlar (__str__, __repr__)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. self Nedir ve Neden Her Metotta Vardır?",
                    body = "Python'da bir sınıfın metotlarına ilk parametre olarak her zaman `self` yazılır. `self`, **o an işlem yapılan nesnenin kendisini** temsil eder.\n\nSiz `araba.hizlan(20)` yazdığınızda, Python arka planda `Araba.hizlan(araba, 20)` çağrısı yapar. Yani nesnenin kendisini otomatik olarak `self` parametresine gönderir!",
                    codeSnippet = "class Araba:\n    def __init__(self, marka, model):\n        self.marka = marka  # Nesneye ait özellik\n        self.model = model\n        self.hiz = 0\n        \n    def hizlan(self, miktar):\n        self.hiz += miktar\n        print(f'{self.marka} yeni hızı: {self.hiz} km/s')"
                ),
                LessonContentBlock(
                    subtitle = "2. Dunder (Sihirli) Metotlar",
                    body = "İki alt çizgiyle başlayıp biten metotlara **Dunder (*Double Underscore*) Metotlar** denir:\n\n• `__init__`: Nesne oluşturulurken ilk çalışan kurucu metottur.\n• `__str__`: `print(nesne)` yapıldığında kullanıcıya görünecek metni belirler.\n• `__eq__`: İki nesneyi `==` ile kıyaslarken çalışır.",
                    codeSnippet = "class Kitap:\n    def __init__(self, ad, sayfa):\n        self.ad = ad\n        self.sayfa = sayfa\n        \n    def __str__(self):\n        return f'{self.ad} ({self.sayfa} Sayfa)'\n\nk = Kitap('1984', 328)\nprint(k) # Çıktı: 1984 (328 Sayfa)"
                )
            ),
            codeExample = "class BankaHesabi:\n    def __init__(self, sahip, bakiye=0):\n        self.sahip = sahip\n        self.bakiye = bakiye\n        \n    def yatir(self, miktar):\n        self.bakiye += miktar\n        return self.bakiye\n\nh = BankaHesabi('Deniz', 500)\nh.yatir(200)\nprint(f'{h.sahip} Güncel Bakiye: {h.bakiye} TL')",
            codeExplanation = "BankaHesabi sınıfı ile durum saklayan ve metot içeren nesne yönelimli mimari kuruldu.",
            realWorldExample = "Web sunucularında (FastAPI/Django) her bir Veritabanı Modeli (User, Order) birer Python sınıfı olarak tanımlanır.",
            practicalTask = "Ogrenci adında (ad, notu) bir sınıf tanımlayın. __str__ metodunu 'Öğrenci: [ad] - Not: [notu]' döndürecek şekilde yazın.",
            starterPlaygroundCode = "class Ogrenci:\n    def __init__(self, ad, notu):\n        self.ad = ad\n        self.notu = notu\n    def __str__(self):\n        return f'Öğrenci: {self.ad} - Not: {self.notu}'\n\no = Ogrenci('Mert', 90)\nprint(o)",
            miniQuestion = MiniQuestion(
                id = "py_q_6",
                question = "Python'da bir nesne ekrana print() ile basıldığında okunabilir metin üretmesini sağlayan sihirli metot hangisidir?",
                options = listOf("__str__", "__print__", "__show__", "__display__"),
                correctIndex = 0,
                explanation = "__str__ metodu nesnenin kullanıcı dostu string temsilini döndürür."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_6",
                lessonId = "py_6",
                title = "Dikdörtgen Alan Hesaplayıcı Sınıfı",
                instructions = "Dikdortgen(en, boy) sınıfını tanımlayın. İçinde alan() metodunu (en * boy) hesaplayacak şekilde yazın.",
                exampleInput = "d = Dikdortgen(5, 4); d.alan()",
                exampleOutput = "20",
                starterCode = "class Dikdortgen:\n    def __init__(self, en, boy):\n        self.en = en\n        self.boy = boy\n        \n    def alan(self):\n        # Kodunu yaz:\n        return 0",
                solutionCode = "class Dikdortgen:\n    def __init__(self, en, boy):\n        self.en = en\n        self.boy = boy\n        \n    def alan(self):\n        return self.en * self.boy",
                hints = listOf("return self.en * self.boy yazın."),
                testCases = listOf(
                    TestCase("Dikdortgen(5, 4).alan()", "20", "5x4 alan"),
                    TestCase("Dikdortgen(10, 10).alan()", "100", "10x10 kare")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_6_1",
                    lessonId = "py_6",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Python'da __init__ metodu ile __new__ metodu arasındaki fark nedir?",
                    options = listOf(
                        "__new__ nesneyi bellekte gerçekten oluşturan metottur; __init__ ise oluşturulan nesnenin özelliklerini ilklendiren (initialize eden) metottur",
                        "__init__ silme işlemi yapar",
                        "İkisi tamamen aynıdır",
                        "__new__ sadece sayılar için çalışır"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Mükemmel teknik bilgi! __new__ nesneyi yaratır, __init__ ise içini doldurur.",
                    explanationWrong = "__new__ nesneyi oluşturur, __init__ ilklendirir.",
                    reviewTopic = "Python OOP Yaşam Döngüsü"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "__str__ ile __repr__ arasındaki fark nedir?",
                    answer = "__str__ son kullanıcı için güzel metin üretir; __repr__ ise geliştiriciler için nesnenin nasıl yeniden yaratılabileceğini gösteren teknik çıktıdır (Örn: Kitap(ad='1984', sayfa=328))."
                )
            ),
            communityInsights = listOf(
                CommunityInsight(
                    source = "StackOverflow Top OOP Sorusu",
                    topic = "Neden Python'da private değişkenler için 'private' kelimesi yoktur?",
                    insight = "Python topluluğunda ünlü bir söz vardır: 'We are all consenting adults here' (Hepimiz yetişkin insanlarız). Zorla erişimi engellemek yerine geleneksel olarak değişkenin başına tek alt çizgi `_ozel_veri` konularak 'bu içsel bir değişkendir, lütfen dışarıdan dokunmayın' mesajı verilir.",
                    commonMistake = "Çift alt çizgi `__veri` koyup Name Mangling mekanizmasını 'kesin güvenlik' sanmak."
                )
            ),
            completionCriteria = listOf(
                "Sınıf ve __init__ kurucusunu yazabilmek",
                "self mantığını ve __str__ metodunu kullanabilmek"
            )
        ),

        // ==========================================
        // DERS 7: DEKORATÖRLER (@decorator) VE KAPANISLAR (Closures)
        // ==========================================
        Lesson(
            id = "py_7",
            courseId = "python",
            sectionId = "py_sec_4",
            title = "İleri Düzey Yetenekler: Dekoratörler (@decorator) ve Kapanışlar (Closures)",
            shortDesc = "Fonksiyonların kaynak koduna dokunmadan loglama, yetkilendirme veya süre ölçme ekleyen @decorator sanatı.",
            level = CourseLevel.INTERMEDIATE,
            order = 7,
            isPremium = true,
            learningObjectives = listOf(
                "Fonksiyonları sarmalayan (Wrapper) Closures yapısını kavramak",
                "@decorator sözdizimi ile fonksiyonlara yeni yetenekler kazandırmak",
                "functools.wraps ile fonksiyon kimliğini korumayı öğrenmek"
            ),
            prerequisites = listOf("Fonksiyonlar ve OOP"),
            subtopics = listOf("Closures (Kapanışlar)", "Dekoratör Nasıl Çalışır?", "@ Sözdizimi", "functools.wraps"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Dekoratörlerin Temel Mantığı",
                    body = "Bir web uygulamasında 20 farklı fonksiyonunuz var ve her birinin ne kadar sürede çalıştığını ölçmek veya kullanıcının giriş yapıp yapmadığını kontrol etmek istiyorsunuz. Her fonksiyonun içine aynı kodları kopyalamak yerine bir **Dekoratör** yazarsınız.\n\nDekoratör, bir fonksiyonu girdi olarak alıp, ona yeni yetenekler ekleyerek geri döndüren bir fonksiyondur.",
                    codeSnippet = "def buyuk_harf_yap(fonksiyon):\n    def wrapper():\n        orijinal_sonuc = fonksiyon()\n        return orijinal_sonuc.upper()\n    return wrapper\n\n@buyuk_harf_yap\ndef selamla():\n    return 'merhaba dünya'\n\nprint(selamla()) # 'MERHABA DÜNYA'"
                ),
                LessonContentBlock(
                    subtitle = "2. Parametre Alan Fonksiyonları Dekore Etmek (*args, **kwargs)",
                    body = "Dekoratörün her türlü parametre alan fonksiyonda çalışabilmesi için içteki `wrapper(*args, **kwargs)` olarak tanımlanır.",
                    codeSnippet = "import time\n\ndef sure_olc(fonksiyon):\n    def wrapper(*args, **kwargs):\n        baslangic = time.time()\n        sonuc = fonksiyon(*args, **kwargs)\n        bitis = time.time()\n        print(f'{fonksiyon.__name__} çalışma süresi: {bitis - baslangic:.4f} sn')\n        return sonuc\n    return wrapper"
                )
            ),
            codeExample = "def unlem_ekle(fn):\n    def wrapper(*args, **kwargs):\n        return f'{fn(*args, **kwargs)}!!!'\n    return wrapper\n\n@unlem_ekle\ndef mesaj(ad):\n    return f'Hoş geldin {ad}'\n\nprint(mesaj('Ahmet')) # 'Hoş geldin Ahmet!!!'",
            codeExplanation = "@unlem_ekle dekoratörü fonksiyon sonucunun sonuna '!!!' ekledi.",
            realWorldExample = "Flask ve FastAPI web çatılarında `@app.get('/kullanicilar')` veya Django'da `@login_required` dekoratörleri standarttır.",
            practicalTask = "Bir fonksiyonun çalışmadan önce 'İşlem Başlıyor...', çalıştıktan sonra 'İşlem Bitti.' yazdıran bir log_dekorator yazın.",
            starterPlaygroundCode = "def log_dekorator(fn):\n    def wrapper(*args, **kwargs):\n        print('İşlem Başlıyor...')\n        sonuc = fn(*args, **kwargs)\n        print('İşlem Bitti.')\n        return sonuc\n    return wrapper",
            miniQuestion = MiniQuestion(
                id = "py_q_7",
                question = "Python'da bir fonksiyonun üzerine @dekorator_adi yazıldığında arka planda hangi işlem gerçekleşir?",
                options = listOf(
                    "fonksiyon = dekorator_adi(fonksiyon)",
                    "fonksiyon = fonksiyon + dekorator_adi",
                    "dekorator_adi belleği temizler",
                    "Fonksiyon iki kez çalıştırılır"
                ),
                correctIndex = 0,
                explanation = "@dekorator sözdizimi, fonksiyonu dekoratör fonksiyonuna parametre verip çıkan yeni sarmalayıcıyı fonksiyona atamanın kısayoludur."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_7",
                lessonId = "py_7",
                title = "İki Katına Çıkaran Dekoratör",
                instructions = "Sayısal sonuç döndüren herhangi bir fonksiyonun sonucunu 2 ile çarpan `iki_kati_yap(fn)` dekoratörünü yazın.",
                exampleInput = "@iki_kati_yap\ndef topla(a, b): return a + b\ntopla(3, 4)",
                exampleOutput = "14",
                starterCode = "def iki_kati_yap(fn):\n    def wrapper(*args, **kwargs):\n        # Kodu tamamla:\n        return 0\n    return wrapper",
                solutionCode = "def iki_kati_yap(fn):\n    def wrapper(*args, **kwargs):\n        return fn(*args, **kwargs) * 2\n    return wrapper",
                hints = listOf("return fn(*args, **kwargs) * 2 döndürün."),
                testCases = listOf(
                    TestCase("iki_kati_yap(lambda a, b: a + b)(3, 4)", "14", "3+4=7 * 2 = 14")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_7_1",
                    lessonId = "py_7",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir dekoratör yazarken 'functools.wraps' kullanmanın temel amacı nedir?",
                    options = listOf(
                        "Orijinal fonksiyonun __name__ (adı) ve docstring (belgelendirme) gibi meta verilerini korumak",
                        "Fonksiyonu hızlandırmak",
                        "Hataları gizlemek",
                        "Sadece sınıflarda çalışmasını sağlamak"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! @functools.wraps(fn) yazılmazsa fonksiyonun adı 'wrapper' olarak görünür ve debug zorlaşır.",
                    explanationWrong = "functools.wraps meta verilerin korunmasını sağlar.",
                    reviewTopic = "Python functools.wraps"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Bir fonksiyona birden fazla dekoratör eklenebilir mi?",
                    answer = "Evet! Üst üste birden fazla @dekorator yazılabilir. En alttaki dekoratör ilk önce çalışır."
                )
            ),
            communityInsights = listOf(
                CommunityInsight(
                    source = "Reddit r/Python Top İpucu",
                    topic = "Dekoratörleri nerede kullanmalıyız?",
                    insight = "Dekoratörler kod tekrarını yok eden en güçlü silahtır: 1) Rate limiting (API istek sınırlandırma), 2) Caching / Memoization (Hesaplama sonuçlarını önbelleğe alma - @functools.lru_cache), 3) Yetki kontrolü (Admin mi?).",
                    commonMistake = "Her küçük işlem için gereksiz yere karmaşık dekoratör zincirleri kurmak."
                )
            ),
            completionCriteria = listOf(
                "Dekoratör mantığını ve @ sözdizimini kavramak",
                "*args ve **kwargs ile esnek dekoratör yazabilmek"
            )
        ),

        // ==========================================
        // DERS 8: JENERATÖRLER VE YIELD (Lazy Evaluation)
        // ==========================================
        Lesson(
            id = "py_8",
            courseId = "python",
            sectionId = "py_sec_4",
            title = "Bellek Tasarrufu: Jeneratörler, yield ve Tembel Değerlendirme (Lazy Evaluation)",
            shortDesc = "Milyonlarca veriyi RAM'e yüklemeden tek tek işleme: yield kelimesinin duraklatma gücü.",
            level = CourseLevel.INTERMEDIATE,
            order = 8,
            isPremium = true,
            learningObjectives = listOf(
                "return ile yield arasındaki durum koruma (Stateful) farkını kavramak",
                "Generator nesnelerinin Iterator protokolünü (__next__) nasıl uyguladığını anlamak",
                "Devasa dosya veya veri akışlarını bellek tüketmeden işlemeyi öğrenmek"
            ),
            prerequisites = listOf("Fonksiyonlar ve Döngüler"),
            subtopics = listOf("yield Nedir?", "Tembel Değerlendirme (Lazy Evaluation)", "next() Fonksiyonu", "Bellek Kıyaslaması"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. return vs yield Mantığı",
                    body = "Normal bir fonksiyon `return` dediğinde çalışması tamamen biter ve hafızadaki tüm yerel değişkenleri silinir.\n\nİçinde **`yield`** bulunan bir fonksiyon ise bir **Jeneratör (*Generator*)** üretir. `yield` bir değer üretir, fonksiyonun o anki durumunu (satırını ve değişkenlerini) dondurur (*pause*) ve bir sonraki çağrıyı bekler!",
                    codeSnippet = "def sonsuz_sayac():\n    sayi = 1\n    while True:\n        yield sayi\n        sayi += 1\n\ngen = sonsuz_sayac()\nprint(next(gen)) # 1\nprint(next(gen)) # 2 (Kaldığı yerden devam etti!)"
                ),
                LessonContentBlock(
                    subtitle = "2. Neden Devasa Bellek Tasarrufu Sağlar?",
                    body = "10 GB boyutunda bir log dosyasını `dosya.readlines()` ile okursanız bilgisayarın 10 GB RAM'i anında dolar ve kilitlenir. Ancak `yield` ile satır satır okuyan bir jeneratör sadece **birkaç Kilobyte** RAM kullanır.",
                    codeSnippet = "# Bellek dostu sayı üretici:\ndef buyuk_aralik(n):\n    i = 0\n    while i < n:\n        yield i\n        i += 1"
                )
            ),
            codeExample = "def fibonacci_uret(adet):\n    a, b = 0, 1\n    for _ in range(adet):\n        yield a\n        a, b = b, a + b\n\nfor sayi in fibonacci_uret(6):\n    print(sayi, end=' ') # 0 1 1 2 3 5",
            codeExplanation = "Fibonacci sayıları hafızada liste tutulmadan yield ile anlık üretildi.",
            realWorldExample = "Büyük veri işleme (Big Data) ve Makine Öğrenimi veri hatlarında (Data Pipelines) terabaytlarca resim ve metin jeneratörler ile parçalar halinde (Batch) modele beslenir.",
            practicalTask = "Verilen bir başlangıç ve bitiş arasındaki çift sayıları yield ile üreten cift_sayac(baslangic, bitis) jeneratörünü yazın.",
            starterPlaygroundCode = "def cift_sayac(baslangic, bitis):\n    for i in range(baslangic, bitis + 1):\n        if i % 2 == 0:\n            yield i\n\nprint(list(cift_sayac(1, 10)))",
            miniQuestion = MiniQuestion(
                id = "py_q_8",
                question = "Bir jeneratör fonksiyonundan bir sonraki değeri istemek için hangi yerleşik Python fonksiyonu çağrılır?",
                options = listOf("next()", "step()", "yield()", "get()"),
                correctIndex = 0,
                explanation = "next(generator) fonksiyonu jeneratörü bir sonraki yield noktasına kadar ilerletir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_8",
                lessonId = "py_8",
                title = "Kare Jeneratörü",
                instructions = "1'den n'e kadar (n dahil) olan sayıların karesini yield ile tek tek üreten kareler_generator(n) fonksiyonunu yazın.",
                exampleInput = "list(kareler_generator(3))",
                exampleOutput = "[1, 4, 9]",
                starterCode = "def kareler_generator(n):\n    # yield kullanarak yaz:\n    pass",
                solutionCode = "def kareler_generator(n):\n    for i in range(1, n + 1):\n        yield i * i",
                hints = listOf("for i in range(1, n + 1): yield i * i yazın."),
                testCases = listOf(
                    TestCase("list(kareler_generator(3))", "[1, 4, 9]", "1..3 kareler")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_8_1",
                    lessonId = "py_8",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir jeneratörün üretecek başka elemanı kalmadığında next() çağrılırsa hangi istisna (exception) fırlatılır?",
                    options = listOf("StopIteration", "IndexError", "GeneratorExit", "EndOfStream"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! for döngüleri arka planda bu StopIteration istisnasını yakalayarak döngüyü güvenle bitirir.",
                    explanationWrong = "Jeneratör bittiğinde StopIteration fırlatılır.",
                    reviewTopic = "Python Iterator Protocol"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Jeneratörler geriye dönebilir veya baştan başlayabilir mi?",
                    answer = "Hayır, jeneratörler tek yönlüdür; tüketildikten sonra tekrar baştan başlamazlar, yeniden çağrılmaları gerekir."
                )
            ),
            communityInsights = listOf(
                CommunityInsight(
                    source = "StackOverflow Top Python Memory İpucu",
                    topic = "sys.getsizeof() ile List vs Generator Karşılaştırması",
                    insight = "1 milyon elemanlı bir liste 'sys.getsizeof([x for x in range(1000000)])' yaklaşık 8.5 MB RAM kaplarken, aynı jeneratör '(x for x in range(1000000))' sadece 104 Byte yer kaplar. Aradaki fark 85.000 kattır!",
                    commonMistake = "Devasa veri akışlarında jeneratör yerine büyük listeler oluşturup sunucuyu 'Out of Memory (OOM)' ile çökertmek."
                )
            ),
            completionCriteria = listOf(
                "yield anahtar kelimesinin duraklatma mantığını kavramak",
                "Bellek dostu jeneratörler yazabilmek"
            )
        ),

        // ==========================================
        // DERS 9: HATA YÖNETİMİ (try-except-else-finally) VE EAFP
        // ==========================================
        Lesson(
            id = "py_9",
            courseId = "python",
            sectionId = "py_sec_3",
            title = "Çökmeyen Kod: try-except-else-finally ve EAFP Felsefesi",
            shortDesc = "Hata yakalama mekanizması, özel istisnalar (Custom Exceptions) ve Python'ın ünlü EAFP yaklaşımı.",
            level = CourseLevel.INTERMEDIATE,
            order = 9,
            isPremium = true,
            learningObjectives = listOf(
                "try, except, else ve finally bloklarının kesin çalışma sırasını kavramak",
                "EAFP (Easier to ask for forgiveness than permission) felsefesini anlamak",
                "Custom Exception (Özel İstisna Sınıfları) oluşturmayı öğrenmek"
            ),
            prerequisites = listOf("Fonksiyonlar ve OOP"),
            subtopics = listOf("try-except Blokları", "else ve finally Farkı", "EAFP vs LBYL Felsefesi", "Özel Hata Sınıfları"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. try-except-else-finally Mimarisi",
                    body = "• **try:** Riskli kod buraya yazılır.\n• **except:** Hata olursa yakalanır.\n• **else:** *Hiçbir hata OLMADIYSA* çalışır (Çok az bilinir ama çok temizdir!).\n• **finally:** Hata olsa da olmasa da *kesinlikle en sonda* çalışır (Dosya kapatma, bağlantı sonlandırma için).",
                    codeSnippet = "try:\n    sayi = int('123')\nexcept ValueError:\n    print('Geçersiz sayı!')\nelse:\n    print(f'Başarıyla dönüştürüldü: {sayi}') # Hata yoksa çalışır\nfinally:\n    print('İşlem tamamlandı.')"
                ),
                LessonContentBlock(
                    subtitle = "2. Python'ın Felsefesi: EAFP",
                    body = "C ve Java dillerinde önce kontrol edilir: *'Bak bakalım dosya var mı? Varsa aç'* (**LBYL**: *Look Before You Leap*).\n\nPython'da ise önce denenir, hata olursa yakalanır: **EAFP** (*Easier to Ask for Forgiveness than Permission* - *İzin istemektense af dilemek daha kolaydır*). Bu yaklaşım çok daha hızlıdır ve yarış durumlarını (*Race Conditions*) engeller.",
                    codeSnippet = "# Pythonic EAFP Yöntemi:\ntry:\n    with open('veri.txt') as f:\n        print(f.read())\nexcept FileNotFoundError:\n    print('Dosya bulunamadı!')"
                )
            ),
            codeExample = "def guvenli_bol(a, b):\n    try:\n        return a / b\n    except ZeroDivisionError:\n        return 0\n\nprint(guvenli_bol(10, 2)) # 5.0\nprint(guvenli_bol(10, 0)) # 0",
            codeExplanation = "ZeroDivisionError yakalandı ve uygulamanın çökmesi engellendi.",
            realWorldExample = "Finans uygulamalarında döviz kurları API'den çekilirken internet kesintisi veya geçersiz JSON gelmesi durumunda try-except ile kullanıcıya çevrimdışı son kur gösterilir.",
            practicalTask = "Geçersiz bir metni sayıya çevirmeyi deneyen ve ValueError yakalandığında -1 döndüren bir fonksiyon yazın.",
            starterPlaygroundCode = "def sayi_yap(metin):\n    try:\n        return int(metin)\n    except ValueError:\n        return -1\n\nprint(sayi_yap('abc'))",
            miniQuestion = MiniQuestion(
                id = "py_q_9",
                question = "try-except yapısında sadece ve sadece HATA OLUŞMADIĞINDA çalışan blok hangisidir?",
                options = listOf("else", "finally", "except", "then"),
                correctIndex = 0,
                explanation = "else bloğu try bloğunda hiçbir istisna fırlatılmadığında çalışır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_9",
                lessonId = "py_9",
                title = "Güvenli Liste İndeks Erişimi",
                instructions = "Bir liste ve indeks (int) parametresi alan, eğer indeks geçerliyse o elemanı, IndexError oluşursa 'Geçersiz İndeks' döndüren guvenli_eleman(liste, indeks) fonksiyonunu try-except ile yazın.",
                exampleInput = "liste = ['a', 'b'], indeks = 5",
                exampleOutput = "'Geçersiz İndeks'",
                starterCode = "def guvenli_eleman(liste, indeks):\n    # try-except ile yaz:\n    return None",
                solutionCode = "def guvenli_eleman(liste, indeks):\n    try:\n        return liste[indeks]\n    except IndexError:\n        return 'Geçersiz İndeks'",
                hints = listOf("try: return liste[indeks] except IndexError: return 'Geçersiz İndeks' yazın."),
                testCases = listOf(
                    TestCase("guvenli_eleman(['a', 'b'], 0)", "a", "Geçerli indeks"),
                    TestCase("guvenli_eleman(['a', 'b'], 5)", "Geçersiz İndeks", "Hatalı indeks")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_9_1",
                    lessonId = "py_9",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Neden 'except:' veya 'except Exception:' yazıp içini boş 'pass' bırakmak çok tehlikelidir?",
                    options = listOf(
                        "Klavyeden çıkış (Ctrl+C), bellek hatası ve yazım hataları dahil tüm kritik sistem sinyallerini yutarak hatanın kaynağını tamamen görünmez kıldığı için",
                        "Programı hızlandırdığı için",
                        "Python sürümünü düşürdüğü için",
                        "Sadece Linux'ta hata verdiği için"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Kesinlikle! Buna 'Bare Except / Silent Exception Swallowing' denir ve korkunç bir anti-pattern'dir.",
                    explanationWrong = "Bare except hataları gizler ve debug etmeyi imkansız hale getirir.",
                    reviewTopic = "Python Exception Handling Anti-Patterns"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Özel hata (Custom Exception) nasıl oluşturulur?",
                    answer = "class OzelHata(Exception): pass şeklinde Exception sınıfından kalıtım alınarak kolayca oluşturulur."
                )
            ),
            communityInsights = listOf(
                CommunityInsight(
                    source = "StackOverflow En Popüler Python Tavsiyesi",
                    topic = "Neden her zaman spesifik hata yakalamalıyız?",
                    insight = "'except Exception:' yerine her zaman yakalamak istediğiniz net hatayı (Örn: 'except (KeyError, ValueError):') belirtin. Böylece beklenmedik bir NameError veya TypeError olduğunda bunu yanlışlıkla yutmaz, hemen fark edip düzeltebilirsiniz.",
                    commonMistake = "Tüm kod tabanını tek bir dev 'except:' ile sarmalayıp program neden yanlış çalışıyor diye günlerce aramak."
                )
            ),
            completionCriteria = listOf(
                "try-except-else-finally bloklarını doğru kullanabilmek",
                "EAFP yaklaşımının mantığını anlamak"
            )
        ),

        // ==========================================
        // DERS 10: CONTEXT MANAGERS VE WITH DEYİMİ
        // ==========================================
        Lesson(
            id = "py_10",
            courseId = "python",
            sectionId = "py_sec_6",
            title = "Kaynak Yönetimi: with Deyimi ve Context Managers (__enter__, __exit__)",
            shortDesc = "Dosya, veritabanı veya ağ bağlantılarında sızıntıları (Leak) önleyen with sihirbazlığı.",
            level = CourseLevel.INTERMEDIATE,
            order = 10,
            isPremium = true,
            learningObjectives = listOf(
                "with deyiminin arka plandaki kaynak açma ve kapatma mekanizmasını kavramak",
                "__enter__ ve __exit__ dunder metotları ile kendi Context Manager sınıfını yazmak",
                "contextlib modülündeki @contextmanager dekoratörünü öğrenmek"
            ),
            prerequisites = listOf("Sınıflar ve Hata Yönetimi"),
            subtopics = listOf("with Deyimi Neden Standarttır?", "__enter__ ve __exit__", "@contextmanager Dekoratörü", "Kaynak Sızıntılarını Önleme"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. with Deyimi Neden Hayat Kurtarır?",
                    body = "Bir dosya açtığınızda (`f = open('dosya.txt')`), dosya okurken bir hata fırlatılırsa `f.close()` satırı asla çalışmaz ve işletim sisteminde açık kalan dosya tanıtıcıları (*File Descriptors*) birikerek sistemi kilitler.\n\n**`with` deyimi**, hata olsa bile bloğun sonunda kaynağın kapatılmasını garanti eder.",
                    codeSnippet = "# Dosya okunur ve blok bittiğinde OTOMATİK kapatılır:\nwith open('notlar.txt', 'w') as dosya:\n    dosya.write('Python ile güvenli dosya yazımı!')"
                ),
                LessonContentBlock(
                    subtitle = "2. Kendi Context Manager Sınıfımızı Yazmak",
                    body = "Bir sınıfa `__enter__` ve `__exit__` metotlarını eklediğinizde o sınıf artık `with` ile kullanılabilir hale gelir.",
                    codeSnippet = "class VeritabaniBaglantisi:\n    def __enter__(self):\n        print('Veritabanına bağlanıldı 🔌')\n        return self\n        \n    def __exit__(self, exc_type, exc_val, exc_tb):\n        print('Bağlantı güvenle kapatıldı 🔒')\n\nwith VeritabaniBaglantisi():\n    print('Sorgular çalıştırılıyor...')"
                )
            ),
            codeExample = "class SayacZamanlayici:\n    def __enter__(self):\n        print('Giriş yapıldı')\n        return self\n    def __exit__(self, exc_type, exc_val, exc_tb):\n        print('Çıkış yapıldı')\n\nwith SayacZamanlayici():\n    print('Blok içi işlem')",
            codeExplanation = "__enter__ ile başlayan ve __exit__ ile temizlenen özel context manager çalıştırıldı.",
            realWorldExample = "Çok iş parçacıklı programlamada `threading.Lock` ile kilit alırken `with lock:` yazılır; böylece işlem bitince kilit otomatik serbest bırakılır (Deadlock riski önlenir).",
            practicalTask = "with open('test.txt', 'w') as f: f.write('Deneme') kodunu zihninizde canlandırın ve __exit__ çağrısının ne zaman tetiklendiğini açıklayın.",
            starterPlaygroundCode = "with open('deneme.txt', 'w') as f:\n    f.write('Merhaba Context Manager!')\nprint('Dosya otomatik kapandı.')",
            miniQuestion = MiniQuestion(
                id = "py_q_10",
                question = "Bir sınıfın 'with' deyimi ile kullanılabilmesi için hangi iki sihirli metodu içermesi gerekir?",
                options = listOf("__enter__ ve __exit__", "__open__ ve __close__", "__start__ ve __stop__", "__init__ ve __del__"),
                correctIndex = 0,
                explanation = "Context Manager protokolü __enter__ ve __exit__ metotlarından oluşur."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_10",
                lessonId = "py_10",
                title = "Özel Selamlayıcı Context Manager",
                instructions = "Girişte 'BAŞLADI', çıkışta 'BİTTİ' yazdıran ve __enter__ / __exit__ metotlarını içeren GorevTakipci sınıfını yazın.",
                exampleInput = "with GorevTakipci(): pass",
                exampleOutput = "'BAŞLADI' ardından 'BİTTİ'",
                starterCode = "class GorevTakipci:\n    def __enter__(self):\n        # Kodu yaz:\n        return self\n    def __exit__(self, exc_type, exc_val, exc_tb):\n        # Kodu yaz:\n        pass",
                solutionCode = "class GorevTakipci:\n    def __enter__(self):\n        print('BAŞLADI')\n        return self\n    def __exit__(self, exc_type, exc_val, exc_tb):\n        print('BİTTİ')",
                hints = listOf("__enter__ içinde print('BAŞLADI'), __exit__ içinde print('BİTTİ') yazın."),
                testCases = listOf(
                    TestCase("GorevTakipci().__enter__(); GorevTakipci().__exit__(None, None, None)", "None", "Giriş ve çıkış testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_10_1",
                    lessonId = "py_10",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "with bloğu içinde beklenmedik bir hata (Exception) oluşursa __exit__ metoduna ne olur?",
                    options = listOf(
                        "__exit__ metodu yine de kesinlikle çalıştırılır ve hata bilgileri parametre olarak verilir",
                        "__exit__ metodu iptal edilir",
                        "Program anında donar",
                        "Dosya açık kalır"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! __exit__ her durumda çalışarak kaynakların temizlenmesini garanti eder.",
                    explanationWrong = "__exit__ hata olsa bile kesinlikle çalışır.",
                    reviewTopic = "Context Manager Exception Handling"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "@contextlib.contextmanager nedir?",
                    answer = "Sınıf yazmak yerine yield içeren basit bir fonksiyonun üzerine @contextmanager koyarak tek hamlede context manager oluşturmanızı sağlayan standart kütüphane aracıdır."
                )
            ),
            communityInsights = listOf(
                CommunityInsight(
                    source = "GitHub Python Clean Code Rules",
                    topic = "Neden manuel open() ve close() artık kod incelemelerinde (Code Review) reddedilir?",
                    insight = "'f = open(...)' yazıp alt satırlarda 'f.close()' yazmak modern Python'da kabul edilmez. Çünkü aradaki 10 satırın herhangi birinde hata olursa dosya sonsuza kadar kilitli kalır. Her zaman 'with open(...) as f:' kullanılmalıdır.",
                    commonMistake = "with varken eski yöntemle dosya açıp kapatmayı unutmak."
                )
            ),
            completionCriteria = listOf(
                "with deyimi ile kaynak yönetimi yapabilmek",
                "__enter__ ve __exit__ mekanizmasını anlamak"
            )
        ),

        // ==========================================
        // DERS 11: ASENKRON PYTHON (AsyncIO) VE GIL
        // ==========================================
        Lesson(
            id = "py_11",
            courseId = "python",
            sectionId = "py_sec_5",
            title = "Asenkron Programlama: AsyncIO, async/await ve GIL Sırrı",
            shortDesc = "Event Loop mimarisi, ağ beklemelerinde vakit kaybetmeyen async/await ve Global Interpreter Lock (GIL).",
            level = CourseLevel.ADVANCED,
            order = 11,
            isPremium = true,
            learningObjectives = listOf(
                "Senkron (Bloklayan) vs Asenkron (Non-blocking) programlama farkını anlamak",
                "async def ve await sözdizimi ile coroutine oluşturmak",
                "Global Interpreter Lock (GIL) nedir ve Python performansını nasıl etkiler kavramak"
            ),
            prerequisites = listOf("Fonksiyonlar ve Jeneratörler"),
            subtopics = listOf("Event Loop Mantığı", "async ve await", "asyncio.gather()", "GIL (Global Interpreter Lock)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Asenkron Programlama Mantığı: Restoran Analojisi",
                    body = "Bir garson düşünün (Tek İş Parçacığı / Thread). Masadan siparişi alır ve mutfağa iletir. Yemek pişene kadar (Ağ / Veritabanı gecikmesi) mutfakta dikilip beklemez; gidip diğer masaların siparişini alır. Yemek pişince gidip servis eder.\n\nİşte **AsyncIO**, bekleme sürelerinde CPU'yu boş tutmayıp diğer işleri yapan **Olay Döngüsü (*Event Loop*)** mimarisidir.",
                    codeSnippet = "import asyncio\n\nasync def veri_cek():\n    print('Veri çekiliyor... ⏳')\n    await asyncio.sleep(1) # Thread kilitlenmez, diğer işler devam eder\n    return 'Veri Geldi! ✅'\n\n# asyncio.run(veri_cek())"
                ),
                LessonContentBlock(
                    subtitle = "2. GIL (Global Interpreter Lock) Nedir?",
                    body = "Python'da CPython yorumlayıcısının bellek yönetimini (Reference Counting) güvenli tutmak için kullandığı bir kilit vardır: **GIL**.\n\nGIL yüzünden Python aynı anda sadece tek bir CPU çekirdeğinde bytecode çalıştırabilir. Bu yüzden:\n• **I/O Bound (Ağ, Disk, Veritabanı):** `asyncio` veya `threading` harikadır.\n• **CPU Bound (Görüntü işleme, Yapay zeka):** Çoklu işlemci kullanmak için `multiprocessing` kullanılır.",
                    tip = "Python 3.13+ ile serbest iş parçacıklı (Free-threaded / GIL-free) Python deneysel olarak kullanıma sunulmuştur."
                )
            ),
            codeExample = "import asyncio\n\nasync def selam(ad):\n    await asyncio.sleep(0.5)\n    return f'Merhaba {ad}'\n\n# asyncio.run(selam('Kaan'))",
            codeExplanation = "async def ile coroutine fonksiyonu tanımlandı ve await ile beklemesiz işlem yapıldı.",
            realWorldExample = "FastAPI web çatısı dünyanın en hızlı web kütüphanelerinden biridir çünkü her isteği `async/await` ile asenkron olarak karşılar.",
            practicalTask = "async def kullanarak 2 coroutine tanımlayıp asyncio.gather() ile aynı anda çalıştırmanın mantığını kavrayın.",
            starterPlaygroundCode = "import asyncio\n\nasync def ana_islem():\n    print('Asenkron dünya!')\n\n# asyncio.run(ana_islem())",
            miniQuestion = MiniQuestion(
                id = "py_q_11",
                question = "Python'da asenkron bir fonksiyon (coroutine) tanımlamak için 'def' kelimesinin önüne ne eklenir?",
                options = listOf("async", "await", "coroutine", "thread"),
                correctIndex = 0,
                explanation = "Asenkron fonksiyonlar 'async def' ile tanımlanır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_11",
                lessonId = "py_11",
                title = "Asenkron Selamlayıcı",
                instructions = "isim (str) parametresi alan ve 'Asenkron Selam: [isim]' döndüren `async def async_selam(isim)` fonksiyonunu yazın.",
                exampleInput = "async_selam('Ece')",
                exampleOutput = "'Asenkron Selam: Ece'",
                starterCode = "async def async_selam(isim):\n    # Kodunu yaz:\n    return ''",
                solutionCode = "async def async_selam(isim):\n    return f'Asenkron Selam: {isim}'",
                hints = listOf("return f'Asenkron Selam: {isim}' yazın."),
                testCases = listOf(
                    TestCase("async_selam('Ece').__name__", "async_selam", "Coroutine kontrolü")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_11_1",
                    lessonId = "py_11",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "CPU yoğunluklu (örneğin 10 milyar asal sayı hesaplama) işlemlerde birden çok CPU çekirdeğini kullanmak için hangisi tercih edilmelidir?",
                    options = listOf(
                        "multiprocessing (Ayrı Python süreçleri açarak GIL kilidini aşmak)",
                        "threading",
                        "asyncio",
                        "while döngüsü"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! multiprocessing her çekirdeğe ayrı bir Python yorumlayıcısı açtığı için GIL'i aşar.",
                    explanationWrong = "CPU yoğun işler için multiprocessing kullanılır.",
                    reviewTopic = "Python Multiprocessing vs AsyncIO"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "await kelimesi normal fonksiyon içinde kullanılabilir mi?",
                    answer = "Hayır! await sadece 'async def' ile tanımlanmış bir asenkron fonksiyonun içinde kullanılabilir."
                )
            ),
            communityInsights = listOf(
                CommunityInsight(
                    source = "StackOverflow #1 AsyncIO Hatası",
                    topic = "Neden async fonksiyon içinde time.sleep() kullanmak felakettir?",
                    insight = "async fonksiyon içinde 'time.sleep(5)' yazarsanız tüm Event Loop'u (ve o sırada bekleyen diğer yüzlerce kullanıcının isteğini) 5 saniye boyunca tamamen kilitlersiniz. Asenkron kodlarda her zaman 'await asyncio.sleep(5)' kullanılmalıdır.",
                    commonMistake = "Asenkron projelerde bloklayıcı senkron kütüphaneleri çağırıp uygulamanın hızını sıfıra indirmek."
                )
            ),
            completionCriteria = listOf(
                "async ve await sözdizimini kavramak",
                "GIL'in ne olduğunu ve I/O vs CPU farkını bilmek"
            )
        ),

        // ==========================================
        // DERS 12: PROFESYONEL MİMARİ, IF __NAME__ VE MODÜLLER
        // ==========================================
        Lesson(
            id = "py_12",
            courseId = "python",
            sectionId = "py_sec_6",
            title = "Profesyonel Python: Modüller, if __name__ == '__main__' ve Temiz Kod",
            shortDesc = "Büyük projeleri paketleme, sanal ortamlar (venv), pip ve profesyonel kariyer tavsiyeleri.",
            level = CourseLevel.EXPERT,
            order = 12,
            isPremium = true,
            learningObjectives = listOf(
                "if __name__ == '__main__' kalıbının gerçek amacını kavramak",
                "Python modül ve paket (__init__.py) hiyerarşisini kurmak",
                "Tebrikler: Artık tam donanımlı bir Python geliştiricisisiniz!"
            ),
            prerequisites = listOf("Tüm Python Konuları"),
            subtopics = listOf("if __name__ == '__main__'", "Modüller ve Paketler", "Sanal Ortamlar (venv)", "Kariyer Yolu"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. if __name__ == '__main__' Sırrı",
                    body = "Bir Python dosyasını doğrudan çalıştırdığınızda Python onun `__name__` değişkenine `'__main__'` değerini atar. Ancak o dosyayı başka bir dosyadan `import` ettiğinizde `__name__` dosyanın kendi adı olur.\n\nBu kalıp sayesinde dosyanız hem bağımsız bir betik olarak çalışabilir hem de başka dosyalara kütüphane olarak aktarılırken istem dışı kod çalıştırmaz.",
                    codeSnippet = "def ana_islem():\n    print('Program çalıştı!')\n\nif __name__ == '__main__':\n    # Sadece doğrudan çalıştırıldığında burası devreye girer:\n    ana_islem()"
                ),
                LessonContentBlock(
                    subtitle = "2. Tebrikler! Python Ustası Oldunuz! 🏆",
                    body = "Değişkenlerin işaretçi mantığından Comprehensions'a, OOP ve Dunder metotlardan AsyncIO ve GIL mimarisine kadar Python'ın tüm inceliklerini kavradınız!\n\nArtık Yapay Zekâ, Veri Analizi, Web Geliştirme (FastAPI/Django) veya Otomasyon projelerinizi dünya standartlarında inşa edebilirsiniz! 🚀🐍"
                )
            ),
            codeExample = "def topla(a, b):\n    return a + b\n\nif __name__ == '__main__':\n    print(f'Test: {topla(5, 5)}')",
            codeExplanation = "Modüler ve profesyonel dosya mimarisi örneği oluşturuldu.",
            realWorldExample = "Açık kaynak kütüphanelerin (Numpy, Requests) tüm kaynak kodları bu modüler mimari ve __init__.py paketleme kurallarına göre dağıtılır.",
            practicalTask = "Kendinize bir Python projesi tasarlayın ve modüllere ayırma planınızı oluşturun.",
            starterPlaygroundCode = "print('Python yolculuğunuz başarıyla tamamlandı!')",
            miniQuestion = MiniQuestion(
                id = "py_q_12",
                question = "Bir Python dosyasının doğrudan mı çalıştırıldığını yoksa import mu edildiğini anlamak için hangi değişken kontrol edilir?",
                options = listOf("__name__", "__file__", "__main__", "__module__"),
                correctIndex = 0,
                explanation = "__name__ değişkeni doğrudan çalıştırıldığında '__main__' olur."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_12",
                lessonId = "py_12",
                title = "Modüler Çarpıcı",
                instructions = "a ve b parametrelerini alan, çarpımlarını döndüren ve test edilebilir carp(a, b) fonksiyonunu yazın.",
                exampleInput = "carp(6, 7)",
                exampleOutput = "42",
                starterCode = "def carp(a, b):\n    # Kodunu yaz:\n    return 0",
                solutionCode = "def carp(a, b):\n    return a * b",
                hints = listOf("return a * b yazın."),
                testCases = listOf(
                    TestCase("carp(6, 7)", "42", "6x7")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_12_1",
                    lessonId = "py_12",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Python projelerinde neden her zaman Sanal Ortam (Virtual Environment / venv) kullanılmalıdır?",
                    options = listOf(
                        "Farklı projelerin kullandığı kütüphane ve paket sürümlerinin birbirini bozmasını önleyip izole bir çalışma alanı oluşturmak için",
                        "Python'ı daha hızlı çalıştırmak için",
                        "Dosya boyutunu küçültmek için",
                        "Sadece Windows'ta çalıştığı için"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Sanal ortamlar paket bağımlılığı çakışmalarını engeller.",
                    explanationWrong = "venv paket bağımlılıklarını izole tutar.",
                    reviewTopic = "Python Sanal Ortamlar (venv)"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "requirements.txt dosyası ne işe yarar?",
                    answer = "Projenin çalışması için gereken tüm dış kütüphaneleri ve kesin sürümlerini listeler (pip install -r requirements.txt ile kurulur)."
                )
            ),
            communityInsights = listOf(
                CommunityInsight(
                    source = "Reddit r/learnpython Mezuniyet Tavsiyesi",
                    topic = "Python öğrendikten sonraki en verimli adım",
                    insight = "Artık sadece tutorial izlemeyi bırakıp kendi projelerinizi yapma zamanı: 1) FastAPI ile bir REST API yazın, 2) BeautifulSoup ile veri kazıyın (Scraping), 3) Pandas ve Matplotlib ile veri görselleştirin. Kendi projenizi kodlamak bilgiyi kalıcı hale getiren tek yoldur.",
                    commonMistake = "Sonsuz tutorial izleme döngüsünde (Tutorial Hell) kalıp proje üretmemek."
                )
            ),
            completionCriteria = listOf(
                "if __name__ == '__main__' kalıbını doğru kullanabilmek",
                "Temiz ve profesyonel Python projeleri geliştirebilmek"
            )
        )
    )
}
