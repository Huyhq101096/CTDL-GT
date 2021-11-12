public class Node<T> {

    Product info;
    Node next;

    public Node(T x) {
        this(x,null);
    }

    public Node(T info, Node next) {
        this.info = (Product) info;
        this.next = next;
    }

    public Product getInfo() {
        return info;
    }

    public void setInfo(Product info) {
        this.info = info;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return info.toString();
    }
}
