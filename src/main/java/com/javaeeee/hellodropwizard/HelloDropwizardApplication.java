package com.javaeeee.hellodropwizard;

import io.dropwizard.Application;
import io.dropwizard.auth.AuthDynamicFeature;
import io.dropwizard.auth.oauth.OAuthCredentialAuthFilter;
import io.dropwizard.setup.Environment;

import javax.sql.DataSource;

import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;
import org.skife.jdbi.v2.DBI;

import io.dropwizard.setup.Bootstrap;
import com.javaeeee.hellodropwizard.service.PartsService;
import com.javaeeee.hellodropwizard.health.HelloDropwizardApplicationHealthCheck;
import com.javaeeee.hellodropwizard.resources.PartsResource;

public class HelloDropwizardApplication extends Application<HelloDropwizardConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HelloDropwizardApplication().run(args);
    }

    @Override
    public String getName() {
        return "HelloDropwizard";
    }

    @Override
    public void initialize(final Bootstrap<HelloDropwizardConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final HelloDropwizardConfiguration configuration,
                    final Environment environment) {
    	
    	final String SQL = "sql";
    	final String HELLO_DROPWIZARD_SERVICE = "Dropwizard Test service";
    	final String BEARER = "Bearer";
    	
    	// Datasource configuration
        final DataSource dataSource = configuration.getDataSourceFactory().build(environment.metrics(), SQL);
        DBI dbi = new DBI(dataSource);

        // Register Health Check
        HelloDropwizardApplicationHealthCheck healthCheck =
            new HelloDropwizardApplicationHealthCheck(dbi.onDemand(PartsService.class));
        environment.healthChecks().register(HELLO_DROPWIZARD_SERVICE, healthCheck);

        // Register OAuth authentication
        environment.jersey()
            .register(new AuthDynamicFeature(new OAuthCredentialAuthFilter.Builder<User>()
                .setAuthenticator(new HelloDropwizardAuthenticator())
                .setAuthorizer(new HelloDropwizardAuthorizer()).setPrefix(BEARER).buildAuthFilter()));
        environment.jersey().register(RolesAllowedDynamicFeature.class);

        // Register resources
        environment.jersey().register(new PartsResource(dbi.onDemand(PartsService.class)));
      }


}
