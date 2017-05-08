package com.tlw.neo4j.ogm.teach.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tlw@winning.com.cn on 2017/5/5.
 */
@NodeEntity
public class Teacher extends Entity{

    @Relationship(type="TEACH")
    private Set<Student> teachs;

    public void addTeach(Student student){
        if(teachs == null){
            teachs = new HashSet();
        }
        teachs.add(student);
    }
}
