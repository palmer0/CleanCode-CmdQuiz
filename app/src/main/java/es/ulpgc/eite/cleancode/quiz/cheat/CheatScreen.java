package es.ulpgc.eite.cleancode.quiz.cheat;

import android.support.v4.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.quiz.app.AppMediator;

public class CheatScreen {


  public static void configure(CheatContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    AppMediator mediator = (AppMediator) context.get().getApplication();
    CheatState state = mediator.getCheatState();

    CheatContract.Router router = new CheatRouter(mediator);
    CheatContract.Presenter presenter = new CheatPresenter(state);
    presenter.injectView(new WeakReference<>(view));
    presenter.injectRouter(router);
    view.injectPresenter(presenter);

  }

}
