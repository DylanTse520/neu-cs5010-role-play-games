import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharacterTest {
    private Character character;

    @Before
    public void testConstructor() {
        character = new Character(1, 10, 10);
    }

    @Test
    public void testBaseAttack() {
        assertEquals(10, character.getBaseAttack());
    }

    @Test
    public void testBaseDefense() {
        assertEquals(10, character.getBaseDefense());
    }
}
