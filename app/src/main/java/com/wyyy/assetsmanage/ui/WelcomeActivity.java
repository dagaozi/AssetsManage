package com.wyyy.assetsmanage.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.widget.ImageView;

import com.wyyy.assetsmanage.R;
import com.wyyy.assetsmanage.base.BaseActivity;

import butterknife.Bind;
import rx.Observable;
import rx.Subscriber;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class WelcomeActivity extends BaseActivity {

    @Bind(R.id.img_welcome)
    ImageView imgWelcome;


    @Override
    protected void initViews() {
        setContentView(R.layout.activity_welcom);

        mToolbar.setVisibility(View.GONE);
        //初始化动画文件 绑定控件
        Animator animation = AnimatorInflater.loadAnimator(WelcomeActivity.this, R.animator.welcome_animator);
        animation.setTarget(imgWelcome);
    /*    Observable.create(new AnimatorOnSubscribe(animation)).subscribeOn(AndroidSchedulers.mainThread())//指定订阅的Observable对象的call方法运行在ui线程中
                .observeOn(Schedulers.io())
                .filter(new Func1<Void, Boolean>() {
                    @Override
                    public Boolean call(Void aVoid) {
                        //filter过滤：判断是否登录过，如果false就会跳过下面的操作
                        return isLogin;
                    }
                })
*//*                .filter(new Func1<Void, Boolean>() {
                    @Override
                    public Boolean call(Void aVoid) {
                        //过滤：判断上次登录是否超过时间差
                        Long lastTime= (Long) SPUtils.get(getApplicationContext(),Constant.LOGINTIME,0L);
                        return System.currentTimeMillis()-lastTime >mTimeDifference;
                    }
                })*//*
                .flatMap(new Func1<Void, Observable<TokenBean>>() {
                    @Override
                    public Observable<TokenBean> call(Void aVoid) {
                        //flatMap转换：和 map() 有一个相同点：它也是把传入的参数转化之后返回另一个对象。但需要注意，和 map()不同的是， flatMap() 中返回的是个 Observable 对象
                        //上面两步都为true才能到这里，取出用户信息，开始联网。
                        String userAccount= (String) SPUtils.get(getApplicationContext(),Constant.USERACCOUNT,"");
                        String userPassword= (String) SPUtils.get(getApplicationContext(),Constant.USERPASSWORD,"");
                        return getUserToken(userAccount,userPassword);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())//最后统一回到UI线程中处理
                .subscribe(new Subscriber<TokenBean>() {
                    @Override
                    public void onCompleted() {
                        //所有操作完成，统一回调这里，实现Activity跳转功能
                        startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
                        finish();
                    }

                    @Override
                    public void onError(Throwable e) {
                        //异常处理，根据每个项目而定，这里不具体写
                        LogUtils.e(e.getMessage());
                    }

                    @Override
                    public void onNext(TokenBean tokenBean) {
                        //只有网络成功才会回调这里，这里可以保存网络数据。
                    }
                });*/
    }

    @Override
    protected void initEvents() {

    }

    class AnimatorOnSubscribe implements Observable.OnSubscribe<Void> {
        final Animator animator;

        public AnimatorOnSubscribe(Animator animator) {
            this.animator = animator;
        }

        @Override
        public void call(final Subscriber<? super Void> subscriber) {
            //checkUiThread();//检查是否在UI线程调用，否则不能播放动画
            AnimatorListenerAdapter adapter=new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);
                    subscriber.onNext(null);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    subscriber.onCompleted();
                }
            };

            animator.addListener(adapter);
            animator.start();//先绑定监听器再开始
        }
    }

}
