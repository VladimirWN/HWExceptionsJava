package Services;

import Exceptions.*;
import Users.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserService {
    public User parseToUser(String line) throws RuntimeException {
        User user = new User();
        if (checkCountElements(line) < 0) {
            throw new OverSizeMessageException("Мало данных");
        } else if (checkCountElements(line) > 0) {
            throw new UnderSizeMessageException("Данных больше необходимого");
        } else {
            ArrayList<String> userList = new ArrayList<>(Arrays.asList(line.split(" ")));
            Pattern patternDateFormat = Pattern.compile(
                    "^\\d{2}" + "\\." + "\\d{2}" + "\\." + "\\d{4}$");
            Pattern patternMaleFormat = Pattern.compile("[mf]");
            Pattern patternNameFormat = Pattern.compile("^\\D{2,}$");
            Pattern patternPhoneFormat = Pattern.compile("^\\d{3,12}$");
            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).contains(".")) {
                    Matcher matcherDate = patternDateFormat.matcher(userList.get(i));
                    if (matcherDate.find()) {
                        user.setBirthDate(userList.get(i));
                    } else {
                        throw new IncorrectDateFormatException("Неверный формат даты! (dd.mm.yyyy)");
                    }
                } else if (userList.get(i).length() == 1) {
                    Matcher matcherMale = patternMaleFormat.matcher(userList.get(i));
                    if (matcherMale.find()) {
                        user.setMale(userList.get(i).charAt(0));
                    } else {
                        throw new IncorrectMaleException("Неверный формат пола! (m or f)");
                    }
                } else if (Character.isDigit(userList.get(i).charAt(0))) {
                    Matcher matcherPhone = patternPhoneFormat.matcher(userList.get(i));
                    if (matcherPhone.find()) {
                        user.setPhone(Integer.parseInt(userList.get(i)));
                    } else {
                        throw new IncorrectPhoneException("Неверный формат номера телефона! (3-12 digits)");
                    }
                } else {
                    String[] fullName = new String[3];
                    for (int j = 0; j < 3; j++) {
                        Matcher matcherName = patternNameFormat.matcher(userList.get(i));
                        if (matcherName.find()) {
                            fullName[j] = userList.get(i);
                        } else {
                            throw new IncorrectNameException("Неверный формат ФИО!");
                        }
                        i++;
                    }
                    user.setSurname(fullName[0]);
                    user.setFirstname(fullName[1]);
                    user.setPatronymic(fullName[2]);
                    i--;
                }
            }
            while (((Iterator<Object>) user).hasNext()){
                if (((Iterator<Object>) user).next() == null){
                    throw new IncorrectDataException("Неверный набор данных");
                }
            }
        }
        return user;
    }

    public Integer checkCountElements(String line) {
        String[] inputList = line.split(" ");
        return (User.countUserCharacters - inputList.length);
    }

    public boolean isDigit(String word) {
        for (int i = 0; i < word.length(); i++) {
            if (!Character.isDigit(word.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
