import model.Entity.Mumi_Troll;
import model.Objects.Boat;
import model.Objects.Coast;

public class Main {
    public static void main(String[] args) {
        Mumi_Troll troll = new Mumi_Troll("Mumi-Troll");
        System.out.println(troll.maneuver() + troll.take(new Boat("лодка"), new Coast("берег")));
    }
}