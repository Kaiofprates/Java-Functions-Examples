package functionalinterface;

import java.util.function.Predicate;

public class _Predicate {

    public static void main(String[] args) {
        System.out.println(isPhoneNumerValid("09000987000"));
        System.out.println(isPhoneNumerValid("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("07000000000"));
        System.out.println(isPhoneNumberValidPredicate.test("09000987000"));

        boolean test = isPhoneNumberValidPredicate.and(containsNumber3).test("07000983000");
        System.out.println(test);

        boolean test1 = isPhoneNumberValidPredicate.or(containsNumber3).test("07000000000");
        System.out.println(test1);
    }

    static Predicate<String> isPhoneNumberValidPredicate = number -> number.startsWith("07") && number.length() == 11;

    static boolean isPhoneNumerValid(String phoneNumeber) {
        return phoneNumeber.startsWith("07") && phoneNumeber.length() == 11;
    }

    static Predicate<String> containsNumber3 = phone -> phone.contains("3");
}
