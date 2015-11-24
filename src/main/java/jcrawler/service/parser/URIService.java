package jcrawler.service.parser;

import jcrawler.service.parser.exception.NotValidUriException;
import org.springframework.stereotype.Service;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

@Service
public class URIService {
    public URI normalize(String uri) throws URISyntaxException, NotValidUriException {
        return normalize(new URI(uri));
    }

    public URI normalize(URI uri) throws URISyntaxException, NotValidUriException {
        if ("".equals(uri.toString()) || uri.getHost() == null) {
            throw new NotValidUriException(uri);
        }
        URI normal = uri.normalize();
        if ("mailto".equals(normal.getScheme())) {
            throw new NotValidUriException(uri);
        }
        String path = normal.getPath();
        if (path.length() > 0 && path.substring(path.length() - 1, path.length()).equals("/")) {
            path = path.substring(0, path.length() - 1);
        }

        return new URI(normal.getScheme(), normal.getHost(), path, normal.getQuery());
    }
}
