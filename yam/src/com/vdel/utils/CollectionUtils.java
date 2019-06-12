package com.vdel.utils;

import java.util.Collection;

public class CollectionUtils {

    public static Boolean isEmpty(Collection collection){
        return collection == null || collection.size() == 0;
    }
    public static Boolean isNotEmpty(Collection collection){
        return !isEmpty(collection);
    }
}
