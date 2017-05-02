package com.qiqi.edmond.qishop.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by edmond on 16-11-17.
 */

public class ClassUtil {

    public static void copyData(Object copyObject,Object toObject){
        Class personClass = copyObject.getClass();

        System.out.println(copyObject.getClass());

        Field[] fields = personClass.getDeclaredFields();

        for (Field f:fields) {
            String fieldName = f.getName();
            String begin = fieldName.substring(0,1);
            String end = fieldName.substring(1);
            String setMethodName = "set"+begin.toUpperCase()+end;
            String getMethodName = "get"+begin.toUpperCase()+end;

            System.out.println(f.getName());

            Method gm = null;
            Method sm = null;
            try {
                gm = personClass.getMethod(getMethodName,null);
                sm = personClass.getMethod(setMethodName,f.getType());
            } catch (NoSuchMethodException e) {
                continue;
            }

            Object o = null;
            try {
                o = gm.invoke(copyObject,null);
                sm.invoke(toObject,o);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
