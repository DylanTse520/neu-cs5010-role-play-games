import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HandGearTest {

    private HandGear handGear;

    @Before
    public void setUp() {
        handGear = new HandGear("Fierce", "Sword", 8, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionThrownWithIllegalDefenseAmount() {
        HandGear illegalDefenseAmount = new HandGear("Fierce", "Sword", 8, 7);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionThrownWithNegativeAttackAmount() {
        HandGear negativeAttackAmount = new HandGear("Fierce", "Sword", -8, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionThrownWithNullNameInput() {
        HandGear nullNameInput = new HandGear(null, "Sword", 8, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionThrownWithEmptyNameInput() {
        HandGear emptyNameInput = new HandGear("", "Sword", 8, 0);
    }

    @Test
    public void testGetName() {
        assertEquals("Fierce Sword", handGear.getName());
    }

    @Test
    public void testGetAdj() {
        assertEquals("Fierce", handGear.getAdj());
    }

    @Test
    public void testGetNoun() {
        assertEquals("Sword", handGear.getNoun());
    }

    @Test
    public void testGetGearAttackAmount() {
        assertEquals(8, handGear.getGearAttackAmount());
    }

    @Test
    public void testGetGearDefenseAmount() {
        assertEquals(0, handGear.getGearDefenseAmount());
    }

    @Test
    public void testToString() {
        assertEquals("Fierce Sword -- defense strength: 0, attack strength 8", handGear.toString());
    }

}
