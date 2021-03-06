package es.ulpgc.eite.cleancode.quiz.question;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.quiz.app.AppCommand;
import es.ulpgc.eite.cleancode.quiz.app.AppMediator;
import es.ulpgc.eite.cleancode.quiz.app.CheatToQuestionState;
import es.ulpgc.eite.cleancode.quiz.app.QuestionToCheatState;
import es.ulpgc.eite.cleancode.quiz.question.commands.CheckCurrentQuestion;
import es.ulpgc.eite.cleancode.quiz.question.commands.LoadCurrentQuestion;
import es.ulpgc.eite.cleancode.quiz.question.commands.LoadNextQuestion;


public class QuestionPresenter implements QuestionContract.Presenter {

  public static String TAG = QuestionPresenter.class.getSimpleName();

  private WeakReference<QuestionContract.View> view;
  private QuestionState state;
  private QuestionContract.Model model;
  private AppMediator mediator;

  public QuestionPresenter(AppMediator mediator) {
    this.mediator = mediator;
    state = mediator.getQuestionState();
  }


  @Override
  public void injectView(WeakReference<QuestionContract.View> view) {
    this.view = view;
  }

  @Override
  public void injectModel(QuestionContract.Model model) {
    this.model = model;
  }


  private void passDataToCheatScreen(QuestionToCheatState state) {
    mediator.setQuestionToCheatState(state);
  }

  private CheatToQuestionState getDataFromCheatScreen() {
    return mediator.getCheatToQuestionState();
  }

  @Override
  public void fetchQuestionData() {
    //Log.e(TAG, "fetchQuestionData()");

    // set passed state
    CheatToQuestionState stateFromCheat = getDataFromCheatScreen();
    if(stateFromCheat != null) {

        if(stateFromCheat.cheated){
          nextButtonClicked();
          return;
        }
    }

    loadCurrentQuestion();
    view.get().displayQuestionData(state);

  }


  private void loadCurrentQuestion() {

    model.setCurrentIndex(state.quizIndex);
    execute(new LoadCurrentQuestion(state, model.getCurrentQuestion()));
  }



  private void updateQuestionData(boolean userAnswer) {

    checkCurrentQuestion(userAnswer);
    view.get().displayQuestionData(state);
  }

  private void checkCurrentQuestion(boolean userAnswer) {
    boolean currentAnswer = model.getCurrentAnswer();

    String result;

    if(currentAnswer == userAnswer) {
      result = model.getCorrectLabel();
    } else {
      result = model.getIncorrectLabel();
    }

    boolean enable = true;

    if(model.isLastQuestion()) {
      enable = false;
    }

    execute(new CheckCurrentQuestion(state, result, enable));

  }

  @Override
  public void trueButtonClicked() {
    updateQuestionData(true);
  }

  @Override
  public void falseButtonClicked() {
    updateQuestionData(false);
  }

  @Override
  public void cheatButtonClicked() {
    boolean answer = model.getCurrentAnswer();
    QuestionToCheatState stateToCheat = new QuestionToCheatState(answer);
    passDataToCheatScreen(stateToCheat);
    view.get().navigateToCheatScreen();
  }


  @Override
  public void nextButtonClicked() {
    //Log.e(TAG, "nextButtonClicked()");

    loadNextQuestion();
    view.get().displayQuestionData(state);
  }


  private void loadNextQuestion() {
    model.incrQuizIndex();
    execute(new LoadNextQuestion(state, model.getCurrentQuestion()));

  }

  private void execute(AppCommand command) {
    command.execute();
  }

}
