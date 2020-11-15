package com.ankit.practice.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class Format {
    @NotNull
    @JsonProperty("template")
    private String template;

    @NotNull
    @JsonProperty("defaultName")
    private String defaultName;

    public String getTemplate() {
        return template;
    }

    public String getDefaultName() {
        return defaultName;
    }
}
