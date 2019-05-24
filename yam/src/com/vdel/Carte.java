package com.vdel;

public class Carte {
    public static final Integer HAUTEUR = 60;
    public static final Integer LARGEUR = 90;

    private Lieu[][] carte = new Lieu[HAUTEUR][LARGEUR];


    public Lieu getLieu(Integer X, Integer Y){
        return carte[Y][X];
    }
}
