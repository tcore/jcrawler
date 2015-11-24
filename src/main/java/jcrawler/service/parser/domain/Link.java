package jcrawler.service.parser.domain;

import lombok.Getter;

import java.net.URI;

public class Link {
    @Getter
    private String text;

    @Getter
    private URI uri;

    public Link(String text, URI uri) {
        this.text = text;
        this.uri = uri;
    }

    public String toString() {
        return uri.toString();
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
