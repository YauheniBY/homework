
package task01;

import java.util.Scanner;

public class Entry {
    private int id = 0;
    private String name;
    private String surname;
    private String category;

    public Entry() {
    }

    public Entry(int id, String name, String surname, String category) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.category = category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCategory() {
        return category;
    }

    public void Show(PhoneNumber[][] P) {
        System.out.print(getId() + ". Name: " + getName() + ". Surname: " + getSurname() + ". Category:" + getCategory() + " ");

        for (int j = 0; j < P[id - 1].length; j++) {
            if (P[id - 1][j].getNumber() != 0) {
                P[id - 1][j].ShowPhoneNumber();
            }

        }

        System.out.println();
    }

    public void Exchange(int choice, int max, PhoneNumber[][] P) {
        String str;
        int x;

        Scanner scanner = new Scanner(System.in);


        switch (choice) {

            case 1:
                System.out.println("Старое значение записи:");
                Show(P);
                System.out.println("Введите новое значение имени:");
                str = scanner.nextLine();
                setName(str);
                System.out.println("новое значение фамилии:");
                str = scanner.nextLine();
                setSurname(str);
                System.out.println("новое значение категории:");
                str = scanner.nextLine();
                setCategory(str);
                for (int j = 0; j < max; j++) {

                    if (P[id - 1][j].getNumber() != 0) {
                        System.out.println("Введите тип " + (j + 1) + "-ого номера : ");
                        str = scanner.nextLine();
                        P[id - 1][j].setType(str);
                        System.out.println("Введите " + (j + 1) + "-й номер : ");
                        x = scanner.nextInt();
                        scanner.nextLine();
                        P[id - 1][j].setNumber(x);


                    }
                }

                break;
            case 2:
                System.out.println("старое значение:");
                getName();
                System.out.println("Введите новое значение:");
                str = scanner.nextLine();
                setName(str);
                break;
            case 3:
                System.out.println("старое значение:");
                getSurname();
                System.out.println("новое значение:");
                str = scanner.nextLine();
                setSurname(str);
                break;
            case 4:
                System.out.println("старое значение:");
                getCategory();
                System.out.println("новое значение:");
                str = scanner.nextLine();
                setCategory(str);
                break;


        }
    }

    //Методы сравнения по параметру
    public int srawName(String str, PhoneNumber[][] P) {
        int x = 0;
        if (str.equals(this.name)) {
            Show(P);
            x = 1;
        }
        return x;
    }

    public int srawSurname(String str, PhoneNumber[][] P) {
        int x = 0;
        if (str.equals(this.surname)) {
            Show(P);
            x = 1;
        }
        return x;
    }

    public int srawCategory(String str, PhoneNumber[][] P) {
        int x = 0;
        if (str.equals(this.category)) {
            Show(P);
            x = 1;
        }
        return x;
    }

    public int srawType(String str1, int max, PhoneNumber[][] P) {
        int x = 0;
        String str2;
        for (int j = 0; j < max; j++) {
            str2 = P[id - 1][j].getType();
            if (str1.equals(str2)) {
                Show(P);
                x = 1;
            }
        }
        return x;
    }

    public int srawNumber(int num1, int max, PhoneNumber[][] P) {
        int x = 0;
        int num2;
        for (int j = 0; j < max; j++) {
            num2 = P[id - 1][j].getNumber();
            if (num1 == num2) {
                Show(P);
                x = 1;
            }
        }
        return x;
    }

    public int srawId(int x, PhoneNumber[][] P) {
        if (this.id == x) {
            Show(P);
            x = 1;
        } else {
            x = 0;
        }
        return x;
    }


    //  System.out.println(getId()+""+getName()+""+getSurname()+""+getCategory());


    public String toString() {
        return String.format(
                "{Id: %2d, Name %s Surname: %s, Category: %s}",
                getId(), getName(), getSurname(), getCategory());
    }

}
