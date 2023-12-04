public abstract class Transport {
    protected float speed;
    protected  int weight;
    protected  String color;
    private byte[] coordinate;

    public Transport(){}
    public Transport(float _speed, int _weight, String _color, byte[] _coordinate){
        setValues(_speed,_weight,_color,_coordinate);
        System.out.println("Object^_^: \n");
        System.out.println(getValues());
    }
    public Transport(int _weight,byte[] _coordinate ){
        weight = _weight;
        coordinate = _coordinate;
        System.out.println("Object^_^: \n");
        //System.out.println(this.getValues());
    }
    public abstract void moveObject(float speed);
    public abstract boolean stopObject();

    protected void setValues(float speed, int _weight, String _color, byte[] _coordinate){
        this.speed = speed;
        weight = _weight;
        color = _color;
        coordinate = _coordinate;
    }
    protected String getValues(){
        String info = "Object speed: " + speed + " weight: " + weight + " color " + color + ". \n";
        String infoCord = "Cord: \n";
        for (int i = 0; i < coordinate.length; i++){
            infoCord += coordinate[i] + " ";
        }
        return info + infoCord;
    }

    class Engine {

        private boolean isReady;
        private int km;

        public int sq = 100;
        public  void isReady(boolean isReady){
            this.isReady = isReady;
        }

        public void setValues(boolean isReady, int km){
            this.isReady = isReady;
            this.km = km;
        }

        public void info(){
            if(isReady){
                System.out.println("Engine true");
            }
            else{
                System.out.println("Engine false, he go: " + km + " km");
            }
        }

    }

}
