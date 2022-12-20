import java.util.Scanner;

public class Task4 {
//    Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. Пользователю должно
//    показаться сообщение, что пустые строки вводить нельзя.

    public static void main(String[] args) {
        System.out.println(getInputData());
    }

    public static String getInputData() {
        String result;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите строку: ");
        result = scanner.nextLine();
        if (result.isBlank()) {
            throw new RuntimeException("Пустые строки вводить нельзя");
        }
        return result;
    }
}
