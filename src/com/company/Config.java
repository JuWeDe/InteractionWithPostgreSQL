package com.company;

public class Config {
    private final String DB_USERNAME = "postgres";
    private final String DB_PASSWORD = "postgres";
    private final String DB_URL = "jdbc:postgresql://localhost:5432/newone";

    public Config() {
    }

    public String getDB_URL() {
        return DB_URL;
    }

    public String getDB_USERNAME() {
        return DB_USERNAME;
    }

    public String getDB_PASSWORD() {
        return DB_PASSWORD;
    }
}
