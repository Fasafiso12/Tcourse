package com.example.data.catalog

import com.example.model.*

/**
 * Elixir Kolay & Anlaşılır Müfredatı (12 Adım):
 * Discord ve WhatsApp gibi milyonlarca anlık mesajlaşmayı çökmeksizin yöneten fonksiyonel süper dil Elixir'i öğrenin!
 */
object ElixirCurriculum {

    fun getSections(): List<CourseSection> = listOf(
        CourseSection(
            id = "elixir_sec_1",
            courseId = "elixir",
            title = "Bölüm 1: Elixir Temelleri ve Atomlar",
            level = CourseLevel.BEGINNER,
            order = 1,
            description = "IO.puts, sembolik sabitler olan Atomlar (:ok, :error) ve Erlang BEAM dünyası.",
            learningObjectives = listOf("IO.puts ile ekrana yazdırmak", "Atom (:ok) kavramını anlamak", "Temel tipleri öğrenmek"),
            prerequisites = listOf("Ön koşul gerekmez! Sıfırdan başlar.")
        ),
        CourseSection(
            id = "elixir_sec_2",
            courseId = "elixir",
            title = "Bölüm 2: Değişmezlik, Listeler ve Tuple'lar",
            level = CourseLevel.BEGINNER,
            order = 2,
            description = "Verilerin asla bozulmaması (Immutability), [1, 2, 3] Listeleri ve { :ok, \"Veri\" } Tuple'ları.",
            learningObjectives = listOf("Immutability (Değişmezlik) kavramını kavramak", "Listeler ve Tuple'lar arasındaki farkı bilmek"),
            prerequisites = listOf("Elixir Temelleri")
        ),
        CourseSection(
            id = "elixir_sec_3",
            courseId = "elixir",
            title = "Bölüm 3: Pattern Matching (= Eşleme) ve Kararlar",
            level = CourseLevel.INTERMEDIATE,
            order = 3,
            description = "'=' işareti atama değil dedektifliktir! case, cond ve kalıp eşleme gücü.",
            learningObjectives = listOf("Pattern Matching ile veri ayıklamak", "case ile durumları eşlemek"),
            prerequisites = listOf("Listeler ve Tuple'lar")
        ),
        CourseSection(
            id = "elixir_sec_4",
            courseId = "elixir",
            title = "Bölüm 4: Modüller ve Efsanevi Pipe Operatörü (|>)",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            description = "defmodule ile fonksiyon gruplama ve kodları şiir gibi dizen Pipe operatörü (|>).",
            learningObjectives = listOf("Modül ve fonksiyon yazmak", "|> Pipe operatörü ile zincirleme kod kurmak", "Enum modülü fonksiyonlarını kullanmak"),
            prerequisites = listOf("Pattern Matching")
        ),
        CourseSection(
            id = "elixir_sec_5",
            courseId = "elixir",
            title = "Bölüm 5: Eşzamanlılık ve 'Bırak Çöksün' Felsefesi",
            level = CourseLevel.ADVANCED,
            order = 5,
            description = "Milyonlarca hafif süreç (Processes), mesajlaşma (send/receive) ve OTP Supervisor mimarisi.",
            learningObjectives = listOf("spawn ile arka plan süreci başlatmak", "send ve receive ile mesajlaşmak", "'Let It Crash' felsefesini anlamak"),
            prerequisites = listOf("Modüller ve Pipe")
        ),
        CourseSection(
            id = "elixir_sec_6",
            courseId = "elixir",
            title = "Bölüm 6: Phoenix Framework ve Elixir Ustalığı",
            level = CourseLevel.EXPERT,
            order = 6,
            description = "Canlı sohbetler (LiveView), gerçek zamanlı web uygulamaları ve profesyonel Elixir ustalığı.",
            learningObjectives = listOf("Phoenix ve LiveView gücünü kavramak", "Çökmeyen dağıtık sistemler tasarlamak"),
            prerequisites = listOf("Tüm Seviyeler")
        )
    )

    fun getLessons(): List<Lesson> = listOf(
        // ==========================================
        // DERS 1: IO.PUTS VE ATOMLAR
        // ==========================================
        Lesson(
            id = "ex_1",
            courseId = "elixir",
            sectionId = "elixir_sec_1",
            title = "Elixir Diline Giriş: IO.puts, Atomlar ve BEAM Gücü",
            shortDesc = "Discord'un 5 milyon anlık ses kanalını yöneten süper dil! IO.puts ve :ok atomları.",
            level = CourseLevel.BEGINNER,
            order = 1,
            isPremium = false,
            learningObjectives = listOf(
                "Elixir'in neden bu kadar güçlü ve çökmeyen bir dil olduğunu anlamak",
                "IO.puts ile ekrana yazı yazdırmak",
                "Atom (:ok, :error) sembollerini kavramak"
            ),
            prerequisites = listOf("Ön koşul gerekmez."),
            subtopics = listOf("Elixir Nedir?", "IO.puts", "Atomlar (:ok, :error)", "#{} Metin Birleştirme"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Çökmeyen Sistemlerin Dili: Elixir",
                    body = "Elixir, telekomünikasyon devi Ericsson'un 'asla durmayan sistemler' için ürettiği Erlang BEAM motoru üzerinde çalışır. Discord, WhatsApp ve Pinterest bu altyapıyı kullanır.\n\nEkrana yazı yazmak için `IO.puts` kullanılır."
                ),
                LessonContentBlock(
                    subtitle = "2. Atomlar: İsmi Kendisi Olan Sabitler",
                    body = "Başına iki nokta `:` koyduğumuz kelimelere **Atom** denir (`:ok`, `:error`, `:beklemede`). Değerleri kendi isimleridir ve bellekte neredeyse sıfır yer kaplarlar!",
                    codeSnippet = "IO.puts(\"Merhaba Elixir Dünyası! 💧\")\n\ndurum = :ok\nIO.puts(\"İşlem Durumu: #{durum}\")"
                )
            ),
            codeExample = "ad = \"Zeynep\"\nIO.puts(\"Hoş geldin #{ad}!\")",
            codeExplanation = "#{} interpolasyonu ile değişken metne gömüldü.",
            realWorldExample = "Discord, milyonlarca oyuncunun anlık ses ve metin odalarını Elixir süreçleriyle yönetir.",
            practicalTask = "Adınızı IO.puts ile ekrana yazdırın.",
            starterPlaygroundCode = "IO.puts(\"Merhaba Elixir\")",
            miniQuestion = MiniQuestion(
                id = "ex_q_1",
                question = "Elixir'de başına ':' konarak tanımlanan ve değeri kendi ismi olan sabit veri tipine ne ad verilir?",
                options = listOf("Atom", "Symbol", "Constant", "Key"),
                correctIndex = 0,
                explanation = "Elixir'de ':ok' gibi yapılara 'Atom' denir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_ex_1",
                lessonId = "ex_1",
                title = "İki Sayıyı Topla",
                instructions = "İki sayıyı toplayıp sonucunu döndüren topla(a, b) fonksiyonunu yazın.",
                exampleInput = "topla(10, 20)",
                exampleOutput = "30",
                starterCode = "defmodule Hesap do\n  def topla(a, b) do\n    # Kodunu yaz:\n    0\n  end\nend",
                solutionCode = "defmodule Hesap do\n  def topla(a, b) do\n    a + b\n  end\nend",
                hints = listOf("a + b yazın."),
                testCases = listOf(
                    TestCase("Hesap.topla(10, 20)", "30", "Toplam testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "ex_quiz_1_1",
                    lessonId = "ex_1",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Elixir kodlarının arkasında çalışan ve 30 yıldır telekomünikasyon dünyasında kullanılan sanal makinenin adı nedir?",
                    options = listOf("BEAM (Erlang VM)", "JVM", "V8", "CLR"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Elixir efsanevi BEAM sanal makinesinde çalışır.",
                    explanationWrong = "BEAM sanal makinesidir.",
                    reviewTopic = "Elixir BEAM"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Elixir'de true ve false da birer atom mudur?",
                    answer = "Evet! true aslında :true atomudur, false da :false atomudur."
                )
            ),
            completionCriteria = listOf(
                "IO.puts ve #{} kullanımını bilmek",
                "Atom (:ok) mantığını kavramak"
            )
        ),

        // ==========================================
        // DERS 2: DEĞİŞMEZLİK, LİSTELER VE TUPLE'LAR
        // ==========================================
        Lesson(
            id = "ex_2",
            courseId = "elixir",
            sectionId = "elixir_sec_2",
            title = "Değişmezlik (Immutability), Listeler ve Tuple'lar",
            shortDesc = "Oluşturulan veriler asla değişmez! [1, 2, 3] Listeleri ve {:ok, \"Veri\"} Tuple'ları.",
            level = CourseLevel.BEGINNER,
            order = 2,
            isPremium = false,
            learningObjectives = listOf(
                "Elixir'de verilerin %100 Değişmez (Immutable) olduğunu anlamak",
                "Listeler ([1, 2, 3]) ve Tuple'lar ({:ok, 200}) arasındaki farkı öğrenmek"
            ),
            prerequisites = listOf("Elixir Giriş ve Atomlar"),
            subtopics = listOf("Immutability (Değişmezlik)", "Listeler [ ]", "Tuple'lar { }"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Değişmezlik: Sürpriz Bug'lara Son!",
                    body = "Elixir'de bir liste veya sayı oluşturduğunuzda hiçbir fonksiyon onu gizlice arkadan değiştiremez. Yeni bir şey üretmek istiyorsanız yeni bir kopya oluşturursunuz. Bu sayede kodlar %100 güvenlidir!"
                ),
                LessonContentBlock(
                    subtitle = "2. Liste vs Tuple",
                    body = "• **Liste `[1, 2, 3]`:** Dinamik büyüyüp küçülen zincir.\n• **Tuple `{:ok, \"Mesaj\"}`:** Sabit boyutlu bilgi paketi.",
                    codeSnippet = "liste = [\"Elma\", \"Armut\"]\nyeni_liste = [\"Muz\" | liste] # Başına Muz ekledik!\n\nsonuc = {:ok, \"Giriş başarılı\"}"
                )
            ),
            codeExample = "kullanici = {:uye, \"Can\", 25}\nIO.inspect(kullanici)",
            codeExplanation = "Tuple içinde atom, isim ve yaş bir arada saklandı.",
            realWorldExample = "Elixir'deki tüm fonksiyonlar genellikle {:ok, sonuc} veya {:error, \"Hata nedeni\"} tuple'ı döndürür.",
            practicalTask = "{:ok, 100} şeklinde bir tuple tanımlayın.",
            starterPlaygroundCode = "t = {:ok, \"Başarılı\"}",
            miniQuestion = MiniQuestion(
                id = "ex_q_2",
                question = "Elixir'de sabit boyutlu, hızlı erişilen ve süslü parantezle tanımlanan veri yapısı hangisidir?",
                options = listOf("Tuple ({:ok, 10})", "List ([1, 2])", "Map (%{})", "Array"),
                correctIndex = 0,
                explanation = "Süslü parantez '{ }' Tuple yapısını tanımlar."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_ex_2",
                lessonId = "ex_2",
                title = "Başarılı Sonuç Paketi",
                instructions = "Verilen veriyi {:ok, veri} tuple'ı olarak paketleyip döndüren basarili(veri) fonksiyonunu yazın.",
                exampleInput = "basarili(100)",
                exampleOutput = "{:ok, 100}",
                starterCode = "defmodule Paket do\n  def basarili(veri) do\n    # Kodunu yaz:\n    {:error, nil}\n  end\nend",
                solutionCode = "defmodule Paket do\n  def basarili(veri) do\n    {:ok, veri}\n  end\nend",
                hints = listOf("{:ok, veri} yazın."),
                testCases = listOf(
                    TestCase("Paket.basarili(100)", "{:ok, 100}", "Başarılı paket")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "ex_quiz_2_1",
                    lessonId = "ex_2",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Elixir'de bir listenin başına [yeni_eleman | liste] şeklinde eleman eklemek ne kadar sürer?",
                    options = listOf("O(1) - Anında (Milisaniyenin altında)", "O(n) - Listenin uzunluğuna göre yavaşlar", "Çok yavaş", "Eklenemez"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Bağlantılı liste başına ekleme anında O(1) hızında yapılır.",
                    explanationWrong = "O(1) anında çalışır.",
                    reviewTopic = "Elixir Listeler"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "IO.inspect ile IO.puts farkı nedir?",
                    answer = "IO.puts sadece metin basar, IO.inspect ise tuple, liste, map gibi her türlü karmaşık veri yapısını olduğu gibi ekranda gösterir."
                )
            ),
            completionCriteria = listOf(
                "Immutability mantığını bilmek",
                "Liste ve Tuple tanımlayabilmek"
            )
        ),

        // ==========================================
        // DERS 3: PATTERN MATCHING (= EŞLEME)
        // ==========================================
        Lesson(
            id = "ex_3",
            courseId = "elixir",
            sectionId = "elixir_sec_3",
            title = "Elixir'in Kalbi: Pattern Matching (= Operatörü)",
            shortDesc = "'=' işareti atama değil dedektifliktir! Kutuları açıp içindeki verileri tek hamlede yakalayın.",
            level = CourseLevel.INTERMEDIATE,
            order = 3,
            isPremium = true,
            learningObjectives = listOf(
                "Elixir'de '=' işaretinin atama değil Pattern Matching olduğunu kavramak",
                "Tuple ve Listeleri tek satırda parçalayıp değişkenlere dağıtmak",
                "_ joker karakteri ile ilgilenilmeyen kısımları atlamak"
            ),
            prerequisites = listOf("Listeler ve Tuple'lar"),
            subtopics = listOf("Pattern Matching Nedir?", "Tuple Açma (Destructuring)", "Liste Başı/Kuyruğu ([h | t])"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. '=' Eşitleme Değil, Kalıp Eşleştirmedir!",
                    body = "Elixir'de `sol = sag` yazdığınızda Elixir iki tarafı karşılaştırır ve sol taraftaki değişkenlere sağ taraftaki karşılıklarını doldurur!",
                    codeSnippet = "{:ok, sonuc} = {:ok, \"İşlem Tamam!\"}\n# Artık 'sonuc' değişkeninin değeri \"İşlem Tamam!\" oldu!\n\n[ilk | kalanlar] = [1, 2, 3, 4]\n# ilk = 1, kalanlar = [2, 3, 4]"
                )
            ),
            codeExample = "{durum, puan} = {:kazandi, 95}\nIO.puts(\"Puan: #{puan}\")",
            codeExplanation = "Tuple içindeki 95 değeri puan değişkenine otomatik ayrıştırıldı.",
            realWorldExample = "Gelen sunucu yanıtının {:ok, veri} mi yoksa {:error, sebep} mi olduğunu tek satırda ayırt etmek için kullanılır.",
            practicalTask = "{:ok, x} = {:ok, 42} eşlemesini inceleyin.",
            starterPlaygroundCode = "{:ok, deger} = {:ok, 50}\nIO.puts(deger)",
            miniQuestion = MiniQuestion(
                id = "ex_q_3",
                question = "Elixir'de '{:ok, sayi} = {:error, \"Başarısız\"}' satırı çalıştırılırsa ne olur?",
                options = listOf("MatchError hatası fırlatılır (Çünkü :ok ile :error eşleşmez)", "sayi nil olur", "Sessizce geçer", "false döner"),
                correctIndex = 0,
                explanation = "Sol ve sağ kalıp uyuşmadığında Elixir MatchError verir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_ex_3",
                lessonId = "ex_3",
                title = "Kutuyu Aç",
                instructions = "{:veri, sayi} şeklinde gelen tuple'dan sayi değerini pattern matching ile çıkarıp döndüren kutuyu_ac(paket) fonksiyonunu yazın.",
                exampleInput = "kutuyu_ac({:veri, 42})",
                exampleOutput = "42",
                starterCode = "defmodule Dedektif do\n  def kutuyu_ac(paket) do\n    # Kodunu yaz:\n    0\n  end\nend",
                solutionCode = "defmodule Dedektif do\n  def kutuyu_ac({:veri, sayi}) do\n    sayi\n  end\nend",
                hints = listOf("def kutuyu_ac({:veri, sayi}) do sayi end yazın."),
                testCases = listOf(
                    TestCase("Dedektif.kutuyu_ac({:veri, 42})", "42", "Kutu açma")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "ex_quiz_3_1",
                    lessonId = "ex_3",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Elixir'de bir değişkenin mevcut değerini sabitleyip pattern matching'de yeni değer atanmasını engellemek için başına ne konur?",
                    options = listOf("^ (Pin Operatörü) örn: ^x", "@ (At)", "$ (Dolar)", "! (Ünlem)"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Değer sabitleme için Pin '^' operatörü kullanılır.",
                    explanationWrong = "^ (Pin) operatörü kullanılır.",
                    reviewTopic = "Elixir Pin Operatörü"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Fonksiyon parametresinde pattern matching yapılır mı?",
                    answer = "Evet! Elixir fonksiyonları parametrelerini alırken doğrudan pattern matching uygulayabilir."
                )
            ),
            completionCriteria = listOf(
                "Pattern Matching mantığını kavramak",
                "Tuple ve Liste parçalayabilmek"
            )
        ),

        // ==========================================
        // DERS 4: CASE, COND VE IF
        // ==========================================
        Lesson(
            id = "ex_4",
            courseId = "elixir",
            sectionId = "elixir_sec_3",
            title = "Kararlar: case, cond ve if/unless",
            shortDesc = "case ile kalıpları eşleyin, cond ile çoklu koşulları yönetin.",
            level = CourseLevel.INTERMEDIATE,
            order = 4,
            isPremium = true,
            learningObjectives = listOf(
                "case ... do kalıbıyla farklı durumları yönetmek",
                "cond ile birden çok mantıksal koşulu test etmek",
                "if ve unless sözdizimini öğrenmek"
            ),
            prerequisites = listOf("Pattern Matching"),
            subtopics = listOf("case İfadesi", "cond Çoklu Koşul", "if / unless"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. case: Kalıplara Göre Karar Vermek",
                    body = "`case`, gelen verinin şekline göre doğru kod bloğunu çalıştırır.",
                    codeSnippet = "yanit = {:ok, \"Hoş geldiniz\"}\n\nmesaj = case yanit do\n  {:ok, icerik} -> \"Başarılı: #{icerik}\"\n  {:error, sebep} -> \"Hata: #{sebep}\"\n  _ -> \"Bilinmeyen Durum\"\nend\n\nIO.puts(mesaj)"
                )
            ),
            codeExample = "cond do\n  2 + 2 == 5 -> \"İmkansız\"\n  2 * 2 == 4 -> \"Doğru!\"\n  true -> \"Varsayılan\"\nend",
            codeExplanation = "cond ilk doğru olan şartın sonucunu döndürdü.",
            realWorldExample = "API isteklerinin 200, 404, 500 yanıtları case bloğu ile kontrol edilir.",
            practicalTask = "case ile basit bir durum kontrolü yazın.",
            starterPlaygroundCode = "case {:ok, 1} do {:ok, x} -> x end",
            miniQuestion = MiniQuestion(
                id = "ex_q_4",
                question = "Elixir'de bir koşulun 'yanlış' olması durumunda çalışan ters-if yapısına ne ad verilir?",
                options = listOf("unless", "else_if", "not_if", "until"),
                correctIndex = 0,
                explanation = "'if not' yerine Elixir'de 'unless' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_ex_4",
                lessonId = "ex_4",
                title = "Durum Açıklayıcı",
                instructions = "durum {:ok, isim} ise 'Hoş geldin isim', {:error, _} ise 'Hata' döndüren acikla(durum) fonksiyonunu yazın.",
                exampleInput = "acikla({:ok, \"Ali\"})",
                exampleOutput = "\"Hoş geldin Ali\"",
                starterCode = "defmodule Karar do\n  def acikla(durum) do\n    # case kullan:\n    \"\"\n  end\nend",
                solutionCode = "defmodule Karar do\n  def acikla(durum) do\n    case durum do\n      {:ok, isim} -> \"Hoş geldin #{isim}\"\n      {:error, _} -> \"Hata\"\n    end\n  end\nend",
                hints = listOf("case durum do {:ok, isim} -> \"Hoş geldin #{isim}\" {:error, _} -> \"Hata\" end yazın."),
                testCases = listOf(
                    TestCase("Karar.acikla({:ok, \"Ali\"})", "Hoş geldin Ali", "Başarılı"),
                    TestCase("Karar.acikla({:error, :yetkisiz})", "Hata", "Hatalı")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "ex_quiz_4_1",
                    lessonId = "ex_4",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Elixir'de cond ifadesinde hiçbir şart true olmazsa ne olur?",
                    options = listOf("CondClauseError hatası verir (Bu yüzden en sona 'true -> ...' konur)", "nil döner", "false döner", "Sessizce geçer"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Cond bloğunda en az bir şart doğru olmalıdır; en sona true konur.",
                    explanationWrong = "CondClauseError hatası verir.",
                    reviewTopic = "Elixir cond"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Guard (when) nedir?",
                    answer = "case veya fonksiyonda 'when is_integer(x)' diyerek ek tip kontrolleri eklemektir."
                )
            ),
            completionCriteria = listOf(
                "case ile durum eşleyebilmek",
                "cond ve unless yapısını bilmek"
            )
        ),

        // ==========================================
        // DERS 5: ANONİM FONKSİYONLAR VE &
        // ==========================================
        Lesson(
            id = "ex_5",
            courseId = "elixir",
            sectionId = "ex_sec_3",
            title = "Anonim Fonksiyonlar ve & Operatörü",
            shortDesc = "fn -> end ile hızlı fonksiyonlar ve Elixir'in ünlü &(&1 * 2) kısayolu.",
            level = CourseLevel.INTERMEDIATE,
            order = 5,
            isPremium = true,
            learningObjectives = listOf(
                "fn a, b -> a + b end ile anonim fonksiyon yazmak",
                "Anonim fonksiyonları 'topla.(5, 10)' şeklinde nokta ile çağırmak",
                "&(&1 * 2) yakalama (Capture) sözdizimini öğrenmek"
            ),
            prerequisites = listOf("Kararlar ve Pattern Matching"),
            subtopics = listOf("fn -> end", "Nokta ile Çağırma (f.())", "& Yakalama Operatörü"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. fn -> end Sözdizimi",
                    body = "Tek kullanımlık fonksiyonları `fn` ile tanımlarız. Çağırırken mutlaka fonksiyon adının sonuna `.` (nokta) koyarız!",
                    codeSnippet = "topla = fn a, b -> a + b end\nIO.puts(topla.(10, 20)) # 30 (. işaretine dikkat!)\n\n# Kısa & sözdizimi:\niki_kat = &(&1 * 2)\nIO.puts(iki_kat.(5)) # 10"
                )
            ),
            codeExample = "kare = &(&1 * &1)\nIO.puts(kare.(6)) # 36",
            codeExplanation = "&1 birinci parametreyi temsil eder.",
            realWorldExample = "Listeleri filtrelerken Enum.filter(liste, &(&1 > 10)) kalıbı kullanılır.",
            practicalTask = "İki katını alan anonim bir fonksiyon tanımlayın.",
            starterPlaygroundCode = "f = fn x -> x * 2 end; IO.puts(f.(4))",
            miniQuestion = MiniQuestion(
                id = "ex_q_5",
                question = "Elixir'de bir değişkene atanan anonim fonksiyon çağrılırken (f) parantezden önce hangi işaret konur?",
                options = listOf(". (Nokta) örn: f.(10)", "->", ":", "@"),
                correctIndex = 0,
                explanation = "Anonim fonksiyonlar 'f.(parametre)' şeklinde nokta ile çağrılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_ex_5",
                lessonId = "ex_5",
                title = "Kare Alan Anonim Fonksiyon",
                instructions = "Gelen sayının karesini döndüren bir anonim fonksiyon oluşturup döndüren kare_fonksiyonu() fonksiyonunu yazın.",
                exampleInput = "f = kare_fonksiyonu(); f.(5)",
                exampleOutput = "25",
                starterCode = "defmodule Anonim do\n  def kare_fonksiyonu do\n    # fn -> end veya & döndür:\n    fn x -> 0 end\n  end\nend",
                solutionCode = "defmodule Anonim do\n  def kare_fonksiyonu do\n    fn x -> x * x end\n  end\nend",
                hints = listOf("fn x -> x * x end yazın."),
                testCases = listOf(
                    TestCase("Anonim.kare_fonksiyonu().(5)", "25", "5'in karesi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "ex_quiz_5_1",
                    lessonId = "ex_5",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Elixir'de &(&1 + &2) ifadesindeki &1 ve &2 neyi temsil eder?",
                    options = listOf("Fonksiyona gelen 1. ve 2. parametreleri", "Hafıza adreslerini", "İplik numaralarını", "Atomları"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! &1 birinci, &2 ikinci parametreyi temsil eder.",
                    explanationWrong = "1. ve 2. parametreleri temsil eder.",
                    reviewTopic = "Elixir Capture Operatörü"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Neden isimlendirilmiş fonksiyonlarda nokta yok da anonimlerde nokta var?",
                    answer = "Elixir aynı isimdeki yerel değişken ile fonksiyon çağrısını ayırt edebilmek için anonim fonksiyonlarda '.' zorunlu kılar."
                )
            ),
            completionCriteria = listOf(
                "fn -> end ile anonim fonksiyon yazabilmek",
                "f.() ve &1 mantığını kavramak"
            )
        ),

        // ==========================================
        // DERS 6: MODÜLLER VE DEF
        // ==========================================
        Lesson(
            id = "ex_6",
            courseId = "elixir",
            sectionId = "elixir_sec_4",
            title = "Modüller (defmodule) ve İsimli Fonksiyonlar (def)",
            shortDesc = "defmodule ile kodları paketleme, def ile dışa açık ve defp ile gizli fonksiyonlar.",
            level = CourseLevel.INTERMEDIATE,
            order = 6,
            isPremium = true,
            learningObjectives = listOf(
                "defmodule ModulAdi do ... end ile modül kurmak",
                "def ile herkese açık, defp ile gizli (private) fonksiyon yazmak",
                "Farklı kalıplara sahip çoklu fonksiyon gövdeleri (Multi-Clause) tasarlamak"
            ),
            prerequisites = listOf("Anonim Fonksiyonlar"),
            subtopics = listOf("defmodule", "def vs defp", "Çoklu Fonksiyon Gövdeleri"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Modül ve Çoklu Gövde Mimarisi",
                    body = "Elixir'de if-else yazmak yerine aynı isimde birden fazla fonksiyon tanımlayıp parametreye göre ayrıştırırız!",
                    codeSnippet = "defmodule Karsilama do\n  def selam(:tr), do: \"Merhaba! 🇹🇷\"\n  def selam(:en), do: \"Hello! 🇬🇧\"\n  def selam(_),   do: \"Selam Dünya! 🌍\"\nend\n\nIO.puts(Karsilama.selam(:tr)) # Merhaba!"
                )
            ),
            codeExample = "defmodule Matematik do\n  def faktoryel(0), do: 1\n  def faktoryel(n), do: n * faktoryel(n - 1)\nend",
            codeExplanation = "Faktöriyel tek satırda pattern matching ile çözüldü.",
            realWorldExample = "Phoenix uygulamalarındaki Controller ve Context yapıları birer defmodule'dür.",
            practicalTask = "Basit bir Matematik modülü ve topla fonksiyonu yazın.",
            starterPlaygroundCode = "defmodule Test do def carp(a, b), do: a * b end",
            miniQuestion = MiniQuestion(
                id = "ex_q_6",
                question = "Elixir'de sadece o modülün içinde kullanılabilen gizli (private) bir fonksiyon tanımlamak için hangisi kullanılır?",
                options = listOf("defp", "private def", "hidden def", "def_secret"),
                correctIndex = 0,
                explanation = "Gizli fonksiyonlar için 'defp' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_ex_6",
                lessonId = "ex_6",
                title = "Selam Modülü",
                instructions = "selam(ad) çağrıldığında 'Merhaba ad!' döndüren Selamlayici modülünü yazın.",
                exampleInput = "Selamlayici.selam(\"Efe\")",
                exampleOutput = "\"Merhaba Efe!\"",
                starterCode = "defmodule Selamlayici do\n  # selam(ad) fonksiyonunu yaz:\nend",
                solutionCode = "defmodule Selamlayici do\n  def selam(ad) do\n    \"Merhaba #{ad}!\"\n  end\nend",
                hints = listOf("def selam(ad) do \"Merhaba #{ad}!\" end yazın."),
                testCases = listOf(
                    TestCase("Selamlayici.selam(\"Efe\")", "Merhaba Efe!", "Selam testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "ex_quiz_6_1",
                    lessonId = "ex_6",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Elixir'de modül isimleri hangi harfle başlamak ZORUNDADIR?",
                    options = listOf("Büyük Harfle (Örn: Matematik)", "Küçük Harfle", "Alt Çizgiyle", "İki Noktayla"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Elixir modül adları büyük harfle başlar (Aslında arkada birer atomdur).",
                    explanationWrong = "Büyük harfle başlamalıdır.",
                    reviewTopic = "Elixir Modüller"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "def topla(a, b), do: a + b tek satırda yazılabilir mi?",
                    answer = "Evet! Kısa fonksiyonlar ', do:' sözdizimi ile tek satırda yazılabilir."
                )
            ),
            completionCriteria = listOf(
                "defmodule ve def kullanabilmek",
                "defp ile gizli fonksiyon yazabilmek"
            )
        ),

        // ==========================================
        // DERS 7: PIPE OPERATÖRÜ (|>)
        // ==========================================
        Lesson(
            id = "ex_7",
            courseId = "elixir",
            sectionId = "elixir_sec_4",
            title = "Elixir'in İmzası: Pipe Operatörü (|>)",
            shortDesc = "İç içe karmaşık fonksiyon parantezlerine son! Kodları su gibi akıtan sihirli boru: |>",
            level = CourseLevel.INTERMEDIATE,
            order = 7,
            isPremium = true,
            learningObjectives = listOf(
                "|> Pipe operatörünün çalışma mantığını kavramak",
                "Soldaki ifadenin sonucunu sağdaki fonksiyonun İLK parametresine otomatik aktarmak",
                "Temiz, okunabilir ve şiir gibi veri işleme hatları kurmak"
            ),
            prerequisites = listOf("Modüller ve Fonksiyonlar"),
            subtopics = listOf("Pipe Mantığı", "İç İçe Kodları Sadeleştirme", "Boru Hattı Mimarisi"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Parantez Çorbasından Kurtulun!",
                    body = "Normalde: `String.upcase(String.trim(\"  merhaba  \"))` yazarız. Okuması zordur.\n\nElixir'in **Pipe (`|>`)** operatörü ile veriyi borudan akıtır gibi yazarız: Soldaki sonuç sağdaki fonksiyonun ilk parametresi olur!"
                ),
                LessonContentBlock(
                    subtitle = "2. Şiir Gibi Kod",
                    body = "Veri baştan girer ve sırayla işlenir:",
                    codeSnippet = "\"  merhaba elixir  \"\n|> String.trim()\n|> String.upcase()\n|> IO.puts()\n# Çıktı: \"MERHABA ELIXIR\""
                )
            ),
            codeExample = "[1, 2, 3, 4]\n|> Enum.map(&(&1 * 10))\n|> Enum.sum()\n# 100",
            codeExplanation = "Liste sırayla 10 ile çarpıldı ve toplandı.",
            realWorldExample = "Web sunucusuna gelen ham HTTP isteği sırasıyla doğrulama, JSON çözme ve veritabanı boru hatlarından (|>) geçer.",
            practicalTask = "Metni kırpıp büyüten bir Pipe zinciri kurun.",
            starterPlaygroundCode = "\" elixir \" |> String.trim() |> IO.puts()",
            miniQuestion = MiniQuestion(
                id = "ex_q_7",
                question = "Elixir'de 'veri |> fonksiyon()' yazıldığında 'veri' fonksiyona nasıl aktarılır?",
                options = listOf("Fonksiyonun İLK parametresi olarak otomatik iletilir", "Son parametre olarak", "Global değişken olur", "İletilmez"),
                correctIndex = 0,
                explanation = "Pipe operatörü veriyi otomatik olarak ilk parametreye aktarır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_ex_7",
                lessonId = "ex_7",
                title = "Pipe ile Metin Temizleyici",
                instructions = "Gelen metni String.trim() ile temizleyip ardından String.upcase() ile büyüten ve sonucu döndüren temizle(metin) fonksiyonunu |> ile yazın.",
                exampleInput = "temizle(\"  elixir  \")",
                exampleOutput = "\"ELIXIR\"",
                starterCode = "defmodule Boru do\n  def temizle(metin) do\n    # |> zincirini yaz:\n    \"\"\n  end\nend",
                solutionCode = "defmodule Boru do\n  def temizle(metin) do\n    metin\n    |> String.trim()\n    |> String.upcase()\n  end\nend",
                hints = listOf("metin |> String.trim() |> String.upcase() yazın."),
                testCases = listOf(
                    TestCase("Boru.temizle(\"  elixir  \")", "ELIXIR", "Pipe testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "ex_quiz_7_1",
                    lessonId = "ex_7",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Pipe operatörünün Elixir geliştiricilerine sunduğu en büyük avantaj nedir?",
                    options = listOf("Kodun yukarıdan aşağıya, soldan sağa mantıksal bir veri akışı olarak okunmasını sağlaması", "Kodu derlemeden çalıştırması", "Daha az bellek kullanması", "Otomatik internete bağlanması"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Pipe kodu inanılmaz derecede okunabilir ve temiz kılar.",
                    explanationWrong = "Kod okunabilirliğini ve akışını mükemmelleştirir.",
                    reviewTopic = "Elixir Pipe Operatörü"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Birden fazla parametre alan fonksiyona Pipe nasıl uygulanır?",
                    answer = "İlk parametre Pipe'tan gelir, diğer parametreler parantez içine yazılır: 'liste |> Enum.take(3)'."
                )
            ),
            completionCriteria = listOf(
                "|> operatörünü ustaca kullanabilmek",
                "İç içe fonksiyonları Pipe zincirine dönüştürebilmek"
            )
        ),

        // ==========================================
        // DERS 8: HARİTALAR (MAPS) VE STRUCTS
        // ==========================================
        Lesson(
            id = "ex_8",
            courseId = "elixir",
            sectionId = "elixir_sec_4",
            title = "Haritalar (Maps %{}) ve Yapılar (Structs)",
            shortDesc = "Anahtar-değer sözlükleri (%{}) ve defstruct ile şablonlu veri modelleri.",
            level = CourseLevel.INTERMEDIATE,
            order = 8,
            isPremium = true,
            learningObjectives = listOf(
                "%{isim: \"Ali\", yas: 20} ile Map tanımlamak",
                "Nokta (map.isim) ve Map.get ile okuma yapmak",
                "defstruct ile kurallı veri yapıları oluşturmak"
            ),
            prerequisites = listOf("Pipe ve Modüller"),
            subtopics = listOf("Map Sözlükleri (%{})", "Map Güncelleme (%{map | k: v})", "defstruct"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Map: Süper Hızlı Sözlük",
                    body = "Elixir'de en sık kullanılan veri yapısı `%{}` haritasıdır.",
                    codeSnippet = "kullanici = %{isim: \"Deniz\", puan: 100}\nIO.puts(kullanici.isim) # Deniz\n\n# Değer güncelleme (yeni kopya üretir):\nguncel = %{kullanici | puan: 110}"
                )
            ),
            codeExample = "defmodule Oyuncu do\n  defstruct isim: \"İsimsiz\", can: 100\nend\n\np = %Oyuncu{isim: \"Barbaros\"}",
            codeExplanation = "defstruct ile varsayılan değerlere sahip bir veri modeli üretildi.",
            realWorldExample = "Veritabanındaki kullanıcı tabloları Ecto kütüphanesinde birer Struct olarak modellenir.",
            practicalTask = "Ad ve yaş içeren bir Map tanımlayıp adını ekrana basın.",
            starterPlaygroundCode = "m = %{ad: \"Can\", yas: 30}; IO.puts(m.ad)",
            miniQuestion = MiniQuestion(
                id = "ex_q_8",
                question = "Elixir'de mevcut bir Map'in içindeki bir değeri güncellemek (%{map | anahtar: yeni_deger}) için anahtarın önceden var olması şart mıdır?",
                options = listOf("Evet şarttır; var olmayan bir anahtar | ile güncellenmeye çalışılırsa KeyError verir", "Hayır şart değildir", "Sadece sayılarda şarttır", "Hata vermez"),
                correctIndex = 0,
                explanation = "%{map | anahtar: val} sözdizimi var olan anahtarı güncellemek içindir; yeni anahtar için Map.put kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_ex_8",
                lessonId = "ex_8",
                title = "Map Değer Okuyucu",
                instructions = "Gelen %{skor: s} haritasından skor değerini döndüren skoru_al(m) fonksiyonunu yazın.",
                exampleInput = "skoru_al(%{skor: 95})",
                exampleOutput = "95",
                starterCode = "defmodule Harita do\n  def skoru_al(m) do\n    # Kodunu yaz:\n    0\n  end\nend",
                solutionCode = "defmodule Harita do\n  def skoru_al(%{skor: s}) do\n    s\n  end\nend",
                hints = listOf("def skoru_al(%{skor: s}) do s end yazın."),
                testCases = listOf(
                    TestCase("Harita.skoru_al(%{skor: 95})", "95", "Skor testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "ex_quiz_8_1",
                    lessonId = "ex_8",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Bir modül içinde 'defstruct' tanımlandığında bu yapıya ne ad verilir?",
                    options = listOf("Struct (Yapı)", "Class", "Enum", "Record"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Modüle bağlı tip denetimli haritalara Struct denir.",
                    explanationWrong = "Struct adı verilir.",
                    reviewTopic = "Elixir Structs"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Map.get(\"olmayan\", :varsayilan) ne yapar?",
                    answer = "Anahtar bulunamazsa çökmez, ikinci parametredeki varsayılan değeri döndürür."
                )
            ),
            completionCriteria = listOf(
                "Map ve Struct tanımlayabilmek",
                "Pattern matching ile map verisi okuyabilmek"
            )
        ),

        // ==========================================
        // DERS 9: ENUM MODÜLÜ
        // ==========================================
        Lesson(
            id = "ex_9",
            courseId = "elixir",
            sectionId = "elixir_sec_4",
            title = "Enum Modülü ve Koleksiyon Sihirbazlığı",
            shortDesc = "map, filter, reduce, sort... Koleksiyonları tek satırda dönüştüren devasa araç kiti.",
            level = CourseLevel.ADVANCED,
            order = 9,
            isPremium = true,
            learningObjectives = listOf(
                "Enum.map ile tüm elemanları dönüştürmek",
                "Enum.filter ile şartı sağlayanları süzmek",
                "Enum.reduce ile tek bir sonuca indirgemek (toplam vb.)"
            ),
            prerequisites = listOf("Maps ve Pipe"),
            subtopics = listOf("Enum.map", "Enum.filter", "Enum.reduce"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Enum: Elixir'in En Çok Kullanılan Modülü",
                    body = "Listeler, haritalar ve aralıklar üzerinde döngü yazmak yerine Enum modülü fonksiyonlarını Pipe ile zincirleriz.",
                    codeSnippet = "sayilar = [1, 2, 3, 4, 5, 6]\n\nsonuc =\n  sayilar\n  |> Enum.filter(&(&1 > 2))    # [3, 4, 5, 6]\n  |> Enum.map(&(&1 * 10))      # [30, 40, 50, 60]\n  |> Enum.sum()                # 180"
                )
            ),
            codeExample = "Enum.join([\"Elma\", \"Armut\"], \", \") # \"Elma, Armut\"",
            codeExplanation = "Enum.join ile liste metne dönüştürüldü.",
            realWorldExample = "E-ticaret sepetindeki ürünlerin fiyatlarını toplamak için Enum.map ve Enum.sum kullanılır.",
            practicalTask = "1..5 aralığını Enum.map ile ikiyle çarpın.",
            starterPlaygroundCode = "1..5 |> Enum.map(&(&1 * 2)) |> IO.inspect()",
            miniQuestion = MiniQuestion(
                id = "ex_q_9",
                question = "Bir listedeki sadece çift sayıları seçmek için Enum modülünün hangi fonksiyonu kullanılır?",
                options = listOf("Enum.filter", "Enum.map", "Enum.each", "Enum.reduce"),
                correctIndex = 0,
                explanation = "Süzme ve filtreleme için 'Enum.filter' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_ex_9",
                lessonId = "ex_9",
                title = "Çift Sayıları İkiyle Çarp",
                instructions = "Verilen listedeki çift sayıları (rem(x, 2) == 0) bulup 2 ile çarpan ciftleri_katla(liste) fonksiyonunu Enum ile yazın.",
                exampleInput = "ciftleri_katla([1, 2, 3, 4])",
                exampleOutput = "[4, 8]",
                starterCode = "defmodule Koleksiyon do\n  def ciftleri_katla(liste) do\n    # Enum zinciri yaz:\n    []\n  end\nend",
                solutionCode = "defmodule Koleksiyon do\n  def ciftleri_katla(liste) do\n    liste\n    |> Enum.filter(&(rem(&1, 2) == 0))\n    |> Enum.map(&(&1 * 2))\n  end\nend",
                hints = listOf("liste |> Enum.filter(&(rem(&1, 2) == 0)) |> Enum.map(&(&1 * 2)) yazın."),
                testCases = listOf(
                    TestCase("Koleksiyon.ciftleri_katla([1, 2, 3, 4])", "[4, 8]", "Çift katlama")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "ex_quiz_9_1",
                    lessonId = "ex_9",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Milyonlarca elemanlı devasa listelerde belleği tüketmeden tembelce (Lazy) işlem yapmak için Enum yerine hangi modül kullanılır?",
                    options = listOf("Stream Modülü", "LazyEnum", "Flow", "Future"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Tembel değerlendirme için 'Stream' modülü kullanılır.",
                    explanationWrong = "Stream modülü kullanılır.",
                    reviewTopic = "Elixir Stream"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Enum.each ile Enum.map farkı nedir?",
                    answer = "Enum.map yeni dönüştürülmüş bir liste döndürür; Enum.each ise ekrana yazdırma gibi yan etkiler için kullanılır ve geriye sadece :ok döner."
                )
            ),
            completionCriteria = listOf(
                "Enum.map ve Enum.filter kullanabilmek",
                "Enum ile Pipe zinciri kurabilmek"
            )
        ),

        // ==========================================
        // DERS 10: EŞZAMANLILIK VE PROCESSES
        // ==========================================
        Lesson(
            id = "ex_10",
            courseId = "elixir",
            sectionId = "elixir_sec_5",
            title = "Eşzamanlılık: Süreçler (Processes), spawn ve send/receive",
            shortDesc = "Aktör Modeli: Milyonlarca bağımsız süreç (Process) ve posta kutusu mesajlaşması.",
            level = CourseLevel.ADVANCED,
            order = 10,
            isPremium = true,
            learningObjectives = listOf(
                "BEAM Süreçlerinin (Process) işletim sistemi thread'i olmadığını (çok hafif olduğunu) anlamak",
                "spawn ile yeni bir süreç başlatmak",
                "send ve receive ile süreçler arası mesaj alıp vermek"
            ),
            prerequisites = listOf("Enum ve Modüller"),
            subtopics = listOf("Process Nedir?", "spawn/1", "send ve receive Posta Kutusu"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Milyonlarca Küçük Beyin: Processes",
                    body = "Elixir'de her işlem kendi bağımsız **Sürecinde (Process)** yaşar. Bellekleri tamamen ayrıdır. Birbirlerine sadece mektup yollarlar (`send`). Biri çökse bile diğerleri etkilenmez!"
                ),
                LessonContentBlock(
                    subtitle = "2. Mesaj Gönder ve Bekle",
                    body = "Posta kutusuna mesaj geldiğinde `receive` ile okunur.",
                    codeSnippet = "pid = spawn(fn ->\n  receive do\n    {:selam, gonderen} -> send(gonderen, \"Aleyküm selam!\")\n  end\nend)\n\nsend(pid, {:selam, self()})\n\nreceive do\n  yanit -> IO.puts(\"Gelen Yanıt: #{yanit}\")\nend"
                )
            ),
            codeExample = "spawn(fn -> IO.puts(\"Arka planda bağımsız çalışıyorum!\") end)",
            codeExplanation = "spawn ile mikrosaniyede bağımsız bir süreç başlatıldı.",
            realWorldExample = "WhatsApp'a bağlı her bir kullanıcı arka planda Erlang/Elixir'in tek bir Process'i olarak yaşar.",
            practicalTask = "spawn ile arka plan süreci başlatmayı inceleyin.",
            starterPlaygroundCode = "spawn(fn -> IO.puts(\"Süreç\") end)",
            miniQuestion = MiniQuestion(
                id = "ex_q_10",
                question = "Elixir'de bir sürece mesaj göndermek için hangi fonksiyon kullanılır?",
                options = listOf("send(pid, mesaj)", "post(pid, mesaj)", "push(pid, mesaj)", "emit(mesaj)"),
                correctIndex = 0,
                explanation = "Mesaj yollamak için 'send(hedef_pid, mesaj)' kullanılır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_ex_10",
                lessonId = "ex_10",
                title = "Kendine Mesaj Yolla",
                instructions = "Mevcut sürece (self()) 'send(self(), mesaj)' ile mesaj gönderip ardından o mesajı döndüren kendine_yolla(mesaj) fonksiyonunu yazın.",
                exampleInput = "kendine_yolla(\"Selam\")",
                exampleOutput = "\"Selam\"",
                starterCode = "defmodule Haber do\n  def kendine_yolla(mesaj) do\n    # send ve receive yaz:\n    \"\"\n  end\nend",
                solutionCode = "defmodule Haber do\n  def kendine_yolla(mesaj) do\n    send(self(), mesaj)\n    receive do\n      m -> m\n    end\n  end\nend",
                hints = listOf("send(self(), mesaj) receive do m -> m end yazın."),
                testCases = listOf(
                    TestCase("Haber.kendine_yolla(\"Selam\")", "Selam", "Mesaj testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "ex_quiz_10_1",
                    lessonId = "ex_10",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Elixir'de bir Process çöktüğünde diğer Process'lerin bellekleri bozulur mu?",
                    options = listOf("Asla bozulmaz! Her Process tamamen izole bir bellek alanına ve Garbage Collector'a sahiptir", "Evet hepsi çöker", "Ana program durur", "Hafıza sızıntısı olur"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! BEAM süreçleri tam izolasyona sahiptir.",
                    explanationWrong = "Tamamen izoledir, diğerleri etkilenmez.",
                    reviewTopic = "Elixir Süreç İzolasyonu"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "self() ne döndürür?",
                    answer = "O an çalışan kodun kendi Süreç Kimliğini (Process ID - PID) döndürür."
                )
            ),
            completionCriteria = listOf(
                "Process mantığını kavramak",
                "spawn, send ve receive kullanımını bilmek"
            )
        ),

        // ==========================================
        // DERS 11: OTP VE LET IT CRASH
        // ==========================================
        Lesson(
            id = "ex_11",
            courseId = "elixir",
            sectionId = "elixir_sec_5",
            title = "OTP, GenServer ve 'Bırak Çöksün' (Let It Crash) Felsefesi",
            shortDesc = "Hata olursa programı kurtarmaya çalışma, 'bırak çöksün' (Supervisor) anında yeniden başlatsın!",
            level = CourseLevel.ADVANCED,
            order = 11,
            isPremium = true,
            learningObjectives = listOf(
                "Elixir'in efsanevi 'Let It Crash' felsefesini anlamak",
                "GenServer ile durum (state) tutan sunucu aktörleri yazmak",
                "Supervisor ağaçları ile çöken süreci milisaniyede sıfırdan ayağa kaldırmak"
            ),
            prerequisites = listOf("Processes ve Mesajlaşma"),
            subtopics = listOf("Let It Crash Felsefesi", "GenServer Mimarisi", "Supervisor Ağaçları"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. 'Bırak Çöksün!' (Let It Crash)",
                    body = "Klasik dillerde her yere try-catch koyup hatayı yamamaya çalışırız. Elixir der ki: 'Bozuk bellekle uğraşma, bırak o süreç çöksün! **Supervisor (Gözetmen)** onu milisaniyede sıfır kilometre olarak yeniden başlatsın!' İşte bu yüzden Elixir sistemleri 10 yıl boyunca tek saniye durmadan çalışabilir!"
                )
            ),
            codeExample = "use GenServer\n# Durum tutan ve milyonlarca çağrıyı yöneten OTP standardı",
            codeExplanation = "GenServer endüstri standardı durum yönetim çatısıdır.",
            realWorldExample = "Ericsson baz istasyonları ve telekom santralleri %99.9999999 (yılda 1 saniye bile durmayan) güvenilirliğe bu mimariyle ulaşmıştır.",
            practicalTask = "Supervisor ve GenServer kavramını inceleyin.",
            starterPlaygroundCode = "# Let It Crash felsefesi: Hata durumunda gözetmen süreci anında canlandırır.",
            miniQuestion = MiniQuestion(
                id = "ex_q_11",
                question = "Elixir/Erlang mimarisinde çöken süreçleri otomatik olarak tespit edip yeniden başlatan gözetmen mekanizmasına ne ad verilir?",
                options = listOf("Supervisor", "Watcher", "Rebooter", "Guardian"),
                correctIndex = 0,
                explanation = "Çöken süreçleri yeniden başlatan OTP bileşenine 'Supervisor' denir."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_ex_11",
                lessonId = "ex_11",
                title = "Şampiyon Durum Kontrolü",
                instructions = "durum :hazir ise {:ok, \"Çalışıyor\"}, değilse {:hata, \"Yeniden Başlat\"} döndüren sistem_durumu(durum) fonksiyonunu yazın.",
                exampleInput = "sistem_durumu(:hazir)",
                exampleOutput = "{:ok, \"Çalışıyor\"}",
                starterCode = "defmodule Sistem do\n  def sistem_durumu(durum) do\n    # Kodunu yaz:\n    {:ok, \"\"}\n  end\nend",
                solutionCode = "defmodule Sistem do\n  def sistem_durumu(:hazir), do: {:ok, \"Çalışıyor\"}\n  def sistem_durumu(_), do: {:hata, \"Yeniden Başlat\"}\nend",
                hints = listOf("def sistem_durumu(:hazir), do: {:ok, \"Çalışıyor\"} def sistem_durumu(_), do: {:hata, \"Yeniden Başlat\"} yazın."),
                testCases = listOf(
                    TestCase("Sistem.sistem_durumu(:hazir)", "{:ok, \"Çalışıyor\"}", "Hazır"),
                    TestCase("Sistem.sistem_durumu(:cöktü)", "{:hata, \"Yeniden Başlat\"}", "Çöktü")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "ex_quiz_11_1",
                    lessonId = "ex_11",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "GenServer içinde senkron (yanıt bekleyen) çağrılar için hangi fonksiyon kullanılır?",
                    options = listOf("GenServer.call()", "GenServer.cast()", "GenServer.send()", "GenServer.push()"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Senkron yanıt bekleyen çağrılar için 'call', asenkron için 'cast' kullanılır.",
                    explanationWrong = "GenServer.call() kullanılır.",
                    reviewTopic = "Elixir GenServer"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "GenServer.call ile GenServer.cast farkı nedir?",
                    answer = "call yanıt bekler (Senkron), cast ise mesajı fırlatıp yanıt beklemeden yoluna devam eder (Asenkron)."
                )
            ),
            completionCriteria = listOf(
                "Let It Crash felsefesini anlamak",
                "Supervisor ve GenServer görevini bilmek"
            )
        ),

        // ==========================================
        // DERS 12: PHOENIX VE ELIXIR USTALIĞI
        // ==========================================
        Lesson(
            id = "ex_12",
            courseId = "elixir",
            sectionId = "elixir_sec_6",
            title = "Phoenix Framework, Canlı Web ve Elixir Ustalığı",
            shortDesc = "Phoenix LiveView ile tek satır JS yazmadan gerçek zamanlı web uygulamaları ve geleceğin mimarisi.",
            level = CourseLevel.EXPERT,
            order = 12,
            isPremium = true,
            learningObjectives = listOf(
                "Phoenix Framework ve LiveView mimarisini kavramak",
                "JavaScript yazmadan sunucu taraflı gerçek zamanlı (WebSocket) UI üretmek",
                "Tebrikler: Artık çökmeyen, milyonluk sistemlerin aranan Elixir mimarısınız!"
            ),
            prerequisites = listOf("Tüm Elixir Konuları"),
            subtopics = listOf("Phoenix Framework", "Phoenix LiveView", "Tebrikler ve Tavsiyeler"),
            detailedExplanation = listOf(
                LessonContentBlock(
                    subtitle = "1. Tebrikler! Elixir Yolculuğunu Başarıyla Tamamladınız! 💧🏆",
                    body = "Artık Immutability, Pattern Matching, Pipe (|>) zincirleri, Aktör Modeli eşzamanlılığı ve OTP Supervisor mimarisine tam anlamıyla hakimsiniz.\n\nPhoenix LiveView ile React/Vue karmaşasına girmeden saniyede 2 milyon kullanıcının anlık etkileşimde bulunduğu canlı web platformları inşa edebilirsiniz!"
                )
            ),
            codeExample = "# Elixir Ustası Oldunuz!\nIO.puts(\"Elixir Seviyeniz: EFSANE! 💧✨\")",
            codeExplanation = "Elixir yolculuğunuz başarıyla tamamlandı.",
            realWorldExample = "Discord, Bleacher Report ve PepsiCo gerçek zamanlı canlı sistemlerini Phoenix ile ölçeklemiştir.",
            practicalTask = "Elixir başarınızı kutlayın!",
            starterPlaygroundCode = "# Harika bir Elixir geliştiricisisiniz!",
            miniQuestion = MiniQuestion(
                id = "ex_q_12",
                question = "Elixir dünyasında tek satır JavaScript yazmadan zengin ve gerçek zamanlı web arayüzleri geliştirmeyi sağlayan devrimsel çatı hangisidir?",
                options = listOf("Phoenix LiveView", "React", "Vue", "Angular"),
                correctIndex = 0,
                explanation = "Gerçek zamanlı web devrimi 'Phoenix LiveView' çatısı ile sağlanır."
            ),
            codingChallenge = CodingChallenge(
                id = "cc_ex_12",
                lessonId = "ex_12",
                title = "Şampiyon Elixir Mesajı",
                instructions = "Üstünde 'Elixir Şampiyonu' yazan metni döndüren sampiyon() fonksiyonunu yazın.",
                exampleInput = "sampiyon()",
                exampleOutput = "\"Elixir Şampiyonu\"",
                starterCode = "defmodule Zafer do\n  def sampiyon do\n    # Kodunu yaz:\n    \"\"\n  end\nend",
                solutionCode = "defmodule Zafer do\n  def sampiyon do\n    \"Elixir Şampiyonu\"\n  end\nend",
                hints = listOf("\"Elixir Şampiyonu\" yazın."),
                testCases = listOf(
                    TestCase("Zafer.sampiyon()", "Elixir Şampiyonu", "Şampiyon testi")
                )
            ),
            quizQuestions = listOf(
                QuizQuestion(
                    id = "ex_quiz_12_1",
                    lessonId = "ex_12",
                    questionType = QuestionType.MULTIPLE_CHOICE,
                    questionText = "Elixir paket yöneticisinin ve kütüphane ekosisteminin adı nedir?",
                    options = listOf("Hex (Hex.pm)", "NPM", "Pip", "Cargo"),
                    correctOptionIndex = 0,
                    explanationRight = "Doğru! Elixir ve Erlang paket yöneticisi Hex'tir.",
                    explanationWrong = "Hex (Hex.pm) paket yöneticisidir.",
                    reviewTopic = "Elixir Ekosistemi"
                )
            ),
            qaItems = listOf(
                TopicQAItem(
                    question = "Mix nedir?",
                    answer = "Elixir projeleri oluşturmak, derlemek, test etmek ve paket yönetmek için kullanılan resmi komut satırı aracıdır (mix new, mix phx.server)."
                )
            ),
            completionCriteria = listOf(
                "Elixir ve OTP felsefesini tam kavramak",
                "Gerçek zamanlı ve yüksek dayanıklılıklı sistemler kurmaya hazır olmak"
            )
        )
    )
}
