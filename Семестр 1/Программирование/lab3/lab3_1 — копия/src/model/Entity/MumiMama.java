package model.Entity;

import Interface.MamiActions;
import model.Objects.Bottle;
import model.Objects.Pancakes;
import model.Objects.Sand;
import model.Objects.Stones;


import java.util.List;

public class MumiMama extends Troll implements MamiActions {
    public MumiMama(String name) {
        super(name,Gender.FEMALE);
    }


    @Override
    public String puted(Stones stones) {
        return " сложила " + Prepositions.Of +stones.declensions() + " очаг, ";
    }
    @Override
    public String putedTo(Stones stones) {
        return " и на каждый угол положила " + stones;
    }

    @Override
    public String reheat(Pancakes pancakes) {
        return "чтобы подогреть" + pancakes;
    }

    @Override
    public String bring() {
        return ", натаскала дров, ";
    }

    @Override
    public String spread(Sand sand) {
        return "расстелила" + " " + sand.mumiMam() + " скатерть";
    }

    @Override
    public String placed() {
        return " расставила чашки, ";
    }

    @Override
    public String buried(Bottle bottle) {
        return "закопала" + " " + bottle.declensions() + bottle.butter.declensions();
    }

    @Override
    public String decorated() {
        return " украсила стол букетом береговых лилий.";
    }
}
