package algorithms;

import java.util.Iterator;
import java.util.List;

public class CollapsingIterators<T> implements Iterator<T>{

    Iterator<T> listCurrentIterator;
    Iterator<Iterator<T>> listIterator;

    public CollapsingIterators(List<Iterator<T>> iterators) {
        this.listIterator = iterators.iterator();
        this.listCurrentIterator = this.listIterator.next();

    }

    @Override
    public boolean hasNext() {
        if(!listCurrentIterator.hasNext()){
            if(!listIterator.hasNext()) {
                return false;
            }
        }

        listCurrentIterator = listIterator.next();
        hasNext();
        return true;
    }

    @Override
    public T next() {
        return null;
    }
}
