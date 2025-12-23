# News App

## Deskripsi Aplikasi
News App adalah aplikasi Android sederhana yang menampilkan daftar berita terbaru dari NewsAPI.  
Aplikasi ini dibuat sebagai bagian dari **Final Task Rakamin Mobile Developer** untuk menerapkan konsep **MVVM Architecture**, **RecyclerView**, dan **API Integration** menggunakan Android Studio.

Pengguna dapat melihat daftar berita, serta membuka sumber berita melalui browser.

---

## Tujuan Tugas
- Mengimplementasikan arsitektur **MVVM**
- Menampilkan data menggunakan **RecyclerView**
- Mengonsumsi **REST API** menggunakan Retrofit
- Mengelola data model menggunakan **data class**
- Mengambil data dari **NewsAPI**
- Menampilkan detail berita
- Menggunakan **ViewBinding**
- Mengelola resource (colors, drawable, layout)

---

## Teknologi & Library
- **Kotlin**
- **Android Studio**
- **MVVM Architecture**
- **RecyclerView**
- **ViewModel & LiveData**
- **ViewBinding**
- **Retrofit**
- **Gson Converter**
- **Coil** (Image Loader)

---
## Struktur Folder

```
dev.rakamin.newsapp
├── data
│   └── NewsRepository.kt
│
├── models
│   ├── Article.kt
│   └── NewsResponse.kt
│
├── network
│   ├── NewsInterface.kt
│   └── RetrofitClient.kt
│
├── ui
│   ├── MainActivity.kt
│   └── NewsAdapter.kt
│
├── utils
│   └── DateFormatter.kt
│
├── viewmodel
│   └── NewsViewModel.kt
│
├── androidTest
├── test
```

## Resource Folder
```
res
├── drawable
│   ├── bg_category_tag.xml
│   ├── ic_calendar.xml
│   ├── ic_image_placeholder.xml
│   ├── ic_launcher_background.xml
│   ├── ic_launcher_foreground.xml
│   ├── ic_mandir.xml
│   └── ic_user.xml
│
├── layout
│   ├── activity_main.xml
│   ├── item_article.xml
│   └── item_headline.xml
│
├── mipmap
│   ├── ic_launcher
│   └── ic_launcher_round
│
├── values
│   ├── colors.xml
│   ├── strings.xml
│   └── themes.xml
│
├── xml
│   ├── backup_rules.xml
│   └── data_extraction_rules.xml
```
---

## Data Model
Aplikasi menggunakan `data class Article` untuk menampung data berita dari API, seperti:
- Judul berita
- Nama sumber
- Gambar
- Tanggal publikasi
- URL berita

---

## Resource
- **colors.xml**  
  Digunakan untuk menyimpan warna aplikasi agar konsisten dan mudah dikelola.
- **ic_image_placeholder**  
  Digunakan sebagai gambar default ketika gambar berita gagal dimuat atau masih loading.
- **layout XML** 
  Digunakan untuk mengatur tampilan UI utama dan item RecyclerView

---

## 🧪 Fitur Utama
- Menampilkan daftar berita
- Menampilkan detail berita
- Membuka link berita di browser
- Menampilkan gambar berita dari URL
- Placeholder image saat loading

---

## Cara Menjalankan Aplikasi
1. Clone repository ini
2. Buka project menggunakan **Android Studio**
3. Pastikan koneksi internet aktif
4. Jalankan aplikasi menggunakan emulator atau perangkat fisik
