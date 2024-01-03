// insertion 
          // length
          //print
          // delete
public class LinkList {
     Node head;
     class Node{
          String data; 
          Node next;
          Node (String data){
               this.data = data;
               this.next = null;
          }
     }
     // add - first,last
     public void addfirst(String data){
          Node newNode = new Node(data);
          if (head==null){
              head = newNode;
             
              return;
          }
               newNode.next=head;
               head=newNode;     
     }
     // add last
 public void addlast(String data){
     Node newNode = new Node(data);
      if (head==null){
              head = newNode;
         
              return;
          }
     Node tempNode=head;
     while (tempNode.next!=null){
          tempNode=tempNode.next;
     }
          tempNode.next=newNode;
     
          return;
}
public void printlist(){
      Node tempNode=head;
      if (head==null){
          System.out.println("List is empty");
          return;
      }
     while (tempNode!=null){
          System.out.println(tempNode.data+"- > ");
          tempNode=tempNode.next;
     }
         
          return;
}
     public static void main(String[] args) {
          LinkList list = new LinkList();
          list.addfirst("4");
          list.addfirst("5");
          list.addlast("a");
          list.addlast("is");
          list.printlist();


     }
}
