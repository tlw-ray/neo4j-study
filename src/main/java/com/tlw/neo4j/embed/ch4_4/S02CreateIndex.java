package com.tlw.neo4j.embed.ch4_4;

import com.tlw.neo4j.embed.Constant;
import com.tlw.neo4j.embed.Neo4jUtil;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Label;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.schema.IndexDefinition;
import org.neo4j.graphdb.schema.Schema;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by tlw@winning.com.cn on 2017/5/5.
 * 创建索引
 */
public class S02CreateIndex implements Constant {
    public static void main(String[] args){
        GraphDatabaseService graphDb = new GraphDatabaseFactory()
                .newEmbeddedDatabase(new File(Constant.DB_PATH));
        Neo4jUtil.registerShutdownHook( graphDb );

        long start = System.currentTimeMillis();
        try ( Transaction tx = graphDb.beginTx() )
        {
            Schema schema = graphDb.schema();
            IndexDefinition indexDefinition = schema.indexFor( Label.label( USER_INDEXED_LABEL ) )
                    .on( USER_NAME_PROPERTIES )
                    .create();
            //阻塞等待索引创建成功
            schema.awaitIndexOnline( indexDefinition, 10, TimeUnit.SECONDS );
            tx.success();
        }
        System.out.println("spend: " + (System.currentTimeMillis() - start) + "ms");
    }
}
