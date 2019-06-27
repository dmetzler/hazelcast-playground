package com.dmetzler.hazelcast;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.inject.Inject;
import javax.inject.Named;

public class FsIntegerIncrement {

    private Path path;

    private LockService lock;

    @Inject
    public FsIntegerIncrement(@Named("counterPath") Path path, LockService lock) {
        this.path = path;
        this.lock = lock;
    }

    public synchronized int incrementAndGet() throws IOException, InterruptedException {

        lock.lock();
        try {
            int counter = 0;
            if (Files.exists(path)) {
                counter = Integer.parseInt(Files.lines(path, StandardCharsets.UTF_8).findFirst().get()) + 1;
                Thread.sleep(100);
                Files.delete(path);
            }

            Files.write(path, String.format("%s\n", counter).getBytes());
            return counter;
        } finally {
            lock.unlock();
        }
    }
}
