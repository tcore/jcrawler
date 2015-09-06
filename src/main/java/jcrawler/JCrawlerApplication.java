package jcrawler;

import jcrawler.service.Crawler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JCrawlerApplication implements CommandLineRunner {
    @Autowired
    Crawler crawler;

    public static void main(String[] args) {
        SpringApplication.run(JCrawlerApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        crawler.getLinks("http://riot.net.ua");
    }
}
