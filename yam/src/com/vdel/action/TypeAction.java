package com.vdel.action;

public enum TypeAction {

    CREATE_HERO(1),
    MOVE(1),
    STAT(0),
    QUIT(0),
    OBSERVE(0);

    private Integer nbArgument = null;

    TypeAction(Integer nbArgument){
        this.nbArgument = nbArgument;
    }

    public Integer getNbArgument() {
        return nbArgument;
    }

}
