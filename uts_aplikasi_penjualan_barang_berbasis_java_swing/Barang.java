package aplikasi_penjualan_barang_berbasis_java_swing;

public class Barang {
    private String namaBarang;
    private int harga;

    public Barang(String namaBarang, int harga) {
        this.namaBarang = namaBarang;
        this.harga = harga;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public int getHarga() {
        return harga;
    }
}
