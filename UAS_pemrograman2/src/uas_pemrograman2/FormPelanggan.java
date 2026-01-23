package uas_pemrograman2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class FormPelanggan extends JFrame {

    JTextField txtId, txtNama, txtAlamat;
    JTable table;
    DefaultTableModel model;

    public FormPelanggan() {
        setTitle("CRUD Data Pelanggan");
        setSize(600, 400);
        setLocationRelativeTo(null);

        // ===== PANEL FORM =====
        JPanel form = new JPanel(new GridLayout(3, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        txtId = new JTextField();
        txtId.setEditable(false);
        txtNama = new JTextField();
        txtAlamat = new JTextField();

        form.add(new JLabel("ID"));
        form.add(txtId);
        form.add(new JLabel("Nama"));
        form.add(txtNama);
        form.add(new JLabel("Alamat"));
        form.add(txtAlamat);

        // ===== TOMBOL =====
        JPanel tombol = new JPanel(new GridLayout(1, 4, 10, 10));
        JButton btnSimpan = new JButton("Insert");
        JButton btnUpdate = new JButton("Update");
        JButton btnHapus = new JButton("Delete");
        JButton btnReset = new JButton("Reset");

        tombol.add(btnSimpan);
        tombol.add(btnUpdate);
        tombol.add(btnHapus);
        tombol.add(btnReset);

        // ===== TABLE =====
        model = new DefaultTableModel(new String[]{"ID", "Nama", "Alamat"}, 0);
        table = new JTable(model);
        JScrollPane scroll = new JScrollPane(table);

        // ===== LAYOUT =====
        setLayout(new BorderLayout());
        add(form, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(tombol, BorderLayout.SOUTH);

        tampilData();

        // ===== EVENT =====
        btnSimpan.addActionListener(e -> insertData());
        btnUpdate.addActionListener(e -> updateData());
        btnHapus.addActionListener(e -> deleteData());
        btnReset.addActionListener(e -> resetForm());

        table.getSelectionModel().addListSelectionListener(e -> pilihData());
    }

        // ===== INSERT =====
    private void insertData() {
      try {
        String sql = "INSERT INTO pelanggan (nama, alamat) VALUES (?, ?)";
        PreparedStatement pst = Koneksi.getKoneksi().prepareStatement(sql);
        pst.setString(1, txtNama.getText());
        pst.setString(2, txtAlamat.getText());
        pst.executeUpdate();

        JOptionPane.showMessageDialog(this, "Data pelanggan berhasil disimpan");

        // ➜ buka Form Penjualan
        new FormPenjualan().setVisible(true);

        // ➜ tutup Form Pelanggan
        dispose();

     } catch (HeadlessException | SQLException e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}

    // ===== SELECT =====
    private void tampilData() {
        model.setRowCount(0);
        try {
            String sql = "SELECT * FROM pelanggan";
            Statement st = Koneksi.getKoneksi().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id_pelanggan"),
                        rs.getString("nama"),
                        rs.getString("alamat")
                });
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // ===== UPDATE =====
    private void updateData() {
        try {
            String sql = "UPDATE pelanggan SET nama=?, alamat=? WHERE id_pelanggan=?";
            PreparedStatement pst = Koneksi.getKoneksi().prepareStatement(sql);
            pst.setString(1, txtNama.getText());
            pst.setString(2, txtAlamat.getText());
            pst.setInt(3, Integer.parseInt(txtId.getText()));
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data berhasil diupdate");
            tampilData();
            resetForm();
            // ➜ buka Form Penjualan
        new FormPenjualan().setVisible(true);

        // ➜ tutup Form Pelanggan
        dispose();

        } catch (HeadlessException | NumberFormatException | SQLException e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    // ===== DELETE =====
    private void deleteData() {
        try {
            String sql = "DELETE FROM pelanggan WHERE id_pelanggan=?";
            PreparedStatement pst = Koneksi.getKoneksi().prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(txtId.getText()));
            pst.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
            tampilData();
            resetForm();
            
            // 🔥 PINDAH KE FORM PENJUALAN OTOMATIS
        new FormPenjualan().setVisible(true);
        
        // (opsional) tutup form pelanggan
        this.dispose();

        } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    
        }
    }

    private void pilihData() {
        int row = table.getSelectedRow();
        if (row >= 0) {
            txtId.setText(model.getValueAt(row, 0).toString());
            txtNama.setText(model.getValueAt(row, 1).toString());
            txtAlamat.setText(model.getValueAt(row, 2).toString());
        }
    }

    private void resetForm() {
        txtId.setText("");
        txtNama.setText("");
        txtAlamat.setText("");
        table.clearSelection();
    }
    
    
}
