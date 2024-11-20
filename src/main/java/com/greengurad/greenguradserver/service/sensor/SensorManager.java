package com.greengurad.greenguradserver.service.sensor;


public interface SensorManager {
  boolean addSensor(Sensor sensor);
  String showCurrentReadings();
  String showStatus(); 
  String showSensorType();
  // List<Sensor> getConnectedSensorList();

  
}
