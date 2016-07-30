package com.wyyy.assetsmanage.ui;

import android.os.Bundle;
import android.widget.Button;

import com.wyyy.assetsmanage.R;
import com.wyyy.assetsmanage.base.BaseActivity;
import com.wyyy.assetsmanage.base.BaseSubscriber;
import com.wyyy.assetsmanage.base.IBaseSubscriber;
import com.wyyy.assetsmanage.model.TaskModel;
import com.wyyy.assetsmanage.model.TestData;
import com.wyyy.assetsmanage.model.TestModel;
import com.wyyy.assetsmanage.model.UploadResult;
import com.wyyy.assetsmanage.utils.LogUtils;
import com.wyyy.assetsmanage.utils.NetUtils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Subscription;

/**
 * 主页
 * Created by 郝海滨（dagaozi@163.com）
 * 创建时间 2016/7/18 11:11
 * 描述：
 */
public class MainActivity extends BaseActivity implements IBaseSubscriber {

    @Bind(R.id.btnTest)
    Button btnTest;

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

    @OnClick(R.id.btnTest)
    public void btnClick(Button btn) {
        getTaobaodata2("21.22.11.33");
    }



    //使用BaseSubscriber访问网络
    private void getTaobaodata2(String ip) {
        Subscription sn = apiMethods.getTaoboData(new BaseSubscriber<TestModel>(this, 1), ip);
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
        toast.showToast("onCompleted");
    }

    @Override
    public void onError(Throwable e) {
        toast.showToast(NetUtils.checkApiException(e));
        // toast.showToast(e.getMessage());
        LogUtils.e(e.getMessage());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
