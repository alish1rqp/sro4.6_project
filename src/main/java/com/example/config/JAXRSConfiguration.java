package com.example.config;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/api")
public class JAXRSConfiguration extends Application {
    // This class is used to configure the base path for all JAX-RS resources
}
