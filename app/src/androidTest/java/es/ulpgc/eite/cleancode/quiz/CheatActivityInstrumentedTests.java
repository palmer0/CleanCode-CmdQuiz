package es.ulpgc.eite.cleancode.quiz;


import android.content.pm.ActivityInfo;
import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import es.ulpgc.eite.cleancode.quiz.cheat.CheatActivity;
import es.ulpgc.eite.cleancode.quiz.question.QuestionActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.*;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class CheatActivityInstrumentedTests {

    @Rule
    public ActivityTestRule<QuestionActivity> mActivityTestRule = new ActivityTestRule<>(QuestionActivity.class);


    @Rule
    public ActivityTestRule<CheatActivity> mActivityTestRule2 = new ActivityTestRule<>(CheatActivity.class);

    @Test
    public void cheatActivityTest() {
        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

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

        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.nextButton), withText("Next"),
                        /*childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.constraint.ConstraintLayout")),
                                        3),
                                1),*/
                        isDisplayed()));
        appCompatButton2.perform(click());

        ViewInteraction textView = onView(
                allOf(withId(R.id.questionText), withText("The Gremlins movie was released in 1986?"),
                        /*childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),*/
                        isDisplayed()));
        textView.check(matches(withText("The Gremlins movie was released in 1986?")));

        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.cheatButton), withText("Cheat"),
                        /*childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.constraint.ConstraintLayout")),
                                        3),
                                0),*/
                        isDisplayed()));
        appCompatButton3.perform(click());

        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.noButton), withText("No"),
                        /*childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                2)),
                                1),*/
                        isDisplayed()));
        appCompatButton4.perform(click());

        /*// Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/


        ViewInteraction textView2 = onView(
                allOf(withId(R.id.questionText), withText("The Gremlins movie was released in 1986?"),
                        /*childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),*/
                        isDisplayed()));
        textView2.check(matches(withText("The Gremlins movie was released in 1986?")));

        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.cheatButton), withText("Cheat"),
                        /*childAtPosition(
                                childAtPosition(
                                        withClassName(is("android.support.constraint.ConstraintLayout")),
                                        3),
                                0),*/
                        isDisplayed()));
        appCompatButton5.perform(click());

        mActivityTestRule2.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/



        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.yesButton), withText("Yes"),
                        /*childAtPosition(
                                allOf(withId(R.id.linearLayout),
                                        childAtPosition(
                                                withClassName(is("android.support.constraint.ConstraintLayout")),
                                                2)),
                                0),*/
                        isDisplayed()));
        appCompatButton6.perform(click());

        ViewInteraction textView3 = onView(
                allOf(withId(R.id.answerText), withText("False"),
                        /*childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),*/
                        isDisplayed()));
        textView3.check(matches(withText("False")));

        mActivityTestRule2.getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        /*try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/



        ViewInteraction textView4 = onView(
                allOf(withId(R.id.answerText), withText("False"),
                        /*childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                2),*/
                        isDisplayed()));
        textView4.check(matches(withText("False")));

        pressBack();

        /*// Added a sleep statement to match the app's execution delay.
        // The recommended way to handle such scenarios is to use Espresso idling resources:
        // https://google.github.io/android-testing-support-library/docs/espresso/idling-resource/index.html
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        ViewInteraction textView5 = onView(
                allOf(withId(R.id.questionText), withText("Brad Pitt played Danny Ocean in Ocean's Eleven, Ocean's Twelve and Ocean's Thirteen?"),
                        /*childAtPosition(
                                childAtPosition(
                                        withId(android.R.id.content),
                                        0),
                                0),*/
                        isDisplayed()));
        textView5.check(matches(withText("Brad Pitt played Danny Ocean in Ocean's Eleven, Ocean's Twelve and Ocean's Thirteen?")));
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
    }*/
}
