package ui;

import javax.swing.*;
import java.awt.event.*;
import geometri3d.Bola;
import geometrilingkaran.*;

public class BolaFrame extends JFrame {

    public JTextField txtJari;
    public JButton btnHitung;
    public JLabel lblLuasPermukaan, lblVolume;

    public BolaFrame() {

        this.setTitle("Hitung Volume dan Luas Permukaan Bola");
        this.setSize(400, 250);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel l1 = new JLabel("Jari-jari:");
        l1.setBounds(10, 10, 100, 20);
        this.add(l1);

        txtJari = new JTextField();
        txtJari.setBounds(120, 10, 150, 20);
        this.add(txtJari);

        btnHitung = new JButton("Hitung");
        btnHitung.setBounds(130, 50, 120, 30);
        this.add(btnHitung);

        JLabel l2 = new JLabel("Luas Permukaan:");
        l2.setBounds(10, 100, 100, 20);
        this.add(l2);

        lblLuasPermukaan = new JLabel("0.00");
        lblLuasPermukaan.setBounds(120, 100, 150, 20);
        this.add(lblLuasPermukaan);

        JLabel l3 = new JLabel("Volume:");
        l3.setBounds(10, 140, 100, 20);
        this.add(l3);

        lblVolume = new JLabel("0.00");
        lblVolume.setBounds(120, 140, 150, 20);
        this.add(lblVolume);

        btnHitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtJari.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Jari-jari harus diisi!");
                        return;
                    }

                    double jariJari = GeometriLingkaran.isValidPositive(Double.parseDouble(txtJari.getText().replace(",", ".")));
                    Bola bola = new Bola(jariJari);
                    lblLuasPermukaan.setText(String.format("%.2f", bola.hitungLuasPermukaan()));
                    lblVolume.setText(String.format("%.2f", bola.hitungVolume()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Input harus angka!", "Warning", JOptionPane.WARNING_MESSAGE);
                } catch (NegativeNumberException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        new BolaFrame().setVisible(true);
    }
}