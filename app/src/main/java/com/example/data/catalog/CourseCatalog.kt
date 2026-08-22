package com.example.data.catalog

import com.example.R
import com.example.model.*

object CourseCatalog {

    val languages = listOf(
        ProgrammingLanguage(
            id = "dart",
            name = "Dart",
            tag = "Mobile & Web",
            iconEmoji = "🎯",
            colorHex = 0xFF00B4AB,
            shortDescription = "Flutter için temel programlama dili, modern ve nesne yönelimli.",
            targetAudience = "Mobil uygulama ve Flutter geliştiricileri",
            popularUses = listOf("Flutter Mobil", "Web & CLI", "Backend Server"),
            totalLessonsCount = 8,
            isPopular = true,
            drawableRes = R.drawable.img_lang_dart_1787396183719
        ),
        ProgrammingLanguage(
            id = "python",
            name = "Python",
            tag = "AI & Data Science",
            iconEmoji = "🐍",
            colorHex = 0xFF3776AB,
            shortDescription = "Yapay zeka, veri bilimi ve otomasyon için en popüler ve kolay dil.",
            targetAudience = "Yapay zeka, veri analizi ve backend meraklıları",
            popularUses = listOf("Yapay Zeka & ML", "Veri Analizi", "Django/FastAPI Web"),
            totalLessonsCount = 8,
            isPopular = true,
            drawableRes = R.drawable.img_lang_python_1787396198130
        ),
        ProgrammingLanguage(
            id = "cpp",
            name = "C++",
            tag = "System & Game",
            iconEmoji = "⚡",
            colorHex = 0xFF00599C,
            shortDescription = "Yüksek performanslı sistem programlama, oyun motorları ve gömülü sistemler.",
            targetAudience = "Oyun geliştiricileri ve sistem programcıları",
            popularUses = listOf("Unreal Engine Oyun", "Sistem Yazılımları", "Gömülü Sistemler"),
            totalLessonsCount = 8,
            isPopular = true,
            drawableRes = R.drawable.img_lang_cpp_1787396210963
        ),
        ProgrammingLanguage(
            id = "kotlin",
            name = "Kotlin",
            tag = "Android & Multiplatform",
            iconEmoji = "📱",
            colorHex = 0xFF7F52FF,
            shortDescription = "Android'in resmi dili, modern, güvenli ve Jetpack Compose ile tam uyumlu.",
            targetAudience = "Modern Android ve KMP geliştiricileri",
            popularUses = listOf("Android Native", "Jetpack Compose", "Kotlin Multiplatform"),
            totalLessonsCount = 8,
            isPopular = true,
            drawableRes = R.drawable.img_lang_kotlin_1787396247052
        ),
        ProgrammingLanguage(
            id = "rust",
            name = "Rust",
            tag = "Safe Systems",
            iconEmoji = "🦀",
            colorHex = 0xFFDEA584,
            shortDescription = "Bellek güvenliği garantili, çöp toplayıcısız (GC-free) ultra hızlı sistem dili.",
            targetAudience = "Modern altyapı ve güvenli sistem mimarları",
            popularUses = listOf("Sistem & OS", "WebAssembly", "Kripto & Ağ Motorları"),
            totalLessonsCount = 8,
            isPopular = false,
            drawableRes = R.drawable.img_lang_rust_1787396223257
        ),
        ProgrammingLanguage(
            id = "javascript",
            name = "JavaScript",
            tag = "Web & Fullstack",
            iconEmoji = "🌐",
            colorHex = 0xFFF7DF1E,
            shortDescription = "Tüm modern web tarayıcılarının ve Node.js ekosisteminin temeli.",
            targetAudience = "Web frontend ve Node.js backend geliştiricileri",
            popularUses = listOf("React/Vue Frontend", "Node.js Backend", "Full-Stack"),
            totalLessonsCount = 8,
            isPopular = true,
            drawableRes = R.drawable.img_lang_javascript_1787396236459
        ),
        ProgrammingLanguage(
            id = "flutter",
            name = "Flutter",
            tag = "Cross-Platform UI",
            iconEmoji = "💙",
            colorHex = 0xFF02569B,
            shortDescription = "Tek bir Dart kod tabanıyla iOS, Android, Web ve Masaüstü UI geliştirme.",
            targetAudience = "Çapraz platform mobil arayüz geliştiricileri",
            popularUses = listOf("iOS & Android UI", "Desktop Apps", "Web Uygulamaları"),
            totalLessonsCount = 8,
            isPopular = true,
            drawableRes = R.drawable.img_lang_flutter_1787396261102
        )
    )

    val defaultAchievements = listOf(
        AchievementItem(
            id = "first_lesson",
            title = "İlk Adım 🏆",
            description = "İlk dersini başarıyla tamamladın!",
            iconEmoji = "🏆",
            xpReward = 50
        ),
        AchievementItem(
            id = "streak_7",
            title = "7 Günlük Seri 🔥",
            description = "Üst üste 7 gün boyunca kodlama çalıştın.",
            iconEmoji = "🔥",
            xpReward = 150
        ),
        AchievementItem(
            id = "first_code",
            title = "İlk Kod 💻",
            description = "İlk kodlama egzersizini başarıyla çözdün.",
            iconEmoji = "💻",
            xpReward = 80
        ),
        AchievementItem(
            id = "quiz_master",
            title = "Quiz Ustası 🧠",
            description = "10 quiz testini yüksek başarıyla tamamladın.",
            iconEmoji = "🧠",
            xpReward = 200
        ),
        AchievementItem(
            id = "python_starter",
            title = "Python Kaşifi 🐍",
            description = "Python temel seviyesini bitirdin.",
            iconEmoji = "🐍",
            xpReward = 120
        ),
        AchievementItem(
            id = "first_project",
            title = "İlk Proje 🚀",
            description = "Uygulamalı bir projeyi tamamladın.",
            iconEmoji = "🚀",
            xpReward = 250
        )
    )

    fun getSections(courseId: String): List<CourseSection> {
        return when (courseId) {
            "dart" -> listOf(
                CourseSection("dart_sec_1", "dart", "Bölüm 1 – Dart'a Giriş", CourseLevel.BEGINNER, 1, "Temel kavramlar ve ilk program"),
                CourseSection("dart_sec_2", "dart", "Bölüm 2 – Değişkenler & Tipler", CourseLevel.BEGINNER, 2, "var, final, const, int, String, double"),
                CourseSection("dart_sec_3", "dart", "Bölüm 3 – Operatörler & Mantık", CourseLevel.FUNDAMENTAL, 3, "Aritmetik, karşılaştırma ve mantıksal işlemler"),
                CourseSection("dart_sec_4", "dart", "Bölüm 4 – Koşullar & Karar", CourseLevel.FUNDAMENTAL, 4, "if, else if, switch-case kontrol yapıları"),
                CourseSection("dart_sec_5", "dart", "Bölüm 5 – Döngüler & Kontroller", CourseLevel.INTERMEDIATE, 5, "for, while, do-while, break, continue"),
                CourseSection("dart_sec_6", "dart", "Bölüm 6 – Fonksiyonlar & Koleksiyonlar", CourseLevel.INTERMEDIATE, 6, "Listeler, Set, Map ve arrow fonksiyonlar"),
                CourseSection("dart_sec_7", "dart", "Bölüm 7 – Nesne Yönelimli Programlama", CourseLevel.ADVANCED, 7, "Class, constructor, inheritance, mixin"),
                CourseSection("dart_sec_8", "dart", "Bölüm 8 – Asenkron Dart & Future", CourseLevel.EXPERT, 8, "Future, async/await, Stream ve Isolates")
            )
            "python" -> listOf(
                CourseSection("py_sec_1", "python", "Bölüm 1 – Python'a Giriş", CourseLevel.BEGINNER, 1, "Sözdizimi, print() ve ilk betik"),
                CourseSection("py_sec_2", "python", "Bölüm 2 – Değişkenler & Veri Tipleri", CourseLevel.BEGINNER, 2, "str, int, float, bool ve tip dönüşümleri"),
                CourseSection("py_sec_3", "python", "Bölüm 3 – Operatörler & Koşullar", CourseLevel.FUNDAMENTAL, 3, "if, elif, else ve mantıksal operatörler"),
                CourseSection("py_sec_4", "python", "Bölüm 4 – Döngüler & range()", CourseLevel.FUNDAMENTAL, 4, "for, while, range ve döngü kontrolleri"),
                CourseSection("py_sec_5", "python", "Bölüm 5 – Listeler & Sözlükler", CourseLevel.INTERMEDIATE, 5, "List, tuple, dict, set ve metodları"),
                CourseSection("py_sec_6", "python", "Bölüm 6 – Fonksiyonlar & Lambdalar", CourseLevel.INTERMEDIATE, 6, "def, *args, **kwargs, lambda ve scope"),
                CourseSection("py_sec_7", "python", "Bölüm 7 – OOP (Sınıflar & Kalıtım)", CourseLevel.ADVANCED, 7, "class, self, __init__, dunder metotlar"),
                CourseSection("py_sec_8", "python", "Bölüm 8 – Asenkron & Hata Yönetimi", CourseLevel.EXPERT, 8, "async/await, try-except, generator ve decorators")
            )
            "cpp" -> listOf(
                CourseSection("cpp_sec_1", "cpp", "Bölüm 1 – C++ Temelleri", CourseLevel.BEGINNER, 1, "Giriş, main(), cout, cin ve derleme süreci"),
                CourseSection("cpp_sec_2", "cpp", "Bölüm 2 – Değişkenler & Veri Tipleri", CourseLevel.BEGINNER, 2, "int, double, char, string, bool ve boyutlar"),
                CourseSection("cpp_sec_3", "cpp", "Bölüm 3 – Operatörler & Koşullar", CourseLevel.FUNDAMENTAL, 3, "Aritmetik ve if-else, switch"),
                CourseSection("cpp_sec_4", "cpp", "Bölüm 4 – Döngüler & Fonksiyonlar", CourseLevel.FUNDAMENTAL, 4, "for, while döngüleri ve modüler fonksiyonlar"),
                CourseSection("cpp_sec_5", "cpp", "Bölüm 5 – Pointer & Referanslar", CourseLevel.INTERMEDIATE, 5, "Bellek adresleri, * ve & operatörleri"),
                CourseSection("cpp_sec_6", "cpp", "Bölüm 6 – Dinamik Bellek Yönetimi", CourseLevel.ADVANCED, 6, "new, delete, smart pointers ve memory leak önleme"),
                CourseSection("cpp_sec_7", "cpp", "Bölüm 7 – OOP & Kalıtım (Inheritance)", CourseLevel.ADVANCED, 7, "Class, constructor, destructor, virtual metotlar"),
                CourseSection("cpp_sec_8", "cpp", "Bölüm 8 – STL & Modern C++", CourseLevel.EXPERT, 8, "vector, map, algoritmalar, templates ve lambda")
            )
            "kotlin" -> listOf(
                CourseSection("kt_sec_1", "kotlin", "Bölüm 1 – Kotlin'e Giriş", CourseLevel.BEGINNER, 1, "Modern Kotlin felsefesi ve ilk kod"),
                CourseSection("kt_sec_2", "kotlin", "Bölüm 2 – val vs var & Tipler", CourseLevel.BEGINNER, 2, "Değişmezlik ve temel tipler"),
                CourseSection("kt_sec_3", "kotlin", "Bölüm 3 – Null Güvenliği (Null Safety)", CourseLevel.FUNDAMENTAL, 3, "?, ?., ?: (Elvis operatörü) ve !! kullanımı"),
                CourseSection("kt_sec_4", "kotlin", "Bölüm 4 – Kontrol Akışı & When", CourseLevel.FUNDAMENTAL, 4, "when ifadesi ve akıllı tip dönüşümü"),
                CourseSection("kt_sec_5", "kotlin", "Bölüm 5 – Fonksiyonlar & Lambdalar", CourseLevel.INTERMEDIATE, 5, "Higher-order functions ve extension functions"),
                CourseSection("kt_sec_6", "kotlin", "Bölüm 6 – Data Classes & OOP", CourseLevel.INTERMEDIATE, 6, "data class, sealed class, abstract & interface"),
                CourseSection("kt_sec_7", "kotlin", "Bölüm 7 – Generics & Koleksiyonlar", CourseLevel.ADVANCED, 7, "List, Map, Set, generic parametreler"),
                CourseSection("kt_sec_8", "kotlin", "Bölüm 8 – Coroutines & Asenkron Flow", CourseLevel.EXPERT, 8, "suspend, launch, async, StateFlow ve SharedFlow")
            )
            "rust" -> listOf(
                CourseSection("rust_sec_1", "rust", "Bölüm 1 – Rust'a Giriş", CourseLevel.BEGINNER, 1, "Sistem dili felsefesi ve println! makrosu"),
                CourseSection("rust_sec_2", "rust", "Bölüm 2 – Değişkenler & let mut", CourseLevel.BEGINNER, 2, "Sabitlik (immutability) ve temel skalar tipler"),
                CourseSection("rust_sec_3", "rust", "Bölüm 3 – Fonksiyonlar & Kontrol", CourseLevel.FUNDAMENTAL, 3, "Dönüş değerleri, if ifadeleri ve loop"),
                CourseSection("rust_sec_4", "rust", "Bölüm 4 – Sahiplik (Ownership)", CourseLevel.FUNDAMENTAL, 4, "Rust'ın bellek güvenlik motoru ve move semantiği"),
                CourseSection("rust_sec_5", "rust", "Bölüm 5 – Borrowing & Referanslar", CourseLevel.INTERMEDIATE, 5, "& ve &mut kuralları, veri yarışlarını önleme"),
                CourseSection("rust_sec_6", "rust", "Bölüm 6 – Structs & Enums", CourseLevel.INTERMEDIATE, 6, "Özel veri yapıları ve match pattern matching"),
                CourseSection("rust_sec_7", "rust", "Bölüm 7 – Traits & Generics", CourseLevel.ADVANCED, 7, "Ortak davranışlar, trait bounds ve soyutlama"),
                CourseSection("rust_sec_8", "rust", "Bölüm 8 – Hata Yönetimi & Async", CourseLevel.EXPERT, 8, "Result<T, E>, Option<T>, panic ve async/await")
            )
            "javascript" -> listOf(
                CourseSection("js_sec_1", "javascript", "Bölüm 1 – JS Giriş & Temeller", CourseLevel.BEGINNER, 1, "Web'in dili, console.log ve sözdizimi"),
                CourseSection("js_sec_2", "javascript", "Bölüm 2 – let, const & Veri Tipleri", CourseLevel.BEGINNER, 2, "Primitive tipler, template literals ve scope"),
                CourseSection("js_sec_3", "javascript", "Bölüm 3 – Operatörler & Koşullar", CourseLevel.FUNDAMENTAL, 3, "== vs ===, ternary operatör, if-else"),
                CourseSection("js_sec_4", "javascript", "Bölüm 4 – Fonksiyonlar & Arrow", CourseLevel.FUNDAMENTAL, 4, "() => {}, default parametreler ve rest operator"),
                CourseSection("js_sec_5", "javascript", "Bölüm 5 – Dizi Metodları", CourseLevel.INTERMEDIATE, 5, "map, filter, reduce, find ve forEach"),
                CourseSection("js_sec_6", "javascript", "Bölüm 6 – Nesneler & Destructuring", CourseLevel.INTERMEDIATE, 6, "Object manipulation, spread (...) ve JSON"),
                CourseSection("js_sec_7", "javascript", "Bölüm 7 – Promises & Async/Await", CourseLevel.ADVANCED, 7, "Asenkron mimari, fetch API ve hata yönetimi"),
                CourseSection("js_sec_8", "javascript", "Bölüm 8 – ES6+ Modülleri & Sınıflar", CourseLevel.EXPERT, 8, "Class, inheritance, import/export ve closure")
            )
            "flutter" -> listOf(
                CourseSection("fl_sec_1", "flutter", "Bölüm 1 – Flutter Mimarisi", CourseLevel.BEGINNER, 1, "Widget ağacı ve temel Scaffold yapısı"),
                CourseSection("fl_sec_2", "flutter", "Bölüm 2 – Stateless & Stateful", CourseLevel.BEGINNER, 2, "Durum kavramı ve setState() mekanizması"),
                CourseSection("fl_sec_3", "flutter", "Bölüm 3 – Layout: Row, Column & Box", CourseLevel.FUNDAMENTAL, 3, "Flexbox mantığı, Padding, Center ve Stack"),
                CourseSection("fl_sec_4", "flutter", "Bölüm 4 – Kullanıcı Girdileri & Form", CourseLevel.FUNDAMENTAL, 4, "TextField, ElevatedButton, validator ve Controller"),
                CourseSection("fl_sec_5", "flutter", "Bölüm 5 – ListView & Dinamik Listeler", CourseLevel.INTERMEDIATE, 5, "ListView.builder, GridView ve Card tasarımları"),
                CourseSection("fl_sec_6", "flutter", "Bölüm 6 – Navigasyon & Sayfa Geçişleri", CourseLevel.INTERMEDIATE, 6, "Navigator.push, pop ve MaterialPageRoute"),
                CourseSection("fl_sec_7", "flutter", "Bölüm 7 – Durum Yönetimi (State Mgmt)", CourseLevel.ADVANCED, 7, "Provider, Riverpod ve Bloc mimarileri"),
                CourseSection("fl_sec_8", "flutter", "Bölüm 8 – REST API & HTTP İstekleri", CourseLevel.EXPERT, 8, "http paketi, async API çağrıları ve JSON modelleme")
            )
            else -> listOf(
                CourseSection("${courseId}_sec_1", courseId, "Bölüm 1 – Başlangıç & Giriş", CourseLevel.BEGINNER, 1, "Temel kavramlar ve merhaba dünya"),
                CourseSection("${courseId}_sec_2", courseId, "Bölüm 2 – Değişkenler & Tipler", CourseLevel.BEGINNER, 2, "Temel veri tipleri ve değer atama"),
                CourseSection("${courseId}_sec_3", courseId, "Bölüm 3 – Operatörler & Koşullar", CourseLevel.FUNDAMENTAL, 3, "Karar yapıları ve mantık"),
                CourseSection("${courseId}_sec_4", courseId, "Bölüm 4 – Döngüler & Yapılar", CourseLevel.INTERMEDIATE, 4, "Tekrarlayan işlemler"),
                CourseSection("${courseId}_sec_5", courseId, "Bölüm 5 – İleri Düzey Konular", CourseLevel.ADVANCED, 5, "Mimari ve modüller")
            )
        }
    }

    fun getLessonsForCourse(courseId: String): List<Lesson> {
        return when (courseId) {
            "dart" -> getDartLessons()
            "python" -> getPythonLessons()
            "cpp" -> getCppLessons()
            "kotlin" -> getKotlinLessons()
            "rust" -> getRustLessons()
            "javascript" -> getJavaScriptLessons()
            "flutter" -> getFlutterLessons()
            else -> getDartLessons()
        }
    }

    // ==========================================
    // DART DERSLERİ (1, 2, 3 Ücretsiz | 4..8 Premium)
    // ==========================================
    private fun getDartLessons(): List<Lesson> = listOf(
        Lesson(
            id = "dart_1",
            courseId = "dart",
            sectionId = "dart_sec_1",
            title = "Dart'a Giriş & İlk Program",
            shortDesc = "Dart dili mimarisi, main() fonksiyonu ve print() ile konsol çıktısı.",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false, // ÜCRETSİZ (Ders 1)
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Dart Nedir?",
                    body = "Dart, Google tarafından geliştirilen, istemci tarafı optimizasyonlu, hızlı ve nesne yönelimli modern bir programlama dilidir. Özellikle popüler Flutter framework'ünün ana dili olarak bilinir."
                ),
                LessonContentBlock(
                    subtitle = "2. main() Fonksiyonu",
                    body = "Her Dart uygulamasının başlangıç noktası 'main()' fonksiyonudur. Program çalıştırıldığında işletim sistemi ilk olarak bu fonksiyonu yürütür.",
                    codeSnippet = "void main() {\n  print('Merhaba Dünya!');\n}"
                ),
                LessonContentBlock(
                    subtitle = "3. Temel Sözdizimi Kuralları",
                    body = "Dart'ta her kod satırı noktalı virgül (;) ile bitmek zorundadır. Harf büyüklüğüne duyarlıdır (case-sensitive)."
                )
            ),
            codeExample = "void main() {\n  print('Kod Akademi Dart Kursuna Hoş Geldiniz!');\n  print(5 + 3);\n}",
            codeExplanation = "void main() dönüş tipi olmayan ana fonksiyondur. print() ise içerisine verilen değeri konsola yazdırır.",
            starterPlaygroundCode = "void main() {\n  // İlk Dart kodunu buraya yaz:\n  print('Merhaba Kod Akademi!');\n}\n",
            miniQuestion = MiniQuestion(
                id = "dart_mini_1",
                question = "Dart programlarının çalışma başlangıç noktası olan ana fonksiyon hangisidir?",
                options = listOf("start()", "main()", "run()", "init()"),
                correctIndex = 1,
                explanation = "Tüm Dart programları 'void main()' fonksiyonu ile çalışmaya başlar."
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "dart_q1_1",
                    lessonId = "dart_1",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Dart programlama dilinde her ifade hangi karakter ile sonlandırılmalıdır?",
                    options = listOf("Nokta (.)", "İki nokta üst üste (:)", "Noktalı virgül (;)", "Virgül (,)"),
                    correctOptionIndex = 2,
                    explanationRight = "Harika! Dart sözdiziminde satırlar noktalı virgül (;) ile sonlandırılır.",
                    explanationWrong = "Dart'ta ifadelerin sonuna noktalı virgül (;) koymak zorunludur.",
                    reviewTopic = "Dart Sözdizimi Kuralları"
                )
            ),
            codingChallenge = CodingChallenge(
                id = "dart_ch_1",
                lessonId = "dart_1",
                title = "Dart ile Karşılama Mesajı",
                instructions = "Konsola tam olarak 'Dart Ogreniyorum' yazdıran bir Dart programı yazınız.",
                exampleInput = "(Girdi yok)",
                exampleOutput = "Dart Ogreniyorum",
                starterCode = "void main() {\n  // Kodunu buraya yaz:\n  \n}",
                solutionCode = "void main() {\n  print('Dart Ogreniyorum');\n}",
                hints = listOf(
                    "print() fonksiyonunu kullanın.",
                    "Metni tek veya çift tırnak arasına alın.",
                    "Satır sonuna noktalı virgül (;) koymayı unutmayın: print('Dart Ogreniyorum');"
                ),
                testCases = listOf(
                    TestCase("", "Dart Ogreniyorum", "Konsol çıktısı kontrolü")
                )
            )
        ),
        Lesson(
            id = "dart_2",
            courseId = "dart",
            sectionId = "dart_sec_2",
            title = "Değişkenler ve Temel Tipler",
            shortDesc = "var, String, int, double, bool, final ve const kavramları.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false, // ÜCRETSİZ (Ders 2)
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Veri Tipleri",
                    body = "Dart güçlü tipli (strongly typed) bir dildir. Temel tipler: int (tam sayı), double (ondalıklı), String (metin), bool (doğru/yanlış)."
                ),
                LessonContentBlock(
                    subtitle = "2. 'var' ile Tip Çıkarımı (Type Inference)",
                    body = "var ile tanımlanan değişkenin tipi atanan ilk değere göre otomatik belirlenir.",
                    codeSnippet = "var isim = 'Ahmet'; // String olarak belirlenir"
                ),
                LessonContentBlock(
                    subtitle = "3. final ve const",
                    body = "final: Çalışma anında (runtime) bir kez değer alır ve değiştirilemez.\nconst: Derleme anında (compile-time) sabittir."
                )
            ),
            codeExample = "void main() {\n  String dil = 'Dart';\n  int versiyon = 3;\n  double puan = 9.8;\n  bool begenildiMi = true;\n  print('\$dil \$versiyon puanı: \$puan');\n}",
            codeExplanation = "\$ işareti ile string interpolation (metin içine değişken gömme) yapılır.",
            starterPlaygroundCode = "void main() {\n  String ad = 'Mobil Geliştirici';\n  int deneyimYili = 2;\n  print('\$ad - \$deneyimYili Yıl');\n}",
            miniQuestion = MiniQuestion(
                id = "dart_mini_2",
                question = "Dart'ta String içine değişken değeri gömmek için hangi sembol kullanılır?",
                options = listOf("&", "#", "$", "@"),
                correctIndex = 2,
                explanation = "Dart'ta '\$degisken' veya '\${ifade}' şeklinde String interpolation kullanılır."
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "dart_q2_1",
                    lessonId = "dart_2",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir kez değer atandıktan sonra ASLA değiştirilemeyen derleme zamanı sabiti hangisidir?",
                    options = listOf("var", "dynamic", "const", "late"),
                    correctOptionIndex = 2,
                    explanationRight = "Doğru! 'const' derleme anında sabit olan değerler için kullanılır.",
                    explanationWrong = "'const' derleme zamanı değişmez sabittir. 'var' değiştirilebilir değişkendir.",
                    reviewTopic = "final ve const farkı"
                )
            ),
            codingChallenge = CodingChallenge(
                id = "dart_ch_2",
                lessonId = "dart_2",
                title = "İki Sayının Toplamı",
                instructions = "int a = 15 ve int b = 25 değişkenlerini oluşturup toplamlarını 'Toplam: 40' şeklinde yazdırın.",
                exampleInput = "(Girdi yok)",
                exampleOutput = "Toplam: 40",
                starterCode = "void main() {\n  int a = 15;\n  int b = 25;\n  // Toplamı yazdırın:\n}",
                solutionCode = "void main() {\n  int a = 15;\n  int b = 25;\n  print('Toplam: \${a + b}');\n}",
                hints = listOf(
                    "a + b işlemini yapın.",
                    "Dize içinde işlem için \${a + b} formatını kullanın."
                ),
                testCases = listOf(
                    TestCase("", "Toplam: 40", "Değişken toplama testi")
                )
            )
        ),
        Lesson(
            id = "dart_3",
            courseId = "dart",
            sectionId = "dart_sec_3",
            title = "Operatörler ve Mantıksal İşlemler",
            shortDesc = "Aritmetik, karşılaştırma ve mantıksal operatörler.",
            level = CourseLevel.FUNDAMENTAL,
            order = 3,
            isPremium = false, // ÜCRETSİZ (Ders 3)
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Aritmetik Operatörler",
                    body = "+ (Toplama), - (Çıkarma), * (Çarpma), / (Bölme), ~/ (Tam Sayı Bölme), % (Mod / Kalan)"
                ),
                LessonContentBlock(
                    subtitle = "2. Karşılaştırma ve Mantıksal",
                    body = "== (Eşit mi), != (Eşit değil mi), > (Büyük), < (Küçük), && (VE), || (VEYA), ! (DEĞİL)"
                )
            ),
            codeExample = "void main() {\n  int x = 17;\n  int y = 5;\n  print('Tam Bolum: \${x ~/ y}'); // 3\n  print('Kalan: \${x % y}'); // 2\n}",
            codeExplanation = "~/ operatörü ondalık kısmı atıp sadece tam sayı bölümünü döndürür.",
            starterPlaygroundCode = "void main() {\n  int yas = 20;\n  bool yetiskinMi = yas >= 18;\n  print('Reşit mi: \$yetiskinMi');\n}"
        ),
        Lesson(
            id = "dart_4",
            courseId = "dart",
            sectionId = "dart_sec_4",
            title = "Koşul Yapıları: if, else ve switch-case",
            shortDesc = "Karar mekanizmaları, ternary operatör ve pattern matching.",
            level = CourseLevel.FUNDAMENTAL,
            order = 4,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. if - else if - else",
                    body = "Belirli bir koşulun doğru (true) ya da yanlış (false) olmasına göre farklı kod bloklarını çalıştırır."
                ),
                LessonContentBlock(
                    subtitle = "2. Ternary Operatör (? :)",
                    body = "Kısa koşul yazımı: koşul ? dogruysa : yanlissa",
                    codeSnippet = "var sonuc = (puan >= 50) ? 'Geçti' : 'Kaldı';"
                )
            ),
            codeExample = "void main() {\n  int notu = 85;\n  if (notu >= 90) {\n    print('AA');\n  } else if (notu >= 80) {\n    print('BA');\n  } else {\n    print('Gecti');\n  }\n}",
            codeExplanation = "Koşullar yukarıdan aşağıya kontrol edilir, ilk sağlanan blok çalışır.",
            starterPlaygroundCode = "void main() {\n  int saat = 14;\n  String selam = (saat < 12) ? 'Gunaydin' : 'Iyi Gunler';\n  print(selam);\n}"
        ),
        Lesson(
            id = "dart_5",
            courseId = "dart",
            sectionId = "dart_sec_5",
            title = "Döngüler: for, while ve do-while",
            shortDesc = "Tekrarlı işlemler, break & continue, for-in yapısı.",
            level = CourseLevel.INTERMEDIATE,
            order = 5,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. for ve for-in",
                    body = "for (int i = 0; i < 5; i++) ile sayaçlı döngü veya for (var item in list) ile koleksiyon üzerinde gezinme yapılır."
                )
            ),
            codeExample = "void main() {\n  for (int i = 1; i <= 3; i++) {\n    print('Sayac: \$i');\n  }\n}",
            codeExplanation = "i değişkeni 1'den başlar, her adımda 1 artar ve 3 dahil olana kadar döner.",
            starterPlaygroundCode = "void main() {\n  var diller = ['Dart', 'Kotlin', 'Rust'];\n  for (var d in diller) {\n    print('Dil: \$d');\n  }\n}"
        ),
        Lesson(
            id = "dart_6",
            courseId = "dart",
            sectionId = "dart_sec_6",
            title = "Koleksiyonlar: List, Set ve Map",
            shortDesc = "Diziler, benzersiz kümeler, anahtar-değer haritaları ve koleksiyon metodları.",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. List, Set ve Map",
                    body = "List: Sıralı ve indeksli elemanlar. Set: Benzersiz elemanlar kümesi. Map: Key-value (anahtar-değer) çiftleri."
                )
            ),
            codeExample = "void main() {\n  List<String> sehirler = ['Ankara', 'Istanbul', 'Izmir'];\n  Map<String, int> plakalar = {'Ankara': 6, 'Istanbul': 34};\n  print('Ankara Plaka: \${plakalar['Ankara']}');\n}",
            codeExplanation = "Map içinde anahtar verilerek değere erişilir.",
            starterPlaygroundCode = "void main() {\n  var sayilar = [1, 2, 3, 4, 5];\n  var kareler = sayilar.map((e) => e * e).toList();\n  print(kareler);\n}"
        ),
        Lesson(
            id = "dart_7",
            courseId = "dart",
            sectionId = "dart_sec_7",
            title = "OOP: Sınıflar, Kalıtım ve Mixinler",
            shortDesc = "Class yapısı, constructor, extend, abstract class ve 'with' anahtar kelimesi.",
            level = CourseLevel.ADVANCED,
            order = 7,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Dart Sınıf Mimarisi",
                    body = "Dart saf nesne yönelimli bir dildir. Her şey bir nesnedir. Mixin ile çoklu kalıtım davranışı kazanılır."
                )
            ),
            codeExample = "class Araba {\n  String marka;\n  int yil;\n  Araba(this.marka, this.yil);\n  void calis() => print('\$marka calisiyor.');\n}\nvoid main() {\n  var oto = Araba('Tesla', 2024);\n  oto.calis();\n}",
            codeExplanation = "this.marka ile constructor kısa yoldan alanlara değer atar.",
            starterPlaygroundCode = "class Kisi {\n  String isim;\n  Kisi(this.isim);\n}\nvoid main() {\n  var k = Kisi('Ali');\n  print(k.isim);\n}"
        ),
        Lesson(
            id = "dart_8",
            courseId = "dart",
            sectionId = "dart_sec_8",
            title = "Asenkron Dart: Future, async/await & Streams",
            shortDesc = "Ağ istekleri, dosya okuma ve eşzamanlı veri akışları.",
            level = CourseLevel.EXPERT,
            order = 8,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Future ve async / await",
                    body = "Future, gelecekte tamamlanacak bir değeri temsil eder. 'await' anahtar kelimesi ile asenkron işlem senkron gibi beklenir."
                )
            ),
            codeExample = "Future<String> veriGetir() async {\n  await Future.delayed(Duration(seconds: 1));\n  return 'Veri Geldi!';\n}\nvoid main() async {\n  var veri = await veriGetir();\n  print(veri);\n}",
            codeExplanation = "async fonksiyonlar her zaman Future döndürür.",
            starterPlaygroundCode = "void main() async {\n  print('Basladi');\n  await Future.delayed(Duration(milliseconds: 500));\n  print('Bitti');\n}"
        )
    )

    // ==========================================
    // PYTHON DERSLERİ (1, 2, 3 Ücretsiz | 4..8 Premium)
    // ==========================================
    private fun getPythonLessons(): List<Lesson> = listOf(
        Lesson(
            id = "py_1",
            courseId = "python",
            sectionId = "py_sec_1",
            title = "Python'a Giriş & İlk Betik",
            shortDesc = "Python nedir, neden bu kadar popüler ve print() kullanımı.",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false, // ÜCRETSİZ (Ders 1)
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Python Nedir?",
                    body = "Python, okunabilirliği ve sade sözdizimi ile ünlü, dinamik tipli, yorumlanan yüksek seviyeli bir programlama dilidir. Veri bilimi, yapay zeka, web geliştirme ve otomasyonda lider konumdadır."
                ),
                LessonContentBlock(
                    subtitle = "2. İlk Python Kodu: print()",
                    body = "Python'da süslü parantez veya noktalı virgül gerekmez! Kod blokları girintilerle (indentation) belirlenir.",
                    codeSnippet = "print('Merhaba Kod Akademi Python Kursu!')"
                )
            ),
            codeExample = "# Python'da ilk kodumuz\nprint('Yapay Zeka Dünyasına Hoş Geldiniz!')\nprint(10 + 5 * 2) # 20",
            codeExplanation = "print() ekrana metin veya matematiksel işlem sonucunu yazdırır.",
            starterPlaygroundCode = "# İlk Python kodunu yaz ve Çalıştır'a tıkla:\nprint('Merhaba Python!')\n",
            miniQuestion = MiniQuestion(
                id = "py_mini_1",
                question = "Python'da kod blokları ve kapsam ne ile belirlenir?",
                options = listOf("Süslü parantez {}", "Girinti (Indentation / Boşluk)", "Noktalı virgül ;", "BEGIN-END"),
                correctIndex = 1,
                explanation = "Python'da kod blokları girintiler (genelde 4 boşluk veya Tab) ile ayrılır."
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_q1_1",
                    lessonId = "py_1",
                    questionType = QuestionType.GUESS_OUTPUT,
                    questionText = "Aşağıdaki Python kodunun çıktısı nedir?",
                    codeSnippet = "print('3' + '4')",
                    options = listOf("7", "34", "Hata verir", "3 4"),
                    correctOptionIndex = 1,
                    explanationRight = "Tebrikler! Metin (string) toplama işlemi iki metni birleştirir ('3' + '4' = '34').",
                    explanationWrong = "Tırnak içindeki değerler stringdir. String birleştirme (concatenation) '34' üretir.",
                    reviewTopic = "String Birleştirme"
                )
            ),
            codingChallenge = CodingChallenge(
                id = "py_ch_1",
                lessonId = "py_1",
                title = "Python Print Görevi",
                instructions = "Konsola 'Python ile Kodluyorum' yazdıran kodu yazınız.",
                exampleInput = "(Girdi yok)",
                exampleOutput = "Python ile Kodluyorum",
                starterCode = "# Kodunu buraya yaz:\n",
                solutionCode = "print('Python ile Kodluyorum')",
                hints = listOf(
                    "print() fonksiyonunu çağırın.",
                    "İçine 'Python ile Kodluyorum' metnini yerleştirin."
                ),
                testCases = listOf(
                    TestCase("", "Python ile Kodluyorum", "Çıktı doğrulama")
                )
            )
        ),
        Lesson(
            id = "py_2",
            courseId = "python",
            sectionId = "py_sec_2",
            title = "Değişkenler ve Veri Tipleri",
            shortDesc = "str, int, float, bool ve f-string kullanımı.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false, // ÜCRETSİZ (Ders 2)
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Değişken Tanımlama",
                    body = "Python'da değişken tanımlarken tür yazılmaz, doğrudan değer atanır: x = 10, isim = 'Ece'."
                ),
                LessonContentBlock(
                    subtitle = "2. f-string Biçimlendirme",
                    body = "Metinlerin içine değişken yerleştirmek için f'Merhaba {isim}' sözdizimi kullanılır."
                )
            ),
            codeExample = "isim = 'Kod Akademi'\nyas = 3\npuan = 99.8\nprint(f'{isim} platformu {yas} yasinda, Puani: {puan}')",
            codeExplanation = "f-string değişkenleri otomatik metne dönüştürür.",
            starterPlaygroundCode = "dil = 'Python'\nseviye = 'Ileri'\nprint(f'Kurs: {dil} - {seviye}')",
            quizQuestions = listOf(
                QuizQuestion(
                    id = "py_q2_1",
                    lessonId = "py_2",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "type(3.14) fonksiyonunun döndüreceği tür nedir?",
                    options = listOf("<class 'int'>", "<class 'float'>", "<class 'double'>", "<class 'str'>"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Python'da ondalıklı sayılar 'float' sınıfına aittir.",
                    explanationWrong = "Python'da ondalıklı sayılar 'float' olarak adlandırılır.",
                    reviewTopic = "Python Veri Tipleri"
                )
            )
        ),
        Lesson(
            id = "py_3",
            courseId = "python",
            sectionId = "py_sec_3",
            title = "Operatörler ve Koşullar (if-elif-else)",
            shortDesc = "Mantıksal karar ağaçları ve karşılaştırma operatörleri.",
            level = CourseLevel.FUNDAMENTAL,
            order = 3,
            isPremium = false, // ÜCRETSİZ (Ders 3)
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "if - elif - else",
                    body = "Koşullara göre kod bloklarını dallandırır. İki nokta (:) ve girintiye dikkat edilmelidir."
                )
            ),
            codeExample = "puan = 85\nif puan >= 90:\n    print('A')\nelif puan >= 75:\n    print('B')\nelse:\n    print('C')",
            codeExplanation = "85 sayısı 75-90 aralığında olduğu için 'B' yazdırılır.",
            starterPlaygroundCode = "x = 15\nif x % 2 == 0:\n    print('Cift')\nelse:\n    print('Tek')"
        ),
        Lesson(
            id = "py_4",
            courseId = "python",
            sectionId = "py_sec_4",
            title = "Döngüler: for, while & range()",
            shortDesc = "range() fonksiyonu, döngü kontrolleri ve listeler üzerinde gezinme.",
            level = CourseLevel.FUNDAMENTAL,
            order = 4,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "range() ve for Döngüsü",
                    body = "for i in range(1, 6): 1'den 5'e kadar olan sayıları sırayla üretir."
                )
            ),
            codeExample = "for i in range(1, 4):\n    print(f'Sayi: {i}')",
            codeExplanation = "1, 2 ve 3 sayılarını yazdırır.",
            starterPlaygroundCode = "toplam = 0\nfor i in [10, 20, 30]:\n    toplam += i\nprint(f'Toplam: {toplam}')"
        ),
        Lesson(
            id = "py_5",
            courseId = "python",
            sectionId = "py_sec_5",
            title = "Listeler, Sözlükler (Dict) & Set",
            shortDesc = "List comprehension, key-value sözlükler ve küme metodları.",
            level = CourseLevel.INTERMEDIATE,
            order = 5,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "List & Dictionary",
                    body = "Listeler [] ile sıralı verileri, Dictionary {} ise anahtar-değer (key-value) eşleşmelerini saklar."
                )
            ),
            codeExample = "ogrenci = {'ad': 'Ali', 'not': 95}\nprint(ogrenci['ad'])\nkareler = [x**2 for x in range(5)]\nprint(kareler) # [0, 1, 4, 9, 16]",
            codeExplanation = "List comprehension ile tek satırda liste dönüştürme yapılır.",
            starterPlaygroundCode = "veriler = {'python': 100, 'dart': 90}\nprint(veriler.keys())"
        ),
        Lesson(
            id = "py_6",
            courseId = "python",
            sectionId = "py_sec_6",
            title = "Fonksiyonlar: def, *args, **kwargs & Lambda",
            shortDesc = "Parametre aktarımı, varsayılan argümanlar ve anonim tek satırlık lambda fonksiyonları.",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Fonksiyon Tanımı",
                    body = "def topla(a, b=0): return a + b; *args değişken sayıda argüman almayı sağlar."
                )
            ),
            codeExample = "kare = lambda x: x * x\nprint(kare(6)) # 36\n\ndef selamla(isim='Ziyaretci'):\n    return f'Hos geldin {isim}'\nprint(selamla('Deniz'))",
            codeExplanation = "lambda tek satırlık pratik fonksiyonlar üretir.",
            starterPlaygroundCode = "def carp(*sayilar):\n    sonuc = 1\n    for s in sayilar: sonuc *= s\n    return sonuc\nprint(carp(2, 3, 4))"
        ),
        Lesson(
            id = "py_7",
            courseId = "python",
            sectionId = "py_sec_7",
            title = "OOP: Sınıflar, Kalıtım & Dunder Metotlar",
            shortDesc = "class yapısı, self parametresi, __init__, __str__ ve çok biçimlilik.",
            level = CourseLevel.ADVANCED,
            order = 7,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Python'da Nesne Tabanlı Programlama",
                    body = "__init__ constructor'dır. self nesnenin kendisini referans eder."
                )
            ),
            codeExample = "class Robot:\n    def __init__(self, model):\n        self.model = model\n    def calis(self):\n        return f'{self.model} devrede.'\n\nr = Robot('Atlas')\nprint(r.calis())",
            codeExplanation = "Robot sınıfından üretilen 'r' nesnesi kendi model adını saklar.",
            starterPlaygroundCode = "class Araba:\n    def __init__(self, marka):\n        self.marka = marka\na = Araba('BMW')\nprint(a.marka)"
        ),
        Lesson(
            id = "py_8",
            courseId = "python",
            sectionId = "py_sec_8",
            title = "Asenkron Python & Hata Yönetimi",
            shortDesc = "async/await, asyncio mimarisi, try-except-finally ve context managers.",
            level = CourseLevel.EXPERT,
            order = 8,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Asyncio ve Hata Yakalama",
                    body = "try-except blokları olası çökmeleri yakalar. async/await ile eşzamanlı I/O işlemleri hızlandırılır."
                )
            ),
            codeExample = "import asyncio\n\nasync def veri_cek():\n    await asyncio.sleep(0.5)\n    return 'API Verisi'\n\n# try-except ornegi:\ntry:\n    sayi = int('abc')\nexcept ValueError:\n    print('Sayiya donusturulemedi!')",
            codeExplanation = "ValueError hatası yakalanarak programın çökmesi engellenir.",
            starterPlaygroundCode = "try:\n    x = 10 / 0\nexcept ZeroDivisionError:\n    print('Sıfıra bolunemez!')"
        )
    )

    // ==========================================
    // C++ DERSLERİ (1, 2, 3 Ücretsiz | 4..8 Premium)
    // ==========================================
    private fun getCppLessons(): List<Lesson> = listOf(
        Lesson(
            id = "cpp_1",
            courseId = "cpp",
            sectionId = "cpp_sec_1",
            title = "C++ Temelleri & cout ile Çıktı",
            shortDesc = "iostream kütüphanesi, main() fonksiyonu ve derleme prensipleri.",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false, // ÜCRETSİZ (Ders 1)
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. C++ Nedir?",
                    body = "C++, Bjarne Stroustrup tarafından geliştirilmiş, doğrudan donanıma erişebilen, yüksek performanslı ve nesne yönelimli bir dildir."
                ),
                LessonContentBlock(
                    subtitle = "2. İlk C++ Programı",
                    body = "#include <iostream> girdi/çıktı kütüphanesini dahil eder. std::cout konsola yazdırma yapar.",
                    codeSnippet = "#include <iostream>\n\nint main() {\n    std::cout << \"Merhaba C++!\" << std::endl;\n    return 0;\n}"
                )
            ),
            codeExample = "#include <iostream>\nusing namespace std;\n\nint main() {\n    cout << \"C++ ile Yuksek Performans!\" << endl;\n    cout << \"Hesap: \" << (10 * 5) << endl;\n    return 0;\n}",
            codeExplanation = "using namespace std; ile std:: ön eki yazma zorunluluğu kalkar.",
            starterPlaygroundCode = "#include <iostream>\nusing namespace std;\n\nint main() {\n    cout << \"Merhaba Kod Akademi!\" << endl;\n    return 0;\n}",
            miniQuestion = MiniQuestion(
                id = "cpp_mini_1",
                question = "C++'ta konsola veri yazdırmak için hangi nesne kullanılır?",
                options = listOf("cin", "cout", "printf", "scanner"),
                correctIndex = 1,
                explanation = "std::cout (character output) konsola çıktı akışı sağlamak için kullanılır."
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "cpp_q1_1",
                    lessonId = "cpp_1",
                    questionType = QuestionType.GUESS_OUTPUT,
                    questionText = "Aşağıdaki C++ kodunun çıktısı nedir?",
                    codeSnippet = "int x = 10;\nint y = 20;\ncout << x + y;",
                    options = listOf("10", "20", "30", "1020"),
                    correctOptionIndex = 2,
                    explanationRight = "Doğru! x ve y tam sayı olduğu için 10 + 20 = 30 toplanır ve ekrana yazdırılır.",
                    explanationWrong = "Toplama operatörü (+) tam sayılarda aritmetik toplama yapar (10 + 20 = 30).",
                    reviewTopic = "C++ cout ve Aritmetik İşlemler"
                )
            ),
            codingChallenge = CodingChallenge(
                id = "cpp_ch_1",
                lessonId = "cpp_1",
                title = "C++ Çıktı Egzersizi",
                instructions = "cout kullanarak 'Kod Akademi CPP' yazdıran programı yazınız.",
                exampleInput = "(Girdi yok)",
                exampleOutput = "Kod Akademi CPP",
                starterCode = "#include <iostream>\nusing namespace std;\n\nint main() {\n    // Kodunu buraya yaz:\n    \n    return 0;\n}",
                solutionCode = "#include <iostream>\nusing namespace std;\n\nint main() {\n    cout << \"Kod Akademi CPP\";\n    return 0;\n}",
                hints = listOf(
                    "cout << \"...\" formatını kullanın.",
                    "Noktalı virgülü unutmayın."
                ),
                testCases = listOf(
                    TestCase("", "Kod Akademi CPP", "Konsol çıktısı")
                )
            )
        ),
        Lesson(
            id = "cpp_2",
            courseId = "cpp",
            sectionId = "cpp_sec_2",
            title = "Değişkenler ve Veri Tipleri",
            shortDesc = "int, double, char, bool, string ve bellek boyutları.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false, // ÜCRETSİZ (Ders 2)
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Temel Tipler",
                    body = "int (4 byte tam sayı), double (8 byte ondalık), char (1 byte karakter), bool (1 byte mantıksal)."
                )
            ),
            codeExample = "#include <iostream>\n#include <string>\nusing namespace std;\n\nint main() {\n    string ad = \"Ahmet\";\n    int yas = 25;\n    cout << ad << \" \" << yas << \" yasinda.\" << endl;\n    return 0;\n}",
            codeExplanation = "string tipi için <string> kütüphanesi kullanılır.",
            starterPlaygroundCode = "#include <iostream>\nusing namespace std;\n\nint main() {\n    int a = 15;\n    int b = 35;\n    cout << \"Toplam: \" << (a + b) << endl;\n    return 0;\n}"
        ),
        Lesson(
            id = "cpp_3",
            courseId = "cpp",
            sectionId = "cpp_sec_3",
            title = "Operatörler ve Karar Yapıları",
            shortDesc = "Aritmetik mantık, if-else blokları ve switch-case kontrolü.",
            level = CourseLevel.FUNDAMENTAL,
            order = 3,
            isPremium = false, // ÜCRETSİZ (Ders 3)
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Karar Yapıları",
                    body = "if, else if ve switch ifadeleri ile program mantığı yönlendirilir."
                )
            ),
            codeExample = "#include <iostream>\nusing namespace std;\n\nint main() {\n    int puan = 75;\n    if (puan >= 50) cout << \"Gecti\";\n    else cout << \"Kaldi\";\n    return 0;\n}",
            codeExplanation = "Koşul doğru olduğunda 'Gecti' yazdırılır.",
            starterPlaygroundCode = "#include <iostream>\nusing namespace std;\nint main() {\n    int x = 20;\n    cout << (x % 2 == 0 ? \"Cift\" : \"Tek\");\n    return 0;\n}"
        ),
        Lesson(
            id = "cpp_4",
            courseId = "cpp",
            sectionId = "cpp_sec_4",
            title = "Döngüler ve Fonksiyonlar",
            shortDesc = "for, while döngüleri, fonksiyon prototipleri ve değer döndürme.",
            level = CourseLevel.FUNDAMENTAL,
            order = 4,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Modüler Kodlama",
                    body = "Fonksiyonlar kod tekrarını önler. Dönüş tipi, isim ve parametre listesi ile tanımlanır."
                )
            ),
            codeExample = "#include <iostream>\nusing namespace std;\n\nint topla(int a, int b) {\n    return a + b;\n}\nint main() {\n    cout << \"Toplam: \" << topla(12, 8);\n    return 0;\n}",
            codeExplanation = "topla fonksiyonu 20 değerini döndürür.",
            starterPlaygroundCode = "#include <iostream>\nusing namespace std;\nint kare(int n) { return n * n; }\nint main() { cout << kare(5); return 0; }"
        ),
        Lesson(
            id = "cpp_5",
            courseId = "cpp",
            sectionId = "cpp_sec_5",
            title = "Pointer (İşaretçiler) ve Referanslar (&)",
            shortDesc = "Bellek adresleri, * dereference operatörü ve referans değişkenleri.",
            level = CourseLevel.INTERMEDIATE,
            order = 5,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Pointer ve Bellek Adresi",
                    body = "Pointer, başka bir değişkenin bellekteki RAM adresini saklar. & adresi verir, * adresteki değeri okur."
                )
            ),
            codeExample = "int sayi = 100;\nint* ptr = &sayi;\ncout << \"Adres: \" << ptr << \" Deger: \" << *ptr;",
            codeExplanation = "*ptr ile 100 değerine erişilir.",
            starterPlaygroundCode = "int x = 42;\nint& ref = x;\nref = 50;\ncout << x; // 50 yazar"
        ),
        Lesson(
            id = "cpp_6",
            courseId = "cpp",
            sectionId = "cpp_sec_6",
            title = "Dinamik Bellek: new & delete",
            shortDesc = "Heap bellek ayırma, memory leak önleme ve smart pointers (unique_ptr, shared_ptr).",
            level = CourseLevel.ADVANCED,
            order = 6,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Heap Yönetimi",
                    body = "new operatörü heap'ten bellek ayırır, delete ile iade edilmelidir."
                )
            ),
            codeExample = "int* dizi = new int[5];\ndizi[0] = 10;\ndelete[] dizi; // Bellek iade edildi",
            codeExplanation = "delete[] dizi dinamik diziyi bellekten temizler.",
            starterPlaygroundCode = "int* p = new int(99);\ncout << *p;\ndelete p;"
        ),
        Lesson(
            id = "cpp_7",
            courseId = "cpp",
            sectionId = "cpp_sec_7",
            title = "OOP: Sınıflar, Kalıtım & Sanal Metotlar",
            shortDesc = "Kapsülleme (private/public), constructor, destructor ve virtual fonksiyonlar.",
            level = CourseLevel.ADVANCED,
            order = 7,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "C++ OOP Prensipleri",
                    body = "Polymorphism (çok biçimlilik) virtual anahtar kelimesi ile sağlanır."
                )
            ),
            codeExample = "class Hayvan {\npublic:\n    virtual void sesCikar() { cout << \"Ses\"; }\n};\nclass Kopek : public Hayvan {\npublic:\n    void sesCikar() override { cout << \"Hav!\"; }\n};",
            codeExplanation = "override ile türetilen sınıfın davranışı özelleştirilir.",
            starterPlaygroundCode = "class Nokta {\npublic:\n    int x, y;\n    Nokta(int a, int b) : x(a), y(b) {}\n};\nint main() { Nokta n(3, 4); cout << n.x; return 0; }"
        ),
        Lesson(
            id = "cpp_8",
            courseId = "cpp",
            sectionId = "cpp_sec_8",
            title = "STL: vector, map & Şablonlar (Templates)",
            shortDesc = "Standart şablon kütüphanesi (STL), generic algoritmalar ve modern C++20 özellikleri.",
            level = CourseLevel.EXPERT,
            order = 8,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Standard Template Library (STL)",
                    body = "std::vector dinamik dizi, std::map anahtar-değer tablosu sunar. Algoritmalar ile hızlı sıralama yapılır."
                )
            ),
            codeExample = "#include <iostream>\n#include <vector>\n#include <algorithm>\nusing namespace std;\n\nint main() {\n    vector<int> v = {5, 2, 8, 1};\n    sort(v.begin(), v.end());\n    for (int n : v) cout << n << \" \";\n    return 0;\n}",
            codeExplanation = "std::sort vektörü küçükten büyüğe sıralar: 1 2 5 8.",
            starterPlaygroundCode = "#include <vector>\n#include <iostream>\nusing namespace std;\nint main() {\n    vector<string> isimler = {\"Ali\", \"Veli\"};\n    cout << isimler.size();\n    return 0;\n}"
        )
    )

    // ==========================================
    // KOTLIN DERSLERİ (1, 2, 3 Ücretsiz | 4..8 Premium)
    // ==========================================
    private fun getKotlinLessons(): List<Lesson> = listOf(
        Lesson(
            id = "kt_1",
            courseId = "kotlin",
            sectionId = "kt_sec_1",
            title = "Kotlin'e Giriş & Temeller",
            shortDesc = "Android'in resmi dili, println() ve modern sözdizimi.",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false, // ÜCRETSİZ (Ders 1)
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Kotlin Nedir?",
                    body = "Kotlin, JetBrains tarafından geliştirilmiş, JVM üzerinde çalışan, %100 Java ile uyumlu, modern ve ifade gücü yüksek bir programlama dilidir."
                )
            ),
            codeExample = "fun main() {\n    println(\"Kotlin ile Android Gelistirme!\")\n    val a = 10\n    val b = 20\n    println(\"Toplam: \${a + b}\")\n}",
            codeExplanation = "fun main() Kotlin'in başlangıç fonksiyonudur.",
            starterPlaygroundCode = "fun main() {\n    println(\"Merhaba Kotlin!\")\n}",
            quizQuestions = listOf(
                QuizQuestion(
                    id = "kt_q1_1",
                    lessonId = "kt_1",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Kotlin'de değiştirilemeyen (read-only) bir değişken tanımlamak için hangi anahtar kelime kullanılır?",
                    options = listOf("var", "val", "const", "let"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! 'val' (value) değiştirilemeyen, 'var' (variable) değiştirilebilir değişkenler içindir.",
                    explanationWrong = "val değiştirilemez (immutable), var değiştirilebilir (mutable) değişkenler içindir.",
                    reviewTopic = "val vs var"
                )
            )
        ),
        Lesson(
            id = "kt_2",
            courseId = "kotlin",
            sectionId = "kt_sec_2",
            title = "val vs var & Veri Tipleri",
            shortDesc = "Değişmezlik felsefesi ve tip çıkarımı.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false, // ÜCRETSİZ (Ders 2)
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "val vs var",
                    body = "val bir kez değer alır ve değiştirilemez. var ise sonradan güncellenebilir."
                )
            ),
            codeExample = "fun main() {\n    val ulke = \"Turkiye\"\n    var sehir = \"Ankara\"\n    sehir = \"Istanbul\" // Gecerli\n    println(\"\$ulke - \$sehir\")\n}",
            codeExplanation = "ulke val olduğu için değiştirilemez, sehir var olduğu için yeni değer alabilir.",
            starterPlaygroundCode = "fun main() {\n    val x = 5\n    var y = 10\n    y += x\n    println(y)\n}"
        ),
        Lesson(
            id = "kt_3",
            courseId = "kotlin",
            sectionId = "kt_sec_3",
            title = "Null Safety (Null Güvenliği)",
            shortDesc = "Kotlin'in meşhur NullPointerException engelleyici sistemi.",
            level = CourseLevel.FUNDAMENTAL,
            order = 3,
            isPremium = false, // ÜCRETSİZ (Ders 3)
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Nullable Tipler ve Elvis Operatörü",
                    body = "Kotlin'de bir değişken varsayılan olarak null olamaz. Null olabilmesi için '?' eklenmelidir: String? Elvis operatörü (?:) null durumunda varsayılan değer sağlar."
                )
            ),
            codeExample = "fun main() {\n    var isim: String? = null\n    val uzunluk = isim?.length ?: 0\n    println(\"Uzunluk: \$uzunluk\") // 0\n}",
            codeExplanation = "isim null olduğu için ?: 0 devreye girer.",
            starterPlaygroundCode = "fun main() {\n    val metin: String? = \"Kod Akademi\"\n    println(metin?.uppercase() ?: \"BOS\")\n}"
        ),
        Lesson(
            id = "kt_4",
            courseId = "kotlin",
            sectionId = "kt_sec_4",
            title = "Kontrol Akışı: when & İfadeler",
            shortDesc = "Güçlü when yapısı, akıllı tip dönüşümü (smart cast) ve aralıklar (in 1..10).",
            level = CourseLevel.FUNDAMENTAL,
            order = 4,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "when İfadesi",
                    body = "Java'daki switch'in çok daha yetenekli halidir. Sonuç döndürebilir ve aralık kontrolü yapabilir."
                )
            ),
            codeExample = "fun main() {\n    val puan = 85\n    val harf = when (puan) {\n        in 90..100 -> \"AA\"\n        in 80..89 -> \"BA\"\n        else -> \"Gecti\"\n    }\n    println(\"Harf Notu: \$harf\")\n}",
            codeExplanation = "when bir ifade (expression) olarak doğrudan harf değişkenine atanır.",
            starterPlaygroundCode = "fun main() {\n    val gun = 1\n    println(when(gun) { 1 -> \"Pazartesi\"; else -> \"Diger\"; })\n}"
        ),
        Lesson(
            id = "kt_5",
            courseId = "kotlin",
            sectionId = "kt_sec_5",
            title = "Lambdalar & Extension Functions",
            shortDesc = "Genişletme fonksiyonları ve yüksek seviyeli (higher-order) fonksiyonlar.",
            level = CourseLevel.INTERMEDIATE,
            order = 5,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Extension Functions",
                    body = "Mevcut sınıflara kaynak kodlarını değiştirmeden yeni fonksiyonlar eklemenizi sağlar."
                )
            ),
            codeExample = "fun String.unlemEkle(): String = \"\$this!\"\n\nfun main() {\n    println(\"Merhaba\".unlemEkle()) // Merhaba!\n}",
            codeExplanation = "String sınıfına unlemEkle() metodu kazandırıldı.",
            starterPlaygroundCode = "fun Int.kare(): Int = this * this\nfun main() { println(7.kare()) }"
        ),
        Lesson(
            id = "kt_6",
            courseId = "kotlin",
            sectionId = "kt_sec_6",
            title = "Data Classes & Sealed Classes",
            shortDesc = "Otomatik equals/hashCode/copy üreten data class'lar ve durum yönetimi için sealed class'lar.",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Data Class ve Sealed Class",
                    body = "data class veri modelleri içindir. sealed class/interface ise kısıtlı sınıf hiyerarşisi oluşturarak UI State yönetiminde (Loading, Success, Error) mükemmel sonuç verir."
                )
            ),
            codeExample = "data class Kullanici(val id: Int, val isim: String)\n\nsealed class UiState {\n    object Loading : UiState()\n    data class Success(val veri: String) : UiState()\n}",
            codeExplanation = "UiState ile tüm olası durumlar derleme zamanında tip güvenliğiyle ele alınır.",
            starterPlaygroundCode = "data class Kitap(val baslik: String, val sayfa: Int)\nfun main() {\n    val k = Kitap(\"Kotlin\", 300)\n    println(k)\n}"
        ),
        Lesson(
            id = "kt_7",
            courseId = "kotlin",
            sectionId = "kt_sec_7",
            title = "OOP & Kalıtım: Open, Abstract, Interface",
            shortDesc = "Kotlin'de sınıflar varsayılan olarak finaldir. open ile kalıtıma açma ve arayüzler.",
            level = CourseLevel.ADVANCED,
            order = 7,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Kalıtım Kuralları",
                    body = "Bir sınıfın miras alınabilmesi için 'open' anahtar kelimesi ile işaretlenmesi zorunludur."
                )
            ),
            codeExample = "open class Arac(val tekerSayisi: Int)\nclass Bisiklet : Arac(2)\n\nfun main() {\n    val b = Bisiklet()\n    println(\"Teker: \${b.tekerSayisi}\")\n}",
            codeExplanation = "Bisiklet sınıfı Arac sınıfından 2 tekerlekli olarak türer.",
            starterPlaygroundCode = "interface Calisabilir { fun calis() }\nclass Isci : Calisabilir { override fun calis() = println(\"Calisiyor\") }\nfun main() { Isci().calis() }"
        ),
        Lesson(
            id = "kt_8",
            courseId = "kotlin",
            sectionId = "kt_sec_8",
            title = "Coroutines & Asenkron Flow",
            shortDesc = "suspend fonksiyonlar, viewModelScope, StateFlow ve reaktif asenkron akışlar.",
            level = CourseLevel.EXPERT,
            order = 8,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Kotlin Coroutines",
                    body = "Hafif iş parçacıkları (lightweight threads) olarak çalışır. UI thread'ini bloke etmeden arka planda asenkron ağ ve veritabanı işlemlerini yönetir."
                )
            ),
            codeExample = "import kotlinx.coroutines.*\n\nsuspend fun veriGetir(): String {\n    delay(500)\n    return \"Sunucu Yaniti\"\n}\n\nfun main() = runBlocking {\n    val sonuc = veriGetir()\n    println(sonuc)\n}",
            codeExplanation = "suspend fonksiyonlar sadece coroutine kapsamı içinden çağrılabilir.",
            starterPlaygroundCode = "// Coroutines temel prensibi\nprintln(\"Kotlin Coroutines ile ultra hızlı asenkron kodlama!\")"
        )
    )

    // ==========================================
    // RUST DERSLERİ (1, 2, 3 Ücretsiz | 4..8 Premium)
    // ==========================================
    private fun getRustLessons(): List<Lesson> = listOf(
        Lesson(
            id = "rust_1",
            courseId = "rust",
            sectionId = "rust_sec_1",
            title = "Rust'a Giriş & println! Makrosu",
            shortDesc = "Bellek güvenliği felsefesi ve ilk Rust programı.",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false, // ÜCRETSİZ (Ders 1)
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Rust Nedir?",
                    body = "Rust, çöp toplayıcı (garbage collector) olmadan bellek güvenliği sağlayan yenilikçi bir sistem programlama dilidir."
                )
            ),
            codeExample = "fn main() {\n    println!(\"Merhaba Rust ve Kod Akademi!\");\n}",
            codeExplanation = "println! bir fonksiyon değil, bir makrodur (ünlem işareti makro olduğunu gösterir).",
            starterPlaygroundCode = "fn main() {\n    println!(\"Rust ile guvenli kodlama!\");\n}"
        ),
        Lesson(
            id = "rust_2",
            courseId = "rust",
            sectionId = "rust_sec_2",
            title = "Değişkenler ve let mut",
            shortDesc = "Sabitlik felsefesi ve değiştirilebilir değişkenler.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false, // ÜCRETSİZ (Ders 2)
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "let ve mut",
                    body = "Rust'ta değişkenler varsayılan olarak sabittir (immutable). Değiştirebilmek için 'mut' eklenmelidir: let mut x = 5;"
                )
            ),
            codeExample = "fn main() {\n    let mut sayi = 10;\n    sayi += 5;\n    println!(\"Sonuc: {}\", sayi);\n}",
            codeExplanation = "mut sayesinde sayi değeri güncellenebilir.",
            starterPlaygroundCode = "fn main() {\n    let x = 42;\n    println!(\"Deger: {}\", x);\n}"
        ),
        Lesson(
            id = "rust_3",
            courseId = "rust",
            sectionId = "rust_sec_3",
            title = "Veri Tipleri ve Fonksiyonlar",
            shortDesc = "Skalar tipler (i32, f64, bool, char) ve fonksiyon dönüş değerleri.",
            level = CourseLevel.FUNDAMENTAL,
            order = 3,
            isPremium = false, // ÜCRETSİZ (Ders 3)
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Rust Tipleri ve fn",
                    body = "Rust katı statik tiplidir. Fonksiyonlar 'fn' ile tanımlanır ve dönüş tipi '->' ile belirtilir."
                )
            ),
            codeExample = "fn topla(a: i32, b: i32) -> i32 {\n    a + b // Noktali virgulsuz son ifade return demektir\n}\nfn main() {\n    println!(\"Toplam: {}\", topla(15, 25));\n}",
            codeExplanation = "Son satıra noktalı virgül konmazsa otomatik olarak döndürülür.",
            starterPlaygroundCode = "fn kare(x: i32) -> i32 { x * x }\nfn main() { println!(\"{}\", kare(5)); }"
        ),
        Lesson(
            id = "rust_4",
            courseId = "rust",
            sectionId = "rust_sec_4",
            title = "Sahiplik (Ownership) Sistemi",
            shortDesc = "Rust'ın kalbi: Her değerin tek bir sahibi vardır.",
            level = CourseLevel.FUNDAMENTAL,
            order = 4,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Ownership Kuralları",
                    body = "1. Her değerin bir sahibi (owner) değişkeni vardır.\n2. Bir anda yalnızca bir sahip olabilir.\n3. Sahip kapsamdan (scope) çıkınca bellek anında iade edilir (drop)."
                )
            ),
            codeExample = "fn main() {\n    let s1 = String::from(\"Rust\");\n    let s2 = s1; // Sahiplik s2'ye gecti (Move)\n    // s1 artik gecersizdir!\n    println!(\"{}\", s2);\n}",
            codeExplanation = "Move işlemi sayesinde çift serbest bırakma (double free) hatası engellenir.",
            starterPlaygroundCode = "fn main() {\n    let metin = String::from(\"Kod Akademi\");\n    let k = metin.clone();\n    println!(\"{} - {}\", metin, k);\n}"
        ),
        Lesson(
            id = "rust_5",
            courseId = "rust",
            sectionId = "rust_sec_5",
            title = "Borrowing ve Referanslar (&)",
            shortDesc = "Sahipliği devretmeden veriyi ödünç alma kuralları.",
            level = CourseLevel.INTERMEDIATE,
            order = 5,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Referanslar ve Borçlanma",
                    body = "& ile immutable referans, &mut ile mutable referans alınır. Aynı anda birden fazla okuma veya tek bir yazma referansı olabilir."
                )
            ),
            codeExample = "fn uzunluk(s: &String) -> usize {\n    s.len()\n}\nfn main() {\n    let s = String::from(\"Rust\");\n    let len = uzunluk(&s);\n    println!(\"Uzunluk: {}, Metin: {}\", len, s);\n}",
            codeExplanation = "&s sayesinde s değişkeninin sahipliği fonksiyon tarafından tüketilmez.",
            starterPlaygroundCode = "fn main() {\n    let mut sayi = 10;\n    let r = &mut sayi;\n    *r += 5;\n    println!(\"{}\", sayi);\n}"
        ),
        Lesson(
            id = "rust_6",
            courseId = "rust",
            sectionId = "rust_sec_6",
            title = "Structs & Enums: Pattern Matching",
            shortDesc = "Özel veri modelleri, 'match' kontrolü ve Option<T> kullanımı.",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Enums ve Match",
                    body = "Rust'ta null yoktur; yerine Option::Some(T) veya Option::None kullanılır. Match ile tüm durumlar kapsanır."
                )
            ),
            codeExample = "enum Durum {\n    Basarili(String),\n    Hata(i32),\n}\nfn main() {\n    let d = Durum::Basarili(String::from(\"Tamam\"));\n    match d {\n        Durum::Basarili(msg) => println!(\"OK: {}\", msg),\n        Durum::Hata(kod) => println!(\"Hata: {}\", kod),\n    }\n}",
            codeExplanation = "match ifadesi exhaustive'dir (tüm varyantları kontrol etmek zorundadır).",
            starterPlaygroundCode = "struct Nokta { x: i32, y: i32 }\nfn main() {\n    let n = Nokta { x: 10, y: 20 };\n    println!(\"{}, {}\", n.x, n.y);\n}"
        ),
        Lesson(
            id = "rust_7",
            courseId = "rust",
            sectionId = "rust_sec_7",
            title = "Traits ve Generics",
            shortDesc = "Arayüz benzeri ortak davranışlar ve generic tipler.",
            level = CourseLevel.ADVANCED,
            order = 7,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Trait Kavramı",
                    body = "Trait, türlerin paylaştığı metot imzalarını tanımlar."
                )
            ),
            codeExample = "trait OzetiVer {\n    fn ozet(&self) -> String;\n}\nstruct Makale { baslik: String }\nimpl OzetiVer for Makale {\n    fn ozet(&self) -> String { format!(\"Yazi: {}\", self.baslik) }\n}",
            codeExplanation = "impl Trait for Type sözdizimi ile trait uygulanır.",
            starterPlaygroundCode = "fn en_buyuk<T: PartialOrd>(a: T, b: T) -> T {\n    if a > b { a } else { b }\n}\nfn main() { println!(\"{}\", en_buyuk(10, 20)); }"
        ),
        Lesson(
            id = "rust_8",
            courseId = "rust",
            sectionId = "rust_sec_8",
            title = "Hata Yönetimi & Eşzamanlılık (Concurrency)",
            shortDesc = "Result<T, E>, '?' operatörü, thread'ler ve async/await.",
            level = CourseLevel.EXPERT,
            order = 8,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Result ve Güvenli Eşzamanlılık",
                    body = "'?' operatörü hata durumunda fonksiyonu erken sonlandırır. Rust veri yarışlarını derleme anında engeller."
                )
            ),
            codeExample = "use std::thread;\nfn main() {\n    let handle = thread::spawn(|| {\n        println!(\"Ayri thread calisiyor!\");\n    });\n    handle.join().unwrap();\n}",
            codeExplanation = "thread::spawn ile güvenli thread başlatılır.",
            starterPlaygroundCode = "// Rust Concurrency\nprintln!(\"Rust Fearless Concurrency ile sifir hata!\");"
        )
    )

    // ==========================================
    // JAVASCRIPT DERSLERİ (1, 2, 3 Ücretsiz | 4..8 Premium)
    // ==========================================
    private fun getJavaScriptLessons(): List<Lesson> = listOf(
        Lesson(
            id = "js_1",
            courseId = "javascript",
            sectionId = "js_sec_1",
            title = "JavaScript'e Giriş & console.log",
            shortDesc = "Web'in dili, modern JS temelleri.",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false, // ÜCRETSİZ (Ders 1)
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. JavaScript Nedir?",
                    body = "JavaScript, web sayfalarını dinamik hale getiren ve Node.js ile sunucularda çalışan dünyanın en yaygın dilidir."
                )
            ),
            codeExample = "console.log('Merhaba JavaScript!');\nconst toplam = 15 + 25;\nconsole.log(`Toplam: \${toplam}`);",
            codeExplanation = "console.log ile çıktı verilir, backtick (``) ile template string kullanılır.",
            starterPlaygroundCode = "console.log('JavaScript basliyor...');"
        ),
        Lesson(
            id = "js_2",
            courseId = "javascript",
            sectionId = "js_sec_2",
            title = "let, const ve Veri Tipleri",
            shortDesc = "Değişken kapsamları ve ilkel (primitive) tipler.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false, // ÜCRETSİZ (Ders 2)
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "let vs const",
                    body = "const sabit değerler için, let ise güncellenebilir değişkenler için kullanılır. var artık modern projelerde tercih edilmez."
                )
            ),
            codeExample = "const site = 'Kod Akademi';\nlet puan = 100;\npuan += 50;\nconsole.log(site, puan);",
            codeExplanation = "const yeniden atanamaz, let atanabilir.",
            starterPlaygroundCode = "let x = 10;\nconst y = 20;\nconsole.log(x + y);"
        ),
        Lesson(
            id = "js_3",
            courseId = "javascript",
            sectionId = "js_sec_3",
            title = "Operatörler ve Koşullar (if-else)",
            shortDesc = "== vs === farkı, ternary operatör ve switch-case.",
            level = CourseLevel.FUNDAMENTAL,
            order = 3,
            isPremium = false, // ÜCRETSİZ (Ders 3)
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Strict Equality (===)",
                    body = "=== hem değeri hem de türü kontrol eder. '5' === 5 false döndürürken '5' == 5 true döndürür. Her zaman === kullanılması önerilir."
                )
            ),
            codeExample = "const yas = 20;\nconst durum = yas >= 18 ? 'Reşit' : 'Reşit Değil';\nconsole.log(durum);",
            codeExplanation = "Ternary operatör ile kısa koşul kontrolü yapılır.",
            starterPlaygroundCode = "const puan = 85;\nif (puan >= 70) console.log('Gectiniz');"
        ),
        Lesson(
            id = "js_4",
            courseId = "javascript",
            sectionId = "js_sec_4",
            title = "Fonksiyonlar & Arrow Functions",
            shortDesc = "() => {} sözdizimi, default parametreler ve rest operatörü.",
            level = CourseLevel.FUNDAMENTAL,
            order = 4,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Arrow Functions",
                    body = "const topla = (a, b) => a + b; kısa fonksiyon tanımı sağlar."
                )
            ),
            codeExample = "const carp = (a, b = 2) => a * b;\nconsole.log(carp(5)); // 10\nconsole.log(carp(5, 3)); // 15",
            codeExplanation = "b parametresi verilmezse varsayılan olarak 2 değerini alır.",
            starterPlaygroundCode = "const karesi = n => n * n;\nconsole.log(karesi(8));"
        ),
        Lesson(
            id = "js_5",
            courseId = "javascript",
            sectionId = "js_sec_5",
            title = "Modern Dizi Metodları (map, filter, reduce)",
            shortDesc = "Fonksiyonel dizi manipülasyonu ve dönüşümler.",
            level = CourseLevel.INTERMEDIATE,
            order = 5,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Dizi Dönüşümleri",
                    body = "map her elemanı dönüştürür, filter şartı sağlayanları süzer, reduce tek bir toplama indirger."
                )
            ),
            codeExample = "const sayilar = [1, 2, 3, 4, 5];\nconst ciftler = sayilar.filter(n => n % 2 === 0);\nconst toplam = sayilar.reduce((acc, n) => acc + n, 0);\nconsole.log(ciftler, toplam);",
            codeExplanation = "ciftler [2, 4], toplam ise 15 olur.",
            starterPlaygroundCode = "const diller = ['js', 'dart', 'python'];\nconsole.log(diller.map(d => d.toUpperCase()));"
        ),
        Lesson(
            id = "js_6",
            courseId = "javascript",
            sectionId = "js_sec_6",
            title = "Nesneler, Destructuring & Spread (...)",
            shortDesc = "Object destructuring, rest/spread operatörü ve JSON işlemleri.",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Destructuring ve Spread",
                    body = "const { ad, yas } = kisi; ile nesne alanları pratikçe değişkenlere ayrıştırılır."
                )
            ),
            codeExample = "const kullanici = { ad: 'Ece', rol: 'Admin', aktif: true };\nconst { ad, ...diger } = kullanici;\nconst kopya = { ...kullanici, puan: 100 };\nconsole.log(ad, kopya);",
            codeExplanation = "Spread (...) operatörü nesneyi klonlar ve yeni özellik ekler.",
            starterPlaygroundCode = "const obj = { x: 10, y: 20 };\nconst { x, y } = obj;\nconsole.log(x + y);"
        ),
        Lesson(
            id = "js_7",
            courseId = "javascript",
            sectionId = "js_sec_7",
            title = "Asenkron JS: Promises & Async/Await",
            shortDesc = "fetch API, resolve/reject mekanizması ve try-catch ile hata yönetimi.",
            level = CourseLevel.ADVANCED,
            order = 7,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Async / Await",
                    body = "Asenkron işlemleri senkron gibi okunaklı yazmayı sağlar."
                )
            ),
            codeExample = "const veriGetir = async () => {\n    try {\n        // API cagrisi benzetimi\n        return 'API Yaniti Başarılı';\n    } catch (e) {\n        console.error(e);\n    }\n};\nveriGetir().then(console.log);",
            codeExplanation = "async fonksiyonlar her zaman Promise döndürür.",
            starterPlaygroundCode = "const bekle = ms => new Promise(r => setTimeout(r, ms));\n// async / await ile asenkron kontrol"
        ),
        Lesson(
            id = "js_8",
            courseId = "javascript",
            sectionId = "js_sec_8",
            title = "ES6+ Modülleri & Sınıflar (OOP)",
            shortDesc = "class, constructor, extend, import/export ve closure yapısı.",
            level = CourseLevel.EXPERT,
            order = 8,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "JavaScript Sınıfları",
                    body = "ES6 ile gelen class yapısı prototype tabanlı kalıtımın üzerine modern bir sözdizimi sunar."
                )
            ),
            codeExample = "class Gelistirici {\n    constructor(ad, dil) {\n        this.ad = ad;\n        this.dil = dil;\n    }\n    kodYaz() {\n        return `\${this.ad}, \${this.dil} ile kodluyor.`;\n    }\n}\nconst dev = new Gelistirici('Can', 'JavaScript');\nconsole.log(dev.kodYaz());",
            codeExplanation = "new anahtar kelimesi ile sınıftan yeni nesne oluşturulur.",
            starterPlaygroundCode = "class Hayvan { ses() { return 'Miyav'; } }\nconsole.log(new Hayvan().ses());"
        )
    )

    // ==========================================
    // FLUTTER DERSLERİ (1, 2, 3 Ücretsiz | 4..8 Premium)
    // ==========================================
    private fun getFlutterLessons(): List<Lesson> = listOf(
        Lesson(
            id = "fl_1",
            courseId = "flutter",
            sectionId = "fl_sec_1",
            title = "Flutter Nedir? Her Şey Bir Widget!",
            shortDesc = "Flutter mimarisi, Widget ağacı ve StatelessWidget.",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false, // ÜCRETSİZ (Ders 1)
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Flutter Felsefesi",
                    body = "Flutter'da ekrandaki her görsel öğe (metin, buton, boşluk, sayfa) bir 'Widget'tır."
                )
            ),
            codeExample = "Widget build(BuildContext context) {\n  return Scaffold(\n    body: Center(\n      child: Text('Merhaba Flutter!'),\n    ),\n  );\n}",
            codeExplanation = "Scaffold temel sayfa yapısını, Center merkeze almayı, Text metin göstermeyi sağlar.",
            starterPlaygroundCode = "// Flutter Widget Yapısı\nText('Kod Akademi Mobil');"
        ),
        Lesson(
            id = "fl_2",
            courseId = "flutter",
            sectionId = "fl_sec_2",
            title = "StatelessWidget vs StatefulWidget",
            shortDesc = "Durum (state) yönetimi ve setState() mantığı.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false, // ÜCRETSİZ (Ders 2)
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Stateless vs Stateful",
                    body = "StatelessWidget değişmeyen statik arayüzler içindir. StatefulWidget ise kullanıcı etkileşimiyle değişen dinamik arayüzler içindir."
                )
            ),
            codeExample = "setState(() {\n  sayac++;\n});",
            codeExplanation = "setState çağrıldığında build metodu yeniden çalışarak arayüzü günceller.",
            starterPlaygroundCode = "int sayac = 0;\n// sayac degistiginde UI guncellenir."
        ),
        Lesson(
            id = "fl_3",
            courseId = "flutter",
            sectionId = "fl_sec_3",
            title = "Layout Yapıları: Row, Column ve Stack",
            shortDesc = "Yatay, dikey ve üst üste arayüz hiza elemanları.",
            level = CourseLevel.FUNDAMENTAL,
            order = 3,
            isPremium = false, // ÜCRETSİZ (Ders 3)
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Row & Column",
                    body = "Row öğeleri yatayda, Column ise dikeyde yan yana/alt alta dizer."
                )
            ),
            codeExample = "Column(\n  children: [\n    Text('Başlık'),\n    Text('Alt Başlık'),\n  ],\n)",
            codeExplanation = "Children listesindeki widget'lar alt alta yerleşir.",
            starterPlaygroundCode = "Row(children: [Icon(Icons.star), Text('5.0')]);"
        ),
        Lesson(
            id = "fl_4",
            courseId = "flutter",
            sectionId = "fl_sec_4",
            title = "Kullanıcı Girdileri: TextField & Form",
            shortDesc = "TextEditingController, input dekorasyonu ve veri doğrulama.",
            level = CourseLevel.FUNDAMENTAL,
            order = 4,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Form ve Giriş Alanları",
                    body = "TextEditingController ile kullanıcı metni anlık olarak dinlenir."
                )
            ),
            codeExample = "TextField(\n  controller: _controller,\n  decoration: InputDecoration(\n    labelText: 'E-posta',\n    border: OutlineInputBorder(),\n  ),\n)",
            codeExplanation = "Kullanıcı girdisi _controller.text ile okunur.",
            starterPlaygroundCode = "// TextField ornegi\nElevatedButton(onPressed: () {}, child: Text('Gonder'));"
        ),
        Lesson(
            id = "fl_5",
            courseId = "flutter",
            sectionId = "fl_sec_5",
            title = "ListView & GridView Listeleme",
            shortDesc = "ListView.builder ile bellek dostu sonsuz liste mimarisi.",
            level = CourseLevel.INTERMEDIATE,
            order = 5,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "ListView.builder",
                    body = "Yalnızca ekranda görünen öğeleri oluşturarak yüksek performans sağlar."
                )
            ),
            codeExample = "ListView.builder(\n  itemCount: ogeler.length,\n  itemBuilder: (context, index) {\n    return ListTile(title: Text(ogeler[index]));\n  },\n)",
            codeExplanation = "itemBuilder dinamik olarak indeks bazlı eleman üretir.",
            starterPlaygroundCode = "// ListView.builder ornegi"
        ),
        Lesson(
            id = "fl_6",
            courseId = "flutter",
            sectionId = "fl_sec_6",
            title = "Navigasyon & Sayfa Geçişleri",
            shortDesc = "Navigator.push, pop ve sayfalar arası veri aktarımı.",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "Navigator Mimarisi",
                    body = "Sayfalar yığın (stack) şeklinde üst üste açılır ve kapanır."
                )
            ),
            codeExample = "Navigator.push(\n  context,\n  MaterialPageRoute(builder: (context) => DetaySayfasi()),\n);",
            codeExplanation = "MaterialPageRoute platforma uygun animasyonla yeni sayfaya geçer.",
            starterPlaygroundCode = "// Navigator.pop(context);"
        ),
        Lesson(
            id = "fl_7",
            courseId = "flutter",
            sectionId = "fl_sec_7",
            title = "Durum Yönetimi (State Management)",
            shortDesc = "Provider, Riverpod ve Bloc mimarileri ile profesyonel state akışı.",
            level = CourseLevel.ADVANCED,
            order = 7,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "State Management Neden Gereklidir?",
                    body = "Büyük uygulamalarda veriyi widget ağacının derinliklerine taşımak ve temiz mimari kurmak için kullanılır."
                )
            ),
            codeExample = "class SayacNotifier extends ChangeNotifier {\n  int _sayi = 0;\n  int get sayi => _sayi;\n  void artir() {\n    _sayi++;\n    notifyListeners();\n  }\n}",
            codeExplanation = "notifyListeners() dinleyen widget'ları otomatik günceller.",
            starterPlaygroundCode = "// ChangeNotifier tabanlı state modeli"
        ),
        Lesson(
            id = "fl_8",
            courseId = "flutter",
            sectionId = "fl_sec_8",
            title = "REST API İstekleri & JSON Parsing",
            shortDesc = "http paketi, async API çağrıları ve JSON model dönüşümleri.",
            level = CourseLevel.EXPERT,
            order = 8,
            isPremium = true, // 🔒 PREMIUM
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "API Entegrasyonu",
                    body = "FutureBuilder ile API verisi yüklenirken loading indicator, tamamlandığında veri listelenir."
                )
            ),
            codeExample = "Future<List<Post>> fetchPosts() async {\n  final response = await http.get(Uri.parse('https://api.example.com/posts'));\n  if (response.statusCode == 200) {\n    return parsePosts(response.body);\n  }\n  throw Exception('Yuklenemedi');\n}",
            codeExplanation = "API verisi parse edilerek tip güvenli Dart nesnelerine dönüştürülür.",
            starterPlaygroundCode = "// Flutter FutureBuilder mimarisi"
        )
    )

    // ==========================================
    // UYGULAMALI GERÇEK PROJELER
    // ==========================================
    val projects = listOf(
        ProjectItem(
            id = "proj_py_calc",
            courseId = "python",
            title = "Akıllı CLI Hesap Makinesi",
            level = CourseLevel.BEGINNER,
            description = "Kullanıcıdan iki sayı ve işlem operatörü alarak hata kontrollü sonuç üreten komut satırı aracı.",
            learningObjectives = listOf("Fonksiyonlar", "Hata Yakalama (try-except)", "Kullanıcı Girdisi"),
            starterCode = "def hesapla(a, b, islem):\n    # Kodunu buraya yaz:\n    pass\n\nprint(hesapla(10, 5, '+'))",
            solutionCode = "def hesapla(a, b, islem):\n    if islem == '+': return a + b\n    elif islem == '-': return a - b\n    elif islem == '*': return a * b\n    elif islem == '/': return a / b if b != 0 else 'Sıfıra bölünemez'\n    return 'Geçersiz işlem'\n\nprint(hesapla(10, 5, '+'))"
        ),
        ProjectItem(
            id = "proj_dart_todo",
            courseId = "dart",
            title = "CLI Görev Yöneticisi (To-Do)",
            level = CourseLevel.BEGINNER,
            description = "List<Task> ile görev ekleme, tamamlama ve listeleme özelliklerine sahip konsol uygulaması.",
            learningObjectives = listOf("List Koleksiyonları", "Class & Nesneler", "Döngüler"),
            starterCode = "class Gorev {\n  String baslik;\n  bool tamamlandi;\n  Gorev(this.baslik, {this.tamamlandi = false});\n}\nvoid main() {\n  // Görev listesi oluşturun ve yazdırın\n}",
            solutionCode = "class Gorev {\n  String baslik;\n  bool tamamlandi;\n  Gorev(this.baslik, {this.tamamlandi = false});\n}\nvoid main() {\n  var liste = [Gorev('Dart dersi bitir'), Gorev('Quiz coz')];\n  liste[0].tamamlandi = true;\n  for (var g in liste) {\n    print('\${g.tamamlandi ? \"[x]\" : \"[ ]\"} \${g.baslik}');\n  }\n}"
        ),
        ProjectItem(
            id = "proj_cpp_bank",
            courseId = "cpp",
            title = "Banka Hesap Yönetim Sistemi",
            level = CourseLevel.INTERMEDIATE,
            description = "Bakiye yatırma, çekme ve transfer işlemlerini kapsülleme prensipleriyle yöneten C++ sınıfı.",
            learningObjectives = listOf("OOP Sınıfları", "Kapsülleme (Encapsulation)", "Metodlar"),
            starterCode = "class BankaHesabi {\nprivate:\n    double bakiye;\npublic:\n    BankaHesabi(double b) : bakiye(b) {}\n    // Para yatir ve cek fonksiyonlari:\n};",
            solutionCode = "class BankaHesabi {\nprivate:\n    double bakiye;\npublic:\n    BankaHesabi(double b) : bakiye(b) {}\n    void paraYatir(double miktar) { bakiye += miktar; }\n    bool paraCek(double miktar) {\n        if(miktar > bakiye) return false;\n        bakiye -= miktar;\n        return true;\n    }\n    double getBakiye() const { return bakiye; }\n};"
        ),
        ProjectItem(
            id = "proj_dart_json",
            courseId = "dart",
            title = "REST API JSON Parser",
            level = CourseLevel.ADVANCED,
            description = "Gelen JSON harita verisini Dart modellerine 'fromJson' ve 'toJson' ile dönüştüren API katmanı.",
            learningObjectives = listOf("Map<String, dynamic>", "Factory Constructor", "Model Serialization"),
            starterCode = "class Kullanici {\n  final String isim;\n  final int id;\n  Kullanici.fromJson(Map<String, dynamic> json) : isim = json['name'], id = json['id'];\n}",
            solutionCode = "class Kullanici {\n  final String isim;\n  final int id;\n  Kullanici({required this.isim, required this.id});\n  factory Kullanici.fromJson(Map<String, dynamic> json) {\n    return Kullanici(isim: json['name'], id: json['id']);\n  }\n}"
        )
    )

    fun searchLessons(query: String): List<Lesson> {
        val q = query.trim().lowercase()
        if (q.isEmpty()) return emptyList()
        val allLessons = languages.flatMap { getLessonsForCourse(it.id) }
        return allLessons.filter {
            it.title.lowercase().contains(q) ||
            it.shortDesc.lowercase().contains(q) ||
            it.codeExample.lowercase().contains(q) ||
            it.detailedExplanation.any { block -> block.subtitle.lowercase().contains(q) || block.body.lowercase().contains(q) }
        }
    }
}
