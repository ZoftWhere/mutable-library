package app.zoftwhere.mutable.function;

import java.util.Collection;

public interface ProxyCollection<E> {

    int size();

    E get(int index);

    E set(int index, E element);

}
