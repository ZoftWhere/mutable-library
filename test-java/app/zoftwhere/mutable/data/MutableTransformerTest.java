package app.zoftwhere.mutable.data;

import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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
    }

}