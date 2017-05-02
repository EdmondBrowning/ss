package com.qiqi.edmond.qishop.interfaces.mvp.models;

import com.qiqi.edmond.qishop.presenters.AroundWillPresenter;

/**
 * Created by edmond on 17-2-21.
 */

public interface AroundWillModelInterface {
    void init(AroundWillPresenter presenter);
    void refresh(AroundWillPresenter presenter);
    void loadMore(AroundWillPresenter presenter);
}
