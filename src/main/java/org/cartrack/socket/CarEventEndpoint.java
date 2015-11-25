package org.cartrack.socket;

import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;

import javax.websocket.server.ServerEndpoint;

/**
 * Created by Niko on 11/25/2015.
 */
@WebSocket
@ServerEndpoint(value="/events/")
public class CarEventEndpoint {

    @OnWebSocketConnect
    public void onConnect(Session session){
        System.out.println("Socket Connected: " + session);
    }

    @OnWebSocketMessage
    public void onWebSocketText(String message) {
        System.out.println("Received TEXT message: " + message);
    }

    @OnWebSocketClose
    public void onWebSocketClose(Session session, int status, String reason) {
        System.out.println("Socket Closed: " + reason);
    }

    @OnWebSocketError
    public void onWebSocketError(Throwable cause) {
        cause.printStackTrace(System.err);
    }
}
