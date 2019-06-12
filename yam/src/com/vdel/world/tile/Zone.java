package com.vdel.world.tile;

import com.vdel.Ennemi;
import com.vdel.Personne;
import com.vdel.utils.Haikunator;
import com.vdel.utils.YamUtils;
import com.vdel.world.Coord;

import java.util.ArrayList;
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


        public Zone instantiateZone(){
            switch(this){

                case SEA:
                    return new Sea();
                case EARTH:
                    return new Earth();
                case TOWN:
                    return new Town();
                case FOREST:
                    return new Forest();
            }
            return null;
        }
    }


    private Coord coord;
    private List<Personne> habitants;
    private List<Ennemi> ennemis;
    public Boolean visited = false;


    public abstract String getZoneName();
    public abstract Integer getVisibilite();
    public abstract Tile getTile();
    public abstract Integer getHabitationPercentage();
    public abstract Integer getHabitationMaximum();


    public Zone(){
        initPopulationZone();

    }

    private void initPopulationZone() {
        for(Integer i = 0; i < getHabitationMaximum(); i++){
            Integer result = YamUtils.launchDice(100);
            if(result <= getHabitationPercentage()){
                Personne p = new Personne();
                p.setName("Personne - "+ Haikunator.INSTANCE.haikunate());
                p.setZone(this);
                if(habitants == null){
                    habitants = new ArrayList<>();
                }
                habitants.add(p);
            }
        }
    }

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

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }
}
