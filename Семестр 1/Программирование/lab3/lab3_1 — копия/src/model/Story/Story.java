package model.Story;

import model.Entity.*;
import model.Objects.*;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Story {

    Everyone<Troll> everyone = new Everyone<>();
    Board board = new Board();
    Shoal shoal = new Shoal("отмель");
    Boat boat = new Boat("boat");
    Coast coast = new Coast("берег");
    Mumi_Troll mumiTroll = new Mumi_Troll("Муми-троль");
    MumiMama mumiMama = new MumiMama("Муми-мама");
    Pancakes pancakes = new Pancakes(" оладьи");
    Tablecloth tablecloth = new Tablecloth("скатерть");
    Bottle bottle = new Bottle("бутылка");
    Bow bow = new Bow();
    Sand sand = new Sand();
    Stones stones = new Stones();
    List<Stone> st = new ArrayList<>();


    public void tellStory(){
        stones.setStones(st);
        StringJoiner sj = new StringJoiner(". ");
        sj.add(everyone + everyone.Stretched() + board.declensions() + everyone.watched());
        sj.add(mumiTroll.maneuver() + shoal.declensions() + ((mumiTroll.isMale()) ? "он" : "она") + mumiTroll.take(boat, coast));
        sj.add("\n" + Prepositions.Her + bow.getBow() + bow.poked() + Prepositions.In + sand.declensions());
        sj.add(mumiTroll + mumiTroll.jump()+ Prepositions.And + " вскоре " + coast + coast.revived());
        sj.add("\n" + mumiMama + mumiMama.puted(stones) + mumiMama.reheat(pancakes) + mumiMama.bring() + mumiMama.spread(sand) + mumiMama.putedTo(stones) + tablecloth.notCarry());
        sj.add("\n" + Prepositions.Then + mumiMama.placed() + mumiMama.buried(bottle) + Prepositions.In + " сырой" + sand.declensions() + " в тени от скалы и под конец" + mumiMama.decorated());

        String join = sj.toString();
        System.out.println(join);

    }
}
