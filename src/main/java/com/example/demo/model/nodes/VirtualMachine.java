package com.example.demo.model.nodes;

import com.example.demo.model.utils.VMMetrics;
import com.example.demo.model.utils.VMSpecs;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.neo4j.core.schema.*;


@Node
//@Data
@EqualsAndHashCode(callSuper = true)
public class VirtualMachine extends VMMetrics {



}
