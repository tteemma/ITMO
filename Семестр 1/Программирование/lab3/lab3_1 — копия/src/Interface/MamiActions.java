package Interface;

import model.Entity.Stone;
import model.Objects.Bottle;
import model.Objects.Pancakes;
import model.Objects.Sand;
import model.Objects.Stones;

import java.util.List;

public interface MamiActions {
    String puted(Stones stones);
    String putedTo(Stones stones);
    String reheat(Pancakes pancakes);
    String bring();
    String spread(Sand sand);
    String placed();
    String buried(Bottle bottle);
    String decorated();
}
