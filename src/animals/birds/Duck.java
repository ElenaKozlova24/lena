package animals.birds;

import animals.Animal;

public class Duck extends Animal implements Flying {
    void say () {
    System.out.println("кря");
}

    @Override
    public void flying() {
            System.out.println("я лечу");
    }
}
