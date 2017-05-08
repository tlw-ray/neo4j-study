package com.tlw.neo4j.ogm.rmpackage.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by 唐力伟 on 2017/5/4 20:10.
 */
@NodeEntity
public class RmPackage {

    private Long id;
    private String name;
    @Relationship(type = "has")
    private Set<RmPackage> children;


    public void setName(String name) {
        this.name = name;
    }

    public void add(RmPackage rmpackage){
        if(children==null){
            children = new LinkedHashSet<RmPackage>();
        }
        children.add(rmpackage);
    }
}
