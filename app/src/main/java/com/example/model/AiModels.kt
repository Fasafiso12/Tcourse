package com.example.model

enum class AiShortcut(
    val id: String,
    val title: String,
    val shortLabel: String,
    val iconEmoji: String,
    val description: String,
    val promptPrefix: String
) {
    STEP_BY_STEP(
        id = "step_by_step",
        title = "Adım Adım Açıklama",
        shortLabel = "Adım Adım",
        iconEmoji = "🪜",
        description = "Konuyu sıfırdan, en temelden başlayarak numaralandırılmış basit adımlarla anlatır.",
        promptPrefix = "Lütfen bu konuyu veya kodu bir programlama öğrencisine en baştan, adım adım (1, 2, 3...) mantıksal sırayla ve çok net örneklerle açıkla:"
    ),
    DEEP_DIVE(
        id = "deep_dive",
        title = "Derinlemesine Açıklama",
        shortLabel = "Derinlemesine",
        iconEmoji = "🔬",
        description = "Mimarisi, arka planda (under the hood) nasıl çalıştığı, bellek ve performans detayları.",
        promptPrefix = "Lütfen bu konuyu derinlemesine incele. Arka planda derleyici/çalışma zamanı seviyesinde ne olduğunu, bellek yönetimini ve ileri seviye kullanım püf noktalarını açıkla:"
    ),
    SUMMARIZE(
        id = "summarize",
        title = "Konuyu Özetle",
        shortLabel = "Özetle",
        iconEmoji = "📝",
        description = "Konunun en önemli noktaları, püf noktaları ve hızlı akılda kalıcı hap özet (TL;DR).",
        promptPrefix = "Lütfen bu konunun en can alıcı noktalarını özetle (TL;DR), akılda kalması gereken altın kuralları madde madde ve 1 adet mini kod örneğiyle sun:"
    ),
    EXPLAIN_SENTENCE(
        id = "explain_sentence",
        title = "Anlamadığım Cümleyi / Kodu Açıkla",
        shortLabel = "Cümleyi Açıkla",
        iconEmoji = "🔍",
        description = "Takıldığınız özel bir cümleyi, terimi veya kod satırını sade Türkçe ile netleştirir.",
        promptPrefix = "Kullanıcı şu cümleyi/kavramı veya kod satırını tam olarak anlayamadı. Lütfen bunu günlük sade bir dille, hiç karmaşık terim kullanmadan izah et:"
    ),
    ANALOGY_EXAMPLE(
        id = "analogy_example",
        title = "Günlük Hayat Benzetmesi",
        shortLabel = "Benzetme & Analoji",
        iconEmoji = "💡",
        description = "Gerçek hayat analojileri ve somut benzetmelerle konuyu zihinde canlandırır.",
        promptPrefix = "Lütfen bu programlama kavramını günlük hayattan çok eğlenceli ve akılda kalıcı bir benzetme (analoji) ile anlat:"
    ),
    CHECK_CODE(
        id = "check_code",
        title = "Kodu Kontrol Et & İpucu Ver",
        shortLabel = "Kodu Kontrol Et",
        iconEmoji = "🩺",
        description = "Yazdığınız koddaki hataları doğrudan cevabı söylemeden pedagojik ipuçlarıyla gösterir.",
        promptPrefix = "Lütfen kullanıcının yazdığı kodu incele. Kodundaki hataları, eksik veya hatalı sözdizimini pedagojik olarak açıkla. KESİNLİKLE doğrudan hazır tam çözümü veya çalışan bitmiş kodu verme; kullanıcının kendisinin bulması için yol gösterici ipuçları ve yönlendirmeler ver:"
    )
}

enum class AiMessageSender {
    USER,
    ASSISTANT
}

data class AiChatMessage(
    val id: String,
    val sender: AiMessageSender,
    val text: String,
    val shortcutUsed: AiShortcut? = null,
    val timestamp: Long = System.currentTimeMillis(),
    val relatedLessonId: String? = null,
    val relatedLanguageId: String? = null,
    val isError: Boolean = false
)

data class AiAssistantContext(
    val languageId: String = "dart",
    val languageName: String = "Dart",
    val lessonId: String? = null,
    val lessonTitle: String? = null,
    val lessonContentSnippet: String? = null,
    val lessonCodeSnippet: String? = null
)

data class AiAssistantState(
    val isOpen: Boolean = false,
    val isLoading: Boolean = false,
    val context: AiAssistantContext = AiAssistantContext(),
    val selectedShortcut: AiShortcut? = null,
    val confusingSentenceInput: String = "",
    val messages: List<AiChatMessage> = emptyList(),
    val errorMessage: String? = null
)
