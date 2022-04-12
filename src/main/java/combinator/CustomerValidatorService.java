package combinator;

import java.time.LocalDate;
import java.time.Period;

public class CustomerValidatorService {

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }
    private boolean isPhoneNumberValid(String phoneNumer) {
        return phoneNumer.startsWith("+0");
    }
    private boolean isAdult(LocalDate dob) {
        return Period.between(dob, LocalDate.now()).getYears() > 16;
    }

    public boolean isValid(Custumer custumer) {
        return isEmailValid(custumer.getEmail())
                && isPhoneNumberValid(custumer.getPhoneNumber())
                && isAdult(custumer.getDob());
    }

}
