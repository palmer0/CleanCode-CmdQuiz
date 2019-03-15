package es.ulpgc.eite.cleancode.quiz.question.commands;

import es.ulpgc.eite.cleancode.quiz.app.AppCommand;
import es.ulpgc.eite.cleancode.quiz.question.QuestionViewModel;

public class CheckCurrentQuestion implements AppCommand {

  private QuestionViewModel viewModel;
  private final String result;
  private final boolean enable;

  public CheckCurrentQuestion(
      QuestionViewModel viewModel, String result, boolean enable) {

    this.viewModel = viewModel;
    this.result = result;
    this.enable = enable;
  }


  @Override
  public void execute() {
    checkCurrentQuestion();
  }

  private void checkCurrentQuestion() {
    viewModel.resultText = result;

    viewModel.falseButton = false;
    viewModel.trueButton = false;
    viewModel.cheatButton = false;
    viewModel.nextButton = enable;

  }


}
