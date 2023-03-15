package org.jboss.eap.demo;


import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Application;
import jakarta.ws.rs.core.Response;

@Path("/")
public class HelloEndpoint {



    @GET
    @Produces("text/plain")
    public Response doGet() {

        StringBuilder out = new StringBuilder("Hello from EAP!");

        return Response.ok(out).build();
    }

    @ApplicationPath("/")
    public static class RestApplication extends Application {
    }
}
