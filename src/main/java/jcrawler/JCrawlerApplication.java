package jcrawler;

import jcrawler.service.Crawler;
import jcrawler.service.parser.domain.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class JCrawlerApplication implements CommandLineRunner {
    @Autowired
    Crawler crawler;

    public static void main(String[] args) {
        SpringApplication.run(JCrawlerApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        Set<Link> links = crawler.getLinks("http://riot.net.ua");
        for (Link l : links) {
            System.out.println(l);
        }
    }
}
