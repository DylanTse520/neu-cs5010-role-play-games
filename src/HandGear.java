public class HandGear extends AbstractGear {

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
