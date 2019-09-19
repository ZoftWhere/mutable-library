package app.zoftwhere.function;

public interface ThrowingFunction2<R, T1, T2> {

    R accept(T1 t1, T2 t2) throws Throwable;
}
