package app.zoftwhere.mutable.data;

import app.zoftwhere.mutable.function.Consumer0;
import app.zoftwhere.mutable.function.Transformer0;

import java.util.function.Function;

public class AbstractTransformer0<R> extends MutableValue<R> implements Transformer0<R> {

    private final Consumer0 consumer;

    public AbstractTransformer0(Function<AbstractTransformer0<R>, Consumer0> function) {
        super();
        this.consumer = function.apply(this);
    }

    public AbstractTransformer0(Function<AbstractTransformer0<R>, Consumer0> function, R value) {
        super(value);
        this.consumer = function.apply(this);
    }

    @Override
    public void accept() {
        consumer.accept();
    }

}
