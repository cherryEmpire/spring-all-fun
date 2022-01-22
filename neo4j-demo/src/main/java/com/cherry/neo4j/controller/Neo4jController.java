package com.cherry.neo4j.controller;

import com.cherry.neo4j.entities.ActedIn;
import com.cherry.neo4j.entities.Directed;
import com.cherry.neo4j.entities.Movie;
import com.cherry.neo4j.entities.Person;
import com.cherry.neo4j.service.Neo4jService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: Cherry
 * @Date: 2021/12/15
 * @Desc: Neo4jController
 */
@RestController
@RequestMapping("/neo4j")
@Api(tags = "Neo4j Demo测试")
public class Neo4jController {

    @Autowired
    private Neo4jService neo4jService;

    @RequestMapping("addPerson")
    public Person addPerson(Person person) {
        return neo4jService.addPerson(person);
    }

    @RequestMapping("/findOnePerson/{id}")
    public Person findOnePerson(@PathVariable("id")String id){
        return neo4jService.findOnePerson(Long.parseLong(id));
    }

    @RequestMapping("/deleteOnePerson/{id}")
    public String deleteOnePerson(@PathVariable("id")String id){
        neo4jService.deleteOnePerson(Long.parseLong(id));
        return "success";
    }

    @RequestMapping("addMovie")
    public Movie addMobie(Movie movie) {
        return neo4jService.addMovie(movie);
    }

    @RequestMapping("/findOneMovie/{id}")
    public Movie findOneMovie(@PathVariable("id")String id){
        return neo4jService.findOneMovie(Long.parseLong(id));
    }

    @RequestMapping("/directed/{personId}/{movieId}")
    public Directed directed(@PathVariable("personId")String personId, @PathVariable("movieId")String movieId){
        Person person= neo4jService.findOnePerson(Long.parseLong(personId));
        Movie movie= neo4jService.findOneMovie(Long.parseLong(movieId));
        Directed directed=new Directed();
        directed.setStartNode(person);
        directed.setEndNode(movie);
        return neo4jService.directed(directed);
    }

    @RequestMapping("/actedIn/{personId}/{movieId}")
    public ActedIn actedIn(@PathVariable("personId")String personId, @PathVariable("movieId")String movieId){
        Person person= neo4jService.findOnePerson(Long.parseLong(personId));
        Movie movie= neo4jService.findOneMovie(Long.parseLong(movieId));
        ActedIn actedIn=new ActedIn();
        actedIn.setRoles("龙套");
        actedIn.setStartNode(person);
        actedIn.setEndNode(movie);
        return neo4jService.actedIn(actedIn);
    }

}
