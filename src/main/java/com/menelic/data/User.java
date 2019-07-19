package com.menelic.data;

public enum User {

    JUST_ONBOARDED(
            "test.menelic@menelic.io"
    ),

    PASSED_COOLING_OFFD(
            "cooled.off@email.com"
    );

    public String email;

    User(String email) {
        this.email = email;
    }
}
