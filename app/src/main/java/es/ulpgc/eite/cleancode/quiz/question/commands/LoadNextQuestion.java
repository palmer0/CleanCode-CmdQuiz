package es.ulpgc.eite.cleancode.quiz.question.commands;

import es.ulpgc.eite.cleancode.quiz.app.AppCommand;
import es.ulpgc.eite.cleancode.quiz.question.QuestionState;
import es.ulpgc.eite.cleancode.quiz.question.QuestionViewModel;

public class LoadNextQuestion implements AppCommand {


  private QuestionState state;
  private QuestionViewModel viewModel;
  private final String question;

  public LoadNextQuestion(QuestionState state, String question) {
    this.state = state;
    viewModel = state;
    this.question = question;
  }

  @Override
  public void execute() {
    loadNextQuestion();
  }

  private void loadNextQuestion() {
    state.quizIndex++;

    viewModel.questionText = question;
    viewModel.resultText = "";

    viewModel.falseButton = true;
    viewModel.trueButton = true;
    viewModel.cheatButton = true;
    viewModel.nextButton = false;
  }
}
