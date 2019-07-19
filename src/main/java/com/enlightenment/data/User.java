package com.enlightenment.data;

public enum User {

    JUST_ONBOARDED(
            "test.enlightenment@enlightenment.io"
    ),

    PASSED_COOLING_OFFD(
            "cooled.off@email.com"
    );

    public String email;

    User(String email) {
        this.email = email;
    }
}
