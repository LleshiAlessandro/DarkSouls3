/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package darksouls3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author aless
 */
public class FormFightScreen extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormFightScreen.class.getName());
    private String keyWord = "";
    private String[] bossPaths = {"boss/Iudex_Gundyr.jpg", "boss/vordt.jpeg", "boss/Dancer_of_the_Boreal_Valley.jpg", "boss/Abyss_Watchers.jpg", "boss/Sulyvahn.jpg", "boss/yhorm.jpg", "boss/aldrich.jpg", "boss/lorian_lothric.jpg", "boss/soul-of-cinder.jpg", "boss/friede.jpg", "boss/namless_king.jpg", "boss/demon_prince.png", "boss/midir.jpg", "boss/gael.jpg"};
    private String bossPath;
    private boolean used = false;
    private int value;
    private boolean soulOfCinderDefeated = false;
    private boolean soul_of_cinder = false;
    private JProgressBar lifeBar;
    private JProgressBar manaBar;
    private JProgressBar staminaBar;
//immagini/barbarian.png
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
        
        
        JPanel bossImg_and_StatsPanel = new JPanel(new BorderLayout());
        
        JPanel bossStatsPanel = new JPanel(new GridLayout(5,1));
        JLabel bossName = new JLabel("  Name: " + g.v.name);
        bossName.setForeground(Color.white);
        JLabel bossLife = new JLabel("  Life: " + g.v.getLife());
        bossLife.setForeground(Color.white);
        JLabel bossAtt = new JLabel("   Base Att: " + g.v.baseAtt);
        bossAtt.setForeground(Color.white);
        bossStatsPanel.add(bossName);
        bossStatsPanel.add(bossLife);
        bossStatsPanel.add(bossAtt);
        bossStatsPanel.setBackground(Color.black);
        
        JProgressBar bossLifeBar = new JProgressBar(0, g.v.getLife());
        bossLifeBar.setBorder(null);
        bossLifeBar.setBackground(Color.black);
        bossLifeBar.setForeground(Color.red);
        bossLifeBar.setStringPainted(true);
        bossLifeBar.setValue(g.v.life);
        bossImg_and_StatsPanel.add(bossLifeBar, BorderLayout.NORTH);
        
        
        //tutte le immagini dei boss
        if(g.v.getName().equals(EnumVillain.IUDEX_GUNDYR.getDisplayName())){
            bossPath = bossPaths[0];
        }
        else if(g.v.getName().equals(EnumVillain.VORDT_OF_THE_BOREAL_VALLEY.getDisplayName())){
            bossPath = bossPaths[1];
        }
        else if(g.v.getName().equals(EnumVillain.DANCER_OF_THE_BOREAL_VALLEY.getDisplayName())){
            bossPath = bossPaths[2];
        }
        else if(g.v.getName().equals(EnumVillain.ABYSS_WATCHERS.getDisplayName())){
            bossPath = bossPaths[3];
        }
        else if(g.v.getName().equals(EnumVillain.PONTIFF_SULYVAHN.getDisplayName())){
            bossPath = bossPaths[4];
        }
        else if(g.v.getName().equals(EnumVillain.YHORM_THE_GIANT.getDisplayName())){
            bossPath = bossPaths[5];
        }
        else if(g.v.getName().equals(EnumVillain.ALDRICH_DEVOURER_OF_GODS.getDisplayName())){
            bossPath = bossPaths[6];
        }
        else if(g.v.getName().equals(EnumVillain.LORRIC_AND_LORIAN.getDisplayName())){
            bossPath = bossPaths[7];
        }
        //non funziona
        else if(g.v.getName().equals(EnumVillain.SOUL_OF_CINDER.getDisplayName()) && g.fightM.bossesDefeated > 3){
            bossPath = bossPaths[8];
            soul_of_cinder = true;
        }
        else if(g.v.getName().equals(EnumVillain.SISTER_FRIEDE.getDisplayName())){
            bossPath = bossPaths[9];
        }
        else if(g.v.getName().equals(EnumVillain.NAMELESS_KING.getDisplayName())){
            bossPath = bossPaths[10];
        }
        else if(g.v.getName().equals(EnumVillain.DEMON_PRINCE.getDisplayName())){
            bossPath = bossPaths[11];
        }
        else if(g.v.getName().equals(EnumVillain.DARK_EATER_MIDIR.getDisplayName())){
            bossPath = bossPaths[12];
        }
        else if(g.v.getName().equals(EnumVillain.SLAVE_KNIGHT_GAEL.getDisplayName())){
            bossPath = bossPaths[13];
        }
        else{
            bossPath = bossPaths[1];//di default
        }
        JPanel bossImgPanel = new JPanel() {
            
            Image sfondo = new ImageIcon(bossPath).getImage();
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(sfondo, 0, 0, getWidth(), getHeight(), this);
            }
        };
        bossImgPanel.setPreferredSize(new Dimension(300,650));
        
        
        
        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Color.black);
        infoPanel.setPreferredSize(new Dimension(150,150));
        bossImg_and_StatsPanel.add(bossImgPanel, BorderLayout.CENTER);
        bossImgPanel.setBorder(new EmptyBorder(20,20,20,20));
        bossImg_and_StatsPanel.add(bossStatsPanel, BorderLayout.EAST);
        JLabel turn = new JLabel("turn: " + String.valueOf(g.fightM.getTurni()));
        JLabel numEstus = new JLabel("number of estus: " + String.valueOf(g.c.inv.numberEstus));
        JLabel numAshenEstus = new JLabel("number of ashen estus: " + String.valueOf(g.c.inv.numberAshenEstus));
        JLabel numGreenBlossom = new JLabel("number of GreenBlossom: " + String.valueOf(g.c.inv.greenBlossom));
        
        turn.setForeground(Color.green);
        numEstus.setForeground(Color.white);
        numAshenEstus.setForeground(Color.white);
        numGreenBlossom.setForeground(Color.white);
        
        infoPanel.add(turn);
        infoPanel.add(numEstus);
        infoPanel.add(numAshenEstus);
        infoPanel.add(numGreenBlossom);
        infoPanel.setPreferredSize(new Dimension(200,200));
        bossImg_and_StatsPanel.add(infoPanel, BorderLayout.WEST);//mi serve per ridimensionare l'immagine non serve ad altro
        mainPanel.add(bossImg_and_StatsPanel);

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

        
        //character stats
        JPanel characterStatsPanel = new JPanel(new GridLayout(7,1));
        JLabel nameCharacter = new JLabel("  Name: " + g.c.name);
        nameCharacter.setForeground(Color.white);
        JLabel lifeCharacter = new JLabel("  Life: " + g.c.getLife());
        lifeCharacter.setForeground(Color.white);
        
        
        lifeBar = new JProgressBar(0, 150); // crea una barra
        lifeBar.setValue(g.c.life); //valore iniziale
        lifeBar.setStringPainted(true); //mostra il numero % sulla barra
        lifeBar.setBorder(null);
        lifeBar.setBackground(Color.black);
        lifeBar.setForeground(Color.red);
        
        
        
        manaBar = new JProgressBar(0, 100); // crea una barra
        manaBar.setValue(g.c.mana); //valore iniziale
        manaBar.setStringPainted(true); //mostra il numero % sulla barra
        manaBar.setBorder(null);
        manaBar.setBackground(Color.black);
        manaBar.setForeground(Color.blue);
        
        
        
        staminaBar = new JProgressBar(0, 100); // crea una barra
        staminaBar.setValue(g.c.stamina); //valore iniziale
        staminaBar.setStringPainted(true); //mostra il numero % sulla barra
        staminaBar.setBorder(null);
        staminaBar.setBackground(Color.black);
        staminaBar.setForeground(Color.green);
        
        
        
        
        JLabel manaCharacter = new JLabel("  Mana: " + g.c.mana);
        manaCharacter.setForeground(Color.white);
        JLabel staminaCharacter = new JLabel("  Stamina: " + g.c.stamina);
        staminaCharacter.setForeground(Color.white);
        JLabel attCharacter = new JLabel("  Base Att: " + g.c.baseAtt);
        attCharacter.setForeground(Color.white);
        
        characterStatsPanel.add(nameCharacter);
        characterStatsPanel.add(attCharacter);
        characterStatsPanel.add(lifeBar);
        characterStatsPanel.add(lifeCharacter);
        characterStatsPanel.add(manaBar);
        characterStatsPanel.add(manaCharacter);
        characterStatsPanel.add(staminaBar);
        characterStatsPanel.add(staminaCharacter);
        
        
        
        
        characterImg_and_StatsPanel.setBackground(Color.black);
        characterStatsPanel.setBackground(Color.black);
        characterImgPanel.setBackground(Color.black);
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
        JButton specialAbility = new JButton("Special Ab.");
        JButton useConsumable = new JButton("Use Consumable");

        Dimension buttonSize = new Dimension(120,40);
        heal.setPreferredSize(buttonSize);
        attac.setPreferredSize(buttonSize);
        roll.setPreferredSize(buttonSize);
        specialAbility.setPreferredSize(buttonSize);
        useConsumable.setPreferredSize(buttonSize);
        
        
        buttonsPanel.add(heal);
        buttonsPanel.add(attac);
        buttonsPanel.add(roll);
        buttonsPanel.add(specialAbility);
        buttonsPanel.add(useConsumable);

        azioniCharacterPanel.add(buttonsPanel, BorderLayout.CENTER);
        
        ActionListener actionHeal = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(g.c.inv.numberEstus <= 0){
                    heal.setEnabled(false);
                }
                keyWord = "heal";
                g.fight(keyWord);
                lifeBar.setValue(g.c.getLife());
                manaBar.setValue(g.c.getMana());
                staminaBar.setValue(g.c.getStamina());

                lifeBar.repaint();
                manaBar.repaint();
                staminaBar.repaint();
                if(g.c.getLife()>0 && g.v.getLife()>0){
                    if(g.fightM.getTurni() %2 != 0){
                        specialAbility.setEnabled(true);
                        turn.setForeground(Color.green);
                        g.c.useEstus();
                        g.c.useAshenEstus();
                        g.c.useGreenblossom();
                        numEstus.setText("  number of estus: " + String.valueOf(g.c.inv.getNumberEstus()));
                        numAshenEstus.setText("  number of ashen estus: " + String.valueOf(g.c.inv.getNumberAshenEstus()));
                        numGreenBlossom.setText("  number of green blossom: " + String.valueOf(g.c.inv.getGreenBlossom()));
                        lifeBar.setValue(g.c.getLife());
                        manaBar.setValue(g.c.getMana());
                        staminaBar.setValue(g.c.getStamina());
                        
                        lifeBar.repaint();
                        manaBar.repaint();
                        staminaBar.repaint();
                        
                    }
                    lifeCharacter.setText(String.valueOf("  Life: " + g.c.getLife()));
                    manaCharacter.setText(String.valueOf("  Mana: " + g.c.getMana()));
                    staminaCharacter.setText(String.valueOf("  Stamina: " + g.c.getStamina()));
                    if(g.fightM.getTurni() %2 == 0){
                        specialAbility.setEnabled(false);
                        turn.setForeground(Color.red);
                    }
                    
                }
                turn.setText("  turn: " + String.valueOf(g.fightM.getTurni()));
                
                
                if(g.getResult() == 0){
                JOptionPane.showMessageDialog(FormFightScreen.this,
                    "Both you and your opponent have fallen… The fire fades.",
                    "DARK SOULS 3",
                    JOptionPane.INFORMATION_MESSAGE);
                fG.travel.setEnabled(false);
                fG.exit.setEnabled(true);
                fG.att.setText("base attac: " + String.valueOf(g.c.getBaseAtt()));
                fG.numEstus.setText("  number of estus: " + String.valueOf(g.c.inv.getNumberEstus()));
                fG.numAshenEstus.setText("  number of ashen estus: " + String.valueOf(g.c.inv.getNumberAshenEstus()));
                fG.numGreenBlossom.setText("  number of green blossom: " + String.valueOf(g.c.inv.getGreenBlossom()));
                FormFightScreen.this.dispose();
                }
                else if (g.getResult() == 1) {
                    JOptionPane.showMessageDialog(FormFightScreen.this,
                        "You have met your end… Ashes to ashes, ember to darkness.",
                        "DARK SOULS 3",
                        JOptionPane.INFORMATION_MESSAGE);
                    fG.travel.setEnabled(false);
                    fG.exit.setEnabled(true);
                    fG.att.setText("base attac: " + String.valueOf(g.c.getBaseAtt()));
                    fG.eventArea.setText("");
                    fG.eventArea.append("YOU DIED");
                    fG.eventArea.setForeground(Color.red);
                    fG.numEstus.setText("  number of estus: " + String.valueOf(g.c.inv.getNumberEstus()));
                    fG.numAshenEstus.setText("  number of ashen estus: " + String.valueOf(g.c.inv.getNumberAshenEstus()));
                    fG.numGreenBlossom.setText("  number of green blossom: " + String.valueOf(g.c.inv.getGreenBlossom()));
                    FormFightScreen.this.dispose();
                }
                else if (g.getResult() == 2) {
                    
                    JOptionPane.showMessageDialog(FormFightScreen.this,
                        "The foe crumbles to dust… Victory is yours, but the journey continues.",
                        "DARK SOULS 3",
                        JOptionPane.INFORMATION_MESSAGE);
                    fG.travel.setEnabled(true);
                    fG.exit.setEnabled(true);
                    fG.att.setText("base attac: " + String.valueOf(g.c.getBaseAtt()));
                    fG.numEstus.setText("  number of estus: " + String.valueOf(g.c.inv.getNumberEstus()));
                    fG.numAshenEstus.setText("  number of ashen estus: " + String.valueOf(g.c.inv.getNumberAshenEstus()));
                    fG.numGreenBlossom.setText("  number of green blossom: " + String.valueOf(g.c.inv.getGreenBlossom()));
                    FormFightScreen.this.dispose();
                    
                }
            }
        };
        ActionListener actionAttac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keyWord = "attack";
                g.fight(keyWord);
                lifeCharacter.setText(String.valueOf("  Life:" + g.c.getLife()));
                bossLife.setText(String.valueOf("  Life: " + g.v.getLife()));
                lifeBar.setValue(lifeBar.getValue() - g.v.getBaseAtt());
                lifeBar.setValue(g.c.getLife());
                lifeBar.repaint();
                bossLifeBar.setValue(bossLifeBar.getValue() - g.c.getBaseAtt());
                bossLifeBar.setValue(g.v.getLife());
                bossLifeBar.repaint();

                if(g.c.getLife()>0 && g.v.getLife()>0){
                    if(g.fightM.getTurni() %2 == 0){
                        specialAbility.setEnabled(false);
                        turn.setForeground(Color.red);
                        lifeBar.setValue(lifeBar.getValue() - g.v.getBaseAtt());
                        lifeCharacter.setText(String.valueOf("  Life:" + g.c.getLife()));
                        lifeBar.setValue(g.c.getLife());
                        lifeBar.repaint();
                        
                    }
                    else{
                        specialAbility.setEnabled(true);
                        turn.setForeground(Color.green);
                        bossLifeBar.setValue(bossLifeBar.getValue() - g.c.getBaseAtt());
                        bossLife.setText(String.valueOf("  Life:" + g.v.getLife()));
                        bossLifeBar.setValue(g.v.getLife());
                        bossLifeBar.repaint();
                        
                    }
                }
                turn.setText("  turn: " + String.valueOf(g.fightM.getTurni()));
                numEstus.setText("  number of estus: " + String.valueOf(g.c.inv.getNumberEstus()));
                numAshenEstus.setText("  number of ashen estus: " + String.valueOf(g.c.inv.getNumberAshenEstus()));
                numGreenBlossom.setText("  number of green blossom: " + String.valueOf(g.c.inv.getGreenBlossom()));
                if(g.getResult() == 0){
                JOptionPane.showMessageDialog(FormFightScreen.this,
                    "Both you and your opponent have fallen… The fire fades.",
                    "DARK SOULS 3",
                    JOptionPane.INFORMATION_MESSAGE);
                    fG.travel.setEnabled(false);
                    fG.exit.setEnabled(true);
                    fG.att.setText("base attac: " + String.valueOf(g.c.getBaseAtt()));
                    fG.numEstus.setText("  number of estus: " + String.valueOf(g.c.inv.getNumberEstus()));
                    fG.numAshenEstus.setText("  number of ashen estus: " + String.valueOf(g.c.inv.getNumberAshenEstus()));
                    fG.numGreenBlossom.setText("  number of green blossom: " + String.valueOf(g.c.inv.getGreenBlossom()));
                    FormFightScreen.this.dispose();
                }
                else if (g.getResult() == 1) {
                    JOptionPane.showMessageDialog(FormFightScreen.this,
                        "You have met your end… Ashes to ashes, ember to darkness.",
                        "DARK SOULS 3",
                        JOptionPane.INFORMATION_MESSAGE);
                    fG.travel.setEnabled(false);
                    fG.exit.setEnabled(true);
                    fG.att.setText("base attac: " + String.valueOf(g.c.getBaseAtt()));
                    fG.eventArea.setText("");
                    fG.eventArea.append("YOU DIED");
                    fG.eventArea.setForeground(Color.red);
                    fG.numEstus.setText("  number of estus: " + String.valueOf(g.c.inv.getNumberEstus()));
                    fG.numAshenEstus.setText("  number of ashen estus: " + String.valueOf(g.c.inv.getNumberAshenEstus()));
                    fG.numGreenBlossom.setText("  number of green blossom: " + String.valueOf(g.c.inv.getGreenBlossom()));
                    FormFightScreen.this.dispose();
                }
                else if (g.getResult() == 2) {
                    JOptionPane.showMessageDialog(FormFightScreen.this,
                        "The foe crumbles to dust… Victory is yours, but the journey continues.",
                        "DARK SOULS 3",
                        JOptionPane.INFORMATION_MESSAGE);
                    fG.travel.setEnabled(true);
                    fG.exit.setEnabled(true);
                    fG.att.setText("base attac: " + String.valueOf(g.c.getBaseAtt()));
                    fG.numEstus.setText("  number of estus: " + String.valueOf(g.c.inv.getNumberEstus()));
                    fG.numAshenEstus.setText("  number of ashen estus: " + String.valueOf(g.c.inv.getNumberAshenEstus()));
                    fG.numGreenBlossom.setText("  number of green blossom: " + String.valueOf(g.c.inv.getGreenBlossom()));
                    //non funziona
                    //System.out.println("Boss name: [" + g.v.getName() + "]");
                    //System.out.println("Expected: [" + EnumVillain.SOUL_OF_CINDER.getDisplayName() + "]");
                    if(g.getResult() == 2){
                        if(g.v.getName().equals(EnumVillain.SOUL_OF_CINDER.getDisplayName()) && g.fightM.bossesDefeated > 3){
                            FormFightScreen.this.dispose();
                            FormChoiseEnding cE = new FormChoiseEnding(g);
                            fG.dispose();
                            cE.setVisible(true);
                            return;
                        }
                        // altri boss normali
                        FormFightScreen.this.dispose();
                    }
                }
            }
        };
        ActionListener actionRoll = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keyWord = "roll";
                g.fight(keyWord);
                lifeCharacter.setText(String.valueOf("  Life:" + g.c.getLife()));
                staminaCharacter.setText(String.valueOf("  Stamina:" + g.c.getStamina()));
                if(g.c.getLife()>0 && g.v.getLife()> 0){
                    if(g.fightM.getTurni() %2 == 0){
                        specialAbility.setEnabled(false);
                        turn.setForeground(Color.red);
                    }
                    else{
                        specialAbility.setEnabled(true);
                        turn.setForeground(Color.green);
                    }
                }
                lifeBar.setValue(g.c.getLife());
                staminaBar.setValue(g.c.getStamina());

                lifeBar.repaint();
                staminaBar.repaint();
                turn.setText("  Turn: " + String.valueOf(g.fightM.getTurni()));
                numEstus.setText("  number of estus: " + String.valueOf(g.c.inv.getNumberEstus()));
                numAshenEstus.setText("  number of ashen estus: " + String.valueOf(g.c.inv.getNumberAshenEstus()));
                numGreenBlossom.setText("  number of green blossom: " + String.valueOf(g.c.inv.getGreenBlossom()));
                if(g.getResult() == 0){
                JOptionPane.showMessageDialog(FormFightScreen.this,
                    "Both you and your opponent have fallen… The fire fades.",
                    "DARK SOULS 3",
                    JOptionPane.INFORMATION_MESSAGE);
                    fG.travel.setEnabled(false);
                    fG.exit.setEnabled(true);
                    fG.att.setText("base attac: " + String.valueOf(g.c.getBaseAtt()));
                    fG.numEstus.setText("  number of estus: " + String.valueOf(g.c.inv.getNumberEstus()));
                    fG.numAshenEstus.setText("  number of ashen estus: " + String.valueOf(g.c.inv.getNumberAshenEstus()));
                    fG.numGreenBlossom.setText("  number of green blossom: " + String.valueOf(g.c.inv.getGreenBlossom()));
                    FormFightScreen.this.dispose();
                }
                else if (g.getResult() == 1) {
                    JOptionPane.showMessageDialog(FormFightScreen.this,
                        "You have met your end… Ashes to ashes, ember to darkness.",
                        "DARK SOULS 3",
                        JOptionPane.INFORMATION_MESSAGE);
                    fG.travel.setEnabled(false);
                    fG.exit.setEnabled(true);
                    fG.att.setText("base attac: " + String.valueOf(g.c.getBaseAtt()));
                    fG.att.setText("base attac: " + String.valueOf(g.c.getBaseAtt()));
                    fG.eventArea.setText("");
                    fG.eventArea.append("YOU DIED");
                    fG.eventArea.setForeground(Color.red);
                    fG.numEstus.setText("  number of estus: " + String.valueOf(g.c.inv.getNumberEstus()));
                    fG.numAshenEstus.setText("  number of ashen estus: " + String.valueOf(g.c.inv.getNumberAshenEstus()));
                    fG.numGreenBlossom.setText("  number of green blossom: " + String.valueOf(g.c.inv.getGreenBlossom()));
                    FormFightScreen.this.dispose();
                }
                else if (g.getResult() == 2) {
                    JOptionPane.showMessageDialog(FormFightScreen.this,
                        "The foe crumbles to dust… Victory is yours, but the journey continues.",
                        "DARK SOULS 3",
                        JOptionPane.INFORMATION_MESSAGE);
                    fG.travel.setEnabled(true);
                    fG.exit.setEnabled(true);
                    fG.numEstus.setText("  number of estus: " + String.valueOf(g.c.inv.getNumberEstus()));
                    fG.numAshenEstus.setText("  number of ashen estus: " + String.valueOf(g.c.inv.getNumberAshenEstus()));
                    fG.numGreenBlossom.setText("  number of green blossom: " + String.valueOf(g.c.inv.getGreenBlossom()));
                    FormFightScreen.this.dispose();
                }
            }
        };
        ActionListener actionAbility = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                keyWord = "special ability";
                g.fight(keyWord);
                lifeCharacter.setText(String.valueOf("  Life:" + g.c.getLife()));
                manaCharacter.setText(String.valueOf("  Mana:" + g.c.getMana()));
                staminaCharacter.setText(String.valueOf("  Stamina:" + g.c.getStamina()));
                bossLife.setText(String.valueOf("  Life:" + g.v.getLife()));
                lifeBar.setValue(g.c.getLife());
                lifeBar.repaint();
                manaBar.setValue(g.c.getMana());
                manaBar.repaint();
                staminaBar.setValue(g.c.getStamina());
                staminaBar.repaint();
                if(g.c.getLife()>0 && g.v.getLife()> 0){
                    if(g.fightM.getTurni() %2 == 0){
                        specialAbility.setEnabled(false);
                        turn.setForeground(Color.red);
                        lifeBar.setValue(lifeBar.getValue() - g.v.getBaseAtt());
                        lifeCharacter.setText(String.valueOf("  Life:" + g.c.getLife()));
                        manaCharacter.setText(String.valueOf("  Mana:" + g.c.getMana()));
                        staminaCharacter.setText(String.valueOf("  Stamina:" + g.c.getStamina()));
                        lifeBar.setValue(g.c.getLife());
                        lifeBar.repaint();
                        manaBar.setValue(g.c.getMana());
                        manaBar.repaint();
                        staminaBar.setValue(g.c.getStamina());
                        staminaBar.repaint();
                    }
                    else{
                        specialAbility.setEnabled(true);
                        turn.setForeground(Color.green);
                        bossLife.setText(String.valueOf("  Life:" + g.v.getLife()));
                        manaCharacter.setText(String.valueOf("  Mana:" + g.c.getMana()));
                        staminaCharacter.setText(String.valueOf("  Stamina:" + g.c.getStamina()));
                        bossLifeBar.setValue(g.v.getLife());
                        bossLifeBar.repaint();
                        lifeBar.setValue(g.c.getLife());
                        lifeBar.repaint();
                        manaBar.setValue(g.c.getMana());
                        manaBar.repaint();
                        staminaBar.setValue(g.c.getStamina());
                        staminaBar.repaint();
                    }
                }
                
                turn.setText("  Turn: " + String.valueOf(g.fightM.getTurni()));
                used = true;
                if(used == true){
                    specialAbility.setEnabled(false);
                    numEstus.setText("number of estus: " + String.valueOf(g.c.inv.getNumberEstus()));
                    numAshenEstus.setText("number of ashen estus: " + String.valueOf(g.c.inv.getNumberAshenEstus()));
                    numGreenBlossom.setText("number of green blossom: " + String.valueOf(g.c.inv.getGreenBlossom()));
                }
                if(g.getResult() == 0){
                JOptionPane.showMessageDialog(FormFightScreen.this,
                    "Both you and your opponent have fallen… The fire fades.",
                    "DARK SOULS 3",
                    JOptionPane.INFORMATION_MESSAGE);
                    fG.travel.setEnabled(false);
                    fG.exit.setEnabled(true);
                    fG.att.setText("base attac: " + String.valueOf(g.c.getBaseAtt()));
                    fG.numEstus.setText("  number of estus: " + String.valueOf(g.c.inv.getNumberEstus()));
                    fG.numAshenEstus.setText("  number of ashen estus: " + String.valueOf(g.c.inv.getNumberAshenEstus()));
                    fG.numGreenBlossom.setText("  number of green blossom: " + String.valueOf(g.c.inv.getGreenBlossom()));
                    FormFightScreen.this.dispose();
                }
                else if (g.getResult() == 1) {
                    JOptionPane.showMessageDialog(FormFightScreen.this,
                        "You have met your end… Ashes to ashes, ember to darkness.",
                        "DARK SOULS 3",
                        JOptionPane.INFORMATION_MESSAGE);
                    fG.travel.setEnabled(false);
                    fG.exit.setEnabled(true);
                    fG.att.setText("base attac: " + String.valueOf(g.c.getBaseAtt()));
                    
                    fG.eventArea.setText("");
                    fG.eventArea.append("YOU DIED");
                    fG.eventArea.setForeground(Color.red);
                    fG.numEstus.setText("  number of estus: " + String.valueOf(g.c.inv.getNumberEstus()));
                    fG.numAshenEstus.setText("  number of ashen estus: " + String.valueOf(g.c.inv.getNumberAshenEstus()));
                    fG.numGreenBlossom.setText("  number of green blossom: " + String.valueOf(g.c.inv.getGreenBlossom()));
                    FormFightScreen.this.dispose();
                }
                else if (g.getResult() == 2) {
                    JOptionPane.showMessageDialog(FormFightScreen.this,
                        "The foe crumbles to dust… Victory is yours, but the journey continues.",
                        "DARK SOULS 3",
                        JOptionPane.INFORMATION_MESSAGE);
                    fG.travel.setEnabled(true);
                    fG.exit.setEnabled(true);
                    fG.att.setText("base attac: " + String.valueOf(g.c.getBaseAtt()));
                    fG.numEstus.setText("  number of estus: " + String.valueOf(g.c.inv.getNumberEstus()));
                    fG.numAshenEstus.setText("  number of ashen estus: " + String.valueOf(g.c.inv.getNumberAshenEstus()));
                    fG.numGreenBlossom.setText("  number of green blossom: " + String.valueOf(g.c.inv.getGreenBlossom()));
                    //System.out.println("Boss name: [" + g.v.getName() + "]");
                    //System.out.println("Expected: [" + EnumVillain.SOUL_OF_CINDER.getDisplayName() + "]");
                    if(g.v.getName().equals(EnumVillain.SOUL_OF_CINDER.getDisplayName()) && g.fightM.bossesDefeated > 3){
                            FormFightScreen.this.dispose();
                            FormChoiseEnding cE = new FormChoiseEnding(g);
                            fG.dispose();
                            cE.setVisible(true);
                            return;
                        }
                        FormFightScreen.this.dispose();
                }
            }
        };
        ActionListener actionConsumable = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(g.c.inv.items.isEmpty() != true){
                   for (Item item : g.c.inv.items) {
                        if (item.getName() == EnumItem.DIVINE_BLESSING) {
                            g.c.setLife(g.c.getLife() + 20);
                            g.c.inv.items.remove(item);
                        } else if (item.getName() == EnumItem.EMBER) {
                            g.c.setLife(100);
                            g.c.inv.items.remove(item);
                        } else if (item.getName() == EnumItem.SIEGBRAU) {
                            g.c.setLife(g.c.getLife() + 10);
                            g.c.inv.items.remove(item);
                        }
                    }
                    
                    lifeCharacter.setText(String.valueOf("  Life:" + g.c.getLife()));
                    manaCharacter.setText(String.valueOf("  Mana:" + g.c.getMana()));
                    staminaCharacter.setText(String.valueOf("  Stamina:" + g.c.getStamina()));
                }
                else{
                    JOptionPane.showMessageDialog(FormFightScreen.this, "INVENTORY EMPTY", "Inventory", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        };    
        
        
        heal.addActionListener(actionHeal);
        attac.addActionListener(actionAttac);
        roll.addActionListener(actionRoll);
        specialAbility.addActionListener(actionAbility);
        useConsumable.addActionListener(actionConsumable);
        
        
        
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setVisible(true);
        /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    }
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
