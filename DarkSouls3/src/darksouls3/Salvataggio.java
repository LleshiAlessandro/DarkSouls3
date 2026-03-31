/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;


/**
 *
 * @author lleshi.alessandro
 */
public class Salvataggio {

    //dovrò inserire tutti i dati che dorvò salvare, così che con la serializzazione inserirò 1 solo oggetto Salvataggio nel fileManager e salverò tutto
    //con 1 solo oggetto
    private Character c;
    private Player p;
    private FormGameScreen gameScreen;

    public Salvataggio(Character c, Player p,FormGameScreen form) {
        this.c = c;
        this.p = p;
        this.gameScreen = form;
    }
    
}
