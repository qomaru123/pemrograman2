package aplikasi_penjualan_barang_berbasis_java_swing;

public class Penjualan extends Barang implements Diskon {

    public Penjualan(String namaBarang, int harga) {
        super(namaBarang, harga);
    }

    public int hitungTotal(int jumlah) {
        return getHarga() * jumlah;
    }

    @Override
    public int hitungDiskon(int total) {
        if (total >= 500000) {
            return total * 10 / 100;
        }
        return 0;
    }
}
