package pertemuan5_Inherintance_Hewan;


import pertemuan5_Inherintance_Hewan.Kucing;
import pertemuan5_Inherintance_Hewan.Anjing;

public class Main {
    public static void main(String[] args) {

        Kucing kucing1 = new Kucing();
        Kucing kucing2 = new Kucing();

        Anjing anjing1 = new Anjing();
        Anjing anjing2 = new Anjing();

        System.out.println("=====================");
        System.out.println("        KUCING       ");
        System.out.println("=====================");
        kucing1.daftarHewan("Miko", "Persia");
        kucing1.beriMakan(200, 1500);
        kucing1.tampilkanData();
        kucing1.tampilTambahan();
        System.out.println("---------------------");

        kucing2.daftarHewan("Snow", "Anggora");
        kucing2.beriMakan(300, 2000);
        kucing2.tampilkanData();
        kucing2.tampilTambahan();
        System.out.println("---------------------\n");

        System.out.println("=====================");
        System.out.println("        ANJING       ");
        System.out.println("=====================");
        anjing1.daftarHewan("Rocky", "Bulldog");
        anjing1.beriPerawatan(75000);
        anjing1.tampilkanData();
        anjing1.tampilTambahan();
        System.out.println("---------------------");

        anjing2.daftarHewan("Kuro", "Shiba Inu");
        anjing2.beriPerawatan(120000);
        anjing2.tampilkanData();
        anjing2.tampilTambahan();
        System.out.println("---------------------");
    }
}