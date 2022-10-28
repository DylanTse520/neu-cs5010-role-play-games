/**
 * This is the headgear class. A headgear goes on the character’s head and are only useful for defense.
 * */
public class HeadGear extends AbstractGear {

    /**
     * Constructs a headgear object and initialize it with the given adjective part of the name and the noun part of
     * the name, the attack amount and the defense amount. A headgear cannot have non-zero attack power.
     *
     * @param adj            String, the adjective part of the name
     * @param noun           String, the noun part of the name
     * @param attackAmount   Integer, the amount of attack power of the gear
     * @param defenseAmount  Integer, the amount of defense power of the gear
     * @exception IllegalArgumentException thrown when attack amount is non-zero
     */
    public HeadGear(String adj, String noun, Integer attackAmount, Integer defenseAmount) {
        super(adj, noun, attackAmount, defenseAmount);
        if (attackAmount != 0) {
            throw new IllegalArgumentException("Head gear should have 0 attack amount");
        }
    }

    @Override
    Gear newGear(String adj, String noun, Integer attackAmount, Integer defenseAmount) {
        return new HeadGear(adj, noun, attackAmount, defenseAmount);
    }

    @Override
    boolean checkType(Gear other) {
        return other instanceof HeadGear;
    }

}
