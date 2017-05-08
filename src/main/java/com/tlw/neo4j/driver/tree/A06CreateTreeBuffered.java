package com.tlw.neo4j.driver.tree;

import org.neo4j.driver.v1.*;

import static com.tlw.neo4j.driver.Constant.*;

/**
 * Created by 唐力伟 on 2017/5/7 14:02.
 * 发现单条语句创建节点会存在数量限制，采用带有缓存的方式来创建
 * 但发现整个结构是耦合的，
 */
public class A06CreateTreeBuffered{
    public static void main(String[] args){
        A06CreateTreeBuffered tree2DB = new A06CreateTreeBuffered();
        tree2DB.makeTree();
    }

    String getBaseName(){
        return "N";
    }

    int getWidth(){
        return 5;
    }

    int getDeep(){
        return 9;
    }

    Driver driver = GraphDatabase.driver(NEO4J_URL, AuthTokens.basic(USERNAME, PASSWORD));

    public void makeTree(){
        try(Session session = driver.session()){
            makeTree(null, 1, session);//2是起始深度
        }
    }

    private void makeTree(String parentName, int currentDeep, Session session){
        StringBuffer script = new StringBuffer();
        if(parentName == null){
            String nodeName = getBaseName();
            //创建根节点
            createNode(script, nodeName);

            commit(session, script);

            //迭代创建根节点的子节点
            makeTree(nodeName, currentDeep + 1, session);
        }else{

            //查询父节点
            queryParent(parentName, script);

            String[] nodeNames = new String[getWidth()];
            for(int i=0;i<getWidth();i++){
                String nodeName = parentName + "_" + i;
                nodeNames[i] = nodeName;
                //创建当前子节点
                createNode(script, nodeName);
                //创建当前子节点与父节点关系
                createRelation(script, parentName, nodeName);

            }

            commit(session, script);

            for(String nodeName:nodeNames){
                //迭代创建当前节点的子节点
                if(currentDeep < getDeep()){
                    makeTree(nodeName, currentDeep + 1, session);
                }
            }
        }

    }

    private void commit(Session session, StringBuffer script) {
        System.out.println(script.toString());
        System.out.println("-------");
        try (Transaction tx = session.beginTransaction()) {
            tx.run(script.toString());
            tx.success();
        }
    }

    private void queryParent(String parentName, StringBuffer script) {
        script.append("MATCH (")
            .append(parentName)
            .append(":TreeNode {name:'")
            .append(parentName)
            .append("'})")
            .append("\n");
    }

    public void createNode(StringBuffer script, String nodeName) {
        script.append("CREATE (")
                .append(nodeName)
                .append(":TreeNode {name:'")
                .append(nodeName)
                .append("'})\n");
    }

    public void createRelation(StringBuffer script, String parentName, String nodeName) {
        script.append("CREATE (")
                .append(parentName)
                .append(")<-[:Parent]-(")
                .append(nodeName)
                .append(")\n");
    }
}
