package com.smile.server;

import io.vertx.core.Vertx;

/**
 * @author Tom Smile
 * @version 1.0
 * @description: TODO
 * @date 2024/4/9 13:09
 */
public class VertxHttpServer implements HttpServer{


    @Override
    public void doStart(int port) {
        Vertx vertx = Vertx.vertx();
        io.vertx.core.http.HttpServer server= vertx.createHttpServer();
        server.requestHandler(new HttpServerHandler());
        server.listen(port, result -> {
            if (result.succeeded()) {
                System.out.println("Server is now listening on port" + port);

            } else {
                System.out.println("Failed to start server:" + result.cause());

            }
        });
    }
}
