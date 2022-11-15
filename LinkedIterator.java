package closest.pair;

import java.util.Iterator;

public class LinkedIterator implements Iterator<Point> {
    LinkedList list;
    Node current;
    LinkedIterator(LinkedList li){
        list = li;
        current = li.getHead();
    }
    @Override
    public boolean hasNext() {
        return current!=null;
    }

    @Override
    public Point next() {
        Node result = current;
        current = current.getNext();
        return  result.getData();
    }
}
