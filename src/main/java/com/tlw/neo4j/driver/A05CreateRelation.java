package com.tlw.neo4j.driver;

import org.neo4j.driver.v1.*;

/**
 * Created by 唐力伟 on 2017/5/7 10:42.
 */
public class A05CreateRelation implements Constant {
    public static void main(String[] args){
        Driver driver = GraphDatabase.driver(NEO4J_URL, AuthTokens.basic(USERNAME, PASSWORD));
        try( Transaction tx = driver.session().beginTransaction()){
            String script = "CREATE (node0:MyNode {name:'node0'}) \n"
                    + "CREATE (node1:MyNode {name:'node1'}) \n"
                    + "CREATE (node2:MyNode {name:'node2'})"
                    + "CREATE \n"
                    + "\t(node0)<-[:Parent]-(node1),\n"
                    + "\t(node0)<-[:Parent]-(node2)";
            tx.run(script);
            tx.success();
        }
    }
}
