package com.tlw.neo4j.embed.ch4_3;

import com.tlw.neo4j.embed.Constant;
import com.tlw.neo4j.embed.Neo4jUtil;
import org.neo4j.graphdb.*;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;

/**
 * Created by tlw@winning.com.cn on 2017/5/5.
 */
public class S03FindById implements Constant{
    public static void main(String[] args){
        GraphDatabaseService graphDb = new GraphDatabaseFactory()
                .newEmbeddedDatabase(new File(Constant.DB_PATH));
        Neo4jUtil.registerShutdownHook( graphDb );

        long start = System.currentTimeMillis();
        Label label = Label.label( USER_LABEL );
        int idToFind = 10045;
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
