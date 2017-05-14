package gutierrez.daniel.vexquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuizActivity extends AppCompatActivity {

    private int mNumQuestions;

    private Button mAnswer1;
    private Button mAnswer2;
    private Button mAnswer3;
    private Button mAnswer4;

    private ArrayList<Button> buttons = new ArrayList<Button>();
    private ArrayList<Question> questions;

    private ImageView mFlag;

    private int mAnswerNumber = 0;
    private int mQuestionNumber;
    private int mScore;
    private int mOriginalNumberOfQuestions;

    private Random mRand = new Random();

    private Toast correctMsg;
    private Toast incorrectMsg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        Intent intent = getIntent();
        mNumQuestions = intent.getIntExtra("numQuestions", 0);
        mScore = 0;

        mAnswer1 = (Button)findViewById(R.id.a1);
        mAnswer2 = (Button)findViewById(R.id.a2);
        mAnswer3 = (Button)findViewById(R.id.a3);
        mAnswer4 = (Button)findViewById(R.id.a4);
        buttons.add(mAnswer1);
        buttons.add(mAnswer2);
        buttons.add(mAnswer3);
        buttons.add(mAnswer4);
        mFlag = (ImageView)findViewById(R.id.flag);

        questions = createQuestions();


        Context context = getApplicationContext();
        CharSequence text = "Correct!";
        CharSequence otherText = "Incorrect!";
        int duration = Toast.LENGTH_SHORT;
        correctMsg = Toast.makeText(context, text, duration);
        incorrectMsg = Toast.makeText(context, otherText, duration);

        mOriginalNumberOfQuestions = mNumQuestions;

        selectQuestion();

    }

    public ArrayList<Question> createQuestions() {
        ArrayList<Question> result = new ArrayList<Question>();
        /*ArrayList<String> test = new ArrayList<String>();
        test.add("Afghanistan");
        test.add("Syria");
        test.add("Pakistan");
        test.add("Turkmenistan");*/
        Question q1 = new Question(R.drawable.flag_of_afghanistan, createAnswers("Afghanistan", "Albania", "Croatia", "Russia"), 0);
        Question q2 = new Question(R.drawable.flag_of_albania, createAnswers("Serbia", "Albania", "Croatia", "Russia"), 1);
        Question q3 = new Question(R.drawable.flag_of_algeria, createAnswers("Iraq", "Iran", "Algeria", "Egypt"), 2);
        Question q4 = new Question(R.drawable.flag_of_andorra, createAnswers("Spain", "Romania", "Moldavia", "Andorra"), 3);
        Question q5 = new Question(R.drawable.flag_of_angola, createAnswers("Angola", "Mozambique", "Ecuador", "Egypt"), 0);
        Question q6 = new Question(R.drawable.flag_of_antigua_and_barbuda, createAnswers("Seychelles", "Antigua & Barbuda", "Phillipines", "Belize"), 1);
        Question q7 = new Question(R.drawable.flag_of_argentina, createAnswers("Uruguay", "Bolivia", "Argentina", "Panama"), 2);
        Question q8 = new Question(R.drawable.flag_of_armenia, createAnswers("Iran", "Colombia", "Azerbaijan", "Armenia"), 3);
        Question q9 = new Question(R.drawable.flag_of_australia, createAnswers("Australia", "New Zealand", "Tuvalu", "Tonga"), 0);
        Question q10 = new Question(R.drawable.flag_of_austria, createAnswers("Germany", "Austria", "Switzerland", "Australia"), 1);
        Question q11 = new Question(R.drawable.flag_of_azerbaijan, createAnswers("Iran", "Turkey", "Azerbaijan", "Kuwait"), 2);
        Question q12 = new Question(R.drawable.flag_of_bahamas, createAnswers("Dominican Republic", "Bermuda", "Jamaica", "Bahamas"), 3);
        Question q13 = new Question(R.drawable.flag_of_bahrain, createAnswers("Bahrain", "Brunei", "Qatar", "Saudi Arabia"), 0);
        Question q14 = new Question(R.drawable.flag_of_bangladesh, createAnswers("Japan", "Bangladesh", "Pakistan", "Nepal"), 1);
        Question q15 = new Question(R.drawable.flag_of_barbados, createAnswers("Trinidad & Tobago", "Jamaica", "Barbados", "Sri Lanka"), 2);
        Question q16 = new Question(R.drawable.flag_of_belarus, createAnswers("Ukraine", "Russia", "Bulgaria", "Belarus"), 3);
        Question q17 = new Question(R.drawable.flag_of_belgium, createAnswers("Belgium", "Germany", "Uganda", "Yemen"), 0);
        Question q18 = new Question(R.drawable.flag_of_belize, createAnswers("Honduras", "Belize", "Tanzania", "Tuvalu"), 1);
        Question q19 = new Question(R.drawable.flag_of_benin, createAnswers("Somalia", "Eritrea", "Benin", "Togo"), 2);
        Question q20 = new Question(R.drawable.flag_of_bhutan, createAnswers("Nepal", "Sri Lanka", "China", "Bhutan"), 3);
        Question q21 = new Question(R.drawable.flag_of_greece, createAnswers("Greece", "Cyprus", "Turkey", "Bulgaria"), 0);
        Question q22 = new Question(R.drawable.flag_of_brazil, createAnswers("Uruguay", "Brazil", "Paraguay", "Argentina"), 1);
        Question q23 = new Question(R.drawable.flag_of_sierra_leone, createAnswers("Nigeria", "Nambia", "Sierra Leone", "Senegal"), 2);
        Question q24 = new Question(R.drawable.flag_of_kazakhstan, createAnswers("Oman", "Turkmenistan", "Ukraine", "Kazakhstan"), 3);
        Question q25 = new Question(R.drawable.flag_of_vatican_city, createAnswers("Vatican City", "Switzerland", "Vietnam", "Vanatu"), 0);
        Question q26 = new Question(R.drawable.flag_of_portugal, createAnswers("Spain", "Portugal", "Gabon", "Libya"), 1);
        Question q27 = new Question(R.drawable.flag_of_czech_republic, createAnswers("Slovenia", "Czech Republic", "Phillipines", "Malta"), 1);
        Question q28 = new Question(R.drawable.flag_of_cuba, createAnswers("Puerto Rico", "Haiti", "Cuba", "Tunisia"), 2);
        Question q29 = new Question(R.drawable.flag_of_cote_divoire, createAnswers("Lithuania", "Netherlands", "Ireland", "Côte d'Ivoire"), 3);
        Question q30 = new Question(R.drawable.flag_of_china, createAnswers("China", "North Korea", "Vietnam", "Yemen"), 0);

        result.add(q1);
        result.add(q2);
        result.add(q3);
        result.add(q4);
        result.add(q5);
        result.add(q6);
        result.add(q7);
        result.add(q8);
        result.add(q9);
        result.add(q10);
        result.add(q11);
        result.add(q12);
        result.add(q13);
        result.add(q14);
        result.add(q15);
        result.add(q16);
        result.add(q17);
        result.add(q18);
        result.add(q19);
        result.add(q20);
        result.add(q21);
        result.add(q22);
        result.add(q23);
        result.add(q24);
        result.add(q25);
        result.add(q26);
        result.add(q27);
        result.add(q28);
        result.add(q29);
        result.add(q30);

        Collections.shuffle(result, new Random());

        return result;


    }

    public ArrayList<String> createAnswers(String ans1, String ans2, String ans3, String ans4) {
        ArrayList<String> result = new ArrayList<String>(4);

        result.add(ans1);
        result.add(ans2);
        result.add(ans3);
        result.add(ans4);

        return result;
    }

    public void selectQuestion() {
        if (mNumQuestions > 0) {
            if (mNumQuestions == 0) {
                mQuestionNumber = 0;
            } else {
                mQuestionNumber = mRand.nextInt(mNumQuestions);
            }
            mFlag.setImageResource(questions.get(mQuestionNumber).getFlag());
            mAnswerNumber = questions.get(mQuestionNumber).getAnswer();

            for (int i = 0; i < buttons.size(); i++) {
                buttons.get(i).setText(questions.get(mQuestionNumber).getAnswers().get(i));
            }

            questions.remove(mQuestionNumber);
            mNumQuestions--;
        } else {
            Intent intent = new Intent(this, EndScreenActivity.class);
            intent.putExtra("score", mScore);
            intent.putExtra("numQuestions", mOriginalNumberOfQuestions);
            startActivity(intent);
        }
    }

    public void clickAns1(View v) {
        if (mAnswerNumber == 0) {
            mScore++;
            correctMsg.show();
        } else {
            incorrectMsg.show();
        }

        selectQuestion();
    }

    public void clickAns2(View v) {
        if (mAnswerNumber == 1) {
            mScore++;
            correctMsg.show();
        } else {
            incorrectMsg.show();
        }

        selectQuestion();

    }

    public void clickAns3(View v) {
        if (mAnswerNumber == 2) {
            mScore++;
            correctMsg.show();
        } else {
            incorrectMsg.show();
        }

        selectQuestion();


    }

    public void clickAns4(View v) {
        if (mAnswerNumber == 3) {
            mScore++;
            correctMsg.show();
        } else {
            incorrectMsg.show();
        }

        selectQuestion();


    }

    /*public void congrats() {
        Context context = getApplicationContext();
        CharSequence text = "Correct!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }*/
}
