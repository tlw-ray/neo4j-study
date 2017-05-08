package com.tlw.neo4j.ogm.rmpackage;

import com.tlw.neo4j.ogm.rmpackage.service.RmPackageService;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by 唐力伟 on 2017/5/4 20:10.
 */
@Configuration
@ComponentScan(basePackages = "com.tlw.neo4j.ogm.rmpackage")
@EnableNeo4jRepositories(basePackages = "com.tlw.neo4j.ogm.rmpackage.repository")
@EnableTransactionManagement
public class App {
    @Bean
    public SessionFactory sessionFactory() {
        // with domain entity base package(s)
        return new SessionFactory("com.tlw.neo4j.ogm.rmpackage.domain");
    }

    @Bean
    public Neo4jTransactionManager transactionManager() {
        return new Neo4jTransactionManager(sessionFactory());
    }

    public static void main(String[] args){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(App.class);
        RmPackageService service = context.getBean(RmPackageService.class);
        service.createRmPackages();
    }
}
