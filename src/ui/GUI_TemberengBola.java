package ui;

import javax.swing.*;
import java.awt.event.*;
import geometri3d.TemberengBola;
import geometri3d.TemberengBolaThread;

public class GUI_TemberengBola extends JFrame {

    private JTextField txtR, txtTinggi;
    private JButton btnHitung;
    private JLabel lblHasil;

    public GUI_TemberengBola() {

        setTitle("Hitung Volume Tembereng Bola");
        setSize(300, 220);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel l1 = new JLabel("Jari-jari:");
        l1.setBounds(10, 10, 100, 20);
        add(l1);

        txtR = new JTextField();
        txtR.setBounds(120, 10, 120, 20);
        add(txtR);

        JLabel l2 = new JLabel("Tinggi:");
        l2.setBounds(10, 40, 100, 20);
        add(l2);

        txtTinggi = new JTextField();
        txtTinggi.setBounds(120, 40, 120, 20);
        add(txtTinggi);

        btnHitung = new JButton("Hitung");
        btnHitung.setBounds(80, 80, 120, 30);
        add(btnHitung);

        lblHasil = new JLabel("Hasil: ");
        lblHasil.setBounds(10, 130, 260, 20);
        add(lblHasil);

        btnHitung.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {

                    if (txtR.getText().isEmpty() || txtTinggi.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Semua input harus diisi!");
                        return;
                    }

                    double r = Double.parseDouble(txtR.getText().replace(",", "."));
                    double t = Double.parseDouble(txtTinggi.getText().replace(",", "."));

                    TemberengBola tb = new TemberengBola(r, t);

                    // thread
                    TemberengBolaThread thread = new TemberengBolaThread(tb);
                    thread.start();

                    lblHasil.setText("Hasil: " + String.format("%.2f", tb.hitungVolume()));

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Input harus angka!");
                }
            }
        });

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new GUI_TemberengBola();
    }
}