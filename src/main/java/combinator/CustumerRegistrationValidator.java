package combinator;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

import static combinator.CustumerRegistrationValidator.ValidationResult.*;

public interface CustumerRegistrationValidator extends Function<Custumer, CustumerRegistrationValidator.ValidationResult> {

    static CustumerRegistrationValidator isEmailValid() {
        return custumer ->
            custumer.getEmail().contains("@") ?
                    ValidationResult.SUCCESS : PHONE_NUMBER_NOT_VALID;
    }

    static CustumerRegistrationValidator isPhoneNumberValid() {
        return custumer ->
                custumer.getPhoneNumber().startsWith("+0") ?
                        SUCCESS : EMAIL_NOT_VALID;
    }

    static CustumerRegistrationValidator isAdult() {
        return custumer ->
                Period.between(custumer.getDob(), LocalDate.now()).getYears() > 16 ?
                       SUCCESS : IS_NOT_AN_ADULT;
    }
    enum ValidationResult{
        SUCCESS,
        PHONE_NUMBER_NOT_VALID,
        EMAIL_NOT_VALID,
        IS_NOT_AN_ADULT
    }

    default CustumerRegistrationValidator and (CustumerRegistrationValidator other) {
        return custumer -> {
            ValidationResult result = this.apply(custumer);
            return result.equals(SUCCESS)  ? other.apply(custumer) : result;
        };
    }

}
