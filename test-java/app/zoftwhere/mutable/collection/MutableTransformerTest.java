package app.zoftwhere.mutable.collection;

import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MutableTransformerTest {

    @Test
    void checkConstructor() {
        var transformer = (Supplier<String>) null;

        transformer = new MutableTransformer0<>(supplier -> null);
        assertNotNull(transformer);

        transformer = new MutableTransformer0<>(supplier -> null, null);
        assertNotNull(transformer);

        transformer = new MutableTransformer0<>(supplier -> null, "this");
        assertNotNull(transformer);
        assertEquals("this", transformer.get());

        transformer = new MutableTransformer1<>(supplier -> null);
        assertNotNull(transformer);

        transformer = new MutableTransformer1<>(supplier -> null, null);
        assertNotNull(transformer);

        transformer = new MutableTransformer1<>(supplier -> null, "this");
        assertNotNull(transformer);
        assertEquals("this", transformer.get());

        transformer = new MutableTransformer2<>(supplier -> null);
        assertNotNull(transformer);

        transformer = new MutableTransformer2<>(supplier -> null, null);
        assertNotNull(transformer);

        transformer = new MutableTransformer2<>(supplier -> null, "this");
        assertNotNull(transformer);
        assertEquals("this", transformer.get());

        transformer = new MutableTransformer3<>(supplier -> null);
        assertNotNull(transformer);

        transformer = new MutableTransformer3<>(supplier -> null, null);
        assertNotNull(transformer);

        transformer = new MutableTransformer3<>(supplier -> null, "this");
        assertNotNull(transformer);
        assertEquals("this", transformer.get());

        transformer = new MutableTransformer4<>(supplier -> null);
        assertNotNull(transformer);

        transformer = new MutableTransformer4<>(supplier -> null, null);
        assertNotNull(transformer);

        transformer = new MutableTransformer4<>(supplier -> null, "this");
        assertNotNull(transformer);
        assertEquals("this", transformer.get());
    }

    @Test
    void testConsumer() {
        final var m0 = new MutableTransformer0<Integer>(internal -> () -> internal.set(0));
        m0.accept();
        assertEquals(0, m0.get());

        final var m1 = new MutableTransformer1<String, Integer>(internal -> (t1) -> internal.set(1));
        m1.accept("1");
        assertEquals(1, m1.get());

        final var m2 = new MutableTransformer2<String, String, Integer>(internal -> (t1, t2) -> internal.set(2));
        m2.accept("2", "3");
        assertEquals(2, m2.get());

        final var m3 =
            new MutableTransformer3<String, String, String, Integer>(internal -> (t1, t2, t3) -> internal.set(3));
        m3.accept("4", "5", "6");
        assertEquals(3, m3.get());

        final var m4 =
            new MutableTransformer4<String, String, String, String, Integer>(internal -> (t1, t2, t3, t4) -> internal
                .set(4));
        m4.accept("7", "8", "9", "10");
        assertEquals(4, m4.get());
    }

}
