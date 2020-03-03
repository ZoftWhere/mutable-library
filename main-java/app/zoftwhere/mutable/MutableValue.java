package app.zoftwhere.mutable;

import java.util.NoSuchElementException;
import java.util.Optional;

import app.zoftwhere.function.PlaceHolder;

/**
 * A mutable value.
 *
 * @param <T> the type
 */
public class MutableValue<T> implements PlaceHolder<T> {

    private T value;

    /**
     * Returns a {@code MutableValue} describing the given value.
     *
     * @param value the possibly-{@code null} value to describe
     * @param <T>   the type of the value
     * @return {@code MutableValue} instance with the initial specified value
     */
    public static <T> MutableValue<T> ofNullable(T value) {
        return new MutableValue<>(value);
    }

    /**
     * Returns an empty {@code MutableValue}.
     *
     * @param <T> the type of the value
     * @return {@code MutableValue} instance with a null initial value.
     */
    public static <T> MutableValue<T> empty() {
        return new MutableValue<>();
    }

    /**
     * Constructs a mutable value with initial value of null.
     */
    public MutableValue() {
        this.value = null;
    }

    /**
     * Constructs a mutable value.
     *
     * @param value initial value
     */
    public MutableValue(T value) {
        this.value = value;
    }

    /**
     * Set mutable value.
     */
    @Override
    public Void set(T value) {
        this.value = value;
        return null;
    }

    /**
     * Retrieve mutable value.
     *
     * @return Stored value
     * @exception NoSuchElementException if no value is present
     */
    @Override
    public T get() {
        if (value == null) {
            throw new NoSuchElementException();
        }
        return value;
    }

    /**
     * Retrieve mutable value.
     *
     * @return Stored value
     */
    @Override
    public T getValue() {
        return value;
    }

    /**
     * Returns an {@code Optional} describing the current value.
     *
     * @return an {@code Optional} with a present value if the specified value is non-{@code null}, otherwise an empty
     * {@code Optional}
     */
    public Optional<T> optional() {
        return Optional.ofNullable(value);
    }

    /**
     * Check if value is not null.
     *
     * @return {@code true} if a value is present, otherwise {@code false}
     */
    @Override
    public boolean isPresent() {
        return value != null;
    }

    /**
     * Check if the value is null.
     *
     * @return {@code true} if a value is null, otherwise {@code false}
     */
    @Override
    public boolean isEmpty() {
        return value == null;
    }

    /**
     * Retrieves non-null mutable value, otherwise returns {@code other}.
     *
     * @param other the value to be returned, if no value is present. May be {@code null}
     * @return the value, if present, otherwise {@code other}
     */
    @Override
    public T orElse(T other) {
        return value != null ? value : other;
    }

}
