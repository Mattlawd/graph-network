package com.example.graphNetwork.repository;

import com.example.graphNetwork.model.nodes.NIC;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface NetworkInterfaceCardRepository extends Neo4jRepository<NIC, Long> {



}
