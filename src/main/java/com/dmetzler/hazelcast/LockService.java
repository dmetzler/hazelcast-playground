package com.dmetzler.hazelcast;

import java.util.concurrent.locks.Lock;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.hazelcast.core.HazelcastInstance;

@Singleton
public class LockService {

    Lock appLock;

    @Inject
    public LockService(HazelcastInstance hz) {
        appLock = hz.getLock("counter");
    }

    public void lock() {
        appLock.lock();
    }

    public void unlock() {
        appLock.unlock();
    }
}
