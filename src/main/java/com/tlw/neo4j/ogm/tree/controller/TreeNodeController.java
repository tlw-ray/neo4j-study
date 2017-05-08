package com.tlw.neo4j.ogm.tree.controller;

import com.tlw.neo4j.ogm.tree.domain.TreeNode;
import com.tlw.neo4j.ogm.tree.repository.TreeNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created by 唐力伟 on 2017/5/5 23:48.
 */
@RestController
public class TreeNodeController {

    @Autowired
    TreeNodeRepository repository;

    @RequestMapping("/getChildren/{id}")
    public Set<TreeNode> getChildren(@PathVariable long id){
        TreeNode treeNode = repository.findOne(id);
        if(treeNode == null){
            return null;
        }else{
            return treeNode.getChildren();
        }
    }
}
