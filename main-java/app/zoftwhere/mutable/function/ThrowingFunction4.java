package app.zoftwhere.mutable.function;

public interface ThrowingFunction4<T1, T2, T3, T4, R> {

    R accept(T1 t1, T2 t2, T3 t3, T4 t4) throws Throwable;
}