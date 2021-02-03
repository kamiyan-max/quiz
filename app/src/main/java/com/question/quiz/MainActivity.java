package com.question.quiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private TextView countLabel;
    private ImageView questionImage;
    private Button answerBtn1, answerBtn2, answerBtn3, answerBtn4;
   

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    static final private int QUIZ_COUNT = 10;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    String quizData[][] = {
            
            {"aichi", "愛知", "愛媛", "兵庫", "岐阜"},
            {"akita", "秋田", "岩手", "山形", "群馬"},
            {"aomori", "青森", "石川", "山口", "山梨"},
            {"chiba", "千葉", "岐阜", "三重", "長野"},
            {"ehime", "愛媛", "愛知", "香川", "島根"},
            {"fukui", "福井", "福島", "福岡", "奈良"},
            {"fukuoka", "福岡", "福井", "福島", "岡山"},
            {"fukushima", "福島", "広島", "島根", "宮城"},
            {"gifu", "岐阜", "奈良", "佐賀", "三重"},
            {"gunma", "群馬", "栃木", "茨城", "山梨"},
            {"hiroshima", "広島", "長崎", "東京", "宮崎"},
            {"hokkaido", "北海道", "鹿児島", "神奈川", "和歌山"},
            {"hyougo", "兵庫", "京都", "大阪", "茨城"},
            {"ibaraki", "茨城", "滋賀", "佐賀", "静岡"},
            {"ishikawa", "石川", "高知", "大分", "鳥取"},
            {"iwate", "岩手", "鳥取", "島根", "宮城"},
            {"kagawa", "香川", "愛媛", "石川", "大阪"},
            {"kagoshima", "鹿児島", "福島", "島根", "広島"},
            {"kanagawa", "神奈川", "東京", "埼玉", "千葉"},
            {"kouchi", "高知", "和歌山", "宮崎", "千葉"},
            {"kumamoto", "熊本", "鹿児島", "宮崎", "長野"},
            {"kyoto", "京都", "東京", "大阪", "奈良"},
            {"mie", "三重", "大分", "佐賀", "奈良"},
            {"miyagi", "宮城", "宮崎", "岡山", "山口"},
            {"miyazaki", "宮崎", "長崎", "沖縄", "秋田"},
            {"nagano", "長野", "北海道", "東京", "福岡"},
            {"nagasaki", "長崎", "東京", "沖縄", "青森"},
            {"nara", "奈良", "大分", "佐賀", "滋賀"},
            {"niigata", "新潟", "長野", "和歌山", "熊本"},
            {"oita", "大分", "三重", "山形", "群馬"},
            {"okayama", "岡山", "山形", "山梨", "和歌山"},
            {"osaka", "大阪", "兵庫", "京都", "奈良"},
            {"saga", "佐賀", "滋賀", "岐阜", "福岡"},
            {"saitama", "埼玉", "山梨", "栃木", "愛知"},
            {"shiga", "滋賀", "青森", "岩手", "新潟"},
            {"shimane", "島根", "福島", "広島", "鹿児島"},
            {"shizuoka", "静岡", "岡山", "山口", "福岡"},
            {"tochigi", "栃木", "茨城", "山形", "愛知"},
            {"tokushima", "徳島", "福島", "鳥取", "静岡"},
            {"tokyo", "東京", "神奈川", "福岡", "愛知"},
            {"tottori", "鳥取", "島根", "福井", "富山"},
            {"toyama", "富山", "山形", "北海道", "千葉"},
            {"wakayama", "和歌山", "高知", "熊本", "秋田"},
            {"yamagata", "山形", "秋田", "岩手", "宮城"},
            {"yamaguchi", "山口","石川", "沖縄", "徳島"},
            {"yamanashi", "山梨", "山口", "山形", "大分"}
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countLabel = findViewById(R.id.countLabel);
        questionImage = findViewById(R.id.questionImage);
        answerBtn1 = findViewById(R.id.answerBtn1);
        answerBtn2 = findViewById(R.id.answerBtn2);
        answerBtn3 = findViewById(R.id.answerBtn3);
        answerBtn4 = findViewById(R.id.answerBtn4);
      
        
        for (int i = 0; i < quizData.length; i++) {
           
            ArrayList<String> tmpArray = new ArrayList<>();

            
            tmpArray.add(quizData[i][0]); 
            tmpArray.add(quizData[i][1]); 
            tmpArray.add(quizData[i][2]); 
            tmpArray.add(quizData[i][3]); 
            tmpArray.add(quizData[i][4]); 

           
            quizArray.add(tmpArray);
        }

        showNextQuiz();
    }

    public void showNextQuiz() {
        
        countLabel.setText("Q" + quizCount);

        
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

      
        ArrayList<String> quiz = quizArray.get(randomNum);

       
        questionImage.setImageResource(
                getResources().getIdentifier(quiz.get(0), "drawable", getPackageName())
        );

       
        rightAnswer = quiz.get(1);

       
        quiz.remove(0);

       
        Collections.shuffle(quiz);

       
        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));

       
        quizArray.remove(randomNum);
    }

    public void checkAnswer(View view) {

     
        Button answerBtn = findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;
        if (btnText.equals(rightAnswer)) {
            
            alertTitle = "正解！";
            rightAnswerCount++;
        } else {
            
            alertTitle = "不正解...";
        }

        
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("答え：" + rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (quizCount == QUIZ_COUNT) {
                  
                    showResult();

                } else {
                    quizCount++;
                   
                    showNextQuiz();
                }
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    public void showResult() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("結果");
        builder.setMessage(rightAnswerCount + " / " + quizCount);
        builder.setPositiveButton("もう一度", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                recreate();
            }
        });
        builder.setNegativeButton("終了", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.show();
    }
}
