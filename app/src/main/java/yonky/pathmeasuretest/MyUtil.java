package yonky.pathmeasuretest;

import android.content.Context;

/**
 * Created by Administrator on 2018/5/3.
 */

public class MyUtil {
    public static int dp2px(Context context, int dp){
        float scale =context.getResources().getDisplayMetrics().density;
        return (int)(dp*scale+0.5);
    }
}
