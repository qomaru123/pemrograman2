package pertemuan5_Inherintance_Hewan;

public class Kucing extends Hewan {

    private int jumlahMakan; // dalam gram
    private double hargaPerGram;

    public Kucing() {
        super();
    }

    public void beriMakan(int porsi, double harga) {
        jumlahMakan = porsi;
        hargaPerGram = harga;
    }

    public void tampilTambahan() {
        System.out.println("Porsi Makan (gram): " + jumlahMakan);
        System.out.println("Harga/Gram        : " + hargaPerGram);
        System.out.println("Total Biaya Makan : " + hitungTotal(0, jumlahMakan * hargaPerGram));
    }
}