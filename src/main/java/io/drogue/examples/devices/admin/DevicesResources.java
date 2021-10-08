package io.drogue.examples.devices.admin;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import io.drogue.examples.devices.admin.data.Device;

@Path("/devices")
public class DevicesResources {

    @GET
    //@RolesAllowed({})
    @PermitAll
    @Produces(MediaType.APPLICATION_JSON)
    public List<Device> list(@Context SecurityContext ctx) {
        Principal caller =  ctx.getUserPrincipal();
        String name = caller == null ? "<anonymous>" : caller.getName();
        var device = new Device();
        device.setId("abc");
        return List.of(device);
    }
}