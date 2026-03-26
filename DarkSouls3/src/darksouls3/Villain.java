/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package darksouls3;

/**
 *
 * @author lleshi.alessandro
 */
public class Villain extends PgStatsCommon {

    public Villain(EnumVillain bossEnum) {
        super(bossEnum.getDisplayName(), bossEnum.getLife(), bossEnum.getBaseAtt());
    }

    public String getName() {
        return name;
    }

}
