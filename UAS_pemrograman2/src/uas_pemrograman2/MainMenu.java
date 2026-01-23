package uas_pemrograman2;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("Aplikasi Manajemen Toko");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Font titleFont = new Font("Segoe UI", Font.BOLD, 20);
        Font btnFont = new Font("Segoe UI", Font.PLAIN, 14);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(245, 245, 245));

        JLabel title = new JLabel("MENU UTAMA", JLabel.CENTER);
        title.setFont(titleFont);
        title.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0));
        panel.add(title, BorderLayout.NORTH);

        JPanel btnPanel = new JPanel(new GridLayout(3, 1, 15, 15));
        btnPanel.setOpaque(false);
        btnPanel.setBorder(BorderFactory.createEmptyBorder(30, 80, 30, 80));

        JButton btnPelanggan = new JButton("Data Pelanggan");
        JButton btnPenjualan = new JButton("Data Penjualan");
        JButton btnLaporan   = new JButton("Laporan Penjualan");

        styleButton(btnPelanggan, btnFont);
        styleButton(btnPenjualan, btnFont);
        styleButton(btnLaporan, btnFont);

        btnPelanggan.addActionListener(e -> new FormPelanggan().setVisible(true));
        btnPenjualan.addActionListener(e -> new FormPenjualan().setVisible(true));
        btnLaporan.addActionListener(e -> new FormLaporanPenjualan().setVisible(true));

        btnPanel.add(btnPelanggan);
        btnPanel.add(btnPenjualan);
        btnPanel.add(btnLaporan);

        panel.add(btnPanel, BorderLayout.CENTER);
        add(panel);

        // ===== MENU BAR =====
        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem mPelanggan = new JMenuItem("Pelanggan");
        JMenuItem mPenjualan = new JMenuItem("Penjualan");
        JMenuItem mLaporan   = new JMenuItem("Laporan Penjualan");
        JMenuItem mExit      = new JMenuItem("Keluar");

        mPelanggan.addActionListener(e -> new FormPelanggan().setVisible(true));
        mPenjualan.addActionListener(e -> new FormPenjualan().setVisible(true));
        mLaporan.addActionListener(e -> new FormLaporanPenjualan().setVisible(true));
        mExit.addActionListener(e -> System.exit(0));

        menu.add(mPelanggan);
        menu.add(mPenjualan);
        menu.add(mLaporan);
        menu.addSeparator();
        menu.add(mExit);

        bar.add(menu);
        setJMenuBar(bar);
    }

    private void styleButton(JButton btn, Font font) {
        btn.setFont(font);
        btn.setBackground(new Color(52, 152, 219));
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    public static void main(String[] args) {
        new MainMenu().setVisible(true);
    }
}
