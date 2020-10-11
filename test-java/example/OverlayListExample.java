package example;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import app.zoftwhere.mutable.collection.OverlayList;

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

}
