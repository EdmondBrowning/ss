package com.qiqi.edmond.qishop.interfaces.mvp.models;

import com.qiqi.edmond.qishop.presenters.AroundPastPresenter;

/**
 * Created by edmond on 17-2-21.
 */

public interface AroundPastModelInterface {
    void init(AroundPastPresenter presenter);
    void refresh(AroundPastPresenter presenter);
    void loadMore(AroundPastPresenter presenter);
}
