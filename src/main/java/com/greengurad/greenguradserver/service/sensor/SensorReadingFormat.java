package com.greengurad.greenguradserver.service.sensor;

enum SensorReadingFormat {
  READING_FORMAT("Sensor name: %s, current reading: %f"),
  TYPE_FORMAT("Sensor name: %s, type: %s"),
  STATUS_FORMAT("Sensor name: %s, is sensor active: %b");

  private final String format;


  SensorReadingFormat(String format) {
    this.format = format;
  } 

  String getFormat() {
    return format;
  }
}
