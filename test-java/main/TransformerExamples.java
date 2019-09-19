package main;

import app.zoftwhere.mutable.data.AbstractTransformer0;
import app.zoftwhere.mutable.data.AbstractTransformer1;
import app.zoftwhere.mutable.data.AbstractTransformer2;

public class TransformerExamples {

    public static void main(String[] args) {
        {
            var transformer = new AbstractTransformer0<Long>() {
                @Override
                public void accept() {
                    set(System.nanoTime());
                }
            };
            transformer.accept();
        }
        {
            var transformer = new AbstractTransformer1<Long, Long>(0L) {
                @Override
                public void accept(Long value) {
                    set(get() ^ value);
                }
            };
            transformer.accept(System.currentTimeMillis());
        }
        {
            var transformer = new AbstractTransformer2<Long, Long, Long>(0L) {
                @Override
                public void accept(Long t1, Long t2) {
                    set(t1 * t2);
                }
            };
            transformer.accept(3L, 5L);
        }
    }

}
