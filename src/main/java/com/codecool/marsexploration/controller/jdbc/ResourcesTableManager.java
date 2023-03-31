package com.codecool.marsexploration.controller.jdbc;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.datacontroller.DataPresenter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ResourcesTableManager implements JDBCManager {
    Connection connection;
    DataPresenter dataPresenter;
    Context context;

    public ResourcesTableManager(Connection connection, DataPresenter dataPresenter) {
        this.connection = connection;
        this.dataPresenter = dataPresenter;
        this.context = dataPresenter.presentContext();
    }

    @Override
    public void createTable() {
        try {
            Statement statement = connection.createStatement();
            String tableCreationQuery = "CREATE TABLE resource_list(" +
                    "TYPE VARCHAR (20) NOT NULL," +
                    "NUMBER INT NOT NULL," +
                    "FOUND_BY VARCHAR (20) NOT NULL" +
                    ")";

            statement.execute( tableCreationQuery );
            System.out.println( "Resources table successfully created" );
        } catch (Exception e) {
            throw new RuntimeException( e );
        }
    }

    @Override
    public void insertDataIntoTable() {
        PreparedStatement preparedStatement = null;
        String SQL = "INSERT INTO resource_list (type, number, found_by) " +
                "VALUES (?, ?, ?), (?, ?, ?)";
        try {
            preparedStatement = connection.prepareStatement( SQL );
            preparedStatement.setString( 1, "Water" );
            preparedStatement.setInt( 2, context.getRover().getObjectCollector().waterList().size() );
            preparedStatement.setString( 3, context.getRover().getId() );
            preparedStatement.setString( 4, "Mineral" );
            preparedStatement.setInt( 5, context.getRover().getObjectCollector().mineralList().size() );
            preparedStatement.setString( 6, context.getRover().getId() );
            preparedStatement.executeUpdate();
            System.out.println( "Data successfully added to resource list table" );
        } catch (SQLException e) {
            throw new RuntimeException( e );
        }
    }
}
