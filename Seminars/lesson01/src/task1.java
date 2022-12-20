public class task1 {
    public static void main(String[] args) {
        int[] array = {1, 4, 6, 7};
        System.out.println(isLongEnough(array, 3));
    }


    static int isLongEnough(int[] arr, int min){
        if(arr.length < min){
            return -1;
        }
        System.out.println();
        return arr.length;
    }
}

