package com.example.demo.model.nodes;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.neo4j.core.schema.Node;

@Data
@Node
@EqualsAndHashCode(callSuper = true)
public class ExternalNIC extends NIC {


}
