package com.example.graphNetwork.model.nodes;

import com.example.graphNetwork.model.edges.VMMetricsToVMRelationship;
import com.example.graphNetwork.model.utils.TimeDetails;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
@Data
@Node
@EqualsAndHashCode(callSuper = true)
public class VMMetrics extends TimeDetails {

    private float cpuUtilisation;
    private float availableMemory;

    @Relationship(type = "METRICS", direction = Relationship.Direction.OUTGOING)
    private VMMetricsToVMRelationship vmMetricsToVMRelationship;

}
