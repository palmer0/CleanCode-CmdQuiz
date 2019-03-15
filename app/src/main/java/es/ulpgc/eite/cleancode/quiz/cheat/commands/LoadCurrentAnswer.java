package es.ulpgc.eite.cleancode.quiz.cheat.commands;

import es.ulpgc.eite.cleancode.quiz.app.AppCommand;
import es.ulpgc.eite.cleancode.quiz.cheat.CheatViewModel;

public class LoadCurrentAnswer implements AppCommand {

  private final CheatViewModel viewModel;
  private final String reply;

  public LoadCurrentAnswer(CheatViewModel viewModel, String reply) {
    this.viewModel = viewModel;
    this.reply = reply;
  }

  @Override
  public void execute() {
    viewModel.answerText = reply;

    viewModel.yesButton = false;
    viewModel.noButton = false;
  }
}
