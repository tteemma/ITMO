public class MyClass {
    // Статический блок инициализации класса
    static {
        System.out.println("Это статический блок инициализации класса.");
    }
    {
        System.out.println("Metod");
    }
    public MyClass(){
        System.out.println("dewdewfewfew");
    }

    // Статический метод
    public static void staticMethod() {
        System.out.println("Это статический метод.");
    }

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        MyClass.staticMethod();

    }
}