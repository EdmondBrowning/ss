package com.qiqi.edmond.qishop.models;

import com.qiqi.edmond.qishop.interfaces.mvp.models.AroundWillModelInterface;
import com.qiqi.edmond.qishop.models.base.BaseModel;
import com.qiqi.edmond.qishop.net.Api;
import com.qiqi.edmond.qishop.net.BaseStringListener;
import com.qiqi.edmond.qishop.net.StringNetWork;
import com.qiqi.edmond.qishop.presenters.AroundWillPresenter;
import com.qiqi.edmond.qishop.utils.AroundWillData;
import com.qiqi.edmond.qishop.utils.AroundWillInfoMore;

import java.util.HashMap;

/**
 * Created by edmond on 17-2-21.
 */

public class AroundWillModel extends BaseModel<AroundWillData> implements AroundWillModelInterface {
    @Override
    public void init(final AroundWillPresenter presenter) {

//        AroundWillInfo info1 = new AroundWillInfo();
//        AroundWillInfo info2 = new AroundWillInfo();
//        AroundWillInfo info3 = new AroundWillInfo();
//        AroundWillInfo info4 = new AroundWillInfo();
//        AroundWillInfo info5 = new AroundWillInfo();
//
//        info1.setCare(true);
//        info1.setCollection(false);
//        info1.setCommentNumber(12);
//        info1.setName("Edmond");
//        info1.setScript("dfsdfdsfasfadsfadsfasfdsa");
//        info1.setThumbNumber(12);
//        info1.setTime("2016-02-22 16:00:00");
//        info1.setTitle("dfdf");
//        info1.setWatchingNumber(12);
//        info1.setFaceUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487764571493&di=edcbbfe3af9c7e01f9fcb7c359077e47&imgtype=0&src=http%3A%2F%2Fb.zol-img.com.cn%2Fdesk%2Fbizhi%2Fimage%2F4%2F960x600%2F1390442761386.jpg");
//        info1.setLogoUrl("http://tupian.enterdesk.com/2013/xll/012/04/8/6.jpg");
//
//        info2.setCare(true);
//        info2.setCollection(true);
//        info2.setCommentNumber(12);
//        info2.setName("Edmond");
//        info2.setScript("dfsdfdsfasfadsfadsfasfdsa");
//        info2.setThumbNumber(12);
//        info2.setTime("2016-02-22 16:00:00");
//        info2.setTitle("dfdf");
//        info2.setWatchingNumber(12);
//        info2.setFaceUrl("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487765608555&di=836da489d08349e369e194b5aab46779&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F7%2F53c5f72012445.jpg");
//        info2.setLogoUrl("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487765637164&di=f3d720b1312f61545206a69167f6660a&imgtype=0&src=http%3A%2F%2Fb.zol-img.com.cn%2Fdesk%2Fbizhi%2Fimage%2F4%2F960x600%2F1384741005674.jpg");
//
//        info3.setCare(true);
//        info3.setCollection(true);
//        info3.setCommentNumber(12);
//        info3.setName("Edmond");
//        info3.setScript("dfsdfdsfasfadsfadsfasfdsa");
//        info3.setThumbNumber(12);
//        info3.setTime("2016-02-22 16:00:00");
//        info3.setTitle("dfdf");
//        info3.setWatchingNumber(12);
//        info3.setFaceUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487766153406&di=ffa1a759c01e5d1a3852d995ac9c285d&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2Fd043ad4bd11373f0b748eca5a70f4bfbfbed0490.jpg");
//        info3.setLogoUrl("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487765987586&di=caf33d0596d01a3d94ddb33fb10906cc&imgtype=0&src=http%3A%2F%2Fh.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F838ba61ea8d3fd1fb6482db8324e251f94ca5feb.jpg");
//
//        info4.setCare(true);
//        info4.setCollection(true);
//        info4.setCommentNumber(12);
//        info4.setName("Edmond");
//        info4.setScript("dfsdfdsfasfadsfadsfasfdsa");
//        info4.setThumbNumber(12);
//        info4.setTime("2016-02-22 16:00:00");
//        info4.setTitle("dfdf");
//        info4.setWatchingNumber(12);
//        info4.setFaceUrl("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487766254850&di=41961726cea3d8e31761c142781b1742&imgtype=0&src=http%3A%2F%2Fdesk.fd.zol-img.com.cn%2Fg5%2FM00%2F02%2F0E%2FChMkJ1bK5piIdwSUAAGrbz01bXoAALKWgJaX9UAAauH904.jpg");
//        info4.setLogoUrl("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487766291599&di=f290b051df4799ad2cfff402cff8d8fa&imgtype=0&src=http%3A%2F%2Fb.zol-img.com.cn%2Fdesk%2Fbizhi%2Fimage%2F6%2F960x600%2F1425868787336.jpg");
//
//        info5.setCare(true);
//        info5.setCollection(true);
//        info5.setCommentNumber(12);
//        info5.setName("Edmond");
//        info5.setScript("dfsdfdsfasfadsfadsfasfdsa");
//        info5.setThumbNumber(12);
//        info5.setTime("2016-02-22 16:00:00");
//        info5.setTitle("dfdf");
//        info5.setWatchingNumber(12);
//        info5.setFaceUrl("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487765608555&di=836da489d08349e369e194b5aab46779&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F7%2F53c5f72012445.jpg");
//        info5.setLogoUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487766424840&di=13c3ad552f88471e95641a77ece9154a&imgtype=0&src=http%3A%2F%2Fimg.qqu.cc%2Fuploads%2Fallimg%2F141214%2F1-1412141U502.jpg");
//
//        getData().getAroundWillInfos().add(info1);
//        getData().getAroundWillInfos().add(info2);
//        getData().getAroundWillInfos().add(info3);
//        getData().getAroundWillInfos().add(info4);
//        getData().getAroundWillInfos().add(info5);

        HashMap<String,String> map = new HashMap<>();
        map.put("uid","");
        map.put("token","");

        StringNetWork stringNetWork = new StringNetWork(0, Api.AROUND_WILL_INIT, new BaseStringListener<AroundWillData>() {
            @Override
            public void onStart(int what) {

            }

            @Override
            public void onSucceed(int what, AroundWillData response) {
                getData().getAroundWillInfos().addAll(response.getAroundWillInfos());
                getData().setLastId(response.getLastId());
                presenter.inited(getData());
            }

            @Override
            public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
                presenter.initError();
            }

            @Override
            public void onFinish(int what) {

            }
        },map);

//        stringNetWork.doIt();
    }

    @Override
    public void refresh(final AroundWillPresenter presenter) {
//        AroundWillInfo info1 = new AroundWillInfo();
//        AroundWillInfo info2 = new AroundWillInfo();
//        AroundWillInfo info3 = new AroundWillInfo();
//        AroundWillInfo info4 = new AroundWillInfo();
//        AroundWillInfo info5 = new AroundWillInfo();
//
//        info1.setCare(true);
//        info1.setCollection(false);
//        info1.setCommentNumber(12);
//        info1.setName("Edmond");
//        info1.setScript("dfsdfdsfasfadsfadsfasfdsa");
//        info1.setThumbNumber(12);
//        info1.setTime("2016-02-22 16:00:00");
//        info1.setTitle("dfdf");
//        info1.setWatchingNumber(12);
//        info1.setFaceUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487764571493&di=edcbbfe3af9c7e01f9fcb7c359077e47&imgtype=0&src=http%3A%2F%2Fb.zol-img.com.cn%2Fdesk%2Fbizhi%2Fimage%2F4%2F960x600%2F1390442761386.jpg");
//        info1.setLogoUrl("http://tupian.enterdesk.com/2013/xll/012/04/8/6.jpg");
//
//        info2.setCare(true);
//        info2.setCollection(true);
//        info2.setCommentNumber(12);
//        info2.setName("Edmond");
//        info2.setScript("dfsdfdsfasfadsfadsfasfdsa");
//        info2.setThumbNumber(12);
//        info2.setTime("2016-02-22 16:00:00");
//        info2.setTitle("dfdf");
//        info2.setWatchingNumber(12);
//        info2.setFaceUrl("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487765608555&di=836da489d08349e369e194b5aab46779&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F7%2F53c5f72012445.jpg");
//        info2.setLogoUrl("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487765637164&di=f3d720b1312f61545206a69167f6660a&imgtype=0&src=http%3A%2F%2Fb.zol-img.com.cn%2Fdesk%2Fbizhi%2Fimage%2F4%2F960x600%2F1384741005674.jpg");
//
//        info3.setCare(true);
//        info3.setCollection(true);
//        info3.setCommentNumber(12);
//        info3.setName("Edmond");
//        info3.setScript("dfsdfdsfasfadsfadsfasfdsa");
//        info3.setThumbNumber(12);
//        info3.setTime("2016-02-22 16:00:00");
//        info3.setTitle("dfdf");
//        info3.setWatchingNumber(12);
//        info3.setFaceUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487766153406&di=ffa1a759c01e5d1a3852d995ac9c285d&imgtype=0&src=http%3A%2F%2Ff.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2Fd043ad4bd11373f0b748eca5a70f4bfbfbed0490.jpg");
//        info3.setLogoUrl("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487765987586&di=caf33d0596d01a3d94ddb33fb10906cc&imgtype=0&src=http%3A%2F%2Fh.hiphotos.baidu.com%2Fzhidao%2Fpic%2Fitem%2F838ba61ea8d3fd1fb6482db8324e251f94ca5feb.jpg");
//
//        info4.setCare(true);
//        info4.setCollection(true);
//        info4.setCommentNumber(12);
//        info4.setName("Edmond");
//        info4.setScript("dfsdfdsfasfadsfadsfasfdsa");
//        info4.setThumbNumber(12);
//        info4.setTime("2016-02-22 16:00:00");
//        info4.setTitle("dfdf");
//        info4.setWatchingNumber(12);
//        info4.setFaceUrl("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487766254850&di=41961726cea3d8e31761c142781b1742&imgtype=0&src=http%3A%2F%2Fdesk.fd.zol-img.com.cn%2Fg5%2FM00%2F02%2F0E%2FChMkJ1bK5piIdwSUAAGrbz01bXoAALKWgJaX9UAAauH904.jpg");
//        info4.setLogoUrl("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487766291599&di=f290b051df4799ad2cfff402cff8d8fa&imgtype=0&src=http%3A%2F%2Fb.zol-img.com.cn%2Fdesk%2Fbizhi%2Fimage%2F6%2F960x600%2F1425868787336.jpg");
//
//        info5.setCare(true);
//        info5.setCollection(true);
//        info5.setCommentNumber(12);
//        info5.setName("Edmond");
//        info5.setScript("dfsdfdsfasfadsfadsfasfdsa");
//        info5.setThumbNumber(12);
//        info5.setTime("2016-02-22 16:00:00");
//        info5.setTitle("dfdf");
//        info5.setWatchingNumber(12);
//        info5.setFaceUrl("http://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487765608555&di=836da489d08349e369e194b5aab46779&imgtype=0&src=http%3A%2F%2Fpic1.win4000.com%2Fwallpaper%2F7%2F53c5f72012445.jpg");
//        info5.setLogoUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1487766424840&di=13c3ad552f88471e95641a77ece9154a&imgtype=0&src=http%3A%2F%2Fimg.qqu.cc%2Fuploads%2Fallimg%2F141214%2F1-1412141U502.jpg");
//
//        getData().getAroundWillInfos().clear();
//
//        getData().getAroundWillInfos().add(info1);
//        getData().getAroundWillInfos().add(info2);
//        getData().getAroundWillInfos().add(info3);
//        getData().getAroundWillInfos().add(info4);
//        getData().getAroundWillInfos().add(info5);
//        presenter.refreshed(getData());

        HashMap<String,String> map = new HashMap<>();
        map.put("uid","");
        map.put("token","");

        StringNetWork stringNetWork = new StringNetWork(0, Api.AROUND_WILL_INIT, new BaseStringListener<AroundWillData>() {
            @Override
            public void onStart(int what) {

            }

            @Override
            public void onSucceed(int what, AroundWillData response) {
                presenter.refreshed(getData());
            }

            @Override
            public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
                presenter.refreshError();
            }

            @Override
            public void onFinish(int what) {

            }
        },map);

//        stringNetWork.doIt();
    }

    @Override
    public void loadMore(final AroundWillPresenter presenter) {
        HashMap<String,String> map = new HashMap<>();
        map.put("uid","");
        map.put("token","");
        map.put("lastId","");
        StringNetWork stringNetWork = new StringNetWork(0, Api.AROUND_WILL_MORE, new BaseStringListener<AroundWillInfoMore>() {
            @Override
            public void onStart(int what) {

            }

            @Override
            public void onSucceed(int what, AroundWillInfoMore response) {
                presenter.loadMored(response.getAroundWillInfos());
            }

            @Override
            public void onFailed(int what, String url, Object tag, Exception exception, int responseCode, long networkMillis) {
                presenter.loadMoreError();
            }

            @Override
            public void onFinish(int what) {

            }
        },map);

//        stringNetWork.doIt();
    }
}
