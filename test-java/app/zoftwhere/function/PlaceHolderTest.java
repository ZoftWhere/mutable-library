package app.zoftwhere.function;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

class PlaceHolderTest {

    @Test
    void testIsEmpty() {
        var placeHolder = new PlaceHolder<String>() {
            @Override
            public Optional<String> optional() {
                return Optional.empty();
            }

            @Override
            public boolean isPresent() {
                return false;
            }

            @Override
            public void set(String s) {
            }

            @Override
            public String get() {
                throw new NoSuchElementException();
            }
        };

        Assertions.assertNotNull(placeHolder);
        Assertions.assertFalse(placeHolder.isPresent());
        Assertions.assertTrue(placeHolder.isEmpty());
    }

}