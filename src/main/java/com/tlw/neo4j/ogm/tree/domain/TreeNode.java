package com.tlw.neo4j.ogm.tree.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by 唐力伟 on 2017/5/5 22:47.
 */
@NodeEntity
public class TreeNode extends Entity{

    @Relationship(type = "has")
    Set<TreeNode> children;

    public void addChild(TreeNode treeNode){
        if(children == null){
            children = new LinkedHashSet();
        }
        children.add(treeNode);
    }

    public Set<TreeNode> getChildren(){
        return children;
    }

}
