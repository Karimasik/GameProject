public class Item {
    private String name;
    private String description;
    private Moveable moveable;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Item(String name, String description, Moveable moveable) {
        this.name = name;
        this.description = description;
        this.moveable = moveable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Moveable getMoveable() {
        return moveable;
    }

    public void setMoveable(Moveable moveable) {
        this.moveable = moveable;
    }

    @Override
    public String toString() {
        return "Предмет:" +
                "название - " + name +
                ", описание - " + description +
                ", состояние - " + moveable +
                '.';
    }
}
