package com.example.graphNetwork.model.edges;

import com.example.graphNetwork.model.nodes.VirtualMachine;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
@Data
public class NICToVMRelationship {

    @RelationshipId
    @GeneratedValue
    private Long flowId;

    @TargetNode
    private VirtualMachine virtualMachine;
}