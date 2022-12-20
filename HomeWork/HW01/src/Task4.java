import java.util.Arrays;
import java.util.logging.Logger;

public class Task4 {

    static Logger logger = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        int[] arrayOne = {10, 15, 20, 5};
        int[] arrayTwo = {5, 5, 5, 0};
        int[] result = subtractOfTwoArrays(arrayOne, arrayTwo);
        if (result != null)
            logger.info(Arrays.toString(result));
    }

    public static int[] subtractOfTwoArrays(int[] arr1, int[] arr2){
        if (arr2.length != arr1.length){
            logger.info("Длины массивов не равны!");
            return null;
        }
        int[] result = new int[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if (arr2[i] == 0){
                logger.info("Во втором массиве есть нулевой элемент, выполнение не возможно. Индекс нуля: " + i);
                return null;
            }
            result[i] = arr1[i] / arr2[i];
        }
        return result;
    }


}

