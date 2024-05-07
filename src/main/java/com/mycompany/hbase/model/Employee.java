package com.mycompany.hbase.model;

public class Employee {
    private String key;
    private String value;

    public Employee(){}

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
