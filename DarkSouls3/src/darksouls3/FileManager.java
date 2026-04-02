/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

import java.io.IOException;
import java.io.*;
import java.io.Serializable;

/**
 *
 * @author aless
 */
public class FileManager implements Serializable{
    //tutto da implementare
    private String gameSave = "salvataggio/save.ser";//savlataggio serializzato
    
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
}
