package com.tlw.neo4j.person.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by tlw@winning.com.cn on 2017/5/4.
 */
@NodeEntity
public class Person {
    private Long id;
    private String name;

    @Relationship(type = "FRIEND", direction = "OUTGOING")
    private Set<Person> friends;

    public Person() {}
    public Person(String name) { this.name = name; }

    public void knows(Person friend) {
        if(friends == null){
            friends = new LinkedHashSet<Person>();
        }
        friends.add(friend);
    }
    public Set<Person> getFriends(){return friends;}
}