// use encapsulation
import java.util.Scanner;

class Area{
    private int area;
   
   
    public void setDim(int lenght, int breadth){
        area= lenght*breadth;

    }
 public    int   getArea(){
        return area;

    }
   
}
public class pro1 {
    static Scanner scan= new Scanner(System.in);
    public static void main(String[] args) {
        Area obj = new Area();
        System.out.println("enter the length: " );
        int l=scan.nextInt();
        System.out.println("enter the  breagth: " );
        int b=scan.nextInt();
        obj.setDim(l, b);
        System.out.println( " the Area is: "+ obj.getArea());
    }
}
