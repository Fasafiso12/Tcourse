package com.example.data.catalog

import com.example.R
import com.example.model.*

/**
 * CourseCatalog central repository coordinating all 7 rich curricula
 * (Dart, Python, C++, Kotlin, Rust, JavaScript, Flutter).
 */
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
            totalLessonsCount = 12,
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
            totalLessonsCount = 12,
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
            totalLessonsCount = 12,
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
            totalLessonsCount = 12,
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
            totalLessonsCount = 12,
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
            totalLessonsCount = 12,
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
            totalLessonsCount = 12,
            isPopular = true,
            drawableRes = R.drawable.img_lang_flutter_1787396261102
        ),
        ProgrammingLanguage(
            id = "c",
            name = "C",
            tag = "System & Hardware",
            iconEmoji = "⚙️",
            colorHex = 0xFFA8B9CC,
            shortDescription = "Sistem programlama, işletim sistemleri, donanım kontrolü ve yüksek performanslı bellek mimarisi.",
            targetAudience = "Gömülü sistem, kernel ve performans mimarları",
            popularUses = listOf("Linux Çekirdeği", "Gömülü Cihazlar", "Oyun Motorları"),
            totalLessonsCount = 12,
            isPopular = true,
            drawableRes = R.drawable.img_lang_cpp_1787396210963
        ),
        ProgrammingLanguage(
            id = "lua",
            name = "Lua",
            tag = "Game Scripting & Embed",
            iconEmoji = "🌙",
            colorHex = 0xFF5C7CFA,
            shortDescription = "Oyun motorları (Roblox, Defold), script yazımı ve C/C++ entegrasyonu için hafif ve ultra hızlı dil.",
            targetAudience = "Roblox geliştiricileri, oyun tasarımcıları ve script yazarları",
            popularUses = listOf("Roblox Studio", "Oyun Scripting & AI", "Redis & Nginx Eklentileri"),
            totalLessonsCount = 12,
            isPopular = true,
            drawableRes = R.drawable.img_lang_javascript_1787396236459
        ),
        ProgrammingLanguage(
            id = "go",
            name = "Go",
            tag = "Cloud & Concurrency",
            iconEmoji = "🐹",
            colorHex = 0xFF00ADD8,
            shortDescription = "Google tarafından geliştirilen; ultra hafif Goroutines, yüksek derleme hızı ve bulut mimarileri için standart dil.",
            targetAudience = "Backend, bulut altyapısı ve mikroservis geliştiricileri",
            popularUses = listOf("Kubernetes & Docker", "Yüksek Hızlı API", "Mikroservisler"),
            totalLessonsCount = 12,
            isPopular = true,
            drawableRes = R.drawable.img_lang_kotlin_1787396247052
        ),
        ProgrammingLanguage(
            id = "elixir",
            name = "Elixir",
            tag = "OTP & Distributed",
            iconEmoji = "💧",
            colorHex = 0xFFA855F7,
            shortDescription = "Erlang BEAM sanal makinesinde çalışan; hata toleranslı, dağıtık ve milyonlarca eşzamanlı aktör yöneten fonksiyonel dil.",
            targetAudience = "Dağıtık sistemler, gerçek zamanlı sohbet ve yüksek erişilebilirlik mimarları",
            popularUses = listOf("Phoenix Canlı Web", "Dağıtık Sohbet & Oyun", "Finansal Sistemler"),
            totalLessonsCount = 12,
            isPopular = true,
            drawableRes = R.drawable.img_lang_dart_1787396183719
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
            "dart" -> DartCurriculum.getSections()
            "python" -> PythonCurriculum.getSections()
            "cpp" -> CppCurriculum.getSections()
            "kotlin" -> KotlinCurriculum.getSections()
            "rust" -> RustCurriculum.getSections()
            "javascript" -> JavaScriptCurriculum.getSections()
            "flutter" -> FlutterCurriculum.getSections()
            "c" -> CCurriculum.getSections()
            "lua" -> LuaCurriculum.getSections()
            "go" -> GoCurriculum.getSections()
            "elixir" -> ElixirCurriculum.getSections()
            else -> DartCurriculum.getSections()
        }
    }

    fun getLessonsForCourse(courseId: String): List<Lesson> {
        return when (courseId) {
            "dart" -> DartCurriculum.getLessons()
            "python" -> PythonCurriculum.getLessons()
            "cpp" -> CppCurriculum.getLessons()
            "kotlin" -> KotlinCurriculum.getLessons()
            "rust" -> RustCurriculum.getLessons()
            "javascript" -> JavaScriptCurriculum.getLessons()
            "flutter" -> FlutterCurriculum.getLessons()
            "c" -> CCurriculum.getLessons()
            "lua" -> LuaCurriculum.getLessons()
            "go" -> GoCurriculum.getLessons()
            "elixir" -> ElixirCurriculum.getLessons()
            else -> DartCurriculum.getLessons()
        }
    }

    // ==========================================
    // UYGULAMALI GERÇEK DÜNYA PROJELERİ
    // ==========================================
    val projects = listOf(
        ProjectItem(
            id = "proj_go_rate_limiter_pipeline",
            courseId = "go",
            title = "Goroutine & Channel Tabanlı Dağıtık Worker Pool & Rate Limiter",
            level = CourseLevel.EXPERT,
            description = "Token Bucket algoritması, context.WithTimeout iptal zincirleri, sync.WaitGroup ve saniyede 1 milyon isteği eriten yüksek hızlı Go iş kuyruğu.",
            learningObjectives = listOf("Goroutine Worker Pool", "Channel-based Rate Limiter", "context.Context Timeout Propagation", "sync.WaitGroup & Atomic Operations"),
            starterCode = "package main\n\n// Go Worker Pool & Rate Limiter mimarisini yazın",
            solutionCode = "package main\n\nimport (\n    \"context\"\n    \"sync\"\n    \"time\"\n)\n\ntype RateLimiter struct {\n    tokens chan struct{}\n}\n\nfunc NewRateLimiter(rate time.Duration) *RateLimiter {\n    rl := &RateLimiter{tokens: make(chan struct{}, 100)}\n    go func() {\n        for range time.Tick(rate) {\n            select { case rl.tokens <- struct{}{}: default: }\n        }\n    }()\n    return rl\n}"
        ),
        ProjectItem(
            id = "proj_elixir_otp_distributed_chat",
            courseId = "elixir",
            title = "GenServer & OTP Supervision Tabanlı Hata Toleranslı Dağıtık Sohbet & Cache",
            level = CourseLevel.EXPERT,
            description = "GenServer durum yönetimi, DynamicSupervisor çocuk denetimi, Registry PubSub ve BEAM düğümleri arası kümeleme ile sıfır kesintili dağıtık mesajlaşma motoru.",
            learningObjectives = listOf("GenServer State Management", "OTP Supervision Tree & Self-Healing", "Distributed Node Clustering", "Registry & PubSub Broadcast"),
            starterCode = "defmodule DistributedEngine do\n  use GenServer\n  # GenServer ve Supervisor motorunu yazın\nend",
            solutionCode = "defmodule ChatEngine do\n  use GenServer\n  def start_link(opts), do: GenServer.start_link(__MODULE__, opts, name: __MODULE__)\n  def init(state), do: {:ok, state}\n  def handle_call({:broadcast, msg}, _from, state) do\n    {:reply, :ok, [msg | state]}\n  end\nend"
        ),
        ProjectItem(
            id = "proj_c_arena_allocator",
            courseId = "c",
            title = "Zero-Fragmentation Arena & Pool Bellek Tahsisçisi",
            level = CourseLevel.EXPERT,
            description = "POSIX mmap, pointer hizalama (Memory Alignment), slab allocation ve O(1) sıfır maliyetli tampon bellek yöneticisi.",
            learningObjectives = listOf("Custom Arena Allocator", "Memory Alignment & Padding", "mmap / Virtual Memory", "O(1) Slab Allocation"),
            starterCode = "typedef struct {\n    unsigned char* buffer;\n    size_t capacity;\n    size_t offset;\n} Arena;\n\n// Arena kodunu yazın",
            solutionCode = "#include <stdlib.h>\n#include <stdint.h>\ntypedef struct { uint8_t* buf; size_t cap; size_t off; } Arena;\nArena* arena_init(size_t cap) {\n    Arena* a = malloc(sizeof(Arena));\n    a->buf = malloc(cap);\n    a->cap = cap; a->off = 0;\n    return a;\n}\nvoid* arena_alloc(Arena* a, size_t size) {\n    if (a->off + size > a->cap) return NULL;\n    void* p = &a->buf[a->off];\n    a->off += size;\n    return p;\n}"
        ),
        ProjectItem(
            id = "proj_lua_fsm_game_engine",
            courseId = "lua",
            title = "Metatable Tabanlı Reaktif FSM & Entity Component Motoru",
            level = CourseLevel.EXPERT,
            description = "Lua Metatables (__index), Coroutines ve Event-driven mimari ile 60 FPS Roblox/Oyun durum makinesi ve ECS mimarisi.",
            learningObjectives = listOf("Metatable OOP Architecture", "Coroutines & task.wait() loop", "Entity-Component-System (ECS)", "Event Bus Subscription"),
            starterCode = "local FSM = {}\nFSM.__index = FSM\n-- State Machine motorunu yazın",
            solutionCode = "local FSM = {}\nFSM.__index = FSM\nfunction FSM.new(initial)\n    return setmetatable({current = initial, listeners = {}}, FSM)\nend\nfunction FSM:transition(newState)\n    self.current = newState\n    for _, fn in ipairs(self.listeners) do fn(newState) end\nend"
        ),
        ProjectItem(
            id = "proj_dart_stream_bus",
            courseId = "dart",
            title = "Reaktif EventBus & Isolate İşlemcisi",
            level = CourseLevel.EXPERT,
            description = "Dart StreamController.broadcast, Isolates compute ve generic typed event bus mimarisi.",
            learningObjectives = listOf("StreamController.broadcast", "Isolates & compute()", "Generic EventBus"),
            starterCode = "class EventBus {\n  // EventBus kodunu yazın\n}",
            solutionCode = "import 'dart:async';\nclass EventBus {\n  final _controller = StreamController.broadcast();\n  Stream<T> on<T>() => _controller.stream.where((e) => e is T).cast<T>();\n  void fire(event) => _controller.add(event);\n}"
        ),
        ProjectItem(
            id = "proj_fl_bloc_crypto",
            courseId = "flutter",
            title = "BLoC & CustomPainter Kripto Grafik Motoru",
            level = CourseLevel.EXPERT,
            description = "Flutter BLoC durum yönetimi ve CustomPainter ile canlı borsa mum grafik çizim motoru.",
            learningObjectives = listOf("flutter_bloc State Machine", "CustomPainter 60 FPS Canvas", "WebSocket Stream"),
            starterCode = "class CandlestickPainter extends CustomPainter {\n  // Canvas çizimi yapın\n}",
            solutionCode = "import 'package:flutter/material.dart';\nclass CandlestickPainter extends CustomPainter {\n  @override\n  void paint(Canvas canvas, Size size) {\n    final paint = Paint()..color = Colors.green;\n    canvas.drawLine(Offset(10, 20), Offset(10, 80), paint);\n  }\n  @override\n  bool shouldRepaint(covariant CustomPainter oldDelegate) => true;\n}"
        ),
        ProjectItem(
            id = "proj_py_metaclass_orm",
            courseId = "python",
            title = "Metaclass & Descriptor Tabanlı Asenkron Mini ORM",
            level = CourseLevel.EXPERT,
            description = "type metaclass, Descriptors ve asyncio ile tip güvenli sıfırdan Python ORM motoru.",
            learningObjectives = listOf("Python Metaclass", "Descriptors (__get__, __set__)", "asyncio & Connection Pool"),
            starterCode = "class ModelMeta(type):\n    # Metaclass yazın\n    pass",
            solutionCode = "class Field:\n    def __init__(self, f_type): self.f_type = f_type\n\nclass ModelMeta(type):\n    def __new__(cls, name, bases, attrs):\n        fields = {k: v for k, v in attrs.items() if isinstance(v, Field)}\n        attrs['_fields'] = fields\n        return super().__new__(cls, name, bases, attrs)"
        ),
        ProjectItem(
            id = "proj_kt_kmp_mvi",
            courseId = "kotlin",
            title = "KMP & Kotlin Coroutines StateFlow MVI Motoru",
            level = CourseLevel.EXPERT,
            description = "Kotlin Multiplatform (KMP), StateFlow, SharedFlow ve Unidirectional Data Flow MVI mimarisi.",
            learningObjectives = listOf("MVI Architecture", "StateFlow & SharedFlow", "KMP Architecture"),
            starterCode = "interface MviViewModel<I, S> {\n  // MVI kontratını yazın\n}",
            solutionCode = "import kotlinx.coroutines.flow.*\ninterface MviIntent\ninterface MviState\nabstract class BaseViewModel<I: MviIntent, S: MviState>(initialState: S) {\n  private val _state = MutableStateFlow(initialState)\n  val state: StateFlow<S> = _state.asStateFlow()\n}"
        ),
        ProjectItem(
            id = "proj_cpp_lockfree_mempool",
            courseId = "cpp",
            title = "Lock-Free Ring Buffer & Sabit Boyutlu Memory Pool",
            level = CourseLevel.EXPERT,
            description = "std::atomic, std::memory_order_acquire/release ve Placement new ile sıfır kilitli mikro-saniye bellek havuzu.",
            learningObjectives = listOf("Lock-free Ring Buffer", "std::atomic & Memory Ordering", "Custom Memory Pool & Placement New"),
            starterCode = "template<typename T, size_t Cap>\nclass LockFreeQueue {\n  // Queue kodunu yazın\n};",
            solutionCode = "#include <atomic>\ntemplate<typename T, size_t Cap>\nclass LockFreeQueue {\n    std::atomic<size_t> head_{0};\n    std::atomic<size_t> tail_{0};\n    T buffer_[Cap];\npublic:\n    bool push(const T& val) {\n        size_t h = head_.load(std::memory_order_relaxed);\n        buffer_[h % Cap] = val;\n        head_.store(h + 1, std::memory_order_release);\n        return true;\n    }\n};"
        ),
        ProjectItem(
            id = "proj_rs_highthroughput_queue",
            courseId = "rust",
            title = "Lock-Free Ring Buffer & Type-State Network Soketi",
            level = CourseLevel.EXPERT,
            description = "Atomics (Acquire/Release), Type-state soket durum makinesi (Disconnected -> Handshake -> Connected) ve ZST PhantomData kullanan yüksek verimli sıfır kopyalı ağ motoru.",
            learningObjectives = listOf("Lock-Free Atomics", "Type-State Design Pattern", "Zero-Copy Ring Buffer", "PhantomData ZST"),
            starterCode = "pub struct NetworkEngine {\n  // Lock-free motoru yazın\n}",
            solutionCode = "use std::sync::atomic::{AtomicUsize, Ordering};\npub struct RingBuffer {\n  head: AtomicUsize,\n  tail: AtomicUsize,\n}\nimpl RingBuffer {\n  pub fn new() -> Self { Self { head: AtomicUsize::new(0), tail: AtomicUsize::new(0) } }\n  pub fn push(&self) { self.head.fetch_add(1, Ordering::Release); }\n}"
        ),
        ProjectItem(
            id = "proj_js_wasm_signal_processor",
            courseId = "javascript",
            title = "Web Worker & TypedArray Tabanlı Yüksek Hızlı Sinyal Filtresi",
            level = CourseLevel.EXPERT,
            description = "SharedArrayBuffer, Float32Array ve Web Workers kullanarak UI thread'ini 1 milisaniye bile dondurmadan 1 milyon veri noktasını filtreleyen reaktif veri motoru.",
            learningObjectives = listOf("Web Workers Parallel Processing", "SharedArrayBuffer", "Float32Array TypedArrays", "Proxy Reactive UI Binding"),
            starterCode = "class SignalEngine {\n  // Mimariyi kurun\n}",
            solutionCode = "class SignalEngine {\n  constructor() {\n    this.buffer = new Float32Array(10000);\n  }\n  process() {\n    return this.buffer.map(x => Math.sin(x));\n  }\n}"
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
