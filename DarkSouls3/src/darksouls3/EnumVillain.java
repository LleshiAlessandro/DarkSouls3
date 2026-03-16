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
    IUDEX_GUNDYR("Iudex Gundyr", 80, 22),
    VORDT_OF_THE_BOREAL_VALLEY("Vordt of the Boreal Valley", 85, 23),
    DANCER_OF_THE_BOREAL_VALLEY("Dancer of the Boreal Valley", 90, 25),
    ABYSS_WATCHERS("Abyss Watchers", 88, 24),
    PONTIFF_SULYVAHN("Pontiff Sulyvahn", 95, 26),
    YHORM_THE_GIANT("Yhorm the Giant", 130, 20),
    ALDRICH_DEVOURER_OF_GODS("Aldrich, Devourer of Gods", 100, 27),
    LORRIC_AND_LORIAN("Lothric & Lorian", 105, 28),
    SOUL_OF_CINDER("Soul of Cinder", 115, 30),
    SISTER_FRIEDE("Sister Friede", 98, 26),
    NAMELESS_KING("Nameless King", 125, 28),
    DEMON_PRINCE("Demon Prince", 120, 27),
    DARK_EATER_MIDIR("Dark Eater Midir", 130, 30),
    SLAVE_KNIGHT_GAEL("Slave Knight Gael", 150, 32);

    private String displayName;
    private int life;
    private int baseAtt;

    EnumVillain(String displayName, int life, int baseAtt) {
        this.displayName = displayName;
        this.life = life;
        this.baseAtt = baseAtt;
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
}
