import java.util.ArrayList;
import java.util.List;

/**
 * Character class has an attack and defense strength. It can pick up new gears and add attack/defense strength.
 */

public class Character {

    private final static int MAXIMUM_NUM_OF_ITEMS = 2;
    private static HeadGear headGear;
    private static List<HandGear> handgearArr = new ArrayList<>();
    private static List<Footwear> footwearArr = new ArrayList<>();
    private final int baseAttack;
    private final int baseDefense;
    private int uid;

    /**
     * Constructs a character with 3 params: uid, baseAttack and baseDefense.
     */
    public Character(int uid, int baseAttack, int baseDefense) {
        this.uid = uid;
        this.baseAttack = baseAttack;
        this.baseDefense = baseDefense;
    }

    public static void pickItem(Gear gear) {
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

    public static void main(String[] args) {
        headGear = new HeadGear("Strong", "Helmet", 0, 5);
        HandGear handGear = new HandGear("Fierce", "Sword", 8, 0);
        pickItem(handGear);
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
        int totalAttack = 0;
        for (HandGear hg : handgearArr) {
            totalAttack += hg.getGearAttackAmount();
        }
        for (Footwear fw : footwearArr) {
            totalAttack += fw.getGearAttackAmount();
        }
        return totalAttack;
    }

    public int getTotalDefense() {
        int totalDefense = 0;
        totalDefense += headGear.getGearDefenseAmount();
        for (Footwear fw : footwearArr) {
            totalDefense += fw.getGearDefenseAmount();
        }
        return totalDefense;
    }
}
