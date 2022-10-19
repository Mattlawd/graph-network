package com.example.graphNetwork.repository;

import com.example.graphNetwork.model.nodes.VirtualMachine;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface VirtualMachineRepository extends Neo4jRepository<VirtualMachine, Long> {
}
