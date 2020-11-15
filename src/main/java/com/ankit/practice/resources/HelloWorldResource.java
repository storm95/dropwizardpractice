package com.ankit.practice.resources;

import com.ankit.practice.api.Saying;
import com.ankit.practice.entity.request.CreateEmployeeRequest;
import com.ankit.practice.service.EmployeeService;
import com.codahale.metrics.annotation.Timed;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Charsets;
import com.google.common.io.ByteSource;
import com.google.common.io.ByteStreams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {

    Logger logger = LoggerFactory.getLogger(HelloWorldResource.class);

    private final String template;//TODO: Check why is this field again taken in this class as it is already taken in HelloWorldConfiguration
    private final String defaultName;
    private final AtomicLong counter;
    private final EmployeeService employeeService;

    public HelloWorldResource(String template, String defaultName, EmployeeService employeeService) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
        this.employeeService = employeeService;
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") String name) {
        final String value = String.format(template, name);
        return new Saying(counter.incrementAndGet(), value);
    }

    @GET
    @Timed
    @Path("employee")
    public Response getEmployees() {
        return Response.ok(employeeService.getEmployees()).build();
    }

    @POST
    @Timed
    @Path("employee")
    public Response createEmployees(CreateEmployeeRequest createEmployeeRequest) {
        employeeService.createEmployee(createEmployeeRequest.getName());
        return Response.ok().build();
    }
}
