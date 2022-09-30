package dev.ifrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.smallrye.common.constraint.NotNull;


@Path("/api")
public class Resource {

    @Path("/lbtokg/{lb}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response lbtokg(@NotNull @PathParam("lb") Double lb) {
            if(lb == 0) {
                return Response.status(Status.BAD_GATEWAY).build();
            };  

            Double kg = lb/2.2046;
            String response = kg.toString();

            return Response.ok(response).build() ;
    }

    @Path("/kgtolb/{kg}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response kgtolb(@PathParam("kg") double kg) {
        Double lb = kg*2.2046;
        String response = lb.toString();
        return Response.ok(response).build();
    }
}