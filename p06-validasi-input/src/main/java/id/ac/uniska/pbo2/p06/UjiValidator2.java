
package id.ac.uniska.pbo2.p06;

/**
 * Pengujian kelas Validator2 tanpa GUI.
 * @author Adib Baraa Taufani
 */
public class UjiValidator2 {

    private static int gagal = 0;

    private static void cek(String nama, String hasil,
                            boolean harusValid) {

        boolean valid = (hasil == null);

        if (valid != harusValid) {
            gagal++;
        }

        String status = (valid == harusValid)
                ? "SESUAI " : "SALAH ";

        System.out.println(status + nama + ": "
                + (valid ? "valid" : hasil));
    }

    public static void main(String[] args) {

        // Pengujian NPM
        cek("NPM kosong",
                Validator2.npm(""), false);

        cek("NPM kurang dari 10 digit",
                Validator2.npm("12345"), false);

        cek("NPM mengandung huruf",
                Validator2.npm("24100100ab"), false);

        cek("NPM benar",
                Validator2.npm("2410010071"), true);

        // Pengujian Nama
        cek("Nama kosong",
                Validator2.nama(""), false);

        cek("Nama terlalu pendek",
                Validator2.nama("Ad"), false);

        cek("Nama mengandung angka",
                Validator2.nama("Adib123"), false);

        cek("Nama benar",
                Validator2.nama("Adib Baraa Taufani"), true);

        // Pengujian Email
        cek("Email kosong",
                Validator2.email(""), false);

        cek("Email tanpa domain",
                Validator2.email("adib@"), false);

        cek("Email benar",
                Validator2.email("adib@gmail.com"), true);

        // Pengujian Nomor HP
        cek("Nomor HP kosong",
                Validator2.nomorHp(""), false);

        cek("Nomor HP terlalu pendek",
                Validator2.nomorHp("0812"), false);

        cek("Nomor HP diawali 62",
                Validator2.nomorHp("6281234567890"), false);

        cek("Nomor HP benar",
                Validator2.nomorHp("081234567890"), true);

        System.out.println();

        if (gagal == 0) {
            System.out.println(
                    "Semua aturan bekerja sesuai harapan");
        } else {
            System.out.println(
                    gagal + " aturan belum sesuai");
        }
    }
}
