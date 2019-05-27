package com.vdel.world.tile;

import static com.vdel.world.tile.Zone.Tile.FOREST;

public class Forest extends Zone {
    @Override
    String getZoneName() {
        return "FORET";
    }

    @Override
    Integer getVisibilite() {
        return 80;
    }

    @Override
    public Tile getTile() {
        return FOREST;
    }
}
