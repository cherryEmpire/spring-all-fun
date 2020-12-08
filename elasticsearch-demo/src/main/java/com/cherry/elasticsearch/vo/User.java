package com.cherry.elasticsearch.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Cherry
 * @Date: 2020/12/7
 * @Desc: User
 */
@Data
@NoArgsConstructor
public class User {

    private long id;

    private String name;

    private int age;

    private String country;

    public User(long id, String name, int age, String country) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.country = country;
    }
}
