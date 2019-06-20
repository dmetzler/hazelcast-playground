package com.dmetzler.hazelcast.jaxrs;

import java.util.stream.Collectors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.hazelcast.core.HazelcastInstance;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class Status {

    @Context
    HazelcastInstance hz;

    @GET
    public Response doGet() {
        final StringBuilder sb = new StringBuilder("[");
        sb.append(hz.getCluster().getMembers().stream().map(m -> String.format("\"%s\"", m.toString())).collect(
                Collectors.joining(",")));
        sb.append("]");
        return Response.ok().entity(sb.toString()).build();
    }
}
