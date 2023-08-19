package com.hiiro.fuckddvip;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import static de.robv.android.xposed.XposedHelpers.findClass;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import java.util.UUID;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class MainHook implements IXposedHookLoadPackage {
    private final String pkgName = "info.zzjdev.musicdownload";

    @Override
    public void handleLoadPackage(LoadPackageParam lpparam) throws Throwable {
        if (lpparam.packageName.equals("com.hiiro.fuckddvip")) return;
        hookMainActivity(lpparam);
        hookDeviceIdUtil(lpparam);
        hookVip(lpparam);
        hookVideo(lpparam);
    }

    private void hookMainActivity(LoadPackageParam lpparam) {
        Class<?> mainClass = XposedHelpers.findClass(pkgName + ".ui.activity.MainActivity", lpparam.classLoader);
        findAndHookMethod(mainClass, "initView", Bundle.class,
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("[fuckddvip]mainhook success!!!!!!!");
                        Toast.makeText((Activity) param.thisObject, "FuckDDVip模块加载成功!", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void hookDeviceIdUtil(LoadPackageParam lpparam) {
        Class<?> DeviceIdUtilClass = XposedHelpers.findClass(pkgName + ".util.और", lpparam.classLoader);
        findAndHookMethod(DeviceIdUtilClass, "जोरसेक", Context.class,
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        XposedBridge.log("[fuckddvip]utilhook success!!!!!!!");
                        String string = UUID.randomUUID().toString();
                        param.setResult(string);
                    }
                });
    }

    private void hookVip(LoadPackageParam lpparam) {
        Class<?> userInfoClass = findClass(pkgName + ".mvp.model.entity.UserInfo", lpparam.classLoader);
        findAndHookMethod(userInfoClass, "vip",
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(1);
                        XposedBridge.log("[vip]vip hook success");
                    }
                });
        findAndHookMethod(userInfoClass, "getVip",
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(Boolean.TRUE);
                        XposedBridge.log("[getVip]getVip hook success");
                    }
                });
        findAndHookMethod(userInfoClass, "setVip", boolean.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(true);
                        XposedBridge.log("[setVipbol]setVipbol hook success");
                    }
                });
        findAndHookMethod(userInfoClass, "setVip", int.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(1);
                        XposedBridge.log("[setVipint]setVipint hook success");
                    }
                });
        findAndHookMethod(userInfoClass, "getExpire",
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult("2099-12-31 23:59:59");
                        XposedBridge.log("[getExpire]getExpire hook success");
                    }
                });
        findAndHookMethod(userInfoClass, "getCollectionMax",
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(9999);
                        XposedBridge.log("[getCollectionMax]getCollectionMax hook success");
                    }
                });
        findAndHookMethod(userInfoClass, "getScore",
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(9999);
                        XposedBridge.log("[getScore]getScore hook success");
                    }
                });
        findAndHookMethod(userInfoClass, "isVip",
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(true);
                        XposedBridge.log("[isVip]isVip hook success");
                    }
                });
    }

    private void hookVideo(LoadPackageParam lpparam) {
        Class<?> userInfoClass = findClass(pkgName + ".util.हैकमरे.कुछ", lpparam.classLoader);
        findAndHookMethod(userInfoClass, "लेबर",
                new XC_MethodHook() {
                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        param.setResult(true);
                        XposedBridge.log("[video]video hook success");
                    }
                });
    }

}
