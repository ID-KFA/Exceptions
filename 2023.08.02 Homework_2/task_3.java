

public class task_3 {

    public static void main(String[] args)  {
  
       int a = 90;
       int b = 3;

       if (b==0){
        System.out.println("Cannot divide by 0 ");
     } else {
        System.out.println(a / b);
     }
       printSum(23, 234);

       int[] abc = { 1, 2 };
       int index = 1;
       if (index >= 0 && index < abc.length){
         abc[index]=9;    
        
       } else {
             System.out.println("Index is out of bounds");
       }
    

}
public static void printSum(int a, int b) {
   System.out.println(a + b);
}

    
}
