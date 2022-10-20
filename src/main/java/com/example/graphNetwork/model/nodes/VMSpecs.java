package com.example.graphNetwork.model.nodes;

import com.example.graphNetwork.model.edges.VMSpecsToVMRelationship;
import com.example.graphNetwork.model.utils.TimeDetails;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Data
@Node
@EqualsAndHashCode(callSuper = true)
public class VMSpecs extends TimeDetails {

    private float cores;
    private float ram;

    @Relationship(type = "SPECS", direction = Relationship.Direction.OUTGOING)
    private VMSpecsToVMRelationship vmSpecsToVMRelationship;

//    public void setVMSpecs(VMSpecs vmSpecs) {
//        this.cores = vmSpecs.cores;
//        this.ram = vmSpecs.ram;
//    }
//
//    public VMSpecs() {}

}
