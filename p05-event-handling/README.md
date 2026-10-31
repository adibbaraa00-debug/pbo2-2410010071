# Praktikum PBO 2 – Pertemuan 5: Event Handling

## Identitas

| Keterangan | Data |
|---|---|
| Nama | Adib Baraa Taufani |
| NPM | 2410010071 |
| Mata Kuliah | Pemrograman Berbasis Objek 2 |
| Pertemuan | 5 – Event Handling |
| Program Studi | Teknik Informatika |
| Package | `id.ac.uniska.pbo2.p05` |

---

## 1. Tabel Pengamatan Praktikum 2

Berdasarkan pengujian aplikasi `PengamatEvent`, berikut event yang tercatat pada setiap tindakan.

| No. | Tindakan | Event yang tercatat |
|---:|---|---|
| 1 | Arahkan kursor ke tombol, lalu jauhkan | `MouseEvent` – `mouseEntered` ketika kursor masuk ke tombol dan `mouseExited` ketika kursor keluar dari tombol. |
| 2 | Klik tombol **Klik saya** | `ActionEvent` – `actionPerformed` ketika tombol diklik. |
| 3 | Centang lalu hapus centang **Aktifkan fitur** | `ItemEvent` – `itemStateChanged` ketika kotak dicentang dan ketika centangnya dihapus. |
| 4 | Ganti pilihan dari **Pagi** menjadi **Malam** | `ItemEvent` – `itemStateChanged`. Event terjadi untuk pilihan lama yang `DESELECTED` dan pilihan baru yang `SELECTED`. Dengan pemeriksaan `ItemEvent.SELECTED`, pencatatan pilihan baru dilakukan satu kali. |
| 5 | Klik isian, lalu ketik kata **abc** | `FocusEvent` – `focusGained` ketika isian mendapat fokus, kemudian `KeyEvent` – `keyTyped` untuk setiap karakter `a`, `b`, dan `c`. |
| 6 | Klik tombol setelah mengetik di isian | `FocusEvent` – `focusLost` ketika isian kehilangan fokus. Tombol yang diklik juga memicu `ActionEvent` pada tombol tersebut jika tombol memiliki handler aksi. |

## 2. Jawaban Eksperimen Praktikum 3 – Konversi Suhu

### Eksperimen 1

**Pertanyaan:** Hapus pemeriksaan `evt.getStateChange() == ItemEvent.SELECTED` dan tambahkan `System.out.println("item berubah");` di dalam event handler. Berapa kali pesan tercetak setiap pilihan diganti?

**Jawaban:** Pesan tercetak sebanyak **dua kali** setiap pilihan Combo Box diganti. Hal ini terjadi karena `itemStateChanged` dipanggil untuk dua perubahan keadaan, yaitu pilihan sebelumnya menjadi `DESELECTED` dan pilihan baru menjadi `SELECTED`. Pemeriksaan `ItemEvent.SELECTED` diperlukan agar proses hanya dijalankan untuk pilihan yang baru dipilih.

### Eksperimen 2

**Pertanyaan:** Kosongkan event `keyReleased` pada `celsiusField`, lalu buat event `keyPressed` yang memanggil `konversi()`. Mengapa hasil yang tampil terlambat satu karakter?

**Jawaban:** Karena `keyPressed` dipanggil ketika tombol keyboard baru ditekan, sebelum karakter dimasukkan ke dalam `JTextField`. Akibatnya, saat `konversi()` membaca isi field, karakter yang baru ditekan belum masuk. Hasil perhitungan masih menggunakan teks sebelumnya sehingga terlihat terlambat satu karakter. Event `keyReleased` terjadi setelah proses pengetikan karakter, sehingga isi field sudah diperbarui ketika dibaca.

### Eksperimen 3

**Pertanyaan:** Hapus blok `try` dan `catch` di method `konversi`, lalu ketik huruf pada isian. Apa yang muncul di jendela Output?

**Jawaban:** Ketika huruf dimasukkan, `Double.parseDouble()` tidak dapat mengubah teks tersebut menjadi angka. Program menghasilkan `NumberFormatException` dan informasi kesalahan atau stack trace tampil di jendela **Output** NetBeans. Blok `try-catch` diperlukan agar kesalahan input dapat ditangani dan aplikasi dapat menampilkan pesan yang lebih mudah dipahami pengguna.

## 3. Jawaban Eksperimen Praktikum 4 – Kalkulator Sederhana

### Eksperimen 1

**Pertanyaan:** Buat event `actionPerformed` untuk `kaliButton` melalui Events tanpa menghapus lambda di konstruktor, lalu tambahkan `System.out.println("kali");` di kedua tempat. Berapa kali pesan tercetak? Mengapa satu tombol sebaiknya hanya memakai satu cara?

**Jawaban:** Pesan `kali` tercetak **dua kali** ketika tombol diklik karena terdapat dua listener yang menangani aksi tombol yang sama: event handler dari GUI Builder dan lambda yang ditambahkan di konstruktor. Satu tombol sebaiknya hanya menggunakan satu cara penghubung event agar aksi tidak dijalankan berulang kali dan kode lebih mudah dipelihara.

### Eksperimen 2

**Pertanyaan:** Tambahkan tombol `%` untuk sisa bagi (modulus). Apa saja yang diubah di tab Design dan di tab Source?

**Jawaban:**

- **Tab Design:** Tambahkan satu `JButton` pada `operatorPanel`, ubah teks tombol menjadi `%`, dan beri nama variabel, misalnya `modulusButton`.
- **Tab Source:** Tambahkan penanganan operator `%` pada method `hitung(char operator)`, yaitu menggunakan operator modulus (`a % b`) untuk memperoleh sisa hasil pembagian. Tambahkan pula kondisi pemeriksaan pembagi nol untuk operator `%`, sehingga operasi modulus dengan angka kedua nol tidak dijalankan.

Contoh penambahan pada `switch`:

```java
case '%' -> a % b;
```

Pemeriksaan pembagi nol dapat disesuaikan menjadi:

```java
if ((operator == '/' || operator == '%') && b == 0) {
    hasilLabel.setText("Tidak dapat membagi dengan nol");
    return;
}
```

### Eksperimen 3

**Pertanyaan:** Tekan tombol Hapus. Mengapa kursor langsung berada di isian pertama?

**Jawaban:** Karena pada method `hapus()` terdapat perintah `angka1Field.requestFocusInWindow()`. Perintah tersebut meminta komponen isian angka pertama mendapatkan fokus kembali setelah seluruh isian dikosongkan. Dengan demikian, pengguna dapat langsung memasukkan angka baru tanpa perlu mengeklik field tersebut lagi.

## 4. Peta Event FormAnggotaPerpustakaan

Peta event berikut diterapkan pada `FormAnggotaPerpustakaan` sesuai instruksi Latihan Mandiri Modul P05.

| No. | Komponen | Menu Events | Event | Aksi |
|---:|---|---|---|---|
| 1 | `persetujuanCheck` | Item | `itemStateChanged` | Tombol **Daftar** aktif hanya ketika kotak persetujuan dicentang. |
| 2 | `batalButton` | Action | `actionPerformed` | Mengosongkan seluruh isian, menghapus pilihan jenis anggota, menonaktifkan tombol Daftar, memperbarui informasi digit NPM, dan mengembalikan fokus ke isian NPM. |
| 3 | `daftarButton` | Action | `actionPerformed` | Menampilkan ringkasan data anggota menggunakan `JOptionPane`. |
| 4 | `npmText` | Key | `keyReleased` | Memperbarui informasi jumlah digit NPM, misalnya `8 dari 10 digit`. |
| 5 | Form (JFrame di Navigator) | Window | `windowClosing` | Menampilkan dialog konfirmasi sebelum aplikasi ditutup. Jika pengguna memilih Yes, aplikasi ditutup; jika memilih No, aplikasi tetap terbuka. |

**Pengaturan form:** `defaultCloseOperation` diatur menjadi `DO_NOTHING_ON_CLOSE`, sedangkan properti `enabled` pada `daftarButton` diatur menjadi `false` pada kondisi awal.

## 5. Dokumentasi Screenshot

Simpan ketiga tangkapan layar pada folder `screenshots` di dalam repository, kemudian pastikan nama file sesuai dengan yang digunakan di bawah ini.

### 5.1 Properties – Events Tombol Daftar

![Properties bagian Events untuk tombol Daftar](screenshots/properties-events-daftar.png)

### 5.2 Dialog Ringkasan Data Anggota

![Dialog ringkasan data anggota](screenshots/dialog-ringkasan.png)

### 5.3 Dialog Konfirmasi Keluar

![Dialog konfirmasi keluar aplikasi](screenshots/dialog-konfirmasi-keluar.png)

## 6. Deklarasi Penggunaan AI

Dalam pengerjaan praktikum ini, saya menggunakan **ChatGPT** sebagai alat bantu untuk:

1. Membantu memahami instruksi dan materi pada Modul Praktikum PBO 2 Pertemuan 5.
2. Membantu menyusun jawaban tabel pengamatan dan eksperimen Praktikum 3 serta Praktikum 4 berdasarkan materi modul.
3. Membantu menyusun dokumentasi peta event `FormAnggotaPerpustakaan` ke dalam README.

Penggunaan AI hanya sebagai alat bantu pembelajaran dan penyusunan dokumentasi. Implementasi program, pengujian event, serta tangkapan layar dilakukan dan diperiksa kembali pada aplikasi NetBeans.

---

**Catatan:** Pastikan seluruh file screenshot benar-benar berada di folder `screenshots` dengan nama yang sama seperti pada bagian dokumentasi agar gambar tampil ketika README dibuka di GitHub.
