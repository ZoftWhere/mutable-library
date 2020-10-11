package app.zoftwhere.mutable.function;

public interface ThrowingFunction1<T, R> {

    R accept(T t) throws Throwable;
}
