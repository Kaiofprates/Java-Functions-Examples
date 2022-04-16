package combinator;

import java.time.LocalDate;

import static combinator.CustumerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {

        Custumer custumer = new Custumer(
                "Alice",
                "alice@gmail.com",
                "+088123123",
                LocalDate.of(2000, 1, 18)
        );

        /*CustomerValidatorService validator = new CustomerValidatorService();
        boolean valid = validator.isValid(custumer);
        System.out.println(valid);
        */

        ValidationResult result = isEmailValid()
                .and(isPhoneNumberValid())
                .and(isAdult())
                .and(isEmailValid())
                .apply(custumer);
        System.out.println(result);

        if (result != ValidationResult.SUCCESS) {
            throw new IllegalStateException(result.name());
        }

    }
}
