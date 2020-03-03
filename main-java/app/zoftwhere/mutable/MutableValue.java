package app.zoftwhere.mutable;

import java.util.NoSuchElementException;
import java.util.Optional;

import app.zoftwhere.function.PlaceHolder;

public class MutableValue<T> implements PlaceHolder<T> {

    private T value;

    public MutableValue() {
        this.value = null;
    }

    public MutableValue(T value) {
        this.value = value;
    }

    @Override
    public Void set(T value) {
        this.value = value;
    }

    /**
     * Retrieve variable value.
     *
     * @return Stored value.
     * @exception NoSuchElementException if no value is present
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
