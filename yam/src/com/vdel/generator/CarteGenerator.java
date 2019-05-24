package com.vdel.generator;

import com.vdel.Carte;
import com.vdel.Orientation;
import com.vdel.utils.YamUtils;

import static com.vdel.Carte.HAUTEUR;
import static com.vdel.Carte.LARGEUR;

public class CarteGenerator {


    public static Integer[][] generateCarte(){
        Integer[][] carte = new Integer[HAUTEUR][LARGEUR];
        for(int y = 0; y < HAUTEUR; y ++){
            for(int x = 0; x < LARGEUR; x++){
                carte[y][x] = 0;
            }
        }

        initIsland(carte,YamUtils.randomNumber(15,20),30,20);
        initIsland(carte,YamUtils.randomNumber(10,15),30,20);
        initIsland(carte,YamUtils.randomNumber(3,8));
        initIsland(carte,YamUtils.randomNumber(3,8));

        return carte;
    }


    private static void initIsland(Integer[][] carte, Integer rayon) {
        initIsland(carte,rayon,0,0);
    }

    private static void initIsland(Integer[][] carte, Integer rayon, Integer margeDeDepartX, Integer margeDeDepartY) {


        // On commence le tracé
        Integer longueurTrace = YamUtils.randomNumber(10,20);

        Orientation orientation = null;
        Integer startX = null;
        Integer startY = null;
        for(int i = 0 ; i < longueurTrace; i++){
            if(orientation == null){
                // Point de départ
                startX = YamUtils.randomNumber(0+margeDeDepartX,LARGEUR -1 - margeDeDepartY);
                startY = YamUtils.randomNumber(0+margeDeDepartY,HAUTEUR -1 - margeDeDepartY);
                orientation = Orientation.randomOrientation();
            }
            else{
                Orientation[] possibleOrientations = orientation.getPossibleOrientations();
                orientation = possibleOrientations[YamUtils.randomNumber(0,possibleOrientations.length-1)];
                startX = startX + orientation.getVariationX();
                startY = startY + orientation.getVariationY();
            }

            drawCircle(carte,startX,startY,rayon);

        }

        // rac((xb - xa)² + (yb - ya)²)
    }

    private static void drawCircle(Integer[][] carte,Integer startX, Integer startY, Integer rayon){
        for(int y = startY - rayon; y <= startY+ rayon; y++){
            if(y>=0 && y < HAUTEUR)
            for(int x = startX - rayon; x <= startX + rayon; x++){
                if(x>=0 && x < LARGEUR) {
                    Double distance = Math.sqrt(Math.pow(Double.valueOf(x - startX), 2) + Math.pow(Double.valueOf(y - startY), 2));
                    if (distance <= rayon) {
                        carte[y][x] = 1;
                    }
                }
            }
        }

    }
}
