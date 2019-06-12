package com.vdel.world.tile;

import static com.vdel.world.tile.Zone.Tile.FOREST;

public class Forest extends Zone {
    @Override
    public String getZoneName() {
        return "FORET";
    }

    @Override
    public Integer getVisibilite() {
        return 20;
    }

    @Override
    public Tile getTile() {
        return FOREST;
    }

    @Override
    public Integer getHabitationPercentage() {
        return 2;
    }

    @Override
    public Integer getHabitationMaximum() {
        return 4;
    }
}
