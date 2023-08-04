// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
//  и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, 
// вместо этого, необходимо повторно запросить у пользователя ввод данных.

import java.util.Scanner;

public class task_1 {
    

    public static void main(String[] args) {
       
        
       while(true)
       {
        Scanner scan = new Scanner (System.in);
        System.out.print("Enter the float number: ");
        String num =scan.nextLine();

        if (num.matches("-?\\d+(\\.\\d+)?")){
            
            System.out.println(num);
            break;

        } else {
            System.out.println("Wrong number");
        }
       }


        
        
        
    }
}
       

    



