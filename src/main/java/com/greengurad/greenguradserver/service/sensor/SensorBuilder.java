package com.greengurad.greenguradserver.service.sensor;

public abstract class SensorBuilder {

  public static Sensor createSensor(String sensorType) {
    SensorType type = SensorType.castStringToSensorType(sensorType);

    switch (type) {
        case TEMPERATURE_SENSOR: { return new TemperatureSensor(type);}
        case HUMIDITY_SENSOR: { return null;}
        default: { return null; }
    } 
  } 
  
}
