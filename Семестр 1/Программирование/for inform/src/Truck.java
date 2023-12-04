public class Truck extends Transport{
    private boolean isLoadet;
    public Engine engine = new Engine();
    public Truck(int _weight,byte[] _coordinate ){
        super(_weight, _coordinate);
    }


    public Truck(int _weight,byte[] _coordinate, boolean _isloadet ){
        super(_weight, _coordinate);
        this.isLoadet = _isloadet;
        getValues();
    }
    public  void setLoadet(boolean loadet){
        this.isLoadet = loadet;
    }
    @Override
    protected String getValues(){
        System.out.println(super.getValues());
        return getLoadet();
    }
    @Override
    public void moveObject(float speed) {
        System.out.println("Объект двигается: " + speed);
    }
    @Override
    public boolean stopObject(){
        this.speed = 0;
        return true;
    }
    public String getLoadet(){
        if(isLoadet == true)
            return "\nTruck is loadet";
        else
            return  "\nTruck isn`t loadet";
    }
    //@Override
    public void setValues(float speed, int _weight, String _color, byte[] _coordinate,boolean isLoadet){
        super.setValues(speed, _weight, _color, _coordinate);
        this.isLoadet = isLoadet;

    }
}
