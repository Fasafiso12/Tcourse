package com.example.data.catalog

import com.example.model.*

/**
 * Python Complete Official Curriculum (12 Sequential Lessons):
 * BEGINNER -> FUNDAMENTAL -> INTERMEDIATE -> ADVANCED -> EXPERT
 * Seamless progression from basic syntax & data structures to AsyncIO, Metaclasses & CPython internals.
 */
object PythonCurriculum {

    fun getSections(): List<CourseSection> = listOf(
        CourseSection(
            id = "py_sec_1",
            courseId = "python",
            title = "Seviye 1 – Python Temelleri, Sözdizimi & Kontrol Akışı",
            level = CourseLevel.BEGINNER,
            order = 1,
            description = "Python felsefesi (Zen of Python), dinamik tip sistemi, değişkenler, f-strings, if-elif-else koşulları ve for/while döngüleri.",
            learningObjectives = listOf("Python yorumlayıcı modeli & dinamik tipleme", "f-string ile modern metin formatlama", "if-elif-else karar yapıları", "for ve while döngüleri & range()"),
            prerequisites = listOf("Temel bilgisayar kullanım bilgisi")
        ),
        CourseSection(
            id = "py_sec_2",
            courseId = "python",
            title = "Seviye 2 – Fonksiyonlar, Veri Yapıları & Comprehensions",
            level = CourseLevel.BEGINNER,
            order = 2,
            description = "Fonksiyonlar (*args, **kwargs), Listeler, Tuple'lar, Kümeler (Set), Sözlükler (Dict), List/Dict Comprehensions ve Dosya I/O.",
            learningObjectives = listOf("Fonksiyonlar & *args, **kwargs parametreleri", "List, Tuple, Set, Dict veri yapıları", "List/Dict Comprehension kalıpları", "Dosya işlemleri (with open)"),
            prerequisites = listOf("Python Temelleri & Kontrol Akışı")
        ),
        CourseSection(
            id = "py_sec_3",
            courseId = "python",
            title = "Seviye 3 – Hata Yönetimi & Nesne Yönelimli Programlama (OOP)",
            level = CourseLevel.INTERMEDIATE,
            order = 3,
            description = "try-except-else-finally hata yönetimi, Sınıflar (class), __init__, self referansı, Kalıtım, Çok Biçimlilik ve Dunder (Magic) metotlar.",
            learningObjectives = listOf("try-except-finally & Özel İstisna sınıfları", "Sınıflar, __init__ ve self mimarisi", "Kalıtım (Inheritance) & super()", "Dunder metotlar (__str__, __repr__, __len__)"),
            prerequisites = listOf("Python Fonksiyonlar ve Veri Yapıları")
        ),
        CourseSection(
            id = "py_sec_4",
            courseId = "python",
            title = "Seviye 4 – Dekoratörler, Jeneratörler & Context Managers",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            description = "First-class fonksiyonlar, Fonksiyon ve Sınıf Dekoratörleri (@wraps), yield ile Jeneratörler ve 'with' Context Managers (__enter__, __exit__).",
            learningObjectives = listOf("Decorator deseni ve parametreli dekoratörler", "yield ile bellek dostu jeneratörler & iteratörler", "Context Manager mimarisi (__enter__, __exit__)", "@property ile kapsülleme"),
            prerequisites = listOf("Python OOP ve Temel Sınıflar")
        ),
        CourseSection(
            id = "py_sec_5",
            courseId = "python",
            title = "Seviye 5 – Asenkron Python (AsyncIO) & Concurrency (Threading vs Multi-process)",
            level = CourseLevel.ADVANCED,
            order = 5,
            description = "AsyncIO Event Loop mimarisi, async/await, Task orkestrasyonu, Threading vs Multiprocessing farkları ve GIL (Global Interpreter Lock).",
            learningObjectives = listOf("AsyncIO Event Loop ve coroutine yürütme", "asyncio.gather & Task yönetimi", "GIL (Global Interpreter Lock) kısıtlamaları", "CPU-bound vs I/O-bound iş parçacığı stratejisi"),
            prerequisites = listOf("Python Dekoratörler ve Jeneratörler")
        ),
        CourseSection(
            id = "py_sec_6",
            courseId = "python",
            title = "Seviye 6 – Metaprogramming, Descriptors & CPython Internals",
            level = CourseLevel.EXPERT,
            order = 6,
            description = "Metasınıflar (Metaclasses - type vs object), Descriptor Protokolü (__get__, __set__), CPython PyObject anatomisi, Cyclic GC ve Bytecode analizi.",
            learningObjectives = listOf("Metaclasses ile dinamik sınıf inşası", "Descriptor protokolü ile ORM mimarisi", "CPython Reference Counting & Cyclic GC", "dis modülü ile Python Bytecode analizi"),
            prerequisites = listOf("İleri Düzey Python, OOP ve Asenkron Mimari")
        )
    )

    fun getLessons(): List<Lesson> = listOf(
        // ==========================================
        // DERS 1: TEMEL SÖZDİZİMİ, DEĞİŞKENLER & TİPLER (ÜCRETSİZ)
        // ==========================================
        Lesson(
            id = "py_1",
            courseId = "python",
            sectionId = "py_sec_1",
            title = "CPython Mimarisi, PyObject & Değişken Modeli",
            shortDesc = "CPython sanal makinesi (VM), PyObject C yapısı, dinamik tip bağlama, Referans Sayımı (Refcounting), Small Integer Caching ve f-strings.",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false,
            learningObjectives = listOf(
                "CPython yorumlayıcısının Bytecode ve yığın tabanlı (Stack-based) VM mimarisini anlamak",
                "Python değişkenlerinin bellek kutusu değil, PyObject işaretçisi (Pointer) olduğunu kavramak",
                "Referans Sayımı (Reference Counting) ve Small Integer Caching (-5..256) mekanizmalarını öğrenmek",
                "f-string formatlama ve str bellek optimizasyonlarını (String Interning) kullanmak"
            ),
            prerequisites = listOf("Ön koşul gerekmez. Sıfırdan başlar."),
            subtopics = listOf("CPython, Bytecode (.pyc) & Stack VM", "PyObject C Yapısı (ob_refcnt, ob_type)", "Değişkenler: Referans İsim Etiketleri", "Small Integer Caching & String Interning", "id(), is vs == Farkı & f-strings"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. CPython Yorumlayıcısı ve PyObject Bellek Mimarisi",
                    body = "Python standart uygulaması (CPython), kaynak kodu önce derleyerek taşınabilir **Bytecode** (.pyc) talimatlarına çevirir; ardından bu bayt kodları yığın tabanlı sanal makinede (Evaluation Loop) yürütür.\n\nPython'da her değer bellekte bir C yapısı olan `PyObject` (veya değişken boyutlular için `PyVarObject`) olarak temsil edilir. Her `PyObject` en az iki temel alan içerir:\n1. `ob_refcnt`: Nesneye işaret eden referans sayısı (Garbage Collector için).\n2. `ob_type`: Nesnenin tipini belirten tip tanımlayıcı işaretçi (`PyTypeObject*`).\n\nBu nedenle Python'da `a = 100` yazıldığında değişken bir bellek kutusu değil, Heap üzerindeki bir `PyLongObject` nesnesini gösteren bir isim etiketidir (Pointer).",
                    codeSnippet = "import sys\n\nx = 1000\nprint(f'Bellek Adresi: {hex(id(x))}')\nprint(f'Referans Sayısı: {sys.getrefcount(x)}') # x'e işaret eden referans adedi\n\ny = x # Yeni bir referans bağlanır, nesne kopyalanmaz!\nprint(x is y) # True (Aynı bellek adresini işaret eder)"
                ),
                LessonContentBlock(
                    subtitle = "2. Small Integer Caching ve String Interning Optimizasyonları",
                    body = "CPython bellek tahsis maliyetini düşürmek için sık kullanılan nesneleri önceden belleğe alır (Pre-allocation):\n\n• **Small Integer Caching:** `-5` ile `256` arasındaki tüm tamsayılar CPython başlatılırken tek seferde belleğe tahsis edilir. Bu aralıktaki sayılar her istendiğinde yeni nesne üretilmez, önbellekteki aynı tekil adrese yönlendirilir.\n• **String Interning:** Değişken isimleri ve ASCII tanımlayıcılar bellekte tekilleştirilerek (intern) `is` ile O(1) hızında adres karşılaştırmasına olanak tanır.",
                    codeSnippet = "a = 250\nb = 250\nprint(a is b) # True! (-5..256 aralığında önbellekten gelir)\n\nc = 1000\nd = 1000\nprint(c is d) # False! (Farklı Heap nesneleri üretilir, ancak c == d True'dur)"
                ),
                LessonContentBlock(
                    subtitle = "3. Modern Metin Formatlama (f-strings) ve Biçimlendirme",
                    body = "Python 3.6+ ile gelen 'Formatted String Literals' (f-strings), `str.format()` ve `%` operatörlerine kıyasla doğrudan C düzeyinde `BUILD_STRING` bayt koduna derlenir; bu sayede çalışma zamanında en yüksek hız ve okunabilirlik sağlar.",
                    codeSnippet = "ad = 'Emre'\nmaas = 45000.758\n\n# f-string ile formatlama ve ifade çözümleme:\nprint(f'{ad.upper()} -> Aylık: {maas:,.2f} TL (Yıllık: {maas * 12:,.0f} TL)')\n# Çıktı: EMRE -> Aylık: 45,000.76 TL (Yıllık: 540,009 TL)",
                    tip = "Python'da girintiler (indentation) sadece kod düzeni için değil, mantıksal blokların (scope) sınırlarını belirlemek için zorunludur (standart olarak 4 boşluk)."
                )
            ),
            codeExample = "ad = 'Elif'\npuan = 94.5\ndurum = True\n\nprint(f'Öğrenci: {ad} | Not: {puan:.1f} | Geçti mi: {durum}')",
            codeExplanation = "puan:.1f formatlayıcısı ondalığı tek basamağa yuvarlar. f-string doğrudan çalışma anında ifadeyi çözümler.",
            realWorldExample = "Instagram ve Spotify backend servisleri, veri bilimi ve makine öğrenmesi modellerinin %90'ı Python temeli üzerinde koşar.",
            practicalTask = "Kullanıcıdan alınan iki sayının aritmetik ortalamasını f-string kullanarak ekrana yazdıran bir Python betiği yazın.",
            starterPlaygroundCode = "a = 10\nb = 20\nprint(f'Toplam: {a + b}')",
            miniQuestion = MiniQuestion(
                id = "py_q_1",
                question = "CPython'da değişkenlerin bellekte doğrudan bir kutu yerine birer referans etiketi olmasını sağlayan temel C yapısı hangisidir?",
                options = listOf("PyObject", "VoidPointer", "PyBox", "RefCell"),
                correctIndex = 0,
                explanation = "CPython'da tüm tipler en temelde 'PyObject' C yapısı olarak Heap üzerinde yönetilir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_1",
                lessonId = "py_1",
                title = "Öğrenci Karne Özeti",
                instructions = "Öğrenci adı (str) ve puanı (float) verildiğinde 'Ahmet: 85.0 Puan' formatında f-string çıktısı üreten karne_ozeti(ad, puan) fonksiyonunu yazın.",
                exampleInput = "ad = 'Ahmet', puan = 85",
                exampleOutput = "'Ahmet: 85.0 Puan'",
                starterCode = "def karne_ozeti(ad: str, puan: float) -> str:\n    # Kodunu buraya yaz:\n    return ''",
                solutionCode = "def karne_ozeti(ad: str, puan: float) -> str:\n    return f'{ad}: {float(puan):.1f} Puan'",
                hints = listOf("f'{ad}: {float(puan):.1f} Puan' formatını kullanın."),
                testCases = listOf(
                    TestCase("karne_ozeti('Ahmet', 85)", "Ahmet: 85.0 Puan", "Normal karne")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_1_1",
                    lessonId = "py_1",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Python'da 'a = 10' ve ardından 'a = \"Merhaba\"' yazıldığında ne gerçekleşir?",
                    options = listOf("Tip uyuşmazlığı hatası verir", "a etiketi dinamik olarak string nesnesini işaret etmeye başlar", "Bellek taşması oluşur", "Değişken sıfırlanır"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Python dinamik tiplidir; değişkenler farklı tiplerdeki nesnelere serbestçe yeniden bağlanabilir.",
                    explanationWrong = "Python dinamik tiplemeye sahiptir; hata vermez.",
                    reviewTopic = "Dinamik Tipleme"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Python'da 'is' ile '==' arasındaki fark nedir?",
                    answer = "'==' nesnelerin içerik eşitliğini (`__eq__`) denetlerken, 'is' iki referansın bellekte tam olarak aynı nesneyi (aynı bellek adresi / id) gösterip göstermediğini doğrular."
                )
            ),
            completionCriteria = listOf(
                "Dinamik değişken tanımlamayı ve PyObject modelini kavramak",
                "f-string formatlama yapabilmek",
                "Temel veri tipleri arasında dönüşüm yapabilmek"
            )
        ),

        // ==========================================
        // DERS 2: KOŞULLU İFADELER, OPERATÖRLER & DÖNGÜLER (ÜCRETSİZ)
        // ==========================================
        Lesson(
            id = "py_2",
            courseId = "python",
            sectionId = "py_sec_1",
            title = "Kontrol Akışı, İteratör Protokolü & Döngüler",
            shortDesc = "Mantıksal operatörler, Short-Circuit değerlendirmesi, if-elif-else, İteratör Protokolü (__iter__, __next__), for-else ve range().",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false,
            learningObjectives = listOf(
                "Python mantıksal operatörlerinin Kısa Devre (Short-Circuit) çalışma prensibini öğrenmek",
                "Python İteratör Protokolü (__iter__, __next__, StopIteration) mimarisini kavramak",
                "for, while ve for-else arama deseni ile algoritmik akış kurmak",
                "enumerate() ve zip() fonksiyonlarını bellek verimli kullanmak"
            ),
            prerequisites = listOf("Python'a Giriş, Değişkenler & Veri Tipleri"),
            subtopics = listOf("Short-Circuit Evaluation (Kısa Devre)", "if, elif, else & Truthy/Falsy Değerler", "Python İteratör Protokolü (__iter__, __next__)", "for Döngüsü, range() & enumerate()", "Döngülerde 'else' Bloğu Arama Deseni"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Kısa Devre (Short-Circuit) ve Truthy / Falsy Değerler",
                    body = "Python'da koşullu değerlendirme yapılırken tüm nesneler `bool(x)` ile boolean bağlamına uyarlanır:\n• **Falsy Değerler:** `False`, `None`, `0`, `0.0`, `''`, `[]`, `()`, `{}`\n• **Truthy Değerler:** Sıfır olmayan sayılar ve boş olmayan tüm koleksiyonlar.\n\n`and` ve `or` operatörleri sadece boolean döndürmez, 'kısa devre' yaparak değerlendirmeyi durduran son nesneyi döner:\n• `A or B`: Eğer A truthy ise doğrudan `A` değerini döner (B'ye hiç bakmaz).\n• `A and B`: Eğer A falsy ise doğrudan `A` değerini döner; aksi takdirde `B`'yi döner.",
                    codeSnippet = "kullanici_girdisi = ''\nvarsayilan_ad = kullanici_girdisi or 'Misafir' # 'Misafir'\n\n# Güvenli erişim kısa devresi:\nveritabani = None\n# veritabani.baglan() çağrılmaz çünkü sol taraf Falsy:\nsonuc = veritabani and veritabani.baglan()"
                ),
                LessonContentBlock(
                    subtitle = "2. Python İteratör Protokolü (__iter__ & __next__)",
                    body = "Python'da `for` döngüsü indeksli bir sayaç değildir. Herhangi bir nesne üzerinde `for x in koleksiyon:` yazıldığında arka planda şu adımlar gerçekleşir:\n1. Koleksiyonun `iter(koleksiyon)` (yani `koleksiyon.__iter__()`) metodu çağrılarak bir **Iterator** nesnesi üretilir.\n2. Döngü her adımda `next(iterator)` (yani `iterator.__next__()`) çağırır.\n3. Elemanlar bittiğinde nesne `StopIteration` istisnası fırlatır ve `for` döngüsü bu istisnayı sessizce yakalayarak döngüyü sonlandırır.",
                    codeSnippet = "liste = [10, 20]\nit = iter(liste)\nprint(next(it)) # 10\nprint(next(it)) # 20\n# print(next(it)) # StopIteration hatası fırlatılır!"
                ),
                LessonContentBlock(
                    subtitle = "3. for-else Deseni ve Çoklu İteratörler (enumerate, zip)",
                    body = "• **for-else:** Eğer döngü bir `break` ifadesi ile erken kesilmeden doğal olarak tamamlanırsa `else` bloğu tetiklenir. Bu sayede 'flag' değişkeni kullanmadan arama ve asal sayı algoritmaları yazılır.\n• **enumerate():** Sayacı ve değeri `(index, value)` demeti olarak tembel (lazy) üretir.\n• **zip():** Birden çok iterable nesneyi paralel eşleştirir.",
                    codeSnippet = "# for-else Arama Deseni:\nfor n in [2, 4, 6, 8]:\n    if n == 5:\n        print('Bulundu!')\n        break\nelse:\n    print('5 sayısı listede yer almıyor.') # break çalışmadığı için çalışır"
                )
            ),
            codeExample = "toplam = 0\nfor i in range(1, 11):\n    if i % 2 == 0:\n        toplam += i\n        print(f'{i} eklendi.')\nprint(f'1-10 arası çift sayıların toplamı: {toplam}')",
            codeExplanation = "range(1, 11) 1'den 10'a kadar döner. i % 2 == 0 ile çift sayılar tespit edilir ve toplama eklenir.",
            realWorldExample = "Veri analitiğinde satır satır veri filtreleme veya web scraping botlarında sayfa sayfa gezme for döngüleriyle yapılır.",
            practicalTask = "1'den 50'ye kadar olan asal sayıları bulan bir for döngüsü yazın.",
            starterPlaygroundCode = "for i in range(5):\n    print(f'Adım {i}')",
            miniQuestion = MiniQuestion(
                id = "py_q_2",
                question = "Python'da bir nesnenin for döngüsünde gezilebilmesi için hangi protokolü ve metodları desteklemesi gerekir?",
                options = listOf("Iterator Protokolü (__iter__ ve __next__)", "Array Protokolü (get_item)", "Callable Protokolü (__call__)", "Serializable Protokolü"),
                correctIndex = 0,
                explanation = "Python'da yinelenebilir her nesne Iterator protokolüne (__iter__ ve __next__) uymak zorundadır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_2",
                lessonId = "py_2",
                title = "Faktöriyel Hesaplayıcı",
                instructions = "Verilen n tamsayısının faktöriyelini döngü kullanarak hesaplayan faktoriyel(n) fonksiyonunu yazın (0! = 1).",
                exampleInput = "n = 5",
                exampleOutput = "120",
                starterCode = "def faktoriyel(n: int) -> int:\n    # Kodunu buraya yaz:\n    return 1",
                solutionCode = "def faktoriyel(n: int) -> int:\n    sonuc = 1\n    for i in range(2, n + 1):\n        sonuc *= i\n    return sonuc",
                hints = listOf("range(2, n + 1) ile çarpın."),
                testCases = listOf(
                    TestCase("faktoriyel(5)", "120", "5!"),
                    TestCase("faktoriyel(0)", "1", "0!")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_2_1",
                    lessonId = "py_2",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Python'da bir for döngüsünün 'else' bloğu ne zaman çalışır?",
                    options = listOf("Döngüye hiç girilmediğinde", "Döngü bir 'break' ifadesi ile kırılmadan normal şekilde tamamlandığında", "Sadece hata oluştuğunda", "Her adımda"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! for-else bloğu döngü 'break' olmadan başarıyla sonlandığında tetiklenir.",
                    explanationWrong = "Döngü break ile kırılmadan tamamlandığında else bloğu çalışır.",
                    reviewTopic = "for-else Yapısı"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "enumerate() fonksiyonu ne işe yarar?",
                    answer = "Döngü sırasında hem indeksi hem de elemanı aynı anda demet (index, value) olarak almanızı sağlar: `for i, eleman in enumerate(liste):`"
                )
            ),
            completionCriteria = listOf(
                "if-elif-else bloklarını doğru kurabilmek",
                "İteratör protokolünün çalışma mantığını bilmek",
                "range(), enumerate() ve zip() fonksiyonlarını kullanabilmek"
            )
        ),

        // ==========================================
        // DERS 3: FONKSİYONLAR, *ARGS, **KWARGS & SCOPE
        // ==========================================
        Lesson(
            id = "py_3",
            courseId = "python",
            sectionId = "py_sec_2",
            title = "Fonksiyon Mimarisi, Parametreler & LEGB Kapsamı",
            shortDesc = "Pass-by-Object-Reference, Mutable Default Trap, *args & **kwargs paket çözme, LEGB Kapsam kuralları ve global/nonlocal yönergeleri.",
            level = CourseLevel.BEGINNER,
            order = 3,
            isPremium = false,
            learningObjectives = listOf(
                "Python'ın 'Pass-by-Object-Reference' (Call-by-Sharing) parametre aktarım mekanizmasını kavramak",
                "Değiştirilebilir Varsayılan Parametre Tuzağı'ndan (Mutable Default Trap) kaçınmak",
                "*args ve **kwargs ile esnek fonksiyon imzaları ve unpacking tasarlamak",
                "LEGB (Local, Enclosing, Global, Built-in) kapsam arama sırasını ve nonlocal kullanımını öğrenmek"
            ),
            prerequisites = listOf("Python Kontrol Akışı & Döngüler"),
            subtopics = listOf("Pass-by-Object-Reference (Call-by-Sharing)", "Mutable Default Argument Trap", "*args (Tuple Unpacking) & **kwargs (Dict Unpacking)", "LEGB Scope Hiyerarşisi & Bayt Kod Karşılığı", "global vs nonlocal Yönergeleri"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Parametre Aktarımı: Pass-by-Object-Reference (Call-by-Sharing)",
                    body = "Python'da argümanlar ne 'Pass-by-Value' ne de 'Pass-by-Reference' olarak geçer; **Pass-by-Object-Reference** (Nesne Referansıyla Aktarım) geçerlidir.\n\nFonksiyona parametre olarak bir nesne verildiğinde, fonksiyonun yerel değişkenine o nesnenin referansı atanır. Eğer nesne değiştirilemez (immutable: int, str, tuple) ise fonksiyon içinde yapılan değişiklikler dışarıyı etkilemez. Ancak nesne değiştirilebilir (mutable: list, dict, set) ise nesne üzerinde yapılan yerinde mutasyonlar (`list.append()`) orijinal nesneyi doğrudan değiştirir.",
                    codeSnippet = "def listeye_ekle(l):\n    l.append(99) # Orijinal listeyi değiştirir!\n\nsayilar = [1, 2]\nlisteye_ekle(sayilar)\nprint(sayilar) # [1, 2, 99]"
                ),
                LessonContentBlock(
                    subtitle = "2. Değiştirilebilir Varsayılan Parametre Tuzağı (Mutable Default Trap)",
                    body = "Python'da varsayılan parametreler fonksiyon çağrıldığında DEĞİL, fonksiyon ilk tanımlandığı (derlendiği) anda TEK SEFERLİK değerlendirilir ve `__defaults__` demetine kaydedilir.\n\nEğer varsayılan değer olarak `def ekle(eleman, liste=[])` yazarsanız, fonksiyonun tüm çağrıları aynı liste nesnesini paylaşır!",
                    codeSnippet = "# ❌ HATALI KULLANIM:\ndef kuyruk_ekle(veri, kuyruk=[]):\n    kuyruk.append(veri)\n    return kuyruk\n\n# ✅ DOĞRU PYTHONIC PRATİK:\ndef kuyruk_ekle_guvenli(veri, kuyruk=None):\n    if kuyruk is None:\n        kuyruk = [] # Her çağrıda yeni bir heap listesi üretilir\n    kuyruk.append(veri)\n    return kuyruk"
                ),
                LessonContentBlock(
                    subtitle = "3. *args, **kwargs ve LEGB Kapsam Çözümlemesi",
                    body = "• `*args`: Konumsal fazlalık argümanları bir Tuple içinde toplar.\n• `**kwargs`: İsimlendirilmiş argümanları bir Dict içinde toplar.\n• **LEGB Kuralı:** Python bir değişken adına erişirken sırasıyla **Local** (fonksiyon içi) -> **Enclosing** (dış çevreleyen fonksiyon) -> **Global** (modül seviyesi) -> **Built-in** (yerleşik: len, range) kapsamlarını tarar.",
                    codeSnippet = "def dis_fonksiyon():\n    sayac = 0\n    def ic_fonksiyon():\n        nonlocal sayac # Enclosing kapsamındaki sayac değişkenini bağlar\n        sayac += 1\n        return sayac\n    return ic_fonksiyon\n\ns = dis_fonksiyon()\nprint(s()) # 1\nprint(s()) # 2"
                )
            ),
            codeExample = "def topla_carp(carpan, *sayilar):\n    return [s * carpan for s in sayilar]\n\nprint(topla_carp(3, 1, 2, 3, 4)) # [3, 6, 9, 12]",
            codeExplanation = "carpan=3 olarak atanır, geri kalan tüm sayılar *sayilar tuple'ında toplanır ve comprehension ile çarpılır.",
            realWorldExample = "Django ve Flask web framework'lerinde rota görünüm fonksiyonları (*args, **kwargs) alarak tüm HTTP parametrelerini yakalar.",
            practicalTask = "İstediğiniz kadar sayı alan ve bu sayıların geometrik ortalamasını hesaplayan bir fonksiyon yazın.",
            starterPlaygroundCode = "kare = lambda x: x * x\nprint(kare(7))",
            miniQuestion = MiniQuestion(
                id = "py_q_3",
                question = "Python'da 'def ekle(x, l=[])' şeklinde varsayılan liste tanımlandığında yaşanan tehlikenin adı nedir?",
                options = listOf("Mutable Default Argument Trap", "Stack Overflow", "Type Erasure", "Deadlock"),
                correctIndex = 0,
                explanation = "Varsayılan parametreler fonksiyon derleme anında bir kez üretildiği için mutable nesneler tüm çağrılar arasında paylaşılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_3",
                lessonId = "py_3",
                title = "Esnek Toplayıcı (*args)",
                instructions = "Gelen tüm sayısal argümanları (*args) toplayan, hiç argüman gelmezse 0 döndüren esnek_topla(*args) fonksiyonunu yazın.",
                exampleInput = "esnek_topla(10, 20, 30, 40)",
                exampleOutput = "100",
                starterCode = "def esnek_topla(*args) -> int:\n    # Kodunu buraya yaz:\n    return 0",
                solutionCode = "def esnek_topla(*args) -> int:\n    return sum(args)",
                hints = listOf("sum(args) yerleşik fonksiyonunu kullanın."),
                testCases = listOf(
                    TestCase("esnek_topla(10, 20, 30, 40)", "100", "4 sayı"),
                    TestCase("esnek_topla()", "0", "Boş çağrı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_3_1",
                    lessonId = "py_3",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Python'da değişken arama sırasını belirleyen LEGB kuralı ne anlama gelir?",
                    options = listOf("Local -> Enclosing -> Global -> Built-in", "List -> Element -> Group -> Block", "Literal -> Expression -> Global -> Binary", "Loop -> Exit -> Goto -> Break"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! LEGB: Önce yerel (Local), sonra çevreleyen (Enclosing), sonra global, en son yerleşik (Built-in) kapsam taranır.",
                    explanationWrong = "LEGB açılımı Local, Enclosing, Global, Built-in şeklindedir.",
                    reviewTopic = "Python Scope"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "global ile nonlocal anahtar kelimeleri arasındaki fark nedir?",
                    answer = "'global' modül seviyesindeki global değişkene erişmek için kullanılırken, 'nonlocal' iç içe (nested) fonksiyonlarda bir üst fonksiyonun yerel değişkenini değiştirmek için kullanılır."
                )
            ),
            completionCriteria = listOf(
                "*args ve **kwargs parametrelerini ustalıkla kullanabilmek",
                "Mutable default argument tuzağından kaçınabilmek",
                "LEGB kapsam kurallarını açıklayabilmek"
            )
        ),

        // ==========================================
        // DERS 4: VERİ YAPILARI: LIST, TUPLE, SET, DICT & COMPREHENSIONS
        // ==========================================
        Lesson(
            id = "py_4",
            courseId = "python",
            sectionId = "py_sec_2",
            title = "Veri Yapıları & Hash Mimarisi (List, Tuple, Set, Dict)",
            shortDesc = "List dinamik dizi over-allocation büyümesi, Tuple immutability, Dict & Set Hash Table mimarisi (O(1)) ve Comprehensions.",
            level = CourseLevel.BEGINNER,
            order = 4,
            isPremium = true,
            learningObjectives = listOf(
                "Python List'in ardışık işaretçi dizisi (Array of pointers) ve over-allocation büyüme modelini anlamak",
                "Dict ve Set veri yapılarının Compact Hash Table mimarisini (O(1) lookup) kavramak",
                "Tuple ve List arasındaki bellek boyutu ve değişmezlik (Immutability) farklarını bilmek",
                "List, Dict ve Set Comprehensions ile yüksek hızlı veri dönüşümleri yapmak"
            ),
            prerequisites = listOf("Python Fonksiyonlar ve Scope"),
            subtopics = listOf("List Mimarisi: Dinamik Dizi & Over-allocation", "Tuple İmmutability & Small Tuple Freelist", "Dict Compact Hash Table Mimarisi", "Set Hash Table (Open Addressing & Quadratic Probing)", "List/Set/Dict Comprehensions"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. List ve Tuple: Bellek Tahsisi ve Büyüme Stratejisi",
                    body = "• **List:** Bellekte ardışık işaretçiler dizisidir (`PyObject**`). `list.append()` yapıldığında her seferinde `realloc` çağırmamak için CPython **Over-allocation** stratejisi (yaklaşık %12 büyüme faktörü) uygular. Bu sayede sona ekleme amorti edilmiş O(1) maliyetlidir.\n• **Tuple:** Boyutu ve elemanları sabittir. Bellek tahsisi tektir ve CPython 20 elemana kadar olan tuple'lar için `free_list` önbelleği tutar.",
                    codeSnippet = "import sys\n\nl = []\nprint(sys.getsizeof(l)) # Boş liste boyutu\nl.append(1)\nprint(sys.getsizeof(l)) # Over-allocation ile fazladan bellek rezerve edilir"
                ),
                LessonContentBlock(
                    subtitle = "2. Dict ve Set: Compact Hash Table Mimarisi (O(1))",
                    body = "Python 3.6+ ile Dict yapısı tamamen yeniden yazılarak **Compact Hash Table** haline getirilmiştir. İki ayrı tablodan oluşur:\n1. Seyrek İndeks Tablosu (Sparse Hash Indices)\n2. Yoğun Giriş Dizisi (Dense Entries Array: `[hash, key, value]`)\n\nBu tasarım bellek kullanımını %30-40 azaltırken, elemanların ekleme sırasını (Insertion Order) varsayılan olarak garanti altına almıştır. Arama, ekleme ve silme işlemleri Hash fonksiyonu sayesinde ortalama **O(1)** karmaşıklığındadır.",
                    codeSnippet = "kullanici = {'id': 101, 'ad': 'Deniz'}\n# get() ile güvenli erişim (KeyError fırlatmaz):\nrol = kullanici.get('rol', 'Standart')\n\n# setdefault ile yoksa ekleme:\nkullanici.setdefault('aktif', True)"
                ),
                LessonContentBlock(
                    subtitle = "3. Comprehensions ile C Düzeyinde Optimize Dönüşümler",
                    body = "Comprehensions, standart `for` döngülerine kıyasla bayt kod seviyesinde `LIST_APPEND` talimatını doğrudan yürüttüğü için hem çok daha temizdir hem de kat kat hızlı çalışır.",
                    codeSnippet = "# List Comprehension:\ncift_kareler = [x**2 for x in range(10) if x % 2 == 0]\n\n# Dict Comprehension:\nkare_tablosu = {x: x**2 for x in range(5)}\n\n# Set Comprehension (Otomatik tekilleştirme):\ntekil_uzunluklar = {len(w) for w in ['kod', 'python', 'kod', 'dart']}"
                )
            ),
            codeExample = "sayilar = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]\n# Çift sayıların küpünü alan tek satırlık comprehension:\ncift_kupler = [n**3 for n in sayilar if n % 2 == 0]\n\nprint(f'Çift Küpler: {cift_kupler}') # [8, 64, 216, 512, 1000]",
            codeExplanation = "for döngüsü ve if koşulu tek bir köşeli parantez içinde birleştirilerek Pythonic kod üretildi.",
            realWorldExample = "Pandas ve veri işleme hatlarında binlerce satırlık veri sütunları List Comprehension ile nanosaniyeler içinde temizlenir.",
            practicalTask = "Bir metindeki her kelimenin kaç kez geçtiğini sayan (kelime frekansı) bir Dict üreten kod yazın.",
            starterPlaygroundCode = "meyveler = ['elma', 'armut', 'muz']\nuzunluklar = {m: len(m) for m in meyveler}\nprint(uzunluklar)",
            miniQuestion = MiniQuestion(
                id = "py_q_4",
                question = "Python 3.6+ sürümünden itibaren Dict veri yapısının eleman ekleme sırasını korumasını sağlayan mimari hangisidir?",
                options = listOf("Compact Hash Table (Dense & Sparse Array)", "Red-Black Tree", "B-Tree", "Linked List Chain"),
                correctIndex = 0,
                explanation = "Python 3.6+ Compact Hash Table mimarisi seyrek hash indeksi ve yoğun giriş dizisi kullanarak ekleme sırasını korur."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_4",
                lessonId = "py_4",
                title = "Kelime Uzunluğu Filtresi (Comprehension)",
                instructions = "Verilen kelime listesindeki uzunluğu en az 'min_len' karakter olan kelimeleri BÜYÜK HARFLERLE listeye dönüştüren filtrele(kelimeler, min_len) fonksiyonunu comprehension ile yazın.",
                exampleInput = "kelimeler = ['elma', 'su', 'bilgisayar'], min_len = 4",
                exampleOutput = "['ELMA', 'BILGISAYAR']",
                starterCode = "def filtrele(kelimeler: list, min_len: int) -> list:\n    # Kodunu buraya yaz:\n    return []",
                solutionCode = "def filtrele(kelimeler: list, min_len: int) -> list:\n    return [k.upper() for k in kelimeler if len(k) >= min_len]",
                hints = listOf("[k.upper() for k in kelimeler if len(k) >= min_len] kullanın."),
                testCases = listOf(
                    TestCase("filtrele(['elma', 'su', 'kod'], 3)", "['ELMA', 'KOD']", "Min 3 uzunluk")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_4_1",
                    lessonId = "py_4",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir listenin elemanlarını ters çevirmek için en hızlı dilimleme (slicing) yöntemi hangisidir?",
                    options = listOf("liste[::-1]", "liste.reverse_all()", "liste[0:-1]", "liste[1::]"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! `liste[::-1]` dilimi adımı -1 yaparak listeyi C hızında ters çevirir.",
                    explanationWrong = "liste[::-1] sözdizimi kullanılır.",
                    reviewTopic = "Python Slicing"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Tuple neden List'ten daha az bellek harcar?",
                    answer = "Tuple immutable (değişmez) olduğu için over-allocation yapmaz ve tam gereken boyutta tekil bir C struct tahsis eder."
                )
            ),
            completionCriteria = listOf(
                "List, Tuple, Set ve Dict arasındaki bellek ve zaman karmaşıklıklarını bilmek",
                "List ve Dict comprehension yapılarını uygulayabilmek",
                "Dilimleme ([start:stop:step]) kurallarını etkin kullanabilmek"
            )
        ),

        // ==========================================
        // DERS 5: HATA YÖNETİMİ & DOSYA I/O (WITH OPEN)
        // ==========================================
        Lesson(
            id = "py_5",
            courseId = "python",
            sectionId = "py_sec_3",
            title = "İstisna Mimarisi, Context Managers & Dosya I/O",
            shortDesc = "try-except-else-finally yaşam döngüsü, Custom Exception sınıfları, Exception Chaining, Context Manager (__enter__, __exit__) ve JSON serileştirme.",
            level = CourseLevel.INTERMEDIATE,
            order = 5,
            isPremium = true,
            learningObjectives = listOf(
                "try-except-else-finally bloklarının tam yürütme akışını ve istisna yakalama hiyerarşisini kavramak",
                "Custom Exception sınıfları ve Exception Chaining ('raise ... from') mekanizmasını öğrenmek",
                "Context Manager protokolünü (__enter__ ve __exit__) uygulayarak kaynak sızıntılarını (Resource Leak) engellemek",
                "JSON verilerini güvenle serileştirmek ve dosyaya yazmak"
            ),
            prerequisites = listOf("Python Veri Yapıları ve Comprehensions"),
            subtopics = listOf("try, except, else, finally Yaşam Döngüsü", "BaseException vs Exception Hiyerarşisi", "Exception Chaining (raise ... from err)", "Context Manager Protokolü (__enter__, __exit__)", "with open() & JSON Serileştirme"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. try-except-else-finally Bloklarının Tam Yaşam Döngüsü",
                    body = "Python'da hata yakalama 4 ayrı aşamadan oluşur:\n\n• `try`: Hata fırlatma potansiyeli olan riskli kodlar buraya yazılır.\n• `except SpesifikHata as e`: Yalnızca eşleşen istisna meydana geldiğinde çalışır.\n• `else`: Sadece ve sadece `try` bloğu hiçbir istisna fırlatmadan başarıyla bittiğinde çalışır (Başarı yolu).\n• `finally`: İster hata çıksın ister çıkmasın, fonksiyon `return` edilse dahi en son mutlaka çalışır (Kaynak serbest bırakma).",
                    codeSnippet = "try:\n    sonuc = 10 / 2\nexcept ZeroDivisionError:\n    print('Sıfıra bölünemez!')\nelse:\n    print(f'Hesaplama Başarılı: {sonuc}') # Çalışır\nfinally:\n    print('Temizlik tamamlandı.')"
                ),
                LessonContentBlock(
                    subtitle = "2. Özel İstisnalar ve İstisna Zincirleme (Exception Chaining)",
                    body = "Tüm kullanıcı tanımlı istisnalar `Exception` sınıfından türetilmelidir (`BaseException` doğrudan miras alınmamalıdır, çünkü KeyboardInterrupt gibi sistem sinyallerini de yakalar).\n\nBir hatayı yakalayıp daha üst seviye bir hata olarak fırlatırken orijinal hata izini kaybetmemek için `raise YeniHata(...) from eski_hata` sözdizimi kullanılır.",
                    codeSnippet = "class VeritabaniHatasi(Exception):\n    \"\"\"Uygulama seviyesinde veritabanı istisnası.\"\"\"\n    pass\n\ntry:\n    # Düşük seviye bağlantı denemesi\n    raise ConnectionRefusedError('Port 5432 kapalı')\nexcept ConnectionRefusedError as err:\n    raise VeritabaniHatasi('Veritabanına ulaşılamadı') from err"
                ),
                LessonContentBlock(
                    subtitle = "3. Context Manager Protokolü ve 'with' İfadesi",
                    body = "İşletim sistemi kaynakları (Dosyalar, Soketler, Kilitler) açık bırakıldığında kaynak sızıntısı (Resource Leak) meydana gelir.\n\n`with open('veri.txt', 'w') as f:` kalıbı Context Manager protokolünü çalıştırır. Blok bittiğinde veya hata fırlatıldığında `f.__exit__()` çağrılarak dosya tanıtıcısı (File Descriptor) işletim sistemine anında iade edilir.",
                    codeSnippet = "import json\n\nkullanici_verisi = {'kullanici': 'Admin', 'yetkiler': ['read', 'write']}\n\n# Güvenli dosya yazma:\nwith open('ayarlar.json', 'w', encoding='utf-8') as f:\n    json.dump(kullanici_verisi, f, indent=2, ensure_ascii=False)\n\n# Dosya otomatik kapatıldı!"
                )
            ),
            codeExample = "class BakiyeYetersizError(Exception):\n    pass\n\ndef para_cek(bakiye: float, miktar: float) -> float:\n    if miktar > bakiye:\n        raise BakiyeYetersizError(f'Yetersiz Bakiye! Mevcut: {bakiye}, İstenen: {miktar}')\n    return bakiye - miktar\n\ntry:\n    kalan = para_cek(100.0, 150.0)\nexcept BakiyeYetersizError as err:\n    print(f'İşlem Reddedildi: {err}')",
            codeExplanation = "Exception sınıfından türetilen BakiyeYetersizError özel hatası raise ile fırlatıldı ve except bloğunda kontrollü şekilde yakalandı.",
            realWorldExample = "Finans sistemlerinde geçersiz işlem veya bakiye kontrollerinde özel Exception sınıfları ile transaction rollback mekanizmaları kurulur.",
            practicalTask = "Bir metin dosyasındaki satır sayısını sayan ve dosya yoksa 0 döndüren bir fonksiyon yazın.",
            starterPlaygroundCode = "try:\n    sayi = int('abc')\nexcept ValueError as e:\n    print(f'Hata yakalandı: {e}')",
            miniQuestion = MiniQuestion(
                id = "py_q_5",
                question = "Python'da 'try' bloğu hatasız şekilde tamamlandığında hangi isteğe bağlı blok çalışır?",
                options = listOf("finally", "else", "catch", "then"),
                correctIndex = 1,
                explanation = "'else' bloğu yalnızca try bloğunda hiçbir istisna fırlatılmadığı durumda çalışır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_5",
                lessonId = "py_5",
                title = "Güvenli Bölme Fonksiyonu",
                instructions = "İki sayıyı bölen; sıfıra bölmede ZeroDivisionError yakalayıp 0.0 döndüren guvenli_bol(a, b) fonksiyonunu yazın.",
                exampleInput = "a = 10, b = 0",
                exampleOutput = "0.0",
                starterCode = "def guvenli_bol(a: float, b: float) -> float:\n    # Kodunu buraya yaz:\n    return 0.0",
                solutionCode = "def guvenli_bol(a: float, b: float) -> float:\n    try:\n        return a / b\n    except ZeroDivisionError:\n        return 0.0",
                hints = listOf("try-except ZeroDivisionError kullanın."),
                testCases = listOf(
                    TestCase("guvenli_bol(10, 2)", "5.0", "10 / 2"),
                    TestCase("guvenli_bol(10, 0)", "0.0", "Sıfıra bölme")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_5_1",
                    lessonId = "py_5",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Dosya işlemlerinde 'with open()' kullanmanın en kritik teknik faydası nedir?",
                    options = listOf("Dosyayı daha hızlı açması", "İşlem sırasında hata çıksa bile dosya tutamacını (file descriptor) otomatik olarak kapatması (RAII)", "Dosyayı şifrelemesi", "Dosyayı RAM'e kopyalaması"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Context manager dosyayı güvenle kapatır ve dosya tutamacı sızıntısını önler.",
                    explanationWrong = "with bloğu dosyanın otomatik kapatılmasını garanti eder.",
                    reviewTopic = "Context Managers"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Custom Exception oluştururken neden BaseException yerine Exception miras alınmalıdır?",
                    answer = "Çünkü BaseException, SystemExit ve KeyboardInterrupt gibi sistem seviyesi sinyalleri de içerir. Genel hatalar için Exception sınıfı miras alınmalıdır."
                )
            ),
            completionCriteria = listOf(
                "try-except-else-finally bloklarını doğru kurgulamak",
                "Özel istisna sınıfları yazıp raise ile fırlatabilmek",
                "with open() ile güvenli I/O işlemleri yapabilmek"
            )
        ),

        // ==========================================
        // DERS 6: NESNE YÖNELİMLİ PROGRAMLAMA (OOP) TEMELLERİ
        // ==========================================
        Lesson(
            id = "py_6",
            courseId = "python",
            sectionId = "py_sec_3",
            title = "OOP Temelleri: Sınıflar, __init__, self & Kalıtım",
            shortDesc = "Sınıf yapısı, __init__ kurucusu, self parametresi, Sınıf vs Örnek değişkenleri, Kalıtım (Inheritance) ve super() kullanımı.",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true,
            learningObjectives = listOf(
                "Sınıf (class) tanımlamak ve __init__ ile örnek alanları başlatmak",
                "self referansının nesne yönelimindeki rolünü anlamak",
                "Kalıtım zinciri kurup 'super()' ile üst sınıfı başlatmak"
            ),
            prerequisites = listOf("Python Hata Yönetimi ve Fonksiyonlar"),
            subtopics = listOf("class & __init__ Kurucusu", "self & cls Referansları", "Sınıf Değişkeni vs Örnek Değişkeni", "Kalıtım (Inheritance) & super()", "MRO (Method Resolution Order)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Sınıf, __init__ ve 'self' Referansının Anatomisi",
                    body = "Python'da sınıflar nesne üreten şablonlardır. Bir nesne örneklendiğinde `__init__` kurucusu otomatik tetiklenir.\n\n`self` parametresi, bellekte oluşturulan somut nesne örneğinin kendisini işaret eder. Metot çağrıldığında `nesne.bilgi()` ifadesi Python tarafından arka planda `Sinif.bilgi(nesne)` biçimine dönüştürülür.",
                    codeSnippet = "class Araba:\n    tekerlek_sayisi = 4 # Sınıf değişkeni (Tüm arabalar paylaşır)\n    \n    def __init__(self, marka: str, model: int):\n        self.marka = marka # Örnek değişkeni (Her arabaya özel)\n        self.model = model\n    \n    def bilgi(self) -> str:\n        return f'{self.marka} ({self.model})'"
                ),
                LessonContentBlock(
                    subtitle = "2. Kalıtım, super() ve Metot Arama Sırası (MRO)",
                    body = "Alt sınıf `class Kopek(Hayvan):` üst sınıfın tüm metot ve alanlarını devralır. `super().__init__(...)` ile üst sınıf kurucusu tetiklenir.\n\nPython çoklu kalıtımı (Multiple Inheritance) destekler. İki üst sınıfta aynı metot varsa çakışma 'C3 Linearization' algoritması (MRO - Method Resolution Order) ile çözülür (`Sinif.__mro__`).",
                    tip = "Python çoklu kalıtımı (multiple inheritance) destekler ve metot arama sırasını MRO (Method Resolution Order) algoritması ile çözer."
                )
            ),
            codeExample = "class Calisan:\n    def __init__(self, isim: str, maas: float):\n        self.isim = isim\n        self.maas = maas\n    \n    def calis(self) -> str:\n        return f'{self.isim} çalışıyor.'\n\nclass Yazilimci(Calisan):\n    def __init__(self, isim: str, maas: float, dil: str):\n        super().__init__(isim, maas)\n        self.dil = dil\n    \n    def calis(self) -> str:\n        return f'{self.isim}, {self.dil} ile kod yazıyor.'\n\ny = Yazilimci('Mert', 95000.0, 'Python')\nprint(y.calis())",
            codeExplanation = "Yazilimci sınıfı Calisan'dan türer, super().__init__ ile isim ve maas'ı üst sınıfa iletir ve calis() metodunu polimorfik olarak ezer (override).",
            realWorldExample = "Django ORM'de tüm veritabanı modelleri `models.Model` üst sınıfından kalıtım alarak veritabanı CRUD yeteneklerine kavuşur.",
            practicalTask = "BankaHesabi sınıfı tasarlayarak para_yatir ve para_cek metotlarını yazın.",
            starterPlaygroundCode = "class Kedi:\n    def ses(self): return 'Miyav'\nk = Kedi()\nprint(k.ses())",
            miniQuestion = MiniQuestion(
                id = "py_q_6",
                question = "Python sınıflarında bir örnek metodunun ilk parametresi geleneksel olarak ne adlandırılır?",
                options = listOf("this", "self", "cls", "instance"),
                correctIndex = 1,
                explanation = "Python'da örnek metodları nesnenin kendisini ilk parametre olarak 'self' adıyla alır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_6",
                lessonId = "py_6",
                title = "Dikdörtgen Sınıfı",
                instructions = "genislik ve yukseklik alan Dikdortgen sınıfı oluşturun. alan() ve cevre() metotlarını ekleyin.",
                exampleInput = "d = Dikdortgen(4, 5)",
                exampleOutput = "d.alan() == 20",
                starterCode = "class Dikdortgen:\n    # Sınıfı buraya yazın:\n    pass",
                solutionCode = "class Dikdortgen:\n    def __init__(self, genislik: float, yukseklik: float):\n        self.genislik = genislik\n        self.yukseklik = yukseklik\n    \n    def alan(self) -> float:\n        return self.genislik * self.yukseklik\n    \n    def cevre(self) -> float:\n        return 2 * (self.genislik + self.yukseklik)",
                hints = listOf("__init__, alan() ve cevre() metotlarını tanımlayın."),
                testCases = listOf(
                    TestCase("Dikdortgen(4, 5).alan()", "20", "4x5 alan")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_6_1",
                    lessonId = "py_6",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Python'da bir sınıfın miras arama sırasını (Method Resolution Order) görmek için hangi özellik kullanılır?",
                    options = listOf("Sinif.__mro__", "Sinif.get_order()", "Sinif.__tree__", "Sinif.hierarchy"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! `Class.__mro__` veya `Class.mro()` C3 linearisation algoritması ile belirlenen arama sırasını tuple olarak döner.",
                    explanationWrong = "__mro__ özelliği kullanılır.",
                    reviewTopic = "Python MRO"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Sınıf değişkeni (class variable) ile örnek değişkeni (instance variable) arasındaki fark nedir?",
                    answer = "Sınıf seviyesinde tanımlanan değişkenler tüm nesneler tarafından ortak paylaşılırken, `self.alan` şeklinde __init__ içinde tanımlanan değişkenler her nesneye özeldir."
                )
            ),
            completionCriteria = listOf(
                "Sınıf ve nesne yapısını kurabilmek",
                "Kalıtım ve super() ile hiyerarşi oluşturabilmek",
                "Metot ezme (override) ve çok biçimliliği uygulayabilmek"
            )
        ),

        // ==========================================
        // DERS 7: DUNDER METOTLAR, @PROPERTY & SOYUT SINIFLAR
        // ==========================================
        Lesson(
            id = "py_7",
            courseId = "python",
            sectionId = "py_sec_3",
            title = "Dunder (Magic) Metotlar, @property & Soyut Sınıflar (abc)",
            shortDesc = "Python veri modeli: __str__, __repr__, __len__, __getitem__, __eq__, @property kapsülleme ve abc.ABC soyut taban sınıfları.",
            level = CourseLevel.INTERMEDIATE,
            order = 7,
            isPremium = true,
            learningObjectives = listOf(
                "Dunder (Double Underscore) metotlar ile nesneleri Python yerleşik fonksiyonlarına entegre etmek",
                "@property, @setter ve @deleter ile kapsülleme yapmak",
                "abc.ABC ve @abstractmethod ile soyut arayüz kontratları oluşturmak"
            ),
            prerequisites = listOf("OOP Temelleri: Sınıflar ve Kalıtım"),
            subtopics = listOf("Python Data Model & Dunder Metotlar", "__str__ vs __repr__", "Operatör Aşırı Yükleme (__add__, __eq__, __lt__)", "Kapsülleme (@property & @setter)", "Soyut Taban Sınıflar (abc.ABC)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Python Veri Modeli ve Dunder (Magic) Metotlar",
                    body = "Python'da yerleşik operatör ve fonksiyonlar (`len()`, `+`, `[]`, `in`, `==`), sınıflara eklenen 'Dunder' (Double Underscore) metotlar üzerinden çalışır:\n\n• `__repr__`: Geliştirici için teknik temsil (kod ile yeniden oluşturulabilir format).\n• `__str__`: Son kullanıcı için okunabilir metin.\n• `__len__`: `len(nesne)` çağrıldığında dönecek tamsayı.\n• `__getitem__`: `nesne[key]` indeksleme yeteneği.\n• `__eq__`, `__lt__`: `==` ve `<` karşılaştırmaları.",
                    codeSnippet = "class Sepet:\n    def __init__(self):\n        self.urunler = []\n    def __len__(self):\n        return len(self.urunler)\n    def __getitem__(self, index):\n        return self.urunler[index]\n    def __repr__(self):\n        return f'Sepet({self.urunler})'"
                ),
                LessonContentBlock(
                    subtitle = "2. @property ile Modern Kapsülleme ve abc.ABC Soyut Sınıfları",
                    body = "Java'daki hantal `get_fiyat()` / `set_fiyat()` metotları yerine Python'da `@property` dekoratörü kullanılır. Kullanıcı `urun.fiyat = 100` yazar fakat arka planda doğrulama kuralları (validation) çalışır.\n\n`abc.ABC` ve `@abstractmethod` ise alt sınıfların belirli metotları ezmesini zorunlu kılan soyut arayüz sözleşmeleridir.",
                    tip = "Soyut sınıflar için `from abc import ABC, abstractmethod` kullanılır."
                )
            ),
            codeExample = "class Sicaklik:\n    def __init__(self, celsius: float):\n        self._celsius = celsius\n    \n    @property\n    def fahrenheit(self) -> float:\n        return (self._celsius * 9/5) + 32\n    \n    @property\n    def celsius(self) -> float:\n        return self._celsius\n    \n    @celsius.setter\n    def celsius(self, deger: float):\n        if deger < -273.15:\n            raise ValueError('Mutlak sıfırın altına inilemez!')\n        self._celsius = deger\n\ns = Sicaklik(25)\nprint(f'25 C = {s.fahrenheit} F') # 77.0 F",
            codeExplanation = "fahrenheit alanı dinamik hesaplanan bir getter property'sidir. celsius.setter ise negatif mutlak sıfır kontrolü uygular.",
            realWorldExample = "SQLAlchemy ve PyTorch tensör nesneleri tüm matematiksel operatörleri (+, *, ==) dunder metotlar ile aşırı yükler.",
            practicalTask = "İki Vektor(x, y) nesnesini `+` operatörü ile toplayabilen bir `__add__` metodu yazın.",
            starterPlaygroundCode = "class Kutu:\n    def __init__(self, items): self.items = items\n    def __len__(self): return len(self.items)\nprint(len(Kutu([1, 2, 3])))",
            miniQuestion = MiniQuestion(
                id = "py_q_7",
                question = "Python'da bir nesnenin 'len(nesne)' fonksiyonu ile uzunluk döndürebilmesi için hangi dunder metodun tanımlanması gerekir?",
                options = listOf("__size__", "__len__", "__count__", "__length__"),
                correctIndex = 1,
                explanation = "Python len() çağrıldığında nesnenin `__len__` metodunu çalıştırır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_7",
                lessonId = "py_7",
                title = "Vektör Toplama (__add__)",
                instructions = "x ve y koordinatlarına sahip Vektor sınıfı yazın. İki vektörü `v1 + v2` şeklinde toplayıp yeni bir Vektor döndüren __add__ ve metin çıktısı veren __repr__ metotlarını ekleyin.",
                exampleInput = "Vektor(1, 2) + Vektor(3, 4)",
                exampleOutput = "Vektor(4, 6)",
                starterCode = "class Vektor:\n    # Kodunu buraya yaz:\n    pass",
                solutionCode = "class Vektor:\n    def __init__(self, x: int, y: int):\n        self.x, self.y = x, y\n    def __add__(self, other):\n        return Vektor(self.x + other.x, self.y + other.y)\n    def __repr__(self):\n        return f'Vektor({self.x}, {self.y})'",
                hints = listOf("__add__ içinde yeni bir Vektor(self.x + other.x, self.y + other.y) döndürün."),
                testCases = listOf(
                    TestCase("str(Vektor(1, 2) + Vektor(3, 4))", "Vektor(4, 6)", "Vektör toplamı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_7_1",
                    lessonId = "py_7",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Soyut bir sınıftan doğrudan 'Sinif()' şeklinde nesne oluşturulmaya çalışıldığında ne olur?",
                    options = listOf("Boş nesne döner", "TypeError fırlatılır (Can't instantiate abstract class)", "Varsayılan değerler atanır", "Program donar"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! @abstractmethod içeren soyut sınıflar doğrudan somutlaştırılamaz (instantiate edilemez).",
                    explanationWrong = "TypeError fırlatılır.",
                    reviewTopic = "Soyut Sınıflar"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "__str__ ile __repr__ arasındaki en temel fark nedir?",
                    answer = "__str__ son kullanıcı için okunabilir format üretir. __repr__ ise geliştirici için nesneyi yeniden oluşturabilecek Python kodunu yansıtan (unambiguous) temsil sunar."
                )
            ),
            completionCriteria = listOf(
                "Dunder metotlar ile nesnelere yerleşik davranışlar kazandırmak",
                "@property ve @setter ile kapsülleme uygulamak",
                "abc.ABC ile soyut kontratlar tanımlayabilmek"
            )
        ),

        // ==========================================
        // DERS 8: FONKSİYONEL PYTHON: DEKORATÖRLER & JENERATÖRLER
        // ==========================================
        Lesson(
            id = "py_8",
            courseId = "python",
            sectionId = "py_sec_4",
            title = "Dekoratörler (@wraps) & Jeneratörler (yield)",
            shortDesc = "First-Class Fonksiyonlar, Closure mekanizması, @decorator deseni, functools.wraps, yield ile lazy evaluation jeneratörler.",
            level = CourseLevel.INTERMEDIATE,
            order = 8,
            isPremium = true,
            learningObjectives = listOf(
                "Closure mekanizmasını ve First-Class fonksiyon mantığını anlamak",
                "Performans ölçümü ve yetkilendirme için özel fonksiyon dekoratörleri (@) yazmak",
                "yield anahtar kelimesi ile gigabaytlarca veriyi RAM'i doldurmadan akıtan jeneratörler inşa etmek"
            ),
            prerequisites = listOf("Python Fonksiyonlar, Scope & Dunder Metotlar"),
            subtopics = listOf("First-Class Functions & Closures", "Fonksiyon Dekoratörleri (@)", "functools.wraps ile Metadata Korunumu", "Parametreli Dekoratörler", "yield & Lazy Evaluation Jeneratörler"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Dekoratör Deseni (@) ve Closure Mekanizması",
                    body = "Python'da fonksiyonlar birinci sınıf vatandaştır (First-Class Citizens); değişkenlere atanabilir, başka fonksiyonlara argüman olarak iletilebilir ve fonksiyonlardan döndürülebilir.\n\nDekoratör, bir fonksiyonun gövdesini değiştirmeden önüne ve arkasına ek davranışlar (loglama, yetkilendirme, süre ölçümü, önbellekleme) ekleyen sarmalayıcı bir fonksiyondur. `@functools.wraps(func)` dekoratörü ise orijinal fonksiyonun `__name__` ve `__doc__` meta bilgilerini wrapper fonksiyona aktarır.",
                    codeSnippet = "import time\nfrom functools import wraps\n\ndef sure_olc(func):\n    @wraps(func)\n    def wrapper(*args, **kwargs):\n        baslangic = time.perf_counter()\n        sonuc = func(*args, **kwargs)\n        print(f'{func.__name__} {time.perf_counter() - baslangic:.4f} sn sürdü.')\n        return sonuc\n    return wrapper"
                ),
                LessonContentBlock(
                    subtitle = "2. Jeneratörler (Generators) ve 'yield' ile Sonsuz Bellek Tasarrufu",
                    body = "Standart bir fonksiyon `return` ile tüm listeyi bellekte (RAM) tek seferde oluşturup döner. Eğer 10 milyon satırlık bir CSV okuyorsanız RAM tükenir.\n\n`yield` anahtar kelimesi, fonksiyonun durumunu dondurur (freeze) ve sadece bir sonraki değer talep edildiğinde (`next()` veya for döngüsü) sonraki adıma geçer (Lazy Evaluation). Bellek tüketimi O(N)'den O(1)'e düşer.",
                    codeSnippet = "def buyuk_dosya_oku(dosya_yolu):\n    with open(dosya_yolu, 'r') as f:\n        for satir in f:\n            yield satir.strip() # Sadece 1 satır bellekte tutulur",
                    tip = "Jeneratörler tembeldir (lazy evaluation); değer talep edilene (next()) kadar hesaplama yapılmaz."
                )
            ),
            codeExample = "def fibonacci_uret(limit: int):\n    a, b = 0, 1\n    for _ in range(limit):\n        yield a\n        a, b = b, a + b\n\nfor fib in fibonacci_uret(6):\n    print(fib, end=' ') # 0 1 1 2 3 5",
            codeExplanation = "yield ifadesi her adımda bir Fibonacci sayısı döndürür ve fonksiyon bir sonraki for döngüsü adımına kadar duraklar.",
            realWorldExample = "Flask framework'ündeki `@app.route('/login')` ve FastAPI'deki `@app.get('/')` rotaları Python dekoratörleri ile kaydedilir.",
            practicalTask = "Fonksiyonun kaç kez çağrıldığını sayan bir sayaç dekoratörü yazın.",
            starterPlaygroundCode = "def sayac(n):\n    for i in range(n): yield i\nprint(list(sayac(4)))",
            miniQuestion = MiniQuestion(
                id = "py_q_8",
                question = "Dekoratör yazarken sarmalanan fonksiyonun orijinal __name__ ve docstring bilgilerini korumak için hangi standart kütüphane dekoratörü kullanılır?",
                options = listOf("@functools.wraps", "@decorator", "@property", "@staticmethod"),
                correctIndex = 0,
                explanation = "`@functools.wraps(func)` orijinal fonksiyonun metadata bilgilerini wrapper'a kopyalar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_8",
                lessonId = "py_8",
                title = "Çift Sayı Jeneratörü (yield)",
                instructions = "0'dan başlayarak n'e kadar (n dahil) olan çift sayıları yield eden cift_jenerator(n) fonksiyonunu yazın.",
                exampleInput = "n = 6",
                exampleOutput = "[0, 2, 4, 6]",
                starterCode = "def cift_jenerator(n: int):\n    # Kodunu buraya yaz:\n    pass",
                solutionCode = "def cift_jenerator(n: int):\n    for i in range(0, n + 1, 2):\n        yield i",
                hints = listOf("for i in range(0, n + 1, 2): yield i kullanın."),
                testCases = listOf(
                    TestCase("list(cift_jenerator(6))", "[0, 2, 4, 6]", "0..6 çiftler")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_8_1",
                    lessonId = "py_8",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir jeneratör nesnesinin tüm elemanları tükendiğinde bir sonraki next() çağrısında hangi istisna fırlatılır?",
                    options = listOf("IndexError", "StopIteration", "GeneratorExit", "ValueError"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Jeneratör veya iteratör bittiğinde Python içsel olarak StopIteration fırlatır ve döngü güvenle sonlanır.",
                    explanationWrong = "StopIteration istisnası fırlatılır.",
                    reviewTopic = "Python Generators"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Generator Expression ile List Comprehension farkı nedir?",
                    answer = "List Comprehension `[x for x in data]` tüm elemanları bellekte tek seferde oluşturur. Generator Expression `(x for x in data)` ise elemanları talep edildikçe üretir, bellek harcamaz."
                )
            ),
            completionCriteria = listOf(
                "@wraps ile üretim standartlarında dekoratörler yazabilmek",
                "yield ile bellek dostu jeneratörler oluşturabilmek",
                "Closure mekanizmasını izah edebilmek"
            )
        ),

        // ==========================================
        // DERS 9: ASENKRON PYTHON: ASYNCIO & EVENT LOOP
        // ==========================================
        Lesson(
            id = "py_9",
            courseId = "python",
            sectionId = "py_sec_5",
            title = "Asenkron Python (AsyncIO) & Event Loop",
            shortDesc = "AsyncIO mimarisi, async/await sözdizimi, Coroutines, asyncio.gather, Task scheduling ve I/O-bound optimizasyonu.",
            level = CourseLevel.ADVANCED,
            order = 9,
            isPremium = true,
            learningObjectives = listOf(
                "Python AsyncIO Event Loop mekanizmasını ve cooperative multitasking mantığını kavramak",
                "async ve await ile bloke etmeyen (non-blocking) coroutine fonksiyonları yazmak",
                "asyncio.gather ve asyncio.create_task ile binlerce I/O işlemini eşzamanlı yürütmek"
            ),
            prerequisites = listOf("Python Jeneratörler ve Dekoratörler"),
            subtopics = listOf("Cooperative Multitasking & Event Loop", "async def & Coroutine Nesneleri", "await ile Bloke Etmeyen Bekleme", "asyncio.create_task vs asyncio.gather", "I/O-Bound Optimizasyonu"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. AsyncIO Mimarisi ve Event Loop Çalışma Prensibi",
                    body = "Geleneksel senkron kodda bir ağ isteği veya disk okuması yapıldığında CPU hiçbir şey yapmadan bekler (Blocking I/O).\n\nAsyncIO, tek bir thread üzerinde 'Event Loop' (Olay Döngüsü) koşturur. Bir coroutine `await` gördüğünde kontrolü Event Loop'a geri devreder; döngü bekleyen başka bir görevi çalıştırır. Veri hazır olduğunda duraklayan iş kaldığı yerden devam eder (Cooperative Multitasking).",
                    codeSnippet = "import asyncio\n\nasync def api_istegi(servis_adi: str, gecikme: float):\n    print(f'{servis_adi} isteği yollandı...')\n    await asyncio.sleep(gecikme) # Asenkron non-blocking bekleme\n    print(f'{servis_adi} yanıtı alındı!')\n    return {servis_adi: 'Başarılı'}"
                ),
                LessonContentBlock(
                    subtitle = "2. asyncio.gather ve asyncio.create_task ile Paralel I/O",
                    body = "• `asyncio.create_task(coro)`: Görevi Event Loop'a derhal planlayıp arka planda başlatır (Future döner).\n• `asyncio.gather(*tasks)`: Onlarca veya binlerce asenkron görevi eşzamanlı ateşler ve sonuçları liste olarak toplar.\n\n*Önemli Not:* AsyncIO içinde senkron `time.sleep()` çağrılmamalıdır; bu tüm Event Loop'u dondurur. Daima `await asyncio.sleep()` kullanılmalıdır.",
                    tip = "AsyncIO içinde senkron `time.sleep()` çağrılmamalıdır; bu tüm Event Loop'u kilitler. Daima `await asyncio.sleep()` kullanılmalıdır."
                )
            ),
            codeExample = "import asyncio\n\nasync def gorev(id: int, sure: float):\n    await asyncio.sleep(sure)\n    return f'Görev {id} tamamlandı.'\n\nasync def main():\n    sonuclar = await asyncio.gather(\n        gorev(1, 0.2),\n        gorev(2, 0.1),\n        gorev(3, 0.3)\n    )\n    print(sonuclar)\n\nasyncio.run(main())",
            codeExplanation = "asyncio.gather 3 görevi paralel başlatır. Toplam süre görevlerin toplamı değil, en uzununun süresi (~0.3 sn) kadar sürer.",
            realWorldExample = "FastAPI, aiohttp ve modern mikroservis mimarileri tek bir sunucuda saniyede on binlerce isteği AsyncIO ile karşılar.",
            practicalTask = "10 farklı URL'e asenkron istek atan ve yanıt sürelerini kaydeden bir AsyncIO betiği tasarlayın.",
            starterPlaygroundCode = "import asyncio\nasync def selam():\n    await asyncio.sleep(0.01)\n    return 'Async Python!'\nprint(asyncio.run(selam()))",
            miniQuestion = MiniQuestion(
                id = "py_q_9",
                question = "Python'da bir async fonksiyon çağrıldığında doğrudan değer dönmek yerine ne döner?",
                options = listOf("None", "Thread nesnesi", "Coroutine nesnesi", "Future hatası"),
                correctIndex = 2,
                explanation = "async def ile tanımlanan bir fonksiyon çağrıldığında hemen çalışmaz; bir Coroutine nesnesi döndürür. Çalışması için 'await' veya 'asyncio.run()' gereklidir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_9",
                lessonId = "py_9",
                title = "Paralel Asenkron Toplayıcı",
                instructions = "asyncio.gather kullanarak iki asenkron sayıyı toplayan asenkron_topla(coro1, coro2) fonksiyonunu yazın.",
                exampleInput = "coro1 -> 10, coro2 -> 20",
                exampleOutput = "30",
                starterCode = "import asyncio\nasync def asenkron_topla(coro1, coro2) -> int:\n    # Kodunu buraya yaz:\n    return 0",
                solutionCode = "import asyncio\nasync def asenkron_topla(coro1, coro2) -> int:\n    s1, s2 = await asyncio.gather(coro1, coro2)\n    return s1 + s2",
                hints = listOf("s1, s2 = await asyncio.gather(coro1, coro2) kullanın."),
                testCases = listOf(
                    TestCase("asenkron_topla", "30", "Paralel toplama")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_9_1",
                    lessonId = "py_9",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "AsyncIO mimarisi hangi tür iş yüklerinde (workload) en yüksek verimliliği sağlar?",
                    options = listOf("Ağır matematiksel matris hesaplamalarında (CPU-bound)", "Ağ, veritabanı ve dosya bekleme işlemlerinde (I/O-bound)", "Ekran kartı render işlemlerinde", "Şifre kırma algoritmalarında"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! AsyncIO, I/O bekleme sürelerinde CPU'yu boşta tutmayıp diğer işleri yürüterek I/O-bound işlerde devasa hız sağlar.",
                    explanationWrong = "AsyncIO I/O-bound işlerde en etkilidir.",
                    reviewTopic = "AsyncIO"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "asyncio.create_task() ile await arasındaki fark nedir?",
                    answer = "`create_task(coro)` coroutine'i Event Loop kuyruğuna derhal bağımsız bir arka plan görevi olarak planlar ve bir Task döndürür. `await coro` ise coroutine bitene kadar o noktada duraklar."
                )
            ),
            completionCriteria = listOf(
                "Event Loop ve coroutine mantığını açıklayabilmek",
                "asyncio.gather ile paralel I/O akışları yönetebilmek",
                "Non-blocking kodlama prensiplerini uygulamak"
            )
        ),

        // ==========================================
        // DERS 10: CONCURRENCY: THREADING, MULTIPROCESSING & GIL
        // ==========================================
        Lesson(
            id = "py_10",
            courseId = "python",
            sectionId = "py_sec_5",
            title = "Eşzamanlılık: Threading vs Multiprocessing & GIL",
            shortDesc = "CPython GIL (Global Interpreter Lock), threading modülü, multiprocessing ile gerçek çok çekirdek paralelliği ve ProcessPoolExecutor.",
            level = CourseLevel.ADVANCED,
            order = 10,
            isPremium = true,
            learningObjectives = listOf(
                "GIL'in (Global Interpreter Lock) neden var olduğunu ve CPython'daki etkilerini anlamak",
                "Threading ile Multiprocessing arasındaki mimari ve bellek farklarını kavramak",
                "concurrent.futures (ThreadPoolExecutor & ProcessPoolExecutor) ile havuz yönetimi yapmak"
            ),
            prerequisites = listOf("Asenkron Python & AsyncIO"),
            subtopics = listOf("Global Interpreter Lock (GIL) Mimarisi", "threading vs multiprocessing", "Race Condition & Lock/RLock", "concurrent.futures Havuzları", "CPU-Bound vs I/O-Bound Stratejileri"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. GIL (Global Interpreter Lock) ve Threading Gerçeği",
                    body = "CPython bellek yönetiminde (özellikle `ob_refcnt` referans sayacı) thread-safe olmadığı için tek bir Python bayt kodunu aynı anda yalnızca BİR işletim sistemi thread'inin çalıştırmasına izin veren 'Global Interpreter Lock' (GIL) kilidini kullanır.\n\nBu nedenle standart Python thread'leri CPU-bound (yoğun matematik/hesaplama) işlerde birden fazla çekirdeği paralel kullanamaz.",
                    codeSnippet = "# Threading CPU-bound işleri hızlandırmaz!\n# Çoklu çekirdeği tam kullanmak için Multiprocessing:\nfrom multiprocessing import Pool\n\ndef agir_hesap(n: int) -> int:\n    return sum(i * i for i in range(n))\n\nif __name__ == '__main__':\n    with Pool() as pool:\n        sonuclar = pool.map(agir_hesap, [5000000, 5000000, 5000000])"
                ),
                LessonContentBlock(
                    subtitle = "2. Mimari Seçim Kriterleri & concurrent.futures",
                    body = "• **I/O-Bound (Ağ/Disk/Veritabanı):** `asyncio` veya `concurrent.futures.ThreadPoolExecutor` (Düşük bellek tüketimi, thread'ler GIL'i I/O anında serbest bırakır).\n• **CPU-Bound (Görüntü İşleme, Makine Öğrenimi, Şifreleme):** `concurrent.futures.ProcessPoolExecutor` (Ayrı bellek alanları ve her çekirdeğe bağımsız GIL).\n\n*İş parçacığı güvenliği (Thread-Safety):* Ortak değişkenlere eşzamanlı yazmada veri bozulmasını önlemek için `threading.Lock()` ile kritik bölgeler kilitlenmelidir.",
                    tip = "Multiprocessing işlemler arası iletişimde (IPC) verileri serialize (pickle) ettiği için küçük veri transferlerinde tercih edilmelidir."
                )
            ),
            codeExample = "from concurrent.futures import ThreadPoolExecutor\n\ndef veri_cek(kaynak_id: int) -> str:\n    return f'Kaynak {kaynak_id} verisi alındı.'\n\nwith ThreadPoolExecutor(max_workers=3) as executor:\n    gorevler = [executor.submit(veri_cek, i) for i in range(3)]\n    for g in gorevler:\n        print(g.result())",
            codeExplanation = "ThreadPoolExecutor havuz mantığıyla 3 thread açar ve I/O görevlerini eşzamanlı olarak işler.",
            realWorldExample = "Veri bilimi kütüphaneleri (NumPy, PyTorch) C/C++ katmanına inerek GIL'i serbest bırakır (GIL release) ve çoklu çekirdeği tam kapasite kullanır.",
            practicalTask = "ProcessPoolExecutor kullanarak 4 farklı büyük sayının asal çarpanlarını tüm CPU çekirdeklerinde paralel hesaplayın.",
            starterPlaygroundCode = "import threading\nt = threading.Thread(target=lambda: print('Thread çalıştı'))\nt.start(); t.join()",
            miniQuestion = MiniQuestion(
                id = "py_q_10",
                question = "CPython'da CPU-bound bir hesaplamayı 8 çekirdekli bir işlemcinin tüm çekirdeklerine yayarak gerçek donanım paralelliği elde etmek için hangi modül tercih edilmelidir?",
                options = listOf("threading", "asyncio", "multiprocessing", "queue"),
                correctIndex = 2,
                explanation = "multiprocessing modülü her çekirdek için bağımsız bir Python prosesi ve bağımsız GIL tahsis ederek gerçek donanım paralelliği sağlar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_10",
                lessonId = "py_10",
                title = "Thread Havuzunda Kare Hesaplama",
                instructions = "concurrent.futures.ThreadPoolExecutor kullanarak verilen sayı listesindeki elemanların karelerini hesaplayıp liste olarak döndüren paralel_kareler(sayilar) fonksiyonunu yazın.",
                exampleInput = "[1, 2, 3, 4]",
                exampleOutput = "[1, 4, 9, 16]",
                starterCode = "from concurrent.futures import ThreadPoolExecutor\ndef paralel_kareler(sayilar: list) -> list:\n    # Kodunu buraya yaz:\n    return []",
                solutionCode = "from concurrent.futures import ThreadPoolExecutor\ndef paralel_kareler(sayilar: list) -> list:\n    with ThreadPoolExecutor() as executor:\n        return list(executor.map(lambda x: x*x, sayilar))",
                hints = listOf("executor.map(lambda x: x*x, sayilar) kullanın."),
                testCases = listOf(
                    TestCase("paralel_kareler([1, 2, 3, 4])", "[1, 4, 9, 16]", "Kareler")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_10_1",
                    lessonId = "py_10",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "İki thread'in aynı değişkene eşzamanlı yazmaya çalışıp veriyi bozması durumuna ne ad verilir?",
                    options = listOf("Deadlock", "Race Condition (Yarış Durumu)", "Memory Leak", "Segmentation Fault"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Race condition, atomik olmayan paylaşımlı bellek yazımlarında oluşur; çözümü `threading.Lock` kullanmaktır.",
                    explanationWrong = "Bu durum Race Condition (Yarış Durumu) olarak adlandırılır.",
                    reviewTopic = "Race Conditions"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Threading Lock ile RLock arasındaki fark nedir?",
                    answer = "Standart Lock aynı thread tarafından üst üste iki kez kilitlenirse deadlock olur. RLock (Reentrant Lock) ise kilidi alan aynı thread'in kilidi birden fazla kez güvenle edinmesine izin verir."
                )
            ),
            completionCriteria = listOf(
                "GIL kısıtlarını ve mimari nedenlerini izah edebilmek",
                "I/O ve CPU durumlarına göre Threading ve Multiprocessing ayrımını yapmak",
                "concurrent.futures havuzlarını yönetebilmek"
            )
        ),

        // ==========================================
        // DERS 11: METAPROGRAMMING, DESCRIPTORS & METACLASSES
        // ==========================================
        Lesson(
            id = "py_11",
            courseId = "python",
            sectionId = "py_sec_6",
            title = "Metaprogramming: Descriptors & Metaclasses (type)",
            shortDesc = "Python'da kod yazan kodlar: Descriptor Protokolü (__get__, __set__), Sınıf fabrikaları, type ve Metaclass (__new__, __init__) mimarisi.",
            level = CourseLevel.EXPERT,
            order = 11,
            isPremium = true,
            learningObjectives = listOf(
                "Descriptor protokolünü (__get__, __set__, __delete__) sıfırdan inşa etmek",
                "type fonksiyonunun 3 argümanlı dinamik sınıf üretme yeteneğini öğrenmek",
                "Metaclass yazarak alt sınıfların API kurallarına uyup uymadığını derleme anında denetlemek"
            ),
            prerequisites = listOf("İleri OOP & Concurrency"),
            subtopics = listOf("Descriptor Protokolü (__get__, __set__, __set_name__)", "Data vs Non-Data Descriptors", "Dinamik Sınıf Üretimi (type(name, bases, dict))", "Özel Metaclass Mimarisi (__new__ & __init__)", "ORM & Validasyon Sistemleri Tasarımı"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Descriptor Protokolü (ORM ve Framework Motoru)",
                    body = "Bir sınıf niteliğine erişildiğinde (`obj.alan`), atama yapıldığında (`obj.alan = 5`) veya silindiğinde araya giren protokoldür.\n\nDjango ORM modellerindeki `models.CharField`, SQLAlchemy sütunları veya `@property` / `@classmethod` gibi tüm yerleşik dekoratörler birer Descriptor'dır.",
                    codeSnippet = "class PozitifSayi:\n    def __set_name__(self, owner, name):\n        self.name = name\n    def __get__(self, instance, owner):\n        if instance is None: return self\n        return instance.__dict__.get(self.name, 0)\n    def __set__(self, instance, value):\n        if value < 0:\n            raise ValueError(f'{self.name} negatif olamaz!')\n        instance.__dict__[self.name] = value"
                ),
                LessonContentBlock(
                    subtitle = "2. Metaclasses (Sınıf Üreten Sınıflar)",
                    body = "Python'da nesneleri sınıflar üretir, sınıfları ise 'Metaclass' üretir. Varsayılan metasınıf `type`'tır (`class X:` aslında `type('X', (), {})` çağrısıdır).\n\nÖzel bir Metaclass tanımlayarak (`class Meta(type):`), alt sınıflar tanımlandığı anda (import sırasında) araya girip kuralları (zorunlu metotlar, isimlendirme standartları, otomatik alan kayıtları) zorunlu kılabilirsiniz.",
                    tip = "Zen of Python: 'Metaclasses are deeper magic than 99% of users should ever worry about.'"
                )
            ),
            codeExample = "class ApiKontrolMeta(type):\n    def __new__(cls, name, bases, dct):\n        # Alt sınıfta 'calistir' metodu yoksa sınıfın oluşmasını engelle:\n        if name != 'BaseServis' and 'calistir' not in dct:\n            raise TypeError(f'{name} sınıfı 'calistir' metodunu zorunlu olarak içermelidir!')\n        return super().__new__(cls, name, bases, dct)\n\nclass BaseServis(metaclass=ApiKontrolMeta):\n    pass\n\nclass CalisanServis(BaseServis):\n    def calistir(self):\n        return 'Servis devrede!'",
            codeExplanation = "ApiKontrolMeta sınıfların tanımlanma anında (import edilirken) araya girer ve calistir() metodu bulunmayan sınıflarda derhal TypeError fırlatır.",
            realWorldExample = "Pydantic ve Django ORM tüm model validasyonlarını ve veritabanı şema eşlemelerini Metaclass ve Descriptor motoruyla yönetir.",
            practicalTask = "String değerlerin sadece harflerden oluşmasını denetleyen bir 'HarfDogrulayici' descriptor sınıfı yazın.",
            starterPlaygroundCode = "class Meta(type): pass\nclass X(metaclass=Meta): pass\nprint(type(X))",
            miniQuestion = MiniQuestion(
                id = "py_q_11",
                question = "Python'da standart bir sınıfın (class X:) metasınıfı (varsayılan üreticisi) nedir?",
                options = listOf("object", "type", "class", "module"),
                correctIndex = 1,
                explanation = "Python'da sınıfları üreten varsayılan metasınıf 'type'tır (class X() bir type nesnesidir)."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_11",
                lessonId = "py_11",
                title = "Pozitif Tamsayı Doğrulayıcı Descriptor",
                instructions = "Sadece pozitif tamsayı (> 0) atanmasına izin veren; sıfır veya negatif gelirse ValueError fırlatan PozitifInt descriptor sınıfını yazın.",
                exampleInput = "obj.yas = -5",
                exampleOutput = "ValueError",
                starterCode = "class PozitifInt:\n    # Descriptor'ı buraya yaz:\n    pass",
                solutionCode = "class PozitifInt:\n    def __set_name__(self, owner, name):\n        self.name = name\n    def __get__(self, instance, owner):\n        if instance is None: return self\n        return instance.__dict__.get(self.name, 0)\n    def __set__(self, instance, value):\n        if not isinstance(value, int) or value <= 0:\n            raise ValueError(f'{self.name} pozitif tamsayı olmalıdır!')\n        instance.__dict__[self.name] = value",
                hints = listOf("__set_name__, __get__ ve __set__ metotlarını kurun."),
                testCases = listOf(
                    TestCase("Descriptor", "True", "Validasyon kontrolü")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_11_1",
                    lessonId = "py_11",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Data Descriptor ile Non-Data Descriptor arasındaki teknik fark nedir?",
                    options = listOf("Data descriptor daha hızlıdır", "Data descriptor hem __get__ hem __set__ içerirken, Non-data descriptor sadece __get__ içerir (örn. metotlar)", "Data descriptor veritabanına yazar", "Non-data descriptor salt okunurdur"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! __set__ içeren descriptor'lar Data Descriptor'dır ve örnek sözlüğünden (__dict__) daha yüksek önceliğe sahiptir.",
                    explanationWrong = "Data descriptor hem __get__ hem __set__ metodunu tanımlar.",
                    reviewTopic = "Descriptors"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "__set_name__ metodu ne zaman tetiklenir?",
                    answer = "Descriptor içeren sınıf ilk tanımlandığında Python derleyicisi tarafından otomatik çağrılır ve değişkenin sınıf içindeki adını (string) descriptor'a haber verir."
                )
            ),
            completionCriteria = listOf(
                "Descriptor protokolü ile alan validatörleri kurabilmek",
                "type ile dinamik sınıf üretebilmek",
                "Metaclass ile sınıf inşasını denetleyebilmek"
            )
        ),

        // ==========================================
        // DERS 12: CPYTHON INTERNALS, GC & BYTECODE
        // ==========================================
        Lesson(
            id = "py_12",
            courseId = "python",
            sectionId = "py_sec_6",
            title = "CPython Internals, Bytecode & Cyclic GC",
            shortDesc = "CPython C mimarisi: PyObject anatomisi, Reference Counting, 3-Jenerasyonlu Döngüsel Çöp Toplayıcı (Cyclic GC) ve Bytecode analizi (dis).",
            level = CourseLevel.EXPERT,
            order = 12,
            isPremium = true,
            learningObjectives = listOf(
                "CPython'un temel C yapısını (PyObject & ob_refcnt) kavramak",
                "Referans sayacı yetersiz kaldığında devreye giren 3-jenerasyonlu Cyclic Garbage Collector mantığını öğrenmek",
                "dis modülü ile Python Bytecode komutlarını analiz edip performans darboğazlarını çözmek"
            ),
            prerequisites = listOf("Metaprogramming & Eşzamanlılık"),
            subtopics = listOf("PyObject C Struct Anatomisi", "sys.getrefcount & Bellek İdaresi", "Cyclic Garbage Collector (Gen 0, 1, 2)", "dis Modülü & Bytecode Talimatları", "C Uzantıları & Performans Optimizasyonu"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. CPython Bellek Modeli & PyObject C Yapısı",
                    body = "CPython'da tam sayılardan fonksiyonlara kadar her nesne bir C struct'ıdır:\n\n`typedef struct _object { Py_ssize_t ob_refcnt; struct _typeobject *ob_type; } PyObject;`\n\n• `ob_refcnt`: Nesneyi gösteren referans sayısı. Sıfıra düştüğünde bellek anında işletim sistemine geri verilir (Immediate deallocation).",
                    codeSnippet = "import sys\na = [1, 2, 3]\nb = a # Referans sayısı 2 oldu\nprint(sys.getrefcount(a)) # 3 basar (getrefcount argümanı geçici bir referanstır)"
                ),
                LessonContentBlock(
                    subtitle = "2. Cyclic Garbage Collector ve Python Bytecode (dis)",
                    body = "Döngüsel referanslarda (`a.child = b; b.parent = a`) nesneler silinse dahi referans sayıları asla sıfıra inmez. Bu bellek sızıntısını engellemek için CPython, 3 jenerasyonlu (Generation 0, 1, 2) 'Cyclic Garbage Collector' algoritmasını çalıştırır.\n\n`dis` modülü ise yazdığınız Python fonksiyonlarının sanal makinede (CPython VM) hangi yığın (stack) komutlarına dönüştüğünü gösterir.",
                    codeSnippet = "import dis\n\ndef topla(x, y):\n    return x + y\n\ndis.dis(topla) # LOAD_FAST, BINARY_OP, RETURN_VALUE",
                    tip = "Bytecode seviyesinde optimizasyon analizi için yerleşik `dis` modülü kullanılır."
                )
            ),
            codeExample = "import dis\n\ndef hizli_topla(a, b):\n    return a + b\n\n# Python sanal makinesinin yürüttüğü Bytecode komutları:\ndis.dis(hizli_topla)",
            codeExplanation = "dis.dis() fonksiyonu Python derleyicisinin ürettiği LOAD_FAST ve BINARY_ADD bytecode talimatlarını ekrana döker.",
            realWorldExample = "Yüksek frekanslı finans ve oyun sunucularında kritik anlarda GC duraklamalarını (Stop-the-world) önlemek için `gc.disable()` uygulanır.",
            practicalTask = "Birbirini referans alan iki nesne oluşturup gc.collect() çağırarak temizlenen döngüsel referans sayısını ekrana yazdırın.",
            starterPlaygroundCode = "import gc\nprint(f'Toplanan döngüsel nesneler: {gc.collect()}')",
            miniQuestion = MiniQuestion(
                id = "py_q_12",
                question = "CPython'da bir nesnenin bellekteki referans sayacı (ob_refcnt) sıfıra düştüğünde ne gerçekleşir?",
                options = listOf("Nesne Gen 2 jenerasyonuna taşınır", "Belleği anında (hemen o anda) serbest bırakılır", "Program sonlanırken temizlenir", "Diske yazılır"),
                correctIndex = 1,
                explanation = "CPython'ın birincil bellek yöneticisi referans sayacıdır; sıfıra indiğinde nesne anında yok edilir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_py_12",
                lessonId = "py_12",
                title = "Bellek Sızıntısı Simülatörü",
                instructions = "Döngüsel referans oluşturan iki liste üretip gc modülü ile döngüleri toplayan ve toplanan nesne sayısını int olarak döndüren dongu_temizle() fonksiyonunu yazın.",
                exampleInput = "dongu_temizle()",
                exampleOutput = "> 0",
                starterCode = "import gc\ndef dongu_temizle() -> int:\n    # Kodunu buraya yaz:\n    return 0",
                solutionCode = "import gc\ndef dongu_temizle() -> int:\n    gc.disable()\n    a = []\n    b = [a]\n    a.append(b)\n    del a\n    del b\n    temizlenen = gc.collect()\n    gc.enable()\n    return temizlenen",
                hints = listOf("a = []; b = [a]; a.append(b) ile döngü kurun."),
                testCases = listOf(
                    TestCase("dongu_temizle() > 0", "True", "GC döngü temizliği")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_quiz_12_1",
                    lessonId = "py_12",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "CPython'ın 3 jenerasyonlu Cyclic Garbage Collector'ında en uzun ömürlü ve en seyrek taranan jenerasyon hangisidir?",
                    options = listOf("Generation 0", "Generation 1", "Generation 2", "Generation 3"),
                    correctOptionIndex = 2,
                    explanationRight = "Doğru! Gen 2 en yaşlı nesnelerin bulunduğu ve en seyrek tam tarama (full sweep) yapılan alandır.",
                    explanationWrong = "Gen 2 en uzun ömürlü jenerasyondur.",
                    reviewTopic = "CPython GC"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Python Bytecode nedir?",
                    answer = "Python kaynak kodunun derleyici tarafından sanal makinenin (CPython VM) anlayabileceği yığın tabanlı (stack-based) ara makine komutlarına dönüştürülmüş halidir (.pyc dosyalarında önbelleklenir)."
                )
            ),
            completionCriteria = listOf(
                "PyObject C yapısını ve referans sayacı mantığını bilmek",
                "Cyclic GC jenerasyonlarını ve döngü çözmeyi kavramak",
                "dis modülü ile bytecode analizi yapabilmek"
            )
        )
    )
}
