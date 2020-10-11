package app.zoftwhere.mutable.function;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class ThrowingFunctionTest {

    @Test
    void testFunction() throws Throwable {
        final var value = "void";
        final ThrowingFunction0<String> empty //
            = () -> value;
        assertEquals(value, empty.accept());

        final ThrowingFunction1<Integer, String> single //
            = (i) -> "number" + i;
        assertEquals("number5", single.accept(5));

        final ThrowingFunction2<Integer, Integer, String> twin //
            = (t1, t2) -> "v" + t1 + "." + t2;
        assertEquals("v4.8", twin.accept(4, 8));

        final ThrowingFunction3<Integer, Integer, Integer, String> triplet //
            = (t1, t2, t3) -> "" + (t1 * t2 * t3);
        assertEquals("42", triplet.accept(2, 3, 7));

        final ThrowingFunction4<Integer, Integer, Integer, Integer, String> quartet //
            = (t1, t2, t3, t4) -> "" + (t1 + t2) * (t3 + t4);
        assertEquals("42", quartet.accept(1, 2, 5, 9));
    }

    @Test
    void testTypeThrow() {
        final ThrowingFunction0<String> tf0 //
            = () -> { throw new NullPointerException(); };
        try {
            tf0.accept();
            fail();
        }
        catch (Throwable ignored) {
        }

        final ThrowingFunction1<Integer, String> tf1 //
            = (Integer t1) -> { throw new NullPointerException(); };
        try {
            tf1.accept(1);
            fail();
        }
        catch (Throwable ignored) {
        }

        final ThrowingFunction2<Integer, Long, String> tf2 //
            = (Integer t1, Long t2) -> { throw new NullPointerException(); };
        try {
            tf2.accept(1, 2L);
            fail();
        }
        catch (Throwable ignored) {
        }

        final ThrowingFunction3<Integer, Long, Float, String> tf3 //
            = (Integer t1, Long t2, Float t3) -> { throw new NullPointerException(); };
        try {
            tf3.accept(1, 2L, 3f);
            fail();
        }
        catch (Throwable ignored) {
        }

        final ThrowingFunction4<Integer, Long, Float, Double, String> tf4 //
            = (Integer t1, Long t2, Float t3, Double t4) -> { throw new NullPointerException(); };
        try {
            tf4.accept(1, 2L, 3f, 4d);
            fail();
        }
        catch (Throwable ignored) {
        }
    }

}
