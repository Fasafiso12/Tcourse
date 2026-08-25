package com.example.data.catalog

import com.example.model.*

/**
 * Lua Dili Kapsamlı Resmi Müfredatı (12 Sıralı Ders):
 * BEGINNER -> FUNDAMENTAL -> INTERMEDIATE -> ADVANCED -> EXPERT
 * Temel sözdizimi, tablolardan metatable OOP sistemine, Coroutines, Lua C API ve Roblox/Oyun Motoru mimarisine.
 */
object LuaCurriculum {

    fun getSections(): List<CourseSection> = listOf(
        CourseSection(
            id = "lua_sec_1",
            courseId = "lua",
            title = "Seviye 1 – Lua Temelleri, print() & Kontrol Akışı",
            level = CourseLevel.BEGINNER,
            order = 1,
            description = "Lua yorumlayıcı yapısı, print, dinamik tipler (nil, number, string, boolean), if-then-else, while, repeat-until ve sayısal for.",
            learningObjectives = listOf("Lua çalışma mantığı ve dinamik tipler", "print() ve string birleştirme (..)", "if-then-else koşullu ifadeleri", "while, repeat-until ve sayısal for döngüleri"),
            prerequisites = listOf("Temel bilgisayar bilgisi")
        ),
        CourseSection(
            id = "lua_sec_2",
            courseId = "lua",
            title = "Seviye 2 – Fonksiyonlar & Tablolar (Tables Mimarisi)",
            level = CourseLevel.BEGINNER,
            order = 2,
            description = "Fonksiyonlar, birden fazla değer döndürme (Multiple Returns), Değişken argümanlar (...), Tabloların dizi ve sözlük olarak kullanımı.",
            learningObjectives = listOf("Birinci sınıf (First-Class) fonksiyonlar", "Çoklu değer döndürme mekanizması", "Lua tablolarının (Tables) mimarisi", "ipairs ve pairs ile tablo döngüleri"),
            prerequisites = listOf("Lua Temelleri ve Kontrol Akışı")
        ),
        CourseSection(
            id = "lua_sec_3",
            courseId = "lua",
            title = "Seviye 3 – Metatables & Nesne Yönelimli Programlama (OOP)",
            level = CourseLevel.INTERMEDIATE,
            order = 3,
            description = "Metatables, Metamethods (__index, __newindex, __tostring, __add), Prototip tabanlı OOP, Sınıf tanımlama ve self/noktalı virgül (:) sözdizimi.",
            learningObjectives = listOf("setmetatable ve getmetatable kullanımı", "__index ile fallback ve kalıtım zinciri", "Lua'da Sınıf (Class) ve Nesne üretimi", "İki nokta (:) ile self gizli parametresi"),
            prerequisites = listOf("Tablolar ve Fonksiyonlar")
        ),
        CourseSection(
            id = "lua_sec_4",
            courseId = "lua",
            title = "Seviye 4 – Kapanışlar (Closures) & Eşyordamlar (Coroutines)",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            description = "Lexical Scoping, Closure kalıpları, State saklama, Coroutines (coroutine.create, resume, yield, status) ve İşbirlikçi Çoklu Görev (Cooperative Multitasking).",
            learningObjectives = listOf("Closure ile özel durum (state) saklama", "coroutine.yield ile akışı duraklatma", "coroutine.resume ile veri alışverişi", "Asenkron oyun akışları ve zamanlayıcılar"),
            prerequisites = listOf("Metatables ve OOP")
        ),
        CourseSection(
            id = "lua_sec_5",
            courseId = "lua",
            title = "Seviye 5 – Desen Eşleme (Pattern Matching) & Modüler Mimari",
            level = CourseLevel.ADVANCED,
            order = 5,
            description = "string.match, string.gmatch, string.gsub, Lua Desen (Pattern) kuralları (%d, %a, %s, %b), Modüller, paketleme ve require() sistemi.",
            learningObjectives = listOf("Regex benzeri Lua Pattern Matching sözdizimi", "Metin ayrıştırma ve yakalama grupları ()", "Modül tanımlama ve require() ile yükleme", "Global vs Local kapsam hijyeni"),
            prerequisites = listOf("Coroutines ve Tablo Mimarisi")
        ),
        CourseSection(
            id = "lua_sec_6",
            courseId = "lua",
            title = "Seviye 6 – Lua C API, Roblox & Oyun Motoru Mimarisi",
            level = CourseLevel.EXPERT,
            order = 6,
            description = "Lua C Stack Mimarisi (lua_State, lua_push, lua_call), C fonksiyonlarını Lua'ya bağlama, Entity-Component System (ECS) ve Roblox Game State Machine.",
            learningObjectives = listOf("Lua C API sanal yığınını (Virtual Stack) yönetmek", "C ve Lua arasında veri köprüsü kurmak", "Oyun motorlarında script entegrasyonu", "Entity Component System (ECS) mimarisi"),
            prerequisites = listOf("İleri Lua Modülleri ve Pattern Matching")
        )
    )

    fun getLessons(): List<Lesson> = listOf(
        // ==========================================
        // DERS 1: TEMEL SÖZDİZİMİ & DİNAMİK TİPLER (ÜCRETSİZ)
        // ==========================================
        Lesson(
            id = "lua_1",
            courseId = "lua",
            sectionId = "lua_sec_1",
            title = "Lua'ya Giriş, print() & Dinamik Tipler",
            shortDesc = "Lua'nın hafif mimarisi, print fonksiyonu, dinamik veri tipleri (nil, boolean, number, string), local değişkenler ve string birleştirme (..).",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false,
            learningObjectives = listOf(
                "Lua'nın dinamik tür sistemini (nil, number, string, boolean) anlamak",
                "local anahtar kelimesiyle güvenli ve hızlı değişkenler tanımlamak",
                "String birleştirme (..) operatörünü ve type() fonksiyonunu kullanmak"
            ),
            prerequisites = listOf("Ön koşul gerekmez. Sıfırdan başlar."),
            subtopics = listOf("Lua Register-Based VM", "local vs global ve _ENV", "Dinamik Tip Sistemi (8 Temel Tip)", "String Interning & Bellek", "type() ve tostring() Fonksiyonları"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Lua'nın Mimarisi ve Register-Based Sanal Makinesi",
                    body = "Lua, C diliyle yazılmış olağanüstü hafif (~200-300 KB) ve hızlı bir script dilidir. Çoğu sanal makinenin aksine (JVM, Python stack-based iken), Lua VM register-based (yazmaç tabanlı) bir mimariye sahiptir. Bu sayede daha az CPU komutuyla çok yüksek bytecode yürütme hızına ulaşır.\n\nLua'da 8 temel veri tipi bulunur:\n1. `nil`: Değersizlik / yokluk durumu\n2. `boolean`: true / false\n3. `number`: IEEE 754 Çift duyarlıklı float veya 64-bit integer\n4. `string`: Değiştirilemez (immutable) ve bellekte tekilleştirilmiş (interned) karakter dizileri\n5. `table`: Dizi, hashmap ve nesne temsil eden tek bileşik yapı\n6. `function`: Birinci sınıf vatandaş (first-class closure)\n7. `userdata`: C veri yapılarını sarmalayan ham bellek bloğu\n8. `thread`: Eşyordamlar (Coroutines)",
                    codeSnippet = "-- local anahtar kelimesi değişkeni doğrudan VM register'ına atar (En hızlı erişim):\nlocal isim = \"Lua\"\nlocal versiyon = 5.4\nlocal aktif = true\n\nprint(\"Dil: \" .. isim .. \" v\" .. tostring(versiyon))\nprint(\"Tip: \" .. type(versiyon)) -- number",
                    tip = "Global değişkenler `_G` tablosu üzerinde hash araması gerektirir. Daima `local` değişken kullanın; local değişkenler CPU register eşdeğeri slotlarda saklanır ve 30-50% daha hızlıdır."
                ),
                LessonContentBlock(
                    subtitle = "2. Lua'da Doğruluk Mantığı (Truthy / Falsy Kuralları)",
                    body = "Lua'da mantıksal olarak YANLIŞ sayılan yalnızca iki değer vardır:\n• `nil`\n• `false`\n\nDiğer tüm dillerin aksine sayı `0` ve boş metin `\"\"` Lua'da KESİNLİKLE DOĞRU (true) kabul edilir! Bu durum diğer dillerden gelenler için sık yapılan bir hata kaynağıdır.",
                    codeSnippet = "local sayi = 0\nif sayi then\n    print(\"0 degeri Lua'da TRUE kabul edilir!\")\nend"
                ),
                LessonContentBlock(
                    subtitle = "3. String Interning ve Bellek Verimliliği",
                    body = "Lua sanal makinesinde tüm stringler global bir hash tablosunda tekilleştirilir (String Interning). Aynı metne sahip iki string bellekte tek bir adreste tutulur; bu sayede string karşılaştırmaları (`str1 == str2`) O(1) hızında pointer karşılaştırmasıyla gerçekleşir.",
                    tip = "Stringleri birleştirmek için '+' matematiksel toplama yapar (ör: \"5\" + 2 -> 7). Metin birleştirmek için mutlaka '..' operatörü kullanılmalıdır."
                )
            ),
            codeExample = "local oyuncuAdi = \"Kahraman\"\nlocal seviye = 12\nlocal altin = 1500.5\n\nprint(\"Oyuncu: \" .. oyuncuAdi)\nprint(\"Seviye: \" .. seviye)\nprint(\"Altin: \" .. altin)",
            codeExplanation = "local değişkenler tanımlanır ve '..' operatörü ile metinler birleştirilerek ekrana yazdırılır.",
            realWorldExample = "Roblox, World of Warcraft, Angry Birds ve Redis, gömülü mantıkları çalıştırmak için ana script dili olarak Lua kullanır.",
            practicalTask = "Adınızı ve yaşınızı iki local değişkende tutup ekrana formatlı yazdıran bir Lua kodu yazın.",
            starterPlaygroundCode = "local baslik = \"Kod Akademi Lua\"\nlocal dersSayisi = 12\nprint(baslik .. \" - Toplam Ders: \" .. dersSayisi)",
            miniQuestion = MiniQuestion(
                id = "lua_q_1",
                question = "Lua dilinde stringleri birbirine bağlamak (concatenate) için hangi operatör kullanılır?",
                options = listOf("..", "+", "&", "$"),
                correctIndex = 0,
                explanation = "Lua'da string birleştirme iki nokta (..) operatörü ile yapılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_lua_1",
                lessonId = "lua_1",
                title = "İki Sayıyı Toplama",
                instructions = "Verilen a ve b sayılarını toplayıp döndüren topla(a, b) fonksiyonunu yazın.",
                exampleInput = "a = 20, b = 30",
                exampleOutput = "50",
                starterCode = "function topla(a, b)\n    -- Kodunu buraya yaz:\n    return 0\nend",
                solutionCode = "function topla(a, b)\n    return a + b\nend",
                hints = listOf("return a + b yazarak sonucu döndürün."),
                testCases = listOf(
                    TestCase("topla(20, 30)", "50", "Temel toplama")
                )
            )
        ),

        // ==========================================
        // DERS 2: KONTROL AKIŞI & DÖNGÜLER (ÜCRETSİZ)
        // ==========================================
        Lesson(
            id = "lua_2",
            courseId = "lua",
            sectionId = "lua_sec_1",
            title = "Kontrol Akışı: if-then-else, while, repeat-until & for",
            shortDesc = "Koşul blokları (if then elseif else end), while döngüsü, repeat-until yapısı, Sayısal for (Numeric for) ve break anahtarı.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false,
            learningObjectives = listOf(
                "if ... then ... elseif ... else ... end sözdizimini hatasız kullanmak",
                "Sayısal for (for i = start, stop, step do) döngüsü kurmak",
                "repeat ... until döngüsünün koşul mantığını öğrenmek"
            ),
            prerequisites = listOf("Lua'ya Giriş & Tipler"),
            subtopics = listOf("if-then-else ve end Blokları", "Mantıksal Operatörler (and, or, not) İle Kısa Devre", "Sayısal for ve JIT Optimizasyonu", "while do ... end", "repeat ... until Döngü Mantığı"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Koşul Yapısı ve Blok Kapatma",
                    body = "Lua'da bloklar süslü parantez `{}` yerine `end` anahtar kelimesiyle kapatılır. `if ... then ... elseif ... else ... end` yapısı kullanılır (`elseif` bitişik yazılır).",
                    codeSnippet = "local can = 75\n\nif can > 80 then\n    print(\"Durum: Mukemmel\")\nelseif can > 40 then\n    print(\"Durum: Normal\")\nelse\n    print(\"Durum: Kritik!\")\nend"
                ),
                LessonContentBlock(
                    subtitle = "2. and / or İle Kısa Devre ve Ternary Operatör Simülasyonu",
                    body = "Lua'da C/Java benzeri `? :` üçlü operatörü yoktur. Bunun yerine `a and b or c` deyimi kullanılır. `a` true ise `b` döner, false ise `c` döner.\n\n`local deger = girdi or \"varsayilan\"` kalıbı Lua'da varsayılan parametre atamanın standart yoludur.",
                    codeSnippet = "local kullanici = nil\nlocal isim = kullanici or \"Misafir\"\nprint(\"Hosgeldin: \" .. isim) -- Hosgeldin: Misafir"
                ),
                LessonContentBlock(
                    subtitle = "3. Sayısal for (Numeric for) ve repeat-until",
                    body = "• `for i = start, stop, step do ... end`: `start`, `stop` ve `step` döngüye girmeden önce yalnızca bir kez hesaplanır (önbelleğe alınır).\n• `repeat ... until kosul`: Gövde en az 1 kez çalışır; koşul `true` olana kadar (while'ın tersine) tekrarlar. repeat bloğunda tanımlanan yerel değişkenler `until` koşulunda da görünür!",
                    tip = "repeat-until döngüsünde `until` koşulu, döngü gövdesinde tanımlanan `local` değişkenlere erişebilir."
                )
            ),
            codeExample = "local toplam = 0\nfor i = 1, 5 do\n    toplam = toplam + i\n    print(\"Adim \" .. i .. \" -> Toplam: \" .. toplam)\nend",
            codeExplanation = "for döngüsü 1'den 5'e kadar sayar ve her adımda toplam değişkenini günceller.",
            realWorldExample = "Oyunlarda NPC yapay zekası düşmanın menzilde olup olmadığını her karede if-then kontrolleriyle denetler.",
            practicalTask = "10'dan geriye doğru 1'e kadar sayıp en son \"Ateş!\" yazan bir for döngüsü yazın.",
            starterPlaygroundCode = "for i = 10, 1, -1 do\n    print(\"Geri Sayim: \" .. i)\nend\nprint(\"Ates!\")",
            miniQuestion = MiniQuestion(
                id = "lua_q_2",
                question = "Lua dilinde bir if veya for bloğunu sonlandırmak için hangi anahtar kelime kullanılır?",
                options = listOf("end", "done", "close", "}"),
                correctIndex = 0,
                explanation = "Lua'da if, for, while, function gibi tüm bloklar 'end' ile kapatılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_lua_2",
                lessonId = "lua_2",
                title = "Çift Sayıların Toplamı",
                instructions = "1'den n'e kadar olan sayılar arasındaki çift sayıların toplamını döndüren ciftToplami(n) fonksiyonunu yazın.",
                exampleInput = "n = 6",
                exampleOutput = "12 (2 + 4 + 6)",
                starterCode = "function ciftToplami(n)\n    -- Kodunu buraya yaz:\n    return 0\nend",
                solutionCode = "function ciftToplami(n)\n    local toplam = 0\n    for i = 2, n, 2 do\n        toplam = toplam + i\n    end\n    return toplam\nend",
                hints = listOf("for i = 2, n, 2 do döngüsü kurup toplamı arttırın."),
                testCases = listOf(
                    TestCase("ciftToplami(6)", "12", "Çift toplam testi")
                )
            )
        ),

        // ==========================================
        // DERS 3: FONKSİYONLAR & MULTIPLE RETURNS (ÜCRETSİZ)
        // ==========================================
        Lesson(
            id = "lua_3",
            courseId = "lua",
            sectionId = "lua_sec_2",
            title = "Fonksiyonlar: Çoklu Dönüş Değerleri & Varargs (...)",
            shortDesc = "Fonksiyon tanımlama, Birinci sınıf vatandaşlık (First-Class Functions), Birden fazla değer döndürme (Multiple Returns) ve Değişken sayıda argüman (...).",
            level = CourseLevel.BEGINNER,
            order = 3,
            isPremium = false,
            learningObjectives = listOf(
                "Lua fonksiyonlarının birden fazla değeri virgülle döndürebilme yeteneğini kavramak",
                "Çoklu atama (Multiple Assignment) ile dönen değerleri yakalamak",
                "Değişken sayıda argüman alan (... varargs) fonksiyonlar yazmak"
            ),
            prerequisites = listOf("Kontrol Akışı ve Döngüler"),
            subtopics = listOf("Fonksiyon Tanımlama", "Çoklu Dönüş (return a, b)", "Çoklu Atama (x, y = fn())", "Varargs (...) ve select()", "Upvalues ve Closures (Kapanışlar)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Çoklu Dönüş Değerleri ve Çoklu Atama",
                    body = "Lua'da bir fonksiyon tek seferde birden fazla değeri `return x, y, z` şeklinde dönebilir. Dönen değerler `local a, b = fn()` şeklinde doğrudan yakalanır. Eğer fonksiyon çağrısı başka bir fonksiyonun son argümanı ise tüm değerler iletilir.",
                    codeSnippet = "local function minMax(a, b)\n    if a < b then\n        return a, b\n    else\n        return b, a\n    end\nend\n\nlocal enKucuk, enBuyuk = minMax(45, 12)\nprint(\"Min: \" .. enKucuk .. \", Max: \" .. enBuyuk)"
                ),
                LessonContentBlock(
                    subtitle = "2. Varargs (...) ve select() Fonksiyonu",
                    body = "Değişken sayıda parametre almak için `...` (üç nokta) kullanılır. `select('#', ...)` gelen parametre sayısını verir; `select(i, ...)` i'nci parametreden sonrasını döndürür. `{...}` ifadesi parametreleri anında bir Lua tablosuna dönüştürür.",
                    codeSnippet = "local function logla(etiket, ...)\n    print(\"[\" .. etiket .. \"] Toplam Parametre: \" .. select('#', ...))\nend\nlogla(\"DEBUG\", 1, 2, \"test\")"
                ),
                LessonContentBlock(
                    subtitle = "3. Birinci Sınıf Fonksiyonlar, Kapanışlar (Closures) ve Upvalue",
                    body = "Lua'da fonksiyonlar birinci sınıf değerlerdir. Bir fonksiyon başka bir fonksiyon içinde tanımlandığında, dış fonksiyondaki yerel değişkenleri saklar (Upvalue) ve fonksiyon sonlansa bile erişmeye devam eder (Lexical Scoping).",
                    tip = "Upvalue'lar Lua'da veri gizleme (private field simülasyonu) ve durum koruyan sayaçlar için en yaygın tekniktir."
                )
            ),
            codeExample = "local function toplaHepsi(...)\n    local toplam = 0\n    for _, sayi in ipairs({...}) do\n        toplam = toplam + sayi\n    end\n    return toplam\nend\n\nprint(\"Sonuc: \" .. toplaHepsi(10, 20, 30, 40))",
            codeExplanation = "toplaHepsi fonksiyonu sınırsız sayıda parametreyi {...} tablosuna çevirip toplar.",
            realWorldExample = "Oyun içi fizik motorlarında bir nesnenin 2D veya 3D koordinatları `return x, y, z` olarak çoklu döndürülür.",
            practicalTask = "Verilen iki sayının hem toplamını hem de farkını aynı anda döndüren bir Lua fonksiyonu yazın.",
            starterPlaygroundCode = "local function toplaVeCikar(a, b)\n    return a + b, a - b\nend\n\nlocal t, f = toplaVeCikar(20, 8)\nprint(\"Toplam: \" .. t .. \", Fark: \" .. f)",
            miniQuestion = MiniQuestion(
                id = "lua_q_3",
                question = "Lua'da bir fonksiyonun aynı anda birden fazla değer döndürmesi nasıl sağlanır?",
                options = listOf("return deger1, deger2 şeklinde virgülle ayırarak", "Sadece dizi içine sararak", "Pointer parametresi kullanarak", "Tuple tanımlayarak"),
                correctIndex = 0,
                explanation = "Lua yerel olarak return val1, val2 şeklinde çoklu dönüşü destekler."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_lua_3",
                lessonId = "lua_3",
                title = "Kare ve Küp Hesaplayıcı",
                instructions = "Verilen bir sayının karesini ve küpünü aynı anda döndüren kareVeKup(n) fonksiyonunu yazın.",
                exampleInput = "n = 3",
                exampleOutput = "9, 27",
                starterCode = "function kareVeKup(n)\n    -- Kodunu buraya yaz:\n    return 0, 0\nend",
                solutionCode = "function kareVeKup(n)\n    return n * n, n * n * n\nend",
                hints = listOf("return n * n, n * n * n yazın."),
                testCases = listOf(
                    TestCase("kareVeKup(3)", "9, 27", "Çoklu dönüş testi")
                )
            )
        ),

        // ==========================================
        // DERS 4: TABLOLARIN GÜCÜ (TABLES) (PRO)
        // ==========================================
        Lesson(
            id = "lua_4",
            courseId = "lua",
            sectionId = "lua_sec_2",
            title = "Tabloların Gücü: Dizi, Sözlük, pairs & ipairs",
            shortDesc = "Lua'nın tek ve en güçlü veri yapısı olan Tablolar (Tables), 1-tabanlı indeksleme, Dizi vs Key-Value sözlükleri, table kütüphanesi ve döngüler.",
            level = CourseLevel.BEGINNER,
            order = 4,
            isPremium = true,
            learningObjectives = listOf(
                "Lua'da dizilerin indeksinin 1'den başladığını öğrenmek",
                "Tabloları hem dizi (Array) hem sözlük (Dictionary/Hashmap) olarak kullanmak",
                "Sıralı diziler için ipairs, genel tablolar için pairs döngüsünü doğru seçmek"
            ),
            prerequisites = listOf("Fonksiyonlar ve Çoklu Dönüş"),
            subtopics = listOf("Tablo Mimarisi (Array Part vs Hash Part)", "1-Tabanlı İndeksleme Mantığı", "Key-Value Çiftleri", "ipairs vs pairs Performansı", "table.insert / remove / sort"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Tablonun İç Yapısı: Array Part & Hash Part",
                    body = "Lua tabloları C düzeyinde iki bileşenden oluşur:\n• Dizi Bölümü (Array Part): 1'den N'e kadar sıralı tamsayı indeksler için C dizisi hızında O(1) erişim sağlar.\n• Hash Bölümü (Hash Part): String veya diğer anahtarlar için hash tablosu üzerinde çalışır.\n\nBu melez yapı sayesinde tek bir `{}` hem optimize bir dizi hem de esnek bir sözlüktür.",
                    codeSnippet = "local tablo = {\"Birinci\", \"Ikinci\", ad = \"Lua\", puan = 100}\nprint(tablo[1])   -- Dizi bolumunden gelir: Birinci\nprint(tablo.ad)    -- Hash bolumunden gelir: Lua"
                ),
                LessonContentBlock(
                    subtitle = "2. 1-Tabanlı İndeksleme ve # Uzunluk Operatörü",
                    body = "Lua dizileri geleneksel olarak 1'den başlar (`dizi[1]`). `#dizi` operatörü tablodaki ardışık sıralı elemanların uzunluğunu döndürür.\n\nEğer dizide aralara `nil` değerler girerse (delikli dizi / sparse array), `#` operatörünün sonucu tanımsız olabilir!",
                    tip = "Diziyi temizlemek için `for i = #d, 1, -1 do table.remove(d, i) end` geriye doğru döngü kurmak indeks kaymalarını önler."
                ),
                LessonContentBlock(
                    subtitle = "3. İterasyon: ipairs vs pairs",
                    body = "• `ipairs(t)`: Yalnızca t[1], t[2], ... sıralı sayısal indeksleri dolaşır ve ilk `nil` değerde anında durur. (Hızlıdır)\n• `pairs(t)`: Tablodaki tüm anahtarları (string, boolean, sayı) hash sırasına göre dolaşır.",
                    codeSnippet = "for anahtar, deger in pairs(tablo) do\n    print(tostring(anahtar) .. \" => \" .. tostring(deger))\nend"
                )
            ),
            codeExample = "local oyuncu = {\n    isim = \"Gölge Savaşçı\",\n    can = 100,\n    envanter = {\"Kılıç\", \"İksir\", \"Kalkan\"}\n}\n\nprint(\"Oyuncu: \" .. oyuncu.isim)\nprint(\"İlk Eşya: \" .. oyuncu.envanter[1])",
            codeExplanation = "Tablolar iç içe nesneler ve diziler barındırarak karmaşık JSON benzeri ağaçlar oluşturur.",
            realWorldExample = "Roblox oyun dünyasında tüm modeller, envanter verileri ve oyuncu istatistikleri Lua tablolarında saklanır.",
            practicalTask = "Bir meyve fiyat sözlüğü oluşturup pairs ile tüm meyveleri ve fiyatlarını ekrana yazdırın.",
            starterPlaygroundCode = "local fiyatlar = { elma = 15, muz = 30, cilek = 45 }\nfor meyve, fiyat in pairs(fiyatlar) do\n    print(meyve .. \" -> \" .. fiyat .. \" TL\")\nend",
            miniQuestion = MiniQuestion(
                id = "lua_q_4",
                question = "Lua dilinde standart sıralı bir dizinin ilk elemanının indeksi kaçtır?",
                options = listOf("1", "0", "-1", "Herhangi bir sayı olabilir"),
                correctIndex = 0,
                explanation = "Lua dizileri geleneksel olarak 1-tabanlıdır (1-based indexing)."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_lua_4",
                lessonId = "lua_4",
                title = "Tablo Eleman Sayıcı",
                instructions = "Sayı dizisi alan ve içindeki elemanların toplamını döndüren toplaTablo(t) fonksiyonunu yazın.",
                exampleInput = "t = {10, 20, 30}",
                exampleOutput = "60",
                starterCode = "function toplaTablo(t)\n    -- Kodunu buraya yaz:\n    return 0\nend",
                solutionCode = "function toplaTablo(t)\n    local toplam = 0\n    for _, v in ipairs(t) do\n        toplam = toplam + v\n    end\n    return toplam\nend",
                hints = listOf("ipairs(t) döngüsüyle elemanları toplayın."),
                testCases = listOf(
                    TestCase("toplaTablo({10, 20, 30})", "60", "Tablo toplam testi")
                )
            )
        ),

        // ==========================================
        // DERS 5: METATABLES & METAMETHODS (PRO)
        // ==========================================
        Lesson(
            id = "lua_5",
            courseId = "lua",
            sectionId = "lua_sec_3",
            title = "Metatables & Metamethods (__index, __add, __tostring)",
            shortDesc = "Metatable kavramı, setmetatable/getmetatable, operatör aşırı yükleme (__add, __sub, __mul), __tostring ve __index fallback zinciri.",
            level = CourseLevel.INTERMEDIATE,
            order = 5,
            isPremium = true,
            learningObjectives = listOf(
                "Metatable ile tablolara özel davranışlar ve operatör desteği kazandırmak",
                "__add, __mul gibi metamethodlar ile operatör aşırı yüklemek (Operator Overloading)",
                "__index metamethodunu fallback ve prototip kalıtımı için yapılandırmak"
            ),
            prerequisites = listOf("Tablolar ve Fonksiyonlar"),
            subtopics = listOf("setmetatable & getmetatable", "Operatör Metamethodları (__add, __sub, __mul, __eq)", "__tostring ile Metin Temsili", "__index Metamethodu ve Prototip Kalıtımı", "Veri Koruması (__newindex)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Metatable Mimarisi ve Operatör Aşırı Yükleme",
                    body = "Metatable, sıradan bir tablonun operatörlerle karşılaştığında (+, -, *, ==, ..) veya özel durumlarda nasıl tepki vereceğini yöneten kural tablosudur.\n\n• `__add`: `+` operatörü\n• `__sub`: `-` operatörü\n• `__mul`: `*` operatörü\n• `__eq`: `==` operatörü\n• `__tostring`: `print()` veya `tostring()` çağrıldığında dönen metin",
                    codeSnippet = "local Vektor = {}\nlocal mt = {\n    __add = function(v1, v2)\n        return setmetatable({x = v1.x + v2.x, y = v1.y + v2.y}, mt)\n    },\n    __tostring = function(v)\n        return \"Vektor(\" .. v.x .. \", \" .. v.y .. \")\"\n    }\n}\n\nlocal v1 = setmetatable({x = 10, y = 20}, mt)\nlocal v2 = setmetatable({x = 5, y = 15}, mt)\nlocal v3 = v1 + v2\nprint(tostring(v3)) -- Vektor(15, 35)"
                ),
                LessonContentBlock(
                    subtitle = "2. __index Metamethodu ve Fallback Mekanizması",
                    body = "Bir tabloda aranan bir alan bulunamadığında (`nil`), Lua sanal makinesi metatable'daki `__index` alanına bakar. `__index` bir fonksiyon veya başka bir tablo olabilir.\nBu kural zinciri Lua'da Sınıf (Class) ve Prototip tabanlı Nesne Yönelimli Programlamanın (OOP) temel direğidir.",
                    codeSnippet = "local NesneSinifi = { can = 100, seviye = 1 }\nNesneSinifi.__index = NesneSinifi\n\nlocal yeniNesne = setmetatable({ isim = \"Savasci\" }, NesneSinifi)\nprint(yeniNesne.can) -- NesneSinifi'ndan gelir: 100"
                ),
                LessonContentBlock(
                    subtitle = "3. __newindex ile Salt-Okunur (Read-Only) Tablolar",
                    body = "Var olmayan bir anahtara yeni değer atanmaya çalışıldığında `__newindex` tetiklenir. Bu metamethod ile tablolar salt-okunur (immutable) yapılabilir veya atanacak değerlerin tip güvenliği denetlenebilir.",
                    tip = "Bir tabloyu kilitlemek için `__newindex = function() error(\"Bu tablo salt okunurdur!\") end` yazabilirsiniz."
                )
            ),
            codeExample = "local Varsayilanlar = { can = 100, seviye = 1 }\nlocal mt = { __index = Varsayilanlar }\n\nlocal yeniOyuncu = setmetatable({ isim = \"Can\" }, mt)\nprint(\"Oyuncu: \" .. yeniOyuncu.isim)\nprint(\"Can (Varsayilan): \" .. yeniOyuncu.can) -- Varsayilanlar'dan gelir",
            codeExplanation = "yeniOyuncu tablosunda 'can' alanı yoktur, __index sayesinde Varsayilanlar tablosundan otomatik bulunur.",
            realWorldExample = "Oyun motorlarında 2D/3D Vektör ve Matris matematiği metatable'lar ile sezgisel matematiksel formüllere dönüştürülür.",
            practicalTask = "İki kesirli sayıyı toplayan __add metamethoduna sahip bir Kesir metatable'ı yazın.",
            starterPlaygroundCode = "local mt = { __tostring = function(t) return \"Ozel Tablo: \" .. t.ad end }\nlocal nesne = setmetatable({ ad = \"Nesne-1\" }, mt)\nprint(tostring(nesne))",
            miniQuestion = MiniQuestion(
                id = "lua_q_5",
                question = "Bir tabloda olmayan bir anahtara erişildiğinde devreye giren ve kalıtımı sağlayan en temel metamethod hangisidir?",
                options = listOf("__index", "__newindex", "__call", "__metatable"),
                correctIndex = 0,
                explanation = "__index metamethodu tabloda bulunamayan anahtarların aranacağı yeri belirler."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_lua_5",
                lessonId = "lua_5",
                title = "Metatable ile Varsayılan Değer",
                instructions = "Verilen bir tabloya bulunamayan tüm anahtarlar için \"Yok\" döndüren bir metatable atayıp tabloyu döndüren varsayilanAta(t) fonksiyonunu yazın.",
                exampleInput = "t = { a = 1 }, t.b sorgusu",
                exampleOutput = "\"Yok\"",
                starterCode = "function varsayilanAta(t)\n    -- Kodunu buraya yaz:\n    return t\nend",
                solutionCode = "function varsayilanAta(t)\n    local mt = { __index = function() return \"Yok\" end }\n    return setmetatable(t, mt)\nend",
                hints = listOf("setmetatable(t, { __index = function() return \"Yok\" end }) kullanın."),
                testCases = listOf(
                    TestCase("varsayilanAta({a=1}).b", "Yok", "Fallback testi")
                )
            )
        ),

        // ==========================================
        // DERS 6: NESNE YÖNELİMLİ LUA (OOP & SELF) (PRO)
        // ==========================================
        Lesson(
            id = "lua_6",
            courseId = "lua",
            sectionId = "lua_sec_3",
            title = "Lua ile Nesne Yönelimli Programlama (OOP, Sınıflar & self)",
            shortDesc = "Prototip tabanlı sınıflar, Kurucu metot (Constructor / new), Noktalı virgül (:) sözdizimi ile gizli self parametresi ve Kalıtım (Inheritance).",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true,
            learningObjectives = listOf(
                "Lua'da tablolar ve __index kullanarak Sınıf ve Nesne (Instance) üretmek",
                "İki nokta (nesne:metot()) sözdiziminin `self` parametresini nasıl aktardığını kavramak",
                "Bir üst sınıftan (BaseClass) türetilen alt sınıflar (Subclass) ile kalıtım kurmak"
            ),
            prerequisites = listOf("Metatables ve Metamethods"),
            subtopics = listOf("Sınıf Tanımlama Kalıbı", "new() Kurucu Metodu", "Nokta (.) vs İki Nokta (:)", "self Parametresi", "Kalıtım (Inheritance) Mimarisi"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Lua OOP Kalıbı",
                    body = "Lua'da `class` anahtar kelimesi yoktur; sınıflar bir tablo ve onun `__index`'i olarak tasarlanır.",
                    codeSnippet = "local Karakter = {}\nKarakter.__index = Karakter\n\nfunction Karakter.new(isim, can)\n    local self = setmetatable({}, Karakter)\n    self.isim = isim\n    self.can = can\n    return self\nend\n\nfunction Karakter:hasarAl(miktar)\n    self.can = self.can - miktar\n    print(self.isim .. \" hasar aldi! Kalan can: \" .. self.can)\nend\n\nlocal k1 = Karakter.new(\"Savasci\", 100)\nk1:hasarAl(25) -- İki nokta ile çağrılır"
                ),
                LessonContentBlock(
                    subtitle = "2. İki Nokta (:) Sözdizimi",
                    body = "`k1:hasarAl(25)` çağrısı arka planda `k1.hasarAl(k1, 25)` olarak çalışır ve `self` değişkenini otomatik bağlar.",
                    tip = "Kalıtım için alt sınıfın metatable'ının __index değeri üst sınıfa yönlendirilir."
                )
            ),
            codeExample = "local Dusman = setmetatable({}, { __index = Karakter })\nDusman.__index = Dusman\n\nfunction Dusman.new(isim, can, guc)\n    local self = Karakter.new(isim, can)\n    setmetatable(self, Dusman)\n    self.guc = guc\n    return self\nend\n\nlocal d1 = Dusman.new(\"Goblin\", 50, 10)\nd1:hasarAl(15)",
            codeExplanation = "Dusman sınıfı Karakter'den kalıtım alır ve onun tüm metotlarını miras kullanır.",
            realWorldExample = "Roblox oyunlarında tüm karakter kontrolcüleri, silah sınıfları ve UI bileşenleri bu OOP kalıbıyla yazılır.",
            practicalTask = "BankaHesabi adında paraYatir ve paraCek metotları olan bir Lua sınıfı kodlayın.",
            starterPlaygroundCode = "local Araba = {}\nAraba.__index = Araba\nfunction Araba.new(model) return setmetatable({model = model, hiz = 0}, Araba) end\nfunction Araba:gazla() self.hiz = self.hiz + 20 end\nlocal a = Araba.new(\"Spor\"); a:gazla(); print(\"Hiz: \" .. a.hiz)",
            miniQuestion = MiniQuestion(
                id = "lua_q_6",
                question = "Lua'da bir nesne metodunu çağırırken nesnenin kendisini fonksiyona gizli `self` parametresi olarak aktaran sözdizimi hangisidir?",
                options = listOf("İki nokta (nesne:metot())", "Nokta (nesne.metot())", "Ok (nesne->metot())", "Çift iki nokta (nesne::metot())"),
                correctIndex = 0,
                explanation = "İki nokta (:) sözdizimi metodu çağırırken birinci parametre olarak çağıran nesneyi (self) otomatik iletir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_lua_6",
                lessonId = "lua_6",
                title = "Sayaç Sınıfı",
                instructions = "Sayac adında new() ile başlatılan ve :arttir() metodu çağrıldığında deger alanını 1 arttıran sınıfı yazın.",
                exampleInput = "s = Sayac.new(), s:arttir()",
                exampleOutput = "s.deger == 1",
                starterCode = "Sayac = {}\nSayac.__index = Sayac\nfunction Sayac.new()\n    -- Kodunu buraya yaz:\nend\nfunction Sayac:arttir()\n    -- Kodunu buraya yaz:\nend",
                solutionCode = "Sayac = {}\nSayac.__index = Sayac\nfunction Sayac.new()\n    return setmetatable({deger = 0}, Sayac)\nend\nfunction Sayac:arttir()\n    self.deger = self.deger + 1\nend",
                hints = listOf("self.deger = self.deger + 1 yazın."),
                testCases = listOf(
                    TestCase("s:arttir()", "1", "Sayaç sınıf testi")
                )
            )
        ),

        // ==========================================
        // DERS 7: CLOSURES & FONKSİYONEL PROGRAMLAMA (PRO)
        // ==========================================
        Lesson(
            id = "lua_7",
            courseId = "lua",
            sectionId = "lua_sec_4",
            title = "Kapanışlar (Closures), Lexical Scoping & State Kapsülleme",
            shortDesc = "Lexical Scoping, Upvalue değişkenleri, Closure fabrikaları, Kapsüllenmiş özel durumlar (Private State) ve Fonksiyonel araçlar (map, filter).",
            level = CourseLevel.INTERMEDIATE,
            order = 7,
            isPremium = true,
            learningObjectives = listOf(
                "Closure'ların dış kapsamdaki (Upvalue) değişkenleri nasıl canlı tuttuğunu anlamak",
                "Nesnesiz saf private state (veri gizleme) fabrikaları üretmek",
                "Yüksek dereceli fonksiyonlar (Higher-Order Functions) geliştirmek"
            ),
            prerequisites = listOf("OOP ve Sınıf Mimarisi"),
            subtopics = listOf("Lexical Scope Kuralları", "Upvalues Nedir?", "Closure Fabrikaları", "Veri Kapsülleme (Private State)", "İteratör Üreticileri"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Closure ve Upvalue Mantığı",
                    body = "Bir fonksiyon başka bir fonksiyon içinde tanımlandığında ve dış fonksiyonun lokal değişkenine eriştiğinde bir `Closure` oluşur. Dış fonksiyon sonlansa bile o değişken bellekte yaşamaya devam eder.",
                    codeSnippet = "local function sayacUret(baslangic)\n    local sayi = baslangic or 0\n    return function()\n        sayi = sayi + 1\n        return sayi\n    end\nend\n\nlocal sayac1 = sayacUret(10)\nprint(sayac1()) -- 11\nprint(sayac1()) -- 12"
                ),
                LessonContentBlock(
                    subtitle = "2. Özel Veri Gizleme",
                    body = "Closure'lar sayesinde dışarıdan erişilemeyen güvenli banka hesabı veya şifre korumalı durum makineleri kurulabilir.",
                    tip = "Lua'da for .. in döngüsü aslında her adımda bir closure iteratör çağırır."
                )
            ),
            codeExample = "local function filtrele(tablo, kosul)\n    local sonuc = {}\n    for _, v in ipairs(tablo) do\n        if kosul(v) then table.insert(sonuc, v) end\n    end\n    return sonuc\nend\n\nlocal sayilar = {1, 2, 3, 4, 5, 6}\nlocal ciftler = filtrele(sayilar, function(x) return x % 2 == 0 end)\nprint(\"Cift Sayi Adedi: \" .. #ciftler)",
            codeExplanation = "Anonim fonksiyon koşul olarak iletilip yüksek dereceli filtreleme yapılır.",
            realWorldExample = "Oyun içi tetikleyiciler (Triggers ve Event Listener'lar) parametrelerini closure içinde dondurarak saklar.",
            practicalTask = "Her çağrıldığında önceki sayının iki katını döndüren bir çarpan üreteci (Closure) yazın.",
            starterPlaygroundCode = "local function carpanUret(k)\n    return function(x) return x * k end\nend\nlocal ikiyleCarp = carpanUret(2)\nprint(\"5 * 2 = \" .. ikiyleCarp(5))",
            miniQuestion = MiniQuestion(
                id = "lua_q_7",
                question = "İç içe fonksiyonlarda bir alt fonksiyonun dış kapsamındaki lokal değişkene ne ad verilir?",
                options = listOf("Upvalue (External Local Variable)", "Global değişken", "Static pointer", "Macro"),
                correctIndex = 0,
                explanation = "Lua'da iç fonksiyon tarafından yakalanan üst kapsam değişkenlerine 'Upvalue' adı verilir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_lua_7",
                lessonId = "lua_7",
                title = "Kümülatif Toplayıcı Closure",
                instructions = "baslangic değeri alan ve her çağrıldığında verilen miktarı biriktirip dönen toplayiciUret(baslangic) fonksiyonunu yazın.",
                exampleInput = "t = toplayiciUret(10); t(5); t(10)",
                exampleOutput = "25",
                starterCode = "function toplayiciUret(baslangic)\n    -- Kodunu buraya yaz:\nend",
                solutionCode = "function toplayiciUret(baslangic)\n    local toplam = baslangic or 0\n    return function(miktar)\n        toplam = toplam + (miktar or 0)\n        return toplam\n    end\nend",
                hints = listOf("Lokal toplam değişkenini iç fonksiyonda güncelleyip döndürün."),
                testCases = listOf(
                    TestCase("t(5)", "15", "Kümülatif closure testi")
                )
            )
        ),

        // ==========================================
        // DERS 8: COROUTINES (EŞYORDAMLAR) (PRO)
        // ==========================================
        Lesson(
            id = "lua_8",
            courseId = "lua",
            sectionId = "lua_sec_4",
            title = "Coroutines (Eşyordamlar): İşbirlikçi Çoklu Görev",
            shortDesc = "İşbirlikçi çoklu görev (Cooperative Multitasking), coroutine.create, coroutine.resume, coroutine.yield, durum kontrolü (status) ve asenkron akışlar.",
            level = CourseLevel.INTERMEDIATE,
            order = 8,
            isPremium = true,
            learningObjectives = listOf(
                "İşletim sistemi thread'leri ile hafif Lua Coroutine'leri arasındaki farkı kavramak",
                "coroutine.yield() ile fonksiyon yürütmesini dondurup ana akışa dönmek",
                "coroutine.resume() ile veri ileterek donmuş noktadan devam ettirmek"
            ),
            prerequisites = listOf("Closures ve Fonksiyonel Programlama"),
            subtopics = listOf("Coroutines Nedir?", "coroutine.create & resume", "coroutine.yield ile Duraklatma", "Çift Yönlü Veri Aktarımı", "Oyun Döngüsü Zamanlayıcısı"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Coroutine Mantığı",
                    body = "Standart fonksiyonlar çağrılır ve sonuna kadar çalışır. Bir `coroutine` ise `coroutine.yield()` ile istediği yerde durup durumunu saklar ve daha sonra `coroutine.resume()` ile tam kaldığı satırdan devam eder.",
                    codeSnippet = "local co = coroutine.create(function()\n    print(\"Adim 1: Basladi\")\n    coroutine.yield(\"Duraklatildi 1\")\n    print(\"Adim 2: Devam ediyor\")\n    coroutine.yield(\"Duraklatildi 2\")\n    print(\"Adim 3: Bitti\")\nend)\n\nprint(coroutine.resume(co)) -- true, Duraklatildi 1\nprint(coroutine.resume(co)) -- true, Duraklatildi 2\nprint(coroutine.resume(co)) -- true"
                ),
                LessonContentBlock(
                    subtitle = "2. Thread Güvenliği",
                    body = "Coroutines işbirlikçidir (cooperative); yani CPU kontrolünü zorla devretmezler, sadece kodun kendisi yield dediğinde kontrol ana programa döner. Bu sayede Lock ve Race Condition sorunları yaşanmaz.",
                    tip = "Roblox'ta `task.wait()` veya `coroutine.wrap()` arka planda doğrudan Lua eşyordamlarını yönetir."
                )
            ),
            codeExample = "local function geriSayim(n)\n    return coroutine.create(function()\n        for i = n, 1, -1 do\n            coroutine.yield(i)\n        end\n    end)\nend\n\nlocal sayacCo = geriSayim(3)\nlocal _, deger = coroutine.resume(sayacCo)\nprint(\"Gelen: \" .. deger) -- 3",
            codeExplanation = "Eşyordam her yield çağrısında sıradaki sayıyı döner ve dondurulur.",
            realWorldExample = "Oyunlarda NPC diyalog sistemleri veya sinematik ara sahneler coroutines ile adım adım kare kare oynatılır.",
            practicalTask = "3 aşamalı bir görev tamamlanma sürecini adım adım yield eden bir coroutine yazın.",
            starterPlaygroundCode = "local co = coroutine.create(function() print(\"A\"); coroutine.yield(); print(\"B\") end)\ncoroutine.resume(co)\nprint(\"Ana Akis\");\ncoroutine.resume(co)",
            miniQuestion = MiniQuestion(
                id = "lua_q_8",
                question = "Çalışmakta olan bir Lua coroutine'inin yürütülmesini duraklatıp çağıran koda dönmesini sağlayan fonksiyon hangisidir?",
                options = listOf("coroutine.yield()", "coroutine.pause()", "coroutine.stop()", "coroutine.sleep()"),
                correctIndex = 0,
                explanation = "coroutine.yield() eşyordamın çalışmasını dondurup kontrolü resume() yapan tarafa iletir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_lua_8",
                lessonId = "lua_8",
                title = "İki Adımlı Coroutine Üretici",
                instructions = "İlk resume'da 10, ikinci resume'da 20 yield eden bir coroutine üreten ikiAdimCo() fonksiyonunu yazın.",
                exampleInput = "co = ikiAdimCo(); _, val = coroutine.resume(co)",
                exampleOutput = "10",
                starterCode = "function ikiAdimCo()\n    -- Kodunu buraya yaz:\nend",
                solutionCode = "function ikiAdimCo()\n    return coroutine.create(function()\n        coroutine.yield(10)\n        coroutine.yield(20)\n    end)\nend",
                hints = listOf("coroutine.create(function() coroutine.yield(10) coroutine.yield(20) end) yazın."),
                testCases = listOf(
                    TestCase("coroutine.resume(co)", "true, 10", "Coroutine yield testi")
                )
            )
        ),

        // ==========================================
        // DERS 9: STRING DESEN EŞLEME (PATTERN MATCHING) (PRO)
        // ==========================================
        Lesson(
            id = "lua_9",
            courseId = "lua",
            sectionId = "lua_sec_5",
            title = "Desen Eşleme (Pattern Matching) & String Kütüphanesi",
            shortDesc = "Lua'nın hafif regex alternatifi Desen Eşleme sistemi, Karakter sınıfları (%d, %a, %s, %w), string.find, string.match, string.gmatch ve string.gsub.",
            level = CourseLevel.ADVANCED,
            order = 9,
            isPremium = true,
            learningObjectives = listOf(
                "Ağır Regex motorları yerine ultra hafif Lua Pattern sistemini kullanmak",
                "Karakter sınıfları (%d: rakam, %a: harf, %s: boşluk) ile desenler oluşturmak",
                "string.gsub ve yakalama parantezleri () ile metin dönüştürmek"
            ),
            prerequisites = listOf("Coroutines ve Tablolar"),
            subtopics = listOf("string.find ve string.match", "Karakter Sınıfları (%d, %a, %w)", "Yakalama Grupları ()", "string.gmatch ile Tüm Eşleşmeler", "string.gsub ile Metin Değiştirme"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Lua Karakter Sınıfları",
                    body = "• `%d`: Rakamlar (0-9)\n• `%a`: Harfler (a-z, A-Z)\n• `%w`: Harf ve rakamlar\n• `%s`: Boşluk karakterleri\n• `+`: 1 veya daha fazla\n• `*`: 0 veya daha fazla.",
                    codeSnippet = "local metin = \"Siparis ID: #9842, Tarih: 2026-08-24\"\nlocal id = string.match(metin, \"#(%d+)\")\nprint(\"Bulunan ID: \" .. id) -- 9842"
                ),
                LessonContentBlock(
                    subtitle = "2. string.gsub ile Şablon Değiştirme",
                    body = "`string.gsub(metin, desen, hedef)` metindeki desenle eşleşen tüm yerleri değiştirir veya her eşleşme için bir fonksiyon çalıştırır.",
                    tip = "Büyük harfli sınıflar (%D, %A, %S) tam tersini (negation) temsil eder."
                )
            ),
            codeExample = "local metin = \"isim=Ali, yas=24, rol=Admin\"\nfor anahtar, deger in string.gmatch(metin, \"(%w+)=(%w+)\") do\n    print(anahtar .. \" -> \" .. deger)\nend",
            codeExplanation = "string.gmatch bir iteratör döner ve tüm eşleşen anahtar=değer ikililerini çıkarır.",
            realWorldExample = "Oyun içi sohbet filtreleri ve metin komut ayrıştırıcıları (örn: /tp oyuncu 100 200) string.match ile ayrıştırılır.",
            practicalTask = "Bir metindeki tüm e-posta adreslerini veya telefon numaralarını desenle ayıklayan bir fonksiyon yazın.",
            starterPlaygroundCode = "local log = \"HATA [404]: Sayfa Bulunamadi\"\nlocal kod = string.match(log, \"%[(%d+)%]\")\nprint(\"Hata Kodu: \" .. kod)",
            miniQuestion = MiniQuestion(
                id = "lua_q_9",
                question = "Lua desen eşlemede (Pattern Matching) sadece sayıları/rakamları temsil eden karakter sınıfı hangisidir?",
                options = listOf("%d", "%s", "%a", "%w"),
                correctIndex = 0,
                explanation = "%d (digits) tüm 0-9 arası rakamlarla eşleşir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_lua_9",
                lessonId = "lua_9",
                title = "Sayı Ayıklayıcı",
                instructions = "Verilen bir metin içindeki ilk rakam öbeğini string olarak döndüren ilkSayiyiBul(metin) fonksiyonunu yazın.",
                exampleInput = "metin = \"Oyuncu skoru: 450 puan\"",
                exampleOutput = "\"450\"",
                starterCode = "function ilkSayiyiBul(metin)\n    -- Kodunu buraya yaz:\n    return \"\"\nend",
                solutionCode = "function ilkSayiyiBul(metin)\n    return string.match(metin, \"%d+\") or \"\"\nend",
                hints = listOf("string.match(metin, \"%d+\") kullanın."),
                testCases = listOf(
                    TestCase("ilkSayiyiBul(\"Puan 450\")", "450", "Pattern match testi")
                )
            )
        ),

        // ==========================================
        // DERS 10: MODÜLLER, PAKETLER & REQUIRE (PRO)
        // ==========================================
        Lesson(
            id = "lua_10",
            courseId = "lua",
            sectionId = "lua_sec_5",
            title = "Modüller, Paketler & require() Mimarisi",
            shortDesc = "Modül yazma standartları, require() fonksiyonu, package.loaded önbelleği, Modül izolasyonu ve temiz API tasarımı.",
            level = CourseLevel.ADVANCED,
            order = 10,
            isPremium = true,
            learningObjectives = listOf(
                "Lua'da yeniden kullanılabilir bağımsız modüller (tablo dönen dosyalar) tasarlamak",
                "require() ile modül import etmek ve package.path mantığını kavramak",
                "Global isim alanını kirletmeden temiz kütüphaneler oluşturmak"
            ),
            prerequisites = listOf("Desen Eşleme ve Stringler"),
            subtopics = listOf("Modül Tanımlama Kalıbı", "require() ve package.loaded", "Lokal Kapsam Hijyeni", "package.path Yapılandırması", "Singleton vs Factory Modülleri"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Temiz Modül Kalıbı",
                    body = "Bir Lua modülü aslında bir dosya ve onun sonunda `return modülTablosu` diyen yapıdır.",
                    codeSnippet = "-- matematik.lua\nlocal M = {}\n\nfunction M.topla(a, b) return a + b end\nfunction M.carp(a, b) return a * b end\n\nreturn M\n\n-- main.lua\nlocal mat = require(\"matematik\")\nprint(mat.topla(10, 5))"
                ),
                LessonContentBlock(
                    subtitle = "2. require() Önbelleklemesi",
                    body = "Bir modül `require` ile ilk kez yüklendiğinde çalıştırılır ve sonucu `package.loaded` tablosunda saklanır. Sonraki çağrılarda dosya tekrar okunmaz, önbellekteki tablo anında döner.",
                    tip = "Modül içinde asla global değişken tanımlamayın, her zaman yerel modül tablosuna bağlayın."
                )
            ),
            codeExample = "local Hesaplayici = {}\nHesaplayici.surum = \"1.0.0\"\nfunction Hesaplayici.kare(x) return x * x end\n\n-- Dışa aktarım simülasyonu:\nlocal k = Hesaplayici\nprint(\"Modul Versiyonu: \" .. k.surum .. \" -> Kare: \" .. k.kare(7))",
            codeExplanation = "Modül tablosu dışarı aktarılır ve fonksiyonları temiz bir namespace altında toplanır.",
            realWorldExample = "Oyun motoru eklentileri (LuaRocks kütüphaneleri) require ile projeye dahil edilir.",
            practicalTask = "İçinde daireAlan ve dikdortgenAlan fonksiyonları olan bir Geometri modülü oluşturun.",
            starterPlaygroundCode = "local Modul = { ad = \"TestModul\" }\nfunction Modul.selam() return \"Merhaba \" .. Modul.ad end\nprint(Modul.selam())",
            miniQuestion = MiniQuestion(
                id = "lua_q_10",
                question = "Lua'da harici bir modül veya kütüphane dosyasını yüklemek için kullanılan yerleşik fonksiyon hangisidir?",
                options = listOf("require()", "import()", "include()", "using()"),
                correctIndex = 0,
                explanation = "require() fonksiyonu dosyayı yükler, çalıştırır ve döndürdüğü tabloyu getirir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_lua_10",
                lessonId = "lua_10",
                title = "Matematik Modülü Üretici",
                instructions = "İçinde topla(a,b) ve cikar(a,b) metotları olan bir tablo döndüren modulUret() fonksiyonunu yazın.",
                exampleInput = "m = modulUret(); m.topla(5, 3)",
                exampleOutput = "8",
                starterCode = "function modulUret()\n    -- Kodunu buraya yaz:\nend",
                solutionCode = "function modulUret()\n    local M = {}\n    function M.topla(a, b) return a + b end\n    function M.cikar(a, b) return a - b end\n    return M\nend",
                hints = listOf("Yerel bir tablo oluşturup içine fonksiyonları ekleyin ve return edin."),
                testCases = listOf(
                    TestCase("m.topla(5, 3)", "8", "Modül üretme testi")
                )
            )
        ),

        // ==========================================
        // DERS 11: LUA C API & GÖMME (EMBEDDING) (PRO)
        // ==========================================
        Lesson(
            id = "lua_11",
            courseId = "lua",
            sectionId = "lua_sec_6",
            title = "Lua C API: C/C++ İçine Lua Gömme & Sanal Yığın (Virtual Stack)",
            shortDesc = "Lua C API mimarisi, lua_State, Sanal Yığın (Stack: push, pop, gettop), C fonksiyonlarını Lua'ya export etme ve Yüksek performans köprüsü.",
            level = CourseLevel.EXPERT,
            order = 11,
            isPremium = true,
            learningObjectives = listOf(
                "Lua'nın neden dünyanın 1 numaralı gömülü script dili olduğunu anlamak",
                "Lua C sanal yığınını (Virtual Stack) ve pozitif/negatif indeksleri yönetmek",
                "C/C++ fonksiyonlarını Lua içerisinden çağrılabilir hale getirmek"
            ),
            prerequisites = listOf("Modüller ve Coroutines"),
            subtopics = listOf("lua_State Yaşam Döngüsü", "Sanal Yığın (Stack) İndeksleri", "lua_push* ve lua_to* Fonksiyonları", "C Fonksiyonu Kaydetme (lua_register)", "Lua'dan C'ye Hata Yönetimi"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Sanal Yığın (Virtual Stack) Mimarisi",
                    body = "C ile Lua arasındaki tüm iletişim ortak bir yığın (Stack) üzerinden gerçekleşir.\n• Pozitif indeks (+1): Yığının en dibi (ilk eklenen)\n• Negatif indeks (-1): Yığının en tepesi (son eklenen).",
                    codeSnippet = "// C Kodu Örneği\n#include <lua.h>\n#include <lauxlib.h>\n\nstatic int c_topla(lua_State *L) {\n    double a = lua_tonumber(L, 1); // 1. argüman\n    double b = lua_tonumber(L, 2); // 2. argüman\n    lua_pushnumber(L, a + b);      // Sonucu yığına koy\n    return 1;                      // 1 adet dönüş değeri\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Neden Lua Gömülür?",
                    body = "Oyun geliştiricileri C++ ile motoru yazar, oyun tasarımcıları ise derleme beklemeden anında canlı test yapabilmek için mantığı Lua ile kodlar.",
                    tip = "LuaJIT derleyicisi Lua kodunu C hızına çok yakın JIT makine koduna dönüştürür."
                )
            ),
            codeExample = "-- Lua Tarafından C Fonksiyonunun Çağrılması:\n-- C tarafında: lua_register(L, \"sistemLog\", c_log);\n-- Lua tarafında:\nlocal function testGomulu()\n    print(\"Lua -> C API Koprusu Aktif\")\nend\ntestGomulu()",
            codeExplanation = "C fonksiyonları Lua ortamına kaydedilir ve Lua içerisinden doğal fonksiyonlar gibi çağrılır.",
            realWorldExample = "Nginx web sunucusu (OpenResty) ve Redis veritabanı mikro-saniyelik filtreler için Lua C API kullanır.",
            practicalTask = "C yığın indekslerinin (+1 ve -1) ne anlama geldiğini simüle eden bir açıklama yazın.",
            starterPlaygroundCode = "print(\"Lua C API Entegrasyon Modulu Hazir\")",
            miniQuestion = MiniQuestion(
                id = "lua_q_11",
                question = "Lua C API'sinde yığının en tepesindeki (en son eklenen) elemanı okumak için hangi indeks kullanılır?",
                options = listOf("-1", "0", "1", "top"),
                correctIndex = 0,
                explanation = "Lua yığınında negatif indeksler tepeden başlar; -1 en üstteki son elemandır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_lua_11",
                lessonId = "lua_11",
                title = "Yığın Simülasyonu",
                instructions = "Dizi olarak verilen bir yığının en üst elemanını (son eleman) döndüren sonEleman(yigin) fonksiyonunu yazın.",
                exampleInput = "yigin = {10, 20, 30}",
                exampleOutput = "30",
                starterCode = "function sonEleman(yigin)\n    -- Kodunu buraya yaz:\n    return nil\nend",
                solutionCode = "function sonEleman(yigin)\n    return yigin[#yigin]\nend",
                hints = listOf("yigin[#yigin] ile son elemanı döndürün."),
                testCases = listOf(
                    TestCase("sonEleman({10, 20, 30})", "30", "Yığın son eleman testi")
                )
            )
        ),

        // ==========================================
        // DERS 12: ROBLOX & OYUN MOTORU MİMARİSİ (PRO)
        // ==========================================
        Lesson(
            id = "lua_12",
            courseId = "lua",
            sectionId = "lua_sec_6",
            title = "Roblox & Oyun Motorlarında İleri Mimari (ECS & State Machine)",
            shortDesc = "Oyun durum makineleri (Finite State Machine), Varlık-Bileşen Sistemi (Entity-Component System - ECS), Event-Driven mimari ve Roblox Luau optimizasyonları.",
            level = CourseLevel.EXPERT,
            order = 12,
            isPremium = true,
            learningObjectives = listOf(
                "Oyunlarda karmaşık if kontrolleri yerine Finite State Machine (FSM) tasarlamak",
                "Entity-Component System (ECS) mimarisi ile performanslı oyun nesneleri yönetmek",
                "Roblox ve modern oyun motorlarında 60 FPS bellek ve döngü optimizasyonları yapmak"
            ),
            prerequisites = listOf("Lua C API ve Modüller"),
            subtopics = listOf("Finite State Machine (FSM)", "Entity-Component System (ECS)", "Event Bus Mimarisi", "Roblox Luau Tip Belirteçleri", "60 FPS Garbage Collection Optimizasyonu"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Durum Makinesi (State Machine)",
                    body = "Bir karakterin durumları (Boşta, Koşuyor, Saldırıyor, Ölü) durum nesneleri olarak kapsüllenir ve geçişler temiz yönetilir.",
                    codeSnippet = "local StateMachine = {}\nStateMachine.__index = StateMachine\n\nfunction StateMachine.new(initialState)\n    return setmetatable({ current = initialState }, StateMachine)\nend\n\nfunction StateMachine:change(newState)\n    print(\"Durum degisti: \" .. self.current .. \" -> \" .. newState)\n    self.current = newState\nend\n\nlocal fsm = StateMachine.new(\"IDLE\")\nfsm:change(\"RUN\")"
                ),
                LessonContentBlock(
                    subtitle = "2. ECS Mimarisi ve GC Hijyeni",
                    body = "Oyun içi her karede sürekli yeni tablo `{}` üretmek Çöp Toplayıcıyı (Garbage Collector) tetikleyerek FPS düşüşüne yol açar. Nesne havuzları (Object Pooling) ile aynı tablolar yeniden kullanılır.",
                    tip = "Luau tip sistemi ile değişkenlere tür tanımlayarak derleyici optimizasyonlarını en üst düzeye çıkarabilirsiniz."
                )
            ),
            codeExample = "local OyuncuDurumu = {\n    DURUM_BEKLEME = \"IDLE\",\n    DURUM_KOSMA = \"RUNNING\",\n    DURUM_SALDIRI = \"ATTACK\"\n}\n\nlocal durum = OyuncuDurumu.DURUM_BEKLEME\nprint(\"Karakter Hazir, Durum: \" .. durum)",
            codeExplanation = "Durum sabitleri ve event dinleyicileri oyun mimarisini modüler ve hatasız tutar.",
            realWorldExample = "Milyonlarca oyuncuya sahip Roblox oyunları (Blox Fruits, Adopt Me) ve AAA oyun motorları bu ECS ve State Machine mimarisini kullanır.",
            practicalTask = "Karakterin canı 0'a düştüğünde durumunu 'DEAD' yapan basit bir durum yöneticisi yazın.",
            starterPlaygroundCode = "print(\"Lua ve Oyun Mimarisi Uzmanlik Seviyesi Tamamlandi!\")",
            miniQuestion = MiniQuestion(
                id = "lua_q_12",
                question = "Oyun motorlarında her karede sürekli geçici tablolar ({}) oluşturmanın en büyük performans riski nedir?",
                options = listOf("Garbage Collector'ı (Çöp Toplayıcıyı) tetikleyip mikro donmalara (Frame Drop) sebep olmak", "Ekran çözünürlüğünü düşürmek", "Dosya boyutunu arttırmak", "İnternet bağlantısını yavaşlatmak"),
                correctIndex = 0,
                explanation = "Sürekli bellek tahsisi Garbage Collector'ın devreye girmesine ve 60 FPS kare düşüşlerine yol açar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_lua_12",
                lessonId = "lua_12",
                title = "Durum Geçiş Denetleyicisi",
                instructions = "Mevcut durum 'IDLE' ise 'RUNNING', 'RUNNING' ise 'IDLE' döndüren durumGecis(durum) fonksiyonunu yazın.",
                exampleInput = "durum = \"IDLE\"",
                exampleOutput = "\"RUNNING\"",
                starterCode = "function durumGecis(durum)\n    -- Kodunu buraya yaz:\n    return durum\nend",
                solutionCode = "function durumGecis(durum)\n    if durum == \"IDLE\" then return \"RUNNING\" end\n    if durum == \"RUNNING\" then return \"IDLE\" end\n    return durum\nend",
                hints = listOf("if durum == \"IDLE\" then return \"RUNNING\" kontrolü yapın."),
                testCases = listOf(
                    TestCase("durumGecis(\"IDLE\")", "RUNNING", "State switch testi")
                )
            )
        )
    )
}
