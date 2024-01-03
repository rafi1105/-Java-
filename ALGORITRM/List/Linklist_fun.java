import java.util.LinkedList;

public class Linklist_fun {
     public static void main(String[] args) {
          LinkedList<String> list = new LinkedList<String>(); // <type of the list> list is the object =() means empty list
          list.add("a"); // add default function its add first
          list.addFirst("this"); 
          list.addLast("b");
          System.out.println(list); // list function prints list
          System.out.println(list.size());

         
          list.set(0, "e"); // set default function its add first
           for(int i=0; i<list.size(); i++){
               System.out.print(list.get(i)+"->"); // get method print postion list values
          }
     }     
}
