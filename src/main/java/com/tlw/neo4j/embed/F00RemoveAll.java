package com.tlw.neo4j.embed;

import com.tlw.neo4j.embed.Constant;
import com.tlw.neo4j.embed.Neo4jUtil;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;

/**
 * Created by tlw@winning.com.cn on 2017/5/5.
 */
public class F00RemoveAll {
    public static void main(String[] args){
        GraphDatabaseService graphDb = new GraphDatabaseFactory().newEmbeddedDatabase(new File(Constant.DB_PATH));
        Neo4jUtil.registerShutdownHook(graphDb);

        long start = System.currentTimeMillis();
        try ( Transaction tx = graphDb.beginTx() ) {
            //remove the data
            graphDb.getAllRelationships().forEach(r->r.delete());
            graphDb.getAllNodes().forEach(n->n.delete());

            // Database operations go here
            tx.success();
        }
        System.out.println("spend: " + (System.currentTimeMillis() - start) + "ms");
    }
}
