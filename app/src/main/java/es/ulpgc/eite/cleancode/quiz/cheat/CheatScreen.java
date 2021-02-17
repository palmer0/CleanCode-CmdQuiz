package es.ulpgc.eite.cleancode.quiz.cheat;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.quiz.app.AppMediator;

public class CheatScreen {


  public static void configure(CheatContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = AppMediator.getInstance();

    CheatContract.Presenter presenter = new CheatPresenter(mediator);
    presenter.injectView(new WeakReference<>(view));
    view.injectPresenter(presenter);

  }

}
