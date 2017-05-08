package com.tlw.neo4j.ogm.tree;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by 唐力伟 on 2017/5/5 23:47.
 */
@SpringBootApplication
@EnableNeo4jRepositories(basePackages = "com.tlw.neo4j.ogm.tree.repository")
@EnableTransactionManagement
public class TreeApp {
    @Bean
    public SessionFactory sessionFactory() {
        // with domain entity base package(s)
        return new SessionFactory("com.tlw.neo4j.ogm.tree.domain");
    }

    @Bean
    public Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }

    public static void main(String[] args){
        SpringApplication.run(TreeApp.class, args);
    }
}
