/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

import java.util.ArrayList;

/**
 *
 * @author aless
 */
public class EndingManager {

    public Ending ending(ArrayList<NPC> npcsMet) {
        for (NPC n : npcsMet) {
            NPC_Name name = n.getName();
            if (name.equals(NPC_Name.ANRI_OF_ASTORA) || name.equals(NPC_Name.YURIA_OF_LONDOR) || name.equals(NPC_Name.YOEL_OF_LONDOR)) {
                return Ending.BAD_ENDING;
            } else if (name.equals(NPC_Name.FIRE_KEEPER)) {
                return Ending.GOOD_ENDING;
            }
        }
        return Ending.CLASSIC_ENDING;
    }
}
