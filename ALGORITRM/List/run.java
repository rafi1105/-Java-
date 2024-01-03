public class run {
     static void Staticmethod(){
          System.out.println("i am running without object");
     }
     public void publicmethod(){
          System.out.println("i am running with object");
          
     }
     public static void main(String[] args) {
          run obj=new run();
          obj.publicmethod();
          Staticmethod();
     }
}
