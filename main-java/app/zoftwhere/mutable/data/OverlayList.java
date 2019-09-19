package app.zoftwhere.mutable.data;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class OverlayList<E> implements List<E> {

    private final List<E> back;

    private final List<E> front;

    public OverlayList(List<E> front, List<E> back) {
        this.back = back;
        this.front = new ArrayList<>(front.size());
        this.front.addAll(front);
        for (int i = 0; i < this.front.size(); i++) {
            if (this.front.get(i) == null) {
                this.front.set(i, back.get(i));
            }
        }
    }

    @Override
    public int size() {
        return front.size();
    }

    @Override
    public boolean isEmpty() {
        return front.isEmpty();
    }

    @Override
    public E get(int index) {
        return front.get(index) != null ? front.get(index) : back.get(index);
    }

    @Override
    public E set(int index, E element) {
        if (element == null) {
            if (front.get(index) != null) {
                front.set(index, null);
                return front.set(index, back.get(index));
            }
            return front.get(index);
        }
        else {
            front.set(index, element);
            return front.set(index, element);
        }
    }

    @Override
    public int indexOf(Object o) {
        return front.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return front.lastIndexOf(o);
    }

    @Override
    public boolean contains(Object o) {
        return front.contains(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return front.containsAll(c);
    }

    @Override
    public boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, E element) {
        throw new UnsupportedOperationException();
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
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public E remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        for (int i = 0, size = size(); i < size; i++) {
            set(i, operator.apply(front.get(i)));
        }
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
    public void sort(Comparator<? super E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return front.subList(fromIndex, toIndex);
    }

    @Override
    public Object[] toArray() {
        return front.toArray();
    }

    public <T> T[] toArray(T[] a) {
        return front.toArray(a);
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        //noinspection SuspiciousToArrayCall
        return front.toArray(generator);
    }

    @Override
    public Iterator<E> iterator() {
        return front.iterator();
    }

    @Override
    public ListIterator<E> listIterator() {
        return front.listIterator();
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return front.listIterator(index);
    }

    @Override
    public Spliterator<E> spliterator() {
        return front.spliterator();
    }

    @Override
    public Stream<E> stream() {
        return front.stream();
    }

    @Override
    public Stream<E> parallelStream() {
        return front.parallelStream();
    }

}
