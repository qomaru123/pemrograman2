package uas_pemrograman2;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class FormPenjualan extends JFrame {

    JTextField txtIdPelanggan, txtTanggal, txtTotal;

    public FormPenjualan() {
        setTitle("Form Penjualan");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("ID Pelanggan"));
        txtIdPelanggan = new JTextField();
        panel.add(txtIdPelanggan);

        panel.add(new JLabel("Tanggal (YYYY-MM-DD)"));
        txtTanggal = new JTextField();
        panel.add(txtTanggal);

        panel.add(new JLabel("Total"));
        txtTotal = new JTextField();
        panel.add(txtTotal);

        JButton btnSimpan = new JButton("Simpan");
        btnSimpan.setBackground(new Color(155, 89, 182));
        btnSimpan.setForeground(Color.WHITE);
        btnSimpan.addActionListener(e -> simpanData());

        panel.add(new JLabel());
        panel.add(btnSimpan);

        add(panel);
    }

    // ===== SIMPAN DATA =====
    private void simpanData() {
        try {
            String sql = "INSERT INTO penjualan (id_pelanggan, tanggal, total) VALUES (?, ?, ?)";
            PreparedStatement pst = Koneksi.getKoneksi().prepareStatement(sql);

            pst.setInt(1, Integer.parseInt(txtIdPelanggan.getText()));
            pst.setDate(2, Date.valueOf(txtTanggal.getText()));
            pst.setDouble(3, Double.parseDouble(txtTotal.getText()));

            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data penjualan berhasil disimpan");

            // buka laporan
            new FormLaporanPenjualan().setVisible(true);

            // tutup form penjualan
            dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    public FormPenjualan(int idPelanggan) {
    initComponents();
    txtIdPelanggan.setText(String.valueOf(idPelanggan));
}

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

}
