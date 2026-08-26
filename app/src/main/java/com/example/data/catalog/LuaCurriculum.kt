package com.example.data.catalog

import com.example.model.*

/**
 * Lua Kolay & Anlaşılır Müfredatı (12 Adım):
 * Roblox'un, oyun modlama dünyasının ve gömülü sistemlerin tüy kadar hafif dili Lua'yı eğlenceli örneklerle öğrenin!
 */
object LuaCurriculum {

    fun getSections(): List<CourseSection> = listOf(
        CourseSection(
            id = "lua_sec_1",
            courseId = "lua",
            title = "Bölüm 1: Lua Temelleri ve Kontrol Akışı",
            level = CourseLevel.BEGINNER,
            order = 1,
            description = "print(), değişkenler, metin birleştirme (..), if-then ve döngüler.",
            learningObjectives = listOf("print() ile ekrana yazdırmak", "local değişken tanımlamak", "if-then ve for döngüleri kurmak"),
            prerequisites = listOf("Ön koşul gerekmez! Sıfırdan başlar.")
        ),
        CourseSection(
            id = "lua_sec_2",
            courseId = "lua",
            title = "Bölüm 2: Fonksiyonlar ve Tablolar (Tables)",
            level = CourseLevel.BEGINNER,
            order = 2,
            description = "Tek fonksiyondan 2 sonuç döndürme ve Lua'nın tek ama efsanevi veri yapısı: Tablolar.",
            learningObjectives = listOf("Birden fazla değer döndüren fonksiyon yazmak", "Tabloları liste ve sözlük olarak kullanmak", "ipairs ve pairs ile tabloyu gezmek"),
            prerequisites = listOf("Lua Temelleri")
        ),
        CourseSection(
            id = "lua_sec_3",
            courseId = "lua",
            title = "Bölüm 3: Metatable ve Nesne Yönelimli Lua (OOP)",
            level = CourseLevel.INTERMEDIATE,
            order = 3,
            description = "Tablolara sihirli güçler katan Metatable, __index ve iki nokta (:) ile self kullanımı.",
            learningObjectives = listOf("setmetatable ve __index mantığını anlamak", "Sınıf ve nesne üretmek"),
            prerequisites = listOf("Tablolar ve Fonksiyonlar")
        ),
        CourseSection(
            id = "lua_sec_4",
            courseId = "lua",
            title = "Bölüm 4: Eşyordamlar (Coroutines) ve Metin Arama",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            description = "Fonksiyonu ortada duraklatıp (yield) sonra devam ettirme (resume) ve string.match.",
            learningObjectives = listOf("coroutine ile oyun akışlarını yönetmek", "string.match ile metin ayıklamak"),
            prerequisites = listOf("Metatable ve OOP")
        ),
        CourseSection(
            id = "lua_sec_5",
            courseId = "lua",
            title = "Bölüm 5: Modüller ve require()",
            level = CourseLevel.ADVANCED,
            order = 5,
            description = "Kodları dosyalara bölme, require() ile yükleme ve local kapsam disiplini.",
            learningObjectives = listOf("Modül dosyası oluşturup çağırmak", "Global kirliliği önlemek"),
            prerequisites = listOf("Coroutines ve Tablolar")
        ),
        CourseSection(
            id = "lua_sec_6",
            courseId = "lua",
            title = "Bölüm 6: Roblox, Oyunlar ve Lua Ustalığı",
            level = CourseLevel.EXPERT,
            order = 6,
            description = "Roblox Studio kodlama mantığı, oyun motorları ve profesyonel Lua ipuçları.",
            learningObjectives = listOf("Roblox ve oyun motoru mantığını kavramak", "Hızlı ve temiz Lua scriptleri yazmak"),
            prerequisites = listOf("Tüm Seviyeler")
        )
    )

    fun getLessons(): List<Lesson> = listOf(
        // ==========================================
        // DERS 1: PRINT VE DEĞİŞKENLER
        // ==========================================
        Lesson(
            id = "lua_1",
            courseId = "lua",
            sectionId = "lua_sec_1",
            title = "Lua Diline Giriş: print() ve Değişkenler",
            shortDesc = "Roblox ve oyun dünyasının en hafif dili! print(), local değişkenler ve .. ile metin birleştirme.",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false,
            learningObjectives = listOf(
                "print() fonksiyonu ile ekrana yazdırmak",
                "local anahtar kelimesi ile güvenli değişken tanımlamak",
                ".. (iki nokta) operatörü ile metinleri birleştirmek"
            ),
            prerequisites = listOf("Ön koşul gerekmez."),
            subtopics = listOf("Lua Neden Çok Hafif?", "print()", "local Değişkenler", ".. Metin Birleştirme"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Tüy Kadar Hafif Bir Dil: Lua",
                    body = "Lua, dünyadaki en hızlı ve en hafif betik dillerinden biridir. Roblox oyunları, World of Warcraft eklentileri, Angry Birds ve Neovim Lua ile kodlanır.\n\nEkrana yazı yazmak için `print()` kullanılır."
                ),
                LessonContentBlock(
                    subtitle = "2. local Değişkenler ve .. Birleştirme",
                    body = "Lua'da değişken tanımlarken başına mutlaka `local` yazarız. İki metni yan yana yapıştırmak için ise araya `..` koyarız.",
                    codeSnippet = "local isim = \"Deniz\"\nlocal yas = 20\n\nprint(\"Merhaba \" .. isim .. \", Yaş: \" .. yas)"
                )
            ),
            codeExample = "local skor = 100\nprint(\"Puanınız: \" .. skor)",
            codeExplanation = "local değişken tanımlandı ve .. operatörü ile metne bağlandı.",
            realWorldExample = "Roblox Studio'da bir bloğa dokunulduğunda kapının açılmasını sağlayan scriptler Lua ile yazılır.",
            practicalTask = "Adınızı ve favori oyununuzu print ile ekrana yazdırın.",
            starterPlaygroundCode = "local ad = \"Ali\"\nprint(\"Oyuncu: \" .. ad)",
            miniQuestion = MiniQuestion(
                id = "lua_q_1",
                question = "Lua'da iki metni (string) birbirine bağlayıp birleştirmek için hangi operatör kullanılır?",
                options = listOf(".. (İki Nokta)", "+", "&", "."),
                correctIndex = 0,
                explanation = "Lua'da metin birleştirme için '..' operatörü kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_lua_1",
                lessonId = "lua_1",
                title = "İki Sayıyı Topla",
                instructions = "İki sayıyı toplayıp döndüren topla(a, b) fonksiyonunu yazın.",
                exampleInput = "topla(10, 20)",
                exampleOutput = "30",
                starterCode = "function topla(a, b)\n    -- Kodunu yaz:\n    return 0\nend",
                solutionCode = "function topla(a, b)\n    return a + b\nend",
                hints = listOf("return a + b yazın."),
                testCases = listOf(
                    TestCase("topla(10, 20)", "30", "Toplam testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "lua_quiz_1_1",
                    lessonId = "lua_1",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Lua'da değişken tanımlarken başına 'local' yazmazsanız ne olur?",
                    options = listOf("Değişken global olur ve tüm programdan kontrolsüzce erişilebilir", "Hata verir", "Sabit olur", "Silinir"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Başına local konmayan değişkenler global olur; bu yüzden hep local tercih edilir.",
                    explanationWrong = "Global olur.",
                    reviewTopic = "Lua Değişkenler"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Lua'da tek satırlık yorum nasıl yazılır?",
                    answer = "-- (iki tire) işaretiyle yazılır (Örn: -- Bu bir yorumdur)."
                )
            ),
            completionCriteria = listOf(
                "print() ve local kullanımını bilmek",
                ".. operatörü ile metin birleştirebilmek"
            )
        ),

        // ==========================================
        // DERS 2: KOŞULLAR VE DÖNGÜLER
        // ==========================================
        Lesson(
            id = "lua_2",
            courseId = "lua",
            sectionId = "lua_sec_1",
            title = "Kararlar (if-then-end) ve Döngüler (for, while)",
            shortDesc = "then ve end blokları ile koşullar, sayısal for döngüsü ve repeat-until.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false,
            learningObjectives = listOf(
                "if ... then ... else ... end kalıbını öğrenmek",
                "for i = 1, 5 do ... end sayısal döngüsünü kullanmak",
                "while ve repeat-until döngülerini kavramak"
            ),
            prerequisites = listOf("Lua Değişkenleri"),
            subtopics = listOf("if then else end", "Sayısal for", "repeat until"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. if-then-end Yapısı",
                    body = "Lua'da süslü parantez `{}` yoktur; bloklar `then` ile başlar ve `end` ile biter.",
                    codeSnippet = "local can = 80\n\nif can <= 0 then\n    print(\"Elendiniz! 💀\")\nelseif can < 50 then\n    print(\"Canınız az!\")\nelse\n    print(\"Durumunuz iyi! 🛡️\")\nend"
                ),
                LessonContentBlock(
                    subtitle = "2. for Döngüsü",
                    body = "1'den 5'e kadar saymak için: `for i = 1, 5 do` yazılır.",
                    codeSnippet = "for i = 1, 5 do\n    print(\"Adım: \" .. i)\nend"
                )
            ),
            codeExample = "local top = 0\nfor i = 1, 5 do\n    top = top + i\nend\nprint(\"Toplam: \" .. top) -- 15",
            codeExplanation = "for döngüsüyle 1-5 arası sayılar toplandı.",
            realWorldExample = "Roblox oyunlarında geri sayım sayacı yaparken 'for i = 10, 1, -1 do' döngüsü kullanılır.",
            practicalTask = "1'den 10'a kadar olan çift sayıları yazdıran bir for döngüsü kurun.",
            starterPlaygroundCode = "for i = 2, 10, 2 do print(i) end",
            miniQuestion = MiniQuestion(
                id = "lua_q_2",
                question = "Lua'da if veya for bloklarının sona erdiğini belirtmek için hangi anahtar kelime kullanılır?",
                options = listOf("end", "stop", "finish", "done"),
                correctIndex = 0,
                explanation = "Lua blokları 'end' kelimesiyle kapatılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_lua_2",
                lessonId = "lua_2",
                title = "Pozitif Sayı Kontrolü",
                instructions = "sayi > 0 ise 'Pozitif', değilse 'Sıfır veya Negatif' döndüren kontrol(sayi) fonksiyonunu yazın.",
                exampleInput = "kontrol(5)",
                exampleOutput = "\"Pozitif\"",
                starterCode = "function kontrol(sayi)\n    -- Kodunu yaz:\n    return \"\"\nend",
                solutionCode = "function kontrol(sayi)\n    if sayi > 0 then\n        return \"Pozitif\"\n    else\n        return \"Sıfır veya Negatif\"\n    end\nend",
                hints = listOf("if sayi > 0 then return \"Pozitif\" else return \"Sıfır veya Negatif\" end yazın."),
                testCases = listOf(
                    TestCase("kontrol(5)", "Pozitif", "Pozitif sayı"),
                    TestCase("kontrol(-2)", "Sıfır veya Negatif", "Negatif sayı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "lua_quiz_2_1",
                    lessonId = "lua_2",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Lua'da 'Eşit Değildir' karşılaştırma operatörü hangisidir?",
                    options = listOf("~=", "!=", "<>", "!=="),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Lua'da eşit değil kontrolü '~=' ile yapılır.",
                    explanationWrong = "~= operatörü kullanılır.",
                    reviewTopic = "Lua Operatörler"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Lua'da 0 (sıfır) boolean olarak true mudur false mu?",
                    answer = "Lua'da SADECE 'false' ve 'nil' değerleri false sayılır. 0 ve boş metin (\"\") TRUE kabul edilir!"
                )
            ),
            completionCriteria = listOf(
                "if-then-end yapısını kurabilmek",
                "for ve while döngülerini bilmek"
            )
        ),

        // ==========================================
        // DERS 3: FONKSİYONLAR VE ÇOKLU DÖNÜŞ
        // ==========================================
        Lesson(
            id = "lua_3",
            courseId = "lua",
            sectionId = "lua_sec_2",
            title = "Fonksiyonlar ve Çoklu Değer Döndürme",
            shortDesc = "Tek bir fonksiyondan virgülle birden fazla sonuç döndürme süper gücü.",
            level = CourseLevel.BEGINNER,
            order = 3,
            isPremium = false,
            learningObjectives = listOf(
                "function ... end ile fonksiyon yazmak",
                "return sonuc1, sonuc2 ile birden fazla değer döndürmek",
                "Fonksiyonları değişken gibi parametre olarak aktarmak"
            ),
            prerequisites = listOf("Lua Koşulları ve Döngüleri"),
            subtopics = listOf("Fonksiyon Tanımlama", "Çoklu Değer Döndürme", "Anonim Fonksiyonlar"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Tek Seferde Birden Çok Sonuç",
                    body = "Bir fonksiyon hem minimumu hem maksimumu aynı anda döndürebilir!",
                    codeSnippet = "function min_ve_max(a, b)\n    if a < b then\n        return a, b\n    else\n        return b, a\n    end\nend\n\nlocal kucuk, buyuk = min_ve_max(10, 5)\nprint(\"Küçük: \" .. kucuk .. \", Büyük: \" .. buyuk)"
                )
            ),
            codeExample = "function kare_ve_kup(x)\n    return x*x, x*x*x\nend\n\nlocal k, ku = kare_ve_kup(3) -- 9, 27",
            codeExplanation = "kare_ve_kup tek çağrıda iki farklı hesaplama sonucunu döndürdü.",
            realWorldExample = "Oyunlarda oyuncunun hem (X, Y) koordinatını tek fonksiyondan almak için çoklu return kullanılır.",
            practicalTask = "İki sayının toplamını ve farkını döndüren bir fonksiyon yazın.",
            starterPlaygroundCode = "function topla_cikar(a, b) return a+b, a-b end",
            miniQuestion = MiniQuestion(
                id = "lua_q_3",
                question = "Lua'da bir fonksiyon aynı anda birden fazla değer geri döndürebilir mi?",
                options = listOf("Evet, return a, b şeklinde virgülle döndürebilir", "Hayır, sadece tek değer döner", "Sadece dizi ile döner", "Hata verir"),
                correctIndex = 0,
                explanation = "Lua fonksiyonları 'return a, b' ile birden çok değer döndürebilir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_lua_3",
                lessonId = "lua_3",
                title = "Küp Hesaplayıcı",
                instructions = "Verilen sayının küpünü (x * x * x) hesaplayan kup(x) fonksiyonunu yazın.",
                exampleInput = "kup(3)",
                exampleOutput = "27",
                starterCode = "function kup(x)\n    -- Kodunu yaz:\n    return 0\nend",
                solutionCode = "function kup(x)\n    return x * x * x\nend",
                hints = listOf("return x * x * x yazın."),
                testCases = listOf(
                    TestCase("kup(3)", "27", "3'ün küpü"),
                    TestCase("kup(2)", "8", "2'nin küpü")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "lua_quiz_3_1",
                    lessonId = "lua_3",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Lua'da yerel (local) bir fonksiyon tanımlamanın en temiz yolu hangisidir?",
                    options = listOf("local function topla() ... end", "def topla()", "fn topla()", "func topla()"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! 'local function' kullanımı en yaygın standarttır.",
                    explanationWrong = "local function kullanılır.",
                    reviewTopic = "Lua Fonksiyonlar"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Lua'da fonksiyonlar First-Class mıdır?",
                    answer = "Evet! Fonksiyonları bir değişkene atayabilir, tablolara koyabilir veya başka fonksiyona parametre verebilirsiniz."
                )
            ),
            completionCriteria = listOf(
                "Fonksiyon tanımlayabilmek",
                "Çoklu return mantığını kavramak"
            )
        ),

        // ==========================================
        // DERS 4: TABLOLAR (TABLES)
        // ==========================================
        Lesson(
            id = "lua_4",
            courseId = "lua",
            sectionId = "lua_sec_2",
            title = "Lua'nın Süper Gücü: Tablolar (Tables)",
            shortDesc = "Dizi, liste, sözlük ve nesne... Hepsi tek bir yapıda: { }. Dikkat: Lua'da indeks 1'den başlar!",
            level = CourseLevel.BEGINNER,
            order = 4,
            isPremium = true,
            learningObjectives = listOf(
                "Tabloların (Tables) Lua'daki tek veri saklama yapısı olduğunu anlamak",
                "Önemli kural: Lua dizi indekslerinin 0'dan değil 1'den başladığını öğrenmek",
                "Tabloyu hem liste hem sözlük (Key-Value) olarak kullanmak"
            ),
            prerequisites = listOf("Fonksiyonlar ve Değişkenler"),
            subtopics = listOf("Tablo Tanımlama { }", "1-Tabanlı İndeks Kuralı", "Sözlük Kullanımı"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Lua'da Her Şey Tablodur!",
                    body = "Lua'da ayrı ayrı array, list, dictionary veya object yoktur; hepsi `{ }` tablosudur.\n\n⚠️ **Çok Önemli:** Lua'da listelerin ilk elemanı `dizi[1]`'dir (0 değil!)."
                ),
                LessonContentBlock(
                    subtitle = "2. Liste ve Sözlük Örneği",
                    body = "Nokta ile veya köşeli parantezle erişebilirsiniz.",
                    codeSnippet = "-- 1. Liste:\nlocal meyveler = {\"Elma\", \"Armut\", \"Muz\"}\nprint(meyveler[1]) -- \"Elma\" (1'den başlar!)\n\n-- 2. Sözlük (Dictionary):\nlocal oyuncu = {\n    isim = \"Barbaros\",\n    can = 100,\n    seviye = 5\n}\nprint(oyuncu.isim .. \" Can: \" .. oyuncu.can)"
                )
            ),
            codeExample = "local envanter = {}\nenvanter.kilic = \"Ateş Kılıcı\"\nprint(envanter.kilic)",
            codeExplanation = "Boş tablo oluşturulup içine anahtar-değer atandı.",
            realWorldExample = "Roblox oyunlarında bir oyuncunun sahip olduğu tüm eşyalar bir Tablo içinde tutulur.",
            practicalTask = "3 elemanlı bir liste tablosu açıp ilk elemanını print ile yazdırın.",
            starterPlaygroundCode = "local renkler = {\"Kırmızı\", \"Yeşil\", \"Mavi\"}\nprint(renkler[1])",
            miniQuestion = MiniQuestion(
                id = "lua_q_4",
                question = "Lua programlama dilinde bir listenin (dizi) İLK elemanının indeksi kaçtır?",
                options = listOf("1", "0", "-1", "Tanımsız"),
                correctIndex = 0,
                explanation = "Lua'da dizi indeksleri 1'den başlar (dizi[1])."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_lua_4",
                lessonId = "lua_4",
                title = "İlk Elemanı Al",
                instructions = "Verilen dizi tablosunun ilk elemanını (1. indeks) döndüren ilk_eleman(dizi) fonksiyonunu yazın.",
                exampleInput = "ilk_eleman({\"A\", \"B\"})",
                exampleOutput = "\"A\"",
                starterCode = "function ilk_eleman(dizi)\n    -- Kodunu yaz:\n    return nil\nend",
                solutionCode = "function ilk_eleman(dizi)\n    return dizi[1]\nend",
                hints = listOf("return dizi[1] yazın."),
                testCases = listOf(
                    TestCase("ilk_eleman({\"Lua\", \"Python\"})", "Lua", "İlk eleman testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "lua_quiz_4_1",
                    lessonId = "lua_4",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Lua'da bir dizi tablosunun eleman sayısını hızlıca öğrenmek için hangi operatör kullanılır?",
                    options = listOf("# (Diyez) örn: #meyveler", "len()", "count()", "size()"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Uzunluk için tablonun önüne '#' konur (#tablo).",
                    explanationWrong = "# operatörü kullanılır.",
                    reviewTopic = "Lua Tablo Uzunluğu"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "table.insert ne işe yarar?",
                    answer = "table.insert(liste, \"Yeni\") ile listenin sonuna yeni bir eleman eklersiniz."
                )
            ),
            completionCriteria = listOf(
                "Tablo tanımlayıp eleman ekleyebilmek",
                "1-tabanlı indeks kuralını unutmamak"
            )
        ),

        // ==========================================
        // DERS 5: İPAIRS VE PAIRS
        // ==========================================
        Lesson(
            id = "lua_5",
            courseId = "lua",
            sectionId = "lua_sec_2",
            title = "Tablo İteratörleri: ipairs ve pairs",
            shortDesc = "Sıralı listeleri gezmek için 'ipairs', sözlük ve anahtarları gezmek için 'pairs'.",
            level = CourseLevel.BEGINNER,
            order = 5,
            isPremium = true,
            learningObjectives = listOf(
                "ipairs ile sıralı listelerde (1, 2, 3...) döngü kurmak",
                "pairs ile anahtar-değer (Key-Value) sözlüklerini gezmek"
            ),
            prerequisites = listOf("Tablolar"),
            subtopics = listOf("ipairs (Sıralı Liste)", "pairs (Sözlük Gezici)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Hangisini Ne Zaman Kullanmalı?",
                    body = "• **ipairs (Index-Pairs):** Sayısal sıralı listelerde kullanılır (`1, 2, 3...`). Hızlıdır ve sırayı garanti eder.\n• **pairs:** İsimli anahtarlara sahip sözlüklerde kullanılır (`isim, yas, skor...`)."
                ),
                LessonContentBlock(
                    subtitle = "2. Örnek Kullanım",
                    body = "for anahtar, deger in pairs(tablo) do",
                    codeSnippet = "local sehirler = {\"Ankara\", \"İstanbul\", \"İzmir\"}\nfor indeks, sehir in ipairs(sehirler) do\n    print(indeks .. \". Şehir: \" .. sehir)\nend\n\nlocal skorlar = { Ahmet = 90, Canan = 100 }\nfor isim, puan in pairs(skorlar) do\n    print(isim .. \" -> \" .. puan)\nend"
                )
            ),
            codeExample = "local t = {10, 20, 30}\nlocal top = 0\nfor _, v in ipairs(t) do top = top + v end\nprint(\"Toplam: \" .. top) -- 60",
            codeExplanation = "ipairs ile sayısal liste elemanları toplandı.",
            realWorldExample = "Roblox haritasındaki tüm blokları tek tek boyamak için pairs(workspace:GetChildren()) kullanılır.",
            practicalTask = "ipairs ile 3 meyve adını yazdıran döngüyü inceleyin.",
            starterPlaygroundCode = "for i, v in ipairs({\"A\", \"B\"}) do print(v) end",
            miniQuestion = MiniQuestion(
                id = "lua_q_5",
                question = "Lua'da 1, 2, 3 şeklinde sıralı indekslere sahip bir diziyi sırayla gezmek için hangi iteratör fonksiyonu tercih edilir?",
                options = listOf("ipairs", "pairs", "each", "enumerate"),
                correctIndex = 0,
                explanation = "Sıralı indeksli diziler için 'ipairs' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_lua_5",
                lessonId = "lua_5",
                title = "Tablo Elemanları Toplamı",
                instructions = "ipairs kullanarak verilen sayılar tablosunun toplamını hesaplayan tablo_toplami(t) fonksiyonunu yazın.",
                exampleInput = "tablo_toplami({5, 10, 15})",
                exampleOutput = "30",
                starterCode = "function tablo_toplami(t)\n    -- Kodunu yaz:\n    return 0\nend",
                solutionCode = "function tablo_toplami(t)\n    local top = 0\n    for _, v in ipairs(t) do\n        top = top + v\n    end\n    return top\nend",
                hints = listOf("for _, v in ipairs(t) do top = top + v end return top yazın."),
                testCases = listOf(
                    TestCase("tablo_toplami({5, 10, 15})", "30", "Tablo toplamı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "lua_quiz_5_1",
                    lessonId = "lua_5",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "for i, v in ipairs(tablo) döngüsünde 'i' değerini kullanmak istemiyorsanız yerine ne yazmak iyi bir gelenektir?",
                    options = listOf("_ (Alt çizgi)", "x", "ignore", "pass"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Kullanılmayan değişkenler için '_' yazılır.",
                    explanationWrong = "_ kullanılır.",
                    reviewTopic = "Lua İteratörler"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "ipairs tabloda nil görünce ne yapar?",
                    answer = "ipairs sıralı gider ve karşılaştığı ilk nil değerde döngüyü hemen sonlandırır."
                )
            ),
            completionCriteria = listOf(
                "ipairs ve pairs farkını kavramak",
                "Tablo döngüleri kurabilmek"
            )
        ),

        // ==========================================
        // DERS 6: METATABLE VE OOP
        // ==========================================
        Lesson(
            id = "lua_6",
            courseId = "lua",
            sectionId = "lua_sec_3",
            title = "Metatable ve Nesne Yönelimli Lua (OOP)",
            shortDesc = "Tablolara sihirli güçler katan setmetatable ve aranan alan bulunamazsa devreye giren __index.",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true,
            learningObjectives = listOf(
                "setmetatable ile iki tabloyu birbirine bağlamak",
                "__index metametodu ile kalıtım ve sınıf şablonu oluşturmak",
                "Lua'da prototip tabanlı nesneler üretmek"
            ),
            prerequisites = listOf("Tablolar ve pairs"),
            subtopics = listOf("setmetatable()", "__index Metametodu", "Sınıf Deseni"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Metatable: Tablonun Kullanım Kılavuzu",
                    body = "Bir tablonun içinde olmayan bir değişkeni veya fonksiyonu aradığınızda, Lua metatable içindeki `__index` tablosuna bakar. Bu sayede tüm nesneler tek bir sınıftan metotları miras alabilir!",
                    codeSnippet = "local Araba = {}\nAraba.__index = Araba\n\nfunction Araba.yeni(marka)\n    local self = setmetatable({}, Araba)\n    self.marka = marka\n    return self\nend\n\nfunction Araba:korna()\n    print(self.marka .. \": Düt düt! 🚗\")\nend"
                )
            ),
            codeExample = "local a = Araba.yeni(\"Tesla\")\na:korna() -- Tesla: Düt düt!",
            codeExplanation = "Araba sınıfından yeni bir nesne üretildi ve metodu çağrıldı.",
            realWorldExample = "Roblox oyunlarındaki tüm silah ve canavar sınıfları metatable ile yazılır.",
            practicalTask = "setmetatable ile basit bir sınıf şablonunu inceleyin.",
            starterPlaygroundCode = "local Sinif = {}; Sinif.__index = Sinif",
            miniQuestion = MiniQuestion(
                id = "lua_q_6",
                question = "Lua'da bir tabloda bulunamayan bir anahtarın üst şablonda (prototipte) aranmasını sağlayan sihirli metametod hangisidir?",
                options = listOf("__index", "__newindex", "__tostring", "__call"),
                correctIndex = 0,
                explanation = "Kalıtım ve şablon arama için '__index' metametodu kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_lua_6",
                lessonId = "lua_6",
                title = "Nesne Üretici",
                instructions = "deger alanına sahip ve sablon tablosunu metatable olarak bağlayan nesne_yap(sablon, deger) fonksiyonunu yazın.",
                exampleInput = "nesne_yap(S, 10)",
                exampleOutput = "{ deger = 10 }",
                starterCode = "function nesne_yap(sablon, deger)\n    -- Kodunu yaz:\n    return {}\nend",
                solutionCode = "function nesne_yap(sablon, deger)\n    local obj = { deger = deger }\n    setmetatable(obj, sablon)\n    return obj\nend",
                hints = listOf("local obj = { deger = deger } setmetatable(obj, sablon) return obj yazın."),
                testCases = listOf(
                    TestCase("nesne_yap({}, 5).deger", "5", "Nesne üretimi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "lua_quiz_6_1",
                    lessonId = "lua_6",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Lua'da iki tabloyu '+' işaretiyle toplamaya olanak tanıyan metametod hangisidir?",
                    options = listOf("__add", "__sum", "__plus", "__concat"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Toplama işlemi için __add metametodu kullanılır.",
                    explanationWrong = "__add kullanılır.",
                    reviewTopic = "Lua Metamethods"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "__tostring ne işe yarar?",
                    answer = "Tabloyu print(tablo) ile ekrana bastığınızda 'table: 0x...' yerine anlamlı bir yazı çıkmasını sağlar."
                )
            ),
            completionCriteria = listOf(
                "setmetatable ve __index kullanımını kavramak",
                "Lua'da OOP mantığını anlamak"
            )
        ),

        // ==========================================
        // DERS 7: İKİ NOKTA (:) VE SELF
        // ==========================================
        Lesson(
            id = "lua_7",
            courseId = "lua",
            sectionId = "lua_sec_3",
            title = "İki Nokta (:) ile Metotlar ve self Kavramı",
            shortDesc = "Nokta (.) ile İki Nokta (:) arasındaki fark ve 'self' parametresinin otomatik aktarımı.",
            level = CourseLevel.INTERMEDIATE,
            order = 7,
            isPremium = true,
            learningObjectives = listOf(
                "nesne:metot() sözdiziminin nesne.metot(nesne) ile aynı olduğunu anlamak",
                "self anahtar kelimesi ile nesnenin kendi özelliklerine erişmek"
            ),
            prerequisites = listOf("Metatable ve OOP"),
            subtopics = listOf("İki Nokta (:) Sözdizimi", "self Parametresi"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. İki Nokta (:) Sihri",
                    body = "`oyuncu:hasar_al(20)` yazdığınızda Lua arka planda otomatik olarak `oyuncu.hasar_al(oyuncu, 20)` yapar ve ilk parametreye `self` adını verir.",
                    codeSnippet = "local Oyuncu = {}\nOyuncu.__index = Oyuncu\n\nfunction Oyuncu:hasar_al(miktar)\n    self.can = self.can - miktar\n    print(self.isim .. \" kalan can: \" .. self.can)\nend"
                )
            ),
            codeExample = "local p = { isim = \"Kurt\", can = 100 }\nsetmetatable(p, Oyuncu)\np:hasar_al(30) -- Kurt kalan can: 70",
            codeExplanation = "p:hasar_al çağrısı ile self otomatik olarak p nesnesi oldu.",
            realWorldExample = "Roblox API'sindeki 'part:Destroy()' veya 'humanoid:TakeDamage(10)' fonksiyonları bu yapıyla çalışır.",
            practicalTask = "self.can değerini 10 artıran bir iyiles metodu tasarlayın.",
            starterPlaygroundCode = "function Oyuncu:iyiles() self.can = self.can + 10 end",
            miniQuestion = MiniQuestion(
                id = "lua_q_7",
                question = "Lua'da 'nesne:fonksiyon()' çağrısı yapıldığında fonksiyonun ilk gizli parametresine ne ad verilir?",
                options = listOf("self", "this", "me", "parent"),
                correctIndex = 0,
                explanation = "İki nokta sözdizimi ilk parametreye otomatik olarak 'self' adını verir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_lua_7",
                lessonId = "lua_7",
                title = "Sayaç Artırıcı Metot",
                instructions = "self.sayac değerini 1 artıran Sayac:artir() metodunu yazın.",
                exampleInput = "local s = { sayac = 0 }; setmetatable(s, Sayac); s:artir();",
                exampleOutput = "s.sayac = 1",
                starterCode = "local Sayac = {}\nSayac.__index = Sayac\n\nfunction Sayac:artir()\n    -- Kodunu yaz:\nend",
                solutionCode = "local Sayac = {}\nSayac.__index = Sayac\n\nfunction Sayac:artir()\n    self.sayac = self.sayac + 1\nend",
                hints = listOf("self.sayac = self.sayac + 1 yazın."),
                testCases = listOf(
                    TestCase("local s = {sayac=0}; setmetatable(s, Sayac); s:artir(); s.sayac", "1", "Sayaç artırma")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "lua_quiz_7_1",
                    lessonId = "lua_7",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "nesne.metot(nesne) yazmak ile nesne:metot() yazmak arasında nasıl bir fark vardır?",
                    options = listOf("Hiçbir fark yoktur; iki nokta (:) sadece 'self' parametresini otomatik aktaran kullanışlı bir kısayoldur (Syntactic Sugar)", "İki nokta daha yavaştır", "Nokta hata verir", "Farklı dillere aittir"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! İki nokta sözdizimsel bir şekerdir (Syntactic sugar).",
                    explanationWrong = "İki nokta otomatik self aktarımı sağlar.",
                    reviewTopic = "Lua İki Nokta Sözdizimi"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Nokta ile iki noktayı karıştırırsam ne olur?",
                    answer = "nesne.metot() yazarsanız self parametresi nil kalır ve kod 'attempt to index local self' hatası verir."
                )
            ),
            completionCriteria = listOf(
                ": ve . farkını kavramak",
                "self ile metot yazabilmek"
            )
        ),

        // ==========================================
        // DERS 8: KAPANISLAR (CLOSURES)
        // ==========================================
        Lesson(
            id = "lua_8",
            courseId = "lua",
            sectionId = "lua_sec_4",
            title = "Kapanışlar (Closures) ile Durum Saklama",
            shortDesc = "Global değişken kullanmadan fonksiyonun kendi özel hafızasını tutması.",
            level = CourseLevel.INTERMEDIATE,
            order = 8,
            isPremium = true,
            learningObjectives = listOf(
                "İç içe fonksiyonlar ve Lexical Scoping mantığını öğrenmek",
                "Closure ile dışarıdan müdahale edilemeyen gizli sayaçlar yapmak"
            ),
            prerequisites = listOf("Fonksiyonlar"),
            subtopics = listOf("Closure Nedir?", "Gizli Değişkenler (Encapsulation)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Kendi Hafızası Olan Fonksiyon",
                    body = "Bir fonksiyonun içinde tanımlanan değişken, o fonksiyonun döndürdüğü iç fonksiyon tarafından hatırlanmaya devam eder.",
                    codeSnippet = "function sayac_yap()\n    local sayi = 0\n    return function()\n        sayi = sayi + 1\n        return sayi\n    end\nend\n\nlocal say = sayac_yap()\nprint(say()) -- 1\nprint(say()) -- 2"
                )
            ),
            codeExample = "local s1 = sayac_yap()\nlocal s2 = sayac_yap()\nprint(s1(), s2()) -- 1, 1 (İkisi birbirinden bağımsız hafızaya sahiptir)",
            codeExplanation = "Her closure kendi bağımsız sayi değişkenini hafızasında sakladı.",
            realWorldExample = "Oyun içi benzersiz ID üreteçleri Closure ile yapılır.",
            practicalTask = "Basit bir sayaç üreten closure fonksiyonunu inceleyin.",
            starterPlaygroundCode = "function sayac() local n=0 return function() n=n+1 return n end end",
            miniQuestion = MiniQuestion(
                id = "lua_q_8",
                question = "Bir iç fonksiyonun, kendisini çevreleyen dış fonksiyonun yerel değişkenlerini hatırlayıp kullanabilmesine ne ad verilir?",
                options = listOf("Closure (Kapanış)", "Pointer", "Recursion", "Overload"),
                correctIndex = 0,
                explanation = "Dış değişkenleri hatırlama özelliğine 'Closure' denir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_lua_8",
                lessonId = "lua_8",
                title = "Özel Sayaç Üretici",
                instructions = "Her çağrıldığında 1 artıran anonim fonksiyon döndüren sayac_olustur() fonksiyonunu yazın.",
                exampleInput = "local f = sayac_olustur(); f()",
                exampleOutput = "1",
                starterCode = "function sayac_olustur()\n    -- Kodunu yaz:\n    return function() return 0 end\nend",
                solutionCode = "function sayac_olustur()\n    local n = 0\n    return function()\n        n = n + 1\n        return n\n    end\nend",
                hints = listOf("local n = 0 return function() n = n + 1 return n end yazın."),
                testCases = listOf(
                    TestCase("local f = sayac_olustur(); f()", "1", "İlk tık"),
                    TestCase("local f = sayac_olustur(); f(); f()", "2", "İkinci tık")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "lua_quiz_8_1",
                    lessonId = "lua_8",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Lua'da closure tarafından yakalanıp saklanan dış değişkenlere ne ad verilir?",
                    options = listOf("Upvalue", "Global", "Macro", "Constant"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Lua iç terminolojisinde bunlara 'Upvalue' denir.",
                    explanationWrong = "Upvalue adı verilir.",
                    reviewTopic = "Lua Closures"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Closure bellek harcar mı?",
                    answer = "Evet, fonksiyon yaşadığı sürece kapattığı değişkenler RAM'de tutulur."
                )
            ),
            completionCriteria = listOf(
                "Closure mantığını kavramak",
                "Fonksiyon döndüren fonksiyonlar yazabilmek"
            )
        ),

        // ==========================================
        // DERS 9: COROUTINES (YIELD VE RESUME)
        // ==========================================
        Lesson(
            id = "lua_9",
            courseId = "lua",
            sectionId = "lua_sec_4",
            title = "Eşyordamlar (Coroutines): yield ve resume",
            shortDesc = "Fonksiyonu istediğiniz yerde dondurma (yield) ve sonra kaldığı yerden devam ettirme (resume).",
            level = CourseLevel.ADVANCED,
            order = 9,
            isPremium = true,
            learningObjectives = listOf(
                "coroutine.create ile eşyordam oluşturmak",
                "coroutine.yield ile çalışmayı askıya almak",
                "coroutine.resume ile kaldığı yerden devam ettirmek"
            ),
            prerequisites = listOf("Fonksiyonlar ve Closures"),
            subtopics = listOf("coroutine.create", "coroutine.yield()", "coroutine.resume()"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Oyunu Dondurmadan Beklemek",
                    body = "Normal bir fonksiyona `bekle(5)` derseniz tüm oyun donar. `coroutine` ise sadece o fonksiyonu uyutur (`yield`), oyun akmaya devam eder, süresi dolunca kaldığı yerden devam ettirilir (`resume`)!",
                    codeSnippet = "local gorev = coroutine.create(function()\n    print(\"1. Aşama başladı!\")\n    coroutine.yield() -- BURADA DURAKLAR\n    print(\"2. Aşama devam ediyor!\")\nend)\n\ncoroutine.resume(gorev) -- \"1. Aşama başladı!\"\nprint(\"Oyun akıyor...\")\ncoroutine.resume(gorev) -- \"2. Aşama devam ediyor!\""
                )
            ),
            codeExample = "local co = coroutine.create(function() coroutine.yield(42) end)\nlocal _, deger = coroutine.resume(co)\nprint(\"Yield edilen: \" .. deger) -- 42",
            codeExplanation = "coroutine duraklarken dışarıya 42 değerini aktardı.",
            realWorldExample = "Roblox'ta 'task.wait(2)' komutu arkasında coroutine.yield çalıştırarak karakteri 2 saniye bekletir.",
            practicalTask = "coroutine yield ve resume akışını inceleyin.",
            starterPlaygroundCode = "local co = coroutine.create(function() print(\"A\") coroutine.yield() print(\"B\") end)",
            miniQuestion = MiniQuestion(
                id = "lua_q_9",
                question = "Çalışmakta olan bir Lua coroutine'ini duraklatıp kontrolü ana programa devretmek için hangi fonksiyon çağrılır?",
                options = listOf("coroutine.yield()", "coroutine.pause()", "coroutine.stop()", "coroutine.sleep()"),
                correctIndex = 0,
                explanation = "Duraklatmak için 'coroutine.yield()' çağrılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_lua_9",
                lessonId = "lua_9",
                title = "İlk Adım Coroutine",
                instructions = "Çalıştırıldığında coroutine.resume(co) yapıp true döndüren baslat(co) fonksiyonunu yazın.",
                exampleInput = "baslat(co)",
                exampleOutput = "true",
                starterCode = "function baslat(co)\n    -- Kodunu yaz:\n    return false\nend",
                solutionCode = "function baslat(co)\n    local ok = coroutine.resume(co)\n    return ok\nend",
                hints = listOf("local ok = coroutine.resume(co) return ok yazın."),
                testCases = listOf(
                    TestCase("baslat(coroutine.create(function() end))", "true", "Coroutine başlatma")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "lua_quiz_9_1",
                    lessonId = "lua_9",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir coroutine'in o anki durumunu (running, suspended, dead) öğrenmek için ne kullanılır?",
                    options = listOf("coroutine.status(co)", "coroutine.state(co)", "coroutine.isAlive()", "co.status"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Durum kontrolü coroutine.status() ile yapılır.",
                    explanationWrong = "coroutine.status() kullanılır.",
                    reviewTopic = "Lua Coroutines"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Coroutine ile Thread farkı nedir?",
                    answer = "Coroutine'ler işbirlikçidir (Cooperative); CPU aynı anda birden fazla çalıştırmaz, sadece siz yield dediğinizde sırayı devreder."
                )
            ),
            completionCriteria = listOf(
                "coroutine.create, yield ve resume mantığını kavramak",
                "Oyunlarda bekleme mekanizmasını anlamak"
            )
        ),

        // ==========================================
        // DERS 10: METİN İŞLEME (PATTERN MATCHING)
        // ==========================================
        Lesson(
            id = "lua_10",
            courseId = "lua",
            sectionId = "lua_sec_5",
            title = "Metin İşleme ve Desen Eşleme: string.match",
            shortDesc = "Metin içinden e-posta, sayı (%d) veya kelime (%a) ayıklama sanatı.",
            level = CourseLevel.ADVANCED,
            order = 10,
            isPremium = true,
            learningObjectives = listOf(
                "string.find, string.match ve string.gsub kullanmak",
                "Lua desenlerini (%d: sayı, %a: harf, %s: boşluk) öğrenmek"
            ),
            prerequisites = listOf("Metinler ve Fonksiyonlar"),
            subtopics = listOf("string.match", "Desen Belirteçleri (%d, %a)", "string.gsub Değiştirme"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Regex Yerine Lua Desenleri",
                    body = "Lua çok hafif olduğu için ağır Regex kütüphanesini içermez; kendi süper hızlı `%` desenlerini sunar:\n\n• `%d`: Sayı rakamları (0-9)\n• `%a`: Harfler\n• `%s`: Boşluk karakteri\n• `+`: Bir veya daha fazla tekrar"
                ),
                LessonContentBlock(
                    subtitle = "2. Örnek Kullanım",
                    body = "Metnin içinden sadece sayıları çekelim:",
                    codeSnippet = "local yazi = \"Sipariş No: 48152\"\nlocal numara = string.match(yazi, \"%d+\")\nprint(\"Ayıklanan No: \" .. numara) -- 48152"
                )
            ),
            codeExample = "local yeni = string.gsub(\"Elma Elma\", \"Elma\", \"Armut\")\nprint(yeni) -- Armut Armut",
            codeExplanation = "string.gsub ile metin bul-değiştir işlemi yapıldı.",
            realWorldExample = "Sohbet filtrelerinde küfür veya linkleri engellemek için string.match kullanılır.",
            practicalTask = "string.match ile bir metinden sayı ayıklayın.",
            starterPlaygroundCode = "local no = string.match(\"Fiyat: 150 TL\", \"%d+\")",
            miniQuestion = MiniQuestion(
                id = "lua_q_10",
                question = "Lua desenlerinde (Patterns) sayısal rakamları (0-9) temsil eden desen belirteci hangisidir?",
                options = listOf("%d", "%s", "%a", "%w"),
                correctIndex = 0,
                explanation = "Rakamlar için '%d' (digit) kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_lua_10",
                lessonId = "lua_10",
                title = "Sayı Ayıklayıcı",
                instructions = "Gelen metinden string.match(metin, '%d+') ile ilk sayıyı ayıklayıp döndüren sayi_ayikla(metin) fonksiyonunu yazın.",
                exampleInput = "sayi_ayikla(\"Skor: 99\")",
                exampleOutput = "\"99\"",
                starterCode = "function sayi_ayikla(metin)\n    -- Kodunu yaz:\n    return \"\"\nend",
                solutionCode = "function sayi_ayikla(metin)\n    return string.match(metin, \"%d+\")\nend",
                hints = listOf("return string.match(metin, \"%d+\") yazın."),
                testCases = listOf(
                    TestCase("sayi_ayikla(\"Skor: 99\")", "99", "Sayı ayıklama")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "lua_quiz_10_1",
                    lessonId = "lua_10",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "string.gsub fonksiyonunun sonundaki 'sub' kelimesi ne anlama gelir?",
                    options = listOf("Substitute (Yerine koyma / Değiştirme)", "Substring", "Subtract", "Subscribe"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Global Substitution (Bul ve Değiştir) anlamına gelir.",
                    explanationWrong = "Substitute (Değiştirme) anlamına gelir.",
                    reviewTopic = "Lua Metin İşleme"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Büyük harfle yazılan (%D) ne anlama gelir?",
                    answer = "Tersini ifade eder; %D 'sayı olmayan tüm karakterler' demektir."
                )
            ),
            completionCriteria = listOf(
                "string.match ve string.gsub kullanımını bilmek",
                "%d ve %a desenlerini kavramak"
            )
        ),

        // ==========================================
        // DERS 11: MODÜLLER VE REQUIRE()
        // ==========================================
        Lesson(
            id = "lua_11",
            courseId = "lua",
            sectionId = "lua_sec_5",
            title = "Modüller ve require() ile Temiz Mimari",
            shortDesc = "Büyük projeleri küçük dosyalara bölme ve require(\"modul\") ile içeri aktarma.",
            level = CourseLevel.ADVANCED,
            order = 11,
            isPremium = true,
            learningObjectives = listOf(
                "Modül tablosu oluşturup 'return modul' ile dışa aktarmak",
                "require() ile diğer dosyalardan fonksiyonları çağırmak",
                "Temiz ve modüler oyun mimarisi kurmak"
            ),
            prerequisites = listOf("Tablolar ve Fonksiyonlar"),
            subtopics = listOf("Modül Yazma", "require() Kullanımı", "Modül Önbelleği (Cache)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Modül Yazmak Çok Kolaydır",
                    body = "Lua'da modül, fonksiyonlar içeren sıradan bir tablodur ve dosyanın sonunda `return` edilir.",
                    codeSnippet = "-- matematik.lua dosyası:\nlocal M = {}\n\nfunction M.topla(a, b) return a + b end\nfunction M.carp(a, b) return a * b end\n\nreturn M\n\n-- main.lua dosyası:\nlocal mat = require(\"matematik\")\nprint(mat.topla(10, 5)) -- 15"
                )
            ),
            codeExample = "local mat = require(\"matematik\")\nprint(mat.carp(3, 4)) -- 12",
            codeExplanation = "require ile modül yüklendi ve fonksiyonları kullanıldı.",
            realWorldExample = "Roblox projelerinde 'ModuleScript' nesneleri bu standart require mantığıyla çalışır.",
            practicalTask = "Modül yapısını ve return M kalıbını inceleyin.",
            starterPlaygroundCode = "local M = {}; function M.selam() return \"Selam\" end; return M",
            miniQuestion = MiniQuestion(
                id = "lua_q_11",
                question = "Lua'da başka bir dosyada yazılmış modülü projeye dahil edip yüklemek için hangi standart fonksiyon kullanılır?",
                options = listOf("require()", "import()", "include()", "load()"),
                correctIndex = 0,
                explanation = "Modül yüklemek için 'require()' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_lua_11",
                lessonId = "lua_11",
                title = "Basit Modül Tablosu",
                instructions = "versiyon = \"1.0\" alanına sahip bir tablo oluşturup döndüren modül_uret() fonksiyonunu yazın.",
                exampleInput = "modül_uret().versiyon",
                exampleOutput = "\"1.0\"",
                starterCode = "function modül_uret()\n    -- Kodunu yaz:\n    return {}\nend",
                solutionCode = "function modül_uret()\n    local M = { versiyon = \"1.0\" }\n    return M\nend",
                hints = listOf("local M = { versiyon = \"1.0\" } return M yazın."),
                testCases = listOf(
                    TestCase("modül_uret().versiyon", "1.0", "Modül versiyonu")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "lua_quiz_11_1",
                    lessonId = "lua_11",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Aynı modülü birden fazla kez require() ettiğinizde Lua ne yapar?",
                    options = listOf("İlk seferde önbelleğe (package.loaded) alır ve sonraki çağrılarda aynı nesneyi anında döndürür", "Her seferinde dosyayı baştan okur", "Hata verir", "Modülü siler"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Lua modülleri önbelleğe alarak performansı korur.",
                    explanationWrong = "Önbellekten döndürür.",
                    reviewTopic = "Lua Modüller"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "package.path nedir?",
                    answer = "require() komutunun modül dosyalarını arayacağı klasör dizinlerinin listesidir."
                )
            ),
            completionCriteria = listOf(
                "Modül oluşturup return edebilmek",
                "require() ile modülleri kullanabilmek"
            )
        ),

        // ==========================================
        // DERS 12: ROBLOX VE LUA USTALIĞI
        // ==========================================
        Lesson(
            id = "lua_12",
            courseId = "lua",
            sectionId = "lua_sec_6",
            title = "Lua Ustalığı: Roblox, Oyun Geliştirme ve Gelecek",
            shortDesc = "Roblox Studio, World of Warcraft, Neovim ve milyonlarca oyuncuya ulaşan Lua gücü.",
            level = CourseLevel.EXPERT,
            order = 12,
            isPremium = true,
            learningObjectives = listOf(
                "Roblox Studio mimarisine (ServerScript, LocalScript, ModuleScript) tam hakim olmak",
                "Lua'nın C/C++ motorlarına nasıl gömüldüğünü (Embedded) kavramak",
                "Tebrikler: Artık oyunlar dünyasının aranan bir Lua geliştiricisisiniz!"
            ),
            prerequisites = listOf("Tüm Lua Konuları"),
            subtopics = listOf("Roblox Script Türleri", "C API ve Gömülü Sistemler", "Tebrikler ve Tavsiyeler"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Tebrikler! Lua Yolculuğunu Başarıyla Tamamladınız! 🌙🎮",
                    body = "Artık tablolardan metatable OOP sistemine, Coroutine akışlarından Roblox modül mimarisine kadar Lua'nın tüm kalbine hakimsiniz.\n\nRoblox'ta milyonlarca kişinin oynayacağı oyunlar üretebilir, oyun motorlarına scriptler yazabilir veya hafif sistem araçları geliştirebilirsiniz!"
                )
            ),
            codeExample = "-- Lua Ustası Oldunuz!\nprint(\"Lua Seviyeniz: USTA! 🚀✨\")",
            codeExplanation = "Lua yolculuğunuz başarıyla tamamlandı.",
            realWorldExample = "Roblox'taki Adopt Me, Blox Fruits gibi milyar dolarlık oyunlar Lua ile programlanmıştır.",
            practicalTask = "Lua başarınızı kutlayın!",
            starterPlaygroundCode = "-- Harika bir Lua geliştiricisisiniz!",
            miniQuestion = MiniQuestion(
                id = "lua_q_12",
                question = "Roblox oyunlarında sunucu (Server) tarafında çalışan ana script türü hangisidir?",
                options = listOf("Script (Server Script)", "LocalScript", "ClientScript", "HtmlScript"),
                correctIndex = 0,
                explanation = "Sunucu tarafında standart 'Script' (Server Script) çalışır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_lua_12",
                lessonId = "lua_12",
                title = "Şampiyon Lua Mesajı",
                instructions = "Üstünde 'Lua Şampiyonu' yazan string döndüren sampiyon() fonksiyonunu yazın.",
                exampleInput = "sampiyon()",
                exampleOutput = "\"Lua Şampiyonu\"",
                starterCode = "function sampiyon()\n    -- Kodunu yaz:\n    return \"\"\nend",
                solutionCode = "function sampiyon()\n    return \"Lua Şampiyonu\"\nend",
                hints = listOf("return \"Lua Şampiyonu\" yazın."),
                testCases = listOf(
                    TestCase("sampiyon()", "Lua Şampiyonu", "Şampiyonluk testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "lua_quiz_12_1",
                    lessonId = "lua_12",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Lua dilinin dünya genelinde en çok tercih edilmesinin 1 numaralı sebebi nedir?",
                    options = listOf("C/C++ oyun ve grafik motorlarına entegre edilmesinin olağanüstü kolay ve hafif olması", "Büyük boyutu", "Yavaş olması", "Sadece web için olması"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Lua gömülebilirlik (Embeddability) alanında dünyanın lider dilidir.",
                    explanationWrong = "C/C++ motorlarına gömülmesinin çok kolay olmasıdır.",
                    reviewTopic = "Lua Felsefesi"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Bundan sonra ne yapmalıyım?",
                    answer = "Roblox Studio'yu indirip ilk 3D mini oyununuzu kodlamaya hemen başlayabilirsiniz!"
                )
            ),
            completionCriteria = listOf(
                "Lua felsefesini kavramak",
                "Roblox ve oyun scriptleri yazmaya hazır olmak"
            )
        )
    )
}
