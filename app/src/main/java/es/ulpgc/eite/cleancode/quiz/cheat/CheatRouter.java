package es.ulpgc.eite.cleancode.quiz.cheat;

import es.ulpgc.eite.cleancode.quiz.app.AppMediator;
import es.ulpgc.eite.cleancode.quiz.app.CheatToQuestionState;
import es.ulpgc.eite.cleancode.quiz.app.QuestionToCheatState;


public class CheatRouter implements CheatContract.Router {

  public static String TAG = CheatRouter.class.getSimpleName();

  private AppMediator mediator;

  public CheatRouter(AppMediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void passDataToQuestionScreen(CheatToQuestionState state) {
    mediator.setCheatToQuestionState(state);
  }

  @Override
  public QuestionToCheatState getDataFromQuestionScreen() {
    return mediator.getQuestionToCheatState();
  }
}
