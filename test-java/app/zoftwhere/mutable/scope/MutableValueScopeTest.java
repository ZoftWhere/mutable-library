package app.zoftwhere.mutable.scope;

import app.zoftwhere.mutable.MutableValue;
import org.junit.jupiter.api.Test;

class MutableValueScopeTest {

    @Test
    void testOfNullable() {
        MutableValue.<String>ofNullable(null).set("");
    }

    @Test
    void testEmpty() {
        MutableValue.<String>empty().set("");
    }
}
