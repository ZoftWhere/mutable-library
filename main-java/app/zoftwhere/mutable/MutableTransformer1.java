package app.zoftwhere.mutable;

import java.util.function.Function;

import app.zoftwhere.function.Consumer1;
import app.zoftwhere.function.Transformer1;

public class MutableTransformer1<T, R> extends MutableValue<R> implements Transformer1<T, R> {

    private final Consumer1<T> consumer;

    public MutableTransformer1(Function<MutableTransformer1<T, R>, Consumer1<T>> function) {
        super();
        this.consumer = function.apply(this);
    }

    public MutableTransformer1(Function<MutableTransformer1<T, R>, Consumer1<T>> function, R value) {
        super(value);
        this.consumer = function.apply(this);
    }

    @Override
    public void accept(T t) {
        this.consumer.accept(t);
    }

}
