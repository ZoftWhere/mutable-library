package app.zoftwhere.mutable.collection;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class MutableValueTest {

    @Test
    void testConstructor() {
        var value = "new value";
        var actual = new MutableValue<>(value);
        assertNotNull(value);
        assertNotNull(actual);
        assertNotNull(actual.get());
        assertEquals(value, actual.get());
    }

    @Test
    void testOfNullable() {
        var value = "new value";
        var actual = MutableValue.ofNullable(value);
        assertNotNull(value);
        assertNotNull(actual);
        assertNotNull(actual.get());
        assertEquals(value, actual.get());
    }

    @Test
    void testOptional() {
        assertFalse(new MutableValue<String>().optional().isPresent());
        assertTrue(new MutableValue<>("").optional().isPresent());

        var input = "Mutator";
        var fixed = new MutableValue<String>();
        fixed.set(input);
        assertTrue(fixed.optional().isPresent());
        assertEquals(input, fixed.optional().get());
    }

    @Test
    void testEmpty() {
        final var value = MutableValue.<String>empty();
        assertNull(value.getValue());
        assertTrue(value.isEmpty());
    }

    @Test
    void testGetValue() {
        final var value = MutableValue.<String>empty();
        value.set("Hello");
        assertEquals("Hello", value.getValue());
    }

    @Test
    void testOrElse() {
        String output;
        output = new MutableValue<String>().orElse("else");
        assertEquals("else", output);

        output = new MutableValue<>((String) null).orElse("else");
        assertEquals("else", output);

        output = new MutableValue<>("this").orElse("else");
        assertEquals("this", output);
    }

    @Test
    void testNull() {
        try {
            new MutableValue<String>().get();
            fail("This should throw an exception.");
        }
        catch (NoSuchElementException ignore) {
        }
    }

    @Test
    void testIsPresent() {
        assertFalse(new MutableValue<String>().isPresent());
        assertTrue(new MutableValue<>("").isPresent());
    }

    @Test
    void testIsEmpty() {
        assertTrue(new MutableValue<String>().isEmpty());
        assertFalse(new MutableValue<>("").isEmpty());
    }

}
