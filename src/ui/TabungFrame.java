package ui;

import geometri3d.Tabung;

import javax.swing.*;
import java.awt.event.*;

public class TabungFrame extends JFrame {

    private JTextField txtR;
    private JTextField txtTinggi;
    private JButton btnHitung;
    private JLabel lblHasil;

    public TabungFrame() {

        setTitle("Hitung Volume Tabung");

        setSize(320, 230);

        setLayout(null);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblR = new JLabel("Jari-jari:");
        lblR.setBounds(20, 20, 100, 20);
        add(lblR);

        txtR = new JTextField();
        txtR.setBounds(120, 20, 150, 25);
        add(txtR);

        JLabel lblTinggi = new JLabel("Tinggi:");
        lblTinggi.setBounds(20, 60, 100, 20);
        add(lblTinggi);

        txtTinggi = new JTextField();
        txtTinggi.setBounds(120, 60, 150, 25);
        add(txtTinggi);

        btnHitung = new JButton("Hitung");
        btnHitung.setBounds(90, 100, 120, 30);
        add(btnHitung);

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

                    // object tabung
                    Tabung tabung =
                            new Tabung(r, t);

                    // tampilkan hasil
                    lblHasil.setText(
                            "Hasil : "
                            + String.format(
                                    "%.2f",
                                    tabung.hitungVolume()
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

    // main untuk testing
    public static void main(String[] args) {

        new TabungFrame().setVisible(true);
    }
}