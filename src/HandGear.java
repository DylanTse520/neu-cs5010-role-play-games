/**
 * This is the hand gear class. A hand gear goes on the character’s hands and are only useful for attack.
 * */
public class HandGear extends AbstractGear {

    /**
     * Constructs a hand gear object and initialize it with the given adjective part of the name and the noun part of
     * the name, the attack amount and the defense amount. A hand gear cannot have non-zero defense power.
     *
     * @param adj            String, the adjective part of the name
     * @param noun           String, the noun part of the name
     * @param attackAmount   Integer, the amount of attack power of the gear
     * @param defenseAmount  Integer, the amount of defense power of the gear
     * @exception IllegalArgumentException thrown when attack amount is non-zero
     */
    public HandGear(String adj, String noun, Integer attackAmount, Integer defenseAmount) {
        super(adj, noun, attackAmount, defenseAmount);
        if (defenseAmount != 0) {
            throw new IllegalArgumentException("Head gear should have 0 defense amount");
        }
    }

    @Override
    Gear newGear(String adj, String noun, Integer attackAmount, Integer defenseAmount) {
        return new HandGear(adj, noun, attackAmount, defenseAmount);
    }

    @Override
    boolean checkType(Gear other) {
        return other instanceof HandGear;
    }

}
