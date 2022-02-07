package com.example.Toy_project;


import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

//@Repository
public class EnvironRepositoryImp implements Environ_Repository{

    @Override
    public Environment getNowEnvironment() {

        Environment environment = new Environment();
        try {
            environment = setDB.getInfo();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return environment;
    }

    @Override
    public boolean saveEnvironment(OpenClientSocket openClientSocket) {
        Environment environment = new Environment();
        environment.setTime("0533");
        environment.setTemperature(25);
        environment.setHumidity(55);
        environment.setIlluminace(60);
        try {
            setDB.setInfo(environment);
            System.out.println("데이터 넣기 성공!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public static class setDB {
        private static final String DRIVER = "com.mysql.jdbc.Driver";
        private static final String URL = "jdbc:mysql://127.0.0.1:3306/cmdb"; // jdbc:mysql://127.0.0.1:3306/여러분이 만드신 스키마이름
        private static final String USER = "root"; //DB 사용자명
        private static final String PW = "1234";   //DB 사용자 비밀번호

        public static Environment getInfo() throws Exception{
            Class.forName(DRIVER);

            try(Connection con = DriverManager.getConnection(URL, USER, PW)){
                PreparedStatement preparedStatement = con.prepareStatement("select SEQUENCE from environment_set order by SEQUENCE desc limit 1");
                ResultSet resultSet = preparedStatement.executeQuery();

                Environment environment = new Environment();

                environment.setHumidity(resultSet.getInt(4));
                environment.setIlluminace(resultSet.getInt(5));
                environment.setTemperature(resultSet.getInt(3));
                environment.setTime(resultSet.getString(2));
                System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2));


                resultSet.close();
                preparedStatement.close();
                System.out.println("성공");
                System.out.println(con);

                con.close();
                return environment;
            }catch (Exception e) {
                System.out.println("에러발생");
                e.printStackTrace();
            }
            return null;
        }



        public static void setInfo(Environment environment) throws Exception{


            try(Connection con = DriverManager.getConnection(URL, USER, PW)){

                PreparedStatement preparedStatement = con.prepareStatement("insert into environment_set " +
                        "(time, temperature, humidity, light)"+
                        "value (" + environment.getTime() +", " + environment.getTemperature() + ", " +
                        environment.getHumidity() + ", " + environment.getIlluminace() + ");"
                );
                preparedStatement.executeUpdate();

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



}

