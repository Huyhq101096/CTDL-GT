import java.io.FileWriter;

public class MyStack<T> {

    Node<T> head;
    MyList<Product> list = new MyList<Product>();

    public void push(Product newProduct) {
        Node newNode = new Node(newProduct);
        if(isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head ;
            head = newNode;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Product pop() {
        Product out = head.info;
        head = head.next;
        return out;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Linked list is empty!");
            return;
        }
        Node a = head;
        while (a != null) {
            System.out.println(pop());
            a = a.next;
        }
    }



}
