package kz.kolmykov;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Тригер на выход из программы
        int outputVariable = 1;

        System.out.println("Здравствуте, выберите номер игры: \n1) Угадайте загаданное число от 0 до 9\n2) Угадать загаданное слово");
        System.out.println("0) Выход из программы");

        do {
            if(scanner.hasNextInt()){
                int taskNumber = scanner.nextInt();
                switch (taskNumber){
                    //Выход из программы
                    case 0:
                        System.out.println("Выход из программы.");
                        outputVariable = 0;
                        break;
                    //Угада число
                    case 1:
                        guessTheNumber();
                        scanner.nextLine();
                        break;
                    //Угадай слово
                    case 2:
                        guessTheWord();
                        scanner.nextLine();
                        break;
                    //Введено неверное число
                    default:
                        System.out.println("Номер задачи не найден. Повторите попытку ввода номера задачи.");
                        scanner.nextLine();
                }
            }
            else {
                System.out.println("Вы ввели некоректный вариант. Повторите попытку ввода номера задачи.");
                scanner.nextLine();
            }

        }
        while (outputVariable != 0);


    }

    static void guessTheNumber(){

        int outputVariableForCase1 = 1;

        do{
            System.out.println("Загадано число от 0 до 10. Попробуйте его угадать ;)");
            int number = 0;
            Random random = new Random();
            number = random.nextInt(10);

            Scanner scanner = new Scanner(System.in);



            //Счётчик попыток
            int counter = 0;

            do{
                //Число от пользователя
                scanner.hasNextInt();
                int numberAnswer = scanner.nextInt();

                if(number > numberAnswer){
                    System.out.println("Ваше число меньше загаданного");
                    counter++;
                    scanner.nextLine();
                }
                else if(number < numberAnswer) {
                    System.out.println("Ваше число больше загаданного");
                    counter++;
                    scanner.nextLine();
                }
                else {
                    System.out.println("Вы угадали число!!!");
                    scanner.nextLine();
                    break;
                }
            }
            while (counter < 3);


            int numberForReload = -1;
            //Повторить или выйти?
            System.out.println("Хотите сыграть ещё раз?\n1 - для повтора\n0 - для выхода в главное меню");

            do{
                scanner.nextLine();
                if(scanner.hasNextInt()){
                    switch (numberForReload = scanner.nextInt()){
                        case 0:
                            outputVariableForCase1 = 0;
                            scanner.nextLine();
                            break;
                        case 1:
                            outputVariableForCase1 = 1;
                            scanner.nextLine();
                            break;
                        default:
                            System.out.println("Такого варианта нет. Повторите попытку.");
                    }
                }
                else {
                    System.out.println("Вы ввели некоректный вариант значения");
                }
            }
            while (numberForReload != 1 || numberForReload != 0);

        }
        while (outputVariableForCase1 != 1);
        //Загаданное число


    }

    static void guessTheWord(){
        System.out.println("task 2");
    }


}
