package es.ulpgc.eite.cleancode.quiz.app;

import es.ulpgc.eite.cleancode.quiz.cheat.CheatState;
import es.ulpgc.eite.cleancode.quiz.question.QuestionState;

public class AppMediator {

  private static AppMediator instance;


  private QuestionState questionState;
  private CheatState cheatState;
  private CheatToQuestionState cheatToQuestionState;
  private QuestionToCheatState questionToCheatState;


  private AppMediator() {
    questionState = new QuestionState();
    cheatState = new CheatState();
  }

  public static void resetInstance() {
    instance=null;
  }


  public static AppMediator getInstance() {
    if(instance==null){
      instance = new AppMediator();
    }

    return instance;
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
