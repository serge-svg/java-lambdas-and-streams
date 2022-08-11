import java.util.function.Predicate;

public class PersonFilterBySurname implements Predicate<Person> {

    private String surname;

    public PersonFilterBySurname(String surname) {
        this.surname = surname;
    }

    public boolean test(Person person) {
        return (person.getSurname().equals(surname)) ? true : false;
    }
}
