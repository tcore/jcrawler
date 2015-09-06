package jcrawler.service.parser.domain;

import java.net.URI;
import java.net.URISyntaxException;

public class Link {
    private String text;

    private URI uri;

    public Link(String text, URI uri) {
        this.text = text;
        this.uri = uri;
    }

    public Link(String text, String uri) throws URISyntaxException {
        this.text = text;
        this.uri = new URI(uri);
    }

    public String getText() {
        return text;
    }

    public URI getUri() {
        return uri;
    }

    public int hashCode() {
        return uri.hashCode();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Link)) {
            return false;
        }
        if (obj == this) {
            return  true;
        }

        return ((Link) obj).getUri().equals(uri);
    }
}
