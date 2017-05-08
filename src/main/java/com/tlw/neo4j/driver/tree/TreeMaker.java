package com.tlw.neo4j.driver.tree;

/**
 * Created by 唐力伟 on 2017/5/7 9:35.
 */
public class TreeMaker {

    public static void main(String[] args){
        TreeMaker treeMaker = new TreeMaker();
        treeMaker.makeTree();
    }

    String baseName = "Node";
    final int width = 5;
    final int deep = 8;

    int nodeCount = 1;
    int relationCount = 0;

    public void makeTree(){
        createNode(baseName);
        makeTree(baseName, 2);
    }

    private void makeTree(String parentName, int currentDeep){
        for(int i=0;i<getWidth();i++){
            String nodeName = parentName + "_" + i;
            createNode(nodeName);
            createRelation(parentName, nodeName);
            if(currentDeep < getDeep()){
                makeTree(nodeName, currentDeep + 1);
            }
        }
    }

    public void createNode(String nodeName){
        System.out.println( (nodeCount++) + "\t" + nodeName);
    }
    public void createRelation(String parentName, String nodeName){
        System.out.println((relationCount++) + "\t" + parentName + " - " + nodeName);
    }
    public int getWidth(){
        return width;
    }

    public int getDeep(){
        return deep;
    }
}
