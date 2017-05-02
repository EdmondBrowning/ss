package com.qiqi.edmond.qishop.net;

import com.qiqi.edmond.qishop.interfaces.net.JsonObjectListenerInterface;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.lang.reflect.ParameterizedType;

/**
 * Created by edmond on 16-12-16.
 */

public abstract class BaseJsonObjectListener<T> implements JsonObjectListenerInterface<T> {
    @Override
    public void format(int what,JSONObject response) {
        ParameterizedType parameterizedType = (ParameterizedType)this.getClass().getGenericSuperclass();
        Class<T> tClass= (Class<T>)(parameterizedType.getActualTypeArguments()[0]);
        Gson gson = new Gson();
        T object = gson.fromJson(response.toString(),tClass);
        onSucceed(what,object);
    }
}
