package app.zoftwhere.function;

import org.junit.jupiter.api.Test;

class ThrowingConsumerTest {

    @Test
    void testTypeThrow() throws Throwable {
        final ThrowingConsumer0 throw0 = ThrowingConsumerTest::accept;
        throw0.accept();

        final ThrowingConsumer1<Integer> throw1 = ThrowingConsumerTest::accept;
        throw1.accept(1);

        final ThrowingConsumer2<Integer, Long> throw2 = ThrowingConsumerTest::accept;
        throw2.accept(1, 2L);

        final ThrowingConsumer3<Integer, Long, Float> throw3 = ThrowingConsumerTest::accept;
        throw3.accept(1, 2L, 3f);

        final ThrowingConsumer4<Integer, Long, Float, Double> throw4 = ThrowingConsumerTest::accept;
        throw4.accept(1, 2L, 3f, 4d);
    }

    @SuppressWarnings({"RedundantThrows", "EmptyMethod"})
    private static void accept() throws Throwable {
    }

    @SuppressWarnings({"RedundantThrows", "EmptyMethod"})
    private static void accept(Integer t1) throws Throwable {
    }

    @SuppressWarnings({"RedundantThrows", "EmptyMethod"})
    private static void accept(Integer t1, Long t2) throws Throwable {
    }

    @SuppressWarnings({"RedundantThrows", "EmptyMethod"})
    private static void accept(Integer t1, Long t2, Float t3) throws Throwable {
    }

    @SuppressWarnings({"RedundantThrows", "EmptyMethod"})
    private static void accept(Integer t1, Long t2, Float t3, Double t4) throws Throwable {
    }
}