package com.cherry.neo4j.entities;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Property;

/**
 * @Author: Cherry
 * @Date: 2021/12/15
 * @Desc: Movie
 */
@NodeEntity(label = "Movie")
public class Movie {
    @Id
    @GeneratedValue
    private Long nodeId;

    @Property(name = "title")
    private String title;

    @Property(name = "released")
    private int released;

    public void setNodeId(Long nodeId) {
        this.nodeId = nodeId;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReleased(int released) {
        this.released = released;
    }

    public Long getNodeId() {
        return nodeId;
    }

    public String getTitle() {
        return title;
    }

    public int getReleased() {
        return released;
    }


}
