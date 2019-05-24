package com.vdel.generator;

import com.vdel.Orientation;
import com.vdel.utils.YamUtils;

import static com.vdel.Carte.HAUTEUR;
import static com.vdel.Carte.LARGEUR;
import static com.vdel.generator.CarteGenerator.Tile.*;

public class CarteGenerator {

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
    }


    public static Tile[][] generateCarte() {
        Tile[][] carte = new Tile[HAUTEUR][LARGEUR];

        generateOcean(carte);
        generateEarth(carte);
        generateTown(carte);
        generateForest(carte);

        return carte;
    }

    private static void pickSmallZone(Tile[][] carte, Integer nbPick, Tile tile){
        for(int i = 0; i < nbPick; i++){
            initTileZone(carte, YamUtils.randomNumber(1,3),tile,YamUtils.randomNumber(1,4));
        }
    }

    private static void generateTown(Tile[][] carte) {

        initTileZone(carte, YamUtils.randomNumber(3,5),TOWN,YamUtils.randomNumber(1,4));

        pickSmallZone(carte,5,TOWN);
    }
    private static void generateForest(Tile[][] carte) {

        pickSmallZone(carte,5,FOREST);
    }

    private static void generateEarth(Tile[][] carte) {


        initTileZone(carte, YamUtils.randomNumber(15, 20), 30, 20,EARTH,YamUtils.randomNumber(15, 20));
        initTileZone(carte, YamUtils.randomNumber(10, 15), 30, 20,EARTH,YamUtils.randomNumber(10, 20));
        initTileZone(carte, YamUtils.randomNumber(3, 8),EARTH,YamUtils.randomNumber(10, 20));
        initTileZone(carte, YamUtils.randomNumber(3, 8),EARTH,YamUtils.randomNumber(10, 20));
    }

    private static void generateOcean(Tile[][] carte) {
        for (int y = 0; y < HAUTEUR; y++) {
            for (int x = 0; x < LARGEUR; x++) {
                carte[y][x] = SEA;
            }
        }
    }


    private static void initTileZone(Tile[][] carte, Integer rayon, Tile tile, Integer longueurTrace) {
        initTileZone(carte, rayon, 0, 0, tile,longueurTrace);
    }

    private static void initTileZone(Tile[][] carte, Integer rayon, Integer margeDeDepartX, Integer margeDeDepartY, Tile tile, Integer longueurTrace) {



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
                while(tile.getLevel() - carte [startY][startX].getLevel() != 1);
                orientation = Orientation.randomOrientation();
            } else {
                Orientation[] possibleOrientations = orientation.getPossibleOrientations();
                orientation = possibleOrientations[YamUtils.randomNumber(0, possibleOrientations.length - 1)];

                startX = startX + orientation.getVariationX();
                startY = startY + orientation.getVariationY();
            }

            drawCircle(carte, startX, startY, rayon, tile);

        }

        // rac((xb - xa)² + (yb - ya)²)
    }

    private static void drawCircle(Tile[][] carte, Integer startX, Integer startY, Integer rayon, Tile tile) {
        for (int y = startY - rayon; y <= startY + rayon; y++) {
            if (y >= 0 && y < HAUTEUR)
                for (int x = startX - rayon; x <= startX + rayon; x++) {
                    if (x >= 0 && x < LARGEUR) {
                        Double distance = Math.sqrt(Math.pow(Double.valueOf(x - startX), 2) + Math.pow(Double.valueOf(y - startY), 2));
                        if (distance <= rayon) {
                            if(tile.getLevel() - carte [y][x].getLevel() == 1) {
                                carte[y][x] = tile;
                            }
                        }
                    }
                }
        }

    }
}
