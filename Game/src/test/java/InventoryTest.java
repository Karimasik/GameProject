import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InventoryTest {
    private static Inventory res;
    private static List<Item> list = new ArrayList<>();

    @BeforeClass
    public static void createNewCalculator() {
        res = new Inventory(list);
    }

    @Test
    public void testAdd() { Assert.assertEquals(list, res.add(list, new Item("Стол", "деревянный")));
        Assert.assertEquals(list, res.add(list, new Item("Стул", "металлический")));}

    @Test
    public void testRemove() { Assert.assertEquals(list, res.remove(list, new Item("Стол", "деревянный")));}

    @Test
    public void testFind() { Assert.assertEquals(false, res.find(list, new Item("Стул", "металлический")));}
}
