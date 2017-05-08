package com.tlw.neo4j.embed;

/**
 * Created by tlw@winning.com.cn on 2017/5/5.
 */
public interface Constant {
    String DB_PATH = "data";

    String USER_LABEL = "User";
    String USER_INDEXED_LABEL = "UserIndexed";

    String USER_NAME_PROPERTIES = "userName";

    int USER_COUNT = 10000;
    int USER_COUNT2 = 20000;

    static String getUserName(int id){
        return "user" + id + "@neo4j.org";
    }
}
