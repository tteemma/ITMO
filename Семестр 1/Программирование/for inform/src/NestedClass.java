public class NestedClass {
    private int id;
    private static int tr = 1;
    public NestedClass(int id){
        this.id = id;
    }
    //Вложенный не статический class, относится к объекту
    private class Motor{
        public void stMotor(){
            System.out.println("IDI NAX MISHA + " + id);
        }
    }
    //Статический вложенный класс
    public static class Battery{
        public void charge(){
            System.out.println("Battery is charging" + tr);
        }
    }
    public void Start(){
        Motor motor = new Motor();
        motor.stMotor();
        System.out.println("Electrocar " + id + " is start//////");

        final int x = 12;
        class SomeClass{
            public void someMethod(){
                System.out.println(x);
                System.out.println(id);
            }
        }
        SomeClass someClass = new SomeClass();
        someClass.someMethod();
    }
    private void Test(Object o){
        System.out.println("wefewfewfw");
    }
}
class Test{
    public static void main(String[] args) {
        NestedClass electr = new NestedClass(1);
        electr.Start();
        NestedClass.Battery battery = new NestedClass.Battery();
        battery.charge();
        electr.Start();


    }
}
