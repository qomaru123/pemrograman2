package pertemuan5_Inherintance_Hewan;

public class Hewan {

    protected String nama;
    protected String jenis;

    public Hewan() {
    }

    public void daftarHewan(String nama, String jenis) {
        this.nama = nama;
        this.jenis = jenis;
    }

    public void tampilkanData() {
        System.out.println("Nama Hewan : " + nama);
        System.out.println("Jenis      : " + jenis);
    }

    // method hitungTotal menerima double
    public double hitungTotal(double a, double b) {
        return a + b;
    }
}