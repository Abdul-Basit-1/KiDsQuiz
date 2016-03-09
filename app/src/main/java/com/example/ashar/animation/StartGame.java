package com.example.ashar.animation;

        import android.content.Intent;
        import android.graphics.Color;
        import android.os.Bundle;
        import android.os.CountDownTimer;
        import android.os.SystemClock;
        import android.support.v7.app.AppCompatActivity;
        import android.support.v7.widget.Toolbar;
        import android.util.Log;
        import android.view.View;
        import android.widget.ImageButton;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.Iterator;
        import java.util.LinkedHashSet;
        import java.util.List;
        import java.util.Random;
        import java.util.Set;

public class StartGame extends AppCompatActivity {
    static int latestScore = 0;
    static int count = 0;
    CountDownTimer countDownTimer  = new CountDowntimer(10000, 1000);
    String[] questions = {"Which of these is a lock icon?", "Identify the school bag.", "Choose the diary.", "Determine the football.", "Specify the hair-brush.", "Distinguish the ice among these.", "Locate the jogger.", "Point out the kitty.", "Pinpoint the knife.", "Which one is the laughing emoticon?", "Which is the message icon?", "Which is the mobile?", "Pick the paint brush.", "Select the rectangle.", "Specify the shape of circle.", "Choose glasses.", "Point out the mammal.", "Determine the pic of camera.", "Which one of these is a real egg of hen?", "Which of these is known as a watch?"};
    TextView timer, score,TvQuestion;
    ImageView img1,img2,img3;
    ImageSettings imageSettings = new ImageSettings();
    String[] randomQuestion;
    int[] randImages = new int[20];
    public int[][] two_D_Array;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);

        timer = (TextView) findViewById(R.id.timer);
        score = (TextView) findViewById(R.id.update_score);
        TvQuestion = (TextView) findViewById(R.id.Question);
        two_D_Array = new int[20][3];







        System.arraycopy(questions, 0, questions, 0, questions.length);
        Random rgen = new Random();
        List<Integer> generated = new ArrayList<Integer>();
        for (int i = 0; i < 20; i++)
        {
            while(true)
            {
                Integer next = rgen.nextInt(20) + 1;
                if (!generated.contains(next))
                {
                    // Done for this iteration
                    generated.add(next);
                    break;
                }
            }
        }



            for (int i =0;i<questions.length;i++){

                //int randPos = rgen.nextInt(questions.length);

                randImages[i] = generated.get(i);


                Log.d("Rand", randImages[i]+"\n");



        }



        InitialzeArray();



        img1 = (ImageView) findViewById(R.id.img1);
        img2 = (ImageView) findViewById(R.id.img2);
        img3 = (ImageView) findViewById(R.id.img3);



        questionsComplete();





    }

    private void InitialzeArray() {

        two_D_Array[0][0] = R.drawable.briefcase1;
        two_D_Array[0][1] = R.drawable.briefcase2;
        two_D_Array[0][2] = R.drawable.lock;

        two_D_Array[1][0] = R.drawable.shoppingbag;
        two_D_Array[1][1] = R.drawable.schoolbag;
        two_D_Array[1][2] = R.drawable.purse;

        two_D_Array[2][0] = R.drawable.books;
        two_D_Array[2][1] = R.drawable.notebook;
        two_D_Array[2][2] = R.drawable.dairy;

        two_D_Array[3][0] = R.drawable.football;
        two_D_Array[3][1] = R.drawable.basketball;
        two_D_Array[3][2] = R.drawable.tennis;

        two_D_Array[4][0] = R.drawable.homepaintbrush;
        two_D_Array[4][1] = R.drawable.hairbrush;
        two_D_Array[4][2] = R.drawable.colorpaint;

        two_D_Array[5][0] = R.drawable.ice;
        two_D_Array[5][1] = R.drawable.snowball;
        two_D_Array[5][2] = R.drawable.snowman;

        two_D_Array[6][0] = R.drawable.sportshoes;
        two_D_Array[6][1] = R.drawable.jogger;
        two_D_Array[6][2] = R.drawable.schoolshoes;

        two_D_Array[7][0] = R.drawable.lionkid;
        two_D_Array[7][1] = R.drawable.puppy;
        two_D_Array[7][2] = R.drawable.kitty;

        two_D_Array[8][0] = R.drawable.knife;
        two_D_Array[8][1] = R.drawable.scissor;
        two_D_Array[8][2] = R.drawable.sword;

        two_D_Array[9][0] = R.drawable.laughing;
        two_D_Array[9][1] = R.drawable.crying;
        two_D_Array[9][2] = R.drawable.smile;

        two_D_Array[10][0] = R.drawable.phoneicon;
        two_D_Array[10][1] = R.drawable.messageicon;
        two_D_Array[10][2] = R.drawable.groupicon;

        two_D_Array[11][0] = R.drawable.sugardevice;
        two_D_Array[11][1] = R.drawable.mobile;
        two_D_Array[11][2] = R.drawable.landlinephone;

        two_D_Array[12][0] = R.drawable.professionpaintbrush;
        two_D_Array[12][1] = R.drawable.pencil;
        two_D_Array[12][2] = R.drawable.birdwing;

        two_D_Array[13][0] = R.drawable.rectangle;
        two_D_Array[13][1] = R.drawable.circle;
        two_D_Array[13][2] = R.drawable.square;

        two_D_Array[14][0] = R.drawable.cutter;
        two_D_Array[14][1] = R.drawable.circle;
        two_D_Array[14][2] = R.drawable.oval;

        two_D_Array[15][0] = R.drawable.shades;
        two_D_Array[15][1] = R.drawable.glasses;
        two_D_Array[15][2] = R.drawable.glass;

        two_D_Array[16][0] = R.drawable.turtle;
        two_D_Array[16][1] = R.drawable.parrot;
        two_D_Array[16][2] = R.drawable.mammal;

        two_D_Array[17][0] = R.drawable.notcamera2;
        two_D_Array[17][1] = R.drawable.notcamera;
        two_D_Array[17][2] = R.drawable.camera;

        two_D_Array[18][0] = R.drawable.hen;
        two_D_Array[18][1] = R.drawable.fish;
        two_D_Array[18][2] = R.drawable.chocodile;

        two_D_Array[19][0] = R.drawable.alarmclock;
        two_D_Array[19][1] = R.drawable.watch;
        two_D_Array[19][2] = R.drawable.clock;


    }


    public class CountDowntimer extends CountDownTimer {
        public CountDowntimer(long millisUntilFinished, long countDownInterval) {
            super(10000, 1000);
        }
        @Override
        public void onTick(long millisUntilFinished) {
            timer.setText("Time Remaining: " + millisUntilFinished / 1000);
        }
        public void onFinish(){
            questionsComplete();
        }
    }


    public void questionsComplete() {

        if (count != 20){
            TvQuestion.setText(questions[randImages[count]]);
           // int [] collect = imagesSelectedForQuestion(questions[count]);
            imagesForDisplay(questions[randImages[count]]);
            count++;
            countDownTimer.start();
        }else{
            countDownTimer.cancel();
            Intent intent = new Intent(StartGame.this, SaveScore.class);
            startActivity(intent);
        }
    }

    private void imagesForDisplay(String question) {

        img1.setImageResource(two_D_Array[randImages[count]][0]);
        img2.setImageResource(two_D_Array[randImages[count]][1]);
        img3.setImageResource(two_D_Array[randImages[count]][2]);

        isClick(img3);
        isNotClick(img1);
        isNotClick(img2);

    }


    public void isClick(ImageView imageView){
        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                latestScore++;
                score.setText(latestScore + "/20 ");
                questionsComplete();

            }
        });
    }

    public void isNotClick( final ImageView imageView)
    {
        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                score.setText(latestScore + "/20 ");
                questionsComplete();

            }
        });
    }

    public static String[] Randomize(String[] arr,int[][] array)
   {
       String[] randomizedArray = new String[arr.length];
       int [][] Array2d = new int[20][3];

       Array2d = array;
       System.arraycopy(arr, 0, randomizedArray, 0, arr.length);
       Random rgen = new Random();

       for (int i = 0; i < randomizedArray.length; i++)
       {
           int randPos = rgen.nextInt(randomizedArray.length);
           String tmp = randomizedArray[i];
           randomizedArray[i] = randomizedArray[randPos];
           randomizedArray[randPos] = tmp;

           int temp;
           temp = Array2d[i][0];
           Array2d[i][0] = Array2d[randPos][0];
           Array2d[randPos][0] = temp;


       }
       return randomizedArray;
   }

    public int[] imagesSelectedForQuestion( String questionSelected )
    {
        if (questionSelected.contains("lock"))
        {
            img1.setImageResource(imageSettings.lock[0]);
            img2.setImageResource(imageSettings.lock[1]);
            img3.setImageResource(imageSettings.lock[2]);
            isClick(img3);
            isNotClick(img1);
            isNotClick(img2);

        }
        else if (questionSelected.contains("school bag"))
        {
            img1.setImageResource(imageSettings.schoolBag[0]);
            img2.setImageResource(imageSettings.schoolBag[1]);
            img3.setImageResource(imageSettings.schoolBag[2]);
            isClick(img2);
            isNotClick(img1);
            isNotClick(img3);
        }
        else if (questionSelected.contains("diary"))
        {
            img1.setImageResource(imageSettings.diary[0]);
            img2.setImageResource(imageSettings.diary[1]);
            img3.setImageResource(imageSettings.diary[2]);
            isClick(img3);
            isNotClick(img1);
            isNotClick(img2);
        }
        else if (questionSelected.contains("football"))
        {
            img1.setImageResource(imageSettings.football[0]);
            img2.setImageResource(imageSettings.football[1]);
            img3.setImageResource(imageSettings.football[2]);
            isClick(img1);
            isNotClick(img3);
            isNotClick(img2);

        } else if (questionSelected.contains("hair-brush"))
        {
            img1.setImageResource(imageSettings.hairBrush[0]);
            img2.setImageResource(imageSettings.hairBrush[1]);
            img3.setImageResource(imageSettings.hairBrush[2]);
            isClick(img2);
            isNotClick(img1);
            isNotClick(img3);


        } else if (questionSelected.contains("ice")) {
            img1.setImageResource(imageSettings.ice[0]);
            img2.setImageResource(imageSettings.ice[1]);
            img3.setImageResource(imageSettings.ice[2]);
            isClick(img1);
            isNotClick(img3);
            isNotClick(img2);


        } else if (questionSelected.contains("jogger")) {
            img1.setImageResource(imageSettings.jogger[0]);
            img2.setImageResource(imageSettings.jogger[1]);
            img3.setImageResource(imageSettings.jogger[2]);
            isClick(img2);
            isNotClick(img1);
            isNotClick(img3);

        } else if (questionSelected.contains("kitty")) {
            img1.setImageResource(imageSettings.kitty[0]);
            img2.setImageResource(imageSettings.kitty[1]);
            img3.setImageResource(imageSettings.kitty[2]);
            isClick(img3);
            isNotClick(img1);
            isNotClick(img2);

        } else if (questionSelected.contains("knife")) {
            img1.setImageResource(imageSettings.knife[0]);
            img2.setImageResource(imageSettings.knife[1]);
            img3.setImageResource(imageSettings.knife[2]);
            isClick(img1);
            isNotClick(img3);
            isNotClick(img2);

        } else if (questionSelected.contains("laughing")) {

            img1.setImageResource(imageSettings.laughing[0]);
            img2.setImageResource(imageSettings.laughing[1]);
            img3.setImageResource(imageSettings.laughing[2]);
            isClick(img1);
            isNotClick(img3);
            isNotClick(img2);

        } else if (questionSelected.contains("message")) {
            img1.setImageResource(imageSettings.messageIcon[0]);
            img2.setImageResource(imageSettings.messageIcon[1]);
            img3.setImageResource(imageSettings.messageIcon[2]);
            isClick(img2);
            isNotClick(img1);
            isNotClick(img3);

        } else if (questionSelected.contains("mobile"))
        {
            img1.setImageResource(imageSettings.mobile[0]);
            img2.setImageResource(imageSettings.mobile[1]);
            img3.setImageResource(imageSettings.mobile[2]);
            isClick(img2);
            isNotClick(img1);
            isNotClick(img3);

        } else if (questionSelected.contains("paint")) {

            img1.setImageResource(imageSettings.paintBrush[0]);
            img2.setImageResource(imageSettings.paintBrush[1]);
            img3.setImageResource(imageSettings.paintBrush[2]);
            isClick(img1);
            isNotClick(img3);
            isNotClick(img2);

        } else if (questionSelected.contains("rectangle")) {

            img1.setImageResource(imageSettings.rectangle[0]);
            img2.setImageResource(imageSettings.rectangle[1]);
            img3.setImageResource(imageSettings.rectangle[2]);
            isClick(img3);
            isNotClick(img1);
            isNotClick(img2);

        } else if (questionSelected.contains("circle")) {

            img1.setImageResource(imageSettings.circle[0]);
            img2.setImageResource(imageSettings.circle[1]);
            img3.setImageResource(imageSettings.circle[2]);
            isClick(img2);
            isNotClick(img1);
            isNotClick(img3);

        } else if (questionSelected.contains("glasses")) {
            img1.setImageResource(imageSettings.glasses[0]);
            img2.setImageResource(imageSettings.glasses[1]);
            img3.setImageResource(imageSettings.glasses[2]);
            isClick(img2);
            isNotClick(img1);
            isNotClick(img3);

        } else if (questionSelected.contains("mammal")) {
            img1.setImageResource(imageSettings.mammals[0]);
            img2.setImageResource(imageSettings.mammals[1]);
            img3.setImageResource(imageSettings.mammals[2]);
            isClick(img3);
            isNotClick(img1);
            isNotClick(img2);

        } else if (questionSelected.contains("camera")) {

            img1.setImageResource(imageSettings.camera[0]);
            img2.setImageResource(imageSettings.camera[1]);
            img3.setImageResource(imageSettings.camera[2]);
            isClick(img3);
            isNotClick(img1);
            isNotClick(img2);

        } else if (questionSelected.contains("egg")) {

            img1.setImageResource(imageSettings.egg[0]);
            img2.setImageResource(imageSettings.egg[1]);
            img3.setImageResource(imageSettings.egg[2]);
            isClick(img1);
            isNotClick(img3);
            isNotClick(img2);

        } else if (questionSelected.contains("watch")) {

            img1.setImageResource(imageSettings.watch[0]);
            img2.setImageResource(imageSettings.watch[1]);
            img3.setImageResource(imageSettings.watch[2]);
            isClick(img2);
            isNotClick(img1);
            isNotClick(img3);

        }
        return null;
    }
}













