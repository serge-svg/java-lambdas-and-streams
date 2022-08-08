import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList<Person> personList = new ArrayList<>();
        personList.add(new Person("name1", "ccc", 31));
        personList.add(new Person("name2", "aaa", 22));
        personList.add(new Person("name3", "bbb", 33));

        System.out.println("Sort by comparing ages with Comparable interface");
        Collections.sort(personList);
        printList(personList);

        System.out.println("Sort by comparing names with Comparator interface");
        personList.sort(new ComparatorName());
        printList(personList);

        System.out.println("Sort by comparing surnames with Comparator interface");
        personList.sort(new ComparatorSurname());
        printList(personList);

        System.out.println("Sort by comparing ages with an anonymous class");
        personList.sort(new Comparator<Person>() {
            public int compare(Person person1, Person person2) {
                int result = 0;
                if (person1. getAge() > person2.getAge()) {
                    result = 1;
                } else if (person1.getAge() < person2.getAge()) {
                    result = -1;
                }
                return result;
            }
        });
        printList(personList);

        System.out.println("Sort by comparing ages with a lambda expression");
        personList.sort((Person person1, Person person2) -> {
            int result = 0;
            if (person1.getAge() > person2.getAge()) {
                result = 1;
            } else if (person1.getAge() < person2.getAge()) {
                result = -1;
            }
            return result;
        });
        printList(personList);

        System.out.println("Sort by comparing names with a lambda expression");
        personList.sort((Person person1, Person person2) -> {
            return person1.getName().compareTo(person2.getName());
        });
        printList(personList);

        System.out.println("Sort by comparing names with a lambda expression,\nusing type inference and  a lambda expression simplified");
        personList.sort((person1, person2) -> person1.getName().compareTo(person2.getName()));
        printList(personList);

        System.out.println("Sort by comparing names with a lambda expression,\nusing Comparator.comparing with method reference");
        personList.sort(Comparator.comparing(Person::getName));
        printList(personList);

    }

    private static void printList(List<Person> personList) {
        for (Person p : personList) {
            System.out.printf("person %s %s %s %n", p.getName(), p.getSurname(), p.getAge());
        }
    }

}
