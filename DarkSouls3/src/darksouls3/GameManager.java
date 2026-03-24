/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;



/**
 *
 * @author aless
 */
public class GameManager {
    protected Character c;
    protected Villain v ;
    protected Map m;
    private Player p;
    private FileManager fileM = new FileManager();
    protected EventManager eventM = new EventManager();
    protected FightManager fightM = new FightManager();
    private EndingManager endingM = new EndingManager();
    private EnumVillain[] bosses = EnumVillain.values();;
    private Random rnd = new Random();
    protected ArrayList <NPC> npcsMet = new ArrayList();
    protected boolean inFight = false;//mi serve per disabilitare i bottoni e per poter giocare solo al fight
    protected int result = -1;
    private int bossRand;
    //costruttore
    public GameManager(Character c,Player p) {
        this.c = c;
        this.p = p;
    }

    
    
    
    //NEW BOSS
    public void newBoss(){
        //creo 2 liste 1 dei non apparsi e 1 degli apparsi, e gestisco le duplicità così
        ArrayList<EnumVillain> bossesNotAppeared = new ArrayList(Arrays.asList(bosses));//pieno all'inizio
        ArrayList<EnumVillain> bossesAppeared = new ArrayList();//vuoto all'inizio
        
        bossRand = rnd.nextInt(bossesNotAppeared.size());//prendo una posizione a caso di boss non apparso
        //non controlla quello randomico, ma va in fila
        for(EnumVillain e : bossesNotAppeared){
            
            if(bossesAppeared.contains(e)){
                e.setAppeared(true);
                bossRand = rnd.nextInt(bossesNotAppeared.size());
            }
            if(e.isAppeared() == true){
                bossesAppeared.add(e);
                bossesNotAppeared.remove(e);
            }
            else{
                e.setAppeared(true);
            }
            
        }
        this.v = new Villain(bossesNotAppeared.get(bossRand));
        inFight = true;
    }
    //ITEM FOUND
    public void itemFound(Item i){
        c.inv.addItem(i);
    }
    //NEW NPC
    public void newNPC(){
        //mi fa incontrare un npc randomico
        rnd = new Random();
        NPC_Name randomNpc = NPC_Name.values()[rnd.nextInt(NPC_Name.values().length)];
        npcsMet.add(new NPC(randomNpc));
    }
    //RESTORE HEALS
    public void restoreHeals(Character c){
        c.inv.numberAshenEstus = 3;
        c.inv.numberEstus = 3;
        c.inv.greenBlossom = 3;
    }
    //NEW LOCATION
    public void newLocation(){
        Map[] maps = Map.values();
        int currentIndex = -1;
        for (int i = 0; i < maps.length; i++){
            if (maps[i] == m){
                currentIndex = i;
                break;
            }
        }
        int rand = rnd.nextInt(maps.length - 1); // genera un numero tra 0 e maps.length-2
        if (rand >= currentIndex){
            rand++;
        }
        m = maps[rand];
    }
    
    
    
    
    
    
    public void eventManaging(){
        Event e = eventM.eventRandom();
        switch (e) {
            case ITEM_FOUND ->{
                Item i = new Item();//devo capire che nome dare all'item
                this.itemFound(i);
                if(i.getDamage() >= c.getBaseAtt()){
                    c.setBaseAtt(i.getDamage());
                }
            }
            case RESTORE_HEALS -> c.restoreHeals();
            case NEW_NPC -> {
                
                this.newNPC();
            }
            case NEW_LOCATION -> this.newLocation();
            case NEW_BOSS -> {
                fightM.turni = 1;
                this.newBoss();
                //lo passo al form quando sono in combattimento this.fight(keyWord);
            }
            default -> System.out.println("errore");
        }
    }
    
    //gli passo la keyWord perché così fancendo quando andrò a cliccare il pulsante attacca la keyWord diventerà
    //attacca e di conseguenza adrò a togliere vita al boss
    public void fight(String keyWord){
        fightM.fightManaged(c, v, keyWord);
        result = fightM.fightResult(c, v);
    }
    
    //gestione ending
    public void ending(){
        endingM.ending(npcsMet);
    }
    //da implementare il load e il save

    public int getResult() {
        return result;
    }

    public boolean isInFight() {
        return inFight;
    }
    
    
    @Override
    public String toString(){
        return eventM.toString();
    }
}