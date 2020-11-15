package com.ankit.practice;

import com.ankit.practice.health.TemplateHealthCheck;
import com.ankit.practice.resources.HelloWorldResource;
import com.ankit.practice.service.EmployeeService;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;

import javax.sql.DataSource;

public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(HelloWorldConfiguration configuration,
                    Environment environment) {
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getFormat().getTemplate());
        environment.healthChecks().register("template", healthCheck);

        // Datasource configuration
        final DataSource dataSource =
                configuration.getDataSourceFactory().build(environment.metrics(), "sql");
        DBI dbi = new DBI(dataSource);

        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getFormat().getTemplate(),
                configuration.getFormat().getDefaultName(),
                dbi.onDemand(EmployeeService.class)
        );
        environment.jersey().register(resource);
    }
}
