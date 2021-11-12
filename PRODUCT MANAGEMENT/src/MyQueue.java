public class MyQueue<T> {
    /**
     * Head node contains front node in the queue
     */
    Node<T> head;

    /**
     * Tail node contains last node in the queue
     */
    Node<T> tail;

    public boolean isEmpty() {
        //head = tail = null;
        return head == null;
    }

    public void enqueue(Product newProduct) {
        Node p = new Node(newProduct);
        if(isEmpty()) {
            head = tail = p;
        } else {
            tail.next = p;
            tail = p;
            p.next = null;
        }
    }


    public Product dequeue() {
        Product out = head.info;
        head = head.next;
        return out;
    }



}
