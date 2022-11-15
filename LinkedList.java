package closest.pair;

public class LinkedList {
    private Node head;
    LinkedList(Node head){
        this.head = head;
        head.setNext(null);
    }

    public Node getHead() {
        return head;
    }
    public void add(Node n){
        Node p = head;
        while(p.getNext()!=null){
            p = p.getNext();
        }
        p.setNext(n);
    }


}