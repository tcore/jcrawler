package jcrawler.service.fetcher;

import java.net.URI;
import java.net.URISyntaxException;

public class FetcherRequest {
    private URI uri;

    private FetcherRequest() {

    }

    public FetcherRequest(URI uri) {
        this.uri = uri;
    }

    public FetcherRequest(String uriString) throws URISyntaxException {
        uri = new URI(uriString);
    }

    public URI getUri() {
        return uri;
    }

    public void setUri(URI uri) {
        this.uri = uri;
    }
}
