package app.zoftwhere.mutable.function;

public interface ThrowingFunction1<R, T> {

    R accept(T t) throws Throwable;
}
