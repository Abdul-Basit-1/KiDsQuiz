package com.example.ashar.animation;

        import android.os.Bundle;
        import android.os.CountDownTimer;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.view.View;
        import android.widget.TextView;

public class StartGame extends AppCompatActivity {
    static int latestScore = 0;
    static int count = 0;
    CountDownTimer countDownTimer  = new CountDowntimer(10000, 1000);
    TextView timer, score,question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);
        timer = (TextView) findViewById(R.id.timer);
        score = (TextView) findViewById(R.id.update_score);

    }

    public class CountDowntimer extends CountDownTimer {
        public CountDowntimer(long millisUntilFinished, long countDownInterval) { super(10000, 1000); }
        @Override
        public void onTick(long millisUntilFinished) {
            timer.setText("Time Remaining: " + millisUntilFinished / 1000);
        }
        public void onFinish() { }
    }

   /* public void questionsComplete(){
        if(count != 20){
            question.setText(randonQuestion[count].toString());
            count++;
            countDownTimer.start();
            isClick();
        }
        else{timer.setText("Time's up");}
    }*/

   /* public void isClick(){
        imageButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                latestScore++;
                score.setText(latestScore+"/20 ");
                questionsComplete();

            }
        });
        if (!imageButton.isClickable()){
            score.setText(latestScore+"/20");
            questionsComplete();
        }
    }*/




}
