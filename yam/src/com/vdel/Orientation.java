package com.vdel;

import com.vdel.utils.YamUtils;

import java.util.Arrays;

public enum Orientation {

    NORD,NORD_OUEST,OUEST,SUD_OUEST,SUD,SUD_EST,EST,NORD_EST;


    public static Orientation randomOrientation(){
        return Orientation.values()[YamUtils.randomNumber(0,Orientation.values().length-1)];
    }


    public Integer getIndex(){
        for(Integer i = 0; i < Orientation.values().length; i ++){
            if(Orientation.values()[i].equals(this)){
                return i;
            }
        }
        return null;
    }


    public Orientation[] getPossibleOrientations(){
        Orientation leftOrientation = null;
        if(getIndex() == 0){
            leftOrientation = Orientation.values()[Orientation.values().length-1];
        }
        else{
            leftOrientation =  Orientation.values()[(getIndex() - 1)%Orientation.values().length];
        }

        return new Orientation[]{
                leftOrientation,
                this,
                Orientation.values()[(getIndex() + 1)%Orientation.values().length]};
    }

    public Integer getVariationX(){
        if(Arrays.asList(NORD_OUEST,OUEST,SUD_OUEST).contains(this)){
            return -1;
        }
        else if(Arrays.asList(SUD_EST,EST,NORD_EST).contains(this)){
            return 1;
        }
        return 0;
    }

    public Integer getVariationY(){
        if(Arrays.asList(NORD_OUEST,NORD,NORD_EST).contains(this)){
            return -1;
        }
        else if(Arrays.asList(SUD_EST,SUD,SUD_OUEST).contains(this)){
            return 1;
        }
        return 0;
    }
}
