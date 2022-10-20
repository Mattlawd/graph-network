package com.example.graphNetwork.model.edges;

import com.example.graphNetwork.model.nodes.NIC;
import com.example.graphNetwork.model.utils.TimeDetails;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.neo4j.core.schema.*;

@RelationshipProperties
@Data
@EqualsAndHashCode(callSuper = true)
public class Flow extends TimeDetails {

    private int sourcePort;

    private int destinationPort;

    private float latency;

    private float jitter;

    @TargetNode
    private NIC inboundNIC;

}
