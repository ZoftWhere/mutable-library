package app.zoftwhere.function;

@SuppressWarnings("unused")
public interface Receiver<T, R> {

    R set(T t);
}
