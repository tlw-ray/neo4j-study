package com.tlw.neo4j.driver;

import org.neo4j.driver.v1.*;

import static org.neo4j.driver.v1.Values.parameters;

/**
 * Created by 唐力伟 on 2017/5/7 7:56.
 */
public class A02HelloWorldExample implements AutoCloseable, Constant
{
    private final Driver driver;

    public A02HelloWorldExample(String uri, String user, String password )
    {
        driver = GraphDatabase.driver( uri, AuthTokens.basic( user, password ) );
    }

    @Override
    public void close() throws Exception
    {
        driver.close();
    }

    public void printGreeting( final String message )
    {
        try ( Session session = driver.session() )
        {
            String greeting = session.writeTransaction( new TransactionWork<String>()
            {
                @Override
                public String execute( Transaction tx )
                {
                    StatementResult result = tx.run( "CREATE (a:Greeting) " +
                                    "SET a.message = $message " +
                                    "RETURN a.message + ', from node ' + id(a)",
                            parameters( "message", message ) );
                    return result.single().get( 0 ).asString();
                }
            } );
            System.out.println( greeting );
        }
    }

    public static void main( String... args ) throws Exception
    {
        try ( A02HelloWorldExample greeter = new A02HelloWorldExample(NEO4J_URL, USERNAME, PASSWORD ) )
        {
            greeter.printGreeting( "hello, world" );
        }
    }
}
