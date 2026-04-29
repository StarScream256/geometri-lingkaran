/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui;

import javax.swing.*;
import java.awt.event.*;
import geometri3d.Tabung;
import geometri3d.TabungThread;

public class GUI_Tabung extends JFrame {

    private JTextField txtR, txtTinggi;
    private JButton btnHitung;
    private JLabel lblHasil;

    public GUI_Tabung() {

        setTitle("Hitung Volume Tabung");
        setSize(300, 220);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Label Jari-jari
        JLabel l1 = new JLabel("Jari-jari:");
        l1.setBounds(10, 10, 100, 20);
        add(l1);

        txtR = new JTextField();
        txtR.setBounds(120, 10, 120, 20);
        add(txtR);

        // Label Tinggi
        JLabel l2 = new JLabel("Tinggi:");
        l2.setBounds(10, 40, 100, 20);
        add(l2);

        txtTinggi = new JTextField();
        txtTinggi.setBounds(120, 40, 120, 20);
        add(txtTinggi);

        // Tombol Hitung
        btnHitung = new JButton("Hitung");
        btnHitung.setBounds(80, 80, 120, 30);
        add(btnHitung);

        // Label hasil
        lblHasil = new JLabel("Hasil: ");
        lblHasil.setBounds(10, 130, 260, 20);
        add(lblHasil);

        // EVENT BUTTON
        btnHitung.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    // VALIDASI INPUT KOSONG
                    if (txtR.getText().isEmpty() || txtTinggi.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Semua input harus diisi!");
                        return;
                    }

                    // SUPPORT koma (7,5 → 7.5)
                    double r = Double.parseDouble(txtR.getText().replace(",", "."));
                    double t = Double.parseDouble(txtTinggi.getText().replace(",", "."));

                    // OBJECT TABUNG
                    Tabung tabung = new Tabung(r, t);

                    // THREAD (sesuai materi)
                    TabungThread thread = new TabungThread(tabung);
                    thread.start();

                    // TAMPILKAN HASIL (format 2 desimal)
                    lblHasil.setText("Hasil: " + String.format("%.2f", tabung.getVolume()));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Input harus angka!");
                }
            }
        });

        setVisible(true);
    }

    // MAIN untuk testing (tidak melanggar aturan, hanya untuk run sendiri)
    public static void main(String[] args) {
        new GUI_Tabung();
    }
}