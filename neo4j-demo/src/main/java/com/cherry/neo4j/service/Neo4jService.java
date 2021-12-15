package com.cherry.neo4j.service;

import com.cherry.neo4j.entities.ActedIn;
import com.cherry.neo4j.entities.Directed;
import com.cherry.neo4j.entities.Movie;
import com.cherry.neo4j.entities.Person;
import com.cherry.neo4j.repositories.ActedInRepository;
import com.cherry.neo4j.repositories.DirectedRepository;
import com.cherry.neo4j.repositories.MovieRepository;
import com.cherry.neo4j.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Cherry
 * @Date: 2021/12/15
 * @Desc: Neo4jService
 */
@Service
public class Neo4jService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private DirectedRepository directedRepository;

    @Autowired
    private ActedInRepository actedInRepository;

    public Person addPerson(Person person) {
        return personRepository.save(person);
    }

    public Person findOnePerson(long id) {
        return personRepository.findById(id).get();
    }

    public void deleteOnePerson(long id) {
        personRepository.deleteById(id);
    }

    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public Movie findOneMovie(long id) {
        return movieRepository.findById(id).get();
    }

    public Directed directed(Directed directed) {
        return directedRepository.save(directed);
    }

    public ActedIn actedIn(ActedIn actedIn) {
        return actedInRepository.save(actedIn);
    }
}
