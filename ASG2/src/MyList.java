import java.io.FileWriter;

public class MyList<T> {

    Node<T> head;

    Node<T> tail;

    public MyList() {
    }

    public MyList(Node head, Node tail) {
    }

    // hàm xét xem list có rỗng hay không.
    public boolean isEmpty() {
        return (head == null);
    }

    // tính độ dài của list.
    public int length() {
        int count = 0;
        Node current = head;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    // lấy một node bất kì.
    public Node getNode(int i) {
        if(isEmpty()) {
            System.out.println(" Like list is Empty");
            return null;
        }
        if(i > length()) {
            System.out.println("Input value");
            return null;
        }
        Node current = head;
        for (int j = 0; j < i; j++) {
            current = current.next;
        }
        return current;
    }


    // chèn node ở vị trí đầu tiên.
    public void insertToHead(T item) {
        Node<T> newNode = new Node<>(item);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    // chèn node ở tail.
    public void insertAtTail (T information){
        Node newNode = new Node(information);
        if(isEmpty()) {
            head = tail = newNode;
        }
        else {
            Node lastNode = head;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
            lastNode.next = newNode;
        }
    }


    // hàm hiền thị danh sách .
    public void display() {
        if (isEmpty()) {
            System.out.println("Linked list is empty!");
            return;
        }
        Node p = head;
        System.out.println(" ID | Title | Quantity | Price ");
        while (p != null) {
            System.out.println(p.info);
            p = p.next;
        }
    }

    // tìm kiếm id sản phầm.
    public String searchID(String inputId) {
        Node p = head;
        while (p != null) {
            if(p.info.bCode.equalsIgnoreCase(inputId)) {
                System.out.println(p.info);
                return p.toString();
            }
            p = p.next;
        }
        System.out.println("-1");
        return "-1";
    }

    // xóa phần tử trong list.
    public void deleteID(String inputId) {
        if(head.info.bCode.equalsIgnoreCase(inputId)) {
            head = head.next;
        } else if(tail.info.bCode.equalsIgnoreCase(inputId)) {
            if(head == null) {
                return ;
            }
            Node prevNode = null;
            Node current = head;
            while(current.next != null) {
                prevNode = current;
                current = current.next;
            }
            if(prevNode == null) {
                return ;
            } else {
                prevNode.next = current.next;
            }
        } else {
            if(head == null) {
                return ;
            }
            Node current = head;
            Node prevNode = null;
            boolean isFound = false;
            while(current != null) {
                if(current.info.bCode.equalsIgnoreCase(inputId)) {
                    isFound = true;
                    break;
                }
                prevNode = current;
                current = current.next;
            }
            if(prevNode == null) { // current node is last Node.
                return;
            } else {
                if(current != null) {
                    prevNode.next = current.next;
                }
            }
        }
    }

    /**
     * Swaping two nodes [firstNode] and [secondNode]
     *
     * @param firstNode
     * @param secondNode
     */
    public void swap(Node<Product> firstNode, Node<Product> secondNode) {
        String temp = firstNode.info.bCode;
        firstNode.info.bCode = secondNode.info.bCode;
        secondNode.info.bCode = temp;
    }

    /**
     * Deleting all items in the list
     */
    public void clear() {
        head = tail = null;
    }


}


