package lamda.stream;

public class Dish {
    String name;
    int cs;

    public Dish(String name, int cs) {
        this.name = name;
        this.cs =cs;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCs() {
        return cs;
    }

    public void setCs(int cs) {
        this.cs = cs;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", cs='" + cs + '\'' +
                '}';
    }
}
