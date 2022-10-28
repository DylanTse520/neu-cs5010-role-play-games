/**
 * This is the gear interface specifying the needed methods.
 * */
public interface Gear {

    /**
     * A method to get the full name, consisting of an adjective and a noun.
     *
     * @return the full name in string
     */
    String getName();

    /**
     * A method to get the adjective part of the name.
     *
     * @return the adjective part of the name in string
     */
    String getAdj();

    /**
     * A method to get the noun part of the name.
     *
     * @return the noun part of the name in string
     */
    String getNoun();

    /**
     * A method to get the adjective part of the name.
     *
     * @param other another gear to combine with the current gear
     * @return a new gear that combines the power of the two gears and their name
     */
    Gear combine(Gear other);

    /**
     * A method to get the attack power of the gear.
     *
     * @return the attack power of the gear in integer
     */
    int getGearAttackAmount();

    /**
     * A method to get the defense power of the gear.
     *
     * @return the defense power of the gear in integer
     */
    int getGearDefenseAmount();

}
