package com.tlw.neo4j.ogm.tree.domain;

/**
 * Created by 唐力伟 on 2017/5/5 22:48.
 */
public class Entity {

    Long id;
    String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
