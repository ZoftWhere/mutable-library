package app.zoftwhere.mutable;

import java.util.function.Function;

import app.zoftwhere.function.Consumer3;
import app.zoftwhere.function.Transformer3;

public class MutableTransformer3<T1, T2, T3, R> extends MutableValue<R> implements Transformer3<T1, T2, T3, R> {

    private final Consumer3<T1, T2, T3> consumer;

    public MutableTransformer3(Function<MutableTransformer3<T1, T2, T3, R>, Consumer3<T1, T2, T3>> function) {
        super();
        this.consumer = function.apply(this);
    }

    public MutableTransformer3(Function<MutableTransformer3<T1, T2, T3, R>, Consumer3<T1, T2, T3>> function, R value) {
        super(value);
        this.consumer = function.apply(this);
    }

    @Override
    public void accept(T1 t1, T2 t2, T3 t3) {
        this.consumer.accept(t1, t2, t3);
    }

}
