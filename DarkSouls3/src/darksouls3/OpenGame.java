/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package darksouls3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author aless
 */
public class OpenGame extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(OpenGame.class.getName());
    String instructions = "Welcome to Lothric, brave traveler.\n\n\n"
                + "Before beginning your journey, choose your hero: Barbarian, Knight, Priest, or Mage.\n"
                + "Each has unique abilities that will shape your playstyle.\n\n\n"
                + "Once you start your adventure with the Travel button, you will explore the dark and mysterious lands of Lothric,\n"
                + "where danger lurks at every turn. Encounter powerful bosses, deadly enemies, and random events—\n"
                + "some will aid you, others will challenge you severely.\n\n\n"
                + "Throughout your journey, you will have access to:\n\n"
                + "5 healing potions for each stat, to be used wisely\n\n"
                + "1 special ability, capable of turning the tide of battle\n\n\n"
                + "Every journey will test your strategy, courage, and survival skills.\n"
                + "Will you defeat the bosses, overcome unexpected events, and save the bonfire flame,\n"
                + "the last hope of Lothric, Ashen One?";
    
    /**
     * Creates new form OpenGame
     */
    public OpenGame() {
        initComponents();
        
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.black);
        mainPanel.setLayout(new BorderLayout());
        
        
        JPanel imgPanel = new JPanel(new GridLayout(2, 2));

        JPanel pane1 = new JPanel() {
            Image sfondo = new ImageIcon("immagini/prima_immagine_mockup.jpg").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(sfondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        JPanel pane2 = new JPanel() {
            Image sfondo = new ImageIcon("immagini/seconda_immagine_mockup.jpg").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(sfondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        JPanel pane3 = new JPanel() {
            Image sfondo = new ImageIcon("immagini/terza_immagine_mockup.jpg").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(sfondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        JPanel pane4 = new JPanel() {
            Image sfondo = new ImageIcon("immagini/quarta_immagine_mockup.jpg").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(sfondo, 0, 0, getWidth(), getHeight(), this);
            }
        };

        imgPanel.add(pane1);
        imgPanel.add(pane2);
        imgPanel.add(pane3);
        imgPanel.add(pane4);
        
        
        
        // Panel in NORTH con titolo
        JPanel northPanel = new JPanel(new BorderLayout());
        JLabel label1 = new JLabel("Dark Souls 3");
        
        label1.setFont(new Font("Arial", Font.BOLD, 44));
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        northPanel.add(label1, BorderLayout.CENTER);
        northPanel.setPreferredSize(new Dimension(0, 180));    // altezza del nord
        mainPanel.add(northPanel, BorderLayout.NORTH);

        // Panel in WEST con bottone
        JPanel westPanel = new JPanel();
        
        westPanel.setLayout(new GridLayout(4,1,10,10));
        JButton button1 = new JButton("New Game");
        JButton button2 = new JButton("Load Game");
        JButton button3 = new JButton("Instruction");
        JButton button4 = new JButton("Exit");
        
        //implemento funzioni dei bottoni
        ActionListener newGame = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                ChoiseCharacter cC = new ChoiseCharacter();
                cC.setVisible(true);
            }
        }; //primo bottpne
        
        ActionListener istruction = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(OpenGame.this, instructions, "Instructions", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }; //terzo bottone
        ActionListener exit = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
            
        }; //quarto bottone
        
        button1.addActionListener(newGame);
        
        button3.addActionListener(istruction);
        button4.addActionListener(exit);
        
        //aggiungo i bottoni
        westPanel.add(button1);
        westPanel.add(button2);
        westPanel.add(button3);
        westPanel.add(button4);
        
        westPanel.setPreferredSize(new Dimension(220, 0));//larghezza del panel
        mainPanel.add(westPanel, BorderLayout.WEST);
        
        JPanel southPanel = new JPanel();
        JPanel eastPanel = new JPanel();
        
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        mainPanel.add(eastPanel, BorderLayout.EAST);
        mainPanel.add(imgPanel, BorderLayout.CENTER);
        
        northPanel.setOpaque(false);
        westPanel.setOpaque(false);
        southPanel.setOpaque(false);
        eastPanel.setOpaque(false);
        // aggiungi il mainPanel al frame
        this.add(mainPanel);
        this.setSize(1000, 500);
        
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
        java.awt.EventQueue.invokeLater(() -> new OpenGame().setVisible(true));
        
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
