package ru.rgaru.consul;

import com.orbitz.consul.Consul;
import com.orbitz.consul.HealthClient;
import com.orbitz.consul.model.agent.ImmutableRegistration;
import com.orbitz.consul.model.health.ServiceHealth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.List;


public class ConsulLifecycle {
    private static final Logger LOGGER = LoggerFactory.getLogger(ConsulLifecycle.class);

    private static String instanceId;

    @Inject
    Consul consulClient;
    @ConfigProperty(name = "quarkus.application.name")
    String appName;
    @ConfigProperty(name = "quarkus.application.version")
    String appVersion;
    @ConfigProperty(name = "quarkus.http.port")
    int port;
    @ConfigProperty(name = "app.host_url")
    String host_url;

    void onStart(@Observes StartupEvent ev) {
            HealthClient healthClient = consulClient.healthClient();
            List<ServiceHealth> instances = healthClient.getHealthyServiceInstances(appName).getResponse();
            instanceId = appName + "-" + instances.size();
            System.out.println(instanceId);
            ImmutableRegistration registration = ImmutableRegistration.builder()
                    .id(instanceId)
                    .name(appName)
                    .address(host_url)
                    .port(port)
                    .putMeta("version", appVersion)
                    .build();

            consulClient.agentClient().register(registration);
            LOGGER.info("Instance registered: id={}, address={}:{}", registration.getId(),host_url, port);
    }

    void onStop(@Observes ShutdownEvent ev) {
        consulClient.agentClient().deregister(instanceId);

        LOGGER.info("Instance de-registered: id={}", instanceId);
    }
}
