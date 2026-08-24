package com.example.model

enum class AppLanguage(
    val code: String,
    val displayName: String,
    val nativeName: String,
    val flagEmoji: String,
    val description: String
) {
    TR(
        code = "tr",
        displayName = "Türkçe",
        nativeName = "Türkçe",
        flagEmoji = "🇹🇷",
        description = "Türkçe arayüz, adım adım anlatımlar ve ipuçları"
    ),
    EN(
        code = "en",
        displayName = "English",
        nativeName = "English",
        flagEmoji = "🇬🇧",
        description = "English interface, step-by-step guides & hints"
    );

    companion object {
        fun fromCode(code: String?): AppLanguage {
            if (code == null) return TR
            return values().firstOrNull { it.code.equals(code, ignoreCase = true) } ?: TR
        }
    }
}
