package es.ulpgc.eite.cleancode.quiz.question.mocks;

import es.ulpgc.eite.cleancode.quiz.app.CheatToQuestionState;
import es.ulpgc.eite.cleancode.quiz.app.QuestionToCheatState;
import es.ulpgc.eite.cleancode.quiz.question.QuestionContract;

public class MockQuestionRouter implements QuestionContract.Router  {

  private QuestionToCheatState state;

  public QuestionToCheatState getState() {
    return state;
  }

  @Override
  public void navigateToCheatScreen() {

  }

  @Override
  public void passDataToCheatScreen(QuestionToCheatState state) {
    this.state = state;
  }

  @Override
  public CheatToQuestionState getDataFromCheatScreen() {
    return null;
  }
}
