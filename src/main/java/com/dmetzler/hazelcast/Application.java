package com.dmetzler.hazelcast;

import java.nio.file.Path;
import java.nio.file.Paths;

import javax.inject.Singleton;
import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.internal.inject.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

@ApplicationPath("/")
public class Application extends ResourceConfig {

    public class BindConfiguration extends AbstractBinder {

        @Override
        protected void configure() {
            bind(Paths.get("/tmp/counter")).named("counterPath").to(Path.class);
            bind(FsIntegerIncrement.class).to(FsIntegerIncrement.class).in(Singleton.class);
            bind(Hazelcast.newHazelcastInstance()).to(HazelcastInstance.class).in(Singleton.class);
            bind(LockService.class).to(LockService.class).in(Singleton.class);
        }

    }

    public Application() {
        register(new BindConfiguration());
        packages("com.dmetzler.hazelcast.jaxrs");
    }

}
