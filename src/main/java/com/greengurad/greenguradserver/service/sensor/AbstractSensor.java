package com.greengurad.greenguradserver.service.sensor;

public abstract class AbstractSensor implements Sensor {

  protected String name;
  protected SensorType type;
  protected boolean status;

  public AbstractSensor(SensorType type) {

  }

  public abstract String getReading();  


  public String getTypeReading() {
      return String.format(SensorReadingFormat.TYPE_FORMAT.getFormat(), name, type.getStringType()).toString();
  }

  public String getStatusReading() {
      return String.format(SensorReadingFormat.STATUS_FORMAT.getFormat(), name, status);
  }

  public SensorType getType() {
    return type;
  }
}
