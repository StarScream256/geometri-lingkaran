package ui;

import geometri2d.JuringLingkaran;
import javax.swing.*;
import java.awt.event.*;

public class JuringLingkaranFrame extends JFrame {

    private JTextField txtJariJari;
    private JTextField txtSudut; 
    private JButton btnHitung;
    private JLabel lblLuas, lblKeliling;
    private JTextField txtLuas, txtKeliling;

    public JuringLingkaranFrame() {
        setTitle("Juring Lingkaran");
        setSize(400, 360); 
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblTitle = new JLabel("Juring Lingkaran");
        lblTitle.setBounds(100, 15, 200, 30);
        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18));
        add(lblTitle);

        JLabel lblJariJari = new JLabel("Jari-jari");
        lblJariJari.setBounds(10, 60, 100, 20);
        lblJariJari.setFont(new java.awt.Font("Segoe UI", 1, 12));
        add(lblJariJari);

        txtJariJari = new JTextField();
        txtJariJari.setBounds(120, 60, 250, 25);
        add(txtJariJari);

        JLabel lblSudut = new JLabel("Sudut (Derajat)");
        lblSudut.setBounds(10, 100, 100, 20);
        lblSudut.setFont(new java.awt.Font("Segoe UI", 1, 12));
        add(lblSudut);

        txtSudut = new JTextField();
        txtSudut.setBounds(120, 100, 250, 25);
        add(txtSudut);
   
        btnHitung = new JButton("Hitung");
        btnHitung.setBounds(140, 145, 120, 30);
        btnHitung.setBackground(new java.awt.Color(51, 51, 255));
        btnHitung.setForeground(new java.awt.Color(255, 255, 255));
        btnHitung.setFont(new java.awt.Font("Segoe UI", 1, 12));
        add(btnHitung);

        lblLuas = new JLabel("Luas Juring");
        lblLuas.setBounds(10, 200, 170, 20);
        lblLuas.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblLuas.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblLuas);

        txtLuas = new JTextField();
        txtLuas.setBounds(10, 225, 170, 25);
        txtLuas.setEditable(false);
        add(txtLuas);

        lblKeliling = new JLabel("Keliling Juring");
        lblKeliling.setBounds(200, 200, 170, 20);
        lblKeliling.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblKeliling.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblKeliling);

        txtKeliling = new JTextField();
        txtKeliling.setBounds(200, 225, 170, 25);
        txtKeliling.setEditable(false);
        add(txtKeliling);

        // ACTION LISTENER TOMBOL HITUNG
        btnHitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtJariJari.getText().isEmpty() || txtSudut.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Semua input harus diisi!", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    double jariJariValue = Double.parseDouble(txtJariJari.getText().replace(",", "."));
                    double sudutValue = Double.parseDouble(txtSudut.getText().replace(",", "."));

                    if (jariJariValue <= 0) {
                        JOptionPane.showMessageDialog(null, "Jari-jari harus lebih dari 0!", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }
                    if (sudutValue <= 0 || sudutValue > 360) {
                        JOptionPane.showMessageDialog(null, "Sudut harus berada di antara 0 sampai 360 derajat!", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    JuringLingkaran juring = new JuringLingkaran(jariJariValue, sudutValue);
 
                    txtLuas.setText(String.format("%.2f", juring.hitungLuas()));
                    txtKeliling.setText(String.format("%.2f", juring.hitungKeliling()));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Input harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        new JuringLingkaranFrame().setVisible(true);
    }
}