package es.ulpgc.eite.cleancode.quiz;

import org.junit.Test;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.quiz.app.AppMediator;
import es.ulpgc.eite.cleancode.quiz.app.QuestionToCheatState;
import es.ulpgc.eite.cleancode.quiz.question.QuestionContract;
import es.ulpgc.eite.cleancode.quiz.question.QuestionModel;
import es.ulpgc.eite.cleancode.quiz.question.QuestionPresenter;
import es.ulpgc.eite.cleancode.quiz.question.mocks.MockQuestionActivity;

import static org.junit.Assert.assertEquals;

public class QuestionPresenterUnitTests {

  @Test
  public void testNoClickAnyButton() {

    // Given
    AppMediator mediator = AppMediator.getInstance();
    QuestionContract.Presenter presenter = new QuestionPresenter(mediator);
    MockQuestionActivity activity = new MockQuestionActivity();
    QuestionContract.View view = activity;
    QuestionContract.Model model = new QuestionModel();
    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);
    activity.injectPresenter(presenter);

    // When
    presenter.fetchQuestionData();
    String activityQuestion = activity.getQuestion();
    String modelQuestion = model.getCurrentQuestion();
    String activityResult = activity.getResult();

    // Then
    assertEquals(
        "TestNoClickAnyButton: Get current question failed",
        activityQuestion, modelQuestion
    );
    assertEquals(
        "TestNoClickAnyButton: Get current result failed",
        activityResult, ""
    );
  }

  @Test
  public void testFirstClickTrueButton() {

    // Given
    AppMediator mediator = AppMediator.getInstance();
    QuestionContract.Presenter presenter = new QuestionPresenter(mediator);
    MockQuestionActivity activity = new MockQuestionActivity();
    QuestionContract.View view = activity;
    QuestionContract.Model model = new QuestionModel();
    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);
    activity.injectPresenter(presenter);

    // When
    presenter.fetchQuestionData();
    presenter.trueButtonClicked();
    String activityQuestion = activity.getQuestion();
    String modelQuestion = model.getCurrentQuestion();
    String activityResult = activity.getResult();

    boolean modelAnswer = model.getCurrentAnswer();
    String modelResult = model.getIncorrectLabel();
    if(modelAnswer) {
      modelResult = model.getCorrectLabel();
    }

    /*
    String modelResult = view.getIncorrectLabel();
    if(modelAnswer) {
      modelResult = view.getCorrectLabel();
    }
    */

    // Then
    assertEquals(
        "TestFirstClickTrueButton: Get current question failed",
        activityQuestion, modelQuestion
    );
    assertEquals(
        "TestFirstClickTrueButton: Get current result failed",
        activityResult, modelResult
    );
  }


  @Test
  public void testFirstClickFalseButton() {

    // Given
    AppMediator mediator = AppMediator.getInstance();
    QuestionContract.Presenter presenter = new QuestionPresenter(mediator);
    MockQuestionActivity activity = new MockQuestionActivity();
    QuestionContract.View view = activity;
    QuestionContract.Model model = new QuestionModel();
    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);
    activity.injectPresenter(presenter);

    // When
    presenter.fetchQuestionData();
    presenter.falseButtonClicked();
    String activityQuestion = activity.getQuestion();
    String modelQuestion = model.getCurrentQuestion();
    String activityResult = activity.getResult();

    boolean modelAnswer = model.getCurrentAnswer();
    String modelResult = model.getIncorrectLabel();
    if(!modelAnswer) {
      modelResult = model.getCorrectLabel();
    }

    /*
    String modelResult = view.getIncorrectLabel();
    if(!modelAnswer) {
      modelResult = view.getCorrectLabel();
    }
    */

    // Then
    assertEquals(
        "TestFirstClickFalseButton: Get current question failed",
        activityQuestion, modelQuestion
    );
    assertEquals(
        "TestFirstClickFalseButton: Get current result failed",
        activityResult, modelResult
    );
  }

  @Test
  public void testFirstClickNextButton() {

    // Given
    AppMediator mediator = AppMediator.getInstance();
    QuestionContract.Presenter presenter = new QuestionPresenter(mediator);
    MockQuestionActivity activity = new MockQuestionActivity();
    QuestionContract.View view = activity;
    QuestionContract.Model model = new QuestionModel();
    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);
    activity.injectPresenter(presenter);

    // When
    presenter.fetchQuestionData();
    presenter.nextButtonClicked();
    String activityQuestion = activity.getQuestion();
    String modelQuestion = model.getCurrentQuestion();
    String activityResult = activity.getResult();

    // Then
    assertEquals(
        "TestFirstClickNextButton: Get current question failed",
        activityQuestion, modelQuestion
    );
    assertEquals(
        "TestFirstClickNextButton: Get current result failed",
        activityResult, ""
    );
  }

  @Test
  public void testFirstClickCheatButton() {

    // Given
    AppMediator mediator = AppMediator.getInstance();
    QuestionContract.Presenter presenter = new QuestionPresenter(mediator);
    MockQuestionActivity activity = new MockQuestionActivity();
    QuestionContract.View view = activity;
    QuestionContract.Model model = new QuestionModel();
    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);
    activity.injectPresenter(presenter);

    // When
    presenter.fetchQuestionData();
    presenter.cheatButtonClicked();
    String activityQuestion = activity.getQuestion();
    String modelQuestion = model.getCurrentQuestion();
    String activityResult = activity.getResult();
    QuestionToCheatState presenterState =
        new QuestionToCheatState(model.getCurrentAnswer());
    QuestionToCheatState routerState =
        AppMediator.getInstance().getQuestionToCheatState();

    // Then
    assertEquals(
        "TestFirstClickCheatButton: Get current question failed",
        activityQuestion, modelQuestion
    );
    assertEquals(
        "TestFirstClickCheatButton: Get current result failed",
        activityResult, ""
    );
    assertEquals(
        "TestFirstClickCheatButton: Get current state failed",
        presenterState.answer, routerState.answer
    );
  }
}
