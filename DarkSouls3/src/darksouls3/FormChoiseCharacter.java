/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package darksouls3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;


/**
 *
 * @author lleshi.alessandro
 */
public class FormChoiseCharacter extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormChoiseCharacter.class.getName());
    private String nameCharacter;
    protected Character c;
    protected String imgPath;
    String hystoriPg1 =  "In the dying lands of Lothric, where ash falls like silent snow,\n" +
    "a legend is whispered among the fading fires.\n" +
    "\n" +
    "It speaks of a barbarian born far from crowns and kingdoms,\n" +
    "raised beneath merciless winds and frozen skies.\n" +
    "\n" +
    "His body was that of a titan, scarred by countless battles,\n" +
    "each mark a memory of blood and survival.\n" +
    "In his hands he carried a massive axe,\n" +
    "heavy enough to break shields, bone, and destiny alike.\n" +
    "\n" +
    "He walked through the cursed streets of the Undead Settlement,\n" +
    "where hollow souls wander without hope.\n" +
    "He crossed the poisoned swamps of Farron Keep,\n" +
    "where even the strongest warriors lose their will to fight.\n" +
    "\n" +
    "And when he reached the cold moonlit city of Irithyll,\n" +
    "the shadows themselves trembled before his wrath.\n" +
    "\n" +
    "He fought not for glory.\n" +
    "He fought not for a throne.\n" +
    "\n" +
    "He fought because defying the darkness\n" +
    "was written into his very soul.\n" +
    "\n" +
    "And so, beneath fading flames and endless grey skies,\n" +
    "his name began to spread among the last survivors.\n" +
    "\n" +
    "A warrior born from ash.\n" +
    "A barbarian destined to challenge even the gods.";
    
    String knightLore =
    "In the fading kingdom of Lothric, where the fire grows weak\n" +
    "and the bells of fate echo through broken towers,\n" +
    "there marches a lone knight.\n" +
    "\n" +
    "Clad in steel scarred by countless battles,\n" +
    "he was once sworn to defend the ancient throne.\n" +
    "His armor bears the marks of war,\n" +
    "each dent a memory of loyalty and sacrifice.\n" +
    "\n" +
    "Through the ruined gates of Lothric Castle he walks,\n" +
    "shield raised against the darkness of a dying world.\n" +
    "\n" +
    "He crossed the silent bridges of Irithyll,\n" +
    "where moonlight reflects upon frozen stone\n" +
    "and ancient knights lie forgotten.\n" +
    "\n" +
    "Though the kingdoms have fallen\n" +
    "and the lords have abandoned their thrones,\n" +
    "his oath remains unbroken.\n" +
    "\n" +
    "For a knight does not fight for glory.\n" +
    "A knight fights for honor.\n" +
    "\n" +
    "And even in a world swallowed by ash,\n" +
    "his blade will never fall.";
    
    
    String mageLore =
    "Beyond the crumbling halls of the Grand Archives,\n" +
    "where forbidden knowledge sleeps among ancient tomes,\n" +
    "there walks a sorcerer of terrible wisdom.\n" +
    "\n" +
    "His path was not forged by steel,\n" +
    "but by the silent study of lost spells\n" +
    "and the whispers of fading magic.\n" +
    "\n" +
    "Within his hands burns the cold light of sorcery,\n" +
    "a power drawn from the very soul of the world.\n" +
    "\n" +
    "He wandered through the cursed lands of Lothric,\n" +
    "seeking secrets buried beneath centuries of ash.\n" +
    "The dead rose against him,\n" +
    "yet arcane fire answered their hollow rage.\n" +
    "\n" +
    "In Irithyll's pale moonlight,\n" +
    "his spells illuminated the darkness\n" +
    "like stars in a dying sky.\n" +
    "\n" +
    "For while swords may shatter\n" +
    "and kingdoms may fall,\n" +
    "knowledge endures.\n" +
    "\n" +
    "And in the hands of a true mage,\n" +
    "knowledge becomes power.";
    
    
    
    String priestLore =
    "In the shadow of the Cathedral of the Deep,\n" +
    "where fading prayers echo through hollow halls,\n" +
    "there walks a humble priest.\n" +
    "\n" +
    "Clad not in armor, but in faith,\n" +
    "he carries only a sacred talisman\n" +
    "and the light of ancient miracles.\n" +
    "\n" +
    "The world around him is dying.\n" +
    "Ash falls upon broken kingdoms\n" +
    "and hope grows ever dim.\n" +
    "\n" +
    "Yet still he travels through Lothric,\n" +
    "healing the wounded\n" +
    "and guiding lost souls through the darkness.\n" +
    "\n" +
    "When the undead rise\n" +
    "and despair threatens to consume the land,\n" +
    "his prayers become radiant power.\n" +
    "\n" +
    "For miracles are not born from strength,\n" +
    "nor from knowledge.\n" +
    "\n" +
    "They are born from faith.\n" +
    "\n" +
    "And as long as even a single prayer remains,\n" +
    "the light of the gods shall never truly fade.";
    /**
     * Creates new form ChoiseCharacter
     */
    public FormChoiseCharacter(Player p) {
        initComponents();
        JButton start = new JButton("START ADVENTURE");
        
        nameCharacter = JOptionPane.showInputDialog(
            null,                       // parent component (null = finestra centrale)
            "Inserisci il nome del tuo personaggio:", // messaggio
            "Nome Personaggio",         // titolo finestra
            JOptionPane.QUESTION_MESSAGE
        );

        if (nameCharacter == null || nameCharacter.trim().isEmpty()) {
            nameCharacter = "Adventurer"; // nome di default se l'utente non inserisce nulla
        }
        
        
        JPanel mainPanel = new JPanel(new BorderLayout()){
            Image sfondo = new ImageIcon("immagini/sfondo_scelta_pg_giusto.jpg").getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(sfondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        JPanel northPanel = new JPanel();
        JLabel title = new JLabel("CHOOSE YOUR ADVENTURER");
        title.setForeground(Color.white);
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        northPanel.add(title, BorderLayout.CENTER);
        northPanel.setPreferredSize(new Dimension(0, 140));    // altezza del nord

        //panel che conterrà 4 panel su una riga, che a loro volta conterranno l'icon del pg
        
        JPanel characterPanel = new JPanel(new BorderLayout());
        JPanel characterNamePanel = new JPanel(new GridLayout(1,4));
        JLabel barbarianLabel = new JLabel("barbarian");
        barbarianLabel.setForeground(Color.white);
        JLabel knightLabel = new JLabel("knight");
        knightLabel.setForeground(Color.white);
        JLabel mageLabel = new JLabel("mage");
        mageLabel.setForeground(Color.white);
        JLabel priestLabel = new JLabel("priest");
        priestLabel.setForeground(Color.white);
        
        characterNamePanel.add(barbarianLabel);
        characterNamePanel.add(knightLabel);
        characterNamePanel.add(mageLabel);
        characterNamePanel.add(priestLabel);
        
        
        
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
        MouseAdapter m1 = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                c = new Barbarian(20, 90, nameCharacter, 125, 25);
                imgPath = "immagini/barbarian.png";
                start.setEnabled(true);
            }
        };
        imagePanel1.addMouseListener(m1);
        //implemento funzioni dei bottoni
        ActionListener historyBarbarian = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(FormChoiseCharacter.this, hystoriPg1, "BARBARIAN HISTORY", JOptionPane.INFORMATION_MESSAGE);
            }
        };
        history.addActionListener(historyBarbarian);
        
        pg1.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        //aggiunge un bordo luminoso quando passo sopra all'pamnel dell'immagine 1
        Border originalBorder1 = pg1.getBorder();//salva il bordo originale
        MouseAdapter glowAdapter1 = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                pg1.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2, true));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                pg1.setBorder(originalBorder1);
            }
        };
        // aggiungi al panel principale
        pg1.addMouseListener(glowAdapter1);
        // aggiungi anche a tutti i componenti interni
        for (Component c : pg1.getComponents()) {
            c.addMouseListener(glowAdapter1);
        }
        
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
        MouseAdapter m2 = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //System.out.println("YOU HAVE CLICKED THE KNIGHT");
                c = new Knight(50, 75, nameCharacter, 115, 22);
                imgPath = "immagini/knight.png";
                start.setEnabled(true);
            }
        };
        imagePanel2.addMouseListener(m2);
        ActionListener historyKnight = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(FormChoiseCharacter.this, knightLore, "KNIGHT HISTORY", JOptionPane.INFORMATION_MESSAGE);
            }
        };
        history2.addActionListener(historyKnight);
        //aggiunge un bordo luminoso quando passo sopra all'pamnel dell'immagine 1
        Border originalBorder2 = pg2.getBorder();//salva il bordo originale
        MouseAdapter glowAdapter2 = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                pg2.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2, true));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                pg2.setBorder(originalBorder2);
            }
        };
        // aggiungi al panel principale
        pg2.addMouseListener(glowAdapter2);
        // aggiungi anche a tutti i componenti interni
        for (Component c : pg2.getComponents()) {
            c.addMouseListener(glowAdapter2);
        }

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
        MouseAdapter m3 = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //System.out.println("YOU HAVE CLICKED THE MAGE");
                c = new Mage(90, 25, nameCharacter, 95, 28);
                imgPath = "immagini/mage.png";
                start.setEnabled(true);
            }
        };
        imagePanel3.addMouseListener(m3);
        ActionListener historyMage = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(FormChoiseCharacter.this, mageLore, "MAGE HISTORY", JOptionPane.INFORMATION_MESSAGE);
            }
        };
        history3.addActionListener(historyMage);
        //aggiunge un bordo luminoso quando passo sopra all'pamnel dell'immagine 1
        Border originalBorder3 = pg3.getBorder();//salva il bordo originale
        MouseAdapter glowAdapter3 = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                pg3.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2, true));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                pg3.setBorder(originalBorder3);
            }
        };
        // aggiungi al panel principale
        pg3.addMouseListener(glowAdapter3);
        // aggiungi anche a tutti i componenti interni
        for (Component c : pg3.getComponents()) {
            c.addMouseListener(glowAdapter3);
        }

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
        MouseAdapter m4 = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //System.out.println("YOU HAVE CLICKED THE PRIEST");
                c = new Priest(60, 60, nameCharacter, 100, 20);
                imgPath = "immagini/priest.png";
                start.setEnabled(true);
            }
        };
        imagePanel4.addMouseListener(m4);
        ActionListener historyPriest = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(FormChoiseCharacter.this, priestLore, "MAGE HISTORY", JOptionPane.INFORMATION_MESSAGE);
            }
        };
        history4.addActionListener(historyPriest);
        
        //aggiunge un bordo luminoso quando passo sopra all'pamnel dell'immagine 1
        Border originalBorder4 = pg4.getBorder();//salva il bordo originale
        MouseAdapter glowAdapter4 = new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                pg4.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2, true));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                pg4.setBorder(originalBorder4);
            }
        };
        // aggiungi al panel principale
        pg4.addMouseListener(glowAdapter4);
        // aggiungi anche a tutti i componenti interni
        for (Component c : pg4.getComponents()) {
            c.addMouseListener(glowAdapter4);
        }
        
        
        
        
        
        
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
        characterPanel.add(characterNamePanel, BorderLayout.NORTH);
        characterPanel.add(centerPanel, BorderLayout.CENTER);
        
        
        
        
        JPanel southPanel = new JPanel();
        
        northPanel.setOpaque(false);
        southPanel.setOpaque(false);
        
        northPanel.add(title);
        
        start.setEnabled(false);
        start.setMaximumSize(new Dimension(200, 50));
        southPanel.add(start);
        
        //quando clicco avvia avventura chiude il form e apre la schermata di gioco
        ActionListener startAdventure = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                FormGameScreen gS = new FormGameScreen(imgPath, c, p);
                gS.setVisible(true);
            }
        }; 
        characterPanel.setOpaque(false);
        characterNamePanel.setOpaque(false);
        start.addActionListener(startAdventure);
        mainPanel.add(northPanel, BorderLayout.NORTH);
        mainPanel.add(characterPanel, BorderLayout.CENTER);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        
        //così il giocatore può scegliere una sola volta il personaggio
        if(c != null){
            imagePanel1.removeMouseListener(m1);
            imagePanel2.removeMouseListener(m2);
            imagePanel3.removeMouseListener(m3);
            imagePanel4.removeMouseListener(m4);
        }
        
        this.add(mainPanel);
        this.setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH);
        
        
        
        //prendere in input il nome dell avventuriero per poi stamparlo a schermo
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
        java.awt.EventQueue.invokeLater(() -> new FormChoiseCharacter(null).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
