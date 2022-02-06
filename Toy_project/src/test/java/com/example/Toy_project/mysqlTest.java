package com.example.Toy_project;

import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class mysqlTest {

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/cmdb"; // jdbc:mysql://127.0.0.1:3306/여러분이 만드신 스키마이름
    private static final String USER = "root"; //DB 사용자명
    private static final String PW = "1234";   //DB 사용자 비밀번호

    @Test
    public void testConnection() throws Exception{
        Class.forName(DRIVER);

        try(Connection con = DriverManager.getConnection(URL, USER, PW)){
            PreparedStatement preparedStatement = con.prepareStatement("select * from environment_set");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2));
            }

            resultSet.close();
            preparedStatement.close();



            System.out.println("성공");
            System.out.println(con);

            con.close();
        }catch (Exception e) {
            System.out.println("에러발생");
            e.printStackTrace();
        }
    }

}