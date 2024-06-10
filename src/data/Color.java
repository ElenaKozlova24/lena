package data;

public enum Color {
    RED("red"),
    BLUE("blue"),
    GREEN("green");

    private String name;

    Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
