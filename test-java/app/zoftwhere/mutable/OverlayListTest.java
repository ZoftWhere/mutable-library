package app.zoftwhere.mutable;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

class OverlayListTest {

    @Test
    void todoCreateRealTest() {
        final var backArray = new String[] {"back", null};
        final var backList = Arrays.asList(backArray);
        final var frontArray = new String[] {null, null};
        final var frontList = Arrays.asList(frontArray);

        final var constructor = new OverlayList<>(frontArray, backArray);
        assertNotNull(constructor);

        final var overlay = new OverlayList<>(frontList, backList);
        assertNotNull(overlay);
        assertFalse(overlay.isEmpty());
        assertTrue(overlay.contains(null));

        assertEquals(frontList.size(), overlay.size());
        assertFalse(overlay.isEmpty());

        overlay.set(0, null);
        overlay.set(0, null);
        overlay.set(0, "1");
        assertEquals("1", overlay.get(0));

        overlay.set(0, "1");
        overlay.set(0, "1");
        overlay.set(0, null);
        assertEquals("back", overlay.get(0));

        assertEquals(backList.indexOf("back"), overlay.indexOf("back"));
        assertEquals(backList.lastIndexOf("back"), overlay.lastIndexOf("back"));

        assertEquals(backList.contains("back"), overlay.contains("back"));
        assertTrue(overlay.containsAll(backList));

        try {
            overlay.add("next");
            fail("overlay.list.expected.unsupported.operation.exception");
        }
        catch (UnsupportedOperationException ignore) {}

        try {
            overlay.add(0, "next");
            fail("overlay.list.expected.unsupported.operation.exception");
        }
        catch (UnsupportedOperationException ignore) {}

        try {
            overlay.addAll(List.of("1", "2", "3"));
            fail("overlay.list.expected.unsupported.operation.exception");
        }
        catch (UnsupportedOperationException ignore) {}

        try {
            overlay.addAll(0, List.of("1", "2", "3"));
            fail("overlay.list.expected.unsupported.operation.exception");
        }
        catch (UnsupportedOperationException ignore) {}

        try {
            overlay.remove("next");
            fail("overlay.list.expected.unsupported.operation.exception");
        }
        catch (UnsupportedOperationException ignore) {}

        try {
            overlay.remove(0);
            fail("overlay.list.expected.unsupported.operation.exception");
        }
        catch (UnsupportedOperationException ignore) {}

        try {
            overlay.removeIf(s -> true);
            fail("overlay.list.expected.unsupported.operation.exception");
        }
        catch (UnsupportedOperationException ignore) {}

        try {
            overlay.removeAll(List.of("1", "2", "3"));
            fail("overlay.list.expected.unsupported.operation.exception");
        }
        catch (UnsupportedOperationException ignore) {}

        // Replace all.
        overlay.set(0, "1");
        assertEquals("1", overlay.get(0));
        overlay.replaceAll(s -> null);
        assertEquals("back", overlay.get(0));

        try {
            overlay.retainAll(List.of("1", "2", "3"));
            fail("overlay.list.expected.unsupported.operation.exception");
        }
        catch (UnsupportedOperationException ignore) {}

        try {
            overlay.clear();
            fail("overlay.list.expected.unsupported.operation.exception");
        }
        catch (UnsupportedOperationException ignore) {}

        try {
            //noinspection RedundantOperationOnEmptyContainer
            overlay.sort(Comparator.naturalOrder());
            fail("overlay.list.expected.unsupported.operation.exception");
        }
        catch (UnsupportedOperationException ignore) {}

        assertNotNull(overlay.subList(0, 1));

        var objectArray = overlay.toArray();
        assertNotNull(objectArray);

        var stringArray = overlay.toArray(new String[1]);
        assertNotNull(stringArray);

        assertNotNull(overlay.iterator());
        assertNotNull(overlay.listIterator());
        assertNotNull(overlay.listIterator(0));
        assertNotNull(overlay.spliterator());
        assertNotNull(overlay.stream());
        assertNotNull(overlay.parallelStream());
    }

}