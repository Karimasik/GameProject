import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Inventory {
    private List<Item> items;

    public Inventory(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Item> add(List<Item> items, Item item){
        items.add(item);
        return items;
    }

    public List<Item> remove(List<Item> items, Item item) {
        items.remove(item);
        return items;
    }

    public void show(List<Item> items) {
        for(Item i : items) {
            System.out.println(i);
        }
    }

    public boolean find(List<Item> items, Item item) {
        boolean result = items.stream()
                .anyMatch(i -> item.getName().equals("Древний меч Десаада"));
        return result;
    }
}
