package com.codecool.marsexploration.controller.jdbc;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.datacontroller.DataPresenter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MapTableManager implements JDBCManager{
    Connection connection;
    DataPresenter dataPresenter;
    Context context;

    public MapTableManager(Connection connection, DataPresenter dataPresenter, Context context) {
        this.connection = connection;
        this.dataPresenter = dataPresenter;
        this.context = context;
    }

    @Override
    public void createTable() {
        try {
            Statement statement = connection.createStatement();
            String tableCreationQuery = "CREATE TABLE MAPLIST(" +
                    "MISSION_ID SERIAL," +
                    "MAP_NAME VARCHAR (30) NOT NULL," +
                    "PATH VARCHAR (80) NOT NULL," +
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
        String SQL = "INSERT INTO maplist (map_name, path) " +
                "VALUES (?, ?)";
        try {
                preparedStatement = connection.prepareStatement( SQL );
                preparedStatement.setString( 1,"sdsd");
                preparedStatement.setString( 2, "jksjdkjf" );
                preparedStatement.executeUpdate();
                System.out.println( "Data successfully added to maplist table" );
        } catch (SQLException e) {
            throw new RuntimeException( e );
        }
    }

    public String getPathWithoutFileName(String path, int n) {
        int startingPoint = 0;
        int slashCtn = 0;
        String newPath = "";
        for (int i = 0; i < path.length(); i++) {
            if(path.charAt( i ) == '/') {
                slashCtn++;
                if(slashCtn == n) {
                    newPath = path.substring( startingPoint, i + 1 );
                }
            }
        }
        return newPath;
    }

    public String getFileName(String path, int n) {
        String name = "";
        int slashCtn = 0;
        for (int i = 0; i < path.length(); i++) {
            if(path.charAt( i ) == '/') {
                slashCtn++;
                if(slashCtn == n) {
                    name = path.substring( i + 1, path.length());
                }
            }
        }
        return name;
    }
}
