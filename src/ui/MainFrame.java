package ui;

import javax.swing.*;

public class MainFrame extends JFrame {

    private JButton lingkaranButton, juringLingkaranButton, temberengLingkaranButton;
    private JButton kerucutButton, kerucutTerpancungButton, tabungButton;
    private JButton bolaButton, juringBolaButton, temberengBolaButton, cincinBolaButton;

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lingkaranButton = new JButton();
        juringLingkaranButton = new JButton();
        temberengLingkaranButton = new JButton();
        kerucutButton = new JButton();
        kerucutTerpancungButton = new JButton();
        tabungButton = new JButton();
        bolaButton = new JButton();
        juringBolaButton = new JButton();
        temberengBolaButton = new JButton();
        cincinBolaButton = new JButton();
        JLabel jLabel1 = new JLabel();

        lingkaranButton.setText("Lingkaran");
        lingkaranButton.addActionListener(evt -> lingkaranButtonActionPerformed(evt));

        juringLingkaranButton.setText("Juring Lingkaran");
        juringLingkaranButton.addActionListener(evt -> juringLingkaranButtonActionPerformed(evt));

        temberengLingkaranButton.setText("Tembereng Lingkaran");
        temberengLingkaranButton.addActionListener(evt -> temberengLingkaranButtonActionPerformed(evt));
        
        kerucutButton.setText("Kerucut");
        kerucutButton.addActionListener(evt -> kerucutButtonActionPerformed(evt));

        kerucutTerpancungButton.setText("Kerucut Terpancung");
        kerucutTerpancungButton.addActionListener(evt -> kerucutTerpancungButtonActionPerformed(evt));

        tabungButton.setText("Tabung");
        tabungButton.addActionListener(evt -> tabungButtonActionPerformed(evt));

        bolaButton.setText("Bola");
        bolaButton.addActionListener(evt -> bolaButtonActionPerformed(evt));

        juringBolaButton.setText("Juring Bola");
        juringBolaButton.addActionListener(evt -> juringBolaButtonActionPerformed(evt));

        temberengBolaButton.setText("Tembereng Bola");
        temberengBolaButton.addActionListener(evt -> temberengBolaButtonActionPerformed(evt));

        cincinBolaButton.setText("Cincin Bola");
        cincinBolaButton.addActionListener(evt -> cincinBolaButtonActionPerformed(evt));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14));
        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setText("Geometri Lingkaran");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                    // Baris 1
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lingkaranButton)
                        .addGap(5, 5, 5)
                        .addComponent(juringLingkaranButton)
                        .addGap(5, 5, 5)
                        .addComponent(temberengLingkaranButton)) // Sudah masuk sini sekarang!
                    // Baris 2
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tabungButton)
                        .addGap(5, 5, 5)
                        .addComponent(kerucutButton)
                        .addGap(5, 5, 5)
                        .addComponent(kerucutTerpancungButton))
                    // Baris 3
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bolaButton)
                        .addGap(5, 5, 5)
                        .addComponent(juringBolaButton)
                        .addGap(5, 5, 5)
                        .addComponent(temberengBolaButton)
                        .addGap(5, 5, 5)
                        .addComponent(cincinBolaButton)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                // Baris 1
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lingkaranButton)
                    .addComponent(juringLingkaranButton)
                    .addComponent(temberengLingkaranButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                // Baris 2
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tabungButton)
                    .addComponent(kerucutButton)
                    .addComponent(kerucutTerpancungButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                // Baris 3
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bolaButton)
                    .addComponent(juringBolaButton)
                    .addComponent(temberengBolaButton)
                    .addComponent(cincinBolaButton))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pack();
    }

    private void juringLingkaranButtonActionPerformed(java.awt.event.ActionEvent evt) {
        JuringLingkaranFrame f = new JuringLingkaranFrame();
        f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private void temberengLingkaranButtonActionPerformed(java.awt.event.ActionEvent evt) {
        TemberengLingkaranFrame f = new TemberengLingkaranFrame();
        f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
    private void cincinBolaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        CincinBolaFrame f = new CincinBolaFrame();
        f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private void tabungButtonActionPerformed(java.awt.event.ActionEvent evt) {
        TabungFrame f = new TabungFrame();
        f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private void temberengBolaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        TemberengBolaFrame f = new TemberengBolaFrame();
        f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private void kerucutTerpancungButtonActionPerformed(java.awt.event.ActionEvent evt) {
        KerucutTerpancungFrame f = new KerucutTerpancungFrame();
        f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private void kerucutButtonActionPerformed(java.awt.event.ActionEvent evt) {
        KerucutFrame f = new KerucutFrame();
        f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    private void bolaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        BolaFrame bola = new BolaFrame();
        bola.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        bola.setLocationRelativeTo(null);
        bola.setVisible(true);
    }

    private void juringBolaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        JuringBolaFrame juringBola = new JuringBolaFrame();
        juringBola.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        juringBola.setLocationRelativeTo(null);
        juringBola.setVisible(true);
    }

    private void lingkaranButtonActionPerformed(java.awt.event.ActionEvent evt) {
        LingkaranFrame f = new LingkaranFrame();
        f.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

    public static void main(String args[]) {
        new MainFrame().setVisible(true);
    }
}