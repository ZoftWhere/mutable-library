package example;

import java.util.Random;

import app.zoftwhere.mutable.collection.MutableTransformer0;
import app.zoftwhere.mutable.collection.MutableTransformer1;
import app.zoftwhere.mutable.collection.MutableTransformer2;
import app.zoftwhere.mutable.collection.MutableValue;
import app.zoftwhere.mutable.function.Consumer0;
import app.zoftwhere.mutable.function.Consumer1;
import app.zoftwhere.mutable.function.Consumer2;

public class TransformerExample {

    public static void main(String[] args) {

        // Simple counter.
        var counter = new MutableTransformer0<>(TransformerExample::newLongCounter);
        counter.set(0L);
        counter.accept();
        var count = counter.get();
        assert count == 1;

        // Simple single input hash function.
        var chainHash = new MutableTransformer1<>(TransformerExample::newHashFunction);
        chainHash.set(System.currentTimeMillis());
        chainHash.accept(new Random().nextLong());
        var hash = chainHash.get();
        assert hash != null;

        // Simple 2-dimension route distance total.
        var routeDistance = new MutableTransformer2<>(TransformerExample::newRouteFunction);
        routeDistance.accept(1.0, 1.0);
        routeDistance.accept(4.0, 5.0);
        var distance = routeDistance.get();
        assert distance == 5.0;
    }

    private static Consumer0 newLongCounter(MutableTransformer0<Long> internal) {
        return () -> internal.set(internal.get() + 1L);
    }

    private static Consumer1<Long> newHashFunction(MutableTransformer1<Long, Long> internal) {
        return (t1) -> {
            var current = internal.get();
            if (current == null) {
                internal.set(t1);
            }
            else if (t1 == null) {
                internal.set(internal.get() ^ 0xffffffffL + 1L);
            }
            else {
                internal.set(internal.get() ^ t1 + 1L);
            }
        };
    }

    private static Consumer2<Double, Double> newRouteFunction(MutableTransformer2<Double, Double, Double> internal) {
        final MutableValue<Double> lastX = new MutableValue<>(0.0d);
        final MutableValue<Double> lastY = new MutableValue<>(0.0d);
        return (x, y) -> {
            if (internal.isEmpty()) {
                lastX.set(x);
                lastY.set(y);
                internal.set(0.0d);
            }
            else {
                var current = internal.get();
                var dx = lastX.get() - x;
                var dy = lastY.get() - y;
                internal.set(current + Math.sqrt(dx * dx + dy * dy));
            }
        };
    }

}
