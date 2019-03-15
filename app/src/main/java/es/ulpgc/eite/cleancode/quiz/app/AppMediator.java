package es.ulpgc.eite.cleancode.quiz.app;

import android.app.Application;

import es.ulpgc.eite.cleancode.quiz.cheat.CheatState;
import es.ulpgc.eite.cleancode.quiz.question.QuestionState;

public class AppMediator extends Application {

  private QuestionState questionState;
  private CheatState cheatState;
  private CheatToQuestionState cheatToQuestionState;
  private QuestionToCheatState questionToCheatState;

  @Override
  public void onCreate() {
    super.onCreate();

    questionState = new QuestionState();
    cheatState = new CheatState();
  }

  public CheatState getCheatState() {
    return cheatState;
  }

  public QuestionState getQuestionState() {
    return questionState;
  }

  public CheatToQuestionState getCheatToQuestionState() {
    CheatToQuestionState state = cheatToQuestionState;
    cheatToQuestionState = null;
    return state;
  }

  public void setCheatToQuestionState(CheatToQuestionState state) {
    this.cheatToQuestionState = state;
  }

  public QuestionToCheatState getQuestionToCheatState() {
    QuestionToCheatState state = questionToCheatState;
    questionToCheatState = null;
    return state;
  }

  public void setQuestionToCheatState(QuestionToCheatState state) {
    this.questionToCheatState = state;
  }

}
