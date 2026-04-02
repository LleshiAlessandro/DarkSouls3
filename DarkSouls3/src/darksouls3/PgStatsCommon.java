/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

import java.io.Serializable;

/**
 *
 * @author lleshi.alessandro
 */
public class PgStatsCommon implements Serializable{

    protected String name;
    protected int life;
    protected int baseAtt;

    public PgStatsCommon(String name, int life, int baseAtt) {
        this.name = name;
        this.life = life;
        this.baseAtt = baseAtt;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getLife() {
        return life;
    }

    public int getBaseAtt() {
        return baseAtt;
    }

    public void setBaseAtt(int baseAtt) {
        this.baseAtt = baseAtt;
    }

}
