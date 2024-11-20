package com.greengurad.greenguradserver.service.connection;

import static java.nio.charset.StandardCharsets.UTF_8;

import java.io.*;
import java.nio.channels.*;
import com.greengurad.greenguradserver.service.sensor.*;

public class ConnectionHandler implements Runnable {

  private BufferedReader channelReader;

  public ConnectionHandler(SocketChannel channel) {
    channelReader = new BufferedReader(Channels.newReader(channel, UTF_8));
  }

  @Override
  public void run() {
    String rawData;

    try {
        Sensor sensor = SensorBuilder.createSensor(channelReader.readLine()); 
        // Null is send when there is end of a stream. In case of socket it occurs when the socket closes. 
        while ((rawData = channelReader.readLine()) != null) {
            sensor.appendData(rawData);
      }
    } catch (IOException e) {
    }
  }

  
}
