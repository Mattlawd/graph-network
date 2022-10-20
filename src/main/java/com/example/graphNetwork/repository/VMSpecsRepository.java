package com.example.graphNetwork.repository;

import com.example.graphNetwork.model.nodes.VMSpecs;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface VMSpecsRepository extends Neo4jRepository<VMSpecs, Long> {
}
