package com.tlw.neo4j.driver.tree;

import com.tlw.neo4j.driver.Constant;
import org.neo4j.driver.v1.*;

/**
 * Created by 唐力伟 on 2017/5/7 9:52.
 */
public class A01CreateTree extends TreeMaker implements Constant{
    public static void main(String[] args){
        A01CreateTree tree2DB = new A01CreateTree();
        tree2DB.writeToDB();
    }

    StringBuilder scriptBuilder;

    //构建创建树的脚本
    private void makeScript(){
        scriptBuilder = new StringBuilder();
        makeTree();
        System.out.println(scriptBuilder.toString());
    }

    //将创建脚本写入数据库
    public void writeToDB(){
        makeScript();
        Driver driver = GraphDatabase.driver(NEO4J_URL, AuthTokens.basic(USERNAME, PASSWORD));
        long start = System.currentTimeMillis();
        try(Session session = driver.session()) {
            try (Transaction tx = session.beginTransaction()) {
                tx.run(scriptBuilder.toString());
                tx.success();
            }
        }
        System.out.println("spend: " + (System.currentTimeMillis() - start));
    }

    @Override
    public void createNode(String nodeName) {
        scriptBuilder.append("CREATE (")
                .append(nodeName)
                .append(":TreeNode {name:'")
                .append(nodeName)
                .append("'})\n");
    }

    @Override
    public void createRelation(String parentName, String nodeName) {
        scriptBuilder.append("CREATE (")
                .append(parentName)
                .append(")<-[:Parent]-(")
                .append(nodeName)
                .append(")\n");
    }
}
