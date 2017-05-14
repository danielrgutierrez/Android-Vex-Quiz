package gutierrez.daniel.vexquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DifficultyChooserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_chooser);
    }

    public void goEasy(View v) {
        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra("numQuestions", 10);
        startActivity(intent);
    }

    public void goNormal(View v) {
        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra("numQuestions", 20);
        startActivity(intent);
    }

    public void goHard(View v) {
        Intent intent = new Intent(this, QuizActivity.class);
        intent.putExtra("numQuestions", 30);
        startActivity(intent);
    }
}
