package com.besome.sketch;
import android.content.Context;
public class SdkManager {
    public static void saveSdk(Context c, int compile, int target, int min){
        c.getSharedPreferences("pro_sdk", 0).edit().putInt("c",compile).putInt("t",target).putInt("m",min).apply();
    }
    public static int getTarget(Context c){return c.getSharedPreferences("pro_sdk",0).getInt("t",34);}
    public static int getCompile(Context c){return c.getSharedPreferences("pro_sdk",0).getInt("c",34);}
    public static int getMin(Context c){return c.getSharedPreferences("pro_sdk",0).getInt("m",21);}
}
