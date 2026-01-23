package Pertemuan5_Keyword_This_Buku;

public class Buku {
    private final String judul;
    private final String pengarang;
    private final double harga;

    // Konstruktor
    public Buku(String judul, String pengarang, double harga) {
        this.judul = judul;         // this membedakan atribut dengan parameter
        this.pengarang = pengarang;
        this.harga = harga;
    }

    // Method untuk menampilkan info buku
    public void tampilkanInfo() {
        System.out.println("Judul Buku     : " + this.judul);
        System.out.println("Pengarang      : " + this.pengarang);
        System.out.println("Harga          : Rp " + this.harga);
        System.out.println("---------------------------");
    }
}
