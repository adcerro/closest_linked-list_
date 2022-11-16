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

    //Creates an empty LinkedList.
    LinkedList() {
        this.head = null;
        size = 0;
    }
    //Returns the head of the LinkedList.
    public Node<T> getHead() {
        return head;
    }

    //Returns the last node of the list.
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
     *  The following method searches the object in the LinkedList and returns its index in the list.<p>
     *  If the object is not found or the list is empty it returns -1.<p>
     *  Input: The object.<p>
     *  Output: The index of the list for that object.<p>
     *  @param object  The object that will be searched.
     * */
    public int indexOf(T object){
        int index =0;
        if (head == null) {
            return -1;
        } else if(head.equals(object)){
            return 0;
        }else{
            Node<T> p = head;
            while (p.getNext() != null && !p.getData().equals(object)) {
                p = p.getNext();
                index++;
            }
            if(p.getData().equals(object)){
                return index;
            }else{
                return -1;
            }

        }
    }
    /**
     * The following method iterates through the LinkedList the amount of times specified by the index to get the node
     * in that position of the list.<p>
     * Input: An integer higher than zero and lower than the size of the list.<p>
     * Output: The node in that position
     * @param num  The index in the list.
     * @throws IndexOutOfBoundsException if the index provided doesn't belong in any way in the LinkedList.
     * */
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
    /**
     * The following void adds a new node to the LinkedList in the last position.<p>
     * Input:  The data fot the node.<p>
     * Output: The node in that position.
     * @param n  The data that will be stored in the node.
     * */
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

    //Sets the custom iterator for the LinkedList
    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator<T>(this);
    }
    //returns the size of the list
    public int size() {
        return size;
    }
}