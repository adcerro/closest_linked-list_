package closest.pair;

import java.util.Iterator;

public class LinkedList<T extends Comparable<T>> implements Iterable<T> {
    private Node<T> head;
    private int size;

    /**
     * Creates a LinkedList with the provided Object as is first element and head
     * Input: An object that implements the comparable interface
     * @param head  The first element of the list
     * */
    LinkedList(T head) {
        this.head = new Node<T>(head,null);
        size = 1;
    }

    //Creates an empty LinkedList
    LinkedList() {
        this.head = null;
        size = 0;
    }

    public Node<T> getHead() {
        return head;
    }

    //Returns the last node of the list
    public Node<T> getLast() {
        if (head == null) {
            return null;
        } else {
            Node<T> p = head;
            while (p.getNext() != null) {
                p = p.getNext();
            }
            return p;
        }
    }
    /**
     *  The following
     *
     * */
    public int indexOf(T object){
        int index =0;
        if (head == null) {
            return -1;
        } else if(object.equals(head)){
            return 0;
        }else{
            Node<T> p = head;
            while (p.getNext() != null && p.getData().compareTo(object)!=0) {
                p = p.getNext();
                index++;
            }
            if(p.getData().compareTo(object)==0){
                return index;
            }else{
                return -1;
            }

        }
    }

    public T get(int num) {
        if (head == null) {
            return null;
        } else if (num >= size || num<0) {
            throw new IndexOutOfBoundsException("The index doesn't exist the list!");
        } else {
            Node<T> p = head;
            for (int i=0; i<num;i++) {
                p = p.getNext();
            }
            return p.getData();
        }
    }

    public void add(T n) {
        if (head == null) {
            head = new Node<T>(n, null);
        } else {
            Node p = head;
            while (p.getNext() != null) {
                p = p.getNext();
            }
            p.setNext(new Node<T>(n, null));
        }
        size++;
    }


    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator<T>(this);
    }

    public int size() {
        return size;
    }
}