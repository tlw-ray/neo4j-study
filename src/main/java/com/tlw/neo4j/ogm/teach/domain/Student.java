package com.tlw.neo4j.ogm.teach.domain;

import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by tlw@winning.com.cn on 2017/5/5.
 */
@NodeEntity
public class Student extends Entity{

    @Relationship(type="LEARN")
    Set<Teacher> teachers;

    public void addLearn(Teacher teacher){
        if(teachers == null){
            teachers = new HashSet();
        }
        teachers.add(teacher);
    }

}
