package com.mycompany.hbase;

import com.mycompany.hbase.dao.HbaseDAO;

import java.io.IOException;


public class App 
{
    public static void main( String[] args )
    {


        HbaseDAO hbaseDAO = new HbaseDAO();
        try{
            //hbaseDAO.createTable("Employee", new String[]{"personal", "professional"});
            hbaseDAO.insertData("Employee", "1", "personal", "name", "Anuj");
            //hbaseDAO.insertData("Employee", "1", "professional", "designation", "Engineer");
        } catch (IOException e){
            System.err.println("Error Creating Table:" + e.getMessage());
            e.printStackTrace();
        }

    }
}
