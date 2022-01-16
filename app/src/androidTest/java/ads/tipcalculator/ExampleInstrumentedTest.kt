package ads.tipcalculator

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculate_default_tip() {
        Espresso.onView(ViewMatchers.withId(R.id.cost_of_service_edit_text))
            .perform(ViewActions.typeText("50.00"))

        Espresso.onView(ViewMatchers.withId(R.id.calculate_button)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.tip_result))
            .check(ViewAssertions.matches(ViewMatchers.withText(Matchers.containsString("10.00"))))
    }
}