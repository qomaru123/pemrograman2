package Pertemuan5_Keyword_This_Buku;

public class Main {
    public static void main(String[] args) {
        // Membuat objek Buku
        Buku buku1 = new Buku("Atomic Habits", "James Clear", 120000);
        Buku buku2 = new Buku("Rich Dad Poor Dad", "Robert Kiyosaki", 95000);
        Buku buku3 = new Buku("The Alchemist", "Paulo Coelho", 80000);

        // Menampilkan informasi buku
        System.out.println("=== DAFTAR BUKU ===");
        buku1.tampilkanInfo();
        buku2.tampilkanInfo();
        buku3.tampilkanInfo();
    }
}