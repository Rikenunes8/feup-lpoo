import java.net.ServerSocket;
import java.util.Objects;

public abstract class Person extends User implements  Comparable<Person>{
    private String name;
    private int age;

    public Person(String name) {
        super(name+0);
        this.name = name;
        this.age = 0;
    }

    public Person(String name, int age) {
        super(name+age);
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public abstract String toString();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Person o) {
        return name.compareTo(o.getName());
    }
}
