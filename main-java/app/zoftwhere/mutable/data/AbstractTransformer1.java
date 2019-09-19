package app.zoftwhere.mutable.data;

import app.zoftwhere.mutable.function.Transformer1;

public abstract class AbstractTransformer1<T, R> extends Variable<R> implements Transformer1<T, R> {

    public AbstractTransformer1() {
        super();
    }

    public AbstractTransformer1(R value) {
        super(value);
    }

    public abstract void accept(T t);

}
