package app.zoftwhere.mutable.collection;

import java.util.function.Function;

import app.zoftwhere.mutable.function.Consumer4;
import app.zoftwhere.mutable.function.Transformer4;

public class MutableTransformer4<T1, T2, T3, T4, R> extends MutableValue<R> implements Transformer4<T1, T2, T3, T4, R> {

    private final Consumer4<T1, T2, T3, T4> consumer;

    public MutableTransformer4(Function<MutableTransformer4<T1, T2, T3, T4, R>, Consumer4<T1, T2, T3, T4>> function)
    {
        super();
        this.consumer = function.apply(this);
    }

    public MutableTransformer4(Function<MutableTransformer4<T1, T2, T3, T4, R>, Consumer4<T1, T2, T3, T4>> function,
        R value)
    {
        super(value);
        this.consumer = function.apply(this);
    }

    @Override
    public void accept(T1 t1, T2 t2, T3 t3, T4 t4) {
        this.consumer.accept(t1, t2, t3, t4);
    }

}
