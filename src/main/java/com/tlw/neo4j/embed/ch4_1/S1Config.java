package com.tlw.neo4j.embed.ch4_1;

import com.tlw.neo4j.embed.Constant;
import com.tlw.neo4j.embed.Neo4jUtil;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;
import org.neo4j.graphdb.factory.GraphDatabaseSettings;

import java.io.File;

/**
 * Created by tlw@winning.com.cn on 2017/5/5.
 */
public class S1Config {
    public static void main(String[] args){
        GraphDatabaseService graphDb = new GraphDatabaseFactory()
                .newEmbeddedDatabaseBuilder(new File(Constant.DB_PATH))
                        .loadPropertiesFromFile( "conf/neo4j.conf" )
                .setConfig( GraphDatabaseSettings.pagecache_memory, "512M" )
                .setConfig( GraphDatabaseSettings.string_block_size, "60" )
                .setConfig( GraphDatabaseSettings.array_block_size, "300" )
                .setConfig( GraphDatabaseSettings.read_only, "true" )
                .newGraphDatabase();
        Neo4jUtil.registerShutdownHook(graphDb);
    }
}
