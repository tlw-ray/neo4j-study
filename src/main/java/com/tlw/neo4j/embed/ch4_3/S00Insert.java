package com.tlw.neo4j.embed.ch4_3;

import com.tlw.neo4j.embed.Constant;
import com.tlw.neo4j.embed.Neo4jUtil;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;

/**
 * Created by tlw@winning.com.cn on 2017/5/5.
 */
public class S00Insert implements Constant {
    public static void main(String[] args){
        GraphDatabaseService graphDb = new GraphDatabaseFactory()
                .newEmbeddedDatabase(new File(DB_PATH));
        Neo4jUtil.registerShutdownHook( graphDb );

        long start = System.currentTimeMillis();
        try ( Transaction tx = graphDb.beginTx() )
        {
            Label label = Label.label( USER_LABEL );

            // Create some users
            for ( int id = 0; id < USER_COUNT; id++ )
            {
                Node userNode = graphDb.createNode( label );
                userNode.setProperty( USER_NAME_PROPERTIES, Constant.getUserName(id) );
            }
            tx.success();
        }
        System.out.println("spend: " + (System.currentTimeMillis() - start) + "ms");
    }
}
