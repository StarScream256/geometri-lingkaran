package ui;

import geometri3d.Kerucut;
import javax.swing.*;
import java.awt.event.*;

public class KerucutFrame extends JFrame {

    private JTextField txtJariJari, txtTinggi;
    private JButton btnHitung;
    private JLabel lblLuasPermukaan, lblVolume;
    private JTextField txtLuasPermukaan, txtVolume;

    public KerucutFrame() {
        setTitle("Kerucut");
        setSize(400, 350);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblTitle = new JLabel("Kerucut");
        lblTitle.setBounds(160, 15, 80, 25);
        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblTitle);

        JLabel lblJariJari = new JLabel("Jari-jari");
        lblJariJari.setBounds(10, 50, 100, 20);
        add(lblJariJari);

        txtJariJari = new JTextField();
        txtJariJari.setBounds(120, 50, 250, 25);
        add(txtJariJari);

        JLabel lblTinggi = new JLabel("Tinggi Kerucut");
        lblTinggi.setBounds(10, 85, 100, 20);
        add(lblTinggi);

        txtTinggi = new JTextField();
        txtTinggi.setBounds(120, 85, 250, 25);
        add(txtTinggi);

        btnHitung = new JButton("Hitung");
        btnHitung.setBounds(140, 125, 120, 35);
        btnHitung.setBackground(new java.awt.Color(51, 102, 255));
        btnHitung.setForeground(new java.awt.Color(255, 255, 255));
        btnHitung.setFont(new java.awt.Font("Segoe UI", 1, 12));
        add(btnHitung);

        lblLuasPermukaan = new JLabel("Luas Permukaan");
        lblLuasPermukaan.setBounds(10, 180, 170, 20);
        lblLuasPermukaan.setFont(new java.awt.Font("Segoe UI", 1, 12));
        add(lblLuasPermukaan);

        txtLuasPermukaan = new JTextField();
        txtLuasPermukaan.setBounds(10, 205, 170, 25);
        txtLuasPermukaan.setEditable(false);
        add(txtLuasPermukaan);

        lblVolume = new JLabel("Volume");
        lblVolume.setBounds(200, 180, 170, 20);
        lblVolume.setFont(new java.awt.Font("Segoe UI", 1, 12));
        add(lblVolume);

        txtVolume = new JTextField();
        txtVolume.setBounds(200, 205, 170, 25);
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
                        JOptionPane.showMessageDialog(null, "Jari-jari dan Tinggi harus lebih dari 0!", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    Kerucut kerucut = new Kerucut(jariJariValue, tinggiValue);
                    txtLuasPermukaan.setText(String.format("%.2f", kerucut.hitungLuasPermukaan()));
                    txtVolume.setText(String.format("%.2f", kerucut.hitungVolume()));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Input harus angka!");
                }
            }
        });
    }

    public static void main(String[] args) {
        new KerucutFrame().setVisible(true);
    }
}