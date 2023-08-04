// Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
// Пользователю должно показаться сообщение, что пустые строки вводить нельзя.

import java.util.Scanner;

public class task_4 {
    

    public static void main(String[] args) {
      try{
        rline();
      }catch (IllegalArgumentException e){
        System.out.println(e.getMessage());
      }
        
    }

    static void rline() throws IllegalArgumentException {
    
       
        Scanner scan = new Scanner (System.in);
        System.out.print("Enter the string: ");
        String str =scan.nextLine();

        if (str.equals("")){
            throw new IllegalArgumentException("You cannot make empty strings!");
        } else{
             System.out.println("You entered "+str);
        }

        
        
        
    }
}
       

    



