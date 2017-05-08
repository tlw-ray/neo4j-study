package com.tlw.neo4j.ogm.teach.service;

import com.tlw.neo4j.ogm.teach.domain.LearnRelation;
import com.tlw.neo4j.ogm.teach.domain.Student;
import com.tlw.neo4j.ogm.teach.domain.Teacher;
import com.tlw.neo4j.ogm.teach.repository.LearnRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by tlw@winning.com.cn on 2017/5/5.
 */
@Service
public class InitDataService {

    @Autowired
    LearnRelationRepository repository;

    @Transactional
    public void initByTeach(){
        Student student = new Student();
        student.setName("S1");
        Teacher teacher = new Teacher();
        teacher.setName("T1");
        LearnRelation learnRelation = new LearnRelation();
        learnRelation.setStudent(student);
        learnRelation.setTeacher(teacher);
        learnRelation.setName("English");
        repository.save(learnRelation);
    }

}
