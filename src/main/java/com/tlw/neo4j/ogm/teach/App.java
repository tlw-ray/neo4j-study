package com.tlw.neo4j.ogm.teach;

import com.tlw.neo4j.ogm.person.service.MyService;
import com.tlw.neo4j.ogm.teach.service.InitDataService;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by tlw@winning.com.cn on 2017/5/5.
 */
@Configuration
@ComponentScan(basePackages = "com.tlw.neo4j.ogm.teach")
@EnableNeo4jRepositories(basePackages = "com.tlw.neo4j.ogm.teach.repository")
@EnableTransactionManagement
public class App {
    @Bean
    public SessionFactory sessionFactory() {
        // with domain entity base package(s)
        return new SessionFactory("com.tlw.neo4j.ogm.teach.domain");
    }

    @Bean
    public Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        InitDataService service = context.getBean(InitDataService.class);
        service.initByTeach();
    }
}
