package jcrawler;

import jcrawler.service.fetcher.FetcherImpl;
import jcrawler.service.fetcher.FetcherRequest;
import jcrawler.service.fetcher.FetcherResponse;
import jcrawler.service.parser.Parser;
import jcrawler.service.parser.domain.Link;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.util.Set;

@SpringBootApplication
public class JCrawlerApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JCrawlerApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        FetcherImpl fetcher = new FetcherImpl();
        URI uri = new URI("http://riot.net.ua/");
        FetcherResponse response = fetcher.fetch(new FetcherRequest(uri));

        Parser parser = new Parser(response.getContent(), uri);
        Set<Link> links = parser.getLinks();
        for (Link link : links) {
            System.out.println(link.getUri());
        }
    }
}
