package com.example.demo.model.nodes;
import com.example.demo.model.edges.Flow;
import com.example.demo.model.edges.NICToVMRelationship;
import com.example.demo.model.utils.TimeDetails;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@Data
@Node
@EqualsAndHashCode(callSuper = true)
public class NIC extends TimeDetails {
//
//    @Id
//    @GeneratedValue
//    private Long id;

    private String publicIp;

    private String macAddress;

    private String location;

    @Relationship(type = "FLOWS_TO", direction = Relationship.Direction.OUTGOING)
    private List<Flow> outgoingFlows;

    @Relationship(type="ATTACHED_TO", direction = Relationship.Direction.OUTGOING)
    private List<NICToVMRelationship> nicToVMRelationships;


}
