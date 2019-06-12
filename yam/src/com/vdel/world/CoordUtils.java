package com.vdel.world;

import com.vdel.utils.ArrayUtils;

public class CoordUtils {


    public static Coord add(Coord... coords){
        Coord coord = null;

        if(ArrayUtils.isNotEmpty(coords)){
            Integer x = 0;
            Integer y = 0;
            for (Coord c : coords) {
                x += c.getX();
                y += c.getY();
            }
            coord = Coord.valueOf(x,y);

        }

        return coord;
    }
}
