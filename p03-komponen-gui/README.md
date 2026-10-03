# Penggunaan AI

## Nama AI

**ChatGPT (GPT-5.6 Luna)**

AI digunakan sebagai pendukung dalam pengerjaan aplikasi `FormTiketTravel`. Penggunaan AI difokuskan pada pemahaman logika pemrograman Java Swing, pengelolaan input dari pengguna, pembuatan validasi sederhana, serta pengaturan tampilan aplikasi menggunakan FlatLaf.

---

## Prompt 1 – Membuat Validasi Form Pemesanan

### Prompt

> "Saya ingin menambahkan validasi sederhana pada FormTiketTravel menggunakan Java Swing. Jika nama pemesan atau nomor HP masih kosong ketika tombol Pesan ditekan, tampilkan pesan peringatan dan hentikan proses. Jika semua data sudah diisi, tampilkan pesan bahwa data dapat diproses. Tolong berikan contoh kode yang mudah dipahami."

### Hasil Jawaban AI

AI menyarankan agar pemeriksaan dilakukan sebelum program memproses data pemesanan. Nilai dari `JTextField` dapat diambil menggunakan `getText()`, kemudian `trim()` digunakan untuk menghilangkan spasi yang tidak diperlukan.

Jika salah satu input masih kosong, program menampilkan peringatan menggunakan `JOptionPane` dan proses dihentikan dengan `return`.

Contoh kode:

```java
private void validasiPemesanan() {

    String nama = namaPemesanField.getText().trim();
    String nomorHp = nomorHpField.getText().trim();

    if (nama.isEmpty()) {
        JOptionPane.showMessageDialog(
                this,
                "Nama pemesan belum diisi.",
                "Peringatan",
                JOptionPane.WARNING_MESSAGE
        );
        namaPemesanField.requestFocus();
        return;
    }

    if (nomorHp.isEmpty()) {
        JOptionPane.showMessageDialog(
                this,
                "Nomor HP belum diisi.",
                "Peringatan",
                JOptionPane.WARNING_MESSAGE
        );
        nomorHpField.requestFocus();
        return;
    }

    JOptionPane.showMessageDialog(
            this,
            "Data pemesanan sudah lengkap.",
            "Informasi",
            JOptionPane.INFORMATION_MESSAGE
    );
}
```

Kode tersebut digunakan untuk memastikan data penting telah diisi sebelum proses pemesanan dilanjutkan.

---

## Prompt 2 – Menampilkan Pilihan Kelas yang Dipilih

### Prompt

> "Pada aplikasi tiket travel saya menggunakan tiga JRadioButton untuk pilihan kelas Ekonomi, Bisnis, dan Eksekutif. Bagaimana cara mengetahui pilihan pengguna dan menampilkannya dalam JOptionPane setelah tombol diklik?"

### Hasil Jawaban AI

AI menjelaskan bahwa setiap `JRadioButton` dapat diperiksa menggunakan method `isSelected()`. Program dapat menggunakan percabangan untuk menentukan radio button mana yang sedang aktif.

Contoh implementasinya:

```java
private void cekKelasTiket() {

    String pilihan = "Belum memilih kelas";

    if (ekonomiRadio.isSelected()) {
        pilihan = "Ekonomi";
    } else if (bisnisRadio.isSelected()) {
        pilihan = "Bisnis";
    } else if (eksekutifRadio.isSelected()) {
        pilihan = "Eksekutif";
    }

    JOptionPane.showMessageDialog(
            this,
            "Kelas yang dipilih: " + pilihan,
            "Pilihan Kelas",
            JOptionPane.INFORMATION_MESSAGE
    );
}
```

AI juga menjelaskan bahwa penggunaan `ButtonGroup` diperlukan agar ketiga radio button tersebut hanya memungkinkan satu pilihan pada satu waktu.

---

## Prompt 3 – Mengubah Tampilan Toggle Button

### Prompt

> "Saya menggunakan JToggleButton pada FormTiketTravel dan ingin teks tombol berubah sesuai kondisinya. Jika toggle aktif tampilkan tulisan 'Dark Mode', dan jika tidak aktif tampilkan 'Light Mode'. Bagaimana cara membuat event tersebut di Java Swing?"

### Hasil Jawaban AI

AI menyarankan penggunaan `isSelected()` untuk mengetahui kondisi `JToggleButton`. Nilai tersebut kemudian digunakan sebagai kondisi untuk mengubah teks tombol.

Contoh kode:

```java
private void temaToggleActionPerformed(
        java.awt.event.ActionEvent evt) {

    if (temaToggle.isSelected()) {
        temaToggle.setText("Dark Mode");
    } else {
        temaToggle.setText("Light Mode");
    }
}
```

Dengan cara tersebut, teks pada tombol akan berubah secara otomatis setiap kali pengguna mengaktifkan atau menonaktifkan toggle.

Jika fitur tersebut digabungkan dengan FlatLaf, kondisi toggle juga dapat digunakan untuk menentukan tema yang akan diterapkan pada form.

---

# Alasan Menggunakan AI

AI digunakan dalam pengerjaan aplikasi sebagai sumber bantuan ketika terdapat bagian pemrograman yang perlu dipahami lebih lanjut. Bantuan tersebut terutama digunakan untuk mencari contoh penerapan event handling, membaca nilai dari komponen Swing, serta membuat validasi terhadap data yang dimasukkan pengguna.

Selain membuat contoh kode, AI juga membantu menjelaskan fungsi beberapa method Java Swing seperti `getText()`, `trim()`, `isSelected()`, `requestFocus()`, dan `setText()`.

Kode yang diberikan oleh AI tidak digunakan secara langsung tanpa penyesuaian. Kode diperiksa terlebih dahulu kemudian disesuaikan dengan nama variabel dan komponen yang terdapat pada project `FormTiketTravel`.

Pembuatan tampilan aplikasi tetap dilakukan menggunakan **NetBeans GUI Builder**, termasuk penempatan `JTextField`, `JRadioButton`, `JCheckBox`, `JComboBox`, `JButton`, dan `JToggleButton`. AI hanya digunakan sebagai pendamping dalam memahami logika program dan menyelesaikan bagian kode yang diperlukan.

Melalui penggunaan AI, proses pengerjaan menjadi lebih terbantu karena dapat memperoleh contoh implementasi sekaligus memahami alasan penggunaan setiap fungsi dalam program. Dengan demikian, penggunaan AI tetap diarahkan sebagai sarana belajar dan membantu pemecahan masalah selama proses praktikum.
