package com.example.graphNetwork.model.nodes;

import com.example.graphNetwork.model.utils.VMMetrics;
import lombok.EqualsAndHashCode;
import org.springframework.data.neo4j.core.schema.*;


@Node
//@Data
@EqualsAndHashCode(callSuper = true)
public class VirtualMachine extends VMMetrics {



}
