package com.vdel.world.tile;

import com.vdel.Ennemi;
import com.vdel.Personne;

import java.util.List;

public abstract class Zone {

    public enum Tile {
        SEA(0),
        EARTH(1),
        TOWN(2),
        FOREST(2);

        private Integer level = null;

        Tile(Integer level) {
            this.level = level;
        }

        public Integer getLevel(){
            return level;
        }
    }


    abstract String getZoneName();
    abstract Integer getVisibilite();
    public abstract Tile getTile();


    private List<Personne> habitants;
    private List<Ennemi> ennemis;

    public Boolean visited = false;

    public List<Personne> getHabitants() {
        return habitants;
    }

    public void setHabitants(List<Personne> habitants) {
        this.habitants = habitants;
    }

    public List<Ennemi> getEnnemis() {
        return ennemis;
    }

    public void setEnnemis(List<Ennemi> ennemis) {
        this.ennemis = ennemis;
    }

    public Boolean getVisited() {
        return visited;
    }

    public void setVisited(Boolean visited) {
        this.visited = visited;
    }
}
