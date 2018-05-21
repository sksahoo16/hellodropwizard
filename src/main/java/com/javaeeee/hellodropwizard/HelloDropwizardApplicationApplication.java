package com.javaeeee.hellodropwizard;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HelloDropwizardApplicationApplication extends Application<HelloDropwizardApplicationConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HelloDropwizardApplicationApplication().run(args);
    }

    @Override
    public String getName() {
        return "HelloDropwizardApplication";
    }

    @Override
    public void initialize(final Bootstrap<HelloDropwizardApplicationConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final HelloDropwizardApplicationConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
