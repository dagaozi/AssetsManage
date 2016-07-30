package com.wyyy.assetsmanage.ui;

import android.util.Log;
import android.widget.Button;

import com.wyyy.assetsmanage.R;
import com.wyyy.assetsmanage.base.BaseActivity;
import com.wyyy.assetsmanage.base.BaseSubscriber;
import com.wyyy.assetsmanage.base.IBaseSubscriber;
import com.wyyy.assetsmanage.model.TaskModel;
import com.wyyy.assetsmanage.model.TestData;
import com.wyyy.assetsmanage.model.TestModel;
import com.wyyy.assetsmanage.model.UploadResult;
import com.wyyy.assetsmanage.net.HttpResultFunc;
import com.wyyy.assetsmanage.utils.NetUtils;
import com.wyyy.assetsmanage.utils.ToastUtil;

import butterknife.Bind;
import butterknife.OnClick;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * 主页
 * Created by 郝海滨（dagaozi@163.com）
 * 创建时间 2016/7/18 11:11
 * 描述：
 */
public class MainActivity extends BaseActivity implements IBaseSubscriber {

    @Bind(R.id.btnTest)
    Button btnTest;
    @Bind(R.id.btnTest2)
    Button btnTest2;
    @Bind(R.id.btnTest3)
    Button btnTest3;
    @Bind(R.id.btnTest4)
    Button btnTest4;

    @Override
    protected void initViews() {

        setContentView(R.layout.activity_main);
        //mToolbar.setVisibility(View.GONE);
        setTitleName("资产盘点");
        mToolbar.setNavigationIcon(null);

    }

    @Override
    protected void initEvents() {

    }

    @OnClick({R.id.btnTest, R.id.btnTest2, R.id.btnTest3, R.id.btnTest4})
    public void btnClick(Button btn) {
        switch ((btn.getId())) {
            case R.id.btnTest:
                getTaobaodata("21.22.11.33");
                break;
            case R.id.btnTest2: //多次调用崩溃
                getTaobaodata2("21.22.11.33");
                break;
            case R.id.btnTest3:
                getTaobaodata3("21.22.11.33");
                break;
            case R.id.btnTest4:  //多次调用崩溃
                getTaobaodata4("21.22.11.33");
                break;
            default:
                break;
        }
    }




    //使用subscriber观察，数据过滤，线程切换未封装
    private void getTaobaodata(String ip) {
        Subscriber subscriber = new Subscriber<TestModel>() {
            @Override
            public void onCompleted() {
                // toast.showToast("onCompleted");
                Log.d("TAG", "onError");
            }

            @Override
            public void onError(Throwable e) {
                toast.showToast(NetUtils.checkApiException(e));
                Log.e("TAG", "onError");
            }

            @Override
            public void onNext(TestModel o) {
                toast.showToast(o.getCountry());

            }
        };
        Observable observable = apiStores.getTaobaoData(ip);
        Subscription sn = observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new HttpResultFunc<TestModel>())
                .subscribe(subscriber);
        addSubscription(sn);

    }

    //使用BaseSubscriber观察，数据过滤，线程切换封装
    private void getTaobaodata2(String ip) {
        Subscription sn = apiMethods.getTaoboData(new BaseSubscriber<TestModel>(this, 1), ip);
        addSubscription(sn);
    }
    //使用subscriber观察，数据过滤，线程切换封装
    private void getTaobaodata3(String ip) {
        Subscriber subscriber = new Subscriber<TestModel>() {
            @Override
            public void onCompleted() {
                // toast.showToast("onCompleted");
                Log.d("TAG", "onError");
            }

            @Override
            public void onError(Throwable e) {
                toast.showToast(NetUtils.checkApiException(e));
                Log.e("TAG", "onError");
            }

            @Override
            public void onNext(TestModel o) {
                toast.showToast(o.getCountry());

            }
        };
        Subscription sn = apiMethods.getTaoboData(subscriber, ip);
        addSubscription(sn);

    }
    //使用BaseSubscriber观察，数据过滤，线程切换封装
    private void getTaobaodata4(String ip) {
        Observable observable = apiStores.getTaobaoData(ip);
        Subscription sn = observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new HttpResultFunc<TestModel>())
                .subscribe(new BaseSubscriber<TestModel>(this, 1));
        addSubscription(sn);
    }


    @Override
    public void onNext(Object o, int flag) {
        switch (flag) {
            case 1:
                toast.showToast(((TestModel) o).getCountry());
                break;
            case 2:
                toast.showToast(((TestModel) o).getCountry());
                break;
            case 4:
                hideProgressDialog();
                toast.showToast(((TestModel) o).getCountry() + "4");
                break;
            case 5:
                hideProgressDialog();
                toast.showToast(((TestData) o).getResultcode() + "5");
                btnTest.setText(((TestData) o).getResultcode());
                break;
            case 6:
                hideProgressDialog();
                toast.showToast(((TaskModel) o).getTask_list().size() + "6");

                break;
            case 7:
                hideProgressDialog();
                toast.showToast(((TaskModel) o).getTask_list().size() + "7");
                break;
            case 8:
                hideProgressDialog();
                toast.showToast(((UploadResult) o).getReturn_msg() + "_8");
                break;
            default:
                toast.showToast("没有对应flag");
        }
    }

    @Override
    public void onCompleted() {
        //toast.showToast("onCompleted");
    }

    @Override
    public void onError(Throwable e) {

        Log.e("onError", e.getMessage());
        ToastUtil.showToast(MainActivity.this, NetUtils.checkApiException(e));

    }

}
