package com.enlightenment.mobiletests;

import com.enlightenment.data.User;
import com.enlightenment.utils.CommonActions;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.enlightenment.teststeps.LoginSteps.and_user_clicks_on_emailed_magic_link;
import static com.enlightenment.teststeps.LoginSteps.given_user_logs_in_as;

public class InitialTest extends BaseTest {

    @Description("Testing the login functionality")
    @Feature("Login")
    @Story("Valid Login")
    @Test(description = "Login First Test")
    public void loginBasicTest() {
        given_user_logs_in_as(User.JUST_ONBOARDED);
        CommonActions.pauseTest(12);

        and_user_clicks_on_emailed_magic_link();

        Assert.fail("Failing the test run");
    }
}
