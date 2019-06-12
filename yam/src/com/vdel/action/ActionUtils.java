package com.vdel.action;

import com.vdel.Orientation;
import com.vdel.utils.YamUtils;
import com.vdel.world.Carte;
import com.vdel.world.Coord;
import com.vdel.world.CoordUtils;
import com.vdel.world.Universe;
import com.vdel.world.tile.Zone;

import java.util.List;
import java.util.stream.Collectors;

public class ActionUtils {
    public static Coord generateStartCoord() {

        List<Zone> zoneSeeInBordure = Universe.getInstance().getCarte().getCarte().values().stream().filter(
                z -> (z.getCoord().getX() == 0
                        || z.getCoord().getY() == 0
                        || z.getCoord().getY() == Carte.HAUTEUR - 1
                        || z.getCoord().getX() == Carte.LARGEUR - 1) && z.getTile() == Zone.Tile.SEA
        ).collect(Collectors.toList());
        Zone zone = zoneSeeInBordure.get(YamUtils.randomNumber(0,zoneSeeInBordure.size()));

        zone.setVisited(true);
        Orientation o = null;
        if(zone.getCoord().getX() == 0){
            o = Orientation.EST;
        }
        if(zone.getCoord().getY() == 0){
            o = Orientation.SUD;
        }
        if(zone.getCoord().getY() == Carte.HAUTEUR - 1){
            o = Orientation.NORD;
        }
        if(zone.getCoord().getX() == Carte.LARGEUR - 1){
            o = Orientation.NORD;
        }
        Coord newCoord = zone.getCoord();
        do{

            Orientation[] possibleOrientations = o.getPossibleOrientations();
            o = possibleOrientations[YamUtils.randomNumber(0,possibleOrientations.length-1)];
            Coord tmpCoord =CoordUtils.add(newCoord,o.getVariation());
            if(isCoordInMap(tmpCoord)){
                newCoord = tmpCoord;

                zone = Universe.getInstance().getCarte().getZone(newCoord);
                if( zone != null){

                    zone.setVisited(true);
                }
            }
        }
        while(zone == null || zone.getTile() == Zone.Tile.SEA);

        return newCoord;
    }

    private static boolean isCoordInMap(Coord tmpCoord) {
        if(tmpCoord != null && tmpCoord.getX() >= 0 && tmpCoord.getX() < Carte.LARGEUR
        && tmpCoord.getY() >= 0 && tmpCoord.getY() < Carte.HAUTEUR){
            return true;
        }
        else{
            return false;
        }
    }
}
