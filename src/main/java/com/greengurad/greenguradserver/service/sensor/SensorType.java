package com.greengurad.greenguradserver.service.sensor;

enum SensorType {
  TEMPERATURE_SENSOR("Temperature"), 
  HUMIDITY_SENSOR("Humidity"),
  UNDEFINE_SENSOR("Undefined");

  private final String type;

  SensorType(String type){
    this.type = type;
  }

  static SensorType castStringToSensorType(String type) {
      switch(type) {
        case "TEMP": { return TEMPERATURE_SENSOR; }
        case "HUM": { return HUMIDITY_SENSOR; }
        default: { return UNDEFINE_SENSOR; }
      }
  }

  String getStringType(){
    return type;
  }

}

