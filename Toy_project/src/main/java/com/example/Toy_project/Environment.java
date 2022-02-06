package com.example.Toy_project;

public class Environment {

    String time;
    int Humidity;
    int Temperature;
    int illuminace;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getHumidity() {
        return Humidity;
    }

    public void setHumidity(int humidity) {
        Humidity = humidity;
    }

    public int getTemperature() {
        return Temperature;
    }

    public void setTemperature(int temperature) {
        Temperature = temperature;
    }

    public int getIlluminace() {
        return illuminace;
    }

    public void setIlluminace(int illuminace) {
        this.illuminace = illuminace;
    }
}
