import java.util.Scanner;

public class task2 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] array = {1, 5, 6, 3, 7};
        System.out.println("Input: ");
        doIt(null, 6, scanner.nextInt());
    }
    
    static int searchElement(int[] arr, int min, int number){
        if(arr == null){
            return -3;
        } else if (arr.length < min) {
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if (number == arr[i]){
                return i;
            }
        }
        return -2;
    }

    static void doIt(int[] arr, int min, int number){
        int result = searchElement(arr, min, number);
        switch (result) {
            case -1 -> System.out.println("min");
            case -2 -> System.out.println("did not find");
            case -3 -> System.out.println("arr");
            default -> System.out.println("find index " + result);
        }
    }
}
