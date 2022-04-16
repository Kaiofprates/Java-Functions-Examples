package finalsection;

import java.util.function.Function;

public class Lambdas {

    public static void main(String[] args) {
        // Lambdas are anonymous functions

        Function<String, String> upperCaseName = (name) -> name.toUpperCase();
        System.out.println(upperCaseName.apply("joe"));

        Function<String, String> upperCaseName2 = name -> {
            // logic
            if (name.isBlank()) throw new IllegalArgumentException("Name cannot be blank");
            return name.toUpperCase();
        };


    }
}
