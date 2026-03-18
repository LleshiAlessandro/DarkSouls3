/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

import java.util.Random;



/**
 *
 * @author aless
 */
public class GameManager {
    protected Character c;
    protected Villain v ;
    private Map m;
    private Player p;
    private FileManager fileM = new FileManager();
    private EventManager eventM = new EventManager();
    private FightManager fightM = new FightManager();
    private EndingManager endingM = new EndingManager();
    private NPC n = new NPC();
    private Random rnd = new Random();
    private int npcRandom;
    private NPC_Name[] npcName = n.getNPC_Name();

    //costruttore
    public GameManager(Character c,Player p) {
        this.c = c;
        this.p = p;
    }

    
    
    
    //NEW BOSS
    public void newBoss(){
        EnumVillain[] bosses = EnumVillain.values();
        this.v = new Villain(bosses[rnd.nextInt(bosses.length)]);
    }
    //ITEM FOUND
    public void itemFound(Item i){
        c.inv.addItem(i);
    }
    //NEW NPC
    public NPC_Name newNPC(NPC n){
        //mi fa incontrare un npc randomico
        npcRandom = rnd.nextInt();
        return npcName[npcRandom];
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
        //dopo aver chiamato l'evento randomico, devo fare tutte le if di controllo, ma prima devo capire
        //se gli attributi che ho inserito vanno bene e devo capire come impostare le if
        switch (e) {
            case ITEM_FOUND ->{
                Item i = new Item("ciao");
                this.itemFound(i);}
            case RESTORE_HEALS -> c.restoreHeals();
            case NEW_NPC -> {
                
                this.newNPC(n);
            }
            case NEW_LOCATION -> this.newLocation();
            case NEW_BOSS -> {
                this.newBoss();
                //lo passo al form quando sono in combattimento this.fight(keyWord);
            }
            default -> System.out.println("errore");
        }
    }
    
    //gli passo la keyWord perché così fancendo quando andrò a cliccare il pulsante attacca la keyWord diventerà
    //attacca e di conseguenza adrò a togliere vita al boss
    public void fight(String keyWord){
        fightM.chooseTurn(c, v, keyWord);
        fightM.fightManaged(c, v, keyWord);
    }
    
    //gestione ending
    public void ending(){
        endingM.ending();
    }
    //da implementare il load e il save
}