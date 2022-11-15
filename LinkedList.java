package closest.pair;

import java.util.Iterator;

public class LinkedList implements Iterable<Point>{
    private Node head;
    LinkedList(Node head){
        this.head = head;
        head.setNext(null);
    }
    LinkedList(){
        this.head = null;
    }

    public Node getHead() {
        return head;
    }
    public void add(Node n){
        if(head == null){
            head = n;
        }else{
            Node p = head;
            while(p.getNext()!=null){
                p = p.getNext();
            }
            p.setNext(n);
        }
    }


    @Override
    public Iterator<Point> iterator() {
        return new LinkedIterator(this);
    }
}