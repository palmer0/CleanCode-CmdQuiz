package es.ulpgc.eite.cleancode.quiz.question;

import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.cleancode.quiz.app.AppMediator;
import es.ulpgc.eite.cleancode.quiz.app.CheatToQuestionState;
import es.ulpgc.eite.cleancode.quiz.app.QuestionToCheatState;
import es.ulpgc.eite.cleancode.quiz.cheat.CheatActivity;


public class QuestionRouter implements QuestionContract.Router {

  public static String TAG = QuestionRouter.class.getSimpleName();

  private AppMediator mediator;

  public QuestionRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void navigateToCheatScreen() {
    Context context = mediator.getApplicationContext();
    Intent intent = new Intent(context, CheatActivity.class);
    context.startActivity(intent);
  }

  @Override
  public void passDataToCheatScreen(QuestionToCheatState state) {
    mediator.setQuestionToCheatState(state);
  }

  @Override
  public CheatToQuestionState getDataFromCheatScreen() {
    return mediator.getCheatToQuestionState();
  }
}
