package com.nagarro.auth;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestUserAuthenticator {

    private static final String VALID_USERID = "abhishek";
    private static final String VALID_USERPASSWORD = "abhi@123";
    private static final String INVALID_USERID = "abhi";
    private static final String INVALID_USERPASSWORD = "root@123";

    private static final UserAuthenticator userAuthenticator = new UserAuthenticator();
    @Test
    void testAuthenticateValid(){
        //Given
        final var expected = true;
        //When
        final var actual = userAuthenticator.authenticate(VALID_USERID,VALID_USERPASSWORD);
        //Then
        assertEquals(expected,actual);
    }

    @Test
    void testAuthenticateInValid(){
        final var expected = false;

        final var actual = userAuthenticator.authenticate(INVALID_USERID,INVALID_USERPASSWORD);

        assertEquals(expected,actual);
    }

}
