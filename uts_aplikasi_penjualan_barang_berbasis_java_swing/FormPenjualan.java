package aplikasi_penjualan_barang_berbasis_java_swing;

import javax.swing.*;

public class FormPenjualan extends JFrame {

    JTextField txtNama, txtHarga, txtJumlah, txtTotal, txtDiskon, txtBayar;

    public FormPenjualan() {
        setTitle("Aplikasi Penjualan Barang");
        setSize(460, 420);
        setLayout(null);

        // MENU BAR
        JMenuBar bar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenuItem keluar = new JMenuItem("Keluar");
        menuFile.add(keluar);
        bar.add(menuFile);
        setJMenuBar(bar);

        // LABEL
        JLabel lblNama = new JLabel("Nama Barang");
        JLabel lblHarga = new JLabel("Harga");
        JLabel lblJumlah = new JLabel("Jumlah");
        JLabel lblTotal = new JLabel("Total");
        JLabel lblDiskon = new JLabel("Diskon");
        JLabel lblBayar = new JLabel("Total Bayar");

        // TEXTFIELD
        txtNama = new JTextField();
        txtHarga = new JTextField();
        txtJumlah = new JTextField();
        txtTotal = new JTextField();
        txtDiskon = new JTextField();
        txtBayar = new JTextField();

        txtTotal.setEditable(false);
        txtDiskon.setEditable(false);
        txtBayar.setEditable(false);

        // BUTTON
        JButton btnProses = new JButton("Proses");
        JButton btnReset = new JButton("Reset");
        JButton btnKeluar = new JButton("Keluar");

        // POSISI
        lblNama.setBounds(30, 40, 120, 25);
        txtNama.setBounds(160, 40, 240, 25);

        lblHarga.setBounds(30, 80, 120, 25);
        txtHarga.setBounds(160, 80, 240, 25);

        lblJumlah.setBounds(30, 120, 120, 25);
        txtJumlah.setBounds(160, 120, 240, 25);

        lblTotal.setBounds(30, 160, 120, 25);
        txtTotal.setBounds(160, 160, 240, 25);

        lblDiskon.setBounds(30, 200, 120, 25);
        txtDiskon.setBounds(160, 200, 240, 25);

        lblBayar.setBounds(30, 240, 120, 25);
        txtBayar.setBounds(160, 240, 240, 25);

        btnProses.setBounds(40, 300, 100, 30);
        btnReset.setBounds(180, 300, 100, 30);
        btnKeluar.setBounds(320, 300, 100, 30);

        // ADD
        add(lblNama); add(txtNama);
        add(lblHarga); add(txtHarga);
        add(lblJumlah); add(txtJumlah);
        add(lblTotal); add(txtTotal);
        add(lblDiskon); add(txtDiskon);
        add(lblBayar); add(txtBayar);
        add(btnProses); add(btnReset); add(btnKeluar);

        // EVENT PROSES
        btnProses.addActionListener(e -> {
            try {
                String nama = txtNama.getText();
                int harga = Integer.parseInt(txtHarga.getText());
                int jumlah = Integer.parseInt(txtJumlah.getText());

                Penjualan pj = new Penjualan(nama, harga);
                int total = pj.hitungTotal(jumlah);
                int diskon = pj.hitungDiskon(total);
                int bayar = total - diskon;

                txtTotal.setText(String.valueOf(total));
                txtDiskon.setText(String.valueOf(diskon));
                txtBayar.setText(String.valueOf(bayar));

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Input tidak valid!");
            }
        });

        // RESET
        btnReset.addActionListener(e -> {
            txtNama.setText("");
            txtHarga.setText("");
            txtJumlah.setText("");
            txtTotal.setText("");
            txtDiskon.setText("");
            txtBayar.setText("");
        });

        // KELUAR
        btnKeluar.addActionListener(e -> System.exit(0));
        keluar.addActionListener(e -> System.exit(0));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FormPenjualan();
    }
}
