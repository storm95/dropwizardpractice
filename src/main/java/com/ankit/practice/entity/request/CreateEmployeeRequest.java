package com.ankit.practice.entity.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

public class CreateEmployeeRequest {

    @NotNull
    @JsonProperty
    public String name;

    @JsonProperty
    public String getName() {
        return name;
    }
}
