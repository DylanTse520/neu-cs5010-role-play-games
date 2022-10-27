public interface Gear {

    String getName();

    String getAdj();

    String getNoun();

    Gear combine(Gear other);

    int getGearAttackAmount();

    int getGearDefenseAmount();

}
