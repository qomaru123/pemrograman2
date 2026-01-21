package pertemuan2;

public class Master_Bengkel {
    String namaMekanik;

    public Master_Bengkel(String namaMekanik) {
        this.namaMekanik = namaMekanik;
    }

    // Method mekanik untuk memperbaiki motor
    public void perbaikiMotor(Motor m) {
        System.out.println(namaMekanik + " sedang memperbaiki " + m.merk);
        m.diperbaiki();
    }

    public static void main(String[] args) {
        // Membuat objek motor
        Motor motor1 = new Motor("Honda Beat", "Rem blong");
        Motor motor2 = new Motor("Yamaha NMAX", "Rantai kendor");

        // Membuat objek mekanik
        Master_Bengkel mekanik = new Master_Bengkel("Raditya");

        // Tampilkan status sebelum diperbaiki
        System.out.println("=== Sebelum Diperbaiki ===");
        motor1.tampilkanInfo();
        motor2.tampilkanInfo();

        // Mekanik memperbaiki motor
        mekanik.perbaikiMotor(motor1);
        mekanik.perbaikiMotor(motor2);

        // Tampilkan status setelah diperbaiki
        System.out.println("\n=== Setelah Diperbaiki ===");
        motor1.tampilkanInfo();
        motor2.tampilkanInfo();
    }
}