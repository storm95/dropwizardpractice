package com.ankit.practice;

import com.ankit.practice.config.Format;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class HelloWorldConfiguration extends Configuration {
    @NotNull
    @JsonProperty("format")
    private Format format;

    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory dataSourceFactory = new DataSourceFactory();

    public Format getFormat() {
        return format;
    }

    public DataSourceFactory getDataSourceFactory() {
        return dataSourceFactory;
    }
}
