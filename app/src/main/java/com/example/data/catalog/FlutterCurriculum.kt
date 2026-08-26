package com.example.data.catalog

import com.example.model.*

/**
 * Flutter Kolay & Anlaşılır Müfredatı (12 Adım):
 * Tek kodla hem iOS hem Android uygulama geliştirme sanatı!
 */
object FlutterCurriculum {

    fun getSections(): List<CourseSection> = listOf(
        CourseSection(
            id = "fl_sec_1",
            courseId = "flutter",
            title = "Bölüm 1: Flutter Dünyası ve Temel Widget'lar",
            level = CourseLevel.BEGINNER,
            order = 1,
            description = "Flutter'ın altın kuralı: 'Her şey bir Widget'tır!'. Scaffold, Text, Container ve sayfa düzeni.",
            learningObjectives = listOf("Flutter'ın nasıl çalıştığını öğrenmek", "Scaffold ve AppBar ile sayfa çatısı kurmak", "Column ve Row ile elemanları dizmek"),
            prerequisites = listOf("Temel Dart bilgisi veya sıfırdan başlama hevesi.")
        ),
        CourseSection(
            id = "fl_sec_2",
            courseId = "flutter",
            title = "Bölüm 2: Butonlar, Durumlar (State) ve Listeler",
            level = CourseLevel.BEGINNER,
            order = 2,
            description = "Stateless vs Stateful widget farkı, butona tıklayınca değişen ekranlar ve ListView.",
            learningObjectives = listOf("Stateless ve Stateful farkını kavramak", "setState ile ekranı tazelemek", "ListView.builder ile kaydırılabilir listeler yapmak"),
            prerequisites = listOf("Temel Widget'lar")
        ),
        CourseSection(
            id = "fl_sec_3",
            courseId = "flutter",
            title = "Bölüm 3: Sayfalar Arası Geçiş ve Tasarım",
            level = CourseLevel.INTERMEDIATE,
            order = 3,
            description = "Navigator ile yeni sayfaya gitme, geri dönme ve Material 3 temaları.",
            learningObjectives = listOf("Navigator.push ve pop ile sayfa değiştirmek", "Material 3 renk ve temalarını uygulamak"),
            prerequisites = listOf("Widget'lar ve Listeler")
        ),
        CourseSection(
            id = "fl_sec_4",
            courseId = "flutter",
            title = "Bölüm 4: Durum Yönetimi (State Management)",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            description = "Uygulamanın her yerinden erişilebilen sepet veya kullanıcı durumu (Provider / Riverpod).",
            learningObjectives = listOf("State Management neden gereklidir anlamak", "Provider veya ValueNotifier ile veri paylaşmak"),
            prerequisites = listOf("StatefulWidget ve Navigasyon")
        ),
        CourseSection(
            id = "fl_sec_5",
            courseId = "flutter",
            title = "Bölüm 5: Canlı Animasyonlar ve İnternet Verisi",
            level = CourseLevel.ADVANCED,
            order = 5,
            description = "Göz alıcı Hero ve AnimatedContainer animasyonları, API'den internet verisi çekme.",
            learningObjectives = listOf("AnimatedContainer ile akıcı geçişler yapmak", "http paketiyle internetten veri çekip göstermek"),
            prerequisites = listOf("Temel Flutter Seviyeleri")
        ),
        CourseSection(
            id = "fl_sec_6",
            courseId = "flutter",
            title = "Bölüm 6: Yayınlama ve Profesyonel İpuçları",
            level = CourseLevel.EXPERT,
            order = 6,
            description = "Google Play ve App Store'a uygulama çıkarma, performans optimizasyonu ve temiz kod.",
            learningObjectives = listOf("Uygulama ikonu ve splash ekranı ayarlamak", "Yayınlama adımlarını öğrenmek"),
            prerequisites = listOf("Tüm Seviyeler")
        )
    )

    fun getLessons(): List<Lesson> = listOf(
        // ==========================================
        // DERS 1: WIDGET'LAR VE SCAFFOLD
        // ==========================================
        Lesson(
            id = "fl_1",
            courseId = "flutter",
            sectionId = "fl_sec_1",
            title = "Flutter'a Giriş: Her Şey Bir Widget!",
            shortDesc = "Lego parçaları gibi birleşen arayüzler: MaterialApp, Scaffold, AppBar ve Text.",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false,
            learningObjectives = listOf(
                "Flutter'ın 'Her şey bir Widget'tır' felsefesini anlamak",
                "Scaffold ile beyaz sayfa ve üst çubuk (AppBar) iskeletini kurmak",
                "Text ve Center widget'ları ile ilk ekranı çizmek"
            ),
            prerequisites = listOf("Ön koşul gerekmez."),
            subtopics = listOf("Flutter Nedir?", "Lego Parçaları (Widget)", "Scaffold İskeleti", "Text ve Center"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Flutter Nedir ve Neden Çok Popüler?",
                    body = "Google tarafından geliştirilen Flutter; tek bir kod yazarak aynı anda hem **iPhone (iOS)** hem **Android** hem de web için ultra hızlı uygulamalar üretmenizi sağlar!\n\nFlutter'da ekranda gördüğünüz bir buton, bir yazı, hatta iki buton arasındaki boşluk bile bir **Widget**'tır."
                ),
                LessonContentBlock(
                    subtitle = "2. Scaffold: Sayfanın İskeleti",
                    body = "Bir evin temeli ve çatısı gibi, her mobil sayfanın çatısını `Scaffold` oluşturur. Bize hazır bir `appBar` (üst başlık) ve `body` (sayfa gövdesi) alanı sunar.",
                    codeSnippet = "import 'package:flutter/material.dart';\n\nvoid main() {\n  runApp(\n    MaterialApp(\n      home: Scaffold(\n        appBar: AppBar(title: Text('İlk Flutter Uygulamam')),\n        body: Center(\n          child: Text('Merhaba Kod Akademi! 🚀'),\n        ),\n      ),\n    ),\n  );\n}"
                )
            ),
            codeExample = "Scaffold(\n  appBar: AppBar(title: Text('Ana Sayfa')),\n  body: Center(child: Text('Hoş Geldiniz')),\n)",
            codeExplanation = "Scaffold ile standart mobil sayfa şablonu oluşturuldu.",
            realWorldExample = "Getir, BMW, Alibaba ve Google Pay gibi yüzlerce dev uygulama Flutter ile yazılmıştır.",
            practicalTask = "AppBar başlığı 'Profilim' olan ve ortasında adınız yazan bir Scaffold tasarlayın.",
            starterPlaygroundCode = "Scaffold(\n  appBar: AppBar(title: Text('Profil')),\n  body: Center(child: Text('Zeynep')),\n)",
            miniQuestion = MiniQuestion(
                id = "fl_q_1",
                question = "Flutter'da standart bir mobil ekranın başlık (AppBar) ve gövde (Body) iskeletini sağlayan temel widget hangisidir?",
                options = listOf("Scaffold", "Container", "MaterialApp", "Column"),
                correctIndex = 0,
                explanation = "Standart sayfa iskeleti 'Scaffold' widget'ı ile kurulur."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_fl_1",
                lessonId = "fl_1",
                title = "İlk Widget",
                instructions = "Verilen metni Text widget'ı olarak döndüren metinKutusu(yazi) fonksiyonunu yazın.",
                exampleInput = "metinKutusu('Selam')",
                exampleOutput = "Text('Selam')",
                starterCode = "Widget metinKutusu(String yazi) {\n  // Kodunu yaz:\n  return Container();\n}",
                solutionCode = "Widget metinKutusu(String yazi) {\n  return Text(yazi);\n}",
                hints = listOf("return Text(yazi); yazın."),
                testCases = listOf(
                    TestCase("metinKutusu('Flutter')", "Text('Flutter')", "Text widget testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "fl_quiz_1_1",
                    lessonId = "fl_1",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Flutter'da kullanıcı arayüzünü oluşturan tüm görsel yapı taşlarına ne ad verilir?",
                    options = listOf("Widget", "Component", "View", "Tag"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Flutter'da her şey bir Widget'tır.",
                    explanationWrong = "Flutter'da tüm parçalar Widget'tır.",
                    reviewTopic = "Flutter Temelleri"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Flutter ile iOS için ayrı kod yazmam gerekir mi?",
                    answer = "Hayır! Tek bir Dart kodu yazarsınız, Flutter bunu hem iOS hem Android için otomatik derler."
                )
            ),
            completionCriteria = listOf(
                "Widget kavramını anlamak",
                "Scaffold ve Text kullanabilmek"
            )
        ),

        // ==========================================
        // DERS 2: SAYFA DÜZENİ (Column ve Row)
        // ==========================================
        Lesson(
            id = "fl_2",
            courseId = "flutter",
            sectionId = "fl_sec_1",
            title = "Sayfa Düzeni: Alt Alta (Column) ve Yan Yana (Row)",
            shortDesc = "Elemanları düzenli bir şekilde hizalama, Expanded ile ekranı paylaştırma ve Padding.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false,
            learningObjectives = listOf(
                "Column ile widget'ları alt alta dizmek",
                "Row ile widget'ları yan yana dizmek",
                "Padding ve SizedBox ile ferah boşluklar bırakmak"
            ),
            prerequisites = listOf("Scaffold ve Temel Widget'lar"),
            subtopics = listOf("Column (Sütun)", "Row (Satır)", "SizedBox ile Boşluk", "Padding"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Alt Alta ve Yan Yana Dizmek",
                    body = "• **Column (Sütun):** İçine verilen elemanları yukarıdan aşağıya alt alta dizer.\n• **Row (Satır):** İçine verilen elemanları soldan sağa yan yana dizer.\n• **SizedBox(height: 16):** Araya nefes aldıracak görünmez bir boşluk kutusu koyar.",
                    codeSnippet = "Column(\n  mainAxisAlignment: MainAxisAlignment.center,\n  children: [\n    Text('Başlık', style: TextStyle(fontSize: 24)),\n    SizedBox(height: 12), // 12 piksel alt boşluk\n    Text('Alt açıklama yazısı'),\n  ],\n)"
                )
            ),
            codeExample = "Row(\n  mainAxisAlignment: MainAxisAlignment.spaceAround,\n  children: [\n    Icon(Icons.home),\n    Icon(Icons.search),\n    Icon(Icons.person),\n  ],\n)",
            codeExplanation = "Row ile 3 ikon ekran boyunca eşit aralıklarla yan yana dizildi.",
            realWorldExample = "Sosyal medya uygulamalarında profil fotoğrafı, kullanıcı adı ve takip et butonu yan yana bir Row içinde yer alır.",
            practicalTask = "Bir Column içinde 3 farklı Text widget'ı alt alta yerleştirin.",
            starterPlaygroundCode = "Column(\n  children: [\n    Text('Birinci'),\n    Text('İkinci'),\n    Text('Üçüncü'),\n  ],\n)",
            miniQuestion = MiniQuestion(
                id = "fl_q_2",
                question = "Flutter'da birden çok widget'ı yukarıdan aşağıya alt alta dizmek için hangisi kullanılır?",
                options = listOf("Column", "Row", "Stack", "Wrap"),
                correctIndex = 0,
                explanation = "Alt alta dizilim için Column kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_fl_2",
                lessonId = "fl_2",
                title = "İki Metinli Sütun",
                instructions = "ust ve alt metinlerini alan ve bunları bir Column içinde döndüren ikiSatir(ust, alt) fonksiyonunu yazın.",
                exampleInput = "ikiSatir('A', 'B')",
                exampleOutput = "Column(children: [Text('A'), Text('B')])",
                starterCode = "Widget ikiSatir(String ust, String alt) {\n  // Kodunu yaz:\n  return Container();\n}",
                solutionCode = "Widget ikiSatir(String ust, String alt) {\n  return Column(children: [Text(ust), Text(alt)]);\n}",
                hints = listOf("Column(children: [Text(ust), Text(alt)]) döndürün."),
                testCases = listOf(
                    TestCase("ikiSatir('A', 'B')", "Column(children: [Text('A'), Text('B')])", "Sütun testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "fl_quiz_2_1",
                    lessonId = "fl_2",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "İki widget arasına belirli bir piksel boşluk koymanın en pratik yolu nedir?",
                    options = listOf("SizedBox(height: 16) veya SizedBox(width: 16)", "Spacer_hard()", "EmptyBox()", "Break()"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! SizedBox en pratik boşluk verme widget'ıdır.",
                    explanationWrong = "SizedBox kullanılır.",
                    reviewTopic = "Flutter Düzen"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Column içindeki elemanlar ekrana sığmazsa ne olur?",
                    answer = "Sarı-siyah çizgili 'Overflow' (Taşma) uyarısı verir. Bunu önlemek için sayfayı SingleChildScrollView içine alırız."
                )
            ),
            completionCriteria = listOf(
                "Column ve Row farkını bilmek",
                "SizedBox ile boşluk verebilmek"
            )
        ),

        // ==========================================
        // DERS 3: BUTONLAR VE İKONLAR
        // ==========================================
        Lesson(
            id = "fl_3",
            courseId = "flutter",
            sectionId = "fl_sec_1",
            title = "Butonlar ve Tıklamalar: ElevatedButton ve Icon",
            shortDesc = "Kullanıcıyla etkileşime geçen renkli butonlar ve binlerce hazır Material ikonu.",
            level = CourseLevel.BEGINNER,
            order = 3,
            isPremium = false,
            learningObjectives = listOf(
                "ElevatedButton ile şık tıklanabilir butonlar yapmak",
                "onPressed olayında fonksiyon çalıştırmak",
                "Icon(Icons.star) ile hazır ikonları kullanmak"
            ),
            prerequisites = listOf("Düzen ve Widget'lar"),
            subtopics = listOf("ElevatedButton", "onPressed Olayı", "Hazır İkonlar (Icons)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Butonlar: Tıklanınca Ne Olsun?",
                    body = "Flutter'da en çok kullanılan buton `ElevatedButton`'dur. `onPressed:` parametresine butona basıldığında ne yapılacağını yazarız.",
                    codeSnippet = "ElevatedButton(\n  onPressed: () {\n    print('Butona tıklandı! 🎯');\n  },\n  child: Text('Giriş Yap'),\n)"
                )
            ),
            codeExample = "ElevatedButton.icon(\n  onPressed: () {},\n  icon: Icon(Icons.send),\n  label: Text('Gönder'),\n)",
            codeExplanation = "İkonlu buton tek satırda oluşturuldu.",
            realWorldExample = "Giriş yap, sepete ekle, beğen ve paylaş butonlarının tamamı bu yapıyla oluşturulur.",
            practicalTask = "Tıklandığında konsola 'Tıklandı' yazan bir ElevatedButton yapın.",
            starterPlaygroundCode = "ElevatedButton(\n  onPressed: () => print('Tıklandı'),\n  child: Text('Kaydet'),\n)",
            miniQuestion = MiniQuestion(
                id = "fl_q_3",
                question = "Flutter butonlarında tıklama anında çalışacak kod hangi özelliğe (property) yazılır?",
                options = listOf("onPressed", "onClick", "onTap", "onTouch"),
                correctIndex = 0,
                explanation = "Flutter butonlarında tıklama olayı 'onPressed' parametresiyle atanır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_fl_3",
                lessonId = "fl_3",
                title = "İkonlu Buton",
                instructions = "etiket metnini buton yazısı yapan basit bir ElevatedButton döndüren butonYap(etiket) fonksiyonunu yazın.",
                exampleInput = "butonYap('Kaydet')",
                exampleOutput = "ElevatedButton",
                starterCode = "Widget butonYap(String etiket) {\n  // Kodunu yaz:\n  return Container();\n}",
                solutionCode = "Widget butonYap(String etiket) {\n  return ElevatedButton(onPressed: () {}, child: Text(etiket));\n}",
                hints = listOf("ElevatedButton(onPressed: () {}, child: Text(etiket)) döndürün."),
                testCases = listOf(
                    TestCase("butonYap('Tamam')", "ElevatedButton", "Buton testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "fl_quiz_3_1",
                    lessonId = "fl_3",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Flutter'da hazır gelen binlerce ücretsiz ikona hangi sınıf üzerinden erişilir?",
                    options = listOf("Icons (örn: Icons.home)", "Images", "Drawables", "SVGIcons"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Material ikonlarına Icons.home, Icons.favorite gibi erişilir.",
                    explanationWrong = "Icons sınıfı kullanılır.",
                    reviewTopic = "Flutter İkonlar"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "onPressed: null yaparsam ne olur?",
                    answer = "Buton devre dışı (disabled) kalır ve grileşir, tıklanamaz."
                )
            ),
            completionCriteria = listOf(
                "ElevatedButton oluşturabilmek",
                "Icons sınıfını kullanabilmek"
            )
        ),

        // ==========================================
        // DERS 4: STATELESS VS STATEFUL
        // ==========================================
        Lesson(
            id = "fl_4",
            courseId = "flutter",
            sectionId = "fl_sec_2",
            title = "Değişen Ekranlar: Stateless vs StatefulWidget",
            shortDesc = "Sabit duran sayfalar ile sayacı artınca güncellenen dinamik sayfaların sırrı: setState().",
            level = CourseLevel.BEGINNER,
            order = 4,
            isPremium = true,
            learningObjectives = listOf(
                "StatelessWidget (Sabit/Değişmeyen) mantığını anlamak",
                "StatefulWidget (Dinamik/Değişen) yapısını öğrenmek",
                "setState(() { ... }) ile ekranı yeniden çizdirmek"
            ),
            prerequisites = listOf("Butonlar ve Düzen"),
            subtopics = listOf("Stateless vs Stateful", "setState() Nedir?", "Sayaç Örneği"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Ekran Ne Zaman Değişir?",
                    body = "• **StatelessWidget:** Hakkımızda veya Logo ekranı gibi içeriği asla değişmeyen sabit sayfalardır.\n• **StatefulWidget:** Butona basınca sayaç artan, beğeni sayısı değişen veya yazı yazılan canlı sayfalardır.\n\nBir değişkeni değiştirdiğimizde ekrana anında yansıması için `setState(() { ... })` fonksiyonunu çağırırız!",
                    codeSnippet = "int sayac = 0;\n\nvoid artir() {\n  setState(() {\n    sayac++; // Flutter ekranı hemen günceller!\n  });\n}"
                )
            ),
            codeExample = "class SayacSayfasi extends StatefulWidget {\n  @override\n  _SayacState createState() => _SayacState();\n}\n\nclass _SayacState extends State<SayacSayfasi> {\n  int sayi = 0;\n  @override\n  Widget build(BuildContext context) {\n    return ElevatedButton(\n      onPressed: () => setState(() => sayi++),\n      child: Text('Tık: \$sayi'),\n    );\n  }\n}",
            codeExplanation = "setState çağrıldığında build metodu tekrar çalışarak ekrandaki sayıyı günceller.",
            realWorldExample = "Sepete ürün eklediğinizde sağ üstteki sepet ikonundaki sayının '1' olması StatefulWidget ile olur.",
            practicalTask = "setState mantığıyla çalışan bir sayaç butonunu inceleyin.",
            starterPlaygroundCode = "// setState(() => sayac++);",
            miniQuestion = MiniQuestion(
                id = "fl_q_4",
                question = "StatefulWidget'ta ekrandaki verinin değiştiğini Flutter'a bildirip sayfayı yeniden çizdirmek için hangi fonksiyon çağrılır?",
                options = listOf("setState()", "update()", "refresh()", "rebuild()"),
                correctIndex = 0,
                explanation = "Ekranı yeniden çizdirmek için 'setState(() { ... })' çağrılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_fl_4",
                lessonId = "fl_4",
                title = "Sayaç Metni",
                instructions = "sayi parametresini alıp 'Sayaç: \$sayi' yazan Text widget'ı döndüren sayacMetni(sayi) fonksiyonunu yazın.",
                exampleInput = "sayacMetni(5)",
                exampleOutput = "Text('Sayaç: 5')",
                starterCode = "Widget sayacMetni(int sayi) {\n  // Kodunu yaz:\n  return Container();\n}",
                solutionCode = "Widget sayacMetni(int sayi) {\n  return Text('Sayaç: \$sayi');\n}",
                hints = listOf("Text('Sayaç: \$sayi') döndürün."),
                testCases = listOf(
                    TestCase("sayacMetni(5)", "Text('Sayaç: 5')", "Sayaç metni")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "fl_quiz_4_1",
                    lessonId = "fl_4",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "İçeriği kullanıcı etkileşimiyle asla değişmeyecek salt metin bir sayfa için hangisi tercih edilir?",
                    options = listOf("StatelessWidget", "StatefulWidget", "InheritedWidget", "DynamicWidget"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Sabit sayfalar için en performanslısı StatelessWidget'tır.",
                    explanationWrong = "StatelessWidget tercih edilir.",
                    reviewTopic = "Flutter Widget Çeşitleri"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "setState() olmadan değişkeni artırırsam ne olur?",
                    answer = "Değişken arka planda artar ama ekrandaki yazı güncellenmez çünkü Flutter ekranı yeniden çizmesi gerektiğini bilmez."
                )
            ),
            completionCriteria = listOf(
                "Stateless ve Stateful farkını bilmek",
                "setState() fonksiyonunu kullanabilmek"
            )
        ),

        // ==========================================
        // DERS 5: LİSTELER (ListView.builder)
        // ==========================================
        Lesson(
            id = "fl_5",
            courseId = "flutter",
            sectionId = "fl_sec_2",
            title = "Listeler: ListView.builder ile Akıcı Kaydırma",
            shortDesc = "10.000 elemanlı devasa listeleri telefonu hiç kasmadan kaydıran akıllı liste mimarisi.",
            level = CourseLevel.BEGINNER,
            order = 5,
            isPremium = true,
            learningObjectives = listOf(
                "ListView ve ListView.builder arasındaki farkı anlamak",
                "ListTile ile hazır şık liste satırları yapmak",
                "Sadece ekranda görünen elemanları çizerek bellek tasarrufu yapmak"
            ),
            prerequisites = listOf("StatefulWidget ve Listeler"),
            subtopics = listOf("ListView Nedir?", "ListView.builder", "ListTile Kullanımı"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. ListView.builder: Akıllı Liste",
                    body = "Eğer 1000 tane ürünü tek tek alt alta koyarsanız telefonun hafızası dolar ve donar. `ListView.builder` ise sadece kullanıcının ekranda o an gördüğü 5-10 tanesini çizer, yukarı kaydırdıkça yenilerini üretir!",
                    codeSnippet = "final sehirler = ['İstanbul', 'Ankara', 'İzmir', 'Bursa'];\n\nListView.builder(\n  itemCount: sehirler.length,\n  itemBuilder: (context, index) {\n    return ListTile(\n      leading: Icon(Icons.location_city),\n      title: Text(sehirler[index]),\n      trailing: Icon(Icons.arrow_forward_ios),\n    );\n  },\n)"
                )
            ),
            codeExample = "ListView.builder(\n  itemCount: 5,\n  itemBuilder: (ctx, i) => ListTile(title: Text('Öğe #\$i')),\n)",
            codeExplanation = "ListView.builder 5 elemanlı performanslı bir liste üretti.",
            realWorldExample = "WhatsApp sohbet listesi, Instagram ana sayfası ve Trendyol ürün listeleri ListView.builder ile oluşturulur.",
            practicalTask = "ListTile içinde başlık ve sol ikon bulunan bir liste elemanı tasarlayın.",
            starterPlaygroundCode = "ListTile(\n  leading: Icon(Icons.person),\n  title: Text('Ahmet'),\n)",
            miniQuestion = MiniQuestion(
                id = "fl_q_5",
                question = "Flutter'da uzun listeleri sadece ekranda görünen kısımları çizerek bellek dostu oluşturan widget hangisidir?",
                options = listOf("ListView.builder", "Column", "SingleChildScrollView", "Wrap"),
                correctIndex = 0,
                explanation = "Performanslı listeler için 'ListView.builder' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_fl_5",
                lessonId = "fl_5",
                title = "Şık Liste Elemanı",
                instructions = "baslik metnini alıp ListTile(title: Text(baslik)) döndüren listeElemani(baslik) fonksiyonunu yazın.",
                exampleInput = "listeElemani('Mesajlar')",
                exampleOutput = "ListTile",
                starterCode = "Widget listeElemani(String baslik) {\n  // Kodunu yaz:\n  return Container();\n}",
                solutionCode = "Widget listeElemani(String baslik) {\n  return ListTile(title: Text(baslik));\n}",
                hints = listOf("ListTile(title: Text(baslik)) döndürün."),
                testCases = listOf(
                    TestCase("listeElemani('A')", "ListTile", "Liste elemanı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "fl_quiz_5_1",
                    lessonId = "fl_5",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "ListTile widget'ında sol taraftaki ikonu veya profil fotoğrafını koyduğumuz alanın adı nedir?",
                    options = listOf("leading", "trailing", "title", "subtitle"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Sol baş taraf 'leading', sağ son taraf 'trailing'dir.",
                    explanationWrong = "Sol alan leading olarak adlandırılır.",
                    reviewTopic = "Flutter ListTile"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "ListTile'a tıklanma özelliği verilebilir mi?",
                    answer = "Evet! onTap: () { ... } parametresiyle her liste satırına tıklama olayı eklenebilir."
                )
            ),
            completionCriteria = listOf(
                "ListView.builder mantığını kavramak",
                "ListTile bileşenini kullanabilmek"
            )
        ),

        // ==========================================
        // DERS 6: KULLANICI GİRDİLERİ (TextField)
        // ==========================================
        Lesson(
            id = "fl_6",
            courseId = "flutter",
            sectionId = "fl_sec_2",
            title = "Kullanıcıdan Bilgi Alma: TextField ve Form",
            shortDesc = "Kullanıcının yazı yazmasını sağlayan TextField ve TextEditingController kontrolcüsü.",
            level = CourseLevel.BEGINNER,
            order = 6,
            isPremium = true,
            learningObjectives = listOf(
                "TextField ile giriş kutusu oluşturmak",
                "TextEditingController ile yazılan metni okumak ve temizlemek",
                "InputDecoration ile kutuya ipucu (hint) ve çerçeve eklemek"
            ),
            prerequisites = listOf("StatefulWidget ve Butonlar"),
            subtopics = listOf("TextField", "TextEditingController", "InputDecoration"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. TextField ve Kontrolcü",
                    body = "Kullanıcının yazdığı metni anında yakalamak için bir `TextEditingController` tanımlarız.",
                    codeSnippet = "final controller = TextEditingController();\n\nTextField(\n  controller: controller,\n  decoration: InputDecoration(\n    labelText: 'Adınız',\n    hintText: 'Örn: Ahmet',\n    border: OutlineInputBorder(),\n  ),\n)\n\n// Butona basılınca okumak:\n// print(controller.text);"
                )
            ),
            codeExample = "TextField(\n  obscureText: true, // Şifreyi gizler (***)\n  decoration: InputDecoration(labelText: 'Şifre'),\n)",
            codeExplanation = "obscureText ile şifre kutusu oluşturuldu.",
            realWorldExample = "Giriş yapma, kayıt olma ve arama çubuğu ekranlarında TextField kullanılır.",
            practicalTask = "E-posta girişi için bir TextField kutusu tasarlayın.",
            starterPlaygroundCode = "TextField(\n  decoration: InputDecoration(labelText: 'E-Posta'),\n)",
            miniQuestion = MiniQuestion(
                id = "fl_q_6",
                question = "TextField içine yazılan şifrenin yıldızlı (***) gizli gözükmesi için hangi özellik true yapılır?",
                options = listOf("obscureText", "hideText", "passwordMode", "secret"),
                correctIndex = 0,
                explanation = "Şifre gizleme 'obscureText: true' ile yapılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_fl_6",
                lessonId = "fl_6",
                title = "İpuculu Giriş Kutusu",
                instructions = "ipucu parametresini InputDecoration(hintText: ipucu) olarak alan TextField döndüren girisKutusu(ipucu) fonksiyonunu yazın.",
                exampleInput = "girisKutusu('Adınızı girin')",
                exampleOutput = "TextField",
                starterCode = "Widget girisKutusu(String ipucu) {\n  // Kodunu yaz:\n  return Container();\n}",
                solutionCode = "Widget girisKutusu(String ipucu) {\n  return TextField(decoration: InputDecoration(hintText: ipucu));\n}",
                hints = listOf("TextField(decoration: InputDecoration(hintText: ipucu)) döndürün."),
                testCases = listOf(
                    TestCase("girisKutusu('Ara')", "TextField", "TextField testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "fl_quiz_6_1",
                    lessonId = "fl_6",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "TextField içine yazılan metni Dart kodundan okumak için hangi nesne kullanılır?",
                    options = listOf("TextEditingController", "StringReader", "FormGrabber", "InputKeeper"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! controller.text ile yazılan yazı okunur.",
                    explanationWrong = "TextEditingController kullanılır.",
                    reviewTopic = "Flutter TextField"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Controller işi bittiğinde ne yapılmalıdır?",
                    answer = "Bellek sızıntısını önlemek için StatefulWidget'ın dispose() metodunda controller.dispose() çağrılmalıdır."
                )
            ),
            completionCriteria = listOf(
                "TextField oluşturabilmek",
                "controller.text ile yazıyı okuyabilmek"
            )
        ),

        // ==========================================
        // DERS 7: SAYFALAR ARASI GEÇİŞ (Navigator)
        // ==========================================
        Lesson(
            id = "fl_7",
            courseId = "flutter",
            sectionId = "fl_sec_3",
            title = "Sayfalar Arası Geçiş: Navigator (push ve pop)",
            shortDesc = "İskambil kartı gibi yeni sayfayı öne koyma (push) ve geri dönme (pop) sanatı.",
            level = CourseLevel.INTERMEDIATE,
            order = 7,
            isPremium = true,
            learningObjectives = listOf(
                "Navigator.push ile ikinci sayfaya gitmek",
                "Navigator.pop ile önceki sayfaya geri dönmek",
                "Sayfalar arası veri/parametre taşımak"
            ),
            prerequisites = listOf("Widget'lar ve Butonlar"),
            subtopics = listOf("Sayfa Yığını (Stack)", "Navigator.push", "Navigator.pop"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Sayfaları Üst Üste Koymak",
                    body = "Flutter'da sayfalar bir deste kağıt gibidir. Yeni bir sayfaya gitmek destenin üstüne yeni bir kart koymaktır (`push`). Geri dönmek ise üstteki kartı çekip almaktır (`pop`).",
                    codeSnippet = "// Yeni sayfaya git:\nNavigator.push(\n  context,\n  MaterialPageRoute(builder: (context) => IkinciSayfa()),\n);\n\n// Geri dön:\nNavigator.pop(context);"
                )
            ),
            codeExample = "ElevatedButton(\n  onPressed: () => Navigator.pop(context),\n  child: Text('Geri Dön'),\n)",
            codeExplanation = "Navigator.pop ile önceki ekrana dönüldü.",
            realWorldExample = "Ürün listesinden bir ayakkabıya tıkladığınızda ayakkabının detay sayfasına gitmek push ile yapılır.",
            practicalTask = "İkinci sayfaya geçiş yapan buton kodunu inceleyin.",
            starterPlaygroundCode = "// Navigator.push(context, MaterialPageRoute(...));",
            miniQuestion = MiniQuestion(
                id = "fl_q_7",
                question = "Flutter'da açık olan mevcut sayfayı kapatıp bir önceki sayfaya geri dönmek için hangi komut kullanılır?",
                options = listOf("Navigator.pop(context)", "Navigator.push(context)", "Navigator.back()", "Navigator.close()"),
                correctIndex = 0,
                explanation = "Geri dönmek için 'Navigator.pop(context)' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_fl_7",
                lessonId = "fl_7",
                title = "Geri Dönüş Butonu",
                instructions = "Tıklandığında Navigator.pop(context) çağıran ve üstünde 'Geri' yazan bir ElevatedButton döndüren geriButonu(context) fonksiyonunu yazın.",
                exampleInput = "geriButonu(context)",
                exampleOutput = "ElevatedButton",
                starterCode = "Widget geriButonu(BuildContext context) {\n  // Kodunu yaz:\n  return Container();\n}",
                solutionCode = "Widget geriButonu(BuildContext context) {\n  return ElevatedButton(onPressed: () => Navigator.pop(context), child: Text('Geri'));\n}",
                hints = listOf("ElevatedButton(onPressed: () => Navigator.pop(context), child: Text('Geri')) döndürün."),
                testCases = listOf(
                    TestCase("geriButonu(context)", "ElevatedButton", "Geri butonu testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "fl_quiz_7_1",
                    lessonId = "fl_7",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Yeni bir sayfaya geçiş yaparken sayfa animasyonunu ve temasını sağlayan rota nesnesi hangisidir?",
                    options = listOf("MaterialPageRoute", "SimpleRoute", "PageRouteBuilder", "DirectRoute"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Standart sayfa geçişleri MaterialPageRoute ile sarılır.",
                    explanationWrong = "MaterialPageRoute kullanılır.",
                    reviewTopic = "Flutter Navigasyon"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "İkinci sayfaya veri nasıl gönderilir?",
                    answer = "İkinciSayfa(urunAdi: 'Ayakkabı') şeklinde kurucu (constructor) üzerinden doğrudan parametre olarak aktarılır."
                )
            ),
            completionCriteria = listOf(
                "Navigator.push ve pop mantığını anlamak",
                "Sayfalar arası geçiş yapabilmek"
            )
        ),

        // ==========================================
        // DERS 8: RENKLER VE MATERIAL 3 TEMALARI
        // ==========================================
        Lesson(
            id = "fl_8",
            courseId = "flutter",
            sectionId = "fl_sec_3",
            title = "Temalar ve Renkler: Material 3 ile Şık Tasarımlar",
            shortDesc = "Karanlık Mod (Dark Mode), dinamik renkler ve profesyonel Material Design 3 deneyimi.",
            level = CourseLevel.INTERMEDIATE,
            order = 8,
            isPremium = true,
            learningObjectives = listOf(
                "ThemeData ile tüm uygulamanın renklerini tek merkezden yönetmek",
                "Karanlık mod (Dark Theme) desteği eklemek",
                "Material 3 (useMaterial3: true) standartlarını uygulamak"
            ),
            prerequisites = listOf("Navigasyon ve Widget'lar"),
            subtopics = listOf("ThemeData", "ColorScheme", "Karanlık Mod (Dark Mode)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Tek Yerden Tüm Renkleri Değiştirmek",
                    body = "Her butona tek tek renk vermek yerine `MaterialApp` içinde ana tema belirleriz. Böylece tek bir satırla uygulamanın rengini mavi, yeşil veya karanlık mod yapabiliriz.",
                    codeSnippet = "MaterialApp(\n  theme: ThemeData(\n    useMaterial3: true,\n    colorSchemeSeed: Colors.indigo, // Ana renk indigo olsun\n    brightness: Brightness.light,\n  ),\n  darkTheme: ThemeData(\n    brightness: Brightness.dark,\n  ),\n)"
                )
            ),
            codeExample = "Text(\n  'Öne Çıkan Başlık',\n  style: Theme.of(context).textTheme.headlineMedium,\n)",
            codeExplanation = "Yazı stili merkezi temadan çekildi.",
            realWorldExample = "Gece olunca uygulamanın otomatik olarak göz yormayan siyah/karanlık temaya geçmesi ThemeData ile sağlanır.",
            practicalTask = "colorSchemeSeed ile mor renkli bir tema tanımlayın.",
            starterPlaygroundCode = "ThemeData(useMaterial3: true, colorSchemeSeed: Colors.purple)",
            miniQuestion = MiniQuestion(
                id = "fl_q_8",
                question = "Modern Material 3 tasarım dilini etkinleştirmek için ThemeData içine hangi ayar yazılır?",
                options = listOf("useMaterial3: true", "materialVersion: 3", "enableM3: true", "modernUI: true"),
                correctIndex = 0,
                explanation = "'useMaterial3: true' ile Material 3 aktifleşir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_fl_8",
                lessonId = "fl_8",
                title = "Koyu Tema Oluşturucu",
                instructions = "Brightness.dark kullanan bir ThemeData döndüren koyuTema() fonksiyonunu yazın.",
                exampleInput = "koyuTema()",
                exampleOutput = "ThemeData",
                starterCode = "ThemeData koyuTema() {\n  // Kodunu yaz:\n  return ThemeData();\n}",
                solutionCode = "ThemeData koyuTema() {\n  return ThemeData(brightness: Brightness.dark, useMaterial3: true);\n}",
                hints = listOf("ThemeData(brightness: Brightness.dark, useMaterial3: true) döndürün."),
                testCases = listOf(
                    TestCase("koyuTema()", "ThemeData", "Tema testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "fl_quiz_8_1",
                    lessonId = "fl_8",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Flutter'da o anki aktif temanın renklerine kod içinden nasıl ulaşılır?",
                    options = listOf("Theme.of(context).colorScheme", "AppColors.current", "GlobalTheme.get()", "Colors.active"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Theme.of(context) ile tema özelliklerine erişilir.",
                    explanationWrong = "Theme.of(context) kullanılır.",
                    reviewTopic = "Flutter Temalar"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "colorSchemeSeed ne işe yarar?",
                    answer = "Verdiğiniz tek bir renkten yola çıkarak uygulamanın tüm uyumlu buton, arka plan ve metin renk paletini otomatik üretir."
                )
            ),
            completionCriteria = listOf(
                "ThemeData oluşturabilmek",
                "Material 3 mantığını kavramak"
            )
        ),

        // ==========================================
        // DERS 9: DURUM YÖNETİMİ (Provider)
        // ==========================================
        Lesson(
            id = "fl_9",
            courseId = "flutter",
            sectionId = "fl_sec_4",
            title = "Durum Yönetimi (State Management): Global Veri Paylaşımı",
            shortDesc = "Kullanıcı girişi veya alışveriş sepeti gibi verileri tüm sayfalarda zahmetsizce paylaşın.",
            level = CourseLevel.INTERMEDIATE,
            order = 9,
            isPremium = true,
            learningObjectives = listOf(
                "State Management'ın neden gerekli olduğunu kavramak",
                "ChangeNotifier ve notifyListeners() mantığını öğrenmek",
                "Sayfalar arası veri senkronizasyonu sağlamak"
            ),
            prerequisites = listOf("Temalar ve Navigasyon"),
            subtopics = listOf("State Management Nedir?", "ChangeNotifier", "notifyListeners()"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Neden Durum Yönetimi?",
                    body = "Sepete bir ürün eklediğinizde hem Ürün Sayfası, hem Sepet Sayfası, hem de Profil Sayfası anında haberdar olmalıdır. Verileri sayfalara tek tek elle taşımak yerine ortada tek bir 'Model Deposu' (ChangeNotifier) tutarız.",
                    codeSnippet = "class SepetModel extends ChangeNotifier {\n  final List<String> urunler = [];\n  \n  void ekle(String urun) {\n    urunler.add(urun);\n    notifyListeners(); // 'Beni dinleyen tüm ekranları güncelle!' der\n  }\n}"
                )
            ),
            codeExample = "class SayacModel extends ChangeNotifier {\n  int sayi = 0;\n  void artir() {\n    sayi++;\n    notifyListeners();\n  }\n}",
            codeExplanation = "notifyListeners çağrısı tüm dinleyici widget'ların yeniden çizilmesini tetikler.",
            realWorldExample = "Kullanıcı oturum açtığında tüm sayfalarda profil resminin güncellenmesi Provider/Riverpod ile olur.",
            practicalTask = "notifyListeners() içeren basit bir model tanımlayın.",
            starterPlaygroundCode = "class Model extends ChangeNotifier {\n  // notifyListeners();\n}",
            miniQuestion = MiniQuestion(
                id = "fl_q_9",
                question = "ChangeNotifier sınıfında verinin değiştiğini dinleyen tüm widget'lara haber vermek için hangi metot çağrılır?",
                options = listOf("notifyListeners()", "updateAll()", "emitChange()", "refreshWidgets()"),
                correctIndex = 0,
                explanation = "Değişikliği yaymak için 'notifyListeners()' çağrılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_fl_9",
                lessonId = "fl_9",
                title = "Sayaç Modeli",
                instructions = "deger değişkeni olan ve artir() metodu çağrıldığında deger'i 1 artırıp notifyListeners() çağıran SayacModel sınıfını yazın.",
                exampleInput = "SayacModel().artir()",
                exampleOutput = "deger = 1",
                starterCode = "class SayacModel extends ChangeNotifier {\n  int deger = 0;\n  void artir() {\n    // Kodunu yaz:\n  }\n}",
                solutionCode = "class SayacModel extends ChangeNotifier {\n  int deger = 0;\n  void artir() {\n    deger++;\n    notifyListeners();\n  }\n}",
                hints = listOf("deger++; notifyListeners(); yazın."),
                testCases = listOf(
                    TestCase("SayacModel()", "SayacModel", "Model testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "fl_quiz_9_1",
                    lessonId = "fl_9",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Flutter ekosisteminde en popüler durum yönetimi (State Management) yaklaşımları hangileridir?",
                    options = listOf("Provider, Riverpod ve BLoC", "SQL, MySQL", "HTTP, TCP", "CSS, HTML"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Provider, Riverpod ve BLoC en yaygın çözümlerdir.",
                    explanationWrong = "Provider, Riverpod ve BLoC kullanılır.",
                    reviewTopic = "Flutter Durum Yönetimi"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "setState varken neden Provider kullanalım?",
                    answer = "setState sadece tek bir sayfanın içini günceller. Farklı sayfalar arasında ortak veri paylaşmak için Provider gerekir."
                )
            ),
            completionCriteria = listOf(
                "ChangeNotifier mantığını kavramak",
                "notifyListeners() kullanımını bilmek"
            )
        ),

        // ==========================================
        // DERS 10: ANİMASYONLAR (AnimatedContainer)
        // ==========================================
        Lesson(
            id = "fl_10",
            courseId = "flutter",
            sectionId = "fl_sec_5",
            title = "Canlı Animasyonlar: AnimatedContainer ve Hero",
            shortDesc = "Uygulamanıza profesyonel bir hava katan yumuşak geçişler ve büyüyen fotoğraf efektleri.",
            level = CourseLevel.ADVANCED,
            order = 10,
            isPremium = true,
            learningObjectives = listOf(
                "AnimatedContainer ile boyut ve renk değişimlerini sihirli şekilde yumuşatmak",
                "Hero animasyonu ile ürün fotoğrafını detay sayfasına uçurmak",
                "Duration (Süre) ve Curves (Eğriler) mantığını öğrenmek"
            ),
            prerequisites = listOf("StatefulWidget ve Temalar"),
            subtopics = listOf("AnimatedContainer", "Hero Widget", "Duration ve Curves"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. AnimatedContainer: Zahmetsiz Animasyon",
                    body = "Normal Container yerine `AnimatedContainer` yazıp bir süre (`duration`) verirseniz; genişliği, yüksekliği veya rengi değiştiğinde Flutter aradaki geçişi yağ gibi kayan bir animasyonla kendisi tamamlar!",
                    codeSnippet = "AnimatedContainer(\n  duration: Duration(milliseconds: 500), // Yarım saniye sürsün\n  curve: Curves.easeInOut,\n  width: buyukMu ? 200 : 100,\n  height: buyukMu ? 200 : 100,\n  color: buyukMu ? Colors.blue : Colors.red,\n)"
                )
            ),
            codeExample = "Hero(\n  tag: 'profil_foto',\n  child: CircleAvatar(backgroundImage: NetworkImage('...'))\n)",
            codeExplanation = "Hero animasyonu iki sayfa arasında görselin süzülerek büyümesini sağlar.",
            realWorldExample = "Instagram'da bir gönderiye bastığınızda fotoğrafın yumuşakça büyüyüp tam ekrana oturması Hero animasyonudur.",
            practicalTask = "AnimatedContainer ile tıklanınca büyüyen bir kutu kodu inceleyin.",
            starterPlaygroundCode = "AnimatedContainer(duration: Duration(seconds: 1), width: 100, height: 100)",
            miniQuestion = MiniQuestion(
                id = "fl_q_10",
                question = "İki sayfa arasında aynı görselin uçarak ve büyüyerek geçmesini sağlayan Flutter widget'ının adı nedir?",
                options = listOf("Hero", "FlyImage", "Zoomer", "Transitioner"),
                correctIndex = 0,
                explanation = "Sayfalar arası uçan görsel efekti için 'Hero' widget'ı kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_fl_10",
                lessonId = "fl_10",
                title = "Hero Görseli",
                instructions = "etiket ve cocuk widget'ı alıp Hero(tag: etiket, child: cocuk) döndüren heroKutusu(etiket, cocuk) fonksiyonunu yazın.",
                exampleInput = "heroKutusu('foto', Text('A'))",
                exampleOutput = "Hero",
                starterCode = "Widget heroKutusu(String etiket, Widget cocuk) {\n  // Kodunu yaz:\n  return Container();\n}",
                solutionCode = "Widget heroKutusu(String etiket, Widget cocuk) {\n  return Hero(tag: etiket, child: cocuk);\n}",
                hints = listOf("Hero(tag: etiket, child: cocuk) döndürün."),
                testCases = listOf(
                    TestCase("heroKutusu('1', Text('A'))", "Hero", "Hero testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "fl_quiz_10_1",
                    lessonId = "fl_10",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "AnimatedContainer'da animasyonun ne kadar süreceğini belirten zorunlu parametre hangisidir?",
                    options = listOf("duration (örn: Duration(milliseconds: 300))", "time", "speed", "interval"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Animasyon süresi 'duration' parametresiyle verilir.",
                    explanationWrong = "duration parametresi kullanılır.",
                    reviewTopic = "Flutter Animasyonlar"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Curves (Eğriler) ne işe yarar?",
                    answer = "Animasyonun hızlanma/yavaşlama hissini belirler (örn: Curves.bounceOut yaylanma efekti verir)."
                )
            ),
            completionCriteria = listOf(
                "AnimatedContainer kullanabilmek",
                "Hero animasyonunu kavramak"
            )
        ),

        // ==========================================
        // DERS 11: İNTERNETTEN VERİ ÇEKME (HTTP & JSON)
        // ==========================================
        Lesson(
            id = "fl_11",
            courseId = "flutter",
            sectionId = "fl_sec_5",
            title = "İnternet ve API: http ile Veri Çekme ve Gösterme",
            shortDesc = "Sunuculardan canlı veri çekme, JSON çözümleme ve FutureBuilder ile ekranda gösterme.",
            level = CourseLevel.ADVANCED,
            order = 11,
            isPremium = true,
            learningObjectives = listOf(
                "http paketi ile sunucuya istek atmak",
                "jsonDecode ile gelen metni listeye dönüştürmek",
                "FutureBuilder ile veri gelirken dönen yükleme çarkı (CircularProgressIndicator) göstermek"
            ),
            prerequisites = listOf("Asenkron Dart ve ListView"),
            subtopics = listOf("http Paketi", "jsonDecode", "FutureBuilder"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Sunucudan Canlı Veri Çekmek",
                    body = "Mobil uygulamalar verilerini internet sunucularından alır. `http.get()` ile istek atar ve `jsonDecode()` ile parçalarız.",
                    codeSnippet = "import 'dart:convert';\nimport 'package:http/http.dart' as http;\n\nFuture<String> veriCek() async {\n  final res = await http.get(Uri.parse('https://api.ornek.com/haberler'));\n  if (res.statusCode == 200) {\n    final veri = jsonDecode(res.body);\n    return veri['baslik'];\n  }\n  throw Exception('Hata oluştu');\n}"
                )
            ),
            codeExample = "CircularProgressIndicator() // Dönen yükleme animasyonu",
            codeExplanation = "Veri beklenirken kullanıcıya yükleniyor çarkı gösterilir.",
            realWorldExample = "Haber uygulamalarında son dakika haberlerinin sunucudan çekilip ekrana listelenmesi.",
            practicalTask = "FutureBuilder yapısının bekleme durumunu inceleyin.",
            starterPlaygroundCode = "// FutureBuilder(future: veriCek(), builder: (context, snap) { ... })",
            miniQuestion = MiniQuestion(
                id = "fl_q_11",
                question = "Flutter'da dönen mavi yükleme göstergesi (çark) hangi widget ile çizilir?",
                options = listOf("CircularProgressIndicator", "LoadingSpinner", "ProgressBar", "ActivityIcon"),
                correctIndex = 0,
                explanation = "Dönen yükleme çarkı 'CircularProgressIndicator' widget'ıdır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_fl_11",
                lessonId = "fl_11",
                title = "Yükleniyor Kutusu",
                instructions = "Ortasında CircularProgressIndicator bulunan bir Center widget'ı döndüren yuklemeEkrani() fonksiyonunu yazın.",
                exampleInput = "yuklemeEkrani()",
                exampleOutput = "Center",
                starterCode = "Widget yuklemeEkrani() {\n  // Kodunu yaz:\n  return Container();\n}",
                solutionCode = "Widget yuklemeEkrani() {\n  return Center(child: CircularProgressIndicator());\n}",
                hints = listOf("Center(child: CircularProgressIndicator()) döndürün."),
                testCases = listOf(
                    TestCase("yuklemeEkrani()", "Center", "Yükleme ekranı testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "fl_quiz_11_1",
                    lessonId = "fl_11",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Gelen JSON metnini Dart haritasına (Map) veya listesine çeviren fonksiyon hangisidir?",
                    options = listOf("jsonDecode()", "jsonParse()", "stringToJson()", "mapJson()"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! dart:convert kütüphanesindeki jsonDecode() kullanılır.",
                    explanationWrong = "jsonDecode() kullanılır.",
                    reviewTopic = "Flutter HTTP & JSON"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "FutureBuilder snapshot.hasData ne anlama gelir?",
                    answer = "Sunucudan verinin başarıyla gelip gelmediğini kontrol eder."
                )
            ),
            completionCriteria = listOf(
                "http ile istek atma mantığını anlamak",
                "CircularProgressIndicator kullanabilmek"
            )
        ),

        // ==========================================
        // DERS 12: YAYINLAMA VE GELECEK
        // ==========================================
        Lesson(
            id = "fl_12",
            courseId = "flutter",
            sectionId = "fl_sec_6",
            title = "Uygulama Yayınlama ve Profesyonel İpuçları",
            shortDesc = "Google Play ve App Store'a uygulama çıkarma ve tam donanımlı Flutter geliştiricisi olma.",
            level = CourseLevel.EXPERT,
            order = 12,
            isPremium = true,
            learningObjectives = listOf(
                "App Icon ve Splash Screen (Açılış Ekranı) eklemek",
                "Android App Bundle (.aab) ve iOS (.ipa) çıktıları almak",
                "Tebrikler: Artık iki platforma birden uygulama geliştirebilirsiniz!"
            ),
            prerequisites = listOf("Tüm Flutter Konuları"),
            subtopics = listOf("Uygulama İkonu", "flutter build appbundle", "Tebrikler ve Tavsiyeler"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Mağazalara Çıkış: flutter build",
                    body = "Uygulamanız bittiğinde tek bir terminal komutuyla Google Play için `.aab` ve App Store için `.ipa` dosyalarınızı üretebilirsiniz:\n\n• `flutter build appbundle` (Android için)\n• `flutter build ipa` (iOS için)"
                ),
                LessonContentBlock(
                    subtitle = "2. Tebrikler! Flutter Yolculuğunu Başarıyla Tamamladınız! 📱✨",
                    body = "Artık temel widget'lardan gelişmiş animasyonlara, sayfa geçişlerinden sunucu bağlantılarına kadar komple bir mobil uygulama geliştirecek tüm bilgiye sahipsiniz. Hayalinizdeki uygulamayı yazın ve dünyayla paylaşın!"
                )
            ),
            codeExample = "// Terminal Komutu:\n// flutter build appbundle --release",
            codeExplanation = "Mağazaya yüklenecek optimize edilmiş üretim paketi oluşturulur.",
            realWorldExample = "Google Play Store'da milyonlarca indirmeye sahip Flutter uygulamaları bu komutla paketlenir.",
            practicalTask = "Uygulama yayınlama adımlarını gözden geçirin.",
            starterPlaygroundCode = "// Harika bir Flutter geliştiricisisiniz!",
            miniQuestion = MiniQuestion(
                id = "fl_q_12",
                question = "Google Play Store'a yüklenmek üzere optimize edilmiş Android paketini oluşturmak için hangi komut çalıştırılır?",
                options = listOf("flutter build appbundle", "flutter create apk", "flutter export play", "flutter package release"),
                correctIndex = 0,
                explanation = "Google Play için modern standart 'flutter build appbundle' komutudur."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_fl_12",
                lessonId = "fl_12",
                title = "Tebrik Kartı",
                instructions = "Üstünde 'Tebrikler!' yazan yeşil renkli bir Text widget'ı döndüren tebrikKarti() fonksiyonunu yazın.",
                exampleInput = "tebrikKarti()",
                exampleOutput = "Text",
                starterCode = "Widget tebrikKarti() {\n  // Kodunu yaz:\n  return Container();\n}",
                solutionCode = "Widget tebrikKarti() {\n  return Text('Tebrikler!', style: TextStyle(color: Colors.green));\n}",
                hints = listOf("Text('Tebrikler!', style: TextStyle(color: Colors.green)) döndürün."),
                testCases = listOf(
                    TestCase("tebrikKarti()", "Text", "Tebrik testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "fl_quiz_12_1",
                    lessonId = "fl_12",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Flutter projesinde paketleri, fontları ve resim varlıklarını (assets) tanımladığımız ana yapılandırma dosyası hangisidir?",
                    options = listOf("pubspec.yaml", "manifest.json", "build.gradle", "package.json"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Flutter'da tüm paket ve ayarlar pubspec.yaml dosyasında tutulur.",
                    explanationWrong = "pubspec.yaml dosyasıdır.",
                    reviewTopic = "Flutter Yapılandırma"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Flutter ile masaüstü uygulaması da yapabilir miyim?",
                    answer = "Evet! Windows, macOS ve Linux için de tek kodla masaüstü uygulamaları derleyebilirsiniz."
                )
            ),
            completionCriteria = listOf(
                "Yayınlama adımlarını bilmek",
                "Flutter ekosistemine tam hakim olmak"
            )
        )
    )
}
