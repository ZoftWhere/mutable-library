package app.zoftwhere.function;

import java.util.Optional;
import java.util.function.Supplier;

public interface PlaceHolder<T> extends Receiver<T>, Supplier<T> {

    Optional<T> optional();

    boolean isPresent();

    default boolean isEmpty() {
        return !isPresent();
    }

    default T orElse(T other) {
        return optional().orElse(other);
    }
}