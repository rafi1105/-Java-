class student{
  String name;
  int roll;
  void show(){
    System.out.println("student name: " + name+ "\t \t \n roll: " + roll);
  }

}
public class pro2 {
    public static void main(String[] args) {
        student object= new student();
        object.name= "john";
        object.roll = 2;
        object.show();

    }
}
