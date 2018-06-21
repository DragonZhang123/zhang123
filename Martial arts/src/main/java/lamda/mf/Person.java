package lamda.mf;

import org.jetbrains.annotations.NotNull;

public class Person implements Comparable<Person>{
    private String name;


    public  int compare(Person p1,Person p2){
        return p2.getName().compareTo(p1.getName());
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(@NotNull Person o) {
        return o.getName().compareTo(this.getName());
    }
}
