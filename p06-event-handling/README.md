# Laporan Latihan Mandiri PBO 2 -- Pertemuan 6

## Validasi Input dan Kegunaan (Usability)

### Identitas

  Keterangan    Data
  ------------- --------------------------------------------
  Nama          Adib Baraa Taufani
  NPM           2410010071
  Mata Kuliah   Pemrograman Berorientasi Objek 2
  Materi        Pertemuan 6 -- Validasi Input dan Kegunaan
  Project       `p06-validasi-input`

------------------------------------------------------------------------

## 1. Dokumentasi Peer Review

Lampirkan foto atau hasil pindai lembar peer review yang telah diisi
oleh teman pada bagian berikut.

**Foto/pindaian lembar peer review:**

> Ganti bagian ini dengan foto peer review yang benar-benar diterima
> dari teman. Simpan gambar di folder `screenshots`, lalu ubah nama file
> pada contoh di bawah.

![Lembar peer review](screenshots/peer-review.jpg)

Nama peninjau: **\[Isi nama teman yang melakukan review\]**

## 2. Temuan Peer Review dan Perbaikan

Isi tabel ini berdasarkan hasil peer review yang benar-benar diterima.
Contoh di bawah merupakan format pencatatan, bukan klaim bahwa temuan
tersebut sudah disampaikan oleh peninjau.

  ----------------------------------------------------------------------------
  No.               Temuan dari teman Perbaikan yang    Commit
                                      dilakukan         
  ----------------- ----------------- ----------------- ----------------------
  1                 \[Tuliskan temuan \[Tuliskan        `[hash/nama commit]`
                    pertama dari      perbaikan yang    
                    lembar peer       benar-benar       
                    review\]          dilakukan\]       

  2                 \[Tuliskan temuan \[Tuliskan        `[hash/nama commit]`
                    kedua dari lembar perbaikan yang    
                    peer review\]     benar-benar       
                                      dilakukan\]       

  3                 \[Tuliskan temuan \[Tuliskan        `[hash/nama commit]`
                    berikutnya jika   perbaikan yang    
                    ada\]             benar-benar       
                                      dilakukan\]       
  ----------------------------------------------------------------------------

**Catatan:** Setelah melakukan perbaikan, gunakan `git log --oneline`
untuk melihat commit yang memuat perubahan. Jangan mengisi hash commit
sebelum commit tersebut benar-benar dibuat.

## 3. Screenshot Form dengan Pesan Kesalahan

Jalankan `FormAnggotaPerpustakaan`, masukkan data yang tidak sesuai
aturan validasi, kemudian ambil screenshot yang memperlihatkan input
bertanda merah dan pesan kesalahan pada label di bawah input.

![Form dengan pesan kesalahan](screenshots/form-pesan-kesalahan.png)

**Keterangan:** Screenshot harus berasal dari aplikasi yang dijalankan.
Pastikan pesan kesalahan dan komponen input yang ditandai terlihat
jelas.

## 4. Screenshot Navigator

Ambil screenshot tab **Navigator** di NetBeans ketika
`FormAnggotaPerpustakaan` dibuka pada tampilan Design. Pastikan label
pesan validasi terlihat pada daftar komponen.

![Navigator menampilkan label
pesan](screenshots/navigator-label-pesan.png)

Label pesan yang perlu terlihat pada Navigator:

-   `npmPesanLabel`
-   `namaPesanLabel`
-   `emailPesanLabel`
-   `nomorHpPesanLabel`

**Keterangan:** Sesuaikan nama label di atas dengan nama komponen yang
benar-benar digunakan pada project. Screenshot harus memperlihatkan
Navigator NetBeans, bukan gambar ilustrasi.

## 5. Jawaban Eksperimen Praktikum 4

### 1. Ketik huruf pada isian NPM. Apa yang terjadi dan baris mana di `npmFieldKeyTyped` yang menyebabkannya?

Huruf tidak diterima pada isian NPM karena event `keyTyped` memeriksa
karakter yang diketik. Jika karakter bukan angka, event dibatalkan
menggunakan `evt.consume()`. Dengan demikian, hanya angka yang dapat
dimasukkan ke dalam isian NPM.

Contoh pemeriksaan:

``` java
char karakter = evt.getKeyChar();

if (!Character.isDigit(karakter)) {
    evt.consume();
}
```

### 2. Isi email dengan `siti@`, lalu tekan Tab. Kapan pesan kesalahan muncul?

Pesan kesalahan muncul ketika fokus meninggalkan isian email, yaitu saat
tombol Tab ditekan dan fokus berpindah ke komponen berikutnya. Pada saat
itu, validasi format email dijalankan. Nilai `siti@` tidak memenuhi
format email sehingga isian ditandai sebagai salah dan pesan kesalahan
ditampilkan.

### 3. Klik isian Nama tanpa mengetik, lalu tekan Tab. Mengapa tidak ada pesan kesalahan?

Tidak ada pesan kesalahan karena isian Nama masih kosong dan validasi
saat kehilangan fokus tidak dijalankan untuk input kosong. Tujuannya
agar pengguna tidak langsung menerima peringatan sebelum mulai mengisi
data. Isian kosong tetap diperiksa ketika tombol Daftar ditekan.

### 4. Centang persetujuan, lalu klik Daftar dengan form kosong. Isian mana yang mendapat fokus?

Fokus diarahkan ke isian pertama yang tidak valid berdasarkan urutan
pemeriksaan form, yaitu isian NPM. Pengguna dapat langsung memperbaiki
kesalahan pertama tanpa harus mencari sendiri komponen yang bermasalah.

### 5. Tekan tombol Alt bersama huruf N. Isian mana yang mendapat fokus, dan properti apa yang mengaturnya?

Fokus berpindah ke isian NPM. Hal ini diatur oleh properti
`displayedMnemonic` pada label NPM dengan mnemonic huruf `N`, serta
properti `labelFor` yang menghubungkan label tersebut dengan komponen
isian NPM.

### 6. Isi beberapa isian, lalu klik Batal dan pilih No. Apakah data tetap ada?

Ya, data tetap ada. Pilihan **No** membatalkan proses pengosongan form
sehingga seluruh data yang sudah dimasukkan pengguna tidak dihapus. Form
hanya dikosongkan apabila pengguna memilih **Yes** pada dialog
konfirmasi.

## 6. Deklarasi Penggunaan AI

Dalam pengerjaan latihan mandiri ini, saya menggunakan **ChatGPT**
sebagai alat bantu untuk:

1.  Membantu memahami instruksi praktikum dan ketentuan validasi input.
2.  Membantu menyusun serta memeriksa kode Java pada kelas `Validator2`,
    `UjiValidator2`, dan integrasi validasi pada form.
3.  Membantu menjelaskan penggunaan event, pesan kesalahan, fokus
    komponen, mnemonic, tooltip, dan konfirmasi pengosongan form.
4.  Membantu menyusun dokumentasi pengerjaan dalam file `README.md`.

Seluruh kode tetap perlu diperiksa, dijalankan, dan diuji kembali oleh
saya pada Apache NetBeans. Dokumentasi screenshot dan lembar peer review
dilampirkan berdasarkan hasil pengerjaan dan review yang sebenarnya.

------------------------------------------------------------------------

## 7. Struktur File Dokumentasi

Pastikan file dan folder dokumentasi disusun seperti berikut:

``` text
p06-validasi-input/
├── README.md
├── screenshots/
│   ├── peer-review.jpg
│   ├── form-pesan-kesalahan.png
│   └── navigator-label-pesan.png
└── src/
    └── id/
        └── ac/
            └── uniska/
                └── pbo2/
                    └── p06/
                        ├── FormAnggotaPerpustakaan.java
                        ├── FormAnggotaPerpustakaan.form
                        ├── Validator2.java
                        └── UjiValidator2.java
```

Nama file gambar pada folder `screenshots` harus sama dengan nama yang
digunakan pada tautan gambar di README. Pastikan juga file `.form` ikut
disertakan dalam repository.

## 8. Pemeriksaan Sebelum Pengumpulan

-   [ ] Foto/pindaian peer review asli sudah dimasukkan.
-   [ ] Tabel temuan, perbaikan, dan commit sudah diisi berdasarkan
    hasil sebenarnya.
-   [ ] Screenshot form dengan pesan kesalahan sudah dimasukkan.
-   [ ] Screenshot Navigator yang memperlihatkan label pesan sudah
    dimasukkan.
-   [ ] Jawaban enam eksperimen Praktikum 4 sudah diperiksa sesuai hasil
    aplikasi.
-   [ ] Deklarasi penggunaan AI sudah dicantumkan.
-   [ ] File `.java` dan `.form` sudah ada di repository.
-   [ ] README dan seluruh screenshot sudah di-commit dan di-push ke
    GitHub.
