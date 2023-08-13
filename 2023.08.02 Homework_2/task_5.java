/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные в произвольном порядке, 
 разделенные пробелом (данные вводятся одной строкой без запятых):
Фамилия Имя Отчество, дата рождения, номер телефона, пол

Форматы данных:
фамилия, имя, отчество - строки
дата рождения - строка формата dd.mm.yyyy
номер телефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, 
вернуть код ошибки. Создать метод, который обработает его и покажет пользователю сообщение, что он 
ввел меньше или больше данных, чем требуется.

Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. 
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно 
использовать встроенные типы java или создать свои. Исключение должно быть корректно обработано, 
пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии. 
В него в одну строку должны записаться полученные данные, вида:

Фамилия Имя Отчество, дата рождения, номер телефона, пол

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

Не забудьте закрыть соединение с файлом.

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, 
пользователь должен увидеть стектрейс ошибки.
 */

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class task_5 {

    static String[] parts;

    public static void main(String[] args) {

        menu();
    }

    private static void menu() {

        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Press '1' to input new user");
            System.out.println("Press '2' to quit");

            char menu = scan.nextLine().charAt(0);
            if (menu == '1') {
                insertnewman();
            } else if (menu == '2') {
                break;

            }
        }
    }

    private static void insertnewman() {

        try {
            parts = newman();
            while (countstring(parts) != 1) {
                parts = newman();
            }
            
            saveInFile(parts[0] + ".txt");
            // saveInFile("t/t/ttest.txt");
            System.out.println("Saved in " + parts[0] + ".txt:");

            for (String string : parts) {
                System.out.println(string);
            }

        } catch (WriteInFileException e) {
            e.printStackTrace();
            // System.out.println(e.getMessage());

        } catch (IllegalArgumentException e) {
            // e.printStackTrace();
            System.out.println(e.getMessage());

        }

    }

    static String[] newman() {

        Scanner scan = new Scanner(System.in);
        System.out.println(
                "Enter Second name, Name, Middle name, Birthday (dd.mm.yyyy), Phone number, Gender (f/m) with whitespaces ");

        String str = scan.nextLine();
        String[] parts = str.split(" ");
        return parts;

    }

    static int countstring(String[] parts) {
        if (parts.length != 6) {
            System.out.println("You entered " + parts.length + " of 6 strings");
            return 0;
        }

        if (!parts[0].matches("[^\\d\\s]+"))
            throw new IllegalArgumentException("Wrong first name");

        if (!parts[1].matches("[^\\d\\s]+"))
            throw new IllegalArgumentException("Wrong second name");

        if (!parts[2].matches("[^\\d\\s]+"))
            throw new IllegalArgumentException("Wrong middle name");

        if (!parts[3].matches("^\\d{2}.\\d{2}.\\d{4}$"))
            throw new IllegalArgumentException("Wrong birthday");

        if (!parts[4].matches("^\\d+$"))
            throw new IllegalArgumentException("Wrong phone");

        if (!parts[5].matches("[mfMF]"))
            throw new IllegalArgumentException("Wrong gender");

        return 1;

    }

    static void saveInFile(String filePath) throws WriteInFileException {

        FileWriter writer;
        try {
            writer = new FileWriter(filePath, true);
            for (String string : parts) {
                writer.append(string);
                writer.append(" ");
            }
            writer.append("\n");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new WriteInFileException("Save in " +filePath+ " file error", e);
            // TODO Auto-generated catch block
        }

    }
}
