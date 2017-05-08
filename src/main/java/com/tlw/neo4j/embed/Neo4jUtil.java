package com.tlw.neo4j.embed;

import org.neo4j.graphdb.GraphDatabaseService;

/**
 * Created by tlw@winning.com.cn on 2017/5/5.
 */
public class Neo4jUtil {
    public static void registerShutdownHook( final GraphDatabaseService graphDb ) {
        // Registers a shutdown hook for the Neo4j instance so that it
        // shuts down nicely when the VM exits (even if you "Ctrl-C" the
        // running application).
        Runtime.getRuntime().addShutdownHook( new Thread()
        {
            @Override
            public void run()
            {
                graphDb.shutdown();
            }
        } );
    }
}
