import java.util.*;

public class Location {
    private String name;
    private Inventory inventory;
    private Set<Direction> directions;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Direction> getDirections() {
        return directions;
    }

    public String getDescriptionLocation() {
        return "Такой локации не существует, но мы работаем над обновлением.";
    }

    public void LocationItems() {
        System.out.println("На этой локации нет предметов");
    }

    public void deleteItem() {}

    public void showItem() {}

    public void findItem() {}
}
