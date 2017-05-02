package com.qiqi.edmond.qishop.presenters.base;

import android.util.Log;

import com.qiqi.edmond.qishop.models.base.BaseModel;

import java.lang.reflect.ParameterizedType;

/**
 * Created by edmond on 16-11-25.
 */

public abstract class BasePresenter<V,M extends BaseModel> {
    private static final String TAG="BasePresenter";

    private V view;
    private M model;

    public BasePresenter(V view){
        this.view = view;

        ParameterizedType parameterizedType = (ParameterizedType)this.getClass().getGenericSuperclass();
        Class<M> tClass= (Class<M>)(parameterizedType.getActualTypeArguments()[1]);
        try {
            model = tClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public V getView() {
        return view;
    }

    public M getModel() {
        return model;
    }

    public void onDestroy(){
        if(view!=null){
            view = null;
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        Log.d(TAG,"FREE");
    }
}
