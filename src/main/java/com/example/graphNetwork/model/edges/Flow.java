package com.example.graphNetwork.model.edges;

import com.example.graphNetwork.model.nodes.NIC;
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
