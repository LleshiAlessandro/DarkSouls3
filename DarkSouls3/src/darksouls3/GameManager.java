/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;



/**
 *
 * @author aless
 */
public class GameManager {
    private Character c;    // = new PgStatsCommon("character", 100,25);
    private Villain v ;   //= new Villain("enemie", 100,33);
    private Map m;
    private Player p;
    private FileManager fileM;
    private EventManager eventM;
    private FightManager fightM;
    private EndingManager endingM;

    public GameManager(Character c, Villain v, Map m, Player p, FileManager fileM, EventManager eventM, FightManager fightM, EndingManager endingM) {
        this.c = c;
        this.v = v;
        this.m = m;
        this.p = p;
        this.fileM = fileM;
        this.eventM = eventM;
        this.fightM = fightM;
        this.endingM = endingM;
    }
    
    
    
    public void eventManaging(Item i, NPC n, String keyWord){
        eventM.eventRandom();
        //dopo aver chiamato l'evento randomico, devo fare tutte le if di controllo, ma prima devo capire
        //se gli attributi che ho inserito vanno bene e devo capire come impostare le if
        switch (eventM.eventRandom()) {
            case ITEM_FOUND -> this.itemFound(c, i);
            case RESTORE_HEALS -> this.restoreHeals(c);
            case NEW_NPC -> this.newNPC(n);
            case NEW_LOCATION -> this.newLocation();
            case NEW_BOSS -> {
                this.newBoss();
                this.fight(keyWord);
            }
            default -> System.out.println("errore");
        }
    }
    
    //gli passo la keyWord perché così fancendo quando andrò a cliccare il pulsante attacca la keyWord diventerà
    //attacca e di conseguenza adrò a togliere vita al boss
    public void fight(String keyWord){
        fightM.chooseTurn(c, v);
        fightM.fightManaged(c, v, keyWord);
    }
    
    
    //NEW BOSS
    public boolean newBoss(){
        return true;
    }
    //ITEM FOUND
    public void itemFound(Character c, Item i){
        c.inv.addItem(i);
    }
    //NEW LOCATION
    public boolean newLocation(){
        return true;
    }
    //NEW NPC
    public NPC newNPC(NPC n){
        return n;
    }
    //RESTORE HEALS
    public void restoreHeals(Character c){
        c.inv.numberAshenEstus = 3;
        c.inv.numberEstus = 3;
        c.inv.greenBlossom = 3;
    }
    
    
}
