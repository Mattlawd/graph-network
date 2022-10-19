package com.example.demo.model.edges;

import com.example.demo.model.nodes.NIC;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

@RelationshipProperties
@Data
public class Flow {

    @RelationshipId
    @GeneratedValue
    private Long flowId;

    private int sourcePort;

    private int destinationPort;

    private float latency;

    private float jitter;

    @TargetNode
    private NIC inboundNIC;



}
