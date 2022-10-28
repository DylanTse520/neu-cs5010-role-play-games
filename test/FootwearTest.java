import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This class is to test a footwear. It contains a footwear.
 * */
public class FootwearTest {

    private Footwear footwear;

    @Before
    public void setUp() {
        footwear = new Footwear("Scurrying", "Sandals", 0, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionThrownWithNegativeAttackAmount() {
        Footwear negativeAttackAmount = new Footwear("Scurrying", "Sandals", -8, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionThrownWithNullNameInput() {
        Footwear nullNameInput = new Footwear(null, "Sandals", 8, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionThrownWithEmptyNameInput() {
        Footwear emptyNameInput = new Footwear("", "Sandals", 8, 0);
    }

    @Test
    public void testGetName() {
        assertEquals("Scurrying Sandals", footwear.getName());
    }

    @Test
    public void testGetAdj() {
        assertEquals("Scurrying", footwear.getAdj());
    }

    @Test
    public void testGetNoun() {
        assertEquals("Sandals", footwear.getNoun());
    }

    @Test
    public void testGetGearAttackAmount() {
        assertEquals(0, footwear.getGearAttackAmount());
    }

    @Test
    public void testGetGearDefenseAmount() {
        assertEquals(1, footwear.getGearDefenseAmount());
    }

    @Test
    public void testToString() {
        assertEquals("Scurrying Sandals -- defense strength: 1, attack strength 0", footwear.toString());
    }

}
