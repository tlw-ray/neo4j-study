package com.tlw.neo4j.ogm.tree.repository;

import com.tlw.neo4j.ogm.tree.domain.TreeNode;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 唐力伟 on 2017/5/5 22:52.
 */
@Repository
public interface TreeNodeRepository  extends Neo4jRepository<TreeNode, Long>{
}
