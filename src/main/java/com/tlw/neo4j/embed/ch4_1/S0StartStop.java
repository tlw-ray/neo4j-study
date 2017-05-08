package com.tlw.neo4j.embed.ch4_1;

import com.tlw.neo4j.embed.Constant;
import com.tlw.neo4j.embed.Neo4jUtil;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.factory.GraphDatabaseFactory;

import java.io.File;

/**
 * Created by tlw@winning.com.cn on 2017/5/5.
 * 启动neo4j
 * 设定数据库参数
 * 注册jvm退出时回调停止neo4j
 * 停止neo4j
 */
public class S0StartStop {
    public static void main(String[] args){
        GraphDatabaseService graphDb = new GraphDatabaseFactory()
                .newEmbeddedDatabase(new File(Constant.DB_PATH));
        Neo4jUtil.registerShutdownHook( graphDb );
    }
}
