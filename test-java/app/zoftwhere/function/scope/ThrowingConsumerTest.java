package app.zoftwhere.function.scope;

import app.zoftwhere.function.ThrowingConsumer0;
import app.zoftwhere.function.ThrowingConsumer1;
import app.zoftwhere.function.ThrowingConsumer2;
import app.zoftwhere.function.ThrowingConsumer3;
import app.zoftwhere.function.ThrowingConsumer4;
import org.junit.jupiter.api.Test;

class ThrowingConsumerTest {

    @Test
    void simpleInterfaceTest() {
        final ThrowingConsumer0 throw0 = ThrowingConsumerTest::accept;
        try { throw0.accept();}
        catch (Throwable ignore) {}

        final ThrowingConsumer1<String> throw1 = ThrowingConsumerTest::accept;
        try { throw1.accept("s1"); }
        catch (Throwable ignore) {}

        final ThrowingConsumer2<String, String> throw2 = ThrowingConsumerTest::accept;
        try { throw2.accept("s1", "s2"); }
        catch (Throwable ignore) {}

        final ThrowingConsumer3<String, String, String> throw3 = ThrowingConsumerTest::accept;
        try { throw3.accept("s1", "s2", "s3"); }
        catch (Throwable ignore) {}

        final ThrowingConsumer4<String, String, String, String> throw4 = ThrowingConsumerTest::accept;
        try { throw4.accept("s1", "s2", "s3", "s4"); }
        catch (Throwable ignore) {}
    }

    private static void accept() throws Throwable {
        throw new Throwable();
    }

    private static void accept(String s1) throws Throwable {
        throw new Throwable();
    }

    private static void accept(String s1, String s2) throws Throwable {
        throw new Throwable();
    }

    private static void accept(String s1, String s2, String s3) throws Throwable {
        throw new Throwable();
    }

    private static void accept(String s1, String s2, String s3, String s4) throws Throwable {
        throw new Throwable();
    }
}