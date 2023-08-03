package com.nagarro.resources;

import com.nagarro.auth.UserAuthenticator;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/authenticate")
@Produces(MediaType.APPLICATION_JSON)
public class AuthenticationResource {
    private final UserAuthenticator userAuthenticator;

    public AuthenticationResource(final UserAuthenticator userAuthenticator) {
        this.userAuthenticator = userAuthenticator;
    }

    @POST
    public Response authenticateUser(@QueryParam("userid") final String userId, @QueryParam("password") final String password) {
        final var isAuthenticated = userAuthenticator.authenticate(userId, password);
        if (isAuthenticated) {
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }
}
