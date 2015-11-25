package org.cartrack.socket;

import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;
import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Niko on 11/25/2015.
 */

public class CarEventClientTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(8);
        String dest = "ws://localhost:8080/events";
        for (int i = 0; i < 1000; i++) {
            executorService.submit(()->{
                try {
                    CarEventClientEndpoint socket = new CarEventClientEndpoint();
                    WebSocketContainer container = ContainerProvider.getWebSocketContainer();
                    container.connectToServer(socket, new URI(dest));
                    socket.getLatch().await();
                    socket.sendMessage("getLocation");
                    socket.sendMessage("getLocation");
                } catch (Throwable t) {
                    t.printStackTrace();
                }
            });
        }
    }
}
