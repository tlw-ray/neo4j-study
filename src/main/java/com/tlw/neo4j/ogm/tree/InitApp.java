package com.tlw.neo4j.ogm.tree;

import com.tlw.neo4j.ogm.tree.service.InitService;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by 唐力伟 on 2017/5/5 22:52.
 */
@Configuration
@ComponentScan(basePackages = "com.tlw.neo4j.ogm.tree")
@EnableNeo4jRepositories(basePackages = "com.tlw.neo4j.ogm.tree.repository")
@EnableTransactionManagement
public class InitApp {

    @Bean
    public SessionFactory sessionFactory() {
        // with domain entity base package(s)
        System.out.println("sessionFactory...");
        return new SessionFactory("com.tlw.neo4j.ogm.tree.domain");
    }

    @Bean
    public Neo4jTransactionManager transactionManager() {
        System.out.println("Neo4jTransactionManager...");
        return new Neo4jTransactionManager(sessionFactory());
    }

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(InitApp.class);
        InitService initService = context.getBean(InitService.class);
        initService.makeTree();
    }


}
