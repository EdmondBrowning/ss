package com.qiqi.edmond.qishop.interfaces.mvp.models;

import com.qiqi.edmond.qishop.presenters.HomePresenter;
import com.qiqi.edmond.qishop.presenters.MinePresenter;

/**
 * Created by edmond on 17-1-15.
 */

public interface MineModelInterface {
    void init(MinePresenter presenter);
    void refresh(MinePresenter presenter);
}
