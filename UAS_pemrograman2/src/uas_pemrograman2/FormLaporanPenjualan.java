package uas_pemrograman2;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.text.DecimalFormat;

public class FormLaporanPenjualan extends JFrame {

    JTable table;
    DefaultTableModel model;
    JLabel lblTotal;

    public FormLaporanPenjualan() {
        setTitle("Laporan Penjualan");
        setSize(700, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        model = new DefaultTableModel(
            new String[]{"ID", "Nama", "Tanggal", "Total"}, 0
        );
        table = new JTable(model);

        JButton btnRefresh = new JButton("Refresh");
        btnRefresh.addActionListener(e -> tampilData());

        lblTotal = new JLabel("Total Penjualan : Rp 0");
        lblTotal.setFont(new Font("Segoe UI", Font.BOLD, 14));

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.add(lblTotal, BorderLayout.WEST);
        bottom.add(btnRefresh, BorderLayout.EAST);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);

        tampilData();
    }

    private void tampilData() {
    model.setRowCount(0);
    double totalAll = 0;

    try {
        String sql =
            "SELECT p.id_penjualan, pl.nama, p.tanggal, p.total " +
            "FROM penjualan p JOIN pelanggan pl ON p.id_pelanggan = pl.id_pelanggan";

        ResultSet rs = Koneksi.getKoneksi().createStatement().executeQuery(sql);

        while (rs.next()) {
            double total = rs.getDouble("total");
            totalAll += total;

            model.addRow(new Object[]{
                rs.getInt("id_penjualan"),
                rs.getString("nama"),
                rs.getDate("tanggal"),
                total
            });
        }

        DecimalFormat df = new DecimalFormat("#,###");
        lblTotal.setText("Total Penjualan : Rp " + df.format(totalAll));

    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, e.getMessage());
    }
}

}
