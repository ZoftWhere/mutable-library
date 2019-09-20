package app.zoftwhere.function;

import app.zoftwhere.mutable.MutableValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReceiverTest {

    @Test
    void simpleTest() {
        final var mutable = new MutableValue<>("unset");
        final var receiver = new Receiver<String>() {
            @Override
            public void set(String value) {
                mutable.set(value);
            }
        };
        assertEquals("unset", mutable.get());
        receiver.set("set");
        assertEquals("set", mutable.get());
    }

}