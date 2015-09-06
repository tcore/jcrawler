package jcrawler.service;

import jcrawler.service.fetcher.FetcherImpl;
import jcrawler.service.fetcher.FetcherRequest;
import jcrawler.service.fetcher.FetcherResponse;
import jcrawler.service.parser.Page;
import jcrawler.service.parser.Parser;
import jcrawler.service.parser.domain.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

@Service
public class Crawler {
    @Autowired
    FetcherImpl fetcher;

    @Autowired
    Parser parser;

    public void getLinks(String url) throws URISyntaxException, IOException {
        getLinks(new URI(url));
    }

    public void getLinks(URI uri) throws URISyntaxException, IOException {
        FetcherResponse response = fetcher.fetch(new FetcherRequest(uri));

        Page page = new Page(response.getContent(), uri);
        Set<Link> links = parser.getLinks(page);
        for (Link link : links) {
            System.out.println(link.getUri());
        }
    }
}
