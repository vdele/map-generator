package com.vdel.world;

import com.vdel.Orientation;
import com.vdel.utils.YamUtils;
import com.vdel.world.tile.*;

import static com.vdel.world.Carte.HAUTEUR;
import static com.vdel.world.Carte.LARGEUR;


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
                carte.setZone(x,y,new Sea());
            }
        }
    }

    private static void pickSmallZone(Carte carte,Integer nbPick, Zone tile){
        for(int i = 0; i < nbPick; i++){
            initTileZone(carte,YamUtils.randomNumber(2,3),tile,YamUtils.randomNumber(2,4));
        }
    }

    private static void generateTown(Carte carte) {

        initTileZone(carte,YamUtils.randomNumber(5,10),new Town(),YamUtils.randomNumber(2,4));

        pickSmallZone(carte,5,new Town());
    }
    private static void generateForest(Carte carte) {

        pickSmallZone(carte,5,new Forest());
    }

    private static void generateEarth(Carte carte) {


        initTileZone(carte,YamUtils.randomNumber(25, 30), 30, 20,new Earth(),YamUtils.randomNumber(15, 20));
        initTileZone(carte,YamUtils.randomNumber(15, 20), 30, 20,new Earth(),YamUtils.randomNumber(10, 20));
        initTileZone(carte,YamUtils.randomNumber(8, 10),new Earth(),YamUtils.randomNumber(10, 20));
        initTileZone(carte,YamUtils.randomNumber(8, 10),new Earth(),YamUtils.randomNumber(10, 20));
    }



    private static void initTileZone(Carte carte,Integer rayon, Zone tile, Integer longueurTrace) {
        initTileZone(carte,rayon, 0, 0, tile,longueurTrace);
    }

    private static void initTileZone(Carte carte,Integer rayon, Integer margeDeDepartX, Integer margeDeDepartY, Zone zone, Integer longueurTrace) {



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
                while(zone.getTile().getLevel() - carte.getZone(startX,startY).getTile().getLevel() != 1);
                orientation = Orientation.randomOrientation();
            } else {
                Orientation[] possibleOrientations = orientation.getPossibleOrientations();
                orientation = possibleOrientations[YamUtils.randomNumber(0, possibleOrientations.length - 1)];

                startX = startX + orientation.getVariationX();
                startY = startY + orientation.getVariationY();
            }

            drawCircle(carte,startX, startY, rayon, zone);

        }

        // rac((xb - xa)² + (yb - ya)²)
    }

    private static void drawCircle(Carte carte,Integer startX, Integer startY, Integer rayon, Zone zone) {
        for (int y = startY - rayon; y <= startY + rayon; y++) {
            if (y >= 0 && y < HAUTEUR)
                for (int x = startX - rayon; x <= startX + rayon; x++) {
                    if (x >= 0 && x < LARGEUR) {
                        Double distance = Math.sqrt(Math.pow(x - startX, 2) + Math.pow(y - startY, 2));
                        if (distance <= rayon) {
                            if(zone.getTile().getLevel() - carte.getZone(x,y).getTile().getLevel() == 1) {
                                carte.setZone(x,y,zone);
                            }
                        }
                    }
                }
        }

    }
}
