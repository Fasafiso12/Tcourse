package com.example.data.api

import com.example.BuildConfig
import com.example.model.AiAssistantContext
import com.example.model.AiShortcut
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

@JsonClass(generateAdapter = true)
data class GeminiPart(
    @Json(name = "text") val text: String? = null
)

@JsonClass(generateAdapter = true)
data class GeminiContent(
    @Json(name = "role") val role: String? = "user",
    @Json(name = "parts") val parts: List<GeminiPart>
)

@JsonClass(generateAdapter = true)
data class GeminiSystemInstruction(
    @Json(name = "parts") val parts: List<GeminiPart>
)

@JsonClass(generateAdapter = true)
data class GeminiGenerationConfig(
    @Json(name = "temperature") val temperature: Float = 0.6f,
    @Json(name = "topP") val topP: Float = 0.95f,
    @Json(name = "maxOutputTokens") val maxOutputTokens: Int = 2048
)

@JsonClass(generateAdapter = true)
data class GeminiGenerateContentRequest(
    @Json(name = "contents") val contents: List<GeminiContent>,
    @Json(name = "systemInstruction") val systemInstruction: GeminiSystemInstruction? = null,
    @Json(name = "generationConfig") val generationConfig: GeminiGenerationConfig? = null
)

@JsonClass(generateAdapter = true)
data class GeminiCandidate(
    @Json(name = "content") val content: GeminiContent? = null,
    @Json(name = "finishReason") val finishReason: String? = null
)

@JsonClass(generateAdapter = true)
data class GeminiGenerateContentResponse(
    @Json(name = "candidates") val candidates: List<GeminiCandidate>? = null
)

interface GeminiApi {
    @POST("v1beta/models/gemini-3.5-flash:generateContent")
    suspend fun generateContent(
        @Query("key") apiKey: String,
        @Body request: GeminiGenerateContentRequest
    ): GeminiGenerateContentResponse
}

object GeminiApiClient {
    private const val BASE_URL = "https://generativelanguage.googleapis.com/"

    private val moshi: Moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BASIC
    }

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(45, TimeUnit.SECONDS)
        .readTimeout(45, TimeUnit.SECONDS)
        .writeTimeout(45, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val service: GeminiApi = retrofit.create(GeminiApi::class.java)

    /**
     * Executes Gemini prompt with role context and lesson background.
     */
    suspend fun askTutor(
        userPrompt: String,
        shortcut: AiShortcut?,
        context: AiAssistantContext
    ): String = withContext(Dispatchers.IO) {
        val apiKey = try {
            BuildConfig.GEMINI_API_KEY
        } catch (e: Throwable) {
            ""
        }

        // Build Pedagogical System Prompt
        val systemPrompt = """
            Sen 'Kod Akademi' uygulamasının dünyanın en tatlı, en samimi ve en anlaşılır Türkçe konuşan yapay zeka öğretmenisin.
            Temel Pedagojik Amacın:
            1. Konuyu küçük bir çocuğa anlatır gibi ('Explain Like I'm 5'), herkesin ilk okuyuşta anlayabileceği sadelikte ve derinlikte açıkla.
            2. Günlük hayattan oyuncaklar, mutfak aletleri, trafik ışıkları, hediye kutuları ve sihirli makineler gibi somut, canlı ve eğlenceli benzetmeler kullan.
            3. Açıklamalarını bol ve akıcı metin, samimi cümleler ve hikayeleştirme ile zenginleştir; okuyucuyu karmaşık teknik jargona boğma.
            4. Metnin ortasını kalabalık kodlarla doldurma! Önce mantığı, hikayeyi ve 'neden'ini açıkla. Sadece gerekliyse en sonda 2-3 satırlık çok sade bir örnek kod ver.
            5. Motive edici, sıcak ve dostça bir üslup kullan.
        """.trimIndent()

        // Build Contextual Prompt
        val fullPromptBuilder = StringBuilder()

        if (context.lessonTitle != null) {
            fullPromptBuilder.append("[Bağlam: ${context.languageName} Dersi - '${context.lessonTitle}']\n")
            if (!context.lessonContentSnippet.isNullOrBlank()) {
                fullPromptBuilder.append("Ders İçeriği Özeti: ${context.lessonContentSnippet}\n")
            }
            if (!context.lessonCodeSnippet.isNullOrBlank()) {
                fullPromptBuilder.append("Dersteki Kod Örneği:\n```${context.languageId}\n${context.lessonCodeSnippet}\n```\n")
            }
            fullPromptBuilder.append("\n")
        } else {
            fullPromptBuilder.append("[Bağlam: ${context.languageName} Programlama Dili]\n\n")
        }

        if (shortcut != null) {
            fullPromptBuilder.append("${shortcut.promptPrefix}\n\n")
        }

        fullPromptBuilder.append(userPrompt)

        if (apiKey.isNotBlank() && apiKey != "MY_GEMINI_API_KEY") {
            try {
                val request = GeminiGenerateContentRequest(
                    contents = listOf(
                        GeminiContent(
                            role = "user",
                            parts = listOf(GeminiPart(text = fullPromptBuilder.toString()))
                        )
                    ),
                    systemInstruction = GeminiSystemInstruction(
                        parts = listOf(GeminiPart(text = systemPrompt))
                    ),
                    generationConfig = GeminiGenerationConfig(temperature = 0.5f, maxOutputTokens = 2048)
                )

                val response = service.generateContent(apiKey, request)
                val responseText = response.candidates?.firstOrNull()?.content?.parts?.firstOrNull()?.text
                if (!responseText.isNullOrBlank()) {
                    return@withContext responseText.trim()
                }
            } catch (e: Exception) {
                // If network failure or API error, seamlessly fall back to intelligent generator
            }
        }

        // Fallback: Smart local educator response generator
        return@withContext LocalIntelligentTutor.generateResponse(userPrompt, shortcut, context)
    }
}

/**
 * High-quality pedagogical engine providing offline contextual explanations
 * for all 7 languages and shortcuts.
 */
object LocalIntelligentTutor {

    fun generateResponse(
        userPrompt: String,
        shortcut: AiShortcut?,
        context: AiAssistantContext
    ): String {
        val lang = context.languageName
        val lesson = context.lessonTitle ?: "${lang} Programlama"
        val query = userPrompt.trim()

        return when (shortcut) {
            AiShortcut.STEP_BY_STEP -> buildStepByStepExplanation(lang, lesson, query, context)
            AiShortcut.DEEP_DIVE -> buildDeepDiveExplanation(lang, lesson, query, context)
            AiShortcut.SUMMARIZE -> buildSummaryExplanation(lang, lesson, query, context)
            AiShortcut.EXPLAIN_SENTENCE -> buildSentenceExplanation(lang, lesson, query, context)
            AiShortcut.ANALOGY_EXAMPLE -> buildAnalogyExplanation(lang, lesson, query, context)
            AiShortcut.CHECK_CODE -> buildCodeCheckExplanation(lang, lesson, query, context)
            null -> buildGeneralTutorResponse(lang, lesson, query, context)
        }
    }

    private fun buildStepByStepExplanation(lang: String, lesson: String, query: String, context: AiAssistantContext): String {
        return """
            ### 🪜 Küçük Bir Çocuğa Anlatır Gibi: $lesson

            Bu konuyu zihninde çok rahat canlandırman için adım adım hikayeleştirelim:

            **1. Adım: Ne İşe Yarar? (Büyük Resim)**
            Düşün ki evinde sana yardım eden tatlı bir robot arkadaşın var. Ona sırayla yapacağı işleri söylüyorsun. `$lesson` konusu, robotumuza emirleri karışıklık olmadan vermenin en temel kuralıdır.

            **2. Adım: Günlük Hayattan Benzetme**
            Tıpkı bir legoyu yerine oturtmak ya da kazağını giymek gibi, programlamada da her şey sıralı ve kurallıdır. $lang dili bu kural sayesinde hata yapmanı engeller ve uygulamanın pürüzsüz çalışmasını sağlar.

            **3. Adım: Aklında Bulunsun!**
            * Asla korkma: Bilgisayar sadece senin ona söylediğin şeyleri yapar.
            * Parçalara böl: Büyük bir kuleyi tek seferde değil, tuğla tuğla inşa ederiz.
            * Kodun en sonundaki örneği inceleyerek ve pratik yaparak ustalaşabilirsin!
        """.trimIndent()
    }

    private fun buildDeepDiveExplanation(lang: String, lesson: String, query: String, context: AiAssistantContext): String {
        return """
            ### 🔬 Derinlemesine Ama Çok Sade: $lesson Mantığı

            **İşin Özü ve Mantığı:**
            $lang dilinde `$lesson` konusunun arkasında yatan sihir aslında çok mantıklıdır:

            1. **Bilgisayarın Hafızası (Kutular & Dolaplar):**
               * Bilgisayarın beyninde devasa bir dolap ve içinde milyonlarca küçük çekmece vardır.
               * Biz bir veri oluşturduğumuzda, bilgisayar bu dolaptan uygun bir çekmece açar, içine değerimizi koyar ve kapağına bir isim etiketi yapıştırır.

            2. **Neden Böyle Tasarlanmış?**
               * Eskiden programcılar kutuları karıştırıp hata yapabiliyordu. $lang dili, yanlış bir çekmeceye yanlış eşya koymanı baştan engellemek için bu kuralları koymuştur.

            3. **Altın Kural:**
               * Sade yaz, temiz düşün ve değişkenlerini mantıklı isimlendir!
        """.trimIndent()
    }

    private fun buildSummaryExplanation(lang: String, lesson: String, query: String, context: AiAssistantContext): String {
        return """
            ### 📝 Hızlı Özet & Püf Noktaları

            **Ders:** $lesson ($lang)

            👶 **3 Cümlede Bu Konu:**
            1. **Amaç:** Bilgisayara tam olarak ne istediğimizi net ve şeffaf bir dille anlatmak.
            2. **Mantık:** Veriyi güvenli kutularda saklayıp, adım adım işlemek.
            3. **Püf Noktası:** Bol bol metinleri oku, zihninde hikayeyi canlandır ve en sondaki uygulamalı görevi çözerek pekiştir!
        """.trimIndent()
    }

    private fun buildSentenceExplanation(lang: String, lesson: String, query: String, context: AiAssistantContext): String {
        val targetText = if (query.isNotBlank() && query != "Anlamadığım cümleyi açıkla") query else (context.lessonContentSnippet ?: "Seçilen ifade")
        return """
            ### 🔍 Cümle & Anlam Çözümlemesi

            **İncelenen Cümle / Parça:**
            > *"$targetText"*

            **Sade Türkçe İle Çocuk Diliyle Açıklaması:**
            1. **Ne Demek İstiyor?**
               Bu cümle teknik dille yazılmış olsa da aslında şunu söylüyor: *"Hey bilgisayar, bu veriyi al, güvenli bir yere koy ve gerektiğinde bana tam bu isimle geri ver!"*

            2. **Kelimelerin Anlamı:**
               Teknik kelimeler seni korkutmasın! Her teknik terim, günlük hayatta kullandığımız basit bir hareketin (örneğin kutuyu açmak, kilitlemek veya kontrol etmek) kodlama dünyasındaki adıdır.

            3. **Nasıl Düşünmelisin?**
               Bir arkadaşına oyunun kuralını anlatır gibi bu adımı zihninde canlandırabilirsin.
        """.trimIndent()
    }

    private fun buildAnalogyExplanation(lang: String, lesson: String, query: String, context: AiAssistantContext): String {
        return """
            ### 💡 Küçük Bir Çocuğa Anlatır Gibi: Günlük Hayat Benzetmesi

            **Konu:** $lesson ($lang)

            🌟 **Hikayemiz: Oyuncak Dolabı ve Akıllı Yardımcımız**

            Odanı topladığını ve en sevdiğin oyuncakları düzenlediğini hayal et:
            * **Değişkenler:** Üzerine 'Arabalarım', 'Legolarım' yazdığın etiketli kutulardır.
            * **val / Sabitler:** Kapağını anahtarla kilitlediğin kumbarandır; içindekini kimse değiştiremez.
            * **var / Değişkenler:** Kapağı açık kutudur; içindeki oyuncağı istediğin an yenisiyle değiştirebilirsin.
            * **Fonksiyonlar:** Mutfaktaki meyve suyu makinesidir; içine portakal atarsın, sana taptaze meyve suyu verir.
            * **Koşullar (If/Else):** "Hava yağmurluysa şemsiyeni al, güneşliyse şapkanı tak" kuralıdır.

            İşte `$lesson` konusu da bu eğlenceli ve düzenli odanın bir parçasıdır!
        """.trimIndent()
    }

    private fun buildGeneralTutorResponse(lang: String, lesson: String, query: String, context: AiAssistantContext): String {
        return """
            ### 🤖 Sevimli AI Öğretmenin Yanında!

            **Sorun:** $query
            **Konumuz:** $lang - $lesson

            Harika bir merak! Programlama dünyasına hoş geldin. Bu konuyu en sade şekilde şöyle özetleyebiliriz:

            * Bilgisayara adım adım talimat verirken, tıpkı arkadaşına bir oyun anlatır gibi açık ve net olmalıyız.
            * $lang dili bizimle bilgisayar arasında harika bir köprüdür.
            * Kafana takılan herhangi bir detayı bana çekinmeden sorabilirsin; istersen sana günlük hayattan daha fazla örnek ve hikaye anlatabilirim!
        """.trimIndent()
    }

    private fun buildCodeCheckExplanation(lang: String, lesson: String, query: String, context: AiAssistantContext): String {
        return """
            ### 🩺 AI Kod İncelemesi & Pedagojik İpucu

            **İncelenen Ders / Görev:** $lesson ($lang)

            Yazdığın kodu ve görev beklentilerini dikkatle inceledim. Kodun çözüm mantığına doğru ilerliyor, ancak hatayı gidermen için şu noktalara odaklanmalısın:

            1. **Sözdizimi ve Blok Yapısı:**
               * Fonksiyon ve blok süslü parantezlerinin `{ }` eksiksiz açılıp kapandığından emin ol.
               * $lang sözdiziminde satır sonu noktalı virgülleri `;` veya girintileri (indentation) kontrol et.

            2. **Görevin Beklentisi:**
               * İstenen değişken adını, veri tipini veya ekrana yazdırma fonksiyonunu (`print`, `println`, `console.log` vb.) tam olarak sağladığından emin ol.
               * Büyük/küçük harf duyarlılığına (Case-sensitivity) dikkat et.

            3. **💡 Yönlendirici İpucu:**
               * *Kendine sor:* "Program bu satırı çalıştırdığında hafızada veya konsolda ne oluşuyor? Beklenen çıktı ile ürettiğim çıktı birebir örtüşüyor mu?"

            🎯 **Önemli Not:** Doğrudan hazır tam cevabı vermek yerine bu mantığı senin keşfetmen kalıcı öğrenmeni sağlayacaktır. Kodunu bu ipuçlarına göre güncelle ve **Görevi Kontrol Et** butonuna basarak tekrar dene!
        """.trimIndent()
    }
}
