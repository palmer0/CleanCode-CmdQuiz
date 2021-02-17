package es.ulpgc.eite.cleancode.quiz.cheat;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.quiz.app.AppCommand;
import es.ulpgc.eite.cleancode.quiz.app.AppMediator;
import es.ulpgc.eite.cleancode.quiz.app.CheatToQuestionState;
import es.ulpgc.eite.cleancode.quiz.app.QuestionToCheatState;
import es.ulpgc.eite.cleancode.quiz.cheat.commands.LoadCurrentAnswer;


public class CheatPresenter implements CheatContract.Presenter {

  public static String TAG = CheatPresenter.class.getSimpleName();

  private WeakReference<CheatContract.View> view;
  private CheatState state;
  private AppMediator mediator;

  public CheatPresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getCheatState();
  }


  @Override
  public void injectView(WeakReference<CheatContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(CheatContract.Model model) {
    // not implemented
  }


  private void passDataToQuestionScreen(CheatToQuestionState state) {
    mediator.setCheatToQuestionState(state);
  }

  private QuestionToCheatState getDataFromQuestionScreen() {
    return mediator.getQuestionToCheatState();
  }

  @Override
  public void fetchCheatData() {
    Log.e(TAG, "fetchCheatData()");

    view.get().displayCheatData(state);

  }

  @Override
  public void yesButtonClicked() {

    // set passed state
    QuestionToCheatState stateFromQuestion = getDataFromQuestionScreen();
    if(stateFromQuestion != null) {

      CheatToQuestionState toQuestionState = new CheatToQuestionState(true);
      passDataToQuestionScreen(toQuestionState);

      loadCurrentAnswer(stateFromQuestion.answer);
      view.get().displayCheatData(state);
    }
  }

  private void loadCurrentAnswer(boolean answer) {

    String reply;

    if(answer) {
      reply = view.get().getTrueLabel();
    } else {
      reply = view.get().getFalseLabel();
    }

    execute(new LoadCurrentAnswer(state, reply));

  }

  @Override
  public void noButtonClicked() {
    CheatToQuestionState stateToCheat = new CheatToQuestionState(false);
    passDataToQuestionScreen(stateToCheat);
    view.get().finishView();
  }

  private void execute(AppCommand command) {
    command.execute();
  }

}
