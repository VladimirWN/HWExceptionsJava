import java.util.Scanner;
import java.util.logging.Logger;

public class Task1 {
    //    Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное
//    значение. Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно
//    запросить у пользователя ввод данных.
    static Logger logger = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        logger.info(String.valueOf(getInputFloat()));
    }

    public static float getInputFloat() {
        float input = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            logger.info("Введите вещественное число: ");
            input = Float.parseFloat(scanner.next());
        } catch (NumberFormatException e) {

            logger.info("Введено не корректное значение, повторите ввод.");
            input = getInputFloat();
        }
        return input;
    }
}
