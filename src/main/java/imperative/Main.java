package imperative;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Aisha", Gender.FEMALE),
                new Person("Alice", Gender.FEMALE),
                new Person("Alex", Gender.MALE));
        
        // Imperative approache

        System.out.println("Imperative");
        List<Person> females = new ArrayList<>();

        for (Person person : people) {
            if(Gender.FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }
        for (Person female: females) {
            System.out.println(female);
        }
        
        // Declarative approach

        System.out.println("Declarative");

        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);

        List<Person> females2 = people.stream().filter(personPredicate)
                .collect(Collectors.toList());
        females2.forEach(System.out::println);

    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum  Gender {
        MALE, FEMALE
    }
}
