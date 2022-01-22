package com.cherry.neo4j.repositories;

import com.cherry.neo4j.entities.ActedIn;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: Cherry
 * @Date: 2021/12/15
 * @Desc: ActedInRepository
 */
@Repository
public interface ActedInRepository extends Neo4jRepository<ActedIn, Long> {
}
