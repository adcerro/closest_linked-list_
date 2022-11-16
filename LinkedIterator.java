package closest.pair;

import java.util.Iterator;

public class LinkedIterator<T extends Comparable<T>> implements Iterator<T> {
    LinkedList<T> list;
    Node<T> current;
    /**
     * Assigns an iterator to the head of the linkedList<p>
     * @param list  The LinkedList tou want to be able to iterate through.
     * */
    LinkedIterator(LinkedList<T> list){
        this.list = list;
        current = list.getHead();
    }
    //Returns true if there are more elements after the position of the cursor.
    @Override
    public boolean hasNext() {
        return current!=null;
    }
    /**
     * The following method returns the object where the cursor currently is at the LinkedList
     * Output: A T object
     * */
    @Override
    public T next() {
        T result = current.getData();
        current = current.getNext();
        return  result;
    }
}
