package com.example.data.catalog

import com.example.model.*

/**
 * JavaScript Complete Official Curriculum (12 Sequential Lessons):
 * BEGINNER -> FUNDAMENTAL -> INTERMEDIATE -> ADVANCED -> EXPERT
 * Complete progression from ES6+ syntax to Async/Event Loop, Prototypes, Proxies, Web Workers & V8 Engine Internals.
 */
object JavaScriptCurriculum {

    fun getSections(): List<CourseSection> = listOf(
        CourseSection(
            id = "js_sec_1",
            courseId = "javascript",
            title = "Seviye 1 – JavaScript Temelleri, Değişkenler & Veri Tipleri",
            level = CourseLevel.BEGINNER,
            order = 1,
            description = "Modern JavaScript temelleri: let vs const vs var, Primitif Tipler, Type Coercion (Tip Zorlama), Şablon Dizgileri (Template Literals) ve Strict Mode.",
            learningObjectives = listOf("let, const ve var arasındaki kapsam (Scope) farkları", "Primitif (Number, String, Boolean, Symbol, BigInt) vs Referans tipler", "Type Coercion kuralları (== vs ===)", "Template Literals kullanımı"),
            prerequisites = listOf("Temel bilgisayar kullanım bilgisi")
        ),
        CourseSection(
            id = "js_sec_2",
            courseId = "javascript",
            title = "Seviye 2 – Kontrol Akışı, Fonksiyonlar & Arrow Functions",
            level = CourseLevel.BEGINNER,
            order = 2,
            description = "Koşullu yapılar (if/else, switch, Ternary), Döngüler (for, for...of, for...in), Fonksiyon Bildirimleri vs İfadeleri ve ES6 Arrow Functions.",
            learningObjectives = listOf("Ternary operatörü ve Short-circuiting (&&, ||, ??)", "for...of vs for...in farkı", "Arrow Functions ve lexical 'this' bağlamı", "Default parametreler ve Rest/Spread operatörü (...args)"),
            prerequisites = listOf("JavaScript Temelleri ve Değişkenler")
        ),
        CourseSection(
            id = "js_sec_3",
            courseId = "javascript",
            title = "Seviye 3 – Nesneler, Diziler & Fonksiyonel Dizi Metotları",
            level = CourseLevel.INTERMEDIATE,
            order = 3,
            description = "Object Literals, Destructuring (Dizi ve Nesne Parçalama), Spread/Rest, Yüksek Mertebeli Dizi Metotları (map, filter, reduce, some, every) ve JSON işlemleri.",
            learningObjectives = listOf("Object ve Array Destructuring desenleri", "map, filter, reduce ile saf (pure) veri dönüşümleri", "Shallow Copy (Sığ) vs Deep Copy (Derin Kopyalama: structuredClone)", "Optional Chaining (?.) ve Nullish Coalescing (??)"),
            prerequisites = listOf("Kontrol Akışı ve Fonksiyonlar")
        ),
        CourseSection(
            id = "js_sec_4",
            courseId = "javascript",
            title = "Seviye 4 – Kapsam (Scope), Closures & Nesne Yönelimli JS (Classes / Prototypes)",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            description = "Lexical Scope, Hoisting, Closures (Kapsülleme), Prototip Zinciri (__proto__, prototype) ve ES6 Class Mimarisi (extends, super, #private fields).",
            learningObjectives = listOf("Lexical Scope ve Hoisting mekanizması", "Closures ile özel veri saklama (Data Encapsulation)", "Prototype Chain ve Kalıtım mimarisi", "ES6 Sınıfları ve Özel (#) alanlar"),
            prerequisites = listOf("Nesneler ve Dizi Metotları")
        ),
        CourseSection(
            id = "js_sec_5",
            courseId = "javascript",
            title = "Seviye 5 – Asenkron JS: Promises, Async/Await & Event Loop",
            level = CourseLevel.ADVANCED,
            order = 5,
            description = "Asenkron JavaScript derinlikleri: Callback Hell çözümü, Promises (all, allSettled, race), Async/Await, Tarayıcı Event Loop, Microtasks (Promise) vs Macrotasks (setTimeout).",
            learningObjectives = listOf("Promise durumları (Pending, Fulfilled, Rejected)", "async/await ile senkron görünümlü asenkron kod", "Event Loop: Call Stack, Web APIs, Microtask vs Macrotask kuyrukları", "Fetch API ve AbortController ile istek iptali"),
            prerequisites = listOf("Scope, Closures ve Sınıflar")
        ),
        CourseSection(
            id = "js_sec_6",
            courseId = "javascript",
            title = "Seviye 6 – Uzman Seviye: Metaprogramming, Web Workers & V8 Motoru",
            level = CourseLevel.EXPERT,
            order = 6,
            description = "Proxy & Reflect ile meta-programlama ve reaktif veri bağlama, Web Workers & SharedArrayBuffer ile çoklu iş parçacığı, Bellek Yönetimi (Garbage Collection) ve V8 JIT Optimizasyonları.",
            learningObjectives = listOf("Proxy & Reflect ile reaktif durum yönetimi motoru kurma", "Web Workers ve SharedArrayBuffer ile paralel hesaplama", "V8 Engine Internals: Ignition Interpreter, TurboFan JIT Compiler ve Hidden Classes", "Memory Leaks tespiti ve WeakMap / WeakRef"),
            prerequisites = listOf("Asenkron JS ve Event Loop Mimarisi")
        )
    )

    fun getLessons(): List<Lesson> = listOf(
        // ==========================================
        // DERS 1: DEĞİŞKENLER, SCOPE & TEMPLATE LITERALS (ÜCRETSİZ)
        // ==========================================
        Lesson(
            id = "js_1",
            courseId = "javascript",
            sectionId = "js_sec_1",
            title = "JavaScript'e Giriş: let, const, Veri Tipleri & Template Literals",
            shortDesc = "Modern JS temelleri: let vs const vs var (Block vs Function Scope), Primitif Tipler, Tip Zorlama (Type Coercion: == vs ===) ve Şablon Dizgileri.",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false,
            learningObjectives = listOf(
                "let ve const kullanım kurallarını ve blok kapsamını (Block Scope) öğrenmek",
                "Primitif tipleri (Number, String, Boolean, null, undefined, Symbol, BigInt) ayırt etmek",
                "Strict Equality (===) ile güvenli karşılaştırma yapmak",
                "Template Literals ile çok satırlı dinamik metinler oluşturmak"
            ),
            prerequisites = listOf("Ön koşul gerekmez. Sıfırdan başlar."),
            subtopics = listOf("let & const vs var", "Primitif Veri Tipleri", "Strict Equality (===) vs (==)", "Template Literals", "typeof Operatörü"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. let, const ve var Farkı",
                    body = "• `const`: Değeri yeniden atanamaz (Re-assignment yapılamaz), blok kapsamlıdır (`{}`).\n• `let`: Değeri değiştirilebilir, blok kapsamlıdır.\n• `var`: Eski JS mirasıdır; blok kapsamını tanımaz, fonksiyon kapsamlıdır ve Hoisting nedeniyle hatalara yol açar. Modern JS'de asla kullanılmamalıdır.",
                    codeSnippet = "const pi = 3.14159;\nlet sayac = 0;\nsayac += 1; // Geçerli"
                ),
                LessonContentBlock(
                    subtitle = "2. Strict Equality (===) Neden Zorunludur?",
                    body = "`==` operatörü tipleri otomatik dönüştürür (Type Coercion) ve `\"0\" == false` gibi yanıltıcı sonuçlar üretir. `===` ise hem değeri hem de tipi kontrol eder.",
                    tip = "Daima `const` ile başlayın; yalnızca değeri değişmek zorunda olan değişkenler için `let` kullanın."
                )
            ),
            codeExample = "const kullanici = {\n    ad: \"Deniz\",\n    yas: 25,\n    diller: [\"JS\", \"Python\"]\n};\n\n// Template literal ile dinamik metin oluşturma:\nconst mesaj = \"Kullanıcı: \" + kullanici.ad + \", Yaş: \" + kullanici.yas + \", Diller: \" + kullanici.diller.join(\", \");\n\nconsole.log(mesaj);\nconsole.log(typeof kullanici.yas); // 'number'",
            codeExplanation = "const ile immutable referans tanımlandı, template literal değişkenleri okudu ve typeof veri tipini doğruladı.",
            realWorldExample = "Tüm modern frontend kütüphaneleri (React, Vue, Node.js) veri tanımlamalarında %100 oranında const ve let blok kapsamını kullanır.",
            practicalTask = "Adınızı ve yaşınızı iki değişkende tutup konsola bir karşılama metni yazdırın.",
            starterPlaygroundCode = "const ad = \"Ali\";\nconst yas = 20;\nconsole.log(\"Merhaba \" + ad + \", yaşın: \" + yas);",
            miniQuestion = MiniQuestion(
                id = "js_q_1",
                question = "JavaScript'te '0 == false' ve '0 === false' ifadelerinin sonuçları sırasıyla nedir?",
                options = listOf("true, true", "true, false", "false, false", "false, true"),
                correctIndex = 1,
                explanation = "== tip zorlaması (coercion) yaptığı için 0 ve false eşittir (true); === tip kontrolü de yaptığı için farklı tiptedir (false)."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_1",
                lessonId = "js_1",
                title = "Kullanıcı Karşılama Kartı",
                instructions = "ad ve rol parametrelerini alıp 'Kullanıcı: [ad] (Rol: [rol])' formatında metin döndüren karsila(ad, rol) fonksiyonunu yazın.",
                exampleInput = "karsila(\"Selin\", \"Admin\")",
                exampleOutput = "\"Kullanıcı: Selin (Rol: Admin)\"",
                starterCode = "function karsila(ad, rol) {\n    // Kodunu buraya yaz:\n    return \"\";\n}",
                solutionCode = "function karsila(ad, rol) {\n    return \"Kullanıcı: \" + ad + \" (Rol: \" + rol + \")\";\n}",
                hints = listOf("Metin birleştirme yapın."),
                testCases = listOf(
                    TestCase("karsila(\"Selin\", \"Admin\")", "Kullanıcı: Selin (Rol: Admin)", "Format testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_1_1",
                    lessonId = "js_1",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "JavaScript'te 'const' ile tanımlanmış bir nesnenin (Object) bir özelliğinin (property) değeri değiştirilebilir mi?",
                    options = listOf("Hayır, nesne tamamen kilitlenir", "Evet, const referansı korur; ancak nesnenin içindeki alanlar mutasyona uğrayabilir", "Sadece sayılar değiştirilebilir", "Derleme hatası verir"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! const referansın başka bir adrese atanmasını engeller; nesnenin içeriğini tamamen dondurmak için Object.freeze() gerekir.",
                    explanationWrong = "const referansı kilitler, iç alanlar değiştirilebilir.",
                    reviewTopic = "const & Object Mutability"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "null ile undefined arasındaki fark nedir?",
                    answer = "`undefined` bir değişkenin tanımlandığını ama henüz hiçbir değer atanmadığını belirtir (JS varsayılanı). `null` ise geliştirici tarafından bilinçli olarak 'değer yok / boş' anlamında atanan bir değerdir."
                )
            ),
            completionCriteria = listOf(
                "let, const ve var farkını bilmek",
                "=== ile kesin tip ve değer eşitliğini denetlemek",
                "Template Literals ile formatlı metin üretebilmek"
            )
        ),

        // ==========================================
        // DERS 2: KONTROL AKIŞI & ARROW FUNCTIONS (ÜCRETSİZ)
        // ==========================================
        Lesson(
            id = "js_2",
            courseId = "javascript",
            sectionId = "js_sec_1",
            title = "Kontrol Akışı, Döngüler & Arrow Functions (Lexical this)",
            shortDesc = "Kısa devre operatörleri (&&, ||, ??), for...of döngüleri, Fonksiyon Bildirimleri vs Arrow Functions ve kritik 'lexical this' farkı.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false,
            learningObjectives = listOf(
                "Nullish Coalescing (??) ile mantıksal OR (||) farkını kavramak",
                "for...of (değerler) ile for...in (anahtarlar) arasındaki ayrımı öğrenmek",
                "Arrow Functions sözdizimini ve 'this' bağlamını miras almasını (Lexical Scope) anlamak"
            ),
            prerequisites = listOf("JavaScript Temelleri ve Değişkenler"),
            subtopics = listOf("Nullish Coalescing (??)", "Ternary & Short-Circuit", "for...of vs for...in", "Arrow Functions Sözdizimi", "Lexical 'this' Davranışı"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Nullish Coalescing (??) vs OR (||)",
                    body = "`||` operatörü `0`, `\"\"`, `false` gibi falsy değerlerde de sağdaki yedeğe geçer. `??` ise YALNIZCA `null` veya `undefined` olduğunda yedeğe geçer; bu sayede `sayac = 0` değerini ezmez.",
                    codeSnippet = "const puan = 0;\nconst v1 = puan || 10; // 10 (Hatalı! 0'ı yok saydı)\nconst v2 = puan ?? 10; // 0 (Doğru!)"
                ),
                LessonContentBlock(
                    subtitle = "2. Arrow Functions ve Lexical this",
                    body = "Geleneksel fonksiyonlarda `this` fonksiyonun NASIL çağrıldığına bağlıdır. Arrow functions (`() => {}`) ise kendi `this` bağlamına sahip DEĞİLDİR; tanımlandığı çevreleyen kapsamın `this` değerini aynen kullanır.",
                    tip = "Nesne metotlarında geleneksel fonksiyon, callback ve dizi dönüşümlerinde ise daima arrow function tercih edin."
                )
            ),
            codeExample = "const sayilar = [10, 20, 30];\n\n// for...of ile elemanları gezme:\nfor (const sayi of sayilar) {\n    console.log(\"Eleman: \" + sayi);\n}\n\n// Arrow function ile tek satırlık çarpım:\nconst kareAl = x => x * x;\nconsole.log(\"Kare: \" + kareAl(5)); // 25",
            codeExplanation = "for...of elemanları doğrudan okudu; arrow function tek parametreli ve örtük dönüşlü (implicit return) olarak çalıştı.",
            realWorldExample = "React bileşenlerinde click handler veya callback tanımlarken 'this' bağlama hatalarını önlemek için arrow fonksiyonlar standarttır.",
            practicalTask = "Verilen bir dizi içindeki sayıların ortalamasını for...of döngüsü kullanarak hesaplayan bir kod yazın.",
            starterPlaygroundCode = "const topla = (a, b = 0) => a + b;\nconsole.log(topla(5, 7));",
            miniQuestion = MiniQuestion(
                id = "js_q_2",
                question = "Aşağıdaki operatörlerden hangisi solundaki değer SADECE 'null' veya 'undefined' olduğunda sağdaki varsayılan değeri döndürür?",
                options = listOf("|| (Mantıksal OR)", "?? (Nullish Coalescing)", "&& (Mantıksal AND)", "?: (Ternary)"),
                correctIndex = 1,
                explanation = "?? (Nullish Coalescing) yalnızca null ve undefined durumlarında tetiklenir; 0 veya \"\" gibi falsy değerleri korur."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_2",
                lessonId = "js_2",
                title = "Güvenli Değer Seçici (??)",
                instructions = "Gelen ayar objesinde 'ayar.limit' varsa onu, null veya undefined ise varsayılan 50 sayısını döndüren limitGetir(ayar) fonksiyonunu yazın.",
                exampleInput = "limitGetir({ limit: 0 })",
                exampleOutput = "0",
                starterCode = "function limitGetir(ayar) {\n    // Kodunu buraya yaz:\n    return 0;\n}",
                solutionCode = "function limitGetir(ayar) {\n    return ayar?.limit ?? 50;\n}",
                hints = listOf("ayar?.limit ?? 50 kullanın."),
                testCases = listOf(
                    TestCase("limitGetir({ limit: 0 })", "0", "0 korunmalı"),
                    TestCase("limitGetir({})", "50", "Varsayılan 50")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_2_1",
                    lessonId = "js_2",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Arrow fonksiyonlar (=>) ile klasik 'function' bildirimleri arasındaki en kritik mimari fark nedir?",
                    options = listOf("Arrow fonksiyonlar daha yavaştır", "Arrow fonksiyonlar kendi 'this', 'arguments' ve 'super' bağlamlarına sahip değildir; çevreleyen kapsamdan miras alırlar", "Arrow fonksiyonlar parametre alamaz", "Arrow fonksiyonlar asenkron çalışamaz"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Arrow fonksiyonlar lexical scoping ile 'this' bağlamını dışarıdan alır.",
                    explanationWrong = "Lexical this mekanizması en temel farktır.",
                    reviewTopic = "Lexical this in Arrow Functions"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "for...in ile for...of arasındaki fark nedir?",
                    answer = "`for...in` nesnelerin veya dizilerin anahtarları/indeksleri (keys) üzerinde döner. `for...of` ise yinelenebilir nesnelerin (Iterable: Array, Map, Set) doğrudan değerleri (values) üzerinde döner."
                )
            ),
            completionCriteria = listOf(
                "?? ile || arasındaki falsy farkını bilmek",
                "for...of döngüsünü kullanabilmek",
                "Arrow functions ve lexical this mantığını kavramak"
            )
        ),

        // ==========================================
        // DERS 3: DESTRUCTURING, REST/SPREAD & NESNELER
        // ==========================================
        Lesson(
            id = "js_3",
            courseId = "javascript",
            sectionId = "js_sec_2",
            title = "Nesneler, Destructuring, Rest & Spread Operatörü",
            shortDesc = "ES6+ veri parçalama: Array/Object Destructuring, Yeniden isimlendirme, Varsayılan değerler, Spread (...) ile kopyalama ve Rest parametreleri.",
            level = CourseLevel.BEGINNER,
            order = 3,
            isPremium = false,
            learningObjectives = listOf(
                "Nesne ve Dizi Destructuring ile temiz kod yazmak",
                "Destructuring sırasında yeniden isimlendirme ve varsayılan değer atamak",
                "Spread operatörü ile değişmez (immutable) nesne kopyalama ve birleştirme yapmak"
            ),
            prerequisites = listOf("Kontrol Akışı ve Arrow Functions"),
            subtopics = listOf("Object Destructuring", "Array Destructuring", "Destructuring Renaming & Defaults", "Spread Operatörü (...)", "Rest Parametreleri (...args)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Object Destructuring",
                    body = "Nesnelerin içindeki alanları doğrudan değişken olarak ayıklayabilir, yeniden isimlendirebilir ve varsayılan değer verebilirsiniz.",
                    codeSnippet = "const kisi = { ad: \"Can\", rol: \"Admin\" };\nconst { ad, rol: unvan, sehir = \"İstanbul\" } = kisi;\n// ad: 'Can', unvan: 'Admin', sehir: 'İstanbul'"
                ),
                LessonContentBlock(
                    subtitle = "2. Spread (...) ile Immutable Kopyalama",
                    body = "Mevcut bir nesneyi bozmadan yeni alanlar eklemek için Spread kullanılır (React State mantığı).",
                    codeSnippet = "const eskiState = { sayac: 1, yukleniyor: false };\nconst yeniState = { ...eskiState, yukleniyor: true };"
                )
            ),
            codeExample = "const kullanici = {\n    id: 101,\n    ad: \"Ece\",\n    iletisim: { email: \"ece@test.com\", tel: \"555-1234\" },\n    roller: [\"Kullanıcı\", \"Yazar\"]\n};\n\n// İç içe destructuring ve spread:\nconst { ad, iletisim: { email }, roller: [anaRol] } = kullanici;\nconst guncelKullanici = { ...kullanici, sonGiris: \"Bugün\" };\n\nconsole.log(\"Ad: \" + ad + \", Email: \" + email + \", Rol: \" + anaRol);\nconsole.log(guncelKullanici);",
            codeExplanation = "İç içe nesneden email ve diziden ilk rol tek satırda ayıklandı, spread ile orijinal nesne bozulmadan kopyalandı.",
            realWorldExample = "Redux ve React `useState` güncellemelerinde state nesnesini klonlamak için spread operatörü zorunludur.",
            practicalTask = "İki diziyi spread operatörü kullanarak tek bir sıralı dizide birleştiren bir kod yazın.",
            starterPlaygroundCode = "const [a, ...kalanlar] = [1, 2, 3, 4];\nconsole.log(a, kalanlar);",
            miniQuestion = MiniQuestion(
                id = "js_q_3",
                question = "Aşağıdaki 'const { ad: isim = \"Bilinmiyor\" } = {}' ifadesinde üretilen değişkenin adı ve değeri ne olur?",
                options = listOf("ad = 'Bilinmiyor'", "isim = 'Bilinmiyor'", "ad = undefined", "isim = undefined"),
                correctIndex = 1,
                explanation = "'ad: isim' alanı yeniden 'isim' olarak adlandırır; nesnede ad alanı olmadığı için varsayılan 'Bilinmiyor' değerini alır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_3",
                lessonId = "js_3",
                title = "Nesne Birleştirici (Spread)",
                instructions = "İki obje alan ve birinci objenin üzerine ikinci objeyi spread ile birleştirip döndüren objeleriBirlestir(o1, o2) fonksiyonunu yazın.",
                exampleInput = "objeleriBirlestir({ a: 1 }, { b: 2 })",
                exampleOutput = "{ a: 1, b: 2 }",
                starterCode = "function objeleriBirlestir(o1, o2) {\n    // Kodunu buraya yaz:\n    return {};\n}",
                solutionCode = "function objeleriBirlestir(o1, o2) {\n    return { ...o1, ...o2 };\n}",
                hints = listOf("return { ...o1, ...o2 };"),
                testCases = listOf(
                    TestCase("objeleriBirlestir({ a: 1 }, { b: 2 })", "Object", "Spread testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_3_1",
                    lessonId = "js_3",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "JavaScript'te bir fonksiyonun alacağı tüm argümanları bir dizi olarak toplayan sözdizimi hangisidir?",
                    options = listOf("arguments object", "Rest parametresi (...args)", "Spread parametresi", "Array.from()"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Fonksiyon tanımındaki '...args' gelen tüm ek parametreleri gerçek bir JavaScript dizisi olarak toplar.",
                    explanationWrong = "Rest parametresi (...args) kullanılır.",
                    reviewTopic = "Rest Parameters"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Spread (...) ile kopyalama Shallow Copy midir Deep Copy midir?",
                    answer = "Shallow Copy'dir (Sığ kopyalama). İlk seviyedeki primitif alanları kopyalar; ancak nesne içindeki iç içe alt nesnelerin referans adreslerini kopyalar. Tam derin kopyalama için modern `structuredClone(obj)` kullanılmalıdır."
                )
            ),
            completionCriteria = listOf(
                "Array ve Object Destructuring yapabilmek",
                "Destructuring'de varsayılan ve takma ad kullanımını bilmek",
                "Spread ve Rest operatörlerini doğru ayırt etmek"
            )
        ),

        // ==========================================
        // DERS 4: FONKSİYONEL DİZİ METOTLARI (MAP, FILTER, REDUCE)
        // ==========================================
        Lesson(
            id = "js_4",
            courseId = "javascript",
            sectionId = "js_sec_3",
            title = "Fonksiyonel Dizi Metotları: map, filter, reduce & flatMap",
            shortDesc = "Modern veri işleme: map, filter, reduce, find, some, every, flatMap ve method chaining ile deklaratif veri akışları.",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            isPremium = true,
            learningObjectives = listOf(
                "map, filter ve reduce ile dizileri mutasyona uğratmadan dönüştürmek",
                "reduce akümülatörü ile toplam, gruplama ve frekans tabloları oluşturmak",
                "flatMap ile iç içe dizileri tek hamlede düzleştirmek ve dönüştürmek"
            ),
            prerequisites = listOf("Destructuring ve Spread Operatörü"),
            subtopics = listOf("map (Dönüşüm)", "filter (Eleme)", "reduce (Akümülasyon)", "find & findIndex", "some & every", "flatMap"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. reduce: İsviçre Çakısı",
                    body = "`reduce((acc, cur) => ..., initialValue)` dizideki tüm elemanları tek bir değere (sayı, nesne veya yeni bir diziye) indirger.",
                    codeSnippet = "const sayilar = [10, 20, 30];\nconst toplam = sayilar.reduce((acc, curr) => acc + curr, 0); // 60"
                ),
                LessonContentBlock(
                    subtitle = "2. Zincirleme Metotlar (Method Chaining)",
                    body = "Fonksiyonel programlamada veriler for döngüleri yerine `data.filter(...).map(...).reduce(...)` zinciriyle işlenir.",
                    tip = "Dizi üzerinde arama yaparken ilk eşleşen elemanı bulmak için filter yerine `find` kullanın; ilk elemanı bulduğu an aramayı durdurur."
                )
            ),
            codeExample = "const urunler = [\n    { ad: \"Klavye\", fiyat: 500, kategori: \"Elektronik\" },\n    { ad: \"Mouse\", fiyat: 250, kategori: \"Elektronik\" },\n    { ad: \"Defter\", fiyat: 40, kategori: \"Kırtasiye\" }\n];\n\n// Elektronik ürünlerin toplam fiyatını hesaplayalım:\nconst elektronikToplam = urunler\n    .filter(u => u.kategori === \"Elektronik\")\n    .map(u => u.fiyat)\n    .reduce((toplam, f) => toplam + f, 0);\n\nconsole.log(\"Elektronik Toplam: \" + elektronikToplam + \" TL\");",
            codeExplanation = "filter kategoriyi eledi, map fiyatları çıkardı ve reduce toplam tutarı hesapladı.",
            realWorldExample = "E-ticaret sepet hesaplamalarında, analitik panellerde ve veri tablolarında reduce ve map zincirleri temel taştır.",
            practicalTask = "Bir kelime dizisindeki her kelimenin harf sayısını hesaplayan yeni bir dizi üretin.",
            starterPlaygroundCode = "const sayilar = [1, 2, 3, 4];\nconsole.log(sayilar.filter(x => x % 2 === 0));",
            miniQuestion = MiniQuestion(
                id = "js_q_4",
                question = "JavaScript'te 'every()' metodu dizi elemanları için ne zaman 'true' döner?",
                options = listOf("En az bir eleman koşulu sağladığında", "Dizideki TÜM elemanlar verilen test fonksiyonunu geçtiğinde", "Dizi boş olduğunda false döner", "İlk eleman true olduğunda"),
                correctIndex = 1,
                explanation = "every() dizideki istisnasız tüm elemanlar testi geçtiğinde true döner; bir tanesi bile bozarsa false döner."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_4",
                lessonId = "js_4",
                title = "Çift Sayıların Kareleri Toplamı",
                instructions = "Sayı dizisi alıp içindeki çift sayıların karelerini hesaplayıp toplamını döndüren ciftKarelerToplami(dizi) fonksiyonunu map, filter, reduce ile yazın.",
                exampleInput = "ciftKarelerToplami([1, 2, 3, 4])",
                exampleOutput = "20",
                starterCode = "function ciftKarelerToplami(dizi) {\n    // Kodunu buraya yaz:\n    return 0;\n}",
                solutionCode = "function ciftKarelerToplami(dizi) {\n    return dizi.filter(x => x % 2 === 0).map(x => x * x).reduce((a, b) => a + b, 0);\n}",
                hints = listOf("dizi.filter(x => x % 2 === 0).map(x => x * x).reduce((a, b) => a + b, 0)"),
                testCases = listOf(
                    TestCase("ciftKarelerToplami([1, 2, 3, 4])", "20", "2^2 + 4^2 = 20")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_4_1",
                    lessonId = "js_4",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Orijinal diziyi değiştirmeden (Pure Function kuralı) yeni bir dizi döndüren metot hangisidir?",
                    options = listOf("splice()", "sort()", "map()", "reverse()"),
                    correctOptionIndex = 2,
                    explanationRight = "Doğru! map(), filter() ve slice() orijinal diziyi koruyup yeni dizi üretir; splice ve sort orijinal diziyi bozar.",
                    explanationWrong = "map() saf fonksiyondur ve yeni dizi üretir.",
                    reviewTopic = "Pure Array Methods"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "flatMap() ne işe yarar?",
                    answer = "Önce her elemana `map()` uygular, ardından oluşan iç içe dizileri 1 derinlik seviyesinde `flat()` ile açarak tek bir düz diziye dönüştürür."
                )
            ),
            completionCriteria = listOf(
                "map, filter ve reduce ile veri dönüştürebilmek",
                "Saf (pure) dizi metotlarını mutasyonlu olanlardan ayırmak",
                "find, some, every kontrol metotlarını kullanmak"
            )
        ),

        // ==========================================
        // DERS 5: SCOPE, CLOSURES & KAPSÜLLEME
        // ==========================================
        Lesson(
            id = "js_5",
            courseId = "javascript",
            sectionId = "js_sec_4",
            title = "Kapsam (Scope), Hoisting & Closures (Kapanışlar)",
            shortDesc = "JS'nin kalbi: Lexical Scope, Hoisting mekanizması, Closures (Kapanışlar), Kapsülleme (Private Data), Fabrika Fonksiyonları ve Currying.",
            level = CourseLevel.INTERMEDIATE,
            order = 5,
            isPremium = true,
            learningObjectives = listOf(
                "Lexical Environment ve Scope Chain mekanizmasını kavramak",
                "Hoisting sırasında var vs let/const (Temporal Dead Zone - TDZ) farkını anlamak",
                "Closures kullanarak dışarıdan erişilemeyen özel değişkenler (Private State) üretmek"
            ),
            prerequisites = listOf("Fonksiyonel Dizi Metotları"),
            subtopics = listOf("Lexical Environment", "Temporal Dead Zone (TDZ)", "Closure Nedir?", "Data Encapsulation (Özel Değişkenler)", "Function Currying"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Closure Nedir?",
                    body = "Bir fonksiyonun, dışındaki (çevreleyen) fonksiyon sonlansa bile onun değişkenlerini hatırlaması ve bunlara erişmeye devam etmesi yeteneğidir.",
                    codeSnippet = "function sayacOlustur() {\n    let sayi = 0; // Private state\n    return () => ++sayi;\n}\nconst sayac = sayacOlustur();\nsayac(); // 1\nsayac(); // 2"
                ),
                LessonContentBlock(
                    subtitle = "2. Temporal Dead Zone (TDZ)",
                    body = "`let` ve `const` hoist edilir ancak başlatılmaz. Tanımlandıkları satıra kadar olan bölgeye TDZ denir ve bu aralıkta değişkene erişilirse `ReferenceError` fırlatılır.",
                    tip = "Closure'lar bellek yönetiminde dikkat gerektirir; gereksiz closure referansları değişkenlerin Garbage Collector tarafından temizlenmesini engelleyebilir."
                )
            ),
            codeExample = "function bankaHesabi(baslangicBakiye) {\n    let bakiye = baslangicBakiye; // Dışarıdan doğrudan erişilemez!\n    \n    return {\n        paraYatir: (miktar) => { bakiye += miktar; },\n        paraCek: (miktar) => {\n            if (miktar <= bakiye) bakiye -= miktar;\n            else console.log(\"Yetersiz Bakiye!\");\n        },\n        bakiyeGoster: () => bakiye\n    };\n}\n\nconst hesap = bankaHesabi(1000);\nhesap.paraYatir(500);\nconsole.log(\"Mevcut Bakiye: \" + hesap.bakiyeGoster() + \" TL\"); // 1500",
            codeExplanation = "bakiye değişkeni closure içinde gizlendi; dışarıdan hesap.bakiye şeklinde bozulamaz, sadece metodlar erişebilir.",
            realWorldExample = "React Hooks mimarisindeki `useState` dahili durumunu render'lar arasında korumak için doğrudan Closures mekanizmasını kullanır.",
            practicalTask = "Bir ön ek (prefix) alan ve içine gelen metinlerin başına bu ön eki ekleyen bir closure fabrika fonksiyonu yazın.",
            starterPlaygroundCode = "function selamlayici(onEk) { return (isim) => onEk + \" \" + isim; }\nconst merhabaDe = selamlayici(\"Merhaba\");\nconsole.log(merhabaDe(\"Burak\"));",
            miniQuestion = MiniQuestion(
                id = "js_q_5",
                question = "JavaScript'te bir iç fonksiyonun, ebeveyn fonksiyonu çalışmasını tamamlayıp sonlandıktan sonra bile ebeveyninin değişkenlerine erişebilmesine ne ad verilir?",
                options = listOf("Hoisting", "Closure (Kapanış)", "Currying", "Event Bubbling"),
                correctIndex = 1,
                explanation = "Bu duruma Closure denir; fonksiyon oluşturulduğu andaki Lexical Scope referansını canlı tutar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_5",
                lessonId = "js_5",
                title = "Özel Sayaç (Closure)",
                instructions = "0'dan başlayan, artir() çağrıldığında sayacı 1 artıran, oku() çağrıldığında geçerli değeri döndüren sayacFabrikasi() fonksiyonunu closure ile yazın.",
                exampleInput = "const s = sayacFabrikasi(); s.artir(); s.oku();",
                exampleOutput = "1",
                starterCode = "function sayacFabrikasi() {\n    // Kodunu buraya yaz:\n    return {};\n}",
                solutionCode = "function sayacFabrikasi() {\n    let deger = 0;\n    return {\n        artir: () => { deger++; },\n        oku: () => deger\n    };\n}",
                hints = listOf("let deger = 0 tanımlayın ve metotları obje olarak dönün."),
                testCases = listOf(
                    TestCase("sayacFabrikasi", "1", "Closure test")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_5_1",
                    lessonId = "js_5",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "JavaScript'te 'Temporal Dead Zone (TDZ)' ne anlama gelir?",
                    options = listOf("Programın çöktüğü an", "let ve const değişkenlerinin kapsam başlangıcından tanımlandıkları satıra kadar erişilemez olduğu bölge", "Garbage collector çalışma süresi", "setTimeout bekleme süresi"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! TDZ içinde let/const değişkenine erişim ReferenceError üretir.",
                    explanationWrong = "let/const tanımlanana kadar olan erişilemez bölgedir.",
                    reviewTopic = "Temporal Dead Zone"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Currying nedir?",
                    answer = "Çok parametreli bir fonksiyonu (`f(a, b, c)`), her seferinde tek bir parametre alan iç içe fonksiyon zincirine (`f(a)(b)(c)`) dönüştürme tekniğidir."
                )
            ),
            completionCriteria = listOf(
                "Lexical Scope ve Hoisting farkını açıklayabilmek",
                "Closures ile veri kapsülleme yapabilmek",
                "TDZ mekanizmasının neden var olduğunu bilmek"
            )
        ),

        // ==========================================
        // DERS 6: PROTOTİPLER & ES6 SINIF MİMARİSİ
        // ==========================================
        Lesson(
            id = "js_6",
            courseId = "javascript",
            sectionId = "js_sec_4",
            title = "Prototip Zinciri (__proto__) & Modern ES6 Sınıfları",
            shortDesc = "Prototip tabanlı kalıtım: prototype vs __proto__, Object.create, ES6 Class, constructor, extends, super ve modern Private Fields (#alan).",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true,
            learningObjectives = listOf(
                "JavaScript'in Prototip Tabanlı (Prototypal Inheritance) kalıtım doğasını kavramak",
                "ES6 Class sözdiziminin prototip üzerindeki 'Syntactic Sugar' yapısını anlamak",
                "extends, super() ve private class fields (#alan) ile nesne yönelimli mimariler tasarlamak"
            ),
            prerequisites = listOf("Scope, Hoisting ve Closures"),
            subtopics = listOf("Prototip Zinciri (Prototype Chain)", "Object.prototype & __proto__", "ES6 Class & constructor", "extends & super()", "Private Fields (#) & Getters/Setters"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Prototip Zinciri Nasıl Çalışır?",
                    body = "Bir nesnenin özelliğine erişildiğinde JS önce nesnenin kendisine bakar. Bulamazsa onun prototipine (`__proto__`), oradan `Object.prototype`'a kadar zinciri tırmanır. Bulamazsa `undefined` döner.",
                    codeSnippet = "class Hayvan {\n    constructor(isim) { this.isim = isim; }\n    sesCikar() { return \"Ses\"; }\n}\nclass Kopek extends Hayvan {\n    sesCikar() { return super.sesCikar() + \" -> Hav Hav!\"; }\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Gerçek Özel Alanlar (#private)",
                    body = "Modern JavaScript'te `#` ile başlayan sınıf alanları sınıf dışından hiçbir şekilde okunamaz veya değiştirilemez (Hard Private).",
                    tip = "Sınıf metotları prototipe tek bir kez yazılır; constructor içindeki metotlar ise her nesne örneğinde yeniden oluşturulup bellek harcar."
                )
            ),
            codeExample = "class Kullanici {\n    #sifre; // Private Field\n    \n    constructor(isim, sifre) {\n        this.isim = isim;\n        this.#sifre = sifre;\n    }\n    \n    sifreDogrula(girilenSifre) {\n        return this.#sifre === girilenSifre;\n    }\n}\n\nconst k = new Kullanici(\"Kemal\", \"gizli123\");\nconsole.log(\"Kullanıcı: \" + k.isim);\nconsole.log(\"Şifre Doğru mu: \" + k.sifreDogrula(\"gizli123\")); // true\n// console.log(k.#sifre); // SyntaxError: Private field must be declared in an enclosing class",
            codeExplanation = "#sifre private alanı dış dünyadan tamamen gizlendi ve sınıf kapsülleme sağladı.",
            realWorldExample = "Node.js backend ORM'lerinde (Prisma, TypeORM) veritabanı modelleri ES6 sınıfları ve prototip kalıtımı ile oluşturulur.",
            practicalTask = "Araba sınıfı tanımlayıp ondan türeyen ElektrikliAraba sınıfı yazın.",
            starterPlaygroundCode = "class Kisi { constructor(ad) { this.ad = ad; } selam() { return \"Selam \" + this.ad; } }\nconsole.log(new Kisi(\"Efe\").selam());",
            miniQuestion = MiniQuestion(
                id = "js_q_6",
                question = "Modern JavaScript sınıflarında bir alanın (field) sınıf dışından erişilemeyen GERÇEK özel alan (private) olmasını sağlayan sözdizimi hangisidir?",
                options = listOf("_alan (Alt çizgi)", "#alan (Kare işareti)", "private alan", "local alan"),
                correctIndex = 1,
                explanation = "#alan sözdizimi derleme ve çalışma anında sınıf dışından erişimi imkansız kılan resmi JS standardıdır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_6",
                lessonId = "js_6",
                title = "Dikdörtgen Alanı (ES6 Class)",
                instructions = "genislik ve yukseklik alan Dikdortgen sınıfı tanımlayın. alanHesapla() metodu genişlik * yükseklik döndürsün.",
                exampleInput = "new Dikdortgen(5, 10).alanHesapla()",
                exampleOutput = "50",
                starterCode = "class Dikdortgen {\n    // Sınıfı buraya yazın:\n}",
                solutionCode = "class Dikdortgen {\n    constructor(genislik, yukseklik) {\n        this.genislik = genislik;\n        this.yukseklik = yukseklik;\n    }\n    alanHesapla() {\n        return this.genislik * this.yukseklik;\n    }\n}",
                hints = listOf("constructor(genislik, yukseklik) ve alanHesapla() metodunu tanımlayın."),
                testCases = listOf(
                    TestCase("Dikdortgen", "50", "Class testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_6_1",
                    lessonId = "js_6",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "JavaScript'te tüm nesnelerin en tepesindeki kök prototip hangisidir?",
                    options = listOf("Function.prototype", "Object.prototype", "null", "Array.prototype"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Prototip zincirinin en tepesinde Object.prototype yer alır (Onun da prototipi null'dur).",
                    explanationWrong = "Object.prototype zincirin en tepesindedir.",
                    reviewTopic = "Object.prototype"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "static metotlar nedir?",
                    answer = "`static` metotlar nesne örnekleri (`new Sınıf()`) üzerinden değil, doğrudan sınıfın kendisi (`Sınıf.metot()`) üzerinden çağrılan yardımcı fonksiyonlardır."
                )
            ),
            completionCriteria = listOf(
                "Prototip zincirinin çalışma mantığını bilmek",
                "ES6 class, constructor ve extends kullanabilmek",
                "#private fields ile gerçek kapsülleme yapabilmek"
            )
        ),

        // ==========================================
        // DERS 7: PROMISES & ASYNC/AWAIT
        // ==========================================
        Lesson(
            id = "js_7",
            courseId = "javascript",
            sectionId = "js_sec_5",
            title = "Asenkron JS: Promises & Async/Await Derinlikleri",
            shortDesc = "Callback Hell'den kurtuluş: Promise durumları (Pending, Fulfilled, Rejected), Chaining (.then/.catch), async/await, try/catch ve Promise combinators.",
            level = CourseLevel.ADVANCED,
            order = 7,
            isPremium = true,
            learningObjectives = listOf(
                "Promise durum makinesini (Pending, Fulfilled, Rejected) kavramak",
                "async/await ile asenkron kodları senkron gibi okunabilir yazmak",
                "Promise.all, Promise.allSettled ve Promise.race ile çoklu asenkron işlemleri yönetmek"
            ),
            prerequisites = listOf("Prototip Zinciri ve ES6 Sınıfları"),
            subtopics = listOf("Promise Mimarisi", "then, catch, finally", "async / await Sözdizimi", "Hata Yönetimi (try/catch)", "Promise.all vs allSettled vs race"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Promise Durumları",
                    body = "Bir Promise 3 durumdan birinde olabilir:\n1. `Pending`: Henüz tamamlanmadı.\n2. `Fulfilled`: Başarıyla bitti (`resolve(deger)`).\n3. `Rejected`: Hata ile sonuçlandı (`reject(hata)`).",
                    codeSnippet = "const bekle = ms => new Promise(res => setTimeout(res, ms));\nasync function test() {\n    await bekle(1000);\n    console.log(\"1 sn geçti\");\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Promise.all vs Promise.allSettled",
                    body = "• `Promise.all`: İsteklerden BİRİ BİLE hata verirse anında çöker (Fail-fast).\n• `Promise.allSettled`: Hata verse bile tüm isteklerin bitmesini bekler ve her birinin sonucunu `{ status, value/reason }` olarak döndürür.",
                    tip = "Bağımsız paralel API isteklerinde `await api1(); await api2();` yerine `await Promise.all([api1(), api2()]);` kullanarak süreyi yarıya indirin."
                )
            ),
            codeExample = "const veriGetir = (id) => new Promise((resolve) => {\n    setTimeout(() => resolve(\"Veri #\" + id), 100);\n});\n\nasync function veriAkisi() {\n    try {\n        console.log(\"İstekler paralel başlatıldı...\");\n        const [v1, v2] = await Promise.all([veriGetir(1), veriGetir(2)]);\n        console.log(\"Sonuçlar: \" + v1 + \" & \" + v2);\n    } catch (err) {\n        console.error(\"Hata oluştu:\", err);\n    }\n}\n\nveriAkisi();",
            codeExplanation = "Promise.all ile iki asenkron istek paralel çalıştırıldı ve await ile sonuçlar destructuring ile alındı.",
            realWorldExample = "Frontend uygulamalarında sayfa açılışında kullanıcı profili ve bildirimlerin aynı anda paralel çekilmesi `Promise.all` ile yapılır.",
            practicalTask = "Belirtilen milisaniye kadar bekleyen generic bir delay(ms) Promise fonksiyonu yazın.",
            starterPlaygroundCode = "const delay = ms => new Promise(r => setTimeout(r, ms));\nasync function main() { await delay(50); console.log(\"Hazır\"); }\nmain();",
            miniQuestion = MiniQuestion(
                id = "js_q_7",
                question = "Birden fazla Promise paralel çalıştırıldığında içlerinden biri hata verse bile diğerlerinin sonucunu kaybetmeden tüm sonuçları almak için hangi metot kullanılır?",
                options = listOf("Promise.all()", "Promise.allSettled()", "Promise.race()", "Promise.any()"),
                correctIndex = 1,
                explanation = "Promise.allSettled() her bir Promise'in başarı veya başarısızlık durumunu ayrı ayrı toplar ve asla erken çökmez."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_7",
                lessonId = "js_7",
                title = "Asenkron Sayı İki Katlayıcı",
                instructions = "Bir sayı alıp 10ms sonra bu sayının 2 katını resolve eden asenkronIkiKati(sayi) Promise fonksiyonunu yazın.",
                exampleInput = "await asenkronIkiKati(15)",
                exampleOutput = "30",
                starterCode = "function asenkronIkiKati(sayi) {\n    // Kodunu buraya yaz:\n    return Promise.resolve(0);\n}",
                solutionCode = "function asenkronIkiKati(sayi) {\n    return new Promise(resolve => {\n        setTimeout(() => resolve(sayi * 2), 10);\n    });\n}",
                hints = listOf("return new Promise(res => setTimeout(() => res(sayi * 2), 10));"),
                testCases = listOf(
                    TestCase("asenkronIkiKati(15)", "30", "Promise testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_7_1",
                    lessonId = "js_7",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir 'async' fonksiyonun dönüş değeri (return) daima nedir?",
                    options = listOf("Void", "Döndürülen değere göre değişir", "Daima bir Promise nesnesidir", "Generator nesnesidir"),
                    correctOptionIndex = 2,
                    explanationRight = "Doğru! async fonksiyonlar düz bir değer döndürseler bile JS onu otomatik olarak Promise.resolve() ile sarmalar.",
                    explanationWrong = "async fonksiyonlar daima Promise döner.",
                    reviewTopic = "async return Promise"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Promise.race() ile Promise.any() arasındaki fark nedir?",
                    answer = "`Promise.race()` ilk biten Promise'i (ister başarı olsun ister hata) hemen kabul eder. `Promise.any()` ise ilk BAŞARILI (fulfilled) olanı arar; hataları görmezden gelir."
                )
            ),
            completionCriteria = listOf(
                "Promise durumlarını ve zincirleme yapısını bilmek",
                "async/await ve try-catch ile asenkron hata yönetimi yapmak",
                "Promise.all ve allSettled arasındaki farkı uygulamak"
            )
        ),

        // ==========================================
        // DERS 8: EVENT LOOP & MICROTASKS / MACROTASKS
        // ==========================================
        Lesson(
            id = "js_8",
            courseId = "javascript",
            sectionId = "js_sec_5",
            title = "Event Loop, Call Stack & Microtask / Macrotask Kuyrukları",
            shortDesc = "Tek iş parçacığı (Single Threaded) nasıl çalışır? Call Stack, Web APIs, Microtask Queue (Promises, queueMicrotask) vs Macrotask Queue (setTimeout, I/O) öncelik sırası.",
            level = CourseLevel.ADVANCED,
            order = 8,
            isPremium = true,
            learningObjectives = listOf(
                "JavaScript'in Call Stack çalışma mantığını ve 'Stack Overflow' durumunu kavramak",
                "Event Loop'un tarayıcı ve Node.js'teki döngü mekanizmasını öğrenmek",
                "Microtask (Promise) kuyruğunun Macrotask (setTimeout) kuyruğuna olan MUTLAK ÖNCELİĞİNİ kodla kanıtlamak"
            ),
            prerequisites = listOf("Promises ve Async/Await"),
            subtopics = listOf("Single Thread & Call Stack", "Web APIs & Asenkron Delegasyon", "Microtask Queue (Promises)", "Macrotask Queue (setTimeout, setInterval)", "Event Loop Öncelik Sıralaması"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Event Loop Öncelik Kuralı",
                    body = "1. Call Stack'teki tüm senkron kodlar çalıştırılır.\n2. Call Stack boşaldığında, Microtask Queue'daki (Promise .then/catch, queueMicrotask) TÜM görevler bitene kadar boşaltılır.\n3. Ardından Macrotask Queue'dan (setTimeout, setInterval) TEK BİR görev alınır ve süreç tekrarlanır.",
                    codeSnippet = "console.log('1'); // Senkron\nsetTimeout(() => console.log('2'), 0); // Macrotask\nPromise.resolve().then(() => console.log('3')); // Microtask\nconsole.log('4'); // Senkron\n// Sıralama: 1, 4, 3, 2"
                ),
                LessonContentBlock(
                    subtitle = "2. UI Donmasını Önleme",
                    body = "Ağır hesaplamalar Call Stack'i kilitlerse tarayıcı 60 FPS çizimini ve tıklamaları işleyemez (Freezing). Bu işler `requestAnimationFrame` veya Web Workers'a devredilmelidir.",
                    tip = "`setTimeout(fn, 0)` işlemi 0 milisaniye sonra değil, mevcut Call Stack ve Microtask kuyruğu tamamen bittikten sonra çalıştırılır."
                )
            ),
            codeExample = "console.log(\"A: Senkron Başlangıç\");\n\nsetTimeout(() => {\n    console.log(\"B: Macrotask (setTimeout)\");\n}, 0);\n\nPromise.resolve().then(() => {\n    console.log(\"C: Microtask (Promise 1)\");\n}).then(() => {\n    console.log(\"D: Microtask (Promise 2)\");\n});\n\nconsole.log(\"E: Senkron Bitiş\");\n// Çıktı Sırası: A -> E -> C -> D -> B",
            codeExplanation = "Önce senkron A ve E çalıştı. Stack boşalınca Microtask C ve D çalıştı. En son Macrotask B çalıştı.",
            realWorldExample = "Mülakatlarda en sık sorulan JavaScript sorusudur ve karmaşık asenkron yarış durumlarını (Race Conditions) çözmek için şarttır.",
            practicalTask = "queueMicrotask kullanarak setTimeout'tan önce çalışan bir microtask görevi planlayın.",
            starterPlaygroundCode = "console.log(\"1\");\nsetTimeout(() => console.log(\"3\"), 0);\nqueueMicrotask(() => console.log(\"2\"));",
            miniQuestion = MiniQuestion(
                id = "js_q_8",
                question = "Call Stack boşaldığında Event Loop ilk olarak hangi kuyruktaki görevleri çalıştırır?",
                options = listOf("Macrotask Queue (setTimeout)", "Microtask Queue (Promise .then / queueMicrotask)", "DOM Event Kuyruğu", "Render Kuyruğu"),
                correctIndex = 1,
                explanation = "Microtask kuyruğu her zaman en yüksek önceliğe sahiptir ve Macrotask'lerden önce tamamen boşaltılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_8",
                lessonId = "js_8",
                title = "Microtask Planlayıcı",
                instructions = "queueMicrotask kullanarak verilen mesajı microtask kuyruğuna ekleyen microGorevEkle(mesaj, callback) fonksiyonunu yazın.",
                exampleInput = "microGorevEkle(\"Test\", fn)",
                exampleOutput = "Microtask planlandı",
                starterCode = "function microGorevEkle(mesaj, callback) {\n    // Kodunu buraya yaz:\n}",
                solutionCode = "function microGorevEkle(mesaj, callback) {\n    queueMicrotask(() => callback(mesaj));\n}",
                hints = listOf("queueMicrotask(() => callback(mesaj));"),
                testCases = listOf(
                    TestCase("microGorevEkle", "Microtask", "Event loop test")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_8_1",
                    lessonId = "js_8",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir web sayfasında sonsuz bir while(true) döngüsü çalıştırılırsa ne olur?",
                    options = listOf("Tarayıcı çöker veya sayfa tamamen donarak tıklamalara yanıt veremez hale gelir; çünkü Call Stack asla boşalamaz", "Event loop araya girip döngüyü duraklatır", "setTimeout görevleri çalışmaya devam eder", "Arka planda sessizce biter"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! JS tek thread'dir; senkron döngü Stack'i kilitlerse Event Loop diğer görevleri çalıştıramaz.",
                    explanationWrong = "Call Stack boşalmadığı için sayfa tamamen kilitlenir.",
                    reviewTopic = "Call Stack Blocking"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Node.js ile Tarayıcı Event Loop'u arasında fark var mıdır?",
                    answer = "Evet. Tarayıcıda HTML5 standardı geçerlidir (Microtask/Macrotask). Node.js'te ise Libuv kütüphanesi kullanılır ve Timer, Pending I/O, Poll, Check (setImmediate), Close olmak üzere 6 ayrı faz bulunur."
                )
            ),
            completionCriteria = listOf(
                "Call Stack ve Single-Threaded doğasını kavramak",
                "Microtask ve Macrotask sıralama kurallarını bilmek",
                "Senkron kod bloklamasının zararlarını açıklayabilmek"
            )
        ),

        // ==========================================
        // DERS 9: METAPROGRAMMING: PROXY & REFLECT
        // ==========================================
        Lesson(
            id = "js_9",
            courseId = "javascript",
            sectionId = "js_sec_6",
            title = "Metaprogramming: Proxy & Reflect API",
            shortDesc = "Reaktif sistemlerin kalbi: Proxy ile nesne işlemlerini araya girip yakalama (Traps: get, set, deleteProperty), Reflect API ve Vue 3 tarzı reaktif durum motoru.",
            level = CourseLevel.EXPERT,
            order = 9,
            isPremium = true,
            learningObjectives = listOf(
                "Proxy ile bir nesneye yapılan okuma/yazma işlemlerini yakalamayı (Interception) öğrenmek",
                "Reflect API metotlarını Proxy trap'leri içinde varsayılan davranışı korumak için kullanmak",
                "Özellik doğrulama (Validation) ve Reaktif UI Data-Binding motoru geliştirmek"
            ),
            prerequisites = listOf("Event Loop ve Nesne Yönelimli JS"),
            subtopics = listOf("Proxy Kavramı ve Traps", "get ve set Tuzakları", "Reflect API Entegrasyonu", "Veri Doğrulama ve Güvenlik", "Reaktif Durum Yönetimi Mimarisi"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Proxy Traps ve Interception",
                    body = "Proxy bir nesnenin önüne koyulan bir güvenlik/aracı katmanıdır. `target.alan` okunduğunda `get()`, yazıldığında `set()` tuzakları devreye girer.",
                    codeSnippet = "const hedef = { bakiye: 100 };\nconst p = new Proxy(hedef, {\n    get(target, prop) {\n        console.log(prop + \" okundu\");\n        return Reflect.get(target, prop);\n    }\n});"
                ),
                LessonContentBlock(
                    subtitle = "2. Neden Reflect Kullanılır?",
                    body = "Reflect metotları nesne işlemlerini fonksiyonel hale getirir ve işlem başarısız olduğunda hata fırlatmak yerine boolean (`true/false`) döndürür.",
                    tip = "Vue 3 reaktivite motoru (Reactivity API) tamamen JavaScript `Proxy` nesneleri üzerine kurulmuştur."
                )
            ),
            codeExample = "function reaktifNesne(veri, onChange) {\n    return new Proxy(veri, {\n        set(target, prop, value) {\n            const eski = target[prop];\n            const sonuc = Reflect.set(target, prop, value);\n            if (eski !== value) {\n                onChange(prop, value);\n            }\n            return sonuc;\n        }\n    });\n}\n\nconst state = reaktifNesne({ sayac: 0 }, (alan, yeniDeger) => {\n    console.log(\"State değişti! [\" + alan + \"] -> \" + yeniDeger);\n});\n\nstate.sayac = 1; // Konsola: State değişti! [sayac] -> 1\nstate.sayac = 2; // Konsola: State değişti! [sayac] -> 2",
            codeExplanation = "Proxy set tuzağı ile nesne alanı her değiştiğinde onChange tetiklendi; reaktif state motoru kuruldu.",
            realWorldExample = "Vue 3, MobX ve Immer.js kütüphaneleri durum değişikliklerini otomatik algılayıp UI'ı güncellemek için Proxy kullanır.",
            practicalTask = "Olmayan bir özelliğe erişildiğinde hata fırlatan bir Proxy nesnesi yazın.",
            starterPlaygroundCode = "const p = new Proxy({}, { get: (t, k) => k in t ? t[k] : \"Bulunamadı\" });\nconsole.log(p.test);",
            miniQuestion = MiniQuestion(
                id = "js_q_9",
                question = "Vue 3 reaktivite sisteminin Vue 2'deki Object.defineProperty yerine 'Proxy' kullanmasının en büyük avantajı nedir?",
                options = listOf("Proxy daha az bellek kullanır", "Proxy sonradan eklenen yeni dinamik özellikleri ve dizi indeks değişimlerini otomatik yakalayabilir", "Proxy sadece sayılarla çalışır", "Proxy tarayıcıyı dondurmaz"),
                correctIndex = 1,
                explanation = "Proxy tüm nesneyi sarmalar; böylece sonradan eklenen özellikler ve array mutasyonları (push, splice) anında yakalanır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_9",
                lessonId = "js_9",
                title = "Pozitif Sayı Doğrulayıcı (Proxy)",
                instructions = "Sadece pozitif sayıların atanmasına izin veren, negatif sayı veya metin atanırsa hata fırlatan dogrulanmisNesne() Proxy'sini yazın.",
                exampleInput = "state.puan = -5 // Hata!",
                exampleOutput = "Error: Sadece pozitif sayı",
                starterCode = "function dogrulanmisNesne() {\n    return new Proxy({}, {\n        set(target, prop, value) {\n            // Kodunu buraya yaz:\n            return true;\n        }\n    });\n}",
                solutionCode = "function dogrulanmisNesne() {\n    return new Proxy({}, {\n        set(target, prop, value) {\n            if (typeof value !== 'number' || value < 0) {\n                throw new Error('Sadece pozitif sayı atanabilir');\n            }\n            return Reflect.set(target, prop, value);\n        }\n    });\n}",
                hints = listOf("typeof value !== 'number' || value < 0 kontrolü yapın."),
                testCases = listOf(
                    TestCase("dogrulanmisNesne", "Proxy", "Proxy validation")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_9_1",
                    lessonId = "js_9",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Proxy 'set' tuzağında (trap) atama başarılı olduğunda fonksiyon ne döndürmelidir?",
                    options = listOf("Atanan değeri", "true (başarılı) veya false (başarısız)", "target nesnesini", "undefined"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Proxy set trap'i strict mode'da false döndürürse TypeError fırlatılır; başarılı atamada true dönmelidir.",
                    explanationWrong = "Boolean (true/false) döndürmelidir.",
                    reviewTopic = "Proxy Set Trap Boolean Return"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "deleteProperty tuzağı ne işe yarar?",
                    answer = "Bir nesneden `delete nesne.ozellik` komutu ile alan silinmeye çalışıldığında araya girerek silme işlemini engellemeye veya loglamaya yarar."
                )
            ),
            completionCriteria = listOf(
                "Proxy ve Reflect API farkını bilmek",
                "get ve set tuzakları ile nesne davranışını değiştirebilmek",
                "Reaktif veri bağlama (Data binding) mantığını kavramak"
            )
        ),

        // ==========================================
        // DERS 10: MODÜLLER, WEBPACK/VITE & BUNDLERS
        // ==========================================
        Lesson(
            id = "js_10",
            courseId = "javascript",
            sectionId = "js_sec_6",
            title = "Modül Sistemleri: ESM (import/export) vs CJS & Tree-Shaking",
            shortDesc = "Modern JS mimarisi: ES Modules (import/export), CommonJS (require), Dinamik İçe Aktarma (import()), Bundler optimizasyonları ve Tree-Shaking.",
            level = CourseLevel.ADVANCED,
            order = 10,
            isPremium = true,
            learningObjectives = listOf(
                "ES Modules (ESM) ile CommonJS (CJS) arasındaki statik analiz farkını anlamak",
                "Dinamik import() ile kod bölme (Code Splitting) ve Lazy Loading yapmak",
                "Tree-Shaking mekanizmasının kullanılmayan ölü kodları nasıl temizlediğini kavramak"
            ),
            prerequisites = listOf("Proxy ve Metaprogramming"),
            subtopics = listOf("ESM (import / export)", "Named vs Default Export", "CommonJS (require / module.exports)", "Dynamic import() (Code Splitting)", "Tree-Shaking & Bundle Optimization"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. ESM Neden Üstündür?",
                    body = "CommonJS (`require`) çalışma zamanında dinamik yüklenir. ESM (`import`) ise derleme zamanında statik olarak analiz edilir. Bu sayede derleyiciler (Vite, Rollup) projedeki kullanılmayan fonksiyonları nihai paketten tamamen çıkarır (Tree-Shaking).",
                    codeSnippet = "// Named Export:\nexport const topla = (a, b) => a + b;\n// Default Export:\nexport default class Motor { ... }"
                ),
                LessonContentBlock(
                    subtitle = "2. Dinamik import() ile Lazy Loading",
                    body = "Sayfa açılışında ihtiyaç duyulmayan ağır kütüphaneler sadece kullanıcı ilgili butona tıkladığında yüklenebilir.",
                    codeSnippet = "button.onclick = async () => {\n    const { grafikCiz } = await import('./chart.js');\n    grafikCiz();\n};"
                )
            ),
            codeExample = "// math.js modülü:\nexport const pi = 3.14;\nexport function kare(x) { return x * x; }\n\n// main.js:\n// import { kare } from './math.js';\n// console.log(kare(4)); // 'pi' kullanılmadığı için bundle'a dahil edilmez (Tree-Shaking)!\nconsole.log(\"ESM Statik Modül Sistemi Aktif\");",
            codeExplanation = "Statik import yapısı bundler araçlarının ölü kodu tespit edip atmasını sağladı.",
            realWorldExample = "Vite, Next.js ve Webpack modern web uygulamalarını mikro parçalara bölmek ve hızlı açılış sağlamak için ESM tabanlı kod bölme kullanır.",
            practicalTask = "Dinamik import() kullanarak bir fonksiyonu asenkron yükleyen bir kod taslağı yazın.",
            starterPlaygroundCode = "const mod = { topla: (a,b) => a+b };\nconsole.log(mod.topla(2, 3));",
            miniQuestion = MiniQuestion(
                id = "js_q_10",
                question = "Paketleyicilerin (Vite, Webpack) projedeki kullanılmayan ölü kodları tespit edip nihai çıktıdan atması işlemine ne ad verilir?",
                options = listOf("Minification", "Tree-Shaking", "Transpilation", "Polyfill"),
                correctIndex = 1,
                explanation = "Tree-Shaking statik ESM import yapısını inceleyerek çağrılmayan ölü kod dallarını ağaçtan silker gibi temizler."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_10",
                lessonId = "js_10",
                title = "Named Export Simülasyonu",
                instructions = "Bir nesne içinde topla ve cikar fonksiyonlarını barındıran HesapModulu nesnesini döndüren fonksiyon yazın.",
                exampleInput = "HesapModulu.topla(5, 3)",
                exampleOutput = "8",
                starterCode = "function moduluOlustur() {\n    // Kodunu buraya yaz:\n    return {};\n}",
                solutionCode = "function moduluOlustur() {\n    return {\n        topla: (a, b) => a + b,\n        cikar: (a, b) => a - b\n    };\n}",
                hints = listOf("topla ve cikar fonksiyonlarını nesne olarak dönün."),
                testCases = listOf(
                    TestCase("moduluOlustur", "Module", "Export testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_10_1",
                    lessonId = "js_10",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "CommonJS (require) modül sistemi tarayıcılarda neden doğrudan ve verimli şekilde çalışmaz?",
                    options = listOf("JS dili izin vermez", "require() senkron çalışır ve dosya sisteminden okuma yapar; tarayıcıda ise dosyalar ağ üzerinden asenkron yüklenmek zorundadır", "Sadece Linux'ta çalışır", "Güvenlik nedeniyle yasaklanmıştır"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! require senkron olduğu için tarayıcıda ana thread'i ağ isteği boyunca kilitlerdi; ESM ise asenkron modül yüklemeyi destekler.",
                    explanationWrong = "Senkron dosya okuma mantığı tarayıcı ağına uyum sağlamaz.",
                    reviewTopic = "CommonJS vs ESM in Browser"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "import.meta nedir?",
                    answer = "Mevcut modül hakkında üst veri (metadata) tutan nesnedir; örneğin `import.meta.url` geçerli dosyanın URL adresini verir."
                )
            ),
            completionCriteria = listOf(
                "ESM ve CommonJS farkını açıklayabilmek",
                "Tree-Shaking optimizasyon kurallarını bilmek",
                "Dinamik import() ile kod bölme yapabilmek"
            )
        ),

        // ==========================================
        // DERS 11: WEB WORKERS & SHAREDARRAYBUFFER
        // ==========================================
        Lesson(
            id = "js_11",
            courseId = "javascript",
            sectionId = "js_sec_6",
            title = "Web Workers & SharedArrayBuffer: Gerçek Çoklu İş Parçacığı",
            shortDesc = "Ana UI thread'ini dondurmadan arka planda çoklu thread çalıştırma: Web Workers (postMessage, onmessage), SharedArrayBuffer, Atomics ve TypedArrays (Float32Array).",
            level = CourseLevel.EXPERT,
            order = 11,
            isPremium = true,
            learningObjectives = listOf(
                "Web Workers ile ana thread'den bağımsız arka plan iş parçacıkları oluşturmak",
                "postMessage ile yapılandırılmış klonlama (Structured Clone) mesajlaşmasını kavramak",
                "SharedArrayBuffer ve Atomics ile kilitlenmesiz sıfır kopyalı paylaşımlı bellek yönetimi yapmak"
            ),
            prerequisites = listOf("Modüller ve Asenkron JS"),
            subtopics = listOf("Web Workers Mimarisi", "postMessage & onmessage İletişimi", "SharedArrayBuffer & Paylaşımlı Bellek", "Atomics Operasyonları (add, wait, notify)", "TypedArrays (Uint8Array, Float32Array)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Web Worker Neden Gereklidir?",
                    body = "JavaScript tek thread'dir. Ağır bir görüntü işleme, kripto madenciliği veya ses sentezi ana thread'de yapılırsa sayfa donar. Web Worker bu işi ayrı bir işletim sistemi thread'ine taşır.",
                    codeSnippet = "// Ana Thread:\nconst worker = new Worker('worker.js');\nworker.postMessage({ sayi: 5000000 });\nworker.onmessage = (e) => console.log('Sonuç:', e.data);\n\n// worker.js:\nonmessage = (e) => {\n    const sonuc = agirHesaplama(e.data.sayi);\n    postMessage(sonuc);\n};"
                ),
                LessonContentBlock(
                    subtitle = "2. SharedArrayBuffer ve Atomics",
                    body = "Normal mesajlaşma veriyi klonlar (maliyetlidir). `SharedArrayBuffer` ile iki thread aynı bellek bloğunu doğrudan paylaşır. Race condition'ları önlemek için `Atomics.add`, `Atomics.wait` kullanılır.",
                    tip = "Web Workers içinde `window`, `document` ve DOM API'leri KULLANILAMAZ; sadece saf hesaplama, fetch ve IndexedDB erişilebilir."
                )
            ),
            codeExample = "// TypedArray ile yüksek performanslı bellek yönetimi:\nconst buffer = new ArrayBuffer(16); // 16 byte ham bellek\nconst int32View = new Int32Array(buffer); // 4 elemanlık int32 dizisi\n\nint32View[0] = 42;\nint32View[1] = 100;\n\nconsole.log(\"Byte Uzunluğu: \" + buffer.byteLength);\nconsole.log(\"Değerler: \" + int32View[0] + \", \" + int32View[1]);",
            codeExplanation = "Ham bellek ArrayBuffer üzerinde TypedArray ile sıfır ek yükle C-seviyesinde sayı manipülasyonu yapıldı.",
            realWorldExample = "Figma web uygulamasında C++ motoru WebAssembly ve Web Workers üzerinde çalışır; UI 120 FPS akıcılıkta kalır.",
            practicalTask = "Float32Array oluşturup 5 kayan noktalı sayı yerleştirin.",
            starterPlaygroundCode = "const u8 = new Uint8Array(4);\nu8[0] = 255; console.log(u8[0]);",
            miniQuestion = MiniQuestion(
                id = "js_q_11",
                question = "Bir Web Worker dosyasının içinden doğrudan 'document.getElementById()' çağrılarak DOM elemanlarına erişilebilir mi?",
                options = listOf("Evet, serbestçe erişilebilir", "Hayır, Web Workers DOM ve window nesnelerine erişemez; iş parçacığı güvenliği için UI erişimi kısıtlıdır", "Sadece gizli elemanlara erişebilir", "Belli kütüphanelerle erişebilir"),
                correctIndex = 1,
                explanation = "Thread-safety gereği DOM manipülasyonu yalnızca ana thread'e aittir; Worker yalnızca veri hesaplayıp mesaj atar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_11",
                lessonId = "js_11",
                title = "TypedArray ile Bellek Doldurma",
                instructions = "N elemanlı bir Uint16Array oluşturan ve her elemanına indeks numarasını yazıp döndüren uintDizisiUret(n) fonksiyonunu yazın.",
                exampleInput = "uintDizisiUret(3)",
                exampleOutput = "Uint16Array [0, 1, 2]",
                starterCode = "function uintDizisiUret(n) {\n    // Kodunu buraya yaz:\n    return null;\n}",
                solutionCode = "function uintDizisiUret(n) {\n    const arr = new Uint16Array(n);\n    for (let i = 0; i < n; i++) arr[i] = i;\n    return arr;\n}",
                hints = listOf("const arr = new Uint16Array(n); for döngüsü ile doldurun."),
                testCases = listOf(
                    TestCase("uintDizisiUret(3)", "Uint16Array", "TypedArray testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_11_1",
                    lessonId = "js_11",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "İki farklı Worker thread'inin 'SharedArrayBuffer' üzerindeki aynı bellek alanına aynı anda yazması durumunda veri bozulmasını (Race Condition) önlemek için hangi yerleşik API kullanılır?",
                    options = listOf("Mutex API", "Atomics API", "Locker API", "Sync API"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Atomics API atomik okuma, yazma, bekleme ve uyandırma operasyonları sağlayarak bellek yarışlarını önler.",
                    explanationWrong = "Atomics API kullanılır.",
                    reviewTopic = "Atomics API"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Transferable Objects nedir?",
                    answer = "postMessage ile büyük verileri kopyalamak yerine, belleğin sahipliğini anında Worker'a devreden (Zero-Copy) nesnelerdir (`ArrayBuffer`, `ImageBitmap`). Devredildikten sonra ana thread'deki kopya nötrlenir (detached)."
                )
            ),
            completionCriteria = listOf(
                "Web Workers mimarisini ve kısıtlarını bilmek",
                "postMessage ile thread'ler arası iletişim kurabilmek",
                "TypedArray ve SharedArrayBuffer mantığını kavramak"
            )
        ),

        // ==========================================
        // DERS 12: V8 MOTORU, JIT OPTİMİZASYONLARI & BELLEK YÖNETİMİ
        // ==========================================
        Lesson(
            id = "js_12",
            courseId = "javascript",
            sectionId = "js_sec_6",
            title = "V8 Motoru Derinlikleri: JIT, Hidden Classes & Bellek Yönetimi",
            shortDesc = "Tarayıcı motorunun içi: Ignition Bytecode Interpreter, TurboFan JIT Compiler, Deoptimization, Hidden Classes (Monomorphic vs Megamorphic) ve Garbage Collection.",
            level = CourseLevel.EXPERT,
            order = 12,
            isPremium = true,
            learningObjectives = listOf(
                "V8 motorunun JS kodunu nasıl derleyip optimize ettiğini (Ignition & TurboFan) öğrenmek",
                "Hidden Classes ve Inline Caching (IC) kurallarına uyarak kodları 10 kat daha hızlı çalıştırmak",
                "Monomorphic kod yazarak Deoptimization'ları engellemek",
                "Garbage Collector (Scavenger & Mark-Sweep) çalışma mantığıyla bellek sızıntılarını önlemek"
            ),
            prerequisites = listOf("Web Workers, TypedArrays ve İleri JS"),
            subtopics = listOf("Ignition (Interpreter) vs TurboFan (JIT)", "Hidden Classes (Shape/Maps)", "Inline Caching & Polymorphism", "Deoptimization (Bailout) Tuzakları", "Garbage Collection (Generational GC & WeakMap)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Hidden Classes (Gizli Sınıflar) ve Inline Caching",
                    body = "V8, nesnelerin özelliklerine hızlı erişmek için arka planda C++ benzeri 'Hidden Classes' üretir. Nesneye rastgele sırayla alan eklemek veya `delete obj.prop` yapmak gizli sınıfı bozar ve kodu yavaş yoruma (Deopt) iter.",
                    codeSnippet = "// İYİ (Aynı Hidden Class):\nfunction Nokta(x, y) { this.x = x; this.y = y; }\nconst p1 = new Nokta(1, 2);\nconst p2 = new Nokta(3, 4);\n\n// KÖTÜ (Farklı Hidden Classes - Deopt):\nconst a = {}; a.x = 1; a.y = 2;\nconst b = {}; b.y = 2; b.x = 1; // Farklı sıra!"
                ),
                LessonContentBlock(
                    subtitle = "2. Monomorphic vs Megamorphic Çağrılar",
                    body = "Bir fonksiyon her zaman aynı nesne tipiyle çağrılırsa 'Monomorphic' olur ve V8 assembly hızında doğrudan bellek ofsetine zıplar. 4'ten fazla farklı tipte çağrılırsa 'Megamorphic' olur ve optimizasyon tamamen devre dışı kalır.",
                    tip = "Nesnelerden alan silmek (`delete obj.prop`) yerine `obj.prop = undefined` atayın; böylece V8 gizli sınıf yapısını korur."
                )
            ),
            codeExample = "// Monomorphic optimizasyon örneği:\nclass Kullanici {\n    constructor(id, ad) {\n        this.id = id;\n        this.ad = ad; // Alanlar daima AYNI SIRAYLA eklenir!\n    }\n}\n\nfunction kullaniciOku(k) {\n    return k.id + \": \" + k.ad; // Inline Cache (IC) hızlandırılmış erişim\n}\n\nconst k1 = new Kullanici(1, \"Arda\");\nconst k2 = new Kullanici(2, \"Banu\");\n\nconsole.log(kullaniciOku(k1));\nconsole.log(kullaniciOku(k2));",
            codeExplanation = "Constructor ile alanlar aynı sırayla başlatıldığı için V8 tek bir Hidden Class üretti ve Inline Cache tam verimle çalıştı.",
            realWorldExample = "Node.js yüksek trafikli mikroservislerinde (Fastify vs Express) Fastify'ın 2 kat hızlı olmasının sebebi nesneleri Hidden Class uyumlu şablonlarla üretmesidir.",
            practicalTask = "WeakMap kullanarak DOM referansı temizlendiğinde otomatik bellekten silinen bir önbellek tasarlayın.",
            starterPlaygroundCode = "const wm = new WeakMap();\nlet obj = { a: 1 };\nwm.set(obj, \"Veri\");\nconsole.log(wm.get(obj));",
            miniQuestion = MiniQuestion(
                id = "js_q_12",
                question = "V8 motorunda bir fonksiyonun TurboFan JIT tarafından optimize edilmiş makine kodundan çıkarılıp yavaş yorumlayıcıya (Ignition) geri düşürülmesine ne ad verilir?",
                options = listOf("Garbage Collection", "Deoptimization (Bailout)", "Transpilation", "Memory Leak"),
                correctIndex = 1,
                explanation = "Fonksiyona beklenen tipin dışında farklı bir tip veya bozulmuş Hidden Class gelirse V8 optimizasyonu iptal eder (Deoptimization)."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_js_12",
                lessonId = "js_12",
                title = "Monomorphic Fabrika Fonksiyonu",
                instructions = "x, y, z koordinatlarını DAİMA aynı sırayla oluşturan ve donduran nokta3DUret(x, y, z) fabrika fonksiyonunu yazın.",
                exampleInput = "nokta3DUret(1, 2, 3)",
                exampleOutput = "{ x: 1, y: 2, z: 3 }",
                starterCode = "function nokta3DUret(x, y, z) {\n    // Kodunu buraya yaz:\n    return null;\n}",
                solutionCode = "function nokta3DUret(x, y, z) {\n    return { x, y, z };\n}",
                hints = listOf("return { x, y, z };"),
                testCases = listOf(
                    TestCase("nokta3DUret(1, 2, 3)", "Object", "Hidden class testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "js_quiz_12_1",
                    lessonId = "js_12",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "JavaScript'te 'WeakMap' veya 'WeakSet' koleksiyonlarının standart Map'ten en kritik farkı nedir?",
                    options = listOf("Daha hızlıdırlar", "Anahtarları zayıf referansla (Weak Reference) tutarlar; anahtar nesne başka hiçbir yerde kullanılmıyorsa Garbage Collector tarafından otomatik temizlenir ve bellek sızıntısı önlenir", "Sadece String tutabilirler", "Döngüyle gezilebilirler"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! WeakMap anahtarları GC'yi engellemez; böylece DOM düğümleri veya geçici nesneler silindiğinde bellekten kendiliğinden uçar.",
                    explanationWrong = "Zayıf referans sayesinde Garbage Collector nesneleri temizleyebilir.",
                    reviewTopic = "WeakMap & Garbage Collection"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "V8'de Generational Garbage Collection nasıl çalışır?",
                    answer = "Bellek Genç Nesil (Young Generation - yeni oluşturulan kısa ömürlü nesneler, Scavenger algoritmasıyla çok hızlı temizlenir) ve Yaşlı Nesil (Old Generation - hayatta kalan uzun ömürlü nesneler, Mark-Sweep-Compact ile temizlenir) olarak ikiye ayrılır."
                )
            ),
            completionCriteria = listOf(
                "Ignition ve TurboFan JIT döngüsünü bilmek",
                "Hidden Classes ve Inline Caching kurallarını kavramak",
                "Deoptimization sebeplerini ve WeakMap ile bellek yönetimini öğrenmek"
            )
        )
    )
}
