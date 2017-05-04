# spring-data-neo4j step by step

1. download: neo4j database neo4j-community-3.0.4-windows.zip.

2. install: use administrator command line.

        cd bin
        neo4j install-service
        neo4j start

3. validate: visit neo4j console site.

        http://127.0.0.1:7474/browser/

4. project: create maven project with dependencies.

        spring-boot-starter-web
        spring-data-neo4j

5. coding: The code needs to be changed in Person.known():

        public void knows(Person friend) {
            if(friends == null){
                friends = new LinkedHashSet<Person>();
            }
            friends.add(friend);
        }

6. config: make resource file ogm.properties with content.

        driver=org.neo4j.ogm.drivers.http.driver.HttpDriver
        URI=http://neo4j:111111Sese@localhost:7474

7. run: ...