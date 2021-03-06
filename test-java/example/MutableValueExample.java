package example;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;

import app.zoftwhere.mutable.collection.MutableValue;

/**
 * When you need a final field in your lambda, but you need the value to change later on, using a MutableValue instance
 * may be the solution.
 */
public class MutableValueExample {

    private static final MutableValue<String> publicKey = new MutableValue<>(null);

    public static void main(String[] args) {
        Supplier<Map<String, String>> configSupplier = () -> {
            var map = new LinkedHashMap<String, String>();
            map.put("security.key.public", publicKey.get());
            return map;
        };

        new MutableValueExample(configSupplier).run();
    }

    private final Map<String, String> configMap;

    private MutableValueExample(Supplier<Map<String, String>> supplier) {
        // Load from file and/or database;
        publicKey.set("#public");
        configMap = supplier.get();
    }

    private void run() {
        var path = publicKey.get();
        if (path == null) {
            throw new NullPointerException();
        }
        if (path.equals(configMap.get("base.path"))) {
            throw new IllegalStateException();
        }
    }
}
