package functionalinterface;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class _Consumer {

    public static void main(String[] args) {

        Custumer maria = new Custumer("maria", "9999999");
        greetCustumer(maria);

        // Consumer Functional interface

        greetConsumerConsumer.accept(maria);

        greetConsumerConsumerV2.accept(maria,false);

    }

    static Consumer<Custumer> greetConsumerConsumer =
            custumer -> System.out.println("Hello " + custumer.constumerName
            + ", thanks for registering phone number "
            + custumer.costumerPhoneNumer);

    static BiConsumer<Custumer, Boolean> greetConsumerConsumerV2 =
            (custumer, showPhoneNumber) -> System.out.println("Hello " + custumer.constumerName
                    + ", thanks for registering phone number "
                    + (showPhoneNumber ? custumer.costumerPhoneNumer : "********"));


    static void greetCustumer(Custumer custumer) {
        System.out.println("Hello " + custumer.constumerName
                + ", thanks for registering phone number "
                + custumer.costumerPhoneNumer);
    }


    static class Custumer {
        private final String constumerName;
        private final String costumerPhoneNumer;

        Custumer(String constumerName, String costumerPhoneNumer) {
            this.constumerName = constumerName;
            this.costumerPhoneNumer = costumerPhoneNumer;
        }
    }
}
