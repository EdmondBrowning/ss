package com.qiqi.edmond.qishop.models;

import com.qiqi.edmond.qishop.interfaces.mvp.models.ShoppingCartModelInterface;
import com.qiqi.edmond.qishop.models.base.BaseModel;
import com.qiqi.edmond.qishop.net.Api;
import com.qiqi.edmond.qishop.net.BaseStringListener;
import com.qiqi.edmond.qishop.net.StringNetWork;
import com.qiqi.edmond.qishop.presenters.ShoppingCartPresenter;
import com.qiqi.edmond.qishop.utils.ShoppingCartData;

/**
 * Created by edmond on 17-2-25.
 */

public class ShoppingCartModel extends BaseModel<ShoppingCartData> implements ShoppingCartModelInterface {
    @Override
    public void init(final ShoppingCartPresenter presenter) {
//        ShoppingCartInfo info1 = new ShoppingCartInfo();
//        ShoppingCartInfo info2 = new ShoppingCartInfo();
//        ShoppingCartInfo info3 = new ShoppingCartInfo();
//        ShoppingCartInfo info4 = new ShoppingCartInfo();
//        ShoppingCartInfo info5 = new ShoppingCartInfo();
//
//        info1.setIconUrl("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488208492896&di=d528e2722ddfce10ff2a9b065eef7415&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F16%2F69%2F38%2F42v58PICzEP_1024.jpg");
//        info1.setName("我的小店");
//        info1.setStoreId("1");
//
//        info2.setIconUrl("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488208526987&di=b06e4eb1c49767908a0dea169d2692a5&imgtype=0&src=http%3A%2F%2Fpic1.xtuan.com%2Fupload%2Fimage%2F20131203%2F20052270537_w.jpg");
//        info2.setName("我的小");
//        info2.setStoreId("1");
//
//        info3.setIconUrl("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488803410&di=8aea8209364bcdd59f2b8c301383ec1b&imgtype=jpg&er=1&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F16%2F00%2F52%2F11J58PICD3S_1024.jpg");
//        info3.setName("我的店");
//        info3.setStoreId("1");
//
//        info4.setIconUrl("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488803431&di=dd7ffa4ffe23bc7266036659e0fb5d51&imgtype=jpg&er=1&src=http%3A%2F%2Fpic38.nipic.com%2F20140228%2F3822951_135521683000_2.jpg");
//        info4.setName("我小店");
//        info4.setStoreId("1");
//
//        info5.setIconUrl("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488803461&di=961f51b78ccd45aacbd8ab315014243e&imgtype=jpg&er=1&src=http%3A%2F%2Fdl.bizhi.sogou.com%2Fimages%2F2013%2F11%2F07%2F401031.jpg");
//        info5.setName("我小店");
//        info5.setStoreId("1");
//
//        ArrayList<ShoppingCartItemInfo> shoppingCartItemInfos1 = new ArrayList<>();
//        ArrayList<ShoppingCartItemInfo> shoppingCartItemInfos2 = new ArrayList<>();
//        ArrayList<ShoppingCartItemInfo> shoppingCartItemInfos3 = new ArrayList<>();
//        ArrayList<ShoppingCartItemInfo> shoppingCartItemInfos4 = new ArrayList<>();
//        ArrayList<ShoppingCartItemInfo> shoppingCartItemInfos5 = new ArrayList<>();
//
//        ShoppingCartItemInfo shoppingCartItemInfo1 = new ShoppingCartItemInfo();
//        ShoppingCartItemInfo shoppingCartItemInfo2 = new ShoppingCartItemInfo();
//        ShoppingCartItemInfo shoppingCartItemInfo3 = new ShoppingCartItemInfo();
//        ShoppingCartItemInfo shoppingCartItemInfo4 = new ShoppingCartItemInfo();
//        ShoppingCartItemInfo shoppingCartItemInfo5 = new ShoppingCartItemInfo();
//        ShoppingCartItemInfo shoppingCartItemInfo6 = new ShoppingCartItemInfo();
//        ShoppingCartItemInfo shoppingCartItemInfo7 = new ShoppingCartItemInfo();
//        ShoppingCartItemInfo shoppingCartItemInfo8 = new ShoppingCartItemInfo();
//        ShoppingCartItemInfo shoppingCartItemInfo9 = new ShoppingCartItemInfo();
//
//        shoppingCartItemInfo1.setName("hahah");
//        shoppingCartItemInfo2.setName("lalala");
//        shoppingCartItemInfo3.setName("qu");
//        shoppingCartItemInfo4.setName("enen");
//        shoppingCartItemInfo5.setName("ddd");
//        shoppingCartItemInfo6.setName("bbb");
//        shoppingCartItemInfo7.setName("qq");
//        shoppingCartItemInfo8.setName("zzzzzz");
//        shoppingCartItemInfo9.setName("555555");
//
//        shoppingCartItemInfo1.setCount(1);
//        shoppingCartItemInfo2.setCount(1);
//        shoppingCartItemInfo3.setCount(2);
//        shoppingCartItemInfo4.setCount(1);
//        shoppingCartItemInfo5.setCount(3);
//        shoppingCartItemInfo6.setCount(1);
//        shoppingCartItemInfo7.setCount(1);
//        shoppingCartItemInfo8.setCount(2);
//        shoppingCartItemInfo9.setCount(1);
//
//        shoppingCartItemInfo1.setSinglePrice(23.01);
//        shoppingCartItemInfo2.setSinglePrice(30.01);
//        shoppingCartItemInfo3.setSinglePrice(23.21);
//        shoppingCartItemInfo4.setSinglePrice(25.01);
//        shoppingCartItemInfo5.setSinglePrice(3.01);
//        shoppingCartItemInfo6.setSinglePrice(27.01);
//        shoppingCartItemInfo7.setSinglePrice(23.01);
//        shoppingCartItemInfo8.setSinglePrice(123.01);
//        shoppingCartItemInfo9.setSinglePrice(253.01);
//
//        shoppingCartItemInfo1.setFaceUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488804033&di=b6df8a7b3e06e94e299417fa5d76dbc6&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.sj33.cn%2Fuploads%2Fallimg%2F201503%2F7-150303234610.jpg");
//        shoppingCartItemInfo2.setFaceUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488209332034&di=508451d7bfe5dc4aeece9df3013c8bb0&imgtype=0&src=http%3A%2F%2Fimg.club.pchome.net%2Fkdsarticle%2F2014%2F03small%2F18%2Fbfcbc9c9a0d3cc8b57c1523af28193cc_1000x750.jpg");
//        shoppingCartItemInfo3.setFaceUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488209378890&di=cee7fe8db1b208d1320fc8cc47174b1a&imgtype=0&src=http%3A%2F%2Fpic.uuhy.com%2Fuploads%2F2011%2F10%2F15%2FMacro-Photos20.jpg");
//        shoppingCartItemInfo4.setFaceUrl("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1753835578,2875072531&fm=23&gp=0.jpg");
//        shoppingCartItemInfo5.setFaceUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488209420371&di=aa48a41cb2aac8328157f23173d66fdd&imgtype=0&src=http%3A%2F%2Fimage100.360doc.com%2FDownloadImg%2F2016%2F09%2F1518%2F80108353_12.jpg");
//        shoppingCartItemInfo6.setFaceUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488209420371&di=aa48a41cb2aac8328157f23173d66fdd&imgtype=0&src=http%3A%2F%2Fimage100.360doc.com%2FDownloadImg%2F2016%2F09%2F1518%2F80108353_12.jpg");
//        shoppingCartItemInfo7.setFaceUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488804178&di=5b485b70cb19dc3c904a4f963ee1d8da&imgtype=jpg&er=1&src=http%3A%2F%2Fh5.86.cc%2Fwalls%2F20160707%2F1366x768_a402d930f968ce2.jpg");
//        shoppingCartItemInfo8.setFaceUrl("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2084881701,219887249&fm=23&gp=0.jpg");
//        shoppingCartItemInfo9.setFaceUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488209502225&di=90f040a10eee6f9717e704a289bc4a68&imgtype=0&src=http%3A%2F%2Fimg.article.pchome.net%2F00%2F35%2F62%2F34%2Fpic_lib%2Fs960x639%2FZhiwu36s960x639.jpg");
//
//        shoppingCartItemInfos1.add(shoppingCartItemInfo1);
//        shoppingCartItemInfos1.add(shoppingCartItemInfo2);
//
//        shoppingCartItemInfos2.add(shoppingCartItemInfo3);
//
//        shoppingCartItemInfos3.add(shoppingCartItemInfo4);
//        shoppingCartItemInfos3.add(shoppingCartItemInfo5);
//
//        shoppingCartItemInfos4.add(shoppingCartItemInfo6);
//
//        shoppingCartItemInfos5.add(shoppingCartItemInfo7);
//        shoppingCartItemInfos5.add(shoppingCartItemInfo8);
//        shoppingCartItemInfos5.add(shoppingCartItemInfo9);
//
//        info1.setShoppingCartItemInfoList(shoppingCartItemInfos1);
//        info2.setShoppingCartItemInfoList(shoppingCartItemInfos2);
//        info3.setShoppingCartItemInfoList(shoppingCartItemInfos3);
//        info4.setShoppingCartItemInfoList(shoppingCartItemInfos4);
//        info5.setShoppingCartItemInfoList(shoppingCartItemInfos5);
//
//        getData().getShoppingCartInfos().add(info1);
//        getData().getShoppingCartInfos().add(info2);
//        getData().getShoppingCartInfos().add(info3);
//        getData().getShoppingCartInfos().add(info4);
//        getData().getShoppingCartInfos().add(info5);
//
//        presenter.inited(getData());

        StringNetWork stringNetWork = new StringNetWork(0, Api.SHOPPING_CART_INIT, new BaseStringListener<ShoppingCartData>() {
            @Override
            public void onStart(int what) {

            }

            @Override
            public void onSucceed(int what, ShoppingCartData response) {
                presenter.inited(getData());
            }

            @Override
            public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
                presenter.initError();
            }

            @Override
            public void onFinish(int what) {

            }
        },null);

//        stringNetWork.doIt();
    }

    @Override
    public void refresh(final ShoppingCartPresenter presenter) {
//        getData().getShoppingCartInfos().clear();
//
//        ShoppingCartInfo info1 = new ShoppingCartInfo();
//        ShoppingCartInfo info2 = new ShoppingCartInfo();
//        ShoppingCartInfo info3 = new ShoppingCartInfo();
//        ShoppingCartInfo info4 = new ShoppingCartInfo();
//        ShoppingCartInfo info5 = new ShoppingCartInfo();
//
//        info1.setIconUrl("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488208492896&di=d528e2722ddfce10ff2a9b065eef7415&imgtype=0&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F16%2F69%2F38%2F42v58PICzEP_1024.jpg");
//        info1.setName("我的小店");
//        info1.setStoreId("1");
//
//        info2.setIconUrl("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488208526987&di=b06e4eb1c49767908a0dea169d2692a5&imgtype=0&src=http%3A%2F%2Fpic1.xtuan.com%2Fupload%2Fimage%2F20131203%2F20052270537_w.jpg");
//        info2.setName("我的小");
//        info2.setStoreId("1");
//
//        info3.setIconUrl("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488803410&di=8aea8209364bcdd59f2b8c301383ec1b&imgtype=jpg&er=1&src=http%3A%2F%2Fpic.58pic.com%2F58pic%2F16%2F00%2F52%2F11J58PICD3S_1024.jpg");
//        info3.setName("我的店");
//        info3.setStoreId("1");
//
//        info4.setIconUrl("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488803431&di=dd7ffa4ffe23bc7266036659e0fb5d51&imgtype=jpg&er=1&src=http%3A%2F%2Fpic38.nipic.com%2F20140228%2F3822951_135521683000_2.jpg");
//        info4.setName("我小店");
//        info4.setStoreId("1");
//
//        info5.setIconUrl("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488803461&di=961f51b78ccd45aacbd8ab315014243e&imgtype=jpg&er=1&src=http%3A%2F%2Fdl.bizhi.sogou.com%2Fimages%2F2013%2F11%2F07%2F401031.jpg");
//        info5.setName("我小店");
//        info5.setStoreId("1");
//
//        ArrayList<ShoppingCartItemInfo> shoppingCartItemInfos1 = new ArrayList<>();
//        ArrayList<ShoppingCartItemInfo> shoppingCartItemInfos2 = new ArrayList<>();
//        ArrayList<ShoppingCartItemInfo> shoppingCartItemInfos3 = new ArrayList<>();
//        ArrayList<ShoppingCartItemInfo> shoppingCartItemInfos4 = new ArrayList<>();
//        ArrayList<ShoppingCartItemInfo> shoppingCartItemInfos5 = new ArrayList<>();
//
//        ShoppingCartItemInfo shoppingCartItemInfo1 = new ShoppingCartItemInfo();
//        ShoppingCartItemInfo shoppingCartItemInfo2 = new ShoppingCartItemInfo();
//        ShoppingCartItemInfo shoppingCartItemInfo3 = new ShoppingCartItemInfo();
//        ShoppingCartItemInfo shoppingCartItemInfo4 = new ShoppingCartItemInfo();
//        ShoppingCartItemInfo shoppingCartItemInfo5 = new ShoppingCartItemInfo();
//        ShoppingCartItemInfo shoppingCartItemInfo6 = new ShoppingCartItemInfo();
//        ShoppingCartItemInfo shoppingCartItemInfo7 = new ShoppingCartItemInfo();
//        ShoppingCartItemInfo shoppingCartItemInfo8 = new ShoppingCartItemInfo();
//        ShoppingCartItemInfo shoppingCartItemInfo9 = new ShoppingCartItemInfo();
//
//        shoppingCartItemInfo1.setName("hahah");
//        shoppingCartItemInfo2.setName("lalala");
//        shoppingCartItemInfo3.setName("qu");
//        shoppingCartItemInfo4.setName("enen");
//        shoppingCartItemInfo5.setName("ddd");
//        shoppingCartItemInfo6.setName("bbb");
//        shoppingCartItemInfo7.setName("qq");
//        shoppingCartItemInfo8.setName("zzzzzz");
//        shoppingCartItemInfo9.setName("555555");
//
//        shoppingCartItemInfo1.setCount(1);
//        shoppingCartItemInfo2.setCount(1);
//        shoppingCartItemInfo3.setCount(2);
//        shoppingCartItemInfo4.setCount(1);
//        shoppingCartItemInfo5.setCount(3);
//        shoppingCartItemInfo6.setCount(1);
//        shoppingCartItemInfo7.setCount(1);
//        shoppingCartItemInfo8.setCount(2);
//        shoppingCartItemInfo9.setCount(1);
//
//        shoppingCartItemInfo1.setSinglePrice(23.01);
//        shoppingCartItemInfo2.setSinglePrice(30.01);
//        shoppingCartItemInfo3.setSinglePrice(23.21);
//        shoppingCartItemInfo4.setSinglePrice(25.01);
//        shoppingCartItemInfo5.setSinglePrice(3.01);
//        shoppingCartItemInfo6.setSinglePrice(27.01);
//        shoppingCartItemInfo7.setSinglePrice(23.01);
//        shoppingCartItemInfo8.setSinglePrice(123.01);
//        shoppingCartItemInfo9.setSinglePrice(253.01);
//
//        shoppingCartItemInfo1.setFaceUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488804033&di=b6df8a7b3e06e94e299417fa5d76dbc6&imgtype=jpg&er=1&src=http%3A%2F%2Fimg.sj33.cn%2Fuploads%2Fallimg%2F201503%2F7-150303234610.jpg");
//        shoppingCartItemInfo2.setFaceUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488209332034&di=508451d7bfe5dc4aeece9df3013c8bb0&imgtype=0&src=http%3A%2F%2Fimg.club.pchome.net%2Fkdsarticle%2F2014%2F03small%2F18%2Fbfcbc9c9a0d3cc8b57c1523af28193cc_1000x750.jpg");
//        shoppingCartItemInfo3.setFaceUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488209378890&di=cee7fe8db1b208d1320fc8cc47174b1a&imgtype=0&src=http%3A%2F%2Fpic.uuhy.com%2Fuploads%2F2011%2F10%2F15%2FMacro-Photos20.jpg");
//        shoppingCartItemInfo4.setFaceUrl("https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=1753835578,2875072531&fm=23&gp=0.jpg");
//        shoppingCartItemInfo5.setFaceUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488209420371&di=aa48a41cb2aac8328157f23173d66fdd&imgtype=0&src=http%3A%2F%2Fimage100.360doc.com%2FDownloadImg%2F2016%2F09%2F1518%2F80108353_12.jpg");
//        shoppingCartItemInfo6.setFaceUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488209420371&di=aa48a41cb2aac8328157f23173d66fdd&imgtype=0&src=http%3A%2F%2Fimage100.360doc.com%2FDownloadImg%2F2016%2F09%2F1518%2F80108353_12.jpg");
//        shoppingCartItemInfo7.setFaceUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488804178&di=5b485b70cb19dc3c904a4f963ee1d8da&imgtype=jpg&er=1&src=http%3A%2F%2Fh5.86.cc%2Fwalls%2F20160707%2F1366x768_a402d930f968ce2.jpg");
//        shoppingCartItemInfo8.setFaceUrl("https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2084881701,219887249&fm=23&gp=0.jpg");
//        shoppingCartItemInfo9.setFaceUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1488209502225&di=90f040a10eee6f9717e704a289bc4a68&imgtype=0&src=http%3A%2F%2Fimg.article.pchome.net%2F00%2F35%2F62%2F34%2Fpic_lib%2Fs960x639%2FZhiwu36s960x639.jpg");
//
//        shoppingCartItemInfos1.add(shoppingCartItemInfo1);
//        shoppingCartItemInfos1.add(shoppingCartItemInfo2);
//
//        shoppingCartItemInfos2.add(shoppingCartItemInfo3);
//
//        shoppingCartItemInfos3.add(shoppingCartItemInfo4);
//        shoppingCartItemInfos3.add(shoppingCartItemInfo5);
//
//        shoppingCartItemInfos4.add(shoppingCartItemInfo6);
//
//        shoppingCartItemInfos5.add(shoppingCartItemInfo7);
//        shoppingCartItemInfos5.add(shoppingCartItemInfo8);
//        shoppingCartItemInfos5.add(shoppingCartItemInfo9);
//
//        info1.setShoppingCartItemInfoList(shoppingCartItemInfos1);
//        info2.setShoppingCartItemInfoList(shoppingCartItemInfos2);
//        info3.setShoppingCartItemInfoList(shoppingCartItemInfos3);
//        info4.setShoppingCartItemInfoList(shoppingCartItemInfos4);
//        info5.setShoppingCartItemInfoList(shoppingCartItemInfos5);
//
//        getData().getShoppingCartInfos().add(info1);
//        getData().getShoppingCartInfos().add(info2);
//        getData().getShoppingCartInfos().add(info3);
//        getData().getShoppingCartInfos().add(info4);
//        getData().getShoppingCartInfos().add(info5);
//
//        presenter.refreshed(getData());

        StringNetWork stringNetWork = new StringNetWork(0, Api.SHOPPING_CART_INIT, new BaseStringListener<ShoppingCartData>() {
            @Override
            public void onStart(int what) {

            }

            @Override
            public void onSucceed(int what, ShoppingCartData response) {
                presenter.refreshed(getData());
            }

            @Override
            public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
                presenter.refreshError();
            }

            @Override
            public void onFinish(int what) {

            }
        },null);
//        stringNetWork.doIt();
    }
}
