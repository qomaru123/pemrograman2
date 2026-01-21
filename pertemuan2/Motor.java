package pertemuan2;

public class Motor {
    String merk;
    String kerusakan;

    public Motor(String merk, String kerusakan) {
        this.merk = merk;
        this.kerusakan = kerusakan;
    }

    public void tampilkanInfo() {
        System.out.println(merk + " | Kerusakan: " + kerusakan);
    }

    public void diperbaiki() {
        kerusakan = "Sudah diperbaiki";
        System.out.println(merk + " telah diperbaiki!");
    }
}