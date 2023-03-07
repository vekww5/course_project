package ru.rgaru.consul;

import com.orbitz.consul.Consul;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class ConsulClient {
        @ConfigProperty(name = "consul.url")
        String consul_url;

        @Produces
        public Consul ConsulClientFunc(){
                // создается обьект клиент консула с указанным url
                return Consul.builder().withUrl(consul_url).build();
        }

}

