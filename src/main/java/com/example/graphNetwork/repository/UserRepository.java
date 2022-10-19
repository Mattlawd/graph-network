package com.example.graphNetwork.repository;

import com.example.graphNetwork.model.nodes.User;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface UserRepository extends Neo4jRepository<User, Long> {



}
