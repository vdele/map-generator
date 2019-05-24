package com.vdel;

import java.util.HashMap;
import java.util.Map;

public class Humain extends Peuple {

    @Override
    public Map<TypeStat, Integer> getSpecificStats() {
        Map<TypeStat, Integer> specificStates = new HashMap();

        specificStates.put(TypeStat.ATTACK,1);
        specificStates.put(TypeStat.DEF,-1);

        return specificStates;
    }
}
