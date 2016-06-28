package com.wyyy.assetsmanage.ui;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.wyyy.assetsmanage.R;
import com.wyyy.assetsmanage.utils.SPUtils;

import rx.Observable;
import rx.Subscriber;

public class TestActivity extends Activity {

    ImageView imgWelcome;
    public boolean isLogin=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_test);
        setContentView(R.layout.activity_welcom);
        imgWelcome=(ImageView)findViewById(R.id.img_welcome);
        isLogin = (Boolean) SPUtils.get(getApplicationContext(), Constant.ISLOGIN, isLogin);

        //初始化动画文件 绑定控件
        Animator animation = AnimatorInflater.loadAnimator(TestActivity.this, R.animator.welcome_animator);
        animation.setTarget(imgWelcome);
        Observable.create(new AnimatorOnSubscribe(animation))
                .subscribe(new Subscriber<Void>() {
                    @Override
                    public void onCompleted() {
                        //所有操作完成，统一回调这里，实现Activity跳转功能
                        if(isLogin)
                        startActivity(new Intent(TestActivity.this, MainActivity.class));
                        else
                            startActivity(new Intent(TestActivity.this, MainActivity.class));
                        finish();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Void aVoid) {

                    }
                });
           /*     .subscribe(new Subscriber<TokenBean>() {
                    @Override
                    public void onCompleted() {
                        //所有操作完成，统一回调这里，实现Activity跳转功能
                        startActivity(new Intent(TestActivity.this, MainActivity.class));
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

    class AnimatorOnSubscribe implements Observable.OnSubscribe<Void> {
        final Animator animator;

        public AnimatorOnSubscribe(Animator animator) {
            this.animator = animator;
        }

        @Override
        public void call(final Subscriber<? super Void> subscriber) {
            //checkUiThread();//检查是否在UI线程调用，否则不能播放动画
            AnimatorListenerAdapter adapter = new AnimatorListenerAdapter() {
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
