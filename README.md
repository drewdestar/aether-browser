# 🚀 AETHER BROWSER

**Jelajahi dengan tenang.** Aether adalah browser Android modern yang meniru visual dan interaksi Safari iOS 26, dengan fokus pada privasi, kecepatan, dan pengalaman yang tenang.

## 🎨 Fitur Utama

### 🖼️ Desain & UI
- **Liquid Glass Design** - UI transparan dengan efek blur, adaptif terhadap halaman web
- **3 Layout Tab** - Compact (default), Bottom, dan Top
- **Floating Elements** - URL bar dan kontrol mengambang dengan sudut membulat
- **Animasi Halus** - Durasi 300-400ms, ease-in-out
- **Dark/Light/System Theme** - Dukungan tema lengkap

### 🌐 Browser Features
- **URL Bar** - Autocomplete, security indicators, progress loading
- **Tab Management** - Create, close, switch, duplicate, pin tabs
- **Bookmark & History** - Organisasi lengkap dengan search
- **Download Manager** - Manajemen file download
- **Find in Page** - Cari teks dengan highlight
- **Desktop Mode** - Toggle mobile/desktop view
- **Reader Mode** - Ekstrak konten artikel
- **Screenshot** - Full-page screenshot dengan edit

### 🔒 Privasi & Keamanan
- **Private Relay (VPN via Tor/Proxy)** - Menyembunyikan IP dan mengenkripsi lalu lintas
- **Private Browsing** - Tidak simpan history, cookie, cache
- **Anti-Tracking** - Blokir tracker & iklan
- **Kelola Data Situs** - View dan hapus cookie per site
- **GPS Spoofing** - Lokasi kustom
- **Safe Browsing** - Peringatan situs berbahaya
- **App Lock** - PIN/Biometrik untuk akses

### 📝 Fitur Tambahan
- **Notes** - Catatan pribadi terenkripsi
- **Password Manager** - Simpan & autofill password dengan Master Password
- **Custom Search Engine** - Tambah search engine custom
- **AI Lokal & Cloud** - Chat AI offline/online, search web, summarize artikel

## 🛠️ Teknologi

- **Language**: Kotlin 100%
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM
- **Database**: Room (SQLite)
- **WebEngine**: Android WebView
- **Networking**: OkHttp + Retrofit
- **Encryption**: AES-256 + Android Keystore
- **Target SDK**: Android 14 (API 34)
- **Min SDK**: Android 10 (API 29)

## 📁 Project Structure

```
app/src/main/
├── java/com/newr/aether/
│   ├── MainActivity.kt
│   ├── SettingsActivity.kt
│   ├── SplashActivity.kt
│   ├── ui/
│   │   ├── BrowserScreen.kt
│   │   ├── components/
│   │   └── theme/
│   ├── viewmodel/
│   ├── model/
│   ├── data/local/
│   ├── service/
│   ├── utils/
│   └── di/
└── res/
    ├── drawable/
    ├── values/
    └── ...
```

## 🚀 Mulai Develop

### Prerequisites
- Android Studio Hedgehog+
- Kotlin 1.9+
- Gradle 8.0+

### Build
```bash
./gradlew build
```

### Run
```bash
./gradlew installDebug
```

## 📋 Development Roadmap

1. ✅ UI dasar dengan Compose
2. ✅ WebView dan tab management
3. ⏳ Bookmark & History
4. ⏳ Privacy features (VPN, Private Browsing, Anti-Tracking)
5. ⏳ Password Manager & Notes
6. ⏳ AI Integration (Lokal & Cloud)
7. ⏳ Settings & Preferences
8. ⏳ Testing & Optimization

## 🔐 Privacy Policy

Aether tidak pernah mengirim data pengguna ke server manapun. Semua data tersimpan lokal dan terenkripsi. Tidak ada tracking, analytics, atau telemetry.

## 📄 Lisensi

Open Source - MIT License

## 👥 Tim

Powered by **NEWR**

## 📱 Sosial

- 💬 [Discord](https://discord.gg/vZU3KzEh6a)
- 🐦 X (Soon)
- 📸 Instagram (Soon)

---

**Jelajahi web dengan tenang dan aman bersama Aether.** ⭐
