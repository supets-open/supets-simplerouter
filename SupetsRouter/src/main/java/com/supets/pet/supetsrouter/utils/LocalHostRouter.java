package com.supets.pet.supetsrouter.utils;

import android.content.Context;
import android.util.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LocalHostRouter {
    private final static String TAG = LocalHostRouter.class.getSimpleName();
    private static LocalHostRouter mInstance=new LocalHostRouter();
    private static Context mContext;

    public static LocalHostRouter getInstance() {
        return mInstance;
    }

    public static void register(Context context) {
        mContext = context;
    }

    @SuppressWarnings("unchecked")
    public <T> T create(Class<T> aClass) {
        return (T) Proxy.newProxyInstance(aClass.getClassLoader(), new Class<?>[]{aClass},
                new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object... args) throws Throwable {
                        StringBuilder stringBuilder = new StringBuilder();
                        RouterUri reqUrl = method.getAnnotation(RouterUri.class);
                        stringBuilder.append(reqUrl.routerUri());
                        Annotation[][] parameterAnnotationsArray = method.getParameterAnnotations();//拿到参数注解
                        int pos = 0;
                        for (int i = 0; i < parameterAnnotationsArray.length; i++) {
                            Annotation[] annotations = parameterAnnotationsArray[i];
                            if (annotations != null && annotations.length != 0) {
                                if (pos == 0) {
                                    stringBuilder.append("?");
                                } else {
                                    stringBuilder.append("&");
                                }
                                pos++;
                                RouterParam reqParam = (RouterParam) annotations[0];
                                stringBuilder.append(reqParam.value());
                                stringBuilder.append("=");
                                stringBuilder.append(args[i]);
                            }
                        }
                        openRouterUri(stringBuilder.toString());
                        return null;
                    }


                });
    }

    private void openRouterUri(String url) {
        Log.e(TAG, "router_url------> " + url);
        UINavigation.pushUri(mContext,url);
    }

}