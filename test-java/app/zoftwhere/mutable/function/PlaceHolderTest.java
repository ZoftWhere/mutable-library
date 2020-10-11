package app.zoftwhere.mutable.function;

import java.util.Optional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlaceHolderTest {

    @Test
    void testIsEmpty() {
        final var placeHolder = new NullableString();

        assertNotNull(placeHolder);
        assertFalse(placeHolder.isPresent());
        assertTrue(placeHolder.isEmpty());

        placeHolder.set("test");
        assertEquals("test", placeHolder.get());
    }

    @Test
    void testGetValue() {
        final var placeHolder = new NullableString();

        assertNull(placeHolder.getValue());
    }

    @Test
    void testOrElse() {
        final var placeHolder = new NullableString();

        assertEquals("else", placeHolder.orElse("else"));
    }

    private static class NullableString implements PlaceHolder<String> {
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
    }

}
