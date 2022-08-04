import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonFilterBySurname implements PersonFilter {

    private String surname;

    @Override
    public boolean test(Person person) {
        return (person.getSurname().equals(surname)) ? true : false;
    }
}
