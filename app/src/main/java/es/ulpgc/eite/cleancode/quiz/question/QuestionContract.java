package es.ulpgc.eite.cleancode.quiz.question;

import java.lang.ref.WeakReference;


public interface QuestionContract {

  interface View {
    void injectPresenter(Presenter presenter);

    void navigateToCheatScreen();
    void displayQuestionData(QuestionViewModel viewModel);
    //String getIncorrectLabel();
    //String getCorrectLabel();
  }

  interface Presenter {
    void injectView(WeakReference<View> view);
    void injectModel(Model model);
    //void injectRouter(Router router);

    void fetchQuestionData();
    void trueButtonClicked();
    void falseButtonClicked();
    void cheatButtonClicked();
    void nextButtonClicked();

  }

  interface Model {

    String getCorrectLabel();
    String getIncorrectLabel();

    String getCurrentQuestion();
    boolean getCurrentAnswer();
    boolean isLastQuestion();
    void incrQuizIndex();
    void setCurrentIndex(int index);
  }

//  interface Router {
//
//    void passDataToCheatScreen(QuestionToCheatState state);
//    CheatToQuestionState getDataFromCheatScreen();
//  }
}