package app.zoftwhere.function;

@SuppressWarnings({"RedundantThrows", "RedundantSuppression", "unused"})
public interface ThrowingFunction2<T1, T2, R> {

    R accept(T1 t1, T2 t2) throws Throwable;
}
