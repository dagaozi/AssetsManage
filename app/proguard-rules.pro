# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\ThirdSDK\android-sdk-windows/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
#optimizationpasses表示对代码进行迭代优化的次数，optimization可以对代码进行各种优化，每次优化后还可以继续优化，故称之迭代优化；
-optimizationpasses 5
#混淆时不产生混合大小写的类名
-dontusemixedcaseclassnames
#指定不去忽略非公共的库类
-dontskipnonpubliclibraryclasses
#不预校验
-dontpreverify

#显示混淆的log，帮助排错
-verbose

#代码混淆采用的算法，一般不改变，使用谷歌默认算法即可
-optimizations !code/simplification/arithmetic,!field/*,!class/merging/*

#如果项目中有用到注释，则加入
-keepattributes *Annotation*
-keepattributes Signature

-keep public class * extends android.app.Fragment
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Application
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.preference.Preference
-keep public class * extends android.content.ContentProvider
-keep public class * extends android.support.v4.**
-keep public class * extends android.support.annotation.**
-keep public class * extends android.support.v7.**

#ButterKnife
-keep class butterknife.** { *; }
 -dontwarn butterknife.internal.**
 -keep class **$$ViewBinder { *; }
 -keepclasseswithmembernames class * {
     @butterknife.* <fields>;
 }
 -keepclasseswithmembernames class * {
     @butterknife.* <methods>;
 }
 #Retrofit
 -dontwarn retrofit2.**
 -keep class retrofit2.** { *; }
 -keepattributes Signature
 -keepattributes Exceptions

#RxJava RxAndroid
-dontwarn sun.misc.**
-keepclassmembers class rx.internal.util.unsafe.*ArrayQueue*Field* {
   long producerIndex;
   long consumerIndex;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueProducerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode producerNode;
}
-keepclassmembers class rx.internal.util.unsafe.BaseLinkedQueueConsumerNodeRef {
    rx.internal.util.atomic.LinkedQueueNode consumerNode;
}

#Gson
#-keepattributes Signature-keepattributes *Annotation*
-keep class sun.misc.Unsafe { *; }
-keep class com.google.gson.stream.** { *; }
# Application classes that will be serialized/deserialized over Gson 下面替换成自己的实体类
-keep class com.wyyy.assetsmanage.model.** { *; }

#OKhttp3
-dontwarn com.squareup.okhttp3.**
-keep class com.squareup.okhttp3.** { *;}
-dontwarn okio.**

#这些有警告也不去处理
-dontwarn android.support.v4.**
-dontwarn org.apache.commons.net.**
-dontwarn com.tencent.**

#如果用到了webview的复杂操作，则加入
-keepclassmembers class * extends android.webkit.WebViewClient {
     public void *(android.webkit.WebView,java.lang.String,android.graphics.Bitmap);
     public boolean *(android.webkit.WebView,java.lang.String);
}

-keepclassmembers class * extends android.webkit.WebChromeClient {
     public void *(android.webkit.WebView,java.lang.String);
}

#保持native方法不被混淆
-keepclasseswithmembernames class * {
    native <methods>;
}
#保持自定义控件类，不被混淆
-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet);
}

-keepclasseswithmembernames class * {
    public <init>(android.content.Context, android.util.AttributeSet, int);
}

-keepclasseswithmembers class * {
    public <init>(android.content.Context);
}
#保持枚举类不进行混淆
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}
#保持 Parcelable 类不被混淆
-keep class * implements android.os.Parcelable {
  public static final android.os.Parcelable$Creator *;
}

