import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ArrayList<Person> personList = new ArrayList<>();

        personList.add(new Person("name1", "ccc", 31));
        personList.add(new Person("name2", "aaa", 22));
        personList.add(new Person("name3", "bbb", 33));

        // Examples using specific search methods
        List<Person> list = searchPersonByName("name3", personList);
        printList(list);
        list = searchPersonBySurname("aaa", personList);
        printList(list);

        // Examples using interface and classes with a single search method
        list = searchPersonByFilter(new PersonFilterByName("name3"), personList);
        printList(list);
        list = searchPersonByFilter(new PersonFilterBySurname("ccc"), personList);
        printList(list);

        // Examples using lambdas with inference type. In this case classes PersonFilterBy.. could be avoided,
        // just the interface is needed and can be used because it is a functional interface 'interface with a single method'
        list = searchPersonByFilter((p) -> p.getName().equals("name1"), personList);
        printList(list);
        list = searchPersonByFilter((p) -> p.getSurname().equals("aaa"), personList);
        printList(list);

    }

    public static List<Person> searchPersonByName(String name, List<Person> personList) {

        List<Person> filteredList = new ArrayList<>();
        for (Person person : personList) {
            if (person.getName().contentEquals(name)) {
                filteredList.add(person);
            }
        }

        return filteredList;
    }

    public static List<Person> searchPersonBySurname(String surname, List<Person> personList) {

        List<Person> filteredList = new ArrayList<>();
        for (Person person : personList) {
            if (person.getSurname().contentEquals(surname)) {
                filteredList.add(person);
            }
        }
        return filteredList;
    }

    public static List<Person> searchPersonByFilter(PersonFilter personFilter, List<Person> personList) {

        List<Person> filteredList = new ArrayList<>();
        for (Person person : personList) {
            if (personFilter.test(person)) {
                filteredList.add(person);
            }
        }
        return filteredList;
    }

    private static void printList(List<Person> personList) {

        for (Person person : personList) {
            System.out.printf("Person: %s %s %s %n", person.getName(), person.getSurname(), person.getAge());
        }
    }

}
