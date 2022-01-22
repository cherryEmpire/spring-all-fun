package com.cherry.neo4j.repositories;

import com.cherry.neo4j.entities.Movie;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author: Cherry
 * @Date: 2021/12/15
 * @Desc: MovieRepository
 */
@Repository
public interface MovieRepository extends Neo4jRepository<Movie, Long> {
}
