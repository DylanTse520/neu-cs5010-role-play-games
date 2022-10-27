import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HeadGearTest {

    private HeadGear headGear;

    @Before
    public void setUp() {
        headGear = new HeadGear("Strong", "Helmet", 0, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionThrownWithIllegalAttackAmount() {
        HeadGear illegalAttackAmount = new HeadGear("Strong", "Helmet", 5, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionThrownWithNegativeDefenseAmount() {
        HeadGear negativeDefenseAmount = new HeadGear("Strong", "Helmet", 0, -5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionThrownWithNullNameInput() {
        HeadGear nullNameInput = new HeadGear(null, "Helmet", 0, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionThrownWithEmptyNameInput() {
        HeadGear emptyNameInput = new HeadGear("", "Helmet", 0, 5);
    }

    @Test
    public void testGetName() {
        assertEquals("Strong Helmet", headGear.getName());
    }

    @Test
    public void testGetAdj() {
        assertEquals("Strong", headGear.getAdj());
    }

    @Test
    public void testGetNoun() {
        assertEquals("Helmet", headGear.getNoun());
    }

    @Test
    public void testGetGearAttackAmount() {
        assertEquals(0, headGear.getGearAttackAmount());
    }

    @Test
    public void testGetGearDefenseAmount() {
        assertEquals(5, headGear.getGearDefenseAmount());
    }

    @Test
    public void testToString() {
        assertEquals("Strong Helmet -- defense strength: 5, attack strength 0", headGear.toString());
    }

}
