package com.example.demo.repository;

import com.example.demo.model.nodes.VirtualMachine;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface VirtualMachineRepository extends Neo4jRepository<VirtualMachine, Long> {
}
