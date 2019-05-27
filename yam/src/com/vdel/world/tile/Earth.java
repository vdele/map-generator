package com.vdel.world.tile;


import static com.vdel.world.tile.Zone.Tile.EARTH;

public class Earth extends Zone {


    @Override
    String getZoneName() {
        return "PLAINE";
    }

    @Override
    Integer getVisibilite() {
        return 30;
    }

    @Override
    public Tile getTile() {
        return EARTH;
    }
}
