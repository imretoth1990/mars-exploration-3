package com.codecool.marsexploration.controller.jdbc;

import com.codecool.marsexploration.data.Context;
import com.codecool.marsexploration.data.datacontroller.DataPresenter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.sql.Connection;
import java.util.stream.Stream;

import static org.mockito.Mockito.mock;

class MapTableManagerTest {

    Connection connection = mock( Connection.class );
    DataPresenter dataPresenter = mock( DataPresenter.class );
    Context context = mock( Context.class );

    MapTableManager mapTableManager = new MapTableManager( connection, dataPresenter, context );

    @ParameterizedTest
    @MethodSource("provideStringsForPathTest1")
    void getPathWithoutFileNameTest1(String input, String expected, int n) {
        String result = mapTableManager.getPathWithoutFileName( input, n );
        Assertions.assertEquals( expected, result );
        System.out.println( result );
    }

    private static Stream<Arguments> provideStringsForPathTest1() {
        return Stream.of(
                Arguments.of( "src/main/resources/exploration-1.map", "src/main/resources/", 3 ),
                Arguments.of( "src/src/main/resources/exploration-1.map", "src/src/main/resources/", 4 ) );
    }

    @ParameterizedTest
    @MethodSource("provideStringsForNameTest1")
    void getFileNameTest1(String input, String expected, int n) {
        String result = mapTableManager.getFileName( input, n );
        Assertions.assertEquals( expected, result );
        System.out.println( result );
    }

    private static Stream<Arguments> provideStringsForNameTest1() {
        return Stream.of(
                Arguments.of( "src/main/resources/exploration-1.map", "exploration-1.map", 3 ),
                Arguments.of( "src/src/main/resources/exploration-1.map", "exploration-1.map", 4 ) );
    }
}