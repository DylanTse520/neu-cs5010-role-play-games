public class HeadGear extends AbstractGear {

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
