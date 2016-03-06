package task01;


import java.util.Scanner;



public class PhoneNote {
    //Функция Меню программы
    public static int Menu()
    {
        int menu = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        System.out.println("--------------------------------");
        System.out.println("ВЫБЕРИТЕ ДЕЙСТВИЕ:");
        System.out.println("");
        System.out.println("1-Добавление записи");
        System.out.println("2-Показать все записи");
        System.out.println("3-Изменение записи");
        System.out.println("4-Удаление записи");
        System.out.println("5-Сортировка записи по критерию");
        System.out.println("6-Выход из программы");
        menu = scanner.nextInt();
        System.out.println("--------------------------------");
        return menu;
    }
    //Функция добавления абонента
    public static int Add(int oldKolvo,int howMach,PhoneNumber[][] P,Entry[] en){
        int newKolvo,j = 0,number;
        String name;
        String surname;
        String category;
        String type;
        newKolvo = oldKolvo+howMach;
        Scanner scanner = new Scanner(System.in);
            for( int i = oldKolvo; i<newKolvo;i++) {

                System.out.println("ВВЕДИТЕ : Имя");
                name = scanner.nextLine();
                en[i].setName(name);
                System.out.println("Фамилию:");
                surname = scanner.nextLine();
                en[i].setSurname(surname);
                System.out.println("Категорию (семья, коллега, друг):");
                category = scanner.nextLine();
                en[i].setCategory(category);
                en[i].setId(i+1);
                System.out.println("Сколько номеров у этого абонента? Введите число:");
                int howmuchnumbers = scanner.nextInt();
                scanner.nextLine();
                for(j = 0; j < howmuchnumbers; j++)
                {

                    System.out.println("Тип:"+(j+1)+"-ого номера(домашний или рабочий):");
                    type = scanner.nextLine();
                    P[i][j].setType(type);
                    System.out.println("Введите "+(j+1)+"-й номер:");
                    number = scanner.nextInt();
                    P[i][j].setNumber(number);
                    scanner.nextLine();
                }

                oldKolvo++;
            }

        return oldKolvo;
    }
    //Функкуия выбора ID записи для изменения или удаления
    public static int ChoiceId(int kolvo)
    {
        int id;
        Scanner scanner = new Scanner(System.in);
        System.out.println("выберите ID записи :");
        id = scanner.nextInt();
        while (id>kolvo || id<=0)
        {
            System.out.println("вы ввели несуществующий ID");
            System.out.println("выберите ID записи :");
            id = scanner.nextInt();
        }
        return id;
    }
    public static void main(String[] args) {
        try {

        int id;
        int kolvo = 0;
        int x,y;//для записи различных интовых чисел, которые будут встречаться в программе
        boolean exit = true;
        final int max = 50;
        String str;//для записи различных строк, которые будут встречаться в программе
        //Создаем массив Записей и массив массивов для номеров
        //(потом сможем записать несколько номеров)
        Entry[] en = new Entry[max];
        for(int i =0; i<en.length; i++ )
        {
            en[i] = new Entry();
        }
        PhoneNumber[][] P = new PhoneNumber[max][];
        for (int i = 0; i < P.length; i++)
        {

            P[i] = new PhoneNumber[max];
            for(int j = 0 ; j < P[i].length; j++)
            {
                P[i][j] = new PhoneNumber();
            }
        }

        Scanner scanner = new Scanner(System.in);

        while (exit) {
            switch (Menu()) {

                case 1:
                    kolvo = Add(kolvo, 1, P, en);
                    break;
                case 2:
                    if(kolvo == 0)
                    {
                    System.out.println("Пока нет ни одной записи! Выберите пункт меню ->Добавить запись<-");
                    }
                    else
                    {
                    for (int i = 0; i < kolvo; i++) {
                        en[i].Show(P);
                        en[i].toString();
                    }
                    }
                    break;
                case 3:
                    id = ChoiceId(kolvo);
                    System.out.println("--------------------------------");
                    System.out.println("ЧТО МЕНЯЕМ ?:");
                    System.out.println("");
                    System.out.println("1-Все данные полностью");
                    System.out.println("2-Имя");
                    System.out.println("3-Фамилию");
                    System.out.println("4-Категорию");
                    System.out.println("5-Тип телефона");
                    System.out.println("6-Номер телефона");

                    int choice = scanner.nextInt();
                    if(choice >0 && choice <= 4)
                    {
                        en[id-1].Exchange(choice,max, P);
                    }
                    else if (choice ==4||choice==5)
                    {
                        x=0;
                        for(int j =0; j<=max;j++)
                        {

                            if(P[id-1][j].getNumber() != 0 )
                            {
                                System.out.println((j + 1) + "-й номер : ");
                                P[id - 1][j].getType();
                                P[id - 1][j].getNumber();
                                x++;
                            }


                        }
                        System.out.println("Выберите номер телефона который менять : ");
                        choice = scanner.nextInt();
                        while (choice>x||choice<=0)
                        {
                            System.out.println("Выберите номер телефона от 1 до "+x);
                            choice = scanner.nextInt();
                        }
                        System.out.println("Введитетип  нового номера:");
                        str = scanner.nextLine();
                        P[id-1][choice-1].setType(str);
                        System.out.println("Введите новый номер:");
                        x = scanner.nextInt();
                        P[id-1][choice-1].setNumber( x);

                    }




                    break;
                case 4:
                    id = ChoiceId(kolvo);
                    for(int i = id-1;i<kolvo-1;i++)
                    {
                        en[i] = en[i+1];
                        en[i].setId(i+1);
                        P[i] = P [i+1];

                    }
                    en[kolvo-1]= new Entry();
                    P[kolvo-1] = new PhoneNumber[max];
                    kolvo--;



                    break;
                case 5:
                    do {
                        System.out.println("По какому параметру искать?");
                        System.out.println("1- по имени");
                        System.out.println("2- по фамилии");
                        System.out.println("3- по категории(семья, коллега, друг)");
                        System.out.println("4- по типу номера(домашний или рабочий)");
                        System.out.println("5- по номеру");
                        System.out.println("6- по ID записи");
                        x = scanner.nextInt();
                        scanner.nextLine();
                    }while( x > 6||x <=0);
                    switch (x)
                    {
                        case 1:
                            System.out.println("Введите имя для поиска");
                            str = scanner.nextLine();
                            x = 0;
                            System.out.println("Результат поиска:");
                            for(int i = 0;i<kolvo;i++)
                            {
                                x = x + en[i].srawName(str,P);
                            }
                            if(x == 0)
                            {
                                System.out.println("По задданному параметру ничего не найдено.");
                            }
                            break;
                        case 2:
                            System.out.println("Введите фамилию для поиска");
                            str = scanner.nextLine();
                            x = 0;
                            System.out.println("Результат поиска:");
                            for(int i = 0;i<kolvo;i++)
                            {
                                x = x + en[i].srawSurname(str, P);
                            }
                            if(x == 0)
                            {
                                System.out.println("По задданному параметру ничего не найдено.");
                            }
                            break;
                        case 3:
                            System.out.println("Введите категоию для поиска (семья, коллега, друг) ");
                            str = scanner.nextLine();
                            x = 0;
                            System.out.println("Результат поиска:");
                            for(int i = 0;i<kolvo;i++)
                            {
                                x = x + en[i].srawCategory(str, P);
                            }
                            if(x == 0)
                            {
                                System.out.println("По задданному параметру ничего не найдено.");
                            }
                            break;
                        case 4:
                            System.out.println("Введите тип номеров для поиска (домашний или рабочий)");
                            str = scanner.nextLine();
                            x = 0;
                            System.out.println("Результат поиска:");
                            for(int i = 0;i<kolvo;i++)
                            {
                                x = x + en[i].srawType(str,max,P);
                            }
                            if(x == 0)
                            {
                                System.out.println("По задданному параметру ничего не найдено.");
                            }
                            break;
                        case 5:
                            System.out.println("Введите номер для поиска");
                            y = scanner.nextInt();
                            x = 0;
                            System.out.println("Результат поиска:");
                            for(int i = 0;i<kolvo;i++)
                            {
                                x = x + en[i].srawNumber(y,max,P);
                            }
                            if(x == 0)
                            {
                                System.out.println("По задданному параметру ничего не найдено.");
                            }
                            break;
                        case 6:
                            System.out.println("Введите ID для поиска");
                            x = scanner.nextInt();
                            y = 0;
                            System.out.println("Результат поиска:");
                            for(int i = 0;i<kolvo;i++)
                            {
                                y = y + en[i].srawId(x,P);
                            }
                            if(y == 0)
                            {
                                System.out.println("По задданному параметру ничего не найдено.");
                            }
                            break;

                        default:
                            System.out.println("NICHEGO !!!");
                            break;
                    }
                    break;
                case 6:
                    System.out.println("Вы выбрали выход!");
                    exit = false;
                default:
                    System.out.println("Такого пункта меню не существует!!!");
                    break;
            }
        }
        } catch (Exception e) {
            System.out.println("ОШИБКА! Тип введенного вами числа не совпадает с типом данной переменной.");
        }

    }
}
