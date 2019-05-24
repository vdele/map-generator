package com.vdel;

import java.util.Date;

public class Universe {
    private Date time = null;
    private Carte carte  = null;

    private static Universe universe = null;

    private Universe(){
        time = new Date();
        carte = new Carte();
    }

    public static void start() {
        if(Universe.universe == null){
            universe = new Universe();
        }
    }

    public Date getTime() {
        return time;
    }

    public Carte getCarte() {
        return carte;
    }

    public static Universe getUniverse() {
        return universe;
    }
}
