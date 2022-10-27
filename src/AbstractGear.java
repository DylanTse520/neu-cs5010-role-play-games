public abstract class AbstractGear implements Gear {

    private String adj;
    private String noun;
    private Integer attackAmount;
    private Integer defenseAmount;

    public AbstractGear(String adj, String noun, Integer attackAmount, Integer defenseAmount) {
        if (adj == null || noun == null || attackAmount == null || defenseAmount == null) {
            throw new IllegalArgumentException("Input should not be null");
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
    public Integer getGearAttackAmount() {
        return attackAmount;
    }

    @Override
    public Integer getGearDefenseAmount() {
        return defenseAmount;
    }

    abstract Gear newGear(String adj, String noun, Integer attackAmount, Integer defenseAmount);

    abstract boolean checkType(Gear other);
}
