package es.ulpgc.eite.cleancode.quiz.question;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.quiz.R;
import es.ulpgc.eite.cleancode.quiz.app.AppMediator;


public class QuestionScreen {


  public static void configure(QuestionContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = AppMediator.getInstance();
    //QuestionState state = mediator.getQuestionState();

    //QuestionContract.Router router = new QuestionRouter(mediator);
    //QuestionContract.Presenter presenter = new QuestionPresenter(state);
    QuestionContract.Presenter presenter = new QuestionPresenter(mediator);

    QuestionModel model = new QuestionModel();
    model.setCorrectLabel(context.get().getString(R.string.correct_label));
    model.setIncorrectLabel(context.get().getString(R.string.incorrect_label));

    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);
    //presenter.injectRouter(router);
    view.injectPresenter(presenter);

  }

}
