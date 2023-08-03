package com.nagarro.resources;

import com.nagarro.auth.UserAuthenticator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.assertj.core.api.Assertions.assertThat;


public class TestResource {

    private AuthenticationResource resource;
    private static final String VALID_USERID = "abhishek";
    private static final String VALID_PASSWORD = "abhi@123";
    private static final String INVALID_USERID = "invalid_user";
    private static final String INVALID_PASSWORD = "invalid_password";

    @BeforeEach
    void setUp() {
        final var authenticator = new UserAuthenticator();
        resource = new AuthenticationResource(authenticator);
    }

    @Test
    void testValidAuthentication() {
        final var response = resource.authenticateUser(VALID_USERID, VALID_PASSWORD);

        assertThat(response.getStatus()).isEqualTo(Response.Status.OK.getStatusCode());
    }

    @Test
    void testInvalidAuthentication() {
        final var response = resource.authenticateUser(INVALID_USERID, INVALID_PASSWORD);

        assertThat(response.getStatus()).isEqualTo(Response.Status.FORBIDDEN.getStatusCode());
    }
}
