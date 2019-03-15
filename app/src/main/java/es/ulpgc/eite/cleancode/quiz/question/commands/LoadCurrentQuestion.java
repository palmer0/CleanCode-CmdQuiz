package es.ulpgc.eite.cleancode.quiz.question.commands;

import es.ulpgc.eite.cleancode.quiz.app.AppCommand;
import es.ulpgc.eite.cleancode.quiz.question.QuestionViewModel;

public class LoadCurrentQuestion implements AppCommand {

  private final QuestionViewModel viewModel;
  private final String question;

  public LoadCurrentQuestion(
      QuestionViewModel viewModel, String question) {

    this.viewModel = viewModel;
    this.question = question;
  }

  @Override
  public void execute() {
    loadCurrentQuestion();
  }

  private void loadCurrentQuestion() {

    viewModel.questionText = question;
  }

}
