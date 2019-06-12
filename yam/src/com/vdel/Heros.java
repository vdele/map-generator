package com.vdel;


import com.vdel.world.Coord;

public class Heros {

    private String name;
    private Integer niveau;
    private Coord coord;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNiveau() {
        return niveau;
    }

    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

    public Heros(){
        this.niveau = 1;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }
}
