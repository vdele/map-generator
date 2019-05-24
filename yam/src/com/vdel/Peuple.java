package com.vdel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Peuple {


    private Map<TypeStat, Stat> stats = null;

    abstract Map<TypeStat, Integer> getSpecificStats();

    public Peuple(){
        stats = new HashMap<>();
        Map<TypeStat, Integer> specificStats = getSpecificStats();
        for (TypeStat typeStat : TypeStat.values()) {
            stats.put(typeStat,new Stat(specificStats.get(typeStat)));
        }
    }
}
