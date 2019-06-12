package com.vdel.world.tile;

import com.vdel.world.element.Habitation;

import java.util.List;

import static com.vdel.world.tile.Zone.Tile.TOWN;

public class Town extends Zone {

    public List<Habitation> habitations;

    @Override
    public String getZoneName() {
        return "VILLE";
    }

    @Override
    public Integer getVisibilite() {
        return 40;
    }

    @Override
    public Tile getTile() {
        return TOWN;
    }

    @Override
    public Integer getHabitationPercentage() {
        return 30;
    }

    @Override
    public Integer getHabitationMaximum() {
        return 8;
    }

    public List<Habitation> getHabitations() {
        return habitations;
    }

    public void setHabitations(List<Habitation> habitations) {
        this.habitations = habitations;
    }
}
