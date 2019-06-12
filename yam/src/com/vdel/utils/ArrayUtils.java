package com.vdel.utils;


public class ArrayUtils {

    public static Boolean isEmpty(Object ... objects){
        return objects == null || objects.length == 0;
    }
    public static Boolean isNotEmpty(Object ... objects){
        return !isEmpty(objects);
    }
}
