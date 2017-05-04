package com.tlw.neo4j.person.service;

import com.tlw.neo4j.person.domain.Person;
import com.tlw.neo4j.person.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tlw@winning.com.cn on 2017/5/4.
 */
@Service
public class MyService {

    @Autowired
    private PersonRepository repository;

    @Transactional
    public void doWork() {

        Person jon = new Person("Jon");
        Person emil = new Person("Emil");
        Person rod = new Person("Rod");

        emil.knows(jon);
        emil.knows(rod);

        // Persist entities and relationships to graph database
        repository.save(emil);

//        for (Person friend : emil.getFriends()) {
//            System.out.println("Friend: " + friend);
//        }

//        // Control loading depth
//        Person thatSamejon = repository.findOne(id, 2);
//        for (Person friend : jon.getFriends()) {
//            System.out.println("Jon's friends to depth 2: " + friend);
//        }
    }
}