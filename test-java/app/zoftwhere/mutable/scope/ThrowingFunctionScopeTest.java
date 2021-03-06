package app.zoftwhere.mutable.scope;

import app.zoftwhere.mutable.function.ThrowingFunction0;
import app.zoftwhere.mutable.function.ThrowingFunction1;
import app.zoftwhere.mutable.function.ThrowingFunction2;
import app.zoftwhere.mutable.function.ThrowingFunction3;
import app.zoftwhere.mutable.function.ThrowingFunction4;
import org.junit.jupiter.api.Test;

class ThrowingFunctionScopeTest {

    @Test
    void testScope() {
        final ThrowingFunction0<String> tf0 //
            = () -> { throw new Throwable(); };
        try {
            tf0.accept();
        }
        catch (Throwable ignored) {
        }

        final ThrowingFunction1<String, String> tf1 //
            = (t1) -> { throw new Throwable(); };
        try {
            tf1.accept("s1");
        }
        catch (Throwable ignored) {
        }

        final ThrowingFunction2<String, String, String> tf2 //
            = (t1, t2) -> { throw new Throwable(); };
        try {
            tf2.accept("s1", "s2");
        }
        catch (Throwable ignored) {
        }

        final ThrowingFunction3<String, String, String, String> tf3 //
            = (t1, t2, t3) -> { throw new Throwable(); };
        try {
            tf3.accept("s1", "s2", "s3");
        }
        catch (Throwable ignored) {
        }

        final ThrowingFunction4<String, String, String, String, String> tf4 //
            = (t1, t2, t3, t4) -> { throw new Throwable(); };
        try {
            tf4.accept("s1", "s2", "s3", "s4");
        }
        catch (Throwable ignored) {
        }
    }

}
