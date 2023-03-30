package com.codecool.marsexploration.controller.jdbc;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.datacontroller.DataPresenter;

import java.sql.*;

public class OutcomeTableManager implements JDBCManager{
    Connection connection;
    DataPresenter dataPresenter;
    Context context;

    public OutcomeTableManager(Connection connection, DataPresenter presenter) {
        this.connection = connection;
        this.dataPresenter = presenter;
        this.context = presenter.presentContext();
    }

    @Override
    public void createTable() {
        try {
            Statement statement = connection.createStatement();
            String tableCreationQuery = "CREATE TABLE OUTCOME(" +
                    "MISSION_ID SERIAL," +
                    "STEPS INT NOT NULL," +
                    "UNIT VARCHAR (80) NOT NULL," +
                    "OUTCOME VARCHAR (80) NOT NULL" +
                    ")";

            statement.execute( tableCreationQuery );
            System.out.println( "Outcome table successfully created" );
        } catch (Exception e) {
            throw new RuntimeException( e );
        }
    }

    @Override
    public void insertDataIntoTable() {
        PreparedStatement preparedStatement = null;
        String SQL = "INSERT INTO outcome (steps, unit, outcome) " +
                "VALUES (?, ?, ?)";
        try {
            if (context.getExplorationOutcome().isPresent()) {
                preparedStatement = connection.prepareStatement( SQL );
                preparedStatement.setInt( 1, context.getStepNumber() );
                preparedStatement.setString( 2, context.getRover().getId() );
                preparedStatement.setString( 3, context.getExplorationOutcome().get().name() );
                preparedStatement.executeUpdate();
                System.out.println( "Data successfully added to outcome table" );
            } else {
                System.out.println( "No outcome" );
            }
        } catch (SQLException e) {
            throw new RuntimeException( e );
        }
    }
}
