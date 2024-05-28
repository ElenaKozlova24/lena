package animals;

import data.Color;

public class Animal {

    String name;
    int age;
    float weight;
    Color color = null;

    String getName() {
        return this.name;
    }
String getAge () {
        int ostatok = this.age % 10;
        if (ostatok == 1) {
            return this.age + " год";
        }
        if (ostatok > 1 && ostatok < 5 ) {
            return this.age + " года";
        }
        if (ostatok == 0 || ostatok >= 5) {
            return this.age + " лет";
        }
return null;

}

float getWeight() {
        return this.weight;

}

Color getColor() {
        return this.color;
}

public void setName(String name) {
        this.name = name;
}

public void setAge(int age) {
        this.age = age;
}
public void setWeight(float weight) {
        this.weight = weight;
}

public void setColor(Color color) {
        this.color = color;
}
void say () {
    System.out.println("я говорю");
}

    void drink () {
        System.out.println("я пью");
    }

    void go () {
        System.out.println("я иду");
    }

    void eat () {
        System.out.println("я ем");
    }
    public String  toString ()
    {
        return "Привет! Меня зовут " + this.name + "! Мне " + getAge() +
                ", я вешу " + this.weight + ", мой цвет " + color+".";
    }




}