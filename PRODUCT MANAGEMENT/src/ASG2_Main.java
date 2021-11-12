import java.util.Scanner;

public class ASG2_Main {
    static Scanner sc = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("Choose one of this options:");
        System.out.println("Product list:");
        System.out.println("1. Load data from file and display");
        System.out.println("2. Input & add to the end.");
        System.out.println("3. Display data");
        System.out.println("4. Save product list to file.");
        System.out.println("5. Search by ID");
        System.out.println("6. Delete by ID");
        System.out.println("7. Sort by ID.");
        System.out.println("8. Convert to Binary");
        System.out.println("9. Load to stack and display");
        System.out.println("10. Load to queue and display.");
        System.out.println("0. Exit");
    }

    public static void main(String[] args) {
        int choice;
        int numContinue;
        boolean boContinue;
        OperationToProduct otp = new OperationToProduct();
        MyList<Product> myList = new MyList<Product>();
        do {
            showMenu();
            System.out.print("Choice : ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    otp.getAllItemsFromFile("file/product.txt", myList);
                    break;
                case 2:
                    otp.addLast(myList);
                    break;
                case 3:
                    otp.displayAll(myList);
                    break;
                case 4:
                    otp.writeAllItemsToFile("file/Data.txt", myList);
                    break;
                case 5:
                    otp.searchByCode(myList);
                    break;
                case 6:
                    otp.deleteByCode(myList);
                    break;
                case 7:
                    otp.selectionSort(myList);
                    break;
                case 8:
                    otp.convertToBinary(myList);
                    break;
                case 9:
                    otp.displayStack("file/product.txt");
                    break;
                case 10:
                    otp.displayQueue("file/product.txt");
                    break;
            }
            System.out.print("Do you want to continue ? 1. Yes || 2. No : ");
            numContinue = sc.nextInt();
            if(numContinue == 1) {
                boContinue = true;
            } else {
                boContinue = false;
            }
        } while (boContinue);
    }
}
