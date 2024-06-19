package tables;

import animals.Animal;

public class AnimalTable extends AbsTable<Animal> {
    private final String name = "animals";

    public AnimalTable() {
        super(name);
    }
}
