package app.zoftwhere.function;

@SuppressWarnings("unused")
public interface ThrowingConsumer2<T1, T2> {

    void accept(T1 t1, T2 t2) throws Throwable;
}
