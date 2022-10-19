package com.example.demo.model.edges;

import com.example.demo.model.nodes.VirtualMachine;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
@Data
public class UserToVMRelationship {

    @RelationshipId
    @GeneratedValue
    private Long userConnectionId;

    @TargetNode
    private VirtualMachine virtualMachine;

}
