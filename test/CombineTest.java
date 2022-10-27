import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CombineTest {

    private Footwear scurryingSandals;
    private Footwear happyHoverBoard;
    private HeadGear headGear;

    @Before
    public void setUp() {
        scurryingSandals = new Footwear("Scurrying", "Sandals", 0, 1);
        happyHoverBoard = new Footwear("Happy", "HoverBoard", 1, 3);
        headGear = new HeadGear("Strong", "Helmet", 0, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionThrownWithWrongTypeOfGear() {
        scurryingSandals.combine(headGear);
    }

    @Test
    public void testGetName() {
        Footwear newFootwear = (Footwear) happyHoverBoard.combine(scurryingSandals);
        assertEquals("Scurrying, Happy HoverBoard -- defense strength: 4, attack strength 1", newFootwear.toString());
    }

}
