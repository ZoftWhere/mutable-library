package app.zoftwhere.function;

import java.util.function.Consumer;

public interface Consumer1<T> extends Consumer<T> {

    void accept(T t);
}
