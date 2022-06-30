package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DBHandler {
    Config config = new Config();
    Connection connection;

    {
        try {
            connection = DriverManager.getConnection(config.getDB_URL(), config.getDB_USERNAME(), config.getDB_PASSWORD());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void InsertEmployer (EmployesInfo employesInfo) throws SQLException {


    }

}


