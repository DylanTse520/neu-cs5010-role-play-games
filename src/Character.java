import java.util.ArrayList;
import java.util.List;

/**
 * Character class has an attack and defense strength. It can pick up new gears and add attack/defense strength.
 */

public class Character {

    private final static int MAXIMUM_NUM_OF_ITEMS = 2;
    private final int uid;
    private final int baseAttack;
    private final int baseDefense;
    private final List<HandGear> handgearArr = new ArrayList<>();
    private final List<Footwear> footwearArr = new ArrayList<>();
    private HeadGear headGear;

    /**
     * Constructs a character with 3 params: uid, baseAttack and baseDefense.
     */
    public Character(int uid, int baseAttack, int baseDefense) {
        this.uid = uid;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
    }

    public void pickItem(Gear gear) {
        if (gear instanceof HeadGear) {
            headGear = (HeadGear) gear;
        }

        if (gear instanceof HandGear) {
            if (handgearArr.size() < MAXIMUM_NUM_OF_ITEMS) {
                handgearArr.add((HandGear) gear);
            } else {
                gear.combine(gear);
            }
        }

        if (gear instanceof Footwear) {
            if (footwearArr.size() < MAXIMUM_NUM_OF_ITEMS) {
                footwearArr.add((Footwear) gear);
            } else {
                gear.combine(gear);
            }
        }
    }

    /**
     * Getter method for unique id.
     *
     * @return the unique id of a character.
     */
    public int getUid() {
        return this.uid;
    }

    /**
     * Getter method for base attack.
     *
     * @return the base attack.
     */
    public int getBaseAttack() {
        return this.baseAttack;
    }

    /**
     * Getter method for base defense.
     *
     * @return the base defense.
     */
    public int getBaseDefense() {
        return this.baseDefense;
    }

    public HeadGear getHeadGear() {
        return this.headGear;
    }

    public List<HandGear> getHandGears() {
        return this.handgearArr;
    }

    public List<Footwear> getFootwears() {
        return this.footwearArr;
    }

    public int getTotalAttack() {
        int totalAttack = baseAttack;
        for (HandGear hg : handgearArr) {
            totalAttack += hg.getGearAttackAmount();
        }
        for (Footwear fw : footwearArr) {
            totalAttack += fw.getGearAttackAmount();
        }
        return totalAttack;
    }

    public int getTotalDefense() {
        int totalDefense = baseDefense;
        totalDefense += headGear != null ? headGear.getGearDefenseAmount() : 0;
        for (Footwear fw : footwearArr) {
            totalDefense += fw.getGearDefenseAmount();
        }
        return totalDefense;
    }
}
