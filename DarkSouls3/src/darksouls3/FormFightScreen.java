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
    private String imgPathAzione = "";
    private JPanel imgsCharacterActions;
    private Image sfondoAzione;
    private String currentCharacterPath;
//immagini/barbarian.png

    /**
     * Creates new form FIghtScreen
     *
     * @param fG mi serve perché almeno il form non viene chiuso e il form
     * corrente sa da chi è stato aperto
     * @param g il form che ha aperto il form corrente usa il suo stesso gestore
     * @param imgPath ho bisogno di sapere l'immagine del character scelto
     * precedentemente
     */
    public FormFightScreen(FormGameScreen fG, GameManager g, String imgPath) {
        initComponents();
        g.bossfightSound();
        this.currentCharacterPath = imgPath;

        JPanel mainPanel = new JPanel(new GridLayout(2, 1)); // divide lo schermo in due righe
        this.add(mainPanel);

        JPanel bossImg_and_StatsPanel = new JPanel(new BorderLayout());

        JPanel bossStatsPanel = new JPanel(new GridLayout(5, 1));
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
        if (g.v.getName().equals(EnumVillain.IUDEX_GUNDYR.getDisplayName())) {
            bossPath = bossPaths[0];
        } else if (g.v.getName().equals(EnumVillain.VORDT_OF_THE_BOREAL_VALLEY.getDisplayName())) {
            bossPath = bossPaths[1];
        } else if (g.v.getName().equals(EnumVillain.DANCER_OF_THE_BOREAL_VALLEY.getDisplayName())) {
            bossPath = bossPaths[2];
        } else if (g.v.getName().equals(EnumVillain.ABYSS_WATCHERS.getDisplayName())) {
            bossPath = bossPaths[3];
        } else if (g.v.getName().equals(EnumVillain.PONTIFF_SULYVAHN.getDisplayName())) {
            bossPath = bossPaths[4];
        } else if (g.v.getName().equals(EnumVillain.YHORM_THE_GIANT.getDisplayName())) {
            bossPath = bossPaths[5];
        } else if (g.v.getName().equals(EnumVillain.ALDRICH_DEVOURER_OF_GODS.getDisplayName())) {
            bossPath = bossPaths[6];
        } else if (g.v.getName().equals(EnumVillain.LORRIC_AND_LORIAN.getDisplayName())) {
            bossPath = bossPaths[7];
        } //non funziona
        else if (g.v.getName().equals(EnumVillain.SOUL_OF_CINDER.getDisplayName()) && g.fightM.bossesDefeated > 3) {
            bossPath = bossPaths[8];
            soul_of_cinder = true;
        } else if (g.v.getName().equals(EnumVillain.SISTER_FRIEDE.getDisplayName())) {
            bossPath = bossPaths[9];
        } else if (g.v.getName().equals(EnumVillain.NAMELESS_KING.getDisplayName())) {
            bossPath = bossPaths[10];
        } else if (g.v.getName().equals(EnumVillain.DEMON_PRINCE.getDisplayName())) {
            bossPath = bossPaths[11];
        } else if (g.v.getName().equals(EnumVillain.DARK_EATER_MIDIR.getDisplayName())) {
            bossPath = bossPaths[12];
        } else if (g.v.getName().equals(EnumVillain.SLAVE_KNIGHT_GAEL.getDisplayName())) {
            bossPath = bossPaths[13];
        } else {
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
        bossImgPanel.setPreferredSize(new Dimension(300, 650));

        JPanel infoPanel = new JPanel();
        infoPanel.setBackground(Color.black);
        infoPanel.setPreferredSize(new Dimension(150, 150));
        bossImg_and_StatsPanel.add(bossImgPanel, BorderLayout.CENTER);
        bossImgPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
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
        infoPanel.setPreferredSize(new Dimension(200, 200));
        bossImg_and_StatsPanel.add(infoPanel, BorderLayout.WEST);//mi serve per ridimensionare l'immagine non serve ad altro
        mainPanel.add(bossImg_and_StatsPanel);

        JPanel characterPanel = new JPanel(new BorderLayout());
        characterPanel.setBackground(Color.black);
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
        characterImgPanel.setPreferredSize(new Dimension(300, 650));
        characterImg_and_StatsPanel.add(characterImgPanel, BorderLayout.WEST);

        //character img Actions
        JPanel centralPanel = new JPanel(new GridLayout(1, 2, 0, 0));
        JPanel leftCentralPanel = new JPanel();
        leftCentralPanel.setBackground(Color.black);
        centralPanel.add(leftCentralPanel);
        imgsCharacterActions = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (sfondoAzione != null) {
                    g.drawImage(sfondoAzione, 0, 0, getWidth(), getHeight(), this);
                }
            }
        };
        imgsCharacterActions.setBackground(Color.black);
        imgsCharacterActions.setPreferredSize(new Dimension(200, 500));
        imgsCharacterActions.setMinimumSize(new Dimension(200, 500));
        imgsCharacterActions.setMaximumSize(new Dimension(200, 500));
        centralPanel.add(imgsCharacterActions);
        characterImg_and_StatsPanel.add(centralPanel, BorderLayout.CENTER);

        //character stats
        JPanel characterStatsPanel = new JPanel(new GridLayout(7, 1));
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
        manaBar.setForeground(Color.cyan);

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
        characterImg_and_StatsPanel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel azioniCharacterPanel = new JPanel(new BorderLayout());
        azioniCharacterPanel.setPreferredSize(new Dimension(600, 50));
        azioniCharacterPanel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 50));
        azioniCharacterPanel.setBackground(Color.DARK_GRAY);
        characterPanel.add(azioniCharacterPanel, BorderLayout.SOUTH);

        JPanel buttonsPanel = new JPanel(new GridLayout(1, 6, 10, 0));

        JButton heal = new JButton("Heal");
        JButton attac = new JButton("Attack");
        JButton roll = new JButton("Roll");
        JButton specialAbility = new JButton("Special Ab.");
        JButton useShield = new JButton("Use Shield");
        JButton useConsumable = new JButton("Use Consumable");

        Dimension buttonSize = new Dimension(120, 40);
        heal.setPreferredSize(buttonSize);
        attac.setPreferredSize(buttonSize);
        roll.setPreferredSize(buttonSize);
        specialAbility.setPreferredSize(buttonSize);
        useShield.setPreferredSize(buttonSize);
        useConsumable.setPreferredSize(buttonSize);

        buttonsPanel.add(heal);
        buttonsPanel.add(attac);
        buttonsPanel.add(roll);
        buttonsPanel.add(specialAbility);
        buttonsPanel.add(useShield);
        buttonsPanel.add(useConsumable);

        azioniCharacterPanel.add(buttonsPanel, BorderLayout.CENTER);

        // --- HEAL ---
        ActionListener actionHeal = e -> {
            if (g.c.inv.numberEstus <= 0) {
                heal.setEnabled(false);
            }
            keyWord = "heal";
            g.fight(keyWord);
            if (imgPath.equals("immagini/barbarian.png")) {
                imgPathAzione = "immagini/barbarian_healing.png";
            } else if (imgPath.equals("immagini/knight.png")) {
                imgPathAzione = "immagini/knight_healing.png";
            } else if (imgPath.equals("immagini/mage.png")) {
                imgPathAzione = "immagini/mage_healing.png";
            } else if (imgPath.equals("immagini/priest.png")) {
                imgPathAzione = "immagini/priest_healing.png";
            }
            changeActionImg();

            if (g.c.getLife() > 0 && g.v.getLife() > 0 && g.fightM.getTurni() % 2 != 0) {
                g.c.useEstus();
                g.c.useAshenEstus();
                g.c.useGreenblossom();
            }
            refreshStatusUI(g, turn, bossLife, lifeCharacter, manaCharacter, staminaCharacter, numEstus, numAshenEstus, numGreenBlossom, bossLifeBar, specialAbility);
            handleMatchResult(g, fG);
        };

// --- ATTACK ---
        ActionListener actionAttac = e -> {
            keyWord = "attack";
            g.fight(keyWord);
            if (imgPath.equals("immagini/barbarian.png")) {
                imgPathAzione = "immagini/barbarian_att.png";
            } else if (imgPath.equals("immagini/knight.png")) {
                imgPathAzione = "immagini/knight_att.png";
            } else if (imgPath.equals("immagini/mage.png")) {
                imgPathAzione = "immagini/mage_att.png";
            } else if (imgPath.equals("immagini/priest.png")) {
                imgPathAzione = "immagini/priest_att.png";
            }
            changeActionImg();

            if (g.c.getLife() > 0 && g.v.getLife() > 0) {
                if (g.fightM.getTurni() % 2 == 0) {
                    lifeBar.setValue(lifeBar.getValue() - g.v.getBaseAtt());
                } else {
                    bossLifeBar.setValue(bossLifeBar.getValue() - g.c.getBaseAtt());
                }
            }
            refreshStatusUI(g, turn, bossLife, lifeCharacter, manaCharacter, staminaCharacter, numEstus, numAshenEstus, numGreenBlossom, bossLifeBar, specialAbility);
            handleMatchResult(g, fG);
        };

// --- ROLL ---
        ActionListener actionRoll = e -> {
            keyWord = "roll";
            g.fight(keyWord);
            if (imgPath.equals("immagini/barbarian.png")) {
                imgPathAzione = "immagini/barbarian_roll.png";
            } else if (imgPath.equals("immagini/knight.png")) {
                imgPathAzione = "immagini/knight_roll.png";
            } else if (imgPath.equals("immagini/mage.png")) {
                imgPathAzione = "immagini/mage_roll.png";
            } else if (imgPath.equals("immagini/priest.png")) {
                imgPathAzione = "immagini/priest_roll.png";
            }
            changeActionImg();

            refreshStatusUI(g, turn, bossLife, lifeCharacter, manaCharacter, staminaCharacter, numEstus, numAshenEstus, numGreenBlossom, bossLifeBar, specialAbility);
            handleMatchResult(g, fG);
        };

// --- SPECIAL ABILITY ---
        ActionListener actionAbility = e -> {
            keyWord = "special ability";
            g.fight(keyWord);
            if (imgPath.equals("immagini/barbarian.png")) {
                imgPathAzione = "immagini/barbarian_sp.png";
            } else if (imgPath.equals("immagini/knight.png")) {
                imgPathAzione = "immagini/knight_sp.png";
            } else if (imgPath.equals("immagini/mage.png")) {
                imgPathAzione = "immagini/mage_sp.png";
            } else if (imgPath.equals("immagini/priest.png")) {
                imgPathAzione = "immagini/priest_sp.png";
            }
            changeActionImg();

            if (g.c.getLife() > 0 && g.v.getLife() > 0 && g.fightM.getTurni() % 2 == 0) {
                lifeBar.setValue(lifeBar.getValue() - g.v.getBaseAtt());
            }
            refreshStatusUI(g, turn, bossLife, lifeCharacter, manaCharacter, staminaCharacter, numEstus, numAshenEstus, numGreenBlossom, bossLifeBar, specialAbility);
            handleMatchResult(g, fG);
        };

// --- USE SHIELD ---
        ActionListener actionShield = e -> {
            keyWord = "use shield";
            g.fight(keyWord);
            // Supponendo che tu abbia le immagini scudo chiamate così:
            if (imgPath.equals("immagini/barbarian.png")) {
                imgPathAzione = "immagini/barbarian_shield.png";
            } else if (imgPath.equals("immagini/knight.png")) {
                imgPathAzione = "immagini/knight_shield.png";
            }
            changeActionImg();

            refreshStatusUI(g, turn, bossLife, lifeCharacter, manaCharacter, staminaCharacter, numEstus, numAshenEstus, numGreenBlossom, bossLifeBar, specialAbility);
            handleMatchResult(g, fG);
        };

// --- USE CONSUMABLE ---
        ActionListener actionConsumable = e -> {
            keyWord = "use consumable";
            g.fight(keyWord);
            if (imgPath.equals("immagini/barbarian.png")) {
                imgPathAzione = "immagini/barbarian_item.png";
            }
            changeActionImg();

            refreshStatusUI(g, turn, bossLife, lifeCharacter, manaCharacter, staminaCharacter, numEstus, numAshenEstus, numGreenBlossom, bossLifeBar, specialAbility);
            handleMatchResult(g, fG);
        };

        heal.addActionListener(actionHeal);

        attac.addActionListener(actionAttac);

        roll.addActionListener(actionRoll);

        specialAbility.addActionListener(actionAbility);

        useShield.addActionListener(actionShield);

        useConsumable.addActionListener(actionConsumable);

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.setVisible(
                true);

        /**
         * This method is called from within the constructor to initialize the
         * form. WARNING: Do NOT modify this code. The content of this method is
         * always regenerated by the Form Editor.
         */
    }

    //mi cambia l'immagine per ongi azione
    public void changeActionImg() {
        sfondoAzione = new ImageIcon(imgPathAzione).getImage();
        imgsCharacterActions.repaint(); // ridisegna il pannello
    }

    // METODO COMUNE 1: Aggiorna tutti i testi e i valori delle barre
    private void refreshStatusUI(GameManager g, JLabel turn, JLabel bossLife, JLabel lifeChar, JLabel manaChar, JLabel staminaChar, JLabel nEstus, JLabel nAshen, JLabel nGreen, JProgressBar bossBar, JButton specialBtn) {
        lifeBar.setValue(g.c.getLife());
        manaBar.setValue(g.c.getMana());
        staminaBar.setValue(g.c.getStamina());
        bossBar.setValue(g.v.getLife());

        lifeChar.setText("  Life: " + g.c.getLife());
        manaChar.setText("  Mana: " + g.c.getMana());
        staminaChar.setText("  Stamina: " + g.c.getStamina());
        bossLife.setText("  Life: " + g.v.getLife());
        turn.setText("  turn: " + g.fightM.getTurni());

        nEstus.setText("  number of estus: " + g.c.inv.getNumberEstus());
        nAshen.setText("  number of ashen estus: " + g.c.inv.getNumberAshenEstus());
        nGreen.setText("  number of green blossom: " + g.c.inv.getGreenBlossom());

        // Gestione colore turno e bottone special
        if (g.fightM.getTurni() % 2 == 0) {
            specialBtn.setEnabled(false);
            turn.setForeground(Color.red);
        } else {
            specialBtn.setEnabled(true);
            turn.setForeground(Color.green);
        }

        lifeBar.repaint();
        manaBar.repaint();
        staminaBar.repaint();
        bossBar.repaint();
    }

    private void handleMatchResult(GameManager g, FormGameScreen fG) {
        if (g.getResult() == -1) {
            return;
        }

        String msg = "";
        if (g.getResult() == 0) {
            msg = "Both you and your opponent have fallen… The fire fades.";
        } else if (g.getResult() == 1) {
            msg = "You have met your end… Ashes to ashes, ember to darkness.";
        } else if (g.getResult() == 2) {
            msg = "The foe crumbles to dust… Victory is yours, but the journey continues.";
        }

        JOptionPane.showMessageDialog(this, msg, "DARK SOULS 3", JOptionPane.INFORMATION_MESSAGE);

        // Aggiornamento Form Precedente
        fG.travel.setEnabled(g.getResult() == 2);
        fG.exit.setEnabled(true);
        fG.att.setText("base attac: " + g.c.getBaseAtt());
        fG.numEstus.setText("  number of estus: " + g.c.inv.getNumberEstus());
        fG.numAshenEstus.setText("  number of ashen estus: " + g.c.inv.getNumberAshenEstus());
        fG.numGreenBlossom.setText("  number of green blossom: " + g.c.inv.getGreenBlossom());

        if (g.getResult() == 1) {
            fG.eventArea.setText("YOU DIED");
            fG.eventArea.setForeground(Color.red);
        }

        // Caso speciale Soul of Cinder
        if (g.getResult() == 2 && g.v.getName().equals(EnumVillain.SOUL_OF_CINDER.getDisplayName()) && g.fightM.bossesDefeated > 3) {
            new FormChoiseEnding(g).setVisible(true);
            fG.dispose();
        }

        g.stopBossSound();
        this.dispose();
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
