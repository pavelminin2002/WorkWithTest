import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


public class CalcTest {

    @ParameterizedTest
    @MethodSource("sumListProvider")
    public void sumTest(int a, int b, int expect) {


        int res = Calc.sum(a, b);

        Assertions.assertEquals(expect, res);
    }

    public static Stream<Arguments> sumListProvider() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(3, 1, 4),
                Arguments.of(0, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("subListProvider")
    public void subtractTest(int a, int b, int expect) {

        int res = Calc.subtract(a, b);

        Assertions.assertEquals(expect, res);
    }

    public static Stream<Arguments> subListProvider() {
        return Stream.of(
                Arguments.of(1, 2, -1),
                Arguments.of(3, 1, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("multListProvider")
    public void multTest(int a, int b, int expect) {


        int res = Calc.mult(a, b);

        Assertions.assertEquals(expect, res);
    }

    public static Stream<Arguments> multListProvider() {
        return Stream.of(
                Arguments.of(1, 2, 2),
                Arguments.of(3, 1, 3),
                Arguments.of(0, 0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("devListProvider")
    public void devTest(int a, int b, int expect) {


        int res = Calc.dev(a, b);

        Assertions.assertEquals(expect, res);
    }

    public static Stream<Arguments> devListProvider() {
        return Stream.of(
                Arguments.of(1, 2, 0),
                Arguments.of(3, 1, 3),
                Arguments.of(5, 2, 2)
        );
    }

    @Test
    public void withZeroDevTest(){
        int a = 0, b = 0;
        Class<ArithmeticException> expect = ArithmeticException.class;

        Executable executable = ()->Calc.dev(a, b);

        Assertions.assertThrowsExactly(expect, executable);

    }

}
