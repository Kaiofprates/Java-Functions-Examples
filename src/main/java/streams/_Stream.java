package streams;

import imperative.Main;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _Stream {

    public static void main(String[] args) {

        List<Person> people = List.of(
                new Person("Aisha", Gender.FEMALE),
                new Person("Alice", Gender.FEMALE),
                new Person("John", Gender.MALE),
                new Person("Maria", Gender.FEMALE),
                new Person("Alex", Gender.MALE),
                new Person("Pietra", Gender.TRANS)
        );

/*
        Function<Person, String> personStringFunction = person -> person.name;
        people.stream()
                .map(personStringFunction)
                .mapToInt(String::length)
                .forEach(System.out::println);
*/

        Predicate<Person> personPredicate = person -> Gender.FEMALE.equals(person.gender);
        boolean containsFemales = people.stream()
                .anyMatch(personPredicate);
        System.out.println(containsFemales);

        long count = people.stream().count();
        System.out.println(count);

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
        MALE, FEMALE, TRANS
    }

}
