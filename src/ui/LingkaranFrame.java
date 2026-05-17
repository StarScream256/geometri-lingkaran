package ui;

import geometri2d.Lingkaran;
import javax.swing.*;
import java.awt.event.*;

public class LingkaranFrame extends JFrame {

    private JTextField txtJariJari;
    private JButton btnHitung;
    private JLabel lblLuas, lblKeliling;
    private JTextField txtLuas, txtKeliling;

    public LingkaranFrame() {
        setTitle("Lingkaran");
        setSize(400, 320);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel lblTitle = new JLabel("LINGKARAN");
        lblTitle.setBounds(130, 15, 140, 30);
        lblTitle.setFont(new java.awt.Font("Segoe UI", 1, 18));
        add(lblTitle);

        JLabel lblJariJari = new JLabel("Jari-jari");
        lblJariJari.setBounds(10, 60, 100, 20);
        lblJariJari.setFont(new java.awt.Font("Segoe UI", 1, 12));
        add(lblJariJari);

        txtJariJari = new JTextField();
        txtJariJari.setBounds(120, 60, 250, 25);
        add(txtJariJari);

        btnHitung = new JButton("Hitung");
        btnHitung.setBounds(140, 105, 120, 30);
        btnHitung.setBackground(new java.awt.Color(51, 51, 255));
        btnHitung.setForeground(new java.awt.Color(255, 255, 255));
        btnHitung.setFont(new java.awt.Font("Segoe UI", 1, 12));
        add(btnHitung);

        lblLuas = new JLabel("Luas");
        lblLuas.setBounds(10, 160, 170, 20);
        lblLuas.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblLuas.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblLuas);

        txtLuas = new JTextField();
        txtLuas.setBounds(10, 185, 170, 25);
        txtLuas.setEditable(false);
        add(txtLuas);

        lblKeliling = new JLabel("Keliling");
        lblKeliling.setBounds(200, 160, 170, 20);
        lblKeliling.setFont(new java.awt.Font("Segoe UI", 1, 12));
        lblKeliling.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblKeliling);

        txtKeliling = new JTextField();
        txtKeliling.setBounds(200, 185, 170, 25);
        txtKeliling.setEditable(false);
        add(txtKeliling);

        btnHitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if (txtJariJari.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Semua input harus diisi!");
                        return;
                    }

                    double jariJariValue = Double.parseDouble(txtJariJari.getText().replace(",", "."));

                    if (jariJariValue <= 0) {
                        JOptionPane.showMessageDialog(null, "Jari-jari harus lebih dari 0!", "Warning", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                    Lingkaran lingkaran = new Lingkaran(jariJariValue);
                    txtLuas.setText(String.format("%.2f", lingkaran.hitungLuas()));
                    txtKeliling.setText(String.format("%.2f", lingkaran.hitungKeliling()));

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Input harus angka!");
                }
            }
        });
    }

    public static void main(String[] args) {
        new LingkaranFrame().setVisible(true);
    }
}