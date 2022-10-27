public class Footwear extends AbstractGear {

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
