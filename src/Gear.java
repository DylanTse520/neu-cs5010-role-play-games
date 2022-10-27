public interface Gear {

    String getName();

    String getAdj();

    String getNoun();

    Gear combine(Gear other);

    Integer getGearAttackAmount();

    Integer getGearDefenseAmount();

}
