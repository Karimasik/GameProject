import java.util.*;

public class Temple extends Location{
    private Set<Direction> directions = EnumSet.range(Direction.UP, Direction.SOUTH);
    private List<Item> templeList = new ArrayList<>();
    private Inventory temple = new Inventory(templeList);

    public Temple(String name) {
    }

    public List<Item> getTempleList() {
        return templeList;
    }

    public void setTempleList(List<Item> templeList) {
        this.templeList = templeList;
    }

    public Inventory getTemple() {
        return temple;
    }

    public void setTemple(Inventory temple) {
        this.temple = temple;
    }

    @Override
    public Set<Direction> getDirections() {
        return directions;
    }

    @Override
    public String getDescriptionLocation() {
        return "Сумрачный собор - когда-то был храмом, где в священных залах человечество нашло убежище от зла." +
                " Но после наступления Конца света,\nдаже такие храмы были подвержены нападению сил зла, выстоял" +
                " только сумрачный собор. Его стены обагрены кровью погибших в храме людей, \nа адский огонь вырывается" +
                " наружу из каменного пола.";
    }

    @Override
    public String toString() {
        return "Temple";
    }

    @Override
    public void LocationItems() {
        temple.add(templeList, new Item("Стальной меч", "+35% Шанс вызвать кровотечение", Moveable.MOBILE));
        temple.add(templeList, new Item("Серебряный меч", "+47% Шанс критического удара", Moveable.MOBILE));
        temple.add(templeList, new Item("Доспех мастера", "+36% Сопротивление ударному урону", Moveable.STATIONARY));
        temple.add(templeList, new Item("Вода", "+5% Восстановление здоровья", Moveable.MOBILE));
        temple.add(templeList, new Item("Хлеб", "+10% Восстановление здоровья", Moveable.MOBILE));
        temple.add(templeList, new Item("Древний меч Десаада", "+97% Шанс критического удара", Moveable.STATIONARY));

        temple.show(templeList);
    }

    @Override
    public void deleteItem() {
        temple.remove(templeList, templeList.get(5));
        temple.remove(templeList, templeList.get(1));
        temple.remove(templeList, templeList.get(2));
    }

    @Override
    public void showItem() {
        temple.show(templeList);
    }

    @Override
    public void findItem() {
        if(temple.find(templeList, new Item("Древний меч Десаада", "+97% Шанс критического удара", Moveable.STATIONARY))) {
            System.out.println("Есть. Отлично, надо бы добавить его в инвентарь.");
        } else {
            System.out.println("Нет. Придется вернуться к Десааду, для уточнения информации.");
        }
    }
}
