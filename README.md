
今天有时间，把之前用mvp架构开发的一个需求整理一下。网上大多数是介绍mvp的简单应用，而如何在产品级项目中真正应用mvp架构？

一、mvp架构的优势

到现在为止，我用mvp架构做的需求已经上线了3个大版本，n个小版本了。说实话，刚开始做的时候，并没有意识到mvp对于开发有多大的好处，可是经过这几次版本迭代，mvp架构的优势就凸显出来了——当要加需求时，我只需要改presenter就可以了；当ui有变动，我只需要改fragment里相关的回调里的代码就可以了；当接口契约有改动，我只需要改model层就可以了。层次真的是非常棒！



二、mvp是什么？

m是model的缩写，负责数据处理。

v是view的缩写，负责UI视图的渲染。

p是presenter的缩写，负责业务逻辑处理。

它们三者之间的关系是这样的：



翻译成我能理解的话就是，presenter层控制何时渲染UI，同时处理model层的数据回调（实现model回调接口）；model层负责请求数据；view层负责UI渲染（presenter层负责何时渲染UI）。

更进一步翻译，mvp架构的基本类结构是什么？

1、View接口

2、View接口的实现类（一般为fragment或activity）

3、model类

4、model回调接口

5、presenter类（实现model回调接口）

所以，如何构建自己的mvp架构？先把这几个必备类结构准备好呀~~



三、mvp的具体实现

1、View接口



public interface IAroundTravelView {
    //Part 1: result of Search Item
    void initDefaultCopyWriter(String result);
    //Part 2: result of Tab -- aroundGroup, aroundIndependent, flight+hotel, one-day -- Version 2
    void initTabView(List<Icon> list, boolean fromNetwork);
    //Part 3: result of Popular Destinations
    void initPopularDestinationView(List<DestinationInfo> list, boolean fromNetwork);
    //Part 4: result of concrete content of list items of aroundGroup, aroundIndependent, flight+hotel, one-day
    void initTabDetailsView(TabItemTotalInfo tabItemTotalInfo, boolean fromNetwork);
    //Part 5: result of successfully locating
    void locateSuccess(LocationCityResponseModel data);
    //Part 6:result of not successfully locating
    void failed2Locate();
    //Part 7: set text of Location TextView
    void setDepartureCityName(String city);
    //Part 8: start loading when there is no location Cache
    void startLoading();
    //Part 9: stop loading when location response returned
    void stopLoading();
    //Part 10: just loading when requesting http api
    void loadDialog();
    //Part 11: stop the loading dialog when data returned
    void dismissDialog();
    //Part 12: failure
    void setError(int type);
}
由于我这里是直接拿线上代码作为讲解，可能逻辑会复杂一点。在设计之初就应该想到，我的界面里会有哪几种界面渲染情况。比如，主题宫格部分的UI渲染，热门目的地的UI渲染，热门产品的UI渲染等。





2、View接口的实现类（一般为fragment或activity）

这里就不贴代码了，想怎么画UI，就怎么写fragment好了。



3、model类

public class AroundTravelModel {
    private AroundTravelSender sender;
    public AroundTravelModel() {
        sender = new AroundTravelSender();
    }

    public void getSearchData(final OnAroundTravelDataCallbackListener listener) {
        VacationIndexSearchDefaultCopySender vacationIndexSearchDefaultCopySender = VacationIndexSearchDefaultCopySender.getInstance();
        vacationIndexSearchDefaultCopySender.Send(new VacationIndexSearchDefaultCopySender.CallBackObject() {
            @Override
            public void CallbackFunction(boolean success, final Object data) {
                if (success) {
                    listener.requestSearchRes(data);
                } else {
                    LogUtil.e("TAG", "Http 有误...");
                }
            }
        });
    }

    public void getInitData(int saleCityId, int departureCityId, boolean containSaleCity, OnAroundTravelDataCallbackListener listener) {
        sender.send(saleCityId, departureCityId, containSaleCity, listener);
    }

}
里面通常包括几个接口请求。



4、model回调接口

public interface OnAroundTravelDataCallbackListener {
    //Part 1: result of Search Item
    void requestSearchRes(Object data);
    //Part 2: failure
    void setError(int type);
    //Part 3:
    void requestInitRes(AroundTravelInfo aroundTravelInfo, boolean containSaleCity, boolean fromNetwork);
}
一般有几个数据请求，这个接口里就有几个方法，再加上请求错误方法。

5、presenter类

这里也不详细介绍了。



点击查看demo（传送门）
