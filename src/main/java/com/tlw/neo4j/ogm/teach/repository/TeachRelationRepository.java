package com.tlw.neo4j.ogm.teach.repository;

import com.tlw.neo4j.ogm.teach.domain.TeachRelation;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by tlw@winning.com.cn on 2017/5/5.
 */
@Repository
public interface TeachRelationRepository extends Neo4jRepository<TeachRelation, Long> {
}
