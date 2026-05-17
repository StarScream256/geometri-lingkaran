package ui;

import geometri3d.TemberengBola;
import javax.swing.*;
import java.awt.event.*;

public class TemberengBolaFrame extends JFrame {

    private JTextField txtJariJari, txtTinggi;
    private JButton btnHitung;
    private JLabel lblLuasPermukaan, lblVolume;

    public TemberengBolaFrame() {

        setTitle("Tembereng Bola (Spherical Cap)");
        setSize(380, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblJudul = new JLabel("Tembereng Bola (Spherical Cap)");
        lblJudul.setBounds(75, 15, 230, 25);
        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 14));
        add(lblJudul);

        JLabel lblJariJari = new JLabel("Jari-jari Bola:");
        lblJariJari.setBounds(10, 50, 100, 20);
        add(lblJariJari);

        txtJariJari = new JTextField();
        txtJariJari.setBounds(120, 50, 120, 20);
        add(txtJariJari);

        JLabel lblTinggi = new JLabel("Tinggi Tembereng:");
        lblTinggi.setBounds(10, 80, 110, 20);
        add(lblTinggi);

        txtTinggi = new JTextField();
        txtTinggi.setBounds(120, 80, 120, 20);
        add(txtTinggi);

        btnHitung = new JButton("Hitung");
        btnHitung.setBounds(115, 120, 120, 30);
        btnHitung.setBackground(new java.awt.Color(51, 102, 255));
        btnHitung.setForeground(new java.awt.Color(255, 255, 255));
        add(btnHitung);

        lblLuasPermukaan = new JLabel("Luas Permukaan");
        lblLuasPermukaan.setBounds(10, 170, 100, 20);
        lblLuasPermukaan.setFont(new java.awt.Font("Segoe UI", 1, 12));
        add(lblLuasPermukaan);

        JTextField txtLuasPermukaan = new JTextField();
        txtLuasPermukaan.setBounds(10, 195, 150, 30);
        txtLuasPermukaan.setEditable(false);
        add(txtLuasPermukaan);

        lblVolume = new JLabel("Volume");
        lblVolume.setBounds(200, 170, 100, 20);
        lblVolume.setFont(new java.awt.Font("Segoe UI", 1, 12));
        add(lblVolume);

        JTextField txtVolume = new JTextField();
        txtVolume.setBounds(200, 195, 150, 30);
        txtVolume.setEditable(false);
        add(txtVolume);

        btnHitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {

                    if (txtJariJari.getText().isEmpty() || txtTinggi.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Semua input harus diisi!");
                        return;
                    }

                    double jariJariValue = Double.parseDouble(txtJariJari.getText().replace(",", "."));
                    double tinggiValue = Double.parseDouble(txtTinggi.getText().replace(",", "."));

                    if (jariJariValue <= 0 || tinggiValue <= 0) {
                        JOptionPane.showMessageDialog(null, "Jari-jari atau tinggi tembereng harus lebih besar dari 0.", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    // VALIDASI TAMBAHAN LOGIKA MATEMATIKA: 
                    // Tinggi tembereng tidak boleh melebihi diameter bola (2 * jari-jari)
                    if (tinggiValue > (2 * jariJariValue)) {
                        JOptionPane.showMessageDialog(null, "Tinggi tembereng tidak boleh melebihi diameter bola (2 * Jari-jari)!", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    // Instansiasi objek TemberengBola milikmu
                    TemberengBola temberengBola = new TemberengBola(jariJariValue, tinggiValue);
                    txtLuasPermukaan.setText(String.format("%.2f", temberengBola.hitungLuasPermukaan()));
                    txtVolume.setText(String.format("%.2f", temberengBola.hitungVolume()));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Input harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        new TemberengBolaFrame().setVisible(true);
    }
}