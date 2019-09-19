package app.zoftwhere.mutable;

import app.zoftwhere.function.Consumer2;
import app.zoftwhere.function.Transformer2;

import java.util.function.Function;

public class MutableTransformer2<T1, T2, R> extends MutableValue<R> implements Transformer2<T1, T2, R> {

    private final Consumer2<T1, T2> consumer;

    public MutableTransformer2(Function<MutableTransformer2<T1, T2, R>, Consumer2<T1, T2>> function) {
        super();
        this.consumer = function.apply(this);
    }

    public MutableTransformer2(Function<MutableTransformer2<T1, T2, R>, Consumer2<T1, T2>> function, R value) {
        super(value);
        this.consumer = function.apply(this);
    }

    @Override
    public void accept(T1 t1, T2 t2) {
        this.consumer.accept(t1, t2);
    }

}
