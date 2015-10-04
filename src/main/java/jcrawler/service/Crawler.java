package jcrawler.service;

import jcrawler.service.fetcher.FetcherImpl;
import jcrawler.service.fetcher.FetcherRequest;
import jcrawler.service.fetcher.FetcherResponse;
import jcrawler.service.parser.Parser;
import jcrawler.service.parser.domain.Link;
import jcrawler.service.parser.domain.Page;
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

    public Set<Link> getLinks(jcrawler.domain.Page page) throws IOException, URISyntaxException {
        return getLinks(page.toString());
    }

    public Set<Link> getLinks(String url) throws URISyntaxException, IOException {
        return getLinks(new URI(url));
    }

    public Set<Link> getLinks(URI uri) throws URISyntaxException, IOException {
        FetcherResponse response = fetcher.fetch(new FetcherRequest(uri));
        Page page = new Page(response.getContent(), uri);

        return parser.getLinks(page);
    }
}
