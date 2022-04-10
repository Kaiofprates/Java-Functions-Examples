package functionalinterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _Function {

    public static void main(String[] args) {

        int increment = increment(1);
        System.out.println(increment);
        Integer increment2 = incrementByOneFunction.apply(1);
        System.out.println(increment2);

        Integer multiply = multipleBy10.apply(increment2);
        System.out.println(multiply);

        //Function

        Function<Integer, Integer> integerIntegerFunction = incrementByOneFunction.andThen(multipleBy10);
        Integer apply = integerIntegerFunction.apply(1);
        System.out.println(apply);

        // BiFunction

        int i = incrementByOneAndMutiply(4, 100);
        System.out.println(i);

        Integer result = incrementByOneAndMultiplyBiFunction.apply(4, 100);
        System.out.println(result);

    }

    static Function<Integer, Integer> incrementByOneFunction = number -> number + 1;

    static Function<Integer, Integer> multipleBy10 = number -> number * 10;

    static int increment(int numerber) {
        return numerber + 1;
    }

    static BiFunction<Integer, Integer, Integer> incrementByOneAndMultiplyBiFunction =
            (numberToIncrementByOne, numberToMultiplyBy) ->
                    (numberToIncrementByOne + 1) * numberToMultiplyBy;

    static int incrementByOneAndMutiply(int numerber, int numToMutitlyBy) {
        return (numerber + 1) * numToMutitlyBy;
    }
}
