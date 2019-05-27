package com.vdel.world.tile;

import static com.vdel.world.tile.Zone.Tile.TOWN;

public class Town extends Zone {
    @Override
    String getZoneName() {
        return "VILLE";
    }

    @Override
    Integer getVisibilite() {
        return 60;
    }

    @Override
    public Tile getTile() {
        return TOWN;
    }
}
