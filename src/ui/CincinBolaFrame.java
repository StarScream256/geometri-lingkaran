package ui;

import geometri3d.CincinBola;
import geometrilingkaran.*;
import javax.swing.*;
import java.awt.event.*;

public class CincinBolaFrame extends JFrame {

    public JTextField txtJariJari, txtTinggi;
    public JButton btnHitung;
    public JLabel lblLuasPermukaan, lblVolume;

    public CincinBolaFrame() {

        this.setTitle("Cincin Bola (Spherical Ring)");
        this.setSize(380, 300);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblJudul = new JLabel("Cincin Bola (Spherical Ring)");
        lblJudul.setBounds(85, 15, 200, 25);
        lblJudul.setFont(new java.awt.Font("Segoe UI", 1, 14));
        this.add(lblJudul);

        JLabel lblJariJari = new JLabel("Jari-jari:");
        lblJariJari.setBounds(10, 50, 100, 20);
        this.add(lblJariJari);

        txtJariJari = new JTextField();
        txtJariJari.setBounds(120, 50, 120, 20);
        this.add(txtJariJari);

        JLabel lblTinggi = new JLabel("Tinggi Silinder:");
        lblTinggi.setBounds(10, 80, 100, 20);
        this.add(lblTinggi);

        txtTinggi = new JTextField();
        txtTinggi.setBounds(120, 80, 120, 20);
        this.add(txtTinggi);

        btnHitung = new JButton("Hitung");
        btnHitung.setBounds(115, 120, 120, 30);
        btnHitung.setBackground(new java.awt.Color(51, 102, 255));
        btnHitung.setForeground(new java.awt.Color(255, 255, 255));
        this.add(btnHitung);

        lblLuasPermukaan = new JLabel("Luas Permukaan");
        lblLuasPermukaan.setBounds(10, 170, 100, 20);
        lblLuasPermukaan.setFont(new java.awt.Font("Segoe UI", 1, 12));
        this.add(lblLuasPermukaan);

        JTextField txtLuasPermukaan = new JTextField();
        txtLuasPermukaan.setBounds(10, 195, 150, 30);
        txtLuasPermukaan.setEditable(false);
        this.add(txtLuasPermukaan);

        lblVolume = new JLabel("Volume");
        lblVolume.setBounds(200, 170, 100, 20);
        lblVolume.setFont(new java.awt.Font("Segoe UI", 1, 12));
        this.add(lblVolume);

        JTextField txtVolume = new JTextField();
        txtVolume.setBounds(200, 195, 150, 30);
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
                    CincinBola cincinBola = new CincinBola(jariJariValue, tinggiValue);
                    txtLuasPermukaan.setText(String.format("%.2f", cincinBola.hitungLuasPermukaan()));
                    txtVolume.setText(String.format("%.2f", cincinBola.hitungVolume()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Input harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (NegativeNumberException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        new CincinBolaFrame().setVisible(true);
    }
}