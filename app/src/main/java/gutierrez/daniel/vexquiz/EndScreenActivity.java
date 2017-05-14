package gutierrez.daniel.vexquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EndScreenActivity extends AppCompatActivity {
    private int mScore;
    private int mNumQuestions;
    private TextView mScoreLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);
        mScore = getIntent().getIntExtra("score", 0);
        mNumQuestions = getIntent().getIntExtra("numQuestions", 0);
        mScoreLabel = (TextView)findViewById(R.id.scoreLabel);


        String msg;
        msg = "Score: " + mScore + "/" + mNumQuestions;
        mScoreLabel.setText(msg);

    }

    public void goDifficultyChooser(View v) {
        Intent intent = new Intent(this, DifficultyChooserActivity.class);
        startActivity(intent);
    }
}
