package me.kiryakov.popeengooi;

import me.kiryakov.popeengooi.domain.Site;
import me.kiryakov.popeengooi.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PopeengooiApplication implements CommandLineRunner {

    @Autowired
    private SiteService siteService;

    public static void main(String[] args) {
        SpringApplication.run(PopeengooiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
