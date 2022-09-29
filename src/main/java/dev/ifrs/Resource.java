package dev.ifrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/api")
public class Resource {

    @Path("/lbtokg/{lb}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public double lbtokg(@PathParam("lb") double lb) {

        return lb/2.2046;
    }

    @Path("/kgtolb/{kg}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public double kgtolb(@PathParam("kg") double kg) {

        return kg*2.2046;
    }
}