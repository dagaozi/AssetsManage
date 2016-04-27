package com.wyyy.assetsmanage.base;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wyyy.assetsmanage.R;
import com.wyyy.assetsmanage.di.component.AppComponent;
import com.wyyy.assetsmanage.di.component.DaggerActivityComponent;
import com.wyyy.assetsmanage.di.modules.ActivityModule;
import com.wyyy.assetsmanage.net.ApiMethods;
import com.wyyy.assetsmanage.utils.ToastUtil;

import javax.inject.Inject;

import butterknife.ButterKnife;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by dagaozi on 216/3/30.
 */
public abstract class BaseActivity extends AppCompatActivity {
    protected Toolbar mToolbar;
    private TextView tvTitle;
    protected LinearLayout mBaseLayout;
    // public static final ApiMethods apiMethods = ApiMethods.getInstance();
    private CompositeSubscription mCompositeSubscription;
    @Inject
    public ApiMethods apiMethods;
    @Inject
    public ToastUtil toast;

    public CompositeSubscription getCompositeSubscription() {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }
        return this.mCompositeSubscription;
    }
    public void addSubscription(Subscription s) {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }
        this.mCompositeSubscription.add(s);
    }

       protected void setUpActivityComponet(){
          DaggerActivityComponent.builder().appComponent(getAppComponent()).activityModule(new ActivityModule(this)).build().inject(this);

    }
    protected AppComponent getAppComponent() {

        return ((BaseApp) getApplication()).getAppcomponet();
    }
    protected  abstract void setUpComponent(AppComponent appComponent);
    protected abstract void initViews();
    protected  abstract void initEvents();

    @Override
    public void setContentView(int layoutResID) {
        //super.setContentView(layoutResID);
        LayoutInflater inflater=LayoutInflater.from(this);
        inflater.inflate(layoutResID,mBaseLayout);
        ButterKnife.bind(BaseActivity.this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        initBaseData();
       setUpComponent(getAppComponent());
        setUpActivityComponet();

        initViews();
        initEvents();
    }
    private void initBaseData(){
        super.setContentView(R.layout.base_activity);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        tvTitle = (TextView) mToolbar.findViewById(R.id.tv_toolbar);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mBaseLayout=(LinearLayout)findViewById(R.id.content);
    }
    protected void setTitleName(String name){
        tvTitle.setText(name);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(BaseActivity.this);
        if(mCompositeSubscription!=null)
            mCompositeSubscription.unsubscribe();
    }
}
