package es.ulpgc.eite.cleancode.quiz.cheat;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.quiz.app.CheatToQuestionState;
import es.ulpgc.eite.cleancode.quiz.app.QuestionToCheatState;


public interface CheatContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void displayCheatData(CheatViewModel viewModel);
    void finishView();
    String getFalseLabel();
    String getTrueLabel();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    void injectRouter(Router router);

    void fetchCheatData();
    void yesButtonClicked();
    void noButtonClicked();
  }

  interface Model {

  }

  interface Router {

    void passDataToQuestionScreen(CheatToQuestionState state);
    QuestionToCheatState getDataFromQuestionScreen();
  }
}