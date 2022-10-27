public abstract class AbstractGear implements Gear {

    private Integer id;
    private String adj;
    private String noun;
    private Integer attackAmount;
    private Integer defenseAmount;

    public AbstractGear(Integer id, String adj, String noun, Integer attackAmount, Integer defenseAmount) {
        this.id = id;
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
    public Integer getGearAttackAmount() {
        return attackAmount;
    }

    @Override
    public Integer getGearDefenseAmount() {
        return defenseAmount;
    }

}
