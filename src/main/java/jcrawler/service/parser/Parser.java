package jcrawler.service.parser;

import jcrawler.service.parser.domain.Link;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.net.URISyntaxException;
import java.util.HashSet;
import java.util.Set;

@Service
public class Parser implements ParserInterface {
    @Autowired
    public URIService uriService;

    public Set<Link> getLinks(Page page) {
        Elements links = page.getDocument().select("a[href]");
        Set<Link> list = new HashSet<>();
        for (Element e : links) {
            try {
                Link link = new Link(e.text(), uriService.normalize(e.attr("abs:href")));
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
