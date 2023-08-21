package com.example.itjobs.helper;

public class ParamConfig {
    private String operation;
    private String dbColumn;

    public ParamConfig(String operation, String dbColumn) {
        this.operation = operation;
        this.dbColumn = dbColumn;
    }

    public String getOperation() {
        return operation;
    }

    public String getDbColumn() {
        return dbColumn;
    }
}