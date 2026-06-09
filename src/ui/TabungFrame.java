package ui;

import geometri3d.Tabung;
import javax.swing.*;
import java.awt.event.*;

public class TabungFrame extends JFrame {

    public JTextField txtR;
    public JTextField txtTinggi;
    public JButton btnHitung;
    public JLabel labelLuasPermukaan, labelVolume;

    public TabungFrame() {
        this.setTitle("Hitung Volume Tabung");
        this.setSize(320, 230);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JLabel lblR = new JLabel("Jari-jari:");
        lblR.setBounds(20, 20, 100, 20);
        this.add(lblR);

        txtR = new JTextField();
        txtR.setBounds(120, 20, 150, 25);
        this.add(txtR);

        JLabel lblTinggi = new JLabel("Tinggi:");
        lblTinggi.setBounds(20, 60, 100, 20);
        this.add(lblTinggi);

        txtTinggi = new JTextField();
        txtTinggi.setBounds(120, 60, 150, 25);
        this.add(txtTinggi);

        btnHitung = new JButton("Hitung");
        btnHitung.setBounds(90, 100, 120, 30);
        this.add(btnHitung);

        labelLuasPermukaan = new JLabel();
        labelLuasPermukaan.setBounds(20, 150, 250, 20);
        this.add(labelLuasPermukaan);
        
        labelVolume = new JLabel();
        labelVolume.setBounds(180, 150, 250, 20);
        this.add(labelVolume);

        btnHitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtR.getText().isEmpty() || txtTinggi.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Input tidak boleh kosong!");
                        return;
                    }

                    double r = Double.parseDouble(txtR.getText().replace(",", "."));
                    double t = Double.parseDouble(txtTinggi.getText().replace(",", "."));

                    Tabung tabung = new Tabung(r, t);
                    labelLuasPermukaan.setText("Luas Permukaan : " + String.format("%.2f", tabung.hitungLuasPermukaan()));
                    labelVolume.setText("Volume : " + String.format("%.2f", tabung.hitungVolume()));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Input harus angka!");
                }
            }
        });
    }

    public static void main(String[] args) {
        new TabungFrame().setVisible(true);
    }
}