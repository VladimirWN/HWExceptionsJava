public class Task1 {

    public static void main(String[] args) {
        doArithmeticException(0);
        doNumberFormatException("qwerty");
        doIndexOufOfBoundsException(11);
    }

    public static void doArithmeticException(int b){
        int a = 10 / b;
    }

    public static void doNumberFormatException(String s){
            int c = Integer.parseInt(s);
    }

    public static void doIndexOufOfBoundsException(int i){
        int[] arr = new int[10];
        System.out.println(arr[i]);
    }
}
