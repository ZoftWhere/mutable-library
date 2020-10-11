package app.zoftwhere.mutable.scope;

import app.zoftwhere.mutable.function.ThrowingConsumer0;
import app.zoftwhere.mutable.function.ThrowingConsumer1;
import app.zoftwhere.mutable.function.ThrowingConsumer2;
import app.zoftwhere.mutable.function.ThrowingConsumer3;
import app.zoftwhere.mutable.function.ThrowingConsumer4;
import org.junit.jupiter.api.Test;

class ThrowingConsumerScopeTest {

    @Test
    void simpleInterfaceTest() {
        final ThrowingConsumer0 throw0 = ThrowingConsumerScopeTest::accept;
        try { throw0.accept(); }
        catch (Throwable ignore) {}

        final ThrowingConsumer1<String> throw1 = ThrowingConsumerScopeTest::accept;
        try { throw1.accept("s1"); }
        catch (Throwable ignore) {}

        final ThrowingConsumer2<String, String> throw2 = ThrowingConsumerScopeTest::accept;
        try { throw2.accept("s1", "s2"); }
        catch (Throwable ignore) {}

        final ThrowingConsumer3<String, String, String> throw3 = ThrowingConsumerScopeTest::accept;
        try { throw3.accept("s1", "s2", "s3"); }
        catch (Throwable ignore) {}

        final ThrowingConsumer4<String, String, String, String> throw4 = ThrowingConsumerScopeTest::accept;
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
