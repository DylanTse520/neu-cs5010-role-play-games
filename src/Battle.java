import java.util.*;

/**
 * This class is the driver class that represents a battle.
 */
public class Battle {
    private Character a;
    private Character b;
    private List<Gear> items;

    /**
     * Constructs a battle with 3 params: 2 characters and a list of items
     */
    public Battle(Character a, Character b, List<Gear> items) {
        this.a = a;
        this.b = b;
        this.items = items;
    }

    public void chooseGear(Character character, int index) {
        List<Gear> selectedGears = new ArrayList<>();

        Gear item = items.get(index-1);

        if (character.getHandGears() == null || character.getHandGears().size() < 2 || character.getFootwears().size() < 2) {
            selectedGears.add(item);
            Gear gear = gearPriority(selectedGears);
            character.pickItem(gear);
            items.remove(gear);
        }

        character.pickItem(item);
        items.remove(item);
    }

    Gear finalGear = null;
    int maxValue = -1;
    boolean hasFinalAttachGear = false;
    boolean hasFinalDefenseGear = false;

    public Gear gearPriority(List<Gear> selectedGears) {
        for (int i = 0; i < selectedGears.size(); i++) {
            if (selectedGears.get(i).getGearAttackAmount() > maxValue) {
                maxValue = selectedGears.get(i).getGearAttackAmount();
                finalGear = selectedGears.get(i);
            }
        }

        if (!hasFinalAttachGear) {
            for (Gear gear : selectedGears) {
                if (gear.getGearDefenseAmount() > finalGear.getGearDefenseAmount()) {
                    finalGear = gear;
                    hasFinalDefenseGear = true;
                } else {
                    continue;
                }
            }
        }

        if (!hasFinalDefenseGear) {
            int n = selectedGears.size();
            int r = (int) (Math.random() * n);
            finalGear = selectedGears.get(r);
        }

        return finalGear;
    }

    public void startBattle() {
        int i = 10;
        List<Character> list = new ArrayList<>();
        list.add(a);
        list.add(b);

        while (items.size() > 0) {
            Random randomizer = new Random();
            Character random = list.get(randomizer.nextInt(list.size()));
            chooseGear(random, i);
            i--;

        }

        System.out.println("Player" + a.getUid() + " " + a.getHeadGear() + a.getHandGears().get(0) + a.getHandGears().get(1) + a.getFootwears().get(0) + a.getFootwears().get(1) + " " + "Defense: " + a.getTotalDefense() + " " + "Attack: " + a.getTotalAttack());
        System.out.println("Player" + b.getUid() + " " + b.getHeadGear() + b.getHandGears().get(0) + b.getHandGears().get(1) + b.getFootwears().get(0) + b.getFootwears().get(1) + " " + "Defense: " + b.getTotalDefense() + " " + "Attack: " + b.getTotalAttack());

        int finalScoreA =  a.getBaseDefense() - a.getTotalAttack();
        int finalScoreB =  b.getBaseDefense() - b.getTotalAttack();

        if (finalScoreA < finalScoreB) System.out.println("Player " + a.getUid() + " wins");
        else if (finalScoreA > finalScoreB) System.out.println("Player " + b.getUid() + " wins");
        else System.out.println("It is a tie");
    }
}
