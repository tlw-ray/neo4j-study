package com.tlw.neo4j.driver.tree;

import org.neo4j.driver.v1.*;

import static com.tlw.neo4j.driver.Constant.NEO4J_URL;
import static com.tlw.neo4j.driver.Constant.PASSWORD;
import static com.tlw.neo4j.driver.Constant.USERNAME;

/**
 * Created by 唐力伟 on 2017/5/7 13:54.
 * 批量创建太多数量的节点导致数据库内存崩溃，计划改为单条插入
 * 需要测量单条插入的基本耗时
 */
public class A05SingleRequest {
    public static void main(String[] args){
        Driver driver = GraphDatabase.driver(NEO4J_URL, AuthTokens.basic(USERNAME, PASSWORD));
        try(Session session = driver.session()) {
            long start = System.currentTimeMillis();
            try (Transaction tx = session.beginTransaction()) {

                tx.run("CREATE (:TreeNode{name:'p1'}), (:TreeNode{name:'p2'})");

                tx.success();
            }
            System.out.println("spend: " + (System.currentTimeMillis() - start));
        }
    }
}
