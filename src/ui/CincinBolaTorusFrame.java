package ui;

import geometri3d.CincinBolaTorus;
import javax.swing.*;
import java.awt.event.*;

public class CincinBolaTorusFrame extends JFrame {

    private JTextField txtJariJariMinor, txtJariJariMajor;
    private JButton btnHitung;
    private JLabel lblLuasPermukaan, lblVolume;
    private JTextField txtLuasPermukaan, txtVolume;

    public CincinBolaTorusFrame() {
        setTitle("Cincin Bola (Torus)");
        setSize(400, 350);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblTitle = new JLabel("Cincin Bola (Torus)");
        lblTitle.setBounds(120, 15, 150, 25);
        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblTitle);

        JLabel lblJariJariMinor = new JLabel("Jari-jari Minor");
        lblJariJariMinor.setBounds(10, 50, 100, 20);
        add(lblJariJariMinor);

        txtJariJariMinor = new JTextField();
        txtJariJariMinor.setBounds(120, 50, 250, 25);
        add(txtJariJariMinor);

        JLabel lblJariJariMajor = new JLabel("Jari-jari Major");
        lblJariJariMajor.setBounds(10, 85, 100, 20);
        add(lblJariJariMajor);

        txtJariJariMajor = new JTextField();
        txtJariJariMajor.setBounds(120, 85, 250, 25);
        add(txtJariJariMajor);

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
                    if (txtJariJariMinor.getText().isEmpty() || txtJariJariMajor.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Semua input harus diisi!");
                        return;
                    }

                    double jariJariMinor = Double.parseDouble(txtJariJariMinor.getText().replace(",", "."));
                    double jariJariMajor = Double.parseDouble(txtJariJariMajor.getText().replace(",", "."));

                    if (jariJariMinor <= 0 || jariJariMajor <= 0) {
                        JOptionPane.showMessageDialog(null, "Jari-jari Minor dan Major harus lebih besar dari 0.", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    if (jariJariMajor <= jariJariMinor) {
                        JOptionPane.showMessageDialog(null, "Untuk membentuk torus yang memiliki lubang di tengah maka Jari-jari Major harus lebih besar dari Jari-jari Minor.", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    CincinBolaTorus cincinBolaTorus = new CincinBolaTorus(jariJariMinor, jariJariMajor);
                    txtLuasPermukaan.setText(String.format("%.2f", cincinBolaTorus.hitungLuasPermukaan()));
                    txtVolume.setText(String.format("%.2f", cincinBolaTorus.hitungVolume()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Input harus angka!");
                }
            }
        });
    }

    public static void main(String[] args) {
        new CincinBolaTorusFrame().setVisible(true);
    }
}