package com.vdel.utils;

public class YamUtils {


    public static Integer launchDice(Integer nbFace) {

        return randomNumber(1,nbFace);
    }

    public static Integer randomNumber(Integer start, Integer end){
        Double rand = Math.random() * (end - start + 1 );

        return rand.intValue() + start;

    }
}
