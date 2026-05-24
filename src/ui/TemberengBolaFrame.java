package ui;

import javax.swing.*;
import java.awt.event.*;

import geometri3d.TemberengBola;
import geometri3d.TemberengBolaThread;

public class TemberengBolaFrame extends JFrame {

    private JTextField txtR;
    private JTextField txtTinggi;

    private JButton btnHitung;

    private JLabel lblHasil;

    public TemberengBolaFrame() {

        setTitle("Hitung Volume Tembereng Bola");

        setSize(320, 230);

        setLayout(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
        JLabel lblR = new JLabel("Jari-jari:");
        lblR.setBounds(20, 20, 100, 20);
        add(lblR);

        txtR = new JTextField();
        txtR.setBounds(120, 20, 150, 25);
        add(txtR);

        // label tinggi
        JLabel lblTinggi = new JLabel("Tinggi:");
        lblTinggi.setBounds(20, 60, 100, 20);
        add(lblTinggi);

        // textfield tinggi
        txtTinggi = new JTextField();
        txtTinggi.setBounds(120, 60, 150, 25);
        add(txtTinggi);

        // tombol hitung
        btnHitung = new JButton("Hitung");
        btnHitung.setBounds(90, 100, 120, 30);
        add(btnHitung);

        // label hasil
        lblHasil = new JLabel("Hasil : ");
        lblHasil.setBounds(20, 150, 250, 20);
        add(lblHasil);

        // event handling
        btnHitung.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {

                    // validasi input kosong
                    if (txtR.getText().isEmpty()
                            || txtTinggi.getText().isEmpty()) {

                        JOptionPane.showMessageDialog(
                                null,
                                "Input tidak boleh kosong!"
                        );

                        return;
                    }

                    // parsing input
                    double r =
                            Double.parseDouble(
                                    txtR.getText().replace(",", ".")
                            );

                    double t =
                            Double.parseDouble(
                                    txtTinggi.getText().replace(",", ".")
                            );

                    // object
                    TemberengBola tb =
                            new TemberengBola(r, t);

                    // multithreading
                    Thread thread =
                            new Thread(
                                    new TemberengBolaThread(tb)
                            );

                    thread.start();

                    // tampilkan hasil
                    lblHasil.setText(
                            "Hasil : "
                            + String.format(
                                    "%.2f",
                                    tb.hitungVolume()
                            )
                    );

                } catch (NumberFormatException ex) {

                    // exception handling
                    JOptionPane.showMessageDialog(
                            null,
                            "Input harus angka!"
                    );
                }
            }
        });

        setLocationRelativeTo(null);
    }

    // main testing
    public static void main(String[] args) {

        new TemberengBolaFrame().setVisible(true);
    }
}