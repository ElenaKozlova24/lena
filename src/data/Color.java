package data;

public enum Color {
    RED("Red"),
    BLUE("Blue"),
    GREEN("Green");

    private String name;

    Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
