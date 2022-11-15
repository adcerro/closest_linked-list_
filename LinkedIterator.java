package closest.pair;

import java.util.Iterator;

public class LinkedIterator<T> implements Iterator<T> {
    LinkedList<T> list;
    Node<T> current;
    LinkedIterator(LinkedList<T> list){
        this.list = list;
        current = list.getHead();
    }
    @Override
    public boolean hasNext() {
        return current!=null;
    }

    @Override
    public T next() {
        T result = current.getData();
        current = current.getNext();
        return  result;
    }
}
