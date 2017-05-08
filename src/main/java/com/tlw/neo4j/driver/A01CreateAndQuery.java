package com.tlw.neo4j.driver;

import org.neo4j.driver.v1.*;

import static org.neo4j.driver.v1.Values.parameters;

/**
 * Created by 唐力伟 on 2017/5/7 7:53.
 */
public class A01CreateAndQuery implements Constant {
    public static void main(String[] args){
       Driver driver = GraphDatabase.driver(NEO4J_URL, AuthTokens.basic( USERNAME, PASSWORD ) );
        Session session = driver.session();

        session.run( "CREATE (a:Person {name: {name}, title: {title}})",
                parameters( "name", "Arthur", "title", "King" ) );

        StatementResult result = session.run( "MATCH (a:Person) WHERE a.name = {name} " +
                        "RETURN a.name AS name, a.title AS title",
                parameters( "name", "Arthur" ) );
        while ( result.hasNext() )
        {
            Record record = result.next();
            System.out.println( record.get( "title" ).asString() + " " + record.get( "name" ).asString() );
        }

        session.close();
        driver.close();
    }
}
