package app.zoftwhere.mutable.scope;

import app.zoftwhere.mutable.MutableTransformer0;
import app.zoftwhere.mutable.MutableTransformer1;
import app.zoftwhere.mutable.MutableTransformer2;
import app.zoftwhere.mutable.MutableTransformer3;
import app.zoftwhere.mutable.MutableTransformer4;
import org.junit.jupiter.api.Test;

class MutableTransformerScopeTest {

    @Test
    void testScope() {
        final var v0 = 0;
        new MutableTransformer0<>( //
            internal -> () -> internal.set(0)).accept();
        new MutableTransformer0<>( //
            internal -> () -> internal.set(0), v0).accept();

        final var v1 = 1;
        new MutableTransformer1<String, Integer>( //
            internal -> (String t1) -> internal.set(1)).accept("1");
        new MutableTransformer1<String, Integer>( //
            internal -> (String t1) -> internal.set(1), v1).accept("1");

        final var v2 = 2;
        new MutableTransformer2<String, String, Integer>( //
            internal -> (t1, t2) -> internal.set(2)).accept("2", "3");
        new MutableTransformer2<String, String, Integer>( //
            internal -> (t1, t2) -> internal.set(2), v2).accept("2", "3");

        final var v3 = 3;
        new MutableTransformer3<String, String, String, Integer>( //
            internal -> (t1, t2, t3) -> internal.set(3)).accept("4", "5", "6");
        new MutableTransformer3<String, String, String, Integer>( //
            internal -> (t1, t2, t3) -> internal.set(3), v3).accept("4", "5", "6");

        final var v4 = 4;
        new MutableTransformer4<String, String, String, String, Integer>( //
            internal -> (t1, t2, t3, t4) -> internal.set(4)).accept("7", "8", "9", "10");
        new MutableTransformer4<String, String, String, String, Integer>( //
            internal -> (t1, t2, t3, t4) -> internal.set(4), v4).accept("7", "8", "9", "10");
    }

}