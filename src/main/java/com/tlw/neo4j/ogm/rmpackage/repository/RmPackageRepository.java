package com.tlw.neo4j.ogm.rmpackage.repository;

import com.tlw.neo4j.ogm.rmpackage.domain.RmPackage;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 唐力伟 on 2017/5/4 20:11.
 */
@Repository
public interface RmPackageRepository extends Neo4jRepository<RmPackage, Long> {
}
