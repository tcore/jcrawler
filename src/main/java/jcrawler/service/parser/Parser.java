package jcrawler.service.parser;

import jcrawler.service.parser.domain.Link;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

public class Parser implements ParserInterface {
    private Document document;

    private Parser () {

    }

    public Parser(String content, URI baseUrl) throws IOException {
        document = Jsoup.parse(content, baseUrl.toString());
    }

    public Set<Link> getLinks() {
        Elements links = document.select("a[href]");
        Set<Link> list = new HashSet<>();
        for (Element e : links) {
            Link link = null;
            try {
                link = new Link(e.text(), e.attr("abs:href"));
                if (!list.contains(link)) {
                    list.add(link);
                }
            } catch (URISyntaxException e1) {
                // TODO: save to logs
                e1.printStackTrace();
            }
        }

        return list;
    }
}
