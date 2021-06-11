import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Person {
    public String getFio() {
        return fio;
    }

    public int getAge() {
        return age;
    }

    private String fio;

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int age;

    public Person(String fio, int age) {

        this.fio = fio;
        this.age = age;
    }
    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +" "+ fio +'}';
    }
    }

class ComparePerson implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getAge() - o2.getAge();
        }

    }

class CompareNamePerson implements Comparator<Person> {

    @Override
    public int compare(Person name1, Person name2) {
        return name1.getFio().length() - name2.getFio().length();
    }

}

class Main {

    public static void main(String[] args) {

        ArrayList<Person> list = new ArrayList<Person>();
        list.add(new Person("Царев Дмитрий Олегович", 14));
        list.add(new Person("Иванов Иван Иванович", 40));
        list.add(new Person("Петров Иван Иванович", 50));
        list.add(new Person("Сашка", 3));
        Collections.sort(list, new ComparePerson());
        for (Object person : list) {
            System.out.println(person.toString());
        }
        Stream <Person> stream= list.stream();
        System.out.println(stream.filter(x->x.getAge()>30).collect(Collectors.toList()));

//        System.out.println(list.stream().filter(x->x.getAge()<30).collect(Collectors.toList()));
    }
}

