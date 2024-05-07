package com.mycompany.hbase.dao;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;
import java.util.Arrays;
import java.util.stream.Collectors;

import static com.mycompany.hbase.connection.HbaseConnectionManager.getConnection;

public class HbaseDAO {
    public void createTable(String tableName, String[] columnFamilies) throws IOException{
        try (Connection connection = getConnection();
             Admin admin = connection.getAdmin()) {

            TableName hTableName = TableName.valueOf(tableName);
            if(!admin.tableExists(hTableName)){
                TableDescriptor tableDescriptor = TableDescriptorBuilder.newBuilder(hTableName)
                        .setColumnFamilies(Arrays.stream(columnFamilies)
                                .map(cf -> ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes(cf)).build())
                                .collect(Collectors.toList()))
                        .build();
                admin.createTable(tableDescriptor);
                System.out.println("Table Created Successfully");
            }else{
                System.out.println("Table already exist");
            }

        }

    }

    public void insertData(String tableName, String rowKey, String columnFamily, String qualifier, String value) throws IOException {
        try (Connection connection = getConnection();
             Table table = connection.getTable(TableName.valueOf(tableName))) {

            Put put = new Put(rowKey.getBytes());
            put.addColumn(columnFamily.getBytes(), qualifier.getBytes(), value.getBytes());
            table.put(put);
            System.out.println("Data inserted successfully.");
        }
    }

}
