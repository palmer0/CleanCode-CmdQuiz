package es.ulpgc.eite.cleancode.quiz;


import android.content.pm.ActivityInfo;

import androidx.test.espresso.ViewInteraction;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ulpgc.eite.cleancode.quiz.question.QuestionActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@SuppressWarnings("ALL")
@LargeTest
@RunWith(AndroidJUnit4.class)
public class QuestionScreenTest {

  @Rule
  public ActivityTestRule<QuestionActivity> mActivityTestRule =
      new ActivityTestRule<>(QuestionActivity.class);

  @Test
  public void questionActivityTest() {

    ViewInteraction textView = onView(withId(R.id.questionText));
    textView.check(matches(withText(
        "Christian Bale played Batman in 'The Dark Knight Rises'?"
    )));

    ViewInteraction appCompatButton = onView(withId(R.id.trueButton));
    appCompatButton.perform(click());

    ViewInteraction textView2 = onView(withId(R.id.questionText));
    textView2.check(matches(withText(
        "Christian Bale played Batman in 'The Dark Knight Rises'?"
    )));

    ViewInteraction textView3 = onView(withId(R.id.resultText));
    textView3.check(matches(withText("Correct!")));

    ViewInteraction appCompatButton2 = onView(withId(R.id.nextButton));
    appCompatButton2.perform(click());

    ViewInteraction textView4 = onView(withId(R.id.questionText));
    textView4.check(matches(withText(
        "The Gremlins movie was released in 1986?"
    )));

    ViewInteraction appCompatButton3 = onView(withId(R.id.trueButton));
    appCompatButton3.perform(click());

    ViewInteraction textView5 = onView(withId(R.id.questionText));
    textView5.check(matches(withText(
        "The Gremlins movie was released in 1986?"
    )));

    ViewInteraction textView6 = onView(withId(R.id.resultText));
    textView6.check(matches(withText("Incorrect!")));


    mActivityTestRule.getActivity()
        .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


    ViewInteraction textView7 = onView(withId(R.id.resultText));
    textView7.check(matches(withText("Incorrect!")));

    ViewInteraction textView8 = onView(withId(R.id.questionText));
    textView8.check(matches(withText(
        "The Gremlins movie was released in 1986?"
    )));

    ViewInteraction appCompatButton4 = onView(withId(R.id.nextButton));
    appCompatButton4.perform(click());

    ViewInteraction textView9 = onView(withId(R.id.questionText));
    textView9.check(matches(withText(
        "Brad Pitt played Danny Ocean in Ocean's Eleven, " +
            "Ocean's Twelve and Ocean's Thirteen?"
    )));

    ViewInteraction appCompatButton5 = onView(withId(R.id.falseButton));
    appCompatButton5.perform(click());

    ViewInteraction textView10 = onView(withId(R.id.questionText));
    textView10.check(matches(withText(
        "Brad Pitt played Danny Ocean in Ocean's Eleven, " +
            "Ocean's Twelve and Ocean's Thirteen?"
    )));

    ViewInteraction textView11 = onView(withId(R.id.resultText));
    textView11.check(matches(withText("Correct!")));

    mActivityTestRule.getActivity()
        .setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


    ViewInteraction textView12 = onView(withId(R.id.questionText));
    textView12.check(matches(withText(
        "Brad Pitt played Danny Ocean in Ocean's Eleven, " +
            "Ocean's Twelve and Ocean's Thirteen?"
    )));

    ViewInteraction textView13 = onView(withId(R.id.resultText));
    textView13.check(matches(withText("Correct!")));

    ViewInteraction appCompatButton6 = onView(withId(R.id.nextButton));
    appCompatButton6.perform(click());

    ViewInteraction textView14 = onView(withId(R.id.questionText));
    textView14.check(matches(withText(
        "A spoon full of sugar' came from the 1964 movie Mary Poppins?"
    )));
  }

}
