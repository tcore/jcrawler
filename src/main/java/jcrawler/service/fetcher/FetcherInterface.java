package jcrawler.service.fetcher;


import java.io.IOException;
import java.net.URISyntaxException;

public interface FetcherInterface {
    public FetcherResponse fetch(FetcherRequest request) throws IOException, URISyntaxException;
}
