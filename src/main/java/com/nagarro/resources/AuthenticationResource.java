package com.nagarro.resources;

import com.nagarro.auth.UserAuthenticator;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/authenticate")
@Produces(MediaType.APPLICATION_JSON)
public class AuthenticationResource {
    private final UserAuthenticator userAuthenticator;

    public AuthenticationResource() {
        this.userAuthenticator = new UserAuthenticator();
    }

    @POST
    public Response authenticateUser(@QueryParam("userid") String userId, @QueryParam("password") String password) {
        boolean isAuthenticated = userAuthenticator.authenticate(userId, password);
        if (isAuthenticated) {
            return Response.ok(true).build();
        } else {
            return Response.status(Response.Status.FORBIDDEN).build();
        }
    }
}
