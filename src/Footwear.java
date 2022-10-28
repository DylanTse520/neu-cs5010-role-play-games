/**
 * This is the footwear class. A footwear goes on the character’s feet and can be for attack or defense.
 * */
public class Footwear extends AbstractGear {

    /**
     * Constructs a footwear object and initialize it with the given adjective part of the name and the noun part of
     * the name, the attack amount and the defense amount.
     *
     * @param adj            String, the adjective part of the name
     * @param noun           String, the noun part of the name
     * @param attackAmount   Integer, the amount of attack power of the gear
     * @param defenseAmount  Integer, the amount of defense power of the gear
     */
    public Footwear(String adj, String noun, Integer attackAmount, Integer defenseAmount) {
        super(adj, noun, attackAmount, defenseAmount);
    }

    @Override
    Gear newGear(String adj, String noun, Integer attackAmount, Integer defenseAmount) {
        return new Footwear(adj, noun, attackAmount, defenseAmount);
    }

    @Override
    boolean checkType(Gear other) {
        return other instanceof Footwear;
    }

}
