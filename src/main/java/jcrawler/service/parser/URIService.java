package jcrawler.service.parser;

import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.URISyntaxException;

@Service
public class URIService {
    public URI normalize(String uri) throws URISyntaxException {
        return normalize(new URI(uri));
    }

    public URI normalize(URI uri) throws URISyntaxException {
        URI normal = uri.normalize();
        final String path = normal.getPath().replace("/$", "");

        return new URI(normal.getScheme(), normal.getHost(), path, normal.getQuery());
    }
}
