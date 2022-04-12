package optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
   /*     Object value = Optional.ofNullable(null)
                .orElseThrow(() -> {
                    IllegalStateException exception = new IllegalStateException("exception");
                    return exception;
                });
        System.out.println(value);*/

        Optional.ofNullable(null)
                .ifPresent(System.out::println);

        Optional.ofNullable("boladao@gmail.com")
                .ifPresentOrElse(
                        email -> System.out.println("Sending email to " + email),
                        () -> {
                            System.out.println("Cannot send email");
                        }
                );

    }
}
