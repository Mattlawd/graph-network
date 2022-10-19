package com.example.demo.repository;

import com.example.demo.model.nodes.NIC;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface NetworkInterfaceCardRepository extends Neo4jRepository<NIC, Long> {



}
