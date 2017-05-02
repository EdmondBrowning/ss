package com.qiqi.edmond.qishop.interfaces.mvp.models;

import com.qiqi.edmond.qishop.presenters.HomePresenter;

/**
 * Created by edmond on 17-1-15.
 */

public interface HomeModelInterface {
    void init(HomePresenter presenter);
    void refresh(HomePresenter presenter);
    void loadMore(HomePresenter presenter);
}
