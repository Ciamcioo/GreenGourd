package com.greengurad.greenguradserver.service.sensor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class SensorManagerImplementation implements SensorManager {

  private static final String EMPTY_SENSOR_LIST = "Sensor list is empty. Connect your sensors first!";
  private List<Sensor> managedSensors; 

  
  public SensorManagerImplementation() {
      this.managedSensors = new ArrayList<>();
  }
  
  @Override
  public boolean addSensor(Sensor sensor) {
    if (sensor != null  && sensor instanceof AbstractSensor && ((AbstractSensor) sensor).getType() instanceof SensorType) {
        managedSensors.add(sensor);
        return true;
    }
    return false;
  }

  @Override
  public String showCurrentReadings() {
      if (managedSensors.isEmpty())
        return EMPTY_SENSOR_LIST;

      StringBuilder allReadings = new StringBuilder();
      for (Sensor sensor : managedSensors) 
        allReadings.append(sensor.getReading());
     
      return allReadings.toString();
  }

  @Override
  public String showStatus() {
    if (managedSensors.isEmpty())
      return EMPTY_SENSOR_LIST;

    StringBuilder allStatus = new StringBuilder();
    for (Sensor sensor : managedSensors)
      allStatus.append(sensor.getStatusReading());

    return allStatus.toString();
  }

  @Override
  public String showSensorType() {
    if (managedSensors.isEmpty())
      return EMPTY_SENSOR_LIST;
    
    StringBuilder allTypes = new StringBuilder();
    for (Sensor sensor : managedSensors)
      allTypes.append(sensor.getTypeReading());

    return allTypes.toString();
  }


  
}
