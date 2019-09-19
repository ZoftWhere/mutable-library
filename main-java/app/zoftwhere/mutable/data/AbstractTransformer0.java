package app.zoftwhere.mutable.data;

import app.zoftwhere.mutable.function.Transformer0;

public abstract class AbstractTransformer0<R> extends Variable<R> implements Transformer0<R> {

    public AbstractTransformer0() {
        super();
    }

    public AbstractTransformer0(R value) {
        super(value);
    }

    @Override
    public abstract void accept();

}
