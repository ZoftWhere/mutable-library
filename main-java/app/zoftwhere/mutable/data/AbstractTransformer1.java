package app.zoftwhere.mutable.data;

import app.zoftwhere.mutable.function.Consumer1;
import app.zoftwhere.mutable.function.Transformer1;

import java.util.function.Function;

public class AbstractTransformer1<T, R> extends MutableValue<R> implements Transformer1<T, R> {

    private final Consumer1<T> consumer;

    public AbstractTransformer1(Function<AbstractTransformer1<T, R>, Consumer1<T>> function) {
        super();
        this.consumer = function.apply(this);
    }

    public AbstractTransformer1(Function<AbstractTransformer1<T, R>, Consumer1<T>> function, R value) {
        super(value);
        this.consumer = function.apply(this);
    }

    @Override
    public void accept(T t) {
        this.consumer.accept(t);
    }

}
