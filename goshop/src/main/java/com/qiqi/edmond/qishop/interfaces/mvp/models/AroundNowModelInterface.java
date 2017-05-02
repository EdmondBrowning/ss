package com.qiqi.edmond.qishop.interfaces.mvp.models;

import com.qiqi.edmond.qishop.presenters.NewsTouTiaoPresenter;

/**
 * Created by edmond on 17-2-21.
 */

public interface AroundNowModelInterface {
    void init(NewsTouTiaoPresenter presenter);
    void refresh(NewsTouTiaoPresenter presenter);
    void loadMore(NewsTouTiaoPresenter presenter);
}
