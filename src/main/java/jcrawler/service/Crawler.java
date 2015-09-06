package jcrawler.service;

import java.net.URI;
import java.net.URISyntaxException;

public class Crawler {
    public void parse(String url) throws URISyntaxException {
        parse(new URI(url));
    }

    public void parse(URI url) {

    }
}
