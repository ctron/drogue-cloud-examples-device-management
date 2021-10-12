package io.drogue.examples.devices.admin;

import java.security.Principal;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.drogue.examples.devices.admin.client.Registry;
import io.drogue.examples.devices.admin.data.Device;

@Path("/api/devices")
public class DevicesResources {

    private static final Logger log = LoggerFactory.getLogger(DevicesResources.class);

    @Inject
    @RestClient
    Registry registry;

    @GET
    @RolesAllowed("user")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Device> list(@Context final SecurityContext ctx) {
        final Principal caller = ctx.getUserPrincipal();
        final String name = caller == null ? "<anonymous>" : caller.getName();

        log.info("User: {}", name);

        final var result = new LinkedList<Device>();
        for (final var device : this.registry.listDevices("drogue-public-temperature", makeLabels(Map.of("user", name)), null, null)) {
            final var d = new Device();
            d.setId(device.getMetadata().getName());
            result.add(d);
        }

        return result;
    }

    private String makeLabels(final Map<String, String> user) {
        return user.entrySet().stream().map(e -> String.format("%s=%s", e.getKey(), e.getValue())).collect(Collectors.joining(","));
    }
}