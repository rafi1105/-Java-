class b{
  static  int c;
    b(int a , int b)
    {
        c=a+b;
    }
    void show(){
        System.out.println(c);
    }
}
class c{
    int s;
    c(b ref){
        s=ref.c;
        System.out.println("print class B value -> "+ s);
    }
}
class a{
    public static void main(String[] args) {
        b obj = new b(40,60);
        obj.show();
        c obj1= new c (obj);
    }
}
