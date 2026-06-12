package ui;

import javax.swing.*;
import java.awt.event.*;
import geometri3d.TemberengBola;
import geometrilingkaran.GeometriLingkaran;
import geometrilingkaran.NegativeNumberException;

public class TemberengBolaFrame extends JFrame {
    public JTextField txtJariJari;
    public JTextField txtTinggi;
    public JButton btnHitung;
    public JLabel labelLuasPermukaan, labelVolume;

    public TemberengBolaFrame() {
        this.setTitle("Hitung Volume Tembereng Bola");
        this.setSize(320, 230);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
       
        JLabel lblR = new JLabel("Jari-jari:");
        lblR.setBounds(20, 20, 100, 20);
        this.add(lblR);

        txtJariJari = new JTextField();
        txtJariJari.setBounds(120, 20, 150, 25);
        this.add(txtJariJari);

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
                    if (txtJariJari.getText().isEmpty() || txtTinggi.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Input tidak boleh kosong!");
                        return;
                    }

                    double jariJariValue = GeometriLingkaran.isValidPositive(Double.parseDouble(txtJariJari.getText().replace(",", ".")));
                    double tinggiValue = GeometriLingkaran.isValidPositive(Double.parseDouble(txtTinggi.getText().replace(",", ".")));
                    TemberengBola temberengBola = new TemberengBola(jariJariValue, tinggiValue);
                    labelLuasPermukaan.setText("Luas Permukaan : " + String.format("%.2f", temberengBola.hitungLuasPermukaan()));
                    labelVolume.setText("Volume : " + String.format("%.2f", temberengBola.hitungVolume()));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Input harus angka!");
                } catch (NegativeNumberException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        new TemberengBolaFrame().setVisible(true);
    }
}