/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

/**
 *
 * @author aless
 */
public enum EnumVillain {
    IUDEX_GUNDYR("Iudex Gundyr", 80, 22, false),
    VORDT_OF_THE_BOREAL_VALLEY("Vordt of the Boreal Valley", 85, 23, false),
    DANCER_OF_THE_BOREAL_VALLEY("Dancer of the Boreal Valley", 90, 27, false),
    ABYSS_WATCHERS("Abyss Watchers", 88, 24, false),
    PONTIFF_SULYVAHN("Pontiff Sulyvahn", 95, 26, false),
    YHORM_THE_GIANT("Yhorm the Giant", 130, 20, false),
    ALDRICH_DEVOURER_OF_GODS("Aldrich, Devourer of Gods", 100, 27, false),
    LORRIC_AND_LORIAN("Lothric & Lorian", 105, 28, false),
    SOUL_OF_CINDER("Soul of Cinder", 115, 30, false),
    SISTER_FRIEDE("Sister Friede", 98, 26, false),
    NAMELESS_KING("Nameless King", 125, 28, false),
    DEMON_PRINCE("Demon Prince", 120, 27, false),
    DARK_EATER_MIDIR("Dark Eater Midir", 130, 30, false),
    SLAVE_KNIGHT_GAEL("Slave Knight Gael", 150, 32, false);

    private String displayName;
    private int life;
    private int baseAtt;
    private boolean appeared;

    EnumVillain(String displayName, int life, int baseAtt, boolean app) {
        this.displayName = displayName;
        this.life = life;
        this.baseAtt = baseAtt;
        this.appeared = app;
    }

    // getter
    public String getDisplayName() {
        return displayName;
    }

    public int getLife() {
        return life;
    }

    public int getBaseAtt() {
        return baseAtt;
    }

    public boolean isAppeared() {
        return appeared;
    }

    // setter (per poter modificare stats in runtime)
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public void setBaseAtt(int baseAtt) {
        this.baseAtt = baseAtt;
    }

    public void setAppeared(boolean appeared) {
        this.appeared = appeared;
    }

    public void controlBossApperas() {
        if (this.isAppeared() == false) {
            this.setAppeared(true);
        }
    }
}
