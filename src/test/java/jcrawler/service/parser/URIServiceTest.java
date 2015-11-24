package jcrawler.service.parser;

import jcrawler.service.parser.exception.NotValidUriException;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import static org.junit.Assert.*;

public class URIServiceTest {
    private URIService uriService = new URIService();

    @Test(expected = NotValidUriException.class)
    public void testMailtoException() throws NotValidUriException, URISyntaxException {
        uriService.normalize("mailto:gmail@gmail.com");
    }

    @Test(expected = NotValidUriException.class)
    public void testEmptyException() throws NotValidUriException, URISyntaxException {
        uriService.normalize("");
    }

    @Test(expected = NotValidUriException.class)
    public void testHostIsNotNull() throws URISyntaxException, NotValidUriException {
        uriService.normalize(new URI("/test"));
    }

    @Test
    public void testSlashInTheEndWillBeRemoved() throws NotValidUriException, URISyntaxException {
        Arrays.asList("http://site.com", "http://site.com/test").forEach((String link) -> {
            try {
                assertEquals(link, uriService.normalize(link + "/").toString());
            } catch (URISyntaxException | NotValidUriException e) {
                e.printStackTrace();
            }
        });
    }
}
