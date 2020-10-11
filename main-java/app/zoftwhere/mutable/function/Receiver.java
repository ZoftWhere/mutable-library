package app.zoftwhere.mutable.function;

@SuppressWarnings("unused")
public interface Receiver<T, R> {

    R set(T t);
}
