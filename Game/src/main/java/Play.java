import java.util.*;
import java.util.concurrent.TimeUnit;

public class Play {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Приветствую тебя странник. Назови свое имя.");
        Scanner inputName = new Scanner(System.in);
        Player player = new Player();
        player.setName(inputName.next());
        System.out.println("Меня зовут " + player.getName() + ".");

        System.out.println("Приятно познакомиться " + player.getName() + ", добро пожаловать в Сумрачный собор. " +
                " Меня зовут Десаад, я страж этого храма, если хочешь выжить сделай для меня кое-что." +
                " \nТвоя задача заключается в следующем, по собору раскидано много моих старых вещей, принеси мне мой старый серебряный меч," +
                " и я пропущу тебя дальше. \nМеч уже не в лучшем состоянии, поэтому возьми с собой этот предмет, как найдешь меч скажи \"EDIT\"" +
                " и меч станет как новенький. Я буду ждать тебя здесь, как закончишь возвращайся ко мне.\n");

            Location temple = new Temple("Сумрачный собор");
            player.setLocation(temple);
            System.out.println("Описание локации:");
            System.out.println(temple.getDescriptionLocation());
            System.out.println("\nСписок предметов на локации:");
            temple.LocationItems();
            System.out.println("\nСписок возможных направлений:");
            System.out.println(temple.getDirections());
        System.out.println();

        System.out.println("Инвентарь игрока:");
        player.inventory();
        player.showInventory();
        System.out.println();

        System.out.println("Выбери направление в котором собирешься идти: \nNORTH, SOUTH, EAST, WEST, UP, DOWN");
        try {
            Scanner direction = new Scanner(System.in);
            Direction dir = Direction.valueOf(direction.nextLine());
            player.go(dir);
        } catch (IllegalArgumentException e) {
            System.out.println("Локации не существует. Проверь регистр.");
            System.exit(0);
        }
        System.out.println();

        System.out.println("Осмотр всей локации:");
        player.lookAround();
        System.out.println();

        System.out.println("Проведя осмотр, проверить, есть ли меч Десаада среди предметов, которые мы нашли!");
        TimeUnit.SECONDS.sleep(3);
        System.out.println("Есть ли меч среди найденных предметов?");
        TimeUnit.SECONDS.sleep(3);
        temple.findItem();
        System.out.println();

        System.out.println("Обновленный инвентарь игрока:");
        player.take(new Item("Древний меч Десаада", "+97% Шанс критического удара", Moveable.STATIONARY));
        player.take(new Item("Серебряный меч", "+47% Шанс критического удара", Moveable.MOBILE));
        player.take(new Item("Доспех мастера", "+36% Сопротивление ударному урону", Moveable.STATIONARY));
        player.showInventory();
        System.out.println();

        System.out.println("Обновленный инвентарь локации:");
        temple.deleteItem();
        temple.showItem();
        System.out.println();

        System.out.println("У нас есть нужные предметы для восстановления меча. Давай его восстановим. Готов? Да/Нет");
        Scanner answer = new Scanner(System.in);
        if(answer.nextLine().equals("Да")) {
            System.out.println("Хорошо, тогда сделай все так, как сказал Десаад.");
        } else {
            System.out.println("Подойди, когда будешь готов.");
            System.exit(0);
        }
        System.out.println("Напоминаю, скажи \"EDIT\" и меч станет как новый.");

        if(answer.nextLine().equals("EDIT")) {
            player.use("Древний меч Десаада", "Реликвия Десаада");
        } else {
            System.out.println("Ты по-моему перепутал.");
            System.exit(0);
        }
        player.deleteItemOfInventory("Древний меч Десаада");
        player.deleteItemOfInventory("Реликвия Десаада");
        player.showInventory();
        System.out.println();

        System.out.println("Возвращаемся к Десааду");
        System.out.println("Вот Десаад, держи свой меч.\n");

        System.out.println("Благодарю тебя " + player.getName() + " этот меч вернет мне мое могущество и я " +
                "наконец покину этот храм. Счастливого тебе пути в твоих дальнейших путешествиях. \nПрощай!");
    }
}
