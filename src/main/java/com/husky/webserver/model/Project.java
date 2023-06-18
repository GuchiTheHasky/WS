package com.husky.webserver.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class Project {
    @JsonProperty("project")
    private String project;
    @JsonProperty("timestamp")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp timestamp;
    @JsonProperty("compilationTime")
    private int compilationTime;
    @JsonProperty("result")
    private String result;
}
