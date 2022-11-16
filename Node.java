package closest.pair;

public class Node<T> {
    private T data;
    private Node<T> next;
    /**
     * Creates a node that holds a certain data.
     * @param data  The value/object stored in the node
     * @param next  The node linked tho this node, can be null if it's the last node on the list
     * */
    Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }


    public Node<T> getNext() {
        return next;
    }
    //Links a node with another node.
    public void setNext(Node<T> next) {
        this.next = next;
    }
    // returns the T value that the Node stores.
    public T getData() {
        return data;
    }
    // Sets the T value that the Node will store.
    public void setData(T data) {
        this.data = data;
    }
}
