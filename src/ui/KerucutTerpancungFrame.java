package ui;

import geometri3d.KerucutTerpancung;
import javax.swing.*;
import java.awt.event.*;

public class KerucutTerpancungFrame extends JFrame {

    public JTextField txtJariJariBawah, txtJariJariAtas, txtTinggi;
    public JButton btnHitung;
    public JLabel lblLuasPermukaan, lblVolume;
    public JTextField txtLuasPermukaan, txtVolume;

    public KerucutTerpancungFrame() {
        this.setTitle("Kerucut Terpancung");
        this.setSize(400, 400);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblTitle = new JLabel("Kerucut Terpancung");
        lblTitle.setBounds(120, 15, 160, 25);
        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lblTitle);

        JLabel lblJariJariBawah = new JLabel("Jari-jari Bawah");
        lblJariJariBawah.setBounds(10, 50, 100, 20);
        this.add(lblJariJariBawah);

        txtJariJariBawah = new JTextField();
        txtJariJariBawah.setBounds(120, 50, 250, 25);
        this.add(txtJariJariBawah);

        JLabel lblJariJariAtas = new JLabel("Jari-jari Atas");
        lblJariJariAtas.setBounds(10, 85, 100, 20);
        this.add(lblJariJariAtas);

        txtJariJariAtas = new JTextField();
        txtJariJariAtas.setBounds(120, 85, 250, 25);
        this.add(txtJariJariAtas);

        JLabel lblTinggi = new JLabel("Tinggi Terpancung");
        lblTinggi.setBounds(10, 120, 150, 20);
        this.add(lblTinggi);

        txtTinggi = new JTextField();
        txtTinggi.setBounds(120, 120, 250, 25);
        this.add(txtTinggi);

        btnHitung = new JButton("Hitung");
        btnHitung.setBounds(140, 160, 120, 35);
        btnHitung.setBackground(new java.awt.Color(51, 102, 255));
        btnHitung.setForeground(new java.awt.Color(255, 255, 255));
        btnHitung.setFont(new java.awt.Font("Segoe UI", 1, 12));
        this.add(btnHitung);

        lblLuasPermukaan = new JLabel("Luas Permukaan");
        lblLuasPermukaan.setBounds(10, 215, 170, 20);
        lblLuasPermukaan.setFont(new java.awt.Font("Segoe UI", 1, 12));
        this.add(lblLuasPermukaan);

        txtLuasPermukaan = new JTextField();
        txtLuasPermukaan.setBounds(10, 240, 170, 25);
        txtLuasPermukaan.setEditable(false);
        this.add(txtLuasPermukaan);

        lblVolume = new JLabel("Volume");
        lblVolume.setBounds(200, 215, 170, 20);
        lblVolume.setFont(new java.awt.Font("Segoe UI", 1, 12));
        this.add(lblVolume);

        txtVolume = new JTextField();
        txtVolume.setBounds(200, 240, 170, 25);
        txtVolume.setEditable(false);
        this.add(txtVolume);

        btnHitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtJariJariBawah.getText().isEmpty() || txtJariJariAtas.getText().isEmpty() || txtTinggi.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Semua input harus diisi!");
                        return;
                    }

                    double jariJariBawahValue = Double.parseDouble(txtJariJariBawah.getText().replace(",", "."));
                    double jariJariAtasValue = Double.parseDouble(txtJariJariAtas.getText().replace(",", "."));
                    double tinggiValue = Double.parseDouble(txtTinggi.getText().replace(",", "."));

                    if (jariJariBawahValue <= 0 || jariJariAtasValue <= 0 || tinggiValue <= 0) {
                        JOptionPane.showMessageDialog(null, "Semua nilai harus lebih besar dari 0!", "Input Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (jariJariBawahValue <= jariJariAtasValue) {
                        JOptionPane.showMessageDialog(null, "Jari-jari bawah harus lebih besar dari jari-jari atas!", "Logika Salah", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    KerucutTerpancung kt = new KerucutTerpancung(jariJariBawahValue, tinggiValue, jariJariAtasValue);
                    txtLuasPermukaan.setText(String.format("%.2f", kt.hitungLuasPermukaan()));
                    txtVolume.setText(String.format("%.2f", kt.hitungVolume()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Input harus angka!");
                }
            }
        });
    }

    public static void main(String[] args) {
        new KerucutTerpancungFrame().setVisible(true);
    }
}