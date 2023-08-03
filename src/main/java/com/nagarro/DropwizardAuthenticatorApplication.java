package com.nagarro;

import com.nagarro.auth.UserAuthenticator;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.nagarro.resources.AuthenticationResource;

public class DropwizardAuthenticatorApplication extends Application<DropwizardAuthenticatorConfiguration> {

    public static void main(final String[] args) throws Exception {
        new DropwizardAuthenticatorApplication().run(args);
    }

    @Override
    public String getName() {
        return "DropwizardAuthenticator";
    }

    @Override
    public void initialize(final Bootstrap<DropwizardAuthenticatorConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final DropwizardAuthenticatorConfiguration configuration,
                    final Environment environment) {
        final var userAuthenticator = new UserAuthenticator();
        final var resource = new AuthenticationResource(userAuthenticator);
        environment.jersey().register(resource);
    }

}
