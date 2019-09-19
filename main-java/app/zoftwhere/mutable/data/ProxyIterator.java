package app.zoftwhere.mutable.data;

import app.zoftwhere.mutable.function.ProxyCollection;

import java.util.Iterator;

public class ProxyIterator<E> implements Iterator<E> {

    private final ProxyCollection<E> proxy;
    private final int size;
    private int index = 0;

    public ProxyIterator(ProxyCollection<E> proxy) {
        this.size = proxy != null ? proxy.size() : 0;
        this.proxy = proxy;
    }

    @Override
    public boolean hasNext() {
        return index < size - 1;
    }

    @Override
    public E next() {
        index++;
        return proxy.get(index);
    }
}
