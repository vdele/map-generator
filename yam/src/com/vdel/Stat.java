package com.vdel;

public class Stat {

    public Integer value;

    public static final Integer DEFAULT_VALUE = 10;

    public Stat(Integer specificValue){
        this.value = DEFAULT_VALUE + (specificValue != null ? specificValue : 0);
    }

    public Integer getDefaultValue(){
        return DEFAULT_VALUE;
    }

    public Integer getValue(){
        return value;
    }

    public void setValue(Integer value){
        this.value = value;
    }


}
