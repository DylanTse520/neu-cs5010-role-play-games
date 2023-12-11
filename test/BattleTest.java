import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BattleTest {
    private Battle battle;

    @Before
    public void testConstructor() {
        List<Gear> items = new ArrayList<>();
        HeadGear headGear1 = new HeadGear("Weak", "Helmet", 0, 30);
        HeadGear headGear2 = new HeadGear("Strong", "Helmet", 0, 50);

        HandGear handGear1 = new HandGear("Fierce", "Sword", 30, 0);
        HandGear handGear2 = new HandGear("Rusty", "Sword", 10, 0);
        HandGear handGear3 = new HandGear("Bloodflame", "Blade", 50, 0);
        HandGear handGear4 = new HandGear("Moonveil", "Katana", 100, 0);

        Footwear footwear1 = new Footwear("Scurrying", "Sandals", 10, 100);
        Footwear footwear2 = new Footwear("Commoner", "Shoes", 30, 50);
        Footwear footwear3 = new Footwear("Aristocrat", "Shoes", 50, 30);
        Footwear footwear4 = new Footwear("Bloodhound", "Step", 100, 10);

        items.add(headGear1);
        items.add(handGear2);
        items.add(handGear1);
        items.add(footwear1);
        items.add(headGear2);
        items.add(footwear3);
        items.add(handGear3);
        items.add(footwear4);
        items.add(footwear2);
        items.add(handGear4);

        Character a = new Character(1, 10, 10);
        Character b = new Character(2, 10, 10);

        battle = new Battle(a, b, items);
    }

    @Test
    public void testBattle() {
        battle.startBattle();
    }
}
