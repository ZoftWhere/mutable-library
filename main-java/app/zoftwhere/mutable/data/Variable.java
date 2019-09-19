package app.zoftwhere.mutable.data;

import app.zoftwhere.mutable.function.PlaceHolder;

import java.util.NoSuchElementException;
import java.util.Optional;

public class Variable<T> implements PlaceHolder<T> {

    private T value;

    public Variable() {
        this.value = null;
    }

    public Variable(T value) {
        this.value = value;
    }

    @Override
    public void set(T value) {
        this.value = value;
    }

    /**
     * Retrieve variable value.
     *
     * @return Stored value.
     * @throws NoSuchElementException if no value is present
     */
    @Override
    public T get() {
        if (value == null) {
            throw new NoSuchElementException();
        }
        return value;
    }

    public Optional<T> optional() {
        return Optional.ofNullable(value);
    }

    @Override
    public boolean isPresent() {
        return value != null;
    }

    @Override
    public boolean isEmpty() {
        return value == null;
    }

}
