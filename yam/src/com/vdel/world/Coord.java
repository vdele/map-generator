package com.vdel.world;

import java.util.Objects;

public class Coord {

    private Integer X;
    private Integer Y;

    public Integer getX() {
        return X;
    }

    public void setX(Integer x) {
        X = x;
    }

    public Integer getY() {
        return Y;
    }

    public void setY(Integer y) {
        Y = y;
    }

    public Coord(Integer x, Integer y){
        this.X = x;
        this.Y = y;
    }


    public static Coord valueOf(Integer x, Integer y){
        return new Coord(x,y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coord coord = (Coord) o;
        return X.equals(coord.X) &&
                Y.equals(coord.Y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(X, Y);
    }
}
