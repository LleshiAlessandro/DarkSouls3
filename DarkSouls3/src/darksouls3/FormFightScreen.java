/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package darksouls3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author aless
 */
public class FormFightScreen extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormFightScreen.class.getName());
    String keyWord;
    /**
     * Creates new form FIghtScreen
     * @param fG mi serve perché almeno il form non viene chiuso e il form corrente sa da chi è stato aperto
     * @param g il form che ha aperto il form corrente usa il suo stesso gestore
     * @param imgPath ho bisogno di sapere l'immagine del character scelto precedentemente
     */
    public FormFightScreen(FormGameScreen fG, GameManager g, String imgPath) {
        initComponents();
        
        
        JPanel mainPanel = new JPanel(new GridLayout(2,1)); // divide lo schermo in due righe
        this.add(mainPanel);

        JPanel bossPanel = new JPanel();
        JPanel bossImg_and_StatsPanel = new JPanel(new BorderLayout());
        bossPanel.add(bossImg_and_StatsPanel, BorderLayout.CENTER);
        
        
        JPanel bossStatsPanel = new JPanel(new GridLayout(5,1));
        bossStatsPanel.add(new JLabel("Name: " + g.v.name));
        bossStatsPanel.add(new JLabel("Life: " + g.v.getLife()));
        bossStatsPanel.add(new JLabel("Base Att: " + g.v.baseAtt));
       
        JPanel bossImgPanel = new JPanel() {
            Image sfondo = new ImageIcon(imgPath).getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(sfondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        bossImgPanel.setPreferredSize(new Dimension(300,650));
        
        
        
        
        
        bossImg_and_StatsPanel.add(bossImgPanel, BorderLayout.WEST);
        bossPanel.add(bossStatsPanel);
        mainPanel.add(bossPanel);

        JPanel characterPanel = new JPanel(new BorderLayout());
        characterPanel.setBackground(Color.GREEN);
        mainPanel.add(characterPanel);

        JPanel characterImg_and_StatsPanel = new JPanel(new BorderLayout());
        characterPanel.add(characterImg_and_StatsPanel, BorderLayout.CENTER);

        JPanel characterImgPanel = new JPanel() {
            Image sfondo = new ImageIcon(imgPath).getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(sfondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        characterImgPanel.setPreferredSize(new Dimension(300,650));
        characterImg_and_StatsPanel.add(characterImgPanel, BorderLayout.WEST);

        JPanel characterStatsPanel = new JPanel(new GridLayout(5,1));
        characterStatsPanel.add(new JLabel("Name: " + g.c.name));
        characterStatsPanel.add(new JLabel("Life: " + g.c.getLife()));
        characterStatsPanel.add(new JLabel("Mana: " + g.c.mana));
        characterStatsPanel.add(new JLabel("Stamina: " + g.c.stamina));
        characterStatsPanel.add(new JLabel("Base Att: " + g.c.baseAtt));
        characterImg_and_StatsPanel.add(characterStatsPanel, BorderLayout.EAST);
        characterImg_and_StatsPanel.setBorder(new EmptyBorder(20,20,20,20));

        JPanel azioniCharacterPanel = new JPanel(new BorderLayout());
        azioniCharacterPanel.setPreferredSize(new Dimension(600, 50));
        azioniCharacterPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        azioniCharacterPanel.setBackground(Color.DARK_GRAY);
        characterPanel.add(azioniCharacterPanel, BorderLayout.SOUTH);

        JPanel buttonsPanel = new JPanel(new GridLayout(1,3, 10,0));

        JButton heal = new JButton("Heal");
        JButton attac = new JButton("Attack");
        JButton roll = new JButton("Roll");

        Dimension buttonSize = new Dimension(120,40);
        heal.setPreferredSize(buttonSize);
        attac.setPreferredSize(buttonSize);
        roll.setPreferredSize(buttonSize);

        buttonsPanel.add(heal);
        buttonsPanel.add(attac);
        buttonsPanel.add(roll);

        azioniCharacterPanel.add(buttonsPanel, BorderLayout.CENTER);

        ActionListener actionHeal = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keyWord = "heal";
            }
        };
        ActionListener actionAttac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keyWord = "attack";
            }
        };
        ActionListener actionRoll = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keyWord = "roll";
            }
        };

        heal.addActionListener(actionHeal);
        attac.addActionListener(actionAttac);
        roll.addActionListener(actionRoll);

        keyWord = "attack";
        g.fight(keyWord);

        if (g.c.life <= 0 && g.v.life <= 0) {
            JOptionPane.showMessageDialog(this,
                "Both you and your foe have fallen… The fire fades.",
                "DARK SOULS 3",
                JOptionPane.INFORMATION_MESSAGE);
        }
        else if (g.c.life <= 0) {
            JOptionPane.showMessageDialog(this,
                "You have met your end… Ashes to ashes, ember to darkness.",
                "DARK SOULS 3",
                JOptionPane.INFORMATION_MESSAGE);
        }
        else if (g.v.life <= 0) {
            JOptionPane.showMessageDialog(this,
                "The foe crumbles to dust… Victory is yours, but the journey continues.",
                "DARK SOULS 3",
                JOptionPane.INFORMATION_MESSAGE);
        }

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
        java.awt.EventQueue.invokeLater(() -> new FormFightScreen(null, null, null).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
