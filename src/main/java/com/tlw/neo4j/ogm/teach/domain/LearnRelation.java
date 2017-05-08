package com.tlw.neo4j.ogm.teach.domain;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * Created by tlw@winning.com.cn on 2017/5/5.
 */
@RelationshipEntity(type="LEARN")
public class LearnRelation extends Entity{
    @StartNode
    Student student;
    @EndNode
    Teacher teacher;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
