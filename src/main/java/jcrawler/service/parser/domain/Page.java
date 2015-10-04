package jcrawler.service.parser.domain;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import java.io.IOException;
import java.net.URI;

public class Page {
    private Document document;

    public Page(String content, URI baseUrl) throws IOException {
        document = Jsoup.parse(content, baseUrl.toString());
    }

    public Document getDocument() {
        return document;
    }
}
