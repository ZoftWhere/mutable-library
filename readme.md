# ZoftWhere Mutable Library
![Language](https://img.shields.io/github/languages/top/ZoftWhere/mutable-library)
[![License](https://img.shields.io/github/license/ZoftWhere/mutable-library)](https://github.com/ZoftWhere/mutable-library/blob/master/license.txt)
![GitHub release (latest by date)](https://img.shields.io/github/v/release/ZoftWhere/mutable-library)
![GitHub Release Date](https://img.shields.io/github/release-date/ZoftWhere/mutable-library)
![GitHub last commit (branch)](https://img.shields.io/github/last-commit/ZoftWhere/mutable-library/master?label=master%20updated)

A library for mutable values.


## Overview

The ZoftWhere Mutable Library provides mutable classes for scopes where final are preferred, or required for lambdas and closures.


## Compiling and Installing the Library

The source code can be compiled with Java language version 8.  It has been tested with Oracle JDK8, JDK11 and JDK12.  The test sources are compiled against JDK 11.

The project is Maven based, so executing the ```mvn install``` should install the library to the local repository (Requires at least JDK11).  It has been tested with Apache Maven v3.6.1.

If the project needs to be installed against JDK8, it can be accomplished by calling the following Maven command:

``` shell script
mvn clean compiler:compile@main-compile-jdk8 jar:jar@main-jar build-helper:add-source@main-jpms source:jar@main-sources javadoc:jar@main-javadoc moditect:add-module-info@main-jpms install:install-file@main-install
``` 


## Examples

### Mutable Value

When you need a final field in your lambda, but you need the value to change later on, using a MutableValue instance
 may be the solution.

``` kotlin
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

```

### Overlay List

A simple default-value-backed list example.

``` kotlin
public class OverlayListExample {

    public static void main(String[] args) {
        
        // A default-value-backed list.
        final var original = Collections.unmodifiableList(List.of("five", "eight", "two"));
        final var proxy = Arrays.asList(new String[original.size()]);
        final var list = new OverlayList<>(proxy, original);

        // Set the first value as ten.
        list.set(0, "ten");

        // Change back to default by setting it as null.
        list.set(0, null);

        // list.get(0) == "five"
        assert list.get(0).equals("five");
    }
```

### Transformer with Zero Argument Consumer

A simple counter example.

``` kotlin
public class TransformerExample0 {

    public static void main(String[] args) {

        // Simple counter.
        var counter = new MutableTransformer0<>(TransformerExample::newLongCounter);
        counter.set(0L);
        counter.accept();
        var count = counter.get();
        assert count == 1;
    }

    private static Consumer0 newLongCounter(MutableTransformer0<Long> internal) {
        return () -> internal.set(internal.get() + 1L);
    }

}
```

### Transformer with One Argument Consumer

A simple single input hash function example.

``` kotlin
public class TransformerExample1 {

    public static void main(String[] args) {

        // Simple single input hash function.
        var chainHash = new MutableTransformer1<>(TransformerExample::newHashFunction);
        chainHash.set(System.currentTimeMillis());
        chainHash.accept(new Random().nextLong());
        var hash = chainHash.get();
        assert hash != null;
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

}
```

### Transformer with Two Argument Consumer

A simple 2-dimension route distance total example.

``` kotlin
public class TransformerExample2 {

    public static void main(String[] args) {

        // Simple 2-dimension route distance total.
        var routeDistance = new MutableTransformer2<>(TransformerExample::newRouteFunction);
        routeDistance.accept(1.0, 1.0);
        routeDistance.accept(4.0, 6.0);
        var distance = routeDistance.get();
        assert distance == 5.0;
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
```


## License

Copyright (C) 2020 ZoftWhere

Licensed under the MIT License