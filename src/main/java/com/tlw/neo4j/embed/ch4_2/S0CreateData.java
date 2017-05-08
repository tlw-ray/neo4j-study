package com.tlw.neo4j.embed.ch4_2;

import com.tlw.neo4j.embed.Constant;
import com.tlw.neo4j.embed.Neo4jUtil;
import com.tlw.neo4j.embed.RelTypes;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;

/**
 * Created by tlw@winning.com.cn on 2017/5/5.
 */
public class S0CreateData {
    public static void main(String[] args) {
        GraphDatabaseService graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(new File(Constant.DB_PATH));
        Neo4jUtil.registerShutdownHook(graphDb);

        try (Transaction tx = graphDb.beginTx()) {
            //1. create data
            Node firstNode = graphDb.createNode();
            firstNode.setProperty("message", "Hello, ");
            Node secondNode = graphDb.createNode();
            secondNode.setProperty("message", "World!");

            Relationship relationship = firstNode.createRelationshipTo(secondNode, RelTypes.KNOWS);
            relationship.setProperty("message", "brave Neo4j ");

            // Database operations go here
            tx.success();
        }
    }
}
