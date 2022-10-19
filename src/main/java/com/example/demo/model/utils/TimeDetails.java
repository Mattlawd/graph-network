package com.example.demo.model.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.lang.Nullable;

import java.sql.Timestamp;

@Data
public abstract class TimeDetails {

    @Id
    @GeneratedValue
    private Long id;
    private Timestamp startDate;
    private Timestamp endDate;

}
