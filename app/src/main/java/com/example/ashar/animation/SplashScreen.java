package com.example.ashar.animation;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by ASHAR on 2/18/2016.
 */
public class SplashScreen extends Activity {

    ImageSettings imageSettings;
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }
    Thread splashTread;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        StartAnimations();


    }


    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.zoomin);
        ImageView iv = (ImageView) findViewById(R.id.splash);
        TextView l=(TextView)findViewById(R.id.tex1);

        iv.clearAnimation();

        iv.startAnimation(anim);
        l.clearAnimation();
        l.startAnimation(anim);


     Animation   ani = AnimationUtils.loadAnimation(this, R.anim.rotate);
        anim.reset();
        ImageView Iv = (ImageView) findViewById(R.id.splash);
        Iv.clearAnimation();
        Iv.startAnimation(ani);

        splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 3500) {
                        sleep(100);
                        waited += 100;
                    }
                    Intent intent = new Intent(SplashScreen.this,
                            MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);

                    startActivity(intent);
                    SplashScreen.this.finish();
                } catch (InterruptedException e) {
                    // do nothing
                } finally {
                    SplashScreen.this.finish();
                }

            }
        };
        splashTread.start();

    }





}
