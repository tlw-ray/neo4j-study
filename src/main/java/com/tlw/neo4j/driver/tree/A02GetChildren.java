package com.tlw.neo4j.driver.tree;

import org.neo4j.driver.v1.*;

import static com.tlw.neo4j.driver.Constant.*;

/**
 * Created by 唐力伟 on 2017/5/7 12:45.
 */
public class A02GetChildren {
    public static void main(String[] args){
//        getChildren(24270);
        getChildren("Node_2_1");
    }

    public static void getChildren(int id){
        Driver driver = GraphDatabase.driver(NEO4J_URL, AuthTokens.basic(USERNAME, PASSWORD));
        StatementResult result = null;
        try(Session session = driver.session()) {
            long start = System.currentTimeMillis();
            try (Transaction tx = session.beginTransaction()) {
                result = tx.run("match (n:TreeNode)-[:Parent]-(m) where ID(n)={id} return m", Values.parameters("id", id));
                tx.success();
            }
            System.out.println("spend: " + (System.currentTimeMillis() - start));
        }

        print(result);

    }

    public static void getChildren(String name){
        long start = System.currentTimeMillis();
        Driver driver = GraphDatabase.driver(NEO4J_URL, AuthTokens.basic(USERNAME, PASSWORD));
        StatementResult result = null;
        try(Session session = driver.session()) {
            try (Transaction tx = session.beginTransaction()) {
                result = tx.run("match (n:TreeNode)-[:Parent]-(m) where n.name={name} return m", Values.parameters("name", name));
                tx.success();
            }
            System.out.println("spend: " + (System.currentTimeMillis() - start));
        }

        print(result);

    }

    private static void print(StatementResult result) {
        if(result != null){
            while(result.hasNext()){
                System.out.println(result.next());
            }
        }
    }
}
