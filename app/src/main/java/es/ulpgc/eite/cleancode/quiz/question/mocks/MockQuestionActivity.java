package es.ulpgc.eite.cleancode.quiz.question.mocks;

import es.ulpgc.eite.cleancode.quiz.question.QuestionContract;
import es.ulpgc.eite.cleancode.quiz.question.QuestionViewModel;

public class MockQuestionActivity implements QuestionContract.View {

  //private String correctLabel = "Correct!";
  //private String incorrectLabel = "Incorrect!";

  private QuestionViewModel viewModel;

  public String getQuestion() {
    return viewModel.questionText;
  }

  public String getResult() {
    return viewModel.resultText;
  }

  @Override
  public void injectPresenter(QuestionContract.Presenter presenter) {

  }

  @Override
  public void displayQuestionData(QuestionViewModel viewModel) {
    this.viewModel = viewModel;
  }

  /*
  @Override
  public String getIncorrectLabel() {
    return incorrectLabel;
  }

  @Override
  public String getCorrectLabel() {
    return correctLabel;
  }
  */
}
