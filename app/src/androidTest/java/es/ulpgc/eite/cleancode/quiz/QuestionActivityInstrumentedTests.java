package es.ulpgc.eite.cleancode.quiz;


import android.content.pm.ActivityInfo;
import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import es.ulpgc.eite.cleancode.quiz.question.QuestionActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class QuestionActivityInstrumentedTests {

    @Rule
    public ActivityTestRule<QuestionActivity> mActivityTestRule = new ActivityTestRule<>(QuestionActivity.class);

    @Test
    public void questionActivityTest() {
        ViewInteraction textView = onView(
                allOf(withId(R.id.questionText), withText("Christian Bale played Batman in 'The Dark Knight Rises'?"),
                        /*childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),*/
                        isDisplayed()));
        textView.check(matches(withText("Christian Bale played Batman in 'The Dark Knight Rises'?")));

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.trueButton), withText("True"),
                        /*childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                2)),
                                0),*/
                        isDisplayed()));
        appCompatButton.perform(click());

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.questionText), withText("Christian Bale played Batman in 'The Dark Knight Rises'?"),
                        /*childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),*/
                        isDisplayed()));
        textView2.check(matches(withText("Christian Bale played Batman in 'The Dark Knight Rises'?")));

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.resultText), withText("Correct!"),
                        /*childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),*/
                        isDisplayed()));
        textView3.check(matches(withText("Correct!")));

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        /*childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.constraint.ConstraintLayout")),
                                        3),
                                1),*/
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction textView4 = onView(
                allOf(withId(R.id.questionText), withText("The Gremlins movie was released in 1986?"),
                        /*childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),*/
                        isDisplayed()));
        textView4.check(matches(withText("The Gremlins movie was released in 1986?")));

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.trueButton), withText("True"),
                        /*childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                2)),
                                0),*/
                        isDisplayed()));
        appCompatButton3.perform(click());

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.questionText), withText("The Gremlins movie was released in 1986?"),
                        /*childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),*/
                        isDisplayed()));
        textView5.check(matches(withText("The Gremlins movie was released in 1986?")));

        ViewInteraction textView6 = onView(
                allOf(withId(R.id.resultText), withText("Incorrect!"),
                        /*childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),*/
                        isDisplayed()));
        textView6.check(matches(withText("Incorrect!")));

        /*
        // Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        mActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        ViewInteraction textView7 = onView(
                allOf(withId(R.id.resultText), withText("Incorrect!"),
                        /*childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),*/
                        isDisplayed()));
        textView7.check(matches(withText("Incorrect!")));

        ViewInteraction textView8 = onView(
                allOf(withId(R.id.questionText), withText("The Gremlins movie was released in 1986?"),
                        /*childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),*/
                        isDisplayed()));
        textView8.check(matches(withText("The Gremlins movie was released in 1986?")));

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        /*childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.constraint.ConstraintLayout")),
                                        3),
                                1),*/
                        isDisplayed()));
        appCompatButton4.perform(click());

        ViewInteraction textView9 = onView(
                allOf(withId(R.id.questionText), withText("Brad Pitt played Danny Ocean in Ocean's Eleven, Ocean's Twelve and Ocean's Thirteen?"),
                        /*childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),*/
                        isDisplayed()));
        textView9.check(matches(withText("Brad Pitt played Danny Ocean in Ocean's Eleven, Ocean's Twelve and Ocean's Thirteen?")));

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.falseButton), withText("False"),
                        /*childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                2)),
                                1),*/
                        isDisplayed()));
        appCompatButton5.perform(click());

        ViewInteraction textView10 = onView(
                allOf(withId(R.id.questionText), withText("Brad Pitt played Danny Ocean in Ocean's Eleven, Ocean's Twelve and Ocean's Thirteen?"),
                        /*childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),*/
                        isDisplayed()));
        textView10.check(matches(withText("Brad Pitt played Danny Ocean in Ocean's Eleven, Ocean's Twelve and Ocean's Thirteen?")));

        ViewInteraction textView11 = onView(
                allOf(withId(R.id.resultText), withText("Correct!"),
                        /*childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),*/
                        isDisplayed()));
        textView11.check(matches(withText("Correct!")));

        /*// Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        mActivityTestRule.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        ViewInteraction textView12 = onView(
                allOf(withId(R.id.questionText), withText("Brad Pitt played Danny Ocean in Ocean's Eleven, Ocean's Twelve and Ocean's Thirteen?"),
                        /*childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),*/
                        isDisplayed()));
        textView12.check(matches(withText("Brad Pitt played Danny Ocean in Ocean's Eleven, Ocean's Twelve and Ocean's Thirteen?")));

        ViewInteraction textView13 = onView(
                allOf(withId(R.id.resultText), withText("Correct!"),
                        /*childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),*/
                        isDisplayed()));
        textView13.check(matches(withText("Correct!")));

        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        /*childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.constraint.ConstraintLayout")),
                                        3),
                                1),*/
                        isDisplayed()));
        appCompatButton6.perform(click());

        ViewInteraction textView14 = onView(
                allOf(withId(R.id.questionText), withText("A spoon full of sugar' came from the 1964 movie Mary Poppins?"),
                        /*childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),*/
                        isDisplayed()));
        textView14.check(matches(withText("A spoon full of sugar' came from the 1964 movie Mary Poppins?")));
    }

    /*
    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
    */
}
