package app.zoftwhere.mutable.data;

import app.zoftwhere.mutable.function.ProxyCollection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class OverlayList<E> implements List<E>, ProxyCollection<E> {

    private final List<E> front;

    private final List<E> back;

    private final List<E> proxy;

    public OverlayList(List<E> front, List<E> back) {
        this.front = front;
        this.back = back;
        this.proxy = new ArrayList<>(front.size());
        this.proxy.addAll(front);
        for (int i = 0; i <= proxy.size(); i++) {
            if (proxy.get(i) == null) {
                proxy.set(i, back.get(i));
            }
        }
    }

    @Override
    public int size() {
        return proxy.size();
    }

    @Override
    public boolean isEmpty() {
        return proxy.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return proxy.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return new ProxyIterator<>(this);
    }

    @Override
    public Object[] toArray() {
        return proxy.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return proxy.toArray(a);
    }

    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return proxy.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public E get(int index) {
        return proxy.get(index);
    }

    @Override
    public E set(int index, E element) {
        if (element == null) {
            if (front.get(index) != null) {
                front.set(index, null);
                return proxy.set(index, back.get(index));
            }
            return front.get(index);
        }
        else {
            front.set(index, element);
            return proxy.set(index, element);
        }
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int indexOf(Object o) {
        return proxy.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return proxy.lastIndexOf(o);
    }

    @Override
    public ListIterator<E> listIterator() {
        return proxy.listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return proxy.listIterator(index);
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return proxy.subList(fromIndex, toIndex);
    }

}
