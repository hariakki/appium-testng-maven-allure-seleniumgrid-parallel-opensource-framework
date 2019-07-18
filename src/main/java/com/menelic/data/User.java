package com.menelic.data;

public enum User {

    JUST_ONBOARDED(
            "test.contino@contino.io"
    ),

    PASSED_COOLING_OFF_PERIOD_NO_READINGS_SUBMITTED(
            "cooled.off@email.com"
    ),

    ONBOARDED_WITH_2_SUBMITTED_READINGS(
            "cooled.off@email.com"
    );

    public String email;

    User(String email) {
        this.email = email;
    }
}
