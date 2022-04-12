package combinator;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Custumer custumer = new Custumer(
                "Alice",
                "alice@gmail.com",
                "+088123123",
                LocalDate.of(2000, 1, 18)
        );

        CustomerValidatorService validator = new CustomerValidatorService();
        boolean valid = validator.isValid(custumer);
        System.out.println(valid);

    }
}
