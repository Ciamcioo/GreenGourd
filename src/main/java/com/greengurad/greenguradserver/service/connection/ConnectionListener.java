package com.greengurad.greenguradserver.service.connection;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.*;
import java.util.concurrent.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import jakarta.annotation.PostConstruct;

@Service
public class ConnectionListener implements Runnable {

  @Value("${communication.port}")
  private int portNumber;

  private ServerSocketChannel serverChannel;
  private final ExecutorService sensorHandlers = Executors.newCachedThreadPool();


  @PostConstruct
  private void initializeListening() {
    try {
      serverChannel = ServerSocketChannel.open();
      serverChannel.bind(new InetSocketAddress(portNumber));
      Thread serverThread = new Thread(this);
      serverThread.start();
    } catch(IOException exception) {
 
    }
  }

  public void run() {
    while (serverChannel.isOpen()) {
        try (SocketChannel sensorChannel = serverChannel.accept()) {
          sensorHandlers.submit(new ConnectionHandler(sensorChannel));
        } catch (IOException e) {
          e.printStackTrace();
        }

    }
  }

  
}
