package com.tlw.neo4j.driver.tree;

import org.neo4j.driver.v1.*;

import static com.tlw.neo4j.driver.Constant.*;

/**
 * Created by 唐力伟 on 2017/5/7 13:11.
 */
public class A03DBSize {
    public static void main(String[] args){
        Driver driver = GraphDatabase.driver(NEO4J_URL, AuthTokens.basic(USERNAME, PASSWORD));
        StatementResult result = null;
        try(Session session = driver.session()) {
            long start = System.currentTimeMillis();
            try (Transaction tx = session.beginTransaction()) {
                result = tx.run("match (n:TreeNode) return count(n)");
                System.out.println("TreeNode: " + result.single());

                result = tx.run("match ()-[r:Parent]-() return count(r)");
                System.out.println("Parent: " + result.single());
                tx.success();
            }
            System.out.println("spend: " + (System.currentTimeMillis() - start));
        }
    }
}
