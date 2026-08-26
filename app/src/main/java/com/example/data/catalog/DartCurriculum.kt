package com.example.data.catalog

import com.example.model.*

/**
 * Dart Kolay & Anlaşılır Müfredatı (12 Adım):
 * Sıfırdan başlayanlar için sade, samimi ve örneklerle dolu konu anlatımları.
 */
object DartCurriculum {

    fun getSections(): List<CourseSection> = listOf(
        CourseSection(
            id = "dart_sec_1",
            courseId = "dart",
            title = "Bölüm 1: Programlamaya İlk Adım ve Temel Yapılar",
            level = CourseLevel.BEGINNER,
            order = 1,
            description = "Dart nedir, ekrana nasıl yazı yazdırılır, değişkenler nasıl saklanır ve bilgisayara nasıl karar aldırılır?",
            learningObjectives = listOf("Ekrana yazı yazdırma ve main() fonksiyonu", "Sayı, metin ve mantıksal değişkenler", "if-else ve switch ile karar verme", "for ve while ile tekrarlayan döngüler"),
            prerequisites = listOf("Ön bilgi gerekmez! Merak ve heves yeterlidir.")
        ),
        CourseSection(
            id = "dart_sec_2",
            courseId = "dart",
            title = "Bölüm 2: Fonksiyonlar, Listeler ve Güvenlik",
            level = CourseLevel.BEGINNER,
            order = 2,
            description = "Tekrar eden işleri fonksiyonlara devretme, verileri listelerde toplama ve boş (null) hatalarından korunma.",
            learningObjectives = listOf("Fonksiyon yazma ve kısa ok (=>) kullanımı", "Listeler, Kümeler ve Sözlükler (List, Set, Map)", "Null Safety ile uygulamanın çökmesini önleme"),
            prerequisites = listOf("Temel değişkenler ve döngüler")
        ),
        CourseSection(
            id = "dart_sec_3",
            courseId = "dart",
            title = "Bölüm 3: Nesne Yönelimli Programlama (OOP)",
            level = CourseLevel.INTERMEDIATE,
            order = 3,
            description = "Kodlarımızı gerçek hayattaki nesneler gibi modelleme: Sınıflar, kurucu metotlar ve kalıtım.",
            learningObjectives = listOf("Sınıf (Class) ve Nesne (Object) mantığı", "Kurucu metotlar (Constructors)", "Kalıtım (extends) ile özellikleri miras alma", "Hata yakalama (try-catch)"),
            prerequisites = listOf("Fonksiyonlar ve Listeler")
        ),
        CourseSection(
            id = "dart_sec_4",
            courseId = "dart",
            title = "Bölüm 4: Pratik Araçlar ve Modern Özellikler",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            description = "Mixin ile yetenek paylaşımı, sınıflara dışarıdan yeni güçler katan Extension metodları.",
            learningObjectives = listOf("Mixin ile kod tekrarını önleme", "Extension Methods ile hazır sınıfları genişletme", "Dart 3 Records ve çoklu değer döndürme"),
            prerequisites = listOf("Nesne Yönelimli Programlama")
        ),
        CourseSection(
            id = "dart_sec_5",
            courseId = "dart",
            title = "Bölüm 5: Asenkron Dünya ve Canlı Veri Akışları",
            level = CourseLevel.ADVANCED,
            order = 5,
            description = "İnternetten veri çekerken ekranın donmasını engelleyen Future, async/await ve canlı veri akışları (Streams).",
            learningObjectives = listOf("Future ve async/await ile arka plan işlemleri", "Stream ile canlı veri dinleme", "Zamanlayıcılar ve reaktif bildirimler"),
            prerequisites = listOf("Fonksiyonlar ve Sınıflar")
        ),
        CourseSection(
            id = "dart_sec_6",
            courseId = "dart",
            title = "Bölüm 6: İleri Düzey Performans ve Çoklu İşlemler",
            level = CourseLevel.EXPERT,
            order = 6,
            description = "Büyük hesaplamaları telefonun diğer çekirdeklerine devretme (Isolates) ve temiz kod kuralları.",
            learningObjectives = listOf("Isolate ile paralel çalışma", "Bellek yönetimi ve temiz kod prensipleri"),
            prerequisites = listOf("Asenkron Dart Programlama")
        )
    )

    fun getLessons(): List<Lesson> = listOf(
        // ==========================================
        // DERS 1: TEMEL SÖZDİZİMİ, DEĞİŞKENLER & TİPLER
        // ==========================================
        Lesson(
            id = "dart_1",
            courseId = "dart",
            sectionId = "dart_sec_1",
            title = "Dart'a Giriş: Değişkenler ve Bilgi Saklama",
            shortDesc = "Dart dünyasına ilk adım! Ekrana yazı yazdırma, sayıları ve metinleri değişkenlerde saklama mantığını öğrenin.",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false,
            learningObjectives = listOf(
                "Dart programının başlangıç kapısı olan main() fonksiyonunu anlamak",
                "Metin (String), Tam Sayı (int), Ondalıklı Sayı (double) ve Doğru/Yanlış (bool) tiplerini kullanmak",
                "var, final ve const ile değişken ve sabit tanımlamak",
                "Metinlerin içine değişkenleri (\$isim) pratikçe yerleştirmek"
            ),
            prerequisites = listOf("Ön koşul gerekmez. Kodlama öğrenmeye istekli olmanız yeterlidir!"),
            subtopics = listOf("main() Fonksiyonu ve print()", "Değişkenler Nedir?", "Temel Veri Tipleri", "final ve const Sabitleri", "Metin Birleştirme (String Interpolation)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Programlama Dünyasına Hoş Geldiniz!",
                    body = "Dart, Google tarafından geliştirilen, öğrenmesi çok kolay ve eğlenceli bir dildir. Özellikle tüm dünyada popüler olan mobil uygulama geliştirme aracı **Flutter**'ın temelini oluşturur.\n\nBir Dart programı çalıştırıldığında bilgisayar ilk olarak `main()` isimli fonksiyona bakar. Bunu programın ana giriş kapısı gibi düşünebilirsiniz. Bilgisayara ekranda bir mesaj göstermesini söylemek için `print('...')` komutunu kullanırız.",
                    codeSnippet = "void main() {\n  // Bilgisayara ilk mesajımızı verelim:\n  print('Merhaba Kod Akademi!');\n}",
                    tip = "Dart dilinde yazdığınız her komut satırının sonuna noktalı virgül (;) koymayı unutmayın!"
                ),
                LessonContentBlock(
                    subtitle = "2. Değişkenler: Bilgileri Saklayan Etiketli Kutular",
                    body = "Program yazarken kullanıcı isimleri, yaşlar, puanlar veya fiyatlar gibi bilgileri hafızada tutmamız gerekir. Değişkenleri, üzerine etiket yapıştırdığımız kutular gibi düşünebilirsiniz:\n\n• **String (Metin):** Yazıları tırnak içinde saklar. Örn: `'Ahmet'`, `'Flutter'`\n• **int (Tam Sayı):** Küsuratsız sayılar. Örn: `25`, `100`, `-5`\n• **double (Ondalıklı Sayı):** Noktalı sayılar. Örn: `3.14`, `19.99`\n• **bool (Doğru / Yanlış):** Sadece `true` (evet/doğru) ya da `false` (hayır/yanlış) değerini alır.\n\nEğer değişken tipini tek tek yazmak istemezseniz `var` yazabilirsiniz; Dart içine koyduğunuz değerden tipi otomatik olarak anlar.",
                    codeSnippet = "void main() {\n  String isim = 'Zeynep';\n  int yas = 22;\n  double notOrtalamasi = 3.85;\n  bool mezunMu = false;\n  \n  // Otomatik tip çıkarımı (var):\n  var sehir = 'İzmir'; // Dart bunun yazı olduğunu anlar\n}"
                ),
                LessonContentBlock(
                    subtitle = "3. Sabitler ve Metinlerin İçine Değişken Koyma",
                    body = "Bazen bir bilginin program boyunca hiç değişmemesini isteriz (örneğin Pi sayısı veya doğum yılı). Bunun için `final` veya `const` kelimelerini kullanırız. Bu kutulara bir kez değer koyulduktan sonra bir daha değiştirilemez.\n\nBir metnin içine değişkenin değerini eklemek için dolar işareti (`\$degiskenAdi`) kullanırız. Buna **String Interpolation** denir.",
                    codeSnippet = "void main() {\n  final String ulke = 'Türkiye';\n  const double pi = 3.14;\n  \n  String kullanici = 'Mert';\n  int puan = 95;\n  \n  // \$ işaretiyle metnin içine değişken yerleştirme:\n  print('Tebrikler \$kullanici, puanın: \$puan! (Ülke: \$ulke)');\n}",
                    tip = "Eğer bir işlem yapacaksanız süslü parantez kullanabilirsiniz: print('Gelecek yıl yaşınız: \${yas + 1}');"
                )
            ),
            codeExample = "void main() {\n  String kursAdi = 'Dart ve Flutter';\n  int dersSayisi = 12;\n  double puan = 4.9;\n  bool begenildi = true;\n  \n  print('Kurs: \$kursAdi | \$dersSayisi Ders | Puan: \$puan (Beğenildi: \$begenildi)');\n}",
            codeExplanation = "Metin, tam sayı, ondalıklı sayı ve mantıksal değişkenler tanımlandı ve \$ işaretiyle tek bir cümlede ekrana yazdırıldı.",
            realWorldExample = "Mobil uygulamalarda kullanıcının profil sayfası açıldığında adı, yaşı ve bakiye bilgisi bu değişkenlerde tutulur ve ekrana basılır.",
            practicalTask = "Adınızı ve yaşınızı iki farklı değişkene atayıp, '\$ad \$yas yaşındadır' şeklinde ekrana yazdırın.",
            starterPlaygroundCode = "void main() {\n  String ad = 'Ahmet';\n  int yas = 20;\n  // print ile ekrana yazdırın:\n  \n}",
            miniQuestion = MiniQuestion(
                id = "dart_q_1",
                question = "Dart'ta bir değişkenin değerinin sonradan hiç değiştirilememesini sağlamak için hangi kelime kullanılır?",
                options = listOf("final", "var", "dynamic", "change"),
                correctIndex = 0,
                explanation = "final ve const, değeri sonradan değiştirilemeyen sabit değişkenler tanımlamak için kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_dart_1",
                lessonId = "dart_1",
                title = "Öğrenci Bilgi Kartı",
                instructions = "Öğrencinin adını ve notunu alıp 'Ali: 85 Puan' formatında metin döndüren bilgiKarti() fonksiyonunu yazın.",
                exampleInput = "ad = 'Ali', not = 85",
                exampleOutput = "'Ali: 85 Puan'",
                starterCode = "String bilgiKarti(String ad, int notu) {\n  // Kodunu buraya yaz:\n  return '';\n}",
                solutionCode = "String bilgiKarti(String ad, int notu) {\n  return '\$ad: \$notu Puan';\n}",
                hints = listOf("Dolar (\$ad: \$notu Puan) işaretini kullanarak metni birleştirin."),
                testCases = listOf(
                    TestCase("bilgiKarti('Ali', 85)", "Ali: 85 Puan", "Normal öğrenci kartı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "dart_quiz_1_1",
                    lessonId = "dart_1",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Dart dilinde metin türündeki verileri saklamak için hangi tip kullanılır?",
                    options = listOf("int", "String", "bool", "double"),
                    correctOptionIndex = 1,
                    explanationRight = "Harika! Metinler ve yazılar 'String' türünde saklanır.",
                    explanationWrong = "Metinler için String tipi kullanılır.",
                    reviewTopic = "Dart Veri Tipleri"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "var ile String arasında ne fark vardır?",
                    answer = "'String ad = ...' dediğinizde türü açıkça belirtmiş olursunuz. 'var ad = ...' dediğinizde ise Dart değeri okuyup kendisi String olduğuna karar verir. İkisi de aynı derecede güvenlidir."
                )
            ),
            completionCriteria = listOf(
                "Değişken tanımlamayı ve veri tiplerini öğrenmek",
                "Metin içine değişken yerleştirmeyi (\$isim) yapabilmek",
                "Ekrana print() ile çıktı alabilmek"
            )
        ),

        // ==========================================
        // DERS 2: KOŞULLAR VE DÖNGÜLER
        // ==========================================
        Lesson(
            id = "dart_2",
            courseId = "dart",
            sectionId = "dart_sec_1",
            title = "Karar Verme (if-else) ve Tekrarlar (Döngüler)",
            shortDesc = "Bilgisayara kararlar aldırma (şartlar) ve tekrarlayan işleri döngülerle kolayca yaptırma mantığı.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false,
            learningObjectives = listOf(
                "if, else if ve else ile koşullu kararlar kurmak",
                "Kısa koşul (Ternary ? :) operatörünü kullanmak",
                "for ve while döngüleri ile işlemleri otomatik tekrarlamak",
                "switch-case ile çok seçenekli durumları yönetmek"
            ),
            prerequisites = listOf("Değişkenler ve Veri Tipleri"),
            subtopics = listOf("if-else Karar Blokları", "Kısa Şart (Ternary) Operatörü", "for Döngüsü", "while Döngüsü", "switch-case"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Karar Verme: if ve else",
                    body = "Hayatta olduğu gibi kod yazarken de şartlara göre farklı adımlar atarız. 'Eğer hava yağmurluysa şemsiye al, değilse güneş gözlüğü tak' mantığını `if` ve `else` ile kurarız:\n\n• `if (şart)`: Şart doğruysa bu bloğu çalıştır.\n• `else if (diğer_şart)`: İlk şart tutmadıysa buna bak.\n• `else`: Hiçbiri tutmadıysa bunu yap.",
                    codeSnippet = "void main() {\n  int puan = 75;\n  \n  if (puan >= 85) {\n    print('Harika! Notun: Pekiyi');\n  } else if (puan >= 50) {\n    print('Tebrikler! Geçtin.');\n  } else {\n    print('Üzgünüm, kaldın.');\n  }\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Kısa Şart Operatörü (Ternary ? :)",
                    body = "Tek satırda basit bir karar vermek istediğimizde `şart ? doğruysa : yanlışsa` kalıbı harika bir kolaylık sağlar.",
                    codeSnippet = "int yas = 19;\n// Yaş 18 veya büyükse 'Reşit', değilse 'Çocuk':\nString durum = (yas >= 18) ? 'Reşit' : 'Çocuk';\nprint(durum); // Reşit"
                ),
                LessonContentBlock(
                    subtitle = "3. Döngüler: İşi Bilgisayara Tekrarlatın!",
                    body = "Aynı şeyi 100 kere tek tek yazmak yerine döngü kullanırız:\n\n• **for Döngüsü:** Kaç kere döneceğimizi bildiğimiz durumlar için idealdir.\n• **while Döngüsü:** Belirli bir şart doğru olduğu sürece dönmeye devam eder.",
                    codeSnippet = "void main() {\n  // 1'den 5'e kadar sayalım:\n  for (int i = 1; i <= 5; i++) {\n    print('Sayım: \$i');\n  }\n  \n  // while örneği:\n  int can = 3;\n  while (can > 0) {\n    print('Kalan Can: \$can');\n    can--; // canı 1 azalt\n  }\n}",
                    tip = "Döngülerde sayacı artırmayı veya azaltmayı unutursanız sonsuz döngüye girebilir!"
                )
            ),
            codeExample = "void main() {\n  for (int i = 1; i <= 5; i++) {\n    if (i % 2 == 0) {\n      print('\$i çifttir.');\n    } else {\n      print('\$i tektir.');\n    }\n  }\n}",
            codeExplanation = "1'den 5'e kadar sayılar döngüyle gezilir ve her sayının çift mi tek mi olduğu if-else ile kontrol edilir.",
            realWorldExample = "Alışveriş sepetindeki tüm ürünlerin fiyatını tek tek toplayıp toplam tutarı hesaplarken döngüler kullanılır.",
            practicalTask = "1'den 10'a kadar olan sayılardan sadece çift olanları ekrana yazdıran bir döngü yazın.",
            starterPlaygroundCode = "void main() {\n  for (int i = 1; i <= 10; i++) {\n    // Çift sayıları kontrol edin:\n  }\n}",
            miniQuestion = MiniQuestion(
                id = "dart_q_2",
                question = "Bir döngünün 5 kez dönmesi için başlangıç sayacı 1 iken hangi koşul yazılmalıdır?",
                options = listOf("i <= 5", "i > 5", "i == 0", "i >= 10"),
                correctIndex = 0,
                explanation = "i = 1'den başlayıp i <= 5 olana kadar dönerse toplam 5 kez çalışır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_dart_2",
                lessonId = "dart_2",
                title = "Çift Sayıların Toplamı",
                instructions = "1'den n'e kadar olan çift sayıların toplamını hesaplayan ciftToplami() fonksiyonunu yazın.",
                exampleInput = "n = 6",
                exampleOutput = "12 (2 + 4 + 6)",
                starterCode = "int ciftToplami(int n) {\n  // Kodunu buraya yaz:\n  return 0;\n}",
                solutionCode = "int ciftToplami(int n) {\n  int top = 0;\n  for (int i = 2; i <= n; i += 2) {\n    top += i;\n  }\n  return top;\n}",
                hints = listOf("Döngüyü i = 2'den başlatıp i += 2 ile ikişer ikişer artırabilirsiniz."),
                testCases = listOf(
                    TestCase("ciftToplami(6)", "12", "6 için toplam"),
                    TestCase("ciftToplami(10)", "30", "10 için toplam")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "dart_quiz_2_1",
                    lessonId = "dart_2",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir if şartının içine yazılan kontrol hangi türde bir sonuç üretmelidir?",
                    options = listOf("bool (true/false)", "String", "int", "List"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! if şartı daima doğru (true) veya yanlış (false) bir mantıksal değer bekler.",
                    explanationWrong = "if şartları sadece bool (true/false) değerlerle çalışır.",
                    reviewTopic = "Dart Koşullar"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "for ile while arasında ne fark vardır?",
                    answer = "Kaç adım döneceğiniz belliyse (örn: 10 kere) 'for' döngüsü daha pratiktir. Bir şart sağlanana kadar (örn: kullanıcı çıkış düğmesine basana kadar) beklemek içinse 'while' kullanılır."
                )
            ),
            completionCriteria = listOf(
                "if-else ile şartlı kararlar alabilmek",
                "for ve while döngülerini çalıştırabilmek",
                "Kısa şart (? :) operatörünü anlayabilmek"
            )
        ),

        // ==========================================
        // DERS 3: FONKSİYONLAR VE PARAMETRELER
        // ==========================================
        Lesson(
            id = "dart_3",
            courseId = "dart",
            sectionId = "dart_sec_2",
            title = "Fonksiyonlar: Kodları Paketleyip Yeniden Kullanma",
            shortDesc = "Sürekli aynı kodları yazmak yerine fonksiyon tanımlayın, parametre verin ve sonuç alın.",
            level = CourseLevel.BEGINNER,
            order = 3,
            isPremium = false,
            learningObjectives = listOf(
                "Fonksiyon tanımlamayı ve çağırmayı öğrenmek",
                "Parametre (girdi) gönderme ve return (çıktı) alma mantığını kavramak",
                "İsimlendirilmiş parametreler ({required}) ile okunabilir kod yazmak",
                "Tek satırlık kısa ok (=>) fonksiyonlarını kullanmak"
            ),
            prerequisites = listOf("Değişkenler, Koşullar ve Döngüler"),
            subtopics = listOf("Fonksiyon Nedir?", "Parametre ve Dönüş Değeri", "İsimlendirilmiş Parametreler ({})", "Kısa Ok (=>) Fonksiyonlar"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Fonksiyon Nedir? (Pratik Mutfak Robotu)",
                    body = "Fonksiyonları, içine malzeme (parametre) attığınız ve size hazır bir yemek (dönüş değeri) veren mutfak robotu gibi düşünebilirsiniz.\n\nBir işi bir kere fonksiyon olarak yazarız, sonra programın her yerinde tek satırla tekrar tekrar çağırırız. Böylece kodlarımız hem düzenli kalır hem de gereksiz yere uzamaz.",
                    codeSnippet = "// İki sayıyı toplayıp sonucu veren fonksiyon:\nint topla(int sayi1, int sayi2) {\n  int sonuc = sayi1 + sayi2;\n  return sonuc; // Sonucu geri gönderir\n}\n\nvoid main() {\n  int toplam = topla(15, 25);\n  print('Toplam: \$toplam'); // 40\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. İsimlendirilmiş Parametreler: Flutter'ın Sırrı!",
                    body = "Çok fazla parametre alan fonksiyonlarda hangi değerin ne olduğunu karıştırmamak için süslü parantez `{}` kullanırız. Böylece çağırırken parametrenin adını da yazarız. Flutter'daki tüm buton ve kutucuklar bu yapıyı kullanır!",
                    codeSnippet = "void kullaniciOlustur({\n  required String ad,\n  int yas = 18, // Varsayılan değer\n  String sehir = 'Bilinmiyor',\n}) {\n  print('Kullanıcı: \$ad, Yaş: \$yas, Şehir: \$sehir');\n}\n\nvoid main() {\n  // Sırası önemli değildir, ismiyle çağrılır:\n  kullaniciOlustur(ad: 'Elif', sehir: 'Ankara');\n}",
                    tip = "Parametrenin başına 'required' yazarsanız o bilgiyi vermek zorunlu hale gelir."
                ),
                LessonContentBlock(
                    subtitle = "3. Tek Satırlık Fonksiyonlar (Arrow =>)",
                    body = "Eğer fonksiyonunuz sadece tek bir işlem yapıp sonucunu döndürüyorsa, süslü parantez ve 'return' yazmak yerine pratik ok (`=>`) işaretini kullanabilirsiniz.",
                    codeSnippet = "// Klasik yöntem:\nint carp(int a, int b) {\n  return a * b;\n}\n\n// Pratik Arrow yöntemi (aynı işi yapar):\nint carpPratik(int a, int b) => a * b;"
                )
            ),
            codeExample = "int kareAl(int x) => x * x;\n\nvoid selamVer({required String ad, String unvan = 'Üye'}) {\n  print('Hoş geldin \$unvan \$ad!');\n}\n\nvoid main() {\n  selamVer(ad: 'Can');\n  print('5\\'in karesi: \${kareAl(5)}');\n}",
            codeExplanation = "kareAl tek satırlık ok fonksiyonuyla yazıldı; selamVer ise isimlendirilmiş parametre ile çağrıldı.",
            realWorldExample = "Mobil uygulamada 'Giriş Yap' butonuna basıldığında tetiklenen işlemler bir fonksiyon olarak tanımlanır.",
            practicalTask = "Kullanıcının adını ve soyadını alıp birleştiren tamAd() fonksiyonunu tek satırlık ok (=>) ile yazın.",
            starterPlaygroundCode = "String tamAd(String ad, String soyad) => '';\n\nvoid main() {\n  print(tamAd('Ali', 'Yılmaz'));\n}",
            miniQuestion = MiniQuestion(
                id = "dart_q_3",
                question = "Dart'ta bir fonksiyona parametreleri isimleriyle (örn: ad: 'Ali') göndermek için parametreler hangi parantez içine yazılır?",
                options = listOf("{}", "[]", "()", "<>"),
                correctIndex = 0,
                explanation = "Parametreleri süslü parantez {} içine aldığımızda isimlendirilmiş (named) parametre olurlar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_dart_3",
                lessonId = "dart_3",
                title = "İsimlendirilmiş Selamlayıcı",
                instructions = "Zorunlu 'isim' ve opsiyonel 'selam' parametresi (varsayılan 'Merhaba') alan ve '\$selam, \$isim!' döndüren selamla() fonksiyonunu yazın.",
                exampleInput = "isim: 'Murat'",
                exampleOutput = "'Merhaba, Murat!'",
                starterCode = "String selamla({required String isim, String selam = 'Merhaba'}) {\n  // Kodunu buraya yaz:\n  return '';\n}",
                solutionCode = "String selamla({required String isim, String selam = 'Merhaba'}) {\n  return '\$selam, \$isim!';\n}",
                hints = listOf("String interpolation (\$selam, \$isim!) ile birleştirin."),
                testCases = listOf(
                    TestCase("selamla(isim: 'Murat')", "Merhaba, Murat!", "Varsayılan selam"),
                    TestCase("selamla(isim: 'Ece', selam: 'Günaydın')", "Günaydın, Ece!", "Özel selam")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "dart_quiz_3_1",
                    lessonId = "dart_3",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir fonksiyon hiçbir değer döndürmüyorsa (sadece ekrana yazı yazdırıyorsa) başına hangi kelime yazılır?",
                    options = listOf("void", "int", "null", "empty"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Geriye değer döndürmeyen fonksiyonlar 'void' ile belirtilir.",
                    explanationWrong = "Değer döndürmeyen fonksiyonlar 'void' ile başlar.",
                    reviewTopic = "Dart Fonksiyonlar"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Fonksiyonun dönüş türü neden önemlidir?",
                    answer = "Programın ne tür bir sonuç beklediğini bilmesini sağlar. Örneğin sayı döndürecekse 'int', yazı döndürecekse 'String' yazarız."
                )
            ),
            completionCriteria = listOf(
                "Fonksiyon oluşturup çağırabilmek",
                "İsimlendirilmiş parametreleri ({}) kullanabilmek",
                "Ok (=>) ile tek satırlık fonksiyonlar yazabilmek"
            )
        ),

        // ==========================================
        // DERS 4: LİSTELER, KÜMELER VE SÖZLÜKLER (List, Set, Map)
        // ==========================================
        Lesson(
            id = "dart_4",
            courseId = "dart",
            sectionId = "dart_sec_2",
            title = "Koleksiyonlar: Listeler, Kümeler ve Sözlükler",
            shortDesc = "Birden fazla bilgiyi düzenli bir alışveriş listesi veya telefon rehberi gibi saklama yöntemleri.",
            level = CourseLevel.BEGINNER,
            order = 4,
            isPremium = true,
            learningObjectives = listOf(
                "List (Dizi/Liste) ile sırayla eleman saklamak ve elemanlara erişmek",
                "Set (Küme) ile tekrar etmeyen benzersiz elemanlar tutmak",
                "Map (Sözlük) ile anahtar-değer (Key-Value) ikilileri oluşturmak",
                "where() ve map() ile listeleri kolayca filtrelemek"
            ),
            prerequisites = listOf("Değişkenler ve Fonksiyonlar"),
            subtopics = listOf("List (Sıralı Liste)", "Set (Tekil Küme)", "Map (Anahtar-Değer)", "Listeleri Filtreleme (where, map)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Listeler: Alışveriş Listesi Gibi!",
                    body = "Tek bir değişkende sadece 1 isim tutabilirken, `List` ile yüzlerce ismi sırayla saklayabiliriz. Listenin ilk elemanının indeksi her zaman `0`'dır.",
                    codeSnippet = "void main() {\n  List<String> meyveler = ['Elma', 'Muz', 'Çilek'];\n  \n  print(meyveler[0]); // Elma (ilk eleman)\n  \n  meyveler.add('Portakal'); // Yeni eleman ekler\n  print('Toplam meyve: \${meyveler.length}'); // 4\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Set (Küme) ve Map (Sözlük)",
                    body = "• **Set (Küme):** Tıpkı matematikteki kümeler gibi içinde aynı elemandan birden fazla bulunamaz. Tekrar edenleri otomatik eler.\n• **Map (Sözlük / Telefon Rehberi):** Her bilgiye bir isim (anahtar) vererek saklarız. Örneğin 'ad' -> 'Ahmet', 'yas' -> 25.",
                    codeSnippet = "// Set örneği (aynı eleman iki kez girilse de tek kalır):\nSet<int> sayilar = {1, 2, 2, 3};\nprint(sayilar); // {1, 2, 3}\n\n// Map örneği (Telefon rehberi gibi):\nMap<String, String> baskentler = {\n  'TR': 'Ankara',\n  'FR': 'Paris',\n  'DE': 'Berlin'\n};\nprint(baskentler['TR']); // Ankara"
                ),
                LessonContentBlock(
                    subtitle = "3. Pratik Liste İşleme: where ve map",
                    body = "Bir listedeki sadece belirli elemanları seçmek için `where` (filtrele), elemanların hepsini değiştirmek için `map` (dönüştür) kullanırız.",
                    codeSnippet = "final sayilar = [1, 2, 3, 4, 5, 6];\n\n// Çift sayıları seç ve karelerini al:\nfinal ciftKareler = sayilar\n    .where((s) => s % 2 == 0) // [2, 4, 6]\n    .map((s) => s * s)        // [4, 16, 36]\n    .toList();\n\nprint(ciftKareler); // [4, 16, 36]",
                    tip = "where() ve map() sonuna .toList() ekleyerek sonucu tekrar normal listeye çevirebilirsiniz."
                )
            ),
            codeExample = "void main() {\n  final sehirler = ['İstanbul', 'Ankara', 'İzmir', 'Bursa'];\n  \n  // 'İ' ile başlayanları filtreleyelim:\n  final iIleBaslayanlar = sehirler.where((s) => s.startsWith('İ')).toList();\n  print('İ ile başlayanlar: \$iIleBaslayanlar');\n}",
            codeExplanation = "List.where metodu listedeki her şehri kontrol eder ve şartı sağlayanları yeni bir liste yapar.",
            realWorldExample = "E-ticaret uygulamasında ürünleri 'Fiyata Göre Filtrele' veya 'Kategoriye Göre Seç' yaparken where() kullanılır.",
            practicalTask = "Bir sayı listesindeki sadece pozitif (> 0) sayıları filtreleyip ekrana yazdırın.",
            starterPlaygroundCode = "void main() {\n  final liste = [-5, 10, -2, 8, 0, 15];\n  // Pozitifleri filtreleyin:\n  \n}",
            miniQuestion = MiniQuestion(
                id = "dart_q_4",
                question = "Dart'ta bir listede ilk elemana ulaşmak için hangi indeks numarası yazılır?",
                options = listOf("0", "1", "-1", "first"),
                correctIndex = 0,
                explanation = "Programlamada liste indeksleri daima 0'dan başlar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_dart_4",
                lessonId = "dart_4",
                title = "Pozitif Sayıları Filtrele ve İki Katına Çıkar",
                instructions = "Verilen tam sayı listesindeki sadece pozitif (> 0) sayıları seçip iki katını liste olarak döndüren filtreleVeKatla() fonksiyonunu yazın.",
                exampleInput = "[-2, 5, -1, 3, 0]",
                exampleOutput = "[10, 6]",
                starterCode = "List<int> filtreleVeKatla(List<int> sayilar) {\n  // Kodunu buraya yaz:\n  return [];\n}",
                solutionCode = "List<int> filtreleVeKatla(List<int> sayilar) {\n  return sayilar.where((n) => n > 0).map((n) => n * 2).toList();\n}",
                hints = listOf("where((n) => n > 0) ve map((n) => n * 2).toList() kullanın."),
                testCases = listOf(
                    TestCase("filtreleVeKatla([-2, 5, -1, 3])", "[10, 6]", "Pozitifleri katla")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "dart_quiz_4_1",
                    lessonId = "dart_4",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "İçinde tekrar eden (çift) eleman barındırmayan koleksiyon türü hangisidir?",
                    options = listOf("Set", "List", "Map", "Array"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Set (Küme) her elemandan yalnızca 1 tane tutar.",
                    explanationWrong = "Tekrarsız koleksiyon Set'tir.",
                    reviewTopic = "Dart Koleksiyonlar"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Map ile List arasındaki fark nedir?",
                    answer = "List'te elemanlara sıra numarasıyla (0, 1, 2) ulaşılır. Map'te ise elemanlara istediğiniz bir isimle (örneğin 'kullanici_adi') ulaşılır."
                )
            ),
            completionCriteria = listOf(
                "List, Set ve Map oluşturabilmek",
                "Listenin ilk elemanının indeksinin 0 olduğunu bilmek",
                "where ve map ile filtreleme yapabilmek"
            )
        ),

        // ==========================================
        // DERS 5: GÜVENLİ KOD YAZMA (Null Safety)
        // ==========================================
        Lesson(
            id = "dart_5",
            courseId = "dart",
            sectionId = "dart_sec_2",
            title = "Null Safety: Çökmeyen Güvenli Kodlar Yazmak",
            shortDesc = "Uygulamaların çökmesine yol açan 'boş değer' hatalarını Dart'ın akıllı koruma kalkanıyla önleyin.",
            level = CourseLevel.BEGINNER,
            order = 5,
            isPremium = true,
            learningObjectives = listOf(
                "Null (boş/tanımsız değer) kavramını ve risklerini anlamak",
                "Soru işareti (?) ile boş kalabilecek değişkenleri belirtmek",
                "Null kontrol operatörleri (?., ??, ??=) ile çökme riskini sıfıra indirmek",
                "late anahtar kelimesi ile sonradan değer atamayı yönetmek"
            ),
            prerequisites = listOf("Değişkenler ve Fonksiyonlar"),
            subtopics = listOf("Null Nedir?", "Boş Olabilir (?) Belirteci", "Varsayılan Değer Operatörü (??)", "Güvenli Çağrı (?.)", "late Anahtarı"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Null Nedir? (Boş Kutu)",
                    body = "Programlamada `null`, 'bu kutunun içinde hiçbir şey yok, içi bomboş' demektir. Eğer içi boş bir kutuyu açıp kullanmaya çalışırsanız uygulamanız çöker.\n\nDart, sizi bu hatadan korumak için **Sound Null Safety** özelliğine sahiptir. Dart'ta varsayılan olarak hiçbir değişken boş (null) kalamaz. Eğer bilerek boş kalmasına izin vermek istiyorsanız tipin sonuna soru işareti (`?`) koyarsınız.",
                    codeSnippet = "// Bu değişken asla null olamaz (Hata vermez, güvenlidir):\nString isim = 'Ali';\n// isim = null; -> HATA! Derleyici izin vermez.\n\n// Soru işareti (?) sayesinde bu değişken null olabilir:\nString? ikinciIsim = null; // Geçerli ve güvenli"
                ),
                LessonContentBlock(
                    subtitle = "2. Süper Kurtarıcı Operatörler: ?. ve ??",
                    body = "• `?.` (Güvenli Çağrı): Değişken null değilse çalıştır, null ise çökme, sadece null döndür.\n• `??` (Varsayılan Değer): Eğer sol taraf null ise sağdaki varsayılan değeri kullan.\n• `!` (Zorlama): 'Dart sana söz veriyorum bu değişken kesinlikle boş değil' demektir (Dikkatli kullanılmalıdır!).",
                    codeSnippet = "String? kullaniciAdi = null;\n\n// Eğer null ise 'Misafir' yaz:\nString gorunenIsim = kullaniciAdi ?? 'Misafir';\nprint('Hoş geldin, \$gorunenIsim!'); // Hoş geldin, Misafir!\n\n// Güvenli uzunluk alma:\nprint(kullaniciAdi?.length); // null döner, asla çökmez!",
                    tip = "?? operatörü, internetten veri gelmediğinde kullanıcıya 'Bilinmiyor' veya 'Varsayılan İsim' göstermek için çok kullanışlıdır."
                ),
                LessonContentBlock(
                    subtitle = "3. 'late' ile Değeri Sonradan Verme",
                    body = "Bazen bir değişkenin null olmasını istemezsiniz ama ilk anda da değerini henüz bilmiyorsunuzdur (örneğin ekrandan butonla girilecek). Başına `late` koyarak 'Bu değişkeni birazdan dolduracağım' sözü verirsiniz.",
                    codeSnippet = "late String profilResmi;\n\nvoid resimYukle() {\n  profilResmi = 'avatar.png'; // Biraz sonra dolduruldu\n  print('Resim hazır: \$profilResmi');\n}"
                )
            ),
            codeExample = "void main() {\n  String? telefon = null;\n  \n  // Telefon varsa onu, yoksa 'Belirtilmedi' yazdır:\n  String bilgi = telefon ?? 'Telefon Numarası Belirtilmedi';\n  print(bilgi);\n}",
            codeExplanation = "?? operatörü sayesinde telefon değişkeni null olduğu için uygulama çökmedi ve yedek metin devreye girdi.",
            realWorldExample = "Kullanıcı profilinde ikinci soyadı veya sabit telefon alanı boş bırakıldığında uygulamanın çökmesini engeller.",
            practicalTask = "Boş (null) olabilen bir metin değişkeni tanımlayın ve ?? operatörüyle boşsa 'Varsayılan Metin' yazdırın.",
            starterPlaygroundCode = "void main() {\n  String? mesaj = null;\n  // ?? kullanarak ekrana yazdırın:\n  \n}",
            miniQuestion = MiniQuestion(
                id = "dart_q_5",
                question = "Dart'ta bir değişkenin null (boş) değer alabilmesi için tipinin sonuna hangi işaret konur?",
                options = listOf("?", "!", "#", "&"),
                correctIndex = 0,
                explanation = "Tipin sonuna soru işareti (?) konulduğunda (örn: String?) o değişken null alabilir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_dart_5",
                lessonId = "dart_5",
                title = "Güvenli Metin Uzunluğu",
                instructions = "Null gelebilecek bir String alıp, metin varsa uzunluğunu, metin null ise 0 döndüren guvenliUzunluk() fonksiyonunu yazın.",
                exampleInput = "metin = 'Flutter'",
                exampleOutput = "7",
                starterCode = "int guvenliUzunluk(String? metin) {\n  // Kodunu buraya yaz:\n  return 0;\n}",
                solutionCode = "int guvenliUzunluk(String? metin) {\n  return metin?.length ?? 0;\n}",
                hints = listOf("metin?.length ?? 0 ifadesini kullanın."),
                testCases = listOf(
                    TestCase("guvenliUzunluk('Dart')", "4", "Dolu metin"),
                    TestCase("guvenliUzunluk(null)", "0", "Null metin")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "dart_quiz_5_1",
                    lessonId = "dart_5",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "String? ad = null; print(ad ?? 'Misafir'); kodunun ekran çıktısı ne olur?",
                    options = listOf("Misafir", "null", "Hata verir", "ad"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! 'ad' değişkeni null olduğu için ?? operatörü sağdaki 'Misafir' değerini verir.",
                    explanationWrong = "ad null olduğu için yedek değer olan 'Misafir' yazılır.",
                    reviewTopic = "Dart Null Safety"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Neden her değişkeni String? yapmıyoruz?",
                    answer = "Çünkü her değişkenin boş kalabilmesi kodlarınızı karmaşıklaştırır ve sürekli kontrol yazmanızı gerektirir. Gerçekten boş kalması gerekenler dışında tüm değişkenleri normal (non-null) tutmak en temiz yoldur."
                )
            ),
            completionCriteria = listOf(
                "Null kavramını ve ? işaretini öğrenmek",
                "?? ile yedek/varsayılan değer atayabilmek",
                "?. ile güvenli metot çağırmayı kavramak"
            )
        ),

        // ==========================================
        // DERS 6: SINIFLAR VE NESNELER (OOP)
        // ==========================================
        Lesson(
            id = "dart_6",
            courseId = "dart",
            sectionId = "dart_sec_3",
            title = "Sınıflar ve Nesneler: Gerçek Dünyayı Modelleme",
            shortDesc = "Kek kalıbı ve kek ilişkisi! Sınıf (Class) kurup ondan nesneler (Objects) üretme sanatı.",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true,
            learningObjectives = listOf(
                "Sınıf (Class) ve Nesne (Object) mantığını gerçek hayattan örneklerle kavramak",
                "Kurucu metot (Constructor) ile nesneleri kolayca oluşturmak",
                "Sınıf içi fonksiyonlar (Metotlar) yazmak",
                "Gizli (private _) değişkenlerle bilgileri korumak"
            ),
            prerequisites = listOf("Fonksiyonlar ve Koleksiyonlar"),
            subtopics = listOf("Sınıf Nedir? (Kalıp)", "Nesne Üretme", "Kurucu Metot (Constructor)", "Metotlar ve Yetenekler"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Sınıf ve Nesne Nedir? (Kurabiye Kalıbı)",
                    body = "Gerçek hayattaki nesneleri (örneğin bir Araba, Kullanıcı, Ürün) kodla ifade etmek için `class` (sınıf) kullanırız.\n\n• **Sınıf (Class):** Kurabiye kalıbıdır. Hangi özelliklerin olacağını belirler.\n• **Nesne (Object):** O kalıptan çıkan kurabiyelerdir. Örneğin 'Araba' kalıbından üretilen 'Kırmızı BMW' ve 'Mavi Toyota' birer nesnedir.",
                    codeSnippet = "class Araba {\n  String marka;\n  int modelYili;\n  \n  // Kurucu Metot (Constructor):\n  Araba(this.marka, this.modelYili);\n  \n  // Arabanın bir yeteneği (Metot):\n  void calistir() {\n    print('\$marka motoru çalıştı! Vrooom!');\n  }\n}\n\nvoid main() {\n  // Nesne üretelim:\n  Araba arabam = Araba('Toyota', 2022);\n  arabam.calistir(); // Toyota motoru çalıştı!\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. İsimlendirilmiş Kurucular (Named Constructors)",
                    body = "Bazen bir nesneyi farklı yollarla oluşturmak isteriz (örneğin internetten gelen veriden veya sıfır başlangıçla). Bunun için sınıfa ek kurucular yazabiliriz.",
                    codeSnippet = "class Oyuncu {\n  String ad;\n  int puan;\n  \n  // Standart kurucu:\n  Oyuncu(this.ad, this.puan);\n  \n  // Başlangıç oyuncusu kurucusu (0 puanla başlar):\n  Oyuncu.yeniBaslayan(this.ad) : puan = 0;\n}\n\nvoid main() {\n  var yeniOyuncu = Oyuncu.yeniBaslayan('Ahmet');\n  print('\${yeniOyuncu.ad} Puanı: \${yeniOyuncu.puan}'); // 0\n}",
                    tip = "Dart'ta yeni bir nesne oluştururken 'new' kelimesini yazmanıza gerek yoktur."
                )
            ),
            codeExample = "class Ogrenci {\n  String ad;\n  int notu;\n  \n  Ogrenci(this.ad, this.notu);\n  \n  bool gectiMi() => notu >= 50;\n}\n\nvoid main() {\n  var ogr = Ogrenci('Merve', 85);\n  print('\${ogr.ad} Geçti mi? \${ogr.gectiMi()}');\n}",
            codeExplanation = "Ogrenci sınıfı oluşturuldu, kurucu metotla bilgileri dolduruldu ve gectiMi metoduyla sonucu test edildi.",
            realWorldExample = "Instagram'da her bir gönderi (Post) başlık, fotoğraf linki ve beğeni sayısını tutan bir Post sınıfının nesnesidir.",
            practicalTask = "BankaHesabi adında bir sınıf oluşturup içine bakiye değişkeni ve paraYatir(miktar) fonksiyonu ekleyin.",
            starterPlaygroundCode = "class BankaHesabi {\n  double bakiye = 0;\n  // paraYatir metodunu ekleyin:\n}\n\nvoid main() {\n  var hesap = BankaHesabi();\n}",
            miniQuestion = MiniQuestion(
                id = "dart_q_6",
                question = "Dart'ta bir sınıfın değişkenini veya metodunu sadece o dosyaya özel (private) yapmak için başına hangi işaret konur?",
                options = listOf("_ (alt çizgi)", "private", "#", "@"),
                correctIndex = 0,
                explanation = "Dart'ta başına alt çizgi konulan isimler (örn: _sifre) private olur."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_dart_6",
                lessonId = "dart_6",
                title = "Kitap Sınıfı ve Özeti",
                instructions = "baslik ve yazar alanlarına sahip Kitap sınıfını yazın ve 'Başlık - Yazar' formatında metin veren ozet() metodunu ekleyin.",
                exampleInput = "Kitap('Simyacı', 'Paulo Coelho')",
                exampleOutput = "'Simyacı - Paulo Coelho'",
                starterCode = "class Kitap {\n  String baslik;\n  String yazar;\n  \n  Kitap(this.baslik, this.yazar);\n  \n  String ozet() {\n    // Kodunu yaz:\n    return '';\n  }\n}",
                solutionCode = "class Kitap {\n  String baslik;\n  String yazar;\n  \n  Kitap(this.baslik, this.yazar);\n  \n  String ozet() => '\$baslik - \$yazar';\n}",
                hints = listOf("'\$baslik - \$yazar' metnini döndürün."),
                testCases = listOf(
                    TestCase("Kitap('1984', 'George Orwell').ozet()", "1984 - George Orwell", "Kitap özeti")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "dart_quiz_6_1",
                    lessonId = "dart_6",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir sınıftan yeni bir örnek (nesne) oluşturulduğunda ilk çalışan özel metoda ne denir?",
                    options = listOf("Constructor (Kurucu Metot)", "Destructor", "main()", "Getter"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Kurucu metotlar (Constructor) nesne ilk doğduğu an çalışır.",
                    explanationWrong = "Nesne oluşturulurken Constructor (Kurucu) çalışır.",
                    reviewTopic = "Dart Sınıflar"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Neden nesne yönelimli programlama kullanıyoruz?",
                    answer = "Büyük projelerde binlerce satır kodu düzenli parçalara bölmek, birbiriyle mantıklı ilişkilendirmek ve kod tekrarını önlemek için OOP en yaygın yaklaşımdır."
                )
            ),
            completionCriteria = listOf(
                "Class ve Object farkını anlamak",
                "Constructor yazıp nesne oluşturabilmek",
                "Sınıf içine yetenek (metot) ekleyebilmek"
            )
        ),

        // ==========================================
        // DERS 7: KALITIM VE SOYUT SINIFLAR
        // ==========================================
        Lesson(
            id = "dart_7",
            courseId = "dart",
            sectionId = "dart_sec_3",
            title = "Kalıtım (extends) ve Arayüzler: Kodları Miras Alma",
            shortDesc = "Ortak özellikleri baştan yazmak yerine üst sınıftan miras alın ve kendi yeteneklerinizi ekleyin.",
            level = CourseLevel.INTERMEDIATE,
            order = 7,
            isPremium = true,
            learningObjectives = listOf(
                "Kalıtım (extends) ile ortak kodları tek yerde toplamak",
                "super anahtarı ile üst sınıfın kurucusuna ulaşmak",
                "@override ile miras alınan yeteneği özelleştirmek",
                "Soyut sınıflar (abstract class) ile sözleşmeler tanımlamak"
            ),
            prerequisites = listOf("Sınıflar ve Kurucu Metotlar"),
            subtopics = listOf("Kalıtım (extends) Nedir?", "super ve @override", "Soyut Sınıf (abstract class)", "implements Arayüzleri"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Kalıtım Nedir? (Anne-Baba ve Çocuk)",
                    body = "Diyelim ki bir Hayvan sınıfımız var (adı, yaşı, yemekYeme metodu var). Kedi ve Köpek sınıfları da birer hayvandır. Ortak özellikleri tek tek her sınıfa kopyalamak yerine, Hayvan sınıfından miras (`extends`) alırız.",
                    codeSnippet = "class Hayvan {\n  String isim;\n  Hayvan(this.isim);\n  \n  void sesCikar() {\n    print('Bir ses çıkarıldı.');\n  }\n}\n\n// Hayvan sınıfının tüm özelliklerini miras alan Kopek sınıfı:\nclass Kopek extends Hayvan {\n  Kopek(String isim) : super(isim); // Üst sınıfa ismi gönderir\n  \n  @override\n  void sesCikar() {\n    print('\$isim: Hav hav!'); // Miras alınan sesi özelleştirdik\n  }\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Soyut Sınıf (abstract class): Bir Görev Şablonu",
                    body = "Soyut bir sınıftan doğrudan nesne üretilemez; o sadece alt sınıfların uyması gereken zorunlu bir plan veya kural listesidir.",
                    codeSnippet = "abstract class Sekil {\n  double alanHesapla(); // Gövdesi yok, alt sınıflar doldurmak ZORUNDA\n}\n\nclass Kare extends Sekil {\n  double kenar;\n  Kare(this.kenar);\n  \n  @override\n  double alanHesapla() => kenar * kenar;\n}"
                )
            ),
            codeExample = "void main() {\n  var kopek = Kopek('Karabaş');\n  kopek.sesCikar(); // Karabaş: Hav hav!\n}",
            codeExplanation = "Kopek sınıfı Hayvan sınıfından türetildi ve sesCikar metodu @override edilerek köpeğe uyarlandı.",
            realWorldExample = "Flutter'daki StatelessWidget ve StatefulWidget sınıfları, Flutter motorunun temel Widget sınıfından türetilmiştir.",
            practicalTask = "Calisan adında bir üst sınıf ve ondan türeyen Yazilimci sınıfı oluşturun.",
            starterPlaygroundCode = "class Calisan {\n  String ad;\n  Calisan(this.ad);\n}\n// Yazilimci sınıfını extends edin:\n",
            miniQuestion = MiniQuestion(
                id = "dart_q_7",
                question = "Dart'ta bir sınıfın başka bir sınıfın özelliklerini miras alması için hangi kelime kullanılır?",
                options = listOf("extends", "implements", "with", "inherits"),
                correctIndex = 0,
                explanation = "Bir üst sınıftan miras almak için 'extends' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_dart_7",
                lessonId = "dart_7",
                title = "Kare Alanı Hesaplayıcı",
                instructions = "Sekil üst sınıfından türeyen ve alan() metodunu 'kenar * kenar' olarak hesaplayan Kare sınıfını yazın.",
                exampleInput = "Kare(4).alan()",
                exampleOutput = "16",
                starterCode = "abstract class Sekil {\n  double alan();\n}\n\nclass Kare extends Sekil {\n  double kenar;\n  Kare(this.kenar);\n  \n  @override\n  double alan() {\n    // Kodunu yaz:\n    return 0;\n  }\n}",
                solutionCode = "abstract class Sekil {\n  double alan();\n}\n\nclass Kare extends Sekil {\n  double kenar;\n  Kare(this.kenar);\n  \n  @override\n  double alan() => kenar * kenar;\n}",
                hints = listOf("kenar * kenar çarpımını döndürün."),
                testCases = listOf(
                    TestCase("Kare(5).alan()", "25.0", "5 kenarlı kare")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "dart_quiz_7_1",
                    lessonId = "dart_7",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Üst sınıftan miras alınan bir metodun davranışını değiştirmek için metodun üzerine ne yazılır?",
                    options = listOf("@override", "@new", "@super", "@change"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Üst metodun üzerine yazarken @override notasyonu kullanılır.",
                    explanationWrong = "Metot ezme işlemi için @override kullanılır.",
                    reviewTopic = "Dart Kalıtım"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "abstract class'tan neden nesne üretilemez?",
                    answer = "Çünkü içinde henüz nasıl çalışacağı yazılmamış yarım metotlar bulunabilir. Tamamlanması alt sınıflara bırakılmıştır."
                )
            ),
            completionCriteria = listOf(
                "extends ile kalıtım yapabilmek",
                "super() ile üst sınıfa parametre aktarmak",
                "@override ile metotları özelleştirebilmek"
            )
        ),

        // ==========================================
        // DERS 8: MODERN DART (Mixin ve Extensions)
        // ==========================================
        Lesson(
            id = "dart_8",
            courseId = "dart",
            sectionId = "dart_sec_4",
            title = "Modern Dart: Mixin'ler ve Uzantılar (Extensions)",
            shortDesc = "Sınıflara süper güçler ekleyin: Mixin ile yetenek paylaşımı ve Extension ile hazır sınıfları genişletme.",
            level = CourseLevel.INTERMEDIATE,
            order = 8,
            isPremium = true,
            learningObjectives = listOf(
                "Mixin (with) ile sınıflara tak-çıkar yetenekler eklemek",
                "Extension Methods ile String veya int sınıflarına yeni fonksiyonlar kazandırmak",
                "Dart 3 Records ile tek seferde birden çok değer döndürmek"
            ),
            prerequisites = listOf("Sınıflar ve Kalıtım"),
            subtopics = listOf("Mixin Nedir? (with)", "Extension Methods", "Dart 3 Records"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Mixin: Tak-Çıkar Süper Güçler (with)",
                    body = "Kalıtımda bir çocuk sadece bir anne-babaya sahip olabilir. Ancak bir sınıfa birden fazla bağımsız yetenek (örneğin Uçabilme, Yüzebilme, Loglama) takmak istersek `mixin` kullanırız. Sınıfa `with` kelimesiyle eklenir.",
                    codeSnippet = "mixin Ucabilen {\n  void uc() => print('Gökyüzünde süzülüyor! 🦅');\n}\n\nmixin Yuzebilen {\n  void yuz() => print('Denizde yüzüyor! 🐬');\n}\n\n// Ördek hem uçar hem yüzer:\nclass Ordek with Ucabilen, Yuzebilen {}\n\nvoid main() {\n  var ordek = Ordek();\n  ordek.uc();\n  ordek.yuz();\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Extension Methods: Hazır Sınıflara Yeni Güçler!",
                    body = "Dart'ın kendi `String` veya `int` sınıfının kaynak kodunu değiştiremezsiniz; ama ona kendi yazdığınız fonksiyonları sanki orijinalinde varmış gibi ekleyebilirsiniz!",
                    codeSnippet = "extension MetinGelistirici on String {\n  // İlk harfi büyük yapma fonksiyonu:\n  String ilkHarfBuyuk() {\n    if (isEmpty) return this;\n    return this[0].toUpperCase() + substring(1);\n  }\n}\n\nvoid main() {\n  String isim = 'ahmet';\n  print(isim.ilkHarfBuyuk()); // 'Ahmet'\n}"
                ),
                LessonContentBlock(
                    subtitle = "3. Dart 3 Records: Çoklu Değer Döndürme",
                    body = "Bir fonksiyondan hem adı hem yaşı aynı anda döndürmek için eskiden ayrı bir sınıf yazmak gerekirdi. Artık `(String, int)` şeklinde parantez içinde döndürebilirsiniz!",
                    codeSnippet = "(String, int) kullaniciVerisiAl() {\n  return ('Zeynep', 24);\n}\n\nvoid main() {\n  var (isim, yas) = kullaniciVerisiAl();\n  print('\$isim \$yas yaşındadır.');\n}"
                )
            ),
            codeExample = "mixin Caliskan {\n  void calis() => print('Sıkı çalışıyor! 💻');\n}\n\nclass Gelistirici with Caliskan {}\n\nvoid main() {\n  var dev = Gelistirici();\n  dev.calis();\n}",
            codeExplanation = "Gelistirici sınıfına Caliskan mixin'i with ile eklendi ve metodu doğrudan çağrıldı.",
            realWorldExample = "Flutter animasyonlarında sayfaya animasyon yeteneği kazandırmak için `with SingleTickerProviderStateMixin` kullanılır.",
            practicalTask = "String sınıfına ünlem ekleyen 'unlemEkle()' uzantısı (extension) yazın.",
            starterPlaygroundCode = "extension Unlem on String {\n  // unlemEkle fonksiyonunu yazın:\n}\n\nvoid main() {\n  print('Merhaba'.unlemEkle()); // Merhaba!\n}",
            miniQuestion = MiniQuestion(
                id = "dart_q_8",
                question = "Dart'ta bir sınıfa mixin eklemek için hangi anahtar kelime kullanılır?",
                options = listOf("with", "extends", "implements", "using"),
                correctIndex = 0,
                explanation = "Mixin'ler sınıflara 'with' anahtarı ile dahil edilir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_dart_8",
                lessonId = "dart_8",
                title = "String Ünlem Uzantısı",
                instructions = "String sınıfı üzerine bu metnin sonuna '!' ekleyen unlemEkle() extension fonksiyonunu yazın.",
                exampleInput = "'Selam'.unlemEkle()",
                exampleOutput = "'Selam!'",
                starterCode = "extension Unlem on String {\n  String unlemEkle() {\n    // Kodunu yaz:\n    return '';\n  }\n}",
                solutionCode = "extension Unlem on String {\n  String unlemEkle() => '\$this!';\n}",
                hints = listOf("'\$this!' ifadesini döndürün."),
                testCases = listOf(
                    TestCase("'Kod'.unlemEkle()", "Kod!", "Ünlem ekleme")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "dart_quiz_8_1",
                    lessonId = "dart_8",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Extension Methods hangi amaçla kullanılır?",
                    options = listOf("Mevcut sınıflara kaynak koduna dokunmadan yeni metotlar eklemek için", "Uygulamayı hızlandırmak için", "Sadece sayıları toplamak için", "Değişkenleri silmek için"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Extension'lar mevcut tiplere pratik yeni yetenekler katar.",
                    explanationWrong = "Extension Methods var olan sınıflara yeni metot ekler.",
                    reviewTopic = "Dart Extensions"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Mixin ile Normal Sınıf arasındaki fark nedir?",
                    answer = "Mixin'lerin kurucu metodu (constructor) olamaz ve doğrudan nesnesi üretilemez. Yalnızca başka sınıflara yetenek katmak için var olurlar."
                )
            ),
            completionCriteria = listOf(
                "Mixin mantığını ve 'with' kullanımını kavramak",
                "Extension yazarak sınıflara yeni metot kazandırmak",
                "Dart 3 Records ile çoklu değer alabilmek"
            )
        ),

        // ==========================================
        // DERS 9: ASENKRON PROGRAMLAMA (Future & async/await)
        // ==========================================
        Lesson(
            id = "dart_9",
            courseId = "dart",
            sectionId = "dart_sec_5",
            title = "Asenkron Programlama: async ve await ile Donmayan Uygulamalar",
            shortDesc = "İnternetten veri çekerken veya dosya okurken ekranın kilitlenmesini engelleyin.",
            level = CourseLevel.ADVANCED,
            order = 9,
            isPremium = true,
            learningObjectives = listOf(
                "Asenkron çalışmanın ne olduğunu ve neden gerekli olduğunu anlamak",
                "Future (Gelecekten Gelen Veri) kavramını kavramak",
                "async ve await ile bekleme işlemlerini kolayca yönetmek",
                "İnternetten veri çekme simülasyonu yapmak"
            ),
            prerequisites = listOf("Fonksiyonlar ve Sınıflar"),
            subtopics = listOf("Asenkron Nedir?", "Future Mimarisi", "async ve await", "Hata Yönetimi (try-catch)"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Asenkron Nedir? (Kahve Sırası Örneği)",
                    body = "Bir kafede kahve siparişi verdiğinizi düşünün. Kahveniz hazırlanırken kasanın önünde heykel gibi dikilip arkadaki herkesi bekletmezsiniz; sipariş fişinizi alır bir masaya oturursunuz. Kahve hazır olduğunda adınız çağrılır.\n\nİşte internetten fotoğraf indirirken veya veritabanından kullanıcı çekerken ekranın donmaması için **asenkron** kod yazarız. Uygulama arka planda veriyi beklerken kullanıcı arayüzü akıcı şekilde çalışmaya devam eder.",
                    codeSnippet = "// 2 saniye süren sahte bir internet isteği:\nFuture<String> veriGetir() async {\n  await Future.delayed(Duration(seconds: 2));\n  return 'İnternetten gelen kullanıcı profili 👤';\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. async ve await ile Kolay Okunan Kodlar",
                    body = "• `async`: 'Bu fonksiyonun içinde zaman alan bir bekleme olacak' demektir.\n• `await`: 'Bu işlem bitene kadar bekle ama ekranı dondurma' demektir.",
                    codeSnippet = "void main() async {\n  print('1. İstek gönderildi...');\n  \n  String sonuc = await veriGetir(); // Sonuç gelene kadar bekler\n  \n  print('2. Gelen Veri: \$sonuc');\n  print('3. İşlem tamam!');\n}"
                )
            ),
            codeExample = "Future<int> bakiyeSorgula() async {\n  await Future.delayed(Duration(milliseconds: 500));\n  return 1500;\n}\n\nvoid main() async {\n  print('Bakiye sorgulanıyor...');\n  int bakiye = await bakiyeSorgula();\n  print('Güncel Bakiye: \$bakiye TL');\n}",
            codeExplanation = "bakiyeSorgula fonksiyonu Future döndürür, main içinde await ile beklenir ve değer ekrana basılır.",
            realWorldExample = "Mobil bankacılık uygulamasında hesap hareketlerini çekerken döner tekerlek (loading) gösterilip veriler await ile beklenir.",
            practicalTask = "2 saniye bekleyip 'Giriş Başarılı' metnini döndüren bir asenkron fonksiyon yazın.",
            starterPlaygroundCode = "Future<String> girisYap() async {\n  // Future.delayed ile 2 saniye bekleyin:\n  return 'Giriş Başarılı';\n}\n\nvoid main() async {\n  print(await girisYap());\n}",
            miniQuestion = MiniQuestion(
                id = "dart_q_9",
                question = "Dart'ta zaman alan bir Future işleminin sonucunu beklemek için hangi kelime kullanılır?",
                options = listOf("await", "wait", "async", "pause"),
                correctIndex = 0,
                explanation = "Bir Future'ın tamamlanmasını beklemek için başına 'await' yazılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_dart_9",
                lessonId = "dart_9",
                title = "Asenkron Selamlama",
                instructions = "1 saniye bekledikten sonra 'Hoş geldin, \$isim!' döndüren asenkronSelam() fonksiyonunu yazın.",
                exampleInput = "asenkronSelam('Merve')",
                exampleOutput = "'Hoş geldin, Merve!'",
                starterCode = "Future<String> asenkronSelam(String isim) async {\n  // Kodunu yaz:\n  return '';\n}",
                solutionCode = "Future<String> asenkronSelam(String isim) async {\n  await Future.delayed(Duration(milliseconds: 10));\n  return 'Hoş geldin, \$isim!';\n}",
                hints = listOf("await Future.delayed ve '\$isim' kullanın."),
                testCases = listOf(
                    TestCase("asenkronSelam('Merve')", "Hoş geldin, Merve!", "Asenkron selam")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "dart_quiz_9_1",
                    lessonId = "dart_9",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "await anahtar kelimesi yalnızca hangi tür fonksiyonların içinde kullanılabilir?",
                    options = listOf("async işaretli fonksiyonlarda", "void fonksiyonlarda", "main() haricindeki fonksiyonlarda", "Sadece constructor'larda"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Bir fonksiyonun içinde await kullanabilmek için gövdesi 'async' olarak işaretlenmelidir.",
                    explanationWrong = "await sadece async fonksiyonlarda çalışır.",
                    reviewTopic = "Dart Asenkron"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Future ile normal değişken arasındaki fark nedir?",
                    answer = "Normal değişken değeri hemen o anda bellidir. Future ise 'Şu an elimde yok ama birazdan hazır olacak' sözüdür."
                )
            ),
            completionCriteria = listOf(
                "Asenkron programlama mantığını kavramak",
                "Future, async ve await üçlüsünü kullanabilmek",
                "İnternet/veritabanı isteklerini yönetebilmek"
            )
        ),

        // ==========================================
        // DERS 10: VERİ AKIŞLARI (Streams)
        // ==========================================
        Lesson(
            id = "dart_10",
            courseId = "dart",
            sectionId = "dart_sec_5",
            title = "Canlı Veri Akışları (Streams): Sürekli Gelen Bilgileri Dinleme",
            shortDesc = "Borsa fiyatları, canlı sohbet mesajları veya GPS konumu gibi sürekli akan verileri Stream ile yakalayın.",
            level = CourseLevel.ADVANCED,
            order = 10,
            isPremium = true,
            learningObjectives = listOf(
                "Stream (Veri Akışı) mantığını bir su borusu analojisiyle anlamak",
                "Future (tek seferlik) ile Stream (sürekli akış) arasındaki farkı kavramak",
                "listen() ile canlı olayları dinlemek",
                "async* ve yield ile kendi canlı veri akışınızı üretmek"
            ),
            prerequisites = listOf("Asenkron Programlama (Future)"),
            subtopics = listOf("Stream Nedir? (Su Borusu)", "Stream Dinleme (listen)", "async* ve yield Jeneratörleri"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Stream Nedir? (Su Borusu Analojisi)",
                    body = "• **Future:** Tek bir bardak su gibidir; sipariş verirsiniz ve tek bir seferde gelir.\n• **Stream:** Açık bir musluk gibidir; su damla damla veya gürül gürül sürekli akmaya devam eder.\n\nÖrneğin bir canlı sohbet uygulamasında arkadaşlarından gelen her yeni mesaj musluktan damlayan yeni bir su damlasıdır.",
                    codeSnippet = "// 1'den 3'e kadar her saniye sayı fırlatan bir akış:\nStream<int> sayacAkisi() async* {\n  for (int i = 1; i <= 3; i++) {\n    await Future.delayed(Duration(seconds: 1));\n    yield i; // yield: 'Yeni bir damla fırlat' demektir\n  }\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Akışı Dinlemek (listen)",
                    body = "Bir Stream'den yeni bir bilgi geldiğinde anında haberdar olmak için `listen` (dinle) fonksiyonunu kurarız.",
                    codeSnippet = "void main() {\n  print('Akış dinlenmeye başlandı...');\n  \n  sayacAkisi().listen((sayi) {\n    print('Yeni sayı damladı: \$sayi');\n  });\n}"
                )
            ),
            codeExample = "Stream<String> bildirimler() async* {\n  yield 'Yeni mesajınız var!';\n  yield 'Arkadaşınız fotoğrafınızı beğendi.';\n}\n\nvoid main() {\n  bildirimler().listen((msg) => print('Bildirim: \$msg'));\n}",
            codeExplanation = "async* ve yield ile bildirim akışı üretildi ve listen ile gelen her mesaj anında yakalandı.",
            realWorldExample = "Canlı futbol maçı skorları veya radyo yayın akışları Stream ile dinlenir.",
            practicalTask = "1'den 5'e kadar sayıları yield ile yayan basit bir Stream fonksiyonu yazın.",
            starterPlaygroundCode = "Stream<int> sayiUretici() async* {\n  // for döngüsü ve yield kullanın:\n}\n\nvoid main() {\n  sayiUretici().listen(print);\n}",
            miniQuestion = MiniQuestion(
                id = "dart_q_10",
                question = "Stream üreten bir fonksiyonda sıradaki yeni değeri dışarı fırlatmak için hangi kelime kullanılır?",
                options = listOf("yield", "return", "send", "emit"),
                correctIndex = 0,
                explanation = "async* fonksiyonlarında yeni bir veri akıtmak için 'yield' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_dart_10",
                lessonId = "dart_10",
                title = "Geri Sayım Akışı",
                instructions = "n'den 1'e kadar geriye doğru sayan ve yield ile sayıları fırlatan geriSayim() stream fonksiyonunu yazın.",
                exampleInput = "geriSayim(3)",
                exampleOutput = "3, 2, 1",
                starterCode = "Stream<int> geriSayim(int n) async* {\n  // Kodunu yaz:\n}",
                solutionCode = "Stream<int> geriSayim(int n) async* {\n  for (int i = n; i >= 1; i--) {\n    yield i;\n  }\n}",
                hints = listOf("for (int i = n; i >= 1; i--) döngüsü ve yield i kullanın."),
                testCases = listOf(
                    TestCase("geriSayim(3)", "3, 2, 1", "Geri sayım akışı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "dart_quiz_10_1",
                    lessonId = "dart_10",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Future ile Stream arasındaki en temel fark nedir?",
                    options = listOf("Future tek bir değer getirir, Stream ise zaman içinde birden fazla değer akıtabilir", "Stream sadece sayılar içindir", "Future daha yavaştır", "Fark yoktur"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Future tek seferlik bir yanıt, Stream ise sürekli bir veri akışıdır.",
                    explanationWrong = "Future tek bir yanıt verirken Stream çoklu veri akışı sağlar.",
                    reviewTopic = "Dart Streams"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Flutter'da Stream nerede kullanılır?",
                    answer = "Firebase veritabanı dinleme, anlık mesajlaşma veya telefonun sensör verilerini (pusula, ivmeölçer) StreamBuilder ile ekrana çizdirirken kullanılır."
                )
            ),
            completionCriteria = listOf(
                "Stream mantığını su borusu benzetimiyle anlamak",
                "listen() ile gelen canlı veriyi yakalayabilmek",
                "async* ve yield ile kendi akışını yazabilmek"
            )
        ),

        // ==========================================
        // DERS 11: ÇOKLU İŞLEM (Isolates)
        // ==========================================
        Lesson(
            id = "dart_11",
            courseId = "dart",
            sectionId = "dart_sec_6",
            title = "Çoklu İşlem (Isolates): Ağır Görevleri Arka Plana Devretme",
            shortDesc = "Büyük dosya sıkıştırma veya fotoğraf işleme gibi ağır işleri telefonun diğer çekirdeklerine aktarın.",
            level = CourseLevel.EXPERT,
            order = 11,
            isPremium = true,
            learningObjectives = listOf(
                "Dart'ın tek iş parçacıklı (Single Thread) doğasını ve Isolate mantığını anlamak",
                "Ağır hesaplamaların arayüzü neden kastığını kavramak",
                "Isolate.run ile ağır işleri arka çekirdeklere kolayca göndermek"
            ),
            prerequisites = listOf("Asenkron Programlama"),
            subtopics = listOf("Tek Çekirdek Kısıtı", "Isolate Nedir?", "Isolate.run Pratiği"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Isolate Nedir? (Ayrı Bir İşçi Masası)",
                    body = "Dart normalde tek bir şeritte çalışır. Eğer siz bu şeritte 10 milyon sayıyı sıralamaya çalışırsanız telefonun ekranı takılır ve donar.\n\nBu donmayı önlemek için Dart `Isolate` adını verdiği ayrı çalışan işçiler sunar. Bu işçiye 'Sen arka odada bu 10 milyon sayıyı hesapla, bitince bana haber ver' deriz.",
                    codeSnippet = "// Arka planda çalışacak ağır işlem:\nint agirHesaplama(int n) {\n  int toplam = 0;\n  for (int i = 0; i < n; i++) {\n    toplam += i;\n  }\n  return toplam;\n}\n\nvoid main() async {\n  print('Ağır hesaplama arka plana gönderiliyor...');\n  \n  // Isolate.run ile yan çekirdeğe devrettik:\n  int sonuc = await Isolate.run(() => agirHesaplama(50000000));\n  \n  print('Hesaplama tamamlandı! Sonuç: \$sonuc');\n}"
                )
            ),
            codeExample = "import 'dart:isolate';\n\nint kareToplami(int n) {\n  return n * (n + 1) ~/ 2;\n}\n\nvoid main() async {\n  final sonuc = await Isolate.run(() => kareToplami(100));\n  print('Sonuç: \$sonuc');\n}",
            codeExplanation = "Isolate.run fonksiyonu belirtilen işlemi ana ekrandan tamamen bağımsız ikinci bir çekirdeğe devretti.",
            realWorldExample = "Mobil uygulamada büyük bir JSON dosyasını ayrıştırma (parse) veya fotoğraf filtreleme işlemleri Isolate.run ile yapılır.",
            practicalTask = "Isolate.run kullanarak arka planda bir metni tersine çeviren kod yazın.",
            starterPlaygroundCode = "import 'dart:isolate';\n\nString tersCevir(String s) => s.split('').reversed.join('');\n\nvoid main() async {\n  // Isolate.run ile çağırın:\n}",
            miniQuestion = MiniQuestion(
                id = "dart_q_11",
                question = "Dart'ta ağır bir hesaplamayı arayüzü dondurmadan ayrı bir çekirdekte çalıştırmanın en pratik modern yolu hangisidir?",
                options = listOf("Isolate.run()", "Thread.sleep()", "delay()", "wait()"),
                correctIndex = 0,
                explanation = "Isolate.run() tek satırda arka planda işlem başlatıp sonucu ana akışa getirir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_dart_11",
                lessonId = "dart_11",
                title = "Arka Planda Faktöriyel",
                instructions = "Verilen n sayısının faktöriyelini hesaplayan faktoriyel() fonksiyonunu yazın.",
                exampleInput = "faktoriyel(5)",
                exampleOutput = "120",
                starterCode = "int faktoriyel(int n) {\n  // Kodunu yaz:\n  return 1;\n}",
                solutionCode = "int faktoriyel(int n) {\n  int f = 1;\n  for (int i = 2; i <= n; i++) f *= i;\n  return f;\n}",
                hints = listOf("for döngüsüyle f *= i çarpımını yapın."),
                testCases = listOf(
                    TestCase("faktoriyel(5)", "120", "5!"),
                    TestCase("faktoriyel(4)", "24", "4!")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "dart_quiz_11_1",
                    lessonId = "dart_11",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Isolate'lerin normal Thread (iş parçacığı) yapılarından en temel farkı nedir?",
                    options = listOf("Kendi bağımsız bellek alanlarına sahiptirler ve birbirlerinin hafızasına doğrudan müdahale edemezler", "Sadece sayılarla çalışırlar", "Daha yavaştırlar", "Kapatılamazlar"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Isolate'ler izole bellek alanlarına sahiptir, bu sayede çakışma ve kilitlenme riski olmaz.",
                    explanationWrong = "Isolate'ler kendi bağımsız belleklerine sahiptir.",
                    reviewTopic = "Dart Isolates"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Her işlem için Isolate mi kullanmalıyız?",
                    answer = "Hayır! Küçük işlemler (örn: 100 elemanlı liste) için Isolate başlatmak gereksiz yük oluşturur. Sadece birkaç saniye sürebilecek ağır işlemler için kullanılmalıdır."
                )
            ),
            completionCriteria = listOf(
                "Isolate kavramını ve tek iş parçacığı mantığını bilmek",
                "Isolate.run() ile arka plan işlemleri başlatabilmek"
            )
        ),

        // ==========================================
        // DERS 12: HATA YÖNETİMİ VE TEMİZ KOD
        // ==========================================
        Lesson(
            id = "dart_12",
            courseId = "dart",
            sectionId = "dart_sec_6",
            title = "Hata Yakalama (try-catch) ve Profesyonel İpuçları",
            shortDesc = "Beklenmedik durumlarda uygulamanın kapanmasını önleyin, hataları yakalayın ve temiz kod yazın.",
            level = CourseLevel.EXPERT,
            order = 12,
            isPremium = true,
            learningObjectives = listOf(
                "try, catch ve finally blokları ile hataları güvenle yakalamak",
                "throw ile özel hata fırlatmak",
                "Okunabilir, temiz ve standartlara uygun Dart kodu yazma alışkanlığı kazanmak"
            ),
            prerequisites = listOf("Dart Temelleri ve Sınıflar"),
            subtopics = listOf("Hata Nedir? (Exception)", "try-catch-finally", "throw ile Hata Fırlatma", "Temiz Kod İpuçları"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Hataları Güvenle Yakalamak: try-catch",
                    body = "İnternet kopabilir, kullanıcı geçersiz bir sayı girebilir veya bir dosya bulunamayabilir. Bu tür durumlarda uygulamanın 'Uygulama Durduruldu' diyerek kapanmaması için şüpheli kodları `try` (dene) bloğuna alırız. Bir terslik olursa `catch` (yakala) bloğu devreye girer ve kullanıcıya nazik bir uyarı gösteririz.",
                    codeSnippet = "void main() {\n  try {\n    int sayi = int.parse('abc'); // 'abc' sayıya çevrilemez!\n    print('Sayı: \$sayi');\n  } catch (e) {\n    print('Bir hata oluştu ama uygulama çökmedi! Hata: \$e');\n  } finally {\n    print('Bu satır hata olsa da olmasa da kesinlikle çalışır.');\n  }\n}"
                ),
                LessonContentBlock(
                    subtitle = "2. Kendiniz Hata Fırlatın (throw)",
                    body = "Eğer kullanıcı sisteme eksi yaş girerse bunu mantıksız bulup kendiniz de hata fırlatabilirsiniz.",
                    codeSnippet = "void yasKontrol(int yas) {\n  if (yas < 0) {\n    throw Exception('Yaş sıfırdan küçük olamaz!');\n  }\n  print('Yaş geçerli: \$yas');\n}"
                ),
                LessonContentBlock(
                    subtitle = "3. Tebrikler! Dart Ustası Oldunuz!",
                    body = "Artık değişkenlerden nesnelere, asenkron yapılardan hata yönetimine kadar Dart'ın tüm temel ve ileri düzey yeteneklerine hakimsiniz. Şimdi bu bilgileri Flutter ile muhteşem mobil uygulamalara dönüştürme zamanı! 🚀"
                )
            ),
            codeExample = "void main() {\n  try {\n    int sonuc = 100 ~/ 0; // Sıfıra bölme hatası\n    print(sonuc);\n  } catch (e) {\n    print('Hata yakalandı: Sıfıra bölme yapılamaz.');\n  }\n}",
            codeExplanation = "Sıfıra tamsayı bölme hatası try-catch ile yakalandı ve program güvenle sonlandı.",
            realWorldExample = "Kullanıcı hatalı şifre girdiğinde veya internet kesildiğinde ekranda kırmızı uyarı kutucuğu göstermek için try-catch kullanılır.",
            practicalTask = "Geçersiz bir metni sayıya çevirmeyi deneyip hatayı yakalayan bir try-catch bloğu yazın.",
            starterPlaygroundCode = "void main() {\n  try {\n    int.parse('hatali_sayi');\n  } catch (e) {\n    // Hatayı ekrana yazdırın:\n  }\n}",
            miniQuestion = MiniQuestion(
                id = "dart_q_12",
                question = "Bir try-catch yapısında hata olsa da olmasa da her zaman çalışan blok hangisidir?",
                options = listOf("finally", "catch", "then", "always"),
                correctIndex = 0,
                explanation = "finally bloğu her halükarda en sonda mutlaka çalıştırılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_dart_12",
                lessonId = "dart_12",
                title = "Güvenli Sayı Çevirici",
                instructions = "Verilen metni sayıya çevirmeye çalışan, başarısız olursa -1 döndüren guvenliCevir() fonksiyonunu try-catch ile yazın.",
                exampleInput = "guvenliCevir('123')",
                exampleOutput = "123",
                starterCode = "int guvenliCevir(String metin) {\n  // try-catch ile yazın:\n  return 0;\n}",
                solutionCode = "int guvenliCevir(String metin) {\n  try {\n    return int.parse(metin);\n  } catch (e) {\n    return -1;\n  }\n}",
                hints = listOf("try { return int.parse(metin); } catch(e) { return -1; }"),
                testCases = listOf(
                    TestCase("guvenliCevir('42')", "42", "Geçerli sayı"),
                    TestCase("guvenliCevir('abc')", "-1", "Hatalı metin")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "dart_quiz_12_1",
                    lessonId = "dart_12",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Dart programında bilerek özel bir hata üretip fırlatmak için hangi kelime kullanılır?",
                    options = listOf("throw", "catch", "error", "fail"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! 'throw Exception(...)' ile özel hata üretilir.",
                    explanationWrong = "Hata fırlatmak için throw kullanılır.",
                    reviewTopic = "Dart Hata Yönetimi"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Hata yakalama neden bu kadar önemlidir?",
                    answer = "Çünkü kullanıcılar her zaman mükemmel veri girmez veya internet her an kopabilir. Profesyonel uygulamalar bu durumları önceden yakalayıp kullanıcıya yol gösterir."
                )
            ),
            completionCriteria = listOf(
                "try-catch-finally yapısını öğrenmek",
                "Hata fırlatmayı (throw) bilmek",
                "Temiz ve çökmeyen kod yazma prensiplerini uygulamak"
            )
        )
    )
}
