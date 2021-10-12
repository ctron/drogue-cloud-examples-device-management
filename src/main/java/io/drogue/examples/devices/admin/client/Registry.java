package io.drogue.examples.devices.admin.client;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Path("/api/registry/v1alpha1")
@RegisterRestClient
@ClientHeaderParam(name = "Authorization", value = "{token}")
public interface Registry {

    Logger log = LoggerFactory.getLogger(Registry.class);

    default String token() {
        final String apiKey = ConfigProvider.getConfig().getValue("drogue.api.key", String.class);
        log.info("Token: {}", apiKey);
        return String.format("Bearer %s", apiKey);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    class Metadata {
        private String name;

        public String getName() {
            return this.name;
        }

        public void setName(final String name) {
            this.name = name;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    class Device {
        private Metadata metadata;

        public Metadata getMetadata() {
            return this.metadata;
        }

        public void setMetadata(final Metadata metadata) {
            this.metadata = metadata;
        }
    }

    @GET
    @Path("/apps/{application}/devices")
    @Produces(MediaType.APPLICATION_JSON)
    List<Device> listDevices(
            @PathParam("application") String application,
            @QueryParam("labels") String labels,
            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset
    );

}
