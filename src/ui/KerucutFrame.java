package ui;

import geometri3d.Kerucut;
import geometrilingkaran.GeometriLingkaran;
import geometrilingkaran.NegativeNumberException;
import javax.swing.*;
import java.awt.event.*;

public class KerucutFrame extends JFrame {

    public JTextField txtJariJari, txtTinggi;
    public JButton btnHitung;
    public JLabel lblLuasPermukaan, lblVolume;
    public JTextField txtLuasPermukaan, txtVolume;

    public KerucutFrame() {
        this.setTitle("Kerucut");
        this.setSize(400, 350);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblTitle = new JLabel("Kerucut");
        lblTitle.setBounds(160, 15, 80, 25);
        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 14));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(lblTitle);

        JLabel lblJariJari = new JLabel("Jari-jari");
        lblJariJari.setBounds(10, 50, 100, 20);
        this.add(lblJariJari);

        txtJariJari = new JTextField();
        txtJariJari.setBounds(120, 50, 250, 25);
        this.add(txtJariJari);

        JLabel lblTinggi = new JLabel("Tinggi Kerucut");
        lblTinggi.setBounds(10, 85, 100, 20);
        this.add(lblTinggi);

        txtTinggi = new JTextField();
        txtTinggi.setBounds(120, 85, 250, 25);
        this.add(txtTinggi);

        btnHitung = new JButton("Hitung");
        btnHitung.setBounds(140, 125, 120, 35);
        btnHitung.setBackground(new java.awt.Color(51, 102, 255));
        btnHitung.setForeground(new java.awt.Color(255, 255, 255));
        btnHitung.setFont(new java.awt.Font("Segoe UI", 1, 12));
        this.add(btnHitung);

        lblLuasPermukaan = new JLabel("Luas Permukaan");
        lblLuasPermukaan.setBounds(10, 180, 170, 20);
        lblLuasPermukaan.setFont(new java.awt.Font("Segoe UI", 1, 12));
        this.add(lblLuasPermukaan);

        txtLuasPermukaan = new JTextField();
        txtLuasPermukaan.setBounds(10, 205, 170, 25);
        txtLuasPermukaan.setEditable(false);
        this.add(txtLuasPermukaan);

        lblVolume = new JLabel("Volume");
        lblVolume.setBounds(200, 180, 170, 20);
        lblVolume.setFont(new java.awt.Font("Segoe UI", 1, 12));
        this.add(lblVolume);

        txtVolume = new JTextField();
        txtVolume.setBounds(200, 205, 170, 25);
        txtVolume.setEditable(false);
        this.add(txtVolume);

        btnHitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtJariJari.getText().isEmpty() || txtTinggi.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Semua input harus diisi!");
                        return;
                    }

                    double jariJariValue = GeometriLingkaran.isValidPositive(Double.parseDouble(txtJariJari.getText().replace(",", ".")));
                    double tinggiValue = GeometriLingkaran.isValidPositive(Double.parseDouble(txtTinggi.getText().replace(",", ".")));
                    Kerucut kerucut = new Kerucut(jariJariValue, tinggiValue);
                    txtLuasPermukaan.setText(String.format("%.2f", kerucut.hitungLuasPermukaan()));
                    txtVolume.setText(String.format("%.2f", kerucut.hitungVolume()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Input harus angka!");
                } catch (NegativeNumberException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        new KerucutFrame().setVisible(true);
    }
}