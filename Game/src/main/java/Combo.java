public class Combo {
    private Item object = new Item("Древний меч Десаада", "+97% Шанс критического удара", Moveable.STATIONARY);
    private Item subject = new Item("Реликвия Десаада", "Восстановление оружия");
    private Item result = new Item("Восстановленный меч Десаада", "+97% Шанс критического удара", Moveable.STATIONARY);
    private String message = "Меч полностью восстановлен.";

    public Item getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }
}
