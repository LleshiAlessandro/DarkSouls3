/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package darksouls3;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author lleshi.alessandro
 */
public class FormGameScreen extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormGameScreen.class.getName());
    
    GameManager g;
    FormFightScreen fF;
    protected JButton travel;
    protected JButton exit;
    protected JLabel att;
    protected JTextArea eventArea;
    protected JLabel numEstus ;
    protected JLabel numAshenEstus ;
    protected JLabel numGreenBlossom ;
    private ArrayList <String> item = new ArrayList();
    protected ArrayList <String> npcName = new ArrayList();
    private String mapPath;
    private Image sfondoAgg;
    /**
     * Creates new form GameScreen
     */
    /**
     * 
     * @param imgPath serve perché se non gli passo il percorso dell immagine non posso sapere quale immagine prendere per questo form 
     * @param c serve perché se non passo il character io non so le sue statistiche
     * @param p serve perché il gestore di gioco richiede un player e io a me serve nel FormChoiseCharacter e nel form FormOpenGame
     */
    public FormGameScreen(String imgPath, Character c, Player p) {
        initComponents();        
        
        
        g = new GameManager(c, p);
        
        
        JPanel mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if(sfondoAgg != null){
                    g.drawImage(sfondoAgg, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        mainPanel.setBackground(Color.black);
        JPanel northPanel = new JPanel(new BorderLayout());
        JLabel title = new JLabel("Dark Souls 3");
        northPanel.setBackground(Color.black);
        
        JPanel numberHeals = new JPanel(new GridLayout(3,1,10,10));
        
        numEstus = new JLabel("  number of estus: " + String.valueOf(g.c.inv.getNumberEstus()));
        numAshenEstus = new JLabel("  number of ashen estus: " + String.valueOf(g.c.inv.getNumberAshenEstus()));
        numGreenBlossom = new JLabel("  number of green blossom: " + String.valueOf(g.c.inv.getGreenBlossom()));
        numEstus.setForeground(Color.white);
        numAshenEstus.setForeground(Color.white);
        numGreenBlossom.setForeground(Color.white);
        
        numberHeals.add(numEstus);
        numberHeals.add(numAshenEstus);
        numberHeals.add(numGreenBlossom);
        numberHeals.setBackground(Color.black);
        
        northPanel.add(numberHeals, BorderLayout.WEST);
        
        title.setFont(new Font("Arial", Font.BOLD, 40));
        title.setForeground(Color.white);
        
        title.setHorizontalAlignment(SwingConstants.CENTER);
        northPanel.add(title, BorderLayout.CENTER);
        northPanel.setPreferredSize(new Dimension(0, 140));    // altezza del nord
        
        JPanel westPanel = new JPanel(new GridLayout(2,1,10,10));
        westPanel.setBackground(Color.black);
        JPanel imgCharacter = new JPanel(new BorderLayout()) {
            Image sfondo = new ImageIcon(imgPath).getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(sfondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        imgCharacter.setBackground(Color.black);
        JPanel characterSpec = new JPanel(new GridLayout(5,1,10,10));
        characterSpec.setBackground(Color.black);
        JLabel life = new JLabel("life: " + String.valueOf(g.c.getLife()));
        life.setForeground(Color.white);
        JLabel mana = new JLabel("mana: " + String.valueOf(g.c.mana));
        mana.setForeground(Color.white);
        JLabel stamina = new JLabel("stamina: " + String.valueOf(g.c.stamina));
        stamina.setForeground(Color.white);
        att = new JLabel("base attack: " + String.valueOf(g.c.getBaseAtt()));
        att.setForeground(Color.white);
        JLabel name = new JLabel("name: " + g.c.name);
        name.setForeground(Color.white);
        characterSpec.add(name);
        characterSpec.add(life);
        characterSpec.add(mana);
        characterSpec.add(stamina);
        characterSpec.add(att);
        
        JPanel eastButtonPanel = new JPanel(new GridLayout(7,1,10,10));
        eastButtonPanel.setBackground(Color.black);
        JButton specialAb = new JButton("info special ability");
        ActionListener actionAbility = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(FormGameScreen.this, g.c.toString(), "Inventory", JOptionPane.INFORMATION_MESSAGE);
            }
        };
        specialAb.addActionListener(actionAbility);
        
        
        JButton inv = new JButton("inventory");
        ActionListener actionInv = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Item i : g.c.inv.getItems()){
                    item.add(i.toString() + ", ") ;
                    
                    //da sistemare, perché trovata un arma non mi cambia subito la label
                    if(i.getDamage() > 0 && g.c.getBaseAtt() < i.getDamage()){
                        att.setText("base attac: " + String.valueOf(i.getDamage()));
                    }
                }
                JOptionPane.showMessageDialog(FormGameScreen.this, item, "Inventory", JOptionPane.INFORMATION_MESSAGE);
            }
        };
        inv.addActionListener(actionInv);
        
        
        JButton npcs = new JButton("Familiar Faces");
        ActionListener actionNpc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(g.npcsMet.isEmpty()) {
                    JOptionPane.showMessageDialog(FormGameScreen.this,
                        "You haven't met any NPCs yet.",
                        "Familiar Faces",
                        JOptionPane.INFORMATION_MESSAGE);
                }
                else {
                    String names = "";
                    for(NPC n : g.npcsMet) {
                        names += n.toString() + "\n";
                    }
                    JOptionPane.showMessageDialog(FormGameScreen.this,
                        names,
                        "Familiar Faces",
                        JOptionPane.INFORMATION_MESSAGE);
                }
            }
        };
        npcs.addActionListener(actionNpc);
        
        JButton saveCsv = new JButton("save CSV");
        JButton loadCsv = new JButton("load CSV");
        JButton save = new JButton("save");
        JButton load = new JButton("load");
        imgCharacter.setPreferredSize(new Dimension(175,550));
        westPanel.add(imgCharacter);
        westPanel.add(characterSpec);
        westPanel.setBorder(new EmptyBorder(20,20,20,20));
        
        
        eastButtonPanel.add(specialAb);
        eastButtonPanel.add(inv);
        eastButtonPanel.add(npcs);
        eastButtonPanel.add(saveCsv);
        eastButtonPanel.add(loadCsv);
        eastButtonPanel.add(save);
        eastButtonPanel.add(load);
        westPanel.add(eastButtonPanel, BorderLayout.EAST);
        
        
        JPanel eastPanel = new JPanel(new BorderLayout());

        
        
        eastPanel.setPreferredSize(new Dimension(250,100));
        
        JLabel titleEvent = new JLabel("exploits of your trip");
        titleEvent.setForeground(Color.white);
        eventArea = new JTextArea();
        eventArea.setForeground(Color.white);
        eventArea.setBackground(Color.black);
        eventArea.add(new JScrollPane());
        eventArea.setEditable(false);
        
        
        eastPanel.add(titleEvent, BorderLayout.NORTH);
        eastPanel.add(eventArea, BorderLayout.CENTER);
        eastPanel.setBorder(new EmptyBorder(10,10,10,10));
        eastPanel.setBackground(Color.black);
        JPanel southPanel = new JPanel(new BorderLayout());
        travel = new JButton("TRAVEL");
        
        exit = new JButton("EXIT");
        travel.setPreferredSize(new Dimension(50,50));
        southPanel.add(travel, BorderLayout.CENTER);
        southPanel.add(exit, BorderLayout.EAST);
        southPanel.setBorder(new EmptyBorder(0,500,0,500));
        southPanel.setBackground(Color.black);
        //implemento funzioni dei bottoni
        ActionListener actionTravel = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                g.eventManaging();
                eventArea.append(g.eventM.toString());
                if(g.inFight == true){
                    travel.setEnabled(false);
                    exit.setEnabled(false);
                    fF = new FormFightScreen(FormGameScreen.this, g, imgPath);
                    fF.setVisible(true);
                    g.inFight = false;
                }
                else{
                    travel.setEnabled(true);
                    exit.setEnabled(true);
                }
                if(g.eventM.getLastEvent().equals(Event.NEW_LOCATION)){
                    if(g.m.equals(Map.CEMETERY_OF_ASH)){
                        mapPath = "immagini/satuarioDelVincolo.jpg";
                        sfondoAgg = new ImageIcon(mapPath).getImage(); // aggiorni immagine
                        mainPanel.repaint();
                    }
                    else if(g.m.equals(Map.FIRELINK_SHRINE)){
                        mapPath = "immagini/fire_link.jpg";
                        sfondoAgg = new ImageIcon(mapPath).getImage(); // aggiorni immagine
                        mainPanel.repaint();
                    }
                    else if(g.m.equals(Map.FIRELINK_SHRINE_ALT)){
                        mapPath = "immagini/fire.jpg";
                        sfondoAgg = new ImageIcon(mapPath).getImage(); // aggiorni immagine
                        mainPanel.repaint();
                    }
                    else if(g.m.equals(Map.LOTHRIC_CASTLE_INTERIOR)){
                        mapPath = "immagini/dentroMura.jpg";
                        sfondoAgg = new ImageIcon(mapPath).getImage(); // aggiorni immagine
                        mainPanel.repaint();
                    }
                    else if(g.m.equals(Map.HIGH_WALL_OF_LOTHRIC)){
                        mapPath = "immagini/muraAlte.jpg";
                        sfondoAgg = new ImageIcon(mapPath).getImage(); // aggiorni immagine
                        mainPanel.repaint();
                    }
                    else if(g.m.equals(Map.MOCKUP_THIRD_AREA)){
                        mapPath = "immagini/terza_immagine_mockup.jpg";
                        sfondoAgg = new ImageIcon(mapPath).getImage(); // aggiorni immagine
                        mainPanel.repaint();
                    }
                    else if(g.m.equals(Map.MOCKUP_SECOND_AREA)){
                        mapPath = "immagini/seconda_immagine_mockup.jpg";
                        sfondoAgg = new ImageIcon(mapPath).getImage(); // aggiorni immagine
                        mainPanel.repaint();
                    }
                    else if(g.m.equals(Map.ANOR_LONDO)){
                        mapPath = "immagini/anorLondo.jpg";
                        sfondoAgg = new ImageIcon(mapPath).getImage(); // aggiorni immagine
                        mainPanel.repaint();
                    }
                    else if(g.m.equals(Map.MOCKUP_FIRST_AREA)){
                        mapPath = "immagini/prima_immagine_mockup.jpg";
                        sfondoAgg = new ImageIcon(mapPath).getImage(); // aggiorni immagine
                        mainPanel.repaint();
                    }
                    else if(g.m.equals(Map.ARCHDRAGON_PEAK)){
                        mapPath = "immagini/vettDeiDraghi.jpg";
                        sfondoAgg = new ImageIcon(mapPath).getImage(); // aggiorni immagine
                        mainPanel.repaint();
                    }
                    else if(g.m.equals(Map.PAINTED_WORLD_OF_ARIANDEL)){
                        mapPath = "immagini/ariandel.jpg";
                        sfondoAgg = new ImageIcon(mapPath).getImage(); // aggiorni immagine
                        mainPanel.repaint();
                    }
                    else if(g.m.equals(Map.MOCKUP_FOURTH_AREA)){
                        mapPath = "immagini/quarta_immagine_mockup.jpg";
                        sfondoAgg = new ImageIcon(mapPath).getImage(); // aggiorni immagine
                        mainPanel.repaint();
                    }
                    else if(g.m.equals(Map.THE_RINGED_CITY)){
                        mapPath = "immagini/ringedCity.jpg";
                        sfondoAgg = new ImageIcon(mapPath).getImage(); // aggiorni immagine
                        mainPanel.repaint();
                    }
                    else{
                        mapPath =  "immagini/satuarioDelVincolo.jpg";
                        sfondoAgg = new ImageIcon(mapPath).getImage(); // aggiorni immagine
                        mainPanel.repaint();
                        }
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
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
