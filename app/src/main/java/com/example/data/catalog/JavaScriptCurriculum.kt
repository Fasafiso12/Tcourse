package com.example.data.catalog

import com.example.model.*

/**
 * JavaScript Kolay & Anlaşılır Müfredatı (12 Adım):
 * Web tarayıcılarının, dinamik sitelerin ve modern frontend dünyasının vazgeçilmez dilini eğlenceli örneklerle öğrenin!
 */
object JavaScriptCurriculum {

    fun getSections(): List<CourseSection> = listOf(
        CourseSection(
            id = "js_sec_1",
            courseId = "javascript",
            title = "Bölüm 1: JavaScript Temelleri ve console.log()",
            level = CourseLevel.BEGINNER,
            order = 1,
            description = "console.log(), let ve const değişkenleri, `\${isim}` şablonları ve temel tipler.",
            learningObjectives = listOf("console.log() ile ekrana yazdırmak", "let ve const farkını bilmek", "Metin ve sayı değişkenleri tanımlamak"),
            prerequisites = listOf("Ön koşul gerekmez! Sıfırdan başlar.")
        ),
        CourseSection(
            id = "js_sec_2",
            courseId = "javascript",
            title = "Bölüm 2: Koşullar, Döngüler ve Fonksiyonlar",
            level = CourseLevel.BEGINNER,
            order = 2,
            description = "if-else kararları, for döngüsü ve modern ok fonksiyonları (() => {}).",
            learningObjectives = listOf("if-else ile koşul kontrolü yapmak", "for döngüsü kurmak", "Ok fonksiyonları (Arrow Functions) yazmak"),
            prerequisites = listOf("JavaScript Temelleri")
        ),
        CourseSection(
            id = "js_sec_3",
            courseId = "javascript",
            title = "Bölüm 3: Diziler (Arrays) ve Nesneler (Objects)",
            level = CourseLevel.INTERMEDIATE,
            order = 3,
            description = "Listeler ([1, 2, 3]), push/pop, anahtar-değer nesneleri ({ isim: 'Can' }) ve forEach.",
            learningObjectives = listOf("Dizilere eleman ekleyip çıkarmak", "JSON benzeri nesneler oluşturmak"),
            prerequisites = listOf("Fonksiyonlar ve Döngüler")
        ),
        CourseSection(
            id = "js_sec_4",
            courseId = "javascript",
            title = "Bölüm 4: Dizi Metotları: map, filter, reduce",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            description = "Döngü yazmadan listeleri dönüştüren map, filtreleyen filter ve toplayan reduce.",
            learningObjectives = listOf("map ile listeleri dönüştürmek", "filter ile süzgeçten geçirmek", "reduce ile özet hesaplamak"),
            prerequisites = listOf("Diziler ve Nesneler")
        ),
        CourseSection(
            id = "js_sec_5",
            courseId = "javascript",
            title = "Bölüm 5: Asenkron JavaScript: Promises ve Async/Await",
            level = CourseLevel.ADVANCED,
            order = 5,
            description = "İnternetten veri çekerken sayfayı dondurmayan async/await ve fetch() API.",
            learningObjectives = listOf("Asenkron programlama mantığını kavramak", "async ve await ile veri beklemek", "try-catch ile hataları yakalamak"),
            prerequisites = listOf("Dizi Metotları")
        ),
        CourseSection(
            id = "js_sec_6",
            courseId = "javascript",
            title = "Bölüm 6: DOM Yönetimi ve Web Ustalığı",
            level = CourseLevel.EXPERT,
            order = 6,
            description = "HTML elemanlarını canlı değiştirme (DOM), tıklama olayları (addEventListener) ve modern JS ekosistemi.",
            learningObjectives = listOf("Sayfadaki buton ve yazıları JavaScript ile yönetmek", "Tıklama ve form olaylarını dinlemek"),
            prerequisites = listOf("Tüm Seviyeler")
        )
    )

    fun getLessons(): List<Lesson> = listOf(
        // ==========================================
        // DERS 1: CONSOLE.LOG VE DEĞİŞKENLER
        // ==========================================
        Lesson(
            id = "js_1",
            courseId = "javascript",
            sectionId = "js_sec_1",
            title = "JavaScript'e Giriş: console.log() ve Değişkenler",
            shortDesc = "Web'in beyni! console.log() ile mesaj yazdırın, let ve const ile değişkenler tanımlayın.",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false,
            learningObjectives = listOf(
                "console.log() ile tarayıcı konsoluna yazı yazdırmak",
                "let (değişebilir) ve const (sabit) arasındaki farkı kavramak",
                "Metin, sayı ve boolean tiplerini öğrenmek"
            ),
            prerequisites = listOf("Ön koşul gerekmez."),
            subtopics = listOf("JavaScript Nedir?", "console.log()", "let ve const", "Şablon Dizgileri (`\${}` )"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Web'i Canlandıran Dil: JavaScript",
                    body = "HTML sayfanın iskeleti, CSS kıyafeti ise JavaScript o sayfanın canlı beynidir! Butonlara tıklanınca çalışan her şey JavaScript ile yapılır.\n\nEkrana veya konsola çıktı almak için `console.log()` kullanırız."
                ),
                LessonContentBlock(
                    subtitle = "2. Değişkenler: let ve const",
                    body = "• `let`: Değeri sonradan değişebilen değişkenler için (örn: skor, sayaç).\n• `const`: Değeri asla değişmeyen sabitler için (örn: pi sayısı, site adı).\n\nMetinleri birleştirmek için ters tırnak içindeki `\${değişken}` yapısını kullanırız.",
                    codeSnippet = "const ulke = 'Türkiye';\nlet puan = 100;\npuan = 150; // Değeri güncelleyebiliriz\n\nconsole.log(`Tebrikler! Puanınız: \${puan}, Ülke: \${ulke}`);"
                )
            ),
            codeExample = "const ad = 'Ahmet';\nlet yas = 20;\nconsole.log(`Merhaba, benim adım \${ad} ve \${yas} yaşındayım.`);",
            codeExplanation = "const ve let ile değişken tanımlandı ve şablon dizgisi (template literal) ile birleştirildi.",
            realWorldExample = "Bir alışveriş sitesinde sepet tutarı hesaplandığında let toplamFiyat değişkeninde tutulur ve ekrana basılır.",
            practicalTask = "Adınızı ve favori renginizi iki değişkende saklayıp console.log ile yazdırın.",
            starterPlaygroundCode = "const isim = 'Zeynep';\nlet favoriRenk = 'Mavi';\nconsole.log(`İsim: \${isim}, Renk: \${favoriRenk}`);",
            miniQuestion = MiniQuestion(
                id = "js_q_1",
                question = "JavaScript'te değeri sonradan asla değiştirilemeyecek sabit bir değişken tanımlamak için hangisi kullanılır?",
                options = listOf("const", "let", "var", "static"),
                correctIndex = 0,
                explanation = "Sabit değişkenler 'const' (constant) anahtar kelimesi ile tanımlanır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_1",
                lessonId = "js_1",
                title = "İki Sayıyı Topla",
                instructions = "İki sayıyı toplayıp sonucunu döndüren topla(a, b) fonksiyonunu yazın.",
                exampleInput = "topla(10, 20)",
                exampleOutput = "30",
                starterCode = "function topla(a, b) {\n    // Kodunu yaz:\n    return 0;\n}",
                solutionCode = "function topla(a, b) {\n    return a + b;\n}",
                hints = listOf("return a + b; yazın."),
                testCases = listOf(
                    TestCase("topla(10, 20)", "30", "İki pozitif sayıyı toplama")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_1_1",
                    lessonId = "js_1",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "JavaScript'te metinlerin içine değişken yerleştirmek için hangi tırnak işareti kullanılır?",
                    options = listOf("` (Backtick / Ters Tırnak)", "' (Tek Tırnak)", "\" (Çift Tırnak)", "# (Diyez)"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! ` \${değişken} ` şablon dizgileri için ters tırnak (backtick) kullanılır.",
                    explanationWrong = "Ters tırnak (backtick `) kullanılır.",
                    reviewTopic = "JavaScript Değişkenler"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Neden artık 'var' kullanmıyoruz?",
                    answer = "var eski bir JavaScript yapısıdır ve kapsam (scope) karmaşasına yol açar. Modern JavaScript'te let ve const kullanılır."
                )
            ),
            completionCriteria = listOf(
                "console.log() ve ters tırnak şablonlarını bilmek",
                "let ve const farkını kavramak"
            )
        ),

        // ==========================================
        // DERS 2: KOŞULLAR VE DÖNGÜLER
        // ==========================================
        Lesson(
            id = "js_2",
            courseId = "javascript",
            sectionId = "js_sec_2",
            title = "Kararlar (if-else) ve Döngüler (for, while)",
            shortDesc = "Programınıza mantık katın: if-else koşulları ve for döngüleri.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false,
            learningObjectives = listOf(
                "if, else if ve else ile şart kontrolleri yapmak",
                "Üçlü eşitlik (===) ile kesin tip ve değer karşılaştırması",
                "for döngüsü ile tekrarlayan işlemleri otomatikleştirmek"
            ),
            prerequisites = listOf("JavaScript Temelleri"),
            subtopics = listOf("if / else", "=== Karşılaştırma", "for Döngüsü", "Ternary Operatörü (? :)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Karar Verme: if-else",
                    body = "Şart doğruysa bir kod bloğu, yanlışsa başka bir kod bloğu çalışır.\n\n⚠️ **İpucu:** JavaScript'te eşitlik kontrolü için daima `===` (üç eşittir) kullanın; bu hem değeri hem de tipi kontrol eder."
                ),
                LessonContentBlock(
                    subtitle = "2. for Döngüsü",
                    body = "Bir işlemi 5 kez yapmak için sayacı 0'dan 5'e kadar saydırırız.",
                    codeSnippet = "let puan = 85;\n\nif (puan >= 90) {\n    console.log('Pekiyi! 🌟');\n} else if (puan >= 70) {\n    console.log('İyi! 👍');\n} else {\n    console.log('Çalışmalısın! 📚');\n}\n\n// 1'den 5'e kadar sayalım:\nfor (let i = 1; i <= 5; i++) {\n    console.log(`Adım: \${i}`);\n}"
                )
            ),
            codeExample = "let toplam = 0;\nfor (let i = 1; i <= 5; i++) {\n    toplam += i;\n}\nconsole.log(`1-5 arası toplam: \${toplam}`); // 15",
            codeExplanation = "for döngüsü 5 tur döndü ve toplam değişkenine her turdaki sayıyı ekledi.",
            realWorldExample = "Kullanıcı şifresini kontrol ederken 'şifre 6 karakterden uzun mu?' kontrolü if-else ile yapılır.",
            practicalTask = "1'den 10'a kadar olan çift sayıları ekrana yazdıran bir for döngüsü kurun.",
            starterPlaygroundCode = "for (let i = 2; i <= 10; i += 2) {\n    console.log(i);\n}",
            miniQuestion = MiniQuestion(
                id = "js_q_2",
                question = "JavaScript'te hem değeri hem de veri tipini (örneğin 5 ile '5' arasındaki farkı) kontrol eden güvenli eşitlik operatörü hangisidir?",
                options = listOf("===", "==", "=", "!="),
                correctIndex = 0,
                explanation = "Üç eşittir (===) hem değerin hem de tipin tam uyuştuğunu doğrular."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_2",
                lessonId = "js_2",
                title = "Pozitif mi Negatif mi?",
                instructions = "sayi 0'dan büyükse 'Pozitif', küçükse 'Negatif', sıfır ise 'Sıfır' döndüren durumKontrol(sayi) fonksiyonunu yazın.",
                exampleInput = "durumKontrol(5)",
                exampleOutput = "\"Pozitif\"",
                starterCode = "function durumKontrol(sayi) {\n    // Kodunu yaz:\n    return \"\";\n}",
                solutionCode = "function durumKontrol(sayi) {\n    if (sayi > 0) return \"Pozitif\";\n    if (sayi < 0) return \"Negatif\";\n    return \"Sıfır\";\n}",
                hints = listOf("if (sayi > 0) return 'Pozitif'; else if (sayi < 0) return 'Negatif'; else return 'Sıfır'; yazın."),
                testCases = listOf(
                    TestCase("durumKontrol(5)", "Pozitif", "Pozitif sayı"),
                    TestCase("durumKontrol(-3)", "Negatif", "Negatif sayı"),
                    TestCase("durumKontrol(0)", "Sıfır", "Sıfır kontrolü")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_2_1",
                    lessonId = "js_2",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "5 === '5' ifadesinin sonucu nedir?",
                    options = listOf("false (Çünkü biri sayı diğeri metindir)", "true", "undefined", "Hata verir"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! 5 sayısı ile '5' metni tipleri farklı olduğu için === ile false döner.",
                    explanationWrong = "false döner çünkü tipleri farklıdır.",
                    reviewTopic = "JavaScript Eşitlik"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Ternary operatörü nedir?",
                    answer = "'koşul ? dogruysa : yanlissa' şeklinde tek satırda if-else yazmayı sağlayan pratik yapıdır."
                )
            ),
            completionCriteria = listOf(
                "if-else bloklarını doğru kurabilmek",
                "for döngüsü ile sayaç yönetebilmek"
            )
        ),

        // ==========================================
        // DERS 3: FONKSİYONLAR VE OK FONKSİYONLARI
        // ==========================================
        Lesson(
            id = "js_3",
            courseId = "javascript",
            sectionId = "js_sec_2",
            title = "Fonksiyonlar ve Ok Fonksiyonları (Arrow Functions)",
            shortDesc = "Kod tekrarını önleyin! Klasik fonksiyonlar ve modern ok fonksiyonları (() => {}).",
            level = CourseLevel.BEGINNER,
            order = 3,
            isPremium = false,
            learningObjectives = listOf(
                "function anahtar kelimesi ile fonksiyon tanımlamak",
                "Modern ok fonksiyonu (() => {}) sözdizimini öğrenmek",
                "return ile fonksiyondan sonuç döndürmek"
            ),
            prerequisites = listOf("Koşullar ve Döngüler"),
            subtopics = listOf("Klasik Fonksiyonlar", "Arrow Functions (() => {})", "Parametreler ve return"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Fonksiyon Nedir?",
                    body = "Fonksiyon, bir görevi yerine getiren ve istediğiniz zaman tekrar tekrar çağırabileceğiniz bir kod kutusudur."
                ),
                LessonContentBlock(
                    subtitle = "2. Modern Ok Fonksiyonları (Arrow Functions)",
                    body = "Modern JavaScript'te fonksiyonları çok daha kısa yazabiliriz: `const topla = (a, b) => a + b;`",
                    codeSnippet = "// 1. Klasik Fonksiyon:\nfunction selamVer(isim) {\n    return `Merhaba \${isim}!`;\n}\n\n// 2. Modern Ok Fonksiyonu:\nconst kareAl = (sayi) => sayi * sayi;\n\nconsole.log(selamVer('Ali')); // Merhaba Ali!\nconsole.log(kareAl(4));       // 16"
                )
            ),
            codeExample = "const indirimHesapla = (fiyat, oran) => fiyat - (fiyat * oran / 100);\nconsole.log(indirimHesapla(100, 20)); // 80",
            codeExplanation = "indirimHesapla ok fonksiyonu tek satırda hesaplama yapıp sonucu döndürdü.",
            realWorldExample = "Kullanıcı sepete ekle butonuna bastığında çalışan kod bir fonksiyondur.",
            practicalTask = "İki sayının çarpımını döndüren bir ok fonksiyonu yazın.",
            starterPlaygroundCode = "const carp = (a, b) => a * b;\nconsole.log(carp(3, 4));",
            miniQuestion = MiniQuestion(
                id = "js_q_3",
                question = "Aşağıdakilerden hangisi geçerli bir ok fonksiyonu (Arrow Function) tanımıdır?",
                options = listOf("const topla = (a, b) => a + b;", "function topla(a, b) -> a + b", "arrow topla(a, b) { a + b }", "def topla(a, b): a + b"),
                correctIndex = 0,
                explanation = "Ok fonksiyonları '(parametreler) => gövde' şeklinde tanımlanır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_3",
                lessonId = "js_3",
                title = "Küp Hesaplayıcı",
                instructions = "Parametre olarak gelen sayının küpünü (sayi * sayi * sayi) hesaplayıp döndüren kupAl(sayi) ok fonksiyonunu yazın.",
                exampleInput = "kupAl(3)",
                exampleOutput = "27",
                starterCode = "const kupAl = (sayi) => {\n    // Kodunu yaz:\n    return 0;\n};",
                solutionCode = "const kupAl = (sayi) => sayi * sayi * sayi;",
                hints = listOf("const kupAl = (sayi) => sayi * sayi * sayi; yazın."),
                testCases = listOf(
                    TestCase("kupAl(3)", "27", "3'ün küpü"),
                    TestCase("kupAl(2)", "8", "2'nin küpü")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_3_1",
                    lessonId = "js_3",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Ok fonksiyonlarında (Arrow Functions) tek bir ifade varsa süslü parantez ({ }) ve 'return' yazmaya gerek var mıdır?",
                    options = listOf("Hayır, doğrudan sonucu kendisi otomatik döndürür (Implicit Return)", "Evet, her zaman zorunludur", "Sadece sayılarda gerekir", "Hata verir"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Tek satırlık gövdelerde süslü parantez ve return yazılmazsa otomatik return edilir.",
                    explanationWrong = "Otomatik return eder.",
                    reviewTopic = "JavaScript Fonksiyonlar"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Varsayılan parametre (Default Parameter) nasıl verilir?",
                    answer = "const selam = (isim = 'Misafir') => `Selam \${isim}`; şeklinde parametreye varsayılan değer atanabilir."
                )
            ),
            completionCriteria = listOf(
                "Fonksiyon ve return kullanımını bilmek",
                "Ok fonksiyonu (() => {}) yazabilmek"
            )
        ),

        // ==========================================
        // DERS 4: DİZİLER VE NESNELER
        // ==========================================
        Lesson(
            id = "js_4",
            courseId = "javascript",
            sectionId = "js_sec_3",
            title = "Diziler (Arrays) ve Nesneler (Objects)",
            shortDesc = "Listeler [1, 2, 3], eleman ekleme (push), ve anahtar-değer nesneleri { ad: 'Ali' }.",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            isPremium = true,
            learningObjectives = listOf(
                "Dizi (Array) oluşturmak ve push/pop ile eleman yönetmek",
                "Nesne (Object) tanımlayarak karmaşık verileri gruplamak",
                "Nokta notasyonu (nesne.ozellik) ile verilere erişmek"
            ),
            prerequisites = listOf("Fonksiyonlar"),
            subtopics = listOf("Dizi Tanımlama []", "push() ve pop()", "Nesne Tanımlama {}", "Nokta ile Erişim"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Diziler (Arrays): Sıralı Listeler",
                    body = "Birden fazla veriyi tek bir kutuda sıralı tutmak için `[]` kullanırız. Listenin ilk elemanı `0` numaralı indekstir."
                ),
                LessonContentBlock(
                    subtitle = "2. Nesneler (Objects): Özellik Paketleri",
                    body = "Bir kullanıcının adını, yaşını ve adresini tek bir pakette anahtar-değer olarak saklamak için `{}` kullanılır.",
                    codeSnippet = "// 1. Dizi:\nconst meyveler = ['Elma', 'Muz', 'Çilek'];\nmeyveler.push('Portakal'); // Sona ekler\nconsole.log(meyveler[0]);  // 'Elma'\n\n// 2. Nesne:\nconst ogrenci = {\n    isim: 'Efe',\n    yas: 21,\n    aktif: true\n};\nconsole.log(`Öğrenci: \${ogrenci.isim}, Yaş: \${ogrenci.yas}`);"
                )
            ),
            codeExample = "const araba = { marka: 'Tesla', model: 'Model 3', hiz: 0 };\naraba.hiz = 120;\nconsole.log(araba.hiz); // 120",
            codeExplanation = "araba nesnesi oluşturuldu ve hız özelliği güncellendi.",
            realWorldExample = "Web sitelerinde bir kullanıcının profil bilgileri sunucudan nesne (JSON) olarak gelir.",
            practicalTask = "3 favori filminizi içeren bir dizi açıp ilk filmi ekrana yazdırın.",
            starterPlaygroundCode = "const filmler = ['Matrix', 'Yıldızlararası'];\nconsole.log(filmler[0]);",
            miniQuestion = MiniQuestion(
                id = "js_q_4",
                question = "JavaScript'te bir dizinin sonuna yeni bir eleman eklemek için hangi metot kullanılır?",
                options = listOf("push()", "add()", "append()", "insert()"),
                correctIndex = 0,
                explanation = "Dizi sonuna eleman eklemek için 'push()' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_4",
                lessonId = "js_4",
                title = "İlk Elemanı Al",
                instructions = "Gelen dizinin ilk elemanını (0. indeks) döndüren ilkEleman(dizi) fonksiyonunu yazın.",
                exampleInput = "ilkEleman(['A', 'B'])",
                exampleOutput = "\"A\"",
                starterCode = "const ilkEleman = (dizi) => {\n    // Kodunu yaz:\n    return null;\n};",
                solutionCode = "const ilkEleman = (dizi) => dizi[0];",
                hints = listOf("return dizi[0]; yazın."),
                testCases = listOf(
                    TestCase("ilkEleman(['JS', 'Python'])", "JS", "İlk eleman testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_4_1",
                    lessonId = "js_4",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir dizideki toplam eleman sayısını öğrenmek için hangi özellik kullanılır?",
                    options = listOf("dizi.length", "dizi.count", "dizi.size()", "dizi.len()"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Eleman sayısı için .length özelliği kullanılır.",
                    explanationWrong = "dizi.length kullanılır.",
                    reviewTopic = "JavaScript Diziler"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "pop() ne işe yarar?",
                    answer = "Dizinin en sonundaki elemanı çıkarır ve onu geri döndürür."
                )
            ),
            completionCriteria = listOf(
                "Dizi ve nesne oluşturabilmek",
                "push/pop ve nokta notasyonunu bilmek"
            )
        ),

        // ==========================================
        // DERS 5: MAP, FILTER, REDUCE
        // ==========================================
        Lesson(
            id = "js_5",
            courseId = "javascript",
            sectionId = "js_sec_4",
            title = "Dizi Metotları: map, filter, reduce",
            shortDesc = "Döngü yazmadan listeleri dönüştürün (map), süzün (filter) ve özetleyin (reduce).",
            level = CourseLevel.INTERMEDIATE,
            order = 5,
            isPremium = true,
            learningObjectives = listOf(
                "map() ile tüm liste elemanlarını dönüştürmek",
                "filter() ile belirli şarta uyanları seçmek",
                "reduce() ile liste toplamı veya özeti çıkarmak"
            ),
            prerequisites = listOf("Diziler ve Ok Fonksiyonları"),
            subtopics = listOf("map() Dönüşümü", "filter() Süzgeci", "reduce() İndirgemesi"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Modern Dizi Operasyonları",
                    body = "Eski usul for döngüsü yazmak yerine tek satırda listeler üzerinde işlem yaparız:\n\n• `map()`: Listedeki herkese aynı işlemi uygular ve yeni liste döner.\n• `filter()`: Şartı sağlayanları süzer.\n• `reduce()`: Tüm listeyi tek bir sayıya/değere indirger."
                ),
                LessonContentBlock(
                    subtitle = "2. Örnek Kullanım",
                    body = "Sayıları filtreleyip ikiyle çarpalım:",
                    codeSnippet = "const sayilar = [1, 2, 3, 4, 5, 6];\n\n// 1. Çift olanları süz:\nconst ciftler = sayilar.filter(x => x % 2 === 0); // [2, 4, 6]\n\n// 2. İki katını al:\nconst ikiKat = ciftler.map(x => x * 2); // [4, 8, 12]\n\n// 3. Hepsini topla:\nconst toplam = sayilar.reduce((top, sayi) => top + sayi, 0); // 21"
                )
            ),
            codeExample = "const fiyatlar = [100, 200, 300];\nconst kdvli = fiyatlar.map(f => f * 1.20);\nconsole.log(kdvli); // [120, 240, 360]",
            codeExplanation = "map fonksiyonu her fiyata %20 KDV ekledi.",
            realWorldExample = "Bir e-ticaret sitesinde ürünleri 'Fiyatı 500 TL altı' diye filtrelemek filter() ile yapılır.",
            practicalTask = "[1, 2, 3, 4] dizisindeki sayıları map ile 10 ile çarpın.",
            starterPlaygroundCode = "const liste = [1, 2, 3];\nconst carpilmis = liste.map(x => x * 10);\nconsole.log(carpilmis);",
            miniQuestion = MiniQuestion(
                id = "js_q_5",
                question = "Bir listedeki sadece belirli bir koşula uyan elemanları seçip yeni bir liste oluşturmak için hangi dizi metodu kullanılır?",
                options = listOf("filter()", "map()", "reduce()", "find()"),
                correctIndex = 0,
                explanation = "Koşula göre süzme işlemi için 'filter()' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_5",
                lessonId = "js_5",
                title = "Çift Sayıları Bul",
                instructions = "Verilen sayı dizisindeki sadece çift sayıları (x % 2 === 0) filtreleyip döndüren ciftleriBul(liste) fonksiyonunu yazın.",
                exampleInput = "ciftleriBul([1, 2, 3, 4, 5, 6])",
                exampleOutput = "[2, 4, 6]",
                starterCode = "const ciftleriBul = (liste) => {\n    // filter kullan:\n    return [];\n};",
                solutionCode = "const ciftleriBul = (liste) => liste.filter(x => x % 2 === 0);",
                hints = listOf("return liste.filter(x => x % 2 === 0); yazın."),
                testCases = listOf(
                    TestCase("ciftleriBul([1, 2, 3, 4, 5, 6])", "[2, 4, 6]", "Çift sayı süzme")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_5_1",
                    lessonId = "js_5",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "map() metodu orijinal diziyi değiştirir mi yoksa yeni bir dizi mi üretir?",
                    options = listOf("Orijinal diziye dokunmaz, tamamen yeni bir dizi üretir", "Orijinal diziyi bozar", "Diziyi siler", "Hata verir"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! map() saf bir fonksiyondur, orijinali koruyup yeni bir kopya döner.",
                    explanationWrong = "Yeni bir dizi üretir.",
                    reviewTopic = "JavaScript map Metodu"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "forEach ile map farkı nedir?",
                    answer = "map yeni bir dizi döndürür; forEach ise sadece döngü yapar geriye hiçbir şey döndürmez."
                )
            ),
            completionCriteria = listOf(
                "map ve filter kullanımını bilmek",
                "reduce mantığını kavramak"
            )
        ),

        // ==========================================
        // DERS 6: PARÇALAMA VE SPREAD
        // ==========================================
        Lesson(
            id = "js_6",
            courseId = "javascript",
            sectionId = "js_sec_4",
            title = "Destructuring (Parçalama) ve Spread (...) Operatörü",
            shortDesc = "Nesne ve dizileri tek satırda parçalara ayırma ve üç nokta (...) ile birleştirme.",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true,
            learningObjectives = listOf(
                "const { isim, yas } = kisi ile nesneleri kolayca parçalamak",
                "const [ilk, ikinci] = dizi ile dizileri açmak",
                "... (Spread) operatörü ile nesne ve dizileri klonlayıp birleştirmek"
            ),
            prerequisites = listOf("Diziler ve Nesneler"),
            subtopics = listOf("Object Destructuring", "Array Destructuring", "Spread (...) Operatörü"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Destructuring: Kutuyu Tek Hamlede Açmak",
                    body = "`kisi.isim`, `kisi.yas` yazmak yerine tek satırda değişkenlere atayabiliriz:",
                    codeSnippet = "const kisi = { isim: 'Mert', yas: 24, sehir: 'İzmir' };\n\n// Tek satırda çıkaralım:\nconst { isim, yas } = kisi;\nconsole.log(`İsim: \${isim}, Yaş: \${yas}`);"
                ),
                LessonContentBlock(
                    subtitle = "2. Spread (...) Operatörü",
                    body = "İki listeyi birleştirmek veya nesneyi kopyalayıp yeni özellik eklemek için `...` kullanırız.",
                    codeSnippet = "const dizi1 = [1, 2];\nconst dizi2 = [3, 4];\nconst hepsi = [...dizi1, ...dizi2]; // [1, 2, 3, 4]\n\nconst kullanici = { ad: 'Ali' };\nconst guncel = { ...kullanici, rol: 'Admin' }; // { ad: 'Ali', rol: 'Admin' }"
                )
            ),
            codeExample = "const [bir, iki] = ['Altın', 'Gümüş'];\nconsole.log(bir); // Altın",
            codeExplanation = "Dizi elemanları sıra ile değişkenlere atandı.",
            realWorldExample = "React ve Vue çatılarında Component props'ları daima Destructuring ({ prop1, prop2 }) ile karşılanır.",
            practicalTask = "Spread (...) ile iki diziyi birleştirin.",
            starterPlaygroundCode = "const a = [1, 2]; const b = [...a, 3]; console.log(b);",
            miniQuestion = MiniQuestion(
                id = "js_q_6",
                question = "JavaScript'te bir dizi veya nesnenin elemanlarını başka bir dizi veya nesneye yayarak kopyalamak için hangi operatör kullanılır?",
                options = listOf("... (Spread Operatörü)", "&&", "||", "::"),
                correctIndex = 0,
                explanation = "Yayma ve kopyalama için üç nokta '...' (Spread) operatörü kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_6",
                lessonId = "js_6",
                title = "İki Listeyi Birleştir",
                instructions = "Spread (...) operatörü kullanarak a ve b dizilerini tek bir dizi olarak birleştiren birlestir(a, b) fonksiyonunu yazın.",
                exampleInput = "birlestir([1, 2], [3, 4])",
                exampleOutput = "[1, 2, 3, 4]",
                starterCode = "const birlestir = (a, b) => {\n    // Spread kullan:\n    return [];\n};",
                solutionCode = "const birlestir = (a, b) => [...a, ...b];",
                hints = listOf("return [...a, ...b]; yazın."),
                testCases = listOf(
                    TestCase("birlestir([1, 2], [3, 4])", "[1, 2, 3, 4]", "Dizi birleştirme")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_6_1",
                    lessonId = "js_6",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "const { ad } = { ad: 'Can', yas: 20 } satırından sonra 'ad' değişkeninin değeri ne olur?",
                    options = listOf("'Can'", "undefined", "{ ad: 'Can' }", "Hata verir"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Destructuring nesnedeki 'ad' özelliğini doğrudan değişkene çıkardı.",
                    explanationWrong = "'Can' değerini alır.",
                    reviewTopic = "JavaScript Destructuring"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Rest parametresi nedir?",
                    answer = "Fonksiyonun alacağı belirsiz sayıdaki parametreleri tek bir dizide toplamak için yine '...parametreler' yazılır."
                )
            ),
            completionCriteria = listOf(
                "Destructuring ile nesne ve dizi açabilmek",
                "... Spread operatörünü kullanabilmek"
            )
        ),

        // ==========================================
        // DERS 7: SINIFLAR (CLASSES) VE OOP
        // ==========================================
        Lesson(
            id = "js_7",
            courseId = "javascript",
            sectionId = "js_sec_4",
            title = "Sınıflar (Classes) ve Nesne Yönelimli Programlama",
            shortDesc = "class şablonları, constructor kurucusu ve extends ile kalıtım almak.",
            level = CourseLevel.INTERMEDIATE,
            order = 7,
            isPremium = true,
            learningObjectives = listOf(
                "class SinifAdi { ... } şablonu oluşturmak",
                "constructor() ile nesne özelliklerini başlatmak",
                "extends ile bir sınıftan miras (kalıtım) almak"
            ),
            prerequisites = listOf("Nesneler ve Fonksiyonlar"),
            subtopics = listOf("class Tanımlama", "constructor()", "Metotlar", "extends Kalıtımı"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Sınıf (Class): Nesne Fabrikası",
                    body = "Bir fabrika kalıbı düşünün; araba üretmek için aynı şablonu kullanırız.",
                    codeSnippet = "class Oyuncu {\n    constructor(isim, seviye) {\n        this.isim = isim;\n        this.seviye = seviye;\n    }\n    \n    selamVer() {\n        console.log(`Kahraman \${this.isim}, Seviye: \${this.seviye}`);\n    }\n}\n\nconst p1 = new Oyuncu('Barbaros', 5);\np1.selamVer(); // Kahraman Barbaros, Seviye: 5"
                )
            ),
            codeExample = "class Araba {\n    constructor(marka) { this.marka = marka; }\n    calistir() { return `\${this.marka} çalıştı!`; }\n}\nconst a = new Araba('BMW');\nconsole.log(a.calistir());",
            codeExplanation = "Araba sınıfından new ile yeni bir nesne üretildi ve metodu çağrıldı.",
            realWorldExample = "Oyunlardaki karakterler, düşmanlar ve eşyalar Class yapıları ile modellenir.",
            practicalTask = "Basit bir Dikdortgen sınıfı açıp alan() metodunu yazın.",
            starterPlaygroundCode = "class Kisi {\n    constructor(ad) { this.ad = ad; }\n}",
            miniQuestion = MiniQuestion(
                id = "js_q_7",
                question = "JavaScript'te bir sınıftan yeni bir nesne örneği (instance) üretmek için sınıf adının önüne hangi anahtar kelime yazılır?",
                options = listOf("new", "create", "make", "build"),
                correctIndex = 0,
                explanation = "Yeni nesne üretmek için 'new SinifAdi()' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_7",
                lessonId = "js_7",
                title = "Kare Sınıfı",
                instructions = "kenar alanını alan constructor'a ve alan() metoduna sahip Kare sınıfını yazın.",
                exampleInput = "const k = new Kare(5); k.alan()",
                exampleOutput = "25",
                starterCode = "class Kare {\n    constructor(kenar) {\n        // Kodunu yaz:\n    }\n    \n    alan() {\n        return 0;\n    }\n}",
                solutionCode = "class Kare {\n    constructor(kenar) {\n        this.kenar = kenar;\n    }\n    alan() {\n        return this.kenar * this.kenar;\n    }\n}",
                hints = listOf("this.kenar = kenar; ve return this.kenar * this.kenar; yazın."),
                testCases = listOf(
                    TestCase("new Kare(5).alan()", "25", "Kare alanı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_7_1",
                    lessonId = "js_7",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir sınıfın başka bir sınıfın özelliklerini ve metotlarını miras alması için hangi kelime kullanılır?",
                    options = listOf("extends", "implements", "inherits", "super"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Sınıf kalıtımı için 'class Kedi extends Hayvan' şeklinde 'extends' kullanılır.",
                    explanationWrong = "extends kullanılır.",
                    reviewTopic = "JavaScript Kalıtım"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "super() ne işe yarar?",
                    answer = "Miras alınan üst sınıfın constructor'ını çalıştırmak için çağrılır."
                )
            ),
            completionCriteria = listOf(
                "class ve constructor yazabilmek",
                "new ile nesne türetebilmek"
            )
        ),

        // ==========================================
        // DERS 8: ASENKRON JS VE PROMISES
        // ==========================================
        Lesson(
            id = "js_8",
            courseId = "javascript",
            sectionId = "js_sec_5",
            title = "Asenkron JavaScript ve Promises (Sözler)",
            shortDesc = "Sayfayı dondurmadan arka planda iş yapma: setTimeout ve Promise (.then / .catch).",
            level = CourseLevel.ADVANCED,
            order = 8,
            isPremium = true,
            learningObjectives = listOf(
                "Senkron vs Asenkron farkını kavramak (Tek iş parçacıklı JS)",
                "setTimeout ile zaman ayarlı işlemler yapmak",
                "Promise nesnesinin 3 durumunu (Pending, Fulfilled, Rejected) öğrenmek"
            ),
            prerequisites = listOf("Fonksiyonlar ve Nesneler"),
            subtopics = listOf("Asenkron Mantığı", "setTimeout()", "Promise Yapısı", ".then() ve .catch()"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Neden Asenkron?",
                    body = "İnternetten büyük bir resim inerken tüm web sitesi donup kalsaydı hiçbir kullanıcı sitede durmazdı. Asenkron kod, arka planda veri inerken sayfanın akmaya devam etmesini sağlar."
                ),
                LessonContentBlock(
                    subtitle = "2. Promise (Söz): Gelecekte Gelecek Veri",
                    body = "Bir Promise size şunu söyler: 'Ben bu veriyi getireceğim, bitince .then() ile sana teslim ederim; hata olursa .catch() ile yakalarsın.'",
                    codeSnippet = "console.log('1. Sipariş verildi');\n\nsetTimeout(() => {\n    console.log('2. Pizza teslim edildi! 🍕 (2 saniye sonra)');\n}, 2000);\n\nconsole.log('3. Masa hazırlanıyor...');"
                )
            ),
            codeExample = "const soz = new Promise((resolve) => resolve('Başarılı!'));\nsoz.then(mesaj => console.log(mesaj));",
            codeExplanation = "Promise tamamlandığında .then bloğu çalıştı.",
            realWorldExample = "Instagram'da akış aşağı kaydırıldığında yeni fotoğraflar arkadan asenkron olarak yüklenir.",
            practicalTask = "1 saniye sonra ekrana mesaj basan bir setTimeout yazın.",
            starterPlaygroundCode = "setTimeout(() => console.log('Süre doldu!'), 1000);",
            miniQuestion = MiniQuestion(
                id = "js_q_8",
                question = "Başarıyla tamamlanan bir Promise'in ürettiği veriyi yakalamak için hangi fonksiyon zincirlenir?",
                options = listOf(".then()", ".catch()", ".finally()", ".done()"),
                correctIndex = 0,
                explanation = "Başarılı sonuçlar '.then()' ile yakalanır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_8",
                lessonId = "js_8",
                title = "Hazır Promise",
                instructions = "İçinde 'Hazır' metni olan çözülmüş (resolved) bir Promise döndüren hazirPromise() fonksiyonunu yazın.",
                exampleInput = "hazirPromise().then(x => console.log(x))",
                exampleOutput = "\"Hazır\"",
                starterCode = "const hazirPromise = () => {\n    // Promise.resolve kullan:\n    return null;\n};",
                solutionCode = "const hazirPromise = () => Promise.resolve(\"Hazır\");",
                hints = listOf("return Promise.resolve('Hazır'); yazın."),
                testCases = listOf(
                    TestCase("hazirPromise()", "[object Promise]", "Promise testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_8_1",
                    lessonId = "js_8",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir Promise işleminde hata meydana geldiğinde hatayı yakalamak için ne kullanılır?",
                    options = listOf(".catch()", ".then()", ".error()", ".stop()"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Hatalar .catch() bloğu ile yakalanır.",
                    explanationWrong = ".catch() kullanılır.",
                    reviewTopic = "JavaScript Promises"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Event Loop nedir?",
                    answer = "JavaScript'in tek çekirdekte asenkron işleri ve zamanlayıcıları sırayla yöneten arka plan motorudur."
                )
            ),
            completionCriteria = listOf(
                "Asenkron programlama amacını bilmek",
                "Promise, .then ve .catch yapısını kavramak"
            )
        ),

        // ==========================================
        // DERS 9: ASYNC / AWAIT VE FETCH
        // ==========================================
        Lesson(
            id = "js_9",
            courseId = "javascript",
            sectionId = "js_sec_5",
            title = "Modern Asenkron: async / await ve fetch() API",
            shortDesc = "Asenkron kodları düz senkron kod gibi yazın: async/await ve internetten veri çekme.",
            level = CourseLevel.ADVANCED,
            order = 9,
            isPremium = true,
            learningObjectives = listOf(
                "async anahtar kelimesi ile asenkron fonksiyon tanımlamak",
                "await ile Promise sonucunu tek satırda beklemek",
                "fetch() ile internetteki bir REST API'den veri çekmek"
            ),
            prerequisites = listOf("Promises ve Asenkron JS"),
            subtopics = listOf("async Anahtarı", "await ile Bekleme", "fetch() ile API Çağrısı", "try / catch"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. async / await: Temiz Asenkron Kod",
                    body = "Artık karmaşık `.then().then()` zincirlerine gerek yok! Bir fonksiyonun başına `async`, bekleyeceğiniz işlemin başına `await` yazmanız yeterlidir.",
                    codeSnippet = "async function havaDurumuGetir() {\n    try {\n        const yanit = await fetch('https://api.ornek.com/hava');\n        const veri = await yanit.json();\n        console.log(`Sıcaklık: \${veri.derece}°C`);\n    } catch (hata) {\n        console.log('Hava durumu alınamadı:', hata);\n    }\n}"
                )
            ),
            codeExample = "const bekle = () => new Promise(r => setTimeout(r, 1000));\nasync function test() {\n    console.log('Başladı');\n    await bekle();\n    console.log('1 saniye sonra bitti!');\n}",
            codeExplanation = "await fonksiyonun tamamlanmasını düz bir satır gibi bekledi.",
            realWorldExample = "Kripto para fiyatlarını veya hava durumu bilgisini anlık gösteren tüm web siteleri fetch ve async/await ile çalışır.",
            practicalTask = "async bir fonksiyon açıp içine await ekleyin.",
            starterPlaygroundCode = "async function selam() { return 'Merhaba'; }",
            miniQuestion = MiniQuestion(
                id = "js_q_9",
                question = "JavaScript'te 'await' anahtar kelimesi sadece hangi tür fonksiyonların içinde kullanılabilir?",
                options = listOf("Başına 'async' eklenmiş fonksiyonların içinde", "Tüm klasik fonksiyonlarda", "Sadece sınıflarda", "Döngülerin içinde"),
                correctIndex = 0,
                explanation = "await komutu yalnızca 'async' fonksiyonlar içinde geçerlidir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_9",
                lessonId = "js_9",
                title = "Asenkron Toplayıcı",
                instructions = "a ve b sayılarını toplayıp Promise olarak döndüren async toplaAsync(a, b) fonksiyonunu yazın.",
                exampleInput = "await toplaAsync(10, 20)",
                exampleOutput = "30",
                starterCode = "async function toplaAsync(a, b) {\n    // Kodunu yaz:\n    return 0;\n}",
                solutionCode = "async function toplaAsync(a, b) {\n    return a + b;\n}",
                hints = listOf("return a + b; yazın (async fonksiyon otomatik Promise döner)."),
                testCases = listOf(
                    TestCase("await toplaAsync(10, 20)", "30", "Asenkron toplam")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_9_1",
                    lessonId = "js_9",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "async/await yapısında internet kopması gibi hataları güvenle yakalamak için hangi blok kullanılır?",
                    options = listOf("try ... catch", "if ... else", "error ... handle", "catch ... only"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Hataları yakalamak için try/catch kullanılır.",
                    explanationWrong = "try/catch kullanılır.",
                    reviewTopic = "JavaScript async/await"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "response.json() neden await edilir?",
                    answer = "Çünkü internetten gelen veri akışının JSON nesnesine dönüştürülmesi de asenkron bir işlemdir."
                )
            ),
            completionCriteria = listOf(
                "async ve await kullanımını bilmek",
                "try-catch ile asenkron hataları yakalayabilmek"
            )
        ),

        // ==========================================
        // DERS 10: DOM YÖNETİMİ VE OLAYLAR
        // ==========================================
        Lesson(
            id = "js_10",
            courseId = "javascript",
            sectionId = "js_sec_6",
            title = "DOM Yönetimi ve Olay Dinleyicileri (Events)",
            shortDesc = "Sayfadaki butonları, yazıları ve formları canlı canlı kontrol edin: document.querySelector.",
            level = CourseLevel.ADVANCED,
            order = 10,
            isPremium = true,
            learningObjectives = listOf(
                "document.querySelector ile HTML elemanlarını seçmek",
                "addEventListener('click', ...) ile buton tıklamalarını dinlemek",
                "textContent ve style ile sayfayı dinamik güncellemek"
            ),
            prerequisites = listOf("async/await ve Fonksiyonlar"),
            subtopics = listOf("DOM Nedir?", "querySelector()", "addEventListener()", "Stil ve Metin Değiştirme"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. DOM: Sayfayı Canlandırma Köprüsü",
                    body = "Tarayıcı HTML sayfasını bir ağaç yapısına (**DOM**) çevirir. JavaScript ile bu ağaçtaki istediğimiz düğümü seçip rengini, yazısını veya konumunu anında değiştirebiliriz!"
                ),
                LessonContentBlock(
                    subtitle = "2. Butona Tıklama Olayı",
                    body = "addEventListener ile kullanıcı etkileşimlerini yakalarız:",
                    codeSnippet = "// 1. Butonu seç:\nconst buton = document.querySelector('#girisButonu');\nconst baslik = document.querySelector('h1');\n\n// 2. Tıklanınca çalışacak kod:\nbuton.addEventListener('click', () => {\n    baslik.textContent = 'Hoş Geldiniz! 🎉';\n    baslik.style.color = 'green';\n});"
                )
            ),
            codeExample = "const kutu = document.querySelector('.kutu');\nkutu.classList.add('aktif');",
            codeExplanation = "kutu elemanına yeni bir CSS sınıfı eklendi.",
            realWorldExample = "Gece Modu (Dark Mode) butonuna basıldığında sayfanın arka planının siyah olması DOM ile yapılır.",
            practicalTask = "Basit bir tıklama olayı dinleyicisini inceleyin.",
            starterPlaygroundCode = "// Butona tıklama:\n// buton.addEventListener('click', () => alert('Tıklandı!'));",
            miniQuestion = MiniQuestion(
                id = "js_q_10",
                question = "HTML sayfasındaki bir butona tıklama olayı (Click Event) eklemek için hangi metot kullanılır?",
                options = listOf("addEventListener('click', fonksiyon)", "onClick('click')", "attachEvent()", "listen()"),
                correctIndex = 0,
                explanation = "Olay dinleyicisi eklemek için 'addEventListener()' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_10",
                lessonId = "js_10",
                title = "Başlık Metni Değiştirici",
                instructions = "Gelen baslik DOM elemanının metnini (baslik.textContent) 'Tamamlandı' yapan baslikGuncelle(baslik) fonksiyonunu yazın.",
                exampleInput = "baslikGuncelle(el)",
                exampleOutput = "baslik.textContent = \"Tamamlandı\"",
                starterCode = "const baslikGuncelle = (baslik) => {\n    // Kodunu yaz:\n};",
                solutionCode = "const baslikGuncelle = (baslik) => {\n    baslik.textContent = \"Tamamlandı\";\n};",
                hints = listOf("baslik.textContent = 'Tamamlandı'; yazın."),
                testCases = listOf(
                    TestCase("const b = {}; baslikGuncelle(b); b.textContent", "Tamamlandı", "DOM güncelleme")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_10_1",
                    lessonId = "js_10",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "document.querySelector('#giris') ifadesindeki '#' işareti neyi ifade eder?",
                    options = listOf("id özelliği 'giris' olan elemanı seçtiğini", "class özelliği 'giris' olanı", "Tüm butonları", "Yorum satırını"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! '#' id seçicisi, '.' ise class seçicisidir.",
                    explanationWrong = "id seçicisidir.",
                    reviewTopic = "JavaScript DOM"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "e.preventDefault() ne işe yarar?",
                    answer = "Form gönderildiğinde sayfanın baştan yenilenmesini engelleyerek akıcı tek sayfa (SPA) deneyimi sunar."
                )
            ),
            completionCriteria = listOf(
                "DOM seçim metotlarını bilmek",
                "addEventListener ile olay yakalayabilmek"
            )
        ),

        // ==========================================
        // DERS 11: MODÜLLER (IMPORT / EXPORT)
        // ==========================================
        Lesson(
            id = "js_11",
            courseId = "javascript",
            sectionId = "js_sec_6",
            title = "ES Modülleri: import ve export",
            shortDesc = "Büyük projeleri küçük dosyalara bölün: export ile dışa aktarın, import ile kullanın.",
            level = CourseLevel.ADVANCED,
            order = 11,
            isPremium = true,
            learningObjectives = listOf(
                "export const topla = ... ile fonksiyonları dışa açmak",
                "import { topla } from './matematik.js' ile modül yüklemek",
                "export default ile varsayılan dışa aktarım yapmak"
            ),
            prerequisites = listOf("DOM ve Fonksiyonlar"),
            subtopics = listOf("Modül Nedir?", "İsimli Dışa Aktarma (export)", "Varsayılan (export default)", "import Sözdizimi"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Temiz Mimari: Dosyalara Bölmek",
                    body = "Binlerce satır kodu tek dosyaya yazmak yerine matematik, kullanıcı, sepet gibi ayrı dosyalara böler ve `import` ile çağırırız.",
                    codeSnippet = "// 📁 matematik.js dosyası:\nexport const topla = (a, b) => a + b;\nexport const carp = (a, b) => a * b;\n\n// 📁 app.js dosyası:\nimport { topla, carp } from './matematik.js';\n\nconsole.log(topla(5, 3)); // 8"
                )
            ),
            codeExample = "// Varsayılan modül:\n// export default class Kullanici { ... }\n// import Kullanici from './Kullanici.js';",
            codeExplanation = "export default ile dosyanın ana içeriği dışa aktarıldı.",
            realWorldExample = "React ve Node.js projelerindeki tüm bileşenler ve kütüphaneler import / export ile bağlanır.",
            practicalTask = "import ve export sözdizimini inceleyin.",
            starterPlaygroundCode = "// export const pi = 3.14;\n// import { pi } from './sabitler.js';",
            miniQuestion = MiniQuestion(
                id = "js_q_11",
                question = "JavaScript'te bir dosyadan bir fonksiyonu diğer dosyaların kullanımına açmak için başına hangi kelime yazılır?",
                options = listOf("export", "import", "public", "share"),
                correctIndex = 0,
                explanation = "Dışa aktarmak için 'export' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_11",
                lessonId = "js_11",
                title = "Modül Nesnesi",
                instructions = "versiyon: '1.0' ve yazar: 'Akademi' alanlarına sahip bir modül nesnesi döndüren modulOlustur() fonksiyonunu yazın.",
                exampleInput = "modulOlustur()",
                exampleOutput = "{ versiyon: \"1.0\", yazar: \"Akademi\" }",
                starterCode = "const modulOlustur = () => {\n    // Kodunu yaz:\n    return {};\n};",
                solutionCode = "const modulOlustur = () => ({\n    versiyon: \"1.0\",\n    yazar: \"Akademi\"\n});",
                hints = listOf("return { versiyon: '1.0', yazar: 'Akademi' }; yazın."),
                testCases = listOf(
                    TestCase("modulOlustur().versiyon", "1.0", "Modül versiyonu")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_11_1",
                    lessonId = "js_11",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir JavaScript dosyasında kaç tane 'export default' bulunabilir?",
                    options = listOf("Sadece 1 tane", "İstenildiği kadar", "En fazla 5", "Hiç bulunamaz"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Her dosyada sadece 1 adet varsayılan (default) export olabilir.",
                    explanationWrong = "Sadece 1 tane bulunabilir.",
                    reviewTopic = "JavaScript Modüller"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "HTML'de ES modülü kullanmak için script etiketine ne eklenir?",
                    answer = "<script type=\"module\" src=\"app.js\"></script> yazılır."
                )
            ),
            completionCriteria = listOf(
                "import ve export kullanımını bilmek",
                "Modüler dosya yapısını kavramak"
            )
        ),

        // ==========================================
        // DERS 12: JAVASCRIPT USTALIĞI VE GELECEK
        // ==========================================
        Lesson(
            id = "js_12",
            courseId = "javascript",
            sectionId = "js_sec_6",
            title = "JavaScript Ustalığı: Modern Ekosistem ve Gelecek",
            shortDesc = "React, Node.js, TypeScript ve milyarlarca cihaza güç veren JavaScript krallığı.",
            level = CourseLevel.EXPERT,
            order = 12,
            isPremium = true,
            learningObjectives = listOf(
                "Modern JS ekosistemini (React, Vue, Next.js, Node.js) kavramak",
                "TypeScript'in neden bu kadar popüler olduğunu anlamak",
                "Tebrikler: Artık modern web dünyasına hazır bir JavaScript geliştiricisisiniz!"
            ),
            prerequisites = listOf("Tüm JavaScript Konuları"),
            subtopics = listOf("Frontend Frameworkleri (React/Vue)", "Backend (Node.js)", "TypeScript Dünyası", "Tebrikler!"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Tebrikler! JavaScript Yolculuğunu Tamamladınız! 🌐🏆",
                    body = "Artık temel sözdiziminden asenkron async/await mimarisine, dizi metotlarından modern modül yapısına kadar JavaScript'in tüm kalbine hakimsiniz.\n\nBu temelle React ile mobil/web arayüzleri yazabilir, Node.js ile backend sunucuları kurabilir veya TypeScript ile devasa kurumsal projeler inşa edebilirsiniz!"
                )
            ),
            codeExample = "// Artık bir JavaScript Uzmanısınız!\nconsole.log('Tebrikler! JS Seviyeniz: USTA! 🚀✨');",
            codeExplanation = "JavaScript yolculuğunuz başarıyla tamamlandı.",
            realWorldExample = "Netflix, Facebook, Uber ve Spotify'ın tamamı bu JavaScript temelleri üzerinde çalışmaktadır.",
            practicalTask = "JavaScript başarılarınızı kutlayın!",
            starterPlaygroundCode = "// Harika bir JavaScript geliştiricisisiniz!",
            miniQuestion = MiniQuestion(
                id = "js_q_12",
                question = "JavaScript'e statik tip güvenliği (Type Safety) ekleyerek büyük projelerde hataları önleyen popüler üst-dil hangisidir?",
                options = listOf("TypeScript", "CoffeeScript", "ActionScript", "PureScript"),
                correctIndex = 0,
                explanation = "JavaScript'e tip güvenliği kazandıran dil TypeScript'tir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_12",
                lessonId = "js_12",
                title = "Şampiyon Mesajı",
                instructions = "Üstünde 'JavaScript Şampiyonu' yazan bir string döndüren sampiyon() fonksiyonunu yazın.",
                exampleInput = "sampiyon()",
                exampleOutput = "\"JavaScript Şampiyonu\"",
                starterCode = "const sampiyon = () => {\n    // Kodunu yaz:\n    return \"\";\n};",
                solutionCode = "const sampiyon = () => \"JavaScript Şampiyonu\";",
                hints = listOf("return 'JavaScript Şampiyonu'; yazın."),
                testCases = listOf(
                    TestCase("sampiyon()", "JavaScript Şampiyonu", "Şampiyonluk testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_12_1",
                    lessonId = "js_12",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "JavaScript dilinin uluslararası standart ismi nedir?",
                    options = listOf("ECMAScript (ES)", "JavaWeb", "ScriptX", "WebScript"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! JavaScript'in resmi standart adı ECMAScript'tir (ES6, ES2024 vb.).",
                    explanationWrong = "ECMAScript (ES)'tir.",
                    reviewTopic = "JavaScript Standartları"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Bundan sonra hangi teknolojiyi öğrenmeliyim?",
                    answer = "Frontend için React veya Vue; backend için Node.js ve Express; tip güvenliği için ise TypeScript harika bir sonraki adımdır."
                )
            ),
            completionCriteria = listOf(
                "JavaScript temellerine ve asenkron yapıya tam hakim olmak",
                "React veya Node.js öğrenmeye hazır hale gelmek"
            )
        )
    )
}
