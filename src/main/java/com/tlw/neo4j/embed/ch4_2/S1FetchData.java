package com.tlw.neo4j.embed.ch4_2;

import com.tlw.neo4j.embed.Constant;
import com.tlw.neo4j.embed.Neo4jUtil;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;

/**
 * Created by tlw@winning.com.cn on 2017/5/5.
 */
public class S1FetchData {
    public static void main(String[] args) {
        GraphDatabaseService graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(new File(Constant.DB_PATH));
        Neo4jUtil.registerShutdownHook(graphDb);

        try (Transaction tx = graphDb.beginTx()) {

            graphDb.getAllNodes().forEach(n->System.out.println("node:" + n.getId() + "\tmessage: " + n.getProperty("message")));
            graphDb.getAllRelationships().forEach(r->System.out.print("relation:" + r.getId() + "\tmessage: " + r.getProperty( "message" )));

            // Database operations go here
            tx.success();
        }
    }
}
