package pertemuan3;

public class mahasiswa {
    String nim;
    String nama;
    double ipk;
    String predikat;

    // Constructor
    public mahasiswa(String nim, String nama, double ipk) {
        this.nim = nim;
        this.nama = nama;
        this.ipk = ipk;
        this.predikat = "";
    }

    // Menampilkan data mahasiswa
    void tampilkanInfo() {
        System.out.println("==== Info Mahasiswa ====");
        System.out.println("NIM  : " + nim);
        System.out.println("Nama : " + nama);
        System.out.println("IPK  : " + ipk);
    }

    // Menentukan predikat
    String hitungPredikat() {
        if (ipk >= 3.5) {
            predikat = "Cumlaude";
        } else if (ipk >= 3.25) {
            predikat = "Sangat Memuaskan";
        } else if (ipk >= 3.0) {
            predikat = "Memuaskan";
        } else {
            predikat = "Perlu perbaikan";
        }
        return predikat;
    }

    // Update nama mahasiswa
    void gantiNama(String namaBaru) {
        this.nama = namaBaru;
        System.out.println("Nama telah diubah menjadi: " + this.nama);
    }

    // Cek kelulusan dengan nilai minimal
    boolean lulus(double nilaiMinimal) {
        return this.ipk >= nilaiMinimal;
    }

    // Tambahan unik: bonus reward jika IPK tinggi
    double hitungBonus() {
        if (ipk > 3.7) {
            return 3000000; // misal reward 3 juta
        } else if (ipk > 3.4) {
            return 2000000;
        } else {
            return 0;
        }
    }
}