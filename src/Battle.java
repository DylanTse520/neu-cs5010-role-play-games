import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * This class is the driver class that represents a battle.
 */
public class Battle {
    private final static int MAXIMUM_NUM_OF_ROUNDS = 10;
    private final Character a;
    private final Character b;
    private final List<Gear> items;

    /**
     * Constructs a battle with 3 params: 2 characters and a list of items.
     */
    public Battle(Character a, Character b, List<Gear> items) {
        this.a = a;
        this.b = b;
        this.items = items;
    }

    /**
     * A method to see if one gear is possible for a character.
     *
     * @param gear      a gear item.
     * @param character a character of the battle.
     */
    private boolean isAvailableGear(Gear gear, Character character) {
        if (gear instanceof HeadGear) {
            return character.getHandGears() == null;
        } else if (gear instanceof HandGear) {
            return character.getHandGears().size() < 2;
        } else if (gear instanceof Footwear) {
            return character.getFootwears().size() < 2;
        }
        return false;
    }

    /**
     * A method to let character choose gear according to 4 different rules.
     *
     * @param character a character of the battle.
     */
    public void chooseGear(Character character) {
        List<Gear> preferredGears = new ArrayList<>();

        for (Gear gear : items) {
            if (isAvailableGear(gear, character)) {
                preferredGears.add(gear);
            }
        }

        Gear gear;
        if (preferredGears.size() > 0) {
            gear = getBestGear(preferredGears);
        } else {
            gear = getBestGear(items);
        }
        character.pickItem(gear);
        items.remove(gear);
    }

    /**
     * A method for prioritizing the gear when there are multiple choices.
     *
     * @param preferredGears a list of all the gear that can be chosen.
     * @return a gear with the highest attack/defence amount.
     */
    public Gear getBestGear(List<Gear> preferredGears) {
        int maxAttackValue = -1;
        List<Gear> highestAttackGear = new ArrayList<>();
        for (Gear gear : preferredGears) {
            if (gear.getGearAttackAmount() > maxAttackValue) {
                maxAttackValue = gear.getGearAttackAmount();
                highestAttackGear = new ArrayList<>();
                highestAttackGear.add(gear);
            } else if (gear.getGearAttackAmount() == maxAttackValue) {
                highestAttackGear.add(gear);
            }
        }

        int maxDefenseValue = -1;
        List<Gear> highestDefenseGear = new ArrayList<>();
        for (Gear gear : highestAttackGear) {
            if (gear.getGearDefenseAmount() > maxDefenseValue) {
                maxDefenseValue = gear.getGearDefenseAmount();
                highestDefenseGear = new ArrayList<>();
                highestDefenseGear.add(gear);
            } else if (gear.getGearDefenseAmount() == maxDefenseValue) {
                highestDefenseGear.add(gear);
            }
        }

        return highestDefenseGear.get(new Random().nextInt(highestDefenseGear.size()));
    }

    /**
     * A method to start a battle and print out the result.
     */
    public void startBattle() {
        for (int i = 0; i < MAXIMUM_NUM_OF_ROUNDS; i++) {
            if (i % 2 == 0) {
                chooseGear(a);
                System.out.println("Player " + a.getUid() + ":\nHeadGear: " + a.getHeadGear() + "\nHandGear: " + a.getHandGears() + "\nFootwears:" + a.getFootwears() + "\nDefense: " + a.getTotalDefense() + " " + "Attack: " + a.getTotalAttack());
            } else {
                chooseGear(b);
                System.out.println("Player " + b.getUid() + ":\nHeadGear: " + b.getHeadGear() + "\nHandGear: " + b.getHandGears() + "\nFootwears:" + b.getFootwears() + "\nDefense: " + b.getTotalDefense() + " " + "Attack: " + b.getTotalAttack());
            }
        }

        int finalScoreA = a.getTotalAttack() - b.getTotalDefense();
        int finalScoreB = b.getTotalAttack() - a.getTotalDefense();

        if (finalScoreA > finalScoreB) System.out.println("Player " + a.getUid() + " wins");
        else if (finalScoreA < finalScoreB) System.out.println("Player " + b.getUid() + " wins");
        else System.out.println("It is a tie");
    }
}
