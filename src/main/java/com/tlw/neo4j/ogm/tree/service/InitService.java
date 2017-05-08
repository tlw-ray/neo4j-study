package com.tlw.neo4j.ogm.tree.service;

import com.tlw.neo4j.ogm.tree.domain.TreeNode;
import com.tlw.neo4j.ogm.tree.repository.TreeNodeRepository;
import org.neo4j.ogm.annotation.Transient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 唐力伟 on 2017/5/5 22:52.
 */
@Service
public class InitService {

    final int width = 3;

    @Autowired
    TreeNodeRepository repository;

    @Transient
    public void makeTree(){
        System.out.println("root");
        TreeNode treeNode = new TreeNode();
        treeNode.setName("Node");
        makeTree(treeNode, 2);
        repository.save(treeNode);
    }
    private void makeTree(TreeNode parent, int deep){
        for(int i=0;i<width;i++){
            TreeNode treeNode = new TreeNode();
            treeNode.setName(parent.getName() + "_" + i);
            parent.addChild(treeNode);
            System.out.println(treeNode.getName());
            if(deep > 0){
                makeTree(treeNode, deep - 1);
            }
        }
    }
}
