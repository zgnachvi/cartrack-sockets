#Jetty WebSocket performance test
Goal –Explore jetty WebSocket implementation, monitor thread count and state during multiple, active, connection.

- Step 1 –create simple WebSocket server endpoint to handle connections.
- Step 2 –create WebSocket client endpoint to open multiple connection.
- Step 3 –open 500 and 1000 connection.

Test result:
Server threads after start
![image1](https://github.com/zgnachvi/cartrack-sockets/blob/master/1.png)


After 500 active connections
![image2](https://github.com/zgnachvi/cartrack-sockets/blob/master/1.png)

After 1000 active connections
![image3](https://github.com/zgnachvi/cartrack-sockets/blob/master/1.png)

Conclusion –Jetty WebSocket does not propagate threads per connection.
