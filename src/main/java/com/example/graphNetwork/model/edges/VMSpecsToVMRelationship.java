package com.example.graphNetwork.model.edges;

import com.example.graphNetwork.model.nodes.VirtualMachine;
import com.example.graphNetwork.model.utils.TimeDetails;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.neo4j.core.schema.*;

@RelationshipProperties
@Data
@EqualsAndHashCode(callSuper = true)
public class VMSpecsToVMRelationship extends TimeDetails {

    @TargetNode
    private VirtualMachine virtualMachine;

}
