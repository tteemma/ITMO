public class Car extends Transport implements  ILights{
    private boolean isOn;
    public Car(){}
    public  Car(float _speed, int _weight, String _color, byte[] _coordinate){
        super(_speed, _weight, _color, _coordinate);

        setValues(_speed, _weight, _color, _coordinate);
    }
    public Engine engine = new Engine();



    @Override
    public void moveObject(float speed) {
        System.out.println("Объект двигается: " + speed);
    }
    @Override
    public boolean stopObject(){
        this.speed = 0;
        return true;
    }

    @Override
    public void setLight(boolean set) {
        this.isOn = set;
    }
    @Override
    public void blinkLight() {
        System.out.println("Blink your light");
    }
}
