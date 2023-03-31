package com.codecool.marsexploration.controller.jdbc;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.datacontroller.DataPresenter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MapTableManager implements JDBCManager {
    Connection connection;
    DataPresenter dataPresenter;
    Context context;

    public MapTableManager(Connection connection, DataPresenter dataPresenter) {
        this.connection = connection;
        this.dataPresenter = dataPresenter;
        this.context = dataPresenter.presentContext();
    }

    @Override
    public void createTable() {
        try {
            Statement statement = connection.createStatement();
            String tableCreationQuery = "CREATE TABLE map_list(" +
                    "MISSION_ID SERIAL," +
                    "PATH VARCHAR (80) NOT NULL," +
                    "MAP_NAME VARCHAR (30) NOT NULL" +
                    ")";

            statement.execute( tableCreationQuery );
            System.out.println( "Maplist table successfully created" );
        } catch (Exception e) {
            throw new RuntimeException( e );
        }
    }

    @Override
    public void insertDataIntoTable() {
        PreparedStatement preparedStatement = null;
        String SQL = "INSERT INTO map_list (map_name, path) " +
                "VALUES (?, ?)";
        try {
            String path = dataPresenter.getInput().mapPath();
            preparedStatement = connection.prepareStatement( SQL );
            preparedStatement.setString( 1, getPathWithoutFileName(path , 3 ) );
            preparedStatement.setString( 2, getFileName( path, 3) );
            preparedStatement.executeUpdate();
            System.out.println( "Data successfully added to maplist table" );
        } catch (SQLException e) {
            throw new RuntimeException( e );
        }
    }

    public String getPathWithoutFileName(String path, int n) {
        return splitString( path, n, true );
    }

    public String getFileName(String path, int n) {
        return splitString( path, n, false );
    }

    public String splitString(String path, int n, boolean returnPath) {
        String result = "";
        int startingPoint = 0;
        int slashCtn = 0;
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt( i ) == '/') {
                slashCtn++;
                if (slashCtn == n) {
                    if (!returnPath) {
                        result = path.substring( startingPoint, i + 1 );
                    } else {
                        result = path.substring( i + 1 );
                    }
                }
            }
        }
        return result;
    }
}
