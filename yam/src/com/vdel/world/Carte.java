package com.vdel.world;

import com.vdel.Personne;
import com.vdel.world.tile.Zone;

import java.util.*;


public class Carte {

    public static final Integer HAUTEUR = 60;
    public static final Integer LARGEUR = 90;

    protected static final Carte INSTANCE = new Carte();

    private Set<Personne> population;

   // private Zone[][] carte = null;
    private Map<Coord,Zone> carte = null;

    private Carte(){
        carte = new HashMap<>();

        CarteGenerator.generateCarte(this);
    }

    public Map<Coord,Zone> getCarte(){
        return carte;
    }


    public Zone getZone(Coord coord){
        return carte.get(coord);
    }
    public Zone getZone(Integer x, Integer y){
        return getZone(Coord.valueOf(x,y));
    }

    public void setZone(Coord coord, Zone z){

       carte.put(coord,z);

       z.setCoord(coord);

    }

    public Set<Personne> getPopulation(){
        return population;
    }

    public void addPopulation(Personne p){
        if(p!= null){
            if(population == null){
                population = new HashSet<>();
            }
            population.add(p);
        }
    }
    public void addPopulation(Collection<Personne> p){
        if(p!= null){
            if(population == null){
                population = new HashSet<>();
            }
            population.addAll(p);
        }
    }

}
