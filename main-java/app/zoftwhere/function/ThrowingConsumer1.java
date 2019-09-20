package app.zoftwhere.function;

@SuppressWarnings("unused")
public interface ThrowingConsumer1<T> {

    void accept(T t) throws Throwable;
}
