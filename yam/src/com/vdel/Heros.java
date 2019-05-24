package com.vdel;


public class Heros<T extends Peuple> {

    private String name;
    private Integer niveau;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNiveau() {
        return niveau;
    }

    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

    public Heros(String name, Peuple peuple){
        this.name = name;
        this.niveau = 1;
    }



}
