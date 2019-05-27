package com.vdel.world.tile;

import com.vdel.Ennemi;
import com.vdel.Personne;

import java.util.List;

import static com.vdel.world.tile.Zone.Tile.SEA;

public class Sea extends Zone {


    @Override
    public String getZoneName() {
        return "La mer";
    }

    @Override
    public Integer getVisibilite() {
        return 10;
    }

    @Override
    public Tile getTile() {
        return SEA;
    }

    @Override
    public List<Personne> getHabitants() {
        return null;
    }

    @Override
    public List<Ennemi> getEnnemis() {
        return null;
    }
}
