import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class OperationToProduct {

    // đọc dữ liệu từ file và lưu vào mylist.
    public void getAllItemsFromFile(String fileName, MyList<Product> list) {
        try {
            //fileName = "file/product.txt";
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line;
            String[] txt;
            //list.clear();
            while ((line = br.readLine()) != null ) {
                txt = line.split("\\|");
                Product p = new Product();
                p.bCode = txt[0].trim();
                p.title = txt[1].trim();
                p.quantity = Integer.parseInt(txt[2].trim());
                p.price = Double.parseDouble(txt[3].trim());
                list.insertAtTail(p);
            }
            list.display();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // thêm dữ liệu vào cuối list.
    public void addLast(MyList<Product> list) {
        Scanner sc = new Scanner(System.in);
        Product p = new Product();
        System.out.print("Input code: ");
        p.bCode = sc.nextLine();
        System.out.print("Input title: ");
        p.title = sc.nextLine();
        System.out.print("Input quantity: ");
        p.quantity = sc.nextInt();
        System.out.print("Input double: ");
        p.price = sc.nextDouble();
        list.insertAtTail(p);
        list.display();
        newPrint("file/console_output.txt", list);
    }

    // hàm hiển thị danh sách có trong list .
    public void displayAll(MyList<Product> list) {
        list.display();
    }

    /**
     * Writing all products from the list to the file
     *
     * @param fileName Input file name
     * @param list     Input Linked list
     */
    public void writeAllItemsToFile(String fileName, MyList<Product> list) {
        try {
            //fileName = "file/Data.txt";
            FileWriter fw = new FileWriter(fileName);
            int count = list.length();
            for (int i = 0; i < count; i++) {
                fw.write(list.getNode(i).toString());
                fw.write("\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // tìm kiếm một sản phẩm theo code.
    public void searchByCode(MyList<Product> list) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input code : ");
        String search = sc.nextLine();
        list.searchID(search);
    }

    // xóa sản phẩm theo code.
    public void deleteByCode(MyList<Product> list) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input code : ");
        String search = sc.nextLine();
        list.deleteID(search);
        newPrint("file/console_output.txt", list);
    }

    // hàm sắp xếp ban đầu , không sử dụng đệ qui.
    public void sortByCode(MyList<Product> list) {
        Node i = list.head;
        while (i != null) {
            Node j  = i.next;
            while (j != null) {
                if(i.info.bCode.compareTo(j.info.bCode) > 0) {
                    list.swap(i,j);
                }
                j = j.next;
            }
            i = i.next;
        }
    }

    /**
     * Bên ngoài gọi hàm này
     * @param list
     */
    public void selectionSort(MyList<Product> list) {
        selectionSort(list, list.head);
        newPrint("file/console_output.txt", list);
    }

    /**
     * Ham sort chon truc tiep phuong phap de quy
     * Dua phan tu nho nhat vao vi tri dang xet
     * @param list ds sap xep
     * @param start phan tu xet, lan dau goi truyen heead vao
     */
    private void selectionSort(MyList<Product> list, Node<Product> start) {
        // phan tu cuoi khong can lam gi, dung de quy (dk cơ sở)
        if(start != null && start.next != null) {
            // Bat dau tu phan tu xet
            Node temp = start;
            Node min = temp;
            temp = temp.next;
            while(temp != null) {
                if(min.info.bCode.compareTo(temp.info.bCode) > 0) {
                    min = temp;
                }
                temp = temp.next;
            }
            // khong hoan vi chinh no
            if(start != temp) {
                // hoan vi phan tu nho nhat voi vi tri xet
                list.swap(start, min);
            }
            // lặp xử lý phần tử kế tiếp bằng đệ quy.
            selectionSort(list, start.next);
        }
    }

    /**
     * Convert a decimal to an array of binary. Example: input i = 18 -> Output =
     * {0, 1, 0, 0, 0, 1}
     * @return Array of binary numbers .
     */
    public int[] convertToBinary(MyList<Product> list) {
        int i = list.head.info.quantity;
        int[] binary = new int[40];
        int index = 0;
        while (i > 0) {
            binary[index++] = i%2;
            i = i/2;
        }
        for(int j = index-1;j >= 0;j--) {
            System.out.print(binary[j] + " ");
        }
        System.out.println();
        return binary;
    }

    // hàm hiển thị danh sách theo stack.
    public void displayStack(String fileName) {
        try {
            MyStack<Product> arrange = new MyStack<Product>();
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] txt;
            while ((line = br.readLine()) != null ) {
                txt = line.split("\\|");
                Product p = new Product();
                p.bCode = txt[0].trim();
                p.title = txt[1].trim();
                p.quantity = Integer.parseInt(txt[2].trim());
                p.price = Double.parseDouble(txt[3].trim());
                arrange.push(p);
            }
            while (!arrange.isEmpty()) {
                System.out.println(arrange.pop());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // hiển thị danh sách theo queue.
    public void displayQueue(String fileName) {
        try {
            MyQueue<Product> queue = new MyQueue<Product>();
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] txt;
            while ((line = br.readLine()) != null ) {
                txt = line.split("\\|");
                Product p = new Product();
                p.bCode = txt[0].trim();
                p.title = txt[1].trim();
                p.quantity = Integer.parseInt(txt[2].trim());
                p.price = Double.parseDouble(txt[3].trim());
                queue.enqueue(p);
            }
            while (!queue.isEmpty()) {
                System.out.println(queue.dequeue());
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    // ghi dữ liệu vào file console.output.txt
    public void newPrint(String fileName,MyList<Product> list) {
        try {
            FileWriter fw = new FileWriter(fileName, true);
            int count = list.length();
            for (int i = 0; i < count; i++) {
                fw.write(list.getNode(i).toString());
                fw.write("\n");
            }
            //fw.write(product);
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
