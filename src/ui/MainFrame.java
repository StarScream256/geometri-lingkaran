package ui;

import javax.swing.*;

public class MainFrame extends JFrame {

    private JButton lingkaranButton, kerucutButton, kerucutTerpancungButton, tabungButton;
    private JButton bolaButton, juringBolaButton, temberengBolaButton, cincinBolaButton;

    public MainFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lingkaranButton = new JButton();
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
                .addGap(0, 22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bolaButton)
                        .addGap(5, 5, 5)
                        .addComponent(juringBolaButton)
                        .addGap(4, 4, 4)
                        .addComponent(temberengBolaButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cincinBolaButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lingkaranButton)
                        .addGap(5, 5, 5)
                        .addComponent(kerucutTerpancungButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(kerucutButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tabungButton))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(lingkaranButton)
                    .addComponent(kerucutTerpancungButton)
                    .addComponent(tabungButton)
                    .addComponent(kerucutButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(temberengBolaButton)
                    .addComponent(cincinBolaButton)
                    .addComponent(bolaButton)
                    .addComponent(juringBolaButton))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }

    private void cincinBolaButtonActionPerformed(java.awt.event.ActionEvent evt) {
        CincinBolaTorusFrame f = new CincinBolaTorusFrame();
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