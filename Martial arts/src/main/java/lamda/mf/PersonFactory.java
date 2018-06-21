package lamda.mf;

import java.util.function.Supplier;

public class PersonFactory {
    private Supplier<Person> supplier;

    public PersonFactory(Supplier<Person> supplier) {
        this.supplier = supplier;
    }

    public Person getPerson() {
        return supplier.get();
    }
}
