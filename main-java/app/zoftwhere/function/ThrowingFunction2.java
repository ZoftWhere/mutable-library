package app.zoftwhere.function;

public interface ThrowingFunction2<T1, T2, R> {

    R accept(T1 t1, T2 t2) throws Throwable;
}
