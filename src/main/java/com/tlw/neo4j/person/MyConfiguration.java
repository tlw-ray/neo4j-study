package com.tlw.neo4j.person;

import com.tlw.neo4j.person.repository.PersonRepository;
import com.tlw.neo4j.person.service.MyService;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by tlw@winning.com.cn on 2017/5/4.
 */
@Configuration
@ComponentScan(basePackages = "com.tlw.neo4j.person")
@EnableNeo4jRepositories(basePackages = "com.tlw.neo4j.person.repository")
@EnableTransactionManagement
public class MyConfiguration {

    @Bean
    public SessionFactory sessionFactory() {
        // with domain entity base package(s)
        return new SessionFactory("com.tlw.neo4j.person.domain");
    }

    @Bean
    public Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfiguration.class);
        MyService myService = context.getBean(MyService.class);
        myService.doWork();
    }
}
