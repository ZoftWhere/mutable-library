package app.zoftwhere.function.scope;

import app.zoftwhere.function.ThrowingFunction0;
import app.zoftwhere.function.ThrowingFunction1;
import app.zoftwhere.function.ThrowingFunction2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThrowingFunctionTest {

    @Test
    void testTypes() {
        final var value = "void";
        final var empty = new ThrowingFunction0<String>() {
            @Override
            public String accept() {
                return value;
            }
        };
        assertEquals(value, empty.accept());

        var single = new ThrowingFunction1<Integer, String>() {
            @Override
            public String accept(Integer integer) {
                return "number" + integer;
            }
        };
        assertEquals("number5", single.accept(5));

        var twin = new ThrowingFunction2<Integer, Integer, String>() {
            @Override
            public String accept(Integer i1, Integer i2) {
                return "v" + i1 + "." + i2;
            }
        };

        assertEquals("v4.8", twin.accept(4, 8));
    }

}