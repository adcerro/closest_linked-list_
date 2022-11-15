package closest.pair;

public class Node {
    private Point data;
    private Node next;
    Node(Point p, Node next){
        data =p;
        this.next = next;
    }


    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Point getData() {
        return data;
    }

    public void setData(Point data) {
        this.data = data;
    }
}
