/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package darksouls3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.*;

/**
 *
 * @author lleshi.alessandro
 */
public class FormChoiseEnding extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormChoiseEnding.class.getName());
    private boolean hasAnri = false;
    private boolean hasYuria = false;
    private boolean hasYoel = false;
    private boolean hasFireKeeper = false;
    private String endPath = "";
    private JPanel img;
    private Timer t;
    private int leaseTime = 30;

    /**
     * Creates new form FormChoiseEnding
     */
    public FormChoiseEnding(GameManager g) {
        initComponents();
        t = new Timer(1000, e -> {
            leaseTime--;
            if (leaseTime <= 0) {
                g.stopEndSound();
                dispose();
            }
        });
        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        JButton badEnd = new JButton("<html>The flame has waned…<br>Shadows crawl where light once held sway.<br>From the ashes of fire, a new Lord of Darkness rises.<br>All shall kneel beneath the endless night… and the age of man fades into legend.</html>");
        JButton classicEnd = new JButton("<html>The fire flickers, frail yet unbroken…<br>Through pain and sacrifice, the flame endures.<br>A fragile light against the encroaching dark, it burns once more.<br>And so the cycle continues, until the fire fades again.</html>");
        JButton goodEnd = new JButton("<html>The flame trembles and then ebbs…<br>The fire fades, but not in despair.<br>In its absence, a quiet dawn breaks upon Lothric, and hope, long dormant, stirs once more.<br>The age of fire may end, yet life endures.</html>");
        Dimension buttonDimension = new Dimension(20, 100);

        badEnd.setPreferredSize(buttonDimension);
        classicEnd.setPreferredSize(buttonDimension);
        goodEnd.setPreferredSize(buttonDimension);

        goodEnd.setEnabled(false);
        badEnd.setEnabled(false);

        buttonPanel.add(badEnd);
        buttonPanel.add(classicEnd);
        buttonPanel.add(goodEnd);

        for (NPC n : g.c.npcsMet) {
            if (n.getName().equals(NPC_Name.ANRI_OF_ASTORA)) {
                hasAnri = true;
            } else if (n.getName().equals(NPC_Name.YURIA_OF_LONDOR)) {
                hasYuria = true;
            } else if (n.getName().equals(NPC_Name.YOEL_OF_LONDOR)) {
                hasYoel = true;
            } else if (n.getName().equals(NPC_Name.FIRE_KEEPER)) {
                hasFireKeeper = true;
            }
        }

        // abilita bottoni corretti
        if (hasAnri == true || hasYuria == true || hasYoel == true) {
            badEnd.setEnabled(true);
        }

        if (hasFireKeeper == true) {
            goodEnd.setEnabled(true);
        }

        // classic sempre disponibile
        classicEnd.setEnabled(true);

        //da implementare i 3 bottoni, devo aggiungere il controllo degli npc e quinid se è possibile fare il finale, poi dovrò scegliere 3 immagini
        badEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endPath = "immagini/badEnd.jpg";
                buttonPanel.setVisible(false);
                img.repaint();
                t.start();
                g.endSound();

            }
        });

        classicEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endPath = "immagini/classicEnd.jpg";
                buttonPanel.setVisible(false);
                img.repaint();
                t.start();
                g.endSound();
            }
        });

        goodEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endPath = "immagini/goodEnd.jpg";
                buttonPanel.setVisible(false);
                img.repaint();
                t.start();
                g.endSound();
            }
        });

        img = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (endPath != null && !endPath.isEmpty()) {
                    Image sfondo = new ImageIcon(endPath).getImage();
                    g.drawImage(sfondo, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };

        mainPanel.add(img, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(mainPanel);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
