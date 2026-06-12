package ui;

import geometri3d.JuringBola;
import javax.swing.*;
import java.awt.event.*;
import geometrilingkaran.*;

public class JuringBolaFrame extends JFrame {

    public JTextField txtJariJari, txtTinggi;
    public JButton btnHitung;
    public JLabel lblLuasPermukaan, lblVolume;
    public JTextField txtLuasPermukaan, txtVolume;

    public JuringBolaFrame() {
        this.setTitle("Juring Bola");
        this.setSize(400, 350);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblTitle = new JLabel("Juring Bola");
        lblTitle.setBounds(140, 15, 120, 25);
        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18));
        this.add(lblTitle);

        JLabel lblJari = new JLabel("Jari-jari");
        lblJari.setBounds(10, 50, 100, 20);
        this.add(lblJari);

        txtJariJari = new JTextField();
        txtJariJari.setBounds(120, 50, 250, 25);
        this.add(txtJariJari);

        JLabel lblTinggi = new JLabel("Tinggi");
        lblTinggi.setBounds(10, 85, 100, 20);
        this.add(lblTinggi);

        txtTinggi = new JTextField();
        txtTinggi.setBounds(120, 85, 250, 25);
        this.add(txtTinggi);

        btnHitung = new JButton("Hitung");
        btnHitung.setBounds(140, 125, 120, 35);
        btnHitung.setBackground(new java.awt.Color(51, 51, 255));
        btnHitung.setForeground(new java.awt.Color(255, 255, 255));
        btnHitung.setFont(new java.awt.Font("Segoe UI", 1, 12));
        this.add(btnHitung);

        lblLuasPermukaan = new JLabel("Luas Permukaan");
        lblLuasPermukaan.setBounds(10, 180, 170, 20);
        this.add(lblLuasPermukaan);

        txtLuasPermukaan = new JTextField();
        txtLuasPermukaan.setBounds(10, 205, 170, 25);
        txtLuasPermukaan.setEditable(false);
        this.add(txtLuasPermukaan);

        lblVolume = new JLabel("Volume");
        lblVolume.setBounds(200, 180, 170, 20);
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
                    JuringBola juringBola = new JuringBola(jariJariValue, tinggiValue);
                    txtLuasPermukaan.setText(String.format("%.2f", juringBola.hitungLuasPermukaan()));
                    txtVolume.setText(String.format("%.2f", juringBola.hitungVolume()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Input harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (NegativeNumberException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        new JuringBolaFrame().setVisible(true);
    }
}