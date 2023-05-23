package method_overriding;

 class overriding1 {
    public void show()
    {
        System.out.println("not  working-> method_overriding");
    }
}
class overriding2 extends overriding1{
        @Override
        public void show()
        {
           System.out.println("working -> method_overriding");
        }
}
class overriding{
    public static void main(String[] args)
    {
        overriding1 obj1 = new overriding1();
        obj1.show();
        overriding2 obj2 = new overriding2();
        obj2.show();
        // working method_overriding 
        overriding1 obj = new overriding2();
        obj.show();
    }
}
