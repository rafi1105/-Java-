import java.util.Scanner;
class test{
  static int sum;  
    int method(int a, int b){
        
        sum= a+b;
        return sum;
    }

    
    public static void main(String[] args) {
        Scanner scan= new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        double c  = scan.nextDouble();
        test obj = new test(); 
        obj.method(a,b);
        System.out.println(sum);
    }
}