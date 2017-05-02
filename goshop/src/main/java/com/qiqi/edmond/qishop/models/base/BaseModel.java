package com.qiqi.edmond.qishop.models.base;

import android.util.Log;

import java.lang.reflect.ParameterizedType;

/**
 * Created by edmond on 16-11-25.
 */

public abstract class BaseModel<T> {

    private T data;

    public BaseModel(){
        ParameterizedType parameterizedType = (ParameterizedType)this.getClass().getGenericSuperclass();
        Class<T> tClass= (Class<T>)(parameterizedType.getActualTypeArguments()[0]);
        try {
            data = tClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private static final String TAG = "BaseModel";

    public T getData() {
        return data;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Log.d(TAG,"FREE");
    }
}
