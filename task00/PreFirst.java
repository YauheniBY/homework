package task00;

import java.util.Scanner;

public class PreFirst {
    public static void main(String[] args) {
        int n;//число, которое будет вводить пользователь для деления
        try {
            do {

                System.out.println("Введите число для проверки кратности 3-м:");
                Scanner scanner = new Scanner(System.in);
                n = scanner.nextInt();
                if (n  % 3 == 0 && n != 0) {
                    System.out.println("Число " + n + " кратное 3-м");
                } else if (n != 0) {
                    System.out.println("Число " + n + " НЕ кратное 3-м");
                }


            } while (0 != n);
         } catch (Exception e) {
        System.out.println("ОШИБКА! Вы ввели значение не являющееся целым числом.");
    }


}

}
