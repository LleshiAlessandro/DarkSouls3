/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package darksouls3;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author lleshi.alessandro
 */
public class FormGameScreen extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormGameScreen.class.getName());
    
    GameManager g;
    Player p;
    String namePlayer;
    /**
     * Creates new form GameScreen
     */
    /**
     * 
     * @param imgPath serve perché se non gli passo il percorso dell immagine non posso sapere quale immagine prendere per questo form 
     * @param c serve perché se non passo il character io non so le sue statistiche
     */
    public FormGameScreen(String imgPath, Character c) {
        initComponents();        
        namePlayer = JOptionPane.showInputDialog(
            null,                       // parent component (null = finestra centrale)
            "Inserisci il tuo nome:",
            "Nome Player",
            JOptionPane.QUESTION_MESSAGE
        );
        if (namePlayer == null || namePlayer.trim().isEmpty()) {
            namePlayer = "Player"; // nome di default se l'utente non inserisce nulla
        }
        
        p = new Player(namePlayer);
        g = new GameManager(c, p);
        
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel northPanel = new JPanel();
        JLabel title = new JLabel("Dark Souls 3");

        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        northPanel.add(title, BorderLayout.CENTER);
        northPanel.setPreferredSize(new Dimension(0, 140));    // altezza del nord
        
        JPanel westPanel = new JPanel(new GridLayout(2,1,10,10));
        JPanel imgCharacter = new JPanel() {
            Image sfondo = new ImageIcon(imgPath).getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(sfondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        JPanel characterSpec = new JPanel(new GridLayout(5,1,10,10));
        JLabel life = new JLabel("life: " + String.valueOf(g.c.getLife()));
        JLabel mana = new JLabel("mana: " + String.valueOf(g.c.mana));
        JLabel stamina = new JLabel("stamina: " + String.valueOf(g.c.stamina));
        JLabel att = new JLabel("base attac: " + String.valueOf(g.c.baseAtt));
        JLabel name = new JLabel("name: " + g.c.name);
        characterSpec.add(name);
        characterSpec.add(life);
        characterSpec.add(mana);
        characterSpec.add(stamina);
        characterSpec.add(att);
        westPanel.setPreferredSize(new Dimension(200, 650));
        westPanel.add(imgCharacter);
        westPanel.add(characterSpec);
        westPanel.setBorder(new EmptyBorder(20,20,20,20));
        
        
        
        JPanel eastPanel = new JPanel(new BorderLayout());
        eastPanel.setPreferredSize(new Dimension(350,100));
        
        JLabel titleEvent = new JLabel("exploits of your trip");
        JTextArea eventArea = new JTextArea();
        eventArea.setEditable(false);
        
        eastPanel.add(titleEvent, BorderLayout.NORTH);
        eastPanel.add(eventArea, BorderLayout.CENTER);
        eastPanel.setBorder(new EmptyBorder(10,10,10,10));
        
        JPanel southPanel = new JPanel(new BorderLayout());
        JButton travel = new JButton("TRAVEL");
        JButton exit = new JButton("EXIT");
        travel.setPreferredSize(new Dimension(50,50));
        southPanel.add(travel, BorderLayout.CENTER);
        southPanel.add(exit, BorderLayout.EAST);
        southPanel.setBorder(new EmptyBorder(0,500,0,500));
        
        //implemento funzioni dei bottoni
        ActionListener actionTravel = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                g.eventManaging();
                eventArea.append(g.eventM.toString());
                if(g.inFight == true){
                    travel.setEnabled(false);
                    exit.setEnabled(false);
                    FormFightScreen fF = new FormFightScreen(FormGameScreen.this);
                    fF.setVisible(true);
                }
                
            }
        };
        ActionListener actionExit = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        };
        travel.addActionListener(actionTravel);
        exit.addActionListener(actionExit);
        
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        mainPanel.add(eastPanel, BorderLayout.EAST);
        mainPanel.add(westPanel, BorderLayout.WEST);
        mainPanel.add(northPanel, BorderLayout.NORTH);
        this.add(mainPanel);
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
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
        //immagini/priest.png immagine di default
        java.awt.EventQueue.invokeLater(() -> new FormGameScreen("immagini/priest.png", null).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
