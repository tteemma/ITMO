interface AbleToEat{
    void eat();
}
public class AnanimClass {
    public static void main(String[] args) {
        AbleToEat ableToEat = new AbleToEat(){
          @Override
          public void eat(){
              System.out.println("dewdwedewdewdewd");
          }
        };
        AbleToEat ableTo1Eat = new AbleToEat(){
            @Override
            public void eat(){
                System.out.println("dewdwede3434243wdewdewd");
            }
        };

        ableToEat.eat();
        ableTo1Eat.eat();

    }
}
