import animals.Animal;
import animals.pets.Cat;
import animals.pets.Dog;
import animals.birds.Duck;
import data.Color;
import data.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String... arcs) {
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
                while (true) {
                    System.out.println("Введите цвет");
                    Color color = Color.getFromName(input.nextLine().trim());
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
