package com.wyyy.assetsmanage.base;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.Theme;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.wyyy.assetsmanage.R;
import com.wyyy.assetsmanage.di.component.AppComponent;
import com.wyyy.assetsmanage.net.ApiMethods;
import com.wyyy.assetsmanage.net.ApiStores;
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
    protected Drawer sideView;
    // public static final ApiMethods apiMethods = ApiMethods.getInstance();
    private CompositeSubscription mCompositeSubscription;
    @Inject
    public ApiMethods apiMethods;
    @Inject
    public ApiStores apiStores;
    @Inject
    public ToastUtil toast;
    private boolean isLoading=false;
    private MaterialDialog progressDialog;

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
         // DaggerActivityComponent.builder().appComponent(getAppComponent()).activityModule(new ActivityModule(this)).build().inject(this);
           this.getAppComponent().inject(this);
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
        mBaseLayout=(LinearLayout)findViewById(R.id.content);
        initToolbar();
        initSideView();
    }
    protected void setTitleName(String name){
        tvTitle.setText(name);
    }


    /**
     * 初始化导航栏
     */
    private void initToolbar(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        tvTitle = (TextView) mToolbar.findViewById(R.id.tv_toolbar);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        getSupportActionBar().setHomeButtonEnabled(true);//设置返回键可用
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    /**
     * 初始化侧边栏
     */
    private  void  initSideView(){
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.sidebackgroud)
                .addProfiles(
                        new ProfileDrawerItem().withName("登陆者").withIcon(getResources().getDrawable(R.drawable.header))
                )
             /*   .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })*/
                .build();
//create the drawer and remember the `Drawer` result object
        sideView = new DrawerBuilder()
                .withAccountHeader(headerResult)
                .withActivity(this)
               // .withToolbar(mToolbar)
                .withDrawerGravity(Gravity.RIGHT)
                .withTranslucentStatusBar(true)
                .withActionBarDrawerToggle(false)
                .addDrawerItems(
                        new PrimaryDrawerItem().withName("功能1").withSubItems( new SecondaryDrawerItem().withName("子菜单1")),
                        new PrimaryDrawerItem().withName("功能2"),
                        new PrimaryDrawerItem().withName("功能3"),
                        /*new Drawer(),*/
                        new SecondaryDrawerItem().withName("功能4").withIcon(R.mipmap.ic_launcher),
                        new SecondaryDrawerItem().withName("功能5").withBadge(R.string.app_name),
                        new SecondaryDrawerItem().withName("功能6")
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                      toast.showToast(position+"");
                        return  false;
                    }
                })
                .build();
     /*   result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        new DrawerBuilder()
                .withActivity(this)
                .addDrawerItems(
                        //pass your items here
                )

                .append(result);
        result.getActionBarDrawerToggle().setDrawerIndicatorEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
           sideView.openDrawer();
            return true;

    }
  public void showProgressDialog(){
      if(isLoading)
          return;
      if(progressDialog==null){
          MaterialDialog.Builder builder = new MaterialDialog.Builder(this)
                  .content(R.string.waiting)
                  .theme(Theme.LIGHT)
                  .progressIndeterminateStyle(true)
                  .cancelable(false)
                  .progress(true, 0);
          progressDialog=builder.build();
      }
      progressDialog.show();
      isLoading=true;
  }
    public void hideProgressDialog(){
        if(progressDialog!=null){
            try{
                progressDialog.dismiss();
            }
            catch (Exception e){
                progressDialog=null;
            }
        }
        isLoading=false;
    }

    @Override
    protected void onStop() {
        super.onStop();
        ButterKnife.unbind(BaseActivity.this);
        if(mCompositeSubscription!=null)
            mCompositeSubscription.unsubscribe();
    }

  /*  @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(BaseActivity.this);
        if(mCompositeSubscription!=null)
            mCompositeSubscription.unsubscribe();
    }*/
}
