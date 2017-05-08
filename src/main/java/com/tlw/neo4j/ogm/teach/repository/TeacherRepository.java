package com.tlw.neo4j.ogm.teach.repository;

import com.tlw.neo4j.ogm.teach.domain.Teacher;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tlw@winning.com.cn on 2017/5/5.
 */
@Repository
public interface TeacherRepository extends Neo4jRepository<Teacher, Long>{
}
