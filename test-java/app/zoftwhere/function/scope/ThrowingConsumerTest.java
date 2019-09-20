package app.zoftwhere.function.scope;

import app.zoftwhere.function.ThrowingConsumer0;
import app.zoftwhere.function.ThrowingConsumer1;
import app.zoftwhere.function.ThrowingConsumer2;
import org.junit.jupiter.api.Test;

class ThrowingConsumerTest {

    @Test
    void simpleInterfaceTest() {
        final var throw0 = new ThrowingConsumer0() {
            @Override
            public void accept() throws Throwable {
                throw new Throwable();
            }
        };

        try {
            throw0.accept();
        }
        catch (Throwable ignore) {}

        final var throw1 = new ThrowingConsumer1<String>() {
            @Override
            public void accept(String value) throws Throwable {
                throw new Throwable(value);
            }
        };

        try {
            throw1.accept("value");
        }
        catch (Throwable ignore) {}

        final var throw2 = new ThrowingConsumer2<String, String>() {
            @Override
            public void accept(String left, String right) throws Throwable {
                throw new Throwable(left + ":" + right);
            }
        };

        try {
            throw2.accept("left", "right");
        }
        catch (Throwable ignore) {}
    }

}