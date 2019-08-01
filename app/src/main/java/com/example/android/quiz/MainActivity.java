package com.example.android.quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView copyrightNotice = (TextView) findViewById(R.id.copyright);
        assert copyrightNotice != null;
        copyrightNotice.setMovementMethod(LinkMovementMethod.getInstance());
        copyrightNotice.setText(Html.fromHtml(getString(R.string.copyright_notice)));
    }


    /**
     * Called from view to score the quiz
     *
     * @param view
     */
    public void submitAnswers(View view) {

        int numberOfQuestions = 7;
        int answersCorrect = 0;

        // score each quiz section individually
        answersCorrect += scoreQuestionOne();
        answersCorrect += scoreQuestionTwo();
        answersCorrect += scoreQuestionThree();
        answersCorrect += scoreQuestionFour();
        answersCorrect += scoreQuestionFive();
        answersCorrect += scoreQuestionSix();
        answersCorrect += scoreQuestionSeven();

        // create message for Toast
        String msg;
        if (answersCorrect >= 6) {
            msg = "You have " + Integer.toString(answersCorrect) + " answers correct!\n Great Job!";
        } else if (answersCorrect >= 4) {
            msg = "You have " + Integer.toString(answersCorrect) + " answers correct!\n Study some more.";
        } else
            msg = "You have " + Integer.toString(answersCorrect) + " answers correct!\n Good luck next time.";

        //style Toast
        Toast toast = Toast.makeText(this, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    /**
     * Score Question #1
     *
     * @return score
     */
    private int scoreQuestionOne() {
        int score = 0;

        EditText editText = (EditText) findViewById(R.id.q1_answer);
        String answer = editText.getText().toString().trim();
        editText.setText("");

        if (answer.equalsIgnoreCase("android")) {
            return score = 1;
        }
        return score;
    }

    /**
     * Score Question #2
     *
     * @return score
     */
    private int scoreQuestionTwo() {
        int score = 0;

        RadioButton rb1 = (RadioButton) findViewById(R.id.q2_yes_radio_button);
        RadioButton rb2 = (RadioButton) findViewById(R.id.q2_no_radio_button);
        // Check which radio button was clicked


        if (rb1.isChecked()) {
            rb1.setChecked(false);
            return score = 1;
        }
        rb2.setChecked(false);
        return score;
    }

    /**
     * Score Question #3
     *
     * @return score
     */
    private int scoreQuestionThree() {
        ;
        int score = 0;

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.q3_checkbox_1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.q3_checkbox_2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.q3_checkbox_3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.q3_checkbox_4);

        if (checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked() && !checkBox4.isChecked()) {
            checkBox1.setChecked(false);
            checkBox2.setChecked(false);
            checkBox3.setChecked(false);
            checkBox4.setChecked(false);
            return score = 1;
        }
        checkBox1.setChecked(false);
        checkBox2.setChecked(false);
        checkBox3.setChecked(false);
        checkBox4.setChecked(false);
        return score;
    }

    /**
     * Score Question #4
     *
     * @return score
     */
    private int scoreQuestionFour() {
        int score = 0;

        RadioButton rb1 = (RadioButton) findViewById(R.id.q4_breakaway_radio_button);
        RadioButton rb2 = (RadioButton) findViewById(R.id.q4_conditional_radio_button);
        RadioButton rb3 = (RadioButton) findViewById(R.id.q4_switch_radio_button);
        // Check which radio button was clicked

        if (rb2.isChecked()) {
            rb2.setChecked(false);
            return score = 1;
        }
        rb1.setChecked(false);
        rb3.setChecked(false);
        return score;
    }

    /**
     * Score Question #5
     *
     * @return score
     */
    private int scoreQuestionFive() {
        int score = 0;

        EditText editText = (EditText) findViewById(R.id.q5_answer);
        String answer = editText.getText().toString().trim();
        editText.setText("");

        if (answer.equalsIgnoreCase("scrollview")) {
            return score = 1;
        }
        return score;
    }

    /**
     * Score Question #6
     *
     * @return score
     */
    private int scoreQuestionSix() {
        int score = 0;

        CheckBox checkBox1 = (CheckBox) findViewById(R.id.q6_checkbox_1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.q6_checkbox_2);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.q6_checkbox_3);
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.q6_checkbox_4);

        if (checkBox1.isChecked() && !checkBox2.isChecked() && checkBox3.isChecked() && checkBox4.isChecked()) {
            checkBox1.setChecked(false);
            checkBox2.setChecked(false);
            checkBox3.setChecked(false);
            checkBox4.setChecked(false);
            return score = 1;
        }
        checkBox1.setChecked(false);
        checkBox2.setChecked(false);
        checkBox3.setChecked(false);
        checkBox4.setChecked(false);
        return score;
    }

    /**
     * Score Question #7
     *
     * @return score
     */
    private int scoreQuestionSeven() {
        int score = 0;

        RadioButton rb1 = (RadioButton) findViewById(R.id.q7_relativelayout_radio_button);
        RadioButton rb2 = (RadioButton) findViewById(R.id.q7_linearlayout_radio_button);
        // Check which radio button was clicked

        if (rb2.isChecked()) {
            rb2.setChecked(false);
            return score = 1;
        }
        rb1.setChecked(false);
        return score;
    }
}
