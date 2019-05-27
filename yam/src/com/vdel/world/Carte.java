package com.vdel.world;

import com.vdel.world.tile.Sea;
import com.vdel.world.tile.Zone;

import java.util.ArrayList;
import java.util.List;

public class Carte {

    public static final Integer HAUTEUR = 60;
    public static final Integer LARGEUR = 90;

    public static final Carte INSTANCE = new Carte();

    // private List<List<Zone>> carte = null;
    private Zone[][] carte = null;

    private Carte(){
        carte = new Zone[HAUTEUR][LARGEUR];



        CarteGenerator.generateCarte(this);


    }


    public Zone getZone(Integer X, Integer Y){
        return carte[Y][X];
    }

    public void setZone(Integer X, Integer Y, Zone z){
       /* if(getZone(X,Y) == null){
            carte.get(Y).add(X,z);
        }
        else{
            carte.get(Y).set(X,z);
        }*/

       carte[Y][X] = z;

    }

}
