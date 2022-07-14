package com.heyrudy.karatebdddemo;

import com.heyrudy.karatebdddemo.app.core.abilities.fsstorage.IFileStore;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;

@SpringBootApplication
public class KarateBddDemoApplication implements CommandLineRunner {

    @Resource
    IFileStore iFileStore;

    public static void main(String[] args) {
        SpringApplication.run(KarateBddDemoApplication.class, args);
    }

    @Override
    public void run(String... args) {
        iFileStore.deleteAll();
        iFileStore.init();
    }
}
