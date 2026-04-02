/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

import java.io.Serializable;

/**
 *
 * @author aless
 */
public class NPC implements Serializable{

    private NPC_Name name;

    public NPC(NPC_Name name) {
        this.name = name;
    }

    public NPC_Name getName() {
        return name;
    }

    @Override
    public String toString() {
        // Converte in una forma leggibile
        return name.toString().replace("_", " ");
    }
}
