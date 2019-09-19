package app.zoftwhere.mutable;

import app.zoftwhere.function.Consumer0;
import app.zoftwhere.function.Transformer0;

import java.util.function.Function;

public class MutableTransformer0<R> extends MutableValue<R> implements Transformer0<R> {

    private final Consumer0 consumer;

    public MutableTransformer0(Function<MutableTransformer0<R>, Consumer0> function) {
        super();
        this.consumer = function.apply(this);
    }

    public MutableTransformer0(Function<MutableTransformer0<R>, Consumer0> function, R value) {
        super(value);
        this.consumer = function.apply(this);
    }

    @Override
    public void accept() {
        consumer.accept();
    }

}
