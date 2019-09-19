package app.zoftwhere.mutable.data;

import app.zoftwhere.mutable.function.Transformer2;

public abstract class AbstractTransformer2<T1, T2, R> extends Variable<R> implements Transformer2<T1, T2, R> {

    public AbstractTransformer2() {
        super();
    }

    public AbstractTransformer2(R value) {
        super(value);
    }

    @Override
    public abstract void accept(T1 t1, T2 t2);

}
