package com.greengurad.greenguradserver.controller;

import com.greengurad.greenguradserver.service.sensor.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sensors")
public class SensorController {

  private SensorManagerImplementation sensorsManager; 
  
  public SensorController(SensorManagerImplementation sensorsManager) {
    this.sensorsManager = sensorsManager;
  }


  @GetMapping("/readings")
  public String getReadings() {
    return sensorsManager.showCurrentReadings();
  }
 
 
}
