package com.dmetzler.hazelcast;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

@ApplicationPath("/")
public class WebStatusApp extends ResourceConfig {

    public class BindConfiguration extends AbstractBinder {

        @Override
        protected void configure() {
            bind(Hazelcast.newHazelcastInstance()).to(HazelcastInstance.class).in(Singleton.class);
        }

    }

    public WebStatusApp() {
        register(new BindConfiguration());
        packages("com.dmetzler.hazelcast.jaxrs");
    }

}
