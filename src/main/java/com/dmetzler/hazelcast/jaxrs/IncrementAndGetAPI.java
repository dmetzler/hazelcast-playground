package com.dmetzler.hazelcast.jaxrs;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dmetzler.hazelcast.FsIntegerIncrement;
import com.dmetzler.hazelcast.LockService;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class IncrementAndGetAPI {

    @Context
    LockService lock;

    @Context
    FsIntegerIncrement fs;

    @GET
    public Response doGet(@QueryParam("delay") String delayStr) throws IOException, InterruptedException {
//        lock.lock();
//        try {
            return Response.ok().entity(String.format("%s", fs.incrementAndGet())).build();
//        } catch (Exception e) {
//            return Response.serverError().entity(e.getMessage()).build();
//        } finally {
//            lock.unlock();
//        }
    }
}
