package com.tlw.neo4j.person.repository;

import com.tlw.neo4j.person.domain.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tlw@winning.com.cn on 2017/5/4.
 */
@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long> {

    List<Person> findByName(String name);

    List<Person> findByNameLike(String name);
}
