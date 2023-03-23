package Users;

import java.util.Iterator;
import java.util.function.Consumer;

public class User implements Iterator<Object> {
    private String firstname;
    private String patronymic;
    private String surname;
    private String birthDate;
    private int phone;
    private char male;
    private int index;

    public static int countUserCharacters = 6;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public char getMale() {
        return male;
    }

    public void setMale(char male) {
        this.male = male;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s, %s, %d, '%c'", this.surname, this.firstname,
                this.patronymic, this.birthDate, this.phone, this.male);
    }

    @Override
    public boolean hasNext() {
        return index++ < 6;
    }

    @Override
    public Object next() {
        switch (index){
            case 1:
                return firstname;
            case 2:
                return patronymic;
            case 3:
                return surname;
            case 4:
                return birthDate;
            case 5:
                return phone;
            default:
                return male;
        }
    }
}
