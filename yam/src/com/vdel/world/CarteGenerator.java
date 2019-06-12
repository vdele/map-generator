package com.vdel.world;

import com.vdel.Orientation;
import com.vdel.utils.YamUtils;
import com.vdel.world.tile.*;
import com.vdel.world.tile.Zone.Tile;

import static com.vdel.world.Carte.HAUTEUR;
import static com.vdel.world.Carte.LARGEUR;
import static com.vdel.world.tile.Zone.Tile.*;


public class CarteGenerator {

    protected static void generateCarte(Carte carte) {
        //Zone[][] carte = new Sea[HAUTEUR][LARGEUR];
        generateOcean(carte);
        generateEarth(carte);
        generateTown(carte);
        generateForest(carte);
    }

    private static void generateOcean(Carte carte) {

        for(int y = 0; y < HAUTEUR; y++){
            for(int x = 0; x < LARGEUR; x++){
                carte.setZone(Coord.valueOf(x,y),new Sea());
            }
        }
    }

    private static void pickSmallZone(Carte carte,Integer nbPick, Tile tile){
        for(int i = 0; i < nbPick; i++){
            initTileZone(carte,YamUtils.randomNumber(2,3),tile,YamUtils.randomNumber(2,4));
        }
    }

    private static void generateTown(Carte carte) {

        initTileZone(carte,YamUtils.randomNumber(5,10),TOWN,YamUtils.randomNumber(2,4));

        pickSmallZone(carte,5,TOWN);
    }
    private static void generateForest(Carte carte) {

        pickSmallZone(carte,5,FOREST);
    }

    private static void generateEarth(Carte carte) {


        initTileZone(carte,YamUtils.randomNumber(25, 30), EARTH,YamUtils.randomNumber(15, 20));
        initTileZone(carte,YamUtils.randomNumber(15, 20),EARTH,YamUtils.randomNumber(10, 20));
        initTileZone(carte,YamUtils.randomNumber(8, 10),EARTH,YamUtils.randomNumber(10, 20));
        initTileZone(carte,YamUtils.randomNumber(8, 10),EARTH,YamUtils.randomNumber(10, 20));
    }



    private static void initTileZone(Carte carte,Integer rayon, Tile tile, Integer longueurTrace) {


        Orientation orientation = null;
        Integer startX = null;
        Integer startY = null;
        for (int i = 0; i < longueurTrace; i++) {
            if (orientation == null) {
                // Point de départ, commencer uniquement si la différence de niveau == 1
                do{
                   /* startX = YamUtils.randomNumber(0 + margeDeDepartX, LARGEUR - 1 - margeDeDepartY);
                    startY = YamUtils.randomNumber(0 + margeDeDepartY, HAUTEUR - 1 - margeDeDepartY);*/
                    startX = YamUtils.randomNumber(0 , LARGEUR - 1);
                    startY = YamUtils.randomNumber(0, HAUTEUR - 1 );
                }
                while(tile.getLevel() - carte.getZone(Coord.valueOf(startX,startY)).getTile().getLevel() != 1);
                orientation = Orientation.randomOrientation();
            } else {
                Orientation[] possibleOrientations = orientation.getPossibleOrientations();
                orientation = possibleOrientations[YamUtils.randomNumber(0, possibleOrientations.length - 1)];

                startX = startX + orientation.getVariation().getX();
                startY = startY + orientation.getVariation().getY();
            }

            drawCircle(carte,Coord.valueOf(startX, startY), rayon, tile);

        }

        // rac((xb - xa)² + (yb - ya)²)
    }

    private static void drawCircle(Carte carte,Coord center, Integer rayon, Tile tile) {
        for (int y = center.getY() - rayon; y <= center.getY() + rayon; y++) {
            if (y >= 0 && y < HAUTEUR)
                for (int x = center.getX() - rayon; x <= center.getX() + rayon; x++) {
                    if (x >= 0 && x < LARGEUR) {
                        Double distance = Math.sqrt(Math.pow(x - center.getX(), 2) + Math.pow(y - center.getY(), 2));
                        if (distance <= rayon) {
                            if(tile.getLevel() - carte.getZone(Coord.valueOf(x,y)).getTile().getLevel() == 1) {
                                Zone zone = tile.instantiateZone();

                                carte.setZone(Coord.valueOf(x,y),zone);
                                carte.addPopulation(zone.getHabitants());
                            }
                        }
                    }
                }
        }

    }
}
