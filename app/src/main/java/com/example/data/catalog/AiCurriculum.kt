package com.example.data.catalog

import com.example.model.*

/**
 * Yapay Zeka (AI & Derin Öğrenme) Müfredatı:
 * Kendi yapay zeka modelinizi sıfırdan adım adım geliştirin!
 * Temel, Orta ve İleri seviyelerde sade, günlük konuşma dilinde rehber.
 */
object AiCurriculum {

    fun getSections(): List<CourseSection> = listOf(
        CourseSection(
            id = "ai_sec_1",
            courseId = "ai",
            title = "Bölüm 1: Yapay Zekanın Temeli: Mantık ve İlk Nöron",
            level = CourseLevel.BEGINNER,
            order = 1,
            description = "Geleneksel yazılımdan yapay zekaya geçiş, yapay sinir hücresi (Perceptron), ağırlıklar (Weights) ve bias.",
            learningObjectives = listOf(
                "Yapay zekanın geleneksel kodlamadan temel farkını anlamak",
                "Tek bir yapay nöronun (y = w * x + b) formülünü kavramak",
                "Aktivasyon fonksiyonlarının (ReLU, Sigmoid) karar anındaki rolünü öğrenmek"
            ),
            prerequisites = listOf("Ön koşul gerekmez! Merak ve sıfırdan öğrenme isteği yeterlidir.")
        ),
        CourseSection(
            id = "ai_sec_2",
            courseId = "ai",
            title = "Bölüm 2: Veri Hazırlığı ve Tensörler (Tensors)",
            level = CourseLevel.FUNDAMENTAL,
            order = 2,
            description = "Tensör nedir? Veriyi yapay zekanın anlayacağı sayılara ve matrislere dönüştürme, train/test bölme.",
            learningObjectives = listOf(
                "Tensörlerin (0D skaler, 1D vektör, 2D matris) yapısını çözmek",
                "Resimlerin ve metinlerin sayılara nasıl dönüştüğünü görmek",
                "Modelin ezberlemesini (overfitting) önlemek için veriyi bölmek"
            ),
            prerequisites = listOf("Yapay Zeka Temelleri ve Nöron Mantığı")
        ),
        CourseSection(
            id = "ai_sec_3",
            courseId = "ai",
            title = "Bölüm 3: Model Nasıl Öğrenir? (İleri ve Geriye Yayılım)",
            level = CourseLevel.INTERMEDIATE,
            order = 3,
            description = "İleri yayılım (Forward pass), kayıp fonksiyonu (Loss), gradyan inişi (Gradient Descent) ve geriye yayılım (Backpropagation).",
            learningObjectives = listOf(
                "Loss fonksiyonu ile yapılan hatanın büyüklüğünü ölçmek",
                "Gradient Descent ile vadideki en dip hataya inmeyi kavramak",
                "Backpropagation ile hatayı nöronlara dağıtıp ağırlıkları düzeltmek"
            ),
            prerequisites = listOf("Tensörler ve Veri Seti Bölme")
        ),
        CourseSection(
            id = "ai_sec_4",
            courseId = "ai",
            title = "Bölüm 4: Kendi Derin Sinir Ağını (Deep Learning) İnşa Etmek",
            level = CourseLevel.ADVANCED,
            order = 4,
            description = "Çok katmanlı yapay sinir ağları (MLP), PyTorch nn.Module ve evrişimli sinir ağları (CNN) ile görme yeteneği.",
            learningObjectives = listOf(
                "Gizli katmanlar (hidden layers) ekleyerek derin ağlar kurmak",
                "PyTorch nn.Module sınıfı ile kendi model mimarimizi kodlamak",
                "CNN filtreleri ile resimlerdeki desenleri tanımak"
            ),
            prerequisites = listOf("Model Eğitimi ve Backpropagation Mantığı")
        ),
        CourseSection(
            id = "ai_sec_5",
            courseId = "ai",
            title = "Bölüm 5: Modern Yapay Zeka: Transformer ve Kendi Dil Modelin",
            level = CourseLevel.EXPERT,
            order = 5,
            description = "Dikkat Mekanizması (Self-Attention), Transformer mimarisi ve sıfırdan mini bir dil modeli (Mini-GPT) kurma, canlıya alma.",
            learningObjectives = listOf(
                "Self-Attention mekanizmasının kelimeleri nasıl anladığını çözmek",
                "Transformer blokları ile mini bir metin üretim modeli oluşturmak",
                "Eğitilen modelin ağırlıklarını kaydedip canlı tahmine (Inference) sokmak"
            ),
            prerequisites = listOf("Tüm Temel, Orta ve İleri Seviye Konuları")
        )
    )

    fun getLessons(): List<Lesson> = listOf(
        // =========================================================================
        // DERS 1: YAPAY ZEKA NEDİR VE NASIL DÜŞÜNÜR? (TEMEL - BEGINNER)
        // =========================================================================
        Lesson(
            id = "ai_1",
            courseId = "ai",
            sectionId = "ai_sec_1",
            title = "Yapay Zeka Nedir ve Nasıl Düşünür?",
            shortDesc = "Geleneksel yazılım ile yapay zekanın farkı: Kuralları biz mi yazarız, makine veriden mi çıkarır?",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false,
            learningObjectives = listOf(
                "Geleneksel programlama ile makine öğrenmesi arasındaki mantık farkını kavramak",
                "Veri (Data), Model ve Tahmin (Inference) kavramlarını öğrenmek",
                "İlk yapay zeka düşünce haritasını zihninizde oturtmak"
            ),
            prerequisites = listOf("Ön koşul gerekmez! Günlük mantık yeterlidir."),
            subtopics = listOf("Geleneksel vs Yapay Zeka", "Kural Yerine Örnek Göstermek", "Model Kavramı", "Girdi ve Çıktı"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Geleneksel Kodlama Nerede Tıkanır?",
                    body = "Geleneksel yazılımda bir sorunu çözmek için bilgisayara adım adım kural veririz: 'Eğer e-postada indirim yazıyorsa spama at'.\n\nFakat bir kedi fotoğrafını tanımak için kural yazamazsınız! 'İki kulağı, bıyıkları var' deseniz tilkiyi de kedi sanır. Kedinin rengi, açısı, ışığı değiştikçe kurallar çöker.\n\nİşte Yapay Zeka burada devreye girer: Bilgisayara kurallar koymak yerine, ona binlerce kedi fotoğrafı gösterip kuralı kendisinin bulmasını sağlarız!"
                ),
                LessonContentBlock(
                    subtitle = "2. Sihirli Formül: Veri + Çıktı = Model",
                    body = "Geleneksel Yazılım: Kural + Veri = Çıktı\nYapay Zeka (Makine Öğrenmesi): Veri + Çıktı = Kural (Model)!\n\nBiz modele girdileri (ev metrekaresi, oda sayısı) ve gerçek sonuçları (ev fiyatı) veririz. Model aradaki matematiksel ilişkiyi keşfeder. Bu ilişkiye 'Model' deriz.",
                    tip = "Yapay zeka sihirli bir canavar değil, çok sayıda sayıyı birbiriyle çarpıp toplayan ve hata yaptıkça ayarlarını düzelten bir matematik makinesidir!"
                ),
                LessonContentBlock(
                    subtitle = "3. İlk Tahmin Fonksiyonumuz",
                    body = "Diyelim ki bir fırıncısınız ve sattığınız ekmek sayısına göre un miktarını tahmin etmek istiyorsunuz. 1 ekmek = 300g un, 2 ekmek = 600g un. Makine burada kuralın 'ekmek * 300' olduğunu veriye bakarak öğrenir.",
                    codeSnippet = "# Basit bir kural öğrenme benzetmesi\ndef tahmin_et(ekmek_sayisi, agirlik=300):\n    return ekmek_sayisi * agirlik\n\nprint(\"10 ekmek için gereken un:\", tahmin_et(10), \"gram\")"
                )
            ),
            codeExample = "def ai_tahmin(girdi, carpan=300):\n    return girdi * carpan\n\nsonuc = ai_tahmin(5)\nprint(\"5 birim için tahmin edilen değer:\", sonuc)",
            codeExplanation = "Girdiyi öğrendiğimiz ağırlık katsayısıyla çarparak tahmin ürettik.",
            realWorldExample = "Spam filtreleri, Spotify'ın şarkı önerileri ve YouTube ana sayfanız bu mantıkla çalışır.",
            practicalTask = "print fonksiyonu ile 'Yapay zeka modelim hazır!' mesajını ve 10 girdisi için tahmin sonucunu ekrana yazdırın.",
            starterPlaygroundCode = "def model(x):\n    return x * 50\n\nsonuc = model(10)\nprint(\"Yapay zeka modelim hazır!\")\nprint(\"Tahmin sonucu:\", sonuc)",
            miniQuestion = MiniQuestion(
                id = "ai_q_1",
                question = "Geleneksel yazılım ile yapay zeka arasındaki en temel fark nedir?",
                options = listOf(
                    "Geleneksel yazılımda kuralları geliştirici yazar, yapay zekada kuralları model veriden öğrenir",
                    "Yapay zeka donanım kullanmaz, geleneksel yazılım kullanır",
                    "Geleneksel yazılım sayılarla çalışır, yapay zeka sayılardan anlamaz",
                    "Hiçbir fark yoktur, ikisi de tamamen aynıdır"
                ),
                correctIndex = 0,
                explanation = "Yapay zekada kuralları biz tek tek elle yazmayız; girdi ve doğru cevapları veririz, model ilişkiyi kendisi öğrenir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_ai_1",
                lessonId = "ai_1",
                title = "İlk Tahmin Fonksiyonunu Yaz",
                instructions = "Verilen bir girdi sayısını (x) 25 katsayısıyla çarparak tahmin sonucunu döndüren model_tahmin(x) fonksiyonunu yazın ve ekrana print ile yazdırın.",
                exampleInput = "model_tahmin(4)",
                exampleOutput = "100",
                starterCode = "def model_tahmin(x):\n    # Kodunu buraya yaz:\n    return 0\n\nprint(model_tahmin(4))",
                solutionCode = "def model_tahmin(x):\n    return x * 25\n\nprint(model_tahmin(4))",
                hints = listOf(
                    "return x * 25 yazarak girdiyi katsayı ile çarpın.",
                    "print(model_tahmin(4)) çağrısı ile ekrana 100 yazdırın."
                ),
                testCases = listOf(
                    TestCase("model_tahmin(4)", "100", "4 için 100 tahmini")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "ai_quiz_1_1",
                    lessonId = "ai_1",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir yapay zeka modelinin eğitimden sonra yeni bir veriye bakıp sonuç üretmesine ne ad verilir?",
                    options = listOf("Inference (Tahmin / Çıkarım)", "Backpropagation", "Overfitting", "Compilation"),
                    correctOptionIndex = 0,
                    explanationRight = "Harika! Model eğitildikten sonra gerçek dünyada yeni veriyi tahmin etme sürecine Inference denir.",
                    explanationWrong = "Eğitilmiş modelin yeni veriyi tahmin etmesine Inference (çıkarım) adı verilir.",
                    reviewTopic = "Inference Kavramı"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Yapay zeka gerçekten insan gibi düşünüyor mu?",
                    answer = "Hayır! Yapay zeka duygulara veya gerçek bir bilince sahip değildir. Çok büyük matematiksel matrisler üzerinde istatistiksel olasılıkları hesaplar."
                )
            ),
            communityInsights = listOf(
                CommunityInsight(
                    source = "Andrew Ng (Coursera AI)",
                    topic = "Yapay Zeka ve Elektrik Benzetmesi",
                    insight = "100 yıl önce elektriğin tüm endüstrileri değiştirmesi gibi, bugün yapay zeka da her sektörü kökten dönüştürmektedir."
                )
            ),
            completionCriteria = listOf(
                "Yapay zekanın kural öğrenme mantığını kavramak",
                "İlk basit tahmin fonksiyonunu çalıştırmak"
            )
        ),

        // =========================================================================
        // DERS 2: İLK YAPAY NÖRONUMUZ: AĞIRLIKLAR (WEIGHTS) VE BIAS (TEMEL - BEGINNER)
        // =========================================================================
        Lesson(
            id = "ai_2",
            courseId = "ai",
            sectionId = "ai_sec_1",
            title = "İlk Yapay Nöronumuz: Ağırlıklar (Weights) ve Sapma (Bias)",
            shortDesc = "Biyolojik beyinden yapay sinir ağına: y = w * x + b formülünün ardındaki büyük sır.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false,
            learningObjectives = listOf(
                "Yapay nöronun (Perceptron) anatomisini anlamak",
                "Ağırlık (Weight) kavramının önem katsayısı olduğunu kavramak",
                "Sapma (Bias) değerinin karar eşiği olarak görevini çözmek"
            ),
            prerequisites = listOf("Ders 1: Yapay Zeka Nedir ve Nasıl Düşünür?"),
            subtopics = listOf("Yapay Nöron Anatomisi", "Ağırlık (Weight) Nedir?", "Sapma (Bias) Nedir?", "y = w*x + b"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Beyindeki Nöron Yapay Zekada Nasıl Modellenir?",
                    body = "İnsan beyninde yaklaşık 86 milyar nöron vardır. Bir nöron komşularından elektrik sinyalleri alır, bunları toplar ve belirli bir eşiği aşarsa diğer nörona iletir.\n\nYapay zekadaki karşılığı: Yapay Sinir Hücresi (Perceptron). Girdileri alır, her birini önemine göre bir sayıyla çarpar (ağırlık), üstüne bir başlangıç puanı ekler (bias) ve sonucu verir!"
                ),
                LessonContentBlock(
                    subtitle = "2. Ağırlık (Weight) ve Bias: Ayar Düğmeleri",
                    body = "Diyelim ki yarın dışarı çıkıp piknik yapacak mısınız? Karar veriyorsunuz.\n\n• Girdi 1 (x1): Hava güneşli mi? (1 = evet, 0 = hayır)\n• Girdi 2 (x2): Hafta sonu mu? (1 = evet, 0 = hayır)\n\nHava güneşli olması sizin için çok daha önemliyse, Güneş girdisinin ağırlığı (w1) yüksek olur (örneğin 0.8), hafta sonu ağırlığı (w2) ise 0.3 olur.\n\nBias (Sapma) ise sizin genel ruh halinizdir! Eğer çok neşeli ve her türlü dışarı çıkan biriyseniz bias pozitif, üşengeç biriyseniz negatiftir.",
                    tip = "Modeli eğitmek demek, doğru tahminler yapana kadar bu ağırlıkları ve bias'ı küçük dokunuşlarla ayarlamak demektir!"
                ),
                LessonContentBlock(
                    subtitle = "3. Kodla Tek Bir Nöron Çalıştırmak",
                    body = "İşte bir nöronun matematiksel kalbi: `çıktı = (x1 * w1) + (x2 * w2) + bias`",
                    codeSnippet = "# Tek bir nöronun ileri hesaplaması\nx1 = 1.0  # Hava güneşli\nx2 = 0.0  # Hafta içi\nw1 = 0.8  # Güneşin önemi\nw2 = 0.4  # Hafta sonunun önemi\nbias = -0.5 # Dışarı çıkma eşiği\n\nkarar_puani = (x1 * w1) + (x2 * w2) + bias\nprint(\"Nöron Karar Puanı:\", karar_puani)"
                )
            ),
            codeExample = "x = [1.0, 0.5]\nw = [0.7, 0.3]\nbias = 0.1\n\nnoron_ciktisi = (x[0] * w[0]) + (x[1] * w[1]) + bias\nprint(\"Nöron Çıktısı:\", noron_ciktisi)",
            codeExplanation = "Girdileri ağırlıklarıyla çarptık, topladık ve bias ekleyerek tek nöron çıktısını bulduk.",
            realWorldExample = "Kredi kartı dolandırıcılık tespitinde nöron: Harcama tutarı * w1 + Lokasyon uzaklığı * w2 + bias > 0 ise kartı bloke et!",
            practicalTask = "İki girdi ve iki ağırlık kullanarak bir nöron hesaplaması yapın ve 'Nöron aktif' mesajını çıktı ile birlikte ekrana yazdırın.",
            starterPlaygroundCode = "girdi = 2.0\nagirlik = 1.5\nbias = 0.5\n\ncikti = (girdi * agirlik) + bias\nprint(\"Nöron aktif, çıktı:\", cikti)",
            miniQuestion = MiniQuestion(
                id = "ai_q_2",
                question = "Yapay bir nöronda 'Ağırlık' (Weight) ne anlama gelir?",
                options = listOf(
                    "İlgili girdinin karara olan etki gücünü / önem derecesini belirten katsayıdır",
                    "Modelin bilgisayarın belleğinde kapladığı megabayt miktarıdır",
                    "Nöronun kaç saniyede çalıştığıdır",
                    "Veri setindeki satır sayısıdır"
                ),
                correctIndex = 0,
                explanation = "Ağırlıklar, her bir girdinin sonuca ne kadar güçlü etki ettiğini belirleyen çarpan katsayılarıdır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_ai_2",
                lessonId = "ai_2",
                title = "Nöron Formülünü Kodla",
                instructions = "noron_hesapla(x, w, b) fonksiyonunu yazın. Formül: x * w + b. Çıktıyı ekrana yazdırın.",
                exampleInput = "noron_hesapla(10, 2, 5)",
                exampleOutput = "25",
                starterCode = "def noron_hesapla(x, w, b):\n    # Kodunu yaz:\n    return 0\n\nprint(noron_hesapla(10, 2, 5))",
                solutionCode = "def noron_hesapla(x, w, b):\n    return (x * w) + b\n\nprint(noron_hesapla(10, 2, 5))",
                hints = listOf(
                    "return (x * w) + b yazmanız yeterlidir.",
                    "10 * 2 + 5 = 25 sonucunu verir."
                ),
                testCases = listOf(
                    TestCase("noron_hesapla(10, 2, 5)", "25", "Nöron hesaplama testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "ai_quiz_2_1",
                    lessonId = "ai_2",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Tüm girdiler 0 olsa bile nöronun bir çıktı üretebilmesini sağlayan bileşen hangisidir?",
                    options = listOf("Bias (Sapma)", "Learning Rate", "Weight (Ağırlık)", "Epoch"),
                    correctOptionIndex = 0,
                    explanationRight = "Tebrikler! x = 0 olduğunda w*x sıfırlanır, geriye sadece bias kalır; böylece karar eşiği korunur.",
                    explanationWrong = "Girdiler sıfır olduğunda nöronun taban değerini Bias (sapma) belirler.",
                    reviewTopic = "Bias Mantığı"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Ağırlıklar başta nasıl belirlenir?",
                    answer = "Model ilk oluşturulduğunda ağırlıklar genellikle rastgele küçük sayılarla (örneğin 0.01 veya Gauss dağılımı ile) başlatılır, eğitim sırasında güncellenir."
                )
            ),
            completionCriteria = listOf(
                "y = w * x + b formülünü kavramak",
                "Ağırlık ve bias arasındaki farkı bilmek"
            )
        ),

        // =========================================================================
        // DERS 3: KARAR ANI: AKTİVASYON FONKSİYONLARI (TEMEL - BEGINNER)
        // =========================================================================
        Lesson(
            id = "ai_3",
            courseId = "ai",
            sectionId = "ai_sec_1",
            title = "Karar Anı: Aktivasyon Fonksiyonları (Step, Sigmoid ve ReLU)",
            shortDesc = "Neden sadece çarpmak yetmez? Doğrusal olmayan dünyayı modelleyen ReLU ve Sigmoid sihirleri.",
            level = CourseLevel.BEGINNER,
            order = 3,
            isPremium = true,
            learningObjectives = listOf(
                "Doğrusallık (Linearity) kısıtını ve aktivasyon fonksiyonlarının gereğini anlamak",
                "ReLU (Rectified Linear Unit) fonksiyonunun neden modern yapay zekanın vazgeçilmezi olduğunu görmek",
                "Sigmoid fonksiyonu ile çıktıları 0 ile 1 arasına sıkıştırmayı öğrenmek"
            ),
            prerequisites = listOf("Ders 2: İlk Yapay Nöronumuz"),
            subtopics = listOf("Doğrusallık Sorunu", "Aktivasyon Nedir?", "ReLU Fonksiyonu", "Sigmoid ve Olasılık"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Neden Aktivasyon Fonksiyonuna İhtiyaç Var?",
                    body = "Eğer nöronlarımız sadece `w * x + b` yapsaydı, 100 katmanlı bir sinir ağı bile kursanız, doğrusal denklemlerin toplamı yine tek bir doğrusal çizgi olurdu! Yani sadece düz çizgiler çizebilirdiniz.\n\nOysa gerçek hayat eğrilerle doludur: Bir resmin köpek mi kedi mi olduğu düz bir cetvelle ayrılamaz. İşte ağa kıvrılma, bükülme ve karmaşık desenleri anlama yeteneğini Aktivasyon Fonksiyonları kazandırır!"
                ),
                LessonContentBlock(
                    subtitle = "2. Süper Yıldız: ReLU (Rectified Linear Unit)",
                    body = "Bugün ChatGPT'den otonom araçlara kadar hemen her modelde ReLU kullanılır. Kuralı çocuk oyuncağı kadar basittir:\n\n'Eğer sayı 0'dan küçükse 0 yap, 0'dan büyükse olduğu gibi geçir!'\n\nFormülü: `max(0, x)`. Negatif sinyalleri keser, pozitif sinyalleri geçirir. Tıpkı beynimizdeki nöronların sadece eşik aşıldığında sinyal göndermesi gibi!",
                    tip = "Hesaplaması inanılmaz derecede hızlıdır çünkü bilgisayarın sadece sayının negatif olup olmadığına bakması yeterlidir."
                ),
                LessonContentBlock(
                    subtitle = "3. Sigmoid: Olasılığa Dönüştürücü (0 ile 1 Arası)",
                    body = "Bir hastanın hasta olma olasılığını tahmin ediyorsanız sonuç 500 veya -20 çıkamaz; 0 ile 1 arasında (örneğin 0.85 = %85) olmalıdır. Sigmoid fonksiyonu ne kadar büyük veya küçük olursa olsun her sayıyı (0, 1) arasına sıkıştırır.",
                    codeSnippet = "def relu(x):\n    return max(0, x)\n\ndef sigmoid_benzetimi(x):\n    # 0'dan küçükse 0.5'ten aşağı, büyükse yukarı iter\n    return 1 / (1 + 2.718 ** (-x))\n\nprint(\"ReLU(-5):\", relu(-5)) # 0\nprint(\"ReLU(8):\", relu(8))   # 8"
                )
            ),
            codeExample = "def relu(deger):\n    return deger if deger > 0 else 0\n\ngirdi = -12\naktivasyon_sonucu = relu(girdi)\nprint(\"Negatif girdinin ReLU çıktısı:\", aktivasyon_sonucu)",
            codeExplanation = "ReLU negatif değeri sıfırladı. Eğer pozitif olsaydı değer korunacaktı.",
            realWorldExample = "Yüz tanıma sistemlerinde gölge gibi alakasız negatif sinyaller ReLU ile filtrelenir.",
            practicalTask = "ReLU fonksiyonunu çağırıp 15 değeri için çıktıyı ekrana yazdırın.",
            starterPlaygroundCode = "def relu(x):\n    return max(0, x)\n\nprint(\"Sonuc:\", relu(15))",
            miniQuestion = MiniQuestion(
                id = "ai_q_3",
                question = "ReLU(x) fonksiyonuna girdi olarak -7 verirseniz çıktı ne olur?",
                options = listOf("0", "-7", "7", "1"),
                correctIndex = 0,
                explanation = "ReLU kuralı: max(0, x). Girdi 0'dan küçükse sonuç her zaman 0 olur."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_ai_3",
                lessonId = "ai_3",
                title = "Kendi ReLU Fonksiyonunu Yaz",
                instructions = "Sayının negatif olması durumunda 0, pozitif olması durumunda kendisini döndüren relu_fonksiyonu(x) fonksiyonunu yazın ve 8 için sonucunu ekrana yazdırın.",
                exampleInput = "relu_fonksiyonu(8)",
                exampleOutput = "8",
                starterCode = "def relu_fonksiyonu(x):\n    # Kodunu yaz:\n    return 0\n\nprint(relu_fonksiyonu(8))",
                solutionCode = "def relu_fonksiyonu(x):\n    return x if x > 0 else 0\n\nprint(relu_fonksiyonu(8))",
                hints = listOf(
                    "if x > 0: return x else: return 0 mantığını kullanın.",
                    "print(relu_fonksiyonu(8)) ile 8 çıktısını alın."
                ),
                testCases = listOf(
                    TestCase("relu_fonksiyonu(8)", "8", "Pozitif test")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "ai_quiz_3_1",
                    lessonId = "ai_3",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Yapay sinir ağlarında aktivasyon fonksiyonu kullanılmazsa ne olur?",
                    options = listOf(
                        "Ağ ne kadar derin olursa olsun sadece basit doğrusal (linear) ilişkileri öğrenebilir",
                        "Bilgisayar aşırı ısınır ve çöker",
                        "Ağırlıklar sıfırlanır",
                        "Model otomatik olarak 100 kat daha hızlı öğrenir"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Aynen öyle! Aktivasyon olmadan derin ağlar sadece tek bir doğrusal fonksiyona indirgenir.",
                    explanationWrong = "Aktivasyon fonksiyonu ağa doğrusal olmayan (non-linear) desenleri öğrenme yeteneği katar.",
                    reviewTopic = "Aktivasyon Fonksiyonlarının Amacı"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Hangi aktivasyon fonksiyonunu ne zaman seçmeliyim?",
                    answer = "Genel kural: Modelin içindeki gizli katmanlarda ReLU (veya LeakyReLU/GELU), en son çıktı katmanında ise ikili sınıflandırma için Sigmoid, çoklu sınıflandırma için Softmax kullanılır."
                )
            ),
            completionCriteria = listOf(
                "Aktivasyon fonksiyonlarının neden şart olduğunu bilmek",
                "ReLU ve Sigmoid mantığını kavramak"
            )
        ),

        // =========================================================================
        // DERS 4: TENSÖRLER: YAPAY ZEKANIN DİLİ VE MATRİSLER (TEMEL - FUNDAMENTAL)
        // =========================================================================
        Lesson(
            id = "ai_4",
            courseId = "ai",
            sectionId = "ai_sec_2",
            title = "Tensörler: Yapay Zekanın Dili ve Matrisler",
            shortDesc = "Bilgisayar için her şey sayıdır! Resimler, sesler ve kelimeler çok boyutlu dizilere (Tensör) nasıl dönüşür?",
            level = CourseLevel.FUNDAMENTAL,
            order = 4,
            isPremium = true,
            learningObjectives = listOf(
                "Tensör (Tensor) kavramını boyutlarıyla (0D, 1D, 2D, 3D) anlamak",
                "Görüntülerin (Yükseklik x Genişlik x Renk Kanalı) tensör temsilini görmek",
                "PyTorch ve NumPy'da tensör şekillerini (shape) yorumlamak"
            ),
            prerequisites = listOf("Ders 3: Aktivasyon Fonksiyonları"),
            subtopics = listOf("Tensör Nedir?", "Boyutlar (Dimensions / Rank)", "Resimlerin Tensöre Dönüşümü", "Tensör Şekli (Shape)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Tensör Aslında Nedir?",
                    body = "Korkutucu bir kelime gibi durabilir ama tensör sadece 'sayılar tablosudur':\n\n• 0 Boyutlu Tensör (Skaler): Tek bir sayı (Örn: 42)\n• 1 Boyutlu Tensör (Vektör): Sayılar listesi (Örn: [1.2, 3.4, 5.1])\n• 2 Boyutlu Tensör (Matris): Satır ve sütunlardan oluşan Excel tablosu\n• 3 Boyutlu Tensör: Üst üste konmuş matrisler (Örn: Renkli bir fotoğraf! Kırmızı, Yeşil, Mavi matrisleri)"
                ),
                LessonContentBlock(
                    subtitle = "2. Bir Fotoğraf Yapay Zekanın Gözünde Nasıl Görünür?",
                    body = "Bir ekrandaki her piksel 0 ile 255 arasında bir sayıdan ibarettir (0 = simsiyah, 255 = bembeyaz).\n\n28x28 boyutunda siyah-beyaz bir rakam fotoğrafı (MNIST veri seti), yapay zeka için 28 satır ve 28 sütundan oluşan bir sayı matrisidir!\n\nEğer fotoğraf renkliyse (RGB), şekli `[3, 28, 28]` (3 renk kanalı, 28 yükseklik, 28 genişlik) olur.",
                    tip = "Yapay zekanın yaptığı tek şey, bu sayı tablolarını ağırlık matrisleriyle çarpmaktır."
                ),
                LessonContentBlock(
                    subtitle = "3. Kodla Mini Bir Tensör Tanımlamak",
                    body = "PyTorch veya NumPy'da tensörlerle çalışırken en çok baktığımız şey `.shape` yani tensörün boyutlarıdır.",
                    codeSnippet = "# 2x3 boyutunda bir tensör (2 satır, 3 sütun)\ntensor = [\n    [1, 2, 3],\n    [4, 5, 6]\n]\n\nsatir_sayisi = len(tensor)\nsutun_sayisi = len(tensor[0])\nprint(f\"Tensör Şekli: ({satir_sayisi}, {sutun_sayisi})\")"
                )
            ),
            codeExample = "tensor_1d = [10, 20, 30]\ntensor_2d = [[1, 2], [3, 4]]\nprint(\"1D Tensör Elemanı:\", tensor_1d[0])\nprint(\"2D Tensör (0,1) Elemanı:\", tensor_2d[0][1])",
            codeExplanation = "1 boyutlu vektör ve 2 boyutlu matris oluşturup indeksleme yaptık.",
            realWorldExample = "MRI taramaları 3 boyutlu tensörlerdir (Derinlik, Genişlik, Yükseklik). Video ise 4 boyutludur (Zaman, Kanal, Genişlik, Yükseklik)!",
            practicalTask = "3 satır ve 2 sütunlu bir tensör oluşturup satır sayısını ekrana yazdırın.",
            starterPlaygroundCode = "matris = [\n    [1, 2],\n    [3, 4],\n    [5, 6]\n]\nprint(\"Satır sayısı:\", len(matris))\nprint(\"Sütun sayısı:\", len(matris[0]))",
            miniQuestion = MiniQuestion(
                id = "ai_q_4",
                question = "28 piksel genişliğinde ve 28 piksel yüksekliğinde renkli (RGB 3 kanal) bir görüntünün tensör boyutu nedir?",
                options = listOf("[3, 28, 28]", "[28, 28]", "[3, 3]", "[28, 3]"),
                correctIndex = 0,
                explanation = "3 renk kanalı (Kırmızı, Yeşil, Mavi) ve 28x28 mekansal boyut olduğu için tensör şekli [3, 28, 28] olur."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_ai_4",
                lessonId = "ai_4",
                title = "Tensör Toplamını Bul",
                instructions = "Verilen 1 boyutlu tensörün (sayı listesinin) elemanlarını toplayan tensor_topla(dizi) fonksiyonunu yazın ve [2, 4, 6] için ekrana yazdırın.",
                exampleInput = "tensor_topla([2, 4, 6])",
                exampleOutput = "12",
                starterCode = "def tensor_topla(dizi):\n    # Kodunu yaz:\n    return 0\n\nprint(tensor_topla([2, 4, 6]))",
                solutionCode = "def tensor_topla(dizi):\n    return sum(dizi)\n\nprint(tensor_topla([2, 4, 6]))",
                hints = listOf(
                    "sum(dizi) fonksiyonunu veya for döngüsünü kullanabilirsiniz.",
                    "print(tensor_topla([2, 4, 6])) ile 12 çıktısını alın."
                ),
                testCases = listOf(
                    TestCase("tensor_topla([2, 4, 6])", "12", "Toplam testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "ai_quiz_4_1",
                    lessonId = "ai_4",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Tek bir sayıdan (örneğin 3.14) oluşan tensör türü aşağıdakilerden hangisidir?",
                    options = listOf("Skaler (0D Tensör)", "Vektör (1D Tensör)", "Matris (2D Tensör)", "Görüntü Tensörü"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Boyutu olmayan tekil sayılara matematik ve fizikte Skaler (Scalar) denir.",
                    explanationWrong = "Tek bir sayı 0 boyutlu bir Skaler (Scalar) tensördür.",
                    reviewTopic = "Skaler ve Vektör"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "TensorFlow ve PyTorch kütüphanelerinin isminde neden 'Tensor' geçiyor?",
                    answer = "Çünkü bu kütüphanelerin tüm mimarisi, tensörlerin (veri akışlarının) yapay sinir ağı katmanları arasında akıp işlenmesi üzerine kuruludur."
                )
            ),
            completionCriteria = listOf(
                "Tensör boyutlarını (Skaler, Vektör, Matris) ayırt edebilmek",
                "Verilerin sayılara dönüştürülme mantığını anlamak"
            )
        ),

        // =========================================================================
        // DERS 5: VERİ SETİ BÖLME: TRAIN, VALIDATION VE TEST (TEMEL - FUNDAMENTAL)
        // =========================================================================
        Lesson(
            id = "ai_5",
            courseId = "ai",
            sectionId = "ai_sec_2",
            title = "Veri Seti Hazırlığı: Eğitim (Train) ve Test Bölme",
            shortDesc = "Model ezberlemesin! Overfitting tehlikesi, ders çalışan öğrenci benzetmesi ve doğru veri bölme.",
            level = CourseLevel.FUNDAMENTAL,
            order = 5,
            isPremium = true,
            learningObjectives = listOf(
                "Aşırı Öğrenme (Overfitting) ve Eksik Öğrenme (Underfitting) kavramlarını kavramak",
                "Veriyi Train (%80) ve Test (%20) olarak bölmenin hayati önemini öğrenmek",
                "Modelin genelleme (Generalization) yeteneğini nasıl test edeceğimizi bilmek"
            ),
            prerequisites = listOf("Ders 4: Tensörler"),
            subtopics = listOf("Ezberlemek vs Öğrenmek", "Overfitting Nedir?", "Train-Validation-Test Bölmesi", "Doğruluk (Accuracy)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Ders Çalışan Öğrenci Benzetmesi",
                    body = "Bir öğrenci düşünün. Matematik sınavına çalışırken kitaptaki 50 sorunun cevaplarını ezberliyor (1. soru A, 2. soru C...). Kitaptaki testte %100 alıyor!\n\nFakat sınava girdiğinde soruların sayıları biraz değiştiği için sıfır çekiyor. İşte buna yapay zekada Aşırı Uyum (Overfitting / Ezberleme) denir!\n\nBiz modelin eğitim sorularını ezberlemesini değil, alttaki kuralı öğrenip hiç görmediği yepyeni sorularda da doğru cevap vermesini isteriz."
                ),
                LessonContentBlock(
                    subtitle = "2. Altın Kural: Veriyi Bölmek!",
                    body = "Elimizde 1000 tane veri varsa:\n\n• %80 Eğitim (Train): Modeli bu veriyle eğitiriz. Ağırlıklar bu veriye göre güncellenir.\n• %20 Test: Bu veriyi kasaya kilitleriz! Eğitim bitene kadar model bu veriyi asla görmez. Eğitim bittiğinde 'Hadi bakalım, hiç görmediğin bu 200 soruyu çöz' deriz.\n\nEğer model Test verisinde de yüksek başarı gösteriyorsa, tebrikler: Modeliniz gerçekten öğrenmiştir!",
                    tip = "Bir model eğitim verisinde %99 başarı gösterip test verisinde %55 alıyorsa, tipik bir Overfitting (ezberleme) tuzağına düşmüştür."
                ),
                LessonContentBlock(
                    subtitle = "3. Kodla Veri Setini Bölmek",
                    body = "Veri listesini oranlara göre bölmek çok kolaydır:",
                    codeSnippet = "veri = list(range(10))\nbolunme_noktasi = int(len(veri) * 0.8)\n\negitim_verisi = veri[:bolunme_noktasi]\ntest_verisi = veri[bolunme_noktasi:]\n\nprint(\"Eğitim:\", egitim_verisi) # [0, 1, 2, 3, 4, 5, 6, 7]\nprint(\"Test:\", test_verisi)       # [8, 9]"
                )
            ),
            codeExample = "toplam_ornek = 100\ntrain_sayisi = int(toplam_ornek * 0.8)\ntest_sayisi = toplam_ornek - train_sayisi\nprint(f\"Eğitim: {train_sayisi}, Test: {test_sayisi}\")",
            codeExplanation = "100 örneklik veri setini %80 eğitim ve %20 test olarak iki gruba ayırdık.",
            realWorldExample = "Kendi kendine giden Tesla araçları, antrenmanda görmediği yeni bir kavşağa girdiğinde kaza yapmamak için bu genelleme testlerinden geçer.",
            practicalTask = "50 elemanlı bir verinin %80'lik eğitim sayısını ekrana yazdırın.",
            starterPlaygroundCode = "eleman_sayisi = 50\negitim_sayisi = int(eleman_sayisi * 0.8)\nprint(\"Eğitim örnekleri:\", egitim_sayisi)",
            miniQuestion = MiniQuestion(
                id = "ai_q_5",
                question = "Eğitim verisinde %98 başarı gösteren bir modelin, test verisinde %52 başarı alması hangi duruma örnektir?",
                options = listOf(
                    "Overfitting (Aşırı Uyum / Ezberleme)",
                    "Underfitting (Yetersiz Öğrenme)",
                    "Mükemmel Genelleme",
                    "Doğru Boyutlandırma"
                ),
                correctIndex = 0,
                explanation = "Eğitimde çok yüksek başarı gösterip yeni test verisinde çuvallamak, modelin kuralları kavramayıp veriyi ezberlediğini (Overfitting) gösterir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_ai_5",
                lessonId = "ai_5",
                title = "Veri Seti Bölücü Yaz",
                instructions = "train_test_ayir(toplam_sayi, oran) fonksiyonunu yazın. Eğitim verisi sayısını int olarak döndürün ve toplam_sayi=200, oran=0.8 için ekrana yazdırın.",
                exampleInput = "train_test_ayir(200, 0.8)",
                exampleOutput = "160",
                starterCode = "def train_test_ayir(toplam, oran):\n    # Kodunu yaz:\n    return 0\n\nprint(train_test_ayir(200, 0.8))",
                solutionCode = "def train_test_ayir(toplam, oran):\n    return int(toplam * oran)\n\nprint(train_test_ayir(200, 0.8))",
                hints = listOf(
                    "return int(toplam * oran) ifadesini kullanın.",
                    "200 * 0.8 = 160 sonucunu verir."
                ),
                testCases = listOf(
                    TestCase("train_test_ayir(200, 0.8)", "160", "Bölme testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "ai_quiz_5_1",
                    lessonId = "ai_5",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Test veri setinin yapay zekaya eğitim esnasında ASLA gösterilmemesinin nedeni nedir?",
                    options = listOf(
                        "Modelin gerçek dünyadaki başarısını tarafsız ve dürüst bir şekilde ölçmek",
                        "Bilgisayarın hafızasını korumak",
                        "Test verilerinin hatalı olması",
                        "Modelin daha yavaş öğrenmesini sağlamak"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Harika! Model soruları önceden görürse sınavın bir anlamı kalmaz; test verisi her zaman gizli tutulur.",
                    explanationWrong = "Test verisi, modelin daha önce hiç görmediği verilerdeki performansını ölçmek için gizlenir.",
                    reviewTopic = "Test Verisinin Rolü"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Overfitting nasıl engellenir?",
                    answer = "Daha fazla veri toplayarak, modeli gereksiz karmaşık yapmayarak (Dropout kullanarak) veya erken durdurma (Early Stopping) yaparak engellenir."
                )
            ),
            completionCriteria = listOf(
                "Overfitting tehlikesini anlamak",
                "Train/Test ayrımının mantığını kavramak"
            )
        ),

        // =========================================================================
        // DERS 6: HATA HESAPLAMA: KAYIP FONKSİYONLARI (ORTA - INTERMEDIATE)
        // =========================================================================
        Lesson(
            id = "ai_6",
            courseId = "ai",
            sectionId = "ai_sec_3",
            title = "Hata Hesaplama: Kayıp Fonksiyonları (Loss Functions)",
            shortDesc = "Ne kadar yanıldık? Modelin yaptığı hatayı tek bir sayıya indirgeyen MSE ve Cross-Entropy.",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true,
            learningObjectives = listOf(
                "Loss (Kayıp) kavramının öğrenmedeki kritik rolünü anlamak",
                "Ortalama Kare Hata (MSE - Mean Squared Error) formülünü çözmek",
                "Amacımızın bu Loss değerini sıfıra yaklaştırmak olduğunu kavramak"
            ),
            prerequisites = listOf("Bölüm 2: Veri Hazırlığı ve Tensörler"),
            subtopics = listOf("Hata Puanı Nedir?", "MSE (Ortalama Kare Hata)", "Neden Kare Alınır?", "Cross-Entropy"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Model Ne Kadar Hata Yaptı?",
                    body = "Bir hedef tahtasına ok attığınızı hayal edin. Hedef tam 12'den vurmak. Sizin attığınız ok 10 santim uzağa düştü.\n\nİşte bu 10 santimlik sapmaya yapay zekada Kayıp (Loss) denir!\n\nEğer Loss = 0 ise, model kusursuz tahmin yapmıştır. Eğer Loss = 100 ise model feci şekilde çuvallamıştır. Eğitim boyunca tek amacımız bu Loss puanını küçültmektir!"
                ),
                LessonContentBlock(
                    subtitle = "2. En Popüler Hata Formülü: MSE (Mean Squared Error)",
                    body = "Ev fiyatını tahmin ediyoruz diyelim:\n• Gerçek Değer (y): 100.000 TL\n• Modelin Tahmini (y_pred): 90.000 TL\n\nFark: `100.000 - 90.000 = 10.000`. Bu farkın karesini alırız: `(10.000)^2`.\n\nNeden kare alıyoruz? İki sebebi var:\n1. Negatif hatalar ile pozitif hatalar birbirini sıfırlamasın (-5 ile +5 toplanınca 0 olmasın).\n2. Büyük hataları daha sert cezalandıralım (10 birim hata yapana 100 ceza puanı verelim!).",
                    tip = "Tahmin sayısal bir değerse MSE, sınıflandırma (kedi mi köpek mi) ise Cross-Entropy Loss kullanılır."
                ),
                LessonContentBlock(
                    subtitle = "3. Kodla MSE Hesabı Yapmak",
                    body = "İşte bir liste tahmin ve gerçek değer arasındaki MSE hesabı:",
                    codeSnippet = "gercek = [10, 20, 30]\ntahmin = [12, 18, 33]\n\nhatalar = [(g - t) ** 2 for g, t in zip(gercek, tahmin)]\nmse = sum(hatalar) / len(hatalar)\nprint(\"Ortalama Kare Hata (MSE):\", mse)"
                )
            ),
            codeExample = "gercek = 50\ntahmin = 45\nhata_karesi = (gercek - tahmin) ** 2\nprint(\"Tekil Örnek Kayıp (Loss):\", hata_karesi)",
            codeExplanation = "Gerçek değer ile tahmin arasındaki farkın karesini alarak kayıp değerini bulduk.",
            realWorldExample = "Borsa veya hava durumu tahmin modellerinde modelin başarısı MSE kayıp değeriyle ölçülür.",
            practicalTask = "Gerçek değeri 100, tahmini 90 olan bir modelin hata karesini ekrana yazdırın.",
            starterPlaygroundCode = "gercek = 100\ntahmin = 90\nloss = (gercek - tahmin) ** 2\nprint(\"Loss değeri:\", loss)",
            miniQuestion = MiniQuestion(
                id = "ai_q_6",
                question = "MSE formülünde gerçek değer ile tahmin arasındaki farkın karesinin alınmasının temel sebebi nedir?",
                options = listOf(
                    "Negatif ve pozitif hataların birbirini nötrlemesini önlemek ve büyük hataları daha çok cezalandırmak",
                    "Bilgisayarın karesi alınmayan sayıları toplayamaması",
                    "Sonucun her zaman sıfır çıkmasını istememiz",
                    "Modelin ağırlıklarını gizlemek"
                ),
                correctIndex = 0,
                explanation = "Kare alma işlemi negatif işaretleri yok eder ve büyük sapmaları katlanarak cezalandırır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_ai_6",
                lessonId = "ai_6",
                title = "Kayıp (Loss) Hesaplayıcı Yaz",
                instructions = "İki sayı arasındaki farkın karesini hesaplayan kare_hata(gercek, tahmin) fonksiyonunu yazın ve 20 ile 15 değerleri için ekrana yazdırın.",
                exampleInput = "kare_hata(20, 15)",
                exampleOutput = "25",
                starterCode = "def kare_hata(gercek, tahmin):\n    # Kodunu yaz:\n    return 0\n\nprint(kare_hata(20, 15))",
                solutionCode = "def kare_hata(gercek, tahmin):\n    return (gercek - tahmin) ** 2\n\nprint(kare_hata(20, 15))",
                hints = listOf(
                    "return (gercek - tahmin) ** 2 ifadesini yazın.",
                    "(20 - 15) = 5, 5'in karesi 25'tir."
                ),
                testCases = listOf(
                    TestCase("kare_hata(20, 15)", "25", "Hata karesi testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "ai_quiz_6_1",
                    lessonId = "ai_6",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir yapay zeka modelinin eğitiminin başarılı gittiğini hangi göstergeden anlarız?",
                    options = listOf(
                        "Loss (Kayıp) değerinin her geçen turda kademeli olarak azalması",
                        "Loss değerinin hızla sonsuza yaklaşması",
                        "Modelin boyutunun her saniye ikiye katlanması",
                        "Hiçbir sayının değişmemesi"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Kesinlikle! Loss sıfıra doğru azaldıkça modelin tahminleri gerçeğe o kadar yaklaşıyor demektir.",
                    explanationWrong = "Başarılı bir eğitimde Loss değeri turlar ilerledikçe düzenli olarak düşer.",
                    reviewTopic = "Loss Grafiği Yorumlama"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Loss değeri tam 0 olabilir mi?",
                    answer = "Teorik olarak mümkün olsa da pratikte Loss'un tam 0 olması neredeyse her zaman modelin veriyi körü körüne ezberlediği (Overfitting) anlamına gelir."
                )
            ),
            completionCriteria = listOf(
                "Loss kavramının amacını anlamak",
                "MSE formülünü kavramak"
            )
        ),

        // =========================================================================
        // DERS 7: GRADYAN İNİŞİ: VADİDEKİ EN DÜŞÜK NOKTAYI BULMAK (ORTA - INTERMEDIATE)
        // =========================================================================
        Lesson(
            id = "ai_7",
            courseId = "ai",
            sectionId = "ai_sec_3",
            title = "Hatalardan Ders Çıkarmak: Gradyan İnişi (Gradient Descent)",
            shortDesc = "Sisli bir dağda vadiye inen dağcı örneği: Öğrenme oranı (Learning Rate) ve adım adım en az hataya ulaşma.",
            level = CourseLevel.INTERMEDIATE,
            order = 7,
            isPremium = true,
            learningObjectives = listOf(
                "Gradyan İnişi (Gradient Descent) optimizasyon algoritmasını anlamak",
                "Öğrenme Oranı (Learning Rate - alpha) ayarının önemini kavramak",
                "Aşırı büyük veya aşırı küçük adımların doğuracağı sonuçları görmek"
            ),
            prerequisites = listOf("Ders 6: Kayıp Fonksiyonları"),
            subtopics = listOf("Sisli Dağdaki Dağcı Benzetmesi", "Türev ve Eğim (Gradient)", "Öğrenme Oranı (Learning Rate)", "Optimizasyon"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Sisli Dağdaki Dağcı Benzetmesi",
                    body = "Gözlerinizi kapatın ve kendinizi dik, sisli bir dağın tepesinde hayal edin. Görüş mesafeniz sıfır ama vadideki köyün çukuruna (en düşük hataya / minimum loss) inmeniz gerekiyor.\n\nNe yaparsınız? Ayağınızla zemini yoklarsınız. Zemin hangi yöne doğru aşağı eğimliyse, o yöne doğru bir adım atarsınız!\n\nİşte Gradient Descent budur: Mevcut ağırlık noktasında hatanın eğimini (türevini) hesaplar ve eğimin tersi yönünde aşağıya doğru bir adım atar."
                ),
                LessonContentBlock(
                    subtitle = "2. Öğrenme Oranı (Learning Rate): Adım Büyüklüğü!",
                    body = "Ne kadar büyük adımlar atacaksınız?\n\n• Adımınız çok küçük olursa (Örn: 0.0000001): Vadiye inmeniz 100 yıl sürer, model öğrenemez.\n• Adımınız çok büyük olursa (Örn: 10.0): Vadiyi ıskalayıp karşıdaki dağın tepesine fırlarsınız (patlama / divergence)!\n\nİşte bu adım büyüklüğüne `Learning Rate` (Öğrenme Oranı) denir. Genellikle `0.001` veya `0.01` gibi tatlı bir denge seçilir.",
                    tip = "Yapay zeka modellerinin iyi eğitilmemesinin bir numaralı sebebi yanlış seçilmiş Learning Rate değeridir."
                ),
                LessonContentBlock(
                    subtitle = "3. Ağırlık Güncelleme Kuralı",
                    body = "Yeni ağırlık formülü:\n`yeni_agirlik = eski_agirlik - (learning_rate * egim)`\n\nEğim pozitifse ağırlığı azaltırız, eğim negatifse ağırlığı artırırız!",
                    codeSnippet = "agirlik = 5.0\negim = 2.0  # Hatanın türevi\nlearning_rate = 0.1\n\n# Bir adım atıyoruz:\nagirlik = agirlik - (learning_rate * egim)\nprint(\"Yeni Ağırlık:\", agirlik) # 4.8"
                )
            ),
            codeExample = "w = 10.0\nlr = 0.05\ngradient = 4.0\nw = w - (lr * gradient)\nprint(\"Güncellenen Ağırlık:\", w)",
            codeExplanation = "Gradient Descent adımı atarak ağırlığı eğimin tersi yönünde güncelledik.",
            realWorldExample = "Kendi kendini süren araçlar direksiyon açısını her milisaniyede gradient descent ile düzelterek şeritte kalır.",
            practicalTask = "Mevcut ağırlığı 8.0, eğimi 2.0, lr=0.1 olan bir güncelleme adımı yapıp sonucu ekrana yazdırın.",
            starterPlaygroundCode = "w = 8.0\negim = 2.0\nlr = 0.1\nyeni_w = w - (lr * egim)\nprint(\"Güncellenmiş ağırlık:\", yeni_w)",
            miniQuestion = MiniQuestion(
                id = "ai_q_7",
                question = "Yapay zeka modelini eğitirken Learning Rate (Öğrenme Oranı) aşırı büyük seçilirse ne olur?",
                options = listOf(
                    "Model minimum hata noktasını ıskalayıp ıraksayabilir (diverge) ve öğrenemez",
                    "Model hemen 1 saniyede mükemmel öğrenir",
                    "Bilgisayarın ekran parlaklığı artar",
                    "Hiçbir etkisi olmaz"
                ),
                correctIndex = 0,
                explanation = "Aşırı büyük learning rate adımları vadideki taban noktasını aşarak zıplamaya ve hatanın kontrolsüz büyümesine yol açar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_ai_7",
                lessonId = "ai_7",
                title = "Ağırlık Güncelleme Adımını Kodla",
                instructions = "agirlik_guncelle(w, egim, lr) fonksiyonunu yazın. Formül: w - (lr * egim). w=10, egim=3, lr=0.1 için sonucu ekrana yazdırın.",
                exampleInput = "agirlik_guncelle(10, 3, 0.1)",
                exampleOutput = "9.7",
                starterCode = "def agirlik_guncelle(w, egim, lr):\n    # Kodunu yaz:\n    return 0.0\n\nprint(agirlik_guncelle(10, 3, 0.1))",
                solutionCode = "def agirlik_guncelle(w, egim, lr):\n    return w - (lr * egim)\n\nprint(agirlik_guncelle(10, 3, 0.1))",
                hints = listOf(
                    "return w - (lr * egim) yazmanız yeterlidir.",
                    "10 - (0.1 * 3) = 9.7 sonucunu üretir."
                ),
                testCases = listOf(
                    TestCase("agirlik_guncelle(10, 3, 0.1)", "9.7", "Güncelleme testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "ai_quiz_7_1",
                    lessonId = "ai_7",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Gradient Descent algoritmasında hangi yöne doğru adım atılır?",
                    options = listOf(
                        "Hatanın eğiminin (gradyanının) tam tersi yönünde",
                        "Rastgele herhangi bir yöne",
                        "Eğimin gösterdiği en dik yukarı yöne",
                        "Sadece sağa doğru"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Eğim yokuş yukarıyı gösterir, biz hatayı azaltmak istediğimiz için eğimin tersine (aşağı) adım atarız.",
                    explanationWrong = "Hatayı azaltmak için türevin (eğimin) zıt yönüne adım atılır.",
                    reviewTopic = "Gradyan Yönü"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Stochastic Gradient Descent (SGD) ve Adam optimizer nedir?",
                    answer = "SGD her adımda verinin rastgele bir parçasını (mini-batch) kullanır. Adam ise hızı ve yönü geçmiş adımların ivmesine göre otomatik ayarlayan en popüler optimize edicidir."
                )
            ),
            completionCriteria = listOf(
                "Gradient Descent ve vadi benzetmesini anlamak",
                "Learning rate ayarının önemini bilmek"
            )
        ),

        // =========================================================================
        // DERS 8: GERİYE YAYILIM (BACKPROPAGATION) (ORTA - INTERMEDIATE)
        // =========================================================================
        Lesson(
            id = "ai_8",
            courseId = "ai",
            sectionId = "ai_sec_3",
            title = "Öğrenmenin Sırrı: Geriye Yayılım (Backpropagation)",
            shortDesc = "Yapay zekayı mümkün kılan sihir: Hatanın suçunu katmanlar boyunca geriye dağıtıp ağırlıkları düzeltmek.",
            level = CourseLevel.INTERMEDIATE,
            order = 8,
            isPremium = true,
            learningObjectives = listOf(
                "İleri Yayılım (Forward Pass) ve Geriye Yayılım (Backward Pass) döngüsünü anlamak",
                "Hatanın suçunu nöronlara paylaştırma mantığını kavramak",
                "Türevin zincir kuralının (Chain Rule) korkutucu olmadığını keşfetmek"
            ),
            prerequisites = listOf("Ders 7: Gradyan İnişi"),
            subtopics = listOf("Forward vs Backward Pass", "Suç Dağıtımı", "Zincir Kuralı Mantığı", "Epoch ve Eğitim Döngüsü"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Bir Şirket Hatası Benzetmesi",
                    body = "Büyük bir şirket düşünün: Çırağı var, ustası var, müdürü var ve genel müdürü var.\n\nŞirket hatalı bir ürün üretti ve müşteri şikayet etti (Loss oluştu).\n\nGenel müdür müdüre bakar: 'Senin suçun ne kadar?', müdür ustaya bakar, usta çırağa bakar. Herkes hatadaki payı kadar fırça yer ve bir dahaki sefere davranışını o pay kadar düzeltir!\n\nİşte Geriye Yayılım (Backpropagation) tam olarak budur: Çıktıdaki toplam hatayı, sondan başa doğru zincirleme olarak her bir ağırlığa paylaştırır."
                ),
                LessonContentBlock(
                    subtitle = "2. Eğitim Döngüsü (Epoch Loop): 4 Adım!",
                    body = "Tüm derin öğrenme modelleri bu 4 adımlık döngüyle eğitilir:\n\n1. İleri Yayılım (Forward): Girdi verilir, model tahmin üretir.\n2. Hata Hesabı (Compute Loss): Gerçek ile tahmin karşılaştırılır, Loss bulunur.\n3. Geriye Yayılım (Backward): Hatanın her ağırlığa göre türevi (gradyanı) geriye doğru hesaplanır.\n4. Optimize Et (Step): Ağırlıklar bir tık düzeltilir ve sıfırlanır.",
                    tip = "PyTorch'ta bu 4 adım sadece 3 satır koddur: `optimizer.zero_grad()`, `loss.backward()`, `optimizer.step()`!"
                ),
                LessonContentBlock(
                    subtitle = "3. Kodla Mini Eğitim Döngüsü Simülasyonu",
                    body = "Gelin tek bir ağırlığı 5 adımda eğitip hatayı nasıl sıfırladığımızı görelim:",
                    codeSnippet = "w = 0.0  # Başlangıç ağırlığı\nhedef = 10.0\n\nfor epoch in range(1, 4):\n    tahmin = w * 2.0\n    loss = (hedef - tahmin) ** 2\n    # Geriye yayılım adımı (hata yönünde ağırlığı artır)\n    w += 1.0\n    print(f\"Epoch {epoch}: Tahmin={tahmin}, Loss={loss:.1f}\")"
                )
            ),
            codeExample = "adimlar = [\"1. Forward (Tahmin Et)\", \"2. Loss (Hatayı Ölç)\", \"3. Backward (Geriye Dağıt)\", \"4. Step (Ağırlığı Düzelt)\"]\nfor a in adimlar:\n    print(a)",
            codeExplanation = "Yapay zekanın kalbindeki 4 adımlık eğitim döngüsünü listeledik.",
            realWorldExample = "Geoffrey Hinton 1986'da Backpropagation makalesini yayınlayarak bugünkü ChatGPT çağının temelini attı.",
            practicalTask = "3 adımlık bir eğitim döngüsü yazıp her adımda azalan bir Loss değerini ekrana yazdırın.",
            starterPlaygroundCode = "for epoch in range(1, 4):\n    loss = 10.0 / epoch\n    print(f\"Epoch {epoch} - Loss: {loss:.2f}\")",
            miniQuestion = MiniQuestion(
                id = "ai_q_8",
                question = "Backpropagation (Geriye Yayılım) algoritmasının temel amacı nedir?",
                options = listOf(
                    "Çıktıdaki hatayı geriye doğru yayarak her bir ağırlığın hatadaki payını (gradyanını) hesaplamak",
                    "Veri setindeki tüm resimleri silmek",
                    "Bilgisayarın işletim sistemini yeniden başlatmak",
                    "İnternet bağlantısını hızlandırmak"
                ),
                correctIndex = 0,
                explanation = "Backpropagation, türevin zincir kuralını kullanarak hatanın her bir ağırlığa olan hassasiyetini sondan başa doğru hesaplar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_ai_8",
                lessonId = "ai_8",
                title = "Mini Eğitim Döngüsü Simülatörü",
                instructions = "Verilen epoch sayısına göre 'Egitim tamamlandi' çıktısını ve son adım sayısını döndüren egitim_dongusu(epoch_sayisi) fonksiyonunu yazın ve 5 için çalıştırın.",
                exampleInput = "egitim_dongusu(5)",
                exampleOutput = "5 adim tamamlandi",
                starterCode = "def egitim_dongusu(n):\n    # Kodunu yaz:\n    return \"\"\n\nprint(egitim_dongusu(5))",
                solutionCode = "def egitim_dongusu(n):\n    return f\"{n} adim tamamlandi\"\n\nprint(egitim_dongusu(5))",
                hints = listOf(
                    "f\"{n} adim tamamlandi\" string'ini return edin.",
                    "print ile ekrana yazdırın."
                ),
                testCases = listOf(
                    TestCase("egitim_dongusu(5)", "5 adim tamamlandi", "Döngü testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "ai_quiz_8_1",
                    lessonId = "ai_8",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Tüm eğitim veri setinin modelden bir tam tur geçmesine ne ad verilir?",
                    options = listOf("Epoch", "Batch", "Tensor", "Dropout"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Modelin veri setindeki tüm örnekleri bir kez görüp eğitilmesine 1 Epoch denir.",
                    explanationWrong = "Veri setinin baştan sona bir tam tur geçişine Epoch denir.",
                    reviewTopic = "Epoch Kavramı"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Backpropagation elle türev almayı gerektirir mi?",
                    answer = "Eskiden gerektiriyordu! Bugün PyTorch (Autograd) ve TensorFlow gibi kütüphaneler tüm zincir kuralı türevlerini arkada otomatik olarak alır (Automatic Differentiation)."
                )
            ),
            completionCriteria = listOf(
                "İleri ve Geriye yayılım arasındaki farkı anlamak",
                "4 adımlık eğitim döngüsünü kavramak"
            )
        ),

        // =========================================================================
        // DERS 9: ÇOK KATMANLI SİNİR AĞLARI (MLP) (İLERİ - ADVANCED)
        // =========================================================================
        Lesson(
            id = "ai_9",
            courseId = "ai",
            sectionId = "ai_sec_4",
            title = "Çok Katmanlı Ağlar (MLP): Kendi Model Sınıfını Yazmak",
            shortDesc = "Katmanlar birleşiyor! PyTorch nn.Module yapısıyla sıfırdan çok katmanlı sinir ağı (MLP) inşa etmek.",
            level = CourseLevel.ADVANCED,
            order = 9,
            isPremium = true,
            learningObjectives = listOf(
                "Çok Katmanlı Algılayıcı (Multi-Layer Perceptron - MLP) mimarisini kavramak",
                "Girdi Katmanı, Gizli Katmanlar (Hidden Layers) ve Çıktı Katmanı hiyerarşisini kurmak",
                "PyTorch tarzı modern bir model sınıfı ve forward fonksiyonu yazmak"
            ),
            prerequisites = listOf("Bölüm 3: Model Nasıl Öğrenir?"),
            subtopics = listOf("Derin Ağ Mimarisi", "Gizli Katmanların Gücü", "PyTorch nn.Module", "Forward Fonksiyonu"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Neden 'Derin' Öğrenme?",
                    body = "Tek bir nöron sadece basit bir karar verebilir. Fakat yüzlerce nöronu arka arkaya katmanlar halinde bağlarsanız mucizeler başlar:\n\n• 1. Katman: Resimdeki pikselleri ve basit çizgileri tanır.\n• 2. Katman: Çizgileri birleştirip göz, burun, kulak gibi şekilleri yakalar.\n• 3. Katman: Şekilleri birleştirip 'Bu bir kedi yüzü!' kararını verir.\n\nİşte birden fazla gizli katmana sahip bu ağlara Derin Yapay Sinir Ağı (Deep Neural Network) denir."
                ),
                LessonContentBlock(
                    subtitle = "2. PyTorch ile Kendi Model Mimarini Kodlamak",
                    body = "Dünyadaki tüm profesyonel yapay zeka mühendisleri modellerini nesne yönelimli (OOP) sınıflar olarak yazar. Sınıf iki ana parçadan oluşur:\n\n1. `__init__`: Katmanları tanımladığımız oda (Örn: 10 girdi -> 64 gizli nöron -> 1 çıktı).\n2. `forward`: Girdinin bu katmanlardan sırayla geçip ReLU aktivasyonlarıyla işlendiği koridor!",
                    tip = "Katmanlar arasındaki boyutların eşleşmesi kritiktir: 1. katman 64 çıktı veriyorsa, 2. katman 64 girdi kabul etmelidir!"
                ),
                LessonContentBlock(
                    subtitle = "3. Örnek Model Kodu",
                    body = "Gelin saf Python ile bir Model sınıfı yazalım:",
                    codeSnippet = "class KendiModelim:\n    def __init__(self, girdi_boyutu, gizli_noron, cikti_boyutu):\n        self.w1 = 0.5\n        self.w2 = 0.8\n        print(f\"Model Kuruldu: {girdi_boyutu} -> {gizli_noron} -> {cikti_boyutu}\")\n        \n    def forward(self, x):\n        gizli = max(0, x * self.w1) # ReLU aktivasyonu\n        cikti = gizli * self.w2\n        return cikti\n\nmodel = KendiModelim(1, 10, 1)\nprint(\"Tahmin:\", model.forward(4.0))"
                )
            ),
            codeExample = "class YapayZekaAgi:\n    def __init__(self):\n        self.katmanlar = [\"Girdi (Input: 784)\", \"Gizli Katman 1 (Linear: 128)\", \"ReLU()\", \"Çıktı (Output: 10)\"]\n    def mimariyi_goster(self):\n        return \" -> \".join(self.katmanlar)\n\nmodel = YapayZekaAgi()\nprint(\"Model Mimarisi:\", model.mimariyi_goster())",
            codeExplanation = "Klasik bir MNIST el yazısı rakam sınıflandırıcı derin ağ mimarisini kurduk.",
            realWorldExample = "Kredi onay sistemleri ve müşteri kaybı (churn) tahmin motorları bu çok katmanlı MLP ağlarıyla çalışır.",
            practicalTask = "Kendi model sınıfınızı oluşturup forward fonksiyonundan bir tahmin çıktısı yazdırın.",
            starterPlaygroundCode = "class MiniModel:\n    def forward(self, x):\n        return x * 2.5 + 1.0\n\nm = MiniModel()\nprint(\"Model Tahmini:\", m.forward(10))",
            miniQuestion = MiniQuestion(
                id = "ai_q_9",
                question = "Derin bir yapay sinir ağında ilk katman 32 nöronluk çıktı üretiyorsa, hemen ardından gelen ikinci katmanın girdi boyutu kaç olmalıdır?",
                options = listOf("Tam olarak 32", "İstediğimiz herhangi bir sayı", "1", "0"),
                correctIndex = 0,
                explanation = "Katmanlar birbirine bağlandığı için bir önceki katmanın çıkış boyutu, bir sonraki katmanın giriş boyutuyla birebir eşleşmelidir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_ai_9",
                lessonId = "ai_9",
                title = "Model Sınıfı ve Forward Metodu Yaz",
                instructions = "LinearModel sınıfı oluşturun. forward(x) metodu x * 3 + 2 değerini döndürsün. x=5 için model çıktısını ekrana yazdırın.",
                exampleInput = "LinearModel().forward(5)",
                exampleOutput = "17",
                starterCode = "class LinearModel:\n    def forward(self, x):\n        # Kodunu yaz:\n        return 0\n\nm = LinearModel()\nprint(m.forward(5))",
                solutionCode = "class LinearModel:\n    def forward(self, x):\n        return (x * 3) + 2\n\nm = LinearModel()\nprint(m.forward(5))",
                hints = listOf(
                    "return (x * 3) + 2 ifadesini yazın.",
                    "5 * 3 + 2 = 17 sonucunu ekrana yazdırın."
                ),
                testCases = listOf(
                    TestCase("LinearModel().forward(5)", "17", "Model testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "ai_quiz_9_1",
                    lessonId = "ai_9",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Derin sinir ağlarında Girdi (Input) ve Çıktı (Output) katmanları arasında yer alan tüm katmanlara ne ad verilir?",
                    options = listOf("Gizli Katmanlar (Hidden Layers)", "Kayıp Katmanları", "Türev Katmanları", "Statik Katmanlar"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Dış dünyadan doğrudan beslenmeyen ve ara özellikleri öğrenen katmanlara Gizli Katman (Hidden Layer) denir.",
                    explanationWrong = "Aradaki özellik çıkarıcı katmanlara Gizli Katmanlar (Hidden Layers) adı verilir.",
                    reviewTopic = "Gizli Katman Kavramı"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Bir modele ne kadar çok katman eklersek o kadar iyi mi olur?",
                    answer = "Her zaman değil! Çok fazla katman modeli aşırı hantallaştırabilir, kaybolan gradyan (vanishing gradient) problemine veya ezberlemeye (overfitting) yol açabilir."
                )
            ),
            completionCriteria = listOf(
                "Çok katmanlı ağların nasıl çalıştığını bilmek",
                "PyTorch tarzı Model sınıfı yapısını kavramak"
            )
        ),

        // =========================================================================
        // DERS 10: EVRİŞİMLİ SİNİR AĞLARI (CNN) (İLERİ - ADVANCED)
        // =========================================================================
        Lesson(
            id = "ai_10",
            courseId = "ai",
            sectionId = "ai_sec_4",
            title = "Gören Yapay Zeka: Evrişimli Sinir Ağları (CNN)",
            shortDesc = "Bilgisayarlı görü (Computer Vision) devrimi: Filtreler (Kernels), kenar bulma ve Max Pooling ile görüntü işleme.",
            level = CourseLevel.ADVANCED,
            order = 10,
            isPremium = true,
            learningObjectives = listOf(
                "Evrişimli Sinir Ağlarının (Convolutional Neural Networks - CNN) neden görüntüler için mükemmel olduğunu anlamak",
                "Filtre (Kernel) gezdirerek kenarları, köşeleri ve desenleri yakalama mantığını kavramak",
                "Ortaklama (Pooling) ile görüntü boyutunu küçültüp hesaplamayı hızlandırmayı öğrenmek"
            ),
            prerequisites = listOf("Ders 9: Çok Katmanlı Ağlar (MLP)"),
            subtopics = listOf("Bilgisayarlı Görü", "Evrişim (Convolution) Nedir?", "Kernel/Filtre Mantığı", "Max Pooling"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Düz Katmanlar Fotoğraflarda Neden Çöker?",
                    body = "Normal bir fotoğrafta 1 milyon piksel vardır. Düz bir ağa verirseniz milyarlarca ağırlık gerekir ve bilgisayar kilitlenir!\n\nDahası, kedi fotoğrafın ister sol üst köşesinde olsun ister sağ alt köşesinde, o hala bir kedidir! Normal ağlar nesnenin yer değiştirmesini anlayamazken, CNN (Evrişimli Sinir Ağları) tam olarak bunu çözer."
                ),
                LessonContentBlock(
                    subtitle = "2. Büyüteçle Gezmek: Filtre (Kernel) Mantığı",
                    body = "Elinizde 3x3 boyutunda küçük bir büyüteç (filtre) hayal edin. Bu büyüteci fotoğrafın en sol üstünden başlatıp adım adım sağa ve aşağı doğru kaydırırsınız.\n\nFiltre gezdikçe:\n• 1. Filtre fotoğraftaki dikey çizgileri parlatır.\n• 2. Filtre yatay çizgileri parlatır.\n• 3. Filtre daireleri ve yuvarlak hatları yakalar!\n\nBöylece devasa bir fotoğraf, önemli görsel özelliklerin özet haritasına dönüşür.",
                    tip = "Max Pooling adımı ise 2x2'lik kutulardaki sadece en büyük sayıyı alarak resmi yarı yarıya küçültür."
                ),
                LessonContentBlock(
                    subtitle = "3. Kodla Mini 2D Evrişim (Filtre) Simülasyonu",
                    body = "Gelin bir filtrenin pikselle nasıl çarpıldığını görelim:",
                    codeSnippet = "# 3x3 piksel bölgesi ve kenar bulucu filtre\npikseller = [10, 10, 10]\nfiltre = [-1, 2, -1] # Kenar vurgulayıcı\n\nvurgu = sum(p * f for p, f in zip(pikseller, filtre))\nprint(\"Kenar Yanıtı:\", vurgu) # 0 (düz zemin, kenar yok!)"
                )
            ),
            codeExample = "cnn_katmanlari = [\"Conv2d(3 -> 32 filtre)\", \"ReLU()\", \"MaxPool2d(2x2)\", \"Conv2d(32 -> 64)\", \"Linear Sınıflandırıcı\"]\nprint(\"CNN Görme Hattı:\")\nfor k in cnn_katmanlari:\n    print(\" •\", k)",
            codeExplanation = "Klasik bir CNN görüntü tanıma işlem hattını listeledik.",
            realWorldExample = "Telefonunuzun yüz tanıma kilidi (FaceID) ve tıpta röntgen filmlerinde tümör teşhisi CNN modelleriyle yapılır.",
            practicalTask = "Bir CNN modelinin filtre sayısını ve çıktı mesajını ekrana yazdırın.",
            starterPlaygroundCode = "filtre_sayisi = 64\nprint(f\"CNN Modeli Aktif: {filtre_sayisi} özellik filtresi taranıyor...\")",
            miniQuestion = MiniQuestion(
                id = "ai_q_10",
                question = "CNN mimarisinde Max Pooling katmanının temel görevi nedir?",
                options = listOf(
                    "Özellik haritasının boyutunu küçülterek hesaplama yükünü azaltmak ve önemli özellikleri korumak",
                    "Görüntüyü tamamen silmek",
                    "Ağırlık sayısını sonsuza çıkarmak",
                    "Renkli görüntüyü siyah beyaza çevirmek"
                ),
                correctIndex = 0,
                explanation = "Max Pooling, piksel pencerelerindeki en yüksek sinyali seçerek boyutları küçültür ve hesaplamayı hızlandırır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_ai_10",
                lessonId = "ai_10",
                title = "1D Evrişim (Filtre Çarpımı) Hesapla",
                instructions = "filtre_uygula(sinyal, filtre) fonksiyonunu yazın. İki listenin karşılıklı elemanlarını çarpıp toplayın. sinyal=[2, 4, 2], filtre=[-1, 2, -1] için sonucu ekrana yazdırın.",
                exampleInput = "filtre_uygula([2, 4, 2], [-1, 2, -1])",
                exampleOutput = "4",
                starterCode = "def filtre_uygula(sinyal, filtre):\n    # Kodunu yaz:\n    return 0\n\nprint(filtre_uygula([2, 4, 2], [-1, 2, -1]))",
                solutionCode = "def filtre_uygula(sinyal, filtre):\n    return sum(s * f for s, f in zip(sinyal, filtre))\n\nprint(filtre_uygula([2, 4, 2], [-1, 2, -1]))",
                hints = listOf(
                    "sum(s * f for s, f in zip(sinyal, filtre)) yazın.",
                    "(2*-1) + (4*2) + (2*-1) = -2 + 8 - 2 = 4 sonucunu üretir."
                ),
                testCases = listOf(
                    TestCase("filtre_uygula([2, 4, 2], [-1, 2, -1])", "4", "Evrişim testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "ai_quiz_10_1",
                    lessonId = "ai_10",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "CNN modellerinde resmin üzerinde adım adım kaydırılan küçük ağırlık matrisine ne ad verilir?",
                    options = listOf("Kernel (Filtre)", "Loss", "Bias", "Epoch"),
                    correctOptionIndex = 0,
                    explanationRight = "Tebrikler! Görüntünün üzerinde gezerek özellikleri toplayan küçük matrise Kernel ya da Filtre denir.",
                    explanationWrong = "Bu küçük matrise Kernel (Filtre) denir.",
                    reviewTopic = "Kernel / Filtre Kavramı"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "YOLO (You Only Look Once) nedir?",
                    answer = "YOLO, görüntüyü tek seferde tarayarak nesnelerin yerini (kutu içine alarak) ve türünü saniyede 60+ kare hızında gerçek zamanlı tespit eden efsanevi bir CNN mimarisidir."
                )
            ),
            completionCriteria = listOf(
                "CNN mantığını ve görüntülerin nasıl işlendiğini anlamak",
                "Kernel ve Pooling kavramlarını kavramak"
            )
        ),

        // =========================================================================
        // DERS 11: CHATGPT VE TRANSFORMER MİMARİSİ (UZMAN - EXPERT)
        // =========================================================================
        Lesson(
            id = "ai_11",
            courseId = "ai",
            sectionId = "ai_sec_5",
            title = "ChatGPT Nasıl Çalışır? Self-Attention ve Transformer Mimarisi",
            shortDesc = "Büyük Dil Modellerinin (LLM) kalbi: 'Attention Is All You Need', kelimelerin birbirine dikkat etmesi ve Tokenization.",
            level = CourseLevel.EXPERT,
            order = 11,
            isPremium = true,
            learningObjectives = listOf(
                "Büyük Dil Modellerinin (LLM) metinleri nasıl anladığını çözmek",
                "Tokenization ve Kelime Gömme (Embedding) mantığını kavramak",
                "Self-Attention (Öz-Dikkat) mekanizmasının bağlamı nasıl yakaladığını öğrenmek"
            ),
            prerequisites = listOf("Bölüm 4: Kendi Derin Sinir Ağını İnşa Etmek"),
            subtopics = listOf("Dil Modelleri Nasıl Çalışır?", "Token Nedir?", "Word Embeddings", "Self-Attention Mekanizması"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. 'Banka' Kelimesi Ne Demek?",
                    body = "Şu iki cümleye bakın:\n1. 'Parayı bankaya yatırdım.'\n2. 'Nehir kenarındaki bankta oturdum.'\n\nEski yapay zekalar 'banka' kelimesini gördüğünde ikisini de aynı sanırdı! Oysa kelimelerin anlamı, etrafındaki diğer kelimelerle olan ilişkisine bağlıdır.\n\n2017'de Google araştırmacılarının icat ettiği Transformer mimarisi, her kelimenin cümledeki diğer TÜM kelimelere 'dikkat etmesini' (Attention) sağladı!"
                ),
                LessonContentBlock(
                    subtitle = "2. Adım 1: Tokenization ve Embedding",
                    body = "Bilgisayar harfleri okuyamaz. Bu yüzden cümle önce 'Token' adı verilen hece parçalarına ayrılır:\n'Yapay zeka harika' -> `[1254, 8821, 412]`\n\nArdından her sayı, bir anlam uzayında yüzlerce boyuttan oluşan bir vektöre (Embedding) dönüştürülür. Örneğin 'Kral' vektöründen 'Erkek' çıkarıp 'Kadın' eklerseniz matematiksel olarak 'Kraliçe' vektörüne ulaşırsınız!",
                    tip = "Büyük dil modellerinin temel görevi aslında tek bir şeydir: 'Verilen kelimelerden sonra gelebilecek en olası bir sonraki kelimeyi tahmin etmek!'"
                ),
                LessonContentBlock(
                    subtitle = "3. Kodla Mini Attention Benzetimi",
                    body = "Gelin iki kelime arasındaki alaka skorunu (Dot Product) hesaplayalım:",
                    codeSnippet = "# İki kelimenin anlam vektörleri\nvektor_kedi = [0.9, 0.8, 0.1]\nvektor_kopek = [0.8, 0.9, 0.1]\nvektor_araba = [0.1, 0.2, 0.9]\n\ndef benzerlik(v1, v2):\n    return sum(a * b for a, b in zip(v1, v2))\n\nprint(\"Kedi-Köpek Alakası:\", benzerlik(vektor_kedi, vektor_kopek)) # Yüksek (~1.45)\nprint(\"Kedi-Araba Alakası:\", benzerlik(vektor_kedi, vektor_araba)) # Düşük (~0.34)"
                )
            ),
            codeExample = "prompt = \"Yapay zeka geleceği\"\ntokenlar = [\"Yapay\", \" zeka\", \" geleceği\"]\nprint(\"Kelimeler tokenlara ayrıldı:\", tokenlar)\nprint(\"Tahmin edilen bir sonraki token: ' değiştirecek.'\")",
            codeExplanation = "LLM modellerinin bir sonraki kelimeyi (Next Token Prediction) üretme akışını simüle ettik.",
            realWorldExample = "ChatGPT, Claude, Gemini ve GitHub Copilot tamamen bu Transformer & Attention mimarisi üzerine kuruludur.",
            practicalTask = "Bir sonraki token tahminini ve prompt metnini ekrana yazdıran bir kod çalıştırın.",
            starterPlaygroundCode = "prompt = \"Derin ogrenme ile\"\nsonraki_kelime = \"kendi modelini egit!\"\nprint(f\"Metin: {prompt} -> Tahmin: {sonraki_kelime}\")",
            miniQuestion = MiniQuestion(
                id = "ai_q_11",
                question = "ChatGPT ve Transformer mimarisinde 'Self-Attention' mekanizmasının ana görevi nedir?",
                options = listOf(
                    "Cümledeki bir kelimenin, cümledeki diğer kelimelerle olan anlamsal bağını ve bağlamını hesaplamak",
                    "İnternetteki tüm siteleri silmek",
                    "Kullanıcının klavye tuşlarına basma hızını ölçmek",
                    "Resimleri PDF formatına çevirmek"
                ),
                correctIndex = 0,
                explanation = "Self-Attention, bir kelimenin cümledeki bağlamını anlamak için diğer kelimelerle olan ağırlıklı ilişkisini hesaplar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_ai_11",
                lessonId = "ai_11",
                title = "Vektör Benzerlik (Dot Product) Motoru",
                instructions = "İki eşit uzunluktaki vektörün nokta çarpımını (benzerlik skorunu) hesaplayan vektor_benzerlik(v1, v2) fonksiyonunu yazın ve [1, 2] ile [3, 4] için ekrana yazdırın.",
                exampleInput = "vektor_benzerlik([1, 2], [3, 4])",
                exampleOutput = "11",
                starterCode = "def vektor_benzerlik(v1, v2):\n    # Kodunu yaz:\n    return 0\n\nprint(vektor_benzerlik([1, 2], [3, 4]))",
                solutionCode = "def vektor_benzerlik(v1, v2):\n    return sum(a * b for a, b in zip(v1, v2))\n\nprint(vektor_benzerlik([1, 2], [3, 4]))",
                hints = listOf(
                    "sum(a * b for a, b in zip(v1, v2)) kullanın.",
                    "(1*3) + (2*4) = 3 + 8 = 11 sonucunu üretir."
                ),
                testCases = listOf(
                    TestCase("vektor_benzerlik([1, 2], [3, 4])", "11", "Vektör testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "ai_quiz_11_1",
                    lessonId = "ai_11",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Büyük Dil Modellerinin (LLM) temel çalışma prensibi aşağıdakilerden hangisidir?",
                    options = listOf(
                        "Kendisine verilen metne bakarak bir sonraki en olası kelimeyi (token) olasılıkla tahmin etmek",
                        "Gerçek bir insan gibi rüya görmek",
                        "Tüm dünya dillerini bir veritabanında sabit metin olarak saklamak",
                        "Cevapları Google'da aratıp kopyala-yapıştır yapmak"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Aynen öyle! LLM'ler muazzam bir bağlam içinde bir sonraki kelimeyi (Next Token Prediction) tahmin eden olasılık motorlarıdır.",
                    explanationWrong = "LLM modelleri bir sonraki en olası token'ı tahmin ederek metin üretir.",
                    reviewTopic = "LLM Çalışma Prensibi"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Kendi mini dil modelimi eğitebilir miyim?",
                    answer = "Evet! Andrej Karpathy'nin 'nanoGPT' projesinde olduğu gibi, sadece birkaç yüz satır PyTorch koduyla Shakespeare metinleri üreten kendi mini dil modelinizi evinizdeki bilgisayarda eğitebilirsiniz."
                )
            ),
            completionCriteria = listOf(
                "Transformer ve Self-Attention mantığını kavramak",
                "Tokenization ve Embedding kavramlarını bilmek"
            )
        ),

        // =========================================================================
        // DERS 12: BÜYÜK FİNAL: KENDİ MODELİNİ EĞİT, KAYDET VE CANLIYA AL! (UZMAN)
        // =========================================================================
        Lesson(
            id = "ai_12",
            courseId = "ai",
            sectionId = "ai_sec_5",
            title = "Büyük Final: Kendi Modelini Sıfırdan Eğit, Kaydet ve Canlıya Al!",
            shortDesc = "Bütün parçalar birleşiyor: Veri yükleme, eğitim döngüsü, model ağırlıklarını kaydetme (.pth/ONNX) ve canlı tahmin (Inference).",
            level = CourseLevel.EXPERT,
            order = 12,
            isPremium = true,
            learningObjectives = listOf(
                "Sıfırdan uçtan uca eksiksiz bir yapay zeka geliştirme hattı (Pipeline) kurmak",
                "Eğitilen en iyi modelin ağırlıklarını diske kaydetmeyi öğrenmek",
                "Kaydedilen modeli üretim ortamında (API / Mobil) canlı tahminde (Inference) çalıştırmak"
            ),
            prerequisites = listOf("Ders 1'den 11'e kadar olan tüm adımlar"),
            subtopics = listOf("Uçtan Uca Yapay Zeka Hattı", "Modeli Kaydetmek (State Dict)", "Modeli Yüklemek", "Canlı Tahmin (Inference API)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Tebrikler! Tüm Parçaları Birleştiriyoruz",
                    body = "Tebrikler! Yapay zekanın ilk nöronundan başladınız, aktivasyon fonksiyonlarını, tensörleri, veri bölmeyi, kayıp fonksiyonlarını, geriye yayılımı, derin ağları ve Transformer mimarisini öğrendiniz.\n\nŞimdi gerçek bir yapay zeka mühendisi gibi kendi modelinizi sıfırdan eğitecek, ağırlıklarını kaydedecek ve canlıya alacaksınız!"
                ),
                LessonContentBlock(
                    subtitle = "2. Modeli Kaydetmek: Ağırlıklar (Weights) Dosyası",
                    body = "Modeli her çalıştırmada saatlerce tekrar eğitmeyiz! Model eğitildikten sonra öğrendiği en iyi ağırlık matrislerini bir dosyaya kaydederiz (`model.pth` veya `model.onnx`).\n\nBu dosya genellikle birkaç megabayt veya gigabaytlık sayılar tablosudur. Canlı sunucuda sadece boş model iskeletini oluşturup bu ağırlıkları içine yükleriz (`model.load_state_dict()`).",
                    tip = "ONNX formatı sayesinde PyTorch'ta eğittiğiniz bir modeli Android veya iOS mobil uygulamanızda internet bile olmadan çevrimdışı çalıştırabilirsiniz!"
                ),
                LessonContentBlock(
                    subtitle = "3. Tam Eğitim ve Canlıya Alma Kodu",
                    body = "İşte bir modelin eğitilip canlı tahmin üretmesinin tam özeti:",
                    codeSnippet = "# Tam Yapay Zeka Hattı Simülasyonu\nclass FinalModel:\n    def __init__(self):\n        self.w = 0.0\n    def fit(self, veri, hedef_katsayi=4.0):\n        # Eğitim döngüsü: En iyi ağırlığı bul\n        self.w = hedef_katsayi\n        print(f\"✓ Model eğitildi! En iyi ağırlık: {self.w}\")\n    def predict(self, x):\n        return x * self.w\n\nmodel = FinalModel()\nmodel.fit([1, 2, 3])\ntahmin = model.predict(10)\nprint(\"Canlı Tahmin (Inference):\", tahmin) # 40.0"
                )
            ),
            codeExample = "class YapayZekaPipeline:\n    def egit_ve_kaydet(self):\n        return \"✓ Model başarıyla eğitildi ve 'model_weights.pth' olarak kaydedildi.\"\n    def canli_tahmin(self, yeni_veri):\n        return f\"Girdi: {yeni_veri} -> Model Kararı: Onaylandı (%98.5 Güven)\"\n\npipeline = YapayZekaPipeline()\nprint(pipeline.egit_ve_kaydet())\nprint(pipeline.canli_tahmin(\"Kullanıcı #1042\"))",
            codeExplanation = "Eğitim, ağırlık kaydetme ve canlı tahmin pipeline'ını çalıştırdık.",
            realWorldExample = "Hugging Face, ChatGPT API ve mobil uygulamalardaki yapay zeka özellikleri bu şekilde canlıya alınır.",
            practicalTask = "Kendi model pipeline'ınızı kurup 'Model canlıda' mesajını ve tahmin sonucunu ekrana yazdırın.",
            starterPlaygroundCode = "class FinalAiModel:\n    def predict(self, x):\n        return x * 100\n\nm = FinalAiModel()\nprint(\"Model canlıda! Tahmin:\", m.predict(5))",
            miniQuestion = MiniQuestion(
                id = "ai_q_12",
                question = "Eğitilmiş bir modelin ağırlıklarını diske kaydetmenin en büyük avantajı nedir?",
                options = listOf(
                    "Modeli her kullanımda tekrar saatlerce eğitmek zorunda kalmadan anında yükleyip tahmin (inference) üretebilmek",
                    "Bilgisayarın hafıza kartını temizlemek",
                    "Modelin internet hızını iki katına çıkarmak",
                    "Geliştiricinin adını koda eklemek"
                ),
                correctIndex = 0,
                explanation = "Ağırlıklar kaydedildiğinde, model doğrudan üretim ortamına taşınabilir ve milisaniyeler içinde tahmin yapmaya hazır hale gelir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_ai_12",
                lessonId = "ai_12",
                title = "Kendi Yapay Zeka Pipeline'ını Yaz",
                instructions = "KendiModelPipeline sınıfı yazın. predict(x) metodu girdi sayısını 100 ile çarparak döndürsün. x=7 için model çıktısını ekrana yazdırın.",
                exampleInput = "KendiModelPipeline().predict(7)",
                exampleOutput = "700",
                starterCode = "class KendiModelPipeline:\n    def predict(self, x):\n        # Kodunu yaz:\n        return 0\n\nmodel = KendiModelPipeline()\nprint(model.predict(7))",
                solutionCode = "class KendiModelPipeline:\n    def predict(self, x):\n        return x * 100\n\nmodel = KendiModelPipeline()\nprint(model.predict(7))",
                hints = listOf(
                    "return x * 100 ifadesini yazın.",
                    "7 * 100 = 700 sonucunu ekrana yazdırın."
                ),
                testCases = listOf(
                    TestCase("KendiModelPipeline().predict(7)", "700", "Pipeline testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "ai_quiz_12_1",
                    lessonId = "ai_12",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir yapay zeka projesinde baştan sona izlenen doğru sıra aşağıdakilerden hangisidir?",
                    options = listOf(
                        "1. Veri Hazırlığı -> 2. Model Mimarisi -> 3. Eğitim & Loss Azaltma -> 4. Test & Değerlendirme -> 5. Canlıya Alma (Inference)",
                        "1. Canlıya Alma -> 2. Veri Toplama -> 3. Model Eğitimi",
                        "1. Loss Hesaplama -> 2. Veriyi Silme -> 3. Bitiş",
                        "1. Tahmin Üretme -> 2. Nöronları Çıkarma"
                    ),
                    correctOptionIndex = 0,
                    explanationRight = "Mükemmel! Bir yapay zeka mühendisinin tam yol haritasını kusursuz şekilde kavradınız.",
                    explanationWrong = "Sıralama: Veri Hazırlığı -> Model Mimarisi -> Eğitim -> Test -> Canlıya Alma şeklindedir.",
                    reviewTopic = "Uçtan Uca Yapay Zeka Hattı"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Buradan sonra hangi adımı atmalıyım?",
                    answer = "Kaggle veya Google Colab üzerinden ücretsiz GPU alarak PyTorch veya TensorFlow ile gerçek dünya veri setleri üzerinde ilk derin öğrenme modelinizi çalıştırmaya başlayabilirsiniz!"
                )
            ),
            communityInsights = listOf(
                CommunityInsight(
                    source = "Andrej Karpathy (OpenAI & Tesla AI)",
                    topic = "Yapay Zeka Öğrenmenin Sırrı",
                    insight = "En iyi öğrenme yöntemi, sıfırdan bir 'micrograd' veya 'nanoGPT' yazarak tensörlerin ve geriye yayılımın arkasındaki matematiği hissetmektir."
                )
            ),
            completionCriteria = listOf(
                "Uçtan uca yapay zeka model geliştirme adımlarını bilmek",
                "Model kaydetme ve canlı tahmin mantığını kavramak"
            )
        )
    )
}
