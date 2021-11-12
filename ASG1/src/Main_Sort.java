import java.util.Scanner;

public class Main_Sort {
    static float[] arr;
    static float[] arrRead;

    static int n; // số phần tử có trong mảng.
    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();
        Scanner sc = new Scanner(System.in);

        int choose;
        boolean continuePro = true;
        do {
            showMenu();
            System.out.print("Choose: ");
            choose = sc.nextInt();
            while(choose < 0 || choose > 7 ) {
                System.out.print("Hãy chọn các tính năng của chương trình có trong Menu: ");
                choose = sc.nextInt();
            }

            switch (choose) {
                case 1:
                    do {
                        System.out.print("Nhập vào số phần tử có trong mảng: ");
                        n = sc.nextInt();
                    } while(n < 0);

                    arr = new float[n];
                    for(int i = 0; i < n; i++) {
                        System.out.print("Số thứ " + i + " : ");
                        arr[i] = sc.nextFloat();
                    }
                    algorithm.writeFile(arr);
                    break;
                case 2:
                     arrRead = algorithm.readFile();
                    break;
                case 3:
                    float[] arr1 = arrRead.clone();
                    algorithm.bubbleSort(arr1);
                    break;
                case 4:
                    float[] arr2 = arrRead.clone();
                    algorithm.selectionSort(arr2);
                    break;
                case 5:
                    float[] arr3 = arrRead.clone();
                    algorithm.insertionSort(arr3);
                    break;
                case 6:
                    float[] arr4 = arrRead.clone();
                    System.out.println("Linear Search");
                    System.out.print("Input value : ");
                    float n = sc.nextFloat();
                    algorithm.linearSearch(arr4, n);
                    break;
                case 7:
                    float[] arr5 = arrRead.clone();
                    // sắp xếp mảng .
                    for (int i = 0; i < arr5.length - 1; i++) {
                        int min = i;
                        // tim so nho nhat trong arr.
                        for (int j = i + 1; j < arr5.length ; j++) {
                            if(arr5[j] < arr5[min]) {
                                min = j;
                            }
                        }
                        float temp = arr5[min];
                        arr5[min] = arr5[i];
                        arr5[i] = temp;
                    }
                    System.out.println("Binary Search");
                    System.out.print("Input value : ");
                    float m = sc.nextFloat();
                    int result = algorithm.binarySearch(arr5, 0,arr5.length - 1,m);
                    if(result == -1) {
                        System.out.println("Not Element.");
                    } else {
                        System.out.println("Index of fist element : " + result);
                    }
                    break;
                case 0:
                    break;
            }

            System.out.print("Bạn muốn tiếp tục chương trình hay không. 1.Có || 2.Không : ");
            int x = sc.nextInt();
            if(x == 1) {
                continuePro = true;
            } else {
                continuePro = false;
            }
        } while (continuePro);
    }


    public static void showMenu() {
        System.out.println("+-------------------Menu------------------+");
        System.out.println("|      1.Input                            |");
        System.out.println("|      2.Output                           |");
        System.out.println("|      3.Bubble sort                      |");
        System.out.println("|      4.Selection sort                   |");
        System.out.println("|      5.Insertion sort                   |");
        System.out.println("|      6.Search > value                   |");
        System.out.println("|      7.Search = value                   |");
        System.out.println("|      0.Exit                             |");
        System.out.println("+----------------------------------------.+");
    }
}
