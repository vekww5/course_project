package ru.rgaru.consul;

import com.orbitz.consul.Consul;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class ConsulClient {
        @Produces
        Consul consulClient = Consul.builder().build();
}

