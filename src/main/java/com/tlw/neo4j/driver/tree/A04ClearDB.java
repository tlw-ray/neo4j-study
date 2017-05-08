package com.tlw.neo4j.driver.tree;

import org.neo4j.driver.v1.*;

import static com.tlw.neo4j.driver.Constant.NEO4J_URL;
import static com.tlw.neo4j.driver.Constant.PASSWORD;
import static com.tlw.neo4j.driver.Constant.USERNAME;

/**
 * Created by 唐力伟 on 2017/5/7 13:41.
 */
public class A04ClearDB {
    public static void main(String[] args){
        Driver driver = GraphDatabase.driver(NEO4J_URL, AuthTokens.basic(USERNAME, PASSWORD));
        try(Session session = driver.session()) {
            long start = System.currentTimeMillis();
            try (Transaction tx = session.beginTransaction()) {
                tx.run("match ()-[r:Parent]-() delete r");
                tx.run("match (n:TreeNode) delete n");
                tx.success();
            }
            System.out.println("spend: " + (System.currentTimeMillis() - start));
        }

    }
}
