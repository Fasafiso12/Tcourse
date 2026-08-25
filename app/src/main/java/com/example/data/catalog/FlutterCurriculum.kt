package com.example.data.catalog

import com.example.model.*

/**
 * Flutter Complete Official Curriculum (12 Sequential Lessons):
 * BEGINNER -> FUNDAMENTAL -> INTERMEDIATE -> ADVANCED -> EXPERT
 * Seamless progression from Basic Widgets & State Lifecycle to BLoC/Riverpod, Slivers, Animations & Three-Tree Engine Architecture (RenderObject/Platform Channels).
 */
object FlutterCurriculum {

    fun getSections(): List<CourseSection> = listOf(
        CourseSection(
            id = "fl_sec_1",
            courseId = "flutter",
            title = "Seviye 1 – Flutter Mimarisi, Temel Widget'lar & Düzen (Layout)",
            level = CourseLevel.BEGINNER,
            order = 1,
            description = "Flutter motoru (Engine/Framework), runApp(), MaterialApp, Scaffold, Column, Row, Container, Expanded ve Flexible yerleşimleri.",
            learningObjectives = listOf("Flutter motorunun çalışma prensibi", "MaterialApp ve Scaffold temelleri", "Column, Row ve hizalama eksenleri", "Expanded ve Flexible ile esnek yerleşim"),
            prerequisites = listOf("Temel Dart Programlama Bilgisi")
        ),
        CourseSection(
            id = "fl_sec_2",
            courseId = "flutter",
            title = "Seviye 2 – Widget Yaşam Döngüsü, Listeler & Kullanıcı Girdileri",
            level = CourseLevel.BEGINNER,
            order = 2,
            description = "StatelessWidget vs StatefulWidget, State Lifecycle (initState, dispose), ListView.builder, Form, TextFormField ve TextEditingController.",
            learningObjectives = listOf("Stateless vs Stateful widget farkı", "State yaşam döngüsü metotları (initState, dispose)", "ListView.builder ile performanslı listeler", "TextFormField ve Form doğrulama (validation)"),
            prerequisites = listOf("Flutter Temel Widget'lar ve Düzen")
        ),
        CourseSection(
            id = "fl_sec_3",
            courseId = "flutter",
            title = "Seviye 3 – Navigasyon (GoRouter), Tema & Duyarlı Tasarım (Responsive)",
            level = CourseLevel.INTERMEDIATE,
            order = 3,
            description = "Navigator 2.0 / GoRouter, Argüman aktarımı, Deep Linking, ThemeData, Material 3 ColorScheme, MediaQuery ve LayoutBuilder.",
            learningObjectives = listOf("GoRouter ile bildirimsel (declarative) rota yönetimi", "Deep linking ve sayfa parametreleri", "Material 3 Tema ve Dinamik Renkler", "LayoutBuilder ile duyarlı (responsive) UI"),
            prerequisites = listOf("Widget Yaşam Döngüsü ve Listeler")
        ),
        CourseSection(
            id = "fl_sec_4",
            courseId = "flutter",
            title = "Seviye 4 – Durum Yönetimi (State Management: Provider, Riverpod & BLoC)",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            description = "InheritedWidget temeli, Provider (ChangeNotifier), Flutter BLoC/Cubit (Event-State) ve Riverpod (Ref, AsyncValue) mimarileri.",
            learningObjectives = listOf("InheritedWidget ve State yayılımı", "Provider ve ChangeNotifier kullanımı", "BLoC & Cubit ile reaktif akışlar", "Riverpod sağlayıcıları (Providers)"),
            prerequisites = listOf("Flutter Navigasyon ve Temalama")
        ),
        CourseSection(
            id = "fl_sec_5",
            courseId = "flutter",
            title = "Seviye 5 – Animasyonlar (Implicit/Explicit), Ağ İstekleri & Veri Saklama",
            level = CourseLevel.ADVANCED,
            order = 5,
            description = "AnimatedContainer, AnimationController, CurvedAnimation, Hero animasyonları, Dio/HTTP ile REST API ve Hive/Isar yerel veritabanı.",
            learningObjectives = listOf("Implicit (Örtük) Animasyonlar", "Explicit (AnimationController) Animasyonlar", "Hero sayfa geçiş efektleri", "REST API entegrasyonu ve yerel veri önbelleği"),
            prerequisites = listOf("Flutter Durum Yönetimi")
        ),
        CourseSection(
            id = "fl_sec_6",
            courseId = "flutter",
            title = "Seviye 6 – Flutter İç Mimarisi (Üç Ağaç), RenderObject & Platform Channels",
            level = CourseLevel.EXPERT,
            order = 6,
            description = "Widget Tree, Element Tree & RenderObject Tree, CustomPainter, Slivers (CustomScrollView), MethodChannel/EventChannel ile Native (Kotlin/Swift) köprüsü.",
            learningObjectives = listOf("Flutter Üç Ağaç (Three-Tree) mimarisi", "Element lifecycle ve RenderObject çizim hattı", "CustomPainter ve doğrudan Canvas çizimleri", "MethodChannel ile Android/iOS yerel API köprüleri"),
            prerequisites = listOf("İleri Seviye Flutter Animasyon ve Mimari")
        )
    )

    fun getLessons(): List<Lesson> = listOf(
        // ==========================================
        // DERS 1: FLUTTER'A GİRİŞ, RUNAPP & SCAFFOLD (ÜCRETSİZ)
        // ==========================================
        Lesson(
            id = "fl_1",
            courseId = "flutter",
            sectionId = "fl_sec_1",
            title = "Flutter'a Giriş, runApp() & Scaffold Anatomisi",
            shortDesc = "Flutter felsefesi: 'Her Şey Bir Widget'tır'. Flutter mimarisi (Engine, Skia/Impeller), runApp(), MaterialApp ve standart Scaffold iskeleti.",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false,
            learningObjectives = listOf(
                "Flutter'ın yerel derleme ve Impeller grafik motoru mimarisini kavramak",
                "MaterialApp ve Scaffold bileşenlerinin rolünü öğrenmek",
                "Temel StatelessWidget ile ilk ekranı oluşturmak"
            ),
            prerequisites = listOf("Temel Dart Programlama Bilgisi"),
            subtopics = listOf("Flutter Mimarisi & Impeller vs Skia Motoru", "Üç Ağaç (Three Trees) Modeli (Widget, Element, RenderObject)", "MaterialApp & runApp() Başlatma Hattı", "Scaffold Ekran İskeleti", "const Anahtarı & Yeniden Çizim Optimizasyonu"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Flutter'ın Katmanlı Mimarisi ve Impeller Grafik Motoru",
                    body = "Flutter geleneksel web-view veya JavaScript köprüsü (bridge) kullanan melez çerçevelerin aksine, C++ ile yazılmış kendi grafik motoru (Engine) üzerinden doğrudan piksel çizer.\n\n• Impeller: Shader derleme gecikmelerini (Shader Compilation Jank) tamamen ortadan kaldırmak için Metal (iOS) ve Vulkan (Android) üzerinde AOT (Ahead-of-Time) derlenmiş gölgelendiricilerle çalışan yeni nesil grafik motorudur.\n• Üç Ağaç (Three-Tree Architecture): Flutter arayüzü üç katmandan oluşur: 1. Widget Ağacı (Hafif, değişmez yapılandırma), 2. Element Ağacı (Yaşam döngüsü ve referans bağı), 3. RenderObject Ağacı (Boyutlandırma, yerleşim ve gerçek piksel çizimi).",
                    codeSnippet = "import 'package:flutter/material.dart';\n\nvoid main() {\n  // runApp() kök widget'ı Element ağacına bağlar ve RenderView'ı başlatır\n  runApp(const BenimUygulamam());\n}\n\nclass BenimUygulamam extends StatelessWidget {\n  const BenimUygulamam({super.key});\n\n  @override\n  Widget build(BuildContext context) {\n    return const MaterialApp(\n      debugShowCheckedModeBanner: false,\n      home: Scaffold(\n        body: Center(child: Text('Merhaba Flutter! 🚀')),\n      ),\n    );\n  }\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Scaffold: Material Design Ekran İskeleti",
                    body = "Scaffold; `appBar`, `body`, `floatingActionButton`, `bottomNavigationBar` ve `drawer` gibi Material Design ekran bileşenlerini sağlayan temel iskelettir.\n\n`const` Anahtarı: Sabit widget'ların başına `const` eklemek, üst widget her yeniden inşa edildiğinde (rebuild) alt widget'ın yeniden oluşturulmasını önler ve bellek tahsisini sıfıra indirir.",
                    tip = "Sabit tüm widget'lara `const` ekleyerek Flutter derleyicisinin derleme zamanında tekilleştirilmiş (canonicalized) nesneler üretmesini sağlayın."
                )
            ),
            codeExample = "class AnaSayfa extends StatelessWidget {\n  const AnaSayfa({super.key});\n\n  @override\n  Widget build(BuildContext context) {\n    return Scaffold(\n      appBar: AppBar(\n        title: const Text('Flutter Kursu'),\n        backgroundColor: Colors.blueAccent,\n      ),\n      body: const Center(\n        child: Text(\n          'Flutter Dünyasına Hoş Geldiniz!',\n          style: TextStyle(fontSize: 20, fontWeight: FontWeight.bold),\n        ),\n      ),\n    );\n  }\n}",
            codeExplanation = "Scaffold temel ekranı kurdu, AppBar başlığı oluşturdu, Center ve Text widget'ları ile ekran ortalandı.",
            realWorldExample = "BMW, Google Pay, Alibaba ve Nubank milyonlarca kullanıcıya hizmet veren devasa mobil uygulamalarını Flutter ile geliştirmiştir.",
            practicalTask = "AppBar'ında başlık ve gövdesinde ortalanmış renkli bir metin olan bir Scaffold ekranı tasarlayın.",
            starterPlaygroundCode = "import 'package:flutter/material.dart';\nvoid main() => runApp(const MaterialApp(home: Scaffold(body: Center(child: Text('Hello')))));",
            miniQuestion = MiniQuestion(
                id = "fl_q_1",
                question = "Flutter'da bir Material Design ekranının standart iskeletini (AppBar, Body, FAB vb.) sağlayan temel widget hangisidir?",
                options = listOf("Container", "Scaffold", "MaterialApp", "Column"),
                correctIndex = 1,
                explanation = "Scaffold bir ekranın tüm temel görsel iskeletini sağlayan ana bileşendir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_fl_1",
                lessonId = "fl_1",
                title = "Basit Karşılama Ekranı",
                instructions = "Ortasında 'Başarılar!' yazan bir Scaffold döndüren BasitEkran StatelessWidget'ını yazın.",
                exampleInput = "BasitEkran()",
                exampleOutput = "Scaffold with centered text",
                starterCode = "class BasitEkran extends StatelessWidget {\n  const BasitEkran({super.key});\n  @override\n  Widget build(BuildContext context) {\n    // Kodunu buraya yaz:\n    return Container();\n  }\n}",
                solutionCode = "class BasitEkran extends StatelessWidget {\n  const BasitEkran({super.key});\n  @override\n  Widget build(BuildContext context) {\n    return const Scaffold(\n      body: Center(child: Text('Başarılar!')),\n    );\n  }\n}",
                hints = listOf("Scaffold(body: Center(child: Text('Başarılar!'))) döndürün."),
                testCases = listOf(
                    TestCase("BasitEkran", "Scaffold", "İlk ekran testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "fl_quiz_1_1",
                    lessonId = "fl_1",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Flutter'da widget ağacını başlatıp kök widget'ı ekrana bağlayan fonksiyon hangisidir?",
                    options = listOf("startFlutter()", "runApp()", "build()", "init()"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! main() içinde çağrılan runApp() kök widget'ı Flutter motoruna bağlar.",
                    explanationWrong = "runApp() fonksiyonu kullanılır.",
                    reviewTopic = "runApp"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Impeller Grafik Motoru nedir?",
                    answer = "Flutter'ın Skia yerine iOS ve Android için sıfırdan geliştirdiği; 'Jank' (animasyon takılması/shader derleme takılması) sorununu tamamen ortadan kaldıran yeni nesil metal/vulkan grafik motorudur."
                )
            ),
            completionCriteria = listOf(
                "Flutter mimarisini ve widget mantığını bilmek",
                "MaterialApp ve Scaffold iskeletini kurabilmek",
                "const kullanımının performans önemini kavramak"
            )
        ),

        // ==========================================
        // DERS 2: YERLEŞİM (LAYOUT): COLUMN, ROW, EXPANDED (ÜCRETSİZ)
        // ==========================================
        Lesson(
            id = "fl_2",
            courseId = "flutter",
            sectionId = "fl_sec_1",
            title = "Temel Yerleşim: Column, Row, Container & Expanded",
            shortDesc = "Esnek düzenler: Dikey (Column) ve Yatay (Row) dizilim, mainAxisAlignment, crossAxisAlignment, Container kutu modeli ve taşmaları önleyen Expanded/Flexible.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false,
            learningObjectives = listOf(
                "Column ve Row eksen hizalamalarını (MainAxis vs CrossAxis) ustaca yönetmek",
                "Container ile kenarlık, gölge (BoxDecoration) ve iç/dış boşluk (Padding/Margin) vermek",
                "RenderFlex Overflow (sarı-siyah şerit) taşma hatalarını Expanded ile çözmek"
            ),
            prerequisites = listOf("runApp ve Scaffold Anatomisi"),
            subtopics = listOf("Flutter Kısıt Kuralları (Constraints Go Down, Sizes Go Up)", "Column & Row Eksen Yönetimi", "Container, Padding & BoxDecoration", "RenderFlex Overflow Nedenleri", "Expanded vs Flexible Farkı (Tight vs Loose)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Flutter'ın Altın Kuralı: Kısıtlar (Constraints)",
                    body = "Flutter yerleşiminin temel kuralı şudur:\n• Constraints go down (Kısıtlar yukarıdan aşağıya iner)\n• Sizes go up (Boyutlar aşağıdan yukarıya bildirilir)\n• Parents decide position (Ebeveynler konumu belirler)\n\nRow ve Column (Flex tabanlı) kendi ana eksenlerinde sınırsız (unbounded) alan sunarlar; bu nedenle içlerine konan sınırsız genişlikteki elemanlar taşma hatasına yol açar.",
                    codeSnippet = "Row(\n  mainAxisAlignment: MainAxisAlignment.spaceBetween,\n  crossAxisAlignment: CrossAxisAlignment.center,\n  children: const [\n    Icon(Icons.star),\n    Text('4.9 Puan'),\n  ],\n)"
                ),
                LessonContentBlock(
                    subtitle = "2. Expanded vs Flexible ve RenderFlex Taşmaları",
                    body = "• `Expanded`: Çocuğuna `fit: FlexFit.tight` uygular; yani ebeveynin kalan tüm boşluğunu ZORLA doldurmasını sağlar. Metin taşmalarını engeller.\n• `Flexible`: Çocuğuna `fit: FlexFit.loose` uygular; çocuğun en fazla o kadar yer kaplamasına izin verir ancak çocuk daha küçükse zorlamaz.",
                    tip = "Sadece boşluk vermek için ağır Container yerine hafif `const SizedBox(height: 16)` kullanın."
                )
            ),
            codeExample = "class ProfilKarti extends StatelessWidget {\n  const ProfilKarti({super.key});\n\n  @override\n  Widget build(BuildContext context) {\n    return Container(\n      padding: const EdgeInsets.all(16),\n      decoration: BoxDecoration(\n        color: Colors.white,\n        borderRadius: BorderRadius.circular(12),\n        boxShadow: const [BoxShadow(color: Colors.black12, blurRadius: 8)],\n      ),\n      child: Row(\n        children: [\n          const CircleAvatar(child: Icon(Icons.person)),\n          const SizedBox(width: 16),\n          Expanded(\n            child: Column(\n              crossAxisAlignment: CrossAxisAlignment.start,\n              children: const [\n                Text('Ahmet Yılmaz', style: TextStyle(fontWeight: FontWeight.bold)),\n                Text('Mobil Yazılım Uzmanı', style: TextStyle(color: Colors.grey)),\n              ],\n            ),\n          ),\n        ],\n      ),\n    );\n  }\n}",
            codeExplanation = "Row içinde CircleAvatar ve Expanded Column kullanılarak taşma riski olmayan profesyonel bir kart oluşturuldu.",
            realWorldExample = "Sosyal medya gönderi kartları, ürün listesi satırları ve ayarlar menüleri bu Row-Column-Expanded kombinasyonu ile kodlanır.",
            practicalTask = "Yatayda iki butonu eşit genişlikte (%50-%50) paylaştıran bir Row tasarlayın.",
            starterPlaygroundCode = "Row(children: const [Expanded(child: Text('Sol')), Expanded(child: Text('Sağ'))]);",
            miniQuestion = MiniQuestion(
                id = "fl_q_2",
                question = "Row veya Column içinde bir widget'ın mevcut kalan boşluğun tamamını esnek şekilde doldurmasını sağlayan widget hangisidir?",
                options = listOf("Center", "Expanded", "Padding", "Align"),
                correctIndex = 1,
                explanation = "Expanded widget'ı Flex kuralına göre kalan tüm alanı çocuk widget'a tahsis eder."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_fl_2",
                lessonId = "fl_2",
                title = "İki Sütunlu Bilgi Kartı",
                instructions = "Row içinde solunda Icon(Icons.info) ve sağında Expanded(child: Text(bilgi)) bulunan BilgiSatiri(bilgi) widget'ını yazın.",
                exampleInput = "BilgiSatiri(bilgi: 'Sistem güncel')",
                exampleOutput = "Row with icon and expanded text",
                starterCode = "class BilgiSatiri extends StatelessWidget {\n  final String bilgi;\n  const BilgiSatiri({super.key, required this.bilgi});\n  @override\n  Widget build(BuildContext context) {\n    // Kodunu buraya yaz:\n    return Container();\n  }\n}",
                solutionCode = "class BilgiSatiri extends StatelessWidget {\n  final String bilgi;\n  const BilgiSatiri({super.key, required this.bilgi});\n  @override\n  Widget build(BuildContext context) {\n    return Row(\n      children: [\n        const Icon(Icons.info),\n        const SizedBox(width: 8),\n        Expanded(child: Text(bilgi)),\n      ],\n    );\n  }\n}",
                hints = listOf("Row(children: [Icon(...), SizedBox(...), Expanded(child: Text(bilgi))]) kullanın."),
                testCases = listOf(
                    TestCase("BilgiSatiri", "Row", "Yerleşim testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "fl_quiz_2_1",
                    lessonId = "fl_2",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Flutter'da 'A RenderFlex overflowed by X pixels' sarı-siyah çizgili ekran hatasının temel sebebi nedir?",
                    options = listOf("Telefonun hafızasının dolması", "Row veya Column içindeki çocukların mevcut ekran genişliği/yüksekliğinden daha fazla alan talep etmesi (Unbounded Constraints)", "Flutter sürümünün eski olması", "Dart derleme hatası"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Çocuk widget ekrandan taştığında RenderFlex taşma hatası fırlatır.",
                    explanationWrong = "Çocuk widget ekrana sığmadığında bu hata oluşur.",
                    reviewTopic = "RenderFlex Overflow"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Expanded ile Flexible arasındaki fark nedir?",
                    answer = "`Expanded` çocuğu kalan alanın TAMAMINI zorla doldurmaya iter (`fit: FlexFit.tight`). `Flexible` ise çocuğa maksimum o kadar alan verir ancak çocuk daha küçükse kendi boyutu kadar yer kaplamasına izin verir (`fit: FlexFit.loose`)."
                )
            ),
            completionCriteria = listOf(
                "Column ve Row eksen mantığını kavramak",
                "Container ve BoxDecoration ile stillendirme yapabilmek",
                "Expanded kullanarak taşma hatalarını çözebilmek"
            )
        ),

        // ==========================================
        // DERS 3: STATEFULWIDGET & STATE YAŞAM DÖNGÜSÜ
        // ==========================================
        Lesson(
            id = "fl_3",
            courseId = "flutter",
            sectionId = "fl_sec_2",
            title = "StatelessWidget vs StatefulWidget & State Yaşam Döngüsü",
            shortDesc = "Değişen durumlar: StatelessWidget vs StatefulWidget, State Lifecycle (initState, didChangeDependencies, didUpdateWidget, dispose) ve setState() mekanizması.",
            level = CourseLevel.BEGINNER,
            order = 3,
            isPremium = false,
            learningObjectives = listOf(
                "Stateless ve Stateful widget kullanım senaryolarını ayırt etmek",
                "State yaşam döngüsü metotlarını (initState, dispose) doğru zamanda kullanmak",
                "setState() çağrısının çalışma mantığını ve build metodunu nasıl tetiklediğini kavramak"
            ),
            prerequisites = listOf("Temel Yerleşim Widget'ları"),
            subtopics = listOf("Neden State Nesnesi Widget'tan Ayrıdır?", "initState() & Tek Seferlik Başlatma Kuralları", "didUpdateWidget() ve didChangeDependencies()", "dispose() & Bellek Sızıntılarını Önleme", "setState() ve Render Pipeline Tetikleme"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Neden Widget ile State Ayrıdır?",
                    body = "Widget'lar değişmezdir (immutable) ve her rebuild işleminde yok edilip yeniden üretilir. `State` nesnesi ise Element ağacında kalıcıdır; bellekteki durumunu (değişkenler, controller'lar) korur.\n\n`setState()` çağrıldığında o State'e bağlı Element `dirty` (kirli) olarak işaretlenir ve bir sonraki karede (frame) `build()` metodu yeniden çalıştırılır.",
                    codeSnippet = "class SayacEkran extends StatefulWidget {\n  const SayacEkran({super.key});\n  @override\n  State<SayacEkran> createState() => _SayacEkranState();\n}\n\nclass _SayacEkranState extends State<SayacEkran> {\n  int _sayac = 0;\n  void _artir() => setState(() => _sayac++);\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. initState() ve dispose() Yaşam Döngüsü",
                    body = "• `initState()`: Widget ağaca ilk eklendiğinde YALNIZCA BİR KEZ çalışır. Stream, AnimationController ve TextEditingController burada başlatılır.\n• `dispose()`: Widget ağaçtan kalıcı olarak silindiğinde çalışır. Bellek sızıntılarını önlemek için dinleyiciler ve controller'lar burada `.dispose()` edilmelidir.",
                    tip = "setState() içine asenkron (`async/await`) kodlar koymayın; asenkron işlem bittikten sonra `if (mounted) setState(...)` çağrılmalıdır."
                )
            ),
            codeExample = "class SayacUygulamasi extends StatefulWidget {\n  const SayacUygulamasi({super.key});\n  @override\n  State<SayacUygulamasi> createState() => _SayacUygulamasiState();\n}\n\nclass _SayacUygulamasiState extends State<SayacUygulamasi> {\n  int _sayac = 0;\n\n  @override\n  Widget build(BuildContext context) {\n    return Scaffold(\n      appBar: AppBar(title: const Text('Sayaç')), \n      body: Center(child: Text('Tıklama: \$_sayac', style: const TextStyle(fontSize: 24))),\n      floatingActionButton: FloatingActionButton(\n        onPressed: () => setState(() => _sayac++),\n        child: const Icon(Icons.add),\n      ),\n    );\n  }\n}",
            codeExplanation = "FAB'a basıldığında setState() çağrıldı; Flutter State'in değiştiğini anlayıp build() metodunu yeniden çalıştırdı.",
            realWorldExample = "Animasyon sayaçları, sepet miktarı butonları, form giriş alanları ve toggle switch'ler StatefulWidget ile durum tutar.",
            practicalTask = "Sayacı hem artıran hem de sıfırlayan bir StatefulWidget tasarlayın.",
            starterPlaygroundCode = "class A extends StatefulWidget { @override State<A> createState() => _A(); }\nclass _A extends State<A> { @override Widget build(BuildContext c) => const Text('A'); }",
            miniQuestion = MiniQuestion(
                id = "fl_q_3",
                question = "Flutter'da bir StatefulWidget ağaçtan kalıcı olarak kaldırıldığında Controller, Timer veya Stream'leri kapatmak için hangi yaşam döngüsü metodu ezilmelidir (override)?",
                options = listOf("initState()", "build()", "dispose()", "stop()"),
                correctIndex = 2,
                explanation = "dispose() metodu bellek sızıntılarını önlemek için dinleyicileri ve controller'ları kapatma yeridir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_fl_3",
                lessonId = "fl_3",
                title = "Beğeni (Like) Butonu",
                instructions = "Tıklandığında begenildi (bool) durumunu tersine çeviren ve begenildi ise kırmızı kalp (Icons.favorite), değilse boş kalp (Icons.favorite_border) gösteren BegeniButonu StatefulWidget'ını yazın.",
                exampleInput = "BegeniButonu()",
                exampleOutput = "Toggled icon",
                starterCode = "class BegeniButonu extends StatefulWidget {\n  const BegeniButonu({super.key});\n  @override\n  State<BegeniButonu> createState() => _BegeniButonuState();\n}\nclass _BegeniButonuState extends State<BegeniButonu> {\n  bool _begenildi = false;\n  @override\n  Widget build(BuildContext context) {\n    // Kodunu buraya yaz:\n    return Container();\n  }\n}",
                solutionCode = "class BegeniButonu extends StatefulWidget {\n  const BegeniButonu({super.key});\n  @override\n  State<BegeniButonu> createState() => _BegeniButonuState();\n}\nclass _BegeniButonuState extends State<BegeniButonu> {\n  bool _begenildi = false;\n  @override\n  Widget build(BuildContext context) {\n    return IconButton(\n      icon: Icon(_begenildi ? Icons.favorite : Icons.favorite_border, color: _begenildi ? Colors.red : Colors.grey),\n      onPressed: () => setState(() => _begenildi = !_begenildi),\n    );\n  }\n}",
                hints = listOf("IconButton içinde onPressed: () => setState(() => _begenildi = !_begenildi) yapın."),
                testCases = listOf(
                    TestCase("BegeniButonu", "IconButton", "Stateful toggle testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "fl_quiz_3_1",
                    lessonId = "fl_3",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "State nesnesi içinden üstteki StatefulWidget'ın parametrelerine (property) erişmek için hangi özel nesne kullanılır?",
                    options = listOf("parent", "widget", "this.state", "super"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! 'widget.ozellik' sözdizimi ile State içinden bağlı olduğu StatefulWidget'ın parametrelerine erişilir.",
                    explanationWrong = "widget nesnesi üzerinden erişilir.",
                    reviewTopic = "widget property in State"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "didUpdateWidget() ne zaman tetiklenir?",
                    answer = "Üst widget yeniden build edildiğinde ve altındaki bu StatefulWidget'a yeni parametreler geçtiğinde ancak State nesnesi korunmaya devam ettiğinde tetiklenir."
                )
            ),
            completionCriteria = listOf(
                "Stateless ve Stateful ayrımını bilmek",
                "initState ve dispose yaşam döngülerini doğru yönetmek",
                "setState ile UI güncellemelerini tetikleyebilmek"
            )
        ),

        // ==========================================
        // DERS 4: LİSTELER & FORMLAR (LISTVIEW, TEXTFORMFIELD)
        // ==========================================
        Lesson(
            id = "fl_4",
            courseId = "flutter",
            sectionId = "fl_sec_2",
            title = "Listeler, Izgaralar & Form Yönetimi (ListView & Form)",
            shortDesc = "Performanslı listeleme: ListView.builder, GridView.builder, ListTile, Form, TextFormField, GlobalKey<FormState> ve TextEditingController.",
            level = CourseLevel.BEGINNER,
            order = 4,
            isPremium = true,
            learningObjectives = listOf(
                "ListView.builder ile yalnızca ekranda görünen elemanları oluşturan tembel (lazy) listeler kurmak",
                "TextEditingController ile metin girdilerini yönetmek ve dispose etmek",
                "Form ve GlobalKey<FormState> ile kurallı form doğrulaması (validation) yapmak"
            ),
            prerequisites = listOf("StatefulWidget ve State Yaşam Döngüsü"),
            subtopics = listOf("ListView.builder & Sliver Sanallaştırma (Virtualization)", "ListTile & Divider", "GridView.builder ile Esnek Izgaralar", "TextEditingController & Dinleme", "Form & GlobalKey<FormState> Doğrulama"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. ListView.builder ve Viewport Sanallaştırması",
                    body = "Standart `ListView(children: [...])` listedeki tüm elemanları belleğe anında yükler. `ListView.builder` ise arka planda `RenderSliverList` kullanarak sadece ekranda (Viewport) görünen elemanları oluşturur ve kaydırdıkça görünmeyenleri bellekten serbest bırakır (Virtualization).",
                    codeSnippet = "ListView.builder(\n  itemCount: ogrenciler.length,\n  itemBuilder: (context, index) {\n    return ListTile(\n      title: Text(ogrenciler[index]),\n      leading: const Icon(Icons.person),\n    );\n  },\n)"
                ),
                LessonContentBlock(
                    subtitle = "2. Form ve GlobalKey<FormState> Mimarisi",
                    body = "`GlobalKey<FormState>` ile form ağacına dışarıdan erişilir ve `_formKey.currentState!.validate()` çağrılarak tüm alt `TextFormField`'ların validator fonksiyonları tek seferde tetiklenir.",
                    tip = "TextEditingController'ı mutlaka `dispose()` metodunda `_controller.dispose()` şeklinde serbest bırakın."
                )
            ),
            codeExample = "class GirisFormu extends StatefulWidget {\n  const GirisFormu({super.key});\n  @override\n  State<GirisFormu> createState() => _GirisFormuState();\n}\n\nclass _GirisFormuState extends State<GirisFormu> {\n  final _formKey = GlobalKey<FormState>();\n  final _epostaController = TextEditingController();\n\n  @override\n  void dispose() {\n    _epostaController.dispose();\n    super.dispose();\n  }\n\n  @override\n  Widget build(BuildContext context) {\n    return Form(\n      key: _formKey,\n      child: Column(\n        children: [\n          TextFormField(\n            controller: _epostaController,\n            decoration: const InputDecoration(labelText: 'E-posta'),\n            validator: (val) => val == null || !val.contains('@') ? 'Geçerli e-posta girin' : null,\n          ),\n          ElevatedButton(\n            onPressed: () {\n              if (_formKey.currentState!.validate()) {\n                ScaffoldMessenger.of(context).showSnackBar(const SnackBar(content: Text('Giriş Başarılı')));\n              }\n            },\n            child: const Text('Giriş Yap'),\n          ),\n        ],\n      ),\n    );\n  }\n}",
            codeExplanation = "GlobalKey form durumunu tuttu, validator ile e-posta kontrolü yapıldı ve dispose ile controller temizlendi.",
            realWorldExample = "E-ticaret ürün katalogları (`GridView.builder`) ve Kullanıcı Kayıt/Ödeme ekranları (`Form`) bu mimariyle yazılır.",
            practicalTask = "100 elemanlı bir listeyi ListView.builder ile listeleyen ve tıklandığında başlığını yazdıran kod yazın.",
            starterPlaygroundCode = "ListView.builder(itemCount: 5, itemBuilder: (c, i) => ListTile(title: Text('Öğe \$i')));",
            miniQuestion = MiniQuestion(
                id = "fl_q_4",
                question = "Flutter'da bir Form içindeki tüm TextFormField alanlarının validator kurallarını aynı anda tetiklemek için hangi metot çağrılır?",
                options = listOf("_formKey.currentState!.save()", "_formKey.currentState!.validate()", "_formKey.currentState!.reset()", "validateAll()"),
                correctIndex = 1,
                explanation = "validate() metodu tüm alanları kontrol edip hata yoksa true, varsa false döner."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_fl_4",
                lessonId = "fl_4",
                title = "Şehir Listesi (ListView.builder)",
                instructions = "List<String> sehirler listesi alan ve ListView.builder kullanarak her şehri ListTile(title: Text(sehir)) olarak döndüren SehirListesi widget'ını yazın.",
                exampleInput = "sehirler = ['İstanbul', 'Ankara']",
                exampleOutput = "ListView with 2 items",
                starterCode = "class SehirListesi extends StatelessWidget {\n  final List<String> sehirler;\n  const SehirListesi({super.key, required this.sehirler});\n  @override\n  Widget build(BuildContext context) {\n    // Kodunu buraya yaz:\n    return Container();\n  }\n}",
                solutionCode = "class SehirListesi extends StatelessWidget {\n  final List<String> sehirler;\n  const SehirListesi({super.key, required this.sehirler});\n  @override\n  Widget build(BuildContext context) {\n    return ListView.builder(\n      itemCount: sehirler.length,\n      itemBuilder: (context, index) => ListTile(title: Text(sehirler[index])),\n    );\n  }\n}",
                hints = listOf("ListView.builder(itemCount: sehirler.length, itemBuilder: (c, i) => ListTile(title: Text(sehirler[i])))"),
                testCases = listOf(
                    TestCase("SehirListesi", "ListView", "Liste testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "fl_quiz_4_1",
                    lessonId = "fl_4",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "TextEditingController nesneleri kullanılmadığında dispose() edilmezse ne meydana gelir?",
                    options = listOf("Uygulama anında çöker", "Arka planda dinleyiciler referans tutmaya devam eder ve bellek sızıntısına (Memory Leak) yol açar", "Metinler silinir", "Hiçbir şey olmaz"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Controller'lar dispose edilmezse bellek sızıntısı oluşturur.",
                    explanationWrong = "Bellek sızıntısına yol açar.",
                    reviewTopic = "Controller Disposal"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "GridView.count vs GridView.builder farkı nedir?",
                    answer = "`GridView.count` tüm grid elemanlarını baştan oluşturur (küçük listeler için). `GridView.builder` ise ekranda görünen ızgara kutularını tembel (lazy) oluşturur (büyük/dinamik listeler için)."
                )
            ),
            completionCriteria = listOf(
                "ListView.builder ile performanslı listeler kurabilmek",
                "Form ve TextFormField ile input validasyonu yapmak",
                "TextEditingController yaşam döngüsünü yönetebilmek"
            )
        ),

        // ==========================================
        // DERS 5: NAVİGASYON (GOROUTER) & DEEP LINKING
        // ==========================================
        Lesson(
            id = "fl_5",
            courseId = "flutter",
            sectionId = "fl_sec_3",
            title = "Navigasyon & Yönlendirme (Navigator 2.0 / GoRouter)",
            shortDesc = "Modern sayfa yönetimi: Navigator 1.0 vs Navigator 2.0 (Router), GoRouter ile bildirimsel rota yapılandırması, Parametre aktarımı ve Deep Linking.",
            level = CourseLevel.INTERMEDIATE,
            order = 5,
            isPremium = true,
            learningObjectives = listOf(
                "GoRouter ile bildirimsel (declarative) rota mimarisi kurmak",
                "Path parametreleri (`/urun/:id`) ve Query parametreleri (`?ara=flutter`) aktarmak",
                "Web ve mobilde Deep Linking (URL tabanlı sayfa açma) altyapısını kavramak"
            ),
            prerequisites = listOf("Listeler ve Form Yönetimi"),
            subtopics = listOf("Navigator 1.0 vs Navigator 2.0 (Router API)", "GoRouter Bildirimsel Rota Yapısı", "context.go() vs context.push()", "Path & Query Parametreleri (state.pathParameters)", "Redirect (Auth Guard) Mimarisi"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. context.go() vs context.push() Farkı",
                    body = "• `context.go('/detay')`: Rota ağacını hedefe göre yeniden yapılandırır; tarayıcı URL adresiyle birebir eşleşir (Web ve Deep Link için zorunludur).\n• `context.push('/detay')`: Mevcut yığının (Navigation Stack) en üstüne bağımsız yeni bir sayfa iter (AppBar geri butonu ile dönülür).",
                    codeSnippet = "final router = GoRouter(\n  routes: [\n    GoRoute(path: '/', builder: (c, s) => const AnaEkran()),\n    GoRoute(\n      path: '/urun/:id',\n      builder: (c, s) => UrunDetayEkran(id: s.pathParameters['id']!),\n    ),\n  ],\n);"
                ),
                LessonContentBlock(
                    subtitle = "2. Auth Guard & Otomatik Yönlendirme (Redirect)",
                    body = "GoRouter'ın `redirect` fonksiyonu sayesinde oturum açmamış kullanıcıların korumalı sayfalara erişmesi global düzeyde engellenerek `/login` ekranına yönlendirilir.",
                    tip = "MaterialApp.router kurucusunu `routerConfig: router` ile bağlamayı unutmayın."
                )
            ),
            codeExample = "import 'package:flutter/material.dart';\n// GoRouter Mimarisi Özeti:\nclass UrunDetayEkran extends StatelessWidget {\n  final String id;\n  const UrunDetayEkran({super.key, required this.id});\n\n  @override\n  Widget build(BuildContext context) {\n    return Scaffold(\n      appBar: AppBar(title: Text('Ürün Detayı #\$id')),\n      body: Center(child: Text('Görüntülenen Ürün ID: \$id')),\n    );\n  }\n}",
            codeExplanation = "GoRouter URL'deki :id parametresini çekerek sayfaya aktardı; web tarayıcısında adres çubuğu ile tam senkronize çalışır.",
            realWorldExample = "E-posta veya bildirim linkine tıklandığında uygulamanın doğrudan ilgili ürün sayfasına açılması (Deep Linking) GoRouter ile çözülür.",
            practicalTask = "Ana sayfadan detay sayfasına isim parametresi aktaran iki ekranlı bir yapı kurgulayın.",
            starterPlaygroundCode = "Navigator.push(context, MaterialPageRoute(builder: (c) => const Scaffold(body: Text('Detay'))));",
            miniQuestion = MiniQuestion(
                id = "fl_q_5",
                question = "GoRouter'da sayfaya geçiş yaparken tarayıcı URL geçmişini değiştirmeden doğrudan yeni sayfayı yığının (stack) üstüne eklemek için hangi metot kullanılır?",
                options = listOf("context.go()", "context.push()", "context.replace()", "context.pop()"),
                correctIndex = 1,
                explanation = "context.push() yığına yeni sayfa iter ve AppBar otomatik geri butonu ekler."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_fl_5",
                lessonId = "fl_5",
                title = "Parametreli Detay Ekranı",
                instructions = "baslik (String) parametresi alan ve AppBar'ında bu başlığı gösteren DetaySayfasi StatelessWidget'ını yazın.",
                exampleInput = "DetaySayfasi(baslik: 'Ayarlar')",
                exampleOutput = "Scaffold with AppBar title 'Ayarlar'",
                starterCode = "class DetaySayfasi extends StatelessWidget {\n  final String baslik;\n  const DetaySayfasi({super.key, required this.baslik});\n  @override\n  Widget build(BuildContext context) {\n    // Kodunu buraya yaz:\n    return Container();\n  }\n}",
                solutionCode = "class DetaySayfasi extends StatelessWidget {\n  final String baslik;\n  const DetaySayfasi({super.key, required this.baslik});\n  @override\n  Widget build(BuildContext context) {\n    return Scaffold(\n      appBar: AppBar(title: Text(baslik)),\n      body: Center(child: Text(baslik)),\n    );\n  }\n}",
                hints = listOf("Scaffold(appBar: AppBar(title: Text(baslik)))"),
                testCases = listOf(
                    TestCase("DetaySayfasi", "Scaffold", "Parametreli sayfa")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "fl_quiz_5_1",
                    lessonId = "fl_5",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Flutter Web ve Mobilde bildirimsel (declarative) navigasyon ve Deep Linking için Google tarafından resmi önerilen paket hangisidir?",
                    options = listOf("GetX", "GoRouter", "AutoRoute", "Fluro"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! GoRouter Flutter ekibi tarafından geliştirilen resmi ve en popüler yönlendirme kütüphanesidir.",
                    explanationWrong = "GoRouter resmi pakettir.",
                    reviewTopic = "GoRouter"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "ShellRoute nedir?",
                    answer = "Alt sayfalar değiştikçe alt navigasyon çubuğunu (BottomNavigationBar) sabit tutan ve sadece gövdeyi yenileyen GoRouter özelliğidir."
                )
            ),
            completionCriteria = listOf(
                "GoRouter rota konfigürasyonunu yapabilmek",
                "Path ve Query parametrelerini okuyabilmek",
                "Deep linking mantığını kavramak"
            )
        ),

        // ==========================================
        // DERS 6: TEMA & DUYARLI TASARIM (MATERIAL 3 & RESPONSIVE)
        // ==========================================
        Lesson(
            id = "fl_6",
            courseId = "flutter",
            sectionId = "fl_sec_3",
            title = "Tema & Duyarlı Tasarım (Material 3, MediaQuery & LayoutBuilder)",
            shortDesc = "Görsel tutarlılık ve cihaz uyumu: Material 3 (ColorScheme.fromSeed), Dark Mode, MediaQuery, LayoutBuilder ve Breakpoint kuralları.",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true,
            learningObjectives = listOf(
                "Material 3 ColorScheme.fromSeed ile dinamik renk paletleri ve Dark Theme oluşturmak",
                "MediaQuery ile ekran boyutlarını ve güvenli alanları (SafeArea) yönetmek",
                "LayoutBuilder ile mobil, tablet ve masaüstüne uyum sağlayan Responsive arayüzler tasarlamak"
            ),
            prerequisites = listOf("Navigasyon ve GoRouter"),
            subtopics = listOf("Material 3 & ColorScheme.fromSeed", "Açık ve Koyu Tema (ThemeMode)", "Theme.of(context) Kullanımı", "MediaQuery (Boyut & Padding)", "LayoutBuilder ile Responsive Breakpoints"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Material 3 Temalama",
                    body = "`ColorScheme.fromSeed(seedColor: Colors.deepPurple)` tek bir ana renkten 30+ tonlu tam uyumlu Material 3 renk paleti üretir.",
                    codeSnippet = "ThemeData(\n  useMaterial3: true,\n  colorScheme: ColorScheme.fromSeed(\n    seedColor: Colors.teal,\n    brightness: Brightness.dark,\n  ),\n)"
                ),
                LessonContentBlock(
                    subtitle = "2. LayoutBuilder ile Duyarlı (Responsive) UI",
                    body = "`LayoutBuilder` ebeveynin sunduğu maksimum genişliği (`constraints.maxWidth`) ölçer. Örneğin 600px altındaysa tek sütun, üstündeyse iki sütunlu tablet görünümüne geçer.",
                    tip = "Statik renkler (`Colors.blue`) yerine daima `Theme.of(context).colorScheme.primary` kullanın; böylece tema değişiminde UI otomatik güncellenir."
                )
            ),
            codeExample = "class DuyarliEkran extends StatelessWidget {\n  const DuyarliEkran({super.key});\n\n  @override\n  Widget build(BuildContext context) {\n    final tema = Theme.of(context);\n    \n    return Scaffold(\n      appBar: AppBar(\n        title: const Text('Duyarlı Tasarım'),\n        backgroundColor: tema.colorScheme.primaryContainer,\n      ),\n      body: LayoutBuilder(\n        builder: (context, constraints) {\n          if (constraints.maxWidth > 600) {\n            // Tablet / Masaüstü (Geniş Ekran - 2 Sütun):\n            return Row(children: const [Expanded(child: Text('Sol Menü')), Expanded(child: Text('İçerik'))]);\n          } else {\n            // Mobil (Dar Ekran - Tek Sütun):\n            return const Center(child: Text('Mobil Görünüm'));\n          }\n        },\n      ),\n    );\n  }\n}",
            codeExplanation = "LayoutBuilder ekran genişliğine göre mobil veya tablet düzenini dinamik olarak seçti.",
            realWorldExample = "Katlanabilir telefonlar (Galaxy Fold) ve iPad Split View modunda uygulamaların bozulmadan adapte olması LayoutBuilder ile sağlanır.",
            practicalTask = "ThemeData içinde özel bir seedColor belirleyip TextTheme stillerini kullanan bir sayfa yazın.",
            starterPlaygroundCode = "LayoutBuilder(builder: (c, constraints) => Text('Genişlik: \${constraints.maxWidth}'));",
            miniQuestion = MiniQuestion(
                id = "fl_q_6",
                question = "Flutter'da bir widget'ın mevcut ebeveyninden aldığı maksimum genişlik ve yükseklik kısıtlamalarını (BoxConstraints) ölçerek UI kararı vermeyi sağlayan widget hangisidir?",
                options = listOf("MediaQuery", "LayoutBuilder", "Container", "SizedBox"),
                correctIndex = 1,
                explanation = "LayoutBuilder widget'ın kendi ebeveyn kısıtlamalarını (constraints) ölçerek responsive render yapar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_fl_6",
                lessonId = "fl_6",
                title = "Tema Renkli Buton",
                instructions = "Arka plan rengi Theme.of(context).colorScheme.primary olan bir Container içinde beyaz renkle 'Kaydet' yazan TemaButonu widget'ını yazın.",
                exampleInput = "TemaButonu()",
                exampleOutput = "Themed Container with text",
                starterCode = "class TemaButonu extends StatelessWidget {\n  const TemaButonu({super.key});\n  @override\n  Widget build(BuildContext context) {\n    // Kodunu buraya yaz:\n    return Container();\n  }\n}",
                solutionCode = "class TemaButonu extends StatelessWidget {\n  const TemaButonu({super.key});\n  @override\n  Widget build(BuildContext context) {\n    final colorScheme = Theme.of(context).colorScheme;\n    return Container(\n      padding: const EdgeInsets.symmetric(horizontal: 16, vertical: 8),\n      decoration: BoxDecoration(\n        color: colorScheme.primary,\n        borderRadius: BorderRadius.circular(8),\n      ),\n      child: const Text('Kaydet', style: TextStyle(color: Colors.white)),\n    );\n  }\n}",
                hints = listOf("Theme.of(context).colorScheme.primary kullanın."),
                testCases = listOf(
                    TestCase("TemaButonu", "Container", "Tema erişim testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "fl_quiz_6_1",
                    lessonId = "fl_6",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "MediaQuery.of(context).size ile LayoutBuilder(constraints) arasındaki en kritik mimari fark nedir?",
                    options = listOf("MediaQuery tüm fiziksel ekranın boyutunu verir; LayoutBuilder ise o widget'ın ebeveyninden aldığı kullanılabilir net alanı verir", "MediaQuery daha hızlıdır", "LayoutBuilder sadece web içindir", "Farkları yoktur"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! MediaQuery ekranın tamamını ölçerken, LayoutBuilder widget'ın kendi yerleşim kutusunu ölçer.",
                    explanationWrong = "MediaQuery cihaz ekranını, LayoutBuilder yerel ebeveyn alanını ölçer.",
                    reviewTopic = "MediaQuery vs LayoutBuilder"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "SafeArea widget'ı ne işe yarar?",
                    answer = "Çentik (notch), dinamik ada (Dynamic Island), durum çubuğu ve ana ekran alt çizgisi gibi işletim sistemi öğelerinin arayüz metinlerinin üstünü kapatmasını engeller."
                )
            ),
            completionCriteria = listOf(
                "Material 3 ColorScheme yapılandırmasını bilmek",
                "Theme.of(context) ile tema özelliklerini okuyabilmek",
                "LayoutBuilder ile Responsive ekranlar geliştirebilmek"
            )
        ),

        // ==========================================
        // DERS 7: DURUM YÖNETİMİ 1: INHERITEDWIDGET & PROVIDER
        // ==========================================
        Lesson(
            id = "fl_7",
            courseId = "flutter",
            sectionId = "fl_sec_4",
            title = "Durum Yönetimi 1: InheritedWidget & Provider Mimarisi",
            shortDesc = "Prop drilling'e son: InheritedWidget mekanizması, Provider, ChangeNotifier, context.watch() vs context.read() ve Consumer widget'ı.",
            level = CourseLevel.INTERMEDIATE,
            order = 7,
            isPremium = true,
            learningObjectives = listOf(
                "Flutter'ın veri yayılım temeli olan InheritedWidget'ın çalışma prensibini kavramak",
                "ChangeNotifier ve Provider ile iş mantığını (Business Logic) UI'dan ayırmak",
                "context.watch (yeniden çiz) ile context.read (sadece metot çağır) arasındaki kritik farkı öğrenmek"
            ),
            prerequisites = listOf("Tema ve Duyarlı Tasarım"),
            subtopics = listOf("Prop Drilling Problemi", "InheritedWidget Derinlikleri", "ChangeNotifier & notifyListeners()", "ChangeNotifierProvider & MultiProvider", "context.watch vs context.read vs Consumer"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. context.watch() vs context.read()",
                    body = "• `context.watch<T>()`: Değer değiştiğinde build metodunu YENİDEN ÇALIŞTIRIR (UI'da veri gösterirken kullanılır).\n• `context.read<T>()`: Değeri sadece bir kere okur ve dinlemez; butonların `onPressed` fonksiyonlarında metot çağırmak için ZORUNLUDUR (Gereksiz rebuild'leri önler).",
                    codeSnippet = "class SepetModel extends ChangeNotifier {\n  final List<String> _urunler = [];\n  List<String> get urunler => _urunler;\n  \n  void ekle(String urun) {\n    _urunler.add(urun);\n    notifyListeners(); // Dinleyen tüm UI'ları uyarır!\n  }\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Consumer Widget'ı ile Noktasal Rebuild",
                    body = "Tüm `build()` metodunu baştan çalıştırmak yerine yalnızca değişen Text widget'ını `Consumer<SepetModel>` içine alarak 60 FPS performans korunur.",
                    tip = "build() metodu içinde asla `context.read()` kullanmayın; dinlemediği için verideki değişim ekrana yansımaz."
                )
            ),
            codeExample = "class SepetSayfasi extends StatelessWidget {\n  const SepetSayfasi({super.key});\n\n  @override\n  Widget build(BuildContext context) {\n    // Yalnızca veri gösterirken watch:\n    final sepet = context.watch<SepetModel>();\n    \n    return Scaffold(\n      appBar: AppBar(title: Text('Sepetim (\${sepet.urunler.length})')),\n      body: ListView.builder(\n        itemCount: sepet.urunler.length,\n        itemBuilder: (c, i) => ListTile(title: Text(sepet.urunler[i])),\n      ),\n      floatingActionButton: FloatingActionButton(\n        // Butonda sadece read:\n        onPressed: () => context.read<SepetModel>().ekle('Yeni Ürün'),\n        child: const Icon(Icons.add),\n      ),\n    );\n  }\n}",
            codeExplanation = "SepetModel verisi ChangeNotifierProvider ile ağaca sağlandı, watch ile okundu ve read ile eklendi.",
            realWorldExample = "Sepet tutarı, kullanıcı oturum durumu (Auth state) ve tema seçimi (Açık/Koyu) Provider ile merkezi olarak yönetilir.",
            practicalTask = "SayacModel ChangeNotifier sınıfı yazıp Provider ile sayacı artıran ve ekranda gösteren bir UI tasarlayın.",
            starterPlaygroundCode = "class Sayac extends ChangeNotifier { int n = 0; void inc() { n++; notifyListeners(); } }",
            miniQuestion = MiniQuestion(
                id = "fl_q_7",
                question = "Provider kütüphanesinde bir butona tıklandığında (onPressed içinde) modeldeki bir fonksiyonu çağırmak için hangisi kullanılmalıdır?",
                options = listOf("context.watch<Model>()", "context.read<Model>()", "context.listen<Model>()", "context.find<Model>()"),
                correctIndex = 1,
                explanation = "Buton tıklamalarında gereksiz rebuild tetiklememek için her zaman context.read<Model>() kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_fl_7",
                lessonId = "fl_7",
                title = "ChangeNotifier Sayacı",
                instructions = "int deger alanı olan, artir() ve sifirla() metotlarında notifyListeners() çağıran BasitSayacModel ChangeNotifier sınıfını yazın.",
                exampleInput = "BasitSayacModel().artir()",
                exampleOutput = "deger == 1",
                starterCode = "class BasitSayacModel extends ChangeNotifier {\n  // Kodunu buraya yaz:\n}",
                solutionCode = "class BasitSayacModel extends ChangeNotifier {\n  int _deger = 0;\n  int get deger => _deger;\n  void artir() {\n    _deger++;\n    notifyListeners();\n  }\n  void sifirla() {\n    _deger = 0;\n    notifyListeners();\n  }\n}",
                hints = listOf("int get deger => _deger; ve metodlarda notifyListeners(); çağırın."),
                testCases = listOf(
                    TestCase("BasitSayacModel", "ChangeNotifier", "Provider model testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "fl_quiz_7_1",
                    lessonId = "fl_7",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "ChangeNotifier sınıfında durum değiştiğinde bunu dinleyen widget'lara haber verip yeniden çizilmelerini sağlayan metot hangisidir?",
                    options = listOf("setState()", "notifyListeners()", "emit()", "update()"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! notifyListeners() ChangeNotifier dinleyicilerini tetikler.",
                    explanationWrong = "notifyListeners() metodu çağrılır.",
                    reviewTopic = "notifyListeners"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "InheritedWidget'ın updateShouldNotify() metodu ne yapar?",
                    answer = "InheritedWidget yeniden oluşturulduğunda eski ve yeni veriyi karşılaştırır; eğer veri değişmişse alt widget'lara bildirim gönderip rebuild olmalarını sağlar."
                )
            ),
            completionCriteria = listOf(
                "InheritedWidget mantığını bilmek",
                "ChangeNotifier ve notifyListeners kullanımını kavramak",
                "context.watch ve context.read ayrımını hatasız uygulamak"
            )
        ),

        // ==========================================
        // DERS 8: İLERİ DURUM YÖNETİMİ (BLOC, CUBIT & RIVERPOD)
        // ==========================================
        Lesson(
            id = "fl_8",
            courseId = "flutter",
            sectionId = "fl_sec_4",
            title = "İleri Durum Yönetimi: Flutter BLoC, Cubit & Riverpod",
            shortDesc = "Endüstri standardı mimariler: BLoC (Events -> States), Cubit (Metot -> State), BlocBuilder, BlocListener, Riverpod 2.0 (Providers, Notifiers & AsyncValue).",
            level = CourseLevel.ADVANCED,
            order = 8,
            isPremium = true,
            learningObjectives = listOf(
                "BLoC (Business Logic Component) deseninin Event-State akışını kavramak",
                "Cubit ile hafif ve öngörülebilir durum yönetimi yapmak",
                "Riverpod 2.0 ile derleme zamanı güvenli (Compile-time Safe) sağlayıcılar ve AsyncValue yönetmek"
            ),
            prerequisites = listOf("InheritedWidget ve Provider"),
            subtopics = listOf("BLoC vs Cubit Mimarisi", "Event-State Modellemesi", "BlocBuilder & BlocListener & BlocConsumer", "Riverpod Mimarisi & Ref Nesnesi", "AsyncValue ile Yükleniyor/Hata/Veri Durumu"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. BLoC ve Cubit Mimarisi",
                    body = "• Cubit: `emit(yeniState)` ile doğrudan durum yayan basit yapı.\n• BLoC: Gelen `Event` olaylarını `on<Event>((e, emit) { ... })` ile dinleyip işleyen katı mimari.",
                    codeSnippet = "class SayacCubit extends Cubit<int> {\n  SayacCubit() : super(0);\n  void artir() => emit(state + 1);\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. BlocBuilder vs BlocListener",
                    body = "• `BlocBuilder`: Durum değiştikçe UI WIDGET'I çizer (Saf fonksiyon olmalıdır).\n• `BlocListener`: Durum değiştikçe Snackbaer gösterme, Sayfa yönlendirme (Navigate) gibi TEK SEFERLİK YAN ETKİLERİ (Side Effects) çalıştırır.",
                    tip = "Hem UI çizip hem Snackbar göstermek gerekiyorsa ikisini birleştiren `BlocConsumer` kullanılır."
                )
            ),
            codeExample = "class SayacEkraniBloc extends StatelessWidget {\n  const SayacEkraniBloc({super.key});\n\n  @override\n  Widget build(BuildContext context) {\n    return Scaffold(\n      appBar: AppBar(title: const Text('BLoC / Cubit')),\n      body: Center(\n        child: BlocBuilder<SayacCubit, int>(\n          builder: (context, state) {\n            return Text('Sayaç Durumu: \$state', style: const TextStyle(fontSize: 24));\n          },\n        ),\n      ),\n      floatingActionButton: FloatingActionButton(\n        onPressed: () => context.read<SayacCubit>().artir(),\n        child: const Icon(Icons.add),\n      ),\n    );\n  }\n}",
            codeExplanation = "BlocBuilder SayacCubit durumunu dinleyerek yalnızca Text widget'ını rebuild etti.",
            realWorldExample = "Fintech, bankacılık ve kurumsal ölçekteki Flutter projelerinin %80'i test edilebilirlik ve sıkı mimari nedeniyle BLoC kullanır.",
            practicalTask = "Cubit kullanarak AuthState (GirişYapildi, CikisYapildi) durumlarını yöneten bir mini yapı kurun.",
            starterPlaygroundCode = "class AuthCubit extends Cubit<bool> { AuthCubit() : super(false); void login() => emit(true); }",
            miniQuestion = MiniQuestion(
                id = "fl_q_8",
                question = "Flutter BLoC kütüphanesinde durum değiştiğinde Snackbar göstermek veya başka sayfaya yönlendirmek gibi tek seferlik işlemleri (Side-effects) yapmak için hangi widget kullanılır?",
                options = listOf("BlocBuilder", "BlocListener", "BlocProvider", "BlocSelector"),
                correctIndex = 1,
                explanation = "BlocListener UI çizmez; tek seferlik yan etkileri (navigation, dialog, snackbar) güvenle yürütür."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_fl_8",
                lessonId = "fl_8",
                title = "Tema Seçici Cubit (ThemeCubit)",
                instructions = "ThemeMode durumu tutan, koyuYap() ile ThemeMode.dark ve acikYap() ile ThemeMode.light yayan ThemeCubit sınıfını yazın.",
                exampleInput = "ThemeCubit().koyuYap()",
                exampleOutput = "state == ThemeMode.dark",
                starterCode = "class ThemeCubit extends Cubit<ThemeMode> {\n  // Kodunu buraya yaz:\n  ThemeCubit() : super(ThemeMode.system);\n}",
                solutionCode = "class ThemeCubit extends Cubit<ThemeMode> {\n  ThemeCubit() : super(ThemeMode.system);\n  void koyuYap() => emit(ThemeMode.dark);\n  void acikYap() => emit(ThemeMode.light);\n}",
                hints = listOf("void koyuYap() => emit(ThemeMode.dark);"),
                testCases = listOf(
                    TestCase("ThemeCubit", "ThemeMode", "Cubit testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "fl_quiz_8_1",
                    lessonId = "fl_8",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Riverpod'da asenkron veri yükleme süreçlerini (Loading, Error, Data) otomatik yöneten ve desen eşleme sağlayan özel veri yapısı hangisidir?",
                    options = listOf("FutureBuilder", "AsyncValue<T>", "StreamSubscription", "StateNotifier"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! AsyncValue.when(data: ..., error: ..., loading: ...) ile asenkron durumlar tek satırda kusursuz yönetilir.",
                    explanationWrong = "AsyncValue<T> kullanılır.",
                    reviewTopic = "Riverpod AsyncValue"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Riverpod neden BuildContext'e ihtiyaç duymaz?",
                    answer = "Riverpod global `ProviderContainer` ve `Ref` nesnesi üzerinde çalıştığı için Flutter Widget ağacından tamamen bağımsızdır; UI dışında servis ve testlerde de doğrudan çalışabilir."
                )
            ),
            completionCriteria = listOf(
                "BLoC ve Cubit mimari farklarını bilmek",
                "BlocBuilder ve BlocListener'ı doğru yerde kullanmak",
                "Riverpod sağlayıcılarını ve AsyncValue desenini kavramak"
            )
        ),

        // ==========================================
        // DERS 9: ANİMASYONLAR (IMPLICIT & EXPLICIT)
        // ==========================================
        Lesson(
            id = "fl_9",
            courseId = "flutter",
            sectionId = "fl_sec_5",
            title = "Animasyonlar & Hareket Tasarımı (Implicit, Explicit & Hero)",
            shortDesc = "Akıcı görsel deneyim: Implicit Animasyonlar (AnimatedContainer, AnimatedOpacity), Explicit Animasyonlar (AnimationController, CurvedAnimation, Tween) ve Hero geçişleri.",
            level = CourseLevel.ADVANCED,
            order = 9,
            isPremium = true,
            learningObjectives = listOf(
                "AnimatedContainer ve TweenAnimationBuilder ile sıfır konfigürasyonla örtük (implicit) animasyon yapmak",
                "AnimationController ve SingleTickerProviderStateMixin ile mikro saniye kontrollü açık (explicit) animasyonlar kurmak",
                "Hero widget'ı ile sayfalar arası pürüzsüz görsel uçuş geçişleri sağlamak"
            ),
            prerequisites = listOf("BLoC ve Riverpod Mimarisi"),
            subtopics = listOf("Implicit (Örtük) Animasyonlar", "AnimatedContainer & AnimatedOpacity", "Explicit Animasyonlar (AnimationController)", "TickerProvider & vsync Mantığı", "Hero Widget ile Sayfa Geçişleri"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Implicit vs Explicit Animasyonlar",
                    body = "• Implicit: Boyutu, rengi veya opasiteyi değiştirirsiniz; `AnimatedContainer(duration: 300.ms)` aradaki tüm kareleri otomatik doldurur.\n• Explicit: Başlatma, durdurma, geri sarma, tekrarlama (repeat) gibi tam kontrol gereken durumlarda `AnimationController` kullanılır.",
                    codeSnippet = "AnimatedContainer(\n  duration: const Duration(milliseconds: 400),\n  curve: Curves.easeInOut,\n  width: _buyuk ? 200 : 100,\n  height: _buyuk ? 200 : 100,\n  color: _buyuk ? Colors.blue : Colors.red,\n)"
                ),
                LessonContentBlock(
                    subtitle = "2. Hero Widget ile Görsel Uçuşu",
                    body = "İki farklı sayfada aynı `tag` değerine sahip `Hero(tag: 'urun-1', child: Image(...))` kullanıldığında sayfa değişirken resim ekranın bir ucundan diğerine uçarak geçer.",
                    tip = "AnimationController nesneleri mutlaka `dispose()` içinde `_controller.dispose()` şeklinde kapatılmalıdır."
                )
            ),
            codeExample = "class DonenKutu extends StatefulWidget {\n  const DonenKutu({super.key});\n  @override\n  State<DonenKutu> createState() => _DonenKutuState();\n}\n\nclass _DonenKutuState extends State<DonenKutu> with SingleTickerProviderStateMixin {\n  late final AnimationController _controller;\n\n  @override\n  void initState() {\n    super.initState();\n    _controller = AnimationController(vsync: this, duration: const Duration(seconds: 2))..repeat();\n  }\n\n  @override\n  void dispose() {\n    _controller.dispose();\n    super.dispose();\n  }\n\n  @override\n  Widget build(BuildContext context) {\n    return RotationTransition(\n      turns: _controller,\n      child: const Icon(Icons.refresh, size: 60, color: Colors.indigo),\n    );\n  }\n}",
            codeExplanation = "SingleTickerProviderStateMixin ekran tazeleme hızına (60/120Hz) senkron vsync sağladı, RotationTransition sürekli dönen animasyon üretti.",
            realWorldExample = "E-ticaret uygulamalarında ürün resmine tıklandığında detay sayfasına pürüzsüz büyümesi Hero animasyonu ile yapılır.",
            practicalTask = "Butona tıklandığında boyutu 50'den 150'ye büyüyen bir AnimatedContainer tasarlayın.",
            starterPlaygroundCode = "AnimatedOpacity(opacity: 1.0, duration: const Duration(seconds: 1), child: const Text('Görünür'));",
            miniQuestion = MiniQuestion(
                id = "fl_q_9",
                question = "İki farklı sayfa arasında aynı görsel öğenin ekran boyunca akıcı şekilde uçarak geçiş yapmasını sağlayan Flutter widget'ı hangisidir?",
                options = listOf("FlyTransition", "Hero", "PageTransition", "SharedElement"),
                correctIndex = 1,
                explanation = "Hero widget'ı ortak 'tag' kimliğine sahip öğeleri sayfalar arasında otomatik uçurur."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_fl_9",
                lessonId = "fl_9",
                title = "Görünürlük Animasyonu (AnimatedOpacity)",
                instructions = "gorunur (bool) parametresi alan ve Duration(milliseconds: 300) ile opasitesini 1.0 veya 0.0 yapan OpaklikAnimasyonu widget'ını AnimatedOpacity ile yazın.",
                exampleInput = "OpaklikAnimasyonu(gorunur: true)",
                exampleOutput = "AnimatedOpacity with opacity 1.0",
                starterCode = "class OpaklikAnimasyonu extends StatelessWidget {\n  final bool gorunur;\n  const OpaklikAnimasyonu({super.key, required this.gorunur});\n  @override\n  Widget build(BuildContext context) {\n    // Kodunu buraya yaz:\n    return Container();\n  }\n}",
                solutionCode = "class OpaklikAnimasyonu extends StatelessWidget {\n  final bool gorunur;\n  const OpaklikAnimasyonu({super.key, required this.gorunur});\n  @override\n  Widget build(BuildContext context) {\n    return AnimatedOpacity(\n      duration: const Duration(milliseconds: 300),\n      opacity: gorunur ? 1.0 : 0.0,\n      child: const Text('Animasyonlu Metin'),\n    );\n  }\n}",
                hints = listOf("AnimatedOpacity(duration: ..., opacity: gorunur ? 1.0 : 0.0, child: ...)"),
                testCases = listOf(
                    TestCase("OpaklikAnimasyonu", "AnimatedOpacity", "Animasyon testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "fl_quiz_9_1",
                    lessonId = "fl_9",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Flutter'da Explicit animasyonlarda AnimationController oluştururken 'vsync: this' parametresinin temel teknik amacı nedir?",
                    options = listOf("Animasyonu hızlandırmak", "Ekran arka plandayken veya kapalıyken gereksiz animasyon hesaplamasını durdurup pil ve GPU tüketimini sıfıra indirmek", "Hataları yakalamak", "Widget'ı renklendirmek"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Ticker vsync ile animasyonu yalnızca ekran aktifken ve donanım tazeleme frekansında tetikler.",
                    explanationWrong = "vsync gereksiz kare çizimlerini engelleyip pil tasarrufu sağlar.",
                    reviewTopic = "vsync and Ticker"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "CurvedAnimation nedir?",
                    answer = "Lineer (sabit hızlı) ilerleyen animasyon kontrolcüsüne `Curves.bounceOut`, `Curves.easeInOut` gibi fiziksel ivmelenme eğrileri kazandıran sınıftır."
                )
            ),
            completionCriteria = listOf(
                "Implicit animasyonları hızlıca uygulayabilmek",
                "AnimationController ve vsync mimarisini yönetmek",
                "Hero animasyonları ile sayfa geçişleri kurgulamak"
            )
        ),

        // ==========================================
        // DERS 10: AĞ, REST API & YEREL VERİTABANI
        // ==========================================
        Lesson(
            id = "fl_10",
            courseId = "flutter",
            sectionId = "fl_sec_5",
            title = "Ağ İstekleri, REST API & Yerel Veritabanı (Dio, Hive / Isar)",
            shortDesc = "Veri haberleşmesi ve kalıcılık: HTTP / Dio kütüphanesi, Interceptors, JSON Serileştirme, Offline-First yaklaşımı ve NoSQL Hive/Isar veritabanı.",
            level = CourseLevel.ADVANCED,
            order = 10,
            isPremium = true,
            learningObjectives = listOf(
                "Dio kütüphanesi ile Interceptors (Token enjeksiyonu, Loglama) ve REST istekleri yönetmek",
                "Model sınıflarında `fromJson` ve `toJson` serileştirmesi kurmak",
                "Hive veya Isar ile internet olmasa dahi çalışan (Offline-First) yerel önbellek mimarisi tasarlamak"
            ),
            prerequisites = listOf("Animasyonlar ve Hareket Tasarımı"),
            subtopics = listOf("Dio vs http", "Dio Interceptors & Hata Yakalama", "JSON Serialization (fromJson/toJson)", "SharedPreferences (Basit Ayarlar)", "Hive & Isar NoSQL Veritabanı"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Dio ve Interceptor Gücü",
                    body = "Dio; istek iptali (CancelToken), dosya indirme/yükleme ilerleme takibi ve en önemlisi `Interceptor` sağlar. Tüm isteklere otomatik `Bearer Token` eklemek ve 401 hatasında sessizce token yenilemek için idealdir.",
                    codeSnippet = "final dio = Dio(BaseOptions(baseUrl: 'https://api.example.com'));\ndio.interceptors.add(InterceptorsWrapper(\n  onRequest: (options, handler) {\n    options.headers['Authorization'] = 'Bearer \$token';\n    return handler.next(options);\n  },\n));"
                ),
                LessonContentBlock(
                    subtitle = "2. NoSQL Hive / Isar Hızı",
                    body = "SQLite yerine saf Dart ile yazılmış anahtar-değer veya belge tabanlı `Hive/Isar` veritabanları nanosaniyeler seviyesinde veri okur ve SQLite'a göre 5 kat daha az bellek harcar.",
                    tip = "Büyük JSON listelerini UI thread'ini dondurmadan ayrıştırmak için Dart `compute()` fonksiyonu (Isolate) kullanılmalıdır."
                )
            ),
            codeExample = "class KullaniciModel {\n  final int id;\n  final String ad;\n  KullaniciModel({required this.id, required this.ad});\n\n  factory KullaniciModel.fromJson(Map<String, dynamic> json) {\n    return KullaniciModel(id: json['id'], ad: json['ad']);\n  }\n}\n\nFuture<KullaniciModel> kullaniciGetir(Dio dio) async {\n  final response = await dio.get('/kullanici/1');\n  return KullaniciModel.fromJson(response.data);\n}",
            codeExplanation = "Dio HTTP isteğini attı, gelen yanıt factory kurucusu ile tip güvenli KullaniciModel nesnesine dönüştürüldü.",
            realWorldExample = "Spotify veya Instagram gibi uygulamalar açıldığında internet olmasa bile önceden Hive/Isar'a kaydedilmiş akışı anında ekrana basar.",
            practicalTask = "Bir Map<String, dynamic> alıp Model nesnesine dönüştüren factory fromJson kurucusu yazın.",
            starterPlaygroundCode = "final map = {'id': 1, 'ad': 'Ali'}; final id = map['id']; print(id);",
            miniQuestion = MiniQuestion(
                id = "fl_q_10",
                question = "Ağ isteklerinde tüm giden isteklerin başlığına (header) otomatik olarak JWT Token eklemek veya hataları merkezi loglamak için Dio'nun hangi özelliği kullanılır?",
                options = listOf("CancelToken", "Interceptors", "BaseOptions", "FormData"),
                correctIndex = 1,
                explanation = "Interceptors istek öncesi ve yanıt sonrası araya girerek merkezi işlem yapmayı sağlar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_fl_10",
                lessonId = "fl_10",
                title = "JSON Model Fabrikası",
                instructions = "baslik (String) ve id (int) alanlarına sahip, Map<String, dynamic> json alan factory GorevModel.fromJson kurucusunu yazın.",
                exampleInput = "{'id': 10, 'baslik': 'Kod yaz'}",
                exampleOutput = "GorevModel(id: 10, baslik: 'Kod yaz')",
                starterCode = "class GorevModel {\n  final int id;\n  final String baslik;\n  GorevModel({required this.id, required this.baslik});\n  // factory kurucusunu buraya yazın:\n}",
                solutionCode = "class GorevModel {\n  final int id;\n  final String baslik;\n  GorevModel({required this.id, required this.baslik});\n  factory GorevModel.fromJson(Map<String, dynamic> json) {\n    return GorevModel(id: json['id'] as int, baslik: json['baslik'] as String);\n  }\n}",
                hints = listOf("factory GorevModel.fromJson(Map<String, dynamic> json) => GorevModel(id: json['id'], baslik: json['baslik']);"),
                testCases = listOf(
                    TestCase("GorevModel", "GorevModel", "JSON parsing testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "fl_quiz_10_1",
                    lessonId = "fl_10",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Flutter'da devasa bir JSON verisini parse ederken ana arayüzün (UI) takılmasını (Jank) önlemek için ne yapılmalıdır?",
                    options = listOf("Timer kullanmak", "JSON parse işlemini 'compute()' fonksiyonu ile arka plan Isolate iş parçacığına devretmek", "setState çağırmak", "Ekranı gizlemek"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! compute() ağır CPU işlemlerini ayrı bir Isolate'e devrederek ana UI thread'ini akıcı tutar.",
                    explanationWrong = "compute() ile ayrı Isolate üzerinde çalıştırılmalıdır.",
                    reviewTopic = "compute and Isolates"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Hive vs SharedPreferences farkı nedir?",
                    answer = "`SharedPreferences` sadece ilkel tipler (int, string, bool) ve küçük kullanıcı ayarları içindir. `Hive` ise nesneleri, listeleri ve büyük veri setlerini yüksek hızda saklayan tam teşekküllü bir NoSQL veritabanıdır."
                )
            ),
            completionCriteria = listOf(
                "Dio ve Interceptors mimarisini kurabilmek",
                "JSON serileştirme kalıplarını uygulamak",
                "Offline-First yerel veri saklama mantığını kavramak"
            )
        ),

        // ==========================================
        // DERS 11: SLIVERS & CUSTOM PAINTER
        // ==========================================
        Lesson(
            id = "fl_11",
            courseId = "flutter",
            sectionId = "fl_sec_6",
            title = "İleri UI: Slivers (CustomScrollView) & CustomPainter",
            shortDesc = "Özel kaydırma efektleri ve doğrudan piksel çizimi: CustomScrollView, SliverAppBar (Genişleyen Başlık), SliverList, CustomPainter, Canvas ve Paint nesneleri.",
            level = CourseLevel.EXPERT,
            order = 11,
            isPremium = true,
            learningObjectives = listOf(
                "CustomScrollView ile kaydıkça küçülen/genişleyen SliverAppBar ve Slivers mimarisi kurmak",
                "CustomPainter ile doğrudan ekrana 2D vektörel grafikler, daireler ve eğriler çizmek",
                "CustomPaint performansında `shouldRepaint` metodunun optimizasyon rolünü kavramak"
            ),
            prerequisites = listOf("Ağ İstekleri ve Yerel Veritabanı"),
            subtopics = listOf("Slivers Nedir?", "CustomScrollView & SliverAppBar", "SliverList & SliverGrid", "CustomPainter Anatomisi (paint & shouldRepaint)", "Canvas & Paint ile Çizim (drawLine, drawCircle, Path)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Slivers (Dilimler) Dünyası",
                    body = "Normal widget'lar kutu protokolü (Box Protocol) ile çalışır. `Sliver`lar ise kaydırma protokolü (Sliver Protocol) ile çalışarak görünür alana göre boyutlarını dinamik değiştirir (Örn: sayfa kaydıkça resmin küçülüp AppBar başlığına dönüşmesi).",
                    codeSnippet = "CustomScrollView(\n  slivers: [\n    SliverAppBar(\n      expandedHeight: 200,\n      flexibleSpace: FlexibleSpaceBar(title: Text('Genişleyen Başlık')),\n    ),\n    SliverList(delegate: SliverChildBuilderDelegate((c, i) => ListTile(title: Text('Öğe \$i')), childCount: 20)),\n  ],\n)"
                ),
                LessonContentBlock(
                    subtitle = "2. CustomPainter: Saf Piksel Kontrolü",
                    body = "Flutter'da var olmayan özel grafikler, dairesel göstergeler veya grafik çizgileri `CustomPaint(painter: BenimCizicim())` ile doğrudan GPU Canvas'ına çizilir.",
                    tip = "Gereksiz yeniden çizimleri önlemek için `shouldRepaint` metodunda sadece çizim parametreleri değiştiğinde `true` döndürün."
                )
            ),
            codeExample = "class DaireCizici extends CustomPainter {\n  @override\n  void paint(Canvas canvas, Size size) {\n    final paint = Paint()\n      ..color = Colors.orangeAccent\n      ..strokeWidth = 4\n      ..style = PaintingStyle.stroke;\n\n    canvas.drawCircle(Offset(size.width / 2, size.height / 2), 40, paint);\n  }\n\n  @override\n  bool shouldRepaint(covariant CustomPainter oldDelegate) => false;\n}",
            codeExplanation = "CustomPainter paint metodunda Canvas ve Paint nesneleriyle piksel piksel turuncu bir çember çizdi.",
            realWorldExample = "Özel finans grafikleri, radar ekranları, imza atma alanları ve ses dalga formu görselleştiricileri CustomPainter ile üretilir.",
            practicalTask = "SliverAppBar içeren ve kaydıkça arka plan resmini gizleyen bir CustomScrollView ekranı yazın.",
            starterPlaygroundCode = "CustomPaint(size: const Size(100, 100), painter: DaireCizici());",
            miniQuestion = MiniQuestion(
                id = "fl_q_11",
                question = "CustomPainter sınıfında gereksiz GPU yeniden çizimlerini engellemek için hangi metot dikkatle uygulanmalıdır?",
                options = listOf("paint()", "shouldRepaint()", "hitTest()", "dispose()"),
                correctIndex = 1,
                explanation = "shouldRepaint(oldDelegate) veriler değişmediğinde false dönerek gereksiz Canvas çizimlerini engeller."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_fl_11",
                lessonId = "fl_11",
                title = "Özel Çizgi Çizici (CustomPainter)",
                instructions = "Sol üstten (Offset.zero) sağ alta (Offset(size.width, size.height)) kırmızı bir çizgi çizen CizgiPainter CustomPainter sınıfını yazın.",
                exampleInput = "CustomPaint(painter: CizgiPainter())",
                exampleOutput = "Diagonal red line",
                starterCode = "class CizgiPainter extends CustomPainter {\n  @override\n  void paint(Canvas canvas, Size size) {\n    // Kodunu buraya yaz:\n  }\n  @override\n  bool shouldRepaint(covariant CustomPainter oldDelegate) => false;\n}",
                solutionCode = "class CizgiPainter extends CustomPainter {\n  @override\n  void paint(Canvas canvas, Size size) {\n    final paint = Paint()..color = Colors.red..strokeWidth = 2;\n    canvas.drawLine(Offset.zero, Offset(size.width, size.height), paint);\n  }\n  @override\n  bool shouldRepaint(covariant CustomPainter oldDelegate) => false;\n}",
                hints = listOf("canvas.drawLine(Offset.zero, Offset(size.width, size.height), Paint()..color = Colors.red)"),
                testCases = listOf(
                    TestCase("CizgiPainter", "CustomPainter", "Çizim testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "fl_quiz_11_1",
                    lessonId = "fl_11",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Flutter'da bir SliverAppBar'ın yukarı kaydırıldığında ekrandan tamamen kaybolmayıp üstte sabit kalmasını (pinned) sağlayan parametre hangisidir?",
                    options = listOf("floating: true", "pinned: true", "snap: true", "fixed: true"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! pinned: true yapıldığında SliverAppBar küçülerek en üstte sabitlenir.",
                    explanationWrong = "pinned: true parametresi kullanılır.",
                    reviewTopic = "SliverAppBar Pinned"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "SliverToBoxAdapter ne işe yarar?",
                    answer = "CustomScrollView içine normal bir kutu widget'ı (Container, Card, Padding gibi sliver olmayan bir widget) eklemek istediğinizde köprü görevi gören adaptör widget'tır."
                )
            ),
            completionCriteria = listOf(
                "CustomScrollView ve SliverAppBar oluşturabilmek",
                "CustomPainter ve Canvas ile özel 2D çizimler yapabilmek",
                "shouldRepaint performans optimizasyonunu kavramak"
            )
        ),

        // ==========================================
        // DERS 12: FLUTTER İÇ MİMARİSİ (ÜÇ AĞAÇ) & PLATFORM CHANNELS
        // ==========================================
        Lesson(
            id = "fl_12",
            courseId = "flutter",
            sectionId = "fl_sec_6",
            title = "Flutter İç Mimarisi (Üç Ağaç) & Platform Channels (Native Köprü)",
            shortDesc = "Flutter motorunun derinlikleri: Üç Ağaç Mimarisi (Widget Tree, Element Tree, RenderObject Tree), RenderObject, Platform Channels (MethodChannel/EventChannel) ve Native Kotlin/Swift Entegrasyonu.",
            level = CourseLevel.EXPERT,
            order = 12,
            isPremium = true,
            learningObjectives = listOf(
                "Widget Tree (Konfigürasyon), Element Tree (Bağlayıcı/Hafıza) ve RenderObject Tree (Çizim/Düzen) farkını kavramak",
                "Flutter'ın 'Key' (ValueKey, ObjectKey) mekanizması ile Element eşlemesini nasıl koruduğunu anlamak",
                "MethodChannel kullanarak Flutter'dan Android (Kotlin) ve iOS (Swift) yerel API'lerini çağırmak"
            ),
            prerequisites = listOf("Slivers, CustomPainter ve İleri Flutter"),
            subtopics = listOf("Üç Ağaç Anatomisi (Widget, Element, RenderObject)", "RenderObject Yaşamı (layout, paint)", "Keys & Element Eşleme Mantığı", "MethodChannel ile Native Çağrı", "EventChannel ile Sürekli Native Veri Akışı"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Flutter'ın Üç Ağaç Mimarisi",
                    body = "1. `Widget Tree`: Hafif, geçici, değişmez (immutable) UI reçetesidir (Her karede yok edilip yeniden üretilebilir).\n2. `Element Tree`: Widget ile RenderObject arasındaki kalıcı köprüdür; State'i hafızada tutar.\n3. `RenderObject Tree`: Ekrana gerçek boyutlandırma (`layout`), konumlandırma ve piksel çizimi (`paint`) yapan ağır C++ bağlantılı nesnelerdir.",
                    codeSnippet = "// MethodChannel ile Native Android/iOS Çağrısı:\nconst platform = MethodChannel('com.example.app/pil');\n\nFuture<int> pilSeviyesiAl() async {\n  final int pil = await platform.invokeMethod('getBatteryLevel');\n  return pil;\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Platform Channels (Native Köprüsü)",
                    body = "Flutter Dart kodu ile Android (Kotlin/Java) veya iOS (Swift/Obj-C) işletim sistemi arasında JSON/Binary mesajlaşma hattı açar. Bluetooth, Pil Durumu ve Sensörler bu yolla bağlanır.",
                    tip = "Tek seferlik çağrılar için `MethodChannel`, sensör gibi sürekli veri akışları için `EventChannel` (Stream) kullanılır."
                )
            ),
            codeExample = "// Dart Tarafı:\nconst platform = MethodChannel('samples.flutter.dev/battery');\n\nFuture<void> pilYazdir() async {\n  try {\n    final int sonuc = await platform.invokeMethod('getBatteryLevel');\n    print('Pil Seviyesi: %\$sonuc');\n  } on PlatformException catch (e) {\n    print('Hata: \${e.message}');\n  }\n}",
            codeExplanation = "invokeMethod yerel işletim sistemi köprüsünü tetikledi ve işletim sisteminin yerel pil API'sinden yanıtı Dart'a taşıdı.",
            realWorldExample = "Kamera eklentileri (camera plugin), Bluetooth ve Biyometrik Parmak İzi okuyucular Platform Channels köprüsüyle işletim sistemine bağlanır.",
            practicalTask = "MethodChannel üzerinden 'selamVer' metodunu çağırıp gelen string yanıtı ekrana basan bir fonksiyon yazın.",
            starterPlaygroundCode = "const channel = MethodChannel('test_channel');\nprint('Platform kanalı hazır.');",
            miniQuestion = MiniQuestion(
                id = "fl_q_12",
                question = "Flutter mimarisinde ekrandaki gerçek piksel çiziminden (paint) ve boyutlandırmadan (layout) sorumlu olan çekirdek ağaç katmanı hangisidir?",
                options = listOf("Widget Tree", "Element Tree", "RenderObject Tree", "Layer Tree"),
                correctIndex = 2,
                explanation = "RenderObject Tree ekrana çizim ve boyut hesaplaması yapan ağır grafik nesnelerinden oluşur."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_fl_12",
                lessonId = "fl_12",
                title = "Native Metot Çağrıcı",
                instructions = "Verilen MethodChannel üzerinden 'cihazModeli' metodunu invokeMethod ile çağırıp dönen String model bilgisini döndüren cihazModeliAl(MethodChannel channel) async fonksiyonunu yazın.",
                exampleInput = "cihazModeliAl(channel)",
                exampleOutput = "'Pixel 8'",
                starterCode = "Future<String> cihazModeliAl(MethodChannel channel) async {\n    // Kodunu buraya yaz:\n    return '';\n}",
                solutionCode = "Future<String> cihazModeliAl(MethodChannel channel) async {\n    final String model = await channel.invokeMethod('cihazModeli');\n    return model;\n}",
                hints = listOf("final String model = await channel.invokeMethod('cihazModeli'); return model;"),
                testCases = listOf(
                    TestCase("cihazModeliAl", "String", "Platform channel testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "fl_quiz_12_1",
                    lessonId = "fl_12",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir listedeki elemanların sırası dinamik olarak değiştiğinde veya eleman silindiğinde Element Tree'nin doğru State nesnelerini doğru widget'larla eşleştirmeye devam etmesini sağlamak için ne kullanılmalıdır?",
                    options = listOf("GlobalKey", "Benzersiz Key (ValueKey / ObjectKey)", "SizedBox", "InheritedWidget"),
                    correctOptionIndex = 1,
                    explanationRight = "Doğru! Key'ler Element Tree'nin liste değişikliklerinde doğru State'i korumasını garanti eder.",
                    explanationWrong = "Benzersiz Key (ValueKey) kullanılır.",
                    reviewTopic = "Widget Keys"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "EventChannel ile MethodChannel farkı nedir?",
                    answer = "`MethodChannel` tek seferlik istek-yanıt (Request-Response) için kullanılırken, `EventChannel` Native taraftan Flutter'a kesintisiz veri akışı (Örn: İvmeölçer / GPS konum akışı) aktarmak için Dart Stream üretir."
                )
            ),
            completionCriteria = listOf(
                "Üç Ağaç (Widget, Element, RenderObject) mimarisini açıklayabilmek",
                "Widget Key mekanizmasının neden gerekli olduğunu bilmek",
                "MethodChannel ve EventChannel ile Native köprüler kurabilmek"
            )
        )
    )
}
