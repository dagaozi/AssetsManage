package com.wyyy.assetsmanage.ui;

import android.content.Intent;
import android.widget.Button;

import com.wyyy.assetsmanage.R;
import com.wyyy.assetsmanage.base.BaseActivity;
import com.wyyy.assetsmanage.base.BaseSubscriber;
import com.wyyy.assetsmanage.base.IBaseSubscriber;
import com.wyyy.assetsmanage.di.component.AppComponent;
import com.wyyy.assetsmanage.model.TestModel;
import com.wyyy.assetsmanage.utils.LogUtils;
import com.wyyy.assetsmanage.utils.NetUtils;

import butterknife.Bind;
import butterknife.OnClick;
import rx.Subscriber;
import rx.Subscription;

public class MainActivity extends BaseActivity implements IBaseSubscriber{

    @Bind(R.id.btnTest)
    Button btnTest;

    @Override
    protected void setUpComponent(AppComponent appComponent) {

    }

    @Override
    protected void initViews() {
        setContentView(R.layout.activity_main);
        toast.showToast("出来吧");
        //mToolbar.setVisibility(View.GONE);
        setTitleName("资产盘点");
        mToolbar.setNavigationIcon(null);
        //sideView.openDrawer();
        getTaobaodata2("21.22.11.33");


    }

    @Override
    protected void initEvents() {

    }
    @OnClick(R.id.btnTest)
    public void btnClick(Button btn){
        startActivity(new Intent(MainActivity.this,Main2Activity.class));
       // startActivity(new Intent(MainActivity.this,LoginActivity.class));
    }
    private  void getTaobaodata(String ip){
        Subscriber subscriber=new Subscriber<TestModel>() {
            @Override
            public void onCompleted() {
                toast.showToast("onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                toast.showToast( NetUtils.checkApiException(e));
            }

            @Override
            public void onNext(TestModel o) {
              toast.showToast(o.getCountry());

            }
        };
        Subscription sn=apiMethods.getTaoboData(subscriber,ip);
        addSubscription(sn);
    }
    //使用BaseSubscriber访问网络
    private void getTaobaodata2(String ip) {
        Subscription sn = apiMethods.getTaoboData(new BaseSubscriber<TestModel>(this, 1), ip);
        addSubscription(sn);
    }
    //使用BaseSubscriber访问网络
    private void getTaobaodata3(String ip) {
        Subscription sn = apiMethods.getTaoboData(new BaseSubscriber<TestModel>(this, 1), ip);
/*
        Observable observable=apiStores.getTaobaoData(ip);
         toSubscribe(observable,subscriber);
*/
        addSubscription(sn);
    }

    @Override
    public void onNext(Object o, int flag) {
        switch (flag) {
            case 1:
                toast.showToast(((TestModel)o).getCountry());
                break;
            case 2:
                toast.showToast(((TestModel)o).getCountry());
                break;
            default:
                toast.showToast("没有对应flag");
        }
    }

    @Override
    public void onCompleted() {
        toast.showToast("onCompleted");
    }

    @Override
    public void onError(Throwable e) {
        toast.showToast( NetUtils.checkApiException(e));
       // toast.showToast(e.getMessage());
        LogUtils.e(e.getMessage());
    }
}
