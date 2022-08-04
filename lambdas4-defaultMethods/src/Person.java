import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {

    private String name;
    private String surname;
    private int age;


    public static boolean isRetired(Person person) {
        return person.getAge() > 65;
    }
}
