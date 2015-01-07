package com.gov.nc.utils;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;

import java.net.UnknownHostException;
/**
 * Class Name : [MongoDBUtil]<br/>
 * Description: supply a static method to get DBCollection object, use singleton design to make sure
 * there is only one DBCollection object. you can use <code>MongoDBUtil.getColl()</code> to get one.<br>
 * Author: Vincent<br/>
 * CreateTime:2014/12/17.<br/>
 * Version V 1.0.0
 */
public class MongoDBUtil {

    private static Log log = LogFactory.getLog(MongoDBUtil.class);
    private static LoadProperties properties = new LoadProperties("/config.properties");
    private static String host = properties.getValue("mongo.host");
    private static int port = Integer.parseInt(properties.getValue("mongo.port"));
    private static String logDB = properties.getValue("mongo.logDB");
    /**
     * client object
     */
    private static Mongo client;


    /**
     * 链接MongoDB
     * @throws java.net.UnknownHostException
     */
    static {
        try {
            client = new MongoClient(host, port);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            log.debug(e);
        }
    }


    public static Mongo getClient() {
        return client;
    }

    public static DB getDB(String dbName) {
        return client.getDB(dbName);
    }


    public static DB getLogDB() {
        return getDB(logDB);
    }

    public static DBCollection getCollection(String dbName, String collectionName) {
        return getDB(dbName).getCollection(collectionName);
    }

    public static DBCollection getSysLogCollection() {
        return getLogDB().getCollection("system_log");
    }


}
