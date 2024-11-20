package com.greengurad.greenguradserver.service.sensor;

public interface Sensor {

  String getReading(); 
  String getTypeReading();
  String getStatusReading();

  boolean appendData(String rawData);
  
}
