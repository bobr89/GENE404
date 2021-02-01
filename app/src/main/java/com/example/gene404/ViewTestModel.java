package com.example.gene404;

public class ViewTestModel {
    String id;
    String response;
    String sensor1;
    String sensor2;

    public ViewTestModel(String id, String response, String sensor1, String sensor2){
        this.id = id;
        this.response = response;
        this.sensor1 = sensor1;
        this.sensor2 = sensor2;
    }

    public String getId(){
        return id;
    }

    public String getResponse(){
        return response;
    }

    public String getSensor1(){
        return sensor1;
    }

    public String getSensor2(){
        return sensor2;
    }
}
