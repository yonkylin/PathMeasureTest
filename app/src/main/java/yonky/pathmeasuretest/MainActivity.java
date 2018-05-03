package yonky.pathmeasuretest;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AccelerateDecelerateInterpolator;

public class MainActivity extends AppCompatActivity {
    PathView mPathView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       mPathView = findViewById(R.id.pathView);
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mPathView,"fraction",0,1);
//        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        objectAnimator.setDuration(2000);
        objectAnimator.setRepeatCount(100);
        objectAnimator.start();
    }
}
