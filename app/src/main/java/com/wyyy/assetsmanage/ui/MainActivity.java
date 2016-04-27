package com.wyyy.assetsmanage.ui;

import android.content.Intent;
import android.widget.Button;

import com.wyyy.assetsmanage.R;
import com.wyyy.assetsmanage.base.BaseActivity;
import com.wyyy.assetsmanage.di.component.AppComponent;

import butterknife.Bind;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

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
        mToolbar.setNavigationIcon(null);
        setTitleName("资产盘点");


    }

    @Override
    protected void initEvents() {

    }
    @OnClick(R.id.btnTest)
    public void btnClick(Button btn){
        startActivity(new Intent(MainActivity.this,Main2Activity.class));
    }
}
