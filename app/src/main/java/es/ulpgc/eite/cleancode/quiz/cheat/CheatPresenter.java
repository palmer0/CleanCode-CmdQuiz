package es.ulpgc.eite.cleancode.quiz.cheat;

import android.util.Log;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.quiz.app.CheatToQuestionState;
import es.ulpgc.eite.cleancode.quiz.app.QuestionToCheatState;
import es.ulpgc.eite.cleancode.quiz.cheat.commands.LoadCurrentAnswer;


public class CheatPresenter implements CheatContract.Presenter {

  public static String TAG = CheatPresenter.class.getSimpleName();

  private WeakReference<CheatContract.View> view;
  private CheatViewModel viewModel;
  private CheatContract.Router router;

  public CheatPresenter(CheatState state) {
    this.viewModel = state;
  }

  @Override
  public void injectView(WeakReference<CheatContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(CheatContract.Model model) {
    // not implemented
  }

  @Override
  public void injectRouter(CheatContract.Router router) {
    this.router = router;
  }

  @Override
  public void fetchCheatData() {
    Log.e(TAG, "fetchCheatData()");

    view.get().displayCheatData(viewModel);

  }

  @Override
  public void yesButtonClicked() {

    // set passed state
    QuestionToCheatState fromQuestionState = router.getDataFromQuestionScreen();
    if(fromQuestionState != null) {

      CheatToQuestionState toQuestionState = new CheatToQuestionState(true);
      router.passDataToQuestionScreen(toQuestionState);

      /*
      if(fromQuestionState.answer) {
        viewModel.answerText = view.get().getTrueLabel();
      } else {
        viewModel.answerText = view.get().getFalseLabel();
      }

      viewModel.yesButton = false;
      viewModel.noButton = false;
      */

      loadCurrentAnswer(fromQuestionState.answer);
      view.get().displayCheatData(viewModel);
    }
  }

  private void loadCurrentAnswer(boolean answer) {

    String reply;

    if(answer) {
      reply = view.get().getTrueLabel();
    } else {
      reply = view.get().getFalseLabel();
    }

    new LoadCurrentAnswer(viewModel, reply);

  }

  @Override
  public void noButtonClicked() {
    CheatToQuestionState newState = new CheatToQuestionState(false);
    router.passDataToQuestionScreen(newState);
    view.get().finishView();
  }


}
