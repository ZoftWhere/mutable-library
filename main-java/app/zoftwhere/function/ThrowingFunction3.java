package app.zoftwhere.function;

@SuppressWarnings({"RedundantThrows", "RedundantSuppression", "unused"})
public interface ThrowingFunction3<T1, T2, T3, R> {

    R accept(T1 t1, T2 t2, T3 t3) throws Throwable;
}
