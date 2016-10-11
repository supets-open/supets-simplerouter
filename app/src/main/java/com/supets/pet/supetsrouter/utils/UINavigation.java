package com.supets.pet.supetsrouter.utils;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.supets.pet.supetsrouter.model.NavigationStack;

//http://handsomeliuyang.iteye.com/blog/1315283
public class UINavigation {


    public static final String Key_Stack = "stack";


    public static void pop(Context from) {
        if (from instanceof Activity) {
            ((Activity) from).finish();
        }
    }

    public static void popSetResult(Context from, int resultCode, Intent intent) {
        if (from instanceof Activity) {
            ((Activity) from).setResult(resultCode, intent);
            ((Activity) from).finish();
        }
    }

    public static void pushStandard(Context from, Class<?> to, Bundle bundle) {
        NavigationStack stack = new NavigationStack();
        stack.setClassName(from.getClass().getName());
        Intent intent = new Intent(from, to);
        intent.putExtras(bundle);
        intent.putExtra(Key_Stack, stack);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        from.startActivity(intent);
    }

    public static void pushStandardForResult(Activity from, Class<?> to, int requestCode, Bundle bundle) {
        NavigationStack stack = new NavigationStack();
        stack.setClassName(from.getClass().getName());
        Intent intent = new Intent(from, to);
        intent.putExtras(bundle);
        intent.putExtra(Key_Stack, stack);
        from.startActivityForResult(intent, requestCode);
    }

    /**
     * 清除栈某个Activity之上的所有Activity，自己不重新创建
     * manifest不需要任何配置启动模式
     * 调用onNewIntent
     *
     * @param from
     * @param to
     * @param bundle
     */
    public static void pushCleanTopRecycler2(Context from, Class<?> to, Bundle bundle) {
        NavigationStack stack = new NavigationStack();
        stack.setClassName(from.getClass().getName());
        Intent intent = new Intent(from, to);
        intent.putExtras(bundle);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        if (!(from instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        intent.putExtra(Key_Stack, stack);
        from.startActivity(intent);
    }

    /**
     * 清除栈某个Activity之上的所有Activity，自己不重新创建
     * manifest不需要任何配置启动模式
     * 调用onNewIntent
     *
     * @param from
     * @param to
     * @param bundle
     */
    public static void pushCleanTopRecycler(Context from, Class<?> to, Bundle bundle) {
        NavigationStack stack = new NavigationStack();
        stack.setClassName(from.getClass().getName());
        Intent intent = new Intent(from, to);
        intent.putExtras(bundle);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        if (!(from instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        intent.putExtra(Key_Stack, stack);
        from.startActivity(intent);
    }

    /**
     * 清除栈某个Activity之上的所有Activity，自己重新创建
     * manifest不需要任何配置启动模式
     *
     * @param from
     * @param to
     * @param bundle
     */
    public static void pushCleanTop(Context from, Class<?> to, Bundle bundle) {
        NavigationStack stack = new NavigationStack();
        stack.setClassName(from.getClass().getName());
        Intent intent = new Intent(from, to);
        intent.putExtras(bundle);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        if (!(from instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        intent.putExtra(Key_Stack, stack);
        from.startActivity(intent);
    }

    /**
     * 多次启动某个Activity，自己不重新创建
     * manifest不需要任何配置启动模式
     * 调用onNewIntent
     *
     * @param from
     * @param to
     * @param bundle
     */
    public static void pushSingleTop(Context from, Class<?> to, Bundle bundle) {
        NavigationStack stack = new NavigationStack();
        stack.setClassName(from.getClass().getName());
        Intent intent = new Intent(from, to);
        intent.putExtras(bundle);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        if (!(from instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        intent.putExtra(Key_Stack, stack);
        from.startActivity(intent);
    }

    /**
     * 清除栈某个Activity之上的所有Activity，自己不重新创建
     * manifest需要配置singletask启动模式
     * 调用onNewIntent
     * 这种模式主要另起一个单任务，需要和taskAffinity一起使用发挥更好的作用
     *
     * @param from
     * @param to
     * @param bundle
     */
    public static void pushSingleTask(Context from, Class<?> to, Bundle bundle) {
        NavigationStack stack = new NavigationStack();
        stack.setClassName(from.getClass().getName());
        Intent intent = new Intent(from, to);
        intent.putExtras(bundle);
        if (!(from instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        intent.putExtra(Key_Stack, stack);
        from.startActivity(intent);
    }

    /**
     * 清除栈某个Activity之上的所有Activity，自己不重新创建
     * manifest需要配置singleInstance启动模式
     * 调用onNewIntent
     * 这种模式主要单独使用单独使用一个任务堆栈，有却只有一个单例模式。
     *
     * @param from
     * @param to
     * @param bundle
     */
    public static void pushSingleInstance(Context from, Class<?> to, Bundle bundle) {
        NavigationStack stack = new NavigationStack();
        stack.setClassName(from.getClass().getName());
        Intent intent = new Intent(from, to);
        intent.putExtras(bundle);
        if (!(from instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        intent.putExtra(Key_Stack, stack);
        from.startActivity(intent);
    }

}
