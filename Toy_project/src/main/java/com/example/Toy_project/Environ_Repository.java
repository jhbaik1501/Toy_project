package com.example.Toy_project;

public interface Environ_Repository {

    Environment getNowEnvironment();
    boolean saveEnvironment(Environment environment);

}
