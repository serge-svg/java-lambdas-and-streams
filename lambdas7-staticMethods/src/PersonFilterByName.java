public class PersonFilterByName implements PersonFilter{

    private String name;

    public PersonFilterByName(String name) {
        this.name = name;
    }

    public boolean test(Person person) {
        return (person.getName().equals(name)) ? true : false;
    }
}
