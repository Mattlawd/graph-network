package com.example.graphNetwork.model.nodes;

import com.example.graphNetwork.model.edges.UserToVMRelationship;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

@Node
@Data
public class User {

    @Id
    @GeneratedValue
    private Long id;

    private String email;

    @Relationship(type = "INSTANTIATED", direction = Relationship.Direction.OUTGOING)
    private List<UserToVMRelationship> userInstantiatedConnections;

    @Relationship(type = "LAST_MODIFIED", direction = Relationship.Direction.OUTGOING)
    private List<UserToVMRelationship> userLastModifiedConnections;

}
