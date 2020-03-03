package es.ulpgc.eite.cleancode.quiz.question;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import es.ulpgc.eite.cleancode.quiz.R;


public class QuestionActivity
    extends AppCompatActivity implements QuestionContract.View {

  public static String TAG = QuestionActivity.class.getSimpleName();

  QuestionContract.Presenter presenter;

  TextView questionText, resultText;
  Button trueButton, falseButton, cheatButton, nextButton;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_question);

    getSupportActionBar().setTitle(R.string.question_screen_title);

    trueButton = findViewById(R.id.trueButton);
    falseButton = findViewById(R.id.falseButton);
    cheatButton = findViewById(R.id.cheatButton);
    nextButton = findViewById(R.id.nextButton);
    questionText = findViewById(R.id.questionText);
    resultText = findViewById(R.id.resultText);

    trueButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        presenter.trueButtonClicked();
      }
    });

    falseButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        presenter.falseButtonClicked();
      }
    });

    cheatButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        presenter.cheatButtonClicked();
      }
    });

    nextButton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        presenter.nextButtonClicked();
      }
    });

    trueButton.setText(getTrueLabel());
    falseButton.setText(getFalseLabel());
    cheatButton.setText(getCheatLabel());
    nextButton.setText(getNextLabel());

    // do the setup
    QuestionScreen.configure(this);

  }


  @Override
  protected void onResume() {
    super.onResume();

    // do some work
    presenter.fetchQuestionData();
  }

  @Override
  public void injectPresenter(QuestionContract.Presenter presenter) {
    this.presenter = presenter;
  }

  @Override
  public void displayQuestionData(QuestionViewModel viewModel) {
    Log.e(TAG, "displayQuestionData()");

    // deal with the data
    questionText.setText(viewModel.questionText);
    resultText.setText(viewModel.resultText);

    trueButton.setEnabled(viewModel.trueButton);
    falseButton.setEnabled(viewModel.falseButton);
    cheatButton.setEnabled(viewModel.cheatButton);
    nextButton.setEnabled(viewModel.nextButton);

  }


  private String getCheatLabel() {
    return getResources().getString(R.string.cheat_label);
  }

  private String getNextLabel() {
    return getResources().getString(R.string.next_label);
  }

  private String getFalseLabel() {
    return getResources().getString(R.string.false_label);
  }

  private String getTrueLabel() {
    return getResources().getString(R.string.true_label);
  }

  /*
  @Override
  public String getIncorrectLabel() {
    return getResources().getString(R.string.incorrect_label);
  }

  @Override
  public String getCorrectLabel() {
    return getResources().getString(R.string.correct_label);
  }
  */

}
