package com.lad.lad;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

public class splash extends Activity implements Animation.AnimationListener {
    private final int SPLASH_DISPLAY_LENGTH = 2000;

    protected Animation fadeIn;
    protected ImageView l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);


        fadeIn = AnimationUtils.loadAnimation(this,R.anim.fade);

        l = (ImageView) findViewById(R.id.img);
        l.setVisibility(View.VISIBLE);
        l.setAnimation(fadeIn);

        Thread timerThread = new Thread(){
            public void run(){
                try{
                    sleep (2500);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(splash.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();


    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    @Override
    public void onAnimationStart(Animation animation) {


    }

    @Override
    public void onAnimationEnd(Animation animation) {
        Toast.makeText(getBaseContext(), "Animation Stopped!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
}
