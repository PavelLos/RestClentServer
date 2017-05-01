package com.pavel.server;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class ServerApp extends ResourceConfig {
    public ServerApp() {
        packages("com/pavel/client/service");
    }
}