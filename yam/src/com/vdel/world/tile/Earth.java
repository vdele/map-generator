package com.vdel.world.tile;


import static com.vdel.world.tile.Zone.Tile.EARTH;

public class Earth extends Zone {


    @Override
    public String getZoneName() {
        return "PLAINE";
    }

    @Override
    public Integer getVisibilite() {
        return 70;
    }

    @Override
    public Tile getTile() {
        return EARTH;
    }

    @Override
    public Integer getHabitationPercentage() {
        return 2;
    }

    @Override
    public Integer getHabitationMaximum() {
        return 10;
    }
}
