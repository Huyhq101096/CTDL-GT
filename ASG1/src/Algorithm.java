import java.io.*;
import java.util.Scanner;

public class Algorithm {
    static Scanner sc = new Scanner(System.in);


    //viết dữ liệu từ array vào file
    public static void writeFile(float[] a) {
        try {
            FileWriter fw = new FileWriter("test/Input.txt");
            // lặp qua và viết giá trị vào file.
            for(int i = 0; i < a.length; i++) {
                fw.write(String.valueOf((float) a[i] + " "));
            }

            for(int i = 0; i < a.length; i++) {
                System.out.print(a[i] + " ");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
    }

    // đọc dữ liệu từ file.
    public static float[] readFile() {
        float[] a = {};
        try {
            FileReader fr = new FileReader("test/Input.txt");
            BufferedReader br = new BufferedReader(fr);
            String[] txt;
            String line = "";
            System.out.print("Array : ");
            while(true) {
                line = br.readLine();  // đọc một dòng trong tệp.
                if(line == null) {
                    break;
                }
                txt = line.split(" ");
                a = new float[txt.length];
                for(int i = 0; i < a.length; i++) {
                    a[i] = Float.parseFloat(txt[i]);
                    System.out.print(a[i] + " ");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        return a;
    }

     //hàm bubble sort sắp xếp nổi bọt.
    public static float[] bubbleSort(float[] a) {
        long starTime = System.nanoTime();
        System.out.println("Bubble Sort. ");
        for (int i = 0; i < a.length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < a.length - 1 - i; j++) {
                if(a[j] > a[j + 1]) {
                    float temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    isSorted = false;
                }
            }
            printArray(a);
            if(isSorted) {
                break;
            }
        }
        // thời gian kết thúc khi sắp xếp.
        System.out.println();
        long endTime = System.nanoTime();
        System.out.println("Time : " + (endTime - starTime));
        // viết mảng vào file.
        try {
            FileWriter fw = new FileWriter("test/Input1.txt");
            // lặp qua và viết giá trị vào file.
            for(int i = 0; i < a.length; i++) {
                fw.write(String.valueOf((float) a[i] + " "));
            }
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return a;
    }

    // hàm selection sort ,
    public static float[] selectionSort(float a[]) {
        long starTime = System.nanoTime();
        for (int i = 0; i < a.length - 1; i++) {
            int min = i;
            // tim so nho nhat trong arr.
            for (int j = i + 1; j < a.length ; j++) {
                if(a[j] < a[min]) {
                    min = j;
                }
            }
            // đưa dữ liệu ra đầu mảng .
            float temp = a[min];
            a[min] = a[i];
            a[i] = temp;
            // in ra giá trị sau mỗi lần tính.
            for (int k = 0; k < a.length; k++) {
                System.out.print(a[k] + " ");
            }
            System.out.println();
        }
        System.out.println();
        long endTime = System.nanoTime();
        System.out.println("Time : " + (endTime - starTime));
        try {
            FileWriter fw = new FileWriter("test/Input2.txt", true);
            // lặp qua và viết giá trị vào file.
            for(int l = 0; l < a.length; l++) {
                fw.write(String.valueOf((float) a[l] + " "));
            }
            fw.write("\n");
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return a;
    }

    // ham sap xep insert sort
    public static float[] insertionSort(float a[]) {
        long starTime = System.nanoTime();
        for (int i = 1; i < a.length; ++i) {
            int j = i - 1;
            float temp = a[i];
            while(j >= 0 && a[j] > temp) {
                a[j+1] = a[j];
                j = j - 1;
            }
            a[j+1] = temp;
            printArray(a);
        }
        System.out.println();
        long endTime = System.nanoTime();
        System.out.println("Time : " + (endTime - starTime));
        try {
            FileWriter fw = new FileWriter("test/Input3.txt", true);
            // lặp qua và viết giá trị vào file.
            for(int l = 0; l < a.length; l++) {
                fw.write(String.valueOf((float) a[l] + " "));
            }
            fw.write("\n");
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return a;
    }

    // ham so sanh lon hon gia tri da cho
    public static void linearSearch(float a[], float value) {
        try {
            FileWriter fw = new FileWriter("test/Input4.txt", true);
            System.out.print("Index : ");
            for ( int i = 0; i < a.length; i++) {
                if (a[i] > value) {
                    System.out.print(i + " ");
                    fw.write(String.valueOf( i + " "));
                }
            }
            fw.write("\n");
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
    }

    // ham Binary Search.
    public static int binarySearch(float a[], int left, int right, float value) {
        try {
            FileWriter fw = new FileWriter("test/Input5.txt", true);
            if(right >= left) {
                int mid = left + (right - left)/2;
                if(a[mid] == value) {
                    fw.write(String.valueOf(mid) + " ");
                    fw.write("\n");
                    fw.close();
                    return mid;
                } else if(a[mid] > value) {
                    return binarySearch(a,left,mid - 1,value);
                } else {
                    return binarySearch(a,mid + 1, right,value);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return -1;
    }

    public static void printArray(float[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

}
