package com.tlw.neo4j.embed;

import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by tlw@winning.com.cn on 2017/5/5.
 */
public class Ch4_4_1_2FindById implements Constant{
    public static void main(String[] args){
        GraphDatabaseService graphDb = new GraphDatabaseFactory()
                .newEmbeddedDatabase(new File(Constant.DB_PATH));
        Neo4jUtil.registerShutdownHook( graphDb );

        long start = System.currentTimeMillis();
        Label label = Label.label( USER_INDEXED_LABEL );
        int idToFind = 45;
        String nameToFind = Constant.getUserName(idToFind);
        try ( Transaction tx = graphDb.beginTx() )
        {
            try ( ResourceIterator<Node> users = graphDb.findNodes( label, USER_NAME_PROPERTIES, nameToFind ) )
            {
                while(users.hasNext()){
                    Node node = users.next();
                    System.out.println("The username of user " + idToFind + " is " + node.getProperty( USER_NAME_PROPERTIES ) );
                }
            }
            tx.success();
        }
        System.out.println("spend: " + (System.currentTimeMillis() - start) + "ms");
    }
}
