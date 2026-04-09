/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

import java.io.IOException;
import java.io.*;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author aless
 */
public class FileManager implements Serializable{
    //tutto da implementare
    private String gameSave = "salvataggio/save.ser";//savlataggio serializzato
    private String gameSaveCsv = "salvataggio/saveCsv.txt";
    private String npcMet_String;
    
    public void saveSer(Salvataggio s){
        //salvo variabili character
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(gameSave))){
            oos.writeObject(s);
        }catch(IOException e){
            System.out.println(e);
        }
    }
    public Salvataggio loadSer(Salvataggio s){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(gameSave))){
            //devo far leggere 
            Salvataggio newS = (Salvataggio) ois.readObject();
            return newS;
        }catch(IOException e){
            System.out.println(e);
        }catch(ClassNotFoundException i){
            System.out.println(i);
        }
        return null;
    }
    
    
    
    public void saveCsv(Salvataggio s) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(gameSaveCsv))) {

            writer.write("player name;life;mana;stamina;baseAtt;numberEstus;numberAshenEstus;numberGreenBlossom;npcs;characterType");
            writer.newLine();

            String npcString = "";
            for (NPC npc : s.c.getNpcsMet()) {
                npcString += npc.getName().name() + ",";
            }
            //tolgo l'ultima virgola
            if (!npcString.isEmpty()) {
                npcString = npcString.substring(0, npcString.length() - 1);
            }

            writer.write(s.p.getName() + ";" +
                         s.c.getLife() + ";" +
                         s.c.getMana() + ";" +
                         s.c.getStamina() + ";" +
                         s.c.getBaseAtt() + ";" +
                         s.c.inv.getNumberEstus() + ";" +
                         s.c.inv.getNumberAshenEstus() + ";" +
                         s.c.inv.getGreenBlossom() + ";" +
                         npcString + ";" +
                         s.c.getClass().getSimpleName());
            writer.newLine();

        } catch (Exception e) {
            System.out.println("Errore saveCsv: " + e);
        }
    }

    public Salvataggio loadCsv() {
        try (BufferedReader reader = new BufferedReader(new FileReader(gameSaveCsv))) {

            reader.readLine();
            String line = reader.readLine();

            String[] stats = line.split(";");

            String playerName = stats[0];
            int life = Integer.parseInt(stats[1]);
            int mana = Integer.parseInt(stats[2]);
            int stamina = Integer.parseInt(stats[3]);
            int baseAtt = Integer.parseInt(stats[4]);
            int numberEstus = Integer.parseInt(stats[5]);
            int numberAshenEstus = Integer.parseInt(stats[6]);
            int numberGreenBlossom = Integer.parseInt(stats[7]);
            String npcString = stats[8];
            String characterType = stats[9];

            Player p = new Player(playerName);

            Character c;
            if (characterType.equals("Knight")) {
                c = new Knight(mana, stamina, playerName, life, baseAtt);
            } else if (characterType.equals("Barbarian")) {
                c = new Barbarian(mana, stamina, playerName, life, baseAtt);
            } else if (characterType.equals("Mage")) {
                c = new Mage(mana, stamina, playerName, life, baseAtt);
            } else if (characterType.equals("Priest")) {
                c = new Priest(mana, stamina, playerName, life, baseAtt);
            } else {
                System.out.println("Classe sconosciuta: " + characterType);
                return null;
            }

            c.inv.setNumberEstus(Integer.parseInt(stats[5]));
            c.inv.setNumberAshenEstus(Integer.parseInt(stats[6]));
            c.inv.setGreenBlossom(Integer.parseInt(stats[7]));

            ArrayList<NPC> npcs = new ArrayList();
            if (!npcString.isEmpty()) {
                String[] npcNames = npcString.split(",");
                for (String name : npcNames) {
                    NPC_Name enumName = NPC_Name.valueOf(name);
                    npcs.add(new NPC(enumName));
                }
            }
            c.setNpcsMet(npcs);

            Salvataggio s = new Salvataggio(c, p);
            return s;

        } catch (Exception e) {
            System.out.println("Errore loadTxt: " + e);
            return null;
        }
    }

}
