package gutierrez.daniel.vexquiz;

import java.util.ArrayList;

/**
 * Created by daniel on 5/12/17.
 */

public class Question {
    private int flag;
    private ArrayList<String> answers;
    private int answer;


    public Question(int flag, ArrayList<String> answers, int answer) {
        this.flag = flag;
        this.answers = answers;
        this.answer = answer;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }
}
