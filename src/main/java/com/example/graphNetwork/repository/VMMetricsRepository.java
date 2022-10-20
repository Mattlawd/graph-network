package com.example.graphNetwork.repository;

import com.example.graphNetwork.model.nodes.VMMetrics;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface VMMetricsRepository extends Neo4jRepository<VMMetrics, Long> {
}
