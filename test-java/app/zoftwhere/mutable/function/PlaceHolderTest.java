package app.zoftwhere.mutable.function;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlaceHolderTest {

    @Test
    void testIsEmpty() {
        final var placeHolder = new PlaceHolder<String>() {
            String internal = null;

            @Override
            public Optional<String> optional() {
                return Optional.empty();
            }

            @Override
            public boolean isPresent() {
                return internal != null;
            }

            @Override
            public Void set(String value) {
                internal = value;
                return null;
            }

            @Override
            public String get() {
                return internal;
            }
        };

        assertNotNull(placeHolder);
        assertFalse(placeHolder.isPresent());
        assertTrue(placeHolder.isEmpty());

        placeHolder.set("test");
        assertEquals("test", placeHolder.get());
    }

}
