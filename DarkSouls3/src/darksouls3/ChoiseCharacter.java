/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package darksouls3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 *
 * @author lleshi.alessandro
 */
public class ChoiseCharacter extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ChoiseCharacter.class.getName());
    String nameCharacter;
    boolean characterChoose;
    GameScreen gS = new GameScreen();
    /**
     * Creates new form ChoiseCharacter
     */
    public ChoiseCharacter() {
        initComponents();
        JPanel mainPanel = new JPanel(new BorderLayout()){
            Image sfondo = new ImageIcon("immagini/sfondo_scelta_pg_giusto.jpg").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(sfondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        JPanel northPanel = new JPanel();
        JLabel title = new JLabel("SCEGLI IL TUO AVVENTURIERO");
        
        
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        northPanel.add(title, BorderLayout.CENTER);
        northPanel.setPreferredSize(new Dimension(0, 140));    // altezza del nord
        
        
        //panel che conterrà 4 panel su una riga, che a loro volta conterranno l'icon del pg
        JPanel centerPanel = new JPanel(new GridLayout(1, 4, 20, 10));
        
        JPanel pg1 = new JPanel(new BorderLayout());

        // panel per l'immagine
        JPanel imagePanel1 = new JPanel() {
            Image sfondo = new ImageIcon("immagini/barbarian.png").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(sfondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        pg1.add(imagePanel1, BorderLayout.CENTER);
        // pulsante sotto
        JButton history = new JButton("HISTORY");
        pg1.add(history, BorderLayout.SOUTH);
        imagePanel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("YOU HAVE CLICKED THE BARBARIAN");
                Character c = new Barbarian(20, 90, nameCharacter, 100, 25);
                dispose();
                gS.setVisible(true);
            }
        });
        
        // pg2
        JPanel pg2 = new JPanel(new BorderLayout());

        // panel immagine
        JPanel imagePanel2 = new JPanel() {
            Image sfondo = new ImageIcon("immagini/knight.png").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(sfondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        pg2.add(imagePanel2, BorderLayout.CENTER);
        // pulsante sotto
        JButton history2 = new JButton("HISTORY");
        pg2.add(history2, BorderLayout.SOUTH);
        imagePanel2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("YOU HAVE CLICKED THE KNIGHT");
                Character c = new Knight(35, 75, nameCharacter, 100, 22);
                dispose();
                gS.setVisible(true);
            }
        });

        // pg3
        JPanel pg3 = new JPanel(new BorderLayout());
        JPanel imagePanel3 = new JPanel() {
            Image sfondo = new ImageIcon("immagini/mage.png").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(sfondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        pg3.add(imagePanel3, BorderLayout.CENTER);
        JButton history3 = new JButton("HISTORY");
        pg3.add(history3, BorderLayout.SOUTH);
        imagePanel3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("YOU HAVE CLICKED THE MAGE");
                Character c = new Mage(90, 25, nameCharacter, 100, 28);
                dispose();
                gS.setVisible(true);
            }
        });

        // pg4
        JPanel pg4 = new JPanel(new BorderLayout());
        JPanel imagePanel4 = new JPanel() {
            Image sfondo = new ImageIcon("immagini/priest.png").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(sfondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        pg4.add(imagePanel4, BorderLayout.CENTER);
        JButton history4 = new JButton("HISTORY");
        pg4.add(history4, BorderLayout.SOUTH);
        imagePanel4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("YOU HAVE CLICKED THE PRIEST");
                Character c = new Priest(60, 60, nameCharacter, 100, 20);
                dispose();
                gS.setVisible(true);
            }
        });
        
        pg1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pg2.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pg3.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pg4.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        pg1.setOpaque(false);
        pg2.setOpaque(false);
        pg3.setOpaque(false);
        pg4.setOpaque(false);
        
        
        imagePanel1.setOpaque(false);
        imagePanel2.setOpaque(false);
        imagePanel3.setOpaque(false);
        imagePanel4.setOpaque(false);
        
        
        pg2.setOpaque(false);
        pg3.setOpaque(false);
        pg4.setOpaque(false);
        centerPanel.setOpaque(false);
        
        centerPanel.add(pg1);
        centerPanel.add(pg2);
        centerPanel.add(pg3);
        centerPanel.add(pg4);
        
        
        JPanel southPanel = new JPanel();
        
        northPanel.setOpaque(false);
        southPanel.setOpaque(false);
        
        northPanel.add(title);
        JButton start = new JButton("START ADVENTURE");
        start.setMaximumSize(new Dimension(200, 50));
        southPanel.add(start);
        
        
        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(centerPanel, BorderLayout.CENTER);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        this.add(mainPanel);
        this.setSize(840, 420);
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
        java.awt.EventQueue.invokeLater(() -> new ChoiseCharacter().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
