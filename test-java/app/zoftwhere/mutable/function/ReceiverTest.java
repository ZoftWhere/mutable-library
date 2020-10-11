package app.zoftwhere.mutable.function;

import app.zoftwhere.mutable.collection.MutableValue;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ReceiverTest {

    @Test
    void simpleTest() {
        final var mutable = new MutableValue<>("unset");
        final var receiver = new Receiver<String, Void>() {
            @Override
            public Void set(String value) {
                return mutable.set(value);
            }
        };
        assertEquals("unset", mutable.get());
        receiver.set("set");
        assertEquals("set", mutable.get());
    }

}
