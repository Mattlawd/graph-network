package com.example.graphNetwork.model.utils;

import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;

import java.sql.Timestamp;

@Data
public abstract class TimeDetails {

    @Id
    @GeneratedValue
    private Long id;
    private Timestamp startDate;
    private Timestamp endDate;

}
