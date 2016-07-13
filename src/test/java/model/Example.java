package model;

public class Example {

    private String name;

    public Example() {
        name = "";
    }

    public Example(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "My name is: " + name;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        if (obj instanceof Example) {
            if (((Example) obj).getName().equalsIgnoreCase(this.name)) {
                result = true;
            }
        }

        return result;
    }
}
