package yonky.pathmeasuretest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2018/5/3.
 */

public class PathView extends View {
    Paint mPaint;
    float length;
    float start,stop;
    float fraction;
    int radius;
    public PathView(Context context) {
        super(context);
        initView(context);
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public void initView(Context context){
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(10);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        start=0;
        radius= MyUtil.dp2px(context,40);

    }

    public float getFraction() {
        return fraction;
    }

    public void setFraction(float fraction) {
        this.fraction = fraction;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path= new Path();
        int centerX = getWidth()/2;
        int centerY = getHeight()/2;
        path.addCircle(centerX,centerY,radius, Path.Direction.CW);

        Path mPath= new Path();
        PathMeasure measure = new PathMeasure(path,false);
       length = measure.getLength();
        stop = length*fraction;
        start = (float) (stop - ((0.5 - Math.abs(fraction - 0.5)) * 200f));
       measure.getSegment(start,stop,mPath,true);
        canvas.drawPath(mPath,mPaint);
//        start = stop;
    }
}
