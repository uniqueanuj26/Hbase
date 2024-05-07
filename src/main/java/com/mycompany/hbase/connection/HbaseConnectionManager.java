package com.mycompany.hbase.connection;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.ConnectionFactory;

import javax.imageio.IIOException;
import java.io.IOException;

public class HbaseConnectionManager {
    private static Configuration configuration;
    private static Connection connection;

    static {
        configuration = HBaseConfiguration.create();
        try {
            connection = ConnectionFactory.createConnection(configuration);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        return connection;
    }
}
