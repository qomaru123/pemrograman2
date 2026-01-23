package pertemuan5_Inherintance_Hewan;

public class Anjing extends Hewan {

    double biayaPerawatan;

    void beriPerawatan(double biaya) {
        biayaPerawatan = biaya;
    }

    void tampilTambahan() {
        System.out.println("Biaya Perawatan : " + biayaPerawatan);
        System.out.println("Total Biaya     : " + hitungTotal(0, biayaPerawatan));
    }
}