import java.util.Scanner;
public class pro3 {
    int num;
    String address;
    void show(){
 System.out.println(address);

    }
    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            pro3 sam = new pro3();
            pro3 john = new pro3();
             sam.address = scan.nextLine();
            sam.show();
            john.address ="bogura";
            john.show();
        }
    }
}
