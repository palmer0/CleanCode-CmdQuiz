package es.ulpgc.eite.cleancode.quiz;


import android.content.pm.ActivityInfo;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ulpgc.eite.cleancode.quiz.cheat.CheatActivity;
import es.ulpgc.eite.cleancode.quiz.question.QuestionActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.Espresso.pressBack;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@SuppressWarnings("ALL")
@LargeTest
@RunWith(AndroidJUnit4.class)
public class CheatScreenTest {

  @Rule
  public ActivityTestRule<QuestionActivity> mActivityTestRule =
      new ActivityTestRule<>(QuestionActivity.class);


  @Rule
  public ActivityTestRule<CheatActivity> mActivityTestRule2 =
      new ActivityTestRule<>(CheatActivity.class);

  @Test
  public void cheatActivityTest() {


    ViewInteraction appCompatButton = onView(withId(R.id.trueButton));
    appCompatButton.perform(click());


    ViewInteraction appCompatButton2 = onView(withId(R.id.nextButton));
    appCompatButton2.perform(click());

    ViewInteraction textView = onView(withId(R.id.questionText));
    textView.check(matches(withText(
        "The Gremlins movie was released in 1986?"
    )));



    ViewInteraction appCompatButton3 = onView(withId(R.id.cheatButton));
    appCompatButton3.perform(click());

    ViewInteraction appCompatButton4 = onView(withId(R.id.noButton));
    appCompatButton4.perform(click());

    ViewInteraction textView2 = onView(withId(R.id.questionText));
    textView2.check(matches(withText(
        "The Gremlins movie was released in 1986?"
    )));

    ViewInteraction appCompatButton5 = onView(withId(R.id.cheatButton));
    appCompatButton5.perform(click());

    mActivityTestRule2.getActivity()
        .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


    ViewInteraction appCompatButton6 = onView(withId(R.id.yesButton));
    appCompatButton6.perform(click());

    ViewInteraction textView3 = onView(withId(R.id.answerText));
    textView3.check(matches(withText("False")));

    mActivityTestRule2.getActivity()
        .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

    ViewInteraction textView4 = onView(withId(R.id.answerText));
    textView4.check(matches(withText("False")));

    pressBack();

    ViewInteraction textView5 = onView(withId(R.id.questionText));
    textView5.check(matches(withText(
        "Brad Pitt played Danny Ocean in Ocean's Eleven, " +
            "Ocean's Twelve and Ocean's Thirteen?"
    )));
  }


}
