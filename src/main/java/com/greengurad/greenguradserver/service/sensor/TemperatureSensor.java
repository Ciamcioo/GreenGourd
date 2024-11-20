package com.greengurad.greenguradserver.service.sensor;


public class TemperatureSensor extends AbstractSensor {

  private double temperature;

  public TemperatureSensor(SensorType type) {
      super(type);
  }


  @Override
  public boolean appendData(String rawData) {
      double temperature = Double.MIN_VALUE;

      try {
        temperature = Double.parseDouble(rawData);        
        this.setTemperature(temperature); 
      } catch(NumberFormatException exception) {
        return false;
      }

      return true;
  }

  public void setTemperature(double temperature) {
     this.temperature = temperature; 
  }


  @Override
  public String getReading() {
      return String.format(SensorReadingFormat.READING_FORMAT.getFormat(),name, temperature);
  }

}
