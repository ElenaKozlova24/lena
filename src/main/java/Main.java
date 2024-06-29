import animals.Animal;
import animals.pets.Cat;
import animals.pets.Dog;
import animals.birds.Duck;
import data.Color;
import data.Command;
import tables.AbsTable;
import tables.AnimalTable;

import java.sql.SQLException;
import java.util.*;

public class Main {
    private static AbsTable animalTable = new AnimalTable();

    public static void main(String... arcs) throws SQLException {
        ArrayList animals = new ArrayList();
        while (true) {
            Animal animal;
            System.out.println("Введите add/list/exit");
            Scanner input = new Scanner(System.in);
            String text = input.nextLine().trim().toUpperCase(Locale.ROOT);

            Command command = null;
            for (Command cmd : Command.values()) {
                if (cmd.name().equalsIgnoreCase(text)) {
                    command = cmd;
                    break;
                }
            }
            if (command == null) {
                System.out.println("неправильная команда");
                continue;
            }

            if (command == Command.ADD) {
                System.out.println(("Какое животное вы хотите создать?"));
                String type = input.nextLine();
                if (type.equalsIgnoreCase("собака")) {
                    animal = new Dog();

                } else if (type.equalsIgnoreCase("кошка")) {
                    animal = new Cat();

                } else if (type.equalsIgnoreCase("утка")) {
                    animal = new Duck();

                } else {
                    System.out.println("Такого животного нет в списке");
                    continue;

                }
                System.out.println("Введите имя");
                String name = input.nextLine().trim();
                animal.setName(name);

                System.out.println("Введите возраст");
                int age_int;
                while (true) {
                    String age = input.nextLine().trim();
                    age_int = Integer.parseInt(age);
                    if (age_int > 0 && age_int < 1000) {
                        animal.setAge(age_int);
                        break;
                    } else {
                        System.out.println("Неверный возраст. Пожалуйста, введите корректный возраст.");
                    }
                }

                System.out.println("Введите вес");
                String weight = input.nextLine().trim();
                animal.setWeight(Float.parseFloat(weight));
                Color color = null;
                while (true) {
                    System.out.println("Введите цвет");
                    color = Color.getFromName(input.nextLine().trim());
                    if (color != null) {
                        animal.setColor(color);
                        break;
                    } else {
                        System.out.println("Неверный цвет. Пожалуйста, введите корректный цвет.");
                        for (Color c : Color.values()) {
                            System.out.println(c.getName());
                        }
                    }
                }
                animals.add(animal);
                List<String> params = new ArrayList<>();
                params.add("id INT NOT NULL PRIMARY KEY AUTO_INCREMENT");
                params.add("name VARCHAR(50) NOT NULL");
                params.add ("age INT NOT NUL");
                params.add( "weight FLOAT NOT NULL");
                params.add ("color VARCHAR(20) DEFAULT NULL");
                params.add ("type VARCHAR(50) NOT NULL");

                animalTable.create(params);
                animalTable.insert(name, age_int, Float.parseFloat(weight), color, type);

            } else if (command == Command.LIST) {
                System.out.println("Ваши животные: ");
                for (Object myAnimal : animals) {
                    System.out.println(myAnimal);
                }


            } else if (command == Command.EXIT) {
                System.exit(0);
            } else {
                System.out.println("Неизвестная команда");
            }

        }
    }

}
