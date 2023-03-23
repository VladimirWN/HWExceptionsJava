import Services.UserService;
import Users.User;
import Utils.WriteToTxt;

import java.io.IOException;
import java.util.Scanner;

public class Controller {
    public void startProgram() {
        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        WriteToTxt writer = new WriteToTxt();
        while (true) {
            System.out.println("Введите данные нового пользователя или \"q\" для выхода:");
            String currentMessage = scanner.nextLine();
            if (currentMessage.equals("q")) {
                scanner.close();
                break;
            } else {
                try {
                    User currentUser = userService.parseToUser(currentMessage);
                    System.out.println("Correct Input");
                    System.out.println(currentUser);
                    try {
                        writer.write(currentUser);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (RuntimeException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
