import java.util.*;

public class Player {
    private String name;
    private Location location;
    private List<Item> playerItems = new ArrayList<>();
    private Inventory playerInventory = new Inventory(playerItems);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public List<Item> getPlayerItems() {
        return playerItems;
    }

    public Inventory getPlayerInventory() {
        return playerInventory;
    }

    public void setPlayerItems(List<Item> playerItems) {
        this.playerItems = playerItems;
    }

    public void setPlayerInventory(Inventory playerInventory) {
        this.playerInventory = playerInventory;
    }

    public void lookAround() {
        new Temple("Сумрачный собор").LocationItems();
    }

    public void go(Direction dir) {
        System.out.println("Пойти на " + dir);
        switch (dir) {
            case NORTH:
                System.out.println("Идем на север.");
                break;
            case SOUTH:
                System.out.println("Идем на юг.");
                break;
            case UP:
                System.out.println("Поднимаемся на второй этаж.");
                break;
            case EAST:
                System.out.println("Идем на восток.");
                break;
            case WEST:
                System.out.println("Идем на запад.");
                break;
            default:
                System.out.println("Пути в данном направлении не существует в данной локации.");
                System.exit(0);
        }
    }

    public void take(Item item) {
        playerInventory.add(playerItems, item);
    }

    public void use(String name1, String name2) {
        Combo combo = new Combo();
        playerInventory.add(playerItems, combo.getResult());
        System.out.println(combo.getMessage());
    }

    public void showInventory() {
        playerInventory.show(playerItems);
    }

    public void inventory() {
        playerInventory.add(playerItems, new Item("Обычный меч", "Может вызвать оглушение"));
        playerInventory.add(playerItems, new Item("Крестьянские сапоги", "+1% к устойчивости"));
        playerInventory.add(playerItems, new Item("Роба шелковая", "+1% к броне"));
        playerInventory.add(playerItems, new Item("Вода", "+5% Восстановление здоровья"));
        playerInventory.add(playerItems, new Item("Реликвия Десаада", "Восстановление оружия"));
    }

    public void deleteItemOfInventory(String name) {
//        for(Item item : playerItems) {
//            if(item.getName().equals(name)) {
//                playerInventory.remove(playerItems, item);
//            }
//        }
        for(int i = 0; i < playerItems.size(); i++) {
            if(playerItems.get(i).getName().equals(name)) {
                playerInventory.remove(playerItems, playerItems.get(i));
            }
        }
    }
}
