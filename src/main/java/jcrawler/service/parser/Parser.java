package jcrawler.service.parser;

import jcrawler.service.parser.domain.Link;
import jcrawler.service.parser.domain.Page;
import jcrawler.service.parser.exception.NotValidUriException;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

@Service
public class Parser {
    @Autowired
    public URIService uriService;

    public Set<Link> getLinks(Page page) {
        Elements links = page.getDocument().select("a[href]");
        Set<Link> list = new HashSet<>();
        for (Element e : links) {
            try {
                String href = e.attr("abs:href");
                Link link = new Link(e.text(), uriService.normalize(href));
                if (!list.contains(link)) {
                    list.add(link);
                }
            } catch (NotValidUriException |URISyntaxException ex) {
                System.err.println(ex.toString());
            }
        }

        return list;
    }
}
