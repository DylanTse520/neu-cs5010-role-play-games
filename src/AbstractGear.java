/**
 * This is the abstract gear class. A gear is a piece of clothing a character can wear to either increase performance
 * with the power to attack or to minimize damage with the power to defense. It has a name consisting of an adjective
 * and a noun, the amount it helps to attack and defense.
 * */
public abstract class AbstractGear implements Gear {

    private final String adj;
    private final String noun;
    private final Integer attackAmount;
    private final Integer defenseAmount;

    /**
     * Constructs a gear object and initialize it with the given adjective part of the name and the noun part of the
     * name, the attack amount and the defense amount.
     *
     * @param adj            String, the adjective part of the name
     * @param noun           String, the noun part of the name
     * @param attackAmount   Integer, the amount of attack power of the gear
     * @param defenseAmount  Integer, the amount of defense power of the gear
     * @exception IllegalArgumentException thrown when input is null, names are empty or attack amount or defense
     * amount is negative
     */
    public AbstractGear(String adj, String noun, Integer attackAmount, Integer defenseAmount) {
        if (adj == null || noun == null || attackAmount == null || defenseAmount == null) {
            throw new IllegalArgumentException("Input should not be null");
        }
        if (adj.equals("") || noun.equals("")) {
            throw new IllegalArgumentException("Names should not be empty string");
        }
        if (attackAmount < 0 || defenseAmount < 0) {
            throw new IllegalArgumentException("Attack amount or defense amount should not be negative");
        }
        this.adj = adj;
        this.noun = noun;
        this.attackAmount = attackAmount;
        this.defenseAmount = defenseAmount;
    }

    @Override
    public String getName() {
        return adj + " " + noun;
    }

    @Override
    public String getAdj() {
        return adj;
    }

    @Override
    public String getNoun() {
        return noun;
    }

    @Override
    public Gear combine(Gear other) {
        if (!(checkType(other))) {
            throw new IllegalArgumentException("Wrong type of gear");
        }
        return newGear(other.getAdj() + ", " + this.getAdj(), this.getNoun(),
                other.getGearAttackAmount() + this.getGearAttackAmount(),
                other.getGearDefenseAmount() + this.getGearDefenseAmount());
    }

    @Override
    public int getGearAttackAmount() {
        return attackAmount;
    }

    @Override
    public int getGearDefenseAmount() {
        return defenseAmount;
    }

    @Override
    public String toString() {
        return getName() + " -- defense value: " + defenseAmount + ", attack value: " + attackAmount;
    }


    /**
     * The new gear method to be implemented by a child class, returning the actual class of the gear.
     *
     * @param adj            String, the adjective part of the name
     * @param noun           String, the noun part of the name
     * @param attackAmount   Integer, the adjective part of the name
     * @param defenseAmount  Integer, the noun part of the name
     */
    abstract Gear newGear(String adj, String noun, Integer attackAmount, Integer defenseAmount);

    /**
     * The check type method to be implemented by a child class, comparing the class of the given gear and this gear.
     *
     * @param other  Gear, the gear to compare the class against
     * @return true if the given gear is of the class as this gear and false otherwise
     */
    abstract boolean checkType(Gear other);

}
