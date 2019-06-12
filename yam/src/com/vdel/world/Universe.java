package com.vdel.world;

import com.vdel.Heros;

public class Universe {

    private Boolean devMode = false;

    private static final Universe universe = new Universe();
    private final Carte carte = Carte.INSTANCE;
    private Heros heros = null;

    public static final Universe getInstance(){
        return universe;
    }


    public Carte getCarte(){
        return carte;
    }

    public Boolean isDevMode() {
        return devMode;
    }

    public void setDevMode(Boolean devMode) {
        this.devMode = devMode;
    }

    public void setHeros(Heros heros) {
        this.heros = heros;
    }

    public Heros getHeros() {
        return heros;
    }
}
