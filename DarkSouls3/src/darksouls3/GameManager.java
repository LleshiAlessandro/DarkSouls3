/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import javax.sound.sampled.*;

/**
 *
 * @author aless
 */
public class GameManager {

    protected Character c;
    protected Villain v;
    protected Map m;
    private Player p;
    protected FileManager fileM = new FileManager();
    protected EventManager eventM = new EventManager();
    protected FightManager fightM = new FightManager();
    private EndingManager endingM = new EndingManager();
    private EnumVillain[] bosses = EnumVillain.values();
    ;
    private Random rnd = new Random();
    protected ArrayList<NPC> npcsMet = new ArrayList();
    protected boolean inFight = false;//mi serve per disabilitare i bottoni e per poter giocare solo al fight
    protected int result = -1;
    private int bossRand;
    //creo 2 liste 1 dei non apparsi e 1 degli apparsi, e gestisco le duplicità così
    private ArrayList<EnumVillain> bossesNotAppeared = new ArrayList<>(Arrays.asList(EnumVillain.values()));
    private ArrayList<EnumVillain> bossesAppeared = new ArrayList<>();
    private Clip bossClip;
    private Clip endClip;

    //costruttore
    public GameManager(Character c, Player p) {
        this.c = c;
        this.p = p;
    }

    //NEW BOSS
    public void newBoss() {
        if (bossesNotAppeared.isEmpty()) {
            //System.out.println("Tutti i boss sono già stati affrontati!");
            return;
        }
        // scegli un boss casuale dalla lista dei non apparsi
        bossRand = rnd.nextInt(bossesNotAppeared.size());
        EnumVillain x = bossesNotAppeared.get(bossRand);//boss uscito random da quelli non sconfitti

        if (x.isAppeared() != true) {
            x.setAppeared(true);
            bossesAppeared.add(x);
            bossesNotAppeared.remove(x);
        }
        this.v = new Villain(x);
        inFight = true;
    }

    //ITEM FOUND
    public void itemFound(Item i) {
        c.inv.addItem(i);
    }

    //NEW NPC
    public void newNPC() {
        //mi fa incontrare un npc randomico
        rnd = new Random();
        NPC_Name randomNpc = NPC_Name.values()[rnd.nextInt(NPC_Name.values().length)];
        npcsMet.add(new NPC(randomNpc));
    }

    //RESTORE HEALS
    public void restoreHeals(Character c) {
        c.inv.numberAshenEstus = 3;
        c.inv.numberEstus = 3;
        c.inv.greenBlossom = 3;
    }

    //NEW LOCATION
    public void newLocation() {
        Map[] maps = Map.values();
        int currentIndex = -1;
        for (int i = 0; i < maps.length; i++) {
            if (maps[i] == m) {
                currentIndex = i;
                break;
            }
        }
        int rand = rnd.nextInt(maps.length - 1); // genera un numero tra 0 e maps.length-2
        if (rand >= currentIndex) {
            rand++;
        }
        m = maps[rand];
    }

    public void eventManaging() {
        Event e = eventM.eventRandom();
        switch (e) {
            case ITEM_FOUND -> {
                Item i = new Item();//devo capire che nome dare all'item
                this.itemFound(i);
                if (i.getDamage() >= c.getBaseAtt()) {
                    c.setBaseAtt(i.getDamage());
                }
            }
            case RESTORE_HEALS ->
                c.restoreHeals();
            case NEW_NPC -> {

                this.newNPC();
            }
            case NEW_LOCATION ->
                this.newLocation();
            case NEW_BOSS -> {
                fightM.turni = 1;
                this.newBoss();
                //lo passo al form quando sono in combattimento this.fight(keyWord);
            }
            default ->
                System.out.println("errore");
        }
    }

    //gli passo la keyWord perché così fancendo quando andrò a cliccare il pulsante attacca la keyWord diventerà
    //attacca e di conseguenza adrò a togliere vita al boss
    public void fight(String keyWord) {
        fightM.fightManaged(c, v, keyWord);
        result = fightM.fightResult(c, v);
    }

    //gestione ending
    public void ending() {
        endingM.ending(npcsMet);
    }
    //da implementare il load e il save

    public int getResult() {
        return result;
    }

    public boolean isInFight() {
        return inFight;
    }

    public void bossfightSound() {
        try {
            File soundFile = new File("song/boss_fight_soundTrack.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);

            bossClip = AudioSystem.getClip();
            bossClip.open(audioStream);

            FloatControl volume = (FloatControl) bossClip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(-18.0f);

            bossClip.loop(Clip.LOOP_CONTINUOUSLY);
            bossClip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void stopBossSound() {
        if (bossClip != null && bossClip.isRunning()) {
            bossClip.stop();
            bossClip.close();
        }
    }

    public void endSound() {
        try {
            File soundFile = new File("song/song_finale.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);

            endClip = AudioSystem.getClip();
            endClip.open(audioStream);

            FloatControl volume = (FloatControl) endClip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(-18.0f);

            endClip.loop(Clip.LOOP_CONTINUOUSLY);
            endClip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void stopEndSound() {
        if (endClip != null && endClip.isRunning()) {
            endClip.stop();
            endClip.close();
        }
    }

    
    
    @Override
    public String toString() {
        return eventM.toString();
    }
}
